/*     */ package com.wanniu.game.data.base;
/*     */ 
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ public abstract class MonsterBase
/*     */ {
/*  11 */   public Map<Integer, String> firstTcMap = new HashMap<>();
/*  12 */   public Map<Integer, String> personTcMap = new HashMap<>();
/*     */   
/*     */   public int iD;
/*     */   
/*     */   public String name;
/*     */   
/*     */   public String title;
/*     */   
/*     */   public int atype;
/*     */   
/*     */   public int sex;
/*     */   
/*     */   public int level;
/*     */   
/*     */   public int qcolor;
/*     */   
/*     */   public int type;
/*     */   
/*     */   public int fight_type;
/*     */   
/*     */   public int fight_count;
/*     */   
/*     */   public int aliveTime;
/*     */   
/*     */   public int killPlayerTime;
/*     */   
/*     */   public int prob1;
/*     */   
/*     */   public int reviveID1;
/*     */   
/*     */   public int prob2;
/*     */   
/*     */   public int reviveID2;
/*     */   
/*     */   public int prob3;
/*     */   
/*     */   public int reviveID3;
/*     */   
/*     */   public int prob4;
/*     */   
/*     */   public int reviveID4;
/*     */   
/*     */   public int dialogChance;
/*     */   
/*     */   public String dialogWords;
/*     */   
/*     */   public int deadDialogChance;
/*     */   
/*     */   public String deadDialogWords;
/*     */   
/*     */   public int idleSpeakChance;
/*     */   
/*     */   public String idleSpeakWords;
/*     */   
/*     */   public String idleSpeakCoolDown;
/*     */   
/*     */   public int fightSpeakChance;
/*     */   
/*     */   public String fightSpeakWords;
/*     */   
/*     */   public String fightSpeakCoolDown;
/*     */   
/*     */   public String deadSpeakWords;
/*     */   
/*     */   public int maxHP;
/*     */   
/*     */   public int maxMP;
/*     */   
/*     */   public int phy;
/*     */   
/*     */   public int mag;
/*     */   
/*     */   public int hit;
/*     */   
/*     */   public int dodge;
/*     */   
/*     */   public int cirt;
/*     */   
/*     */   public int resCirt;
/*     */   
/*     */   public int ac;
/*     */   
/*     */   public int resist;
/*     */   
/*     */   public int ignoreAc;
/*     */   
/*     */   public int ignoreResist;
/*     */   
/*     */   public int healEffect;
/*     */   
/*     */   public int healedEffect;
/*     */   
/*     */   public int baseExp;
/*     */   
/*     */   public int isAttack;
/*     */   
/*     */   public String ability;
/*     */   
/*     */   public String callAbilityPerHP;
/*     */   
/*     */   public String abilityPar;
/*     */   
/*     */   public int wingsReiki;
/*     */   
/*     */   public int shareType;
/*     */   
/*     */   public String firstTc;
/*     */   
/*     */   public String tc;
/*     */   
/*     */   public String showTc;
/*     */   
/*     */   public String teamTc;
/*     */   
/*     */   public String personTc;
/*     */   
/*     */   public int exdTask;
/*     */   
/*     */   public int baseHornor;
/*     */   
/*     */   public String icon;
/*     */   
/*     */   public int refresh;
/*     */   
/*     */   public int deadTimeMs;
/*     */   
/*     */   public String birthInfo;
/*     */   
/*     */   public String deathInfo;
/*     */   
/*     */   public String monsterDes;
/*     */   public String monsterRaid;
/*     */   public int goldPerMonLv;
/*     */   public int expRatio;
/*     */   
/*     */   public void initProperty() {
/* 148 */     if (StringUtil.isNotEmpty(this.firstTc)) {
/* 149 */       if (this.firstTc.indexOf(":") != -1) {
/* 150 */         String[] tcStrs = this.firstTc.split(";");
/* 151 */         for (int i = 0; i < tcStrs.length; i++) {
/* 152 */           String tcStr = tcStrs[i];
/* 153 */           if (StringUtil.isNotEmpty(tcStr)) {
/* 154 */             String[] tcData = tcStr.split(":");
/* 155 */             convertTcData(tcData, this.firstTcMap);
/*     */           } 
/*     */         } 
/*     */       } else {
/* 159 */         convertTcData(new String[] { "0", this.firstTc }, this.personTcMap);
/*     */       } 
/*     */     }
/*     */     
/* 163 */     if (StringUtil.isNotEmpty(this.personTc)) {
/* 164 */       if (this.personTc.indexOf(":") != -1) {
/* 165 */         String[] tcStrs = this.personTc.split(";");
/* 166 */         for (int i = 0; i < tcStrs.length; i++) {
/* 167 */           String tcStr = tcStrs[i];
/* 168 */           if (StringUtil.isNotEmpty(tcStr)) {
/* 169 */             String[] tcData = tcStr.split(":");
/* 170 */             convertTcData(tcData, this.personTcMap);
/*     */           } 
/*     */         } 
/*     */       } else {
/* 174 */         convertTcData(new String[] { "0", this.personTc }, this.personTcMap);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public void beforeProperty() {}
/*     */   
/*     */   public Integer getKey() {
/* 182 */     return Integer.valueOf(this.iD);
/*     */   }
/*     */   
/*     */   public void convertTcData(String[] tcData, Map<Integer, String> tcMap) {
/* 186 */     int pro = Integer.parseInt(tcData[0]);
/* 187 */     String tc = tcData[1];
/* 188 */     if (pro == Const.PlayerPro.COMMON.value) {
/* 189 */       tcMap.put(Integer.valueOf(Const.PlayerPro.YU_JIAN.value), tc);
/* 190 */       tcMap.put(Integer.valueOf(Const.PlayerPro.SHEN_JIAN.value), tc);
/* 191 */       tcMap.put(Integer.valueOf(Const.PlayerPro.CANG_LANG.value), tc);
/* 192 */       tcMap.put(Integer.valueOf(Const.PlayerPro.LI_NHU.value), tc);
/* 193 */       tcMap.put(Integer.valueOf(Const.PlayerPro.YI_XIAN.value), tc);
/*     */     } else {
/* 195 */       tcMap.put(Integer.valueOf(pro), tc);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\base\MonsterBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */