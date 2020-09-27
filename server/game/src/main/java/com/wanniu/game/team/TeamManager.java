/*     */ package com.wanniu.game.team;
/*     */ 
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.PlayerPO;
/*     */ import com.wanniu.game.task.po.TaskPO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TeamManager
/*     */ {
/*     */   private WNPlayer player;
/*     */   private TeamData team;
/*     */   private TeamData.TeamMemberData teamMember;
/*     */   public boolean loginFlag;
/*     */   public int acrossTargetId;
/*     */   public int acrossDifficulty;
/*     */   
/*     */   public TeamManager() {}
/*     */   
/*     */   public TeamManager(WNPlayer player) {
/*  43 */     this.player = player;
/*  44 */     String teamId = (player.getPlayerTempData()).teamId;
/*  45 */     if (teamId != null) {
/*  46 */       TeamData team = TeamService.getTeam(teamId);
/*  47 */       setTeamData(team);
/*  48 */       checkLeader();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void quitAcrossMatch(boolean quit) {
/*  53 */     this.acrossTargetId = 0;
/*  54 */     this.player.teamMembers = null;
/*  55 */     if (this.team != null) {
/*  56 */       this.team.local = (quit || this.team.memberCount() <= 1);
/*     */     }
/*  58 */     TeamHandler.OnAcrossTeamInfoPush push = TeamHandler.OnAcrossTeamInfoPush.newBuilder().build();
/*  59 */     this.player.receive("area.teamPush.onAcrossTeamInfoPush", (GeneratedMessage)push);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAcceptAutoTeam() {
/*  66 */     return ((this.player.getPlayer()).isAcceptAutoTeam == 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAutoTeam() {
/*  73 */     return (this.team != null && this.team.isAutoTeam);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getIsAutoTeam() {
/*  80 */     if (this.team != null) {
/*  81 */       if (this.team.isAutoTeam) {
/*  82 */         return 1;
/*     */       }
/*  84 */       return 0;
/*     */     } 
/*     */     
/*  87 */     return isAcceptAutoTeam() ? 1 : 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIsAutoTeam(boolean auto) {
/*  94 */     if (this.team != null) {
/*  95 */       this.team.isAutoTeam = auto;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onMessage(int msgType, int operate, String id) {
/* 103 */     Out.debug(new Object[] { Integer.valueOf(msgType), " team onEvent, ", id });
/* 104 */     String result = null;
/*     */     
/* 106 */     if (msgType == Const.MESSAGE_TYPE.team_invite.getValue()) {
/* 107 */       TeamData team = TeamService.getTeam(id);
/* 108 */       if (team == null) {
/* 109 */         this.player.sendSysTip(LangService.getValue("TEAM_NULL"));
/* 110 */         return true;
/*     */       } 
/* 112 */       if (!team.invites.containsKey(this.player.getId())) {
/* 113 */         this.player.sendSysTip(LangService.getValue("EXPIRED_MSG"));
/* 114 */         return false;
/*     */       } 
/* 116 */       team.invites.remove(this.player.getId());
/* 117 */       if (!team.isOpenJoin()) {
/* 118 */         this.player.sendSysTip(LangService.getValue("TEAM_BATTLE_ERR"));
/* 119 */         return false;
/*     */       } 
/* 121 */       if (team.isFull()) {
/* 122 */         this.player.sendSysTip(LangService.getValue("TEAM_IS_FULL"));
/* 123 */         return false;
/*     */       } 
/* 125 */       if (operate == Const.MESSAGE_OPERATE.TYPE_ACCEPT.getValue()) {
/* 126 */         boolean isInTeam = isInTeam();
/* 127 */         if (isInTeam) {
/* 128 */           result = LangService.getValue("TEAM_EXISTS");
/*     */         } else {
/* 130 */           String res = TeamUtil.canJoinTeam(this.player, team);
/* 131 */           if (res == null) {
/* 132 */             result = TeamService.joinTeam(team.id, this.player);
/*     */           }
/*     */         } 
/* 135 */         if (result == null) {
/* 136 */           TeamData.TeamMemberData inviter = team.getLeader();
/* 137 */           TeamUtil.sendSysMessageByPlayerEnter(inviter.teamId, this.player.getId());
/* 138 */           return false;
/*     */         } 
/* 140 */         this.player.sendSysTip(result);
/* 141 */         return true;
/*     */       } 
/*     */       
/* 144 */       String s = LangService.format("TEAM_REFUSE", new Object[] { this.player.getName() });
/* 145 */       PlayerUtil.sendSysMessageToPlayer(s, team.leaderId, null);
/*     */     }
/* 147 */     else if (msgType == Const.MESSAGE_TYPE.team_apply.getValue()) {
/* 148 */       String applyId = id;
/* 149 */       if (this.team != null) {
/* 150 */         if (!this.team.applies.containsKey(applyId)) {
/* 151 */           this.player.sendSysTip(LangService.getValue("EXPIRED_MSG"));
/* 152 */           return false;
/*     */         } 
/* 154 */         this.team.removeApply(applyId);
/*     */       } 
/* 156 */       if (operate == Const.MESSAGE_OPERATE.TYPE_ACCEPT.getValue()) {
/* 157 */         if (TeamUtil.isInTeam(applyId)) {
/* 158 */           this.player.sendSysTip(LangService.getValue("TEAM_TARGET_IN_TEAM"));
/* 159 */           return false;
/*     */         } 
/* 161 */         TeamData.TeamMemberData teamMember = this.team.getMember(this.player.getId());
/* 162 */         if (teamMember != null && teamMember.isLeader) {
/* 163 */           result = TeamService.joinTeam(teamMember.teamId, PlayerUtil.getOnlinePlayer(applyId));
/*     */         }
/* 165 */         Out.debug(new Object[] { "join team result:", result });
/* 166 */         if (result == null) {
/* 167 */           TeamUtil.sendSysMessageByPlayerEnter(teamMember.teamId, applyId);
/* 168 */           return false;
/*     */         } 
/* 170 */         String s = LangService.format("TEAM_REFUSE", new Object[] { this.player.getName() });
/* 171 */         PlayerUtil.sendSysMessageToPlayer(s, applyId, null);
/* 172 */         return true;
/*     */       } 
/*     */       
/* 175 */       String res = LangService.getValue("TEAM_TARGET_REFUSE").replace("{playerName}", this.player.getName());
/* 176 */       PlayerUtil.sendSysMessageToPlayer(res, applyId, null);
/*     */     } 
/*     */     
/* 179 */     return true;
/*     */   }
/*     */   
/*     */   public void pushTeamData() {
/* 183 */     String teamId = "";
/* 184 */     List<TeamHandler.TeamMember> teamMembers = new ArrayList<>();
/* 185 */     TeamHandler.OnTeamUpdatePush.Builder data = TeamHandler.OnTeamUpdatePush.newBuilder();
/* 186 */     TeamData team = this.team;
/* 187 */     if (team != null) {
/* 188 */       teamId = team.id;
/* 189 */       Map<String, TeamData.TeamMemberData> teamMembersData = getTeamMembers();
/* 190 */       for (TeamData.TeamMemberData teamMember : teamMembersData.values()) {
/* 191 */         if (!teamMember.id.equals(this.player.getId())) {
/* 192 */           PlayerPO member = teamMember.getPlayerData();
/* 193 */           TeamHandler.TeamMember.Builder tm = TeamHandler.TeamMember.newBuilder();
/* 194 */           tm.setId(teamMember.id);
/* 195 */           tm.setName(member.name);
/* 196 */           tm.setPro(member.pro);
/* 197 */           tm.setLevel(member.level);
/* 198 */           tm.setIsLeader(teamMember.getLeader());
/* 199 */           tm.setFollow(teamMember.getFollow());
/* 200 */           if (teamMember.isOnline()) {
/* 201 */             WNPlayer pm = teamMember.getPlayer();
/* 202 */             tm.setAreaId(pm.getAreaId());
/* 203 */             if (this.player.getInstanceId().equals(pm.getInstanceId())) {
/* 204 */               tm.setStatus(Const.PlayerStatus.online.getValue());
/*     */             } else {
/* 206 */               tm.setStatus(Const.PlayerStatus.faraway.getValue());
/*     */             } 
/*     */           } else {
/* 209 */             tm.setStatus(Const.PlayerStatus.offline.getValue());
/*     */           } 
/*     */           
/* 212 */           teamMembers.add(tm.build()); continue;
/*     */         } 
/* 214 */         data.setFollow(teamMember.getFollow());
/*     */       } 
/*     */       
/* 217 */       data.setS2CIsAcceptAutoTeam(team.isAutoTeam ? 1 : 0);
/*     */     } 
/* 219 */     data.setS2CTeamId(teamId);
/* 220 */     data.addAllS2CData(teamMembers);
/* 221 */     this.player.receive("area.teamPush.onTeamUpdatePush", (GeneratedMessage)data.build());
/*     */   }
/*     */   
/*     */   private void checkLeader() {
/* 225 */     TeamData.TeamMemberData leader = (this.team == null) ? null : this.team.getLeader();
/* 226 */     if (this.teamMember != null && !this.teamMember.isLeader && (leader == null || !leader.isOnline())) {
/* 227 */       this.team.changeLeader();
/*     */     }
/*     */   }
/*     */   
/*     */   public void checkLogin() {
/* 232 */     if (this.loginFlag) {
/* 233 */       this.loginFlag = false;
/* 234 */       checkLeader();
/* 235 */       if (this.team != null) {
/* 236 */         TeamHandler.OnTeamTargetPush targetPush = TeamHandler.OnTeamTargetPush.newBuilder().setS2CTeamTarget(TeamUtil.generateTeamTargetData(this.team)).setHaveApply(this.team.applies.size()).setS2CIsAcceptAutoTeam(this.team.isAutoTeam ? 1 : 0).build();
/* 237 */         this.player.receive("area.teamPush.onTeamTargetPush", (GeneratedMessage)targetPush);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void onPlayerUpgrade() {
/* 243 */     TeamService.refreshTeam(this.team, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onMemberChange(Collection<String> members) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTeamData(TeamData team) {
/* 260 */     if (this.team != team) {
/* 261 */       this.team = team;
/* 262 */       if (team == null) {
/* 263 */         this.teamMember = null;
/*     */       } else {
/* 265 */         this.teamMember = team.getMember(this.player.getId());
/* 266 */         if (this.teamMember == null) {
/* 267 */           this.team = null;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInTeam() {
/* 277 */     return (this.teamMember != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TeamData.TeamMemberData getTeamMember() {
/* 284 */     return this.teamMember;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, TeamData.TeamMemberData> getTeamMembers() {
/* 291 */     if (this.team == null)
/* 292 */       return null; 
/* 293 */     return this.team.teamMembers;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TeamData getTeam() {
/* 300 */     return this.team;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<Integer, TaskPO> getLoopTasks() {
/* 307 */     return (this.team != null) ? this.team.loopTasks : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTeamLeader() {
/* 314 */     return (this.teamMember != null) ? this.teamMember.isLeader : false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFollowLeader() {
/* 321 */     return (this.teamMember != null) ? this.teamMember.follow : false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int followCount() {
/* 328 */     if (this.team != null) {
/* 329 */       return this.team.followCount();
/*     */     }
/* 331 */     return 1;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\team\TeamManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */