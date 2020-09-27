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
/*    */ public class MoneyFlowData
/*    */   extends AnsycPublisher
/*    */ {
/*    */   protected String channel() {
/* 28 */     return "data.MoneyFlow";
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean oneDay() {
/* 33 */     return true;
/*    */   }
/*    */   
/*    */   public MoneyFlowData(PlayerPO player, VirtualItemType type, int before, int operate, int value, int after, int origin) {
/* 37 */     this.data.put("os", player.os);
/* 38 */     this.data.put("channel", player.channel);
/* 39 */     this.data.put("subchannel", player.subchannel);
/* 40 */     this.data.put("id", player.id);
/* 41 */     this.data.put("name", player.name);
/*    */     
/* 43 */     this.data.put("type", type.getItemcode());
/* 44 */     this.data.put("before", Integer.valueOf(before));
/* 45 */     this.data.put("operate", Integer.valueOf(operate));
/* 46 */     this.data.put("value", Integer.valueOf(value));
/* 47 */     this.data.put("after", Integer.valueOf(after));
/* 48 */     this.data.put("origin", Integer.valueOf(origin));
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\player\bi\jsfunny\MoneyFlowData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */