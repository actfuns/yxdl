package com.wanniu.game.rank;

import com.wanniu.core.db.GCache;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.poes.PlayerRankInfoPO;
import com.wanniu.redis.PlayerPOManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class RankCenter {
    private static final RankCenter instance = new RankCenter();

    public static RankCenter getInstance() {
        return instance;
    }

    public PlayerRankInfoPO findRankPO(String playerId) {
        return (PlayerRankInfoPO) PlayerPOManager.findPO(ConstsTR.playerRankTR, playerId, PlayerRankInfoPO.class);
    }


    public void init() {
        String accountTime = GlobalConfig.WorldExp_Bonus_AccountTime;
        String[] rewardTime = accountTime.split("-");
        if (3 == rewardTime.length) {
            Calendar c = Calendar.getInstance();
            c.set(11, Integer.parseInt(rewardTime[0]));
            c.set(12, Integer.parseInt(rewardTime[1]));
            c.set(13, Integer.parseInt(rewardTime[2]));
            c.set(14, 0);
            Date nowDate = new Date();
            long diffTime = c.getTimeInMillis() - nowDate.getTime();

            if (diffTime < 0L) {
                diffTime += Const.Time.Day.getValue();
            }

            JobFactory.addDelayJob(() -> {
                worldLevelReward();
                JobFactory.addFixedRateJob((), Const.Time.Day.getValue(), Const.Time.Day.getValue());
            }diffTime);
        }
    }


    public String getFirstRankMemberId(RankType type, int serverId) {
        Set<String> members = GCache.zrevrange(type.getRedisKey(serverId, 0), 0L, 0L);
        return members.isEmpty() ? "" : members.iterator().next();
    }

    public void worldLevelReward() {
        Out.info(new Object[]{"send world level award..."});
        String itemList = GlobalConfig.WorldExp_Winner_ItemList;
        List<MailData.Attachment> items = new ArrayList<>();
        String[] itemLists = itemList.split(",");
        for (String code : itemLists) {
            MailData.Attachment attachment = new MailData.Attachment();
            attachment.itemCode = code;
            attachment.itemNum = 1;
            items.add(attachment);
        }

        String playerId = RankType.LEVEL.getHandler().getFirstRankMemberId(GWorld.__SERVER_ID);
        if (PlayerUtil.isPlayerOpenedFunction(playerId, Const.FunctionType.WORLD_EXP.getValue())) {

            MailSysData mailData = new MailSysData("Worldexp_reward");
            mailData.attachments = items;
            MailUtil.getInstance().sendMailToOnePlayer(playerId, (MailData) mailData, Const.GOODS_CHANGE_TYPE.WORLD_LEVEL);
        }
    }

    public static void delRoleClear(String playerId) {
        for (RankType type : RankType.values()) {
            if (type.getHandler() != null) {
                type.getHandler().delRankMember(GWorld.__SERVER_ID, playerId);
            }
        }
    }


    public Map<Integer, SimpleRankData> getSimpleRankData(RankType type, int minRank, int maxRank) {
        return null;
    }
}


