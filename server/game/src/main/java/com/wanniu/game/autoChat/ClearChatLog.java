package com.wanniu.game.autoChat;

import com.wanniu.core.db.GCache;
import com.wanniu.core.game.JobFactory;
import com.wanniu.game.common.Const;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PlayerPO;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ScheduledFuture;


public class ClearChatLog {
    private static ClearChatLog ClearChatLog;
    private ScheduledFuture<?> autoClear;

    public static ClearChatLog getInstance() {
        if (ClearChatLog != null) {
            return ClearChatLog;
        }
        ClearChatLog = new ClearChatLog();
        return ClearChatLog;
    }


    public void init() {
        this.autoClear = JobFactory.addScheduleJob(new Runnable() {


            public void run() {
                List<String> list = GCache.lRangeAll("chatLog");
                int listSize = list.size();
                if (list != null && list.size() > 0) {
                    HashSet<String> set = new HashSet<>(list);
                    if (set.size() == 1 && list.size() >= 5) {
                        String playerId = set.iterator().next();
                        WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
                        if (player != null) {
                            player.kick(Const.KickReason.GM_KICK);
                        }
                        PlayerPO po = PlayerUtil.getPlayerBaseData(playerId);

                        long currentTime = System.currentTimeMillis() + 600000L;
                        Date date = new Date(currentTime);
                        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String nowTime = df.format(date);
                        Date parse = null;
                        try {
                            parse = df.parse(nowTime);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        System.out.println(nowTime);
                        po.forbidTalkTime = parse;
                        po.forbidTalkReason = "刷屏禁言10分钟";
                    }
                }


                GCache.remove("chatLog");
            }
        }, 0L, 60000L);
    }
}


