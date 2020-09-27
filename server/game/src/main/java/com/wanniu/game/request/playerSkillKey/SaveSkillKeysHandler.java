/*    */ package com.wanniu.game.request.playerSkillKey;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.msg.WNNotifyManager;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.SkillKeysHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.skillKeysHandler.saveSkillKeysRequest")
/*    */ public class SaveSkillKeysHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 19 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 20 */     final SkillKeysHandler.SaveSkillKeysRequest req = SkillKeysHandler.SaveSkillKeysRequest.parseFrom(this.pak.getRemaingBytes());
/* 21 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 24 */           SkillKeysHandler.SaveSkillKeysResponse.Builder res = SkillKeysHandler.SaveSkillKeysResponse.newBuilder();
/* 25 */           int result = player.skillManager.changeSkillsPos(req);
/*    */           
/* 27 */           if (result == 0) {
/* 28 */             res.setS2CCode(200);
/* 29 */             WNNotifyManager.getInstance().pushSkillKeysUpdate(player, player.skillKeyManager.toJson4Payload());
/* 30 */           } else if (result == -1) {
/* 31 */             res.setS2CCode(500);
/* 32 */             res.setS2CMsg("SKILLKEY_SET_ERROR_SKILL_REPEAT");
/* 33 */           } else if (result == -2) {
/* 34 */             res.setS2CCode(500);
/* 35 */             res.setS2CMsg("SKILLKEY_SET_ERROR_KEY_LOCK");
/* 36 */           } else if (result == -3) {
/* 37 */             res.setS2CCode(500);
/* 38 */             res.setS2CMsg("SKILLKEY_SET_ERROR_SKILL_NOT_CAN_SET");
/* 39 */           } else if (result == -4) {
/* 40 */             res.setS2CCode(500);
/* 41 */             res.setS2CMsg("SKILLKEY_SET_ERROR_NOT_FIND_SKILL");
/* 42 */           } else if (result == -5) {
/* 43 */             res.setS2CCode(500);
/* 44 */             res.setS2CMsg("SKILLKEY_SET_ERROR_SKILL_NOT_LEARN");
/*    */           } 
/* 46 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\playerSkillKey\SaveSkillKeysHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */