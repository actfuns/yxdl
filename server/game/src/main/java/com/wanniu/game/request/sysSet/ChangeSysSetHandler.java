/*    */ package com.wanniu.game.request.sysSet;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.SysSetHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.sysSetHandler.changeSysSetRequest")
/*    */ public class ChangeSysSetHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 19 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 20 */     if (player == null) {
/* 21 */       return new PomeloResponse()
/*    */         {
/*    */           protected void write() throws IOException {
/* 24 */             SysSetHandler.ChangeSysSetResponse.Builder res = SysSetHandler.ChangeSysSetResponse.newBuilder();
/* 25 */             res.setS2CCode(500);
/* 26 */             this.body.writeBytes(res.build().toByteArray());
/*    */           }
/*    */         };
/*    */     }
/* 30 */     SysSetHandler.ChangeSysSetRequest req = SysSetHandler.ChangeSysSetRequest.parseFrom(this.pak.getRemaingBytes());
/* 31 */     SysSetHandler.SetData setData = req.getC2SSetData();
/* 32 */     player.sysSetManager.changeSet(setData);
/* 33 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 36 */           SysSetHandler.ChangeSysSetResponse.Builder res = SysSetHandler.ChangeSysSetResponse.newBuilder();
/* 37 */           res.setS2CCode(200);
/* 38 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\sysSet\ChangeSysSetHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */