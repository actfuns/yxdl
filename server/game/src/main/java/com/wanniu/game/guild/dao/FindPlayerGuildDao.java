/*    */ package com.wanniu.game.guild.dao;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.common.ConstsTR;
/*    */ import com.wanniu.game.poes.PlayerGuildPO;
/*    */ import com.wanniu.redis.PlayerPOManager;
/*    */ 
/*    */ public class FindPlayerGuildDao {
/*    */   public static final PlayerGuildPO getPlayerGuildPOById(String playerId) {
/* 10 */     PlayerGuildPO redisPo = (PlayerGuildPO)PlayerPOManager.findPO(ConstsTR.playerGuildTR, playerId, PlayerGuildPO.class);
/* 11 */     if (null != redisPo) {
/* 12 */       return redisPo;
/*    */     }
/*    */     
/* 15 */     PlayerGuildPO po = new PlayerGuildPO();
/* 16 */     PlayerPOManager.put(ConstsTR.playerGuildTR, playerId, (GEntity)po);
/*    */     
/* 18 */     return po;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\dao\FindPlayerGuildDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */