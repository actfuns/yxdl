/*    */ package com.wanniu.core.game;
/*    */ 
/*    */ import com.wanniu.core.game.protocol.PomeloHeader;
/*    */ import com.wanniu.core.logfs.Out;
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
/*    */ public final class LogicDispatcher
/*    */   extends PacketDispatcher
/*    */ {
/*    */   public final void execute(Packet action) {
/* 21 */     Header header = action.getHeader();
/* 22 */     NetHandler handler = (NetHandler)this.handlers.get(Short.valueOf(header.getType()));
/* 23 */     if (handler == null && header instanceof PomeloHeader) {
/* 24 */       handler = (NetHandler)this.s_handlers.get(((PomeloHeader)header).route_s);
/*    */     }
/* 26 */     if (handler != null) {
/* 27 */       if (action.isClosed())
/*    */         return;  try {
/* 29 */         handler.bindSession(action.getSession());
/* 30 */         handler.execute(action);
/* 31 */       } catch (Exception e) {
/* 32 */         e.printStackTrace();
/*    */       } 
/*    */     } else {
/* 35 */       Out.warn(new Object[] { "未找到该协议号:" + header.getTypeHexString() });
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\game\LogicDispatcher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */