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
/*    */ public class PacketMonitorData
/*    */   extends AnsycPublisher
/*    */ {
/*    */   protected String channel() {
/* 27 */     return "data.PacketMonitor";
/*    */   }
/*    */   
/*    */   public PacketMonitorData(PlayerPO player, Integer count, short index, String route) {
/* 31 */     this.data.put("os", player.os);
/* 32 */     this.data.put("channel", player.channel);
/* 33 */     this.data.put("subchannel", player.subchannel);
/* 34 */     this.data.put("id", player.id);
/* 35 */     this.data.put("name", player.name);
/*    */     
/* 37 */     this.data.put("level", Integer.valueOf(player.level));
/* 38 */     this.data.put("count", count);
/* 39 */     this.data.put("index", Short.valueOf(index));
/* 40 */     this.data.put("route", route);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\player\bi\jsfunny\PacketMonitorData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */