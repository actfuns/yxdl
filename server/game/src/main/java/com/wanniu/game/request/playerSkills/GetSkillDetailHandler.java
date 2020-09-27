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
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.skillHandler.getSkillDetailRequest")
/*    */ public class GetSkillDetailHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 19 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 20 */     SkillHandler.GetSkillDetailRequest req = SkillHandler.GetSkillDetailRequest.parseFrom(this.pak.getRemaingBytes());
/* 21 */     final int skillId = req.getS2CSkillId();
/* 22 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 25 */           SkillHandler.GetSkillDetailResponse.Builder res = SkillHandler.GetSkillDetailResponse.newBuilder();
/* 26 */           SkillHandler.SkillDetail skillDetail = player.skillManager.getSkillDetail4PayLoad(skillId);
/* 27 */           if (skillDetail != null) {
/* 28 */             res.setS2CCode(200);
/* 29 */             res.setS2CSkill(skillDetail);
/*    */           } else {
/* 31 */             res.setS2CCode(500);
/* 32 */             res.setS2CMsg("SKILL_NULL");
/*    */           } 
/* 34 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\playerSkills\GetSkillDetailHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */