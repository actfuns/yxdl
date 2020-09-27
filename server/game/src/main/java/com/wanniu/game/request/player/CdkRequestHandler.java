/*     */ package com.wanniu.game.request.player;
/*     */ 
/*     */ import cn.qeng.common.gm.po.CdkCode;
/*     */ import cn.qeng.common.gm.po.CdkItem;
/*     */ import cn.qeng.common.gm.po.CdkPO;
/*     */ import com.wanniu.core.db.GCache;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.bag.WNBag;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.common.msg.ErrorResponse;
/*     */ import com.wanniu.game.item.po.PlayerItemPO;
/*     */ import com.wanniu.game.player.BILogService;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.CdksUsePO;
/*     */ import com.wanniu.redis.GlobalDao;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import pomelo.area.PlayerHandler;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @GClientEvent("area.playerHandler.cdkRequest")
/*     */ public class CdkRequestHandler
/*     */   extends PomeloRequest
/*     */ {
/*     */   public PomeloResponse request() throws Exception {
/*  53 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*  54 */     PlayerHandler.CDKRequest cdk = PlayerHandler.CDKRequest.parseFrom(this.pak.getRemaingBytes());
/*  55 */     String useCode = cdk.getC2SCdk().toUpperCase();
/*  56 */     if (useCode.length() < 12) {
/*  57 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("ACTIVITY_CKD_NOTEXIST"));
/*     */     }
/*  59 */     CdksUsePO cdksUsePo = null;
/*  60 */     List<CdkItem> items = null;
/*  61 */     String codeStr = null;
/*     */     try {
/*  63 */       boolean canGetCDK = canOperatorCDK();
/*  64 */       if (!canGetCDK) {
/*  65 */         Out.warn(new Object[] { "在获取cdk的时候发现有人在操作！playerId=", player.getId(), ",发送的cdk=", useCode });
/*  66 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("ACTIVITY_CKD_ISUSE"));
/*     */       } 
/*  68 */       String str = GlobalDao.hget(ConstsTR.CDK.value, useCode.substring(0, useCode.indexOf("X")));
/*     */       
/*  70 */       CdkPO cdkPo = (CdkPO)Utils.deserialize(str, CdkPO.class);
/*  71 */       if (cdkPo == null) {
/*  72 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("ACTIVITY_CKD_NOTEXIST"));
/*     */       }
/*  74 */       CdkCode code = null;
/*  75 */       for (CdkCode c : cdkPo.getCdkCodes()) {
/*  76 */         if (c.getCode().equals(useCode)) {
/*  77 */           code = c;
/*     */           break;
/*     */         } 
/*     */       } 
/*  81 */       if (code == null) {
/*  82 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("ACTIVITY_CKD_NOTEXIST"));
/*     */       }
/*  84 */       if (cdkPo.getCdkType() == 0 && code.getUseNum() > 0) {
/*  85 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("ACTIVITY_CKD_ISUSE"));
/*     */       }
/*  87 */       if (cdkPo.getBeginDate() != null && cdkPo.getEndDate() != null && 
/*  88 */         DateUtil.isOutDate(cdkPo.getBeginDate().getTime(), cdkPo.getEndDate().getTime()) != 1) {
/*  89 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("ACTIVITY_CKD_TIMEOUT"));
/*     */       }
/*     */       
/*  92 */       if (cdkPo.getChannel() != -1 && cdkPo.getChannel() != cdk.getC2SChannel()) {
/*  93 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("ACTIVITY_CKD_CHANNELUSE"));
/*     */       }
/*  95 */       if (player.getLevel() < cdkPo.getMinLevel()) {
/*  96 */         return (PomeloResponse)new ErrorResponse(LangService.format("ACTIVITY_CKD_USELEVEL", new Object[] { Integer.valueOf(cdkPo.getMinLevel()) }));
/*     */       }
/*  98 */       if (!cdkPo.getServerIds().isEmpty() && !cdkPo.getServerIds().contains(Integer.valueOf(GWorld.__SERVER_ID))) {
/*  99 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("ACTIVITY_CKD_SERVERUSE"));
/*     */       }
/* 101 */       cdksUsePo = getCdksUsePO(player);
/* 102 */       int useCount = getCDKUseCount(cdksUsePo, cdkPo.getCode());
/* 103 */       if (useCount >= cdkPo.getMaxUseCount()) {
/* 104 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("ACTIVITY_CKD_FULLUSE"));
/*     */       }
/* 106 */       items = cdkPo.getItems();
/* 107 */       codeStr = code.getCode();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 116 */       WNBag wnBag = player.getWnBag();
/* 117 */       int itemsize = items.size();
/* 118 */       if (itemsize > wnBag.emptyGridNum())
/*     */       {
/*     */ 
/*     */ 
/*     */         
/* 123 */         return new PomeloResponse()
/*     */           {
/*     */             protected void write() throws IOException {
/* 126 */               PlayerHandler.CDKResponse.Builder res = PlayerHandler.CDKResponse.newBuilder();
/* 127 */               res.setS2CCode(500);
/* 128 */               res.setS2CMsg(LangService.getValue("背包已满，请先清理背包"));
/* 129 */               this.body.writeBytes(res.build().toByteArray());
/*     */             }
/*     */           };
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 136 */       code.setUseNum(code.getUseNum() + 1);
/*     */       
/* 138 */       if (cdkPo.getCdkType() == 0) {
/* 139 */         code.useCdk(new Date(), player.getId(), cdk.getC2SChannel());
/*     */       }
/* 141 */       GlobalDao.hset(ConstsTR.CDK.value, cdkPo.getCode(), Utils.serialize(cdkPo));
/*     */     } finally {
/*     */       
/* 144 */       delCDKLock();
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 149 */     return afterOperatorCDK(player, cdk, cdksUsePo, items, codeStr);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean canOperatorCDK() {
/* 157 */     long flag = GlobalDao.setnx(ConstsTR.CDK_LOCK.value, "1");
/* 158 */     GlobalDao.expire(ConstsTR.CDK_LOCK.value, 60000);
/* 159 */     boolean isSuccess = (flag > 0L);
/* 160 */     return isSuccess;
/*     */   }
/*     */   
/*     */   public PomeloResponse afterOperatorCDK(WNPlayer player, PlayerHandler.CDKRequest cdk, CdksUsePO cdksUsePo, List<CdkItem> items, String codeStr) {
/* 164 */     cdksUsePo.listCdk.add(new CdksUsePO.CdkUse(codeStr, new Date(), cdk.getC2SChannel()));
/* 165 */     GCache.hset("player_use_cdk", player.getId(), Utils.serialize(cdksUsePo));
/* 166 */     List<PlayerItemPO> notAddItems = new ArrayList<>();
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
/* 178 */     for (CdkItem i : items) {
/* 179 */       player.bag.addCodeItem(i.itemId, i.num, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.CDK);
/*     */     }
/*     */ 
/*     */     
/* 183 */     BILogService.getInstance().recordNum(player, Const.BiLogType.Gift, 1L, Const.GOODS_CHANGE_TYPE.CDK);
/*     */     
/* 185 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/* 188 */           PlayerHandler.CDKResponse.Builder res = PlayerHandler.CDKResponse.newBuilder();
/* 189 */           res.setS2CCode(200);
/* 190 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private void delCDKLock() {
/* 196 */     GlobalDao.remove(ConstsTR.CDK_LOCK.value);
/*     */   }
/*     */   
/*     */   private int getCDKUseCount(CdksUsePO cdksUsePo, String code) {
/* 200 */     int useCount = 0;
/* 201 */     for (CdksUsePO.CdkUse p : cdksUsePo.listCdk) {
/* 202 */       if (p.cdk.startsWith(code)) {
/* 203 */         useCount++;
/*     */       }
/*     */     } 
/* 206 */     return useCount;
/*     */   }
/*     */   
/*     */   private CdksUsePO getCdksUsePO(WNPlayer player) {
/* 210 */     CdksUsePO cdksUsePo = player.allBlobData.cdksUserPo;
/* 211 */     if (cdksUsePo == null) {
/* 212 */       String data = GCache.hget("player_use_cdk", player.getId());
/* 213 */       cdksUsePo = StringUtil.isNotEmpty(data) ? (CdksUsePO)Utils.deserialize(data, CdksUsePO.class) : new CdksUsePO();
/* 214 */       player.allBlobData.cdksUserPo = cdksUsePo;
/*     */     } 
/* 216 */     return cdksUsePo;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\player\CdkRequestHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */