/*    */ package com.wanniu.game.area;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.base.MapBase;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ import java.util.concurrent.ConcurrentMap;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IllusionArea
/*    */   extends Area
/*    */ {
/*    */   public MapBase flProp;
/*    */   public final ConcurrentMap<String, Long> playerHookTimeMap;
/*    */   
/*    */   public IllusionArea(JSONObject opts) {
/* 24 */     super(opts);
/*    */     
/* 26 */     this.flProp = AreaDataConfig.getInstance().get(this.areaId);
/* 27 */     if (this.flProp == null) {
/* 28 */       Out.error(new Object[] { "there is no IllusionArea prop   id:", Integer.valueOf(this.areaId) });
/*    */     }
/*    */     
/* 31 */     this.playerHookTimeMap = new ConcurrentHashMap<>();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void onPlayerEntered(WNPlayer player) {
/* 38 */     super.onPlayerEntered(player);
/*    */     
/* 40 */     long hookStartTime = System.currentTimeMillis();
/* 41 */     this.playerHookTimeMap.put(player.getId(), Long.valueOf(hookStartTime));
/* 42 */     Out.info(new Object[] { "幻境计时开始 playerId=", player.getId(), ",hookStartTime=", Long.valueOf(hookStartTime) });
/* 43 */     player.illusionManager.pushChage();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void onPlayerLeaved(WNPlayer player) {
/* 50 */     super.onPlayerLeaved(player);
/*    */ 
/*    */     
/* 53 */     Long hookStartTime = this.playerHookTimeMap.remove(player.getId());
/* 54 */     if (hookStartTime != null) {
/* 55 */       recordHookTime(player, hookStartTime.longValue());
/*    */     } else {
/* 57 */       Out.warn(new Object[] { "幻境计时结算异常，没有找到进入时间 playerId=", player.getId() });
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void recordHookTime(WNPlayer player, long hookStartTime) {
/* 65 */     long now = System.currentTimeMillis();
/* 66 */     long hookTime = now - hookStartTime;
/* 67 */     Out.info(new Object[] { "幻境计时结束 playerId=", player.getId(), ",now=", Long.valueOf(now), ",hookStartTime=", Long.valueOf(hookStartTime), ",hookTime=", Long.valueOf(hookTime) });
/* 68 */     player.achievementManager.onIllusionTimeChange((int)(hookTime / Const.Time.Minute.getValue()));
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\area\IllusionArea.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */