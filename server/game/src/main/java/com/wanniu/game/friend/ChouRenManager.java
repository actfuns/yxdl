/*     */ package com.wanniu.game.friend;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GEntity;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.functionOpen.FunctionOpenUtil;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.PlayerChouRenPO;
/*     */ import com.wanniu.game.social.SocialFriendProps;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ import pomelo.area.FriendHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChouRenManager
/*     */ {
/*     */   private WNPlayer player;
/*     */   public PlayerChouRenPO data;
/*     */   private int chouRensNum;
/*     */   
/*     */   public ChouRenManager(WNPlayer player, PlayerChouRenPO data) {
/*  34 */     this.player = player;
/*  35 */     this.data = data;
/*  36 */     if (this.data == null) {
/*  37 */       this.data = new PlayerChouRenPO();
/*  38 */       this.data.chouRens = new HashMap<>();
/*  39 */       PlayerPOManager.put(ConstsTR.player_chourenTR, player.getId(), (GEntity)this.data);
/*     */     } 
/*  41 */     this.chouRensNum = this.data.chouRens.size();
/*     */   }
/*     */   
/*     */   public FriendHandler.PlayerInfo chouRenToJson4PayLoad(ChouRenData chouRen) {
/*  45 */     String chouRenId = chouRen.chouRenId;
/*  46 */     Out.debug(new Object[] { "payload仇人数据ID: ", chouRen.chouRenId });
/*     */     
/*  48 */     FriendHandler.PlayerInfo.Builder data = this.player.getFriendManager().getPlayerBaseData(chouRenId);
/*  49 */     data.setId(chouRenId);
/*  50 */     data.setIcon(1);
/*  51 */     data.setChouHenPoint(chouRen.chouHenPoint);
/*  52 */     data.setCreateTimeStamp(chouRen.createTimeStamp.toString());
/*  53 */     data.setIsOnline(PlayerUtil.isOnline(chouRenId) ? 1 : 0);
/*     */     
/*  55 */     FriendHandler.Position.Builder currentPos = FriendHandler.Position.newBuilder();
/*     */     
/*  57 */     if (data.getIsOnline() > 0) {
/*  58 */       WNPlayer chouRenPlayer = PlayerUtil.findPlayer(chouRenId);
/*  59 */       Area area = chouRenPlayer.getArea();
/*  60 */       if (null != area) {
/*  61 */         currentPos.setAreaName(area.getSceneName());
/*  62 */         currentPos.setAreaId(area.areaId);
/*     */       } 
/*     */     } 
/*  65 */     data.setCurrentPos(currentPos.build());
/*     */     
/*  67 */     Out.debug(new Object[] { "payload仇人数据: ", data });
/*  68 */     return data.build();
/*     */   }
/*     */   
/*     */   public List<FriendHandler.PlayerInfo> getAllChouRens() {
/*  72 */     List<FriendHandler.PlayerInfo> chouRens = new ArrayList<>();
/*  73 */     for (Map.Entry<String, ChouRenData> node : (Iterable<Map.Entry<String, ChouRenData>>)this.data.chouRens.entrySet()) {
/*  74 */       FriendHandler.PlayerInfo chouRen = chouRenToJson4PayLoad(node.getValue());
/*  75 */       chouRens.add(chouRen);
/*     */     } 
/*  77 */     chouRens.sort(new Comparator<FriendHandler.PlayerInfo>()
/*     */         {
/*     */           public int compare(FriendHandler.PlayerInfo data1, FriendHandler.PlayerInfo data2) {
/*  80 */             if (data1.getIsOnline() != data2.getIsOnline()) {
/*  81 */               return (data1.getIsOnline() < data2.getIsOnline()) ? 1 : -1;
/*     */             }
/*     */             
/*  84 */             if (data1.getChouHenPoint() != data2.getChouHenPoint()) {
/*  85 */               return (data1.getChouHenPoint() < data2.getChouHenPoint()) ? 1 : -1;
/*     */             }
/*     */             
/*  88 */             if (data1.getStageLevel() != data2.getStageLevel()) {
/*  89 */               return (data1.getStageLevel() < data2.getStageLevel()) ? 1 : -1;
/*     */             }
/*     */             
/*  92 */             return Integer.compare(data2.getLevel(), data1.getLevel());
/*     */           }
/*     */         });
/*  95 */     return chouRens;
/*     */   }
/*     */   
/*     */   public TreeMap<String, Object> add2ChouRenList(String chouRenId) {
/*  99 */     TreeMap<String, Object> rtData = new TreeMap<>();
/* 100 */     rtData.put("result", Boolean.valueOf(true));
/* 101 */     rtData.put("info", LangService.getValue("FRIEND_ADD_SUCCESS"));
/* 102 */     boolean bOpen = PlayerUtil.isPlayerOpenedFunction(this.player.getId(), Const.FunctionType.FRIEND.getValue());
/* 103 */     if (!bOpen) {
/* 104 */       rtData.put("result", Boolean.valueOf(false));
/* 105 */       rtData.put("info", FunctionOpenUtil.getTipsByName(Const.FunctionType.FRIEND.getValue()));
/* 106 */       return rtData;
/*     */     } 
/* 108 */     bOpen = PlayerUtil.isPlayerOpenedFunction(chouRenId, Const.FunctionType.FRIEND.getValue());
/* 109 */     if (!bOpen) {
/* 110 */       rtData.put("result", Boolean.valueOf(false));
/* 111 */       rtData.put("info", LangService.getValue("FUNC_SET_TARGET_NOT_OPEN"));
/* 112 */       return rtData;
/*     */     } 
/* 114 */     if (this.data.chouRens.containsKey(chouRenId)) {
/* 115 */       rtData.put("result", Boolean.valueOf(false));
/* 116 */       rtData.put("info", LangService.getValue("FRIEND_HAVE_IN_CHOUREN_LIST"));
/* 117 */       return rtData;
/*     */     } 
/* 119 */     if (this.chouRensNum >= GlobalConfig.Social_MaxEnemyNum) {
/* 120 */       rtData.put("result", Boolean.valueOf(false));
/* 121 */       rtData.put("info", LangService.getValue("FRIEND_CHOUREN_LIST_FULL"));
/* 122 */       return rtData;
/*     */     } 
/* 124 */     ChouRenData data = new ChouRenData();
/* 125 */     data.chouRenId = chouRenId;
/* 126 */     data.chouHenPoint = 0;
/* 127 */     data.createTimeStamp = new Date();
/* 128 */     this.data.chouRens.put(chouRenId, data);
/* 129 */     this.chouRensNum++;
/* 130 */     Out.debug(new Object[] { "添加了一个仇人，id： ", chouRenId });
/*     */     
/* 132 */     return rtData;
/*     */   }
/*     */   
/*     */   public boolean deleteChouRenById(String id) {
/* 136 */     if (this.data.chouRens.containsKey(id)) {
/* 137 */       this.data.chouRens.remove(id);
/* 138 */       this.chouRensNum--;
/* 139 */       Out.debug(new Object[] { "删除一个仇人，id：", id });
/*     */       
/* 141 */       return true;
/*     */     } 
/* 143 */     Out.debug(new Object[] { "删除一个仇人失败，id：", id });
/* 144 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addChouHenPoint(String chouRenId, int point) {
/* 150 */     if (!this.data.chouRens.containsKey(chouRenId)) {
/* 151 */       return false;
/*     */     }
/* 153 */     int killNumMax = GlobalConfig.Social_KillNumMax;
/* 154 */     int killNumMin = GlobalConfig.Social_KillNumMin;
/*     */     
/* 156 */     if (point >= killNumMax || point <= killNumMin) {
/* 157 */       return false;
/*     */     }
/* 159 */     ChouRenData data = (ChouRenData)this.data.chouRens.get(chouRenId);
/* 160 */     data.chouHenPoint += point;
/* 161 */     Out.debug(new Object[] { "增加仇恨值1点" });
/*     */     
/* 163 */     return true;
/*     */   }
/*     */   
/*     */   public void killOtherOnce(String playerId) {
/* 167 */     addChouHenPoint(playerId, (SocialFriendProps.findByMSocialAction(3)).killNum);
/*     */   }
/*     */ 
/*     */   
/*     */   public void beKilledOnce(String playerId) {
/* 172 */     add2ChouRenList(playerId);
/* 173 */     addChouHenPoint(playerId, (SocialFriendProps.findByMSocialAction(4)).killNum);
/*     */   }
/*     */   
/*     */   public void removeChouRensData(String playerId) {
/* 177 */     this.data.chouRens.remove(playerId);
/*     */   }
/*     */   
/*     */   public void refreshNewDay() {}
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\friend\ChouRenManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */