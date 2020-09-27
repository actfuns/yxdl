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
/*    */ public class CreatePlayerData
/*    */   extends AnsycPublisher
/*    */ {
/*    */   protected String channel() {
/* 27 */     return "data.CreatePlayer";
/*    */   }
/*    */   
/*    */   public CreatePlayerData(PlayerPO player) {
/* 31 */     this.data.put("os", player.os);
/* 32 */     this.data.put("channel", player.channel);
/* 33 */     this.data.put("subchannel", player.subchannel);
/* 34 */     this.data.put("id", player.id);
/* 35 */     this.data.put("name", player.name);
/*    */     
/* 37 */     this.data.put("uid", player.uid);
/* 38 */     this.data.put("pro", Integer.valueOf(player.pro));
/* 39 */     this.data.put("mac", player.mac);
/* 40 */     this.data.put("ip", player.ip);
/* 41 */     this.data.put("hour", Integer.valueOf(this.now.getHour()));
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\player\bi\jsfunny\CreatePlayerData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */