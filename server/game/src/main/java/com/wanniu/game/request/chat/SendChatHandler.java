package com.wanniu.game.request.chat;

import cn.qeng.common.gm.monitor.ChatMonitor;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.db.GCache;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.game.protocol.PomeloPush;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.core.util.DateUtil;
import com.wanniu.core.util.RandomUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.chat.ChannelUtil;
import com.wanniu.game.chat.GMChatUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.daoyou.DaoYouCenter;
import com.wanniu.game.daoyou.DaoYouService;
import com.wanniu.game.data.ChatSettingCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.guild.GuildUtil;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.DaoYouMemberPO;
import com.wanniu.game.recent.ChatMsg;
import com.wanniu.game.recent.RecentChatCenter;
import com.wanniu.game.team.TeamData;
import com.wanniu.game.util.BlackWordUtil;
import com.wanniu.redis.PublishCenter;
import io.netty.util.AttributeKey;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import pomelo.chat.ChatHandler;


@GClientEvent("chat.chatHandler.sendChatRequest")
public class SendChatHandler
        extends PomeloRequest {
    private static final AttributeKey<Long> INVITE_CALL = AttributeKey.valueOf("INVITE.CALL");

    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();

        GCache.push("chatLog", player.getId());
        ChatHandler.SendChatRequest req = ChatHandler.SendChatRequest.parseFrom(this.pak.getRemaingBytes());
        String text = req.getC2SContent();
        String serverData = req.getC2SServerData();
        String chatTime = DateUtil.getDateTime();
        int scope = req.getC2SScope();
        String target = req.getC2SAcceptRoleId();

        if (ChatBacklistManager.getInstance().inBacklist((player.getPlayer()).ip)) {
            Out.warn(new Object[]{"命中聊天黑名单. ip=", (player.getPlayer()).ip, ",playerId=", player.getId(), ",name=", player.getName()});
            return (PomeloResponse) new ErrorResponse("系统异常，请联系客服");
        }

        if (scope == Const.CHAT_SCOPE.TEAM_CALL.getValue()) {
            if (!player.getTeamManager().isInTeam()) {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("CHAT_NOT_IN_TEAM"));
            }

            String msg = teamCall(player, text, serverData, chatTime, scope);
            if (msg != null) {
                return (PomeloResponse) new ErrorResponse(msg);
            }
        } else {

            if ((GWorld.DEBUG || GWorld.ROBOT) && text.toLowerCase().startsWith("@gm")) {
                GMChatUtil.GMChatResult gmRes = GMChatUtil.checkContent(player, text);
                text = gmRes.content;
                return (PomeloResponse) new ErrorResponse(text);
            }

            Date forbidTalkTime = (player.getPlayer()).forbidTalkTime;

            if (forbidTalkTime != null && forbidTalkTime.getTime() > System.currentTimeMillis()) {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("CHAT_PLAYER_SHUTUP"));
            }
            int sys = 0;
            if (scope == Const.CHAT_SCOPE.SYSTEM.getValue())
                return (PomeloResponse) new ErrorResponse(LangService.getValue("CHAT_SYS_SCOPE_ERR"));
            if (scope == Const.CHAT_SCOPE.DAOYOU.getValue()) {
                DaoYouMemberPO dymp = DaoYouCenter.getInstance().getDaoYouMember(player.getId());
                if (dymp == null) {
                    return (PomeloResponse) new ErrorResponse(LangService.getValue("CHAT_DAOYOU_ERR"));
                }
            } else if (scope == Const.CHAT_SCOPE.GUILD.getValue()) {
                if (player.guildManager.guild == null) {
                    return (PomeloResponse) new ErrorResponse(LangService.getValue("CHAT_GUILD_ERR"));
                }
            } else if (scope == Const.CHAT_SCOPE.TEAM.getValue()) {
                if (!player.getTeamManager().isInTeam()) {
                    return (PomeloResponse) new ErrorResponse(LangService.getValue("CHAT_NOT_IN_TEAM"));
                }
            } else if (scope == Const.CHAT_SCOPE.HORM.getValue()) {
                sys = 2;
                String itemCode = GlobalConfig.HornCode;
                int itemNum = GlobalConfig.HornCount;
                if (player.bag.findItemNumByCode(itemCode) < itemNum) {
                    player.onFunctionGoTo(Const.FUNCTION_GOTO_TYPE.LOUD_NOT_ENOUGH, itemCode, null, null);
                    return (PomeloResponse) new ErrorResponse(LangService.getValue("ITEM_LOUD_NOT_ENOUGH"));
                }
                scope = Const.CHAT_SCOPE.WORLD.getValue();
            }


            if (!GWorld.DEBUG) {
                ChatSettingCO setting = (ChatSettingCO) GameData.ChatSettings.get(Integer.valueOf(scope));
                if (setting != null) {
                    if (setting.openLv > player.getLevel()) {
                        return (PomeloResponse) new ErrorResponse(LangService.format("CHAT_LV_LESS", new Object[]{Integer.valueOf(setting.openLv)}));
                    }
                    if (player.chatTime == null) {
                        player.chatTime = new HashMap<>();
                    }
                    Long lasttime = (Long) player.chatTime.get(Integer.valueOf(scope));
                    long currTime = System.currentTimeMillis();
                    if (lasttime != null) {
                        long second = setting.coolDown - (currTime - lasttime.longValue()) / 1000L;
                        if (second > 0L) {
                            return (PomeloResponse) new ErrorResponse(LangService.format("CHAT_WORLD_COOL", new Object[]{Long.valueOf(second)}));
                        }
                    }
                    player.chatTime.put(Integer.valueOf(scope), Long.valueOf(currTime));
                }
            }

            JSONObject json = JSONObject.parseObject(serverData);
            if ("toushaizi".equals(text)) {
                if (json.containsKey("s2c_funtype") && json.getIntValue("s2c_funtype") == 1) {
                    sys = 3;
                    text = LangService.format("CHAT_DICE", new Object[]{player.getName(), Integer.valueOf(RandomUtil.getInt(100))});
                }
            } else {
                boolean ignoreCode = ChannelUtil.extractChatItem(player, text);
                text = BlackWordUtil.replaceBlackString(text, ignoreCode);
            }


            serverData = checkServerData(player, serverData, json);

            final ChatHandler.OnChatPush.Builder push = ChatHandler.OnChatPush.newBuilder();
            push.setS2CContent(text);
            push.setS2CPlayerId(player.getId());
            push.setS2CServerData(serverData);
            push.setS2CScope(scope);
            push.setS2CUid(this.pak.getUid());
            push.setS2CTime(chatTime);
            push.setS2CIndex(0);
            push.setS2CSys(sys);

            if (scope == Const.CHAT_SCOPE.PRIVATE.getValue()) {
                push.setS2CAcceptRid(req.getC2SAcceptRoleId());
            }
            PomeloPush chatPush = new PomeloPush() {
                protected void write() throws IOException {
                    this.body.writeBytes(push.build().toByteArray());
                }


                public String getRoute() {
                    return "chat.chatPush.onChatPush";
                }
            };

            if (scope == Const.CHAT_SCOPE.PRIVATE.getValue()) {
                String acceptRid = req.getC2SAcceptRoleId();
                WNPlayer receiver = GWorld.getInstance().getPlayer(acceptRid);
                if (receiver != null) {
                    receiver.receive((Message) chatPush);
                }
                player.receive((Message) chatPush);

                ChatMsg msg = new ChatMsg();
                msg.playerId = player.getId();
                msg.acceptRid = acceptRid;
                msg.content = text;
                msg.time = chatTime;

                RecentChatCenter.getInstance().getRecentChatMgr(acceptRid).addRecentMsg(player.getId(), msg);


                player.getRecentChatMgr().addRecentMsg(acceptRid, msg);

                target = (receiver == null) ? acceptRid : receiver.getName();
                Out.info(new Object[]{"[私聊]【", player.getName(), "】对【", target, "】说：", req.getC2SContent()});
            } else if (scope == Const.CHAT_SCOPE.TEAM.getValue()) {
                Out.info(new Object[]{"[队伍]【", player.getName(), "】说：", req.getC2SContent()});
                sendTeam(player, chatPush);
            } else if (scope == Const.CHAT_SCOPE.DAOYOU.getValue()) {
                DaoYouService.getInstance().sendDaoYou(player, chatPush);
            } else if (scope == Const.CHAT_SCOPE.GUILD.getValue()) {
                Out.info(new Object[]{"[公会]【", player.getName(), "】说：", req.getC2SContent()});
                GuildUtil.broadcast(player.guildManager.getGuildId(), (Message) chatPush);
            } else {
                if (req.getC2SScope() == Const.CHAT_SCOPE.HORM.getValue()) {
                    Out.info(new Object[]{"[喇叭]【", player.getName(), "】说：", req.getC2SContent()});
                    player.bag.discardItem(GlobalConfig.HornCode, GlobalConfig.HornCount, Const.GOODS_CHANGE_TYPE.chat);
                } else {
                    Out.info(new Object[]{"[世界]【", player.getName(), "】说：", req.getC2SContent()});
                }
                GWorld.getInstance().broadcast((Message) chatPush, player.getLogicServerId());

                player.achievementManager.onWorldSpeakTimes();
            }
        }


        ChatMonitor monitor = new ChatMonitor();
        monitor.setSid(GWorld.__SERVER_ID);
        monitor.setDate(new Date());
        monitor.setId(player.getId());
        monitor.setName(player.getName());
        monitor.setLevel(player.getLevel());
        monitor.setPro(player.getPro());
        monitor.setScope(req.getC2SScope());
        monitor.setText(req.getC2SContent());
        monitor.setTarget(target);
        monitor.setIp(this.pak.getIp());
        GWorld.getInstance().ansycExec(() -> PublishCenter.publish("chat_monitor", JSON.toJSONString(monitor)));


        return new PomeloResponse() {
            protected void write() throws IOException {
                ChatHandler.SendChatResponse.Builder res = ChatHandler.SendChatResponse.newBuilder();
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }


    private String checkServerData(WNPlayer player, String serverData, JSONObject json) {
        int level = player.getLevel();
        String name = player.getName();
        int pro = player.getPro();
        int vip = player.baseDataManager.getVip();
        json.put("s2c_level", Integer.valueOf(level));
        json.put("s2c_name", name);
        json.put("s2c_pro", Integer.valueOf(pro));
        json.put("s2c_vip", Integer.valueOf(vip));
        json.put("s2c_zoneId", Integer.valueOf(player.getLogicServerId()));
        return json.toJSONString();
    }

    private void sendTeam(WNPlayer player, PomeloPush chatPush) {
        TeamData team = player.getTeamManager().getTeam();
        if (team != null) {
            team.receive(chatPush);
        }
    }

    private String teamCall(WNPlayer player, String text, String serverData, String chatTime, int scope) {
        if (!(player.getTeamManager().getTeamMember()).isLeader)
            return LangService.format("TEAM_NO_AUTHORITY", new Object[0]);
        Long callTime = (Long) this.pak.getAttr(INVITE_CALL);
        long currTime = System.currentTimeMillis();
        if (callTime != null) {
            long second = 60L - (currTime - callTime.longValue()) / 1000L;
            if (second > 0L) {
                return LangService.format("TEAM_CALL_COOL", new Object[]{Long.valueOf(second)});
            }
        }


        this.pak.setAttr(INVITE_CALL, Long.valueOf(currTime));
        Collection<GPlayer> players = GWorld.getInstance().getOnlinePlayers().values();
        final ChatHandler.OnChatPush.Builder push = ChatHandler.OnChatPush.newBuilder();
        push.setS2CContent(text);
        push.setS2CPlayerId(player.getId());
        push.setS2CServerData(serverData);
        push.setS2CScope(Const.CHAT_SCOPE.TEAM.getValue());
        push.setS2CUid(this.pak.getUid());
        push.setS2CTime(chatTime);
        push.setS2CIndex(0);
        push.setS2CSys(scope);
        PomeloPush chatPush = new PomeloPush() {
            protected void write() throws IOException {
                this.body.writeBytes(push.build().toByteArray());
            }


            public String getRoute() {
                return "chat.chatPush.onChatPush";
            }
        };
        for (GPlayer freer : players) {
            WNPlayer receiver = (WNPlayer) freer;
            if (receiver.getLevel() < GlobalConfig.Team_Min_Level)
                continue;
            if (receiver.getTeamManager().getTeam() == player.getTeamManager().getTeam() || !receiver.getTeamManager().isInTeam()) {
                freer.receive((Message) chatPush);
            }
        }
        Out.info(new Object[]{"[队伍]【", player.getName(), "】说：", text});

        return null;
    }

    public short getType() {
        return 513;
    }
}


