/*     */ package com.wanniu.game.team;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.proxy.ProxyClient;
/*     */ import com.wanniu.core.tcp.protocol.Message;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.area.AreaUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.guild.GuildUtil;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.PlayerPO;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ public class TeamUtil
/*     */ {
/*     */   public static int getTeamExpAdd(int teamMemberNum) {
/*  34 */     int expAdd = 0;
/*  35 */     if (teamMemberNum == 2) {
/*  36 */       expAdd = GlobalConfig.TeamExperience2;
/*  37 */     } else if (teamMemberNum == 3) {
/*  38 */       expAdd = GlobalConfig.TeamExperience3;
/*  39 */     } else if (teamMemberNum == 4) {
/*  40 */       expAdd = GlobalConfig.TeamExperience4;
/*  41 */     } else if (teamMemberNum == 5) {
/*  42 */       expAdd = GlobalConfig.TeamExperience5;
/*     */     } 
/*  44 */     return expAdd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<TeamHandler.TeamMemberDetail> generateTeamMemberDetailData(WNPlayer player, TeamData team) {
/*  51 */     Map<String, TeamData.TeamMemberData> teamMembers = team.teamMembers;
/*  52 */     List<TeamHandler.TeamMemberDetail> data = new ArrayList<>();
/*  53 */     for (TeamData.TeamMemberData teamMember : teamMembers.values()) {
/*  54 */       PlayerPO po = teamMember.getPlayerData();
/*  55 */       TeamHandler.TeamMemberDetail.Builder detail = TeamHandler.TeamMemberDetail.newBuilder();
/*  56 */       detail.setId(po.id);
/*  57 */       detail.setName(po.name);
/*  58 */       detail.setPro(po.pro);
/*  59 */       detail.setLevel(po.level);
/*  60 */       detail.setUpLevel(po.upOrder);
/*  61 */       String guildName = GuildUtil.getGuildName(teamMember.id);
/*  62 */       detail.setGuildName(guildName);
/*  63 */       detail.setIsLeader(teamMember.getLeader());
/*  64 */       detail.setFightPower(po.fightPower);
/*     */       
/*  66 */       WNPlayer member = teamMember.getPlayer();
/*  67 */       detail.setAreaDes("");
/*  68 */       if (teamMember.isOnline()) {
/*  69 */         if (player.getInstanceId().equals(member.area.instanceId)) {
/*  70 */           detail.setStatus(Const.PlayerStatus.online.getValue());
/*     */         } else {
/*  72 */           detail.setStatus(Const.PlayerStatus.faraway.getValue());
/*     */         } 
/*  74 */         Area area = member.area;
/*  75 */         if (player.getAreaId() == area.areaId) {
/*  76 */           detail.setAreaDes(area.lineIndex + "线");
/*     */         } else {
/*  78 */           detail.setAreaDes(area.getSceneName());
/*     */         } 
/*     */       } else {
/*  81 */         detail.setStatus(Const.PlayerStatus.offline.getValue());
/*     */       } 
/*  83 */       detail.addAllAvatars(PlayerUtil.getBattlerServerAvatar(po));
/*     */       
/*  85 */       detail.setFollow(teamMember.getFollow());
/*  86 */       if (teamMember.isLeader) {
/*  87 */         data.add(0, detail.build()); continue;
/*     */       } 
/*  89 */       data.add(detail.build());
/*     */     } 
/*     */     
/*  92 */     return data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isInTeam(String playerId) {
/*  99 */     return TeamService.isInTeam(playerId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isInTeam(String teamId, String playerId) {
/* 106 */     return TeamService.isInTeam(teamId, playerId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String createAcrossTeam(String leaderId, List<String> memberIds) {
/* 113 */     Out.debug(new Object[] { "sendCenterServerToCreateTeamAcrossServer" });
/* 114 */     WNPlayer leader = PlayerUtil.findPlayer(leaderId);
/* 115 */     return TeamService.createTeam(leader, memberIds, leader.getAcrossServerId());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String createLocaleTeam(String leaderId, List<String> memberIds) {
/* 122 */     Out.debug(new Object[] { "sendCenterServerToCreateTeamSelfServer" });
/* 123 */     WNPlayer leader = PlayerUtil.findPlayer(leaderId);
/* 124 */     return TeamService.createTeam(leader, memberIds, GWorld.__SERVER_ID);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isHasInvitedPlayer(WNPlayer player, String invitedId) {
/* 131 */     TeamData team = player.getTeamManager().getTeam();
/* 132 */     return (team != null && team.invites.containsKey(invitedId));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isHasAppliedTeam(WNPlayer player, TeamData team) {
/* 139 */     return team.applies.containsKey(player.getId());
/*     */   }
/*     */   
/*     */   public static boolean isFullOfTeam(String teamId) {
/* 143 */     TeamData team = TeamService.getTeam(teamId);
/* 144 */     return (team == null || team.isFull());
/*     */   }
/*     */   
/*     */   public static void handleFullOfTeam(TeamData team, WNPlayer player) {
/* 148 */     if (GWorld.ROBOT) {
/* 149 */       team.confirm = false;
/* 150 */       team.isAutoStart = true;
/* 151 */       if (team != null && team.isAutoStart && team.isFull() && team.isAllOnline()) {
/* 152 */         team.curTargetId = team.targetId;
/* 153 */         team.curDifficulty = team.difficulty;
/* 154 */         int mapId = team.getTargetMap();
/* 155 */         if (mapId > 0) {
/* 156 */           goToTeamTarget(team, player);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static Area goToTeamTarget(TeamData team, WNPlayer player) {
/* 163 */     int mapId = team.getTargetMap();
/* 164 */     if (mapId != 0) {
/*     */ 
/*     */       
/* 167 */       Area area = AreaUtil.enterArea(player, mapId, 0.0F, 0.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 177 */       return area;
/*     */     } 
/*     */     
/* 180 */     Out.warn(new Object[] { "there is no prop in teamTargetProp ID:", Integer.valueOf(team.getCurTargetId()) });
/*     */     
/* 182 */     return null;
/*     */   }
/*     */   
/*     */   public static void sendSysMessageByPlayerEnter(String teamId, String playerId) {
/* 186 */     WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
/* 187 */     for (TeamData.TeamMemberData teamMember : TeamService.getTeamMembers(teamId).values()) {
/* 188 */       if (teamMember.id.equals(playerId)) {
/* 189 */         PlayerUtil.sendSysMessageToPlayer(LangService.getValue("TEAM_ENTER"), teamMember.id, null); continue;
/*     */       } 
/* 191 */       PlayerUtil.sendSysMessageToPlayer(LangService.getValue("TEAM_TARGET_ENTER").replace("{playerName}", player.getName()), teamMember.id);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void sendSysMessageByLeaderChanged(String teamId, String oldLeaderName) {
/* 197 */     TeamData team = TeamService.getTeam(teamId);
/* 198 */     WNPlayer leader = PlayerUtil.getOnlinePlayer(team.leaderId);
/* 199 */     for (TeamData.TeamMemberData teamMember : team.teamMembers.values()) {
/* 200 */       if (teamMember.isLeader) {
/* 201 */         PlayerUtil.sendSysMessageToPlayer(LangService.getValue("TEAM_BE_CAPTAIN").replace("{playerName}", oldLeaderName), teamMember.id); continue;
/*     */       } 
/* 203 */       PlayerUtil.sendSysMessageToPlayer(LangService.getValue("TEAM_CHANGE_CAPTAIN").replace("{playerName}", leader.getName()), teamMember.id);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TeamHandler.TeamTarget generateTeamTargetData(TeamData team) {
/* 212 */     TeamHandler.TeamTarget.Builder target = TeamHandler.TeamTarget.newBuilder();
/* 213 */     if (team != null) {
/* 214 */       target.setTargetId(team.targetId);
/* 215 */       target.setDifficulty(team.difficulty);
/* 216 */       target.setMinLevel(team.minLevel);
/* 217 */       target.setMaxLevel(team.maxLevel);
/* 218 */       target.setIsAutoStart(team.isAutoStart ? 1 : 0);
/* 219 */       target.setIsAutoTeam(team.isAutoTeam ? 1 : 0);
/*     */     } else {
/* 221 */       target.setTargetId(0);
/* 222 */       target.setDifficulty(1);
/* 223 */       target.setMinLevel(0);
/* 224 */       target.setMaxLevel(0);
/* 225 */       target.setIsAutoStart(0);
/* 226 */       target.setIsAutoTeam(0);
/*     */     } 
/* 228 */     return target.build();
/*     */   }
/*     */   
/*     */   public static String canJoinTeam(WNPlayer player, TeamData team) {
/* 232 */     if (team == null) {
/* 233 */       return LangService.getValue("TEAM_BREAK_UP");
/*     */     }
/* 235 */     if (!team.isOpenJoin()) {
/* 236 */       return LangService.getValue("TEAM_LOCKED");
/*     */     }
/* 238 */     if (team.minLevel > player.getLevel()) {
/* 239 */       return LangService.getValue("TEAM_TARGET_NO_LV");
/*     */     }
/* 241 */     if (team.maxLevel != 0 && team.maxLevel < player.getLevel()) {
/* 242 */       return LangService.getValue("TEAM_TARGET_MORE_LV");
/*     */     }
/* 244 */     if (team.isFull()) {
/* 245 */       return LangService.getValue("TEAM_IS_FULL");
/*     */     }
/* 247 */     if (!isValidOfMap(team.sceneType) || !isValidOfMap(player.getSceneType())) {
/* 248 */       return LangService.getValue("TEAM_IN_RAID");
/*     */     }
/* 250 */     return null;
/*     */   }
/*     */   
/*     */   public static boolean isValidOfMap(int sceneType) {
/* 254 */     return (Arrays.binarySearch(GlobalConfig.TeamMapTypeGOs, sceneType) >= 0);
/*     */   }
/*     */   
/*     */   public static void leaveTeamInAreaServer(WNPlayer player) {
/* 258 */     boolean isInTeam = player.getTeamManager().isInTeam();
/* 259 */     if (isInTeam) {
/* 260 */       Map<String, TeamData.TeamMemberData> teamMembers = player.getTeamManager().getTeamMembers();
/* 261 */       TeamService.leaveTeam(player);
/* 262 */       PlayerUtil.sendSysMessageToPlayer(LangService.getValue("TEAM_QUIT"), player.getId());
/* 263 */       for (TeamData.TeamMemberData teamMember : teamMembers.values()) {
/* 264 */         if (!teamMember.id.equals(player.getId())) {
/* 265 */           PlayerUtil.sendSysMessageToPlayer(LangService.format("TEAM_TARGET_LEAVE", new Object[] { player.getName() }), teamMember.id, null);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void pushAcrossMatch(final WNPlayer player) {
/* 272 */     final TeamData team = player.getTeamManager().getTeam();
/* 273 */     if (team != null) {
/* 274 */       team.local = false;
/*     */     } else {
/* 276 */       TeamService.removeAutoMatch(player.getId());
/*     */     } 
/* 278 */     ProxyClient.getInstance().add(new Message()
/*     */         {
/*     */           protected void write() throws IOException {
/* 281 */             this.body.writeByte(1);
/* 282 */             int targetId = player.teamManager.acrossTargetId;
/* 283 */             int difficult = player.teamManager.acrossDifficulty;
/* 284 */             if (team != null) {
/* 285 */               targetId = team.curTargetId;
/* 286 */               difficult = team.curDifficulty;
/*     */             } 
/* 288 */             this.body.writeInt(targetId);
/* 289 */             this.body.writeByte(difficult);
/* 290 */             if (team != null) {
/* 291 */               int count = team.memberCount();
/* 292 */               this.body.writeByte(count);
/* 293 */               for (String playerId : team.teamMembers.keySet()) {
/* 294 */                 concatPlayer(PlayerUtil.getOnlinePlayer(playerId));
/*     */               }
/*     */             } else {
/* 297 */               this.body.writeByte(1);
/* 298 */               concatPlayer(player);
/*     */             } 
/*     */           }
/*     */           
/*     */           private void concatPlayer(WNPlayer player) {
/* 303 */             this.body.writeString(player.getId());
/* 304 */             this.body.writeString(player.getName());
/* 305 */             this.body.writeByte(player.getPro());
/* 306 */             this.body.writeShort(player.getLevel());
/*     */           }
/*     */ 
/*     */           
/*     */           public short getType() {
/* 311 */             return 1265;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public static void removeAcrossMatch(final WNPlayer player) {
/* 317 */     if (player != null && player.isRomote()) {
/* 318 */       player.teamManager.quitAcrossMatch(false);
/* 319 */       ProxyClient.getInstance().add(new Message()
/*     */           {
/*     */             protected void write() throws IOException {
/* 322 */               this.body.writeByte(2);
/* 323 */               this.body.writeString(player.getId());
/*     */             }
/*     */ 
/*     */             
/*     */             public short getType() {
/* 328 */               return 1265;
/*     */             }
/*     */           });
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\team\TeamUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */