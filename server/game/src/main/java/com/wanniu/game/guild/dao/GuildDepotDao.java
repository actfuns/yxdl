/*    */ package com.wanniu.game.guild.dao;
/*    */ 
/*    */ import com.wanniu.core.db.GCache;
/*    */ import com.wanniu.game.common.ConstsTR;
/*    */ import com.wanniu.game.common.Utils;
/*    */ import com.wanniu.game.guild.GuildCommonUtil;
/*    */ import com.wanniu.game.poes.GuildDepotPO;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GuildDepotDao
/*    */ {
/*    */   public static GuildDepotPO getDepot(String id) {
/* 17 */     return (GuildDepotPO)GuildCommonUtil.hget(ConstsTR.guildDepotTR, id, GuildDepotPO.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static ArrayList<GuildDepotPO> getDepotList() {
/* 22 */     return GuildCommonUtil.hgetAll(ConstsTR.guildDepotTR, GuildDepotPO.class);
/*    */   }
/*    */   
/*    */   public static void updateDepot(GuildDepotPO data) {
/* 26 */     GCache.hset(ConstsTR.guildDepotTR.value, data.id, Utils.serialize(data));
/*    */   }
/*    */   
/*    */   public static void removeDepotToRedis(GuildDepotPO data) {
/* 30 */     GCache.hremove(ConstsTR.guildDepotTR.value, data.id);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\dao\GuildDepotDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */