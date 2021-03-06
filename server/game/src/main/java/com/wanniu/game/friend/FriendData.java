package com.wanniu.game.friend;

import com.wanniu.core.util.DateUtil;
import com.wanniu.game.area.Area;
import com.wanniu.game.daoyou.DaoYouService;
import com.wanniu.game.guild.GuildUtil;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.DaoYouPO;
import com.wanniu.game.poes.GuildMemberPO;
import com.wanniu.game.poes.GuildPO;
import com.wanniu.game.poes.PlayerPO;

import java.util.Date;

import pomelo.area.FriendHandler;


public class FriendData {
    public String friendId;
    public int friendLv;
    public Date createTimeStamp;
    public Date addFriendLvTime;
    public int addFriendLvToday;

    public FriendHandler.PlayerInfo friendToJson4PayLoad(FriendManager.RecordInfo recordInfos) {
        FriendHandler.PlayerInfo.Builder datas = FriendHandler.PlayerInfo.newBuilder();
        FriendHandler.Position.Builder currentPos = FriendHandler.Position.newBuilder();
        boolean isOnline = PlayerUtil.isOnline(this.friendId);
        datas.setIsOnline(isOnline ? 1 : 0);

        if (isOnline) {
            WNPlayer friendPlayer = PlayerUtil.findPlayer(this.friendId);
            if (null == friendPlayer) {
                return datas.build();
            }

            datas.setGuildId(friendPlayer.guildManager.getGuildId());
            datas.setGuildName(friendPlayer.guildManager.getGuildName());

            datas.setName(friendPlayer.getName());
            datas.setLevel(friendPlayer.getLevel());
            datas.setPro(friendPlayer.getPro());
            datas.setStageLevel(friendPlayer.player.upOrder);
            datas.setVip(0);
            datas.setFightPower(friendPlayer.player.fightPower);

            if (DaoYouService.getInstance().getDaoYou(friendPlayer.getId()) != null) {
                datas.setHasAlly(1);
            }
            Area area = friendPlayer.getArea();
            if (area != null) {
                currentPos.setAreaName(area.getSceneName());
                currentPos.setAreaId(area.areaId);
            }
        } else {
            PlayerPO friendPlayer = PlayerUtil.getPlayerBaseData(this.friendId);

            if (null == friendPlayer) {
                return null;
            }

            datas.setName(friendPlayer.name);
            datas.setLevel(friendPlayer.level);
            datas.setPro(friendPlayer.pro);
            datas.setStageLevel(friendPlayer.upOrder);
            datas.setVip(0);
            datas.setGuildId("");
            datas.setGuildName("");

            GuildMemberPO myInfo = GuildUtil.getGuildMember(this.friendId);
            if (null != myInfo) {
                GuildPO myGuild = GuildUtil.getGuild(myInfo.guildId);
                if (null != myGuild) {
                    datas.setGuildId(myGuild.id);
                    datas.setGuildName(myGuild.name);
                }
            }

            datas.setFightPower(friendPlayer.fightPower);
        }

        if (recordInfos != null) {
            boolean isSame = DateUtil.isSameDay(recordInfos.concernTime, new Date());
            datas.setIsConcerned(isSame ? 1 : 0);
        } else {
            datas.setIsConcerned(0);
        }
        datas.setId(this.friendId);
        datas.setFriendLv(this.friendLv);
        datas.setCurrentPos(currentPos.build());
        DaoYouPO daoYouPo = DaoYouService.getInstance().getDaoYou(this.friendId);
        datas.setIsHaveDaoYou((null == daoYouPo) ? 0 : 1);
        return datas.build();
    }
}


