/*    */ package com.wanniu.game.request.player;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.game.data.ext.UpLevelExpExt;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.PlayerHandler;
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.playerHandler.getClassEventConditionRequest")
/*    */ public class GetClassEventConditionHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 18 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException
/*    */         {
/* 22 */           WNPlayer player = (WNPlayer)GetClassEventConditionHandler.this.pak.getPlayer();
/*    */           
/* 24 */           PlayerHandler.GetClassEventConditionResponse.Builder res = PlayerHandler.GetClassEventConditionResponse.newBuilder();
/* 25 */           res.setS2CCode(200);
/* 26 */           UpLevelExpExt prop_next = player.baseDataManager.getNextUpLevelExp();
/* 27 */           String flag = player.baseDataManager.checkClassEvent(prop_next);
/* 28 */           if (flag == null) {
/* 29 */             res.setS2CFlag(1);
/*    */           } else {
/* 31 */             res.setS2CFlag(0);
/*    */           } 
/* 33 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\player\GetClassEventConditionHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */