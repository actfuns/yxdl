/*    */ package com.wanniu.game.guild.guildFort;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.tcp.protocol.Message;
/*    */ import com.wanniu.game.area.Area;
/*    */ import com.wanniu.game.common.msg.MessagePush;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ 
/*    */ public class GuildFortPveArea extends Area {
/*    */   private GuildFort fort;
/*    */   
/*    */   public GuildFortPveArea(JSONObject opts) {
/* 16 */     super(opts);
/* 17 */     int fortId = opts.getIntValue("fortId");
/* 18 */     this.fort = GuildFortCenter.getInstance().getFort(fortId);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void onPlayerEntered(WNPlayer player) {
/* 26 */     super.onPlayerEntered(player);
/* 27 */     this.fort.onPlayerEntered(player);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean noCloseIfNoPlayer() {
/* 34 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void onInterActiveItem(WNPlayer player, int objId, int itemId) {
/* 41 */     super.onInterActiveItem(player, objId, itemId);
/* 42 */     if (this.fort != null) {
/* 43 */       this.fort.onPickedItem(player, itemId);
/*    */     } else {
/* 45 */       Out.warn(new Object[] { "contender null onInterActiveItem: " + player.getId() + " " + itemId });
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onMonsterDead(int monsterId, int level, float x, float y, int attackType, String refreshPoint, WNPlayer player, JSONArray teamSharedIdList, JSONArray atkAssistantList) {
/* 52 */     super.onMonsterDead(monsterId, level, x, y, attackType, refreshPoint, player, teamSharedIdList, atkAssistantList);
/* 53 */     if (this.fort != null) {
/* 54 */       this.fort.onKilledMonster(player, monsterId);
/*    */     } else {
/* 56 */       Out.warn(new Object[] { "contender null onMonsterDead: " + player.getId() + " " + monsterId });
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void pushReport(MessagePush defenserMessage, MessagePush attackerMessage) {
/* 67 */     for (String pid : this.actors.keySet()) {
/* 68 */       WNPlayer player = PlayerUtil.getOnlinePlayer(pid);
/* 69 */       if (player != null) {
/* 70 */         if (this.fort.isDefenserMember(player.guildManager.getGuildId())) {
/* 71 */           player.receive((Message)defenserMessage); continue;
/*    */         } 
/* 73 */         player.receive((Message)attackerMessage);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guildFort\GuildFortPveArea.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */