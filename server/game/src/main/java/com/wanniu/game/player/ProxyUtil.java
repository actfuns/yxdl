/*     */ package com.wanniu.game.player;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.proxy.ProxyClient;
/*     */ import com.wanniu.core.tcp.protocol.Message;
/*     */ import com.wanniu.core.tcp.protocol.Packet;
/*     */ import com.wanniu.csharp.CSharpClient;
/*     */ import com.wanniu.csharp.CSharpNode;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.area.AreaData;
/*     */ import com.wanniu.game.area.AreaEvent;
/*     */ import com.wanniu.game.area.AreaManager;
/*     */ import com.wanniu.game.area.AreaUtil;
/*     */ import com.wanniu.game.area.ProxyArea;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.data.base.DItemEquipBase;
/*     */ import com.wanniu.game.item.ItemConfig;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.item.po.PlayerItemPO;
/*     */ import com.wanniu.game.petNew.PetNew;
/*     */ import com.wanniu.game.poes.XianYuanPO;
/*     */ import com.wanniu.game.task.TaskEvent;
/*     */ import com.wanniu.game.team.TeamData;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import pomelo.area.FightLevelHandler;
/*     */ import pomelo.area.TeamHandler;
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
/*     */ public final class ProxyUtil
/*     */ {
/*     */   public static void onAcrossPlayerEvent(Packet pak) {
/*  50 */     String playerId = pak.getString();
/*  51 */     WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
/*  52 */     int type = pak.getByte();
/*  53 */     Out.debug(new Object[] { playerId, " player proxy event -> ", Integer.valueOf(type) });
/*  54 */     if (player != null) {
/*  55 */       int fromDes; int unitTemplateId; PetNew pet; Area area; String str; PlayerItemPO item; PlayerItemPO playerItem; DItemEquipBase prop; DItemEquipBase dItemEquipBase1; switch (type) {
/*     */         case 1:
/*  57 */           player.onEvent(new TaskEvent(pak.getInt(), pak.getString()));
/*     */           break;
/*     */         
/*     */         case 2:
/*  61 */           fromDes = pak.getInt();
/*  62 */           str = pak.getString();
/*  63 */           playerItem = (PlayerItemPO)Utils.deserialize(str, PlayerItemPO.class);
/*  64 */           dItemEquipBase1 = ItemConfig.getInstance().getItemProp(playerItem.code);
/*  65 */           player.bag.addEntityItem(new NormalItem(playerItem, dItemEquipBase1), Const.GOODS_CHANGE_TYPE.getE(fromDes));
/*     */           break;
/*     */         
/*     */         case 3:
/*  69 */           unitTemplateId = pak.getInt();
/*  70 */           AreaEvent.onTaskEvent(playerId, unitTemplateId);
/*     */           break;
/*     */         
/*     */         case 4:
/*  74 */           player.illusionManager.addAward(pak.getString(), pak.getInt());
/*     */           break;
/*     */         
/*     */         case 5:
/*  78 */           pet = player.getFightingPet();
/*  79 */           if (pet != null) {
/*  80 */             pet.addExp(pak.getInt(), true);
/*     */           }
/*     */           break;
/*     */         
/*     */         case 6:
/*  85 */           player.playerAttachPO.addFirstMonsterId(pak.getInt());
/*     */           break;
/*     */         
/*     */         case 7:
/*  89 */           player.finishFightLevel(pak.getInt(), pak.getInt());
/*     */           break;
/*     */         
/*     */         case 8:
/*  93 */           player.achievementManager.onPassedDungeon(pak.getInt());
/*     */           break;
/*     */         
/*     */         case 9:
/*  97 */           player.dailyActivityMgr.onEvent(Const.DailyType.valueOf(pak.getString()), pak.getString(), pak.getInt());
/*     */           break;
/*     */         
/*     */         case 10:
/* 101 */           onAcrossEnterConfirm(player, pak);
/*     */           break;
/*     */         
/*     */         case 11:
/* 105 */           onAcrossEnterReply(player, pak);
/*     */           break;
/*     */         
/*     */         case 12:
/* 109 */           player.moneyManager.addXianYuan(pak.getInt(), pak.getInt());
/*     */           break;
/*     */         
/*     */         case 13:
/* 113 */           area = player.getArea();
/* 114 */           if (!(area instanceof ProxyArea))
/*     */             return; 
/* 116 */           item = (PlayerItemPO)Utils.deserialize(pak.getString(), PlayerItemPO.class);
/* 117 */           prop = ItemConfig.getInstance().getItemProp(item.code);
/* 118 */           area.onFreedomPickItem(player, new NormalItem(item, prop), pak.getBoolean());
/*     */           break;
/*     */         
/*     */         case 14:
/* 122 */           player.bag.addCodeItemMail(pak.getString(), pak.getInt(), Const.ForceType.getE(pak.getInt()), Const.GOODS_CHANGE_TYPE.getE(pak.getInt()), pak.getString());
/*     */           break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void onAcrossEnterConfirm(WNPlayer player, Packet pak) {
/* 130 */     int targetId = pak.getInt();
/* 131 */     int difficulty = pak.getByte();
/* 132 */     String leaderId = pak.getString();
/*     */     
/* 134 */     int count = pak.getByte();
/* 135 */     List<FightLevelHandler.MemberData> memberData = new ArrayList<>(count);
/*     */     
/* 137 */     for (int i = 0; i < count; i++) {
/* 138 */       FightLevelHandler.MemberData.Builder md = FightLevelHandler.MemberData.newBuilder();
/* 139 */       md.setId(pak.getString());
/* 140 */       md.setName(pak.getString());
/* 141 */       md.setPro(pak.getByte());
/* 142 */       md.setLevel(pak.getShort());
/* 143 */       memberData.add(md.build());
/*     */     } 
/*     */     
/* 146 */     int overTime = GlobalConfig.TeamGoMapLeftTime;
/*     */ 
/*     */     
/* 149 */     FightLevelHandler.OnConfirmEnterFubenPush enterFuben = FightLevelHandler.OnConfirmEnterFubenPush.newBuilder().setS2CMsg(LangService.getValue("CONFIRM_ENTRY")).setS2CFubenId(TeamData.getTargetMap(targetId, difficulty)).setS2COverTime(overTime).setS2CLeaderId((leaderId == null) ? "" : leaderId).addAllS2CMemberData(memberData).build();
/*     */     
/* 151 */     player.receive("area.fightLevelPush.onConfirmEnterFubenPush", (GeneratedMessage)enterFuben);
/*     */   }
/*     */   
/*     */   private static void onAcrossEnterReply(WNPlayer player, Packet pak) {
/* 155 */     FightLevelHandler.OnMemberEnterFubenStateChangePush msgData = FightLevelHandler.OnMemberEnterFubenStateChangePush.newBuilder().setS2CPlayerId(pak.getString()).setS2CIsReady(pak.getByte()).build();
/* 156 */     player.receive("area.fightLevelPush.onMemberEnterFubenStateChangePush", (GeneratedMessage)msgData);
/*     */   }
/*     */   
/*     */   public static void onAcrossChangeArea(Packet pak) {
/* 160 */     String node = pak.getString();
/* 161 */     CSharpNode csNode = (CSharpNode)JSON.parseObject(node, CSharpNode.class);
/* 162 */     final String playerId = pak.getString();
/* 163 */     final WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
/* 164 */     int areaId = pak.getInt();
/* 165 */     String instanceId = pak.getString();
/* 166 */     if (player == null) {
/* 167 */       Out.warn(new Object[] { "proxy receive change area:", Integer.valueOf(areaId), " isntanceId:", instanceId });
/*     */       return;
/*     */     } 
/* 170 */     ProxyClient.getInstance().add(new Message()
/*     */         {
/*     */           protected void write() throws IOException {
/* 173 */             this.body.writeString(playerId);
/* 174 */             this.body.writeBoolean(player.isRobot());
/* 175 */             this.body.writeFloat(player.vipManager.getVipExpRatio());
/* 176 */             this.body.writeInt(player.getGuildExdExp());
/* 177 */             this.body.writeInt(player.getGuildExdGold());
/* 178 */             this.body.writeInt(player.getBtlExdGold());
/* 179 */             PetNew petnew = player.petNewManager.getFightingPet();
/* 180 */             this.body.writeString((petnew == null) ? "" : Utils.serialize(petnew.po));
/* 181 */             this.body.writeString(Utils.serialize(player.illusionManager.illusionPO));
/* 182 */             this.body.writeString(Utils.serialize(player.vipManager.po));
/* 183 */             XianYuanPO xianYuan = player.allBlobData.xianYuan;
/* 184 */             this.body.writeString((xianYuan == null) ? "" : Utils.serialize(xianYuan));
/* 185 */             List<Integer> firstKillMonsterIds = player.playerAttachPO.firstKillMonsterIds;
/* 186 */             this.body.writeShort(firstKillMonsterIds.size());
/* 187 */             for (Integer id : firstKillMonsterIds) {
/* 188 */               this.body.writeInt(id.intValue());
/*     */             }
/*     */           }
/*     */ 
/*     */           
/*     */           public short getType() {
/* 194 */             return 1025;
/*     */           }
/*     */         });
/* 197 */     Out.info(new Object[] { node, " areaId:", Integer.valueOf(areaId), " isntanceId:", instanceId });
/* 198 */     CSharpClient.getInstance().connect(csNode, () -> {
/*     */           if (AreaUtil.getArea(instanceId) == null) {
/*     */             ProxyArea area = new ProxyArea(Utils.toJSON(new Object[] { "areaId", Integer.valueOf(areaId), "instanceId", instanceId }));
/*     */             area.setBattleServerId(csNode.getNodeId());
/*     */             AreaManager.ProxyServerAreas.put(instanceId, area);
/*     */           } 
/*     */           AreaData areaData = new AreaData(areaId, instanceId);
/*     */           AreaUtil.changeArea(player, areaData);
/*     */         }); } public static void onAcrossTeamEvent(Packet packet) {
/*     */     int second;
/*     */     WNProxy proxy;
/*     */     int count;
/*     */     TeamHandler.OnAcrossTeamInfoPush.Builder push;
/* 211 */     int i, secType = packet.getByte();
/* 212 */     if (secType == 2) {
/* 213 */       createInstance(packet);
/*     */       return;
/*     */     } 
/* 216 */     String playerId = packet.getString();
/* 217 */     WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
/* 218 */     if (player == null) {
/* 219 */       Out.warn(new Object[] { "proxy client quit : ", playerId });
/*     */       return;
/*     */     } 
/* 222 */     switch (secType) {
/*     */       case 1:
/* 224 */         second = packet.getShort();
/* 225 */         count = packet.getByte();
/* 226 */         Out.debug(new Object[] { "across team info sceond ", Integer.valueOf(second), " count ", Integer.valueOf(count) });
/* 227 */         push = TeamHandler.OnAcrossTeamInfoPush.newBuilder().setTargetId(player.teamManager.acrossTargetId).setDifficulty(player.teamManager.acrossDifficulty);
/* 228 */         push.setSecond(second);
/* 229 */         push.addPlayers(TeamHandler.AcrossPlayer.newBuilder().setName(player.getName()).setLevel(player.getLevel()).setPro(player.getPro()));
/* 230 */         for (i = 1; i < count; i++) {
/* 231 */           push.addPlayers(TeamHandler.AcrossPlayer.newBuilder().setName(packet.getString()).setLevel(packet.getShort()).setPro(packet.getByte()));
/*     */         }
/* 233 */         player.receive("area.teamPush.onAcrossTeamInfoPush", (GeneratedMessage)push.build());
/*     */         return;
/*     */       
/*     */       case 3:
/* 237 */         player.teamManager.quitAcrossMatch(true);
/*     */         return;
/*     */       
/*     */       case 4:
/* 241 */         proxy = GWorld.getProxy(playerId);
/* 242 */         if (proxy != null) {
/* 243 */           proxy.free(packet.getBoolean());
/*     */         }
/*     */         return;
/*     */     } 
/* 247 */     Out.warn(new Object[] { "team onAcrossPacket secType : ", Integer.valueOf(secType) });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void createInstance(Packet packet) {
/* 253 */     int targetId = packet.getInt();
/* 254 */     int difficulty = packet.getByte();
/* 255 */     int count = packet.getByte();
/* 256 */     WNPlayer leader = null;
/* 257 */     Map<String, WNPlayer> players = new HashMap<>();
/* 258 */     for (int i = 0; i < count; i++) {
/* 259 */       int sid = packet.getInt();
/* 260 */       String playerId = packet.getString();
/* 261 */       String name = packet.getString();
/* 262 */       int level = packet.getInt();
/* 263 */       int pro = packet.getInt();
/* 264 */       if (sid != GWorld.__SERVER_ID) {
/* 265 */         WNProxy proxy = new WNProxy(playerId, sid);
/* 266 */         proxy.name = name;
/* 267 */         proxy.level = level;
/* 268 */         proxy.pro = pro;
/* 269 */         GWorld.Proxys.put(playerId, proxy);
/* 270 */         players.put(playerId, proxy);
/* 271 */         proxy.teamMembers = players;
/*     */       } else {
/* 273 */         WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
/* 274 */         if (leader == null || player.getTeamManager().isTeamLeader()) {
/* 275 */           leader = player;
/*     */         }
/* 277 */         players.put(playerId, player);
/* 278 */         player.teamMembers = players;
/*     */       } 
/*     */     } 
/*     */     
/* 282 */     int mapId = TeamData.getTargetMap(targetId, difficulty);
/* 283 */     if (mapId != 0) {
/* 284 */       Area area = AreaUtil.createArea(leader, Utils.toJSON(new Object[] { "logicServerId", Integer.valueOf(leader.getLogicServerId()), "areaId", Integer.valueOf(mapId) }));
/* 285 */       Out.info(new Object[] { "onAcrossPacket : ", area });
/* 286 */       AreaData areaData = new AreaData(area.areaId, area.instanceId);
/* 287 */       for (WNPlayer player : players.values()) {
/* 288 */         player.changeArea(areaData);
/* 289 */         if (player.isProxy()) {
/* 290 */           player.setArea(area);
/* 291 */           area.putActor(player.getId());
/*     */         } 
/*     */       } 
/*     */     } else {
/* 295 */       Out.warn(new Object[] { "onAcrossPacket : ", Integer.valueOf(targetId), " - ", Integer.valueOf(difficulty) });
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\player\ProxyUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */