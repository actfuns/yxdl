/*     */ package com.wanniu.game.area;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.game.protocol.PomeloPush;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.tcp.protocol.Message;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.player.BILogService;
/*     */ import com.wanniu.game.player.PlayerDao;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.player.po.AllBlobPO;
/*     */ import com.wanniu.game.poes.PlayerPO;
/*     */ import com.wanniu.redis.GameDao;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import io.netty.channel.Channel;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import pomelo.area.PlayerHandler;
/*     */ import pomelo.area.TaskHandler;
/*     */ import pomelo.player.PlayerOuterClass;
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
/*     */ 
/*     */ 
/*     */ public class PlayerRemote
/*     */ {
/*     */   public static boolean isValidName(String randomName) {
/*  48 */     if (StringUtil.isEmpty(randomName) || randomName.length() > GWorld.__SERVER_LANG.getNameLimit()) {
/*  49 */       return false;
/*     */     }
/*  51 */     return !PlayerDao.existsName(randomName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getRandomName(int pro, int logicServerId) {
/*     */     try {
/*  62 */       String randomName = PlayerUtil.getRandomName(pro);
/*  63 */       for (int i = 0; i < 20; i++) {
/*  64 */         boolean isValid = isValidName(randomName);
/*  65 */         if (isValid) {
/*     */           break;
/*     */         }
/*  68 */         randomName = PlayerUtil.getRandomName(pro);
/*  69 */         Out.debug(new Object[] { PlayerRemote.class, "重新随机名字   count : ", Integer.valueOf(i), " ---name: ", randomName });
/*     */       } 
/*  71 */       return randomName;
/*  72 */     } catch (Exception e) {
/*  73 */       Out.error(new Object[] { PlayerRemote.class, "生成随机名字出错", e.getMessage() });
/*  74 */       return PlayerUtil.getRandomName(pro);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WNPlayer createPlayer(String uid, String name, int pro, int logicServerId) {
/*  85 */     String playerId = UUID.randomUUID().toString();
/*  86 */     boolean isPutSuccess = PlayerDao.putName(name, playerId);
/*  87 */     if (!isPutSuccess) {
/*  88 */       Out.warn(new Object[] { "发现有玩家重名,创角失败!", name });
/*  89 */       return null;
/*     */     } 
/*     */ 
/*     */     
/*  93 */     if (!GameDao.putName(name, playerId)) {
/*  94 */       Out.warn(new Object[] { "建立本服角色列表时异常啦!", name });
/*     */     }
/*     */     
/*  97 */     AllBlobPO playerData = PlayerUtil.createPlayer(playerId, uid, name, pro, logicServerId);
/*  98 */     PlayerDao.insertPlayerId(playerData);
/*     */ 
/*     */ 
/*     */     
/* 102 */     return new WNPlayer(playerData);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void playerEnterAreaServerInner(WNPlayer player, Area area) {
/*     */     try {
/* 113 */       player.initBornData();
/*     */       
/* 115 */       player.write((Message)new PomeloPush()
/*     */           {
/*     */             protected void write() throws IOException {
/* 118 */               PlayerHandler.BattleClearPush.Builder push = PlayerHandler.BattleClearPush.newBuilder();
/* 119 */               push.setS2CName("");
/* 120 */               this.body.writeBytes(push.build().toByteArray());
/*     */             }
/*     */ 
/*     */             
/*     */             public String getRoute() {
/* 125 */               return "area.playerPush.battleClearPush";
/*     */             }
/*     */           });
/*     */       
/* 129 */       if (player.getState() == 1) {
/* 130 */         AreaUtil.changeAreaPush(player, area.areaId, area.instanceId);
/*     */       } else {
/* 132 */         Out.warn(new Object[] { "change scene err!!!playerId=", player.getId(), ",areaId=", Integer.valueOf(area.areaId), ",instanceId=", area.instanceId });
/*     */       } 
/*     */       
/* 135 */       area.addPlayer(player);
/*     */ 
/*     */       
/* 138 */       if (area.sceneType != Const.SCENE_TYPE.NORMAL.getValue() && area.sceneType != Const.SCENE_TYPE.FIGHT_LEVEL.getValue() && area.sceneType != Const.SCENE_TYPE.LOOP.getValue()) {
/* 139 */         TaskHandler.TaskAutoPush.Builder autoPush = TaskHandler.TaskAutoPush.newBuilder();
/* 140 */         autoPush.setAuto(0);
/* 141 */         player.receive("area.taskPush.taskAutoPush", (GeneratedMessage)autoPush.build());
/*     */       } 
/* 143 */     } catch (Exception error) {
/* 144 */       Out.error(new Object[] { error });
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void playerEnterAreaServer(WNPlayer player, String instanceId) {
/* 149 */     Area oldArea = player.getArea();
/* 150 */     if (oldArea != null) {
/* 151 */       oldArea.removePlayer(player, false);
/*     */     }
/* 153 */     Area area = AreaUtil.getArea(instanceId);
/*     */     
/* 155 */     playerEnterAreaServerInner(player, area);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void syncPlayerDataOffline(WNPlayer player, Area area) {
/* 163 */     player.setBornType(Const.BORN_TYPE.NORMAL);
/* 164 */     player.setEnterState(Const.ENTER_STATE.online.value);
/*     */     
/* 166 */     if (area.prop.disConnToMapID != 0) {
/* 167 */       String result = player.getXmdsManager().getBornPlace(area.instanceId, (AreaUtil.getAreaProp(area.prop.disConnToMapID)).templateID);
/* 168 */       JSONObject res = JSON.parseObject(result);
/* 169 */       player.syncBornData(res.getIntValue("x"), res.getIntValue("y"), area.prop.disConnToMapID);
/*     */     } 
/*     */ 
/*     */     
/* 173 */     player.soloManager.onPlayerOffline();
/* 174 */     Out.debug(new Object[] { PlayerRemote.class, "player.soloManager.quitMatching()" });
/* 175 */     player.friendManager.onPlayerOffline();
/* 176 */     player.onlineGiftManager.onPlayerOffline();
/* 177 */     player.five2FiveManager.onPlayerOffline();
/*     */     
/* 179 */     player.guildManager.onLogout();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<PlayerOuterClass.PlayerBasic> getPlayersByUidAndLogicServerId(Channel channel, String uid, int logicServerId, String ip) {
/* 189 */     List<String> list_ids = PlayerDao.getPlayerIdsByUid(uid, logicServerId);
/* 190 */     if (list_ids.isEmpty()) {
/* 191 */       BILogService.getInstance().ansycReportRegister(channel, uid, ip);
/*     */     }
/*     */     
/* 194 */     List<PlayerPO> playerDatas = new ArrayList<>(list_ids.size());
/* 195 */     for (String playerId : list_ids) {
/* 196 */       PlayerPO baseData = (PlayerPO)PlayerPOManager.findPO(ConstsTR.playerTR, playerId, PlayerPO.class);
/* 197 */       if (baseData != null && baseData.isDelete == 0) {
/* 198 */         playerDatas.add(baseData);
/*     */       }
/*     */     } 
/*     */     
/* 202 */     playerDatas.sort(new Comparator<PlayerPO>()
/*     */         {
/*     */           public int compare(PlayerPO p0, PlayerPO p1) {
/* 205 */             Date loginTime0 = p0.loginTime;
/* 206 */             Date loginTime1 = p1.loginTime;
/* 207 */             if (loginTime0 == null)
/* 208 */               return -1; 
/* 209 */             if (loginTime1 == null) {
/* 210 */               return 1;
/*     */             }
/* 212 */             if (loginTime1.getTime() == loginTime0.getTime()) {
/* 213 */               return 0;
/*     */             }
/* 215 */             return (loginTime1.getTime() > loginTime0.getTime()) ? -1 : 1;
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 222 */     List<PlayerOuterClass.PlayerBasic> playerBasics = new ArrayList<>();
/*     */     
/* 224 */     for (PlayerPO playerData : playerDatas) {
/* 225 */       AllBlobPO allblobData = PlayerDao.getAllBlobData(playerData.id);
/* 226 */       playerBasics.add(PlayerUtil.transToJson4BasicByBlob(allblobData));
/*     */     } 
/* 228 */     return playerBasics;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\area\PlayerRemote.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */