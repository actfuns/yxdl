/*     */ package com.wanniu.game.recent;
/*     */ 
/*     */ import com.wanniu.core.game.entity.GEntity;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.common.CommonUtil;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.daoyou.DaoYouService;
/*     */ import com.wanniu.game.guild.GuildUtil;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.GuildMemberPO;
/*     */ import com.wanniu.game.poes.GuildPO;
/*     */ import com.wanniu.game.poes.PlayerPO;
/*     */ import com.wanniu.game.poes.RecentChatPO;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import pomelo.area.FriendHandler;
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
/*     */ public class RecentChatMgr
/*     */ {
/*     */   private RecentChatPO data;
/*  35 */   private final int MSG_MAX = 20;
/*     */   
/*     */   public RecentChatMgr(String playerId, RecentChatPO po) {
/*  38 */     if (null != po) {
/*  39 */       this.data = po;
/*     */     } else {
/*  41 */       this.data = new RecentChatPO();
/*  42 */       PlayerPOManager.put(ConstsTR.playerRecentChatTR, playerId, (GEntity)this.data);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RecentChatPO getData() {
/*  52 */     return this.data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerOffline() {
/*  59 */     checkRecentLimit();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkRecentLimit() {
/*  66 */     if (this.data.msg.size() > GlobalConfig.Social_MaxFriendNum) {
/*  67 */       List<Map.Entry<String, RecentChatMsg>> list = new ArrayList<>(this.data.msg.entrySet());
/*  68 */       list.sort((o1, o2) -> (((RecentChatMsg)o1.getValue()).recentChatTime.getTime() < ((RecentChatMsg)o2.getValue()).recentChatTime.getTime()) ? 1 : -1);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  73 */       for (int i = GlobalConfig.Social_MaxFriendNum; i < this.data.msg.size(); i++) {
/*  74 */         this.data.msg.remove(((Map.Entry)list.get(i)).getKey());
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
/*     */   public FriendHandler.PlayerInfo getPlayerInfo(String playerId) {
/*  86 */     FriendHandler.PlayerInfo.Builder datas = FriendHandler.PlayerInfo.newBuilder();
/*  87 */     FriendHandler.Position.Builder currentPos = FriendHandler.Position.newBuilder();
/*  88 */     boolean isOnline = PlayerUtil.isOnline(playerId);
/*  89 */     datas.setIsOnline(isOnline ? 1 : 0);
/*     */     
/*  91 */     if (isOnline) {
/*  92 */       WNPlayer player = PlayerUtil.findPlayer(playerId);
/*  93 */       if (null == player) {
/*  94 */         return datas.build();
/*     */       }
/*     */       
/*  97 */       datas.setGuildId(player.guildManager.getGuildId());
/*  98 */       datas.setGuildName(player.guildManager.getGuildName());
/*     */       
/* 100 */       datas.setName(player.getName());
/* 101 */       datas.setLevel(player.getLevel());
/* 102 */       datas.setPro(player.getPro());
/* 103 */       datas.setStageLevel(player.player.upLevel);
/* 104 */       datas.setVip(0);
/* 105 */       datas.setFightPower(CommonUtil.calFightPower(player.btlDataManager.allInflus));
/*     */       
/* 107 */       if (DaoYouService.getInstance().getDaoYou(playerId) != null) {
/* 108 */         datas.setHasAlly(1);
/*     */       }
/* 110 */       Area area = player.getArea();
/* 111 */       if (area != null) {
/* 112 */         currentPos.setAreaName(area.getSceneName());
/* 113 */         currentPos.setAreaId(area.areaId);
/*     */       } 
/*     */     } else {
/* 116 */       PlayerPO player = PlayerUtil.getPlayerBaseData(playerId);
/*     */       
/* 118 */       if (null == player) {
/* 119 */         return datas.build();
/*     */       }
/*     */       
/* 122 */       datas.setName(player.name);
/* 123 */       datas.setLevel(player.level);
/* 124 */       datas.setPro(player.pro);
/* 125 */       datas.setStageLevel(player.upLevel);
/* 126 */       datas.setVip(0);
/* 127 */       datas.setGuildId("");
/* 128 */       datas.setGuildName("");
/*     */       
/* 130 */       GuildMemberPO myInfo = GuildUtil.getGuildMember(playerId);
/* 131 */       if (null != myInfo) {
/* 132 */         GuildPO myGuild = GuildUtil.getGuild(myInfo.guildId);
/* 133 */         if (null != myGuild) {
/* 134 */           datas.setGuildId(myGuild.id);
/* 135 */           datas.setGuildName(myGuild.name);
/*     */         } 
/*     */       } 
/*     */       
/* 139 */       datas.setFightPower(player.fightPower);
/*     */     } 
/*     */     
/* 142 */     datas.setId(playerId);
/* 143 */     datas.setCurrentPos(currentPos.build());
/* 144 */     return datas.build();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<FriendHandler.PlayerInfo> getRecentLs() {
/* 153 */     List<FriendHandler.PlayerInfo> ls = new ArrayList<>();
/* 154 */     for (String key : this.data.msg.keySet()) {
/* 155 */       FriendHandler.PlayerInfo playerInfo = getPlayerInfo(key);
/* 156 */       if (null != playerInfo) {
/* 157 */         ls.add(playerInfo);
/*     */       }
/*     */     } 
/* 160 */     return ls;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addRecentMsg(String friendId, ChatMsg msg) {
/* 170 */     Map<String, RecentChatMsg> ls = this.data.msg;
/* 171 */     if (!ls.containsKey(friendId)) {
/* 172 */       RecentChatMsg recentMsg = new RecentChatMsg();
/* 173 */       recentMsg.recentChatTime = DateUtil.format(msg.time);
/* 174 */       recentMsg.msgLs.add(msg);
/* 175 */       ls.put(friendId, recentMsg);
/*     */     } else {
/*     */       
/* 178 */       if (((RecentChatMsg)ls.get(friendId)).msgLs.size() > 20) {
/* 179 */         ((RecentChatMsg)ls.get(friendId)).msgLs.remove(0);
/*     */       }
/*     */       
/* 182 */       ((RecentChatMsg)ls.get(friendId)).recentChatTime = DateUtil.format(msg.time);
/* 183 */       ((RecentChatMsg)ls.get(friendId)).msgLs.add(msg);
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
/*     */   public List<FriendHandler.ChatMsg> getRecentMsg(String playerId) {
/* 197 */     List<FriendHandler.ChatMsg> ls = new ArrayList<>();
/* 198 */     if (this.data.msg.size() < 0 || !this.data.msg.containsKey(playerId)) {
/* 199 */       return ls;
/*     */     }
/*     */     
/* 202 */     for (int i = 0; i < ((RecentChatMsg)this.data.msg.get(playerId)).msgLs.size(); i++) {
/* 203 */       ChatMsg msg = ((RecentChatMsg)this.data.msg.get(playerId)).msgLs.get(i);
/* 204 */       FriendHandler.ChatMsg.Builder buildMsg = FriendHandler.ChatMsg.newBuilder();
/* 205 */       buildMsg.setS2CPlayerId(msg.playerId);
/* 206 */       buildMsg.setS2CContent(msg.content);
/* 207 */       buildMsg.setS2CTime(msg.time);
/* 208 */       buildMsg.setS2CAcceptRid(msg.acceptRid);
/* 209 */       ls.add(buildMsg.build());
/*     */     } 
/*     */     
/* 212 */     return ls;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeRecentMsg(String playerId) {
/* 221 */     if (this.data.msg.size() < 0 || !this.data.msg.containsKey(playerId)) {
/*     */       return;
/*     */     }
/*     */     
/* 225 */     this.data.msg.remove(playerId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeAllMsg() {
/* 232 */     this.data.msg.clear();
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\recent\RecentChatMgr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */