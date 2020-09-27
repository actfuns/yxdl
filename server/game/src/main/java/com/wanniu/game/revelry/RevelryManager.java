/*     */ package com.wanniu.game.revelry;
/*     */ 
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.RevelryCO;
/*     */ import com.wanniu.game.data.RevelryConfigCO;
/*     */ import com.wanniu.game.guild.GuildServiceCenter;
/*     */ import com.wanniu.game.mail.MailUtil;
/*     */ import com.wanniu.game.mail.data.MailData;
/*     */ import com.wanniu.game.mail.data.MailSysData;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.GuildMemberPO;
/*     */ import com.wanniu.game.rank.RankType;
/*     */ import com.wanniu.game.rank.SimpleRankData;
/*     */ import java.time.Duration;
/*     */ import java.time.LocalDate;
/*     */ import java.time.LocalDateTime;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.ScheduledFuture;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RevelryManager
/*     */ {
/*  40 */   private static final RevelryManager instance = new RevelryManager();
/*     */ 
/*     */ 
/*     */   
/*  44 */   private static final Map<String, ScheduledFuture<?>> settlementFutureMap = new ConcurrentHashMap<>();
/*     */   
/*     */   public static RevelryManager getInstance() {
/*  47 */     return instance;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RankType toRankType(int activityKey) {
/*  67 */     switch (activityKey) {
/*     */       case 1:
/*  69 */         return RankType.HP;
/*     */       case 2:
/*  71 */         return RankType.PHY;
/*     */       case 3:
/*  73 */         return RankType.MAGIC;
/*     */       case 4:
/*  75 */         return RankType.XIANYUAN;
/*     */       case 5:
/*  77 */         return RankType.DEMON_TOWER;
/*     */       case 6:
/*  79 */         return RankType.LEVEL;
/*     */       case 7:
/*  81 */         return RankType.FIGHTPOWER;
/*     */       case 8:
/*  83 */         return RankType.GUILD_LEVEL;
/*     */       case 9:
/*  85 */         return RankType.PET;
/*     */       case 10:
/*  87 */         return RankType.Mount;
/*     */       case 11:
/*  89 */         return RankType.ARENA_SCORE;
/*     */       case 12:
/*  91 */         return RankType.PVP_5V5;
/*     */     } 
/*  93 */     return RankType.FIGHTPOWER;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isGuildRankKey(int activityKey) {
/*  98 */     return (activityKey == 8);
/*     */   }
/*     */   
/*     */   public void onLogin(WNPlayer player) {
/* 102 */     LocalDate openServerDate = GWorld.OPEN_SERVER_DATE;
/* 103 */     LocalDate now = LocalDate.now();
/*     */     
/* 105 */     boolean isOpen = GameData.Revelrys.values().stream().filter(v -> (v.isOpen == 1 && now.isBefore(openServerDate.plusDays(v.endDays2)))).findFirst().isPresent();
/* 106 */     player.updateSuperScript(Const.SUPERSCRIPT_TYPE.ACTIVITY_REVELRY, isOpen ? 1 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<RevelryClass> getRevelryClassList() {
/* 113 */     LocalDate openServerDate = GWorld.OPEN_SERVER_DATE;
/* 114 */     LocalDate now = LocalDate.now();
/*     */ 
/*     */     
/* 117 */     List<RevelryCO> templates = GameData.findRevelrys(v -> (v.isOpen == 1 && now.isBefore(openServerDate.plusDays(v.endDays2))));
/* 118 */     templates.sort((o1, o2) -> o1.endDays1 - o2.endDays1);
/*     */ 
/*     */     
/* 121 */     Map<String, RevelryClass> tabCaches = new TreeMap<>();
/*     */     
/* 123 */     for (RevelryCO template : templates) {
/*     */       
/* 125 */       RevelryClass revelryClass = tabCaches.computeIfAbsent(template.activityTab, key -> new RevelryClass(template.activityName1));
/*     */ 
/*     */       
/* 128 */       RevelryToday today = revelryClass.getTodays().computeIfAbsent(template.activityID, key -> new RevelryToday(template.activityName2));
/*     */ 
/*     */       
/* 131 */       RevelryColumn column = new RevelryColumn();
/* 132 */       column.setId(template.tabID);
/* 133 */       column.setName(template.tabName);
/* 134 */       column.setLabel(template.activityKey2);
/* 135 */       column.setGoto1(template.goTo1);
/* 136 */       column.setGoto2(template.goTo2);
/* 137 */       column.setTip(template.activityDesc);
/* 138 */       today.getColumns().add(column);
/*     */ 
/*     */       
/* 141 */       LocalDateTime endTime = GWorld.OPEN_SERVER_DATE.plusDays(template.endDays1).atTime(0, 0, 0, 0);
/* 142 */       long timeleft = Duration.between(LocalDateTime.now(), endTime).getSeconds();
/* 143 */       if (timeleft > 0L && timeleft < today.getTimeleft()) {
/* 144 */         today.setTimeleft(timeleft);
/*     */       }
/*     */     } 
/*     */     
/* 148 */     return new ArrayList<>(tabCaches.values());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onResetOpenServerDate(LocalDate openServerDate) {
/* 155 */     LocalDateTime now = LocalDateTime.now();
/* 156 */     GameData.Revelrys.values().stream().filter(v -> (v.isOpen == 1)).forEach(v -> {
/*     */           ScheduledFuture<?> future = settlementFutureMap.get(v.tabID);
/*     */           if (future != null) {
/*     */             future.cancel(true);
/*     */           }
/*     */           LocalDateTime endTime = openServerDate.plusDays(v.endDays1).atTime(0, 0, 0, 0);
/*     */           if (now.isBefore(endTime)) {
/*     */             long timeleft = Duration.between(now, endTime).getSeconds();
/*     */             settlementFutureMap.put(v.tabID, JobFactory.addDelayJob((), timeleft * 1000L));
/*     */             Out.info(new Object[] { "冲榜活动添加结果任务. tabID=", v.tabID, ",timeleft=", Long.valueOf(timeleft) });
/*     */           } 
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void settlementResult(String tabID) {
/* 178 */     Out.info(new Object[] { "冲榜活动结算。tabID=", tabID });
/*     */     
/* 180 */     RevelryCO template = (RevelryCO)GameData.Revelrys.get(tabID);
/* 181 */     RankType rankType = getInstance().toRankType(template.activityKey);
/* 182 */     Map<Integer, SimpleRankData> rankMap = rankType.getHandler().copyRankToKey(tabID);
/*     */     
/* 184 */     List<RevelryConfigCO> configs = GameData.findRevelryConfigs(v -> tabID.equals(v.type));
/* 185 */     for (RevelryConfigCO config : configs) {
/* 186 */       for (int rank = config.parameter1; rank <= config.parameter2; rank++) {
/* 187 */         SimpleRankData rankData = rankMap.get(Integer.valueOf(rank));
/* 188 */         if (rankData != null)
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 193 */           if (isGuildRankKey(template.activityKey)) {
/* 194 */             sendGuildRankReward(config, template.tabName, rankData.getId(), rank);
/*     */           
/*     */           }
/*     */           else {
/*     */             
/* 199 */             List<MailData.Attachment> attachments = new ArrayList<>();
/* 200 */             buildAttachment(attachments, config.item1code, config.num1);
/* 201 */             buildAttachment(attachments, config.item2code, config.num2);
/* 202 */             buildAttachment(attachments, config.item3code, config.num3);
/* 203 */             buildAttachment(attachments, config.item4code, config.num4);
/*     */             
/* 205 */             sendPlayerRankReward(template.tabName, rankData.getId(), rank, attachments);
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/* 210 */     Out.info(new Object[] { "冲榜活动结算结束。tabID=", tabID });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void sendGuildRankReward(RevelryConfigCO config, String rankName, String guildId, int rank) {
/* 217 */     ArrayList<GuildMemberPO> members = GuildServiceCenter.getInstance().getGuildMemberList(guildId);
/* 218 */     for (GuildMemberPO member : members) {
/* 219 */       List<MailData.Attachment> attachments = new ArrayList<>();
/*     */ 
/*     */       
/* 222 */       if (member.job == Const.GuildJob.PRESIDENT.getValue()) {
/* 223 */         buildAttachment(attachments, config.item1code, config.num1);
/* 224 */         buildAttachment(attachments, config.item2code, config.num2);
/*     */       }
/*     */       else {
/*     */         
/* 228 */         buildAttachment(attachments, config.item3code, config.num3);
/* 229 */         buildAttachment(attachments, config.item4code, config.num4);
/*     */       } 
/*     */       
/* 232 */       sendPlayerRankReward(rankName, member.playerId, rank, attachments);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void sendPlayerRankReward(String rankName, String playerId, int rank, List<MailData.Attachment> attachments) {
/*     */     try {
/* 238 */       MailSysData mailData = new MailSysData("RankRevelryReward");
/* 239 */       mailData.attachments = attachments;
/*     */ 
/*     */       
/* 242 */       mailData.replace = new HashMap<>();
/* 243 */       mailData.replace.put("rankName", rankName);
/* 244 */       mailData.replace.put("rank", String.valueOf(rank));
/*     */       
/* 246 */       MailUtil.getInstance().sendMailToOnePlayer(playerId, (MailData)mailData, Const.GOODS_CHANGE_TYPE.REVELRY);
/* 247 */     } catch (Exception e) {
/* 248 */       Out.warn(new Object[] { "冲榜活动结算时发放奖励异常.rank=", Integer.valueOf(rank), ",playerId=", playerId });
/*     */     } 
/*     */   }
/*     */   
/*     */   private void buildAttachment(List<MailData.Attachment> attachments, String itemCode, int itemNum) {
/* 253 */     if (StringUtils.isNotEmpty(itemCode)) {
/* 254 */       MailData.Attachment item = new MailData.Attachment();
/* 255 */       item.itemCode = itemCode;
/* 256 */       item.itemNum = itemNum;
/* 257 */       attachments.add(item);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\revelry\RevelryManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */