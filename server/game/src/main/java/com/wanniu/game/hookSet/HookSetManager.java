/*    */ package com.wanniu.game.hookSet;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.common.ConstsTR;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.HookSetPO;
/*    */ import com.wanniu.redis.PlayerPOManager;
/*    */ import java.util.List;
/*    */ import pomelo.area.HookSetHandler;
/*    */ import pomelo.player.PlayerOuterClass;
/*    */ 
/*    */ 
/*    */ public class HookSetManager
/*    */ {
/*    */   private final HookSetPO po;
/*    */   
/*    */   public HookSetManager(WNPlayer player, HookSetPO data) {
/* 20 */     if (data == null) {
/* 21 */       player.allBlobData.hookSetData = data = PlayerUtil.createHookSetManager(player.getId());
/* 22 */       PlayerPOManager.put(ConstsTR.hookSetTR, player.getId(), (GEntity)data);
/*    */     } 
/* 24 */     this.po = data;
/*    */   }
/*    */   
/*    */   public void changeHookSet(HookSetHandler.HookSetData hsd) {
/* 28 */     this.po.hpPercent = hsd.getHpPercent();
/* 29 */     this.po.mpPercent = hsd.getMpPercent();
/* 30 */     this.po.hpItemCode = hsd.getHpItemCode();
/* 31 */     this.po.mpItemCode = hsd.getMpItemCode();
/* 32 */     this.po.pkSet = hsd.getPkSet();
/* 33 */     this.po.meltQcolor = hsd.getMeltQcolorList();
/* 34 */     this.po.autoBuyHpItem = hsd.getAutoBuyHpItem();
/* 35 */     this.po.autoBuyMpItem = hsd.getAutoBuyMpItem();
/* 36 */     this.po.fieldMaphook = hsd.getFieldMaphook();
/* 37 */     this.po.areaMaphook = hsd.getAreaMaphook();
/*    */   }
/*    */   
/*    */   public PlayerOuterClass.HookSetData.Builder toJson4Payload() {
/* 41 */     PlayerOuterClass.HookSetData.Builder data = PlayerOuterClass.HookSetData.newBuilder();
/* 42 */     data.setHpPercent(this.po.hpPercent);
/* 43 */     data.setMpPercent(this.po.mpPercent);
/* 44 */     if (StringUtil.isNotEmpty(this.po.hpItemCode)) {
/* 45 */       data.setHpItemCode(this.po.hpItemCode);
/*    */     }
/*    */     
/* 48 */     if (StringUtil.isNotEmpty(this.po.mpItemCode)) {
/* 49 */       data.setMpItemCode(this.po.mpItemCode);
/*    */     } else {
/* 51 */       data.setMpItemCode("");
/*    */     } 
/*    */     
/* 54 */     data.setPkSet(this.po.pkSet);
/* 55 */     data.addAllMeltQcolor(this.po.meltQcolor);
/* 56 */     data.setAutoBuyHpItem(this.po.autoBuyHpItem);
/* 57 */     data.setAutoBuyMpItem(this.po.autoBuyMpItem);
/* 58 */     data.setFieldMaphook(this.po.fieldMaphook);
/* 59 */     data.setAreaMaphook(this.po.areaMaphook);
/* 60 */     return data;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<Integer> getMeltQcolor() {
/* 69 */     return this.po.meltQcolor;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\hookSet\HookSetManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */