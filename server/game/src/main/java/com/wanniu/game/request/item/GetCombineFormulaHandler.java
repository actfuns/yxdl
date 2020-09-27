/*    */ package com.wanniu.game.request.item;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.bag.WNBag;
/*    */ import com.wanniu.game.data.ext.CombineExt;
/*    */ import com.wanniu.game.equip.EquipCraftConfig;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.ItemHandler;
/*    */ import pomelo.item.ItemOuterClass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.itemHandler.getCombineFormulaRequest")
/*    */ public class GetCombineFormulaHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 28 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 29 */     WNBag wnBag = player.getWnBag();
/*    */     
/* 31 */     ItemHandler.GetCombineFormulaRequest req = ItemHandler.GetCombineFormulaRequest.parseFrom(this.pak.getRemaingBytes());
/* 32 */     final int destId = req.getC2SDestID();
/*    */     
/* 34 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 37 */           ItemHandler.GetCombineFormulaResponse.Builder res = ItemHandler.GetCombineFormulaResponse.newBuilder();
/*    */           
/* 39 */           CombineExt prop = EquipCraftConfig.getInstance().getCombineProp(destId);
/* 40 */           if (prop == null) {
/* 41 */             res.setS2CCode(500);
/* 42 */             res.setS2CMsg(LangService.getValue("ITEM_NOT_COMBINE"));
/* 43 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 46 */           ItemOuterClass.Combine data = EquipCraftConfig.getInstance().getCombineFormula(prop);
/*    */           
/* 48 */           res.setS2CCode(200);
/* 49 */           res.setS2CData(data);
/* 50 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\item\GetCombineFormulaHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */