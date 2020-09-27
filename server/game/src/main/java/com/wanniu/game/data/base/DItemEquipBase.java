/*    */ package com.wanniu.game.data.base;
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
/*    */ public class DItemEquipBase
/*    */ {
/*    */   public String name;
/*    */   public String type;
/*    */   public String code;
/*    */   public String desc;
/*    */   public int price;
/*    */   public int salePrice;
/*    */   public int levelReq;
/*    */   public int qcolor;
/*    */   public String icon;
/*    */   public int groupCount;
/*    */   public int purchaseCount;
/*    */   public String pro;
/*    */   public int noDestory;
/*    */   public int noSell;
/*    */   public int noTrade;
/*    */   public int noAuction;
/*    */   public int noDepotRole;
/*    */   public int noDepotAcc;
/*    */   public int noDepotGuild;
/*    */   public String showId;
/*    */   public String avatarId;
/*    */   public int star;
/*    */   public int bindType;
/*    */   public int itemType;
/*    */   public int itemSecondType;
/*    */   public int itemTypeId;
/*    */   public int Pro;
/*    */   
/*    */   public DItemEquipBase copy() {
/* 67 */     DItemEquipBase base = new DItemEquipBase();
/* 68 */     base.name = this.name;
/* 69 */     base.type = this.type;
/* 70 */     base.code = this.code;
/* 71 */     base.desc = this.desc;
/* 72 */     base.price = this.price;
/* 73 */     base.salePrice = this.salePrice;
/* 74 */     base.levelReq = this.levelReq;
/* 75 */     base.qcolor = this.qcolor;
/* 76 */     base.icon = this.icon;
/* 77 */     base.groupCount = this.groupCount;
/* 78 */     base.purchaseCount = this.purchaseCount;
/* 79 */     base.pro = this.pro;
/* 80 */     base.noDestory = this.noDestory;
/* 81 */     base.noSell = this.noSell;
/* 82 */     base.noTrade = this.noTrade;
/* 83 */     base.noAuction = this.noAuction;
/* 84 */     base.noDepotRole = this.noDepotRole;
/* 85 */     base.noDepotAcc = this.noDepotAcc;
/* 86 */     base.noDepotGuild = this.noDepotGuild;
/* 87 */     base.showId = this.showId;
/* 88 */     base.avatarId = this.avatarId;
/* 89 */     base.star = this.star;
/* 90 */     base.bindType = this.bindType;
/*    */     
/* 92 */     base.itemType = this.itemType;
/* 93 */     base.itemSecondType = this.itemSecondType;
/* 94 */     base.itemTypeId = this.itemTypeId;
/* 95 */     base.Pro = this.Pro;
/*    */     
/* 97 */     return base;
/*    */   }
/*    */   
/*    */   public void beforeProperty() {}
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\base\DItemEquipBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */