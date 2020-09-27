/*    */ package com.wanniu.core.db.message;
/*    */ 
/*    */ import com.wanniu.core.db.DBType;
/*    */ import com.wanniu.core.db.ModifyVo;
/*    */ import com.wanniu.core.tcp.protocol.RequestMessage;
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DBModifyMessage
/*    */   extends RequestMessage
/*    */ {
/*    */   private ModifyVo vo;
/*    */   
/*    */   public DBModifyMessage(ModifyVo vo) {
/* 17 */     this.vo = vo;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void write() throws IOException {
/* 22 */     this.body.writeString(this.vo.getModifyTR());
/* 23 */     this.body.writeString(this.vo.getModifyPKey());
/* 24 */     this.body.writeByte(this.vo.getModifyOperate());
/* 25 */     this.body.writeByte(this.vo.getModifyDataType());
/*    */   }
/*    */ 
/*    */   
/*    */   public short getType() {
/* 30 */     return DBType.UPDATE;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\db\message\DBModifyMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */