/*    */ package com.wanniu.login;
/*    */ 
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.redis.ConstsTR;
/*    */ import com.wanniu.core.redis.GCache;
/*    */ import com.wanniu.login.po.AnnouncementPO;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AnnounceServer
/*    */ {
/* 20 */   private static AnnounceServer instance = new AnnounceServer();
/*    */   
/*    */   public static AnnounceServer getInstance() {
/* 23 */     return instance;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static AnnouncementPO announce;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void init() {
/* 35 */     announce = null;
/*    */     
/* 37 */     Map<String, String> map = GCache.hgetAll(ConstsTR.announcement.value);
/* 38 */     List<AnnouncementPO> list = new ArrayList<>();
/* 39 */     map.forEach((k, v) -> paramList.add((AnnouncementPO)JSON.parseObject(v, AnnouncementPO.class)));
/*    */ 
/*    */     
/* 42 */     for (AnnouncementPO p : list) {
/* 43 */       if (p.isUse) {
/* 44 */         announce = p;
/* 45 */         Out.info(new Object[] { "读取登录公告：" + announce.content });
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\login\AnnounceServer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */