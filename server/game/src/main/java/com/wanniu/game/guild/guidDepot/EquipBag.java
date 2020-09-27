/*     */ package com.wanniu.game.guild.guidDepot;
/*     */ 
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.item.po.PlayerItemPO;
/*     */ import com.wanniu.game.poes.PlayerBasePO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import pomelo.guild.GuildManagerHandler;
/*     */ import pomelo.item.ItemOuterClass;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EquipBag
/*     */ {
/*     */   public int bagGridCount;
/*     */   public Map<Integer, NormalItem> bagGrids;
/*     */   public int usedGridCount;
/*     */   public int bagTotalCount;
/*     */   
/*     */   public EquipBag(GuildBagItem bagItem) {
/*  23 */     _init(bagItem);
/*     */   }
/*     */   
/*     */   public void _init(GuildBagItem bagData) {
/*  27 */     this.bagGridCount = bagData.bagGridCount;
/*  28 */     this.bagGrids = new HashMap<>();
/*  29 */     this.usedGridCount = 0;
/*     */     
/*  31 */     Map<Integer, PlayerItemPO> grids = bagData.bagGrids;
/*  32 */     for (Integer key : grids.keySet()) {
/*  33 */       NormalItem item = ItemUtil.createItemByDbOpts(grids.get(key));
/*  34 */       if (item != null) {
/*  35 */         this.bagGrids.put(key, item);
/*  36 */         this.usedGridCount++;
/*     */       } 
/*     */     } 
/*     */     
/*  40 */     this.bagTotalCount = bagData.bagTotalCount;
/*     */   }
/*     */   
/*     */   public GuildBagItem toJson4Serialize() {
/*  44 */     GuildBagItem data = new GuildBagItem();
/*     */     
/*  46 */     for (int index = 1; index <= this.bagGridCount; index++) {
/*  47 */       NormalItem item = getItem(index);
/*  48 */       if (item != null) {
/*  49 */         data.bagGrids.put(Integer.valueOf(index), item.cloneItemDB());
/*     */       }
/*     */     } 
/*     */     
/*  53 */     data.bagGridCount = this.bagGridCount;
/*  54 */     data.bagTotalCount = this.bagTotalCount;
/*  55 */     return data;
/*     */   }
/*     */   
/*     */   public GuildManagerHandler.BagGridsInfo toJson4Payload() {
/*  59 */     GuildManagerHandler.BagGridsInfo.Builder data = GuildManagerHandler.BagGridsInfo.newBuilder();
/*  60 */     data.addAllBagGrids(getGrids4PayLoad());
/*  61 */     data.setBagGridCount(this.bagGridCount);
/*  62 */     data.setBagTotalCount(this.bagTotalCount);
/*  63 */     return data.build();
/*     */   }
/*     */   
/*     */   public NormalItem getItem(int index) {
/*  67 */     return this.bagGrids.get(Integer.valueOf(index));
/*     */   }
/*     */   
/*     */   public void _addUsedGridCount(int num) {
/*  71 */     if (num != 0) {
/*  72 */       this.usedGridCount += num;
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean openGrid(int num) {
/*  77 */     if (num <= 0) {
/*  78 */       return false;
/*     */     }
/*  80 */     if (num + this.bagGridCount > this.bagTotalCount) {
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     this.bagGridCount += num;
/*  85 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList<ItemOuterClass.Grid> getGrids4PayLoad() {
/*  90 */     ArrayList<ItemOuterClass.Grid> data = new ArrayList<>();
/*  91 */     for (int index = 1; index <= this.bagGridCount; index++) {
/*  92 */       NormalItem item = getItem(index);
/*  93 */       if (item != null) {
/*  94 */         data.add(getGrid4PayLoad(index));
/*     */       }
/*     */     } 
/*  97 */     return data;
/*     */   }
/*     */   
/*     */   public ItemOuterClass.Grid getGrid4PayLoad(int index) {
/* 101 */     ItemOuterClass.Grid.Builder grid = ItemOuterClass.Grid.newBuilder();
/* 102 */     grid.setGridIndex(index);
/* 103 */     NormalItem item = getItem(index);
/* 104 */     if (null != item) {
/* 105 */       grid.setItem(item.toJSON4GridPayload());
/*     */     }
/*     */     
/* 108 */     return grid.build();
/*     */   }
/*     */   
/*     */   public ArrayList<ItemOuterClass.ItemDetail> getAllEquipDetails4PayLoad(PlayerBasePO basePO) {
/* 112 */     ArrayList<ItemOuterClass.ItemDetail> data = new ArrayList<>();
/* 113 */     for (int index = 1; index <= this.bagGridCount; index++) {
/* 114 */       NormalItem item = getItem(index);
/* 115 */       if (item != null) {
/* 116 */         data.add(item.getItemDetail(basePO).build());
/*     */       }
/*     */     } 
/* 119 */     return data;
/*     */   }
/*     */   
/*     */   public GuildDepotOneGrid getGridAndDetailByIndex(PlayerBasePO basePO, int index) {
/* 123 */     GuildDepotOneGrid data = new GuildDepotOneGrid();
/* 124 */     ItemOuterClass.Grid.Builder grid = ItemOuterClass.Grid.newBuilder();
/* 125 */     grid.setGridIndex(index);
/* 126 */     NormalItem item = getItem(index);
/* 127 */     if (null != item) {
/* 128 */       grid.setItem(item.toJSON4GridPayload());
/* 129 */       data.detail = item.getItemDetail(basePO).build();
/*     */     } 
/*     */     
/* 132 */     return data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int emptyGridNum() {
/* 141 */     return this.bagGridCount - this.usedGridCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<Integer> findEmptyGrids(int num) {
/* 151 */     ArrayList<Integer> emptyIndex = new ArrayList<>();
/* 152 */     for (int i = 1; i <= this.bagGridCount; i++) {
/* 153 */       NormalItem item = this.bagGrids.get(Integer.valueOf(i));
/* 154 */       if (item == null) {
/* 155 */         emptyIndex.add(Integer.valueOf(i));
/*     */       }
/*     */       
/* 158 */       if (emptyIndex.size() == num) {
/*     */         break;
/*     */       }
/*     */     } 
/* 162 */     return emptyIndex;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean testEmptyGridLarge(int num) {
/* 172 */     if (emptyGridNum() >= num) {
/* 173 */       return true;
/*     */     }
/* 175 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int addItem(NormalItem item) {
/* 186 */     if (item == null) {
/* 187 */       return 0;
/*     */     }
/*     */     
/* 190 */     if (emptyGridNum() == 0) {
/* 191 */       return 0;
/*     */     }
/*     */     
/* 194 */     ArrayList<Integer> emptyIndexs = findEmptyGrids(1);
/* 195 */     if (emptyIndexs.size() <= 0) {
/* 196 */       return 0;
/*     */     }
/* 198 */     return addItemToPos(((Integer)emptyIndexs.get(0)).intValue(), item);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int addItemToPos(int gridIndex, NormalItem item) {
/* 208 */     if (item != null) {
/* 209 */       NormalItem oldItem = getItem(gridIndex);
/* 210 */       if (oldItem == null) {
/* 211 */         this.bagGrids.put(Integer.valueOf(gridIndex), item);
/* 212 */         _addUsedGridCount(1);
/* 213 */         return gridIndex;
/*     */       } 
/*     */     } 
/* 216 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int addItemByData(PlayerItemPO data) {
/* 225 */     NormalItem item = ItemUtil.createItemByDbOpts(data);
/* 226 */     if (item == null) {
/* 227 */       return 0;
/*     */     }
/* 229 */     return addItem(item);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int addItemByPosData(int gridIndex, PlayerItemPO data) {
/* 239 */     NormalItem item = ItemUtil.createItemByDbOpts(data);
/* 240 */     if (item == null || gridIndex < 0) {
/* 241 */       return 0;
/*     */     }
/* 243 */     return addItemToPos(gridIndex, item);
/*     */   }
/*     */   
/*     */   public void _delete(int pos) {
/* 247 */     this.bagGrids.remove(Integer.valueOf(pos));
/* 248 */     _addUsedGridCount(-1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int removeItemByPos(int pos) {
/* 255 */     NormalItem item = getItem(pos);
/* 256 */     if (item != null) {
/* 257 */       _delete(pos);
/* 258 */       return pos;
/*     */     } 
/* 260 */     return 0;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guidDepot\EquipBag.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */