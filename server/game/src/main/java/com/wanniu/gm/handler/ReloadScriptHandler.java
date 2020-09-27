/*    */ package com.wanniu.gm.handler;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.wanniu.core.GConfig;
/*    */ import com.wanniu.core.util.DataUtil;
/*    */ import com.wanniu.gm.GMEvent;
/*    */ import com.wanniu.gm.GMResponse;
/*    */ import com.wanniu.gm.GMStateResponse;
/*    */ import java.io.File;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GMEvent
/*    */ public class ReloadScriptHandler
/*    */   extends GMBaseHandler
/*    */ {
/*    */   public enum ScriptType
/*    */   {
/* 24 */     ACTIVITY_LIST,
/*    */     
/* 26 */     SIGN,
/*    */     
/* 28 */     ONLINE_GIFT,
/*    */     
/* 30 */     LEVEL_GIFT,
/*    */     
/* 32 */     POWER_GIFT,
/*    */     
/* 34 */     OPEN_SERVER;
/*    */   }
/*    */   
/*    */   public GMResponse execute(JSONArray arr) {
/* 38 */     String types = arr.getString(0);
/* 39 */     List<File> files = new ArrayList<>();
/* 40 */     for (String t : types.split(";")) {
/* 41 */       int type = Integer.parseInt(t);
/* 42 */       String path = GConfig.getInstance().get("dir.game.data");
/* 43 */       if (type == ScriptType.ACTIVITY_LIST.ordinal()) {
/* 44 */         files.add(new File(path + "/activity/Activity/Activity.json"));
/* 45 */       } else if (type == ScriptType.SIGN.ordinal()) {
/* 46 */         files.add(new File(path + "/sign/sign/accumulate.json"));
/* 47 */         files.add(new File(path + "/sign/sign/luxury_sign.json"));
/* 48 */         files.add(new File(path + "/sign/sign/normal_sign.json"));
/* 49 */       } else if (type == ScriptType.ONLINE_GIFT.ordinal()) {
/* 50 */         files.add(new File(path + "/activity/OnlineGift/OlGift.json"));
/* 51 */       } else if (type == ScriptType.LEVEL_GIFT.ordinal()) {
/* 52 */         files.add(new File(path + "/activity/Activity/ActivityConfig.json"));
/* 53 */       } else if (type == ScriptType.POWER_GIFT.ordinal()) {
/* 54 */         files.add(new File(path + "/activity/Activity/ActivityConfig.json"));
/* 55 */       } else if (type == ScriptType.OPEN_SERVER.ordinal()) {
/* 56 */         files.add(new File(path + "/activity/Activity/ActivityConfig.json"));
/*    */       } 
/*    */     } 
/* 59 */     for (File f : files) {
/* 60 */       if (f.exists()) {
/* 61 */         DataUtil.loadData(f);
/*    */       }
/*    */     } 
/* 64 */     DataUtil.initProperty();
/* 65 */     return (GMResponse)new GMStateResponse(1);
/*    */   }
/*    */   
/*    */   public short getType() {
/* 69 */     return 24592;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\handler\ReloadScriptHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */