/*    */ package com.wanniu.game.solo;
/*    */ 
/*    */ import com.wanniu.core.util.RandomUtil;
/*    */ import com.wanniu.game.area.MonsterUnit;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.SoloMonsterCO;
/*    */ import com.wanniu.game.data.SoloRankCO;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SoloUtil
/*    */ {
/*    */   public static int calRankScore(int rankId, int starPoint, Date rankGotTime) {
/* 19 */     int maxRankStar = 10;
/*    */ 
/*    */     
/* 22 */     int rankValue = rankId * (maxRankStar + 1) + starPoint;
/*    */     
/* 24 */     int timeValue = (int)(Math.pow(2.0D, 32.0D) - 1.0D - Math.floor((rankGotTime.getTime() / 1000L)));
/*    */     
/* 26 */     return (int)(rankValue * Math.pow(2.0D, 32.0D) + timeValue);
/*    */   }
/*    */ 
/*    */   
/*    */   public static int getRankStar(int rankId) {
/* 31 */     SoloRankCO prop = (SoloRankCO)GameData.SoloRanks.get(Integer.valueOf(rankId));
/*    */     
/* 33 */     return 0;
/*    */   }
/*    */   
/*    */   public static int diffDays(Date t1, Date t2) {
/* 37 */     long diff = t2.getTime() - t1.getTime();
/* 38 */     return (int)(diff / 86400000L);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static SoloMonsterCO getSoloMonsterPropByPro(int pro) {
/* 48 */     int size = GameData.SoloMonsters.size();
/* 49 */     SoloMonsterCO robot = null;
/* 50 */     while (robot == null || robot.availably == 0) {
/* 51 */       robot = (SoloMonsterCO)GameData.SoloMonsters.get(Integer.valueOf(RandomUtil.getInt(size)));
/*    */     }
/* 53 */     return robot;
/*    */   }
/*    */   
/*    */   public static MonsterUnit getRobot(int pro) {
/* 57 */     SoloMonsterCO soloProp = getSoloMonsterPropByPro(pro);
/* 58 */     String startPoint = String.valueOf(soloProp.startPoint);
/*    */     
/* 60 */     MonsterUnit monsterData = new MonsterUnit();
/* 61 */     monsterData.id = soloProp.monID;
/* 62 */     monsterData.force = Const.AreaForce.FORCEB.value;
/* 63 */     monsterData.flag = startPoint;
/* 64 */     monsterData.autoGuard = true;
/*    */     
/* 66 */     return monsterData;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\solo\SoloUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */