/*    */ package com.wanniu.game.request.fightLevel.illusion;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.area.AreaUtil;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.SectionCO;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.request.fightLevel.FightLevelLine;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.FightLevelHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.fightLevelHandler.enterLllsionRequest")
/*    */ public class EnterIllsionHandler
/*    */   extends FightLevelLine
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 29 */     FightLevelHandler.EnterLllsionRequest req = FightLevelHandler.EnterLllsionRequest.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 31 */     int lllusionId = req.getC2SId();
/* 32 */     Out.debug(new Object[] { getClass().getName(), " : ", Integer.valueOf(lllusionId) });
/*    */     
/* 34 */     final SectionCO secionCO = (SectionCO)GameData.Sections.get(Integer.valueOf(lllusionId));
/*    */     
/* 36 */     if (secionCO == null || player.getLevel() < secionCO.minLv) {
/* 37 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*    */     }
/*    */     
/* 40 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 43 */           FightLevelHandler.EnterLllsionResponse.Builder res = FightLevelHandler.EnterLllsionResponse.newBuilder();
/*    */           
/* 45 */           AreaUtil.enterArea(player, secionCO.dungeonID);
/*    */           
/* 47 */           res.setS2CCode(200);
/* 48 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\fightLevel\illusion\EnterIllsionHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */