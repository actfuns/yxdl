/*     */ package com.wanniu.game.guild;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.tcp.protocol.Message;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.data.BlessItemCO;
/*     */ import com.wanniu.game.data.GDungeonCO;
/*     */ import com.wanniu.game.data.GTechnologyItemCO;
/*     */ import com.wanniu.game.data.GTechnologyLevelCO;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.GuildBuildingCO;
/*     */ import com.wanniu.game.data.GuildContributeCO;
/*     */ import com.wanniu.game.data.GuildLevelCO;
/*     */ import com.wanniu.game.data.GuildPositionCO;
/*     */ import com.wanniu.game.data.WareHouseLevelCO;
/*     */ import com.wanniu.game.data.WareHouseValueCO;
/*     */ import com.wanniu.game.data.ext.BlessBuffExt;
/*     */ import com.wanniu.game.data.ext.BlessLevelExt;
/*     */ import com.wanniu.game.data.ext.GBuffExt;
/*     */ import com.wanniu.game.data.ext.GShopExt;
/*     */ import com.wanniu.game.data.ext.GTechnologyExt;
/*     */ import com.wanniu.game.data.ext.GuildSettingExt;
/*     */ import com.wanniu.game.guild.dao.GuildApplyDao;
/*     */ import com.wanniu.game.guild.dao.GuildBlessDao;
/*     */ import com.wanniu.game.guild.dao.GuildDao;
/*     */ import com.wanniu.game.guild.dao.GuildDepotDao;
/*     */ import com.wanniu.game.guild.dao.GuildImpeachDao;
/*     */ import com.wanniu.game.guild.dao.GuildMemberDao;
/*     */ import com.wanniu.game.guild.guidDepot.GuildCond;
/*     */ import com.wanniu.game.guild.guidDepot.GuildDepotCondition;
/*     */ import com.wanniu.game.guild.guidDepot.GuildRecordData;
/*     */ import com.wanniu.game.guild.guildImpeach.GuildImpeachData;
/*     */ import com.wanniu.game.guild.po.GuildBlessPO;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.GuildApplyPO;
/*     */ import com.wanniu.game.poes.GuildDepotPO;
/*     */ import com.wanniu.game.poes.GuildDungeonPO;
/*     */ import com.wanniu.game.poes.GuildMemberPO;
/*     */ import com.wanniu.game.poes.GuildPO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import pomelo.guild.GuildManagerHandler;
/*     */ 
/*     */ 
/*     */ public class GuildUtil
/*     */ {
/*     */   public static String getUpLevelName(int upLevel) {
/*  55 */     return "";
/*     */   }
/*     */   
/*     */   public static GuildSettingExt getGuildSettingExtProp() {
/*  59 */     Map<Integer, GuildSettingExt> list = GameData.GuildSettings;
/*  60 */     Iterator<GuildSettingExt> iterator = list.values().iterator(); if (iterator.hasNext()) { GuildSettingExt setting = iterator.next();
/*  61 */       return setting; }
/*     */     
/*  63 */     return null;
/*     */   }
/*     */   
/*     */   public static Map<Integer, GuildLevelCO> getGuileLevelPropList() {
/*  67 */     return GameData.GuildLevels;
/*     */   }
/*     */   
/*     */   public static GuildLevelCO getGuildLevelPropByLevel(int level) {
/*  71 */     return (GuildLevelCO)GameData.GuildLevels.get(Integer.valueOf(level));
/*     */   }
/*     */   
/*     */   public static Map<Integer, GuildPositionCO> getGuildJobPositon() {
/*  75 */     return GameData.GuildPositions;
/*     */   }
/*     */   
/*     */   public static Map<Integer, String> getJobNameMap() {
/*  79 */     Map<Integer, GuildPositionCO> list = getGuildJobPositon();
/*  80 */     Map<Integer, String> jobNames = new HashMap<>();
/*  81 */     for (Integer key : list.keySet()) {
/*  82 */       jobNames.put(key, ((GuildPositionCO)list.get(key)).position);
/*     */     }
/*  84 */     return jobNames;
/*     */   }
/*     */   
/*     */   public static GuildPositionCO getGuildJobPropByJobId(int job) {
/*  88 */     return (GuildPositionCO)GameData.GuildPositions.get(Integer.valueOf(job));
/*     */   }
/*     */   
/*     */   public static Map<String, GuildContributeCO> getGuildContributePropMap() {
/*  92 */     return GameData.GuildContributes;
/*     */   }
/*     */   
/*     */   static GuildContributeCO getGuildContributePropByType(int type) {
/*  96 */     List<GuildContributeCO> list = GameData.findGuildContributes(t -> (t.type == type));
/*     */ 
/*     */     
/*  99 */     if (list.size() > 0) {
/* 100 */       return list.get(0);
/*     */     }
/* 102 */     return null;
/*     */   }
/*     */   
/*     */   public static WareHouseLevelCO getDepotLevelProp(int level) {
/* 106 */     return (WareHouseLevelCO)GameData.WareHouseLevels.get(Integer.valueOf(level));
/*     */   }
/*     */ 
/*     */   
/*     */   public static WareHouseValueCO getDepotDepositValueProp(int level, int qColor) {
/* 111 */     List<WareHouseValueCO> list = GameData.findWareHouseValues(t -> (t.equipLv == level && t.equipColor == qColor));
/*     */     
/* 113 */     if (list.size() > 0) {
/* 114 */       return list.get(0);
/*     */     }
/*     */     
/* 117 */     return null;
/*     */   }
/*     */   
/*     */   public static GuildBuildingCO getGuildBuildingProp(int buildingId) {
/* 121 */     return (GuildBuildingCO)GameData.GuildBuildings.get(Integer.valueOf(buildingId));
/*     */   }
/*     */   
/*     */   public static List<BlessItemCO> getBlessItemListByLevel(int level) {
/* 125 */     return GameData.findBlessItems(t -> (t.blessLevel == level));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static BlessItemCO getBlessItemById(int id) {
/* 131 */     return (BlessItemCO)GameData.BlessItems.get(Integer.valueOf(id));
/*     */   }
/*     */   
/*     */   public static BlessLevelExt getBlessPropByLevel(int level) {
/* 135 */     return (BlessLevelExt)GameData.BlessLevels.get(Integer.valueOf(level));
/*     */   }
/*     */   
/*     */   public static BlessBuffExt getBlessBuffProp(int buffID) {
/* 139 */     return (BlessBuffExt)GameData.BlessBuffs.get(Integer.valueOf(buffID));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Map<String, Integer> getBlessBuffAttrs(List<Integer> buffIdArray) {
/* 145 */     Map<String, Integer> attrs = new HashMap<>();
/* 146 */     for (int i = 0; i < buffIdArray.size(); i++) {
/* 147 */       BlessBuffExt buffProp = getBlessBuffProp(((Integer)buffIdArray.get(i)).intValue());
/* 148 */       String attrKey = buffProp.attr.getString("attrKey");
/* 149 */       int attrValue = buffProp.attr.getIntValue("attrValue");
/*     */       
/* 151 */       if (!attrs.containsKey(attrKey)) {
/* 152 */         attrs.put(attrKey, Integer.valueOf(attrValue));
/*     */       } else {
/* 154 */         int tmpValue = ((Integer)attrs.get(attrKey)).intValue();
/* 155 */         attrs.put(attrKey, Integer.valueOf(tmpValue + attrValue));
/*     */       } 
/*     */     } 
/* 158 */     return attrs;
/*     */   }
/*     */ 
/*     */   
/*     */   public static List<Map<String, Integer>> getBlessBuffAttrsList(List<Integer> buffIdArray) {
/* 163 */     List<Map<String, Integer>> attrs = new ArrayList<>();
/* 164 */     for (int i = 0; i < buffIdArray.size(); i++) {
/* 165 */       BlessBuffExt buffProp = getBlessBuffProp(((Integer)buffIdArray.get(i)).intValue());
/* 166 */       if (null != buffProp && null != buffProp.attr) {
/*     */ 
/*     */ 
/*     */         
/* 170 */         String attrKey = buffProp.attr.getString("attrKey");
/* 171 */         int attrValue = buffProp.attr.getInteger("attrValue").intValue();
/* 172 */         Map<String, Integer> attr = new HashMap<>();
/* 173 */         attr.put(attrKey, Integer.valueOf(attrValue));
/* 174 */         attrs.add(attr);
/*     */       } 
/* 176 */     }  return attrs;
/*     */   }
/*     */   
/*     */   public static List<GShopExt> getShopPropList() {
/* 180 */     return GameData.findGShops(t -> (t.isValid == 1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static GShopExt getShopPropById(int id) {
/* 186 */     return (GShopExt)GameData.GShops.get(Integer.valueOf(id));
/*     */   }
/*     */   
/*     */   public static GTechnologyLevelCO getTechLevelPropByLevel(int level) {
/* 190 */     return (GTechnologyLevelCO)GameData.GTechnologyLevels.get(Integer.valueOf(level));
/*     */   }
/*     */   
/*     */   public static List<GTechnologyExt> findGuildTechSkillPropsByTechIDAndTechLevel(int techID, int techLevel) {
/* 194 */     return GameData.findGTechnologys(t -> (t.techID == techID && t.techLevel == techLevel));
/*     */   }
/*     */   
/*     */   public static GTechnologyExt getTechSkillPropByIdLevel(int id, int level) {
/* 198 */     List<GTechnologyExt> list = findGuildTechSkillPropsByTechIDAndTechLevel(id, level);
/* 199 */     if (list.size() > 0) {
/* 200 */       return list.get(0);
/*     */     }
/* 202 */     return null;
/*     */   }
/*     */   
/*     */   public static List<GTechnologyExt> findGuildTechSkillPropsByTechLevel(int techLevel) {
/* 206 */     return GameData.findGTechnologys(t -> (t.techLevel == techLevel));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<Integer> getTechSkillIdList() {
/* 212 */     List<Integer> skills = new ArrayList<>();
/* 213 */     List<GTechnologyExt> list = findGuildTechSkillPropsByTechLevel(1);
/* 214 */     for (int i = 0; i < list.size(); i++) {
/* 215 */       skills.add(Integer.valueOf(((GTechnologyExt)list.get(i)).techID));
/*     */     }
/* 217 */     return skills;
/*     */   }
/*     */   
/*     */   public static Map<Integer, GTechnologyItemCO> getTechProducePropList() {
/* 221 */     return GameData.GTechnologyItems;
/*     */   }
/*     */   
/*     */   public static GTechnologyItemCO getTechProducePropById(int id) {
/* 225 */     return (GTechnologyItemCO)GameData.GTechnologyItems.get(Integer.valueOf(id));
/*     */   }
/*     */   
/*     */   public static GBuffExt getTechBuffPropByLevel(int level) {
/* 229 */     return (GBuffExt)GameData.GBuffs.get(Integer.valueOf(level));
/*     */   }
/*     */   
/*     */   public static void updateGuild(GuildPO guildData) {
/* 233 */     GuildDao.updateGuild(guildData);
/*     */   }
/*     */   
/*     */   public static void removeGuild(GuildPO guildPo) {
/* 237 */     GuildDao.removeGuild(guildPo);
/*     */   }
/*     */   
/*     */   public static void updateGuildMember(GuildMemberPO memberData) {
/* 241 */     GuildMemberDao.updateGuildMember(memberData);
/*     */   }
/*     */   
/*     */   public static void addGuildApply(GuildApplyPO applyData) {
/* 245 */     GuildApplyDao.addGuildApply(applyData);
/*     */   }
/*     */   
/*     */   public static void updateGuildImpeach(GuildImpeachData impeachData) {
/* 249 */     GuildImpeachDao.updateGuildImpeach(impeachData);
/*     */   }
/*     */   
/*     */   public static GuildPO getGuild(String guildId) {
/* 253 */     return GuildDao.getGuild(guildId);
/*     */   }
/*     */   
/*     */   public static GuildPO getPlayerGuild(String playerId) {
/* 257 */     GuildMemberPO po = getGuildMember(playerId);
/* 258 */     if (null == po) {
/* 259 */       return null;
/*     */     }
/*     */     
/* 262 */     return getGuild(po.guildId);
/*     */   }
/*     */   
/*     */   public static String getGuildName(String playerId) {
/* 266 */     GuildPO guild = getPlayerGuild(playerId);
/* 267 */     return (guild == null) ? LangService.getValue("TEAM_NO_GUILD") : guild.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GuildMemberPO getGuildMember(String playerId) {
/* 277 */     return GuildMemberDao.getGuildMember(playerId);
/*     */   }
/*     */   
/*     */   public static GuildApplyPO getGuildApply(String applyId) {
/* 281 */     return GuildApplyDao.getGuildApply(applyId);
/*     */   }
/*     */   
/*     */   public static GuildImpeachData getGuildImpeach(String guildId) {
/* 285 */     return GuildImpeachDao.getGuildImpeach(guildId);
/*     */   }
/*     */   
/*     */   public static void removeGuildNameIndex(int logicServerId, String guildName) {
/* 289 */     GuildDao.removeGuildNameIndex(guildName);
/*     */   }
/*     */   
/*     */   public static void removeGuildMember(String playerId) {
/* 293 */     GuildMemberDao.removeGuildMember(playerId);
/*     */   }
/*     */   
/*     */   public static void removeGuildApply(String applyId) {
/* 297 */     GuildApplyDao.removeGuildApply(applyId);
/*     */   }
/*     */   
/*     */   public static List<GuildPO> getGuildList(int logicServerId, String name) {
/* 301 */     return GuildDao.getGuildList(logicServerId, name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<String> getMemberIds(Const.GuildJob... jobs) {
/* 310 */     List<String> ids = new ArrayList<>();
/*     */     
/* 312 */     for (GuildMemberPO member : GuildMemberDao.PlayerMemberMap.values()) {
/* 313 */       for (Const.GuildJob job : jobs) {
/* 314 */         if (member.job == job.getValue()) {
/* 315 */           ids.add(member.playerId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 320 */     return ids;
/*     */   }
/*     */   
/*     */   public static Set<String> getGuildMemberIdList(String guildId) {
/* 324 */     return GuildMemberDao.getGuildMemberIdList(guildId);
/*     */   }
/*     */   
/*     */   public static int getGuildMemberCount(String guildId) {
/* 328 */     return GuildMemberDao.getGuildMemberCount(guildId);
/*     */   }
/*     */   
/*     */   public static List<GuildMemberPO> getGuildMemberList(String guildId) {
/* 332 */     List<GuildMemberPO> list = new ArrayList<>();
/* 333 */     Set<String> idList = getGuildMemberIdList(guildId);
/* 334 */     for (String id : idList) {
/* 335 */       GuildMemberPO member = getGuildMember(id);
/* 336 */       list.add(member);
/*     */     } 
/* 338 */     return list;
/*     */   }
/*     */   
/*     */   public static int getGuildMemberCountByJob(String guildId, int job) {
/* 342 */     int count = 0;
/* 343 */     Set<String> idList = getGuildMemberIdList(guildId);
/* 344 */     for (String id : idList) {
/* 345 */       GuildMemberPO member = getGuildMember(id);
/* 346 */       if (member.job == job) {
/* 347 */         count++;
/*     */       }
/*     */     } 
/* 350 */     return count;
/*     */   }
/*     */   
/*     */   public static int getGuildApplyCount(String guildId) {
/* 354 */     return GuildApplyDao.getGuildApplyCount(guildId);
/*     */   }
/*     */   
/*     */   public static List<GuildApplyPO> getGuildApplyList(String guildId) {
/* 358 */     return GuildApplyDao.getGuildApplyList(guildId);
/*     */   }
/*     */   
/*     */   public static List<GuildApplyPO> getPlayerApplyIdList(String playerId) {
/* 362 */     return GuildApplyDao.getPlayerApplyIdList(playerId);
/*     */   }
/*     */   
/*     */   public static boolean isInGuild(String playerId) {
/* 366 */     GuildMemberPO guildMember = getGuildMember(playerId);
/* 367 */     if (null != guildMember) {
/* 368 */       return true;
/*     */     }
/* 370 */     return false;
/*     */   }
/*     */   
/*     */   public static String getGuildByFullName(String name) {
/* 374 */     return GuildDao.getGuildIdByName(name);
/*     */   }
/*     */   
/*     */   public static boolean existGuildName(int logicServerId, String name) {
/* 378 */     String guildId = getGuildByFullName(name);
/* 379 */     return StringUtil.isNotEmpty(guildId);
/*     */   }
/*     */   
/*     */   public static GuildDepotPO getGuildDepot(String guildId) {
/* 383 */     return GuildDepotDao.getDepot(guildId);
/*     */   }
/*     */   
/*     */   public static ArrayList<GuildDepotPO> getGuildDepotList() {
/* 387 */     return GuildDepotDao.getDepotList();
/*     */   }
/*     */   
/*     */   public static void updateGuildDepot(GuildDepotPO data) {
/* 391 */     GuildDepotDao.updateDepot(data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean checkCondition(GuildDepotCondition cond) {
/* 401 */     GuildSettingExt settingProp = getGuildSettingExtProp();
/* 402 */     if (cond.minCond.qColor < settingProp.warehouseMinQ || cond.maxCond.qColor < settingProp.warehouseMinQ) {
/* 403 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 409 */     if (cond.maxCond.level == 0 && cond.maxCond.level < settingProp.warehouseMinLv) {
/* 410 */       return false;
/*     */     }
/* 412 */     return lessCompare(cond.minCond, cond.maxCond, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isInCondition(GuildCond quality, GuildDepotCondition cond) {
/* 421 */     return (lessCompare(cond.minCond, quality, true) && lessCompare(quality, cond.maxCond, true));
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
/*     */   public static boolean lessCompare(GuildCond minCond, GuildCond maxCond, boolean canEqual) {
/* 433 */     if (minCond.level != maxCond.level)
/* 434 */       return (minCond.level < maxCond.level); 
/* 435 */     if (minCond.qColor != maxCond.qColor) {
/* 436 */       return (minCond.qColor < maxCond.qColor);
/*     */     }
/*     */     
/* 439 */     if (canEqual) {
/* 440 */       return true;
/*     */     }
/* 442 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ArrayList<GuildBlessPO> getGuildBlessList() {
/* 450 */     return GuildBlessDao.getGuildBlessList();
/*     */   }
/*     */   
/*     */   public static void updateGuildBless(GuildBlessPO blessData) {
/* 454 */     GuildBlessDao.updateGuildBless(blessData);
/*     */   }
/*     */   
/*     */   public static GDungeonCO getGuildDungeonConfig() {
/* 458 */     Map<String, GDungeonCO> map = GameData.GDungeons;
/* 459 */     if (map.size() > 0) {
/* 460 */       return map.get("0");
/*     */     }
/* 462 */     return null;
/*     */   }
/*     */   
/*     */   public static GuildDungeonPO getGuildDungeon(String id) {
/* 466 */     return GuildServiceCenter.getInstance().getGuildDungeon(id);
/*     */   }
/*     */   
/*     */   public static void updateGuildDungeon(GuildDungeonPO guildDungeonData) {
/* 470 */     GuildDao.updateGuildDungeon(guildDungeonData);
/*     */   }
/*     */   
/*     */   public static ArrayList<GuildDungeonPO> getAllGuildDungeon() {
/* 474 */     return new ArrayList<>();
/*     */   }
/*     */   
/*     */   public static GuildManagerHandler.QualityCond qualityCond(int level, int upLevel, int qColor) {
/* 478 */     GuildManagerHandler.QualityCond.Builder cond = GuildManagerHandler.QualityCond.newBuilder();
/* 479 */     cond.setLevel(level);
/* 480 */     cond.setUpLevel(upLevel);
/* 481 */     cond.setQColor(qColor);
/*     */     
/* 483 */     return cond.build();
/*     */   }
/*     */   
/*     */   public GuildRecordData getNewGuildReocrd(int type, RoleInfo role1, RoleInfo role2) {
/* 487 */     GuildRecordData record = new GuildRecordData();
/* 488 */     record.type = Const.GuildRecord.UPGRADE.getValue();
/* 489 */     if (null != role1) {
/* 490 */       record.role1 = new RoleInfo();
/* 491 */       record.role1.pro = role1.pro;
/* 492 */       record.role1.name = role1.name;
/*     */     } 
/*     */     
/* 495 */     if (null != role2) {
/* 496 */       record.role2.pro = role2.pro;
/* 497 */       record.role2.name = role2.name;
/*     */     } 
/*     */     
/* 500 */     return record;
/*     */   }
/*     */   
/*     */   public static GuildResult checkGuildMember(String playerId) {
/* 504 */     GuildResult ret = new GuildResult();
/* 505 */     GuildMemberPO myInfo = GuildServiceCenter.getInstance().getGuildMember(playerId);
/* 506 */     GuildPO myGuild = GuildServiceCenter.getInstance().getGuild(myInfo.guildId);
/* 507 */     if (null == myInfo || null == myGuild) {
/* 508 */       ret.result = -1;
/* 509 */       ret.des = "不是公会成员";
/* 510 */       return ret;
/*     */     } 
/* 512 */     return null;
/*     */   }
/*     */   
/*     */   public static void broadcast(String guildId, Message msg) {
/* 516 */     getGuildMemberIdList(guildId).forEach(playerId -> {
/*     */           WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
/*     */           if (player != null) {
/*     */             player.receive(msg);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public static void refreshGuildJobPush(WNPlayer player) {
/* 526 */     if (null != player) {
/* 527 */       GuildManager guildManager = player.guildManager;
/* 528 */       String guildId = guildManager.getGuildId();
/* 529 */       String guildName = guildManager.getGuildName();
/* 530 */       int guildJob = guildManager.getJob();
/* 531 */       String guildIcon = guildManager.getGuildIcon();
/* 532 */       player.pushDynamicData(Utils.ofMap(new Object[] { "guildId", guildId, "guildName", guildName, "guildJob", Integer.valueOf(guildJob), "guildIcon", guildIcon }));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\GuildUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */