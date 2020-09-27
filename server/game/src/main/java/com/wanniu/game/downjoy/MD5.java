/*    */ package com.wanniu.game.downjoy;
/*    */ 
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import java.security.MessageDigest;
/*    */ import java.security.NoSuchAlgorithmException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MD5
/*    */ {
/*    */   public static String getDigest(String msg) {
/*    */     try {
/* 14 */       MessageDigest md5 = MessageDigest.getInstance("MD5");
/* 15 */       byte[] byteArray = null;
/* 16 */       byteArray = msg.getBytes("UTF-8");
/* 17 */       byte[] md5Bytes = md5.digest(byteArray);
/* 18 */       StringBuffer hexValue = new StringBuffer();
/* 19 */       for (int i = 0; i < md5Bytes.length; i++) {
/* 20 */         int val = md5Bytes[i] & 0xFF;
/* 21 */         if (val < 16)
/* 22 */           hexValue.append("0"); 
/* 23 */         hexValue.append(Integer.toHexString(val));
/*    */       } 
/* 25 */       return hexValue.toString();
/* 26 */     } catch (Exception exception) {
/*    */ 
/*    */       
/* 29 */       return null;
/*    */     } 
/*    */   }
/*    */   public static String bytesToHexString(byte[] bArray) {
/* 33 */     StringBuffer sb = new StringBuffer(bArray.length);
/*    */     
/* 35 */     for (int i = 0; i < bArray.length; i++) {
/* 36 */       String sTemp = Integer.toHexString(0xFF & bArray[i]);
/* 37 */       if (sTemp.length() < 2) {
/* 38 */         sb.append(0);
/*    */       }
/* 40 */       sb.append(sTemp.toUpperCase());
/*    */     } 
/* 42 */     return sb.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String encrypt(String source) {
/* 52 */     MessageDigest md = null;
/* 53 */     byte[] bt = source.getBytes();
/*    */     try {
/* 55 */       bt = source.getBytes("UTF-8");
/* 56 */       md = MessageDigest.getInstance("MD5");
/* 57 */       md.update(bt);
/* 58 */       return bytesToHexString(md.digest());
/* 59 */     } catch (NoSuchAlgorithmException e) {
/* 60 */       throw new RuntimeException(e);
/* 61 */     } catch (UnsupportedEncodingException e1) {
/* 62 */       e1.printStackTrace();
/*    */       
/* 64 */       return null;
/*    */     } 
/*    */   }
/*    */   public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
/* 68 */     System.out.println(getDigest("order=ok123456&money=5.21&umid=123456&time=20141212105433&result=1&transno=&key=66666dfPe05f"));
/* 69 */     System.out.println(getDigest("195|j5VEvxhc|4C18A0AEAB1B4C9BBFD49E21E202025C|36223535814"));
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\downjoy\MD5.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */