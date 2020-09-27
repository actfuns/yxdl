/*     */ package com.wanniu.game.guild.guidDepot;
/*     */ 
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.GuildBuildingCO;
/*     */ import com.wanniu.game.data.WareHouseLevelCO;
/*     */ import com.wanniu.game.data.ext.GuildSettingExt;
/*     */ import com.wanniu.game.guild.GuildMsg;
/*     */ import com.wanniu.game.guild.GuildService;
/*     */ import com.wanniu.game.guild.GuildUtil;
/*     */ import com.wanniu.game.guild.RecordInfo;
/*     */ import com.wanniu.game.guild.RoleInfo;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.item.po.PlayerItemPO;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.poes.GuildDepotPO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import pomelo.area.GuildDepotHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuildDepot
/*     */ {
/*     */   public GuildDepotPO depotData;
/*     */   public EquipBag bag;
/*     */   public int deleteCount;
/*     */   
/*     */   public GuildDepot(GuildDepotPO depotData) {
/*  31 */     this.depotData = depotData;
/*  32 */     this.bag = new EquipBag(depotData.bag);
/*     */     
/*  34 */     WareHouseLevelCO levelProp = GuildUtil.getDepotLevelProp(this.depotData.level);
/*  35 */     this.bag.bagTotalCount = levelProp.spece;
/*     */   }
/*     */   
/*     */   public static GuildDepot createEmptyDepot(String guildId, int logicServerId) {
/*  39 */     GuildDepotPO depotData = new GuildDepotPO();
/*  40 */     GuildBuildingCO buildProp = GuildUtil.getGuildBuildingProp(Const.GuildBuilding.DEPOT.getValue());
/*  41 */     depotData.id = guildId;
/*  42 */     depotData.logicServerId = logicServerId;
/*  43 */     depotData.level = buildProp.minLv;
/*  44 */     depotData.createTime = new Date();
/*  45 */     int maxUpLevel = GlobalConfig.Role_Upgrade_LevelLimit;
/*     */     
/*  47 */     GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
/*     */     
/*  49 */     GuildDepotCondition condition = new GuildDepotCondition();
/*  50 */     GuildCond useCond = new GuildCond();
/*  51 */     useCond.level = settingProp.joinLv;
/*  52 */     useCond.upLevel = 0;
/*  53 */     useCond.job = Const.GuildJob.MEMBER.getValue();
/*  54 */     condition.useCond = useCond;
/*     */     
/*  56 */     GuildCond minCond = new GuildCond();
/*  57 */     minCond.level = settingProp.warehouseMinLv;
/*  58 */     minCond.upLevel = 0;
/*  59 */     minCond.qColor = settingProp.warehouseMinQ;
/*  60 */     condition.minCond = minCond;
/*     */     
/*  62 */     GuildCond maxCond = new GuildCond();
/*  63 */     maxCond.level = 100;
/*  64 */     maxCond.upLevel = maxUpLevel;
/*  65 */     maxCond.qColor = 5;
/*  66 */     condition.maxCond = maxCond;
/*     */     
/*  68 */     WareHouseLevelCO levelProp = GuildUtil.getDepotLevelProp(1);
/*  69 */     depotData.bag.bagGridCount = levelProp.spece;
/*  70 */     depotData.bag.bagGrids = new HashMap<>();
/*  71 */     depotData.bag.bagTotalCount = levelProp.spece;
/*     */     
/*  73 */     depotData.condition = condition;
/*  74 */     depotData.news = new ArrayList();
/*  75 */     depotData.deleteCount = 0;
/*     */     
/*  77 */     return new GuildDepot(depotData);
/*     */   }
/*     */   
/*     */   public int getDeleteCount() {
/*  81 */     if (null == this.depotData.refreshTime || DateUtil.canRefreshData(5, this.depotData.refreshTime)) {
/*  82 */       this.deleteCount = 0;
/*  83 */       this.depotData.refreshTime = new Date();
/*     */     } 
/*  85 */     return this.deleteCount;
/*     */   }
/*     */   
/*     */   public GuildDepotPO toJson4Serialize() {
/*  89 */     GuildDepotPO data = new GuildDepotPO();
/*  90 */     data.id = this.depotData.id;
/*  91 */     data.logicServerId = this.depotData.logicServerId;
/*  92 */     data.level = this.depotData.level;
/*  93 */     data.createTime = this.depotData.createTime;
/*  94 */     data.condition = this.depotData.condition;
/*  95 */     data.news = this.depotData.news;
/*  96 */     data.bag = this.bag.toJson4Serialize();
/*  97 */     data.deleteCount = getDeleteCount();
/*  98 */     data.refreshTime = this.depotData.refreshTime;
/*  99 */     return data;
/*     */   }
/*     */   
/*     */   public GuildDepotPO getDepotInfo() {
/* 103 */     GuildDepotPO data = new GuildDepotPO();
/* 104 */     GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
/* 105 */     data.level = this.depotData.level;
/* 106 */     data.condition.useCond = this.depotData.condition.useCond;
/* 107 */     data.condition.minCond = this.depotData.condition.minCond;
/* 108 */     data.condition.maxCond = this.depotData.condition.maxCond;
/* 109 */     data.deleteCount = getDeleteCount();
/* 110 */     data.deleteCountMax = settingProp.warehouseDel;
/* 111 */     return data;
/*     */   }
/*     */   
/*     */   public ArrayList<RecordInfo> getRecordList(int page) {
/* 115 */     ArrayList<RecordInfo> list = new ArrayList<>();
/* 116 */     int perPageNum = 50;
/* 117 */     int startIndex = (page - 1) * perPageNum;
/* 118 */     int endIndex = startIndex + perPageNum;
/* 119 */     for (int i = startIndex; i < this.depotData.news.size() && i < endIndex; i++) {
/* 120 */       GuildRecordData record = this.depotData.news.get(i);
/* 121 */       RecordInfo tempInfo = new RecordInfo();
/* 122 */       tempInfo.time = DateUtil.format(record.time, "MM-dd HH:mm:ss");
/* 123 */       if (null != record.role1 && record.role1.pro > 0) {
/* 124 */         RoleInfo role1 = new RoleInfo();
/* 125 */         role1.pro = record.role1.pro;
/* 126 */         role1.name = record.role1.name;
/* 127 */         tempInfo.role1 = role1;
/*     */       } 
/*     */       
/* 130 */       if (null != record.role2 && record.role2.pro > 0) {
/* 131 */         RoleInfo role2 = new RoleInfo();
/* 132 */         role2.pro = record.role2.pro;
/* 133 */         role2.name = record.role2.name;
/* 134 */         tempInfo.role2 = role2;
/*     */       } 
/*     */       
/* 137 */       if (null != record.result.v2 && !record.result.v2.isEmpty()) {
/* 138 */         tempInfo.resultStr = record.result.v2;
/*     */       }
/*     */       
/* 141 */       if (null != record.item && !record.item.name.isEmpty()) {
/* 142 */         tempInfo.item = record.item;
/*     */       }
/*     */       
/* 145 */       tempInfo.recordType = record.type;
/* 146 */       list.add(tempInfo);
/*     */     } 
/* 148 */     return list;
/*     */   }
/*     */   
/*     */   public boolean testEmptyGridLarge(int num) {
/* 152 */     int actNum = (num > 0) ? num : 1;
/* 153 */     return (this.bag.emptyGridNum() >= actNum);
/*     */   }
/*     */   
/*     */   public void saveToRedis() {
/* 157 */     GuildDepotPO data = toJson4Serialize();
/* 158 */     GuildUtil.updateGuildDepot(data);
/*     */   }
/*     */   
/*     */   public int addEquip(NormalItem equip, String playerId) {
/* 162 */     int addIndex = this.bag.addItem(equip);
/* 163 */     if (addIndex < 0) {
/* 164 */       return addIndex;
/*     */     }
/*     */     
/* 167 */     saveToRedis();
/* 168 */     GuildMsg.DepotRefreshGuildMsg msgData = new GuildMsg.DepotRefreshGuildMsg();
/* 169 */     msgData.bagIndex = addIndex;
/* 170 */     GuildMsg msg = new GuildMsg(Const.NotifyType.DEPOT_DEPOSIT_PUSH.getValue(), (GuildMsg.GuildMsgData)msgData);
/* 171 */     GuildService.notifyAllMemberRefreshGuild(this.depotData.id, msg, playerId);
/* 172 */     return addIndex;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeEquip(int bagIndex, String playerId, boolean isDelete) {
/* 177 */     int removeIndex = this.bag.removeItemByPos(bagIndex);
/* 178 */     if (removeIndex < 0) {
/* 179 */       return false;
/*     */     }
/*     */     
/* 182 */     if (isDelete) {
/* 183 */       this.deleteCount++;
/*     */     }
/*     */ 
/*     */     
/* 187 */     saveToRedis();
/* 188 */     GuildMsg.DepotRefreshGuildMsg msgData = new GuildMsg.DepotRefreshGuildMsg();
/* 189 */     msgData.bagIndex = removeIndex;
/* 190 */     GuildMsg msg = new GuildMsg(Const.NotifyType.DEPOT_REMOVE_PUSH.getValue(), (GuildMsg.GuildMsgData)msgData);
/* 191 */     GuildService.notifyAllMemberRefreshGuild(this.depotData.id, msg, playerId);
/* 192 */     return true;
/*     */   }
/*     */   
/*     */   public NormalItem getEquip(int index) {
/* 196 */     return this.bag.getItem(index);
/*     */   }
/*     */   
/*     */   public boolean setCondition(GuildDepotCondition cond, String playerId) {
/* 200 */     if (!GuildUtil.checkCondition(cond)) {
/* 201 */       return false;
/*     */     }
/*     */     
/* 204 */     this.depotData.condition.useCond = cond.useCond;
/* 205 */     this.depotData.condition.minCond = cond.minCond;
/* 206 */     this.depotData.condition.maxCond = cond.maxCond;
/*     */     
/* 208 */     saveToRedis();
/* 209 */     GuildMsg.DepotRefreshGuildMsg msgData = new GuildMsg.DepotRefreshGuildMsg();
/* 210 */     msgData.condition = this.depotData.condition;
/* 211 */     GuildMsg msg = new GuildMsg(Const.NotifyType.DEPOT_CONDITION_PUSH.getValue(), (GuildMsg.GuildMsgData)msgData);
/* 212 */     GuildService.notifyAllMemberRefreshGuild(this.depotData.id, msg, playerId);
/* 213 */     return true;
/*     */   }
/*     */   
/*     */   public GuildDepotHandler.DepotLevelInfo getNotifyInfo() {
/* 217 */     GuildDepotHandler.DepotLevelInfo.Builder data = GuildDepotHandler.DepotLevelInfo.newBuilder();
/* 218 */     data.setLevel(this.depotData.level);
/* 219 */     data.setBagGridCount(this.bag.bagGridCount);
/* 220 */     data.setBagTotalCount(this.bag.bagTotalCount);
/* 221 */     return data.build();
/*     */   }
/*     */   
/*     */   public void upgradeLevel(String playerId) {
/* 225 */     this.depotData.level++;
/*     */     
/* 227 */     WareHouseLevelCO levelProp = GuildUtil.getDepotLevelProp(this.depotData.level);
/* 228 */     this.bag.bagGridCount = levelProp.spece;
/* 229 */     this.bag.bagTotalCount = levelProp.spece;
/* 230 */     saveToRedis();
/*     */     
/* 232 */     GuildMsg.DepotRefreshGuildMsg msgData = new GuildMsg.DepotRefreshGuildMsg();
/* 233 */     msgData.levelInfo = getNotifyInfo();
/* 234 */     GuildMsg msg = new GuildMsg(Const.NotifyType.DEPOT_UPGRADE_PUSH.getValue(), (GuildMsg.GuildMsgData)msgData);
/*     */     
/* 236 */     GuildService.notifyAllMemberRefreshGuild(this.depotData.id, msg, playerId);
/*     */   }
/*     */   
/*     */   public void addRecord(GuildRecordData record, boolean save) {
/* 240 */     record.time = new Date();
/* 241 */     GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
/* 242 */     this.depotData.news.add(0, record);
/* 243 */     int len = this.depotData.news.size();
/* 244 */     while (len > settingProp.recording) {
/* 245 */       this.depotData.news.remove(len - 1);
/*     */     }
/*     */     
/* 248 */     if (save)
/* 249 */       saveToRedis(); 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guidDepot\GuildDepot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */