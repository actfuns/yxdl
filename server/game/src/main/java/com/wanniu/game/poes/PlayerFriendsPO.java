/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBTable;
/*    */ import com.wanniu.game.friend.BlackActor;
/*    */ import com.wanniu.game.friend.FriendData;
/*    */ import com.wanniu.game.friend.FriendManager;
/*    */ import com.wanniu.game.friend.MessageDate;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Date;
/*    */ import java.util.HashMap;
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
/*    */ @DBTable("player_friends")
/*    */ public class PlayerFriendsPO
/*    */   extends GEntity
/*    */ {
/* 39 */   public Map<String, FriendData> friends = new HashMap<>();
/* 40 */   public Date addPointTime = new Date(0L);
/* 41 */   public Date friendShipTime = new Date(0L); public int addPointToday;
/* 42 */   public Map<String, FriendManager.ApplyFriendData> applyFriendIds = new HashMap<>();
/* 43 */   public Map<String, BlackActor> blackList = new HashMap<>();
/* 44 */   public List<MessageDate> friendMessage = new ArrayList<>();
/* 45 */   public Map<String, FriendManager.RecordInfo> recordInfos = new HashMap<>();
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\PlayerFriendsPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */