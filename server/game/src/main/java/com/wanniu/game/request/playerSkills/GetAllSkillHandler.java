/*    */ package com.wanniu.game.request.playerSkills;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.SkillHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.skillHandler.getAllSkillRequest")
/*    */ public class GetAllSkillHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 17 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 18 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 21 */           SkillHandler.GetAllSkillResponse.Builder res = player.skillManager.toJson4Payload();
/* 22 */           res.setS2CCode(200);
/* 23 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\playerSkills\GetAllSkillHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */