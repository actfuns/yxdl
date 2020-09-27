/*    */ package com.wanniu.game.redpacket;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.util.RandomUtil;
/*    */ import com.wanniu.game.player.GlobalConfig;
/*    */ import java.util.Date;
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ import java.util.UUID;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RedPacket
/*    */ {
/*    */   public String id;
/*    */   public String providerId;
/*    */   public String providerName;
/*    */   public String providerGuildId;
/*    */   public Date dispatchDate;
/*    */   public int totalNum;
/*    */   public int count;
/*    */   public int fetchType;
/*    */   public int benifitType;
/*    */   public String msg;
/* 28 */   public List<RedPacketFetchInfo> redPacketFetchInfoList = new LinkedList<>();
/*    */   
/*    */   public RedPacket() {}
/*    */   
/*    */   public RedPacket(String providerId, String providerName, String providerGuildId, int totalNum, int count, int fetchType, int benifitType, String msg) {
/* 33 */     this();
/* 34 */     if (totalNum <= 0 || count <= 0) {
/* 35 */       Out.error(new Object[] { "参数错误！" });
/*    */       
/*    */       return;
/*    */     } 
/* 39 */     this.id = UUID.randomUUID().toString();
/* 40 */     this.providerId = providerId;
/* 41 */     this.providerName = providerName;
/* 42 */     this.providerGuildId = providerGuildId;
/* 43 */     this.dispatchDate = new Date();
/* 44 */     this.totalNum = totalNum;
/* 45 */     this.count = count;
/*    */     
/* 47 */     this.fetchType = fetchType;
/* 48 */     this.benifitType = benifitType;
/* 49 */     this.msg = msg;
/*    */     
/* 51 */     int scale = (benifitType == 0) ? 1 : GlobalConfig.Red_HongbaoRatio;
/* 52 */     int per = totalNum * scale / count;
/* 53 */     int left = totalNum * scale % count;
/*    */ 
/*    */ 
/*    */     
/*    */     int i;
/*    */ 
/*    */     
/* 60 */     for (i = 0; i < count; i++) {
/* 61 */       RedPacketFetchInfo redPacketFetchInfo = new RedPacketFetchInfo(per + ((left-- > 0) ? 1 : 0));
/* 62 */       this.redPacketFetchInfoList.add(redPacketFetchInfo);
/*    */     } 
/* 64 */     for (i = 0; i < count; i++) {
/* 65 */       RedPacketFetchInfo redPacketFetchInfo1 = this.redPacketFetchInfoList.get(i);
/* 66 */       RedPacketFetchInfo redPacketFetchInfo2 = this.redPacketFetchInfoList.get((i + 1) % count);
/* 67 */       int randomValue = RandomUtil.random(per);
/* 68 */       redPacketFetchInfo1.num += randomValue;
/* 69 */       redPacketFetchInfo2.num -= randomValue;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\redpacket\RedPacket.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */