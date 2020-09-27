/*     */ package com.wanniu.game.request.farm;
/*     */ 
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.game.data.MiscCO;
/*     */ import com.wanniu.game.farm.FarmMgr;
/*     */ import com.wanniu.game.item.ItemConfig;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.FarmPO;
/*     */ import java.io.IOException;
/*     */ import java.util.Date;
/*     */ import pomelo.farm.Farm;
/*     */ import pomelo.farm.FarmHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @GClientEvent("farm.farmHandler.myFarmInfoRequest")
/*     */ public class MyFarmInfoHandler
/*     */   extends PomeloRequest
/*     */ {
/*     */   public PomeloResponse request() throws Exception {
/*  26 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*  27 */     FarmHandler.MyFarmInfoRequest msg = FarmHandler.MyFarmInfoRequest.parseFrom(this.pak.getRemaingBytes());
/*  28 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/*  31 */           FarmHandler.MyFarmInfoResponse.Builder res = FarmHandler.MyFarmInfoResponse.newBuilder();
/*  32 */           FarmMgr farmMgr = player.getFarmMgr();
/*  33 */           FarmPO farmPO = farmMgr.myPO;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  39 */           Farm.PlayerInfo.Builder playerInfoBuilder = Farm.PlayerInfo.newBuilder();
/*     */ 
/*     */           
/*  42 */           playerInfoBuilder.setPlayerId(player.getId());
/*     */ 
/*     */ 
/*     */           
/*  46 */           Farm.PlayerSummary.Builder playerSummaryBuilder = Farm.PlayerSummary.newBuilder();
/*  47 */           playerSummaryBuilder.setPlayerId(player.getId());
/*  48 */           playerSummaryBuilder.setRoleName(player.getName());
/*  49 */           playerSummaryBuilder.setLv(player.getLevel());
/*  50 */           playerSummaryBuilder.setFarmLv(farmPO.lv);
/*  51 */           playerSummaryBuilder.setCanSow(farmMgr.getPlayerCultivatable(player.getId()));
/*  52 */           playerSummaryBuilder.setCanSteal(farmMgr.getPlayerStealable(player.getId()));
/*  53 */           playerInfoBuilder.setPlayerSummary(playerSummaryBuilder.build());
/*     */ 
/*     */           
/*  56 */           for (FarmMgr.Block farmMgrBlock : farmPO.blockMap.values()) {
/*  57 */             Farm.Block.Builder blockBuilder = Farm.Block.newBuilder();
/*  58 */             blockBuilder.setBlockId(farmMgrBlock.blockId);
/*  59 */             blockBuilder.setBlockState(farmMgrBlock.blockState.value);
/*  60 */             blockBuilder.setSeedCode(farmMgrBlock.seedCode);
/*  61 */             blockBuilder.setSeedState(farmMgrBlock.seedState.value);
/*  62 */             blockBuilder.setCultivateType(farmMgrBlock.cultivateType.value);
/*  63 */             blockBuilder.setHarvestTime(FarmMgr.evaluateHarvestTime(farmPO.playerId, farmMgrBlock.blockId).getTime());
/*  64 */             Date protectionEndTime = FarmMgr.getProtectEndTime(farmPO.playerId, farmMgrBlock.blockId);
/*  65 */             if (protectionEndTime != null)
/*  66 */               blockBuilder.setProtectEndTime(protectionEndTime.getTime()); 
/*  67 */             playerInfoBuilder.addBlockLs(blockBuilder.build());
/*     */           } 
/*     */ 
/*     */           
/*  71 */           Farm.PlayerInfo playerInfo = playerInfoBuilder.build();
/*  72 */           res.setPlayerInfo(playerInfo);
/*     */ 
/*     */ 
/*     */           
/*  76 */           for (MiscCO miscCO : ItemConfig.seedMiscMap.values()) {
/*     */             
/*  78 */             int seedNum = player.bag.findItemNumByCode(miscCO.code);
/*  79 */             Farm.Seed.Builder seedBuilder = Farm.Seed.newBuilder();
/*  80 */             seedBuilder.setSeedCode(miscCO.code);
/*  81 */             seedBuilder.setNum(seedNum);
/*     */             
/*  83 */             Farm.Seed handlerSeed = seedBuilder.build();
/*     */             
/*  85 */             res.addSeedLs(handlerSeed);
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/*  90 */           for (MiscCO miscCO : ItemConfig.productMiscMap.values()) {
/*  91 */             int seedNum = player.bag.findItemNumByCode(miscCO.code);
/*     */             
/*  93 */             Farm.Product.Builder productBuilder = Farm.Product.newBuilder();
/*  94 */             productBuilder.setProductCode(miscCO.code);
/*  95 */             productBuilder.setNum(seedNum);
/*     */             
/*  97 */             Farm.Product handlerProduct = productBuilder.build();
/*     */             
/*  99 */             res.addProductLs(handlerProduct);
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 104 */           res.setExp(farmPO.exp);
/*     */ 
/*     */           
/* 107 */           for (FarmMgr.RecordInfo recordInfo : farmPO.recordLs) {
/* 108 */             Farm.RecordInfo.Builder recordInfoBuilder = Farm.RecordInfo.newBuilder();
/* 109 */             recordInfoBuilder.setRecordTimeStamp(recordInfo.recordTime.getTime());
/* 110 */             recordInfoBuilder.setRecordType(recordInfo.recordType.value);
/* 111 */             for (String recordParam : recordInfo.recordParams) {
/* 112 */               recordInfoBuilder.addRecordParams(recordParam);
/*     */             }
/* 114 */             res.addRecordInfoLs(recordInfoBuilder.build());
/*     */           } 
/*     */           
/* 117 */           res.setS2CCode(200);
/* 118 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\farm\MyFarmInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */