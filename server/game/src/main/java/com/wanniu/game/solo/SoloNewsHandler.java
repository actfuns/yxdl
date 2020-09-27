/*     */ package com.wanniu.game.solo;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.game.chat.ChannelUtil;
/*     */ import com.wanniu.game.common.msg.MessageUtil;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.SoloNewsCO;
/*     */ import com.wanniu.game.data.SoloRankCO;
/*     */ import com.wanniu.game.equip.NormalEquip;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SoloNewsHandler
/*     */ {
/*     */   private WNPlayer player;
/*     */   
/*     */   public SoloNewsHandler(WNPlayer player) {
/*  30 */     this.player = player;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onStraightWin(int contWinTimes) {
/*  39 */     for (SoloNewsCO prop : GameData.SoloNewss.values()) {
/*  40 */       if (prop.newsType == 1 && prop.newsPar == contWinTimes) {
/*  41 */         String news = _genWinNews(contWinTimes, prop.newsContent);
/*  42 */         SoloService.getInstance().addSoloNews(news);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onStraightWinStopped(int contWinTimes, String vsPlayerName) {
/*  55 */     for (SoloNewsCO prop : GameData.SoloNewss.values()) {
/*  56 */       if (prop.newsType == 2 && prop.newsPar == contWinTimes) {
/*  57 */         String news = _genWinStoppedNews(contWinTimes, vsPlayerName, prop.newsContent);
/*  58 */         SoloService.getInstance().addSoloNews(news);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onRankIdChanged(int rankId) {
/*  70 */     for (SoloNewsCO prop : GameData.SoloNewss.values()) {
/*  71 */       if (prop.newsType == 3 && prop.newsPar == rankId) {
/*  72 */         String news = _genRankIdUpNews(rankId, prop.newsContent);
/*  73 */         SoloService.getInstance().addSoloNews(news);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onGetGift(String typeStr, List<NormalItem> items) {
/*  86 */     for (NormalItem item : items) {
/*  87 */       if (item.isEquip()) {
/*  88 */         NormalEquip equip = (NormalEquip)item;
/*  89 */         for (SoloNewsCO prop : GameData.SoloNewss.values()) {
/*  90 */           if (prop.newsType == 4 && equip.getQColor() >= prop.newsPar) {
/*  91 */             String news = _genGetgiftNews(typeStr, (NormalItem)equip, prop.newsContent);
/*  92 */             SoloService.getInstance().addSoloNews(news);
/*     */             return;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String getPlayerChatLink(WNPlayer player) {
/* 108 */     String playerLink = ChannelUtil.setPlayerInfo(player);
/* 109 */     String playerText = LangService.format("NAME_LINK", new Object[] { playerLink, player.getName() });
/* 110 */     return playerText;
/*     */   }
/*     */ 
/*     */   
/*     */   private String _genWinNews(int contWinTimes, String originalNews) {
/* 115 */     String news = originalNews;
/*     */     
/* 117 */     String playerText = getPlayerChatLink(this.player);
/* 118 */     news = news.replace("{playerName}", playerText).replace("{straightwinNum}", "" + contWinTimes);
/* 119 */     news = System.currentTimeMillis() + "|" + news;
/* 120 */     return news;
/*     */   }
/*     */ 
/*     */   
/*     */   private String _genWinStoppedNews(int contWinTimes, String vsPlayerName, String originalNews) {
/* 125 */     String news = originalNews;
/*     */     
/* 127 */     String playerText = getPlayerChatLink(this.player);
/* 128 */     news = news.replace("{playerName}", playerText).replace("{straightwinNum}", "" + contWinTimes);
/* 129 */     news = news.replace("{vsPlayerName}", vsPlayerName);
/* 130 */     news = System.currentTimeMillis() + "|" + news;
/* 131 */     return news;
/*     */   }
/*     */ 
/*     */   
/*     */   private String _genRankIdUpNews(int rankId, String originalNews) {
/* 136 */     String news = originalNews;
/*     */     
/* 138 */     String playerText = getPlayerChatLink(this.player);
/* 139 */     String rankText = "" + rankId;
/* 140 */     SoloRankCO prop = (SoloRankCO)GameData.SoloRanks.get(Integer.valueOf(rankId));
/* 141 */     if (prop != null) {
/*     */ 
/*     */ 
/*     */       
/* 145 */       rankText = "<font color=\"" + prop.textColour + "\">{a}</font>";
/* 146 */       rankText = rankText.replace("{a}", prop.rankName);
/*     */     } 
/*     */     
/* 149 */     news = news.replace("{playerName}", playerText).replace("{RankName}", rankText);
/* 150 */     news = System.currentTimeMillis() + "|" + news;
/* 151 */     return news;
/*     */   }
/*     */ 
/*     */   
/*     */   private String _genGetgiftNews(String typeName, NormalItem item, String originalNews) {
/* 156 */     String news = originalNews;
/*     */     
/* 158 */     String playerText = getPlayerChatLink(this.player);
/*     */     
/* 160 */     String allItemText = "";
/*     */     
/* 162 */     if (item != null) {
/* 163 */       String itemText = LangService.getValue(MessageUtil.getColorLink(item.prop.qcolor));
/* 164 */       String itemLink = ChannelUtil.setItemInfo(item);
/* 165 */       itemText = itemText.replace("{a}", item.prop.name).replace("{b}", itemLink);
/*     */       
/* 167 */       String numText = LangService.getValue("DEFAULT");
/* 168 */       numText = numText.replace("{a}", "*" + item.getNum());
/*     */       
/* 170 */       if (allItemText.equals("")) {
/* 171 */         allItemText = allItemText + itemText + numText;
/*     */       } else {
/* 173 */         allItemText = allItemText + "," + itemText + numText;
/*     */       } 
/*     */     } 
/*     */     
/* 177 */     news = news.replace("{playerName}", playerText).replace("{giftType}", typeName).replace("{item}", allItemText);
/*     */     
/* 179 */     news = System.currentTimeMillis() + "|" + news;
/* 180 */     return news;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Map<String, List<String>> getAllSoloNews(int logicServerId) {
/* 190 */     Map<String, List<String>> newsList = new TreeMap<>();
/* 191 */     List<String> newsAll = SoloService.getInstance().getAllSoloNews();
/*     */ 
/*     */     
/* 194 */     for (String news : newsAll) {
/* 195 */       String[] str = news.split("\\|");
/* 196 */       Date date = new Date(Long.parseLong(str[0]));
/* 197 */       String strDate = DateUtil.format(date, "yyyy-MM-dd");
/*     */       
/* 199 */       String timeText = LangService.getValue("TIME_COLOUR");
/* 200 */       timeText = timeText.replace("{a}", "[" + strDate + "]");
/* 201 */       timeText = timeText + str[1];
/*     */       
/* 203 */       if (newsList.containsKey(strDate)) {
/* 204 */         List<String> list = newsList.get(strDate);
/* 205 */         list.add(timeText); continue;
/*     */       } 
/* 207 */       List<String> values = new ArrayList<>();
/* 208 */       values.add(timeText);
/* 209 */       newsList.put(strDate, values);
/*     */     } 
/*     */     
/* 212 */     return newsList;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\solo\SoloNewsHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */