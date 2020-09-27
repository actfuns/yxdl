/*     */ package com.wanniu.core.game.protocol;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.wanniu.core.GConfig;
/*     */ import com.wanniu.core.GGlobal;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.tcp.BufferUtil;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import io.netty.channel.Channel;
/*     */ import io.netty.channel.ChannelHandlerContext;
/*     */ import io.netty.handler.codec.ByteToMessageDecoder;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PomeloDecoder
/*     */   extends ByteToMessageDecoder
/*     */ {
/*  22 */   private static int __REQ_MAX_LEN = GConfig.getInstance().getInt("tcp.request.maxlen", GGlobal.__REQUEST_MAX_LEN);
/*     */ 
/*     */   
/*     */   private static final ByteBuf HANDSHAKE;
/*     */ 
/*     */   
/*     */   static {
/*  29 */     JSONObject res = new JSONObject();
/*  30 */     res.put("code", Integer.valueOf(200));
/*  31 */     JSONObject sys = new JSONObject();
/*  32 */     sys.put("heartbeat", Integer.valueOf(30));
/*  33 */     res.put("sys", sys);
/*  34 */     byte[] bs = res.toJSONString().getBytes(GGlobal.UTF_8);
/*  35 */     PomeloHeader head = new PomeloHeader();
/*  36 */     head.setPomeloType((byte)1);
/*  37 */     head.setLength(bs.length);
/*  38 */     HANDSHAKE = BufferUtil.getAutoBuffer(4 + bs.length);
/*  39 */     head.encode(HANDSHAKE);
/*  40 */     HANDSHAKE.writeBytes(bs);
/*     */     
/*  42 */     PomeloHeader head_hb = new PomeloHeader();
/*  43 */     head_hb.setPomeloType((byte)3);
/*  44 */     head_hb.setLength(0);
/*  45 */   } private static final ByteBuf HEARTBEAT = BufferUtil.getAutoBuffer(4); static {
/*  46 */     head_hb.encode(HEARTBEAT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> messages) throws Exception {
/*  55 */     if (in.readableBytes() < 4) {
/*     */       return;
/*     */     }
/*  58 */     in.markReaderIndex();
/*     */     
/*  60 */     PomeloPacket packet = new PomeloPacket(ctx.channel());
/*  61 */     PomeloHeader header = packet.getHeader();
/*  62 */     header.decode(in);
/*     */     
/*  64 */     int len = header.getLength();
/*  65 */     Out.debug(new Object[] { "请求包头：" + header.toString() });
/*     */     
/*  67 */     if (len > __REQ_MAX_LEN || len < 0) {
/*  68 */       Channel session = ctx.channel();
/*  69 */       Out.warn(new Object[] { "包体长度错误：" + len + 
/*  70 */             " 句柄：" + header.getTypeHexString() + session.remoteAddress() });
/*  71 */       session.close();
/*     */       
/*     */       return;
/*     */     } 
/*  75 */     if (in.readableBytes() < len) {
/*  76 */       in.resetReaderIndex();
/*  77 */       header = null;
/*  78 */       packet = null;
/*     */       
/*     */       return;
/*     */     } 
/*  82 */     ByteBuf body = packet.init();
/*  83 */     body.writeBytes(in, len);
/*  84 */     switch (header.pomelo_type) {
/*     */ 
/*     */       
/*     */       case 1:
/*  88 */         ctx.channel().writeAndFlush(BufferUtil.getBuffer(HANDSHAKE.array()));
/*     */         break;
/*     */       
/*     */       case 2:
/*  92 */         Out.debug(new Object[] { "TYPE_HANDSHAKE_ACK!!" });
/*     */         break;
/*     */       
/*     */       case 4:
/*  96 */         packet.readyBody();
/*     */         
/*  98 */         messages.add(packet);
/*     */         break;
/*     */       
/*     */       case 3:
/* 102 */         Out.error(new Object[] { "TYPE_HEARTBEAT: ", new String(body.array(), GGlobal.UTF_8) });
/* 103 */         ctx.channel().writeAndFlush(BufferUtil.getBuffer(HEARTBEAT.array()));
/*     */         break;
/*     */       
/*     */       case 5:
/* 107 */         Out.debug(new Object[] { "TYPE_KICK: ", new String(body.array(), GGlobal.UTF_8) });
/*     */         break;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\game\protocol\PomeloDecoder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */