/*    */ package com.wanniu.game.request.task;
/*    */ 
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import pomelo.area.TaskHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.taskHandler.cjPlayEndNotify")
/*    */ public class CjPlayEndNotifyHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 21 */     TaskHandler.CjPlayEndNotify req = TaskHandler.CjPlayEndNotify.parseFrom(this.pak.getRemaingBytes());
/* 22 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 23 */     String msg = req.getS2CMsg();
/*    */     
/* 25 */     CJBattleServerNotify notify = new CJBattleServerNotify();
/* 26 */     notify.playerId = player.getId();
/* 27 */     notify.msg = msg;
/*    */     
/* 29 */     player.getXmdsManager().notifyBattleServer(player.getInstanceId(), "CjPlayEndNotify", JSON.toJSONString(notify));
/* 30 */     return null;
/*    */   }
/*    */   
/*    */   public static final class CJBattleServerNotify {
/*    */     public String playerId;
/*    */     public String msg;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\task\CjPlayEndNotifyHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */