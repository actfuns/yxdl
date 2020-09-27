/*     */ package com.wanniu.game.daoyou;
/*     */ 
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.daoyou.dao.DaoYouDao;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.ext.TeamPropExt;
/*     */ import com.wanniu.game.player.AttributeUtil;
/*     */ import com.wanniu.game.poes.DaoYouMemberPO;
/*     */ import com.wanniu.game.poes.DaoYouPO;
/*     */ import com.wanniu.game.rank.RankType;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ 
/*     */ 
/*     */ public class DaoYouCenter
/*     */ {
/*     */   private static DaoYouCenter instance;
/*     */   public ConcurrentHashMap<String, DaoYouPO> daoYouMap;
/*     */   public ConcurrentHashMap<String, String> daoYouNameMap;
/*     */   public ConcurrentHashMap<String, DaoYouMemberPO> daoYouMemberMap;
/*     */   public ConcurrentHashMap<String, List<String>> daoYouMemberIdMap;
/*     */   public ConcurrentHashMap<String, Map<Const.PlayerBtlData, Integer>> daoYouBtlAdd;
/*     */   
/*     */   public static DaoYouCenter getInstance() {
/*  33 */     if (instance == null) {
/*  34 */       instance = new DaoYouCenter();
/*     */     }
/*  36 */     return instance;
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
/*     */   private DaoYouCenter() {
/*  55 */     this.daoYouMap = new ConcurrentHashMap<>();
/*  56 */     this.daoYouNameMap = new ConcurrentHashMap<>();
/*  57 */     this.daoYouMemberMap = new ConcurrentHashMap<>();
/*  58 */     this.daoYouMemberIdMap = new ConcurrentHashMap<>();
/*  59 */     this.daoYouBtlAdd = new ConcurrentHashMap<>();
/*  60 */     init();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init() {
/*  67 */     List<DaoYouMemberPO> daoYouMemberList = DaoYouDao.getAllDaoYouMember();
/*  68 */     for (DaoYouMemberPO dymp : daoYouMemberList) {
/*  69 */       addDaoYouMember(dymp, true);
/*     */     }
/*     */     
/*  72 */     List<DaoYouPO> daoYouList = DaoYouDao.getAllDaoYouList();
/*  73 */     for (DaoYouPO dyp : daoYouList) {
/*  74 */       addDaoYou(dyp, true);
/*     */ 
/*     */       
/*  77 */       calDaoYouData(dyp.id);
/*     */     } 
/*     */ 
/*     */     
/*  81 */     long period = 86400000L;
/*  82 */     long initialDelay = DateUtil.getFiveDelay();
/*  83 */     JobFactory.addFixedRateJob(new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/*     */             try {
/*  88 */               ConcurrentHashMap<String, DaoYouMemberPO> daoYouMem = (DaoYouCenter.getInstance()).daoYouMemberMap;
/*  89 */               Iterator<Map.Entry<String, DaoYouMemberPO>> daoYouMemIt = daoYouMem.entrySet().iterator();
/*  90 */               while (daoYouMemIt.hasNext()) {
/*  91 */                 Map.Entry<String, DaoYouMemberPO> daoYouMemEntry = daoYouMemIt.next();
/*  92 */                 String daoYouMemPlayer = daoYouMemEntry.getKey();
/*  93 */                 DaoYouMemberPO dymp = daoYouMemEntry.getValue();
/*  94 */                 int needReciveRebate = dymp.todayReciveRebate;
/*  95 */                 Map<String, Integer> todaySendRebate = dymp.todaySendRebate;
/*  96 */                 int todaySendRebateNumber = 0;
/*  97 */                 if (todaySendRebate != null) {
/*  98 */                   for (Iterator<Integer> iterator = todaySendRebate.values().iterator(); iterator.hasNext(); ) { int sendRebateNumber = ((Integer)iterator.next()).intValue();
/*  99 */                     todaySendRebateNumber += sendRebateNumber; }
/*     */                 
/*     */                 }
/* 102 */                 dymp.totalSendRebate += todaySendRebateNumber;
/* 103 */                 dymp.todaySendRebate = null;
/* 104 */                 dymp.totalReciveRebate += needReciveRebate;
/* 105 */                 dymp.todayReciveRebate = 0;
/* 106 */                 if (needReciveRebate > 0) {
/* 107 */                   DaoYouService.getInstance().sendRebateMail(daoYouMemPlayer, needReciveRebate);
/*     */                 }
/* 109 */                 DaoYouDao.updateDaoYouMember(dymp);
/*     */               }
/*     */             
/* 112 */             } catch (Exception e) {
/* 113 */               Out.error(new Object[] { e });
/*     */             } 
/*     */           }
/*     */         }initialDelay, period);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DaoYouPO getDaoYou(String daoYouId) {
/* 126 */     return this.daoYouMap.get(daoYouId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDaoYouId(String daoYouName) {
/* 136 */     return this.daoYouNameMap.get(daoYouName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DaoYouMemberPO getDaoYouMember(String dyMemPlayerId) {
/* 146 */     return this.daoYouMemberMap.get(dyMemPlayerId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<Const.PlayerBtlData, Integer> getDaoYouBtl(String daoYouId) {
/* 156 */     return this.daoYouBtlAdd.get(daoYouId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getAllDaoYouMember(String daoYouId) {
/* 166 */     return this.daoYouMemberIdMap.get(daoYouId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addDaoYou(DaoYouPO dyp, boolean isInit) {
/* 176 */     String dypId = dyp.id;
/* 177 */     if (this.daoYouMap.get(dypId) != null) {
/*     */       return;
/*     */     }
/* 180 */     this.daoYouMap.put(dypId, dyp);
/* 181 */     addDaoYouName(dyp.name, dypId);
/* 182 */     if (!isInit) {
/* 183 */       saveDaoYou(dyp);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addDaoYouName(String logicName, String daoYouId) {
/* 194 */     if (logicName != null && !logicName.isEmpty() && daoYouId != null && !daoYouId.isEmpty()) {
/* 195 */       this.daoYouNameMap.put(logicName, daoYouId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveDaoYou(DaoYouPO dyp) {
/* 205 */     if (dyp == null) {
/*     */       return;
/*     */     }
/* 208 */     DaoYouDao.updateDaoYou(dyp);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addDaoYouMember(DaoYouMemberPO dymp, boolean isInit) {
/* 218 */     String dyMemPlayerId = dymp.playerId;
/* 219 */     if (this.daoYouMemberMap.get(dyMemPlayerId) != null) {
/*     */       return;
/*     */     }
/* 222 */     this.daoYouMemberMap.put(dyMemPlayerId, dymp);
/* 223 */     String daoYouId = dymp.daoYouId;
/* 224 */     List<String> dyMemPIds = this.daoYouMemberIdMap.get(daoYouId);
/* 225 */     if (dyMemPIds == null) {
/* 226 */       dyMemPIds = new ArrayList<>();
/*     */     }
/* 228 */     String playerId = dymp.playerId;
/* 229 */     dyMemPIds.add(playerId);
/* 230 */     this.daoYouMemberIdMap.put(daoYouId, dyMemPIds);
/* 231 */     if (!isInit) {
/* 232 */       saveDaoYouMember(dymp);
/*     */     }
/* 234 */     calDaoYouData(daoYouId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveDaoYouMember(DaoYouMemberPO dymp) {
/* 244 */     if (dymp == null) {
/*     */       return;
/*     */     }
/* 247 */     DaoYouDao.updateDaoYouMember(dymp);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeDaoYou(String daoYouId) {
/* 256 */     DaoYouPO dyp = this.daoYouMap.get(daoYouId);
/* 257 */     String dypName = dyp.name;
/* 258 */     this.daoYouNameMap.remove(dypName);
/* 259 */     this.daoYouMap.remove(daoYouId);
/* 260 */     this.daoYouBtlAdd.remove(daoYouId);
/* 261 */     DaoYouDao.removeDaoYou(dyp);
/*     */     
/* 263 */     RankType.DAOYOU.getHandler().delRankMember(GWorld.__SERVER_ID, daoYouId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeDaoYouMember(String dyMemPlayerId) {
/* 272 */     DaoYouMemberPO dymp = this.daoYouMemberMap.get(dyMemPlayerId);
/* 273 */     if (dymp == null) {
/*     */       return;
/*     */     }
/* 276 */     String dyId = dymp.daoYouId;
/* 277 */     List<String> dyMemPlayerIds = this.daoYouMemberIdMap.get(dyId);
/* 278 */     if (dyMemPlayerIds.size() == 2) {
/* 279 */       this.daoYouMemberIdMap.remove(dyId);
/* 280 */       removeDaoYou(dyId);
/* 281 */       DaoYouMemberPO dympA = this.daoYouMemberMap.get(dyMemPlayerIds.get(0));
/* 282 */       DaoYouMemberPO dympB = this.daoYouMemberMap.get(dyMemPlayerIds.get(1));
/* 283 */       this.daoYouMemberMap.remove(dyMemPlayerIds.get(0));
/* 284 */       this.daoYouMemberMap.remove(dyMemPlayerIds.get(1));
/* 285 */       DaoYouDao.removeDaoYouMember(dympA);
/* 286 */       DaoYouDao.removeDaoYouMember(dympB);
/*     */     } else {
/* 288 */       dyMemPlayerIds.remove(dyMemPlayerId);
/* 289 */       calDaoYouData(dyId);
/* 290 */       this.daoYouMemberMap.remove(dyMemPlayerId);
/* 291 */       DaoYouDao.removeDaoYouMember(dymp);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void calDaoYouData(String daoYouId) {
/* 302 */     Map<Const.PlayerBtlData, Integer> thisDaoYouBtlAdd = getDaoYouBtl(daoYouId);
/* 303 */     if (thisDaoYouBtlAdd == null) {
/* 304 */       thisDaoYouBtlAdd = new HashMap<>();
/*     */     } else {
/* 306 */       thisDaoYouBtlAdd.clear();
/*     */     } 
/* 308 */     List<TeamPropExt> props = GameData.findTeamProps(t -> (t.iD == 1));
/* 309 */     if (props.isEmpty())
/*     */       return; 
/* 311 */     TeamPropExt prop = props.get(0);
/* 312 */     List<String> dyMemPlayerId = getAllDaoYouMember(daoYouId);
/* 313 */     if (dyMemPlayerId == null) {
/* 314 */       Out.error(new Object[] { daoYouId, "============找不到成员" });
/*     */       return;
/*     */     } 
/* 317 */     int length = dyMemPlayerId.size();
/* 318 */     for (int i = 0; i < length - 1; i++) {
/* 319 */       AttributeUtil.addData2AllDataByKey(prop.attrs, thisDaoYouBtlAdd);
/*     */     }
/* 321 */     this.daoYouBtlAdd.put(daoYouId, thisDaoYouBtlAdd);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\daoyou\DaoYouCenter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */