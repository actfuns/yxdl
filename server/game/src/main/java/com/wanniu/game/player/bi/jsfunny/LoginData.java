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
/*    */ public class LoginData
/*    */   extends AnsycPublisher
/*    */ {
/*    */   protected String channel() {
/* 27 */     return "data.Login";
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean oneDay() {
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public LoginData(PlayerPO player) {
/* 36 */     this.data.put("os", player.os);
/* 37 */     this.data.put("channel", player.channel);
/* 38 */     this.data.put("subchannel", player.subchannel);
/* 39 */     this.data.put("id", player.id);
/* 40 */     this.data.put("name", player.name);
/*    */     
/* 42 */     this.data.put("uid", player.uid);
/* 43 */     this.data.put("pro", Integer.valueOf(player.pro));
/* 44 */     this.data.put("mac", player.mac);
/* 45 */     this.data.put("ip", player.ip);
/* 46 */     this.data.put("level", Integer.valueOf(player.level));
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\player\bi\jsfunny\LoginData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */