/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBField;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FleeSystemPO
/*    */   extends GEntity
/*    */ {
/*    */   @DBField(isPKey = true, fieldType = "varchar", size = 50)
/*    */   public String id;
/* 19 */   public Date seasonEndTime = new Date();
/*    */   
/*    */   public FleeSystemPO(String logicServerId) {
/* 22 */     this.id = logicServerId;
/*    */   }
/*    */   
/*    */   public FleeSystemPO() {}
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\FleeSystemPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */