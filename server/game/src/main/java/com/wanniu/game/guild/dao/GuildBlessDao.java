/*    */ package com.wanniu.game.guild.dao;
/*    */ 
/*    */ import com.wanniu.core.db.GCache;
/*    */ import com.wanniu.game.common.ConstsTR;
/*    */ import com.wanniu.game.common.Utils;
/*    */ import com.wanniu.game.guild.GuildCommonUtil;
/*    */ import com.wanniu.game.guild.po.GuildBlessPO;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ public class GuildBlessDao
/*    */ {
/*    */   public static ArrayList<GuildBlessPO> getGuildBlessList() {
/* 14 */     return GuildCommonUtil.hgetAll(ConstsTR.guildBlessTR, GuildBlessPO.class);
/*    */   }
/*    */   
/*    */   public static void updateGuildBless(GuildBlessPO data) {
/* 18 */     updateBlessToRedis(data);
/*    */   }
/*    */   
/*    */   public static void updateBlessToRedis(GuildBlessPO data) {
/* 22 */     GCache.hset(ConstsTR.guildBlessTR.value, data.id, Utils.serialize(data));
/*    */   }
/*    */   
/*    */   public static void removeBlessToRedis(GuildBlessPO data) {
/* 26 */     GCache.hremove(ConstsTR.guildBlessTR.value, data.id);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\dao\GuildBlessDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */