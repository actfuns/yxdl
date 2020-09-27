/*    */ package com.wanniu.game.request.role;
/*    */ 
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.wanniu.core.GGlobal;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.common.ConstsTR;
/*    */ import com.wanniu.game.daoyou.DaoYouCenter;
/*    */ import com.wanniu.game.guild.GuildService;
/*    */ import com.wanniu.game.player.PlayerDao;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.poes.PlayerPO;
/*    */ import com.wanniu.game.rank.RankCenter;
/*    */ import com.wanniu.redis.GameDao;
/*    */ import com.wanniu.redis.GlobalDao;
/*    */ import com.wanniu.redis.PlayerPOManager;
/*    */ import java.io.IOException;
/*    */ import pomelo.connector.RoleHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("connector.roleHandler.deletePlayerRequest")
/*    */ public class DeletePlayerHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 36 */     RoleHandler.DeletePlayerRequest req = RoleHandler.DeletePlayerRequest.parseFrom(this.pak.getRemaingBytes());
/* 37 */     String playerId = req.getC2SPlayerId();
/*    */     
/* 39 */     PlayerPO player = (PlayerPO)PlayerPOManager.findPO(ConstsTR.playerTR, playerId, PlayerPO.class);
/* 40 */     if (!player.uid.equals(this.pak.getUid())) {
/* 41 */       Out.warn(new Object[] { "玩家竟然尝试删除不是自己的角色 uid=", this.pak.getUid(), ",playerId=", playerId, ",name=", player.name });
/* 42 */       return new PomeloResponse()
/*    */         {
/*    */           protected void write() throws IOException {
/* 45 */             RoleHandler.DeletePlayerResponse.Builder res = RoleHandler.DeletePlayerResponse.newBuilder();
/* 46 */             res.setS2CCode(200);
/* 47 */             this.body.writeBytes(res.build().toByteArray());
/*    */           }
/*    */         };
/*    */     } 
/*    */     
/* 52 */     player.isDelete = 1;
/* 53 */     Out.info(new Object[] { "玩家删除角色 uid=", this.pak.getUid(), ",playerId=", playerId, ",name=", player.name });
/*    */     
/* 55 */     Integer count = (Integer)this.pak.getAttr(GGlobal.__KEY_ROLE_COUNT);
/* 56 */     if (count != null && count.intValue() > 0) {
/* 57 */       this.pak.setAttr(GGlobal.__KEY_ROLE_COUNT, Integer.valueOf(count.intValue() - 1));
/*    */     }
/*    */ 
/*    */     
/* 61 */     GuildService.delRole(playerId);
/*    */ 
/*    */     
/* 64 */     RankCenter.delRoleClear(playerId);
/*    */ 
/*    */     
/* 67 */     DaoYouCenter.getInstance().removeDaoYouMember(playerId);
/*    */     
/* 69 */     String s_players = GlobalDao.hget(String.valueOf(player.logicServerId), player.uid);
/* 70 */     if (StringUtil.isNotEmpty(s_players)) {
/* 71 */       JSONObject players = JSON.parseObject(s_players);
/* 72 */       players.remove(player.id);
/* 73 */       GlobalDao.hset(String.valueOf(player.logicServerId), player.uid, players.toJSONString());
/* 74 */       PlayerUtil.addLoginServer(player.uid, player.logicServerId, players.size());
/*    */     } 
/*    */     
/* 77 */     PlayerDao.freeName(player.name);
/* 78 */     GameDao.freeName(player.name);
/*    */     
/* 80 */     PlayerPOManager.clearOfflinePO(playerId);
/*    */     
/* 82 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 85 */           RoleHandler.DeletePlayerResponse.Builder res = RoleHandler.DeletePlayerResponse.newBuilder();
/* 86 */           res.setS2CCode(200);
/* 87 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\role\DeletePlayerHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */