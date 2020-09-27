/*    */ package com.wanniu.game.mount;
/*    */ 
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.ext.RideListExt;
/*    */ import com.wanniu.game.data.ext.SkinListExt;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.TreeMap;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MountConfig
/*    */ {
/*    */   private static MountConfig instance;
/*    */   
/*    */   public static MountConfig getInstance() {
/* 18 */     if (instance == null) {
/* 19 */       instance = new MountConfig();
/*    */     }
/* 21 */     return instance;
/*    */   }
/*    */   
/* 24 */   private Map<Integer, RideListExt> mountTable = GameData.RideLists;
/* 25 */   private Map<Integer, SkinListExt> mountSkinTable = GameData.SkinLists;
/*    */ 
/*    */   
/*    */   public List<RideListExt> getMountPropList() {
/* 29 */     return new ArrayList<>(GameData.RideLists.values());
/*    */   }
/*    */ 
/*    */   
/*    */   public List<SkinListExt> getMountSkinPropList() {
/* 34 */     return new ArrayList<>(GameData.SkinLists.values());
/*    */   }
/*    */ 
/*    */   
/*    */   public RideListExt getMountPropByID(int mountId) {
/* 39 */     return this.mountTable.get(Integer.valueOf(mountId));
/*    */   }
/*    */ 
/*    */   
/*    */   public SkinListExt getMountSkinPropByID(int skinId) {
/* 44 */     return this.mountSkinTable.get(Integer.valueOf(skinId));
/*    */   }
/*    */   
/*    */   public Map<String, Integer> getSkinTotalAttribute(List<Integer> skinAry) {
/* 48 */     Map<String, Integer> attrTable = new TreeMap<>();
/* 49 */     for (Map.Entry<Integer, SkinListExt> node : this.mountSkinTable.entrySet()) {
/* 50 */       SkinListExt skin = node.getValue();
/* 51 */       if (skinAry.indexOf(Integer.valueOf(skin.skinID)) != -1);
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 62 */     return attrTable;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\mount\MountConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */