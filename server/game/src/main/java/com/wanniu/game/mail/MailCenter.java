/*     */ package com.wanniu.game.mail;
/*     */ 
/*     */ import com.wanniu.core.GGame;
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.game.entity.GEntity;
/*     */ import com.wanniu.core.game.entity.GPlayer;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.mail.data.MailData;
/*     */ import com.wanniu.game.mail.data.MailGmData;
/*     */ import com.wanniu.game.mail.po.ServerMailsPO;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.PlayerMailDataPO;
/*     */ import com.wanniu.redis.GameDao;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import java.util.Calendar;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ 
/*     */ 
/*     */ public class MailCenter
/*     */ {
/*     */   private static MailCenter instance;
/*  26 */   private ConcurrentHashMap<String, MailManager> mailDatas = new ConcurrentHashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  31 */   private ConcurrentHashMap<String, MailGmData> serverMail = new ConcurrentHashMap<>();
/*     */   
/*     */   public static synchronized MailCenter getInstance() {
/*  34 */     if (instance == null)
/*  35 */       instance = new MailCenter(); 
/*  36 */     return instance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerDisponse(String playerId) {
/*  44 */     this.mailDatas.remove(playerId);
/*     */   }
/*     */   
/*     */   public MailManager findPlayerMails(String playerId) {
/*  48 */     if (playerId == null)
/*  49 */       return null; 
/*  50 */     if (this.mailDatas.containsKey(playerId)) {
/*  51 */       return this.mailDatas.get(playerId);
/*     */     }
/*  53 */     PlayerMailDataPO data = (PlayerMailDataPO)PlayerPOManager.findPO(ConstsTR.mailTR, playerId, PlayerMailDataPO.class);
/*  54 */     if (data == null) {
/*  55 */       data = new PlayerMailDataPO();
/*  56 */       PlayerPOManager.put(ConstsTR.mailTR, playerId, (GEntity)data);
/*     */     } 
/*  58 */     MailManager mailManager = new MailManager(playerId, data);
/*     */     
/*  60 */     this.mailDatas.put(playerId, mailManager);
/*  61 */     return mailManager;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addMail(String playerId, WNMail mail, boolean isUpdateScript) {
/*  66 */     MailManager mailManager = findPlayerMails(playerId);
/*  67 */     if (mailManager != null)
/*  68 */       mailManager.addMail(mail, isUpdateScript); 
/*     */   }
/*     */   
/*     */   public void sendOfflineMailToPlayers(String[] playerIds, MailData newMail, Const.GOODS_CHANGE_TYPE origin) {
/*  72 */     for (String playerId : playerIds) {
/*  73 */       WNMail mail = MailUtil.getInstance().createMail(newMail, playerId, origin);
/*  74 */       addMail(playerId, mail, false);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void checkServerMail(MailManager mailManager) {
/*  79 */     Map<String, String> serverMailRecord = mailManager.data.serverMailRecord;
/*  80 */     for (Map.Entry<String, MailGmData> entry : this.serverMail.entrySet()) {
/*  81 */       String key = entry.getKey();
/*  82 */       MailGmData gmail = entry.getValue();
/*  83 */       WNPlayer player = PlayerUtil.getOnlinePlayer(mailManager.playerId);
/*     */       
/*  85 */       if (gmail.createRoleDate != null && player.player.createTime.after(gmail.createRoleDate)) {
/*     */         continue;
/*     */       }
/*  88 */       if (player.getLevel() < gmail.minLevel) {
/*     */         continue;
/*     */       }
/*     */       
/*  92 */       if (!serverMailRecord.containsKey(key)) {
/*  93 */         WNMail mail = MailUtil.getInstance().createMail((MailData)gmail, mailManager.playerId, Const.GOODS_CHANGE_TYPE.GMT);
/*  94 */         addMail(mailManager.playerId, mail, true);
/*  95 */         mailManager.addServerMailRecord(key);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addServerMail(String serverMailId, MailGmData mailData, Const.GOODS_CHANGE_TYPE origin) {
/* 101 */     if (mailData.createRoleDate == null)
/*     */       return; 
/* 103 */     this.serverMail.put(serverMailId, mailData);
/* 104 */     ServerMailsPO mailsData = new ServerMailsPO();
/* 105 */     mailsData.serverMail = this.serverMail;
/* 106 */     GameDao.update(String.valueOf(GWorld.__SERVER_ID), ConstsTR.serverMailsTR, mailsData);
/* 107 */     Map<String, GPlayer> players = GGame.getInstance().getOnlinePlayers();
/* 108 */     for (GPlayer player : players.values()) {
/* 109 */       WNPlayer wplayer = (WNPlayer)player;
/*     */       
/* 111 */       if (mailData.createRoleDate != null && wplayer.player.createTime.after(mailData.createRoleDate)) {
/*     */         continue;
/*     */       }
/* 114 */       if (wplayer.getLevel() < mailData.minLevel) {
/*     */         continue;
/*     */       }
/* 117 */       WNMail mail = MailUtil.getInstance().createMail((MailData)mailData, wplayer.getId(), origin);
/* 118 */       addMail(wplayer.getId(), mail, true);
/* 119 */       wplayer.mailManager.addServerMailRecord(serverMailId);
/*     */     } 
/* 121 */     long endTime = mailData.createRoleDate.getTime() + 604800000L;
/* 122 */     Calendar c = Calendar.getInstance();
/* 123 */     c.setTimeInMillis(endTime);
/* 124 */     Calendar now = Calendar.getInstance();
/* 125 */     long delay = c.getTimeInMillis() - now.getTimeInMillis();
/* 126 */     addDelayJob(serverMailId, delay);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeServerMail(String serverMailId) {
/* 135 */     this.serverMail.remove(serverMailId);
/* 136 */     ServerMailsPO mailsData = new ServerMailsPO();
/* 137 */     mailsData.serverMail = this.serverMail;
/* 138 */     GameDao.update(String.valueOf(GWorld.__SERVER_ID), ConstsTR.serverMailsTR, mailsData);
/*     */   }
/*     */   
/*     */   public void loadServerMails() {
/* 142 */     ServerMailsPO mailsData = (ServerMailsPO)GameDao.get(String.valueOf(GWorld.__SERVER_ID), ConstsTR.serverMailsTR, ServerMailsPO.class);
/* 143 */     if (mailsData != null) {
/* 144 */       this.serverMail = mailsData.serverMail;
/*     */     } else {
/* 146 */       mailsData = new ServerMailsPO();
/*     */     } 
/* 148 */     for (String serverMailId : this.serverMail.keySet()) {
/* 149 */       MailGmData mailData = this.serverMail.get(serverMailId);
/* 150 */       if (mailData.createRoleDate == null) {
/* 151 */         this.serverMail.remove(serverMailId);
/*     */         continue;
/*     */       } 
/* 154 */       long endTime = mailData.createRoleDate.getTime() + 604800000L;
/* 155 */       Calendar c = Calendar.getInstance();
/* 156 */       c.setTimeInMillis(endTime);
/* 157 */       Calendar now = Calendar.getInstance();
/* 158 */       long delay = c.getTimeInMillis() - now.getTimeInMillis();
/* 159 */       if (delay < 0L) {
/* 160 */         this.serverMail.remove(serverMailId); continue;
/*     */       } 
/* 162 */       addDelayJob(serverMailId, delay);
/*     */     } 
/*     */     
/* 165 */     mailsData.serverMail = this.serverMail;
/* 166 */     GameDao.update(String.valueOf(GWorld.__SERVER_ID), ConstsTR.serverMailsTR, mailsData);
/*     */   }
/*     */   
/*     */   private void addDelayJob(String serverMailId, long delay) {
/* 170 */     JobFactory.addDelayJob(() -> { this.serverMail.remove(serverMailId); ServerMailsPO datas = new ServerMailsPO(); datas.serverMail = this.serverMail; GameDao.update(String.valueOf(GWorld.__SERVER_ID), ConstsTR.serverMailsTR, datas); }delay);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\mail\MailCenter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */