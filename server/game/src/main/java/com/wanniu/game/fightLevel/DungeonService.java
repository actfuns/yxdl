/*     */ package com.wanniu.game.fightLevel;
/*     */ 
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.core.util.RandomUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.area.AreaManager;
/*     */ import com.wanniu.game.area.AreaUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.msg.MessageUtil;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.base.MapBase;
/*     */ import com.wanniu.game.data.base.MonsterBase;
/*     */ import com.wanniu.game.data.ext.MonsterRefreshExt;
/*     */ import com.wanniu.game.monster.MonsterConfig;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.PlayerPO;
/*     */ import com.wanniu.game.team.TeamData;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import pomelo.area.FightLevelHandler;
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
/*     */ public class DungeonService
/*     */ {
/*     */   private static DungeonService instance;
/*     */   
/*     */   public static DungeonService getInstance() {
/*  48 */     if (instance == null) {
/*  49 */       instance = new DungeonService();
/*     */     }
/*  51 */     return instance;
/*     */   }
/*     */   
/*     */   private DungeonService() {
/*  55 */     for (Iterator<MonsterRefreshExt> iterator = GameData.MonsterRefreshs.values().iterator(); iterator.hasNext(); ) { MonsterRefreshExt refreshExt = iterator.next();
/*  56 */       Date bornBeginTime = AreaUtil.formatToday(refreshExt.rebornBeginTime);
/*  57 */       Date bornEndTime = AreaUtil.formatToday(refreshExt.rebornEndTime);
/*  58 */       long now = System.currentTimeMillis();
/*     */       
/*  60 */       Long nextRefreshTime = Long.valueOf(0L);
/*  61 */       if (now < bornBeginTime.getTime()) {
/*  62 */         nextRefreshTime = Long.valueOf(bornBeginTime.getTime() - now);
/*  63 */       } else if (now < bornEndTime.getTime()) {
/*  64 */         nextRefreshTime = Long.valueOf((refreshExt.coolDownTime * Const.Time.Minute.getValue()) - (now - bornBeginTime.getTime()) % (refreshExt.coolDownTime * Const.Time.Minute.getValue()));
/*     */       } else {
/*  66 */         nextRefreshTime = Long.valueOf(DateUtil.getDateAfter(bornBeginTime, 1).getTimeInMillis() - now);
/*     */       } 
/*     */       
/*  69 */       JobFactory.addFixedRateJob(() -> { long nowTime = System.currentTimeMillis(); Date bornBeginTime_everyday = AreaUtil.formatToday(refreshExt.rebornBeginTime); Date bornEndTime_everyday = AreaUtil.formatToday(refreshExt.rebornEndTime); Out.info(new Object[] { "begin refresh boss next refresh date:", bornBeginTime_everyday, ",end time:", bornEndTime_everyday, ",bossId=", Integer.valueOf(refreshExt.monsterID) }, ); if (nowTime >= bornBeginTime_everyday.getTime() && nowTime < bornEndTime_everyday.getTime()) { if (refreshExt.msgSend > 0) { String msg = LangService.getValue("MONSTER_BOSS_REBORN_MESSAGE"); MonsterBase monsterProp = MonsterConfig.getInstance().get(refreshExt.monsterID); String monsterName = MessageUtil.getMonsterName(monsterProp.name, monsterProp.qcolor); MapBase areaProp = AreaUtil.getAreaProp(refreshExt.mapID); msg = msg.replace("{name}", monsterName); msg = msg.replace("{site}", areaProp.name); MessageUtil.sendRollChat(GWorld.__SERVER_ID, msg, Const.CHAT_SCOPE.SYSTEM); }  for (Area area : AreaManager.getInstance().getAreaMap().values()) { if (area.areaId != refreshExt.mapID) continue;  triggerMonster(GWorld.__SERVER_ID, refreshExt.iD, refreshExt.mapID, refreshExt.msgSend, refreshExt.monsterID); Out.debug(new Object[] { "triggerMonster::", Integer.valueOf(refreshExt.iD), ",", Integer.valueOf(refreshExt.mapID), ",", Integer.valueOf(refreshExt.msgSend), ",", Integer.valueOf(refreshExt.monsterID) }); }  }  }nextRefreshTime
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
/*  98 */           .longValue(), (refreshExt.coolDownTime * Const.Time.Minute.getValue())); }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String enterDungeonInTeam(TeamData team, MapBase prop, int dungeonId) {
/* 105 */     Map<String, TeamData.TeamMemberData> teamMembers = team.teamMembers;
/* 106 */     String data = canEnterDungeon(teamMembers, prop);
/* 107 */     if (data != null)
/*     */     {
/* 109 */       return LangService.format("TEAM_MEMBER_BATTLE_ING", new Object[] { data });
/*     */     }
/*     */     
/* 112 */     List<FightLevelHandler.MemberData> memberData = new ArrayList<>();
/*     */     
/* 114 */     for (TeamData.TeamMemberData teamMember : teamMembers.values()) {
/* 115 */       PlayerPO member = teamMember.getPlayerData();
/* 116 */       FightLevelHandler.MemberData.Builder md = FightLevelHandler.MemberData.newBuilder();
/* 117 */       md.setId(teamMember.id);
/* 118 */       md.setName(member.name);
/* 119 */       md.setPro(member.pro);
/* 120 */       md.setLevel(member.level);
/*     */       
/* 122 */       memberData.add(md.build());
/*     */     } 
/*     */     
/* 125 */     int overTime = GlobalConfig.TeamGoMapLeftTime;
/*     */     
/* 127 */     FightLevelHandler.OnConfirmEnterFubenPush enterFuben = FightLevelHandler.OnConfirmEnterFubenPush.newBuilder().setS2CMsg(LangService.getValue("CONFIRM_ENTRY")).setS2CFubenId(prop.mapID).setS2COverTime(overTime).setS2CLeaderId(team.leaderId).addAllS2CMemberData(memberData).build();
/*     */     
/* 129 */     team.lock(overTime);
/*     */     
/* 131 */     if (prop.type == Const.SCENE_TYPE.LOOP.getValue()) {
/*     */       
/* 133 */       for (TeamData.TeamMemberData teamMember : teamMembers.values()) {
/* 134 */         teamMember.handup = teamMember.isFollow() ? Const.HandsUpState.ACCEPT.value : Const.HandsUpState.WAITING.value;
/* 135 */         if (teamMember.isBusy()) {
/* 136 */           teamMember.handup = Const.HandsUpState.REFUSE.value; continue;
/*     */         } 
/* 138 */         if (teamMember.isLeader || !teamMember.follow) {
/* 139 */           MessageUtil.sendMessage(teamMember.id, "area.fightLevelPush.onConfirmEnterFubenPush", (GeneratedMessage)enterFuben);
/*     */         }
/*     */       } 
/*     */     } else {
/*     */       
/* 144 */       for (TeamData.TeamMemberData teamMember : teamMembers.values()) {
/* 145 */         teamMember.handup = teamMember.isLeader ? Const.HandsUpState.ACCEPT.value : Const.HandsUpState.WAITING.value;
/* 146 */         if (teamMember.isBusy()) {
/* 147 */           teamMember.handup = Const.HandsUpState.REFUSE.value; continue;
/*     */         } 
/* 149 */         MessageUtil.sendMessage(teamMember.id, "area.fightLevelPush.onConfirmEnterFubenPush", (GeneratedMessage)enterFuben);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 154 */     if (prop.type == Const.SCENE_TYPE.LOOP.getValue()) {
/* 155 */       for (TeamData.TeamMemberData teamMember : teamMembers.values()) {
/* 156 */         if (teamMember.isFollow()) {
/* 157 */           FightLevelHandler.OnMemberEnterFubenStateChangePush msgData = FightLevelHandler.OnMemberEnterFubenStateChangePush.newBuilder().setS2CPlayerId(teamMember.id).setS2CIsReady(1).build();
/* 158 */           for (TeamData.TeamMemberData member : team.teamMembers.values()) {
/* 159 */             if (member.handup != Const.HandsUpState.REFUSE.value) {
/* 160 */               MessageUtil.sendMessage(member.id, "area.fightLevelPush.onMemberEnterFubenStateChangePush", (GeneratedMessage)msgData);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } else {
/* 166 */       for (TeamData.TeamMemberData teamMember : teamMembers.values()) {
/* 167 */         if (teamMember.handup == Const.HandsUpState.REFUSE.value) {
/* 168 */           FightLevelHandler.OnMemberEnterFubenStateChangePush msgData = FightLevelHandler.OnMemberEnterFubenStateChangePush.newBuilder().setS2CPlayerId(teamMember.id).setS2CIsReady(0).build();
/* 169 */           for (TeamData.TeamMemberData member : team.teamMembers.values()) {
/* 170 */             if (member.handup != Const.HandsUpState.REFUSE.value) {
/* 171 */               MessageUtil.sendMessage(member.id, "area.fightLevelPush.onMemberEnterFubenStateChangePush", (GeneratedMessage)msgData);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 177 */     return data;
/*     */   }
/*     */   
/*     */   public String canEnterDungeon(Map<String, TeamData.TeamMemberData> teamMembers, MapBase prop) {
/* 181 */     StringBuilder data = null;
/* 182 */     for (TeamData.TeamMemberData teamMember : teamMembers.values()) {
/* 183 */       if (!teamMember.isOnline()) {
/* 184 */         if (data == null) {
/* 185 */           data = new StringBuilder();
/*     */         }
/* 187 */         PlayerPO playerPO = PlayerUtil.getPlayerBaseData(teamMember.id);
/* 188 */         if (playerPO != null) {
/* 189 */           data.append(playerPO.name).append("、");
/*     */         }
/*     */       } 
/* 192 */       WNPlayer player = teamMember.getPlayer();
/* 193 */       if (player != null && player.fightLevelManager.canEnterDungeon(player, prop, false) != null) {
/* 194 */         if (data == null) {
/* 195 */           data = new StringBuilder();
/*     */         }
/* 197 */         data.append(player.getName()).append("、");
/*     */       } 
/*     */     } 
/* 200 */     return (data == null) ? null : data.substring(0, data.length() - 1);
/*     */   }
/*     */   
/*     */   private void triggerMonster(int serverId, int propId, int areaId, int send, int monsterId) {
/* 204 */     List<Area> ret = AreaManager.getInstance().getAreaMap().getAreas(areaId, serverId);
/*     */     
/* 206 */     if (ret.size() > 0) {
/* 207 */       int index = RandomUtil.getInt(0, ret.size() - 1);
/* 208 */       Area serverInfo = ret.get(index);
/*     */       
/* 210 */       List<Integer> monsterIds = new ArrayList<>();
/* 211 */       monsterIds.add(Integer.valueOf(propId));
/* 212 */       Area area = AreaUtil.getArea(serverInfo.instanceId);
/* 213 */       if (area != null) {
/* 214 */         area.createMonster(monsterIds, false);
/*     */       } else {
/* 216 */         Out.warn(new Object[] { "triggerMonster:", Integer.valueOf(propId), ",", Integer.valueOf(areaId), ",", Integer.valueOf(monsterId), " area is not exist!" });
/*     */       } 
/*     */     } else {
/* 219 */       Out.warn(new Object[] { "triggerMonster:", Integer.valueOf(propId), ",", Integer.valueOf(areaId), ",", Integer.valueOf(monsterId), " area size error!" });
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\fightLevel\DungeonService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */