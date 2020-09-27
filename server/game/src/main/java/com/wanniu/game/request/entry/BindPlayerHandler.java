package com.wanniu.game.request.entry;

import cn.qeng.common.login.TokenInfo;
import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.GGame;
import com.wanniu.core.GGlobal;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloHeader;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.area.Area;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.MessagePush;
import com.wanniu.game.data.base.MapBase;
import com.wanniu.game.petNew.PetManager;
import com.wanniu.game.player.BILogService;
import com.wanniu.game.player.PlayerDao;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.player.bi.LogReportService;
import com.wanniu.game.player.po.AllBlobPO;
import io.netty.channel.Channel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pomelo.Common;
import pomelo.area.PlayerHandler;
import pomelo.connector.EntryHandler;
import pomelo.item.ItemOuterClass;
import pomelo.player.PlayerOuterClass;


@GClientEvent("connector.entryHandler.bindPlayerRequest")
public class BindPlayerHandler
        extends PomeloRequest {
    public void execute(Packet pak) {
        this.watcher.begin(pak.getHeader().getLength());
        this.pak = pak;
        PomeloResponse res = null;
        try {
            res = request();
        } catch (Exception e) {
            res = GGame.getInstance().getErrResponse(e);
        }
        if (res != null) {
            PomeloHeader header = res.getHeader();
            header.setType(pak.getHeader().getType());
            this.watcher.end(res.getContent().readableBytes());
            write((Message) res);
            if (this.tmpPlayer != null && this.tmpArea != null) {
                this.tmpPlayer.setState((byte) 1);
            }
        } else {
            this.watcher.end(0);
        }
    }

    private WNPlayer tmpPlayer = null;
    private Area tmpArea = null;

    public PomeloResponse request() throws Exception {
        EntryHandler.BindPlayerRequest req = EntryHandler.BindPlayerRequest.parseFrom(this.pak.getRemaingBytes());
        final String uid = this.pak.getUid();
        final String playerId = req.getC2SPlayerId();

        return new PomeloResponse() {
            protected void write() throws IOException {
                EntryHandler.BindPlayerResponse.Builder res = EntryHandler.BindPlayerResponse.newBuilder();

                if (StringUtil.isEmpty(uid)) {
                    Out.warn(new Object[]{BindPlayerHandler.access$000(this.this$0).getIp(), " bindPlayerRequest session uid null!"});
                    res.setS2CCode(400);
                    res.setS2CMsg(LangService.getValue("VERIFY_FAIL"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                if (StringUtil.isEmpty(playerId)) {
                    Out.warn(new Object[]{"bindPlayerRequest msg playerId null!"});
                    res.setS2CCode(400);
                    res.setS2CMsg(LangService.getValue("PLAYER_ID_NULL"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                try {
                    WNPlayer player = PlayerUtil.getOnlinePlayerByUid(uid);

                    if (player != null) {
                        player.setLogoutTime(new Date());
                        Channel session = player.getSession();
                        if (session != BindPlayerHandler.this.pak.getSession() && session.isActive()) {

                            PlayerHandler.KickPlayerPush.Builder builder = PlayerHandler.KickPlayerPush.newBuilder();
                            builder.setS2CReasonType(Const.KickReason.NEW_LOGIN.value);
                            session.write((new MessagePush("area.playerPush.kickPlayerPush", (GeneratedMessage) builder.build())).getContent()).await(2000L);
                            session.close();
                        }
                    }
                    if (player == null || !player.getId().equals(playerId)) {
                        if (player != null) {
                            player.doLogout(true);
                        }


                        AllBlobPO allBlobData = PlayerDao.getAllBlobData(playerId);
                        if (allBlobData.player == null) {
                            res.setS2CCode(500);
                            res.setS2CMsg(LangService.getValue("PLAYER_ID_NULL"));
                            this.body.writeBytes(res.build().toByteArray());

                            return;
                        }

                        player = new WNPlayer(allBlobData);
                    }

                    Date freezeTime = (player.getPlayer()).freezeTime;
                    if (freezeTime != null && freezeTime.getTime() > System.currentTimeMillis()) {
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("ROLE_LOCKED") + "：" + player.player.freezeReason);
                        this.body.writeBytes(res.build().toByteArray());

                        return;
                    }

                    player.bind(BindPlayerHandler.this.pak.getSession());

                    long beginTime = System.currentTimeMillis();

                    TokenInfo token = (TokenInfo) BindPlayerHandler.this.pak.getAttr(GGlobal.__KEY_TOKEN_INFO);
                    if (token != null) {
                        (player.getPlayer()).channel = token.getChannel();
                        (player.getPlayer()).subchannel = token.getSubchannel();
                        (player.getPlayer()).subchannelUID = token.getSubchannelUid();
                        (player.getPlayer()).mac = token.getMac();
                        (player.getPlayer()).os = token.getOs();
                        (player.getPlayer()).ip = BindPlayerHandler.this.pak.getIp();
                    }

                    Out.info(new Object[]{"角色进入游戏 uid=", player.getUid(), ",playerId=", player.getId(), ",name=", player.getName(), ",IP=", (player.getPlayer()).ip});
                    LogReportService.getInstance().ansycReportLogin(player.getPlayer());
                    BILogService.getInstance().ansycReportPlayerData(player.getSession(), player.getPlayer(), false);

                    PlayerOuterClass.Player.Builder data = BindPlayerHandler.this.bindLoadData(player);


                    player.setState((byte) 0);
                    Area area = AreaUtil.dispatch(player);
                    MapBase sceneProp = area.prop;
                    data.setAreaId(sceneProp.templateID);
                    data.setInstanceId(area.instanceId);
                    data.setMapId(area.areaId);


                    res.setS2CCode(200);
                    res.setS2CPlayer(data);
                    res.setS2CSceneType(sceneProp.type);
                    res.setS2CSceneUseAgent(sceneProp.useAgent);
                    res.setS2CChangePkType(sceneProp.changePKtype);
                    res.setS2CRideMount(sceneProp.rideMount);

                    this.body.writeBytes(res.build().toByteArray());

                    WNPlayer login_player = player;
                    GWorld.getInstance().ansycExec(() -> {
                        login_player.onLogin();

                        area.onPlayerLogin(login_player);
                    });
                    Out.debug(new Object[]{player.getName(), " enter game use : ", Long.valueOf(System.currentTimeMillis() - beginTime)});
                    BindPlayerHandler.this.tmpPlayer = player;
                    BindPlayerHandler.this.tmpArea = area;
                } catch (Exception e) {
                    Out.error(new Object[]{e});
                } finally {
                    LoginQueue.removeBindQueue(BindPlayerHandler.this.pak.getSession());
                }
            }
        };
    }


    public PlayerOuterClass.Player.Builder bindLoadData(WNPlayer player) {
        PlayerOuterClass.Player.Builder data = PlayerOuterClass.Player.newBuilder();
        data.setId(player.getId());
        data.setUid(player.getUid());
        data.setName(player.getName());
        data.setLevel(player.player.level);
        data.setExp(player.player.exp);
        data.setPro(player.player.pro);
        data.setUpOrder(player.player.upOrder);
        data.setClassExp(player.player.classExp);
        data.setPrestige(player.player.prestige);
        data.setJuewei(0);
        data.setGold(player.player.gold);
        data.setTicket(player.player.ticket);
        data.setDiamond(player.player.diamond);
        data.setFriendly(player.player.friendly);
        data.setConsumePoint(player.moneyManager.getConsumePoint());
        data.setVip(player.baseDataManager.getVip());
        data.setHp(player.playerTempData.hp);
        data.setMp(player.playerTempData.mp);
        data.setNeedExp(player.player.needExp);
        data.setFightPower(player.player.fightPower);
        data.setUpLevel(player.player.upLevel);
        data.setReqLevel(0);
        PlayerOuterClass.Stores.Builder store = PlayerOuterClass.Stores.newBuilder();
        store.setBag(player.bag.toJson4Payload());
        store.setWareHouse(player.wareHouse.toJson4Payload());
        store.setRecycle(player.recycle.toJson4Payload());
        data.setStore(store);
        data.setEquipments(player.equipManager.toJson4Payload());
        data.addAllFashionInfo(player.fashionManager.toJson4Fashion());
        data.addAllStrengthPos(player.equipManager.toJson4StrengthPos());
        data.setTasks(player.taskManager.toJson4Payload());
        data.setSetData(player.sysSetManager.toJson4Payload());

        data.setHookSetData(player.hookSetManager.toJson4Payload());
        data.addAllSkillKeys(player.skillKeyManager.toJson4Payload());
        data.setCountItems(ItemOuterClass.CountItems.newBuilder());
        data.setPawnGold(player.player.pawnGold);
        data.setGuildpoint(player.player.guildpoint);
        data.setTreasurePoint(player.player.treasurePoint);
        data.setZoneId(String.valueOf(player.getLogicServerId()));
        data.setPetPkModel(PetManager.getPkModel());
        data.addAllFunctionList(player.functionOpenManager.toJson4PayLoad());

        List<Common.KeyValueStruct> ccs = new ArrayList<>();
        if (player.playerAttachPO.config != null) {
            for (String key : player.playerAttachPO.config.keySet()) {
                Common.KeyValueStruct.Builder cc = Common.KeyValueStruct.newBuilder();
                cc.setKey(key);
                cc.setValue((String) player.playerAttachPO.config.get(key));
                ccs.add(cc.build());
            }
        }
        data.addAllClientConfig(ccs);
        data.setFightingPetId(player.petNewManager.getFightingPetId());
        data.setOpenMount(player.player.openMount ? 1 : 0);
        data.setSolopoint(player.soloManager.getSolopoint());
        data.setPayGiftData(player.prepaidManager.getFirstPayStatus());
        return data;
    }

    public short getType() {
        return 258;
    }
}


