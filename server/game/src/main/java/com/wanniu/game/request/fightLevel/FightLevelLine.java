/*    */ package com.wanniu.game.request.fightLevel;
/*    */ 
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ 
/*    */ public abstract class FightLevelLine
/*    */   extends PomeloRequest {
/*    */   public PomeloResponse request() throws Exception {
/* 10 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 11 */     return request(player);
/*    */   }
/*    */   
/*    */   public abstract PomeloResponse request(WNPlayer paramWNPlayer) throws Exception;
/*    */   
/*    */   public short getType() {
/* 17 */     return 1025;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\fightLevel\FightLevelLine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */