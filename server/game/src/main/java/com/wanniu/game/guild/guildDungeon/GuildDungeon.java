/*     */ package com.wanniu.game.guild.guildDungeon;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.area.AreaData;
/*     */ import com.wanniu.game.area.AreaEvent;
/*     */ import com.wanniu.game.area.AreaUtil;
/*     */ import com.wanniu.game.area.DamageHealVO;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.GDungeonMapCO;
/*     */ import com.wanniu.game.data.GDungeonRankCO;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.base.MapBase;
/*     */ import com.wanniu.game.guild.GuildCommonUtil;
/*     */ import com.wanniu.game.guild.GuildService;
/*     */ import com.wanniu.game.item.po.PlayerItemPO;
/*     */ import com.wanniu.game.mail.MailUtil;
/*     */ import com.wanniu.game.mail.data.MailData;
/*     */ import com.wanniu.game.mail.data.MailSysData;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.GuildDungeonPO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import pomelo.area.GuildHandler;
/*     */ import pomelo.area.PlayerHandler;
/*     */ import pomelo.guild.GuildManagerHandler;
/*     */ import pomelo.item.ItemOuterClass;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuildDungeon
/*     */   extends Area
/*     */ {
/*     */   public String guildId;
/*     */   public int maxCountDungeonId;
/*     */   public int dungeonCount;
/*     */   public Map<String, GuildDungeonPlayerInfo> playerInfo;
/*     */   public boolean isClose;
/*     */   public String killplayerId;
/*     */   public Map<String, Area.Actor> playerIds;
/*  49 */   private GuildDungeon self = this;
/*     */   
/*     */   public GuildDungeon(JSONObject opts) {
/*  52 */     super(opts);
/*  53 */     this.playerIds = this.actors;
/*     */     
/*  55 */     this.guildId = opts.getString("guildId");
/*  56 */     this.maxCountDungeonId = opts.getIntValue("maxCountDungeonId");
/*  57 */     this.dungeonCount = opts.getIntValue("dungeonCount");
/*  58 */     this.playerInfo = new HashMap<>();
/*  59 */     this.isClose = false;
/*  60 */     this.killplayerId = "";
/*     */ 
/*     */     
/*  63 */     GuildService.dungeonInit(this.guildId, this.instanceId, "");
/*     */   }
/*     */ 
/*     */   
/*     */   public void onClose(String msg) {
/*  68 */     if (this.isClose) {
/*     */       return;
/*     */     }
/*     */     
/*  72 */     this.isClose = true;
/*  73 */     List<PlayerItemPO> itemsInfo = new ArrayList<>();
/*  74 */     for (Area.AreaItem dropItem : this.items.values()) {
/*  75 */       itemsInfo.add(dropItem.item.cloneItemDB());
/*     */     }
/*     */     
/*  78 */     GuildService.dungeonPass(this.guildId, this.dungeonCount, this.killplayerId);
/*     */     
/*  80 */     for (String id : this.actors.keySet()) {
/*  81 */       WNPlayer player = getPlayer(id);
/*  82 */       if (null == player) {
/*     */         continue;
/*     */       }
/*  85 */       List<ItemOuterClass.ItemDetail> awardItem = new ArrayList<>();
/*  86 */       for (Area.AreaItem dropItem : this.items.values()) {
/*  87 */         awardItem.add(dropItem.item.getItemDetail(player.playerBasePO).build());
/*     */       }
/*     */       
/*  90 */       int state = 0;
/*  91 */       if (this.areaId == this.maxCountDungeonId) {
/*  92 */         state = 1;
/*     */       }
/*     */       
/*  95 */       GuildHandler.OnDungeonEndPush.Builder msgPush = GuildHandler.OnDungeonEndPush.newBuilder();
/*  96 */       msgPush.setS2CCode(200);
/*  97 */       msgPush.addAllAwardItem(awardItem);
/*  98 */       msgPush.setState(state);
/*  99 */       msgPush.setLeftTime(60);
/* 100 */       player.receive("area.guildPush.onDungeonEndPush", (GeneratedMessage)msgPush.build());
/*     */     } 
/*     */     
/* 103 */     GuildService.updateDropItem(this.guildId, this.dungeonCount, itemsInfo);
/*     */     
/* 105 */     GuildDungeonPO data = GuildService.updateDamageAndHeal(this.guildId, this.playerInfo, this.dungeonCount, this.killplayerId);
/*     */     
/* 107 */     if (this.areaId == this.maxCountDungeonId) {
/* 108 */       rankReward(data);
/*     */     }
/*     */ 
/*     */     
/* 112 */     this.closeFuture = JobFactory.addDelayJob(new Runnable()
/*     */         {
/*     */           public void run() {
/* 115 */             for (String id : GuildDungeon.this.playerIds.keySet()) {
/* 116 */               Area.Actor playerData = GuildDungeon.this.playerIds.get(id);
/* 117 */               if (playerData.leave)
/*     */                 continue; 
/* 119 */               WNPlayer player = GuildDungeon.this.getPlayer(id);
/* 120 */               if (null != player) {
/* 121 */                 if (GuildDungeon.this.areaId == GuildDungeon.this.maxCountDungeonId) {
/* 122 */                   player.guildManager.leaveDungeon(player); continue;
/*     */                 } 
/* 124 */                 player.guildManager.joinGuildDungeon(GuildDungeon.this.self, 0);
/*     */               } 
/*     */             } 
/*     */             
/* 128 */             AreaUtil.closeArea(GuildDungeon.this.instanceId);
/*     */           }
/*     */         }60000L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerEntered(WNPlayer player) {
/*     */     try {
/* 138 */       GuildService.updatePlayerNum(this.guildId, this.dungeonCount, getPlayerNum());
/* 139 */     } catch (Exception err) {
/* 140 */       Out.error(new Object[] { "GuildService updatePlayerNum error:", err });
/* 141 */       throw new Error("call GuildService updatePlayerNum error");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerLeaved(WNPlayer player) {
/* 149 */     super.onPlayerLeaved(player);
/*     */     try {
/* 151 */       GuildService.updatePlayerNum(this.guildId, this.dungeonCount, getPlayerNum());
/* 152 */     } catch (Exception err) {
/* 153 */       Out.error(new Object[] { "GuildService updatePlayerNum error:", err });
/* 154 */       throw new Error("call GuildService updatePlayerNum error");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void closeGuildDungeon() {
/* 159 */     if (this.isClose) {
/*     */       return;
/*     */     }
/*     */     
/* 163 */     List<PlayerItemPO> itemsInfo = new ArrayList<>();
/* 164 */     for (Area.AreaItem dropItem : this.items.values()) {
/* 165 */       itemsInfo.add(dropItem.item.cloneItemDB());
/*     */     }
/*     */     
/*     */     try {
/* 169 */       GuildService.updateDropItem(this.guildId, this.dungeonCount, itemsInfo);
/* 170 */       GuildDungeonPO data = GuildService.updateDamageAndHeal(this.guildId, this.playerInfo, this.dungeonCount, this.killplayerId);
/*     */       
/* 172 */       rankReward(data);
/*     */       
/* 174 */       for (String id : this.playerIds.keySet()) {
/* 175 */         Area.Actor playerData = this.playerIds.get(id);
/* 176 */         if (playerData.leave) {
/*     */           continue;
/*     */         }
/* 179 */         WNPlayer player = getPlayer(id);
/*     */         
/* 181 */         if (null != player) {
/* 182 */           player.guildManager.leaveDungeon(player);
/*     */         }
/*     */       } 
/*     */       
/* 186 */       addCloseFuture();
/* 187 */     } catch (Exception err) {
/* 188 */       Out.error(new Object[] { "closeGuildDungeon error:", err });
/* 189 */       throw new Error("closeGuildDungeon error");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRank(ArrayList<GuildManagerHandler.RankInfo> rankInfo, String playerId) {
/* 195 */     for (int i = 0; i < rankInfo.size(); i++) {
/* 196 */       if (((GuildManagerHandler.RankInfo)rankInfo.get(i)).getPlayerId() == playerId) {
/* 197 */         return i + 1;
/*     */       }
/*     */     } 
/* 200 */     return 0;
/*     */   }
/*     */   
/*     */   public void rankReward(GuildDungeonPO data) {
/* 204 */     Map<String, Integer> playerScores = new HashMap<>();
/* 205 */     for (Integer dungeonCount : data.damagePlayer.keySet()) {
/* 206 */       ArrayList<String> damagePlayers = (ArrayList<String>)data.damagePlayer.get(dungeonCount);
/* 207 */       for (String id : damagePlayers) {
/* 208 */         List<GDungeonMapCO> props = GameData.findGDungeonMaps(t -> (t.type == Const.SCENE_TYPE.GUILD_DUNGEON.getValue()));
/*     */ 
/*     */ 
/*     */         
/* 212 */         props.sort((o1, o2) -> o1.layer - o2.layer);
/*     */ 
/*     */ 
/*     */         
/* 216 */         if (playerScores.containsKey(id)) {
/* 217 */           int scores = ((Integer)playerScores.get(id)).intValue();
/* 218 */           playerScores.put(id, Integer.valueOf(scores + ((GDungeonMapCO)props.get(dungeonCount.intValue() - 1)).gpoints)); continue;
/*     */         } 
/* 220 */         playerScores.put(id, Integer.valueOf(((GDungeonMapCO)props.get(dungeonCount.intValue() - 1)).gpoints));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 225 */     for (String id : playerScores.keySet()) {
/* 226 */       int dungeonScore = ((Integer)playerScores.get(id)).intValue();
/* 227 */       int rank = getRank(data.damageRankInfo, id);
/* 228 */       GDungeonRankCO rankProp = GuildCommonUtil.findGDungeonRanks(1, rank);
/* 229 */       if (null != rankProp) {
/* 230 */         dungeonScore += rankProp.gpoints;
/*     */       }
/*     */       
/* 233 */       rank = getRank(data.healRankInfo, id);
/* 234 */       rankProp = GuildCommonUtil.findGDungeonRanks(2, rank);
/* 235 */       if (null != rankProp) {
/* 236 */         dungeonScore += rankProp.gpoints;
/*     */       }
/*     */       
/* 239 */       WNPlayer player = PlayerUtil.getOnlinePlayer(id);
/* 240 */       if (null != player) {
/* 241 */         player.addGuildPoint(dungeonScore);
/* 242 */         player.pushDynamicData("guildpoint", Integer.valueOf(player.player.guildpoint)); continue;
/*     */       } 
/* 244 */       MailSysData mailData = new MailSysData("Guild_dungeon_integral");
/* 245 */       mailData.attachments = new ArrayList();
/* 246 */       MailData.Attachment attach = new MailData.Attachment();
/* 247 */       attach.itemCode = "guildpoint";
/* 248 */       attach.itemNum = dungeonScore;
/* 249 */       mailData.attachments.add(attach);
/* 250 */       MailUtil.getInstance().sendMailToOnePlayer(id, (MailData)mailData, Const.GOODS_CHANGE_TYPE.GUILD_BOSS);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBattleReport(List<DamageHealVO> datas) {
/* 261 */     for (DamageHealVO data : datas) {
/* 262 */       GuildDungeonPlayerInfo info = new GuildDungeonPlayerInfo();
/* 263 */       info.damage = data.TotalDamage;
/* 264 */       info.heal = data.TotalHealing;
/* 265 */       this.playerInfo.put(data.PlayerUUID, info);
/* 266 */       WNPlayer player = getPlayer(data.PlayerUUID);
/* 267 */       if (null != player) {
/* 268 */         player.guildManager.setJoinDungeonGuildId(this.guildId);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onKillBoss(String playerId) {
/* 279 */     this.killplayerId = playerId;
/*     */   }
/*     */   
/*     */   public boolean canRebirth(String playerId) {
/* 283 */     Area.Actor playerData = (Area.Actor)this.actors.get(playerId);
/* 284 */     if (null != playerData) {
/* 285 */       MapBase mapBase = this.prop;
/* 286 */       if (mapBase.revival == 0)
/* 287 */         return false; 
/* 288 */       if (mapBase.revival < 0)
/* 289 */         return true; 
/* 290 */       if (playerData.rebornNum >= mapBase.revival) {
/* 291 */         return false;
/*     */       }
/* 293 */       playerData.rebornNum++;
/*     */     } 
/*     */     
/* 296 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isDamagePlayer(Map<Integer, ArrayList<String>> damagePlayer, int dungeonCount, String playerId) {
/* 300 */     ArrayList<String> eachCountDamage = damagePlayer.get(Integer.valueOf(dungeonCount));
/* 301 */     if (null != eachCountDamage && eachCountDamage.size() > 0) {
/* 302 */       int index = eachCountDamage.indexOf(playerId);
/* 303 */       if (index != -1) {
/* 304 */         return true;
/*     */       }
/*     */     } 
/* 307 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public PlayerHandler.ReliveResponse.Builder relive(String playerId, Area.ReliveType reliveType) {
/* 312 */     PlayerHandler.ReliveResponse.Builder res = PlayerHandler.ReliveResponse.newBuilder();
/* 313 */     Area.Actor actor = this.playerIds.get(playerId);
/* 314 */     WNPlayer player = getPlayer(playerId);
/* 315 */     if (null == actor || null == player) {
/* 316 */       res.setS2CCode(500);
/* 317 */       res.setS2CMsg(LangService.getValue("REVIVE_NOT_FIND_PLAYER"));
/* 318 */       return res;
/*     */     } 
/*     */     
/* 321 */     if (this.prop.revival > 0 && actor.rebornNum >= this.prop.revival) {
/* 322 */       res.setS2CCode(500);
/* 323 */       res.setS2CMsg(LangService.getValue("REVIVE_MAX"));
/* 324 */       return res;
/*     */     } 
/*     */     
/* 327 */     return super.relive(playerId, reliveType);
/*     */   }
/*     */   
/*     */   public int reviveNum(String playerId) {
/* 331 */     MapBase mapBase = this.prop;
/* 332 */     Area.Actor playerData = this.playerIds.get(playerId);
/* 333 */     if (null == playerData)
/*     */     {
/* 335 */       return 0;
/*     */     }
/*     */     
/* 338 */     int configNum = mapBase.revival;
/* 339 */     if (configNum <= 0) {
/* 340 */       return configNum;
/*     */     }
/* 342 */     if (configNum <= playerData.rebornNum) {
/* 343 */       return 0;
/*     */     }
/* 345 */     return configNum - playerData.rebornNum;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerDeadByMonster(String playerId, AreaEvent.MonsterData monsterData) {
/* 351 */     Area.Actor playerData = this.playerIds.get(playerId);
/* 352 */     if (null == playerData) {
/* 353 */       Out.error(new Object[] { "onPlayerDead not exist! :", playerId });
/*     */       return;
/*     */     } 
/* 356 */     WNPlayer player = getPlayer(playerId);
/* 357 */     PlayerHandler.PlayerRelivePush.Builder data = newPlayerRelivePush(player);
/* 358 */     int overTime = GlobalConfig.Dungeon_DeadBack_Time;
/* 359 */     data.setCountDown(overTime);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addPlayer(WNPlayer player) {
/* 366 */     setForce(player);
/* 367 */     String enterSceneData = toJSON4EnterScene(player);
/*     */     try {
/* 369 */       playerEnterRequest(player, enterSceneData);
/* 370 */       this.hasPlayerEntered = true;
/*     */       
/* 372 */       if (null == this.actors.get(player.getId())) {
/* 373 */         this.playerIds.put(player.getId(), new Area.Actor());
/*     */       }
/*     */     }
/* 376 */     catch (Exception error) {
/* 377 */       Out.error(new Object[] { "c# enter scene id: ", this.instanceId, "enterSceneData:", enterSceneData });
/* 378 */       Out.error(new Object[] { "c# enter scene id: ", this.instanceId, " error : ", error });
/* 379 */       throw error;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removePlayer(WNPlayer player, boolean keepObject) {
/* 388 */     String playerId = player.getId();
/* 389 */     if (hasPlayer(playerId)) {
/* 390 */       playerLeaveRequest(player, keepObject);
/* 391 */       onPlayerLeaved(player);
/*     */       
/* 393 */       resetEmptyTime();
/*     */ 
/*     */ 
/*     */       
/* 397 */       ((Area.Actor)this.playerIds.get(playerId)).leave = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 405 */     for (String playerId : this.playerIds.keySet()) {
/* 406 */       if (((Area.Actor)this.playerIds.get(playerId)).leave)
/*     */         continue; 
/* 408 */       WNPlayer player = getPlayer(playerId);
/*     */       
/* 410 */       AreaUtil.dispatchByAreaId(player, new AreaData(player.playerTempData.historyAreaId, player.playerTempData.historyX, player.playerTempData.historyY), null);
/*     */     } 
/*     */     
/* 413 */     getZoneManager().destroyZoneRequest(this.instanceId);
/*     */   }
/*     */   
/*     */   public void cleanDropItems() {}
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guildDungeon\GuildDungeon.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */