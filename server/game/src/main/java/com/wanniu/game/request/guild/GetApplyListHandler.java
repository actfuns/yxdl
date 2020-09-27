/*    */ package com.wanniu.game.request.guild;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import pomelo.area.GuildHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildHandler.getApplyListRequest")
/*    */ public class GetApplyListHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 18 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */ 
/*    */     
/* 21 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 24 */           GuildHandler.GetApplyListResponse.Builder res = GuildHandler.GetApplyListResponse.newBuilder();
/*    */           
/* 26 */           List<GuildHandler.ApplyInfo> applyList = player.guildManager.getMyGuildApplyList();
/* 27 */           res.setS2CCode(200);
/* 28 */           res.addAllS2CApplyList(applyList);
/* 29 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\GetApplyListHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */