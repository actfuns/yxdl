/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.common.IntIntPair;
/*    */ import com.wanniu.game.data.BaseDataCO;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ public class BaseDataExt
/*    */   extends BaseDataCO
/*    */ {
/*    */   private IntIntPair[] _initSkills;
/* 13 */   public List<String> list_ExpCode = new ArrayList<>();
/*    */   
/*    */   public void initProperty() {
/* 16 */     List<IntIntPair> sl = new ArrayList<>();
/* 17 */     String[] skillsInfo = this.initSkill.split("\\|");
/* 18 */     for (String skillInfo : skillsInfo) {
/* 19 */       String[] params = skillInfo.split(":");
/* 20 */       if (params.length > 1) {
/* 21 */         IntIntPair pair = new IntIntPair();
/* 22 */         pair.first = Integer.parseInt(params[0]);
/* 23 */         pair.second = Integer.parseInt(params[1]);
/* 24 */         sl.add(pair);
/*    */       } 
/*    */     } 
/* 27 */     this._initSkills = new IntIntPair[sl.size()];
/* 28 */     this._initSkills = sl.<IntIntPair>toArray(this._initSkills);
/*    */     
/* 30 */     String[] _expCode = this.expCode.split(",");
/* 31 */     for (String par : _expCode) {
/* 32 */       this.list_ExpCode.add(par);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public IntIntPair[] getInitSkills() {
/* 38 */     return this._initSkills;
/*    */   }
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
/*    */ 
/*    */ 
/*    */   
/*    */   public String getModelStar(int level) {
/* 54 */     return null;
/*    */   }
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
/*    */ 
/*    */ 
/*    */   
/*    */   public int getModelStarPercent(int level) {
/* 70 */     return 0;
/*    */   }
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
/*    */ 
/*    */ 
/*    */   
/*    */   public int getModelStarScenePercent(int level) {
/* 86 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\BaseDataExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */