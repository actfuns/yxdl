/*     */ package com.wanniu.gm.handler;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONArray;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.ext.CharacterExt;
/*     */ import com.wanniu.game.data.ext.SkinListExt;
/*     */ import com.wanniu.game.leaderBoard.LeaderBoardProto;
/*     */ import com.wanniu.game.rank.RankType;
/*     */ import com.wanniu.gm.GMErrorResponse;
/*     */ import com.wanniu.gm.GMEvent;
/*     */ import com.wanniu.gm.GMJsonResponse;
/*     */ import com.wanniu.gm.GMResponse;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import pomelo.area.LeaderBoardHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @GMEvent
/*     */ public class RankHandler
/*     */   extends GMBaseHandler
/*     */ {
/*     */   public GMResponse execute(JSONArray arr) {
/*  31 */     int type = arr.getInteger(0).intValue();
/*  32 */     int subType = arr.getInteger(1).intValue();
/*     */     
/*  34 */     RankType kind = RankType.FIGHTPOWER;
/*  35 */     if (type == 0) {
/*  36 */       switch (subType) {
/*     */         case 0:
/*  38 */           kind = RankType.FIGHTPOWER;
/*     */           break;
/*     */         case 1:
/*  41 */           kind = RankType.LEVEL;
/*     */           break;
/*     */         case 2:
/*  44 */           kind = RankType.Mount;
/*     */           break;
/*     */         case 3:
/*  47 */           kind = RankType.PET;
/*     */           break;
/*     */         case 4:
/*  50 */           kind = RankType.XIANYUAN;
/*     */           break;
/*     */         case 5:
/*  53 */           kind = RankType.DEMON_TOWER;
/*     */           break;
/*     */         case 6:
/*  56 */           kind = RankType.HP;
/*     */           break;
/*     */         case 7:
/*  59 */           kind = RankType.PHY;
/*     */           break;
/*     */         case 8:
/*  62 */           kind = RankType.MAGIC;
/*     */           break;
/*     */       } 
/*     */ 
/*     */     
/*  67 */     } else if (type == 1) {
/*  68 */       if (subType == 0) {
/*  69 */         kind = RankType.GUILD_LEVEL;
/*  70 */       } else if (subType == 1) {
/*  71 */         kind = RankType.GUILD_FORT;
/*     */       } 
/*  73 */     } else if (type == 2) {
/*  74 */       if (subType == 0) {
/*  75 */         kind = RankType.SOLO_SCORE;
/*  76 */       } else if (subType == 1) {
/*  77 */         kind = RankType.PVP_5V5;
/*  78 */       } else if (subType == 2) {
/*  79 */         kind = RankType.ARENA_SCOREALL;
/*     */       } 
/*     */     } 
/*  82 */     LeaderBoardProto result = kind.getHandler().getRankData(GWorld.__SERVER_ID, -1, "");
/*  83 */     if (result == null) {
/*  84 */       return (GMResponse)new GMErrorResponse();
/*     */     }
/*     */     
/*  87 */     JSONArray jaData = new JSONArray();
/*  88 */     for (LeaderBoardHandler.LeaderBoardData leaderBoardData : result.s2c_lists) {
/*  89 */       JSONArray ja = new JSONArray();
/*  90 */       for (int i = 0; i < leaderBoardData.getContentsCount(); i++) {
/*  91 */         if (i == 2) {
/*  92 */           CharacterExt p = (CharacterExt)GameData.Characters.get(Integer.valueOf(Integer.parseInt(leaderBoardData.getContents(i))));
/*  93 */           ja.add((p == null) ? "" : p.proName);
/*     */         
/*     */         }
/*  96 */         else if (kind.equals(RankType.Mount) && i == 6) {
/*  97 */           SkinListExt skin = (SkinListExt)GameData.SkinLists.get(Integer.valueOf(Integer.parseInt(leaderBoardData.getContents(i))));
/*  98 */           ja.add((skin == null) ? "" : skin.skinName);
/*     */         } else {
/*     */           
/* 101 */           ja.add(leaderBoardData.getContents(i));
/*     */         } 
/* 103 */       }  jaData.add(ja);
/*     */     } 
/* 105 */     Map<String, Object> data = new HashMap<>();
/* 106 */     data.put("data", jaData);
/* 107 */     JSONObject jo = new JSONObject(data);
/* 108 */     return (GMResponse)new GMJsonResponse(jo);
/*     */   }
/*     */   
/*     */   public short getType() {
/* 112 */     return 20496;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\handler\RankHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */