/*    */ package com.wanniu.game.guild.dao;
/*    */ 
/*    */ import com.wanniu.core.db.GCache;
/*    */ import com.wanniu.game.common.ConstsTR;
/*    */ import com.wanniu.game.common.Utils;
/*    */ import com.wanniu.game.guild.GuildCommonUtil;
/*    */ import com.wanniu.game.guild.guildImpeach.GuildImpeachData;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class GuildImpeachDao
/*    */ {
/*    */   public static GuildImpeachData getGuildImpeach(String id) {
/* 13 */     return (GuildImpeachData)GuildCommonUtil.hget(ConstsTR.guildImpeachTR, id, GuildImpeachData.class);
/*    */   }
/*    */   
/*    */   public static ArrayList<GuildImpeachData> getImpeachList() {
/* 17 */     return GuildCommonUtil.hgetAll(ConstsTR.guildImpeachTR, GuildImpeachData.class);
/*    */   }
/*    */   
/*    */   public static void updateGuildImpeach(GuildImpeachData data) {
/* 21 */     updateImpeachToRedis(data);
/*    */   }
/*    */   
/*    */   public void removeGuildImpeach(String id) {
/* 25 */     GuildImpeachData data = getGuildImpeach(id);
/* 26 */     if (null != data) {
/* 27 */       removeGuildImpeachByData(data);
/*    */     }
/*    */   }
/*    */   
/*    */   public static void removeGuildImpeachByData(GuildImpeachData data) {
/* 32 */     removeImpeachToRedis(data);
/*    */   }
/*    */   
/*    */   public static void updateImpeachToRedis(GuildImpeachData data) {
/* 36 */     GCache.hset(ConstsTR.guildImpeachTR.value, data.id, Utils.serialize(data));
/*    */   }
/*    */   
/*    */   public static void removeImpeachToRedis(GuildImpeachData data) {
/* 40 */     GCache.hremove(ConstsTR.guildImpeachTR.value, data.id);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\dao\GuildImpeachDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */