/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.AchievementConfigCO;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AchievementConfigExt
/*    */   extends AchievementConfigCO
/*    */ {
/*    */   public int id;
/*    */   public String name;
/*    */   public Const.ACHIEVEMENT_TYPE _type;
/*    */   public int beloneId;
/*    */   public Map<String, Integer> awards;
/*    */   
/*    */   public void initProperty() {
/* 20 */     this.id = this.typeId;
/* 21 */     this.name = this.type;
/*    */     
/* 23 */     if (this.id == 0) {
/* 24 */       this._type = Const.ACHIEVEMENT_TYPE.ACHIEVEMENT_TYPE_ALL;
/* 25 */       this.beloneId = 0;
/* 26 */     } else if ((int)Math.floor((this.id % 10)) == 0) {
/* 27 */       this._type = Const.ACHIEVEMENT_TYPE.ACHIEVEMENT_TYPE_MAIN;
/* 28 */       this.beloneId = this.id;
/*    */     } else {
/* 30 */       this._type = Const.ACHIEVEMENT_TYPE.ACHIEVEMENT_TYPE_SUB;
/* 31 */       this.beloneId = (int)(Math.floor((this.id / 10)) * 10.0D);
/*    */     } 
/*    */     
/* 34 */     this.awards = new HashMap<>();
/* 35 */     String[] items = this.awardKey.split(",");
/* 36 */     for (String item : items) {
/* 37 */       String[] codenum = item.split(":");
/* 38 */       this.awards.put(codenum[0], Integer.valueOf(Integer.parseInt(codenum[1])));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\AchievementConfigExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */