/*    */ package com.wanniu.game.request.blood;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.ConstsTR;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.data.OpenLvCO;
/*    */ import com.wanniu.game.functionOpen.FunctionOpenUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.BloodPO;
/*    */ import com.wanniu.redis.PlayerPOManager;
/*    */ import java.io.IOException;
/*    */ import java.util.Iterator;
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
/*    */ @GClientEvent("area.bloodHandler.getEquipedBloodsRequest")
/*    */ public class GetEquipedBloodsHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 42 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 44 */     BloodHandler.GetEquipedBloodsRequest req = BloodHandler.GetEquipedBloodsRequest.parseFrom(this.pak.getRemaingBytes());
/* 45 */     String playerId = req.getPlayerId();
/*    */     
/* 47 */     if (!player.functionOpenManager.isOpen(Const.FunctionType.BloodLineage.getValue())) {
/*    */       
/* 49 */       OpenLvCO prop = FunctionOpenUtil.getPropByName(Const.FunctionType.BloodLineage.getValue());
/* 50 */       return (PomeloResponse)new ErrorResponse(LangService.format("BLOOD_NOT_OPEN", new Object[] { Integer.valueOf(prop.openLv) }));
/*    */     } 
/*    */     
/* 53 */     BloodPO bloodPO = (BloodPO)PlayerPOManager.findPO(ConstsTR.player_blood, playerId, BloodPO.class);
/* 54 */     if (bloodPO == null) {
/* 55 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PLAYER_NULL"));
/*    */     }
/*    */     
/* 58 */     final Map<Integer, Integer> equipedBloods = bloodPO.equipedMap;
/*    */     
/* 60 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 63 */           BloodHandler.GetEquipedBloodsResponse.Builder res = BloodHandler.GetEquipedBloodsResponse.newBuilder();
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 68 */           for (Iterator<Integer> iterator = equipedBloods.values().iterator(); iterator.hasNext(); ) { int bloodId = ((Integer)iterator.next()).intValue();
/*    */ 
/*    */ 
/*    */             
/* 72 */             res.addBloodIds(bloodId); }
/*    */           
/* 74 */           res.setS2CCode(200);
/*    */ 
/*    */           
/* 77 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\blood\GetEquipedBloodsHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */