/*    */ package com.wanniu.game.groovy;
/*    */ 
/*    */ import com.wanniu.core.groovy.IGameGroovy;
/*    */ import com.wanniu.game.player.GlobalConfig;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ 
/*    */ public class GroovyExcutor implements IGameGroovy {
/*    */   public String execute() {
/* 10 */     String id = "87ce937c-1b8d-4181-bbfa-06ad52dca268";
/* 11 */     WNPlayer player = PlayerUtil.getOnlinePlayer(id);
/* 12 */     if (player == null) {
/* 13 */       return "不在线";
/*    */     }
/* 15 */     player.baseDataManager.upgrade(Math.min(GlobalConfig.Role_LevelLimit, 39), 0L);
/* 16 */     return "OK";
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\groovy\GroovyExcutor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */