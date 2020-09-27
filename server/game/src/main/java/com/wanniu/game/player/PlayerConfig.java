/*    */ package com.wanniu.game.player;
/*    */ 
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.PrefixCO;
/*    */ import com.wanniu.game.data.SuffixCO;
/*    */ import com.wanniu.game.data.ext.UpLevelExpExt;
/*    */ import java.util.ArrayList;
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
/*    */ 
/*    */ public class PlayerConfig
/*    */ {
/* 22 */   public List<PrefixCO> randomname_prefix = null;
/*    */   
/*    */   public Map<Integer, List<SuffixCO>> randomname_suffix;
/*    */   private static PlayerConfig instance;
/*    */   
/*    */   public static PlayerConfig getInstance() {
/* 28 */     if (instance == null) {
/* 29 */       instance = new PlayerConfig();
/*    */     }
/* 31 */     return instance;
/*    */   }
/*    */ 
/*    */   
/*    */   private PlayerConfig() {
/* 36 */     this.randomname_prefix = new ArrayList<>(GameData.Prefixs.values());
/* 37 */     this.randomname_suffix = new HashMap<>();
/* 38 */     for (SuffixCO suffix : GameData.Suffixs.values()) {
/*    */       
/* 40 */       if (suffix.sex == 2) {
/* 41 */         ((List<SuffixCO>)this.randomname_suffix.computeIfAbsent(Integer.valueOf(0), key -> new ArrayList())).add(suffix);
/* 42 */         ((List<SuffixCO>)this.randomname_suffix.computeIfAbsent(Integer.valueOf(1), key -> new ArrayList())).add(suffix); continue;
/*    */       } 
/* 44 */       ((List<SuffixCO>)this.randomname_suffix.computeIfAbsent(Integer.valueOf(suffix.sex), key -> new ArrayList())).add(suffix);
/*    */     } 
/*    */   }
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
/*    */   public UpLevelExpExt findupLevelExpPropsByUpLevelAndPro(int upLevel, int pro) {
/* 58 */     GameData.findUpLevelExps(o -> 
/* 59 */         (o.classUPLevel == upLevel && o.Pro == pro));
/*    */     
/* 61 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\player\PlayerConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */