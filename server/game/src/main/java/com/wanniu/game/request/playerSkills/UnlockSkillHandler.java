/*    */ package com.wanniu.game.request.playerSkills;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.SkillHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.skillHandler.unlockSkillRequest")
/*    */ public class UnlockSkillHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 18 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException
/*    */         {
/* 22 */           SkillHandler.UnlockSkillResponse.Builder res = SkillHandler.UnlockSkillResponse.newBuilder();
/*    */           
/* 24 */           res.setS2CCode(500);
/* 25 */           res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 26 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\playerSkills\UnlockSkillHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */