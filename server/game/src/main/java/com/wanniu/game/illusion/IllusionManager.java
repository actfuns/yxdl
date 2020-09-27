/*     */ package com.wanniu.game.illusion;
/*     */ 
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.DateUtils;
/*     */ import com.wanniu.game.data.ExpReduceCO;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.GoldReduceCO;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.IllusionPO;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import pomelo.area.FightLevelHandler;
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
/*     */ public class IllusionManager
/*     */ {
/*     */   public WNPlayer player;
/*     */   public IllusionPO illusionPO;
/*     */   
/*     */   public IllusionManager(WNPlayer player, IllusionPO illusionPO) {
/*  41 */     this.player = player;
/*  42 */     this.illusionPO = illusionPO;
/*     */     
/*  44 */     if (this.illusionPO == null) {
/*  45 */       this.illusionPO = new IllusionPO();
/*     */     }
/*     */   }
/*     */   
/*     */   public int addAward(String code, int value) {
/*  50 */     if (code.equals("gold"))
/*  51 */       return addGold(value); 
/*  52 */     if (code.equals("exp"))
/*  53 */       return addExp(value); 
/*  54 */     if (code.equals("upexp")) {
/*  55 */       return addClassExp(value);
/*     */     }
/*  57 */     return value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int addExp(int exp) {
/*  65 */     ExpReduceCO limit = getExpReduceCO(this.player.getLevel());
/*  66 */     if (limit == null) {
/*  67 */       return 0;
/*     */     }
/*     */     
/*  70 */     int addExp = exp;
/*     */     
/*  72 */     if (this.illusionPO.todayExp >= limit.rate4) {
/*  73 */       addExp = (int)(addExp * 0.2F);
/*     */     
/*     */     }
/*  76 */     else if (this.illusionPO.todayExp >= limit.rate3) {
/*  77 */       addExp = (int)(addExp * 0.4F);
/*     */     
/*     */     }
/*  80 */     else if (this.illusionPO.todayExp >= limit.rate2) {
/*  81 */       addExp = (int)(addExp * 0.6F);
/*     */     
/*     */     }
/*  84 */     else if (this.illusionPO.todayExp >= limit.rate1) {
/*  85 */       addExp = (int)(addExp * 0.8F);
/*     */     }
/*     */     else {
/*     */       
/*  89 */       addExp *= 1;
/*     */     } 
/*     */     
/*  92 */     this.illusionPO.todayExp += addExp;
/*     */     
/*  94 */     if (addExp > 0) {
/*  95 */       pushChage();
/*     */     }
/*  97 */     return addExp;
/*     */   }
/*     */   
/*     */   private ExpReduceCO getExpReduceCO(int level) {
/* 101 */     List<ExpReduceCO> ts = GameData.findExpReduces(v -> (v.minLv <= level && level <= v.maxLv));
/* 102 */     return (ts.size() == 1) ? ts.get(0) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int addGold(int gold) {
/* 110 */     GoldReduceCO limit = getGoldReduceCO(this.player.getLevel());
/* 111 */     if (limit == null) {
/* 112 */       return 0;
/*     */     }
/*     */     
/* 115 */     int addGold = gold;
/*     */     
/* 117 */     if (this.illusionPO.todayGold >= limit.rate4) {
/* 118 */       addGold = (int)(addGold * 0.2F);
/*     */     
/*     */     }
/* 121 */     else if (this.illusionPO.todayGold >= limit.rate3) {
/* 122 */       addGold = (int)(addGold * 0.4F);
/*     */     
/*     */     }
/* 125 */     else if (this.illusionPO.todayGold >= limit.rate2) {
/* 126 */       addGold = (int)(addGold * 0.6F);
/*     */     
/*     */     }
/* 129 */     else if (this.illusionPO.todayGold >= limit.rate1) {
/* 130 */       addGold = (int)(addGold * 0.8F);
/*     */     }
/*     */     else {
/*     */       
/* 134 */       addGold *= 1;
/*     */     } 
/*     */     
/* 137 */     this.illusionPO.todayGold += addGold;
/*     */     
/* 139 */     if (addGold > 0) {
/* 140 */       pushChage();
/*     */     }
/* 142 */     return addGold;
/*     */   }
/*     */   
/*     */   private GoldReduceCO getGoldReduceCO(int level) {
/* 146 */     List<GoldReduceCO> ts = GameData.findGoldReduces(v -> (v.minLv <= level && level <= v.maxLv));
/* 147 */     return (ts.size() == 1) ? ts.get(0) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int addClassExp(int classExp) {
/* 154 */     return 0;
/*     */   }
/*     */   
/*     */   public void pushChage() {
/* 158 */     FightLevelHandler.IllusionPush.Builder push = FightLevelHandler.IllusionPush.newBuilder();
/* 159 */     push.setS2CTodayExp(this.illusionPO.todayExp);
/* 160 */     push.setS2CTodayClassexp(this.illusionPO.todayClassExp);
/* 161 */     push.setS2CTodayGold(this.illusionPO.todayGold);
/* 162 */     push.setS2CMaxExp(0);
/* 163 */     push.setS2CMaxClassexp(0);
/* 164 */     push.setS2CMaxGold(0);
/* 165 */     this.player.receive("area.fightLevelPush.illusionPush", (GeneratedMessage)push.build());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void refreshNewDay() {
/* 172 */     if (this.illusionPO != null) {
/* 173 */       boolean flag = (this.illusionPO.todayExp > 0 || this.illusionPO.todayClassExp > 0 || this.illusionPO.todayGold > 0);
/* 174 */       this.illusionPO.todayExp = 0;
/* 175 */       this.illusionPO.todayClassExp = 0;
/* 176 */       this.illusionPO.todayGold = 0;
/*     */       
/* 178 */       boolean flag2 = this.illusionPO.hasBoxData();
/* 179 */       this.illusionPO.resetBoxData();
/*     */       
/* 181 */       boolean flag3 = this.illusionPO.hasItemData();
/* 182 */       this.illusionPO.resetItemData();
/*     */       
/* 184 */       if (flag) {
/* 185 */         pushChage();
/*     */       }
/* 187 */       if (flag2 || flag3) {
/* 188 */         pushChageBy2();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void pushChageBy2() {
/* 197 */     FightLevelHandler.Illusion2Push.Builder push = FightLevelHandler.Illusion2Push.newBuilder();
/* 198 */     Map<Integer, Integer> boxs = this.illusionPO.boxs;
/* 199 */     Map<String, Integer> items = this.illusionPO.items;
/* 200 */     Integer lv1 = null;
/* 201 */     Integer lv2 = null;
/* 202 */     Integer lv3 = null;
/* 203 */     if (boxs != null) {
/* 204 */       lv1 = boxs.get(Integer.valueOf(1));
/* 205 */       lv2 = boxs.get(Integer.valueOf(2));
/* 206 */       lv3 = boxs.get(Integer.valueOf(3));
/*     */     } 
/* 208 */     push.setS2CTodayLv1((lv1 == null) ? 0 : lv1.intValue());
/* 209 */     push.setS2CTodayLv2((lv2 == null) ? 0 : lv2.intValue());
/* 210 */     push.setS2CTodayLv3((lv3 == null) ? 0 : lv3.intValue());
/* 211 */     push.setS2CMaxNum(GlobalConfig.Mysterious_MaxNumEveryday);
/* 212 */     if (items != null) {
/* 213 */       Set<Map.Entry<String, Integer>> sets = items.entrySet();
/* 214 */       for (Map.Entry<String, Integer> e : sets) {
/* 215 */         Integer vl = GlobalConfig.getItemCount(e.getKey());
/* 216 */         if (vl != null) {
/* 217 */           FightLevelHandler.MJItemMax.Builder bd = FightLevelHandler.MJItemMax.newBuilder();
/* 218 */           bd.setItemCode(e.getKey());
/* 219 */           bd.setS2CMaxMl(vl.intValue());
/* 220 */           bd.setS2CTodayMl(((Integer)e.getValue()).intValue());
/* 221 */           push.addItemInfo(bd);
/*     */         } 
/*     */       } 
/*     */     } 
/* 225 */     this.player.receive("area.fightLevelPush.illusion2Push", (GeneratedMessage)push.build());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canMonsterDrop() {
/* 234 */     return (this.illusionPO.calTotalNum() < GlobalConfig.Mysterious_MaxNumEveryday);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canNotDropBy2(String itemcode) {
/* 241 */     Integer lv = GlobalConfig.getMysteriousLv(itemcode);
/* 242 */     if (lv != null) {
/* 243 */       return (this.illusionPO.calTotalNum() >= GlobalConfig.Mysterious_MaxNumEveryday);
/*     */     }
/*     */     
/* 246 */     Integer itemCount = GlobalConfig.getItemCount(itemcode);
/* 247 */     if (itemCount != null) {
/* 248 */       return (this.illusionPO.calTotalItemNum(itemcode) >= itemCount.intValue());
/*     */     }
/*     */     
/* 251 */     return false;
/*     */   }
/*     */   
/*     */   public boolean addItemNum(Area area, String itemcode, int num) {
/* 255 */     if (area.sceneType == Const.SCENE_TYPE.ILLUSION_2.getValue()) {
/* 256 */       Integer lv = GlobalConfig.getMysteriousLv(itemcode);
/* 257 */       Integer itemCount = GlobalConfig.getItemCount(itemcode);
/* 258 */       if (lv == null && itemCount == null)
/*     */       {
/* 260 */         return true;
/*     */       }
/* 262 */       if (canNotDropBy2(itemcode)) {
/* 263 */         Out.info(new Object[] { "幻境2玩法获得超出上限了.playerId=", this.player.getId(), ",num=", Integer.valueOf(this.illusionPO.calTotalNum()), ",max=", Integer.valueOf(GlobalConfig.Mysterious_MaxNumEveryday) });
/* 264 */         return false;
/*     */       } 
/* 266 */       if (lv != null) {
/* 267 */         this.illusionPO.putBox(lv.intValue(), num);
/* 268 */       } else if (itemCount != null) {
/* 269 */         this.illusionPO.putItem(itemcode, num);
/*     */       } 
/* 271 */       pushChageBy2();
/* 272 */       Out.info(new Object[] { "幻境2玩法计数加加，playerId=", this.player.getId(), ",itemcode=", itemcode, ",itemnum=", Integer.valueOf(num) });
/*     */     } 
/* 274 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isInDouble() {
/* 278 */     Calendar startDate = Calendar.getInstance();
/* 279 */     Calendar endDate = Calendar.getInstance();
/* 280 */     Calendar nowDate = Calendar.getInstance();
/*     */     try {
/* 282 */       startDate.setTime(DateUtils.parse(GlobalConfig.DoubleGet_Begin, "yyyy-MM-dd HH:mm:ss"));
/* 283 */       endDate.setTime(DateUtils.parse(GlobalConfig.DoubleGet_End, "yyyy-MM-dd HH:mm:ss"));
/* 284 */       nowDate.setTime(new Date());
/* 285 */     } catch (Exception e) {
/* 286 */       e.printStackTrace();
/* 287 */       return false;
/*     */     } 
/* 289 */     if (nowDate.before(startDate)) {
/* 290 */       return false;
/*     */     }
/* 292 */     if (nowDate.after(endDate)) {
/* 293 */       return false;
/*     */     }
/* 295 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\illusion\IllusionManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */