package com.wanniu.game.area;

import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.base.MapBase;
import com.wanniu.game.player.WNPlayer;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


public class IllusionArea
        extends Area {
    public MapBase flProp;
    public final ConcurrentMap<String, Long> playerHookTimeMap;

    public IllusionArea(JSONObject opts) {
        super(opts);

        this.flProp = AreaDataConfig.getInstance().get(this.areaId);
        if (this.flProp == null) {
            Out.error(new Object[]{"there is no IllusionArea prop   id:", Integer.valueOf(this.areaId)});
        }

        this.playerHookTimeMap = new ConcurrentHashMap<>();
    }


    public void onPlayerEntered(WNPlayer player) {
        super.onPlayerEntered(player);

        long hookStartTime = System.currentTimeMillis();
        this.playerHookTimeMap.put(player.getId(), Long.valueOf(hookStartTime));
        Out.info(new Object[]{"幻境计时开始 playerId=", player.getId(), ",hookStartTime=", Long.valueOf(hookStartTime)});
        player.illusionManager.pushChage();
    }


    public void onPlayerLeaved(WNPlayer player) {
        super.onPlayerLeaved(player);


        Long hookStartTime = this.playerHookTimeMap.remove(player.getId());
        if (hookStartTime != null) {
            recordHookTime(player, hookStartTime.longValue());
        } else {
            Out.warn(new Object[]{"幻境计时结算异常，没有找到进入时间 playerId=", player.getId()});
        }
    }


    private void recordHookTime(WNPlayer player, long hookStartTime) {
        long now = System.currentTimeMillis();
        long hookTime = now - hookStartTime;
        Out.info(new Object[]{"幻境计时结束 playerId=", player.getId(), ",now=", Long.valueOf(now), ",hookStartTime=", Long.valueOf(hookStartTime), ",hookTime=", Long.valueOf(hookTime)});
        player.achievementManager.onIllusionTimeChange((int) (hookTime / Const.Time.Minute.getValue()));
    }
}


