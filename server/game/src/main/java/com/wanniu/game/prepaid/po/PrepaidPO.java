/*    */ package com.wanniu.game.prepaid.po;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Date;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PrepaidPO
/*    */   extends GEntity
/*    */ {
/*    */   public String playerId;
/* 16 */   public Map<Integer, Integer> first_buy_record = new HashMap<>();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int firstCharge;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int total_charge;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int total_consume;
/*    */ 
/*    */ 
/*    */   
/*    */   public int dailyChargeDiamond;
/*    */ 
/*    */ 
/*    */   
/*    */   public int dailyPayRmb;
/*    */ 
/*    */ 
/*    */   
/* 43 */   public List<PrepaidRecord> chargeRecord = new ArrayList<>();
/*    */   public Date dailyDate;
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\prepaid\po\PrepaidPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */