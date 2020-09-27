/*      */ package com.wanniu.game.bag;
/*      */ 
/*      */ import com.google.protobuf.GeneratedMessage;
/*      */ import com.wanniu.core.game.LangService;
/*      */ import com.wanniu.core.logfs.Out;
/*      */ import com.wanniu.core.util.RandomUtil;
/*      */ import com.wanniu.game.GWorld;
/*      */ import com.wanniu.game.common.Const;
/*      */ import com.wanniu.game.common.CurrencyData;
/*      */ import com.wanniu.game.common.msg.MessageUtil;
/*      */ import com.wanniu.game.common.msg.WNNotifyManager;
/*      */ import com.wanniu.game.data.GameData;
/*      */ import com.wanniu.game.data.base.DItemBase;
/*      */ import com.wanniu.game.data.base.DItemEquipBase;
/*      */ import com.wanniu.game.equip.NormalEquip;
/*      */ import com.wanniu.game.item.ItemConfig;
/*      */ import com.wanniu.game.item.ItemUtil;
/*      */ import com.wanniu.game.item.NormalItem;
/*      */ import com.wanniu.game.item.po.DetailItemNum;
/*      */ import com.wanniu.game.item.po.PlayerItemPO;
/*      */ import com.wanniu.game.mail.MailUtil;
/*      */ import com.wanniu.game.mail.data.MailData;
/*      */ import com.wanniu.game.mail.data.MailSysData;
/*      */ import com.wanniu.game.player.GlobalConfig;
/*      */ import com.wanniu.game.player.PlayerUtil;
/*      */ import com.wanniu.game.player.WNPlayer;
/*      */ import com.wanniu.game.player.bi.LogReportService;
/*      */ import com.wanniu.game.poes.BagsPO;
/*      */ import com.wanniu.game.task.TaskEvent;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.Comparator;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.ConcurrentHashMap;
/*      */ import pomelo.area.BagHandler;
/*      */ import pomelo.item.ItemOuterClass;
/*      */ import pomelo.player.PlayerOuterClass;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class WNBag
/*      */ {
/*      */   private WNPlayer player;
/*      */   public BagsPO bags;
/*      */   public BagPO bagPO;
/*      */   public Map<Integer, NormalItem> bagGrids;
/*      */   public int usedGridCount;
/*      */   private int bagTotalCount;
/*      */   private Const.BAG_TYPE type;
/*      */   
/*      */   public static class TradeMessageItemData
/*      */   {
/*      */     public String name;
/*      */     public int qt;
/*      */     public int num;
/*      */   }
/*   71 */   private ItemConfig itemManager = ItemConfig.getInstance();
/*   72 */   public long bagGridPackUpTime = 0L;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected WNBag() {}
/*      */ 
/*      */ 
/*      */   
/*      */   public WNBag(WNPlayer player, Const.BAG_TYPE type, BagPO bagPO, BagsPO bags) {
/*   82 */     this.player = player;
/*   83 */     this.type = type;
/*   84 */     this.bags = bags;
/*      */     
/*   86 */     _init(bagPO);
/*      */   }
/*      */   
/*      */   private void _init(BagPO bagPO) {
/*   90 */     this.bagPO = bagPO;
/*   91 */     this.bagGrids = new ConcurrentHashMap<>();
/*   92 */     this.usedGridCount = 0;
/*      */ 
/*      */     
/*   95 */     if (GWorld.DEBUG) {
/*   96 */       Iterator<Integer> iter = bagPO.bagGrids.keySet().iterator();
/*   97 */       while (iter.hasNext()) {
/*   98 */         int index = ((Integer)iter.next()).intValue();
/*   99 */         if (ItemConfig.getInstance().getItemProp(((PlayerItemPO)bagPO.bagGrids.get(Integer.valueOf(index))).code) == null) {
/*  100 */           iter.remove();
/*      */         }
/*      */       } 
/*      */     } 
/*  104 */     for (Integer index : bagPO.bagGrids.keySet()) {
/*  105 */       NormalItem item = ItemUtil.createItemByDbOpts(bagPO.bagGrids.get(index));
/*  106 */       if (item != null) {
/*  107 */         this.bagGrids.put(index, item);
/*  108 */         this.usedGridCount++;
/*      */       } 
/*      */     } 
/*  111 */     this.bagTotalCount = BagUtil.getTotalCount(this.type);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NormalItem getGridItemCode(int gridNndex) {
/*  118 */     return this.bagGrids.get(Integer.valueOf(gridNndex));
/*      */   }
/*      */   
/*      */   public void setBagGrid(int gridIndex, NormalItem item) {
/*  122 */     this.bagGrids.put(Integer.valueOf(gridIndex), item);
/*      */   }
/*      */   
/*      */   public void addBagGrid(int gridIndex, NormalItem item) {
/*  126 */     this.bagGrids.put(Integer.valueOf(gridIndex), item);
/*      */   }
/*      */   
/*      */   public NormalItem getItem(int gridIndex) {
/*  130 */     return this.bagGrids.get(Integer.valueOf(gridIndex));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NormalItem randomGetItem() {
/*  142 */     List<Integer> emptyIndex = new ArrayList<>();
/*      */     
/*  144 */     for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
/*  145 */       NormalItem item = this.bagGrids.get(Integer.valueOf(i));
/*  146 */       if (item != null && !item.isBinding() && 
/*  147 */         GameData.PKLostBagItemTypes.containsKey(item.itemCode())) {
/*  148 */         emptyIndex.add(Integer.valueOf(i));
/*      */       }
/*      */     } 
/*      */     
/*  152 */     if (emptyIndex.size() > 0) {
/*  153 */       int emptyPos = RandomUtil.getInt(0, emptyIndex.size() - 1);
/*  154 */       int randomPos = ((Integer)emptyIndex.get(emptyPos)).intValue();
/*  155 */       int randGoldPercent = RandomUtil.getInt(GlobalConfig.PK_DropGoldMin, GlobalConfig.PK_DropGoldMax);
/*  156 */       return discardItemByPosPerent(randomPos, randGoldPercent, Const.GOODS_CHANGE_TYPE.hitUser);
/*      */     } 
/*  158 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object[] randomGetItem(Set<String> codes, int maxReduceCount) {
/*  167 */     if (this.bagPO.bagGridCount < 1) {
/*  168 */       return null;
/*      */     }
/*  170 */     Object[] obj = null;
/*  171 */     List<NormalItem> l = getNormalItemOrder(codes, this.bagPO.bagGridCount);
/*  172 */     if (l != null && !l.isEmpty()) {
/*  173 */       NormalItem dpItem = l.get(0);
/*  174 */       int groupCount = dpItem.itemDb.groupCount;
/*  175 */       int min = Math.min(maxReduceCount, groupCount);
/*  176 */       int trueCount = RandomUtil.getInt(min);
/*  177 */       if (discardItem(dpItem.itemDb.code, trueCount, Const.GOODS_CHANGE_TYPE.hitUser)) {
/*  178 */         obj = new Object[2];
/*  179 */         obj[0] = dpItem.itemDb.code;
/*  180 */         obj[1] = Integer.valueOf(trueCount);
/*      */       } 
/*      */     } 
/*  183 */     return obj;
/*      */   }
/*      */   
/*      */   private List<NormalItem> getNormalItemOrder(Set<String> codes, int count) {
/*  187 */     List<NormalItem> list = new ArrayList<>();
/*  188 */     for (int i = 1; i <= count; i++) {
/*  189 */       NormalItem item = this.bagGrids.get(Integer.valueOf(i));
/*  190 */       if (item != null && codes.contains(item.prop.code)) {
/*  191 */         list.add(item);
/*      */       }
/*      */     } 
/*  194 */     if (list.size() > 1) {
/*  195 */       Collections.shuffle(list);
/*      */     }
/*  197 */     return list;
/*      */   }
/*      */   
/*      */   public PlayerOuterClass.Store toJson4Payload() {
/*  201 */     PlayerOuterClass.Store.Builder data = PlayerOuterClass.Store.newBuilder();
/*  202 */     data.addAllBagGrids(getGrids4PayLoad());
/*  203 */     data.setBagGridCount(this.bagPO.bagGridCount);
/*  204 */     data.setBagTotalCount(this.bagTotalCount);
/*  205 */     data.setType(this.type.getValue());
/*  206 */     data.setGridPrice(BagUtil.getGridPrice(this.type));
/*  207 */     return data.build();
/*      */   }
/*      */   
/*      */   public void _addUsedGridCount(int num) {
/*  211 */     if (num != 0) {
/*  212 */       this.usedGridCount += num;
/*  213 */       _gridNumChangePush();
/*      */     } 
/*      */   }
/*      */   
/*      */   public void _gridNumChangePush() {
/*  218 */     _gridNumChangePush(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void _gridNumChangePush(boolean force) {
/*  225 */     if (this.type == Const.BAG_TYPE.BAG) {
/*  226 */       int emptyNum = emptyGridNum();
/*  227 */       if (emptyNum <= 3 || force) {
/*  228 */         this.player.refreshPlayerRemainBagCountData(emptyNum);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean openGrid(int num) {
/*  241 */     if (num + this.bagPO.bagGridCount > this.bagTotalCount) {
/*  242 */       return false;
/*      */     }
/*      */ 
/*      */     
/*  246 */     int oldGridCount = this.bagPO.bagGridCount;
/*  247 */     this.bagPO.bagGridCount += num;
/*  248 */     List<Integer> list_gridIndexs = new ArrayList<>();
/*  249 */     for (int i = oldGridCount + 1; i <= this.bagPO.bagGridCount; i++) {
/*  250 */       list_gridIndexs.add(Integer.valueOf(i));
/*      */     }
/*      */     
/*  253 */     _updateAndPush(list_gridIndexs, false);
/*  254 */     if (this.type == Const.BAG_TYPE.BAG) {
/*  255 */       int emptyNum = emptyGridNum();
/*  256 */       this.player.refreshPlayerRemainBagCountData(emptyNum);
/*      */     } 
/*  258 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onEvent(TaskEvent event) {
/*  265 */     Out.debug(new Object[] { getClass(), "Bag onEvent ", Integer.valueOf(event.type) });
/*  266 */     if (event.type == Const.EventType.consumeItem.getValue()) {
/*  267 */       String objId = (String)event.params[0];
/*  268 */       int objNum = ((Integer)event.params[1]).intValue();
/*  269 */       if (objId.equals("diamond")) {
/*  270 */         this.player.moneyManager.costDiamond(objNum, Const.GOODS_CHANGE_TYPE.consume);
/*      */       }
/*      */       else {
/*      */         
/*  274 */         itemUseById(objId, objNum);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public List<ItemOuterClass.Grid> getGrids4PayLoad() {
/*  281 */     List<ItemOuterClass.Grid> data = new ArrayList<>();
/*  282 */     for (int index = 1; index <= this.bagPO.bagGridCount; index++) {
/*  283 */       NormalItem item = getItem(index);
/*  284 */       if (item != null) {
/*  285 */         data.add(getGrid4PayLoad(index).build());
/*      */       }
/*      */     } 
/*  288 */     return data;
/*      */   }
/*      */   
/*      */   public ItemOuterClass.Grid.Builder getGrid4PayLoad(int index) {
/*  292 */     ItemOuterClass.Grid.Builder grid = ItemOuterClass.Grid.newBuilder();
/*  293 */     grid.setGridIndex(index);
/*  294 */     NormalItem item = getItem(index);
/*  295 */     if (item != null) {
/*  296 */       grid.setItem(item.toJSON4GridPayload());
/*      */     }
/*  298 */     return grid;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<ItemOuterClass.ItemDetail> getAllEquipDetails4PayLoad() {
/*  307 */     List<ItemOuterClass.ItemDetail> data = new ArrayList<>();
/*  308 */     for (int index = 1; index <= this.bagPO.bagGridCount; index++) {
/*  309 */       NormalItem item = getItem(index);
/*  310 */       if (item != null) {
/*  311 */         data.add(item.getItemDetail(this.player.playerBasePO).build());
/*      */       }
/*      */     } 
/*  314 */     return data;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int findItemNumByCode(String code) {
/*  324 */     int num = 0;
/*  325 */     for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
/*  326 */       NormalItem item = this.bagGrids.get(Integer.valueOf(i));
/*  327 */       if (item != null && code.equals(item.itemDb.code)) {
/*  328 */         num += item.itemDb.groupCount;
/*      */       }
/*      */     } 
/*  331 */     return num;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DetailItemNum findDetailItemNumByCode(String code) {
/*  341 */     DetailItemNum data = new DetailItemNum();
/*  342 */     for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
/*  343 */       NormalItem item = this.bagGrids.get(Integer.valueOf(i));
/*  344 */       if (item != null && code.equals(item.itemDb.code)) {
/*  345 */         data.totalNum += item.itemDb.groupCount;
/*  346 */         if (item.isBinding()) {
/*  347 */           data.bindNum += item.itemDb.groupCount;
/*      */         } else {
/*  349 */           data.unBindNum += item.itemDb.groupCount;
/*      */         } 
/*      */       } 
/*      */     } 
/*  353 */     return data;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<NormalItem> findGridsByCode(String code, boolean bind) {
/*  366 */     List<NormalItem> grids = new ArrayList<>();
/*  367 */     for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
/*  368 */       NormalItem item = this.bagGrids.get(Integer.valueOf(i));
/*  369 */       if (item != null && code.equals(item.itemDb.code) && item.isBinding() == bind) {
/*  370 */         grids.set(i, item);
/*      */       }
/*      */     } 
/*  373 */     return grids;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Map<Integer, NormalItem> findNotFullGridsByCode(String code, boolean bind) {
/*  383 */     Map<Integer, NormalItem> grids = new HashMap<>();
/*  384 */     for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
/*      */       
/*  386 */       NormalItem item = this.bagGrids.get(Integer.valueOf(i));
/*  387 */       if (item != null && code.equals(item.itemDb.code) && item.isBinding() == bind && item.leftGroup() > 0) {
/*  388 */         grids.put(Integer.valueOf(i), item);
/*      */       }
/*      */     } 
/*  391 */     return grids;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Map<Integer, Integer> findItemPosAndCountByCode(String code) {
/*  401 */     Map<Integer, Integer> posCount = new HashMap<>();
/*  402 */     for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
/*  403 */       NormalItem item = this.bagGrids.get(Integer.valueOf(i));
/*  404 */       if (item != null && code.equals(item.itemDb.code)) {
/*  405 */         posCount.put(Integer.valueOf(i), Integer.valueOf(item.itemDb.groupCount));
/*      */       }
/*      */     } 
/*  408 */     return posCount;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NormalItem findFirstItemByCode(String code) {
/*  418 */     for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
/*  419 */       NormalItem item = this.bagGrids.get(Integer.valueOf(i));
/*  420 */       if (item != null && code.equals(item.itemDb.code)) {
/*  421 */         return item;
/*      */       }
/*      */     } 
/*  424 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public int findPosByCode(String code) {
/*  435 */     for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
/*  436 */       NormalItem item = this.bagGrids.get(Integer.valueOf(i));
/*  437 */       if (item != null && code.equals(item.itemDb.code)) {
/*  438 */         return i;
/*      */       }
/*      */     } 
/*  441 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NormalItem findItemById(String id) {
/*  451 */     for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
/*  452 */       NormalItem item = this.bagGrids.get(Integer.valueOf(i));
/*  453 */       if (item != null && id.equals(item.itemDb.id)) {
/*  454 */         return item;
/*      */       }
/*      */     } 
/*  457 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int findPosById(String id) {
/*  467 */     for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
/*  468 */       NormalItem item = this.bagGrids.get(Integer.valueOf(i));
/*  469 */       if (item != null && id.equals(item.itemDb.id))
/*      */       {
/*  471 */         return i;
/*      */       }
/*      */     } 
/*  474 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int emptyGridNum() {
/*  483 */     return this.bagPO.bagGridCount - this.usedGridCount;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<Integer> findEmptyGrids(int num) {
/*  493 */     List<Integer> emptyIndex = new ArrayList<>();
/*  494 */     if (num <= 0) {
/*  495 */       return emptyIndex;
/*      */     }
/*  497 */     for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
/*  498 */       NormalItem item = this.bagGrids.get(Integer.valueOf(i));
/*  499 */       if (item == null) {
/*  500 */         emptyIndex.add(Integer.valueOf(i));
/*      */       }
/*  502 */       if (emptyIndex.size() == num) {
/*      */         break;
/*      */       }
/*      */     } 
/*  506 */     return emptyIndex;
/*      */   }
/*      */   
/*      */   public boolean testEmptyGridLarge(int actNum) {
/*  510 */     return testEmptyGridLarge(actNum, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean testEmptyGridLarge(int actNum, boolean isSilient) {
/*  521 */     if (emptyGridNum() >= actNum) {
/*  522 */       return true;
/*      */     }
/*  524 */     if (!isSilient) {
/*  525 */       WNNotifyManager.getInstance().gridNotEnough(this.player);
/*      */     }
/*  527 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void sendItemTips(WNPlayer player, String code, int number) {
/*  533 */     DItemEquipBase prop = this.itemManager.getItemProp(code);
/*  534 */     if (prop != null) {
/*  535 */       MessageUtil.sendItemTip(player, prop.name, prop.qcolor, number);
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean addItemToPos(int gridIndex, NormalItem item, Const.GOODS_CHANGE_TYPE from) {
/*  540 */     if (item != null) {
/*  541 */       if (_isVirtualItem(item, from)) {
/*  542 */         return true;
/*      */       }
/*  544 */       NormalItem oldItem = getItem(gridIndex);
/*  545 */       if (oldItem == null) {
/*  546 */         this.bagGrids.put(Integer.valueOf(gridIndex), item);
/*  547 */         _addUsedGridCount(1);
/*  548 */         List<Integer> gridIndexs = new ArrayList<>();
/*  549 */         gridIndexs.add(Integer.valueOf(gridIndex));
/*  550 */         _updateAndPush(gridIndexs, false, from);
/*  551 */         WNNotifyManager.getInstance().updateScript(this.player);
/*  552 */         Out.info(new Object[] { "增加道具成功,角色id=", this.player.getId(), ",背包类型为:", Integer.valueOf(this.type.getValue()), ",道具code=", item.itemDb.code, ",id=", item.itemDb.id, ",数量=", Integer.valueOf(item.itemDb.groupCount), ",位置=", Integer.valueOf(gridIndex), ",来源为:", (from == null) ? "未知" : Integer.valueOf(from.value) });
/*  553 */         return true;
/*      */       } 
/*      */     } 
/*  556 */     return false;
/*      */   }
/*      */   
/*      */   public boolean isMagicRingTaskOpen(WNPlayer player) {
/*  560 */     int taskId = GlobalConfig.MagicRing_MissionID;
/*  561 */     if (taskId == 0) {
/*  562 */       return true;
/*      */     }
/*  564 */     if (player.taskManager.isTaskDoingOrFinish(taskId)) {
/*  565 */       return true;
/*      */     }
/*  567 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean _isVirtualItem(NormalItem item, Const.GOODS_CHANGE_TYPE from) {
/*  579 */     if (item != null) {
/*  580 */       if (this.itemManager.getSecondType(item.prop.type) == Const.ItemSecondType.virtual.getValue()) {
/*  581 */         int num = item.getWorth();
/*  582 */         String code = item.itemDb.code;
/*  583 */         if (code.equals("gold")) {
/*  584 */           this.player.moneyManager.addGold(num, from);
/*  585 */         } else if (code.equals(Const.ITEM_CODE.TICKET.value)) {
/*  586 */           this.player.moneyManager.addTicket(num, from);
/*  587 */         } else if (code.equals("diamond")) {
/*  588 */           this.player.moneyManager.addDiamond(num, from);
/*  589 */         } else if (code.equals("fate")) {
/*  590 */           this.player.moneyManager.addXianYuan(num, from);
/*  591 */         } else if (code.equals("exp")) {
/*  592 */           this.player.addExp(num, from);
/*  593 */         } else if (code.equals("upexp")) {
/*  594 */           this.player.baseDataManager.addClassExp(num, from);
/*  595 */         } else if (!code.equals("sp")) {
/*      */           
/*  597 */           if (code.equals("prestige")) {
/*  598 */             this.player.addPrestige(num);
/*  599 */             this.player.pushDynamicData("prestige", Integer.valueOf(this.player.player.prestige));
/*  600 */           } else if (!code.equals("ringpres")) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  606 */             if (code.equals("solopoint")) {
/*  607 */               this.player.soloManager.addSolopoint(num, from);
/*  608 */             } else if (code.equals("consumepoint")) {
/*  609 */               this.player.moneyManager.addConsumePoint(num, from);
/*  610 */             } else if (code.equals("friendly")) {
/*  611 */               this.player.baseDataManager.addFriendly(num);
/*  612 */               this.player.pushDynamicData("friendly", Integer.valueOf(this.player.player.friendly));
/*  613 */             } else if (code.indexOf("rank") == 0) {
/*  614 */               int rankId = Integer.parseInt(code.replace("rank", ""));
/*  615 */               this.player.titleManager.onAwardRank(rankId);
/*  616 */             } else if (code.indexOf("guildpoint") == 0) {
/*  617 */               this.player.addGuildPoint(num);
/*  618 */               this.player.pushDynamicData("guildpoint", Integer.valueOf(this.player.player.guildpoint));
/*  619 */             } else if (code.equals(Const.ITEM_CODE.TREASURE_POINT.value)) {
/*  620 */               this.player.baseDataManager.addTreasurePoint(num);
/*      */             } 
/*      */           } 
/*  623 */         }  return true;
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  637 */       if (item.isVirtQuest()) {
/*  638 */         return true;
/*      */       }
/*      */     } 
/*      */     
/*  642 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Map<String, Object> _hasEnoughItem(String code, int num, final boolean unbindFist) {
/*  649 */     boolean flag = false;
/*  650 */     int sum = 0;
/*  651 */     Map<Integer, NormalItem> itemAll = new HashMap<>();
/*  652 */     for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
/*  653 */       NormalItem item = getItem(i);
/*  654 */       if (item != null && code.equals(item.itemDb.code)) {
/*  655 */         itemAll.put(Integer.valueOf(i), item);
/*      */ 
/*      */         
/*  658 */         sum += item.itemDb.groupCount;
/*      */       } 
/*      */     } 
/*      */     
/*  662 */     if (sum >= num) {
/*  663 */       flag = true;
/*      */     }
/*      */ 
/*      */     
/*  667 */     List<Map.Entry<Integer, NormalItem>> list = new ArrayList<>(itemAll.entrySet());
/*  668 */     Collections.sort(list, new Comparator<Map.Entry<Integer, NormalItem>>()
/*      */         {
/*      */           public int compare(Map.Entry<Integer, NormalItem> item1, Map.Entry<Integer, NormalItem> item2)
/*      */           {
/*  672 */             int bind1 = ((NormalItem)item1.getValue()).itemDb.isBind;
/*      */             
/*  674 */             int bind2 = ((NormalItem)item2.getValue()).itemDb.isBind;
/*      */             
/*  676 */             if (bind1 != bind2) {
/*  677 */               if (unbindFist) {
/*  678 */                 return (bind1 < bind2) ? -1 : 1;
/*      */               }
/*  680 */               return (bind1 < bind2) ? 1 : -1;
/*      */             } 
/*      */             
/*  683 */             return 0;
/*      */           }
/*      */         });
/*  686 */     Out.debug(new Object[] { getClass(), "unbindFist:", Boolean.valueOf(unbindFist), ",haveEnoughItem:", itemAll });
/*      */     
/*  688 */     Map<Integer, Integer> items = new HashMap<>();
/*  689 */     for (Iterator<Integer> iterator = itemAll.keySet().iterator(); iterator.hasNext(); ) { int index = ((Integer)iterator.next()).intValue();
/*  690 */       items.put(Integer.valueOf(index), Integer.valueOf(((NormalItem)itemAll.get(Integer.valueOf(index))).itemDb.groupCount)); }
/*      */ 
/*      */     
/*  693 */     Map<String, Object> result = new HashMap<>();
/*  694 */     result.put("flag", Boolean.valueOf(flag));
/*  695 */     result.put("items", items);
/*  696 */     return result;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<Integer> discardEnoughItem(Map<Integer, Integer> items, int sum, Const.GOODS_CHANGE_TYPE costDes) {
/*  706 */     List<Integer> indexs = new ArrayList<>();
/*      */     
/*  708 */     for (Iterator<Integer> iterator = items.keySet().iterator(); iterator.hasNext(); ) { int pos = ((Integer)iterator.next()).intValue();
/*  709 */       int num = ((Integer)items.get(Integer.valueOf(pos))).intValue();
/*  710 */       NormalItem realItem = getItem(pos);
/*  711 */       if (num > sum) {
/*  712 */         num = sum;
/*  713 */         sum = 0;
/*      */       } else {
/*  715 */         sum -= num;
/*      */       } 
/*      */       
/*  718 */       if (realItem != null && 
/*  719 */         realItem.deleteGroup(num)) {
/*  720 */         if (realItem.isInvalid()) {
/*  721 */           _delete(pos);
/*      */         }
/*  723 */         indexs.add(Integer.valueOf(pos));
/*      */         
/*  725 */         Out.info(new Object[] { "扣除道具成功,角色id=", this.player.getId(), ",背包类型为:", Integer.valueOf(this.type.getValue()), ",道具code=", realItem.itemDb.code, ",id=", realItem.itemDb.id, ",数量=", Integer.valueOf(realItem.itemDb.groupCount), ",位置=", Integer.valueOf(pos), ",来源为:", (costDes == null) ? "未知" : Integer.valueOf(costDes.value) });
/*  726 */         if (this.type == Const.BAG_TYPE.BAG) {
/*  727 */           LogReportService.getInstance().ansycReportItemFlow(this.player.getPlayer(), 2, realItem.itemDb.code, num, (realItem.itemDb.isBind == 1), costDes, realItem.getName());
/*      */         }
/*      */       } 
/*      */       
/*  731 */       if (sum == 0) {
/*      */         break;
/*      */       } }
/*      */     
/*  735 */     return indexs;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean discardItem(String code, int num, Const.GOODS_CHANGE_TYPE costDes, List<CurrencyData> currencyList, boolean unBindFist, boolean isNotPush) {
/*  749 */     boolean isPush = !isNotPush;
/*  750 */     if (currencyList == null) {
/*  751 */       CurrencyData currency = new CurrencyData(Const.CurrencyType.NONE.getValue(), 0);
/*  752 */       currencyList = new ArrayList<>();
/*  753 */       currencyList.add(currency);
/*      */     } 
/*      */     
/*  756 */     Map<String, Object> data = _hasEnoughItem(code, num, unBindFist);
/*  757 */     boolean flag = ((Boolean)data.get("flag")).booleanValue();
/*  758 */     Map<Integer, Integer> items = (Map<Integer, Integer>)data.get("items");
/*  759 */     if (flag) {
/*  760 */       List<Integer> indexs = discardEnoughItem(items, num, costDes);
/*  761 */       if (isPush) {
/*  762 */         _updateAndPush(indexs, true, costDes);
/*      */       }
/*  764 */       WNNotifyManager.getInstance().updateScript(this.player);
/*      */ 
/*      */       
/*  767 */       this.player.guildManager.bagDelItem(code);
/*      */     } 
/*  769 */     return flag;
/*      */   }
/*      */   
/*      */   public boolean discardItem(String code, int num, Const.GOODS_CHANGE_TYPE costDes) {
/*  773 */     return discardItem(code, num, costDes, null, false, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void discardItemByPos(int pos, int delNum, Const.GOODS_CHANGE_TYPE costDes) {
/*  778 */     discardItemByPos(pos, delNum, false, costDes);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NormalItem discardItemByPosPerent(int pos, int percent, Const.GOODS_CHANGE_TYPE costDes) {
/*  785 */     NormalItem item = getItem(pos);
/*  786 */     if (percent == 0 || item.itemDb.groupCount <= 0) {
/*  787 */       return null;
/*      */     }
/*  789 */     float fc = 1.0F * item.itemDb.groupCount / 10000.0F * percent;
/*  790 */     int cost = Math.round(fc);
/*  791 */     cost = (cost <= 0) ? 1 : cost;
/*  792 */     discardItemByPos(pos, cost, costDes);
/*      */ 
/*      */     
/*  795 */     NormalItem drop = ItemUtil.createItemByOpts(item.itemDb.copy(), item.prop);
/*  796 */     drop.itemDb.groupCount = cost;
/*  797 */     return drop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void discardItemByPos(int pos, int delNum, boolean all, Const.GOODS_CHANGE_TYPE costDes) {
/*  810 */     NormalItem item = getItem(pos);
/*  811 */     if (item != null) {
/*  812 */       if (all) {
/*  813 */         delNum = item.itemDb.groupCount;
/*      */       }
/*      */       
/*  816 */       Map<Integer, Integer> currency = new HashMap<>();
/*  817 */       currency.put(Integer.valueOf(Const.CurrencyType.NONE.getValue()), Integer.valueOf(0));
/*  818 */       if (item.deleteGroup(delNum)) {
/*  819 */         if (item.isInvalid()) {
/*  820 */           _delete(pos);
/*      */         }
/*  822 */         List<Integer> list = new ArrayList<>();
/*  823 */         list.add(Integer.valueOf(pos));
/*  824 */         _updateAndPush(list, true, costDes);
/*  825 */         WNNotifyManager.getInstance().updateScript(this.player);
/*      */         
/*  827 */         Out.info(new Object[] { "扣除道具成功,角色id=", this.player.getId(), ",背包类型为:", Integer.valueOf(this.type.getValue()), ",道具code=", item.itemDb.code, ",id=", item.itemDb.id, ",数量=", Integer.valueOf(item.itemDb.groupCount), ",位置=", Integer.valueOf(pos), ",来源为:", (costDes == null) ? "未知" : Integer.valueOf(costDes.value) });
/*  828 */         if (this.type == Const.BAG_TYPE.BAG) {
/*  829 */           LogReportService.getInstance().ansycReportItemFlow(this.player.getPlayer(), 2, item.itemDb.code, delNum, (item.itemDb.isBind == 1), costDes, item.getName());
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void discardItemsByPos(List<Map<String, Object>> posnums, Const.GOODS_CHANGE_TYPE source) {
/*  842 */     List<Integer> gridIndexs = new ArrayList<>();
/*  843 */     List<TradeMessageItemData> sysMessageItems = new ArrayList<>();
/*      */     
/*  845 */     for (int i = 0; i < posnums.size(); i++) {
/*  846 */       int pos = ((Integer)((Map)posnums.get(i)).get("pos")).intValue();
/*  847 */       int num = ((Integer)((Map)posnums.get(i)).get("num")).intValue();
/*  848 */       Map<Integer, Integer> currency = (Map<Integer, Integer>)((Map)posnums.get(i)).get("currency");
/*  849 */       if (currency == null) {
/*  850 */         currency = new HashMap<>();
/*  851 */         currency.put(Integer.valueOf(Const.CurrencyType.NONE.getValue()), Integer.valueOf(0));
/*      */       } 
/*  853 */       int costDes = ((Integer)((Map)posnums.get(i)).get("costDes")).intValue();
/*  854 */       NormalItem item = getItem(pos);
/*      */       
/*  856 */       if (costDes == Const.GOODS_CHANGE_TYPE.trade.getValue()) {
/*  857 */         TradeMessageItemData data = new TradeMessageItemData();
/*  858 */         data.name = item.getName();
/*  859 */         data.qt = item.prop.qcolor;
/*  860 */         data.num = num;
/*  861 */         sysMessageItems.add(data);
/*      */       } 
/*  863 */       if (item != null && num <= item.itemDb.groupCount) {
/*  864 */         if (num < item.itemDb.groupCount) {
/*  865 */           item.deleteGroup(num);
/*      */         } else {
/*  867 */           _delete(pos);
/*      */         } 
/*  869 */         gridIndexs.add(Integer.valueOf(pos));
/*  870 */         Out.info(new Object[] { "扣除道具成功,角色id=", this.player.getId(), ",背包类型为:", Integer.valueOf(this.type.getValue()), ",道具code=", item.itemDb.code, ",id=", item.itemDb.id, ",数量=", Integer.valueOf(item.itemDb.groupCount), ",位置=", Integer.valueOf(pos), ",来源为:", (source == null) ? "未知" : Integer.valueOf(source.value) });
/*  871 */         if (this.type == Const.BAG_TYPE.BAG) {
/*  872 */           LogReportService.getInstance().ansycReportItemFlow(this.player.getPlayer(), 2, item.itemDb.code, item.itemDb.groupCount, (item.itemDb.isBind == 1), source, item.getName());
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  877 */     if (gridIndexs.size() > 0) {
/*  878 */       _updateAndPush(gridIndexs, true, source);
/*  879 */       WNNotifyManager.getInstance().updateScript(this.player);
/*      */     } 
/*  881 */     if (sysMessageItems.size() > 0) {
/*  882 */       this.player.pushChatSystemMessage(Const.SYS_CHAT_TYPE.TRADE, "0", sysMessageItems, null);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean discardItemsByCode(String code, Const.GOODS_CHANGE_TYPE costDes) {
/*  894 */     List<SimpleItemInfo> simpleItemInfos = ItemUtil.parseString(code);
/*  895 */     for (SimpleItemInfo simpleItemInfo : simpleItemInfos) {
/*  896 */       int totalNum = findItemNumByCode(simpleItemInfo.itemCode);
/*  897 */       if (totalNum < simpleItemInfo.itemNum) {
/*  898 */         return false;
/*      */       }
/*      */     } 
/*  901 */     for (SimpleItemInfo simpleItemInfo : simpleItemInfos) {
/*  902 */       discardItem(simpleItemInfo.itemCode, simpleItemInfo.itemNum, costDes);
/*      */     }
/*      */     
/*  905 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeItemByPos(int pos, boolean flag, Const.GOODS_CHANGE_TYPE costDes) {
/*  916 */     NormalItem item = getItem(pos);
/*  917 */     if (item != null) {
/*  918 */       _delete(pos);
/*  919 */       List<Integer> list_pos = new ArrayList<>();
/*  920 */       list_pos.add(Integer.valueOf(pos));
/*  921 */       _updateAndPush(list_pos, true, costDes);
/*  922 */       WNNotifyManager.getInstance().updateScript(this.player);
/*  923 */       Out.info(new Object[] { "扣除道具成功,角色id=", this.player.getId(), ",背包类型为:", Integer.valueOf(this.type.getValue()), ",道具code=", item.itemDb.code, ",id=", item.itemDb.id, ",数量=", Integer.valueOf(item.itemDb.groupCount), ",位置=", Integer.valueOf(pos), ",来源为:", (costDes == null) ? "未知" : Integer.valueOf(costDes.value) });
/*  924 */       if (this.type == Const.BAG_TYPE.BAG) {
/*  925 */         LogReportService.getInstance().ansycReportItemFlow(this.player.getPlayer(), 2, item.itemDb.code, item.itemDb.groupCount, (item.itemDb.isBind == 1), costDes, item.getName());
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeAllItems() {
/*  934 */     List<Integer> gridIndexs = new ArrayList<>();
/*      */     
/*  936 */     for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
/*  937 */       NormalItem item = getItem(i);
/*  938 */       if (item != null) {
/*  939 */         _delete(i);
/*  940 */         gridIndexs.add(Integer.valueOf(i));
/*      */       } 
/*      */     } 
/*      */     
/*  944 */     if (gridIndexs.size() > 0) {
/*  945 */       _updateAndPush(gridIndexs, true, Const.GOODS_CHANGE_TYPE.clear_when_logout);
/*  946 */       WNNotifyManager.getInstance().updateScript(this.player);
/*  947 */       Out.info(new Object[] { "下线时清除所有回购背包的物品:playerId=", this.player.getId() });
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canPackUp() {
/*  957 */     long now = System.currentTimeMillis();
/*  958 */     if (now - this.bagGridPackUpTime < 5000L) {
/*  959 */       return false;
/*      */     }
/*  961 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void merge(NormalItem item, Map<String, NormalItem> temp, List<NormalItem> newData) {
/*  973 */     if (temp.get(item.itemDb.code) == null) {
/*  974 */       temp.put(item.itemDb.code, item);
/*      */     }
/*  976 */     else if (((NormalItem)temp.get(item.itemDb.code)).itemDb.groupCount + item.itemDb.groupCount >= item.prop.groupCount) {
/*  977 */       int tmpCount = item.itemDb.groupCount;
/*      */       
/*  979 */       item.setNum(item.prop.groupCount);
/*  980 */       newData.add(item);
/*      */ 
/*      */ 
/*      */       
/*  984 */       ((NormalItem)temp.get(item.itemDb.code)).setNum(((NormalItem)temp.get(item.itemDb.code)).itemDb.groupCount + tmpCount - item.prop.groupCount);
/*  985 */       if (((NormalItem)temp.get(item.itemDb.code)).itemDb.groupCount == 0) {
/*  986 */         temp.remove(item.itemDb.code);
/*      */       }
/*      */     }
/*      */     else {
/*      */       
/*  991 */       ((NormalItem)temp.get(item.itemDb.code)).addGroupNum(item.itemDb.groupCount);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<NormalItem> _packUpStackNum() {
/* 1004 */     List<NormalItem> newData = new ArrayList<>();
/*      */     
/* 1006 */     Map<String, NormalItem> temp = new HashMap<>();
/* 1007 */     Map<String, NormalItem> tempBind = new HashMap<>();
/*      */     
/* 1009 */     for (int index = 1; index <= this.bagPO.bagGridCount; index++) {
/* 1010 */       NormalItem item = getItem(index);
/* 1011 */       if (item != null)
/*      */       {
/*      */ 
/*      */         
/* 1015 */         if (item.itemDb.groupCount != item.prop.groupCount) {
/* 1016 */           if (item.isBinding()) {
/* 1017 */             ItemUtil.mergeItems(item, tempBind, newData);
/*      */           } else {
/* 1019 */             ItemUtil.mergeItems(item, temp, newData);
/*      */           } 
/*      */         } else {
/* 1022 */           newData.add(item);
/*      */         } 
/*      */       }
/*      */     } 
/* 1026 */     for (NormalItem opts : temp.values()) {
/* 1027 */       newData.add(opts);
/*      */     }
/*      */     
/* 1030 */     for (NormalItem opts : tempBind.values()) {
/* 1031 */       newData.add(opts);
/*      */     }
/*      */     
/* 1034 */     return newData;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean itemUseById(String id, int num) {
/* 1046 */     if (num > findItemNumByCode(id)) {
/* 1047 */       Out.warn(new Object[] { this.player.getId(), "在使用物品的时候失败了!个数不足:id=", id, ",要扣的数量为:", Integer.valueOf(num) });
/* 1048 */       return false;
/*      */     } 
/* 1050 */     NormalItem item = findFirstItemByCode(id);
/*      */     
/* 1052 */     if (item == null || !item.canUse()) {
/* 1053 */       Out.warn(new Object[] { this.player.getId(), "在使用物品的时候失败了!是不可使用的类型:id=", id, ",要扣的数量为:", Integer.valueOf(num) });
/* 1054 */       return false;
/*      */     } 
/*      */ 
/*      */     
/* 1058 */     if (!discardItem(id, num, Const.GOODS_CHANGE_TYPE.use, null, false, false)) {
/* 1059 */       Out.warn(new Object[] { this.player.getId(), "在使用物品的时候失败了!个数不足2:id=", id, ",要扣的数量为:", Integer.valueOf(num) });
/* 1060 */       return false;
/*      */     } 
/*      */     
/* 1063 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isItemNumEnough(String code, int num) {
/* 1104 */     if (findItemNumByCode(code) >= num) {
/* 1105 */       return true;
/*      */     }
/* 1107 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void ItemStatusUpdate(int index) {
/* 1117 */     NormalItem item = getItem(index);
/* 1118 */     if (item != null) {
/* 1119 */       item.itemDb.isNew = 0;
/* 1120 */       this.bagGrids.put(Integer.valueOf(index), item);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void _updateAndPush(List<Integer> gridIndexs, boolean refresh, Const.GOODS_CHANGE_TYPE source) {
/* 1129 */     _pushDynamicData(gridIndexs, refresh, source);
/*      */   }
/*      */   
/*      */   public void _updateAndPush(List<Integer> gridIndexs, boolean refresh) {
/* 1133 */     _pushDynamicData(gridIndexs, refresh, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void _pushDynamicData(List<Integer> gridIndexs, boolean refresh, Const.GOODS_CHANGE_TYPE source) {
/* 1143 */     if (this.type == Const.BAG_TYPE.BAG) {
/* 1144 */       WNNotifyManager.getInstance().pushBagItemDynamic(this.player, gridIndexs, refresh, source);
/* 1145 */     } else if (this.type == Const.BAG_TYPE.WAREHOUSE) {
/* 1146 */       WNNotifyManager.getInstance().pushBagItemDynamicWareHouse(this.player, gridIndexs, refresh);
/* 1147 */     } else if (this.type == Const.BAG_TYPE.RECYCLE) {
/* 1148 */       WNNotifyManager.getInstance().pushBagItemDynamicRecycle(this.player, gridIndexs, refresh);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void _pushNewItem(String code, int num, Const.GOODS_CHANGE_TYPE from) {
/* 1153 */     WNNotifyManager.getInstance().pushBagNewItem(this.player, code, num, from);
/*      */   }
/*      */   
/*      */   public boolean identify() {
/* 1157 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void _delete(int pos) {
/* 1167 */     this.bagGrids.remove(Integer.valueOf(pos));
/* 1168 */     _addUsedGridCount(-1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCD(int secondType, int pos) {
/* 1178 */     List<Integer> grids = new ArrayList<>();
/* 1179 */     for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
/* 1180 */       NormalItem item = this.bagGrids.get(Integer.valueOf(i));
/* 1181 */       if (item != null && 
/* 1182 */         this.itemManager.getSecondType(item.prop.type) == secondType) {
/* 1183 */         item.setCD();
/* 1184 */         if (i != pos) {
/* 1185 */           grids.add(Integer.valueOf(i));
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1191 */     _updateAndPush(grids, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<NormalItem> getAllTypeGem() {
/* 1200 */     Map<Integer, NormalItem> data = new HashMap<>();
/* 1201 */     for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
/* 1202 */       NormalItem item = getItem(i);
/* 1203 */       DItemBase prop = (DItemBase)item.prop;
/* 1204 */       if (item != null && item.prop.itemSecondType == Const.ItemSecondType.gem.getValue() && 
/* 1205 */         item.getLevel() <= this.player.getLevel()) {
/*      */ 
/*      */         
/* 1208 */         NormalItem old = data.get(Integer.valueOf(prop.par));
/* 1209 */         if (old != null) {
/* 1210 */           if (old.prop.price < item.prop.price) {
/* 1211 */             data.put(Integer.valueOf(prop.par), item);
/*      */           }
/*      */         } else {
/* 1214 */           data.put(Integer.valueOf(prop.par), item);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1219 */     Out.debug(new Object[] { getClass(), "getAllTypeGem:", data });
/* 1220 */     List<NormalItem> res = new ArrayList<>();
/* 1221 */     for (NormalItem v : data.values()) {
/* 1222 */       res.add(v);
/*      */     }
/*      */     
/* 1225 */     res.sort(new Comparator<NormalItem>()
/*      */         {
/*      */           public int compare(NormalItem a, NormalItem b)
/*      */           {
/* 1229 */             return (a.prop.price < b.prop.price) ? 1 : -1;
/*      */           }
/*      */         });
/*      */     
/* 1233 */     return res;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<NormalEquip> findEquipByType(int equipType, int pro, int level) {
/* 1243 */     List<NormalEquip> items = new ArrayList<>();
/* 1244 */     for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
/* 1245 */       NormalItem item = this.bagGrids.get(Integer.valueOf(i));
/* 1246 */       if (item != null)
/*      */       {
/*      */         
/* 1249 */         if (item.isEquip())
/*      */         {
/*      */           
/* 1252 */           if (item.prop.Pro == 0 || item.prop.Pro == pro)
/*      */           {
/*      */             
/* 1255 */             if (item.prop.levelReq <= level) {
/*      */ 
/*      */               
/* 1258 */               NormalEquip equip = (NormalEquip)item;
/* 1259 */               if (equip.prop.itemTypeId == equipType)
/*      */               {
/* 1261 */                 items.add(equip); } 
/*      */             }  }  }  } 
/*      */     } 
/* 1264 */     return items;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<NormalItem> findItemByType(String type) {
/* 1271 */     List<NormalItem> items = new ArrayList<>();
/* 1272 */     for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
/* 1273 */       NormalItem item = this.bagGrids.get(Integer.valueOf(i));
/* 1274 */       if (item != null && item.prop.type.equals(type)) {
/* 1275 */         items.add(item);
/*      */       }
/*      */     } 
/* 1278 */     return items;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<NormalItem> findItemBySecondType(Const.ItemSecondType secondType) {
/* 1285 */     List<NormalItem> items = new ArrayList<>();
/* 1286 */     for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
/* 1287 */       NormalItem item = this.bagGrids.get(Integer.valueOf(i));
/* 1288 */       if (item != null && item.prop.itemSecondType == secondType.getValue()) {
/* 1289 */         items.add(item);
/*      */       }
/*      */     } 
/* 1292 */     return items;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<NormalItem> findItemByProp(String prop) {
/* 1299 */     List<NormalItem> items = new ArrayList<>();
/* 1300 */     for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
/* 1301 */       NormalItem item = this.bagGrids.get(Integer.valueOf(i));
/* 1302 */       if (item != null)
/*      */       {
/*      */         
/* 1305 */         if (!item.isEquip()) {
/*      */ 
/*      */ 
/*      */           
/* 1309 */           DItemBase template = (DItemBase)item.prop;
/* 1310 */           if (template != null && template.prop.equals(prop))
/* 1311 */             items.add(item); 
/*      */         }  } 
/*      */     } 
/* 1314 */     return items;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void gmDeleteItemById(String id, int num) {
/* 1324 */     for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
/* 1325 */       NormalItem item = this.bagGrids.get(Integer.valueOf(i));
/* 1326 */       if (item != null && item.itemDb.id.equalsIgnoreCase(id)) {
/* 1327 */         num = Math.min(num, item.itemDb.groupCount);
/* 1328 */         discardItemByPos(i, num, false, Const.GOODS_CHANGE_TYPE.gm);
/* 1329 */         List<Integer> grids = new ArrayList<>();
/* 1330 */         grids.add(Integer.valueOf(i));
/* 1331 */         _updateAndPush(grids, true, Const.GOODS_CHANGE_TYPE.gm);
/*      */         break;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class SimpleItemInfo
/*      */   {
/*      */     public String itemCode;
/*      */     
/*      */     public int itemNum;
/*      */     
/*      */     public Const.ForceType forceType;
/*      */     
/*      */     public int type;
/*      */     
/*      */     public int index;
/*      */     
/*      */     public int pos;
/*      */   }
/*      */ 
/*      */   
/*      */   public int _calcNeedGridNumByCode(List<SimpleItemInfo> itemList, Const.ForceType forceType) {
/* 1356 */     int needGridNum = 0;
/*      */     
/* 1358 */     Map<String, Integer> bindGroup = new HashMap<>();
/* 1359 */     Map<String, Integer> unBindGroup = new HashMap<>();
/* 1360 */     for (int i = 0; i < itemList.size(); i++) {
/* 1361 */       SimpleItemInfo itemInfo = itemList.get(i);
/*      */       
/* 1363 */       if (!ItemUtil.isVirtualItem(itemInfo.itemCode)) {
/*      */ 
/*      */         
/* 1366 */         Const.ForceType finalForceType = (itemInfo.forceType != null) ? itemInfo.forceType : forceType;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1371 */         DItemEquipBase prop = ItemUtil.getPropByCode(itemInfo.itemCode);
/* 1372 */         if (prop == null) {
/* 1373 */           return 9999;
/*      */         }
/* 1375 */         int finalBindType = ItemUtil.getPropBindType(prop, finalForceType);
/* 1376 */         boolean isBind = (finalBindType == 1);
/*      */         
/* 1378 */         Map<String, Integer> group = isBind ? bindGroup : unBindGroup;
/* 1379 */         if (group.get(itemInfo.itemCode) != null) {
/*      */           
/* 1381 */           group.put(itemInfo.itemCode, Integer.valueOf(((Integer)group.get(itemInfo.itemCode)).intValue() + itemInfo.itemNum));
/*      */         } else {
/*      */           
/* 1384 */           group.put(itemInfo.itemCode, Integer.valueOf(itemInfo.itemNum));
/*      */         } 
/*      */       } 
/*      */     } 
/* 1388 */     List<Object[]> items = new ArrayList();
/* 1389 */     Iterator<String> keys_bind = bindGroup.keySet().iterator();
/* 1390 */     while (keys_bind.hasNext()) {
/* 1391 */       String itemCode = keys_bind.next();
/* 1392 */       int itemNum = ((Integer)bindGroup.get(itemCode)).intValue();
/* 1393 */       items.add(new Object[] { itemCode, Integer.valueOf(itemNum), Boolean.valueOf(true) });
/*      */     } 
/* 1395 */     Iterator<String> keys_unbind = unBindGroup.keySet().iterator();
/* 1396 */     while (keys_unbind.hasNext()) {
/* 1397 */       String itemCode = keys_unbind.next();
/* 1398 */       int itemNum = ((Integer)unBindGroup.get(itemCode)).intValue();
/* 1399 */       items.add(new Object[] { itemCode, Integer.valueOf(itemNum), Boolean.valueOf(false) });
/*      */     } 
/*      */     
/* 1402 */     if (items.size() == 0) {
/* 1403 */       return needGridNum;
/*      */     }
/* 1405 */     for (int j = 0; j < items.size(); j++) {
/* 1406 */       Object[] itemInfo = items.get(j);
/* 1407 */       String itemCode = (String)itemInfo[0];
/* 1408 */       int calcNum = ((Integer)itemInfo[1]).intValue();
/* 1409 */       boolean isBind = ((Boolean)itemInfo[2]).booleanValue();
/*      */       
/* 1411 */       DItemEquipBase prop = ItemUtil.getPropByCode(itemCode);
/* 1412 */       Map<Integer, NormalItem> grids = findNotFullGridsByCode(itemCode, isBind);
/* 1413 */       Iterator<Integer> keys = grids.keySet().iterator();
/* 1414 */       while (keys.hasNext()) {
/* 1415 */         int gridIndex = ((Integer)keys.next()).intValue();
/*      */         
/* 1417 */         NormalItem item = getItem(gridIndex);
/* 1418 */         int leftNum = item.leftGroup();
/* 1419 */         if (leftNum <= 0) {
/*      */           continue;
/*      */         }
/* 1422 */         int addNum = (leftNum < calcNum) ? leftNum : calcNum;
/* 1423 */         if (addNum > 0) {
/* 1424 */           calcNum -= addNum;
/*      */         }
/* 1426 */         if (calcNum == 0) {
/*      */           break;
/*      */         }
/*      */       } 
/* 1430 */       if (calcNum > 0) {
/* 1431 */         needGridNum += (calcNum + prop.groupCount - 1) / prop.groupCount;
/*      */       }
/*      */     } 
/* 1434 */     return needGridNum;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean testAddCodeItem(String itemCode, int itemNum) {
/* 1439 */     return testAddCodeItem(itemCode, itemNum, null, false);
/*      */   }
/*      */   
/*      */   public boolean testAddCodeItem(String itemCode, int itemNum, Const.ForceType forceType) {
/* 1443 */     return testAddCodeItem(itemCode, itemNum, forceType, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean testAddCodeItem(String itemCode, int itemNum, Const.ForceType forceType, boolean isNotNotify) {
/* 1456 */     List<SimpleItemInfo> list = new ArrayList<>();
/* 1457 */     SimpleItemInfo map = new SimpleItemInfo();
/* 1458 */     map.itemCode = itemCode;
/* 1459 */     map.itemNum = itemNum;
/* 1460 */     map.forceType = forceType;
/* 1461 */     list.add(map);
/* 1462 */     return testAddCodeItems(list, forceType, isNotNotify);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean testAddCodeItems(List<SimpleItemInfo> itemList) {
/* 1470 */     return testAddCodeItems(itemList, null, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean testAddCodeItems(List<SimpleItemInfo> itemList, Const.ForceType forceType, boolean isNotNotify) {
/* 1483 */     int needGrids = _calcNeedGridNumByCode(itemList, forceType);
/* 1484 */     if (itemList.size() > 0) {
/* 1485 */       Out.debug(new Object[] { getClass(), "testAddCodeItems ", ((SimpleItemInfo)itemList.get(0)).itemCode, " needGrids:", Integer.valueOf(needGrids) });
/*      */     } else {
/* 1487 */       Out.debug(new Object[] { getClass(), "testAddCodeItems needGrids:", Integer.valueOf(needGrids) });
/*      */     } 
/*      */     
/* 1490 */     if (emptyGridNum() < needGrids) {
/* 1491 */       if (!isNotNotify) {
/* 1492 */         WNNotifyManager.getInstance().gridNotEnough(this.player);
/*      */       }
/* 1494 */       return false;
/*      */     } 
/* 1496 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean testAddEntityItem(NormalItem item, boolean isNotNotify) {
/* 1507 */     List<NormalItem> list_items = new ArrayList<>();
/* 1508 */     list_items.add(item);
/* 1509 */     return testAddEntityItems(list_items, isNotNotify);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean testAddEntityItemsPO(List<PlayerItemPO> items, boolean isNotNotify) {
/* 1516 */     List<NormalItem> list = new ArrayList<>();
/* 1517 */     for (PlayerItemPO po : items) {
/* 1518 */       list.add(ItemUtil.createItemByDbOpts(po));
/*      */     }
/* 1520 */     return testAddEntityItems(list, isNotNotify);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean testAddEntityItems(List<NormalItem> items, boolean isNotNotify) {
/* 1531 */     List<SimpleItemInfo> itemList = new ArrayList<>();
/* 1532 */     for (int i = 0; i < items.size(); i++) {
/* 1533 */       NormalItem item = items.get(i);
/*      */       
/* 1535 */       Const.ForceType forceType = item.isBinding() ? Const.ForceType.BIND : Const.ForceType.UN_BIND;
/* 1536 */       SimpleItemInfo map = new SimpleItemInfo();
/* 1537 */       map.itemCode = item.itemDb.code;
/* 1538 */       map.itemNum = item.itemDb.groupCount;
/* 1539 */       map.forceType = forceType;
/* 1540 */       itemList.add(map);
/*      */     } 
/* 1542 */     return testAddCodeItems(itemList, null, isNotNotify);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addCodeItemMail(List<NormalItem> items, Const.ForceType forceType, Const.GOODS_CHANGE_TYPE fromDes, String mailKey) {
/* 1549 */     if (testAddEntityItems(items, false)) {
/* 1550 */       System.out.println(":::::::::::::::::::addEEEEE:::::::::::::::::::::::");
/* 1551 */       addEntityItems(items, fromDes);
/*      */     } else {
/* 1553 */       MailSysData mailData = new MailSysData(mailKey);
/* 1554 */       List<MailData.Attachment> list_attach = new ArrayList<>();
/* 1555 */       for (NormalItem item : items) {
/*      */         
/* 1557 */         if (item.isVirtual()) {
/* 1558 */           addEntityItem(item, fromDes); continue;
/*      */         } 
/* 1560 */         MailData.Attachment attachment = new MailData.Attachment();
/* 1561 */         attachment.itemCode = item.itemCode();
/* 1562 */         attachment.itemNum = item.getNum();
/* 1563 */         list_attach.add(attachment);
/*      */       } 
/*      */       
/* 1566 */       if (list_attach.size() > 0) {
/* 1567 */         mailData.attachments = list_attach;
/* 1568 */         MailUtil.getInstance().sendMailToOnePlayer(this.player.getId(), (MailData)mailData, fromDes);
/*      */       } 
/*      */     } 
/* 1571 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addCodeItemMail(String itemCode, int number, Const.ForceType forceType, Const.GOODS_CHANGE_TYPE fromDes, String mailKey) {
/* 1578 */     if (testAddCodeItem(itemCode, number, forceType)) {
/* 1579 */       addCodeItem(itemCode, number, forceType, fromDes);
/*      */     } else {
/* 1581 */       MailSysData mailData = new MailSysData(mailKey);
/* 1582 */       mailData.attachments = new ArrayList();
/* 1583 */       MailData.Attachment attachment = new MailData.Attachment();
/* 1584 */       attachment.itemCode = itemCode;
/* 1585 */       attachment.itemNum = number;
/* 1586 */       mailData.attachments.add(attachment);
/* 1587 */       MailUtil.getInstance().sendMailToOnePlayer(this.player.getId(), (MailData)mailData, fromDes);
/*      */     } 
/* 1589 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addEntityItemMail(NormalItem item, Const.GOODS_CHANGE_TYPE fromDes, String mailKey) {
/* 1596 */     Const.ForceType forceType = (item.getBind() == 1) ? Const.ForceType.BIND : Const.ForceType.UN_BIND;
/* 1597 */     if (testAddCodeItem(item.itemCode(), item.getNum(), forceType)) {
/* 1598 */       addEntityItem(item, fromDes);
/*      */     } else {
/* 1600 */       MailSysData mailData = new MailSysData(mailKey);
/* 1601 */       mailData.entityItems = new ArrayList();
/* 1602 */       mailData.entityItems.add(item.itemDb);
/* 1603 */       MailUtil.getInstance().sendMailToOnePlayer(this.player.getId(), (MailData)mailData, fromDes);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addCodeItem(String code, int number, Const.ForceType forceType, Const.GOODS_CHANGE_TYPE fromDes) {
/* 1608 */     addCodeItem(code, number, forceType, fromDes, null, false, false);
/*      */   }
/*      */   
/*      */   public void addCodeItem(String code, int number, Const.ForceType forceType, Const.GOODS_CHANGE_TYPE fromDes, Map<Integer, Object> currencyList) {
/* 1612 */     addCodeItem(code, number, forceType, fromDes, currencyList, false, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addCodeItem(String code, int number, Const.ForceType forceType, Const.GOODS_CHANGE_TYPE fromDes, Map<Integer, Object> currencyList, boolean isNotPushNewItem, boolean isNotSendFullMsg) {
/* 1628 */     List<SimpleItemInfo> codeItems = new ArrayList<>();
/* 1629 */     SimpleItemInfo itemInfo = new SimpleItemInfo();
/* 1630 */     itemInfo.itemCode = code;
/* 1631 */     itemInfo.itemNum = number;
/* 1632 */     itemInfo.forceType = forceType;
/* 1633 */     codeItems.add(itemInfo);
/* 1634 */     addCodeItems(codeItems, fromDes, currencyList, isNotPushNewItem, isNotSendFullMsg);
/*      */   }
/*      */ 
/*      */   
/*      */   public void addCodeItems(List<SimpleItemInfo> codeItems, Const.GOODS_CHANGE_TYPE fromDes) {
/* 1639 */     addCodeItems(codeItems, fromDes, null, false, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addCodeItems(List<SimpleItemInfo> codeItems, Const.GOODS_CHANGE_TYPE fromDes, Map<Integer, Object> currencyList, boolean isNotPushNewItem, boolean isNotSendFullMsg) {
/* 1656 */     List<NormalItem> items = new ArrayList<>();
/* 1657 */     for (int i = 0; i < codeItems.size(); i++) {
/* 1658 */       SimpleItemInfo itemInfo = codeItems.get(i);
/* 1659 */       Const.ForceType realForceType = itemInfo.forceType;
/* 1660 */       List<NormalItem> itemList = ItemUtil.createItemsByItemCode(itemInfo.itemCode, itemInfo.itemNum);
/* 1661 */       for (int j = 0; j < itemList.size(); j++) {
/* 1662 */         NormalItem item = itemList.get(j);
/* 1663 */         int bindType = ItemUtil.getPropBindType(item.prop, realForceType);
/* 1664 */         item.setBind(bindType);
/*      */       } 
/* 1666 */       items.addAll(itemList);
/*      */     } 
/* 1668 */     addEntityItems(items, fromDes, currencyList, isNotPushNewItem, isNotSendFullMsg, true);
/*      */   }
/*      */   
/*      */   public void addEntityItem(NormalItem item, Const.GOODS_CHANGE_TYPE fromDes) {
/* 1672 */     addEntityItem(item, fromDes, null, false, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addEntityItem(NormalItem item, Const.GOODS_CHANGE_TYPE fromDes, Map<Integer, Object> currencyList, boolean isNotPushNewItem, boolean isNotSendFullMsg) {
/* 1687 */     List<NormalItem> items = new ArrayList<>();
/* 1688 */     items.add(item);
/* 1689 */     addEntityItems(items, fromDes, currencyList, isNotPushNewItem, isNotSendFullMsg, false);
/*      */   }
/*      */   
/*      */   public void addEntityItems(List<NormalItem> items, Const.GOODS_CHANGE_TYPE fromDes, Map<Integer, Object> currencyList) {
/* 1693 */     addEntityItems(items, fromDes, currencyList, false, false, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addEntityItemsPO(List<PlayerItemPO> items, Const.GOODS_CHANGE_TYPE fromDes) {
/* 1700 */     List<NormalItem> list = new ArrayList<>();
/* 1701 */     for (PlayerItemPO po : items) {
/* 1702 */       list.add(ItemUtil.createItemByDbOpts(po));
/*      */     }
/* 1704 */     addEntityItems(list, fromDes);
/*      */   }
/*      */   
/*      */   public void addEntityItems(List<NormalItem> items, Const.GOODS_CHANGE_TYPE fromDes) {
/* 1708 */     addEntityItems(items, fromDes, null, false, false, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void addEntityItems(List<NormalItem> items, Const.GOODS_CHANGE_TYPE fromDes, Map<Integer, Object> currencyList, boolean isNotPushNewItem, boolean isNotSendFullMsg, boolean isCanChangeParam) {
/* 1724 */     if (items == null || items.size() <= 0 || this.player.isRobot()) {
/*      */       return;
/*      */     }
/*      */     
/* 1728 */     List<NormalItem> actualItems = new ArrayList<>();
/* 1729 */     Map<String, Integer> actualCounts = new HashMap<>();
/*      */     
/* 1731 */     for (int i = 0; i < items.size(); i++) {
/* 1732 */       NormalItem item = items.get(i);
/*      */       
/* 1734 */       this.player.achievementManager.onGetEquipment(item.itemDb.code);
/*      */       
/* 1736 */       this.player.equipManager.updateStrengthScript(item.itemDb.code);
/*      */       
/* 1738 */       this.player.equipManager.updateMakeScript(item.itemDb.code);
/*      */       
/* 1740 */       this.player.equipManager.updateFillGemScript(item.itemDb.code);
/*      */       
/* 1742 */       if (item.isEquip()) {
/*      */         try {
/* 1744 */           this.player.equipManager.updateEquipScript((NormalEquip)item);
/* 1745 */         } catch (ClassCastException e) {
/* 1746 */           Out.error(new Object[] { "NormalEquip cast exception, id=" + item.getId() + " code=" + item.itemDb.code + " name=" + item.getName() });
/* 1747 */           throw e;
/*      */         } 
/*      */       }
/*      */       
/* 1751 */       if (!_isVirtualItem(item, fromDes)) {
/*      */ 
/*      */         
/* 1754 */         if (!isCanChangeParam && item.prop.groupCount > 1) {
/* 1755 */           NormalItem cloneItem = ItemUtil.createItemByDbOpts(item.cloneItemDB());
/* 1756 */           actualItems.add(cloneItem);
/*      */         } else {
/* 1758 */           actualItems.add(item);
/*      */         } 
/*      */         
/* 1761 */         if (actualCounts.get(item.itemDb.code) != null) {
/* 1762 */           actualCounts.put(item.itemDb.code, Integer.valueOf(((Integer)actualCounts.get(item.itemDb.code)).intValue() + item.itemDb.groupCount));
/*      */         } else {
/* 1764 */           actualCounts.put(item.itemDb.code, Integer.valueOf(item.itemDb.groupCount));
/*      */         } 
/*      */         
/* 1767 */         this.player.taskManager.dealTaskEvent(Const.TaskType.GET_ITEM, item.itemDb.code, item.itemDb.groupCount);
/*      */       } 
/* 1769 */     }  if (actualItems.size() == 0) {
/*      */       return;
/*      */     }
/*      */     
/* 1773 */     List<Integer> gridIndexs = new ArrayList<>();
/* 1774 */     List<NormalItem> createArray = new ArrayList<>();
/* 1775 */     List<HashMap<String, NormalItem>> notFullCache = new ArrayList<>();
/*      */ 
/*      */     
/* 1778 */     notFullCache.add(new HashMap<>());
/* 1779 */     notFullCache.add(new HashMap<>());
/* 1780 */     List<HashMap<String, Boolean>> bagFullCheck = new ArrayList<>();
/*      */     
/* 1782 */     bagFullCheck.add(new HashMap<>());
/* 1783 */     bagFullCheck.add(new HashMap<>());
/*      */     
/* 1785 */     for (int j = 0; j < actualItems.size(); j++) {
/* 1786 */       NormalItem newItem = actualItems.get(j);
/* 1787 */       boolean isBind = newItem.isBinding();
/* 1788 */       String code = newItem.itemDb.code;
/*      */       
/* 1790 */       if (this.type == Const.BAG_TYPE.BAG) {
/* 1791 */         LogReportService.getInstance().ansycReportItemFlow(this.player.getPlayer(), 1, code, newItem.itemDb.groupCount, isBind, fromDes, newItem.getName());
/*      */       }
/*      */       
/* 1794 */       Map<String, Boolean> bagCheck = isBind ? bagFullCheck.get(0) : bagFullCheck.get(1);
/* 1795 */       Map<String, NormalItem> cache = isBind ? notFullCache.get(0) : notFullCache.get(1);
/*      */       
/* 1797 */       if (bagCheck.get(code) == null || !((Boolean)bagCheck.get(code)).booleanValue()) {
/* 1798 */         Map<Integer, NormalItem> grids = findNotFullGridsByCode(newItem.itemDb.code, isBind);
/* 1799 */         Iterator<Integer> keys = grids.keySet().iterator();
/* 1800 */         while (keys.hasNext()) {
/* 1801 */           int pos = ((Integer)keys.next()).intValue();
/* 1802 */           NormalItem item = grids.get(Integer.valueOf(pos));
/* 1803 */           int leftNum = item.prop.groupCount - item.itemDb.groupCount;
/* 1804 */           if (leftNum <= 0) {
/*      */             continue;
/*      */           }
/* 1807 */           int addNum = (newItem.itemDb.groupCount <= leftNum) ? newItem.itemDb.groupCount : leftNum;
/* 1808 */           newItem.addGroupNum(-addNum);
/* 1809 */           item.addGroupNum(addNum);
/* 1810 */           if (!gridIndexs.contains(Integer.valueOf(pos))) {
/* 1811 */             gridIndexs.add(Integer.valueOf(pos));
/* 1812 */             Out.info(new Object[] { "增加道具成功,角色id=", this.player.getId(), ",背包类型为:", Integer.valueOf(this.type.getValue()), ",道具code=", item.itemDb.code, ",id=", item.itemDb.id, ",数量=", Integer.valueOf(addNum), "更新后数量为:", Integer.valueOf(item.itemDb.groupCount), ",位置=", Integer.valueOf(pos), ",来源为:", (fromDes == null) ? "未知" : Integer.valueOf(fromDes.value) });
/*      */           } 
/* 1814 */           if (newItem.itemDb.groupCount <= 0) {
/*      */             break;
/*      */           }
/*      */         } 
/*      */       } 
/*      */       
/* 1820 */       if (newItem.itemDb.groupCount > 0) {
/* 1821 */         bagCheck.put(code, Boolean.valueOf(true));
/*      */         
/* 1823 */         int maxGroupCount = newItem.prop.groupCount;
/* 1824 */         if (newItem.itemDb.groupCount >= maxGroupCount) {
/* 1825 */           createArray.add(newItem);
/* 1826 */         } else if (cache.get(code) == null) {
/* 1827 */           cache.put(code, newItem);
/*      */         } else {
/* 1829 */           NormalItem cacheItem = cache.get(code);
/* 1830 */           int totalCount = cacheItem.itemDb.groupCount + newItem.itemDb.groupCount;
/* 1831 */           if (totalCount > maxGroupCount) {
/* 1832 */             cacheItem.setNum(maxGroupCount);
/* 1833 */             newItem.setNum(totalCount - maxGroupCount);
/*      */             
/* 1835 */             createArray.add(cacheItem);
/* 1836 */             cache.put(code, newItem);
/*      */           } else {
/* 1838 */             cacheItem.setNum(totalCount);
/* 1839 */             if (cacheItem.itemDb.groupCount == maxGroupCount) {
/* 1840 */               createArray.add(cacheItem);
/* 1841 */               cache.remove(code);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1848 */     for (Map<String, NormalItem> cache : notFullCache) {
/* 1849 */       for (NormalItem newItem : cache.values()) {
/* 1850 */         if (newItem != null) {
/* 1851 */           createArray.add(newItem);
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1857 */     List<Integer> emptyIndexs = findEmptyGrids(createArray.size());
/* 1858 */     if (emptyIndexs.size() < createArray.size()) {
/* 1859 */       StringBuilder sb = new StringBuilder("addEntityItems error, playerId=" + this.player.getId() + " emptyIndexsSize:" + emptyIndexs.size() + " createArraySize:" + createArray.size());
/* 1860 */       sb.append("\r\nlostItems: ");
/* 1861 */       for (NormalItem lostItem : createArray) {
/* 1862 */         sb.append("code").append(lostItem.itemCode()).append(",num").append(lostItem.getNum()).append(";");
/*      */       }
/* 1864 */       Out.error(new Object[] { sb.toString() });
/*      */       return;
/*      */     } 
/* 1867 */     for (int k = 0; k < createArray.size(); k++) {
/* 1868 */       NormalItem item = createArray.get(k);
/* 1869 */       this.bagGrids.put(emptyIndexs.get(k), createArray.get(k));
/* 1870 */       gridIndexs.add(emptyIndexs.get(k));
/* 1871 */       Out.info(new Object[] { "增加道具成功,角色id=", this.player.getId(), ",背包类型为:", Integer.valueOf(this.type.getValue()), ",道具code=", item.itemDb.code, ",id=", item.itemDb.id, ",数量=", Integer.valueOf(item.itemDb.groupCount), "更新后数量为:", Integer.valueOf(item.itemDb.groupCount), ",位置=", emptyIndexs.get(k), ",来源为:", (fromDes == null) ? "未知" : Integer.valueOf(fromDes.value) });
/*      */     } 
/* 1873 */     _addUsedGridCount(createArray.size());
/*      */ 
/*      */     
/* 1876 */     if (gridIndexs.size() > 0) {
/* 1877 */       _updateAndPush(gridIndexs, true, fromDes);
/*      */     }
/* 1879 */     if (!isNotPushNewItem) {
/* 1880 */       Iterator<String> keys = actualCounts.keySet().iterator();
/* 1881 */       while (keys.hasNext()) {
/* 1882 */         String code = keys.next();
/* 1883 */         int actualCount = ((Integer)actualCounts.get(code)).intValue();
/* 1884 */         _pushNewItem(code, actualCount, fromDes);
/*      */       } 
/*      */     } 
/*      */     
/* 1888 */     if (emptyGridNum() <= 0 && !isNotSendFullMsg) {
/* 1889 */       PlayerUtil.sendSysMessageToPlayer(LangService.getValue("BAG_BECOME_FULL_NOTICE"), this.player.getId(), Const.TipsType.BLACK);
/*      */     }
/* 1891 */     WNNotifyManager.getInstance().updateScript(this.player);
/*      */ 
/*      */     
/* 1894 */     this.player.guildManager.bagAddItems(items);
/*      */   }
/*      */   
/*      */   public void addBagGridCount(int num) {
/* 1898 */     int oldCount = this.bagPO.bagGridCount;
/* 1899 */     this.bagPO.bagGridCount += num;
/* 1900 */     List<Integer> gridIndexs = new ArrayList<>();
/* 1901 */     for (int i = 1; i <= num; i++) {
/* 1902 */       gridIndexs.add(Integer.valueOf(oldCount + i));
/*      */     }
/* 1904 */     _updateAndPush(gridIndexs, false);
/* 1905 */     _gridNumChangePush();
/*      */ 
/*      */     
/* 1908 */     BagHandler.BagGridNumPush.Builder gridNumChange = BagHandler.BagGridNumPush.newBuilder();
/* 1909 */     gridNumChange.setS2CType(this.type.getValue());
/* 1910 */     gridNumChange.setGridNum(this.bagPO.bagGridCount);
/* 1911 */     this.player.receive("area.bagPush.bagGridNumPush", (GeneratedMessage)gridNumChange.build());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void update() {
/* 1918 */     Map<Integer, PlayerItemPO> grids = new HashMap<>();
/* 1919 */     for (Integer pos : this.bagGrids.keySet()) {
/* 1920 */       if (this.bagGrids.get(pos) != null) {
/* 1921 */         grids.put(pos, ((NormalItem)this.bagGrids.get(pos)).itemDb);
/*      */       }
/*      */     } 
/* 1924 */     this.bagPO.bagGrids = grids;
/*      */   }
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\bag\WNBag.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */