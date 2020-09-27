/*     */ package com.wanniu.game.team;
/*     */ 
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.protocol.PomeloPush;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.tcp.protocol.Message;
/*     */ import com.wanniu.core.util.RandomUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.common.msg.MessagePush;
/*     */ import com.wanniu.game.common.msg.MessageUtil;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.TeamTargetCO;
/*     */ import com.wanniu.game.guild.GuildUtil;
/*     */ import com.wanniu.game.message.MessageData;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.PlayerPO;
/*     */ import com.wanniu.game.task.po.TaskPO;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.ScheduledFuture;
/*     */ import pomelo.area.TeamHandler;
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
/*     */ public class TeamData
/*     */ {
/*     */   public String id;
/*     */   public int logicServerId;
/*     */   public Map<String, TeamMemberData> teamMembers;
/*     */   public String leaderId;
/*     */   public int sceneType;
/*     */   public int targetId;
/*     */   public int difficulty;
/*     */   public int curTargetId;
/*     */   public int curDifficulty;
/*  53 */   public int minLevel = 0;
/*  54 */   public int maxLevel = 0;
/*     */   
/*     */   public boolean isAutoTeam;
/*     */   
/*     */   public boolean isAutoStart;
/*     */   
/*     */   public boolean isRobotJoin;
/*     */   
/*     */   public boolean isRobotLeader;
/*     */   
/*     */   public boolean local = true;
/*     */   public boolean confirm = true;
/*     */   public ScheduledFuture<?> lockfuture;
/*  67 */   public Map<String, Long> invites = new ConcurrentHashMap<>();
/*  68 */   public Map<String, Long> applies = new ConcurrentHashMap<>();
/*     */ 
/*     */   
/*     */   public Map<Integer, TaskPO> loopTasks;
/*     */   
/*     */   public Map<Integer, Integer> finishedLoopTasks;
/*     */   
/*     */   private boolean hasLoopTask;
/*     */   
/*     */   private long rebotCanLeaveTime;
/*     */   
/*     */   public long robotFreeTime;
/*     */   
/*     */   public long robotJoinTime;
/*     */ 
/*     */   
/*     */   public void onFirstAcceptLoopTask() {
/*  85 */     this.hasLoopTask = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onAllOverLoopTask() {
/*  92 */     this.hasLoopTask = false;
/*  93 */     this.rebotCanLeaveTime = System.currentTimeMillis() + 300000L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canRobotLeave() {
/* 102 */     if (isInLoopTask()) {
/* 103 */       return false;
/*     */     }
/* 105 */     return (System.currentTimeMillis() >= this.rebotCanLeaveTime);
/*     */   }
/*     */   
/*     */   public boolean isInLoopTask() {
/* 109 */     return this.hasLoopTask;
/*     */   }
/*     */   
/*     */   public int memberCount() {
/* 113 */     return this.teamMembers.size();
/*     */   }
/*     */   
/*     */   public void setAutoTeam(boolean auto) {
/* 117 */     this.isAutoTeam = auto;
/* 118 */     if (auto) {
/* 119 */       setRobotTime();
/*     */     }
/*     */   }
/*     */   
/*     */   public void addApply(String playerId, long validate) {
/* 124 */     this.applies.put(playerId, Long.valueOf(validate));
/* 125 */     if (this.applies.size() == 1) {
/* 126 */       onTeamChange();
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeApply(String playerId) {
/* 131 */     if (this.applies.containsKey(playerId)) {
/* 132 */       this.applies.remove(playerId);
/* 133 */       if (this.applies.isEmpty()) {
/* 134 */         onTeamChange();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setRobotTime() {
/* 140 */     if (GWorld.APP_TIME > this.robotFreeTime && GWorld.APP_TIME < this.robotFreeTime + 300000L) {
/* 141 */       this.robotJoinTime = GWorld.APP_TIME + Utils.getSecMills(60, 300);
/*     */     } else {
/* 143 */       this.robotJoinTime = GWorld.APP_TIME + Utils.getSecMills(6, 10);
/*     */     } 
/* 145 */     setFreeRobotTime();
/*     */   }
/*     */   
/*     */   public void setFreeRobotTime() {
/* 149 */     if (this.isRobotJoin) {
/* 150 */       this.robotFreeTime = Math.max(GWorld.APP_TIME, this.robotJoinTime) + Utils.getSecMills(60, 200);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isAllOnline() {
/* 155 */     for (TeamMemberData teamMember : this.teamMembers.values()) {
/* 156 */       if (!teamMember.isOnline()) {
/* 157 */         return false;
/*     */       }
/*     */     } 
/* 160 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isAllRobotOnline() {
/* 164 */     for (TeamMemberData teamMember : this.teamMembers.values()) {
/* 165 */       if (!teamMember.robot && teamMember.isOnline()) {
/* 166 */         return false;
/*     */       }
/*     */     } 
/* 169 */     return true;
/*     */   }
/*     */   
/*     */   public int followCount() {
/* 173 */     int count = 0;
/* 174 */     for (TeamMemberData member : this.teamMembers.values()) {
/* 175 */       if (member.isFollow()) {
/* 176 */         count++;
/*     */       }
/*     */     } 
/* 179 */     return count;
/*     */   }
/*     */   
/*     */   public boolean isFull() {
/* 183 */     return (memberCount() >= GlobalConfig.NormalTeamMaxNum);
/*     */   }
/*     */   
/*     */   public TeamHandler.Team.Builder createTeamProto() {
/* 187 */     TeamMemberData leader = getLeader();
/* 188 */     if (leader == null) {
/* 189 */       Out.warn(new Object[] { "组队队长异常，自动转让队长..." });
/* 190 */       if (memberCount() > 0) {
/* 191 */         changeLeader();
/* 192 */         leader = getLeader();
/*     */       } else {
/* 194 */         TeamService.destroyTeam(this);
/* 195 */         return null;
/*     */       } 
/*     */     } 
/* 198 */     if (leader == null || !leader.isOnline()) {
/* 199 */       return null;
/*     */     }
/* 201 */     TeamHandler.Team.Builder team = TeamHandler.Team.newBuilder();
/* 202 */     team.setId(this.id);
/* 203 */     team.setTargetId(this.targetId);
/* 204 */     team.setLeaderId(this.leaderId);
/* 205 */     team.setMinLevel(this.minLevel);
/* 206 */     team.setMaxLevel(this.maxLevel);
/* 207 */     for (TeamMemberData teamMember : this.teamMembers.values()) {
/* 208 */       TeamHandler.TeamMemberBasic.Builder basic = TeamHandler.TeamMemberBasic.newBuilder();
/* 209 */       PlayerPO member = teamMember.getPlayerData();
/* 210 */       basic.setId(teamMember.id);
/* 211 */       basic.setPro(member.pro);
/* 212 */       basic.setName(member.name);
/* 213 */       basic.setLevel(member.level);
/* 214 */       basic.setUpLevel(0);
/* 215 */       basic.setGuildName(GuildUtil.getGuildName(teamMember.id));
/* 216 */       team.addTeamMembers(basic);
/*     */     } 
/* 218 */     return team;
/*     */   }
/*     */   
/*     */   public int getCurTargetId() {
/* 222 */     return (this.curTargetId != 0) ? this.curTargetId : this.targetId;
/*     */   }
/*     */   
/*     */   public int getCurDifficulty() {
/* 226 */     return (this.curDifficulty != 0) ? this.curDifficulty : this.difficulty;
/*     */   }
/*     */   
/*     */   public int getTargetMap() {
/* 230 */     int targetId = getCurTargetId();
/* 231 */     int difficulty = getCurDifficulty();
/* 232 */     if (targetId == 0)
/* 233 */       return 0; 
/* 234 */     return getTargetMap(targetId, difficulty);
/*     */   }
/*     */   
/*     */   public static int getTargetMap(int targetId, int difficulty) {
/* 238 */     int mapId = 0;
/* 239 */     TeamTargetCO teamTargetProp = (TeamTargetCO)GameData.TeamTargets.get(Integer.valueOf(targetId));
/* 240 */     if (teamTargetProp != null && 
/* 241 */       difficulty == 1) {
/* 242 */       mapId = teamTargetProp.normalMapID;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 251 */     if (mapId == 0 && targetId == 1020) {
/* 252 */       mapId = GlobalConfig.DemonTowerMapIds[RandomUtil.getIndex(GlobalConfig.DemonTowerMapIds.length)];
/*     */     }
/* 254 */     return mapId;
/*     */   }
/*     */   
/*     */   public void invite(WNPlayer fromPlayer, String toPlayerId) {
/* 258 */     Map<String, String> strMsg = new HashMap<>(2);
/* 259 */     strMsg.put("playerName", PlayerUtil.getFullColorName(fromPlayer));
/* 260 */     TeamTargetCO target = (TeamTargetCO)GameData.TeamTargets.get(Integer.valueOf(this.targetId));
/* 261 */     strMsg.put("target", (target != null) ? LangService.format("TEAM_TARGET_DESC", new Object[] { target.targetName }) : "");
/* 262 */     MessageData.MessageData_Team_InviteId msgData = new MessageData.MessageData_Team_InviteId();
/* 263 */     msgData.inviteId = toPlayerId;
/* 264 */     MessageData message = MessageUtil.createMessage(Const.MESSAGE_TYPE.team_invite.getValue(), fromPlayer.getId(), (MessageData.MessageData_Data)msgData, strMsg);
/* 265 */     message.id = this.id;
/* 266 */     MessageUtil.sendMessageToPlayer(message, toPlayerId);
/* 267 */     this.invites.put(toPlayerId, Long.valueOf(message.validTime));
/*     */   }
/*     */   
/*     */   public TeamMemberData getLeader() {
/* 271 */     return this.teamMembers.get(this.leaderId);
/*     */   }
/*     */   
/*     */   public TeamMemberData getMember(String memberId) {
/* 275 */     return this.teamMembers.get(memberId);
/*     */   }
/*     */   
/*     */   public boolean islock() {
/* 279 */     return (this.lockfuture != null);
/*     */   }
/*     */   
/*     */   public void lock(int time) {
/* 283 */     if (this.lockfuture != null) {
/* 284 */       this.lockfuture.cancel(true);
/* 285 */       Out.warn(new Object[] { "team lock more..." });
/*     */     } 
/* 287 */     this.lockfuture = JobFactory.addDelayJob(() -> { this.lockfuture = null; Out.debug(new Object[] { "lock timeout..." }, ); }(time * 1000));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unlock() {
/* 294 */     if (this.lockfuture != null) {
/* 295 */       this.lockfuture.cancel(true);
/* 296 */       this.lockfuture = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public WNPlayer getPlayer(String rid) {
/* 301 */     return PlayerUtil.getOnlinePlayer(rid);
/*     */   }
/*     */   
/*     */   public boolean isOpenFollow() {
/* 305 */     return isOpenJoin();
/*     */   }
/*     */   
/*     */   public boolean isOpenJoin() {
/* 309 */     boolean lock = islock();
/* 310 */     if (lock) {
/* 311 */       return false;
/*     */     }
/* 313 */     WNPlayer player = getPlayer(this.leaderId);
/* 314 */     Area area = (player == null) ? null : player.getArea();
/* 315 */     return (area != null && area.isOpenJoinTeam());
/*     */   }
/*     */   
/*     */   public void changeLeader() {
/* 319 */     synchronized (TeamService.lock) {
/* 320 */       TeamMemberData newLeader = null;
/* 321 */       Map<String, TeamMemberData> teamMembers = this.teamMembers;
/* 322 */       for (TeamMemberData member : teamMembers.values()) {
/* 323 */         if (newLeader != null && member.isOnline() && ((member.joinTime < newLeader.joinTime && !member.robot) || !newLeader.isOnline() || (newLeader.robot && !member.robot))) {
/* 324 */           newLeader = member; continue;
/* 325 */         }  if (newLeader == null) {
/* 326 */           newLeader = member;
/*     */         }
/*     */       } 
/* 329 */       if (newLeader != null) {
/* 330 */         TeamMemberData oldLeader = getLeader();
/* 331 */         this.leaderId = newLeader.id;
/* 332 */         newLeader.isLeader = true;
/* 333 */         this.isRobotLeader = newLeader.robot;
/* 334 */         if (oldLeader != null && oldLeader != newLeader) {
/* 335 */           oldLeader.isLeader = false;
/*     */         }
/*     */       } else {
/* 338 */         Out.warn(new Object[] { "队长无法转让, 队员：", Integer.valueOf(teamMembers.size()) });
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void receive(String route, GeneratedMessage msg) {
/* 344 */     receive((PomeloPush)new MessagePush(route, msg));
/*     */   }
/*     */   
/*     */   public void receive(PomeloPush push) {
/* 348 */     for (String rid : this.teamMembers.keySet()) {
/* 349 */       WNPlayer player = getPlayer(rid);
/* 350 */       if (player != null) {
/* 351 */         player.receive((Message)push);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void onTeamChange() {
/* 357 */     TeamHandler.OnTeamTargetPush targetPush = TeamHandler.OnTeamTargetPush.newBuilder().setS2CTeamTarget(TeamUtil.generateTeamTargetData(this)).setHaveApply(this.applies.size()).setS2CIsAcceptAutoTeam(this.isAutoTeam ? 1 : 0).build();
/* 358 */     for (String rid : this.teamMembers.keySet()) {
/* 359 */       WNPlayer member = PlayerUtil.getOnlinePlayer(rid);
/* 360 */       if (member != null) {
/* 361 */         member.receive("area.teamPush.onTeamTargetPush", (GeneratedMessage)targetPush);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static class TeamMemberData
/*     */   {
/*     */     public String teamId;
/*     */     
/*     */     public String id;
/*     */     
/*     */     public long joinTime;
/*     */     public boolean robot;
/*     */     public boolean isLeader;
/*     */     public boolean follow;
/*     */     public int handup;
/*     */     
/*     */     public TeamMemberData(String teamId, String playerId) {
/* 380 */       this.teamId = teamId;
/* 381 */       this.id = playerId;
/* 382 */       this.joinTime = GWorld.APP_TIME;
/* 383 */       this.follow = true;
/*     */     }
/*     */     
/*     */     public boolean isOnline() {
/* 387 */       return PlayerUtil.isOnline(this.id);
/*     */     }
/*     */     
/*     */     public WNPlayer getPlayer() {
/* 391 */       return PlayerUtil.getOnlinePlayer(this.id);
/*     */     }
/*     */     
/*     */     public PlayerPO getPlayerData() {
/* 395 */       return PlayerUtil.getPlayerBaseData(this.id);
/*     */     }
/*     */     
/*     */     public TeamData getTeam() {
/* 399 */       return TeamService.getTeam(this.teamId);
/*     */     }
/*     */     
/*     */     public boolean isFollow() {
/* 403 */       return (this.follow || this.isLeader);
/*     */     }
/*     */     
/*     */     public int getFollow() {
/* 407 */       return (this.follow && !this.isLeader) ? 1 : 0;
/*     */     }
/*     */     
/*     */     public int getLeader() {
/* 411 */       return this.isLeader ? 1 : 0;
/*     */     }
/*     */     
/*     */     public boolean isBusy() {
/* 415 */       if (!isOnline()) {
/* 416 */         return true;
/*     */       }
/* 418 */       WNPlayer player = getPlayer();
/* 419 */       if (!isFollow()) {
/* 420 */         Area area = player.getArea();
/* 421 */         if (area == null || !area.isNormal()) {
/* 422 */           return true;
/*     */         }
/*     */       } 
/* 425 */       return false;
/*     */     }
/*     */     
/*     */     public void receive(String route, GeneratedMessage msg) {
/* 429 */       receive((PomeloPush)new MessagePush(route, msg));
/*     */     }
/*     */     
/*     */     public void receive(PomeloPush push) {
/* 433 */       WNPlayer player = getPlayer();
/* 434 */       if (player != null)
/* 435 */         player.receive((Message)push); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\team\TeamData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */