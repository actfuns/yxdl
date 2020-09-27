/*     */ package com.wanniu.gm.handler;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONArray;
/*     */ import com.wanniu.core.db.GCache;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.item.VirtualItemType;
/*     */ import com.wanniu.game.mail.MailUtil;
/*     */ import com.wanniu.game.mail.data.MailData;
/*     */ import com.wanniu.game.mail.data.MailSysData;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.poes.PlayerPO;
/*     */ import com.wanniu.game.prepaid.po.PrepaidPO;
/*     */ import com.wanniu.gm.GMEvent;
/*     */ import com.wanniu.gm.GMResponse;
/*     */ import com.wanniu.gm.GMStateResponse;
/*     */ import com.wanniu.redis.GameDao;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import java.time.LocalDate;
/*     */ import java.time.format.DateTimeFormatter;
/*     */ import java.time.temporal.ChronoUnit;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @GMEvent
/*     */ public class DeletePlayerHandler
/*     */   extends GMBaseHandler
/*     */ {
/*  53 */   private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
/*     */ 
/*     */   
/*     */   public GMResponse execute(JSONArray arr) {
/*  57 */     Out.warn(new Object[] { "开始删除小号..." });
/*     */ 
/*     */     
/*  60 */     Out.warn(new Object[] { "发补偿..." });
/*  61 */     LocalDate openDate = LocalDate.parse(arr.getString(0), this.formatter);
/*  62 */     Map<String, String> names = GCache.hgetAll("NAME_MODULE");
/*  63 */     for (String playerId : names.values()) {
/*     */ 
/*     */       
/*     */       try {
/*  67 */         PrepaidPO po = (PrepaidPO)PlayerPOManager.findPO(ConstsTR.prepaidNewTR, playerId, PrepaidPO.class);
/*  68 */         po.first_buy_record.clear();
/*     */ 
/*     */ 
/*     */         
/*  72 */         PlayerPO player = (PlayerPO)GameDao.get(playerId, ConstsTR.playerTR, PlayerPO.class);
/*  73 */         LocalDate createTime = LocalDate.parse(DateUtil.format(player.createTime, "yyyy-MM-dd"), this.formatter);
/*  74 */         int daysDiff = (int)Math.min(Math.max(0L, ChronoUnit.DAYS.between(openDate, createTime)), GlobalConfig.Combine_MaxDay);
/*  75 */         Out.info(new Object[] { "合服补偿 playerId=", playerId, ",day=", Integer.valueOf(daysDiff) });
/*  76 */         if (daysDiff > 0) {
/*  77 */           String mailKey = "CombineCompensate";
/*  78 */           MailSysData mail = new MailSysData(mailKey);
/*  79 */           mail.attachments = new ArrayList();
/*     */           
/*  81 */           MailData.Attachment item = new MailData.Attachment();
/*  82 */           item.itemCode = VirtualItemType.EXP.getItemcode();
/*  83 */           item.itemNum = daysDiff * GlobalConfig.Combine_Exp;
/*  84 */           item.isBind = Const.BindType.BIND.getValue();
/*  85 */           mail.attachments.add(item);
/*     */ 
/*     */           
/*  88 */           item = new MailData.Attachment();
/*  89 */           item.itemCode = VirtualItemType.UPEXP.getItemcode();
/*  90 */           item.itemNum = daysDiff * GlobalConfig.Combine_UpExp;
/*  91 */           item.isBind = Const.BindType.BIND.getValue();
/*  92 */           mail.attachments.add(item);
/*     */ 
/*     */           
/*  95 */           for (String is : GlobalConfig.Combine_Items.split(",")) {
/*  96 */             String[] i = is.split(":");
/*  97 */             MailData.Attachment attachment = new MailData.Attachment();
/*  98 */             attachment.itemCode = i[0];
/*  99 */             attachment.itemNum = daysDiff * Integer.parseInt(i[1]);
/* 100 */             attachment.isBind = Const.BindType.BIND.getValue();
/* 101 */             mail.attachments.add(attachment);
/*     */           } 
/*     */           
/* 104 */           mail.replace = new HashMap<>();
/* 105 */           mail.replace.put("day", String.valueOf(daysDiff));
/* 106 */           MailUtil.getInstance().sendMailToOnePlayer(playerId, (MailData)mail, Const.GOODS_CHANGE_TYPE.CombineCompensate);
/*     */         } 
/* 108 */       } catch (Exception e) {
/* 109 */         Out.error(new Object[] { e });
/*     */       } 
/*     */     } 
/* 112 */     PlayerPOManager.clearOfflinePO();
/* 113 */     return (GMResponse)new GMStateResponse(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public short getType() {
/* 118 */     return 5;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\handler\DeletePlayerHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */