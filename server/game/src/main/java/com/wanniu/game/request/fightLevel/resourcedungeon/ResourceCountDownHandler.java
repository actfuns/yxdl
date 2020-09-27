/*    */ package com.wanniu.game.request.fightLevel.resourcedungeon;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.area.Area;
/*    */ import com.wanniu.game.area.ResourceDungeon;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.request.fightLevel.FightLevelLine;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.ResourceDungeonHandler;
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
/*    */ @GClientEvent("area.resourceDungeonHandler.resourceCountDownRequest")
/*    */ public class ResourceCountDownHandler
/*    */   extends FightLevelLine
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 29 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 32 */           ResourceDungeonHandler.ResourceCountDownResponse.Builder res = ResourceDungeonHandler.ResourceCountDownResponse.newBuilder();
/*    */           
/* 34 */           Area area = player.getArea();
/* 35 */           if (area.getSceneType() != Const.SCENE_TYPE.RESOURCE_DUNGEON.getValue()) {
/* 36 */             res.setS2CCode(500);
/* 37 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/* 38 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/*    */           
/* 43 */           res.setCountDown(300000L + (Const.Time.Second.getValue() * 15) + ((ResourceDungeon)area).createTime - System.currentTimeMillis());
/*    */           
/* 45 */           res.setS2CCode(200);
/* 46 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\fightLevel\resourcedungeon\ResourceCountDownHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */