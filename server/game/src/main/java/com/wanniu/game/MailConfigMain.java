/*    */ package com.wanniu.game;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.wanniu.core.util.FileUtil;
/*    */ import java.io.File;
/*    */ import java.io.FileWriter;
/*    */ import java.io.IOException;
/*    */ import java.util.HashMap;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MailConfigMain
/*    */ {
/*    */   public static void main(String[] args) {
/* 15 */     File file = new File("../json/json/mail/Mail/MailSystem.json");
/* 16 */     JSONArray doc = JSONArray.parseArray(FileUtil.readText(file));
/*    */     
/* 18 */     FileWriter writer = null;
/* 19 */     HashMap<String, String> strKey_map = new HashMap<>();
/* 20 */     HashMap<String, String> idKey_map = new HashMap<>();
/*    */     try {
/* 22 */       writer = new FileWriter("./src/com/wanniu/game/mail/SysMailConst.java");
/* 23 */       writer.write("package com.wanniu.game.mail;\r\n");
/* 24 */       writer.write("\r\n");
/* 25 */       writer.write("public class SysMailConst{\r\n");
/* 26 */       writer.write("\r\n");
/*    */       
/* 28 */       for (int i = 3; i < doc.size(); i++) {
/* 29 */         JSONArray values = (JSONArray)doc.get(i);
/* 30 */         String field = values.getString(6);
/* 31 */         if (field != null && !field.trim().equals(""))
/*    */         {
/*    */           
/* 34 */           writer.write("\tpublic static final String " + field.toUpperCase() + " = \"" + field + "\";\r\n"); } 
/* 35 */         if (strKey_map.containsKey(field))
/*    */         {
/* 37 */           throw new Exception("重复的ParamName：" + field);
/*    */         }
/* 39 */         String id = values.getString(0);
/* 40 */         strKey_map.put(field, field);
/* 41 */         if (idKey_map.containsKey(id))
/*    */         {
/* 43 */           throw new Exception("重复的id：" + id);
/*    */         }
/* 45 */         strKey_map.put(id, id);
/*    */       } 
/*    */ 
/*    */ 
/*    */       
/* 50 */       writer.write("\r\n");
/* 51 */       writer.write("}");
/* 52 */       writer.flush();
/* 53 */     } catch (Exception e) {
/* 54 */       e.printStackTrace();
/*    */     } finally {
/*    */       try {
/* 57 */         writer.close();
/* 58 */       } catch (IOException e) {
/* 59 */         e.printStackTrace();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\MailConfigMain.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */