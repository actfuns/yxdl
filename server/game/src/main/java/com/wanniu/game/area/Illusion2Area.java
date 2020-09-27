/*    */ package com.wanniu.game.area;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.wanniu.core.game.JobFactory;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.daily.DailyActivityMgr;
/*    */ import com.wanniu.game.player.GlobalConfig;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.sevengoal.SevenGoalManager;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Illusion2Area
/*    */   extends Area
/*    */ {
/*    */   public static final int DEFAULT_ID = 53001;
/*    */   
/*    */   public Illusion2Area(JSONObject opts) {
/* 36 */     super(opts);
/*    */ 
/*    */     
/* 39 */     JobFactory.addDelayJob(() -> {
/*    */           Out.info(new Object[] { "幻境2玩法清场.", this.instanceId }, );
/*    */           AreaManager.getInstance().closeArea(this.instanceId);
/* 42 */         }(DailyActivityMgr.getCloseIllusion2Second() + 2), TimeUnit.SECONDS);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void onPlayerEntered(WNPlayer player) {
/* 50 */     super.onPlayerEntered(player);
/* 51 */     player.illusionManager.pushChageBy2();
/* 52 */     player.dailyActivityMgr.onEvent(Const.DailyType.ILLUSION2, "0", 1);
/* 53 */     player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.ILLUSION2_COUNT, new Object[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean canPickInterActiveItem(WNPlayer player, String itemCode, int itemNum) {
/* 61 */     return player.illusionManager.addItemNum(this, itemCode, itemNum);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Area.AreaItem onPickItem(String playerId, String itemId, boolean isGuard) {
/* 72 */     Area.AreaItem areaItem = this.items.get(itemId);
/* 73 */     if (areaItem != null && (areaItem.bindPlayers == null || areaItem.bindPlayers.containsKey(playerId) || 
/* 74 */       System.currentTimeMillis() - areaItem.createTime > GlobalConfig.itemdrop_lock_lifeTime)) {
/* 75 */       Area.Actor actor = getActor(playerId);
/* 76 */       if (actor == null || !actor.profitable) {
/* 77 */         Out.debug(new Object[] { playerId, "当前不可拾取", itemId });
/* 78 */         return null;
/*    */       } 
/* 80 */       WNPlayer player = getPlayer(playerId);
/*    */       
/* 82 */       if (!player.illusionManager.addItemNum(this, areaItem.item.itemCode(), areaItem.item.getNum())) {
/* 83 */         Out.debug(new Object[] { playerId, "秘境夺宝达到宝箱上限，当前不可拾取", itemId });
/* 84 */         return null;
/*    */       } 
/*    */       
/* 87 */       this.items.remove(itemId);
/* 88 */       Out.debug(new Object[] { getClass(), player.getName(), " onPickItem itemId:", itemId, ",isGuard:", Boolean.valueOf(isGuard) });
/* 89 */       int groupCount = areaItem.item.itemDb.groupCount;
/* 90 */       onFreedomPickItem(player, areaItem.item, isGuard);
/* 91 */       areaItem.item.setGroup(groupCount);
/* 92 */       if (areaItem.dropPlayer != null) {
/* 93 */         onPickPlayerDropItem(player, areaItem);
/*    */       } else {
/* 95 */         onPickMonsterDropItem(player, areaItem);
/*    */       } 
/* 97 */       return areaItem;
/*    */     } 
/* 99 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\area\Illusion2Area.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */