/*    */ package com.wanniu.game.request.guild.guildManager;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.guild.GuildCommonUtil;
/*    */ import com.wanniu.game.guild.RecordInfo;
/*    */ import com.wanniu.game.guild.guildBless.GuildBlessCenter;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import io.netty.util.internal.StringUtil;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import pomelo.guild.GuildManagerHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("guild.guildManagerHandler.getBlessRecordRequest")
/*    */ public class GetBlessRecordHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 25 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 26 */     GuildManagerHandler.GetBlessRecordRequest req = GuildManagerHandler.GetBlessRecordRequest.parseFrom(this.pak.getRemaingBytes());
/* 27 */     final int page = req.getPage();
/* 28 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 31 */           GuildManagerHandler.GetBlessRecordResponse.Builder res = GuildManagerHandler.GetBlessRecordResponse.newBuilder();
/*    */           
/* 33 */           GuildBlessCenter blessManager = GuildBlessCenter.getInstance();
/* 34 */           if (StringUtil.isNullOrEmpty(player.getId()) || null == blessManager) {
/* 35 */             res.setS2CCode(500);
/* 36 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 37 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 41 */           List<RecordInfo> recordList = blessManager.getBlessRecordByPlayerId(player.getId(), page);
/* 42 */           List<GuildManagerHandler.RecordInfo> managerRecordList = new ArrayList<>();
/* 43 */           for (int i = 0; i < recordList.size(); i++) {
/* 44 */             RecordInfo tmpInfo = recordList.get(i);
/* 45 */             GuildManagerHandler.RecordInfo.Builder rInfo = GuildManagerHandler.RecordInfo.newBuilder();
/* 46 */             GuildManagerHandler.RoleInfo role1 = GuildCommonUtil.toGuildMgrHandler(((RecordInfo)recordList.get(i)).role1);
/* 47 */             GuildManagerHandler.RoleInfo role2 = GuildCommonUtil.toGuildMgrHandler(((RecordInfo)recordList.get(i)).role2);
/* 48 */             if (null != role1) {
/* 49 */               rInfo.setRole1(role1);
/*    */             }
/*    */             
/* 52 */             if (null != role2) {
/* 53 */               rInfo.setRole2(role2);
/*    */             }
/*    */             
/* 56 */             rInfo.setResultNum(tmpInfo.resultNum);
/* 57 */             rInfo.setResultStr(tmpInfo.resultStr);
/* 58 */             rInfo.setTime(tmpInfo.time);
/* 59 */             rInfo.setRecordType(tmpInfo.recordType);
/* 60 */             GuildManagerHandler.ItemRecordInfo.Builder itemRecord = GuildManagerHandler.ItemRecordInfo.newBuilder();
/* 61 */             itemRecord.setQColor(tmpInfo.item.qColor);
/* 62 */             itemRecord.setName(tmpInfo.item.name);
/* 63 */             rInfo.setItem(itemRecord.build());
/* 64 */             managerRecordList.add(rInfo.build());
/*    */           } 
/* 66 */           res.setS2CCode(200);
/* 67 */           res.addAllS2CRecordList(managerRecordList);
/* 68 */           res.setS2CPage(page);
/* 69 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildManager\GetBlessRecordHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */