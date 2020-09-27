/*    */ package com.wanniu.game.activity;
/*    */ 
/*    */ import cn.qeng.common.gm.po.GameNoticePO;
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.common.Utils;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.request.activity.ActivityNoticeHandler;
/*    */ import com.wanniu.redis.GlobalDao;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
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
/*    */ 
/*    */ 
/*    */ public class ActivityNoticeService
/*    */ {
/* 37 */   private static final ActivityNoticeService instance = new ActivityNoticeService();
/*    */   
/*    */   private static final int SYNC_INTERVAL = 60000;
/*    */   
/* 41 */   private long nextSyncTime = System.currentTimeMillis();
/*    */   
/* 43 */   private List<GameNoticePO> cacheNotices = new ArrayList<>();
/* 44 */   private List<String> cacheNoticeIds = new ArrayList<>();
/*    */   
/*    */   public static ActivityNoticeService getInstance() {
/* 47 */     return instance;
/*    */   }
/*    */   
/*    */   public String getNotice(WNPlayer player) {
/* 51 */     long now = System.currentTimeMillis();
/* 52 */     if (now >= this.nextSyncTime) {
/* 53 */       sync(now);
/*    */     } else {
/* 55 */       Out.debug(new Object[] { "命中缓存游戏内公告..." });
/*    */     } 
/* 57 */     ArrayList<ActivityNoticeHandler.ContextInfo> list = new ArrayList<>(this.cacheNotices.size());
/* 58 */     for (GameNoticePO prop : this.cacheNotices) {
/* 59 */       ActivityNoticeHandler.ContextInfo info = new ActivityNoticeHandler.ContextInfo();
/* 60 */       info.ID = prop.getId();
/* 61 */       info.NoticeTitle = prop.getName();
/* 62 */       info.ReleaseTime = prop.getCreateDate();
/* 63 */       info.ReleasePerson = "";
/* 64 */       info.Content = prop.getContent();
/* 65 */       info.isRead = player.activityManager.isReward(prop.getId()) ? 1 : 0;
/* 66 */       list.add(info);
/*    */     } 
/* 68 */     return JSON.toJSONString(list);
/*    */   }
/*    */   
/*    */   private void sync(long now) {
/* 72 */     Out.debug(new Object[] { "开始同步游戏内公告..." });
/* 73 */     Map<String, String> map = GlobalDao.hgetAll("game_notice");
/* 74 */     List<GameNoticePO> listPo = new ArrayList<>(map.size());
/* 75 */     List<String> noticeIds = new ArrayList<>();
/* 76 */     map.forEach((k, v) -> {
/*    */           listPo.add(Utils.deserialize(v, GameNoticePO.class));
/*    */           
/*    */           noticeIds.add(k);
/*    */         });
/* 81 */     Collections.sort(listPo, (o1, o2) -> o2.getId() - o1.getId());
/*    */     
/* 83 */     this.cacheNotices = listPo;
/* 84 */     this.cacheNoticeIds = noticeIds;
/* 85 */     this.nextSyncTime = now + 60000L;
/*    */   }
/*    */   
/*    */   public List<String> getNoticeKey() {
/* 89 */     return this.cacheNoticeIds;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\activity\ActivityNoticeService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */