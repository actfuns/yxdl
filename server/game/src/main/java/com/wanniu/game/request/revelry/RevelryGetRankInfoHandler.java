/*     */ package com.wanniu.game.request.revelry;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.common.msg.ErrorResponse;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.RevelryCO;
/*     */ import com.wanniu.game.data.RevelryConfigCO;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.rank.RankType;
/*     */ import com.wanniu.game.rank.SimpleRankData;
/*     */ import com.wanniu.game.revelry.RevelryManager;
/*     */ import java.io.IOException;
/*     */ import java.time.Duration;
/*     */ import java.time.LocalDateTime;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import pomelo.revelry.ActivityRevelryHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @GClientEvent("revelry.activityRevelryHandler.revelryGetRankInfoRequest")
/*     */ public class RevelryGetRankInfoHandler
/*     */   extends PomeloRequest
/*     */ {
/*     */   public PomeloResponse request() throws Exception {
/*  40 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*     */     
/*  42 */     ActivityRevelryHandler.RevelryGetRankInfoRequest req = ActivityRevelryHandler.RevelryGetRankInfoRequest.parseFrom(this.pak.getRemaingBytes());
/*     */     
/*  44 */     final RevelryCO template = (RevelryCO)GameData.Revelrys.get(req.getId());
/*  45 */     if (template == null) {
/*  46 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*     */     }
/*     */     
/*  49 */     final List<RevelryConfigCO> configs = GameData.findRevelryConfigs(v -> template.tabID.equals(v.type));
/*     */     
/*  51 */     int maxRank = 1;
/*  52 */     for (RevelryConfigCO co : configs) {
/*  53 */       if (co.parameter1 == co.parameter2 && co.parameter1 > maxRank) {
/*  54 */         maxRank = co.parameter1;
/*     */       }
/*     */     } 
/*     */     
/*  58 */     final LocalDateTime now = LocalDateTime.now();
/*  59 */     final LocalDateTime endTime = GWorld.OPEN_SERVER_DATE.plusDays(template.endDays1).atTime(0, 0, 0, 0);
/*  60 */     final boolean isGameOver = now.isAfter(endTime);
/*     */     
/*  62 */     final RankType rankType = RevelryManager.getInstance().toRankType(template.activityKey);
/*  63 */     final Map<Integer, SimpleRankData> rankMap = rankType.getHandler().getSimpleRankData(isGameOver, template.tabID, 0, maxRank);
/*     */     
/*  65 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/*  68 */           ActivityRevelryHandler.RevelryGetRankInfoResponse.Builder res = ActivityRevelryHandler.RevelryGetRankInfoResponse.newBuilder();
/*  69 */           res.setRankKey(template.activityKey);
/*     */           
/*  71 */           ActivityRevelryHandler.RevelryRankInfo.Builder selfInfo = null;
/*  72 */           int selfRank = 0;
/*     */           
/*  74 */           for (RevelryConfigCO co : configs) {
/*  75 */             ActivityRevelryHandler.RevelryConfigInfo.Builder info = ActivityRevelryHandler.RevelryConfigInfo.newBuilder();
/*  76 */             info.setMinRank(co.parameter1);
/*  77 */             info.setMaxRank(co.parameter2);
/*     */             
/*  79 */             buildItem(info, co.item1code, co.num1);
/*  80 */             buildItem(info, co.item2code, co.num2);
/*  81 */             buildItem(info, co.item3code, co.num3);
/*  82 */             buildItem(info, co.item4code, co.num4);
/*     */ 
/*     */             
/*  85 */             if (co.parameter1 == co.parameter2) {
/*  86 */               SimpleRankData rankData = (SimpleRankData)rankMap.get(Integer.valueOf(co.parameter1));
/*  87 */               if (rankData != null) {
/*  88 */                 ActivityRevelryHandler.RevelryRankInfo.Builder playerInfo = ActivityRevelryHandler.RevelryRankInfo.newBuilder();
/*     */                 
/*  90 */                 rankType.getHandler().buildRevelryRankInfo(playerInfo, rankData);
/*  91 */                 info.setPlayer(playerInfo);
/*     */                 
/*  93 */                 if (rankData.getId().equals(player.getId())) {
/*  94 */                   selfInfo = playerInfo;
/*  95 */                   selfRank = rankData.getRank();
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */             
/* 100 */             res.addConfig(info);
/*     */           } 
/*     */ 
/*     */           
/* 104 */           if (selfInfo == null) {
/* 105 */             SimpleRankData rankData = rankType.getHandler().getSelfRankInfo(isGameOver, template.tabID, player);
/* 106 */             ActivityRevelryHandler.RevelryRankInfo.Builder playerInfo = ActivityRevelryHandler.RevelryRankInfo.newBuilder();
/* 107 */             rankType.getHandler().buildRevelryRankInfo(playerInfo, rankData);
/* 108 */             selfInfo = playerInfo;
/* 109 */             selfRank = rankData.getRank();
/*     */           } 
/*     */           
/* 112 */           res.setSelf(selfInfo);
/* 113 */           res.setSelfRank(selfRank);
/*     */           
/* 115 */           res.setTitle(template.icon);
/*     */           
/* 117 */           if (isGameOver) {
/* 118 */             res.setTimeleft(0);
/*     */           } else {
/* 120 */             res.setTimeleft((int)Duration.between(now, endTime).getSeconds());
/*     */           } 
/* 122 */           res.setS2CCode(200);
/* 123 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */         
/*     */         private void buildItem(ActivityRevelryHandler.RevelryConfigInfo.Builder info, String itemcode, int num) {
/* 127 */           if (StringUtils.isNotEmpty(itemcode)) {
/* 128 */             ActivityRevelryHandler.RevelryAwardInfo.Builder item = ActivityRevelryHandler.RevelryAwardInfo.newBuilder();
/* 129 */             item.setItemcode(itemcode);
/* 130 */             item.setItemcount(num);
/* 131 */             info.addAward(item);
/*     */           } 
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\revelry\RevelryGetRankInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */