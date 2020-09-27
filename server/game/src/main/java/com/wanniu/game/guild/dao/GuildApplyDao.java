/*     */ package com.wanniu.game.guild.dao;
/*     */ 
/*     */ import com.wanniu.core.db.GCache;
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.data.ext.GuildSettingExt;
/*     */ import com.wanniu.game.guild.GuildCommonUtil;
/*     */ import com.wanniu.game.guild.GuildUtil;
/*     */ import com.wanniu.game.poes.GuildApplyPO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ 
/*     */ 
/*     */ public class GuildApplyDao
/*     */ {
/*     */   public static class GuildApplyMap
/*     */     extends ConcurrentHashMap<String, GuildApplyPO>
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*  26 */     private Map<String, Map<String, GuildApplyPO>> playerApplys = new HashMap<>();
/*     */     
/*  28 */     private Map<String, Map<String, GuildApplyPO>> guildApplys = new HashMap<>();
/*     */ 
/*     */ 
/*     */     
/*     */     public GuildApplyPO put(String key, GuildApplyPO value) {
/*  33 */       Map<String, GuildApplyPO> applys = this.playerApplys.get(value.playerId);
/*  34 */       if (applys == null) {
/*  35 */         applys = new HashMap<>();
/*  36 */         this.playerApplys.put(value.playerId, applys);
/*     */       } 
/*  38 */       applys.put(value.id, value);
/*     */ 
/*     */       
/*  41 */       applys = this.guildApplys.get(value.guildId);
/*  42 */       if (applys == null) {
/*  43 */         applys = new HashMap<>();
/*  44 */         this.guildApplys.put(value.guildId, applys);
/*     */       } 
/*  46 */       applys.put(value.id, value);
/*     */       
/*  48 */       Out.debug(new Object[] { entrySet() });
/*  49 */       Out.debug(new Object[] { key });
/*  50 */       GuildApplyPO result = super.put(key, value);
/*  51 */       Out.debug(new Object[] { entrySet() });
/*  52 */       return result;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public GuildApplyPO remove(Object key) {
/*  58 */       Out.debug(new Object[] { key });
/*  59 */       Out.debug(new Object[] { entrySet() });
/*  60 */       GuildApplyPO value = super.remove(key);
/*  61 */       Out.debug(new Object[] { entrySet() });
/*  62 */       if (value != null) {
/*     */         
/*  64 */         Map<String, GuildApplyPO> applys = this.playerApplys.get(value.playerId);
/*  65 */         if (applys != null) {
/*  66 */           applys.remove(value.id);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*  71 */         applys = this.guildApplys.get(value.guildId);
/*  72 */         if (applys != null) {
/*  73 */           applys.remove(value.id);
/*     */         }
/*     */       } 
/*     */       
/*  77 */       return value;
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/*  82 */       this.playerApplys.clear();
/*  83 */       this.guildApplys.clear();
/*  84 */       super.clear();
/*     */     }
/*     */     
/*     */     public Map<String, GuildApplyPO> getPlayerApplys(String playerId) {
/*  88 */       return this.playerApplys.get(playerId);
/*     */     }
/*     */     
/*     */     public Map<String, GuildApplyPO> getGuildApplys(String guildId) {
/*  92 */       return this.guildApplys.get(guildId);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*  97 */   public static final GuildApplyMap GuildApplys = new GuildApplyMap();
/*     */   
/*     */   public static void init() {
/* 100 */     List<GuildApplyPO> applys = GuildCommonUtil.hgetAll(ConstsTR.guildApplyTR, GuildApplyPO.class);
/* 101 */     for (GuildApplyPO po : applys) {
/* 102 */       GuildApplys.put(po.id, po);
/*     */     }
/* 104 */     Out.debug(new Object[] { GuildApplys });
/* 105 */     JobFactory.addFixedRateJob(() -> { long currTime = System.currentTimeMillis(); GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp(); int expireTime = settingProp.applicationFail * Const.Time.Minute.getValue(); for (GuildApplyPO apply : GuildApplys.values()) { if (currTime - apply.createTime.getTime() >= expireTime) { removeGuildApply(apply.id); Out.debug(new Object[] { "timeout guild apply : ", apply.id }, ); }  }  }1000L, Const.Time.Minute
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 115 */         .getValue());
/*     */   }
/*     */   
/*     */   public static GuildApplyPO getGuildApply(String id) {
/* 119 */     return GuildApplys.get(id);
/*     */   }
/*     */   
/*     */   public static int getGuildApplyCount(String guildId) {
/* 123 */     Map<String, GuildApplyPO> applyMap = GuildApplys.getGuildApplys(guildId);
/* 124 */     return (applyMap != null) ? applyMap.size() : 0;
/*     */   }
/*     */   
/*     */   public static List<GuildApplyPO> getGuildApplyList(String guildId) {
/* 128 */     List<GuildApplyPO> applys = new ArrayList<>();
/* 129 */     Map<String, GuildApplyPO> applyMap = GuildApplys.getGuildApplys(guildId);
/* 130 */     if (applyMap != null) {
/* 131 */       applys.addAll(applyMap.values());
/*     */     }
/* 133 */     return applys;
/*     */   }
/*     */   
/*     */   public static List<GuildApplyPO> getPlayerApplyIdList(String playerId) {
/* 137 */     List<GuildApplyPO> applys = new ArrayList<>();
/* 138 */     Map<String, GuildApplyPO> applyMap = GuildApplys.getPlayerApplys(playerId);
/* 139 */     if (applyMap != null) {
/* 140 */       applys.addAll(applyMap.values());
/*     */     }
/* 142 */     return applys;
/*     */   }
/*     */   
/*     */   public static void addGuildApply(GuildApplyPO data) {
/* 146 */     GuildApplys.put(data.id, data);
/* 147 */     GCache.hset(ConstsTR.guildApplyTR.value, data.id, Utils.serialize(data));
/*     */   }
/*     */   
/*     */   public static void removeGuildApply(String id) {
/* 151 */     GuildApplys.remove(id);
/* 152 */     GCache.hremove(ConstsTR.guildApplyTR.value, id);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\dao\GuildApplyDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */