/*    */ package com.wanniu.game.message;
/*    */ 
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.SocialMessageCO;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class SocialMessageConfig
/*    */ {
/*    */   private static SocialMessageConfig instance;
/*    */   private ArrayList<SocialMessageCO> listMessage;
/*    */   
/*    */   public static SocialMessageConfig getInstance() {
/* 13 */     if (instance == null) {
/* 14 */       instance = new SocialMessageConfig();
/*    */     }
/* 16 */     return instance;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private SocialMessageConfig() {
/* 25 */     this.listMessage = new ArrayList<>();
/*    */     for (SocialMessageCO data : GameData.SocialMessages.values())
/*    */       this.listMessage.add(data);  } public final SocialMessageCO findMessageById(int id) {
/* 28 */     for (SocialMessageCO data : this.listMessage) {
/* 29 */       if (data.iD == id) {
/* 30 */         return data;
/*    */       }
/*    */     } 
/* 33 */     return null;
/*    */   }
/*    */   
/*    */   public final SocialMessageCO findMessageByMessageType(int type) {
/* 37 */     for (SocialMessageCO data : this.listMessage) {
/* 38 */       if (data.messageType == type) {
/* 39 */         return data;
/*    */       }
/*    */     } 
/* 42 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\message\SocialMessageConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */