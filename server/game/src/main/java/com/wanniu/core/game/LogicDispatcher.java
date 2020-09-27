/*    */ package com.wanniu.core.game;
/*    */ 
/*    */ import com.wanniu.core.game.protocol.PomeloHeader;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.tcp.PacketDispatcher;
/*    */ import com.wanniu.core.tcp.protocol.Header;
/*    */ import com.wanniu.core.tcp.protocol.NetHandler;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.core.tcp.server.IPBlacks;
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
/* 22 */     Header header = action.getHeader();
/* 23 */     NetHandler handler = (NetHandler)this.handlers.get(Short.valueOf(header.getType()));
/* 24 */     if (handler == null && header instanceof PomeloHeader) {
/* 25 */       String route_s = ((PomeloHeader)header).route_s;
/*    */       
/* 27 */       handler = (NetHandler)this.s_handlers.get(route_s);
/*    */     } 
/* 29 */     if (handler != null) {
/* 30 */       if (action.isClosed())
/*    */         return;  try {
/* 32 */         handler.bindSession(action.getSession());
/* 33 */         handler.execute(action);
/* 34 */       } catch (Exception e) {
/* 35 */         Out.error(new Object[] { "LogicDispatcher execute", e });
/*    */       } 
/*    */     } else {
/* 38 */       IPBlacks.getInstance().exceptionIp(action.getSession());
/* 39 */       Out.warn(new Object[] { "未找到该协议号:" + header.getTypeHexString() });
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\game\LogicDispatcher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */