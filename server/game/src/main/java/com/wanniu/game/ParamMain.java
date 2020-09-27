/*    */ package com.wanniu.game;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.wanniu.core.GConfig;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.util.FileUtil;
/*    */ import java.io.File;
/*    */ import java.io.FileWriter;
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ParamMain
/*    */ {
/*    */   public static final String START = "//================================ParamMain auto generate start================================//";
/*    */   public static final String END = "//================================ParamMain auto generate end================================//";
/*    */   
/*    */   public static void main(String[] args) {
/* 23 */     GConfig.getInstance().init(false);
/* 24 */     Out.setting();
/*    */     
/* 26 */     File parameters = new File(GConfig.getInstance().get("dir.game.data") + "/config/GameConfig/Parameters.json");
/* 27 */     JSONArray doc = JSONArray.parseArray(FileUtil.readText(parameters));
/* 28 */     StringBuilder builder = new StringBuilder("//================================ParamMain auto generate start================================//");
/* 29 */     for (int i = 3; i < doc.size(); i++) {
/* 30 */       JSONArray values = (JSONArray)doc.get(i);
/* 31 */       String type = values.getString(1);
/* 32 */       builder.append("\n\tpublic static ").append("NUMBER".equals(type) ? "int " : ("FLOAT".equals(type) ? "float " : "String ")).append(values.get(0).toString().replace(".", "_")).append(";");
/*    */     } 
/*    */     
/* 35 */     builder.append("\n//================================ParamMain auto generate end================================//");
/*    */     
/* 37 */     File globalFile = new File("src/main/java/com/wanniu/game/player/GlobalConfig.java");
/* 38 */     System.out.println(globalFile.getAbsolutePath());
/* 39 */     StringBuilder globalContent = new StringBuilder(FileUtil.readText(globalFile));
/* 40 */     int start = globalContent.indexOf("//================================ParamMain auto generate start================================//");
/* 41 */     int end = globalContent.indexOf("//================================ParamMain auto generate end================================//") + "//================================ParamMain auto generate end================================//".length();
/* 42 */     globalContent.replace(start, end, builder.toString());
/* 43 */     System.out.println(globalContent.toString());
/*    */     try {
/* 45 */       FileWriter newGlobalFile = new FileWriter(globalFile);
/* 46 */       newGlobalFile.write(globalContent.toString());
/* 47 */       newGlobalFile.close();
/* 48 */     } catch (IOException e) {
/* 49 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\ParamMain.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */