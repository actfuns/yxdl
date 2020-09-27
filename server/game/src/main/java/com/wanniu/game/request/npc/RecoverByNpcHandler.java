/*    */ package com.wanniu.game.request.npc;
/*    */ 
/*    */ import Xmds.CanTalkWithNpc;
/*    */ import Xmds.RefreshPlayerPropertyChange;
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.GWorld;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.NpcHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.npcHandler.recoverByNpcRequest")
/*    */ public class RecoverByNpcHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 25 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 26 */     NpcHandler.RecoverByNpcRequest msg = NpcHandler.RecoverByNpcRequest.parseFrom(this.pak.getRemaingBytes());
/* 27 */     GWorld.getInstance().ansycExec(() -> {
/*    */           int npcObjId = Integer.parseInt(msg.getNpcObjId());
/*    */           
/*    */           String res_str = player.getXmdsManager().canTalkWithNpc(player.getId(), npcObjId);
/*    */           
/*    */           CanTalkWithNpc npcResult = null;
/*    */           if (StringUtil.isNotEmpty(res_str)) {
/*    */             npcResult = (CanTalkWithNpc)JSON.parseObject(res_str, CanTalkWithNpc.class);
/*    */             Out.debug(new Object[] { "npcResult:", npcResult });
/*    */             if (npcResult.canTalk) {
/*    */               RefreshPlayerPropertyChange refreshChange = new RefreshPlayerPropertyChange();
/*    */               refreshChange.changeType = Const.PropertyChangeType.NPC.value;
/*    */               refreshChange.valueType = 0;
/*    */               refreshChange.value = 0;
/*    */               refreshChange.duration = 0;
/*    */               refreshChange.timestamp = 0L;
/*    */               player.refreshPlayerPropertyChange(refreshChange);
/*    */             } 
/*    */           } 
/*    */         });
/* 47 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 50 */           NpcHandler.RecoverByNpcResponse.Builder res = NpcHandler.RecoverByNpcResponse.newBuilder();
/* 51 */           res.setS2CCode(200);
/* 52 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\npc\RecoverByNpcHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */