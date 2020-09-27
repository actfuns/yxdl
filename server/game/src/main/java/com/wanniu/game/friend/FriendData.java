/*    */ package com.wanniu.game.friend;
/*    */ 
/*    */ import com.wanniu.core.util.DateUtil;
/*    */ import com.wanniu.game.area.Area;
/*    */ import com.wanniu.game.daoyou.DaoYouService;
/*    */ import com.wanniu.game.guild.GuildUtil;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.DaoYouPO;
/*    */ import com.wanniu.game.poes.GuildMemberPO;
/*    */ import com.wanniu.game.poes.GuildPO;
/*    */ import com.wanniu.game.poes.PlayerPO;
/*    */ import java.util.Date;
/*    */ import pomelo.area.FriendHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FriendData
/*    */ {
/*    */   public String friendId;
/*    */   public int friendLv;
/*    */   public Date createTimeStamp;
/*    */   public Date addFriendLvTime;
/*    */   public int addFriendLvToday;
/*    */   
/*    */   public FriendHandler.PlayerInfo friendToJson4PayLoad(FriendManager.RecordInfo recordInfos) {
/* 28 */     FriendHandler.PlayerInfo.Builder datas = FriendHandler.PlayerInfo.newBuilder();
/* 29 */     FriendHandler.Position.Builder currentPos = FriendHandler.Position.newBuilder();
/* 30 */     boolean isOnline = PlayerUtil.isOnline(this.friendId);
/* 31 */     datas.setIsOnline(isOnline ? 1 : 0);
/*    */     
/* 33 */     if (isOnline) {
/* 34 */       WNPlayer friendPlayer = PlayerUtil.findPlayer(this.friendId);
/* 35 */       if (null == friendPlayer) {
/* 36 */         return datas.build();
/*    */       }
/*    */       
/* 39 */       datas.setGuildId(friendPlayer.guildManager.getGuildId());
/* 40 */       datas.setGuildName(friendPlayer.guildManager.getGuildName());
/*    */       
/* 42 */       datas.setName(friendPlayer.getName());
/* 43 */       datas.setLevel(friendPlayer.getLevel());
/* 44 */       datas.setPro(friendPlayer.getPro());
/* 45 */       datas.setStageLevel(friendPlayer.player.upOrder);
/* 46 */       datas.setVip(0);
/* 47 */       datas.setFightPower(friendPlayer.player.fightPower);
/*    */       
/* 49 */       if (DaoYouService.getInstance().getDaoYou(friendPlayer.getId()) != null) {
/* 50 */         datas.setHasAlly(1);
/*    */       }
/* 52 */       Area area = friendPlayer.getArea();
/* 53 */       if (area != null) {
/* 54 */         currentPos.setAreaName(area.getSceneName());
/* 55 */         currentPos.setAreaId(area.areaId);
/*    */       } 
/*    */     } else {
/* 58 */       PlayerPO friendPlayer = PlayerUtil.getPlayerBaseData(this.friendId);
/*    */       
/* 60 */       if (null == friendPlayer) {
/* 61 */         return null;
/*    */       }
/*    */       
/* 64 */       datas.setName(friendPlayer.name);
/* 65 */       datas.setLevel(friendPlayer.level);
/* 66 */       datas.setPro(friendPlayer.pro);
/* 67 */       datas.setStageLevel(friendPlayer.upOrder);
/* 68 */       datas.setVip(0);
/* 69 */       datas.setGuildId("");
/* 70 */       datas.setGuildName("");
/*    */       
/* 72 */       GuildMemberPO myInfo = GuildUtil.getGuildMember(this.friendId);
/* 73 */       if (null != myInfo) {
/* 74 */         GuildPO myGuild = GuildUtil.getGuild(myInfo.guildId);
/* 75 */         if (null != myGuild) {
/* 76 */           datas.setGuildId(myGuild.id);
/* 77 */           datas.setGuildName(myGuild.name);
/*    */         } 
/*    */       } 
/*    */       
/* 81 */       datas.setFightPower(friendPlayer.fightPower);
/*    */     } 
/*    */     
/* 84 */     if (recordInfos != null) {
/* 85 */       boolean isSame = DateUtil.isSameDay(recordInfos.concernTime, new Date());
/* 86 */       datas.setIsConcerned(isSame ? 1 : 0);
/*    */     } else {
/* 88 */       datas.setIsConcerned(0);
/*    */     } 
/* 90 */     datas.setId(this.friendId);
/* 91 */     datas.setFriendLv(this.friendLv);
/* 92 */     datas.setCurrentPos(currentPos.build());
/* 93 */     DaoYouPO daoYouPo = DaoYouService.getInstance().getDaoYou(this.friendId);
/* 94 */     datas.setIsHaveDaoYou((null == daoYouPo) ? 0 : 1);
/* 95 */     return datas.build();
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\friend\FriendData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */