/*    */ package com.wanniu.game.player.bi.jsfunny;
/*    */ 
/*    */ import com.wanniu.game.item.VirtualItemType;
/*    */ import com.wanniu.game.poes.PlayerPO;
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
/*    */ public class MoneyMonitorData
/*    */   extends AnsycPublisher
/*    */ {
/*    */   protected String channel() {
/* 28 */     return "data.MoneyMonitor";
/*    */   }
/*    */   
/*    */   public MoneyMonitorData(PlayerPO player, VirtualItemType type, int today, int threshold) {
/* 32 */     this.data.put("os", player.os);
/* 33 */     this.data.put("channel", player.channel);
/* 34 */     this.data.put("subchannel", player.subchannel);
/* 35 */     this.data.put("id", player.id);
/* 36 */     this.data.put("name", player.name);
/*    */     
/* 38 */     this.data.put("level", Integer.valueOf(player.level));
/* 39 */     this.data.put("type", type.getItemcode());
/* 40 */     this.data.put("today", Integer.valueOf(today));
/* 41 */     this.data.put("threshold", Integer.valueOf(threshold));
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\player\bi\jsfunny\MoneyMonitorData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */