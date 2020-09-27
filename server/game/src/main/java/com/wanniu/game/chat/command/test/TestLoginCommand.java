/*    */ package com.wanniu.game.chat.command.test;
/*    */ 
/*    */ import com.google.protobuf.GeneratedMessage;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.chat.command.AbsCommand;
/*    */ import com.wanniu.game.chat.command.Command;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.ConstsTR;
/*    */ import com.wanniu.game.common.msg.MessagePush;
/*    */ import com.wanniu.game.player.PlayerDao;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.PlayerPO;
/*    */ import com.wanniu.redis.GameDao;
/*    */ import com.wanniu.redis.PlayerPOManager;
/*    */ import pomelo.area.PlayerHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Command({"@gm test login"})
/*    */ public class TestLoginCommand
/*    */   extends AbsCommand
/*    */ {
/*    */   public String help() {
/* 41 */     return "@gm test login <name> 测试登录任何角色";
/*    */   }
/*    */ 
/*    */   
/*    */   protected String exec(WNPlayer player, String... args) {
/* 46 */     String name = args[3];
/* 47 */     String id = GameDao.getIdByName(name);
/* 48 */     if (!StringUtil.isEmpty(id)) {
/* 49 */       Out.info(new Object[] { "拉取目标角色 name=", name, ",id=", id });
/* 50 */       PlayerPO baseData = (PlayerPO)PlayerPOManager.findPO(ConstsTR.playerTR, id, PlayerPO.class);
/* 51 */       PlayerDao.insertPlayerId(baseData, player.allBlobData);
/*    */ 
/*    */       
/* 54 */       PlayerHandler.KickPlayerPush.Builder data = PlayerHandler.KickPlayerPush.newBuilder();
/* 55 */       data.setS2CReasonType(Const.KickReason.GM_KICK.value);
/*    */       try {
/* 57 */         player.getSession().write((new MessagePush("area.playerPush.kickPlayerPush", (GeneratedMessage)data.build())).getContent()).await(2000L);
/* 58 */       } catch (InterruptedException e) {
/* 59 */         e.printStackTrace();
/*    */       } 
/*    */     } else {
/* 62 */       return "目标角色名称未找到...";
/*    */     } 
/* 64 */     return "OK";
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\chat\command\test\TestLoginCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */