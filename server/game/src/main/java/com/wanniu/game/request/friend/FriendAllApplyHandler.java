/*    */ package com.wanniu.game.request.friend;
/*    */ 
/*    */ import com.google.protobuf.ProtocolStringList;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.friend.FriendManager;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import java.util.TreeMap;
/*    */ import pomelo.area.FriendHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.friendHandler.friendAllApplyRequest")
/*    */ public class FriendAllApplyHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 22 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 23 */     FriendHandler.FriendAllApplyRequest msg = FriendHandler.FriendAllApplyRequest.parseFrom(this.pak.getRemaingBytes());
/* 24 */     final ProtocolStringList toPlayerIds = msg.getC2SToPlayerIdsList();
/* 25 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 28 */           FriendHandler.FriendAllApplyResponse.Builder res = FriendHandler.FriendAllApplyResponse.newBuilder();
/* 29 */           FriendManager friendManager = player.getFriendManager();
/* 30 */           TreeMap<String, Object> rtData = friendManager.friendAllApply(toPlayerIds, player);
/* 31 */           boolean result = ((Boolean)rtData.get("result")).booleanValue();
/* 32 */           String info = (String)rtData.get("info");
/* 33 */           if (result) {
/* 34 */             player.getPlayerTasks().dealTaskEvent(Const.TaskType.ADD_FRIEND, toPlayerIds.size());
/* 35 */             res.setS2CCode(200);
/* 36 */             res.setS2CMsg(info);
/*    */           } else {
/*    */             
/* 39 */             res.setS2CCode(500);
/* 40 */             res.setS2CMsg(info);
/*    */           } 
/* 42 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\friend\FriendAllApplyHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */