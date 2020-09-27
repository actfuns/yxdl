/*    */ package com.wanniu.game.request.fashion;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.ext.FashionExt;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import pomelo.area.FashionHandler;
/*    */ import pomelo.area.PlayerHandler;
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
/*    */ @GClientEvent("area.fashionHandler.getFashionsRequest")
/*    */ public class GetFashionsHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 30 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 32 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 35 */           FashionHandler.GetFashionsResponse.Builder res = FashionHandler.GetFashionsResponse.newBuilder();
/*    */           
/* 37 */           for (String temp_code : player.playerBasePO.fashions_get) {
/* 38 */             FashionExt fashionExt = (FashionExt)GameData.Fashions.get(temp_code);
/* 39 */             switch (Const.FASHION_TYPE.valueOf(fashionExt.type)) {
/*    */               case WEPON:
/* 41 */                 res.addCode1(temp_code);
/*    */               
/*    */               case CLOTH:
/* 44 */                 res.addCode2(temp_code);
/*    */               
/*    */               case WING:
/* 47 */                 res.addCode3(temp_code);
/*    */             } 
/*    */ 
/*    */ 
/*    */           
/*    */           } 
/* 53 */           String equipedCode1 = (String)player.playerBasePO.fashions_equiped.get(Integer.valueOf(Const.FASHION_TYPE.WEPON.value));
/* 54 */           if (equipedCode1 != null) {
/*    */             
/* 56 */             res.addCode1(equipedCode1);
/* 57 */             res.setEquipedCode1(equipedCode1);
/*    */           } 
/* 59 */           String equipedCode2 = (String)player.playerBasePO.fashions_equiped.get(Integer.valueOf(Const.FASHION_TYPE.CLOTH.value));
/* 60 */           if (equipedCode2 != null) {
/*    */             
/* 62 */             res.addCode2(equipedCode2);
/* 63 */             res.setEquipedCode2(equipedCode2);
/*    */           } 
/* 65 */           String equipedCode3 = (String)player.playerBasePO.fashions_equiped.get(Integer.valueOf(Const.FASHION_TYPE.WING.value));
/* 66 */           if (equipedCode3 != null) {
/*    */             
/* 68 */             res.addCode3(equipedCode3);
/* 69 */             res.setEquipedCode3(equipedCode3);
/*    */           } 
/*    */           
/* 72 */           player.playerBasePO.fashion_get_spot = 0;
/* 73 */           List<PlayerHandler.SuperScriptType> ls = player.fashionManager.getSuperScriptList();
/* 74 */           player.updateSuperScriptList(ls);
/*    */           
/* 76 */           res.setS2CCode(200);
/* 77 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\fashion\GetFashionsHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */