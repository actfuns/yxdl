/*    */ package com.wanniu.game.area;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.GWorld;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ 
/*    */ public class ProxyArea
/*    */   extends Area
/*    */ {
/*    */   public ProxyArea(JSONObject opts) {
/* 13 */     super(opts);
/*    */   }
/*    */ 
/*    */   
/*    */   public void bindBattleServer(WNPlayer player) {
/* 18 */     Out.warn(new Object[] { "proxy bindBattleServer!!!" });
/*    */   }
/*    */   
/*    */   public void setBattleServerId(String battleServerId) {
/* 22 */     this.serverId = battleServerId;
/* 23 */     Out.debug(new Object[] { "bindBattleServer ", this.serverId });
/*    */   }
/*    */   
/*    */   protected void init() {
/* 27 */     this.hasPlayerEntered = false;
/* 28 */     this.actors = new ConcurrentHashMap<>();
/* 29 */     this.emptyTime = GWorld.APP_TIME;
/* 30 */     this.sceneType = this.prop.type;
/* 31 */     this.lifeTime = this.prop.lifeTime * 1000;
/*    */   }
/*    */ 
/*    */   
/*    */   public void dispose() {
/* 36 */     super.dispose();
/*    */   }
/*    */ 
/*    */   
/*    */   public void addPlayer(WNPlayer player) {
/* 41 */     super.addPlayer(player);
/*    */   }
/*    */ 
/*    */   
/*    */   public void removePlayer(WNPlayer player, boolean keepObject) {
/* 46 */     super.removePlayer(player, keepObject);
/*    */   }
/*    */   
/*    */   public boolean hasHighQualityItem() {
/* 50 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\area\ProxyArea.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */