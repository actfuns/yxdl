/*    */ package com.wanniu.game.autoChat;
/*    */ 
/*    */ import com.wanniu.core.game.protocol.PomeloPush;
/*    */ import com.wanniu.core.tcp.protocol.Message;
/*    */ import com.wanniu.game.GWorld;
/*    */ import java.io.IOException;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import pomelo.chat.ChatHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AutoChat
/*    */   extends Thread
/*    */ {
/*    */   private static AutoChat autoChat;
/*    */   private int serverId;
/*    */   
/*    */   public static AutoChat getInstance() {
/* 22 */     if (autoChat != null) {
/* 23 */       return autoChat;
/*    */     }
/* 25 */     autoChat = new AutoChat();
/* 26 */     return autoChat;
/*    */   }
/*    */   
/*    */   public void init(int serverId) {
/* 30 */     this.serverId = serverId;
/* 31 */     start();
/*    */   }
/*    */ 
/*    */   
/*    */   public void run() {
/* 36 */     String playerId = "-1";
/* 37 */     int scope = 1;
/* 38 */     String uid = "-1";
/* 39 */     String[] textArr = { "" };
/* 40 */     String[] nameArr = { "樱娆,1,34", "绾颜,3,31", "旖旎,5,37", "挽衾,1,25", "書生,3,21", "謫仙,5,20", "茗蜃,1,31", "墨渊惊鸿戚,3,23", "素绣绵绵忆,1,24", "絮锦岁岁梦,3,20" };
/* 41 */     String baseMsg = "|<q {\"index\":}></q>|";
/*    */     while (true) {
/* 43 */       String[] nameSplit = nameArr[(int)(Math.random() * nameArr.length)].split(",");
/* 44 */       String serverData = "{\"acceptRoleId\":\"\",\"s2c_level\":" + nameSplit[2] + ",\"s2c_isAtAll\":0,\"s2c_titleMsg\":\"\",\"s2c_name\":\"" + nameSplit[0] + "\",\"s2c_pro\":" + nameSplit[1] + ",\"s2c_vip\":2,\"s2c_zoneId\":" + this.serverId + ",\"s2c_color\":3723689983}";
/* 45 */       final ChatHandler.OnChatPush.Builder push = ChatHandler.OnChatPush.newBuilder();
/* 46 */       push.setS2CContent(getMsg());
/* 47 */       push.setS2CPlayerId(playerId);
/* 48 */       push.setS2CServerData(serverData);
/* 49 */       push.setS2CScope(scope);
/* 50 */       push.setS2CUid(uid);
/* 51 */       push.setS2CTime(getNowDate());
/* 52 */       push.setS2CIndex(0);
/* 53 */       push.setS2CSys(0);
/*    */ 
/*    */       
/* 56 */       PomeloPush chatPush = new PomeloPush()
/*    */         {
/*    */           protected void write() throws IOException {
/* 59 */             this.body.writeBytes(push.build().toByteArray());
/*    */           }
/*    */ 
/*    */           
/*    */           public String getRoute() {
/* 64 */             return "chat.chatPush.onChatPush";
/*    */           }
/*    */         };
/* 67 */       GWorld.getInstance().broadcast((Message)chatPush, this.serverId);
/*    */       try {
/* 69 */         Thread.sleep(((int)(300.0D + Math.random() * 301.0D) * 1000));
/* 70 */       } catch (InterruptedException e) {
/* 71 */         e.printStackTrace();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public String getNowDate() {
/* 78 */     Date currentTime = new Date();
/* 79 */     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 80 */     return formatter.format(currentTime);
/*    */   }
/*    */   
/*    */   public String getMsg() {
/* 84 */     String baseMsg = "|<q {\"index\":" + (int)(0.0D + Math.random() * 48.0D) + "}></q>|";
/* 85 */     StringBuffer base = new StringBuffer(baseMsg);
/* 86 */     int num = (int)(1.0D + Math.random() * 3.0D);
/* 87 */     for (int i = 1; i < num; i++) {
/* 88 */       base.append(baseMsg);
/*    */     }
/* 90 */     return base.toString();
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\autoChat\AutoChat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */