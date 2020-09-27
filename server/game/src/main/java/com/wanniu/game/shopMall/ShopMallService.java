package com.wanniu.game.shopMall;

import com.wanniu.core.GGame;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.player.WNPlayer;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;


public class ShopMallService {
    private ShopMallService() {
        resetWeekBuy();
    }

    private static final class Holder {
        public static final ShopMallService instance = new ShopMallService();
    }

    public static ShopMallService getInstance() {
        return Holder.instance;
    }

    public Date getResetTime() {
        Calendar monDay = Calendar.getInstance();
        monDay.set(7, 2);
        monDay.set(11, 5);
        monDay.set(12, 0);
        monDay.set(13, 0);
        monDay.set(14, 0);
        return monDay.getTime();
    }


    private void resetWeekBuy() {
        Date monday = getResetTime();

        long delay = monday.getTime() - System.currentTimeMillis();
        if (delay < 0L) {
            delay += (Const.Time.Day.getValue() * 7);
        }
        Out.info(new Object[]{"shopMall resetWeekBuy delay : ", Long.valueOf(delay)});
        JobFactory.addFixedRateJob(() -> {
            Out.info(new Object[]{"resetWeekBuy..."}, );
            Map<String, GPlayer> players = GGame.getInstance().getOnlinePlayers();
            WNPlayer player = null;
            for (GPlayer gplayer : players.values()) {
                player = (WNPlayer) gplayer;
                player.shopMallManager.refreshNewWeek();
            }
        }delay, Const.Time.Day


                .getValue());
    }
}


