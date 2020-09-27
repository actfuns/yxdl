/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.util.RandomUtil;
/*    */ import com.wanniu.game.data.NpcListCO;
/*    */ 
/*    */ public class NpcListExt
/*    */   extends NpcListCO {
/*    */   public int id;
/*    */   public String type;
/*    */   public Limit successArray;
/*    */   public Limit failScoldArray;
/*    */   public Limit failBattleArray;
/*    */   public int totalDrop;
/*    */   
/*    */   public static class Limit {
/*    */     public int min;
/*    */     public int max;
/*    */   }
/*    */   
/*    */   public void initProperty() {
/* 22 */     this.id = this.npcID;
/* 23 */     this.successArray = new Limit();
/* 24 */     this.failScoldArray = new Limit();
/* 25 */     this.failBattleArray = new Limit();
/* 26 */     if (this.type.indexOf("1") == 0) {
/* 27 */       this.totalDrop = this.sucessDrop + this.failScold + this.failBattle;
/*    */       
/* 29 */       if (this.sucessDrop >= 0) {
/* 30 */         this.successArray.min = 0;
/* 31 */         this.successArray.max = this.sucessDrop;
/*    */       } else {
/* 33 */         Out.error(new Object[] { "NpcDataProp 策划数据错误 SucessDrop 配的概率<0,id:", Integer.valueOf(this.id), ",SucessDrop值:", Integer.valueOf(this.sucessDrop), this });
/*    */       } 
/*    */       
/* 36 */       if (this.failScold >= 0) {
/* 37 */         this.failScoldArray.min = this.successArray.max;
/* 38 */         this.failScoldArray.max = this.failScold;
/*    */       } else {
/* 40 */         Out.error(new Object[] { "NpcDataProp 策划数据错误 FailScold 配的概率<0,id:", Integer.valueOf(this.id), ",FailScold值:", Integer.valueOf(this.failScold), this });
/*    */       } 
/*    */       
/* 43 */       if (this.failBattle >= 0) {
/* 44 */         this.failBattleArray.min = this.failScoldArray.max;
/* 45 */         this.failBattleArray.max = this.failBattle;
/*    */       } else {
/* 47 */         Out.error(new Object[] { "NpcDataProp 策划数据错误 FailBattle 配的概率<0 ,id:", Integer.valueOf(this.id), ",FailBattle值:", Integer.valueOf(this.failBattle), this });
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public int steal() {
/* 53 */     int temp = RandomUtil.random(this.totalDrop);
/* 54 */     if (temp >= this.successArray.min && temp < this.successArray.max)
/* 55 */       return 1; 
/* 56 */     if (temp >= this.failScoldArray.min && temp < this.failScoldArray.max)
/* 57 */       return 2; 
/* 58 */     if (temp >= this.failBattleArray.min && temp < this.failBattleArray.max) {
/* 59 */       return 3;
/*    */     }
/* 61 */     return 2;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\NpcListExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */