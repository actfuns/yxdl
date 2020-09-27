/*    */ package com.wanniu.game.player.bi.jsfunny;
/*    */ 
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
/*    */ public class ItemFlowData
/*    */   extends AnsycPublisher
/*    */ {
/*    */   protected String channel() {
/* 27 */     return "data.ItemFlow";
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean oneDay() {
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public ItemFlowData(PlayerPO player, int operate, String itemcode, int count, boolean bind, int origin) {
/* 36 */     this.data.put("os", player.os);
/* 37 */     this.data.put("channel", player.channel);
/* 38 */     this.data.put("subchannel", player.subchannel);
/* 39 */     this.data.put("id", player.id);
/* 40 */     this.data.put("name", player.name);
/*    */     
/* 42 */     this.data.put("operate", Integer.valueOf(operate));
/* 43 */     this.data.put("itemcode", itemcode);
/* 44 */     this.data.put("count", Integer.valueOf(count));
/* 45 */     this.data.put("bind", Boolean.valueOf(bind));
/* 46 */     this.data.put("origin", Integer.valueOf(origin));
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\player\bi\jsfunny\ItemFlowData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */