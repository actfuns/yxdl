/*    */ package com.wanniu.game.item;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum VirtualItemType
/*    */ {
/* 22 */   GOLD("gold", "银两"),
/* 23 */   DIAMOND("diamond", "元宝"),
/* 24 */   CASH("cash", "绑元"),
/* 25 */   EXP("exp", "经验"),
/* 26 */   UPEXP("upexp", "修为"),
/* 27 */   SP("sp", "技能点"),
/* 28 */   PRESTIGE("prestige", "声望"),
/* 29 */   RINGPRES("ringpres", "魔界威望"),
/* 30 */   REMAIN("remain", "计数道具"),
/* 31 */   FRIENDLY("friendly", "友情点"),
/* 32 */   ACHIPOINT("achipoint", "成就点数"),
/* 33 */   SOLOPOINT("solopoint", "单挑积分"),
/* 34 */   GUILDPOINT("guildpoint", "仙盟副本积分"),
/* 35 */   CONSUMEPOINT("consumepoint", "商城积分"),
/* 36 */   WINGEXP("wingexp", "灵气"),
/* 37 */   TREASURESPOINT("treasurespoint", "君王宝藏积分"),
/* 38 */   PEQUIP("pequip", "紫色装备"),
/* 39 */   OEQUIP("oequip", "橙色装备"),
/* 40 */   GEMS("gems", "宝石"),
/* 41 */   VEXP("vexp", "大量经验"),
/* 42 */   FATE("fate", "轩辕值");
/*    */   
/*    */   private final String itemcode;
/*    */   private final String desc;
/*    */   
/*    */   VirtualItemType(String itemcode, String desc) {
/* 48 */     this.itemcode = itemcode;
/* 49 */     this.desc = desc;
/*    */   }
/*    */   
/*    */   public String getItemcode() {
/* 53 */     return this.itemcode;
/*    */   }
/*    */   
/*    */   public String getDesc() {
/* 57 */     return this.desc;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\item\VirtualItemType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */