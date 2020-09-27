/*     */ package com.wanniu.game.guild;
/*     */ 
/*     */ import com.wanniu.core.db.GCache;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.data.GDungeonMapCO;
/*     */ import com.wanniu.game.data.GDungeonRankCO;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.ext.GuildSettingExt;
/*     */ import com.wanniu.game.guild.guidDepot.GuildCond;
/*     */ import com.wanniu.game.guild.guidDepot.GuildDepotCondition;
/*     */ import com.wanniu.game.mail.MailUtil;
/*     */ import com.wanniu.game.mail.data.MailData;
/*     */ import com.wanniu.game.mail.data.MailSysData;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import pomelo.area.GuildDepotHandler;
/*     */ import pomelo.area.GuildHandler;
/*     */ import pomelo.guild.GuildManagerHandler;
/*     */ import redis.clients.jedis.Jedis;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuildCommonUtil
/*     */ {
/*     */   public static List<Integer> toList(int[] arr) {
/*  39 */     List<Integer> ls = new ArrayList<>();
/*  40 */     for (int i = 0; i < arr.length; i++) {
/*  41 */       ls.add(Integer.valueOf(arr[i]));
/*     */     }
/*  43 */     return ls;
/*     */   }
/*     */   
/*     */   public static void sendMailSystenType(String playerId, String key, Map<String, String> map) {
/*  47 */     MailSysData mailData = new MailSysData(key);
/*  48 */     mailData.replace = map;
/*  49 */     MailUtil.getInstance().sendMailToOnePlayer(playerId, (MailData)mailData, Const.GOODS_CHANGE_TYPE.guild_mail);
/*     */   }
/*     */   
/*     */   public static List<GDungeonMapCO> findAndSortDungeonMap() {
/*  53 */     List<GDungeonMapCO> props = GameData.findGDungeonMaps(t -> (t.type == Const.SCENE_TYPE.GUILD_DUNGEON.getValue()));
/*     */ 
/*     */ 
/*     */     
/*  57 */     props.sort(new Comparator<GDungeonMapCO>()
/*     */         {
/*     */           public int compare(GDungeonMapCO o1, GDungeonMapCO o2) {
/*  60 */             return o1.layer - o2.layer;
/*     */           }
/*     */         });
/*  63 */     return props;
/*     */   }
/*     */   
/*     */   public static GDungeonRankCO findGDungeonRanks(int rankType, int rank) {
/*  67 */     List<GDungeonRankCO> rankPropList = GameData.findGDungeonRanks(t -> 
/*  68 */         (t.rankType == rankType && t.openTime == rank));
/*     */ 
/*     */     
/*  71 */     GDungeonRankCO rankProp = null;
/*  72 */     if (null != rankPropList && rankPropList.size() > 0) {
/*  73 */       rankProp = rankPropList.get(0);
/*     */     }
/*  75 */     return rankProp;
/*     */   }
/*     */   
/*     */   public static String getJoinGuildErrorMsg(GuildResult resData) {
/*  79 */     int result = resData.result;
/*  80 */     GuildResult.JoinGuild data = (GuildResult.JoinGuild)resData.data;
/*  81 */     GuildSettingExt prop = GuildUtil.getGuildSettingExtProp();
/*  82 */     if (result == 0)
/*  83 */       return ""; 
/*  84 */     if (result == -1)
/*  85 */       return LangService.getValue("SOMETHING_ERR"); 
/*  86 */     if (result == -2)
/*  87 */       return LangService.getValue("GUILD_CREATE_ERROR"); 
/*  88 */     if (result == -3)
/*  89 */       return LangService.getValue("GUILD_NOT_EXIST"); 
/*  90 */     if (result == -4) {
/*  91 */       if (null == data)
/*  92 */         return ""; 
/*  93 */       String upLevelName = GuildUtil.getUpLevelName(data.needUpLevel);
/*  94 */       return LangService.getValue("GUILD_JOIN_UP_LEVEL").replace("{roleUpLevel}", upLevelName);
/*  95 */     }  if (result == -5)
/*  96 */       return LangService.getValue("GUILD_JOIN_LEVEL").replace("{roleLevel}", String.valueOf(resData.needLevel)); 
/*  97 */     if (result == -6) {
/*  98 */       if (null == data)
/*  99 */         return ""; 
/* 100 */       return LangService.getValue("GUILD_SELF_OUT_CD").replace("{time}", data.cdInfo);
/* 101 */     }  if (result == -7)
/* 102 */       return LangService.getValue("GUILD_NOT_EXIST"); 
/* 103 */     if (result == -20)
/* 104 */       return LangService.getValue("GUILD_HE_IS_NOT_IN_GUILD"); 
/* 105 */     if (result == 1)
/* 106 */       return LangService.getValue("GUILD_JOIN_FULL").replace("{applyMax}", String.valueOf(prop.applyMax)); 
/* 107 */     if (result == 2)
/* 108 */       return LangService.getValue("GUILD_NOT_EXIST"); 
/* 109 */     if (result == 3)
/* 110 */       return LangService.getValue("GUILD_FULL"); 
/* 111 */     if (result == 4) {
/* 112 */       return LangService.getValue("GUILD_HAVE_APPLY");
/*     */     }
/* 114 */     return LangService.getValue("SOMETHING_ERR");
/*     */   }
/*     */   
/*     */   public static List<String> smembers(String id) {
/* 118 */     Jedis redis = GCache.getRedis();
/*     */     try {
/* 120 */       return new ArrayList(redis.smembers(id));
/*     */     } finally {
/* 122 */       GCache.release(redis);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static Date newDateByStr(String timeStr) throws ParseException {
/* 127 */     SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 128 */     long time = Long.parseLong(timeStr);
/* 129 */     String d = format.format(Long.valueOf(time));
/* 130 */     Date date = format.parse(d);
/* 131 */     return date;
/*     */   }
/*     */   
/*     */   public static GuildManagerHandler.QualityCond.Builder toManagerQuality(int level, int upLevel, int qColor) {
/* 135 */     GuildManagerHandler.QualityCond.Builder cond = GuildManagerHandler.QualityCond.newBuilder();
/* 136 */     cond.setLevel(level);
/* 137 */     cond.setUpLevel(upLevel);
/* 138 */     cond.setQColor(qColor);
/* 139 */     return cond;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GuildManagerHandler.DepotCondition toManagerCond(GuildDepotCondition cond) {
/* 149 */     if (null == cond) {
/* 150 */       return null;
/*     */     }
/*     */     
/* 153 */     GuildManagerHandler.UseCond.Builder useCond = GuildManagerHandler.UseCond.newBuilder();
/* 154 */     useCond.setLevel(cond.useCond.level);
/* 155 */     useCond.setUpLevel(cond.useCond.upLevel);
/* 156 */     useCond.setJob(cond.useCond.job);
/*     */     
/* 158 */     GuildManagerHandler.QualityCond.Builder minCond = toManagerQuality(cond.minCond.level, cond.minCond.upLevel, cond.minCond.qColor);
/* 159 */     GuildManagerHandler.QualityCond.Builder maxCond = toManagerQuality(cond.maxCond.level, cond.maxCond.upLevel, cond.maxCond.qColor);
/*     */     
/* 161 */     GuildManagerHandler.DepotCondition.Builder condition = GuildManagerHandler.DepotCondition.newBuilder();
/* 162 */     condition.setUseCond(useCond);
/* 163 */     condition.setMinCond(minCond);
/* 164 */     condition.setMaxCond(maxCond);
/* 165 */     return condition.build();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GuildDepotHandler.DepotCondition toHandlerDepot(GuildDepotCondition cond) {
/* 176 */     GuildDepotHandler.UseCond.Builder useCond = GuildDepotHandler.UseCond.newBuilder();
/* 177 */     useCond.setLevel(cond.useCond.level);
/* 178 */     useCond.setUpLevel(cond.useCond.upLevel);
/* 179 */     useCond.setJob(cond.useCond.job);
/*     */     
/* 181 */     GuildDepotHandler.QualityCond.Builder minCond = GuildDepotHandler.QualityCond.newBuilder();
/* 182 */     minCond.setLevel(cond.minCond.level);
/* 183 */     minCond.setUpLevel(cond.minCond.upLevel);
/* 184 */     minCond.setQColor(cond.minCond.qColor);
/*     */     
/* 186 */     GuildDepotHandler.QualityCond.Builder maxCond = GuildDepotHandler.QualityCond.newBuilder();
/* 187 */     maxCond.setLevel(cond.maxCond.level);
/* 188 */     maxCond.setUpLevel(cond.maxCond.upLevel);
/* 189 */     maxCond.setQColor(cond.maxCond.qColor);
/*     */     
/* 191 */     GuildDepotHandler.DepotCondition.Builder condition = GuildDepotHandler.DepotCondition.newBuilder();
/* 192 */     condition.setUseCond(useCond);
/* 193 */     condition.setMinCond(minCond);
/* 194 */     condition.setMaxCond(maxCond);
/* 195 */     return condition.build();
/*     */   }
/*     */ 
/*     */   
/*     */   public static GuildCond useCond2GuildCond(GuildManagerHandler.UseCond useCond) {
/* 200 */     GuildCond newCond = new GuildCond();
/* 201 */     newCond.level = useCond.getLevel();
/* 202 */     newCond.upLevel = useCond.getUpLevel();
/* 203 */     newCond.job = useCond.getJob();
/* 204 */     return newCond;
/*     */   }
/*     */   
/*     */   public static GuildCond quality2GuildCond(GuildManagerHandler.QualityCond useCond) {
/* 208 */     GuildCond newCond = new GuildCond();
/* 209 */     newCond.level = useCond.getLevel();
/* 210 */     newCond.upLevel = useCond.getUpLevel();
/* 211 */     newCond.qColor = useCond.getQColor();
/* 212 */     return newCond;
/*     */   }
/*     */   
/*     */   public static GuildManagerHandler.UseCond newUseCond(int level, int upLevel, int job) {
/* 216 */     GuildManagerHandler.UseCond.Builder useCond = GuildManagerHandler.UseCond.newBuilder();
/* 217 */     useCond.setLevel(level);
/* 218 */     useCond.setUpLevel(upLevel);
/* 219 */     useCond.setJob(job);
/* 220 */     return useCond.build();
/*     */   }
/*     */   
/*     */   public static GuildManagerHandler.QualityCond newQualityCond(int level, int upLevel, int color) {
/* 224 */     GuildManagerHandler.QualityCond.Builder qualityCond = GuildManagerHandler.QualityCond.newBuilder();
/* 225 */     qualityCond.setLevel(level);
/* 226 */     qualityCond.setUpLevel(upLevel);
/* 227 */     qualityCond.setQColor(color);
/* 228 */     return qualityCond.build();
/*     */   }
/*     */   
/*     */   public static GuildDepotHandler.DepotCondition convertCond(GuildManagerHandler.DepotCondition retCond) {
/* 232 */     GuildDepotHandler.UseCond.Builder useCond = GuildDepotHandler.UseCond.newBuilder();
/* 233 */     useCond.setLevel(retCond.toBuilder().getUseCond().getLevel());
/* 234 */     useCond.setUpLevel(retCond.toBuilder().getUseCond().getUpLevel());
/* 235 */     useCond.setJob(retCond.toBuilder().getUseCond().getJob());
/*     */     
/* 237 */     GuildDepotHandler.QualityCond.Builder minCond = GuildDepotHandler.QualityCond.newBuilder();
/* 238 */     minCond.setLevel(retCond.toBuilder().getMinCond().getLevel());
/* 239 */     minCond.setUpLevel(retCond.toBuilder().getMinCond().getUpLevel());
/* 240 */     minCond.setQColor(retCond.toBuilder().getMinCond().getQColor());
/*     */     
/* 242 */     GuildDepotHandler.QualityCond.Builder maxCond = GuildDepotHandler.QualityCond.newBuilder();
/* 243 */     maxCond.setLevel(retCond.toBuilder().getMaxCond().getLevel());
/* 244 */     maxCond.setUpLevel(retCond.toBuilder().getMaxCond().getUpLevel());
/* 245 */     maxCond.setQColor(retCond.toBuilder().getMaxCond().getQColor());
/*     */     
/* 247 */     GuildDepotHandler.DepotCondition.Builder condition = GuildDepotHandler.DepotCondition.newBuilder();
/* 248 */     condition.setUseCond(useCond);
/* 249 */     condition.setMinCond(minCond);
/* 250 */     condition.setMaxCond(maxCond);
/* 251 */     return condition.build();
/*     */   }
/*     */   
/*     */   public static GuildManagerHandler.RoleInfo.Builder toMgrRoleInfo(int pro, String name) {
/* 255 */     GuildManagerHandler.RoleInfo.Builder roleInfo = GuildManagerHandler.RoleInfo.newBuilder();
/* 256 */     roleInfo.setPro(pro);
/* 257 */     roleInfo.setName(name);
/* 258 */     return roleInfo;
/*     */   }
/*     */   
/*     */   public static GuildManagerHandler.ItemRecordInfo.Builder toMgrItemRecordInfo(int qColor, String name) {
/* 262 */     GuildManagerHandler.ItemRecordInfo.Builder tmp = GuildManagerHandler.ItemRecordInfo.newBuilder();
/* 263 */     tmp.setQColor(qColor);
/* 264 */     tmp.setName(name);
/* 265 */     return tmp;
/*     */   }
/*     */   
/*     */   public static GuildHandler.RoleInfo convertRoleInfo(RoleInfo roleInfo) {
/* 269 */     GuildHandler.RoleInfo.Builder role = GuildHandler.RoleInfo.newBuilder();
/* 270 */     role.setPro(roleInfo.pro);
/* 271 */     if (StringUtil.isNotEmpty(roleInfo.name)) {
/* 272 */       role.setName(roleInfo.name);
/*     */     }
/* 274 */     return role.build();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GuildManagerHandler.RoleInfo toGuildMgrHandler(RoleInfo roleInfo) {
/* 284 */     if (null != roleInfo) {
/* 285 */       GuildManagerHandler.RoleInfo.Builder role = GuildManagerHandler.RoleInfo.newBuilder();
/* 286 */       role.setPro(roleInfo.pro);
/* 287 */       role.setName(roleInfo.name);
/* 288 */       return role.build();
/*     */     } 
/* 290 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> void hset(ConstsTR key, String field, T po) {
/* 301 */     GCache.hset(key.value, field, Utils.serialize(po));
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
/*     */   public static <T> ArrayList<T> hgetAll(ConstsTR key, Class<T> clazz) {
/*     */     try {
/* 314 */       Map<String, String> dataMap = GCache.hgetAll(key.value);
/* 315 */       ArrayList<T> list = new ArrayList<>();
/* 316 */       for (String data : dataMap.values()) {
/* 317 */         T po = (T)Utils.deserialize(data, clazz);
/* 318 */         list.add(po);
/*     */       } 
/* 320 */       return list;
/* 321 */     } catch (Exception e) {
/* 322 */       Out.error(new Object[] { e });
/* 323 */       return null;
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
/*     */ 
/*     */   
/*     */   public static <T> T hget(ConstsTR key, String field, Class<T> clazz) {
/*     */     try {
/* 338 */       String data = GCache.hget(key.value, field);
/* 339 */       if (StringUtil.isNotEmpty(data)) {
/* 340 */         return (T)Utils.deserialize(data, clazz);
/*     */       }
/* 342 */       return null;
/* 343 */     } catch (Exception e) {
/* 344 */       Out.error(new Object[] { e });
/* 345 */       return null;
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
/*     */   public static String leftTimeTips(long needMs) {
/* 357 */     int leftHour = (int)Math.floor((needMs / Const.Time.Hour.getValue()));
/* 358 */     int leftMinute = (int)Math.ceil((needMs % Const.Time.Hour.getValue() / Const.Time.Minute.getValue()));
/* 359 */     int leftSec = (int)Math.ceil((needMs % Const.Time.Hour.getValue() % Const.Time.Minute.getValue() / Const.Time.Second.getValue()));
/* 360 */     String cdInfo = "";
/* 361 */     if (leftHour > 0) {
/* 362 */       cdInfo = cdInfo + leftHour + LangService.getValue("GUILD_HOUR");
/* 363 */       cdInfo = cdInfo + leftMinute + LangService.getValue("GUILD_MIN");
/* 364 */     } else if (leftHour <= 0 && leftMinute > 0) {
/* 365 */       cdInfo = cdInfo + leftMinute + LangService.getValue("GUILD_MIN");
/* 366 */     } else if (leftMinute == 0) {
/* 367 */       cdInfo = cdInfo + leftSec + LangService.getValue("GUILD_SEC");
/*     */     } 
/* 369 */     return cdInfo;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\GuildCommonUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */