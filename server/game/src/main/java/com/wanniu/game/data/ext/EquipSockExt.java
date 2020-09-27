/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.game.data.EquipSockCO;
/*    */ import java.util.Arrays;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EquipSockExt
/*    */   extends EquipSockCO
/*    */ {
/*    */   public Map<Integer, Integer> sockOpenLevel;
/*    */   public List<String> typeList;
/*    */   
/*    */   public void initProperty() {
/* 23 */     this.sockOpenLevel = new HashMap<>();
/* 24 */     this.sockOpenLevel.put(Integer.valueOf(1), Integer.valueOf(this.sock1OpenLvl));
/* 25 */     this.sockOpenLevel.put(Integer.valueOf(2), Integer.valueOf(this.sock2OpenLvl));
/* 26 */     this.sockOpenLevel.put(Integer.valueOf(3), Integer.valueOf(this.sock3OpenLvl));
/* 27 */     this.sockOpenLevel.put(Integer.valueOf(4), Integer.valueOf(this.sock4OpenLvl));
/* 28 */     this.sockOpenLevel.put(Integer.valueOf(5), Integer.valueOf(this.sock5OpenLvl));
/*    */     
/* 30 */     this.typeList = Arrays.asList(this.gemTypeList.split(","));
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\EquipSockExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */