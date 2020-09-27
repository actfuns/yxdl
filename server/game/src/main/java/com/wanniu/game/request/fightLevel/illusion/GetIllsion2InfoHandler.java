/*    */ package com.wanniu.game.request.fightLevel.illusion;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.GlobalConfig;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.IllusionPO;
/*    */ import com.wanniu.game.request.fightLevel.FightLevelLine;
/*    */ import java.io.IOException;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import pomelo.area.FightLevelHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.fightLevelHandler.getLllsion2InfoRequest")
/*    */ public class GetIllsion2InfoHandler
/*    */   extends FightLevelLine
/*    */ {
/*    */   public PomeloResponse request(WNPlayer player) throws Exception {
/* 25 */     final FightLevelHandler.GetLllsion2InfoResponse.Builder res = FightLevelHandler.GetLllsion2InfoResponse.newBuilder();
/* 26 */     IllusionPO illusion = player.illusionManager.illusionPO;
/* 27 */     Map<Integer, Integer> boxs = illusion.boxs;
/* 28 */     Integer lv1 = null;
/* 29 */     Integer lv2 = null;
/* 30 */     Integer lv3 = null;
/* 31 */     if (boxs != null) {
/* 32 */       lv1 = boxs.get(Integer.valueOf(1));
/* 33 */       lv2 = boxs.get(Integer.valueOf(2));
/* 34 */       lv3 = boxs.get(Integer.valueOf(3));
/*    */     } 
/* 36 */     res.setS2CTodayLv1((lv1 == null) ? 0 : lv1.intValue());
/* 37 */     res.setS2CTodayLv2((lv2 == null) ? 0 : lv2.intValue());
/* 38 */     res.setS2CTodayLv3((lv3 == null) ? 0 : lv3.intValue());
/* 39 */     res.setS2CMaxNum(GlobalConfig.Mysterious_MaxNumEveryday);
/*    */     
/* 41 */     Map<String, Integer> items = illusion.items;
/* 42 */     Set<Map.Entry<String, Integer>> sets = GlobalConfig.mysteriousMaxNumVcardInfo.entrySet();
/* 43 */     for (Map.Entry<String, Integer> s : sets) {
/* 44 */       String code = s.getKey();
/* 45 */       int vl = ((Integer)s.getValue()).intValue();
/* 46 */       int today = 0;
/* 47 */       if (items != null && !items.isEmpty()) {
/* 48 */         Integer it = items.get(code);
/* 49 */         today = (it == null) ? 0 : it.intValue();
/*    */       } 
/* 51 */       FightLevelHandler.MJItemMax.Builder bd = FightLevelHandler.MJItemMax.newBuilder();
/* 52 */       bd.setItemCode(code);
/* 53 */       bd.setS2CMaxMl(vl);
/* 54 */       bd.setS2CTodayMl(today);
/* 55 */       res.addItemInfo(bd);
/*    */     } 
/* 57 */     res.setS2CCode(200);
/* 58 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 61 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\fightLevel\illusion\GetIllsion2InfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */