/*    */ package com.wanniu.login.vo;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ 
/*    */ public class AreaVO
/*    */ {
/*    */   public int appId;
/*    */   public int areaId;
/* 10 */   public String areaName = "NEW";
/*    */   
/* 12 */   public Map<Integer, ServerVO> areaServers = new ConcurrentHashMap<>();
/*    */   
/*    */   public AreaVO(int areaId) {
/* 15 */     this.areaId = areaId;
/* 16 */     this.areaName = String.valueOf(this.areaName) + this.areaId;
/*    */   }
/*    */   
/*    */   public AreaVO(int areaId, String areaName) {
/* 20 */     this.areaId = areaId;
/* 21 */     this.areaName = areaName;
/*    */   }
/*    */   
/*    */   public void add(ServerVO server) {
/* 25 */     String name = server.name;
/* 26 */     for (ServerVO s : this.areaServers.values()) {
/* 27 */       if (s.name.equals(name) && s.logicServerId != server.logicServerId) {
/* 28 */         s.name = String.valueOf(name) + s.logicServerId;
/* 29 */         server.name = String.valueOf(name) + server.logicServerId;
/*    */       } 
/*    */     } 
/* 32 */     this.areaServers.put(Integer.valueOf(server.logicServerId), server);
/*    */   }
/*    */   
/*    */   public void remove(int logicServerId) {
/* 36 */     this.areaServers.remove(Integer.valueOf(logicServerId));
/*    */   }
/*    */   
/*    */   public String toString() {
/* 40 */     return String.valueOf(this.appId) + ":" + this.areaId + "-" + this.areaName;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\login\vo\AreaVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */