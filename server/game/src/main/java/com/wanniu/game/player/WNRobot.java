/*     */ package com.wanniu.game.player;
/*     */ 
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.game.protocol.PomeloPush;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.tcp.protocol.Message;
/*     */ import com.wanniu.core.util.RandomUtil;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.common.msg.MessagePush;
/*     */ import com.wanniu.game.message.MessageData;
/*     */ import com.wanniu.game.player.po.AllBlobPO;
/*     */ import com.wanniu.game.poes.PlayerPO;
/*     */ import com.wanniu.game.util.RobotUtil;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ScheduledFuture;
/*     */ import pomelo.Common;
/*     */ import pomelo.area.FightLevelHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WNRobot
/*     */   extends WNPlayer
/*     */ {
/*     */   public ScheduledFuture<?> quitTeamFuture;
/*     */   public ScheduledFuture<?> handFuture;
/*     */   public ScheduledFuture<?> hpFuture;
/*     */   
/*     */   public WNRobot(AllBlobPO allBlobData) {
/*  38 */     super(allBlobData);
/*     */   }
/*     */   
/*     */   public WNRobot(PlayerPO player) {
/*  42 */     super(player);
/*     */   }
/*     */   
/*     */   public boolean isRobot() {
/*  46 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void sync() {
/*  51 */     Out.debug(new Object[] { "sync................" });
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean onMessage(int operate, MessageData message) {
/*  56 */     Out.debug(new Object[] { "onMessage................", Integer.valueOf(message.messageType) });
/*  57 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void pushEffectData() {
/*  62 */     Out.debug(new Object[] { "pushEffectData................" });
/*     */   }
/*     */ 
/*     */   
/*     */   public void pushDynamicData(String key, Object value) {
/*  67 */     Out.debug(new Object[] { "pushDynamicData1................" });
/*     */   }
/*     */ 
/*     */   
/*     */   public void pushDynamicData(String key, Object value, Const.GOODS_CHANGE_TYPE origin) {
/*  72 */     Out.debug(new Object[] { "pushDynamicData2................" });
/*     */   }
/*     */ 
/*     */   
/*     */   public void pushDynamicData(String key, Object value, Const.GOODS_CHANGE_TYPE origin, List<Common.KeyValueStruct> itemChange) {
/*  77 */     Out.debug(new Object[] { "pushDynamicData3................" });
/*     */   }
/*     */ 
/*     */   
/*     */   public void pushDynamicData(Map<String, Object> atts) {
/*  82 */     Out.debug(new Object[] { "pushDynamicData4................" });
/*     */   }
/*     */ 
/*     */   
/*     */   public void pushAndRefreshEffect(boolean isHpMpValid) {
/*  87 */     Out.debug(new Object[] { "pushAndRefreshEffect................" });
/*     */   }
/*     */ 
/*     */   
/*     */   public void sendSysTip(String content) {
/*  92 */     Out.debug(new Object[] { "sendSysTip................" });
/*     */   }
/*     */ 
/*     */   
/*     */   public void sendSysTip(String content, Const.TipsType type) {
/*  97 */     Out.debug(new Object[] { "sendSysTip2................" });
/*     */   }
/*     */ 
/*     */   
/*     */   public void puchFuncGoToTicketNotEnough() {
/* 102 */     Out.debug(new Object[] { "puchFuncGoToTicketNotEnough................" });
/*     */   }
/*     */ 
/*     */   
/*     */   public void puchFuncGoToPickItem() {
/* 107 */     Out.debug(new Object[] { "puchFuncGoToPickItem................" });
/*     */   }
/*     */ 
/*     */   
/*     */   public void sendLeaveWord() {
/* 112 */     Out.debug(new Object[] { "sendLeaveWord................" });
/*     */   }
/*     */ 
/*     */   
/*     */   public void pushChatSystemMessage(Const.SYS_CHAT_TYPE type, String value1, Object value2, String value3) {
/* 117 */     Out.debug(new Object[] { "pushChatSystemMessage................" });
/*     */   }
/*     */ 
/*     */   
/*     */   public void pushChatSystemMessage(Const.SYS_CHAT_TYPE type, String value1, Object value2, String value3, Const.GOODS_CHANGE_TYPE from) {
/* 122 */     Out.debug(new Object[] { "pushChatSystemMessage2................" });
/*     */   }
/*     */ 
/*     */   
/*     */   public void update() {
/* 127 */     Out.warn(new Object[] { "update................" });
/*     */   }
/*     */   
/*     */   public void free() {
/* 131 */     Out.info(new Object[] { "free robot >> ", getName() });
/*     */     try {
/* 133 */       if (this.hpFuture != null) {
/* 134 */         this.hpFuture.cancel(true);
/* 135 */         this.hpFuture = null;
/*     */       } 
/* 137 */       getTeamManager().setTeamData(null);
/* 138 */       if (this.quitTeamFuture != null) {
/* 139 */         this.quitTeamFuture.cancel(true);
/* 140 */         this.quitTeamFuture = null;
/*     */       } 
/*     */     } finally {
/* 143 */       JobFactory.addDelayJob(() -> RobotUtil.freeRobot(this), 
/*     */           
/* 145 */           Utils.getSecMills(5, 10));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void receive(Message msg) {
/* 151 */     String route = ((PomeloPush)msg).getRoute();
/* 152 */     if (route == null) {
/*     */       return;
/*     */     }
/* 155 */     if (route.endsWith("throwPointItemListPush") && 
/* 156 */       RandomUtil.getInt(100) < 70) {
/* 157 */       Area area = getArea();
/* 158 */       area.onRobotThrowPoint(this);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(Message msg) {
/* 167 */     String route = ((PomeloPush)msg).getRoute();
/* 168 */     if (route == null) {
/*     */       return;
/*     */     }
/* 171 */     if (route.endsWith("onConfirmEnterFubenPush")) {
/* 172 */       handConfirmEnterFuben(((MessagePush)msg).getMsg());
/* 173 */     } else if (route.endsWith("closeHandUpPush") && 
/* 174 */       this.handFuture != null) {
/* 175 */       this.handFuture.cancel(true);
/* 176 */       this.handFuture = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void receive(String route, GeneratedMessage msg) {
/* 185 */     if (route.endsWith("playerRelivePush")) {
/* 186 */       RobotUtil.onRobotDie(this.area, this);
/* 187 */     } else if (route.endsWith("onConfirmEnterFubenPush")) {
/* 188 */       handConfirmEnterFuben(msg);
/* 189 */     } else if (route.endsWith("five2FiveApplyMatchPush")) {
/* 190 */       JobFactory.addDelayJob(() -> this.five2FiveManager.refuseMatch(this), 
/*     */           
/* 192 */           Utils.getSecMills(2, 8));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handConfirmEnterFuben(GeneratedMessage msg) {
/* 199 */     FightLevelHandler.OnConfirmEnterFubenPush fuben = (FightLevelHandler.OnConfirmEnterFubenPush)msg;
/* 200 */     this.handFuture = JobFactory.addDelayJob(() -> {
/*     */           this.handFuture = null;
/*     */           this.fightLevelManager.replyEnterDungeon(this, Const.HandsUpState.ACCEPT.value, fuben.getS2CFubenId());
/* 203 */         }Utils.getSecMills(1, 10));
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\player\WNRobot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */