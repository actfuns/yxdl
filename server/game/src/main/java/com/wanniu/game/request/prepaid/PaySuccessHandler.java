/*    */ package com.wanniu.game.request.prepaid;
/*    */ 
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.wanniu.core.pay.request.PayHandler;
/*    */ import com.wanniu.core.tcp.protocol.Message;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.game.prepaid.PrepaidService;
/*    */ import java.io.IOException;
/*    */ import org.apache.commons.lang3.StringUtils;
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
/*    */ public class PaySuccessHandler
/*    */   extends PayHandler
/*    */ {
/*    */   public void execute(Packet pak) {
/* 26 */     final long key = pak.getLong();
/* 27 */     JSONObject json = JSON.parseObject(pak.getString());
/* 28 */     String orderId = json.getString("orderId");
/*    */ 
/*    */     
/* 31 */     String playerId = json.getString("playerId");
/* 32 */     if (StringUtils.isNotEmpty(playerId)) {
/* 33 */       int productId = json.getIntValue("productId");
/* 34 */       PrepaidService.getInstance().onSimulationOrder(orderId, playerId, productId);
/*    */     } 
/*    */     
/* 37 */     PrepaidService.getInstance().onPaySuccess(orderId);
/*    */     
/* 39 */     pak.getSession().writeAndFlush(new Message()
/*    */         {
/*    */           protected void write() throws IOException
/*    */           {
/* 43 */             this.body.writeLong(key);
/* 44 */             this.body.writeString("success");
/*    */           }
/*    */ 
/*    */           
/*    */           public short getType() {
/* 49 */             return 245;
/*    */           }
/*    */         });
/*    */   }
/*    */ 
/*    */   
/*    */   public short getType() {
/* 56 */     return 245;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\prepaid\PaySuccessHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */