/*    */ package com.wanniu.game;
/*    */ 
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.util.http.HttpRequester;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ public class BiTestMain
/*    */ {
/*    */   public static final String URL = "http://dev.6543.cn:8380/app_dev.php/api/open/report";
/*    */   
/*    */   static class Item
/*    */   {
/*    */     public String code;
/*    */     public String name;
/*    */     public String num;
/*    */   }
/*    */   
/*    */   static class Player
/*    */   {
/*    */     public String id;
/*    */     public String name;
/*    */     public String level;
/*    */     public String fightLevel;
/*    */   }
/*    */   
/*    */   static class RideTrain
/*    */   {
/*    */     public String id;
/*    */     public String op;
/* 35 */     public List<BiTestMain.Item> consume = new ArrayList<>();
/*    */     public BiTestMain.Player role;
/*    */   }
/*    */   
/*    */   public static String sortParams(Map<String, String> params) {
/* 40 */     StringBuilder sb = new StringBuilder();
/* 41 */     for (String key : params.keySet()) {
/* 42 */       sb.append(key + "=" + (String)params.get(key) + "&");
/*    */     }
/* 44 */     return sb.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void main(String[] args) {
/* 50 */     Player p = new Player();
/* 51 */     p.id = "01fcb557-7025-4e7b-ac24-7b7eb4c1ce0d";
/* 52 */     p.name = "测试员";
/* 53 */     p.level = "38";
/* 54 */     p.fightLevel = "8555550";
/*    */     
/* 56 */     RideTrain rt = new RideTrain();
/* 57 */     rt.id = "fasdfad";
/* 58 */     rt.op = "1";
/* 59 */     rt.role = p;
/* 60 */     for (int i = 1; i < 5; i++) {
/* 61 */       Item item = new Item();
/* 62 */       item.code = String.valueOf(10000 + i);
/* 63 */       item.num = "inum" + (i * 2);
/* 64 */       item.name = "name" + i;
/* 65 */       rt.consume.add(item);
/*    */     } 
/*    */     
/* 68 */     String data = JSON.toJSONString(rt);
/* 69 */     System.out.println(data);
/*    */     
/* 71 */     Map<String, String> params = new HashMap<>();
/* 72 */     params.put("name", "RideTrain");
/* 73 */     params.put("source", "80");
/* 74 */     params.put("platform", "2");
/* 75 */     params.put("device_id", "02920bdb-7c29-4bec-8068-d4ec8f555283");
/* 76 */     params.put("model", "vivo y66");
/* 77 */     params.put("os", "android 4.0");
/* 78 */     params.put("ip", "192.168.92.8");
/* 79 */     params.put("ts", "" + System.currentTimeMillis());
/* 80 */     params.put("data", data);
/*    */     
/* 82 */     System.out.println(sortParams(params));
/*    */     
/*    */     try {
/* 85 */       String response = (new HttpRequester()).sendPost("http://dev.6543.cn:8380/app_dev.php/api/open/report", params).getContent();
/* 86 */       System.out.println(response);
/* 87 */     } catch (Exception e) {
/* 88 */       Out.error(new Object[] { e });
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\BiTestMain.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */