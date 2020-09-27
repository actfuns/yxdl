/*     */ package com.wanniu.game.guild.guildBoss;
/*     */ 
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.tcp.protocol.Message;
/*     */ import com.wanniu.game.common.msg.MessagePush;
/*     */ import com.wanniu.game.guild.GuildServiceCenter;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.GuildPO;
/*     */ import com.wanniu.game.poes.PlayerPO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import pomelo.area.GuildBossHandler;
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
/*     */ 
/*     */ public class GuildBossAreaHurtRankCenter
/*     */ {
/*  47 */   public static GuildBossAreaHurtRankCenter instance = new GuildBossAreaHurtRankCenter();
/*     */   
/*  49 */   public static final Comparator<RankBean> SORT_HURT = new Comparator<RankBean>() {
/*     */       public int compare(RankBean o1, RankBean o2) {
/*  51 */         if (o1.getHurt() > o2.getHurt())
/*  52 */           return -1; 
/*  53 */         if (o1.getHurt() < o2.getHurt()) {
/*  54 */           return 1;
/*     */         }
/*  56 */         return 0;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*  62 */   public static final Comparator<GuildRankBean> SORT_GUILD = new Comparator<GuildRankBean>() {
/*     */       public int compare(GuildRankBean o1, GuildRankBean o2) {
/*  64 */         if (o1.getBossKillTime() > o2.getBossKillTime())
/*  65 */           return 1; 
/*  66 */         if (o1.getBossKillTime() < o2.getBossKillTime()) {
/*  67 */           return -1;
/*     */         }
/*  69 */         return 0;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*  75 */   public static final Comparator<GuildRankBean> SORT_GUILD_HURT = new Comparator<GuildRankBean>() {
/*     */       public int compare(GuildRankBean o1, GuildRankBean o2) {
/*  77 */         if (o1.getTotalHurt() > o2.getTotalHurt())
/*  78 */           return -1; 
/*  79 */         if (o1.getTotalHurt() < o2.getTotalHurt()) {
/*  80 */           return 1;
/*     */         }
/*  82 */         if (o1.getBossKillTime() > o2.getBossKillTime())
/*  83 */           return 1; 
/*  84 */         if (o1.getBossKillTime() < o2.getBossKillTime()) {
/*  85 */           return -1;
/*     */         }
/*  87 */         return 0;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  94 */   public static final Comparator<GuildRankBean> SORT_GUILD_ONLY_HURT = new Comparator<GuildRankBean>() {
/*     */       public int compare(GuildRankBean o1, GuildRankBean o2) {
/*  96 */         if (o1.getTotalHurt() > o2.getTotalHurt())
/*  97 */           return -1; 
/*  98 */         if (o1.getTotalHurt() < o2.getTotalHurt()) {
/*  99 */           return 1;
/*     */         }
/* 101 */         return 0;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 106 */   private Map<String, GuildRankBean> dataMap = new ConcurrentHashMap<>();
/* 107 */   private Map<String, List<RankBean>> oldData = new ConcurrentHashMap<>();
/* 108 */   private List<GuildRankBean> guildList = new ArrayList<>();
/* 109 */   private Map<String, RankBean> totalHurtMap = new HashMap<>();
/* 110 */   private List<RankBean> totalHurtList = new ArrayList<>();
/*     */   private boolean isChanged = false;
/*     */   
/*     */   public void processSortHurtRank(String guildId, Collection<String> pushRoleIds, boolean isForcePush, long bossKillTime, boolean hasKilled) {
/* 114 */     GuildRankBean bean = getGuildRankBean(guildId);
/* 115 */     processSortHurtRank(guildId, pushRoleIds, isForcePush);
/* 116 */     if (bossKillTime > 0L && !bean.hasKilled() && !hasKilled) {
/* 117 */       bean.setBossKillTime(bossKillTime);
/*     */     }
/* 119 */     if (!bean.hasKilled() && hasKilled) {
/* 120 */       bean.setHasKilled(true);
/* 121 */       bean.setBossKillTime(bossKillTime);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void overStaticsRanks(String guildId, Collection<String> roleIds) {
/* 129 */     GuildRankBean bean = getGuildRankBean(guildId);
/* 130 */     bean.sort();
/* 131 */     processSortHurtRank(guildId, roleIds, true);
/* 132 */     pushOverRanks(roleIds, bean);
/*     */   }
/*     */   
/*     */   public void pushOverRanks(Collection<String> roleIds, GuildRankBean bean) {
/* 136 */     for (String pId : roleIds) {
/* 137 */       WNPlayer py = PlayerUtil.getOnlinePlayer(pId);
/* 138 */       if (py != null) {
/* 139 */         RankBean myBean = bean.onlyGetRankBean(pId);
/* 140 */         int myRank = (myBean == null) ? 0 : myBean.getGuildRank();
/* 141 */         long hurt = (myBean == null) ? 0L : myBean.getHurt();
/* 142 */         GuildBossHandler.OnEndGuildBossPush.Builder msg = GuildBossHandler.OnEndGuildBossPush.newBuilder();
/* 143 */         msg.setInfo(String.format(LangService.getValue("GUILD_BOSS_END_DETAIL_INFO"), new Object[] { convertNumToStr(hurt), String.valueOf(myRank) }));
/* 144 */         msg.setSec(GlobalConfig.GuildBoss_LeaveTime);
/* 145 */         MessagePush push = new MessagePush("area.guildBossPush.onEndGuildBossPush", (GeneratedMessage)msg.build());
/* 146 */         py.receive((Message)push);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void processSortHurtRank(String guildId, Collection<String> pushRoleIds, boolean isForcePush) {
/* 157 */     if (isForcePush) {
/* 158 */       pushRankData(pushRoleIds, guildId);
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/* 164 */       if (pushRoleIds == null || pushRoleIds.isEmpty()) {
/*     */         return;
/*     */       }
/* 167 */       for (RankBean bean : this.totalHurtList) {
/* 168 */         bean.reset();
/*     */       }
/* 170 */       sort(this.totalHurtList);
/* 171 */       Collections.sort(this.guildList, SORT_GUILD_ONLY_HURT);
/* 172 */       pushRankData(pushRoleIds, guildId);
/*     */     } 
/*     */   }
/*     */   
/*     */   private GuildBossHandler.HurtRankInfo.Builder getHurtRankInfo(int rank, String playerId, long hurt) {
/* 177 */     PlayerPO playerBase = PlayerUtil.getPlayerBaseData(playerId);
/* 178 */     if (playerBase != null) {
/* 179 */       GuildBossHandler.HurtRankInfo.Builder bd = GuildBossHandler.HurtRankInfo.newBuilder();
/* 180 */       bd.setHurt(hurt);
/* 181 */       bd.setRank(rank);
/* 182 */       bd.setId(playerId);
/* 183 */       bd.setName(playerBase.name);
/* 184 */       return bd;
/*     */     } 
/* 186 */     return null;
/*     */   }
/*     */   
/*     */   private GuildBossHandler.HurtRankInfo.Builder getGuildHurtRankInfo(int rank, String guildId, long hurt) {
/* 190 */     GuildPO guildPO = GuildServiceCenter.getInstance().getGuild(guildId);
/* 191 */     if (guildPO != null) {
/* 192 */       GuildBossHandler.HurtRankInfo.Builder bd = GuildBossHandler.HurtRankInfo.newBuilder();
/* 193 */       bd.setHurt(hurt);
/* 194 */       bd.setRank(rank);
/* 195 */       bd.setId(guildId);
/* 196 */       bd.setName(guildPO.name);
/* 197 */       return bd;
/*     */     } 
/* 199 */     return null;
/*     */   }
/*     */   
/*     */   private void sort(List<RankBean> list) {
/* 203 */     Collections.sort(list, SORT_HURT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void pushRankData(Collection<String> pushRoleIds, String guildId) {
/* 212 */     if (pushRoleIds == null || pushRoleIds.isEmpty()) {
/*     */       return;
/*     */     }
/* 215 */     GuildBossHandler.OnHurtRankChangePush.Builder msg = GuildBossHandler.OnHurtRankChangePush.newBuilder();
/* 216 */     msg.setS2CCode(200);
/* 217 */     if (this.totalHurtList != null && !this.totalHurtList.isEmpty())
/*     */     {
/* 219 */       for (int i = 0; i < this.totalHurtList.size(); i++) {
/* 220 */         RankBean bean = this.totalHurtList.get(i);
/* 221 */         int rank = i + 1;
/* 222 */         bean.setRank(rank);
/* 223 */         if (i <= 9) {
/* 224 */           GuildBossHandler.HurtRankInfo.Builder bd = getHurtRankInfo(rank, bean.getId(), bean.getHurt());
/* 225 */           if (bd != null) {
/* 226 */             msg.addOtherInfo(bd);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 232 */     if (this.guildList != null && !this.guildList.isEmpty()) {
/*     */       
/* 234 */       int rank = 0;
/* 235 */       for (int i = 0; i < this.guildList.size(); i++) {
/* 236 */         GuildRankBean bean = this.guildList.get(i);
/* 237 */         long totalHurt = bean.getTotalHurt();
/* 238 */         if (rank <= 10 && totalHurt > 0L) {
/* 239 */           GuildBossHandler.HurtRankInfo.Builder bd = getGuildHurtRankInfo(++rank, bean.getGuildId(), totalHurt);
/* 240 */           if (bd != null) {
/* 241 */             msg.addOtherGuildInfo(bd);
/*     */           }
/*     */         } 
/*     */         
/* 245 */         if (guildId.equals(bean.getGuildId())) {
/* 246 */           int myRank = (totalHurt <= 0L) ? 0 : rank;
/* 247 */           GuildBossHandler.HurtRankInfo.Builder myGuildInfo = getGuildHurtRankInfo(myRank, bean.getGuildId(), totalHurt);
/* 248 */           if (myGuildInfo != null) {
/* 249 */             msg.setMyGuildInfo(myGuildInfo);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 255 */     msg.setJoinCount(pushRoleIds.size());
/*     */     
/* 257 */     for (String pId : pushRoleIds) {
/* 258 */       WNPlayer py = PlayerUtil.getOnlinePlayer(pId);
/* 259 */       if (py != null) {
/* 260 */         RankBean myBean = this.totalHurtMap.get(pId);
/* 261 */         int myRank = (myBean == null) ? 0 : myBean.getRank();
/* 262 */         long hurt = (myBean == null) ? 0L : myBean.getHurt();
/* 263 */         GuildBossHandler.HurtRankInfo.Builder myInfo = getHurtRankInfo(myRank, pId, hurt);
/* 264 */         if (myInfo != null) {
/* 265 */           msg.setMyInfo(myInfo);
/*     */         }
/* 267 */         py.receive("area.guildBossPush.onHurtRankChangePush", (GeneratedMessage)msg.build());
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void clearRankData() {
/* 273 */     this.totalHurtMap.clear();
/* 274 */     this.totalHurtList.clear();
/*     */   }
/*     */   
/*     */   public static String convertNumToStr(long hurt) {
/* 278 */     long T1 = (long)Math.pow(10.0D, 8.0D);
/* 279 */     long T2 = (long)Math.pow(10.0D, 5.0D);
/* 280 */     long T3 = (long)Math.pow(10.0D, 2.0D);
/* 281 */     long T4 = (long)Math.pow(10.0D, 6.0D);
/* 282 */     if (hurt / T1 >= 1L) {
/* 283 */       hurt = (long)Math.floor(((float)hurt * 1.0F / (float)T4));
/* 284 */       return String.format("%.2f", new Object[] { Float.valueOf((float)hurt * 1.0F / (float)T3) }) + "亿";
/* 285 */     }  if (hurt / T2 >= 1L) {
/* 286 */       hurt = (long)Math.floor(((float)hurt * 1.0F / (float)T3));
/* 287 */       return String.format("%.2f", new Object[] { Float.valueOf((float)hurt * 1.0F / (float)T3) }) + "万";
/*     */     } 
/* 289 */     return String.valueOf(hurt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void processOver(String guildId) {
/* 298 */     GuildRankBean bean = getGuildRankBean(guildId);
/* 299 */     if (bean.getHurtList() == null || bean.getHurtList().isEmpty()) {
/*     */       return;
/*     */     }
/* 302 */     List<RankBean> newList = new ArrayList<>(bean.getHurtList());
/* 303 */     sort(newList);
/* 304 */     replaceShowData(guildId, newList);
/* 305 */     GuildBossAreaHurtRankService.getInstance().saveAfterOver(guildId, newList);
/*     */   }
/*     */   
/*     */   public void clearOldData() {
/* 309 */     this.dataMap.clear();
/* 310 */     this.guildList.clear();
/* 311 */     clearRankData();
/*     */   }
/*     */   
/*     */   public void replaceShowData(String guildId, List<RankBean> newList) {
/* 315 */     synchronized (this.oldData) {
/* 316 */       this.oldData.put(guildId, newList);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void replaceIfnullShowData(String guildId, List<RankBean> newList) {
/* 327 */     synchronized (this.oldData) {
/* 328 */       List<RankBean> currentList = this.oldData.get(guildId);
/* 329 */       if (currentList == null) {
/* 330 */         this.oldData.put(guildId, newList);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isChanged() {
/* 336 */     return this.isChanged;
/*     */   }
/*     */   
/*     */   public void setChanged(boolean isChanged) {
/* 340 */     this.isChanged = isChanged;
/*     */   }
/*     */   
/*     */   public void setNewData(String guildId, String playerId, long hurt, int enterCount) {
/* 344 */     RankBean bean = getAndSetRankBean(playerId);
/* 345 */     bean.setNewData(enterCount, hurt);
/* 346 */     if (!this.isChanged) {
/* 347 */       this.isChanged = true;
/*     */     }
/* 349 */     GuildRankBean guildBean = getGuildRankBean(guildId);
/* 350 */     guildBean.setRankBeanIfNull(bean);
/*     */   }
/*     */   
/*     */   public GuildRankBean getGuildRankBean(String guildId) {
/* 354 */     GuildRankBean bean = this.dataMap.get(guildId);
/* 355 */     if (bean == null) {
/* 356 */       bean = new GuildRankBean(guildId);
/* 357 */       this.dataMap.put(guildId, bean);
/* 358 */       this.guildList.add(bean);
/*     */     } 
/* 360 */     return bean;
/*     */   }
/*     */   
/*     */   public RankBean getAndSetRankBean(String playerId) {
/* 364 */     RankBean bean = this.totalHurtMap.get(playerId);
/* 365 */     if (bean == null) {
/* 366 */       bean = new RankBean();
/* 367 */       bean.setId(playerId);
/* 368 */       this.totalHurtMap.put(playerId, bean);
/* 369 */       this.totalHurtList.add(bean);
/*     */     } 
/* 371 */     return bean;
/*     */   }
/*     */   
/*     */   public GuildRankBean onlyGetGuildRankBean(String guildId) {
/* 375 */     return this.dataMap.get(guildId);
/*     */   }
/*     */   
/*     */   public Map<String, GuildRankBean> getDataMap() {
/* 379 */     return this.dataMap;
/*     */   }
/*     */   
/*     */   public List<RankBean> getRankList(String guildId) {
/* 383 */     return this.oldData.get(guildId);
/*     */   }
/*     */   
/*     */   public static class GuildStaticRankBean {
/*     */     private String guildId;
/*     */     private long totalHurt;
/*     */     private int seconds;
/*     */     
/*     */     public String getGuildId() {
/* 392 */       return this.guildId;
/*     */     }
/*     */     
/*     */     public void setGuildId(String guildId) {
/* 396 */       this.guildId = guildId;
/*     */     }
/*     */     
/*     */     public long getTotalHurt() {
/* 400 */       return this.totalHurt;
/*     */     }
/*     */     
/*     */     public void setTotalHurt(long totalHurt) {
/* 404 */       this.totalHurt = totalHurt;
/*     */     }
/*     */     
/*     */     public int getSeconds() {
/* 408 */       return this.seconds;
/*     */     }
/*     */     
/*     */     public void setSeconds(int seconds) {
/* 412 */       this.seconds = seconds;
/*     */     }
/*     */     
/*     */     public static GuildStaticRankBean getGuildStaticRankBean(GuildRankBean bean) {
/* 416 */       GuildStaticRankBean rb = new GuildStaticRankBean();
/* 417 */       rb.setGuildId(bean.getGuildId());
/* 418 */       rb.setTotalHurt(bean.getTotalHurt());
/* 419 */       if (bean.hasKilled()) {
/* 420 */         rb.setSeconds((int)((bean.getBossKillTime() - GuildBossCenter.getInstance().getBeginTime()) / 1000L));
/*     */       }
/* 422 */       return rb;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static GuildBossAreaHurtRankCenter getInstance() {
/* 429 */     return instance;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guildBoss\GuildBossAreaHurtRankCenter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */