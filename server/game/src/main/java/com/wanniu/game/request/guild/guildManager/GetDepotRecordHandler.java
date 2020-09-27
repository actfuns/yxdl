/*    */ package com.wanniu.game.request.guild.guildManager;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.guild.GuildCommonUtil;
/*    */ import com.wanniu.game.guild.RecordInfo;
/*    */ import com.wanniu.game.guild.guidDepot.GuildDepotCenter;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import pomelo.guild.GuildManagerHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("guild.guildManagerHandler.getDepotRecordRequest")
/*    */ public class GetDepotRecordHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 24 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 25 */     GuildManagerHandler.GetDepotRecordRequest req = GuildManagerHandler.GetDepotRecordRequest.parseFrom(this.pak.getRemaingBytes());
/* 26 */     final int page = req.getPage();
/* 27 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 30 */           GuildManagerHandler.GetDepotRecordResponse.Builder res = GuildManagerHandler.GetDepotRecordResponse.newBuilder();
/*    */           
/* 32 */           GuildDepotCenter depotManager = GuildDepotCenter.getInstance();
/* 33 */           if (null == player.getId() || null == depotManager) {
/* 34 */             res.setS2CCode(500);
/* 35 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 36 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 40 */           ArrayList<RecordInfo> recordList = depotManager.getDepotRecordByPlayerId(player.getId(), page);
/*    */           
/* 42 */           List<GuildManagerHandler.RecordInfo> retList = new ArrayList<>();
/* 43 */           for (int i = 0; i < recordList.size(); i++) {
/* 44 */             RecordInfo tmp = recordList.get(i);
/* 45 */             if (null != tmp) {
/*    */ 
/*    */ 
/*    */               
/* 49 */               GuildManagerHandler.RecordInfo.Builder guildMgrInfo = GuildManagerHandler.RecordInfo.newBuilder();
/* 50 */               guildMgrInfo.setRole1(GuildCommonUtil.toMgrRoleInfo(tmp.role1.pro, tmp.role1.name));
/* 51 */               guildMgrInfo.setRole2(GuildCommonUtil.toMgrRoleInfo(tmp.role2.pro, tmp.role2.name));
/* 52 */               guildMgrInfo.setResultNum(tmp.resultNum);
/* 53 */               guildMgrInfo.setResultStr(tmp.resultStr);
/* 54 */               guildMgrInfo.setTime(tmp.time);
/* 55 */               guildMgrInfo.setRecordType(tmp.recordType);
/* 56 */               guildMgrInfo.setItem(GuildCommonUtil.toMgrItemRecordInfo(tmp.item.qColor, tmp.item.name));
/* 57 */               retList.add(guildMgrInfo.build());
/*    */             } 
/*    */           } 
/* 60 */           res.setS2CCode(200);
/* 61 */           res.addAllS2CRecordList(retList);
/* 62 */           res.setS2CPage(page);
/* 63 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildManager\GetDepotRecordHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */