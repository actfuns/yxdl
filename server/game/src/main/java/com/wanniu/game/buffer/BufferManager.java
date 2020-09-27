/*     */ package com.wanniu.game.buffer;
/*     */ 
/*     */ import Xmds.RefreshPlayerPropertyChange;
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.data.AttributeCO;
/*     */ import com.wanniu.game.player.AttributeUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import pomelo.area.PlayerHandler;
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
/*     */ public class BufferManager
/*     */ {
/*     */   public WNPlayer player;
/*     */   public List<RefreshPlayerPropertyChange> buffs;
/*     */   public List<RefreshPlayerPropertyChange> localBuffs;
/*     */   
/*     */   protected BufferManager() {}
/*     */   
/*     */   public BufferManager(WNPlayer player) {
/*  34 */     this.buffs = new ArrayList<>();
/*  35 */     this.localBuffs = new ArrayList<>();
/*  36 */     this.player = player;
/*     */     
/*  38 */     _clear();
/*  39 */     clearLocalBuff();
/*     */   }
/*     */ 
/*     */   
/*     */   public void _clear() {
/*  44 */     int len = this.buffs.size();
/*  45 */     long nowTime = System.currentTimeMillis();
/*  46 */     for (int i = len - 1; i >= 0; i--) {
/*  47 */       RefreshPlayerPropertyChange buff = this.buffs.get(i);
/*  48 */       if (buff.timestamp < nowTime)
/*     */       {
/*  50 */         this.buffs.remove(i);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void clearLocalBuff() {
/*  56 */     long nowTime = System.currentTimeMillis();
/*  57 */     int len = this.localBuffs.size();
/*  58 */     for (int i = len - 1; i >= 0; i--) {
/*  59 */       RefreshPlayerPropertyChange buff = this.localBuffs.get(i);
/*  60 */       if (buff.timestamp < nowTime) {
/*  61 */         this.localBuffs.remove(i);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void toJson4Serialize() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(RefreshPlayerPropertyChange buff) {
/*  75 */     this.buffs.add(buff);
/*     */   }
/*     */   
/*     */   public void send2BattleServer() {
/*  79 */     _clear();
/*  80 */     Out.debug(new Object[] { "send2BattleServer :", this.buffs });
/*  81 */     for (int i = 0; i < this.buffs.size(); i++) {
/*  82 */       this.player.refreshPlayerPropertyChange(this.buffs.get(i));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addLocalBuff(String key, long time, int value) {
/*  94 */     boolean addResult = false;
/*  95 */     long nowTime = System.currentTimeMillis();
/*  96 */     int len = this.localBuffs.size();
/*  97 */     for (int i = len - 1; i >= 0; i--) {
/*  98 */       RefreshPlayerPropertyChange buff = this.localBuffs.get(i);
/*  99 */       if (buff.key.equals(key) && buff.value == value) {
/* 100 */         long oldExpireTime = Math.max(buff.timestamp, nowTime);
/* 101 */         buff.timestamp = oldExpireTime + time;
/* 102 */         addResult = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 106 */     if (!addResult) {
/* 107 */       AttributeCO prop = AttributeUtil.getPropByKey(key);
/* 108 */       if (prop != null) {
/* 109 */         RefreshPlayerPropertyChange buff = new RefreshPlayerPropertyChange();
/* 110 */         buff.key = key;
/* 111 */         buff.value = value;
/* 112 */         buff.timestamp = nowTime + time;
/* 113 */         this.localBuffs.add(buff);
/* 114 */         addResult = true;
/*     */       } 
/*     */     } 
/* 117 */     if (addResult) {
/* 118 */       pushLocalBuffToClient();
/*     */     }
/* 120 */     return addResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBuffAttrValue(String key) {
/* 130 */     int attrValue = 0;
/* 131 */     int len = this.localBuffs.size();
/* 132 */     long nowTime = System.currentTimeMillis();
/* 133 */     for (int i = len - 1; i >= 0; i--) {
/* 134 */       RefreshPlayerPropertyChange buff = this.localBuffs.get(i);
/* 135 */       if (buff.key.equals(key) && buff.timestamp >= nowTime)
/*     */       {
/*     */         
/* 138 */         attrValue += buff.value; } 
/*     */     } 
/* 140 */     return attrValue;
/*     */   }
/*     */   
/*     */   public List<PlayerHandler.BuffInfo> toJson4LocalBuffPayLoad() {
/* 144 */     List<PlayerHandler.BuffInfo> buffList = new ArrayList<>();
/* 145 */     int len = this.localBuffs.size();
/* 146 */     long nowTime = System.currentTimeMillis();
/* 147 */     for (int i = len - 1; i >= 0; i--) {
/* 148 */       RefreshPlayerPropertyChange buff = this.localBuffs.get(i);
/* 149 */       if (buff.timestamp < nowTime) {
/* 150 */         this.localBuffs.remove(i);
/*     */       } else {
/*     */         
/* 153 */         AttributeCO prop = AttributeUtil.getPropByKey(buff.key);
/* 154 */         if (prop != null)
/*     */         
/*     */         { 
/* 157 */           PlayerHandler.BuffInfo.Builder temp = PlayerHandler.BuffInfo.newBuilder();
/* 158 */           temp.setId(prop.iD);
/* 159 */           temp.setValue(buff.value);
/* 160 */           temp.setIsFormat(prop.isFormat);
/* 161 */           temp.setExpireTime((int)Math.floor((buff.timestamp / 1000L)));
/*     */           
/* 163 */           buffList.add(temp.build()); } 
/*     */       } 
/* 165 */     }  buffList.sort(new Comparator<PlayerHandler.BuffInfo>()
/*     */         {
/*     */           public int compare(PlayerHandler.BuffInfo o1, PlayerHandler.BuffInfo o2) {
/* 168 */             return o1.getExpireTime() - o2.getExpireTime();
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 173 */     return buffList;
/*     */   }
/*     */ 
/*     */   
/*     */   public void pushLocalBuffToClient() {
/* 178 */     if (this.localBuffs.isEmpty()) {
/*     */       return;
/*     */     }
/* 181 */     List<PlayerHandler.BuffInfo> buffs = toJson4LocalBuffPayLoad();
/* 182 */     PlayerHandler.BuffPropertyPush.Builder data = PlayerHandler.BuffPropertyPush.newBuilder();
/* 183 */     data.addAllBuffList(buffs);
/* 184 */     this.player.receive("area.playerPush.buffPropertyPush", (GeneratedMessage)data.build());
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\buffer\BufferManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */