/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBTable;
/*    */ import com.wanniu.game.common.Const;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @DBTable("player_mount")
/*    */ public class MountPO
/*    */   extends GEntity
/*    */ {
/*    */   public int starLv;
/*    */   public int rideLevel;
/* 19 */   public int usingSkinId = 0;
/*    */   
/*    */   public List<Integer> mountSkins;
/*    */   
/*    */   public int fightPower;
/*    */   
/* 25 */   public int rideFlag = Const.MOUNT_RIDING_STATE.off.getValue();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean firstChoose;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public MountPO() {
/* 37 */     this.firstChoose = false;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\MountPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */