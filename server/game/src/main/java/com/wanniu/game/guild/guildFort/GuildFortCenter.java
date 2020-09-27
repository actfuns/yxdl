/*     */ package com.wanniu.game.guild.guildFort;
/*     */ import com.wanniu.core.db.GCache;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GPlayer;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.ext.GuildFortExt;
/*     */ import com.wanniu.game.guild.guildFort.dao.GuildFortBattleReportPO;
/*     */ import com.wanniu.game.guild.guildFort.dao.GuildFortDao;
/*     */ import com.wanniu.game.guild.guildFort.dao.GuildFortPO;
/*     */ import com.wanniu.game.guild.guildFort.dao.GuildFortReportPO;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class GuildFortCenter {
/*     */   private static final int MAX_BID_FORT_NUM = 3;
/*     */   
/*     */   public enum Status {
/*  27 */     NOT_BEGIN(0),
/*  28 */     INTIME_NOTBID(1),
/*  29 */     BID_ENDED(2),
/*  30 */     IN_PREPARE(3),
/*  31 */     IN_BATTLE(4),
/*  32 */     INTIME_BIDDED(5);
/*     */ 
/*     */ 
/*     */     
/*     */     public int value;
/*     */ 
/*     */ 
/*     */     
/*     */     Status(int value) {
/*  41 */       this.value = value;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*  46 */   private Map<Integer, GuildFort> forts = new HashMap<>();
/*  47 */   private List<GuildFortReportPO> reports = new ArrayList<>();
/*     */   
/*     */   private static final String Tradenionstrongholds = "Tradenionstrongholds";
/*     */   
/*     */   private GuildFortCenter() {
/*  52 */     init();
/*     */   }
/*     */   
/*     */   private void init() {
/*  56 */     for (GuildFortExt fortExt : GameData.GuildForts.values()) {
/*  57 */       GuildFort fort = new GuildFort(fortExt);
/*  58 */       GuildFortPO po = GuildFortDao.getFort(fortExt.iD);
/*  59 */       if (po != null) {
/*  60 */         fort.setPo(po);
/*     */       }
/*  62 */       this.forts.put(Integer.valueOf(fortExt.iD), new GuildFort(fortExt));
/*     */     } 
/*  64 */     this.reports = GuildFortDao.getReports();
/*     */   }
/*     */   
/*     */   private static class GuildFortCenterHolder
/*     */   {
/*  69 */     public static final GuildFortCenter INSTANCE = new GuildFortCenter();
/*     */   }
/*     */   
/*     */   public static GuildFortCenter getInstance() {
/*  73 */     return GuildFortCenterHolder.INSTANCE;
/*     */   }
/*     */   
/*     */   public int getStatus(boolean isBidded) {
/*  77 */     GuildFortService service = GuildFortService.getInstance();
/*  78 */     if (service.isInBidTime()) {
/*  79 */       if (isBidded) {
/*  80 */         return Status.INTIME_BIDDED.value;
/*     */       }
/*  82 */       return Status.INTIME_NOTBID.value;
/*     */     } 
/*  84 */     if (service.isInBidEndedTime())
/*  85 */       return Status.BID_ENDED.value; 
/*  86 */     if (service.isInPrepareBattleTime())
/*  87 */       return Status.IN_PREPARE.value; 
/*  88 */     if (service.isInBattleTime()) {
/*  89 */       return Status.IN_BATTLE.value;
/*     */     }
/*  91 */     return Status.NOT_BEGIN.value;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBidTimeBegin() {
/*  97 */     GuildFortUtil.pushRedPointToAll();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBidOperation() {
/* 103 */     saveForts();
/*     */   }
/*     */   
/*     */   private String getBidOverReportMessage() {
/* 107 */     StringBuilder title = new StringBuilder(LangService.getValue("GUILDFORT_BIDRESULT_TITILE_NOTICE"));
/* 108 */     String msgStr = LangService.getValue("GUILDFORT_BIDRESULT_LOOP_NOTICE");
/* 109 */     String noBidderStr = LangService.getValue("GUILDFORT_BIDRESULT_NOBIDDER_NOTICE");
/* 110 */     for (GuildFort fort : this.forts.values()) {
/* 111 */       String str = msgStr.replace("{fortname}", fort.getName());
/* 112 */       String defName = fort.getDefenserName();
/* 113 */       String attName = fort.getAttackerName();
/* 114 */       if (defName.equals("") && attName.equals("")) {
/* 115 */         str = noBidderStr.replace("{fortname}", fort.getName());
/* 116 */       } else if (!defName.equals("") && attName.equals("")) {
/* 117 */         str = str.replace("{defguildname}", defName).replace("{attguildname}", "据点守卫军");
/*     */       } else {
/* 119 */         str = str.replace("{defguildname}", defName).replace("{attguildname}", attName);
/*     */       } 
/*     */       
/* 122 */       title.append(str);
/*     */     } 
/*     */     
/* 125 */     return title.toString();
/*     */   }
/*     */   
/*     */   public void onBidTimeEnd() {
/* 129 */     for (GuildFort fort : this.forts.values()) {
/* 130 */       fort.onBidOver();
/*     */     }
/* 132 */     saveForts();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPrepareBattle() {
/* 137 */     Map<String, Integer> members = new HashMap<>();
/* 138 */     for (GuildFort fort : this.forts.values()) {
/* 139 */       List<String> ids = fort.getAllMemberIds();
/* 140 */       for (String id : ids) {
/* 141 */         members.put(id, Integer.valueOf(0));
/*     */       }
/*     */     } 
/*     */     
/* 145 */     GuildFortUtil.pushRedPoint(members.keySet());
/*     */   }
/*     */   
/*     */   public void onBattleTimeBegin() {
/* 149 */     for (GuildFort fort : this.forts.values()) {
/* 150 */       fort.onBattleBegin();
/*     */     }
/* 152 */     clearAllDailyAwards();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBattleTimeEnd() {
/* 159 */     for (GuildFort fort : this.forts.values()) {
/* 160 */       fort.onBattleOver();
/* 161 */       String occupyGuildId = fort.getOccupyGuildId();
/* 162 */       System.out.println(fort.getId() + "=======================================fortId");
/* 163 */       System.out.println(fort.getOccupyGuildIds() + "=======================================occIds");
/* 164 */       if (fort.getOccupyGuildIds() == null || fort.getOccupyGuildIds().equals("")) {
/* 165 */         GCache.hset("Tradenionstrongholds", String.valueOf(fort.getId()), "");
/* 166 */         System.out.println("Tradenionstrongholds--------------------------------------------------------------------占领工会id" + occupyGuildId);
/*     */         continue;
/*     */       } 
/* 169 */       GCache.hset("Tradenionstrongholds", String.valueOf(fort.getId()), fort.getOccupyGuildIds());
/* 170 */       System.out.println("Tradenionstrongholds--------------------------------------------------------------------占领工会id" + occupyGuildId);
/*     */     } 
/*     */ 
/*     */     
/* 174 */     saveForts();
/* 175 */     GuildFortUtil.pushRedPointToAll();
/* 176 */     resetAllDailyAwards();
/*     */   }
/*     */ 
/*     */   
/*     */   private void resetAllDailyAwards() {
/* 181 */     GWorld.getInstance().ansycExec(() -> {
/*     */           for (GPlayer p : PlayerUtil.getAllOnlinePlayer()) {
/*     */             WNPlayer wp = (WNPlayer)p;
/*     */             wp.guildFortManager.recalcDailyAwards();
/*     */           } 
/*     */         });
/* 187 */     Out.info(new Object[] { "Guildfort daily awards recalc completed..." });
/*     */   }
/*     */   
/*     */   private void clearAllDailyAwards() {
/* 191 */     GWorld.getInstance().ansycExec(() -> {
/*     */           for (GPlayer p : PlayerUtil.getAllOnlinePlayer()) {
/*     */             WNPlayer wp = (WNPlayer)p;
/*     */             wp.guildFortManager.clearDailyAwards();
/*     */           } 
/*     */         });
/* 197 */     Out.info(new Object[] { "Guildfort daily awards cleared..." });
/*     */   }
/*     */ 
/*     */   
/*     */   public void addBattleReport(GuildFortBattleReportPO battleReport) {
/* 202 */     String date = DateUtil.getDate();
/* 203 */     if (GWorld.DEBUG) {
/* 204 */       date = DateUtil.getDateTime();
/* 205 */       date = date.substring(0, date.length() - 3);
/*     */     } 
/*     */     
/* 208 */     GuildFortReportPO report = null;
/* 209 */     for (GuildFortReportPO rep : this.reports) {
/* 210 */       if (rep.date.equals(date)) {
/* 211 */         report = rep;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 216 */     if (report == null) {
/* 217 */       report = new GuildFortReportPO();
/* 218 */       this.reports.add(report);
/*     */     } 
/* 220 */     report.date = date;
/* 221 */     report.battleReports.put(Integer.valueOf(battleReport.fortId), battleReport);
/*     */     
/* 223 */     if (this.reports.size() >= GlobalConfig.GuildFort_BattleRecordNum) {
/* 224 */       this.reports.remove(0);
/*     */     }
/*     */     
/* 227 */     saveReports();
/*     */   }
/*     */   
/*     */   public GuildFort getFort(int fortId) {
/* 231 */     return this.forts.get(Integer.valueOf(fortId));
/*     */   }
/*     */ 
/*     */   
/*     */   public List<GuildFort> getOccupiedForts(String guildId) {
/* 236 */     List<GuildFort> list = new ArrayList<>();
/* 237 */     for (GuildFort fort : this.forts.values()) {
/* 238 */       if (fort.isOccupier(guildId)) {
/* 239 */         list.add(fort);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 244 */     return list;
/*     */   }
/*     */   
/*     */   public boolean isBitFortExceeded(String guildId) {
/* 248 */     int num = 0;
/* 249 */     for (GuildFort fort : this.forts.values()) {
/* 250 */       if (fort.isInBidders(guildId)) {
/* 251 */         num++;
/*     */       }
/*     */     } 
/*     */     
/* 255 */     return (num >= 3);
/*     */   }
/*     */   
/*     */   public Collection<GuildFort> getAllGuildFort() {
/* 259 */     return this.forts.values();
/*     */   }
/*     */   
/*     */   public List<GuildFortReportPO> getReports() {
/* 263 */     return this.reports;
/*     */   }
/*     */   
/*     */   private void saveForts() {
/* 267 */     for (GuildFort fort : this.forts.values()) {
/* 268 */       GuildFortDao.saveFort(fort.getPo());
/*     */     }
/*     */   }
/*     */   
/*     */   private void saveReports() {
/* 273 */     GuildFortDao.saveReports(this.reports);
/*     */   }
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
/*     */   public void test() {}
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
/*     */   public void onCloseGame() {
/* 299 */     saveForts();
/* 300 */     saveReports();
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guildFort\GuildFortCenter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */