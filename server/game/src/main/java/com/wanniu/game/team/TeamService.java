/*     */ package com.wanniu.game.team;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.alibaba.fastjson.JSONArray;
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.area.AreaData;
/*     */ import com.wanniu.game.area.AreaUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.guild.GuildUtil;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.player.WNRobot;
/*     */ import com.wanniu.game.poes.PlayerPO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.atomic.AtomicLong;
/*     */ import pomelo.area.TeamHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TeamService
/*     */   extends BaseTeamService
/*     */ {
/*  40 */   private static AtomicLong UUID = new AtomicLong(System.nanoTime());
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String createTeam(WNPlayer leader, List<String> memberIds, int logicServerId) {
/*  46 */     Out.debug(new Object[] { "teamService createTeam" });
/*  47 */     synchronized (lock) {
/*  48 */       boolean isInTeam = leader.getTeamManager().isInTeam();
/*  49 */       if (isInTeam) {
/*  50 */         return LangService.getValue("TEAM_ENTER");
/*     */       }
/*     */       
/*  53 */       if (memberIds != null) {
/*  54 */         for (String playerId : memberIds) {
/*  55 */           boolean isIn = isInTeam(playerId);
/*  56 */           if (isIn) {
/*  57 */             return LangService.getValue("TEAM_ENTER");
/*     */           }
/*     */         } 
/*     */       }
/*  61 */       String teamId = String.valueOf(UUID.incrementAndGet());
/*  62 */       TeamData.TeamMemberData teamLeader = new TeamData.TeamMemberData(teamId, leader.getId());
/*  63 */       teamLeader.isLeader = true;
/*  64 */       TeamData team = new TeamData();
/*  65 */       team.id = teamId;
/*  66 */       team.leaderId = teamLeader.id;
/*  67 */       team.logicServerId = logicServerId;
/*  68 */       team.teamMembers = new ConcurrentHashMap<>();
/*     */       
/*  70 */       team.sceneType = leader.getSceneType();
/*     */ 
/*     */       
/*  73 */       team.difficulty = 1;
/*  74 */       team.isAutoTeam = (GlobalConfig.TeamAutoInvite == 1);
/*     */       
/*  76 */       addTeam(team);
/*     */       
/*  78 */       team.teamMembers.put(teamLeader.id, teamLeader);
/*  79 */       addTeamMember(teamLeader);
/*  80 */       if (memberIds != null) {
/*  81 */         for (String playerId : memberIds) {
/*  82 */           TeamData.TeamMemberData member = new TeamData.TeamMemberData(teamId, playerId);
/*  83 */           team.teamMembers.put(member.id, member);
/*  84 */           addTeamMember(member);
/*     */         } 
/*     */       }
/*  87 */       refreshTeam(team);
/*     */     } 
/*  89 */     return null;
/*     */   }
/*     */   
/*     */   public static void changeTeamArea(WNPlayer player) {
/*  93 */     TeamData team = player.getTeamManager().getTeam();
/*  94 */     if (team != null) {
/*  95 */       if (player.getId().equals(team.leaderId)) {
/*  96 */         team.sceneType = player.getSceneType();
/*     */       }
/*  98 */       player.teamManager.checkLogin();
/*  99 */       Area area = player.getArea();
/* 100 */       if (area.sceneType == Const.SCENE_TYPE.FIGHT_LEVEL.getValue() || area.sceneType == Const.SCENE_TYPE.LOOP.getValue() || area.sceneType == Const.SCENE_TYPE.GUILD_BOSS.getValue()) {
/* 101 */         if (player.getTeamManager().getTeamMember() != null) {
/* 102 */           (player.getTeamManager().getTeamMember()).follow = false;
/*     */         }
/* 104 */         refreshTeam(team);
/* 105 */         area.onPlayerAutoBattle(player, true);
/* 106 */         Out.debug(new Object[] { "自动战斗请求:", player.getName(), " - " + player.getId(), " - ", area.prop.name });
/*     */       } else {
/* 108 */         refreshTeam(team);
/*     */       } 
/* 110 */       if (area.isNormal()) {
/* 111 */         team.setFreeRobotTime();
/*     */       }
/*     */     } else {
/*     */       
/* 115 */       player.teamManager.pushTeamData();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String joinTeam(String teamId, WNPlayer wPlayer) {
/* 123 */     if (wPlayer == null) {
/* 124 */       return LangService.getValue("PLAYER_NOT_ONLINE");
/*     */     }
/* 126 */     TeamData team = getTeam(teamId);
/* 127 */     synchronized (lock) {
/* 128 */       if (team == null) {
/* 129 */         return LangService.getValue("TEAM_BREAK_UP");
/*     */       }
/* 131 */       if (!team.isOpenJoin()) {
/* 132 */         return LangService.getValue("TEAM_LOCKED");
/*     */       }
/* 134 */       String res = TeamUtil.canJoinTeam(wPlayer, team);
/* 135 */       if (res != null) {
/* 136 */         return res;
/*     */       }
/* 138 */       TeamData.TeamMemberData member = wPlayer.getTeamManager().getTeamMember();
/* 139 */       if (member != null) {
/* 140 */         return LangService.getValue("TEAM_ALREADY_IN_TEAM");
/*     */       }
/*     */       
/* 143 */       member = new TeamData.TeamMemberData(teamId, wPlayer.getId());
/* 144 */       WNPlayer leader = team.getPlayer(team.leaderId);
/* 145 */       member.follow = (leader != null && leader.getInstanceId().equals(wPlayer.getInstanceId()));
/* 146 */       member.robot = wPlayer.isRobot();
/* 147 */       team.isRobotJoin |= member.robot;
/*     */       
/* 149 */       team.teamMembers.put(member.id, member);
/* 150 */       addTeamMember(member);
/*     */     } 
/*     */ 
/*     */     
/* 154 */     kickRobotMember(team);
/*     */     
/* 156 */     refreshTeam(team);
/*     */     
/* 158 */     TeamUtil.handleFullOfTeam(team, team.getPlayer(team.leaderId));
/* 159 */     return null;
/*     */   }
/*     */   
/*     */   public static void kickRobotMember(TeamData team) {
/* 163 */     if (team.memberCount() > 3) {
/* 164 */       for (Iterator<Map.Entry<String, TeamData.TeamMemberData>> iterator = team.teamMembers.entrySet().iterator(); iterator.hasNext(); ) { Map.Entry<String, TeamData.TeamMemberData> entry = iterator.next();
/* 165 */         if (((TeamData.TeamMemberData)entry.getValue()).robot) {
/* 166 */           WNRobot robot = GWorld.getRobot(entry.getKey());
/* 167 */           if (robot == null)
/*     */             continue; 
/* 169 */           if (robot.quitTeamFuture != null)
/*     */             continue; 
/* 171 */           robot.quitTeamFuture = JobFactory.addDelayJob(() -> {
/*     */                 robot.quitTeamFuture = null;
/*     */                 if (team.isOpenJoin()) {
/*     */                   leaveTeam((WNPlayer)robot);
/*     */                 }
/* 176 */               }Utils.getSecMills(1, 15));
/*     */           break;
/*     */         }  }
/*     */     
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String leaveTeam(WNPlayer player) {
/* 187 */     String playerId = player.getId();
/* 188 */     TeamData team = player.getTeamManager().getTeam();
/* 189 */     synchronized (lock) {
/* 190 */       TeamData.TeamMemberData teamMember = player.getTeamManager().getTeamMember();
/* 191 */       if (teamMember != null) {
/* 192 */         team.teamMembers.remove(playerId);
/* 193 */         removeTeamMember(playerId);
/* 194 */         if (teamMember.isLeader && team.memberCount() > 0) {
/*     */           
/* 196 */           team.changeLeader();
/* 197 */           team.invites.clear();
/* 198 */           team.applies.clear();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 203 */     if (team != null) {
/* 204 */       if (team.memberCount() == 0) {
/* 205 */         destroyTeam(team);
/* 206 */       } else if (!destoryRobotTeam(team)) {
/* 207 */         refreshTeam(team);
/*     */       } 
/*     */     }
/*     */     
/* 211 */     clearTeamData(playerId);
/*     */     
/* 213 */     return null;
/*     */   }
/*     */   
/*     */   public static boolean destoryRobotTeam(TeamData team) {
/* 217 */     for (TeamData.TeamMemberData member : team.teamMembers.values()) {
/* 218 */       if (!member.robot) {
/* 219 */         return false;
/*     */       }
/*     */     } 
/* 222 */     destroyTeam(team);
/* 223 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean kickOutTeam(TeamData team, TeamData.TeamMemberData teamMember) {
/* 230 */     if (teamMember != null && team != null) {
/* 231 */       String playerId = teamMember.id;
/* 232 */       WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
/* 233 */       synchronized (lock) {
/* 234 */         team.teamMembers.remove(playerId);
/* 235 */         if (player != null && player.getTeamManager().getTeamMember() != teamMember) {
/* 236 */           return true;
/*     */         }
/* 238 */         removeTeamMember(playerId);
/*     */       } 
/* 240 */       clearTeamData(playerId);
/* 241 */       refreshTeam(team);
/* 242 */       return true;
/*     */     } 
/* 244 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TeamHandler.Team.Builder generateTeamData(TeamData team) {
/* 251 */     TeamHandler.Team.Builder data = TeamHandler.Team.newBuilder();
/* 252 */     data.setId(team.id);
/* 253 */     data.setLeaderId(team.leaderId);
/*     */     
/* 255 */     List<TeamHandler.TeamMemberBasic> teamMemberBasics = new ArrayList<>();
/* 256 */     Map<String, TeamData.TeamMemberData> teamMembers = team.teamMembers;
/* 257 */     for (TeamData.TeamMemberData teamMember : teamMembers.values()) {
/* 258 */       TeamHandler.TeamMemberBasic.Builder memberBasic = TeamHandler.TeamMemberBasic.newBuilder();
/* 259 */       memberBasic.setId(teamMember.id);
/* 260 */       PlayerPO member = teamMember.getPlayerData();
/* 261 */       memberBasic.setPro(member.pro);
/* 262 */       memberBasic.setName(member.name);
/* 263 */       memberBasic.setLevel(member.level);
/* 264 */       memberBasic.setUpLevel(0);
/* 265 */       memberBasic.setGuildName(GuildUtil.getGuildName(teamMember.id));
/* 266 */       teamMemberBasics.add(memberBasic.build());
/*     */     } 
/* 268 */     data.addAllTeamMembers(teamMemberBasics);
/* 269 */     data.setMinLevel(team.minLevel);
/* 270 */     data.setMaxLevel(team.maxLevel);
/* 271 */     return data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<TeamData> queryTeamByTarget(TeamFilter filter) {
/* 278 */     List<TeamData> result = new ArrayList<>();
/* 279 */     Collection<TeamData> teams = TeamMap.values();
/* 280 */     for (TeamData team : teams) {
/* 281 */       if (filter.filter(team)) {
/* 282 */         result.add(team);
/*     */       }
/*     */     } 
/*     */     
/* 286 */     int maxViewCount = GlobalConfig.TeamViewMAX;
/* 287 */     if (result.size() > maxViewCount) {
/* 288 */       Collections.shuffle(result);
/* 289 */       return result.subList(0, maxViewCount);
/*     */     } 
/*     */     
/* 292 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String dissolveTeam(String playerId) {
/* 299 */     TeamData.TeamMemberData teamMember = getTeamMember(playerId);
/*     */     
/* 301 */     if (teamMember != null && teamMember.isLeader) {
/* 302 */       destroyTeam(teamMember.getTeam());
/* 303 */       return LangService.getValue("TEAM_NO_AUTHORITY");
/*     */     } 
/* 305 */     return null;
/*     */   }
/*     */   
/*     */   public static void refreshTeam(TeamData team) {
/* 309 */     refreshTeam(team, true);
/*     */   }
/*     */   
/*     */   public static void refreshTeam(TeamData team, boolean notify) {
/* 313 */     if (team != null) {
/* 314 */       Set<String> teamMemberIds = team.teamMembers.keySet();
/* 315 */       for (String playerId : teamMemberIds) {
/* 316 */         updateTeamData(team, playerId, notify);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void clearTeamData(String playerId) {
/* 322 */     updateTeamData((TeamData)null, playerId, true);
/*     */   }
/*     */   
/*     */   public static void updateTeamData(TeamData team, String playerId, boolean notify) {
/* 326 */     Out.debug(new Object[] { "teamService sendTeam2TeamMembers:", playerId });
/* 327 */     WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
/* 328 */     if (player != null) {
/* 329 */       Map<String, TeamData.TeamMemberData> teamMembers = null;
/* 330 */       if (team == null) {
/* 331 */         player.pkRuleManager.onExitTeam();
/*     */       } else {
/* 333 */         teamMembers = team.teamMembers;
/*     */       } 
/* 335 */       player.getTeamManager().setTeamData(team);
/* 336 */       List<String> teamMemberIds = new ArrayList<>();
/* 337 */       JSONArray members = new JSONArray();
/* 338 */       if (teamMembers != null) {
/* 339 */         team.isRobotJoin = false;
/* 340 */         for (TeamData.TeamMemberData teamMember : teamMembers.values()) {
/* 341 */           team.isRobotJoin |= teamMember.robot;
/* 342 */           if (!teamMember.id.equals(player.getId())) {
/* 343 */             teamMemberIds.add(teamMember.id);
/*     */           }
/* 345 */           members.add(Utils.toJSON(new Object[] { "followLeader", Integer.valueOf(teamMember.getFollow()), "uuid", teamMember.id }));
/*     */         } 
/*     */       } 
/* 348 */       player.getTeamManager().pushTeamData();
/* 349 */       if (notify) {
/* 350 */         player.getTeamManager().onMemberChange(teamMemberIds);
/* 351 */         player.getXmdsManager().refreshPlayerTeamData(player.getId(), JSON.toJSONString(teamMemberIds));
/* 352 */         player.getXmdsManager().refreshTeamData(player.getId(), Utils.toJSONString(new Object[] { "leaderId", (team == null) ? "" : team.leaderId, "members", members }));
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static String followLeader(WNPlayer player, boolean follow) {
/* 358 */     if (player == null)
/* 359 */       return null; 
/* 360 */     TeamData.TeamMemberData member = player.getTeamManager().getTeamMember();
/* 361 */     if (member != null && member.follow != follow) {
/* 362 */       TeamData team = player.getTeamManager().getTeam();
/* 363 */       if (follow) {
/* 364 */         WNPlayer leader = PlayerUtil.getOnlinePlayer(team.leaderId);
/* 365 */         if (leader != null && !leader.getInstanceId().equals(player.getInstanceId())) {
/* 366 */           Area area = leader.getArea();
/* 367 */           if (area.prop.reqLevel > player.getLevel()) {
/* 368 */             return LangService.format("TEAM_AREA_FOLLOW_LV", new Object[] { Integer.valueOf(area.prop.reqLevel) });
/*     */           }
/* 370 */           AreaUtil.changeArea(member.getPlayer(), new AreaData(area.areaId, area.instanceId));
/*     */         } 
/*     */       } 
/* 373 */       member.follow = follow;
/* 374 */       refreshTeam(team);
/*     */     } 
/* 376 */     return null;
/*     */   }
/*     */   
/*     */   public static void addAutoMatch(WNPlayer player, int targetId, int difficulty) {
/* 380 */     String playerId = player.getId();
/* 381 */     BaseTeamService.MatchData match = AutoMathes.get(playerId);
/* 382 */     if (match != null) {
/* 383 */       removeAutoMatch(playerId);
/* 384 */       if (match.targetId == targetId && match.difficulty == difficulty) {
/*     */         return;
/*     */       }
/* 387 */       match.targetId = targetId;
/* 388 */       match.difficulty = difficulty;
/*     */     } else {
/* 390 */       int logicServerId = player.getLogicServerId();
/* 391 */       match = AutoMathes.getTargetMatch(GWorld.__SERVER_ID, targetId, difficulty);
/* 392 */       if (match != null) {
/* 393 */         if (!matchTeam(match)) {
/* 394 */           WNPlayer leader = match.player;
/* 395 */           createTeam(leader, Arrays.asList(new String[] { player.getId() }, ), logicServerId);
/* 396 */           TeamData team = leader.getTeamManager().getTeam();
/* 397 */           if (team != null) {
/* 398 */             Out.debug(new Object[] { "auto match player : ", leader.getId() });
/* 399 */             team.isAutoTeam = true;
/*     */           } else {
/* 401 */             Out.error(new Object[] { "auto match player : ", leader.getId() });
/*     */           } 
/*     */         } 
/*     */         return;
/*     */       } 
/* 406 */       match = new BaseTeamService.MatchData(player, targetId, difficulty);
/*     */     } 
/* 408 */     AutoMathes.put(playerId, match);
/*     */   }
/*     */   
/*     */   public static void removeAutoMatch(String playerId) {
/* 412 */     AutoMathes.remove(playerId);
/*     */   }
/*     */   
/*     */   public static boolean isAutoMatch(String playerId) {
/* 416 */     return AutoMathes.containsKey(playerId);
/*     */   }
/*     */   
/*     */   public static void onLogout(WNPlayer player) {
/* 420 */     TeamUtil.removeAcrossMatch(player);
/* 421 */     removeAutoMatch(player.getId());
/* 422 */     TeamData team = player.getTeamManager().getTeam();
/* 423 */     if (team != null) {
/* 424 */       (player.getPlayerTempData()).teamId = team.id;
/* 425 */       if (player.getTeamManager().isTeamLeader() && team.memberCount() > 1) {
/* 426 */         team.changeLeader();
/*     */       }
/* 428 */       refreshTeam(team);
/*     */     } else {
/* 430 */       for (TeamData teamData : TeamMap.values()) {
/* 431 */         teamData.removeApply(player.getId());
/*     */       }
/* 433 */       (player.getPlayerTempData()).teamId = null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\team\TeamService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */