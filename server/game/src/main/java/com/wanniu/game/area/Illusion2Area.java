package com.wanniu.game.area;

import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.daily.DailyActivityMgr;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.sevengoal.SevenGoalManager;

import java.util.concurrent.TimeUnit;


public class Illusion2Area
        extends Area {
    public static final int DEFAULT_ID = 53001;

    public Illusion2Area(JSONObject opts) {
        super(opts);


        JobFactory.addDelayJob(() -> {
            Out.info(new Object[]{"幻境2玩法清场.", this.instanceId}, );
            AreaManager.getInstance().closeArea(this.instanceId);
        } (DailyActivityMgr.getCloseIllusion2Second() + 2), TimeUnit.SECONDS);
    }


    public void onPlayerEntered(WNPlayer player) {
        super.onPlayerEntered(player);
        player.illusionManager.pushChageBy2();
        player.dailyActivityMgr.onEvent(Const.DailyType.ILLUSION2, "0", 1);
        player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.ILLUSION2_COUNT, new Object[0]);
    }


    protected boolean canPickInterActiveItem(WNPlayer player, String itemCode, int itemNum) {
        return player.illusionManager.addItemNum(this, itemCode, itemNum);
    }


    public Area.AreaItem onPickItem(String playerId, String itemId, boolean isGuard) {
        Area.AreaItem areaItem = this.items.get(itemId);
        if (areaItem != null && (areaItem.bindPlayers == null || areaItem.bindPlayers.containsKey(playerId) ||
                System.currentTimeMillis() - areaItem.createTime > GlobalConfig.itemdrop_lock_lifeTime)) {
            Area.Actor actor = getActor(playerId);
            if (actor == null || !actor.profitable) {
                Out.debug(new Object[]{playerId, "当前不可拾取", itemId});
                return null;
            }
            WNPlayer player = getPlayer(playerId);

            if (!player.illusionManager.addItemNum(this, areaItem.item.itemCode(), areaItem.item.getNum())) {
                Out.debug(new Object[]{playerId, "秘境夺宝达到宝箱上限，当前不可拾取", itemId});
                return null;
            }

            this.items.remove(itemId);
            Out.debug(new Object[]{getClass(), player.getName(), " onPickItem itemId:", itemId, ",isGuard:", Boolean.valueOf(isGuard)});
            int groupCount = areaItem.item.itemDb.groupCount;
            onFreedomPickItem(player, areaItem.item, isGuard);
            areaItem.item.setGroup(groupCount);
            if (areaItem.dropPlayer != null) {
                onPickPlayerDropItem(player, areaItem);
            } else {
                onPickMonsterDropItem(player, areaItem);
            }
            return areaItem;
        }
        return null;
    }
}


