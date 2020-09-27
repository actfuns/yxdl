/*     */ package com.wanniu.game;
/*     */ 
/*     */ import com.wanniu.core.GConfig;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.DataUtil;
/*     */ import com.wanniu.game.data.ActiveCO;
/*     */ import com.wanniu.game.data.AthleticShopCO;
/*     */ import com.wanniu.game.data.BlueEquipCO;
/*     */ import com.wanniu.game.data.BranchLineCO;
/*     */ import com.wanniu.game.data.ChestCO;
/*     */ import com.wanniu.game.data.CircleSceneCO;
/*     */ import com.wanniu.game.data.DailyCO;
/*     */ import com.wanniu.game.data.DemonTowerCO;
/*     */ import com.wanniu.game.data.DungeonCO;
/*     */ import com.wanniu.game.data.DungeonMapCO;
/*     */ import com.wanniu.game.data.Dungeon_EliteCO;
/*     */ import com.wanniu.game.data.Dungeon_HeroCO;
/*     */ import com.wanniu.game.data.Dungeon_NormalCO;
/*     */ import com.wanniu.game.data.FashionItemCO;
/*     */ import com.wanniu.game.data.FateShopCO;
/*     */ import com.wanniu.game.data.GameMapCO;
/*     */ import com.wanniu.game.data.GuildShopCO;
/*     */ import com.wanniu.game.data.JewelCO;
/*     */ import com.wanniu.game.data.LegendEquipCO;
/*     */ import com.wanniu.game.data.MainLineCO;
/*     */ import com.wanniu.game.data.MallShopCO;
/*     */ import com.wanniu.game.data.MateCO;
/*     */ import com.wanniu.game.data.MenuUISaleCO;
/*     */ import com.wanniu.game.data.MiscCO;
/*     */ import com.wanniu.game.data.NormalEquipCO;
/*     */ import com.wanniu.game.data.NormalMapCO;
/*     */ import com.wanniu.game.data.Normal_WorldCO;
/*     */ import com.wanniu.game.data.NpcSaleCO;
/*     */ import com.wanniu.game.data.PetItemCO;
/*     */ import com.wanniu.game.data.PotionCO;
/*     */ import com.wanniu.game.data.PurpleEquipCO;
/*     */ import com.wanniu.game.data.QuestCO;
/*     */ import com.wanniu.game.data.RankCO;
/*     */ import com.wanniu.game.data.RideEquipCO;
/*     */ import com.wanniu.game.data.RideItemCO;
/*     */ import com.wanniu.game.data.SuitEquipCO;
/*     */ import com.wanniu.game.data.SundryShopCO;
/*     */ import com.wanniu.game.data.TreasureCO;
/*     */ import com.wanniu.game.data.UniqueEquipCO;
/*     */ import com.wanniu.game.data.VirtualCO;
/*     */ import com.wanniu.game.data.base.DEquipBase;
/*     */ import com.wanniu.game.data.base.DItemBase;
/*     */ import com.wanniu.game.data.base.IntergalShopBase;
/*     */ import com.wanniu.game.data.base.MapBase;
/*     */ import com.wanniu.game.data.base.MonsterBase;
/*     */ import com.wanniu.game.data.base.SaleBase;
/*     */ import com.wanniu.game.data.base.TaskBase;
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JS2JMain
/*     */ {
/*  62 */   private static int TableCount = 0;
/*     */   
/*     */   public static void writeClass(File parent) {
/*  65 */     File[] tables = parent.listFiles(new FileFilter()
/*     */         {
/*     */           public boolean accept(File file) {
/*  68 */             if (file.isDirectory()) {
/*  69 */               Out.info(new Object[] { file.getAbsolutePath() });
/*  70 */               JS2JMain.writeClass(file);
/*     */             } 
/*  72 */             if (file.getName().endsWith(".json")) {
/*  73 */               DataUtil.writeClass(file);
/*  74 */               return true;
/*     */             } 
/*  76 */             return false;
/*     */           }
/*     */         });
/*  79 */     TableCount += tables.length;
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/*  83 */     GConfig.getInstance().init(false);
/*  84 */     Out.setting();
/*  85 */     File root = new File(GConfig.getInstance().get("dir.game.data"));
/*  86 */     DataUtil.setDir("src/data/com/wanniu/game/data");
/*     */ 
/*     */     
/*  89 */     DataUtil.superClasses.put(Normal_WorldCO.class.getSimpleName(), MonsterBase.class.getName());
/*  90 */     DataUtil.superClasses.put(DungeonCO.class.getSimpleName(), MonsterBase.class.getName());
/*  91 */     DataUtil.superClasses.put(DemonTowerCO.class.getSimpleName(), MonsterBase.class.getName());
/*  92 */     DataUtil.superClasses.put(Dungeon_NormalCO.class.getSimpleName(), MonsterBase.class.getName());
/*  93 */     DataUtil.superClasses.put(Dungeon_EliteCO.class.getSimpleName(), MonsterBase.class.getName());
/*  94 */     DataUtil.superClasses.put(Dungeon_HeroCO.class.getSimpleName(), MonsterBase.class.getName());
/*     */     
/*  96 */     DataUtil.superClasses.put(MainLineCO.class.getSimpleName(), TaskBase.class.getName());
/*  97 */     DataUtil.superClasses.put(BranchLineCO.class.getSimpleName(), TaskBase.class.getName());
/*  98 */     DataUtil.superClasses.put(DailyCO.class.getSimpleName(), TaskBase.class.getName());
/*  99 */     DataUtil.superClasses.put(CircleSceneCO.class.getSimpleName(), TaskBase.class.getName());
/* 100 */     DataUtil.superClasses.put(CircleSceneCO.class.getSimpleName(), TaskBase.class.getName());
/* 101 */     DataUtil.superClasses.put(TreasureCO.class.getSimpleName(), TaskBase.class.getName());
/*     */ 
/*     */     
/* 104 */     DataUtil.superClasses.put(JewelCO.class.getSimpleName(), DItemBase.class.getName());
/* 105 */     DataUtil.superClasses.put(RideItemCO.class.getSimpleName(), DItemBase.class.getName());
/* 106 */     DataUtil.superClasses.put(PetItemCO.class.getSimpleName(), DItemBase.class.getName());
/* 107 */     DataUtil.superClasses.put(ChestCO.class.getSimpleName(), DItemBase.class.getName());
/* 108 */     DataUtil.superClasses.put(PotionCO.class.getSimpleName(), DItemBase.class.getName());
/* 109 */     DataUtil.superClasses.put(MateCO.class.getSimpleName(), DItemBase.class.getName());
/* 110 */     DataUtil.superClasses.put(MiscCO.class.getSimpleName(), DItemBase.class.getName());
/* 111 */     DataUtil.superClasses.put(VirtualCO.class.getSimpleName(), DItemBase.class.getName());
/* 112 */     DataUtil.superClasses.put(RankCO.class.getSimpleName(), DItemBase.class.getName());
/* 113 */     DataUtil.superClasses.put(QuestCO.class.getSimpleName(), DItemBase.class.getName());
/* 114 */     DataUtil.superClasses.put(ActiveCO.class.getSimpleName(), DItemBase.class.getName());
/* 115 */     DataUtil.superClasses.put(FashionItemCO.class.getSimpleName(), DItemBase.class.getName());
/*     */ 
/*     */     
/* 118 */     DataUtil.superClasses.put(NormalEquipCO.class.getSimpleName(), DEquipBase.class.getName());
/* 119 */     DataUtil.superClasses.put(BlueEquipCO.class.getSimpleName(), DEquipBase.class.getName());
/* 120 */     DataUtil.superClasses.put(PurpleEquipCO.class.getSimpleName(), DEquipBase.class.getName());
/* 121 */     DataUtil.superClasses.put(LegendEquipCO.class.getSimpleName(), DEquipBase.class.getName());
/* 122 */     DataUtil.superClasses.put(SuitEquipCO.class.getSimpleName(), DEquipBase.class.getName());
/* 123 */     DataUtil.superClasses.put(RideEquipCO.class.getSimpleName(), DEquipBase.class.getName());
/*     */ 
/*     */     
/* 126 */     DataUtil.superClasses.put(UniqueEquipCO.class.getSimpleName(), DEquipBase.class.getName());
/*     */ 
/*     */     
/* 129 */     DataUtil.superClasses.put(NormalMapCO.class.getSimpleName(), MapBase.class.getName());
/* 130 */     DataUtil.superClasses.put(DungeonMapCO.class.getSimpleName(), MapBase.class.getName());
/* 131 */     DataUtil.superClasses.put(GameMapCO.class.getSimpleName(), MapBase.class.getName());
/*     */     
/* 133 */     DataUtil.superClasses.put(MenuUISaleCO.class.getSimpleName(), SaleBase.class.getName());
/* 134 */     DataUtil.superClasses.put(NpcSaleCO.class.getSimpleName(), SaleBase.class.getName());
/*     */     
/* 136 */     DataUtil.superClasses.put(MallShopCO.class.getSimpleName(), IntergalShopBase.class.getName());
/* 137 */     DataUtil.superClasses.put(FateShopCO.class.getSimpleName(), IntergalShopBase.class.getName());
/* 138 */     DataUtil.superClasses.put(AthleticShopCO.class.getSimpleName(), IntergalShopBase.class.getName());
/* 139 */     DataUtil.superClasses.put(GuildShopCO.class.getSimpleName(), IntergalShopBase.class.getName());
/* 140 */     DataUtil.superClasses.put(SundryShopCO.class.getSimpleName(), IntergalShopBase.class.getName());
/*     */     
/* 142 */     DataUtil.addExtClass("com.wanniu.game.data");
/*     */     
/* 144 */     writeClass(root);
/* 145 */     Out.info(new Object[] { "生成表格数:", Integer.valueOf(TableCount) });
/*     */     
/* 147 */     DataUtil.writeGameData();
/* 148 */     System.exit(0);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\JS2JMain.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */