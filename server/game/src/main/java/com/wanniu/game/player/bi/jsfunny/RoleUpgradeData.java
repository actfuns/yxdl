/*    */ package com.wanniu.game.player.bi.jsfunny;
/*    */ 
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.util.Date;
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
/*    */ 
/*    */ 
/*    */ public class RoleUpgradeData
/*    */   extends AnsycPublisher
/*    */ {
/*    */   protected String channel() {
/* 29 */     return "data.RoleUpgrade";
/*    */   }
/*    */   
/*    */   public RoleUpgradeData(WNPlayer player) {
/* 33 */     this.data.put("os", (player.getPlayer()).os);
/* 34 */     this.data.put("channel", (player.getPlayer()).channel);
/* 35 */     this.data.put("subchannel", (player.getPlayer()).subchannel);
/* 36 */     this.data.put("id", player.getId());
/*    */     
/* 38 */     this.data.put("name", player.getName());
/* 39 */     this.data.put("level", Integer.valueOf(player.getLevel()));
/* 40 */     this.data.put("exp", Long.valueOf(player.getExp()));
/*    */ 
/*    */     
/* 43 */     Date lastUpDate = player.baseDataManager.getLvChangeTime();
/* 44 */     if (lastUpDate == null)
/*    */     {
/* 46 */       lastUpDate = (player.getPlayer()).createTime;
/*    */     }
/* 48 */     this.data.put("time", Long.valueOf((System.currentTimeMillis() - lastUpDate.getTime()) / 1000L));
/*    */ 
/*    */     
/* 51 */     this.data.put("sid", Integer.valueOf((player.getPlayer()).logicServerId));
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\player\bi\jsfunny\RoleUpgradeData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */