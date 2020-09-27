/*    */ package com.wanniu.game.request.equip;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.equip.EquipManager;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.EquipHandler;
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
/*    */ @GClientEvent("area.equipHandler.openEquipHandlerRequest")
/*    */ public class OpenEquipHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 30 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 31 */     EquipManager equipManager = player.equipManager;
/*    */     
/* 33 */     EquipHandler.OpenEquipHandlerRequest req = EquipHandler.OpenEquipHandlerRequest.parseFrom(this.pak.getRemaingBytes());
/* 34 */     int code = req.getCode();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 44 */     Out.debug(new Object[] { "opennnnnnnnnnnnnn  ", Integer.valueOf(code) });
/* 45 */     Const.SUPERSCRIPT_TYPE type = Const.SUPERSCRIPT_TYPE.getType(code);
/* 46 */     if (type == null)
/*    */     {
/* 48 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAMETER ERROR"));
/*    */     }
/* 50 */     switch (type) {
/*    */       case REBORN:
/* 52 */         if (player.equipManager.getRebornPoint() > 0)
/*    */         {
/* 54 */           player.playerBasePO.openRebornToday = true;
/*    */         }
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 74 */         equipManager.pushScripts();
/*    */         
/* 76 */         return new PomeloResponse()
/*    */           {
/*    */             protected void write() throws IOException {
/* 79 */               EquipHandler.OpenEquipHandlerResponse.Builder res = EquipHandler.OpenEquipHandlerResponse.newBuilder();
/* 80 */               res.setS2CCode(200);
/* 81 */               this.body.writeBytes(res.build().toByteArray()); } };case REBUILD: if (player.equipManager.getRebuildPoint() > 0) player.playerBasePO.openRebuildToday = true;  equipManager.pushScripts(); return new PomeloResponse() { protected void write() throws IOException { EquipHandler.OpenEquipHandlerResponse.Builder res = EquipHandler.OpenEquipHandlerResponse.newBuilder(); res.setS2CCode(200); this.body.writeBytes(res.build().toByteArray()); } };case KAIGUANG: if (player.equipManager.getKaiguangPoint() > 0) player.playerBasePO.openKaiguangToday = true;  equipManager.pushScripts(); return new PomeloResponse() { protected void write() throws IOException { EquipHandler.OpenEquipHandlerResponse.Builder res = EquipHandler.OpenEquipHandlerResponse.newBuilder(); res.setS2CCode(200); this.body.writeBytes(res.build().toByteArray()); }
/*    */              }
/*    */           ;
/*    */     } 
/*    */     return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAMETER ERROR"));
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\equip\OpenEquipHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */