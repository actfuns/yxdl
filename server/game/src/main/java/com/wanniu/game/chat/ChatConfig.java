/*    */ package com.wanniu.game.chat;
/*    */ 
/*    */ import com.wanniu.game.data.ChatSettingCO;
/*    */ import com.wanniu.game.data.GameData;
/*    */ 
/*    */ public class ChatConfig
/*    */ {
/*    */   private static ChatConfig instance;
/*    */   
/*    */   public static ChatConfig getInstance() {
/* 11 */     if (instance == null) {
/* 12 */       instance = new ChatConfig();
/*    */     }
/* 14 */     return instance;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ChatSettingCO getChatSettingProp(int channelId) {
/* 25 */     for (ChatSettingCO setting : GameData.ChatSettings.values()) {
/* 26 */       if (setting.channelID == channelId) {
/* 27 */         return setting;
/*    */       }
/*    */     } 
/* 30 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\chat\ChatConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */