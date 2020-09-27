/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBTable;
/*    */ import com.wanniu.game.player.GlobalConfig;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @DBTable("player_hookset")
/*    */ public class HookSetPO
/*    */   extends GEntity
/*    */ {
/*    */   public int hpPercent;
/*    */   public int mpPercent;
/*    */   public String hpItemCode;
/*    */   public String mpItemCode;
/*    */   public int pkSet;
/*    */   public List<Integer> meltQcolor;
/*    */   public int autoBuyHpItem;
/*    */   public int autoBuyMpItem;
/*    */   public int fieldMaphook;
/*    */   public int areaMaphook;
/*    */   
/*    */   public HookSetPO() {}
/*    */   
/*    */   public HookSetPO(String playerId) {
/* 31 */     this.hpPercent = GlobalConfig.Auto_HP_Percent;
/* 32 */     this.hpItemCode = GlobalConfig.Auto_HP_Item;
/* 33 */     this.pkSet = GlobalConfig.Auto_PK_Reaction;
/* 34 */     this.meltQcolor = new ArrayList<>();
/* 35 */     this.meltQcolor.add(Integer.valueOf(GlobalConfig.Auto_Eqip_Qcolor));
/* 36 */     this.autoBuyHpItem = 1;
/* 37 */     this.fieldMaphook = 0;
/* 38 */     this.areaMaphook = 0;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\HookSetPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */