/*    */ package com.wanniu.gm.handler;
/*    */ 
/*    */ import cn.qeng.common.gm.vo.GmPlayerRankVO;
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.wanniu.game.GWorld;
/*    */ import com.wanniu.game.arena.ArenaService;
/*    */ import com.wanniu.game.guild.GuildUtil;
/*    */ import com.wanniu.game.poes.GuildPO;
/*    */ import com.wanniu.game.rank.RankType;
/*    */ import com.wanniu.game.solo.SoloService;
/*    */ import com.wanniu.gm.GMEvent;
/*    */ import com.wanniu.gm.GMJsonResponse;
/*    */ import com.wanniu.gm.GMResponse;
/*    */ import java.util.ArrayList;
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
/*    */ 
/*    */ @GMEvent
/*    */ public class PlayerRankHandler
/*    */   extends GMBaseHandler
/*    */ {
/*    */   public GMResponse execute(JSONArray arr) {
/* 32 */     String id = arr.getString(0);
/* 33 */     List<GmPlayerRankVO> list = new ArrayList<>();
/* 34 */     long rank = 0L;
/* 35 */     rank = RankType.FIGHTPOWER.getHandler().getRank(GWorld.__SERVER_ID, id);
/* 36 */     list.add(new GmPlayerRankVO("综合", "人物战力榜", (rank == 0L) ? "未上榜" : String.valueOf(rank)));
/*    */     
/* 38 */     rank = RankType.LEVEL.getHandler().getRank(GWorld.__SERVER_ID, id);
/* 39 */     list.add(new GmPlayerRankVO("综合", "人物等级榜", (rank == 0L) ? "未上榜" : String.valueOf(rank)));
/*    */     
/* 41 */     rank = RankType.Mount.getHandler().getRank(GWorld.__SERVER_ID, id);
/* 42 */     list.add(new GmPlayerRankVO("综合", "坐骑榜", (rank == 0L) ? "未上榜" : String.valueOf(rank)));
/*    */     
/* 44 */     rank = RankType.PET.getHandler().getRank(GWorld.__SERVER_ID, id);
/* 45 */     list.add(new GmPlayerRankVO("综合", "宠物榜", (rank == 0L) ? "未上榜" : String.valueOf(rank)));
/*    */     
/* 47 */     GuildPO guild = GuildUtil.getPlayerGuild(id);
/* 48 */     rank = RankType.GUILD_LEVEL.getHandler().getRank(GWorld.__SERVER_ID, (guild == null) ? "" : guild.id);
/* 49 */     list.add(new GmPlayerRankVO("综合", "仙盟等级榜", (rank == 0L) ? "未上榜" : String.valueOf(rank)));
/*    */     
/* 51 */     rank = RankType.SOLO_SCORE.getHandler().getSeasonRank(GWorld.__SERVER_ID, SoloService.getInstance().getTerm(), id);
/* 52 */     list.add(new GmPlayerRankVO("竞技榜", "问道大会", (rank == 0L) ? "未上榜" : String.valueOf(rank)));
/*    */     
/* 54 */     rank = RankType.PVP_5V5.getHandler().getRank(GWorld.__SERVER_ID, id);
/* 55 */     list.add(new GmPlayerRankVO("竞技榜", "试炼大赛", (rank == 0L) ? "未上榜" : String.valueOf(rank)));
/*    */     
/* 57 */     rank = RankType.ARENA_SCOREALL.getHandler().getSeasonRank(GWorld.__SERVER_ID, ArenaService.getInstance().getTerm(), id);
/* 58 */     list.add(new GmPlayerRankVO("竞技榜", "五岳一战", (rank == 0L) ? "未上榜" : String.valueOf(rank)));
/*    */     
/* 60 */     Map<String, Object> data = new HashMap<>();
/* 61 */     data.put("total", Integer.valueOf(list.size()));
/* 62 */     data.put("rows", list);
/* 63 */     JSONObject jo = new JSONObject(data);
/*    */     
/* 65 */     return (GMResponse)new GMJsonResponse(jo);
/*    */   }
/*    */   
/*    */   public short getType() {
/* 69 */     return 12323;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\handler\PlayerRankHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */