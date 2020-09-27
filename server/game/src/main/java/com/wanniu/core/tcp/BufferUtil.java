/*    */ package com.wanniu.core.tcp;
/*    */ 
/*    */ import com.wanniu.core.GGlobal;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import io.netty.buffer.Unpooled;
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
/*    */ public final class BufferUtil
/*    */ {
/*    */   public static ByteBuf getAutoBuffer() {
/* 19 */     return getAutoBuffer(GGlobal.__BUFFER_CAPACITY);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static ByteBuf getAutoBuffer(int initCapacity) {
/* 29 */     ByteBuf body = Unpooled.buffer(initCapacity).order(GGlobal.__BYTE_ORDER);
/* 30 */     return body;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static byte[] getBufBytes(ByteBuf src) {
/* 41 */     return src.array();
/*    */   }
/*    */   
/*    */   public static ByteBuf getBuffer(byte[] buf) {
/* 45 */     ByteBuf body = Unpooled.buffer(buf.length).order(GGlobal.__BYTE_ORDER);
/* 46 */     return body.writeBytes(buf);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\tcp\BufferUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */