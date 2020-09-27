package com.wanniu.game.player;

import com.alibaba.fastjson.JSON;
import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.LangService;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.proxy.ProxyClient;
import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.csharp.CSharpClient;
import com.wanniu.csharp.CSharpNode;
import com.wanniu.game.GWorld;
import com.wanniu.game.area.Area;
import com.wanniu.game.area.AreaData;
import com.wanniu.game.area.AreaEvent;
import com.wanniu.game.area.AreaManager;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.area.ProxyArea;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.Utils;
import com.wanniu.game.data.base.DItemEquipBase;
import com.wanniu.game.item.ItemConfig;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.item.po.PlayerItemPO;
import com.wanniu.game.petNew.PetNew;
import com.wanniu.game.poes.XianYuanPO;
import com.wanniu.game.task.TaskEvent;
import com.wanniu.game.team.TeamData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pomelo.area.FightLevelHandler;
import pomelo.area.TeamHandler;


public final class ProxyUtil {
    public static void onAcrossPlayerEvent(Packet pak) {
        String playerId = pak.getString();
        WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
        int type = pak.getByte();
        Out.debug(new Object[]{playerId, " player proxy event -> ", Integer.valueOf(type)});
        if (player != null) {
            int fromDes;
            int unitTemplateId;
            PetNew pet;
            Area area;
            String str;
            PlayerItemPO item;
            PlayerItemPO playerItem;
            DItemEquipBase prop;
            DItemEquipBase dItemEquipBase1;
            switch (type) {
                case 1:
                    player.onEvent(new TaskEvent(pak.getInt(), pak.getString()));
                    break;

                case 2:
                    fromDes = pak.getInt();
                    str = pak.getString();
                    playerItem = (PlayerItemPO) Utils.deserialize(str, PlayerItemPO.class);
                    dItemEquipBase1 = ItemConfig.getInstance().getItemProp(playerItem.code);
                    player.bag.addEntityItem(new NormalItem(playerItem, dItemEquipBase1), Const.GOODS_CHANGE_TYPE.getE(fromDes));
                    break;

                case 3:
                    unitTemplateId = pak.getInt();
                    AreaEvent.onTaskEvent(playerId, unitTemplateId);
                    break;

                case 4:
                    player.illusionManager.addAward(pak.getString(), pak.getInt());
                    break;

                case 5:
                    pet = player.getFightingPet();
                    if (pet != null) {
                        pet.addExp(pak.getInt(), true);
                    }
                    break;

                case 6:
                    player.playerAttachPO.addFirstMonsterId(pak.getInt());
                    break;

                case 7:
                    player.finishFightLevel(pak.getInt(), pak.getInt());
                    break;

                case 8:
                    player.achievementManager.onPassedDungeon(pak.getInt());
                    break;

                case 9:
                    player.dailyActivityMgr.onEvent(Const.DailyType.valueOf(pak.getString()), pak.getString(), pak.getInt());
                    break;

                case 10:
                    onAcrossEnterConfirm(player, pak);
                    break;

                case 11:
                    onAcrossEnterReply(player, pak);
                    break;

                case 12:
                    player.moneyManager.addXianYuan(pak.getInt(), pak.getInt());
                    break;

                case 13:
                    area = player.getArea();
                    if (!(area instanceof ProxyArea))
                        return;
                    item = (PlayerItemPO) Utils.deserialize(pak.getString(), PlayerItemPO.class);
                    prop = ItemConfig.getInstance().getItemProp(item.code);
                    area.onFreedomPickItem(player, new NormalItem(item, prop), pak.getBoolean());
                    break;

                case 14:
                    player.bag.addCodeItemMail(pak.getString(), pak.getInt(), Const.ForceType.getE(pak.getInt()), Const.GOODS_CHANGE_TYPE.getE(pak.getInt()), pak.getString());
                    break;
            }
        }
    }


    private static void onAcrossEnterConfirm(WNPlayer player, Packet pak) {
        int targetId = pak.getInt();
        int difficulty = pak.getByte();
        String leaderId = pak.getString();

        int count = pak.getByte();
        List<FightLevelHandler.MemberData> memberData = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            FightLevelHandler.MemberData.Builder md = FightLevelHandler.MemberData.newBuilder();
            md.setId(pak.getString());
            md.setName(pak.getString());
            md.setPro(pak.getByte());
            md.setLevel(pak.getShort());
            memberData.add(md.build());
        }

        int overTime = GlobalConfig.TeamGoMapLeftTime;


        FightLevelHandler.OnConfirmEnterFubenPush enterFuben = FightLevelHandler.OnConfirmEnterFubenPush.newBuilder().setS2CMsg(LangService.getValue("CONFIRM_ENTRY")).setS2CFubenId(TeamData.getTargetMap(targetId, difficulty)).setS2COverTime(overTime).setS2CLeaderId((leaderId == null) ? "" : leaderId).addAllS2CMemberData(memberData).build();

        player.receive("area.fightLevelPush.onConfirmEnterFubenPush", (GeneratedMessage) enterFuben);
    }

    private static void onAcrossEnterReply(WNPlayer player, Packet pak) {
        FightLevelHandler.OnMemberEnterFubenStateChangePush msgData = FightLevelHandler.OnMemberEnterFubenStateChangePush.newBuilder().setS2CPlayerId(pak.getString()).setS2CIsReady(pak.getByte()).build();
        player.receive("area.fightLevelPush.onMemberEnterFubenStateChangePush", (GeneratedMessage) msgData);
    }

    public static void onAcrossChangeArea(Packet pak) {
        String node = pak.getString();
        CSharpNode csNode = (CSharpNode) JSON.parseObject(node, CSharpNode.class);
        final String playerId = pak.getString();
        final WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
        int areaId = pak.getInt();
        String instanceId = pak.getString();
        if (player == null) {
            Out.warn(new Object[]{"proxy receive change area:", Integer.valueOf(areaId), " isntanceId:", instanceId});
            return;
        }
        ProxyClient.getInstance().add(new Message() {
            protected void write() throws IOException {
                this.body.writeString(playerId);
                this.body.writeBoolean(player.isRobot());
                this.body.writeFloat(player.vipManager.getVipExpRatio());
                this.body.writeInt(player.getGuildExdExp());
                this.body.writeInt(player.getGuildExdGold());
                this.body.writeInt(player.getBtlExdGold());
                PetNew petnew = player.petNewManager.getFightingPet();
                this.body.writeString((petnew == null) ? "" : Utils.serialize(petnew.po));
                this.body.writeString(Utils.serialize(player.illusionManager.illusionPO));
                this.body.writeString(Utils.serialize(player.vipManager.po));
                XianYuanPO xianYuan = player.allBlobData.xianYuan;
                this.body.writeString((xianYuan == null) ? "" : Utils.serialize(xianYuan));
                List<Integer> firstKillMonsterIds = player.playerAttachPO.firstKillMonsterIds;
                this.body.writeShort(firstKillMonsterIds.size());
                for (Integer id : firstKillMonsterIds) {
                    this.body.writeInt(id.intValue());
                }
            }


            public short getType() {
                return 1025;
            }
        });
        Out.info(new Object[]{node, " areaId:", Integer.valueOf(areaId), " isntanceId:", instanceId});
        CSharpClient.getInstance().connect(csNode, () -> {
            if (AreaUtil.getArea(instanceId) == null) {
                ProxyArea area = new ProxyArea(Utils.toJSON(new Object[]{"areaId", Integer.valueOf(areaId), "instanceId", instanceId}));
                area.setBattleServerId(csNode.getNodeId());
                AreaManager.ProxyServerAreas.put(instanceId, area);
            }
            AreaData areaData = new AreaData(areaId, instanceId);
            AreaUtil.changeArea(player, areaData);
        });
    }

    public static void onAcrossTeamEvent(Packet packet) {
        int second;
        WNProxy proxy;
        int count;
        TeamHandler.OnAcrossTeamInfoPush.Builder push;
        int i, secType = packet.getByte();
        if (secType == 2) {
            createInstance(packet);
            return;
        }
        String playerId = packet.getString();
        WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
        if (player == null) {
            Out.warn(new Object[]{"proxy client quit : ", playerId});
            return;
        }
        switch (secType) {
            case 1:
                second = packet.getShort();
                count = packet.getByte();
                Out.debug(new Object[]{"across team info sceond ", Integer.valueOf(second), " count ", Integer.valueOf(count)});
                push = TeamHandler.OnAcrossTeamInfoPush.newBuilder().setTargetId(player.teamManager.acrossTargetId).setDifficulty(player.teamManager.acrossDifficulty);
                push.setSecond(second);
                push.addPlayers(TeamHandler.AcrossPlayer.newBuilder().setName(player.getName()).setLevel(player.getLevel()).setPro(player.getPro()));
                for (i = 1; i < count; i++) {
                    push.addPlayers(TeamHandler.AcrossPlayer.newBuilder().setName(packet.getString()).setLevel(packet.getShort()).setPro(packet.getByte()));
                }
                player.receive("area.teamPush.onAcrossTeamInfoPush", (GeneratedMessage) push.build());
                return;

            case 3:
                player.teamManager.quitAcrossMatch(true);
                return;

            case 4:
                proxy = GWorld.getProxy(playerId);
                if (proxy != null) {
                    proxy.free(packet.getBoolean());
                }
                return;
        }
        Out.warn(new Object[]{"team onAcrossPacket secType : ", Integer.valueOf(secType)});
    }


    private static void createInstance(Packet packet) {
        int targetId = packet.getInt();
        int difficulty = packet.getByte();
        int count = packet.getByte();
        WNPlayer leader = null;
        Map<String, WNPlayer> players = new HashMap<>();
        for (int i = 0; i < count; i++) {
            int sid = packet.getInt();
            String playerId = packet.getString();
            String name = packet.getString();
            int level = packet.getInt();
            int pro = packet.getInt();
            if (sid != GWorld.__SERVER_ID) {
                WNProxy proxy = new WNProxy(playerId, sid);
                proxy.name = name;
                proxy.level = level;
                proxy.pro = pro;
                GWorld.Proxys.put(playerId, proxy);
                players.put(playerId, proxy);
                proxy.teamMembers = players;
            } else {
                WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
                if (leader == null || player.getTeamManager().isTeamLeader()) {
                    leader = player;
                }
                players.put(playerId, player);
                player.teamMembers = players;
            }
        }

        int mapId = TeamData.getTargetMap(targetId, difficulty);
        if (mapId != 0) {
            Area area = AreaUtil.createArea(leader, Utils.toJSON(new Object[]{"logicServerId", Integer.valueOf(leader.getLogicServerId()), "areaId", Integer.valueOf(mapId)}));
            Out.info(new Object[]{"onAcrossPacket : ", area});
            AreaData areaData = new AreaData(area.areaId, area.instanceId);
            for (WNPlayer player : players.values()) {
                player.changeArea(areaData);
                if (player.isProxy()) {
                    player.setArea(area);
                    area.putActor(player.getId());
                }
            }
        } else {
            Out.warn(new Object[]{"onAcrossPacket : ", Integer.valueOf(targetId), " - ", Integer.valueOf(difficulty)});
        }
    }
}


