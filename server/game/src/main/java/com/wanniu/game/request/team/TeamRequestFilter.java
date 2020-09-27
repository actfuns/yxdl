/*    */ package com.wanniu.game.request.team;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.area.Area;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.player.GlobalConfig;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class TeamRequestFilter
/*    */   extends PomeloRequest
/*    */ {
/*    */   protected PomeloResponse checkRemote(WNPlayer player) {
/* 19 */     if (player.isRomote()) {
/* 20 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_ACROSS"));
/*    */     }
/* 22 */     return null;
/*    */   }
/*    */   
/*    */   protected PomeloResponse checkOpen(WNPlayer player) {
/* 26 */     Area area = player.getArea();
/* 27 */     if (area == null || !area.isOpenJoinTeam()) {
/* 28 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_BATTLE_ERR"));
/*    */     }
/* 30 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public PomeloResponse request() throws Exception {
/* 35 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 36 */     if (player.getLevel() < GlobalConfig.Team_Min_Level) {
/* 37 */       return (PomeloResponse)new ErrorResponse(LangService.format("TEAM_LV_LESS", new Object[] { Integer.valueOf(GlobalConfig.Team_Min_Level) }));
/*    */     }
/* 39 */     PomeloResponse res = checkRemote(player);
/* 40 */     if (res != null) {
/* 41 */       return res;
/*    */     }
/* 43 */     res = checkOpen(player);
/* 44 */     if (res != null) {
/* 45 */       return res;
/*    */     }
/* 47 */     return request(player);
/*    */   }
/*    */   
/*    */   public abstract PomeloResponse request(WNPlayer paramWNPlayer) throws Exception;
/*    */   
/*    */   public short getType() {
/* 53 */     return 770;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\team\TeamRequestFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */