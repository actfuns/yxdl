/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.data.BlackWordCO;
/*    */ 
/*    */ public class BlackWordExt
/*    */   extends BlackWordCO
/*    */ {
/*    */   public void initProperty() {
/* 10 */     if (StringUtil.isNotEmpty(this.word))
/* 11 */       this.word = this.word.toLowerCase(); 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\BlackWordExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */