/*    */ package com.wanniu.game.request.guild;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.GuildHandler;
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildHandler.getGuildMoneyRequest")
/*    */ public class GetGuildMoneyHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 17 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 18 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 21 */           GuildHandler.GetGuildMoneyResponse.Builder res = GuildHandler.GetGuildMoneyResponse.newBuilder();
/*    */           
/* 23 */           JSONObject retData = player.guildManager.toJson4MoneyPayLoad();
/* 24 */           res.setS2CCode(200);
/* 25 */           res.setDepositCount(retData.getIntValue("depositCount"));
/* 26 */           res.setDepositCountMax(retData.getIntValue("depositCountMax"));
/* 27 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\GetGuildMoneyHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */