/*     */ package com.wanniu.game.team;
/*     */ 
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.common.msg.MessageUtil;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.ext.TeamTargetExt;
/*     */ import com.wanniu.game.five2Five.Five2FiveService;
/*     */ import com.wanniu.game.message.MessageData;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.player.WNRobot;
/*     */ import com.wanniu.game.player.po.AllBlobPO;
/*     */ import com.wanniu.game.task.TaskData;
/*     */ import com.wanniu.game.task.po.TaskPO;
/*     */ import com.wanniu.game.util.RobotUtil;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
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
/*     */ public class BaseTeamService
/*     */ {
/*  36 */   protected static final MatchMap AutoMathes = new MatchMap();
/*     */   
/*  38 */   protected static final Map<String, TeamData> TeamMap = new ConcurrentHashMap<>();
/*     */   
/*  40 */   protected static final Map<String, TeamData.TeamMemberData> TeamMemberMap = new ConcurrentHashMap<>();
/*     */   
/*     */   static class MatchMap
/*     */     extends ConcurrentHashMap<String, MatchData> {
/*     */     private static final long serialVersionUID = 1L;
/*  45 */     private Map<String, BaseTeamService.MatchData> targets = new ConcurrentHashMap<>();
/*     */ 
/*     */     
/*     */     public BaseTeamService.MatchData put(String key, BaseTeamService.MatchData value) {
/*  49 */       this.targets.put(value.getKey(), value);
/*  50 */       return super.put(key, value);
/*     */     }
/*     */ 
/*     */     
/*     */     public BaseTeamService.MatchData remove(Object key) {
/*  55 */       BaseTeamService.MatchData match = super.remove(key);
/*  56 */       if (match != null) {
/*  57 */         this.targets.remove(match.getKey());
/*     */       }
/*  59 */       return match;
/*     */     }
/*     */     
/*     */     public BaseTeamService.MatchData getTargetMatch(int logicServerId, int targetId, int difficulty) {
/*  63 */       return this.targets.get(BaseTeamService.getTargetKey(logicServerId, targetId, difficulty));
/*     */     }
/*     */     
/*     */     public void clear() {
/*  67 */       super.clear();
/*  68 */       this.targets.clear();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class MatchData
/*     */   {
/*     */     WNPlayer player;
/*     */     
/*     */     int targetId;
/*     */     int difficulty;
/*     */     
/*     */     MatchData(WNPlayer player, int targetId, int difficulty) {
/*  81 */       this.player = player;
/*  82 */       this.targetId = targetId;
/*  83 */       this.difficulty = difficulty;
/*     */     }
/*     */     
/*     */     String getKey() {
/*  87 */       return BaseTeamService.getTargetKey(GWorld.__SERVER_ID, this.targetId, this.difficulty);
/*     */     }
/*     */   }
/*     */   
/*     */   private static String getTargetKey(int logicServerId, int targetId, int difficulty) {
/*  92 */     return logicServerId + ":" + targetId + ":" + difficulty;
/*     */   }
/*     */   
/*     */   static {
/*  96 */     long minute = 300000L;
/*  97 */     JobFactory.addScheduleJob(new Runnable()
/*     */         {
/*     */           public void run() {
/* 100 */             BaseTeamService.clearExpiredTeam();
/*     */           }
/*     */         },  minute, minute);
/* 103 */     long second = 3000L;
/* 104 */     JobFactory.addScheduleJob(new Runnable()
/*     */         {
/*     */           public void run() {
/* 107 */             if (BaseTeamService.AutoMathes.isEmpty())
/*     */               return; 
/* 109 */             Out.debug(new Object[] { "auto match team..." }, );
/* 110 */             for (Map.Entry<String, BaseTeamService.MatchData> entry : BaseTeamService.AutoMathes.entrySet()) {
/* 111 */               BaseTeamService.matchTeam(entry.getValue());
/*     */             }
/*     */           }
/*     */         },  second, second);
/*     */     
/* 116 */     second = 1000L;
/* 117 */     JobFactory.addScheduleJob(new Runnable()
/*     */         {
/*     */           public void run() {
/* 120 */             GWorld.APP_TIME = System.currentTimeMillis();
/* 121 */             for (TeamData team : BaseTeamService.TeamMap.values()) {
/* 122 */               if (!team.isOpenJoin())
/*     */                 continue; 
/* 124 */               if (team.isRobotJoin) {
/* 125 */                 if (team.isRobotLeader) {
/* 126 */                   team.changeLeader();
/*     */                 }
/* 128 */                 if (GWorld.APP_TIME > team.robotFreeTime && team.canRobotLeave()) {
/*     */                   try {
/* 130 */                     for (TeamData.TeamMemberData member : team.teamMembers.values()) {
/* 131 */                       if (!member.robot)
/*     */                         continue; 
/* 133 */                       WNRobot robot = (WNRobot)member.getPlayer();
/* 134 */                       if (robot != null && robot.quitTeamFuture == null) {
/* 135 */                         robot.quitTeamFuture = JobFactory.addDelayJob(() -> {
/*     */                               robot.quitTeamFuture = null;
/*     */                               TeamService.leaveTeam((WNPlayer)robot);
/* 138 */                             }Utils.getSecMills(1, 10));
/*     */                       }
/*     */                     } 
/* 141 */                   } catch (Exception e) {
/* 142 */                     Out.error(new Object[] { e });
/*     */                   } 
/* 144 */                   team.setFreeRobotTime();
/*     */                 } 
/*     */               } 
/*     */               
/* 148 */               TeamTargetExt teamTargetProp = (TeamTargetExt)GameData.TeamTargets.get(Integer.valueOf(team.targetId));
/* 149 */               if (teamTargetProp == null) {
/*     */                 continue;
/*     */               }
/*     */               
/* 153 */               if (teamTargetProp.isRobot == 0) {
/*     */                 continue;
/*     */               }
/*     */               
/* 157 */               if (team.isAutoTeam && GWorld.APP_TIME > team.robotJoinTime && team.memberCount() < 3) {
/*     */                 try {
/* 159 */                   WNPlayer leader = team.getPlayer(team.leaderId);
/* 160 */                   if (GWorld.ROBOTS && leader != null) {
/* 161 */                     Area area = leader.getArea();
/* 162 */                     if (area.isFull())
/*     */                       continue; 
/* 164 */                     AllBlobPO allBlob = RobotUtil.matchRobot(leader, Math.max(area.prop.reqLevel, team.minLevel));
/* 165 */                     if (allBlob == null) {
/*     */                       continue;
/*     */                     }
/*     */                     
/* 169 */                     allBlob.robotAttr = teamTargetProp.randomAttrs();
/* 170 */                     WNRobot robot = new WNRobot(allBlob);
/*     */                     try {
/* 172 */                       RobotUtil.newRobot(robot);
/* 173 */                       leader.getArea().addPlayer((WNPlayer)robot);
/*     */                       
/* 175 */                       String result = TeamService.joinTeam(team.id, (WNPlayer)robot);
/* 176 */                       if (result != null) {
/* 177 */                         Out.warn(new Object[] { "机器人入队，不正常。", result });
/*     */                         
/* 179 */                         robot.free();
/*     */                       } 
/* 181 */                     } catch (Exception e) {
/* 182 */                       Out.error(new Object[] { "创建机器人，进入场景失败", e });
/* 183 */                       robot.free();
/*     */                     } 
/*     */                   } 
/* 186 */                 } catch (Exception e) {
/* 187 */                   Out.error(new Object[] { e });
/*     */                 } 
/*     */               }
/*     */             } 
/*     */           }
/*     */         }second, second);
/*     */ 
/*     */     
/* 195 */     clearExpiredMessage();
/*     */   }
/*     */   
/* 198 */   protected static Object lock = new Object();
/*     */   
/*     */   protected static boolean matchTeam(MatchData match) {
/* 201 */     WNPlayer player = match.player;
/* 202 */     for (TeamData team : TeamMap.values()) {
/* 203 */       if (team.isAutoTeam && team.local && team.targetId == match.targetId && team.difficulty == match.difficulty && team.memberCount() < GlobalConfig.NormalTeamMaxNum && 
/* 204 */         team.minLevel <= player.getLevel() && (team.maxLevel == 0 || player.getLevel() <= team.maxLevel)) {
/* 205 */         TeamService.joinTeam(team.id, player);
/* 206 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/* 210 */     return false;
/*     */   }
/*     */   
/*     */   public static void reload() {
/* 214 */     AutoMathes.clear();
/* 215 */     TeamMap.clear();
/* 216 */     TeamMemberMap.clear();
/*     */   }
/*     */   
/*     */   public static void clearExpiredMessage() {
/* 220 */     long now = GWorld.APP_TIME;
/* 221 */     long minValidtime = now + 60000L;
/* 222 */     for (TeamData team : TeamMap.values()) {
/* 223 */       for (Map.Entry<String, Long> entry : team.invites.entrySet()) {
/* 224 */         if (now > ((Long)entry.getValue()).longValue()) {
/* 225 */           team.invites.remove(entry.getKey());
/* 226 */           Out.debug(new Object[] { "remove team invite key : ", entry.getKey() }); continue;
/*     */         } 
/* 228 */         minValidtime = Math.min(minValidtime, ((Long)entry.getValue()).longValue());
/*     */       } 
/*     */       
/* 231 */       for (Map.Entry<String, Long> entry : team.applies.entrySet()) {
/* 232 */         if (now > ((Long)entry.getValue()).longValue()) {
/* 233 */           team.removeApply(entry.getKey());
/* 234 */           Out.debug(new Object[] { "remove team applies key : ", entry.getKey() }); continue;
/*     */         } 
/* 236 */         minValidtime = Math.min(minValidtime, ((Long)entry.getValue()).longValue());
/*     */       } 
/*     */     } 
/*     */     
/* 240 */     minValidtime = Math.min(minValidtime - now, 60000L);
/* 241 */     JobFactory.addDelayJob(() -> clearExpiredMessage(), minValidtime);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void clearExpiredTeam() {
/* 250 */     long now = GWorld.APP_TIME;
/* 251 */     long validTime = Math.max(1800000, GlobalConfig.TeamOfflineMaxTime * 3600000);
/* 252 */     for (TeamData team : TeamMap.values()) {
/* 253 */       boolean flag = true;
/* 254 */       for (TeamData.TeamMemberData teamMember : team.teamMembers.values()) {
/* 255 */         if (teamMember.isOnline() || now - teamMember.joinTime < validTime) {
/* 256 */           flag = false;
/*     */           break;
/*     */         } 
/*     */       } 
/* 260 */       if (flag || team.isAllRobotOnline()) {
/* 261 */         Out.warn(new Object[] { "clearPastTeam : ", team.id });
/* 262 */         destroyTeam(team);
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
/*     */   public static boolean isInTeam(String playerId) {
/* 274 */     return TeamMemberMap.containsKey(playerId);
/*     */   }
/*     */   
/*     */   public static boolean isInTeam(String teamId, String playerId) {
/* 278 */     TeamData.TeamMemberData tmData = TeamMemberMap.get(playerId);
/* 279 */     return (tmData != null && tmData.teamId.equals(teamId));
/*     */   }
/*     */   
/*     */   public static TeamData.TeamMemberData getTeamMember(String playerId) {
/* 283 */     return TeamMemberMap.get(playerId);
/*     */   }
/*     */   
/*     */   public static void addTeamMember(TeamData.TeamMemberData teamMember) {
/* 287 */     AutoMathes.remove(teamMember.id);
/* 288 */     TeamMemberMap.put(teamMember.id, teamMember);
/* 289 */     WNPlayer player = teamMember.getPlayer();
/*     */ 
/*     */     
/* 292 */     TeamData team = teamMember.getTeam();
/*     */     
/* 294 */     if (!team.leaderId.equals(teamMember.id)) {
/* 295 */       Five2FiveService.getInstance().processTeamChangeOnFive2Five((teamMember.getTeam()).leaderId);
/*     */     }
/* 297 */     if (team.isInLoopTask() && 
/* 298 */       player != null) {
/* 299 */       for (TaskPO task : team.loopTasks.values()) {
/* 300 */         TaskData taskData = new TaskData(task);
/* 301 */         player.taskManager.pushTaskUpdate(taskData, team);
/* 302 */         player.taskManager.questStatusChangeR2B(player, taskData, task.templateId);
/*     */ 
/*     */         
/* 305 */         player.taskManager.dealTaskEvent(Const.TaskType.ACCEPT_DAILY_LOOP, String.valueOf(3), 1);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 310 */     team.setRobotTime();
/*     */ 
/*     */     
/* 313 */     Five2FiveService.getInstance().singleQuitFive2FiveMatch(teamMember.id, false);
/*     */     
/* 315 */     if (!teamMember.robot) {
/* 316 */       for (TeamData teamData : TeamMap.values()) {
/* 317 */         teamData.invites.remove(teamMember.id);
/* 318 */         teamData.removeApply(teamMember.id);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static void removeTeamMember(String playerId) {
/* 324 */     TeamData.TeamMemberData teamMember = TeamMemberMap.remove(playerId);
/* 325 */     if (teamMember != null) {
/* 326 */       TeamData team = teamMember.getTeam();
/* 327 */       WNPlayer player = teamMember.getPlayer();
/* 328 */       if (player != null && player instanceof WNRobot) {
/* 329 */         player.free();
/*     */       }
/* 331 */       if (player != null && team != null) {
/* 332 */         if (team.loopTasks != null) {
/*     */           
/* 334 */           for (TaskPO db : team.loopTasks.values()) {
/* 335 */             TaskData taskData = new TaskData(db);
/* 336 */             TaskData task = taskData.clone();
/* 337 */             task.db.state = Const.TaskState.DELETE.getValue();
/* 338 */             player.taskManager.pushTaskUpdate(task);
/*     */           } 
/*     */ 
/*     */           
/* 342 */           if (team.memberCount() < 3 && team.memberCount() > 0 && !team.isAutoTeam) {
/* 343 */             for (TeamData.TeamMemberData member : team.teamMembers.values()) {
/* 344 */               if (member.isLeader) {
/* 345 */                 MessageData.MessageData_Data data = new MessageData.MessageData_Data();
/* 346 */                 MessageData message = MessageUtil.createMessage(Const.MESSAGE_TYPE.loop_task_member_leave.getValue(), member.id, data);
/* 347 */                 message.id = member.id;
/* 348 */                 MessageUtil.sendMessageToPlayer(message, member.id);
/*     */               } 
/*     */             } 
/*     */           }
/*     */         } 
/* 353 */         team.setRobotTime();
/*     */       } 
/* 355 */       TeamUtil.removeAcrossMatch(player);
/*     */       
/* 357 */       if (playerId.equals((teamMember.getTeam()).leaderId)) {
/* 358 */         WNPlayer leader = teamMember.getPlayer();
/* 359 */         if (leader != null) {
/* 360 */           leader.five2FiveManager.cancelFive2FiveMatch(false);
/*     */         }
/*     */       } else {
/*     */         
/* 364 */         Five2FiveService.getInstance().processTeamChangeOnFive2Five((teamMember.getTeam()).leaderId);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static Map<String, TeamData.TeamMemberData> getTeamMembers(String teamId) {
/* 370 */     TeamData team = getTeam(teamId);
/* 371 */     if (team != null) {
/* 372 */       return team.teamMembers;
/*     */     }
/* 374 */     return null;
/*     */   }
/*     */   
/*     */   public static TeamData getTeam(String teamId) {
/* 378 */     return TeamMap.get(teamId);
/*     */   }
/*     */   
/*     */   public static void addTeam(TeamData team) {
/* 382 */     TeamMap.put(team.id, team);
/*     */   }
/*     */   
/*     */   public static void destroyTeam(TeamData team) {
/* 386 */     synchronized (lock) {
/* 387 */       String teamId = team.id;
/* 388 */       Out.debug(new Object[] { "destory team - ", teamId });
/* 389 */       for (String memberId : team.teamMembers.keySet()) {
/* 390 */         removeTeamMember(memberId);
/* 391 */         TeamService.clearTeamData(memberId);
/*     */       } 
/*     */       
/* 394 */       TeamMap.remove(teamId);
/* 395 */       team.teamMembers.clear();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\team\BaseTeamService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */