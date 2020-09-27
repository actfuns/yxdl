/*    */ package com.wanniu.game.fashion;
/*    */ 
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.ext.FashionExt;
/*    */ import com.wanniu.game.poes.PlayerBasePO;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import pomelo.Common;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FashionUtil
/*    */ {
/*    */   public static List<Common.Avatar> getAvatarData(PlayerBasePO playerBasePO) {
/* 22 */     List<Common.Avatar> data = new ArrayList<>();
/*    */ 
/*    */     
/* 25 */     for (Map.Entry<Integer, String> entry : (Iterable<Map.Entry<Integer, String>>)playerBasePO.fashions_equiped.entrySet()) {
/* 26 */       if (entry.getValue() == null) {
/*    */         continue;
/*    */       }
/* 29 */       String itemcode = entry.getValue();
/*    */       
/* 31 */       FashionExt fashion = (FashionExt)GameData.Fashions.get(itemcode);
/* 32 */       Common.Avatar.Builder avatar = Common.Avatar.newBuilder();
/* 33 */       avatar.setEffectType(0);
/*    */       
/* 35 */       avatar.setTag(fashion.avatarTag);
/* 36 */       avatar.setFileName(fashion.avatarId);
/* 37 */       data.add(avatar.build());
/*    */     } 
/* 39 */     return data;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\fashion\FashionUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */