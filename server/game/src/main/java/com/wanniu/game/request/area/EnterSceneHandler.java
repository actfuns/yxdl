/*    */ package com.wanniu.game.request.area;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.area.Area;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import org.apache.commons.lang3.StringUtils;
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
/*    */ @GClientEvent("area.playerHandler.enterSceneRequest")
/*    */ public class EnterSceneHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 30 */     PlayerHandler.EnterSceneRequest rquest = PlayerHandler.EnterSceneRequest.parseFrom(this.pak.getRemaingBytes());
/* 31 */     String instanceId = rquest.getC2SInstanceId();
/*    */     
/* 33 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 35 */     Area area = player.getArea();
/*    */ 
/*    */     
/* 38 */     if (StringUtils.isNotEmpty(instanceId) && !area.instanceId.equals(instanceId)) {
/* 39 */       if (StringUtils.isNotEmpty(instanceId)) {
/* 40 */         Out.warn(new Object[] { "连续切图吗？playerId=", player.getId(), ",name=", player.getName(), ",area.instanceId=", area.instanceId, ",C2SInstanceId=", instanceId });
/*    */       }
/* 42 */       return (PomeloResponse)new ErrorResponse("");
/*    */     } 
/*    */     
/* 45 */     area.playerEnterRequest(player);
/*    */     
/* 47 */     area.onPlayerEntered(player);
/*    */     
/* 49 */     player.onEndEnterScene();
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
/* 64 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 67 */           PlayerHandler.EnterSceneResponse.Builder res = PlayerHandler.EnterSceneResponse.newBuilder();
/* 68 */           res.setS2CCode(200);
/* 69 */           res.setS2CInstanceId(player.getInstanceId());
/* 70 */           res.setS2CAreaIndex(player.getLineIndex());
/* 71 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   public short getType() {
/* 77 */     return 1282;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\area\EnterSceneHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */