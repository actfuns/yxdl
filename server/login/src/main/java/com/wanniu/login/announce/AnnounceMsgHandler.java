/*    */ package com.wanniu.login.announce;
/*    */ 
/*    */ import com.wanniu.core.http.HttpDecoderAndEncoder;
/*    */ import com.wanniu.core.http.HttpServerMsgHandler;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.login.AnnounceServer;
/*    */ import com.wanniu.login.po.AnnouncementPO;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import io.netty.handler.codec.http.FullHttpRequest;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AnnounceMsgHandler
/*    */   implements HttpServerMsgHandler
/*    */ {
/*    */   private String path;
/*    */   
/*    */   public AnnounceMsgHandler(String path) {
/* 25 */     this.path = path;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getPath() {
/* 30 */     return this.path;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void doGet(ChannelHandlerContext ctx, FullHttpRequest request, Map<String, String> parmMap) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void doPost(ChannelHandlerContext ctx, FullHttpRequest request, Map<String, String> parmMap) {
/* 40 */     AnnouncementPO announce = AnnounceServer.announce;
/* 41 */     if (announce == null) {
/* 42 */       Out.error(new Object[] { "未获取到公告" });
/* 43 */       HttpDecoderAndEncoder.Response(ctx, request, "");
/*    */     } else {
/* 45 */       Out.debug(new Object[] { "公告：" + announce.content });
/* 46 */       HttpDecoderAndEncoder.Response(ctx, request, announce.content);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\login\announce\AnnounceMsgHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */