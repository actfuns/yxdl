/*    */ package com.wanniu.game.player.bi.jsfunny;
/*    */ 
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import com.wanniu.core.util.DateUtils;
/*    */ import com.wanniu.game.GWorld;
/*    */ import com.wanniu.redis.PublishCenter;
/*    */ import java.time.LocalDateTime;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.UUID;
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
/*    */ public abstract class AnsycPublisher
/*    */ {
/*    */   private final String uuid;
/*    */   protected final LocalDateTime now;
/* 34 */   protected final Map<String, Object> data = new HashMap<>();
/*    */ 
/*    */ 
/*    */   
/*    */   protected abstract String channel();
/*    */ 
/*    */   
/*    */   protected boolean oneDay() {
/* 42 */     return false;
/*    */   }
/*    */   
/*    */   public AnsycPublisher() {
/* 46 */     this.now = LocalDateTime.now();
/* 47 */     this.uuid = UUID.randomUUID().toString();
/* 48 */     this.data.put("_id", this.uuid);
/* 49 */     this.data.put("sid", Integer.valueOf(GWorld.__SERVER_ID));
/* 50 */     this.data.put("date", this.now.format(DateUtils.F_YYYYMMDDHHMMSS));
/*    */ 
/*    */     
/* 53 */     if (oneDay()) {
/* 54 */       this.data.put("_one_day", Boolean.valueOf(true));
/*    */     }
/*    */   }
/*    */   
/*    */   public void publishing() {
/* 59 */     GWorld.getInstance().ansycExec(() -> PublishCenter.publish(channel(), JSON.toJSONString(this.data)));
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\player\bi\jsfunny\AnsycPublisher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */