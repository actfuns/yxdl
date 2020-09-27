/*    */ package com.wanniu.gm.handler;
/*    */ 
/*    */ import cn.qeng.common.gm.vo.GmGuildMemberVO;
/*    */ import cn.qeng.common.gm.vo.GmGuildVO;
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.ext.CharacterExt;
/*    */ import com.wanniu.game.guild.GuildUtil;
/*    */ import com.wanniu.game.guild.dao.GuildDao;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.poes.GuildMemberPO;
/*    */ import com.wanniu.game.poes.GuildPO;
/*    */ import com.wanniu.game.poes.PlayerPO;
/*    */ import com.wanniu.gm.GMErrorResponse;
/*    */ import com.wanniu.gm.GMEvent;
/*    */ import com.wanniu.gm.GMJsonResponse;
/*    */ import com.wanniu.gm.GMResponse;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.Comparator;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GMEvent
/*    */ public class GuildQueryHandler
/*    */   extends GMBaseHandler
/*    */ {
/*    */   public GMResponse execute(JSONArray arr) {
/* 37 */     String guildName = arr.getString(0);
/* 38 */     int type = arr.getIntValue(1);
/* 39 */     if (type == 0) {
/* 40 */       String guildId = GuildUtil.getGuildByFullName(guildName);
/* 41 */       if (guildId == null) {
/* 42 */         return (GMResponse)new GMErrorResponse();
/*    */       }
/* 44 */       List<GmGuildMemberVO> list1 = new ArrayList<>();
/* 45 */       List<GuildMemberPO> members = GuildUtil.getGuildMemberList(guildId);
/* 46 */       for (GuildMemberPO m : members) {
/* 47 */         PlayerPO playerPo = PlayerUtil.getPlayerBaseData(m.playerId);
/* 48 */         String state = PlayerUtil.isOnline(m.playerId) ? "在线" : "";
/* 49 */         if (state.isEmpty()) {
/* 50 */           long minute = (System.currentTimeMillis() - playerPo.logoutTime.getTime()) / 60000L;
/* 51 */           if (minute < 60L) {
/* 52 */             state = "离线" + minute + "分钟";
/*    */           } else {
/* 54 */             state = "离线" + (minute / 60L) + "小时";
/*    */           } 
/*    */         } 
/* 57 */         list1.add(new GmGuildMemberVO(playerPo.name, playerPo.level, playerPo.fightPower, (GuildUtil.getGuildJobPropByJobId(m.job)).position, m.lastContributeValue, state, ((CharacterExt)GameData.Characters.get(Integer.valueOf(playerPo.pro))).proName, m.job));
/*    */       } 
/* 59 */       Collections.sort(list1, new Comparator<GmGuildMemberVO>()
/*    */           {
/*    */             public int compare(GmGuildMemberVO o1, GmGuildMemberVO o2)
/*    */             {
/* 63 */               int i = o1.getJob() - o2.getJob();
/* 64 */               if (i == 0) {
/* 65 */                 i = o2.getLevel() - o1.getLevel();
/* 66 */               } else if (i == 0) {
/* 67 */                 i = o2.getPower() - o1.getPower();
/*    */               } 
/* 69 */               return i;
/*    */             }
/*    */           });
/* 72 */       GuildPO guild = GuildUtil.getGuild(guildId);
/* 73 */       Map<String, Object> map = new HashMap<>();
/* 74 */       map.put("total", Integer.valueOf(list1.size()));
/* 75 */       map.put("rows", list1);
/* 76 */       map.put("id", guild.id);
/* 77 */       map.put("level", Integer.valueOf(guild.level));
/* 78 */       map.put("notice", guild.notice);
/* 79 */       JSONObject jSONObject = new JSONObject(map);
/*    */       
/* 81 */       return (GMResponse)new GMJsonResponse(jSONObject);
/*    */     } 
/* 83 */     List<GmGuildVO> list = new ArrayList<>();
/* 84 */     for (GuildPO guild : GuildDao.GuildMap.values()) {
/* 85 */       if (guild.name.indexOf(guildName) >= 0) {
/* 86 */         list.add(new GmGuildVO(guild.name, guild.level, guild.presidentName));
/*    */       }
/*    */     } 
/*    */     
/* 90 */     Map<String, Object> data = new HashMap<>();
/* 91 */     data.put("total", Integer.valueOf(list.size()));
/* 92 */     data.put("rows", list);
/* 93 */     JSONObject jo = new JSONObject(data);
/* 94 */     return (GMResponse)new GMJsonResponse(jo);
/*    */   }
/*    */ 
/*    */   
/*    */   public short getType() {
/* 99 */     return 12337;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\handler\GuildQueryHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */