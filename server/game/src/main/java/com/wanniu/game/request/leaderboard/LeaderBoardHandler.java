/*    */ package com.wanniu.game.request.leaderboard;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.GWorld;
/*    */ import com.wanniu.game.leaderBoard.LeaderBoardDetail;
/*    */ import com.wanniu.game.leaderBoard.LeaderBoardProto;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.rank.RankType;
/*    */ import io.netty.util.internal.StringUtil;
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.leaderBoardHandler.leaderBoardRequest")
/*    */ public class LeaderBoardHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public short getType() {
/* 29 */     return 785;
/*    */   }
/*    */   
/*    */   public PomeloResponse request() throws Exception {
/* 33 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 34 */     final pomelo.area.LeaderBoardHandler.LeaderBoardRequest req = pomelo.area.LeaderBoardHandler.LeaderBoardRequest.parseFrom(this.pak.getRemaingBytes());
/* 35 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 38 */           pomelo.area.LeaderBoardHandler.LeaderBoardResponse.Builder res = pomelo.area.LeaderBoardHandler.LeaderBoardResponse.newBuilder();
/* 39 */           RankType type = RankType.valueOf(req.getC2SKind());
/* 40 */           if (type == null || type.getHandler() == null) {
/* 41 */             Out.warn(new Object[] { "未实现的排行榜:", Integer.valueOf(this.val$req.getC2SKind()) });
/*    */             
/* 43 */             res.setS2CCode(200);
/* 44 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 48 */           LeaderBoardProto result = type.getHandler().getRankData(player, req.getC2SSeason());
/* 49 */           if (null == result) {
/*    */             
/* 51 */             res.setS2CCode(200);
/* 52 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 56 */           res.setS2CCode(200);
/* 57 */           res.addAllS2CLists(result.s2c_lists);
/* 58 */           String rank = "0";
/* 59 */           if (result.s2c_myData.getContentsCount() > 0) {
/* 60 */             rank = result.s2c_myData.getContents(0);
/*    */           }
/*    */ 
/*    */           
/* 64 */           if (null == result.s2c_myData || StringUtil.isNullOrEmpty(rank) || Integer.parseInt(rank) <= 0) {
/* 65 */             boolean isNeedSelfData = true;
/* 66 */             if (type == RankType.FIGHTPOWER_1 || type == RankType.FIGHTPOWER_3 || type == RankType.FIGHTPOWER_5) {
/* 67 */               int kindPro = type.getValue() - RankType.FIGHTPOWER_1.getValue() + 1;
/* 68 */               if (player.getPro() != kindPro) {
/* 69 */                 isNeedSelfData = false;
/*    */               }
/*    */             } 
/* 72 */             if (isNeedSelfData && (type == RankType.GUILD_BOSS_SINGLE || type == RankType.GUILD_BOSS_GUILD || type == RankType.GUILD_BOSS_PRE_SINGLE || type == RankType.GUILD_BOSS_PRE_GUILD)) {
/* 73 */               isNeedSelfData = false;
/*    */             }
/*    */             
/* 76 */             if (isNeedSelfData) {
/* 77 */               LeaderBoardDetail detail = new LeaderBoardDetail();
/* 78 */               detail.memberId = type.getHandler().getSelfId(player);
/* 79 */               detail.rank = type.getHandler().getSeasonRank(GWorld.__SERVER_ID, req.getC2SSeason(), detail.memberId);
/* 80 */               if (detail.rank > 0L) {
/* 81 */                 detail.score = type.getHandler().getSeasonScore(GWorld.__SERVER_ID, req.getC2SSeason(), detail.memberId);
/*    */                 
/* 83 */                 pomelo.area.LeaderBoardHandler.LeaderBoardData myData = type.getHandler().genBuilderInfo(detail.memberId, (int)detail.score, (int)detail.rank);
/* 84 */                 if (null != myData && myData.getContentsCount() > 1) {
/* 85 */                   result.s2c_myData = myData;
/*    */                 }
/*    */               } 
/*    */             } 
/*    */           } 
/*    */           
/* 91 */           if (result.s2c_lists.size() > 0 && null != result.s2c_myData && result.s2c_myData.getContentsCount() > 0) {
/* 92 */             res.setS2CMyData(result.s2c_myData);
/*    */           }
/* 94 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\leaderboard\LeaderBoardHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */