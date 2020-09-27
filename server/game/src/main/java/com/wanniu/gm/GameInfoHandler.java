/*    */ package com.wanniu.gm;
/*    */ 
/*    */ import com.wanniu.core.gm.request.GMHandler;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.core.util.DateUtils;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.GWorld;
/*    */ import java.time.LocalDate;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GameInfoHandler
/*    */   extends GMHandler
/*    */ {
/*    */   public void execute(Packet pak) {
/* 22 */     GWorld.__AREA_ID = pak.getInt();
/* 23 */     GWorld.__ACROSS_SERVER_ID = pak.getInt();
/* 24 */     GWorld.__SERVER_NAME = pak.getString();
/* 25 */     GWorld.__PLAYER_LIMIT = pak.getInt();
/* 26 */     String openTime = pak.getString();
/*    */     
/* 28 */     if (StringUtil.isNotEmpty(openTime)) {
/*    */       
/* 30 */       if (openTime.length() > 10) {
/* 31 */         openTime = openTime.substring(0, 10);
/*    */       }
/* 33 */       GWorld.resetOpenServerDate(LocalDate.parse(openTime, DateUtils.F_YYYYMMDD));
/*    */     }
/*    */     else {
/*    */       
/* 37 */       GWorld.resetOpenServerDate(LocalDate.now());
/*    */     } 
/*    */     
/* 40 */     GWorld.__NEW = pak.getBoolean();
/* 41 */     GWorld.__HOT = pak.getBoolean();
/* 42 */     GWorld.__RECOMMEND = pak.getBoolean();
/* 43 */     GWorld.__SHOW = pak.getByte();
/*    */     
/* 45 */     if (pak.remaing() > 0) {
/* 46 */       String externalTime = pak.getString();
/* 47 */       if (StringUtil.isNotEmpty(externalTime)) {
/* 48 */         GWorld.resetExternalTime(externalTime);
/*    */       }
/*    */     } 
/*    */     
/* 52 */     GWorld.getInstance().syncServerInfo();
/* 53 */     Out.info(new Object[] { "gm-server sync game info ok!" });
/*    */   }
/*    */   
/*    */   public short getType() {
/* 57 */     return 255;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\GameInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */