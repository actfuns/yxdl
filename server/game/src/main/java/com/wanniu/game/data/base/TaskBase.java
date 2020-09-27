/*     */ package com.wanniu.game.data.base;public abstract class TaskBase { public int iD; public String name; public int kind; public int show; public int type; public int isFail; public int failRelation; public int failCondition; public int upOrder; public int level; public int upLimit; public int levelLimit; public String difficulty; public String job; public int taskCycle; public int beforeRelations; public String before; public String next; public int limitTime; public String targetID; public String targetName; public int quantity; public String targetFromID; public String sourceRemark; public String questTC; public int minLevel; public int maxLevel; public int diff; public int openWay; public String open; public String festivalStart; public String festivalEnd; public String openTime; public String endTime; public int count; public int finishTimes; public int isFastComplete; public int fastCompleteCost;
/*     */   public int isDouble;
/*     */   public int doubleCost;
/*     */   public String acceptItem;
/*     */   public String beforePrompt;
/*     */   public String goToBefore;
/*     */   public String des;
/*     */   public String prompt;
/*     */   public int giveNpc;
/*     */   public String giveNpcName;
/*     */   public String acceptDialogue;
/*     */   public int exp;
/*     */   public int upExp;
/*     */   
/*     */   public Integer getKey() {
/*  16 */     return Integer.valueOf(this.iD);
/*     */   }
/*     */   public int expRatio; public int gold; public String tcReward; public String warriorReward; public String assassinReward; public String magicianReward; public String hunterReward; public String ministerReward; public String rewardName; public String soulItem; public int startScene; public int startPoint; public int doScene; public int doPoint; public int isTransfer; public String funID; public String taskFunID; public String specialTips; public int submitScene; public int submitPoint; public String secretTransfer; public String acceptBtn; public String rejectBtn; public String acceptContent; public String goToAccept; public String goToComplete; public String afterPrompt; public String afterPromptBtn; public String reward; public String rewardBtn; public int completeNpc; public String completeNpcName; public String changePrompt; public String acceptSys; public String rewardSys; public int nPCchat; public int showItem; public int notEffected; public String needNpcID; public String needNpcName; public int needState; public String createPos; public int overState; public String overPos; public int isAuto; public String circleOutPOS; public int circleDungeonID; public int[] loopOutPos; public String modID; public int overState2; public int pro;
/*     */   public int getId() {
/*  20 */     return this.iD;
/*     */   }
/*     */   
/*     */   public int getKind() {
/*  24 */     return this.kind;
/*     */   }
/*     */   
/*     */   public int getType() {
/*  28 */     return this.type;
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
/* 230 */   public List<Integer> needNpcs = new ArrayList<>();
/*     */   
/* 232 */   public Map<Integer, List<ItemNode>> rewards = new HashMap<>(0);
/* 233 */   public List<ItemNode> accepTaskRewards = new ArrayList<>(0);
/* 234 */   public String[] beforeTask = new String[0];
/* 235 */   public String[] nextTask = new String[0];
/* 236 */   public List<String> targets = new ArrayList<>();
/* 237 */   public String[] targetFromIds = new String[0];
/* 238 */   public String[] openDay = new String[0];
/*     */   
/*     */   public static class ItemNode {
/*     */     public String itemCode;
/*     */     public int itemNum;
/*     */     public int isBind;
/*     */     
/*     */     public ItemNode(String itemCode, int itemNum) {
/* 246 */       this.itemCode = itemCode;
/* 247 */       this.itemNum = itemNum;
/*     */     }
/*     */     
/*     */     public ItemNode(String itemCode, int itemNum, int isBind) {
/* 251 */       this(itemCode, itemNum);
/* 252 */       this.isBind = isBind;
/*     */     }
/*     */   }
/*     */   
/*     */   public final boolean isTarget(String id) {
/* 257 */     if (this.targets != null) {
/* 258 */       for (int i = 0; i < this.targets.size(); i++) {
/* 259 */         if (((String)this.targets.get(i)).equals(id)) {
/* 260 */           return true;
/*     */         }
/*     */       } 
/*     */     }
/* 264 */     return false;
/*     */   }
/*     */   
/*     */   public final boolean isTargetFormId(String id) {
/* 268 */     if (this.targetFromIds != null) {
/* 269 */       for (int i = 0; i < this.targetFromIds.length; i++) {
/* 270 */         if (id.equals(this.targetFromIds[i])) {
/* 271 */           return true;
/*     */         }
/*     */       } 
/*     */     }
/* 275 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void beforeProperty() {}
/*     */   
/*     */   public void initProperty() {
/* 282 */     this.pro = Const.PlayerPro.Value(this.job);
/*     */     
/* 284 */     this.rewards = new HashMap<>();
/* 285 */     List<ItemNode> nodes = new ArrayList<>();
/* 286 */     nodes.add(new ItemNode("gold", this.gold));
/* 287 */     nodes.add(new ItemNode("exp", this.exp));
/* 288 */     nodes.add(new ItemNode("upexp", this.upExp));
/* 289 */     this.rewards.put(Integer.valueOf(Const.PlayerPro.COMMON.value), nodes);
/* 290 */     this.rewards.put(Integer.valueOf(Const.PlayerPro.CANG_LANG.value), getReward(this.warriorReward));
/* 291 */     this.rewards.put(Integer.valueOf(Const.PlayerPro.YU_JIAN.value), getReward(this.assassinReward));
/* 292 */     this.rewards.put(Integer.valueOf(Const.PlayerPro.YI_XIAN.value), getReward(this.magicianReward));
/* 293 */     this.rewards.put(Integer.valueOf(Const.PlayerPro.SHEN_JIAN.value), getReward(this.hunterReward));
/* 294 */     this.rewards.put(Integer.valueOf(Const.PlayerPro.LI_NHU.value), getReward(this.ministerReward));
/*     */ 
/*     */     
/* 297 */     this.accepTaskRewards = getReward(this.acceptItem.split(","));
/*     */     
/* 299 */     if (StringUtil.isNotEmpty(this.before)) {
/* 300 */       this.beforeTask = this.before.split(":");
/*     */     }
/* 302 */     if (StringUtil.isNotEmpty(this.next)) {
/* 303 */       this.nextTask = this.next.split(":");
/*     */     }
/* 305 */     this.targets = Arrays.asList(this.targetID.split(":"));
/* 306 */     this.targetFromIds = this.targetFromID.split(":");
/*     */     
/* 308 */     if (this.quantity <= 0) {
/* 309 */       Out.warn(new Object[] { "策划数据有问题!!! 任务表, id:", Integer.valueOf(this.iD), ",任务目标需求数量:", Integer.valueOf(this.quantity), ",这样会导致任务直接完成!!!!!!" });
/*     */     }
/* 311 */     this.openDay = this.open.split(",");
/*     */ 
/*     */     
/* 314 */     if (StringUtil.isNotEmpty(this.needNpcID)) {
/* 315 */       String[] npcs = this.needNpcID.split("\\|");
/* 316 */       for (int i = 0; i < npcs.length; i++) {
/* 317 */         this.needNpcs.add(Integer.valueOf(Integer.parseInt(npcs[i])));
/*     */       }
/*     */     } 
/*     */     
/* 321 */     if (StringUtil.isNotEmpty(this.circleOutPOS)) {
/* 322 */       this.loopOutPos = new int[2];
/* 323 */       String[] circlePOSes = this.circleOutPOS.split(",");
/* 324 */       int index = 0;
/* 325 */       for (String pos : circlePOSes) {
/* 326 */         this.loopOutPos[index] = (int)Float.parseFloat(pos);
/* 327 */         index++;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private List<ItemNode> getReward(String reward) {
/* 333 */     return getReward(reward.split("\\|"));
/*     */   }
/*     */   
/*     */   private List<ItemNode> getReward(String[] rewards) {
/* 337 */     List<ItemNode> data = new ArrayList<>();
/* 338 */     for (String v : rewards) {
/* 339 */       if (v.trim().length() > 0) {
/* 340 */         String[] str = v.split(":");
/* 341 */         String itemCode = str[0];
/* 342 */         int itemNum = Integer.parseInt(str[1]);
/* 343 */         int isBind = 1;
/* 344 */         if (str.length >= 3) {
/* 345 */           isBind = Integer.parseInt(str[2]);
/*     */         }
/* 347 */         data.add(new ItemNode(itemCode, itemNum, isBind));
/*     */       } 
/*     */     } 
/* 350 */     return data;
/*     */   } }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\base\TaskBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */