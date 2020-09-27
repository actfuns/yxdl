/*    */ package com.wanniu.game.request.blood;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.data.OpenLvCO;
/*    */ import com.wanniu.game.functionOpen.FunctionOpenUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.BloodHandler;
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
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.bloodHandler.unequipBloodRequest")
/*    */ public class UnequipBloodHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 39 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 41 */     if (!player.functionOpenManager.isOpen(Const.FunctionType.BloodLineage.getValue())) {
/*    */       
/* 43 */       OpenLvCO prop = FunctionOpenUtil.getPropByName(Const.FunctionType.BloodLineage.getValue());
/* 44 */       return (PomeloResponse)new ErrorResponse(LangService.format("BLOOD_NOT_OPEN", new Object[] { Integer.valueOf(prop.openLv) }));
/*    */     } 
/*    */     
/* 47 */     BloodHandler.UnequipBloodRequest req = BloodHandler.UnequipBloodRequest.parseFrom(this.pak.getRemaingBytes());
/* 48 */     int sortId = req.getSortId();
/*    */     
/* 50 */     boolean result = player.bloodManager.unequipBlood(sortId);
/* 51 */     if (!result)
/*    */     {
/* 53 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("BLOOD_UNEQUIP_FAIL"));
/*    */     }
/*    */     
/* 56 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 59 */           BloodHandler.UnequipBloodResponse.Builder res = BloodHandler.UnequipBloodResponse.newBuilder();
/* 60 */           res.setS2CCode(200);
/*    */ 
/*    */           
/* 63 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\blood\UnequipBloodHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */