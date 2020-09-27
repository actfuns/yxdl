/*     */ package com.wanniu.game.item;
/*     */ 
/*     */ import Xmds.FinishPickItem;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.blood.BloodManager;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.data.base.DItemBase;
/*     */ import com.wanniu.game.data.base.DItemEquipBase;
/*     */ import com.wanniu.game.item.data.ItemToBtlServerData;
/*     */ import com.wanniu.game.item.po.PlayerItemPO;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.poes.ConsignmentItemsPO;
/*     */ import com.wanniu.game.poes.PlayerBasePO;
/*     */ import java.util.Collection;
/*     */ import java.util.UUID;
/*     */ import pomelo.area.BattleHandler;
/*     */ import pomelo.item.ItemOuterClass;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NormalItem
/*     */ {
/*     */   public PlayerItemPO itemDb;
/*     */   public DItemEquipBase prop;
/*     */   private Object lock;
/*     */   
/*     */   public NormalItem(PlayerItemPO itemDb, DItemEquipBase prop) {
/* 104 */     this.lock = new Object(); this.itemDb = itemDb; this.prop = prop;
/*     */   }
/*     */   public String itemCode() { return this.prop.code; }
/* 107 */   public ItemOuterClass.Item.Builder getView() { ItemOuterClass.Item.Builder item = ItemOuterClass.Item.newBuilder(); item.setId(this.itemDb.id); return item; } public final DItemEquipBase getTemplate() { return this.prop; } public String getId() { return this.itemDb.id; } public boolean addGroupNum(int num) { synchronized (this.lock)
/* 108 */     { if (this.itemDb.groupCount + num <= this.prop.groupCount) {
/* 109 */         this.itemDb.groupCount += num;
/* 110 */         return true;
/*     */       } 
/* 112 */       return false; }  }
/*     */   public void old() { this.itemDb.isNew = 0; this.itemDb.gotTime = DateUtil.getZeroDate(); }
/*     */   public String getName() { return this.prop.name; }
/*     */   public int getNum() { if (isVirtual()) return getWorth();  return this.itemDb.groupCount; }
/*     */   public void setNum(int num) { synchronized (this.lock) { this.itemDb.groupCount = num; }  }
/* 117 */   public boolean isFullGroup() { if (this.itemDb.groupCount >= this.prop.groupCount) return true;  return false; } public boolean addGroup(NormalItem item) { if (isFullGroup()) {
/* 118 */       return false;
/*     */     }
/* 120 */     int result = item.itemDb.groupCount + this.itemDb.groupCount;
/* 121 */     if (result > this.prop.groupCount) {
/* 122 */       return false;
/*     */     }
/* 124 */     synchronized (this.lock) {
/* 125 */       this.itemDb.groupCount = result;
/*     */     } 
/* 127 */     return true; }
/*     */ 
/*     */   
/*     */   public void setGroup(int num) {
/* 131 */     if (num > this.prop.groupCount) {
/* 132 */       num = this.prop.groupCount;
/*     */     }
/* 134 */     synchronized (this.lock) {
/* 135 */       this.itemDb.groupCount = num;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean deleteGroup(int num) {
/* 140 */     if (num > this.itemDb.groupCount) {
/* 141 */       return false;
/*     */     }
/* 143 */     synchronized (this.lock) {
/* 144 */       this.itemDb.groupCount -= num;
/*     */     } 
/* 146 */     return true;
/*     */   }
/*     */   
/*     */   public int leftGroup() {
/* 150 */     return this.prop.groupCount - this.itemDb.groupCount;
/*     */   }
/*     */   
/*     */   public boolean isInvalid() {
/* 154 */     if (this.itemDb.groupCount <= 0) {
/* 155 */       return true;
/*     */     }
/* 157 */     return false;
/*     */   }
/*     */   
/*     */   public boolean setCD() {
/* 161 */     DItemBase itemProp = (DItemBase)this.prop;
/* 162 */     if (itemProp.useCD > 0) {
/* 163 */       this.itemDb.cdTime = System.currentTimeMillis() + itemProp.useCD;
/* 164 */       return true;
/*     */     } 
/* 166 */     return false;
/*     */   }
/*     */   
/*     */   public long getCD() {
/* 170 */     return this.itemDb.cdTime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBind() {
/* 179 */     if (this.itemDb.isBindFilter == -1) {
/* 180 */       return this.itemDb.isBind;
/*     */     }
/*     */     
/* 183 */     return this.itemDb.isBindFilter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBind(int bind) {
/* 194 */     this.itemDb.isBind = bind;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBindFilter(int bind) {
/* 215 */     this.itemDb.isBindFilter = bind;
/*     */   }
/*     */   
/*     */   public boolean isBinding() {
/* 219 */     if (this.itemDb.isBindFilter == -1) {
/* 220 */       if (this.itemDb.isBind == 1) {
/* 221 */         return true;
/*     */       }
/* 223 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 227 */     return (this.itemDb.isBindFilter == 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNoAuction(int noAuction) {
/* 235 */     this.itemDb.noAuctionFilter = noAuction;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canTrade() {
/* 244 */     return (this.prop.noTrade == 0 && this.itemDb.isBind != 1);
/*     */   }
/*     */   
/*     */   public boolean canAuction() {
/* 248 */     if (this.itemDb.isBindFilter == -1) {
/* 249 */       return (this.prop.noAuction == 0 && this.itemDb.noAuction != 1);
/*     */     }
/* 251 */     return (this.itemDb.noAuctionFilter != 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canDepotRole() {
/* 256 */     return (this.prop.noDepotRole == 0);
/*     */   }
/*     */   
/*     */   public boolean canDepotAcc() {
/* 260 */     return (this.prop.noDepotAcc == 0 && this.itemDb.isBind != 1);
/*     */   }
/*     */   
/*     */   public boolean canDepotGuild() {
/* 264 */     return (this.prop.noDepotGuild == 0 && this.itemDb.isBind != 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isVirtual() {
/* 271 */     return (ItemConfig.getInstance().getSecondType(this.prop.type) == Const.ItemSecondType.virtual.getValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isVirtQuest() {
/* 278 */     return false;
/*     */   }
/*     */   
/*     */   public int getLevel() {
/* 282 */     return this.prop.levelReq;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getUpLevel() {
/* 287 */     return 0;
/*     */   }
/*     */   
/*     */   public int getQLevel() {
/* 291 */     return this.prop.qcolor;
/*     */   }
/*     */   
/*     */   public boolean isEquip() {
/* 295 */     return ItemUtil.isEquipByItemType(this.prop.itemType);
/*     */   }
/*     */   
/*     */   public boolean isBlood() {
/* 299 */     if (this.prop.itemSecondType != Const.ItemSecondType.virtQuest.getValue())
/*     */     {
/* 301 */       return false;
/*     */     }
/* 303 */     if (BloodManager.itemFilter.contains(itemCode()))
/*     */     {
/* 305 */       return false;
/*     */     }
/* 307 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canSell() {
/* 316 */     return (this.prop.noSell == 0);
/*     */   }
/*     */   
/*     */   public int price() {
/* 320 */     return this.prop.price;
/*     */   }
/*     */   
/*     */   public int getScore() {
/* 324 */     return 0;
/*     */   }
/*     */   
/*     */   public int getPrice() {
/* 328 */     return this.prop.price;
/*     */   }
/*     */   
/*     */   public boolean canUse() {
/* 332 */     if (((DItemBase)this.prop).isApply == 1) {
/* 333 */       return true;
/*     */     }
/* 335 */     return false;
/*     */   }
/*     */   
/*     */   public int getWorth() {
/* 339 */     return this.itemDb.speData.worth;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCD() {
/* 348 */     if (this.itemDb.cdTime < GWorld.APP_TIME) {
/* 349 */       return false;
/*     */     }
/* 351 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemOuterClass.ItemDetail.Builder getItemDetail(PlayerBasePO basePO) {
/* 356 */     ItemOuterClass.ItemDetail.Builder data = ItemOuterClass.ItemDetail.newBuilder();
/* 357 */     data.setId(getId());
/* 358 */     data.setCode(this.itemDb.code);
/* 359 */     data.setBindType(getBind());
/* 360 */     data.setCanTrade(canTrade() ? 1 : 0);
/* 361 */     data.setCanAuction((canAuction() && getBind() != 1) ? 1 : 0);
/* 362 */     data.setCanDepotRole(canDepotRole() ? 1 : 0);
/* 363 */     data.setCanDepotGuild(canDepotGuild() ? 1 : 0);
/* 364 */     return data;
/*     */   }
/*     */   
/*     */   public PlayerItemPO cloneItemDB() {
/* 368 */     return (PlayerItemPO)Utils.clone(this.itemDb);
/*     */   }
/*     */   
/*     */   public ItemOuterClass.Item.Builder toJSON4GridPayload() {
/* 372 */     ItemOuterClass.Item.Builder data = ItemOuterClass.Item.newBuilder();
/* 373 */     data.setId(getId());
/* 374 */     data.setCode(this.itemDb.code);
/* 375 */     data.setItemType((ItemConfig.getInstance().getTypeConfig(this.prop.type)).iD);
/* 376 */     data.setItemSecondType((ItemConfig.getInstance().getIdConfig(this.prop.type)).typeID);
/* 377 */     data.setGroupCount(this.itemDb.groupCount);
/* 378 */     data.setMaxGroupCount(this.prop.groupCount);
/* 379 */     data.setIsNew(this.itemDb.isNew);
/* 380 */     data.setIcon(this.prop.icon);
/* 381 */     data.setQColor(this.prop.qcolor);
/* 382 */     data.setBindType(this.itemDb.isBind);
/*     */ 
/*     */     
/* 385 */     data.setStar(0);
/* 386 */     data.setCdTime(String.valueOf(getCD()));
/* 387 */     return data;
/*     */   }
/*     */   
/*     */   public final ItemToBtlServerData toJSON4BatterServer(Collection<String> belongPlayerIds, Const.TEAM_DISTRIBUTE_TYPE distributeType, boolean isPlayerDead) {
/* 391 */     ItemToBtlServerData data = new ItemToBtlServerData();
/* 392 */     data.id = getId();
/* 393 */     data.name = this.prop.name;
/* 394 */     data.showId = this.prop.showId;
/* 395 */     data.groupCount = this.itemDb.groupCount;
/* 396 */     data.qColor = this.prop.qcolor;
/* 397 */     data.itemTypeId = this.prop.itemTypeId;
/* 398 */     data.IconName = this.prop.icon;
/* 399 */     data.freezeTime = GlobalConfig.itemdrop_lock_freezeTime;
/* 400 */     data.protectTime = GlobalConfig.itemdrop_lock_protectTime;
/* 401 */     data.lifeTime = GlobalConfig.itemdrop_lock_lifeTime;
/*     */     
/* 403 */     data.PlayerUUID = belongPlayerIds;
/* 404 */     data.distributeType = distributeType.value;
/* 405 */     if (!isPlayerDead && 
/* 406 */       !isBinding() && 
/* 407 */       GlobalConfig.getBindByQcolor(this.prop.qcolor) > 0) {
/* 408 */       setBind(1);
/*     */     }
/*     */ 
/*     */     
/* 412 */     return data;
/*     */   }
/*     */   
/*     */   public final BattleHandler.ItemDrop.Builder toProto4Client() {
/* 416 */     BattleHandler.ItemDrop.Builder data = BattleHandler.ItemDrop.newBuilder();
/* 417 */     data.setId(getId());
/* 418 */     data.setName(this.prop.name);
/* 419 */     data.setShowId(this.prop.showId);
/* 420 */     data.setGroupCount(this.itemDb.groupCount);
/* 421 */     data.setQColor(this.prop.qcolor);
/* 422 */     data.setItemTypeId(this.prop.itemTypeId);
/* 423 */     data.setIconName(this.prop.icon);
/* 424 */     data.setFreezeTime(GlobalConfig.itemdrop_lock_freezeTime);
/* 425 */     data.setProtectTime(GlobalConfig.itemdrop_lock_protectTime);
/* 426 */     data.setLifeTime(GlobalConfig.itemdrop_lock_lifeTime);
/*     */     
/* 428 */     if (!isBinding() && GlobalConfig.getBindByQcolor(this.prop.qcolor) > 0) {
/* 429 */       setBind(1);
/*     */     }
/* 431 */     return data;
/*     */   }
/*     */   
/*     */   public FinishPickItem toJSON4PickItemBatterServer() {
/* 435 */     FinishPickItem data = new FinishPickItem();
/* 436 */     data.itemIcon = this.prop.icon;
/* 437 */     data.quality = this.prop.qcolor;
/* 438 */     data.num = this.itemDb.groupCount;
/* 439 */     return data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ConsignmentItemsPO toJSON4ConsignmentLine(int salePrice, String playerName, int pro, String playerId, int effectiveTime, int num, int lateMinutes) {
/* 446 */     ConsignmentItemsPO data = new ConsignmentItemsPO();
/* 447 */     if (this.prop.groupCount != 1) {
/* 448 */       data.id = UUID.randomUUID().toString();
/* 449 */       Out.debug(new Object[] { "toJSON4ConsignmentLine generate id  source id:", this.itemDb.id, "targetId:", data.id });
/*     */     } else {
/* 451 */       data.id = this.itemDb.id;
/*     */     } 
/*     */ 
/*     */     
/* 455 */     data.itemType = this.prop.itemType;
/* 456 */     data.itemSecondType = this.prop.itemSecondType;
/* 457 */     data.pro = this.prop.Pro;
/* 458 */     data.level = getLevel() + getUpLevel() * 1000;
/* 459 */     data.consignmentPrice = salePrice;
/* 460 */     data.consignmentTime = System.currentTimeMillis() + effectiveTime + (lateMinutes * Const.Time.Minute.getValue());
/* 461 */     data.lateMinutes = lateMinutes;
/* 462 */     data.consignmentPlayerName = playerName;
/* 463 */     data.consignmentPlayerPro = pro;
/* 464 */     data.consignmentPlayerId = playerId;
/* 465 */     data.groupCount = num;
/*     */ 
/*     */ 
/*     */     
/* 469 */     data.db = cloneItemDB();
/* 470 */     data.db.id = data.id;
/* 471 */     data.db.groupCount = num;
/*     */     
/* 473 */     return data;
/*     */   }
/*     */   
/*     */   public ItemOuterClass.MiniItem toJSON4MiniItem() {
/* 477 */     ItemOuterClass.MiniItem.Builder data = ItemOuterClass.MiniItem.newBuilder();
/* 478 */     data.setCode(this.prop.code);
/* 479 */     data.setGroupCount(this.itemDb.groupCount);
/* 480 */     data.setIcon(this.prop.icon);
/* 481 */     data.setQColor(this.prop.qcolor);
/* 482 */     data.setName(this.prop.name);
/* 483 */     data.setStar(this.prop.star);
/* 484 */     data.setBindType(getBind());
/* 485 */     return data.build();
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\item\NormalItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */