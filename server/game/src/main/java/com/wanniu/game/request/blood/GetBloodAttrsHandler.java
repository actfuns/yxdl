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
/*    */ import java.util.Map;
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
/*    */ 
/*    */ @GClientEvent("area.bloodHandler.getBloodAttrsRequest")
/*    */ public class GetBloodAttrsHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 41 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */ 
/*    */     
/* 44 */     if (!player.functionOpenManager.isOpen(Const.FunctionType.BloodLineage.getValue())) {
/*    */       
/* 46 */       OpenLvCO prop = FunctionOpenUtil.getPropByName(Const.FunctionType.BloodLineage.getValue());
/* 47 */       return (PomeloResponse)new ErrorResponse(LangService.format(LangService.getValue("BLOOD_NOT_OPEN"), new Object[] { Integer.valueOf(prop.openLv) }));
/*    */     } 
/*    */     
/* 50 */     final Map<Const.PlayerBtlData, Integer> attrs = player.bloodManager.calAllInfluence();
/*    */     
/* 52 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 55 */           BloodHandler.GetBloodAttrsResponse.Builder res = BloodHandler.GetBloodAttrsResponse.newBuilder();
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 60 */           for (Map.Entry<Const.PlayerBtlData, Integer> entry : (Iterable<Map.Entry<Const.PlayerBtlData, Integer>>)attrs.entrySet()) {
/* 61 */             BloodHandler.BloodAttr.Builder ab = BloodHandler.BloodAttr.newBuilder();
/* 62 */             ab.setId(((Const.PlayerBtlData)entry.getKey()).id);
/* 63 */             ab.setValue(((Integer)entry.getValue()).intValue());
/* 64 */             res.addBloodAttrs(ab.build());
/*    */           } 
/* 66 */           res.setS2CCode(200);
/*    */ 
/*    */           
/* 69 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\blood\GetBloodAttrsHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */