/*    */ package com.wanniu.game.guild.guildFort.dao;
/*    */ 
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.GWorld;
/*    */ import com.wanniu.game.common.ConstsTR;
/*    */ import com.wanniu.redis.GameDao;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ public class GuildFortDao
/*    */ {
/*    */   public static void saveReports(List<GuildFortReportPO> list) {
/* 16 */     String str = JSONObject.toJSONString(list);
/* 17 */     GameDao.update(String.valueOf(GWorld.__SERVER_ID), ConstsTR.guildFortReportTR.value, str);
/*    */   }
/*    */   
/*    */   public static List<GuildFortReportPO> getReports() {
/* 21 */     String str = (String)GameDao.get(String.valueOf(GWorld.__SERVER_ID), ConstsTR.guildFortReportTR.value, String.class);
/* 22 */     List<GuildFortReportPO> list = null;
/* 23 */     if (!StringUtil.isEmpty(str)) {
/* 24 */       list = JSON.parseArray(str, GuildFortReportPO.class);
/*    */     } else {
/* 26 */       list = new ArrayList<>();
/*    */     } 
/*    */     
/* 29 */     return list;
/*    */   }
/*    */ 
/*    */   
/*    */   private static String getKey(int fortId) {
/* 34 */     return ConstsTR.guildFortTR.value + "/" + fortId;
/*    */   }
/*    */   
/*    */   public static void saveFort(GuildFortPO fort) {
/* 38 */     String key = getKey(fort.fortId);
/* 39 */     GameDao.update(String.valueOf(GWorld.__SERVER_ID), key, fort);
/*    */   }
/*    */   
/*    */   public static GuildFortPO getFort(int fortId) {
/* 43 */     String key = getKey(fortId);
/* 44 */     return (GuildFortPO)GameDao.get(String.valueOf(GWorld.__SERVER_ID), key, GuildFortPO.class);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guildFort\dao\GuildFortDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */