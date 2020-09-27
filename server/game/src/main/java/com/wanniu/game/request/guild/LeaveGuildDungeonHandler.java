/*    */ package com.wanniu.game.request.guild;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.guild.guildDungeon.GuildDungeon;
/*    */ import com.wanniu.game.guild.guildDungeon.GuildDungeonResult;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.GuildHandler;
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildHandler.leaveGuildDungeonRequest")
/*    */ public class LeaveGuildDungeonHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 20 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 22 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 25 */           GuildHandler.LeaveGuildDungeonResponse.Builder res = GuildHandler.LeaveGuildDungeonResponse.newBuilder();
/*    */           
/* 27 */           GuildDungeon area = (GuildDungeon)player.getArea();
/* 28 */           if (area.sceneType != Const.SCENE_TYPE.GUILD_DUNGEON.getValue()) {
/* 29 */             res.setS2CCode(500);
/* 30 */             res.setS2CMsg(LangService.getValue("AREA_ID_NULL"));
/* 31 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 35 */           GuildDungeonResult data = player.guildManager.leaveDungeon(player);
/*    */           
/* 37 */           if (data.result) {
/* 38 */             res.setS2CCode(200);
/* 39 */             res.setS2CMsg(data.info);
/* 40 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 43 */           res.setS2CCode(500);
/* 44 */           res.setS2CMsg(data.info);
/* 45 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\LeaveGuildDungeonHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */