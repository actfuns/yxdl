/*     */ package com.wanniu.core.game.protocol;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.wanniu.core.GConfig;
/*     */ import com.wanniu.core.GGame;
/*     */ import com.wanniu.core.GGlobal;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.tcp.BufferUtil;
/*     */ import com.wanniu.csharp.CSharpClient;
/*     */ import com.wanniu.csharp.protocol.CSharpMessage;
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
/*  25 */   private static int __REQ_MAX_LEN = GConfig.getInstance().getInt("tcp.request.maxlen", GGlobal.__REQUEST_MAX_LEN);
/*     */ 
/*     */   
/*     */   private static final ByteBuf HANDSHAKE;
/*     */ 
/*     */   
/*     */   static {
/*  32 */     JSONObject res = new JSONObject();
/*  33 */     res.put("code", Integer.valueOf(200));
/*  34 */     JSONObject sys = new JSONObject();
/*  35 */     sys.put("heartbeat", Integer.valueOf(30));
/*  36 */     res.put("sys", sys);
/*  37 */     byte[] bs = res.toJSONString().getBytes(GGlobal.UTF_8);
/*  38 */     PomeloHeader head = new PomeloHeader();
/*  39 */     head.setPomeloType((byte)1);
/*  40 */     head.setLength(bs.length);
/*  41 */     HANDSHAKE = BufferUtil.getAutoBuffer(4 + bs.length);
/*  42 */     head.encode(HANDSHAKE);
/*  43 */     HANDSHAKE.writeBytes(bs);
/*     */     
/*  45 */     PomeloHeader head_hb = new PomeloHeader();
/*  46 */     head_hb.setPomeloType((byte)3);
/*  47 */     head_hb.setLength(0);
/*  48 */   } private static final ByteBuf HEARTBEAT = BufferUtil.getAutoBuffer(4); static {
/*  49 */     head_hb.encode(HEARTBEAT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> messages) throws Exception {
/*  58 */     if (in.readableBytes() < 4) {
/*     */       return;
/*     */     }
/*  61 */     in.markReaderIndex();
/*     */     
/*  63 */     PomeloPacket packet = new PomeloPacket(ctx.channel());
/*  64 */     PomeloHeader header = packet.getHeader();
/*  65 */     header.decode(in);
/*     */     
/*  67 */     int len = header.getLength();
/*     */     
/*  69 */     if (len > __REQ_MAX_LEN || len < 0) {
/*  70 */       Channel session = ctx.channel();
/*  71 */       Out.warn(new Object[] { header.route_s, "包体长度错误：", Integer.valueOf(len), session.remoteAddress() });
/*  72 */       session.close();
/*     */       
/*     */       return;
/*     */     } 
/*  76 */     if (in.readableBytes() < len) {
/*  77 */       in.resetReaderIndex();
/*  78 */       header = null;
/*  79 */       packet = null;
/*     */       
/*     */       return;
/*     */     } 
/*  83 */     ByteBuf body = packet.init();
/*  84 */     body.writeBytes(in, len);
/*  85 */     switch (header.pomelo_type) {
/*     */ 
/*     */       
/*     */       case 1:
/*  89 */         ctx.channel().writeAndFlush(BufferUtil.getBuffer(HANDSHAKE.array()));
/*     */         break;
/*     */       
/*     */       case 2:
/*  93 */         Out.debug(new Object[] { "TYPE_HANDSHAKE_ACK!!" });
/*     */         break;
/*     */       
/*     */       case 4:
/*  97 */         packet.readyBody();
/*     */         
/*  99 */         if (header.isBattlePak()) {
/* 100 */           CSharpClient.getInstance().dispatch(new CSharpMessage(packet)); break;
/*     */         } 
/* 102 */         header.setReceiveTime(System.nanoTime());
/* 103 */         GGame.getInstance().putGlobalRoute(header.route_s, packet);
/*     */         break;
/*     */ 
/*     */       
/*     */       case 3:
/* 108 */         Out.debug(new Object[] { "TYPE_HEARTBEAT: ", new String(body.array(), GGlobal.UTF_8) });
/*     */         
/* 110 */         ctx.channel().writeAndFlush(BufferUtil.getBuffer(HEARTBEAT.array()));
/*     */         break;
/*     */       
/*     */       case 5:
/* 114 */         Out.debug(new Object[] { "TYPE_KICK: ", new String(body.array(), GGlobal.UTF_8) });
/*     */         break;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\game\protocol\PomeloDecoder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */