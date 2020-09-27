/*     */ package com.wanniu.game.guild;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.common.CommonUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.GuildPositionCO;
/*     */ import com.wanniu.game.data.ext.GuildSettingExt;
/*     */ import com.wanniu.game.guild.dao.GuildApplyDao;
/*     */ import com.wanniu.game.guild.dao.GuildDao;
/*     */ import com.wanniu.game.guild.dao.GuildMemberDao;
/*     */ import com.wanniu.game.guild.guidDepot.GuildRecordData;
/*     */ import com.wanniu.game.poes.GuildApplyPO;
/*     */ import com.wanniu.game.poes.GuildDungeonPO;
/*     */ import com.wanniu.game.poes.GuildMemberPO;
/*     */ import com.wanniu.game.poes.GuildPO;
/*     */ import com.wanniu.game.rank.RankType;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class GuildServiceCenter
/*     */ {
/*     */   private static GuildServiceCenter instance;
/*     */   public Map<String, GuildDungeonPO> guildDungeon;
/*     */   
/*     */   public static GuildServiceCenter getInstance() {
/*  33 */     if (instance == null) {
/*  34 */       instance = new GuildServiceCenter();
/*     */     }
/*  36 */     return instance;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private GuildServiceCenter() {
/*  42 */     this.guildDungeon = new HashMap<>();
/*     */   }
/*     */ 
/*     */   
/*     */   public void init() {
/*  47 */     GuildDao.init();
/*     */     
/*  49 */     GuildApplyDao.init();
/*     */     
/*  51 */     GuildMemberDao.init();
/*     */     
/*  53 */     if (GWorld.DEBUG) {
/*  54 */       for (String guildId : GuildDao.GuildMap.keySet()) {
/*  55 */         if (GuildMemberDao.getGuildMemberCount(guildId) == 0) {
/*  56 */           Out.warn(new Object[] { "remove empty guild : ", guildId });
/*  57 */           GuildDao.removeGuild((GuildPO)GuildDao.GuildMap.get(guildId));
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*  62 */     ArrayList<GuildDungeonPO> guildDungeonList = GuildUtil.getAllGuildDungeon();
/*  63 */     for (GuildDungeonPO dungeon : guildDungeonList) {
/*  64 */       this.guildDungeon.put(dungeon.id, dungeon);
/*     */     }
/*     */   }
/*     */   
/*     */   public void delGuild(GuildPO guildPo) {
/*  69 */     GuildUtil.removeGuild(guildPo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GuildPO getGuildByMemberId(String playerId) {
/*  78 */     GuildMemberPO memberPo = getGuildMember(playerId);
/*     */ 
/*     */     
/*  81 */     if (null == memberPo) {
/*  82 */       return null;
/*     */     }
/*     */     
/*  85 */     return getGuild(memberPo.guildId);
/*     */   }
/*     */   
/*     */   public GuildPO getGuild(String guildId) {
/*  89 */     return GuildDao.getGuild(guildId);
/*     */   }
/*     */   
/*     */   public GuildApplyPO getApply(String applyId) {
/*  93 */     return GuildUtil.getGuildApply(applyId);
/*     */   }
/*     */   
/*     */   public GuildMemberPO getGuildMember(String playerId) {
/*  97 */     return GuildMemberDao.getGuildMember(playerId);
/*     */   }
/*     */   
/*     */   public GuildApplyPO getGuildApply(String applyId) {
/* 101 */     return getApply(applyId);
/*     */   }
/*     */   
/*     */   public ArrayList<GuildMemberPO> getGuildMemberList(String guildId) {
/* 105 */     ArrayList<GuildMemberPO> data = new ArrayList<>();
/* 106 */     Set<String> memberIds = getGuildMemberIdList(guildId);
/* 107 */     for (String id : memberIds) {
/* 108 */       GuildMemberPO member = getGuildMember(id);
/* 109 */       if (member != null) {
/* 110 */         data.add(member);
/*     */       }
/*     */     } 
/* 113 */     return data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getGuildMemberIdList(String guildId, Const.GuildJob... jobs) {
/* 123 */     List<String> data = new ArrayList<>();
/* 124 */     Set<String> memberIds = getGuildMemberIdList(guildId);
/* 125 */     for (String id : memberIds) {
/* 126 */       GuildMemberPO member = getGuildMember(id);
/* 127 */       if (member != null) {
/* 128 */         for (Const.GuildJob job : jobs) {
/* 129 */           if (member.job == job.getValue()) {
/* 130 */             data.add(id);
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 136 */     return data;
/*     */   }
/*     */   
/*     */   public List<GuildApplyPO> getPlayerApplyList(String playerId) {
/* 140 */     return GuildUtil.getPlayerApplyIdList(playerId);
/*     */   }
/*     */   
/*     */   public List<GuildApplyPO> getGuildApplyList(String guildId) {
/* 144 */     return GuildUtil.getGuildApplyList(guildId);
/*     */   }
/*     */   
/*     */   public Set<String> getGuildMemberIdList(String guildId) {
/* 148 */     return (Set<String>)GuildMemberDao.GuildMemberMap.get(guildId);
/*     */   }
/*     */   
/*     */   public int getGuildMemberCount(String guildId) {
/* 152 */     Set<String> list = getGuildMemberIdList(guildId);
/* 153 */     if (null != list) {
/* 154 */       return list.size();
/*     */     }
/* 156 */     return 0;
/*     */   }
/*     */   
/*     */   public void removeGuildNameIndex(int logicServerId, String name) {
/* 160 */     GuildUtil.removeGuildNameIndex(logicServerId, name);
/*     */   }
/*     */   
/*     */   public void _addArrayIndex(Map<String, Set<String>> arrayMap, String key, String value) {
/* 164 */     if (null == arrayMap.get(key)) {
/* 165 */       arrayMap.put(key, new HashSet<>());
/*     */     }
/* 167 */     ((Set<String>)arrayMap.get(key)).add(value);
/*     */   }
/*     */   
/*     */   public void addGuild(GuildPO data) {
/* 171 */     saveGuild(data);
/*     */   }
/*     */   
/*     */   public void addMember(GuildMemberPO data) {
/* 175 */     saveMember(data);
/*     */   }
/*     */   
/*     */   public void addApply(GuildApplyPO data) {
/* 179 */     GuildUtil.addGuildApply(data);
/* 180 */     List<GuildMemberPO> ls = GuildUtil.getGuildMemberList(data.guildId);
/* 181 */     for (GuildMemberPO po : ls) {
/* 182 */       GuildPositionCO co = GuildUtil.getGuildJobPropByJobId(po.pro);
/* 183 */       if (null == co || 0 == co.right3) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */       
/* 188 */       CommonUtil.sendIconMsgType(Const.MESSAGE_TYPE.guild_apply, po.playerId);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeMember(String playerId) {
/* 198 */     GuildUtil.removeGuildMember(playerId);
/*     */   }
/*     */   
/*     */   public void removeApply(String applyId) {
/* 202 */     GuildUtil.removeGuildApply(applyId);
/*     */   }
/*     */   
/*     */   public void saveGuild(GuildPO guildData) {
/* 206 */     GuildUtil.updateGuild(guildData);
/*     */   }
/*     */   
/*     */   public void saveMember(GuildMemberPO memberData) {
/* 210 */     GuildUtil.updateGuildMember(memberData);
/*     */   }
/*     */   
/*     */   public boolean isInGuild(String playerId) {
/* 214 */     return (getGuildMember(playerId) != null);
/*     */   }
/*     */   
/*     */   public String getGuildId(String playerId) {
/* 218 */     GuildMemberPO po = getGuildMember(playerId);
/* 219 */     return (po == null) ? null : po.guildId;
/*     */   }
/*     */   
/*     */   public boolean existGuildName(int logicServerId, String name) {
/* 223 */     return StringUtil.isNotEmpty(GuildDao.getGuildIdByName(name));
/*     */   }
/*     */   
/*     */   public void removeAllPlayerApplyAsync(String playerId) {
/* 227 */     List<GuildApplyPO> applies = GuildApplyDao.getPlayerApplyIdList(playerId);
/* 228 */     for (int i = applies.size() - 1; i >= 0; i--) {
/* 229 */       removeApply(((GuildApplyPO)applies.get(i)).id);
/*     */     }
/*     */   }
/*     */   
/*     */   public void addGuildRecord(String guildId, GuildRecordData record) {
/* 234 */     GuildPO guild = getGuild(guildId);
/* 235 */     if (null == guild)
/*     */       return; 
/* 237 */     GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
/* 238 */     record.time = new Date();
/* 239 */     if (null == guild.allBlobData) {
/* 240 */       guild.allBlobData = new GuildAllBlob();
/*     */     }
/*     */     
/* 243 */     List<GuildRecordData> news = GuildDao.getGuildNews(guildId);
/* 244 */     news.add(0, record);
/*     */     
/* 246 */     while (news.size() > settingProp.recording) {
/* 247 */       news.remove(news.size() - 1);
/*     */     }
/*     */     
/* 250 */     GuildDao.saveGuildNews(guildId);
/*     */   }
/*     */   
/*     */   public double convert2Double(long sumFund) {
/* 254 */     double sum = sumFund;
/* 255 */     while (sum > 1.0D) {
/* 256 */       sum *= 0.1D;
/*     */     }
/* 258 */     return sum;
/*     */   }
/*     */   
/*     */   public void refreshGuildTopInfo(String guildId) {
/* 262 */     GuildPO guild = getGuild(guildId);
/* 263 */     if (null == guild) {
/*     */       return;
/*     */     }
/*     */     
/* 267 */     RankType.GUILD_LEVEL.getHandler().handle(guild);
/*     */   }
/*     */ 
/*     */   
/*     */   public GuildDungeonPO getGuildDungeon(String guildId) {
/* 272 */     GuildDungeonPO dungeonInfo = this.guildDungeon.get(guildId);
/*     */     
/* 274 */     if (dungeonInfo != null)
/*     */     {
/* 276 */       return dungeonInfo;
/*     */     }
/*     */     
/* 279 */     dungeonInfo = new GuildDungeonPO();
/* 280 */     this.guildDungeon.put(guildId, dungeonInfo);
/* 281 */     return this.guildDungeon.get(guildId);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\GuildServiceCenter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */