/*    */ package com.wanniu.game.util;
/*    */ 
/*    */ import com.wanniu.core.XLang;
/*    */ import com.wanniu.game.GWorld;
/*    */ import com.wanniu.game.data.BlackWordCO;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class BlackWordUtil
/*    */ {
/* 17 */   private static DFAScanner scaner = null;
/*    */   
/*    */   public static DFAScanner getScaner() {
/* 20 */     if (scaner == null) {
/* 21 */       synchronized (BlackWordUtil.class) {
/* 22 */         if (scaner == null) {
/* 23 */           List<String> words = new ArrayList<>(GameData.BlackWords.size());
/* 24 */           for (BlackWordCO bw : GameData.BlackWords.values()) {
/* 25 */             words.add(bw.word);
/*    */           }
/* 27 */           scaner = new DFAScanner(words);
/*    */         } 
/*    */       } 
/*    */     }
/* 31 */     return scaner;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean isIncludeBlackString(String srcString) {
/* 41 */     return getScaner().findSensitiveWord(srcString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean isIncludeSpecialChar(String srcString) {
/* 51 */     int unicodeStart = GWorld.__SERVER_LANG.getUnicodeStart();
/* 52 */     int unicodeEnd = GWorld.__SERVER_LANG.getUnicodeEnd();
/*    */     
/* 54 */     for (int i = 0; i < srcString.length(); i++) {
/* 55 */       char _char = srcString.charAt(i);
/* 56 */       int charUnicode = _char;
/*    */       
/* 58 */       if ((_char < 'a' || _char > 'z') && (_char < 'A' || _char > 'Z') && (_char < '0' || _char > '9') && (charUnicode < unicodeStart || charUnicode > unicodeEnd))
/*    */       {
/*    */ 
/*    */ 
/*    */         
/* 63 */         if (GWorld.__SERVER_LANG != XLang.VN || _char != ' ')
/*    */         {
/*    */ 
/*    */           
/* 67 */           return true; }  } 
/*    */     } 
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public static String replaceBlackString(String srcString) {
/* 73 */     return getScaner().replaceSensitiveWord(srcString, false);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String replaceBlackString(String srcString, boolean ignoreCode) {
/* 83 */     return getScaner().replaceSensitiveWord(srcString, ignoreCode);
/*    */   }
/*    */   
/*    */   public static boolean isNumberString(String str) {
/* 87 */     for (int i = str.length(); --i >= 0;) {
/* 88 */       if (!Character.isDigit(str.charAt(i))) {
/* 89 */         return false;
/*    */       }
/*    */     } 
/* 92 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gam\\util\BlackWordUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */