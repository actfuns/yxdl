/*     */ package com.wanniu.game;
/*     */ 
/*     */ import com.wanniu.core.GConfig;
/*     */ import com.wanniu.core.GSystem;
/*     */ import com.wanniu.core.game.GServerBootstrap;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.DataUtil;
/*     */ import com.wanniu.game.achievement.AchievementServiceNew;
/*     */ import com.wanniu.game.activity.DemonTowerService;
/*     */ import com.wanniu.game.arena.ArenaService;
/*     */ import com.wanniu.game.auction.AuctionDataManager;
/*     */ import com.wanniu.game.autoChat.AutoChat;
/*     */ import com.wanniu.game.autoChat.ClearChatLog;
/*     */ import com.wanniu.game.chat.GmCommandManager;
/*     */ import com.wanniu.game.common.ScheduleManager;
/*     */ import com.wanniu.game.consignmentShop.ConsignmentLineService;
/*     */ import com.wanniu.game.daoyou.DaoYouCenter;
/*     */ import com.wanniu.game.daoyou.DaoYouService;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.ServerConfigCO;
/*     */ import com.wanniu.game.fightLevel.DungeonService;
/*     */ import com.wanniu.game.five2Five.Five2FiveService;
/*     */ import com.wanniu.game.flee.FleeService;
/*     */ import com.wanniu.game.friend.FriendsCenter;
/*     */ import com.wanniu.game.guild.GuildServiceCenter;
/*     */ import com.wanniu.game.guild.guidDepot.GuildDepotCenter;
/*     */ import com.wanniu.game.guild.guildBless.GuildBlessCenter;
/*     */ import com.wanniu.game.guild.guildBoss.GuildBossService;
/*     */ import com.wanniu.game.guild.guildFort.GuildFortCenter;
/*     */ import com.wanniu.game.guild.guildFort.GuildFortService;
/*     */ import com.wanniu.game.guild.guildImpeach.GuildImpeachCenter;
/*     */ import com.wanniu.game.mail.MailCenter;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PathService;
/*     */ import com.wanniu.game.rank.RankCenter;
/*     */ import com.wanniu.game.recent.RecentChatCenter;
/*     */ import com.wanniu.game.redpacket.RedPacketService;
/*     */ import com.wanniu.game.shopMall.ShopMallService;
/*     */ import com.wanniu.game.solo.SoloService;
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.io.IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GMain
/*     */ {
/*  54 */   private static int TableCount = 0;
/*     */   
/*     */   public static void main(String[] args) {
/*  57 */     GConfig.getInstance().init(false);
/*  58 */     if (args.length > 0) {
/*  59 */       String ip = args[0].trim();
/*  60 */       GConfig.getInstance().put("game.pubhost", ip);
/*  61 */       if (!GConfig.getInstance().exists("game.id")) {
/*  62 */         String gameId = ip.substring(ip.lastIndexOf(".") + 1);
/*  63 */         GConfig.getInstance().put("game.id", gameId);
/*     */       } 
/*  65 */       GWorld.__SERVER_ID = GConfig.getInstance().getGameID();
/*  66 */       Out.info(new Object[] { ip, " game id : ", Integer.valueOf(GWorld.__SERVER_ID) });
/*     */     } 
/*     */     
/*  69 */     Out.info(new Object[] { Boolean.valueOf(GWorld.DEBUG) });
/*     */     
/*  71 */     if (GWorld.DEBUG && GSystem.OS_NAME.startsWith("WINDOWS")) { Out.info(new Object[] { Integer.valueOf(111) });
/*  72 */       (new Thread(() -> {
/*     */             try {
/*     */               System.in.read();
/*  75 */             } catch (IOException e) {
/*     */               Out.error(new Object[] { e }, );
/*     */             } 
/*     */             System.exit(0);
/*  79 */           }"安全停服：测试启用")).start(); }
/*     */ 
/*     */ 
/*     */     
/*  83 */     initData();
/*     */     
/*  85 */     GWorld.getInstance().start();
/*     */ 
/*     */     
/*  88 */     ScheduleManager.getInstance();
/*     */ 
/*     */     
/*  91 */     PathService.getInstance();
/*     */     
/*  93 */     DungeonService.getInstance();
/*     */     
/*  95 */     ConsignmentLineService.getInstance();
/*     */     
/*  97 */     AuctionDataManager.getInstance();
/*     */     
/*  99 */     MailCenter.getInstance().loadServerMails();
/*     */     
/* 101 */     FriendsCenter.getInstance();
/*     */     
/* 103 */     RecentChatCenter.getInstance();
/*     */     
/* 105 */     GuildServiceCenter.getInstance().init();
/* 106 */     GuildImpeachCenter.getInstance();
/* 107 */     GuildDepotCenter.getInstance();
/* 108 */     GuildBlessCenter.getInstance();
/*     */     
/* 110 */     DaoYouService.getInstance();
/* 111 */     DaoYouCenter.getInstance();
/*     */     
/* 113 */     ArenaService.getInstance();
/*     */     
/* 115 */     SoloService.getInstance();
/*     */     
/* 117 */     Five2FiveService.getInstance();
/* 118 */     FleeService.getInstance();
/*     */     
/* 120 */     AchievementServiceNew.getInstance();
/*     */     
/* 122 */     ShopMallService.getInstance();
/*     */     
/* 124 */     RankCenter.getInstance().init();
/*     */     
/* 126 */     GuildBossService.getInstance().init();
/* 127 */     GmCommandManager.init();
/*     */     
/* 129 */     GuildFortService.getInstance();
/* 130 */     GuildFortCenter.getInstance();
/*     */     
/* 132 */     RedPacketService.getInstance().init();
/*     */     
/* 134 */     DemonTowerService.getInstance().init();
/*     */     
/* 136 */     AutoChat.getInstance().init(GWorld.__SERVER_ID);
/*     */     
/* 138 */     ClearChatLog.getInstance().init();
/*     */ 
/*     */ 
/*     */     
/* 142 */     GServerBootstrap.getInstance().start();
/* 143 */     GSystem.free();
/* 144 */     Out.info(new Object[] { "SID-> ", Integer.valueOf(GWorld.__SERVER_ID), "    ENV -> ", GWorld.__SERVER_LANG, "    DEBUG -> ", Boolean.valueOf(GWorld.DEBUG), "    MONITOR -> ", Boolean.valueOf(GWorld.MONITOR) });
/* 145 */     Out.info(new Object[] { "游戏已成功启动运行喽，O(∩_∩)O~" });
/* 146 */     System.out.println("游戏已成功启动运行喽，O(∩_∩)O~");
/*     */   }
/*     */ 
/*     */   
/*     */   private static void loadData(File parent) {
/* 151 */     File[] tables = parent.listFiles(new FileFilter()
/*     */         {
/*     */           public boolean accept(File file) {
/* 154 */             if (file.isDirectory()) {
/* 155 */               GMain.loadData(file);
/*     */             }
/* 157 */             if (file.getName().endsWith(".json")) {
/* 158 */               DataUtil.loadData(file);
/* 159 */               return true;
/*     */             } 
/* 161 */             return false;
/*     */           }
/*     */         });
/* 164 */     TableCount += tables.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void initData() {
/* 169 */     DataUtil.addExtClass("com.wanniu.game.data");
/*     */     
/* 171 */     File dataDir = new File("json");
/* 172 */     loadData(dataDir);
/*     */     
/* 174 */     Out.info(new Object[] { "Load table count:", Integer.valueOf(TableCount) });
/*     */ 
/*     */     
/* 177 */     for (ServerConfigCO t : GameData.ServerConfigs.values()) {
/* 178 */       LangService.put(t.paramNameS, t.showTxt);
/*     */     }
/*     */     
/* 181 */     DataUtil.initProperty();
/*     */     
/* 183 */     GlobalConfig.init();
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\GMain.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */