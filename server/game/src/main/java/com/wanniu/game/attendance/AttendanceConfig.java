/*    */ package com.wanniu.game.attendance;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.ext.AccumulateExt;
/*    */ import com.wanniu.game.data.ext.LuxurySignExt;
/*    */ import com.wanniu.game.data.ext.NormalSignExt;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AttendanceConfig
/*    */ {
/*    */   private static AttendanceConfig instance;
/*    */   
/*    */   public static AttendanceConfig getInstance() {
/* 21 */     if (instance == null) {
/* 22 */       instance = new AttendanceConfig();
/*    */     }
/* 24 */     return instance;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final AccumulateExt findDaccumulateWithIDAndRound(int round, int id) {
/* 32 */     for (AccumulateExt dac : GameData.Accumulates.values()) {
/* 33 */       if (dac.id == id && dac.round == round) {
/* 34 */         return dac;
/*    */       }
/*    */     } 
/* 37 */     Out.error(new Object[] { getClass().getName(), " : Can`t find Daccumulate By id = ", Integer.valueOf(id), "  round = ", Integer.valueOf(round) });
/* 38 */     return null;
/*    */   }
/*    */   
/*    */   public final LuxurySignExt findDluxurySignWithID(int id) {
/* 42 */     for (LuxurySignExt dac : GameData.LuxurySigns.values()) {
/* 43 */       if (dac.id == id) {
/* 44 */         return dac;
/*    */       }
/*    */     } 
/* 47 */     Out.error(new Object[] { getClass().getName(), " : Can`t find Dluxury_sign By id = ", Integer.valueOf(id) });
/* 48 */     return null;
/*    */   }
/*    */   
/*    */   public final NormalSignExt findDnormalSignWithIDAndRound(int round, int id) {
/* 52 */     for (NormalSignExt dac : GameData.NormalSigns.values()) {
/* 53 */       if (dac.id == id && dac.round == round) {
/* 54 */         return dac;
/*    */       }
/*    */     } 
/* 57 */     Out.error(new Object[] { getClass().getName(), " : Can`t find Dnormal_sign By id = ", Integer.valueOf(id), "  round = ", Integer.valueOf(round) });
/* 58 */     return null;
/*    */   }
/*    */   
/*    */   public final ArrayList<NormalSignExt> getDnormalSignsWithRound(int round) {
/* 62 */     ArrayList<NormalSignExt> list = new ArrayList<>();
/* 63 */     for (NormalSignExt dac : GameData.NormalSigns.values()) {
/* 64 */       if (dac.round == round) {
/* 65 */         list.add(dac);
/*    */       }
/*    */     } 
/* 68 */     return list;
/*    */   }
/*    */   
/*    */   public final ArrayList<AccumulateExt> getDaccumulateWithRound(int round) {
/* 72 */     ArrayList<AccumulateExt> list = new ArrayList<>();
/* 73 */     for (AccumulateExt dac : GameData.Accumulates.values()) {
/* 74 */       if (dac.round == round) {
/* 75 */         list.add(dac);
/*    */       }
/*    */     } 
/* 78 */     return list;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\attendance\AttendanceConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */