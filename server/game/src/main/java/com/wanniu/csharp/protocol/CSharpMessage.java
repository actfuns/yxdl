/*    */ package com.wanniu.csharp.protocol;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GPlayer;
/*    */ import com.wanniu.core.game.protocol.PomeloPacket;
/*    */ import com.wanniu.core.tcp.BufferUtil;
/*    */ import com.wanniu.core.tcp.protocol.Header;
/*    */ import com.wanniu.core.tcp.protocol.Message;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CSharpMessage
/*    */   extends Message
/*    */ {
/*    */   private static final int HEAD_SIZE = 6;
/*    */   private ByteBuf pakBody;
/*    */   private String csharpServerId;
/*    */   
/*    */   public String getServerId() {
/* 27 */     return this.csharpServerId;
/*    */   }
/*    */ 
/*    */   
/*    */   public CSharpMessage() {}
/*    */   
/*    */   public CSharpMessage(PomeloPacket pak) {
/* 34 */     super(null);
/* 35 */     this.pakBody = pak.getBody();
/* 36 */     CSharpHeader header = getHeader();
/* 37 */     this.pakBody.skipBytes(2);
/* 38 */     header.setLength(this.pakBody.readableBytes());
/* 39 */     GPlayer player = pak.getPlayer();
/* 40 */     header.setUid(player.getId());
/* 41 */     this.csharpServerId = player.getBattleServerId();
/*    */   }
/*    */   
/*    */   protected Header newHeader() {
/* 45 */     return new CSharpHeader();
/*    */   }
/*    */   
/*    */   public CSharpHeader getHeader() {
/* 49 */     return (CSharpHeader)this.header;
/*    */   }
/*    */   
/*    */   protected ByteBuf newContent() {
/* 53 */     CSharpHeader header = getHeader();
/* 54 */     return BufferUtil.getAutoBuffer(6 + header.getUidLength() + header.getBodyLength());
/*    */   }
/*    */   
/*    */   protected void encodeHeader() {
/* 58 */     CSharpHeader header = getHeader();
/* 59 */     header.encode(this.content);
/*    */   }
/*    */   
/*    */   protected void encodeBody() {
/* 63 */     if (this.pakBody != null) {
/* 64 */       this.content.writeBytes(this.pakBody);
/*    */     } else {
/* 66 */       super.encodeBody();
/*    */     } 
/*    */   }
/*    */   
/*    */   public short getType() {
/* 71 */     return 0;
/*    */   }
/*    */   
/*    */   protected void write() throws IOException {}
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\csharp\protocol\CSharpMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */