/*     */ package com.wanniu.game.request.entry;
/*     */ 
/*     */ import cn.qeng.common.login.TokenInfo;
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.GGame;
/*     */ import com.wanniu.core.GGlobal;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloHeader;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.tcp.protocol.Message;
/*     */ import com.wanniu.core.tcp.protocol.Packet;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.area.AreaUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.msg.MessagePush;
/*     */ import com.wanniu.game.data.base.MapBase;
/*     */ import com.wanniu.game.petNew.PetManager;
/*     */ import com.wanniu.game.player.BILogService;
/*     */ import com.wanniu.game.player.PlayerDao;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.player.bi.LogReportService;
/*     */ import com.wanniu.game.player.po.AllBlobPO;
/*     */ import io.netty.channel.Channel;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import pomelo.Common;
/*     */ import pomelo.area.PlayerHandler;
/*     */ import pomelo.connector.EntryHandler;
/*     */ import pomelo.item.ItemOuterClass;
/*     */ import pomelo.player.PlayerOuterClass;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @GClientEvent("connector.entryHandler.bindPlayerRequest")
/*     */ public class BindPlayerHandler
/*     */   extends PomeloRequest
/*     */ {
/*     */   public void execute(Packet pak) {
/*  51 */     this.watcher.begin(pak.getHeader().getLength());
/*  52 */     this.pak = pak;
/*  53 */     PomeloResponse res = null;
/*     */     try {
/*  55 */       res = request();
/*  56 */     } catch (Exception e) {
/*  57 */       res = GGame.getInstance().getErrResponse(e);
/*     */     } 
/*  59 */     if (res != null) {
/*  60 */       PomeloHeader header = res.getHeader();
/*  61 */       header.setType(pak.getHeader().getType());
/*  62 */       this.watcher.end(res.getContent().readableBytes());
/*  63 */       write((Message)res);
/*  64 */       if (this.tmpPlayer != null && this.tmpArea != null)
/*     */       {
/*  66 */         this.tmpPlayer.setState((byte)1);
/*     */       }
/*     */     } else {
/*  69 */       this.watcher.end(0);
/*     */     } 
/*     */   }
/*     */   
/*  73 */   private WNPlayer tmpPlayer = null;
/*  74 */   private Area tmpArea = null;
/*     */   
/*     */   public PomeloResponse request() throws Exception {
/*  77 */     EntryHandler.BindPlayerRequest req = EntryHandler.BindPlayerRequest.parseFrom(this.pak.getRemaingBytes());
/*  78 */     final String uid = this.pak.getUid();
/*  79 */     final String playerId = req.getC2SPlayerId();
/*     */     
/*  81 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/*  84 */           EntryHandler.BindPlayerResponse.Builder res = EntryHandler.BindPlayerResponse.newBuilder();
/*     */           
/*  86 */           if (StringUtil.isEmpty(uid)) {
/*  87 */             Out.warn(new Object[] { BindPlayerHandler.access$000(this.this$0).getIp(), " bindPlayerRequest session uid null!" });
/*  88 */             res.setS2CCode(400);
/*  89 */             res.setS2CMsg(LangService.getValue("VERIFY_FAIL"));
/*  90 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*  94 */           if (StringUtil.isEmpty(playerId)) {
/*  95 */             Out.warn(new Object[] { "bindPlayerRequest msg playerId null!" });
/*  96 */             res.setS2CCode(400);
/*  97 */             res.setS2CMsg(LangService.getValue("PLAYER_ID_NULL"));
/*  98 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*     */           try {
/* 103 */             WNPlayer player = PlayerUtil.getOnlinePlayerByUid(uid);
/*     */             
/* 105 */             if (player != null) {
/* 106 */               player.setLogoutTime(new Date());
/* 107 */               Channel session = player.getSession();
/* 108 */               if (session != BindPlayerHandler.this.pak.getSession() && session.isActive()) {
/*     */                 
/* 110 */                 PlayerHandler.KickPlayerPush.Builder builder = PlayerHandler.KickPlayerPush.newBuilder();
/* 111 */                 builder.setS2CReasonType(Const.KickReason.NEW_LOGIN.value);
/* 112 */                 session.write((new MessagePush("area.playerPush.kickPlayerPush", (GeneratedMessage)builder.build())).getContent()).await(2000L);
/* 113 */                 session.close();
/*     */               } 
/*     */             } 
/* 116 */             if (player == null || !player.getId().equals(playerId)) {
/* 117 */               if (player != null) {
/* 118 */                 player.doLogout(true);
/*     */               }
/*     */ 
/*     */               
/* 122 */               AllBlobPO allBlobData = PlayerDao.getAllBlobData(playerId);
/* 123 */               if (allBlobData.player == null) {
/* 124 */                 res.setS2CCode(500);
/* 125 */                 res.setS2CMsg(LangService.getValue("PLAYER_ID_NULL"));
/* 126 */                 this.body.writeBytes(res.build().toByteArray());
/*     */                 
/*     */                 return;
/*     */               } 
/*     */               
/* 131 */               player = new WNPlayer(allBlobData);
/*     */             } 
/*     */             
/* 134 */             Date freezeTime = (player.getPlayer()).freezeTime;
/* 135 */             if (freezeTime != null && freezeTime.getTime() > System.currentTimeMillis()) {
/* 136 */               res.setS2CCode(500);
/* 137 */               res.setS2CMsg(LangService.getValue("ROLE_LOCKED") + "：" + player.player.freezeReason);
/* 138 */               this.body.writeBytes(res.build().toByteArray());
/*     */               
/*     */               return;
/*     */             } 
/*     */             
/* 143 */             player.bind(BindPlayerHandler.this.pak.getSession());
/*     */             
/* 145 */             long beginTime = System.currentTimeMillis();
/*     */             
/* 147 */             TokenInfo token = (TokenInfo)BindPlayerHandler.this.pak.getAttr(GGlobal.__KEY_TOKEN_INFO);
/* 148 */             if (token != null) {
/* 149 */               (player.getPlayer()).channel = token.getChannel();
/* 150 */               (player.getPlayer()).subchannel = token.getSubchannel();
/* 151 */               (player.getPlayer()).subchannelUID = token.getSubchannelUid();
/* 152 */               (player.getPlayer()).mac = token.getMac();
/* 153 */               (player.getPlayer()).os = token.getOs();
/* 154 */               (player.getPlayer()).ip = BindPlayerHandler.this.pak.getIp();
/*     */             } 
/*     */             
/* 157 */             Out.info(new Object[] { "角色进入游戏 uid=", player.getUid(), ",playerId=", player.getId(), ",name=", player.getName(), ",IP=", (player.getPlayer()).ip });
/* 158 */             LogReportService.getInstance().ansycReportLogin(player.getPlayer());
/* 159 */             BILogService.getInstance().ansycReportPlayerData(player.getSession(), player.getPlayer(), false);
/*     */             
/* 161 */             PlayerOuterClass.Player.Builder data = BindPlayerHandler.this.bindLoadData(player);
/*     */ 
/*     */             
/* 164 */             player.setState((byte)0);
/* 165 */             Area area = AreaUtil.dispatch(player);
/* 166 */             MapBase sceneProp = area.prop;
/* 167 */             data.setAreaId(sceneProp.templateID);
/* 168 */             data.setInstanceId(area.instanceId);
/* 169 */             data.setMapId(area.areaId);
/*     */ 
/*     */             
/* 172 */             res.setS2CCode(200);
/* 173 */             res.setS2CPlayer(data);
/* 174 */             res.setS2CSceneType(sceneProp.type);
/* 175 */             res.setS2CSceneUseAgent(sceneProp.useAgent);
/* 176 */             res.setS2CChangePkType(sceneProp.changePKtype);
/* 177 */             res.setS2CRideMount(sceneProp.rideMount);
/*     */             
/* 179 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/* 181 */             WNPlayer login_player = player;
/* 182 */             GWorld.getInstance().ansycExec(() -> {
/*     */                   login_player.onLogin();
/*     */                   
/*     */                   area.onPlayerLogin(login_player);
/*     */                 });
/* 187 */             Out.debug(new Object[] { player.getName(), " enter game use : ", Long.valueOf(System.currentTimeMillis() - beginTime) });
/* 188 */             BindPlayerHandler.this.tmpPlayer = player;
/* 189 */             BindPlayerHandler.this.tmpArea = area;
/* 190 */           } catch (Exception e) {
/* 191 */             Out.error(new Object[] { e });
/*     */           } finally {
/* 193 */             LoginQueue.removeBindQueue(BindPlayerHandler.this.pak.getSession());
/*     */           } 
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PlayerOuterClass.Player.Builder bindLoadData(WNPlayer player) {
/* 204 */     PlayerOuterClass.Player.Builder data = PlayerOuterClass.Player.newBuilder();
/* 205 */     data.setId(player.getId());
/* 206 */     data.setUid(player.getUid());
/* 207 */     data.setName(player.getName());
/* 208 */     data.setLevel(player.player.level);
/* 209 */     data.setExp(player.player.exp);
/* 210 */     data.setPro(player.player.pro);
/* 211 */     data.setUpOrder(player.player.upOrder);
/* 212 */     data.setClassExp(player.player.classExp);
/* 213 */     data.setPrestige(player.player.prestige);
/* 214 */     data.setJuewei(0);
/* 215 */     data.setGold(player.player.gold);
/* 216 */     data.setTicket(player.player.ticket);
/* 217 */     data.setDiamond(player.player.diamond);
/* 218 */     data.setFriendly(player.player.friendly);
/* 219 */     data.setConsumePoint(player.moneyManager.getConsumePoint());
/* 220 */     data.setVip(player.baseDataManager.getVip());
/* 221 */     data.setHp(player.playerTempData.hp);
/* 222 */     data.setMp(player.playerTempData.mp);
/* 223 */     data.setNeedExp(player.player.needExp);
/* 224 */     data.setFightPower(player.player.fightPower);
/* 225 */     data.setUpLevel(player.player.upLevel);
/* 226 */     data.setReqLevel(0);
/* 227 */     PlayerOuterClass.Stores.Builder store = PlayerOuterClass.Stores.newBuilder();
/* 228 */     store.setBag(player.bag.toJson4Payload());
/* 229 */     store.setWareHouse(player.wareHouse.toJson4Payload());
/* 230 */     store.setRecycle(player.recycle.toJson4Payload());
/* 231 */     data.setStore(store);
/* 232 */     data.setEquipments(player.equipManager.toJson4Payload());
/* 233 */     data.addAllFashionInfo(player.fashionManager.toJson4Fashion());
/* 234 */     data.addAllStrengthPos(player.equipManager.toJson4StrengthPos());
/* 235 */     data.setTasks(player.taskManager.toJson4Payload());
/* 236 */     data.setSetData(player.sysSetManager.toJson4Payload());
/*     */     
/* 238 */     data.setHookSetData(player.hookSetManager.toJson4Payload());
/* 239 */     data.addAllSkillKeys(player.skillKeyManager.toJson4Payload());
/* 240 */     data.setCountItems(ItemOuterClass.CountItems.newBuilder());
/* 241 */     data.setPawnGold(player.player.pawnGold);
/* 242 */     data.setGuildpoint(player.player.guildpoint);
/* 243 */     data.setTreasurePoint(player.player.treasurePoint);
/* 244 */     data.setZoneId(String.valueOf(player.getLogicServerId()));
/* 245 */     data.setPetPkModel(PetManager.getPkModel());
/* 246 */     data.addAllFunctionList(player.functionOpenManager.toJson4PayLoad());
/*     */     
/* 248 */     List<Common.KeyValueStruct> ccs = new ArrayList<>();
/* 249 */     if (player.playerAttachPO.config != null) {
/* 250 */       for (String key : player.playerAttachPO.config.keySet()) {
/* 251 */         Common.KeyValueStruct.Builder cc = Common.KeyValueStruct.newBuilder();
/* 252 */         cc.setKey(key);
/* 253 */         cc.setValue((String)player.playerAttachPO.config.get(key));
/* 254 */         ccs.add(cc.build());
/*     */       } 
/*     */     }
/* 257 */     data.addAllClientConfig(ccs);
/* 258 */     data.setFightingPetId(player.petNewManager.getFightingPetId());
/* 259 */     data.setOpenMount(player.player.openMount ? 1 : 0);
/* 260 */     data.setSolopoint(player.soloManager.getSolopoint());
/* 261 */     data.setPayGiftData(player.prepaidManager.getFirstPayStatus());
/* 262 */     return data;
/*     */   }
/*     */   
/*     */   public short getType() {
/* 266 */     return 258;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\entry\BindPlayerHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */