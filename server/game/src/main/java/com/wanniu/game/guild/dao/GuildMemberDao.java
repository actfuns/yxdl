/*    */ package com.wanniu.game.guild.dao;
/*    */ 
/*    */ import com.wanniu.core.db.GCache;
/*    */ import com.wanniu.core.db.ModifyDataType;
/*    */ import com.wanniu.game.common.ConstsTR;
/*    */ import com.wanniu.game.common.Utils;
/*    */ import com.wanniu.game.guild.GuildCommonUtil;
/*    */ import com.wanniu.game.poes.GuildMemberPO;
/*    */ import com.wanniu.redis.GameDao;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashSet;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ 
/*    */ 
/*    */ public class GuildMemberDao
/*    */ {
/* 19 */   public static final Map<String, GuildMemberPO> PlayerMemberMap = new ConcurrentHashMap<>();
/* 20 */   public static final Map<String, Set<String>> GuildMemberMap = new ConcurrentHashMap<>();
/*    */   
/*    */   public static void init() {
/* 23 */     ArrayList<GuildMemberPO> members = GuildCommonUtil.hgetAll(ConstsTR.guildMemberTR, GuildMemberPO.class);
/* 24 */     for (GuildMemberPO member : members) {
/* 25 */       addGuildMember(member);
/*    */     }
/*    */   }
/*    */   
/*    */   public static void addGuildMember(GuildMemberPO member) {
/* 30 */     PlayerMemberMap.put(member.playerId, member);
/* 31 */     Set<String> players = GuildMemberMap.get(member.guildId);
/* 32 */     if (players == null) {
/* 33 */       players = new HashSet<>();
/* 34 */       GuildMemberMap.put(member.guildId, players);
/*    */     } 
/* 36 */     players.add(member.playerId);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GuildMemberPO getGuildMember(String playerId) {
/* 43 */     return PlayerMemberMap.get(playerId);
/*    */   }
/*    */   
/*    */   public static Set<String> getGuildMemberIdList(String guildId) {
/* 47 */     return GuildMemberMap.get(guildId);
/*    */   }
/*    */   
/*    */   public static int getGuildMemberCount(String guildId) {
/* 51 */     Set<String> members = GuildMemberMap.get(guildId);
/* 52 */     return (members != null) ? members.size() : 0;
/*    */   }
/*    */   
/*    */   public static void updateGuildMember(GuildMemberPO member) {
/* 56 */     if (!PlayerMemberMap.containsKey(member.playerId)) {
/* 57 */       addGuildMember(member);
/*    */     }
/* 59 */     GCache.hset(ConstsTR.guildMemberTR.value, member.playerId, Utils.serialize(member));
/* 60 */     GameDao.updateToDB(ConstsTR.guildMemberTR, member.playerId, ModifyDataType.MAP);
/*    */   }
/*    */   
/*    */   public static void removeGuildMember(String playerId) {
/* 64 */     GuildMemberPO member = PlayerMemberMap.remove(playerId);
/* 65 */     if (member != null) {
/* 66 */       Set<String> members = GuildMemberMap.get(member.guildId);
/* 67 */       if (members != null) {
/* 68 */         members.remove(playerId);
/*    */       }
/* 70 */       GCache.hremove(ConstsTR.guildMemberTR.value, member.playerId);
/* 71 */       GameDao.delToDB(ConstsTR.guildMemberTR, playerId);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\dao\GuildMemberDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */