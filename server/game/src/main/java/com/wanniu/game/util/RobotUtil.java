/*     */ package com.wanniu.game.util;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.wanniu.core.db.GCache;
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.game.entity.GEntity;
/*     */ import com.wanniu.core.game.entity.GPlayer;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.RandomUtil;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.data.base.DItemBase;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.player.WNRobot;
/*     */ import com.wanniu.game.player.po.AllBlobPO;
/*     */ import com.wanniu.game.poes.MountPO;
/*     */ import com.wanniu.game.poes.PlayerBasePO;
/*     */ import com.wanniu.game.poes.PlayerPetsNewPO;
/*     */ import com.wanniu.game.poes.SkillsPO;
/*     */ import com.wanniu.game.request.bag.UseItemHandler;
/*     */ import com.wanniu.game.team.TeamData;
/*     */ import com.wanniu.game.team.TeamUtil;
/*     */ import com.wanniu.redis.GameDao;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class RobotUtil
/*     */ {
/*     */   private static final String BASE = "base/";
/*     */   private static final String SKILL = "skill/";
/*     */   private static final String MOUNT = "mount/";
/*     */   private static final String PET = "pet/";
/*  46 */   public static Map<Integer, Map<Integer, String>> SkillEntities = new ConcurrentHashMap<>();
/*     */   
/*  48 */   public static Map<Integer, Map<Integer, String>> BaseEntities = new ConcurrentHashMap<>();
/*     */   
/*  50 */   public static Map<Integer, Map<Integer, String>> MountEntities = new ConcurrentHashMap<>();
/*     */   
/*  52 */   public static Map<Integer, Map<Integer, String>> PetEntities = new ConcurrentHashMap<>();
/*     */   
/*  54 */   public static int[] PROS = new int[] { 1, 3, 5 };
/*     */   
/*  56 */   public static AtomicInteger UUID = new AtomicInteger(0);
/*     */   
/*     */   public static void freeRobot(WNRobot robot) {
/*     */     try {
/*  60 */       Area area = robot.getArea();
/*  61 */       if (area != null) {
/*  62 */         area.removePlayer((WNPlayer)robot, false);
/*  63 */         Out.debug(new Object[] { "robot ", robot.getName(), " removed from area ", area.getSceneName() });
/*     */       } 
/*     */     } finally {
/*  66 */       TeamUtil.removeAcrossMatch((WNPlayer)robot);
/*  67 */       GWorld.Robots.remove(robot.getId());
/*  68 */       PlayerPOManager.pos.remove(robot.getId());
/*  69 */       GameDao.freeName(robot.getName());
/*     */ 
/*     */       
/*  72 */       GCache.expire(robot.getId(), 300);
/*     */     } 
/*     */   }
/*     */   private static final String MATCH_ROBOT = "MATCH_ROBOT";
/*     */   public static void newRobot(WNRobot robot) {
/*  77 */     GWorld.Robots.put(robot.getId(), robot);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void cloneRobot(WNPlayer player) {
/*  83 */     int lv = player.getLevel();
/*  84 */     if (lv < GlobalConfig.Robot_Level) {
/*     */       return;
/*     */     }
/*  87 */     int pro = player.getPro();
/*  88 */     String field = lv + "/" + pro;
/*     */     
/*  90 */     Map<Integer, String> pro_skills = SkillEntities.get(Integer.valueOf(lv));
/*  91 */     if (pro_skills == null) {
/*  92 */       pro_skills = new ConcurrentHashMap<>();
/*  93 */       SkillEntities.put(Integer.valueOf(lv), pro_skills);
/*     */     } 
/*  95 */     if (!pro_skills.containsKey(Integer.valueOf(pro))) {
/*  96 */       String skill = Utils.serialize(player.skillManager.player_skills);
/*  97 */       pro_skills.put(Integer.valueOf(pro), skill);
/*  98 */       GCache.hset("MATCH_ROBOT", "skill/" + field, skill);
/*     */     } 
/*     */     
/* 101 */     Map<Integer, String> pro_bases = BaseEntities.get(Integer.valueOf(lv));
/* 102 */     if (pro_bases == null) {
/* 103 */       pro_bases = new ConcurrentHashMap<>();
/* 104 */       BaseEntities.put(Integer.valueOf(lv), pro_bases);
/*     */     } 
/* 106 */     if (!pro_bases.containsKey(Integer.valueOf(pro))) {
/* 107 */       String base = Utils.serialize(player.playerBasePO);
/* 108 */       pro_bases.put(Integer.valueOf(pro), base);
/* 109 */       GCache.hset("MATCH_ROBOT", "base/" + field, base);
/*     */     } 
/*     */     
/* 112 */     if (player.mountManager.mount != null) {
/* 113 */       Map<Integer, String> pro_mount = MountEntities.get(Integer.valueOf(lv));
/* 114 */       if (pro_mount == null) {
/* 115 */         pro_mount = new ConcurrentHashMap<>();
/* 116 */         MountEntities.put(Integer.valueOf(lv), pro_mount);
/*     */       } 
/* 118 */       if (!pro_mount.containsKey(Integer.valueOf(pro))) {
/* 119 */         String mount = Utils.serialize(player.mountManager.mount);
/* 120 */         pro_mount.put(Integer.valueOf(pro), mount);
/* 121 */         GCache.hset("MATCH_ROBOT", "mount/" + field, mount);
/*     */       } 
/*     */     } 
/*     */     
/* 125 */     if (player.petNewManager.petsPO != null) {
/* 126 */       Map<Integer, String> pro_pet = PetEntities.get(Integer.valueOf(lv));
/* 127 */       if (pro_pet == null) {
/* 128 */         pro_pet = new ConcurrentHashMap<>();
/* 129 */         PetEntities.put(Integer.valueOf(lv), pro_pet);
/*     */       } 
/* 131 */       if (!pro_pet.containsKey(Integer.valueOf(pro))) {
/* 132 */         String pet = Utils.serialize(player.petNewManager.petsPO);
/* 133 */         pro_pet.put(Integer.valueOf(pro), pet);
/* 134 */         GCache.hset("MATCH_ROBOT", "pet/" + field, pet);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getTemplate(String key, int lv, int pro) {
/* 141 */     Map<Integer, Map<Integer, String>> entities = null;
/* 142 */     switch (key) {
/*     */       case "base/":
/* 144 */         entities = BaseEntities;
/*     */         break;
/*     */       
/*     */       case "skill/":
/* 148 */         entities = SkillEntities;
/*     */         break;
/*     */       
/*     */       case "mount/":
/* 152 */         entities = MountEntities;
/*     */         break;
/*     */       
/*     */       case "pet/":
/* 156 */         entities = PetEntities;
/*     */         break;
/*     */       
/*     */       default:
/* 160 */         return null;
/*     */     } 
/*     */     
/* 163 */     Map<Integer, String> entity = entities.get(Integer.valueOf(lv));
/* 164 */     if (entity == null) {
/* 165 */       entity = new ConcurrentHashMap<>();
/* 166 */       entities.put(Integer.valueOf(lv), entity);
/*     */     } 
/* 168 */     if (entity.containsKey(Integer.valueOf(pro))) {
/* 169 */       return entity.get(Integer.valueOf(pro));
/*     */     }
/*     */     
/* 172 */     String field = key + lv + "/" + pro;
/* 173 */     String template = GCache.hget("MATCH_ROBOT", field);
/* 174 */     if (StringUtil.isNotEmpty(template)) {
/* 175 */       entity.put(Integer.valueOf(pro), template);
/* 176 */       return template;
/*     */     } 
/* 178 */     return null;
/*     */   }
/*     */   
/*     */   public static void initMathData(int lv) {
/* 182 */     for (int pro : PROS) {
/* 183 */       if (getTemplate("base/", lv, pro) != null) {
/*     */ 
/*     */         
/* 186 */         getTemplate("skill/", lv, pro);
/* 187 */         getTemplate("mount/", lv, pro);
/* 188 */         getTemplate("pet/", lv, pro);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public static AllBlobPO matchRobot(WNPlayer fromPlayer, int minLevel) {
/* 193 */     int maxLevel = fromPlayer.getLevel();
/* 194 */     if (minLevel > maxLevel) {
/* 195 */       return null;
/*     */     }
/* 197 */     WNPlayer mirror = null, tmpPlayer = null;
/* 198 */     for (GPlayer player : GWorld.getInstance().getOnlinePlayers().values()) {
/* 199 */       tmpPlayer = (WNPlayer)player;
/* 200 */       if (tmpPlayer.getLevel() >= minLevel && tmpPlayer.getLevel() <= maxLevel && (tmpPlayer != fromPlayer || tmpPlayer.getPro() != fromPlayer.getPro())) {
/* 201 */         TeamData team = fromPlayer.teamManager.getTeam();
/* 202 */         if (team == null)
/* 203 */           return null; 
/* 204 */         boolean noPro = true;
/* 205 */         for (String str : team.teamMembers.keySet()) {
/* 206 */           WNPlayer actor = team.getPlayer(str);
/* 207 */           if (actor != null && actor.getPro() == fromPlayer.getPro()) {
/* 208 */             noPro = false;
/*     */             break;
/*     */           } 
/*     */         } 
/* 212 */         if (noPro) {
/* 213 */           mirror = tmpPlayer;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 218 */     int pro = fromPlayer.getPro();
/* 219 */     int level = fromPlayer.getLevel();
/* 220 */     SkillsPO player_skill = null;
/* 221 */     PlayerBasePO player_base = null;
/* 222 */     MountPO player_mount = null;
/* 223 */     PlayerPetsNewPO player_pet = null;
/*     */     
/* 225 */     if (mirror != null) {
/* 226 */       pro = mirror.getPro();
/* 227 */       level = mirror.getLevel();
/*     */     } else {
/* 229 */       int matchLv = RandomUtil.getInt(minLevel, maxLevel);
/* 230 */       initMathData(matchLv);
/* 231 */       if (SkillEntities.containsKey(Integer.valueOf(matchLv)) && BaseEntities.containsKey(Integer.valueOf(matchLv))) {
/* 232 */         Map<Integer, String> skills = SkillEntities.get(Integer.valueOf(matchLv));
/* 233 */         Map<Integer, String> bases = BaseEntities.get(Integer.valueOf(matchLv));
/* 234 */         Map<Integer, String> mounts = MountEntities.get(Integer.valueOf(matchLv));
/* 235 */         Map<Integer, String> pets = PetEntities.get(Integer.valueOf(matchLv));
/* 236 */         int matchPro = PROS[RandomUtil.getIndex(PROS.length)];
/* 237 */         if (!skills.containsKey(Integer.valueOf(matchPro)) || !bases.containsKey(Integer.valueOf(matchPro))) {
/* 238 */           for (Iterator<Integer> iterator = skills.keySet().iterator(); iterator.hasNext(); ) { int tmpPro = ((Integer)iterator.next()).intValue();
/* 239 */             if (tmpPro != fromPlayer.getPro() && bases.containsKey(Integer.valueOf(tmpPro))) {
/* 240 */               matchPro = tmpPro;
/*     */               break;
/*     */             }  }
/*     */         
/*     */         }
/* 245 */         if (skills.containsKey(Integer.valueOf(matchPro)) && bases.containsKey(Integer.valueOf(matchPro))) {
/* 246 */           pro = matchPro;
/* 247 */           level = matchLv;
/* 248 */           player_skill = (SkillsPO)Utils.deserialize(skills.get(Integer.valueOf(matchPro)), SkillsPO.class);
/* 249 */           player_base = (PlayerBasePO)Utils.deserialize(bases.get(Integer.valueOf(matchPro)), PlayerBasePO.class);
/* 250 */           if (mounts.containsKey(Integer.valueOf(matchPro))) {
/* 251 */             player_mount = (MountPO)Utils.deserialize(mounts.get(Integer.valueOf(matchPro)), MountPO.class);
/*     */           }
/* 253 */           if (pets.containsKey(Integer.valueOf(matchPro))) {
/* 254 */             player_pet = (PlayerPetsNewPO)Utils.deserialize(pets.get(Integer.valueOf(matchPro)), PlayerPetsNewPO.class);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 260 */     String name = PlayerUtil.getRandomName(pro);
/* 261 */     String playerId = UUID.randomUUID().toString();
/* 262 */     boolean isPutSuccess = GameDao.putName(name, playerId);
/* 263 */     if (!isPutSuccess) {
/* 264 */       Out.warn(new Object[] { "发现有机器人重名,创角失败!", name });
/* 265 */       return null;
/*     */     } 
/*     */     
/* 268 */     if (mirror == null) {
/* 269 */       mirror = fromPlayer;
/*     */     }
/*     */     
/* 272 */     if (player_skill == null) {
/* 273 */       player_skill = mirror.skillManager.player_skills;
/* 274 */       player_skill = (SkillsPO)Utils.deserialize(Utils.serialize(player_skill), SkillsPO.class);
/*     */     } 
/*     */     
/* 277 */     if (player_base == null) {
/* 278 */       player_base = (PlayerBasePO)Utils.deserialize(Utils.serialize(mirror.playerBasePO), PlayerBasePO.class);
/* 279 */       if (mirror.mountManager.mount != null) {
/* 280 */         player_mount = (MountPO)Utils.deserialize(Utils.serialize(mirror.mountManager.mount), MountPO.class);
/*     */       }
/* 282 */       if (mirror.petNewManager.petsPO != null) {
/* 283 */         player_pet = (PlayerPetsNewPO)Utils.deserialize(Utils.serialize(mirror.petNewManager.petsPO), PlayerPetsNewPO.class);
/*     */       }
/*     */     } 
/* 286 */     String robotId = String.valueOf("RO-" + UUID.incrementAndGet());
/* 287 */     AllBlobPO allBlob = PlayerUtil.createPlayer(playerId, robotId, name, pro, fromPlayer.getLogicServerId());
/* 288 */     allBlob.player.uid = robotId;
/* 289 */     allBlob.player.level = level;
/* 290 */     allBlob.player.exp = allBlob.player.exp;
/* 291 */     PlayerPOManager.put(ConstsTR.skillTR, playerId, (GEntity)player_skill);
/*     */     
/* 293 */     allBlob.playerBase = player_base;
/* 294 */     PlayerPOManager.put(ConstsTR.playerBaseTR, playerId, (GEntity)player_base);
/*     */     
/* 296 */     if (player_mount != null) {
/* 297 */       allBlob.player.openMount = true;
/* 298 */       PlayerPOManager.put(ConstsTR.mountTR, playerId, (GEntity)player_mount);
/*     */     } 
/*     */     
/* 301 */     if (player_pet != null) {
/* 302 */       PlayerPOManager.put(ConstsTR.playerPetTR, playerId, (GEntity)player_pet);
/*     */     }
/*     */     
/* 305 */     return allBlob;
/*     */   }
/*     */   
/*     */   public static void onRobotDie(Area area, WNPlayer robot) {
/* 309 */     if (robot.isRobot()) {
/* 310 */       Area.Actor actor = area.getActor(robot.getId());
/* 311 */       if (actor == null)
/*     */         return; 
/* 313 */       if (actor.rebornNum < 99 || area.isNormal()) {
/* 314 */         long deleyTime = actor.reliveCoolTime - System.currentTimeMillis();
/* 315 */         JobFactory.addDelayJob(() -> {
/*     */               if (!area.isClose()) {
/*     */                 area.relive(robot.getId(), (RandomUtil.getInt(100) < 70) ? area.getReliveType() : Area.ReliveType.NOW);
/*     */               }
/* 319 */             }Math.max(deleyTime, Utils.getSecMills(1, 5)));
/*     */       } else {
/* 321 */         JobFactory.addDelayJob(() -> {
/*     */               if (robot.getArea() == area) {
/*     */                 robot.fightLevelManager.leaveDungeon(robot, area);
/*     */               }
/* 325 */             }Utils.getSecMills(5, 20));
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void onRobotLeaderQuit(Area area, WNPlayer leader) {
/* 331 */     if (area.isNormal() || area.isClose() || leader.isRobot())
/*     */       return; 
/* 333 */     TeamData team = leader.getTeamManager().getTeam();
/* 334 */     if (team != null && team.isRobotJoin) {
/* 335 */       for (TeamData.TeamMemberData member : team.teamMembers.values()) {
/* 336 */         if (member.robot && area.hasPlayer(member.id)) {
/* 337 */           JobFactory.addDelayJob(() -> {
/*     */                 if (area.isAllRobot() && area.hasPlayer(member.id)) {
/*     */                   WNPlayer robot = member.getPlayer();
/*     */                   robot.fightLevelManager.leaveDungeon(robot, area);
/*     */                 } 
/* 342 */               }Utils.getSecMills(3, 10));
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
/*     */   public static void onRobotReplyHP(WNPlayer player) {
/* 355 */     if (!player.isRobot() || !(player instanceof WNRobot))
/*     */       return; 
/* 357 */     WNRobot robot = (WNRobot)player;
/* 358 */     if (robot.hpFuture != null)
/*     */       return; 
/* 360 */     DItemBase item = ItemUtil.getUnEquipPropByCode("hp1");
/* 361 */     UseItemHandler.GetItemChanagePropertyResult data = ItemUtil.getItemChanageProperty(item);
/* 362 */     robot.hpFuture = JobFactory.addScheduleJob(() -> {
/*     */           Area area = player.getArea();
/*     */           
/*     */           if (area == null || area.prop.useAgent == 0) {
/*     */             return;
/*     */           }
/*     */           data.itemData.timestamp = GWorld.APP_TIME + item.par;
/*     */           String hp = JSON.toJSONString(data.itemData);
/*     */           player.getXmdsManager().refreshPlayerPropertyChange(player.getId(), hp);
/* 371 */         }Utils.random(30, 60), (item.useCD + 1000));
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gam\\util\RobotUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */