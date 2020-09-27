/*    */ package com.wanniu.core.db;
/*    */ 
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QueryVo
/*    */ {
/*    */   private String table;
/*    */   private String conVal;
/*    */   public int type;
/*    */   
/*    */   public QueryVo(String tr, String conVal) {
/* 18 */     this.table = tr;
/* 19 */     this.conVal = conVal;
/* 20 */     this.type = StringUtil.isEmpty(conVal) ? 0 : 1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getQueryTR() {
/* 27 */     return this.table;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getConVal() {
/* 34 */     return this.conVal;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\db\QueryVo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */