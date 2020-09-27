/*    */ package com.wanniu.game.request.fashion;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import pomelo.Common;
/*    */ import pomelo.area.FashionHandler;
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
/*    */ @GClientEvent("area.fashionHandler.equipFashionRequest")
/*    */ public class EquipFashionHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 30 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 32 */     FashionHandler.EquipFashionRequest req = FashionHandler.EquipFashionRequest.parseFrom(this.pak.getRemaingBytes());
/* 33 */     final String code = req.getCode();
/* 34 */     final boolean ison = req.getIson();
/*    */ 
/*    */     
/* 37 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 40 */           FashionHandler.EquipFashionResponse.Builder res = FashionHandler.EquipFashionResponse.newBuilder();
/*    */           
/* 42 */           boolean result = player.fashionManager.equipFashion(code, ison);
/*    */           
/* 44 */           if (!result) {
/*    */             
/* 46 */             res.setS2CCode(500);
/* 47 */             res.setS2CMsg(LangService.getValue("FASHION_DONT_HAVE"));
/*    */           } 
/* 49 */           res.setS2CCode(200);
/*    */           
/* 51 */           List<Common.Avatar> list = PlayerUtil.getBattlerServerAvatar(player, true);
/* 52 */           for (Common.Avatar avatar : list) {
/* 53 */             if (avatar.getTag() == Const.AVATAR_TYPE.R_HAND_WEAPON.value)
/*    */             {
/* 55 */               res.setEquipedCode1(avatar);
/*    */             }
/* 57 */             if (avatar.getTag() == Const.AVATAR_TYPE.AVATAR_BODY.value)
/*    */             {
/* 59 */               res.setEquipedCode2(avatar);
/*    */             }
/* 61 */             if (avatar.getTag() == Const.AVATAR_TYPE.REAR_EQUIPMENT.value)
/*    */             {
/* 63 */               res.setEquipedCode3(avatar);
/*    */             }
/*    */           } 
/*    */ 
/*    */ 
/*    */           
/* 69 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\fashion\EquipFashionHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */