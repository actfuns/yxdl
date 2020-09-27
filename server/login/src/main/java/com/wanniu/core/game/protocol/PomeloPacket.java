/*    */ package com.wanniu.core.game.protocol;
/*    */ 
/*    */ import com.wanniu.core.tcp.protocol.Header;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import io.netty.channel.Channel;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PomeloPacket
/*    */   extends Packet
/*    */ {
/*    */   public PomeloPacket(Channel session) {
/* 15 */     this.header = new PomeloHeader();
/* 16 */     this.session = session;
/*    */   }
/*    */   
/*    */   public short getPacketType() {
/* 20 */     return this.header.getType();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public PomeloHeader getHeader() {
/* 29 */     return (PomeloHeader)this.header;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 38 */     return this.header.getTypeHexString();
/*    */   }
/*    */   
/*    */   public int getU8() {
/* 42 */     return this.body.readByte() & 0xFF;
/*    */   }
/*    */   
/*    */   public void readyBody() {
/* 46 */     byte flag = getByte();
/* 47 */     PomeloHeader header = getHeader();
/* 48 */     header.compressRoute = ((flag & 0x1) != 0);
/* 49 */     byte type = (byte)(flag >> 1 & 0x7);
/* 50 */     if (Protocol.msgHasId(type)) {
/* 51 */       int id = 0;
/* 52 */       int m = 0;
/* 53 */       int i = 0;
/*    */       do {
/* 55 */         m = getU8();
/* 56 */         id += (m & 0x7F) * (1 << 7 * i);
/* 57 */         i++;
/* 58 */       } while (m >= 128);
/* 59 */       header.setType((short)id);
/*    */     } 
/* 61 */     if (Protocol.msgHasRoute(type))
/* 62 */       if (header.compressRoute) {
/* 63 */         header.route_n = (short)(getU8() << 8 | getU8());
/*    */       } else {
/* 65 */         int routeLen = getU8();
/* 66 */         byte[] dst = new byte[routeLen];
/* 67 */         getBytes(dst);
/* 68 */         header.route_s = Protocol.strdecode(dst);
/*    */       }  
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\game\protocol\PomeloPacket.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */