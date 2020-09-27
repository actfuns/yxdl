/*    */ package com.wanniu.core.game;
/*    */ 
/*    */ import com.wanniu.core.tcp.PacketDispatcher;
/*    */ import com.wanniu.core.tcp.protocol.Header;
/*    */ import com.wanniu.core.tcp.protocol.NetHandler;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class BattleDispatcher
/*    */   extends PacketDispatcher
/*    */ {
/*    */   public final void execute(Packet action) {
/* 19 */     Header header = action.getHeader();
/* 20 */     NetHandler handler = (NetHandler)this.handlers.get(Short.valueOf(header.getType()));
/* 21 */     if (handler != null) {
/* 22 */       if (action.isClosed())
/* 23 */         return;  handler.bindSession(action.getSession());
/* 24 */       handler.execute(action);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\game\BattleDispatcher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */