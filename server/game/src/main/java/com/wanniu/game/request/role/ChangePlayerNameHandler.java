/*    */ package com.wanniu.game.request.role;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.player.PlayerDao;
/*    */ import com.wanniu.game.player.PlayerService;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.util.BlackWordUtil;
/*    */ import com.wanniu.redis.GameDao;
/*    */ import java.io.IOException;
/*    */ import pomelo.connector.RoleHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("connector.roleHandler.changePlayerNameRequest")
/*    */ public class ChangePlayerNameHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 30 */     RoleHandler.ChangePlayerNameRequest req = RoleHandler.ChangePlayerNameRequest.parseFrom(this.pak.getRemaingBytes());
/* 31 */     String uid = this.pak.getUid();
/* 32 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 33 */     final String name = req.getC2SName();
/* 34 */     if (StringUtil.isEmpty(uid)) {
/* 35 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PLAYER_UID_NULL"));
/*    */     }
/*    */     
/* 38 */     if (StringUtil.isEmpty(name)) {
/* 39 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PLAYER_NAME_NULL"));
/*    */     }
/*    */     
/* 42 */     if (name.length() > 6) {
/* 43 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PLAYER_NAME_LONG"));
/*    */     }
/*    */ 
/*    */     
/* 47 */     if (BlackWordUtil.isIncludeBlackString(name)) {
/* 48 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PLAYER_ID_SENSITIVE"));
/*    */     }
/*    */     
/* 51 */     if (BlackWordUtil.isIncludeSpecialChar(name)) {
/* 52 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PLAYER_ID_CHARACTER"));
/*    */     }
/* 54 */     if (player != null) {
/* 55 */       int hasCount = player.bag.findItemNumByCode(Const.ITEM_CODE.Changename.value);
/*    */       
/* 57 */       if (hasCount <= 0) {
/* 58 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("NOT_ENOUGH_ITEM"));
/*    */       }
/*    */     } 
/*    */     
/* 62 */     boolean isPutSuccess = PlayerDao.putName(name, player.getId());
/* 63 */     if (!isPutSuccess) {
/* 64 */       Out.warn(new Object[] { "发现有玩家重名,改名失败,要改的名字为:", name, "playerId=", player.getId() });
/* 65 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PLAYER_NAME_HAS_USED"));
/*    */     } 
/*    */ 
/*    */     
/* 69 */     if (!GameDao.putName(name, player.getId())) {
/* 70 */       Out.warn(new Object[] { "建立本服角色列表时异常啦!", name });
/*    */     }
/*    */     
/* 73 */     String oldName = player.getName();
/* 74 */     PlayerDao.freeName(oldName);
/* 75 */     GameDao.freeName(oldName);
/*    */     
/* 77 */     player.player.name = name;
/* 78 */     player.bag.discardItem(Const.ITEM_CODE.Changename.value, 1, Const.GOODS_CHANGE_TYPE.use, null, false, false);
/* 79 */     PlayerService.getInstance().afterPlayerChangeName(player);
/*    */     
/* 81 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 84 */           RoleHandler.ChangePlayerNameResponse.Builder res = RoleHandler.ChangePlayerNameResponse.newBuilder();
/* 85 */           res.setS2CCode(200);
/* 86 */           res.setS2CName(name);
/* 87 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\role\ChangePlayerNameHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */