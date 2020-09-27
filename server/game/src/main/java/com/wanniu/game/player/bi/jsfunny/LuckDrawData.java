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
/*    */ public class LuckDrawData
/*    */   extends AnsycPublisher
/*    */ {
/*    */   protected String channel() {
/* 27 */     return "data.LuckDraw";
/*    */   }
/*    */   
/*    */   public LuckDrawData(PlayerPO player, int type, int count, int money, int itemcount) {
/* 31 */     this.data.put("os", player.os);
/* 32 */     this.data.put("channel", player.channel);
/* 33 */     this.data.put("subchannel", player.subchannel);
/* 34 */     this.data.put("id", player.id);
/* 35 */     this.data.put("name", player.name);
/*    */     
/* 37 */     this.data.put("type", Integer.valueOf(type));
/* 38 */     this.data.put("count", Integer.valueOf(count));
/* 39 */     this.data.put("money", Integer.valueOf(money));
/* 40 */     this.data.put("itemcount", Integer.valueOf(itemcount));
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\player\bi\jsfunny\LuckDrawData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */