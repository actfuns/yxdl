/*    */ package com.wanniu.game.request.equip;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.equip.EquipUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.PlayerBasePO;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.EquipHandler;
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
/*    */ @GClientEvent("area.equipHandler.equipPreStrengthenRequest")
/*    */ public class EquipPreStrengthenHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 27 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 29 */     EquipHandler.EquipPreStrengthenRequest req = EquipHandler.EquipPreStrengthenRequest.parseFrom(this.pak.getRemaingBytes());
/* 30 */     final int pos = req.getC2SPos();
/*    */     
/* 32 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 35 */           EquipHandler.EquipPreStrengthenResponse.Builder res = EquipHandler.EquipPreStrengthenResponse.newBuilder();
/*    */           
/* 37 */           PlayerBasePO.EquipStrengthPos strengthPos = (PlayerBasePO.EquipStrengthPos)player.equipManager.strengthPos.get(Integer.valueOf(pos));
/* 38 */           if (strengthPos == null) {
/* 39 */             res.setS2CCode(500);
/* 40 */             res.setS2CMsg(LangService.getValue("EQUIP_POS_NOT_EXIST"));
/* 41 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 44 */           res.setS2CStrengthenData(EquipUtil.getStrengthInfo(player, pos));
/*    */           
/* 46 */           res.setS2CCode(200);
/* 47 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\equip\EquipPreStrengthenHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */