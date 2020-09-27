/*    */ package com.wanniu.game.solo;
/*    */ 
/*    */ import com.wanniu.game.area.Area;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ 
/*    */ public class MatchedTeam
/*    */ {
/* 12 */   private Map<String, WNPlayer> members = new ConcurrentHashMap<>(2);
/* 13 */   private Area battleArea = null;
/*    */   
/*    */   public MatchedTeam(WNPlayer a, WNPlayer b) {
/* 16 */     this.members.put("A", a);
/* 17 */     this.members.put("B", b);
/*    */   }
/*    */   
/*    */   public Area getBattleArea() {
/* 21 */     return this.battleArea;
/*    */   }
/*    */   
/*    */   public void setBattleArea(Area battleArea) {
/* 25 */     this.battleArea = battleArea;
/*    */   }
/*    */   
/*    */   public Collection<WNPlayer> getAllPlayers() {
/* 29 */     return this.members.values();
/*    */   }
/*    */   
/*    */   public WNPlayer getPlayerA() {
/* 33 */     return this.members.get("A");
/*    */   }
/*    */   
/*    */   public WNPlayer getPlayerB() {
/* 37 */     return this.members.get("B");
/*    */   }
/*    */   
/*    */   public WNPlayer getPlayer(String playerId) {
/* 41 */     return find(playerId);
/*    */   }
/*    */   
/*    */   public boolean isIn(WNPlayer player) {
/* 45 */     return (find(player.getId()) != null);
/*    */   }
/*    */   
/*    */   public void remove(String playerId) {
/* 49 */     Iterator<WNPlayer> iter = this.members.values().iterator();
/* 50 */     while (iter.hasNext()) {
/* 51 */       WNPlayer p = iter.next();
/* 52 */       if (p.getId().equals(playerId)) {
/* 53 */         iter.remove();
/*    */         return;
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   private WNPlayer find(String playerId) {
/* 60 */     for (WNPlayer p : this.members.values()) {
/* 61 */       if (playerId.equals(p.getId())) {
/* 62 */         return p;
/*    */       }
/*    */     } 
/*    */     
/* 66 */     return null;
/*    */   }
/*    */   
/*    */   public int memberSize() {
/* 70 */     return this.members.size();
/*    */   }
/*    */   
/*    */   public void clear() {
/* 74 */     this.members.clear();
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\solo\MatchedTeam.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */