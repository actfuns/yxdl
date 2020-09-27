/*     */ package com.wanniu.game.guild.guildImpeach;
/*     */ 
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.ext.GuildSettingExt;
/*     */ import com.wanniu.game.guild.GuildCommonUtil;
/*     */ import com.wanniu.game.guild.GuildMsg;
/*     */ import com.wanniu.game.guild.GuildService;
/*     */ import com.wanniu.game.guild.GuildServiceCenter;
/*     */ import com.wanniu.game.guild.GuildUtil;
/*     */ import com.wanniu.game.guild.RoleInfo;
/*     */ import com.wanniu.game.guild.dao.GuildImpeachDao;
/*     */ import com.wanniu.game.guild.guidDepot.GuildRecordData;
/*     */ import com.wanniu.game.poes.GuildMemberPO;
/*     */ import com.wanniu.game.poes.GuildPO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuildImpeachCenter
/*     */ {
/*     */   private static GuildImpeachCenter instance;
/*     */   Map<String, GuildImpeachData> impeachMap;
/*     */   
/*     */   private GuildImpeachCenter() {
/*  32 */     this.impeachMap = new HashMap<>();
/*  33 */     init();
/*     */   }
/*     */   
/*     */   public static GuildImpeachCenter getInstance() {
/*  37 */     if (instance == null) {
/*  38 */       instance = new GuildImpeachCenter();
/*     */     }
/*  40 */     return instance;
/*     */   }
/*     */   
/*     */   public void init() {
/*  44 */     initFromRedis();
/*     */     
/*  46 */     JobFactory.addDelayJob(new Runnable()
/*     */         {
/*     */           public void run() {
/*  49 */             GuildImpeachCenter.this.refreshAllImpeach();
/*     */           }
/*  51 */         },  Const.Time.Minute.getValue());
/*     */   }
/*     */   
/*     */   public void initFromRedis() {
/*  55 */     ArrayList<GuildImpeachData> impeachList = GuildImpeachDao.getImpeachList();
/*  56 */     for (int i = 0; i < impeachList.size(); i++) {
/*  57 */       GuildImpeachData impeach = impeachList.get(i);
/*  58 */       this.impeachMap.put(impeach.id, impeach);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void refreshAllImpeach() {
/*  63 */     GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
/*  64 */     if (null == this.impeachMap || settingProp == null)
/*     */       return; 
/*  66 */     List<GuildImpeachData> copyList = new ArrayList<>();
/*  67 */     for (GuildImpeachData data : this.impeachMap.values()) {
/*  68 */       copyList.add(data);
/*     */     }
/*     */     
/*  71 */     for (GuildImpeachData impeach : copyList) {
/*  72 */       refreshOneImpeachByData(impeach, settingProp);
/*     */     }
/*     */   }
/*     */   
/*     */   public void refreshImpeash(String guildId) {
/*  77 */     GuildImpeachData impeach = getImpeach(guildId);
/*  78 */     GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
/*  79 */     refreshOneImpeachByData(impeach, settingProp);
/*     */   }
/*     */   
/*     */   public void refreshOneImpeachByData(GuildImpeachData impeach, GuildSettingExt settingProp) {
/*  83 */     if (null == settingProp || null == impeach) {
/*     */       return;
/*     */     }
/*  86 */     GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/*  87 */     if (null != impeach) {
/*  88 */       long createTime = impeach.createTime.getTime();
/*  89 */       long nowTime = System.currentTimeMillis();
/*  90 */       if (nowTime - createTime > settingProp.impeachTimeMs) {
/*  91 */         int impeachNum = impeach.playerIds.size();
/*  92 */         if (impeachNum >= settingProp.impeachNo) {
/*  93 */           autoTransferPresident(impeach.id);
/*  94 */           removeGuildImpeach(impeach.id);
/*     */         } else {
/*     */           
/*  97 */           GuildRecordData record = new GuildRecordData();
/*  98 */           record.type = Const.GuildRecord.IMPEACH_TIMEOUT.getValue();
/*  99 */           RoleInfo role1 = new RoleInfo();
/* 100 */           role1.pro = impeach.sponsor.pro;
/* 101 */           role1.name = impeach.sponsor.name;
/* 102 */           record.role1 = role1;
/* 103 */           record.result.v2 = Integer.toString(impeach.playerIds.size());
/* 104 */           guildManager.addGuildRecord(impeach.id, record);
/* 105 */           removeGuildImpeach(impeach.id);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public GuildImpeachData getImpeach(String guildId) {
/* 113 */     return this.impeachMap.get(guildId);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addImpeachAndSave(GuildImpeachData impeach) {
/* 118 */     this.impeachMap.put(impeach.id, impeach);
/* 119 */     updateGuildImpeach(impeach.id);
/*     */   }
/*     */   
/*     */   public void updateGuildImpeach(String guildId) {
/* 123 */     GuildImpeachData impeach = getImpeach(guildId);
/* 124 */     if (null == impeach) {
/*     */       return;
/*     */     }
/* 127 */     updateGuildImpeachByData(impeach);
/*     */   }
/*     */   
/*     */   public void removeGuildImpeach(String guildId) {
/* 131 */     GuildImpeachData impeach = getImpeach(guildId);
/* 132 */     if (null == impeach) {
/*     */       return;
/*     */     }
/* 135 */     removeGuildImpeachByData(impeach);
/*     */   }
/*     */   
/*     */   public void updateGuildImpeachByData(GuildImpeachData impeach) {
/* 139 */     GuildImpeachDao.updateGuildImpeach(impeach);
/*     */   }
/*     */   
/*     */   public void removeGuildImpeachByData(GuildImpeachData impeach) {
/* 143 */     GuildImpeachDao.removeGuildImpeachByData(impeach);
/* 144 */     this.impeachMap.remove(impeach.id);
/*     */   }
/*     */   
/*     */   public void sortGuildMember(List<GuildMemberPO> list) {
/* 148 */     list.sort((memberA, memberB) -> {
/*     */           boolean isTodayA = !DateUtil.canRefreshData(5, memberA.lastContributeTime);
/*     */           boolean isTodayB = !DateUtil.canRefreshData(5, memberB.lastContributeTime);
/* 151 */           return (isTodayA && isTodayB) ? ((memberA.lastContributeValue != memberB.lastContributeValue) ? ((memberA.lastContributeValue < memberB.lastContributeValue) ? 1 : -1) : ((memberA.createTime.getTime() < memberB.createTime.getTime()) ? -1 : 1)) : (isTodayA ? -1 : (isTodayB ? 1 : ((memberA.createTime.getTime() < memberB.createTime.getTime()) ? -1 : 1)));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean autoTransferPresident(String guildId) {
/* 169 */     GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/* 170 */     GuildPO guild = guildManager.getGuild(guildId);
/* 171 */     if (null == guild) {
/* 172 */       return false;
/*     */     }
/*     */     
/* 175 */     ArrayList<GuildMemberPO> memberList = guildManager.getGuildMemberList(guildId);
/* 176 */     GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
/* 177 */     if (null == settingProp) {
/* 178 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 182 */     GuildMemberPO oldPresident = null;
/* 183 */     List<GuildMemberPO> viceGroup = new ArrayList<>();
/* 184 */     List<GuildMemberPO> memberGroup = new ArrayList<>();
/* 185 */     for (int i = 0; i < memberList.size(); i++) {
/* 186 */       GuildMemberPO member = memberList.get(i);
/* 187 */       if (member.job == Const.GuildJob.VICE_PRESIDENT.getValue()) {
/* 188 */         viceGroup.add(member);
/*     */       }
/* 190 */       else if (member.job == Const.GuildJob.PRESIDENT.getValue()) {
/* 191 */         oldPresident = member;
/*     */       } else {
/* 193 */         memberGroup.add(member);
/*     */       } 
/*     */     } 
/*     */     
/* 197 */     GuildMemberPO newPresident = null;
/* 198 */     if (viceGroup.size() > 0) {
/* 199 */       sortGuildMember(viceGroup);
/* 200 */       if (!DateUtil.canRefreshData(5, ((GuildMemberPO)viceGroup.get(0)).lastContributeTime)) {
/* 201 */         newPresident = viceGroup.get(0);
/*     */       }
/*     */     } 
/* 204 */     if (null == newPresident && memberGroup.size() > 0) {
/* 205 */       sortGuildMember(memberGroup);
/* 206 */       newPresident = memberGroup.get(0);
/*     */     } 
/* 208 */     if (null == newPresident) {
/* 209 */       return false;
/*     */     }
/* 211 */     oldPresident.job = Const.GuildJob.MEMBER.getValue();
/* 212 */     newPresident.job = Const.GuildJob.PRESIDENT.getValue();
/* 213 */     guild.presidentId = newPresident.playerId;
/* 214 */     guild.presidentPro = newPresident.pro;
/* 215 */     guild.presidentName = newPresident.name;
/*     */     
/* 217 */     guildManager.saveMember(newPresident);
/* 218 */     guildManager.saveMember(oldPresident);
/* 219 */     guildManager.saveGuild(guild);
/*     */ 
/*     */     
/* 222 */     Map<String, String> map = new HashMap<>();
/* 223 */     map.put("guildposition", (String)guild.officeNames.get(Integer.valueOf(oldPresident.job)));
/* 224 */     GuildCommonUtil.sendMailSystenType(oldPresident.playerId, "Guild_position", map);
/*     */     
/* 226 */     Map<String, String> newMap = new HashMap<>();
/* 227 */     newMap.put("guildposition", (String)guild.officeNames.get(Integer.valueOf(newPresident.job)));
/* 228 */     GuildCommonUtil.sendMailSystenType(oldPresident.playerId, "Guild_position", newMap);
/*     */ 
/*     */     
/* 231 */     GuildMsg.RefreshGuildMsg msgData = new GuildMsg.RefreshGuildMsg();
/* 232 */     msgData.job = oldPresident.job;
/* 233 */     msgData.jobName = (String)guild.officeNames.get(Integer.valueOf(oldPresident.job));
/* 234 */     GuildMsg msg = new GuildMsg(Const.NotifyType.GUILD_JOB_CHANGE.getValue(), (GuildMsg.GuildMsgData)msgData);
/* 235 */     msg.data = (GuildMsg.GuildMsgData)msgData;
/* 236 */     Set<String> ids1 = new HashSet<>();
/* 237 */     ids1.add(oldPresident.playerId);
/* 238 */     GuildService.notifySomePlayerRefreshGuild(ids1, msg, null);
/*     */     
/* 240 */     GuildMsg.RefreshGuildMsg msgData2 = new GuildMsg.RefreshGuildMsg();
/* 241 */     msgData2.job = newPresident.job;
/* 242 */     msgData2.jobName = (String)guild.officeNames.get(Integer.valueOf(newPresident.job));
/* 243 */     GuildMsg msg2 = new GuildMsg(Const.NotifyType.GUILD_JOB_CHANGE.getValue(), (GuildMsg.GuildMsgData)msgData2);
/* 244 */     msg2.data = (GuildMsg.GuildMsgData)msgData2;
/* 245 */     Set<String> ids2 = new HashSet<>();
/* 246 */     ids1.add(newPresident.playerId);
/* 247 */     GuildService.notifySomePlayerRefreshGuild(ids2, msg, null);
/*     */     
/* 249 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guildImpeach\GuildImpeachCenter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */