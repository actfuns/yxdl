package com.wanniu.game.recent;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.core.util.DateUtil;
import com.wanniu.game.area.Area;
import com.wanniu.game.common.CommonUtil;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.daoyou.DaoYouService;
import com.wanniu.game.guild.GuildUtil;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.GuildMemberPO;
import com.wanniu.game.poes.GuildPO;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.game.poes.RecentChatPO;
import com.wanniu.redis.PlayerPOManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import pomelo.area.FriendHandler;


public class RecentChatMgr {
    private RecentChatPO data;
    private final int MSG_MAX = 20;

    public RecentChatMgr(String playerId, RecentChatPO po) {
        if (null != po) {
            this.data = po;
        } else {
            this.data = new RecentChatPO();
            PlayerPOManager.put(ConstsTR.playerRecentChatTR, playerId, (GEntity) this.data);
        }
    }


    public RecentChatPO getData() {
        return this.data;
    }


    public void onPlayerOffline() {
        checkRecentLimit();
    }


    public void checkRecentLimit() {
        if (this.data.msg.size() > GlobalConfig.Social_MaxFriendNum) {
            List<Map.Entry<String, RecentChatMsg>> list = new ArrayList<>(this.data.msg.entrySet());
            list.sort((o1, o2) -> (((RecentChatMsg) o1.getValue()).recentChatTime.getTime() < ((RecentChatMsg) o2.getValue()).recentChatTime.getTime()) ? 1 : -1);


            for (int i = GlobalConfig.Social_MaxFriendNum; i < this.data.msg.size(); i++) {
                this.data.msg.remove(((Map.Entry) list.get(i)).getKey());
            }
        }
    }


    public FriendHandler.PlayerInfo getPlayerInfo(String playerId) {
        FriendHandler.PlayerInfo.Builder datas = FriendHandler.PlayerInfo.newBuilder();
        FriendHandler.Position.Builder currentPos = FriendHandler.Position.newBuilder();
        boolean isOnline = PlayerUtil.isOnline(playerId);
        datas.setIsOnline(isOnline ? 1 : 0);

        if (isOnline) {
            WNPlayer player = PlayerUtil.findPlayer(playerId);
            if (null == player) {
                return datas.build();
            }

            datas.setGuildId(player.guildManager.getGuildId());
            datas.setGuildName(player.guildManager.getGuildName());

            datas.setName(player.getName());
            datas.setLevel(player.getLevel());
            datas.setPro(player.getPro());
            datas.setStageLevel(player.player.upLevel);
            datas.setVip(0);
            datas.setFightPower(CommonUtil.calFightPower(player.btlDataManager.allInflus));

            if (DaoYouService.getInstance().getDaoYou(playerId) != null) {
                datas.setHasAlly(1);
            }
            Area area = player.getArea();
            if (area != null) {
                currentPos.setAreaName(area.getSceneName());
                currentPos.setAreaId(area.areaId);
            }
        } else {
            PlayerPO player = PlayerUtil.getPlayerBaseData(playerId);

            if (null == player) {
                return datas.build();
            }

            datas.setName(player.name);
            datas.setLevel(player.level);
            datas.setPro(player.pro);
            datas.setStageLevel(player.upLevel);
            datas.setVip(0);
            datas.setGuildId("");
            datas.setGuildName("");

            GuildMemberPO myInfo = GuildUtil.getGuildMember(playerId);
            if (null != myInfo) {
                GuildPO myGuild = GuildUtil.getGuild(myInfo.guildId);
                if (null != myGuild) {
                    datas.setGuildId(myGuild.id);
                    datas.setGuildName(myGuild.name);
                }
            }

            datas.setFightPower(player.fightPower);
        }

        datas.setId(playerId);
        datas.setCurrentPos(currentPos.build());
        return datas.build();
    }


    public List<FriendHandler.PlayerInfo> getRecentLs() {
        List<FriendHandler.PlayerInfo> ls = new ArrayList<>();
        for (String key : this.data.msg.keySet()) {
            FriendHandler.PlayerInfo playerInfo = getPlayerInfo(key);
            if (null != playerInfo) {
                ls.add(playerInfo);
            }
        }
        return ls;
    }


    public void addRecentMsg(String friendId, ChatMsg msg) {
        Map<String, RecentChatMsg> ls = this.data.msg;
        if (!ls.containsKey(friendId)) {
            RecentChatMsg recentMsg = new RecentChatMsg();
            recentMsg.recentChatTime = DateUtil.format(msg.time);
            recentMsg.msgLs.add(msg);
            ls.put(friendId, recentMsg);
        } else {

            if (((RecentChatMsg) ls.get(friendId)).msgLs.size() > 20) {
                ((RecentChatMsg) ls.get(friendId)).msgLs.remove(0);
            }

            ((RecentChatMsg) ls.get(friendId)).recentChatTime = DateUtil.format(msg.time);
            ((RecentChatMsg) ls.get(friendId)).msgLs.add(msg);
        }
    }


    public List<FriendHandler.ChatMsg> getRecentMsg(String playerId) {
        List<FriendHandler.ChatMsg> ls = new ArrayList<>();
        if (this.data.msg.size() < 0 || !this.data.msg.containsKey(playerId)) {
            return ls;
        }

        for (int i = 0; i < ((RecentChatMsg) this.data.msg.get(playerId)).msgLs.size(); i++) {
            ChatMsg msg = ((RecentChatMsg) this.data.msg.get(playerId)).msgLs.get(i);
            FriendHandler.ChatMsg.Builder buildMsg = FriendHandler.ChatMsg.newBuilder();
            buildMsg.setS2CPlayerId(msg.playerId);
            buildMsg.setS2CContent(msg.content);
            buildMsg.setS2CTime(msg.time);
            buildMsg.setS2CAcceptRid(msg.acceptRid);
            ls.add(buildMsg.build());
        }

        return ls;
    }


    public void removeRecentMsg(String playerId) {
        if (this.data.msg.size() < 0 || !this.data.msg.containsKey(playerId)) {
            return;
        }

        this.data.msg.remove(playerId);
    }


    public void removeAllMsg() {
        this.data.msg.clear();
    }
}


