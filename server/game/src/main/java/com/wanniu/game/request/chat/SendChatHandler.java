/*     */ package com.wanniu.game.request.chat;
/*     */ 
/*     */ import cn.qeng.common.gm.monitor.ChatMonitor;
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.wanniu.core.db.GCache;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.entity.GPlayer;
/*     */ import com.wanniu.core.game.protocol.PomeloPush;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.tcp.protocol.Message;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.core.util.RandomUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.chat.ChannelUtil;
/*     */ import com.wanniu.game.chat.GMChatUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.msg.ErrorResponse;
/*     */ import com.wanniu.game.daoyou.DaoYouCenter;
/*     */ import com.wanniu.game.daoyou.DaoYouService;
/*     */ import com.wanniu.game.data.ChatSettingCO;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.guild.GuildUtil;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.DaoYouMemberPO;
/*     */ import com.wanniu.game.recent.ChatMsg;
/*     */ import com.wanniu.game.recent.RecentChatCenter;
/*     */ import com.wanniu.game.team.TeamData;
/*     */ import com.wanniu.game.util.BlackWordUtil;
/*     */ import com.wanniu.redis.PublishCenter;
/*     */ import io.netty.util.AttributeKey;
/*     */ import java.io.IOException;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import pomelo.chat.ChatHandler;
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
/*     */ @GClientEvent("chat.chatHandler.sendChatRequest")
/*     */ public class SendChatHandler
/*     */   extends PomeloRequest
/*     */ {
/*  56 */   private static final AttributeKey<Long> INVITE_CALL = AttributeKey.valueOf("INVITE.CALL");
/*     */   
/*     */   public PomeloResponse request() throws Exception {
/*  59 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*     */     
/*  61 */     GCache.push("chatLog", player.getId());
/*  62 */     ChatHandler.SendChatRequest req = ChatHandler.SendChatRequest.parseFrom(this.pak.getRemaingBytes());
/*  63 */     String text = req.getC2SContent();
/*  64 */     String serverData = req.getC2SServerData();
/*  65 */     String chatTime = DateUtil.getDateTime();
/*  66 */     int scope = req.getC2SScope();
/*  67 */     String target = req.getC2SAcceptRoleId();
/*     */     
/*  69 */     if (ChatBacklistManager.getInstance().inBacklist((player.getPlayer()).ip)) {
/*  70 */       Out.warn(new Object[] { "命中聊天黑名单. ip=", (player.getPlayer()).ip, ",playerId=", player.getId(), ",name=", player.getName() });
/*  71 */       return (PomeloResponse)new ErrorResponse("系统异常，请联系客服");
/*     */     } 
/*     */     
/*  74 */     if (scope == Const.CHAT_SCOPE.TEAM_CALL.getValue()) {
/*  75 */       if (!player.getTeamManager().isInTeam()) {
/*  76 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("CHAT_NOT_IN_TEAM"));
/*     */       }
/*     */       
/*  79 */       String msg = teamCall(player, text, serverData, chatTime, scope);
/*  80 */       if (msg != null) {
/*  81 */         return (PomeloResponse)new ErrorResponse(msg);
/*     */       }
/*     */     } else {
/*     */       
/*  85 */       if ((GWorld.DEBUG || GWorld.ROBOT) && text.toLowerCase().startsWith("@gm")) {
/*  86 */         GMChatUtil.GMChatResult gmRes = GMChatUtil.checkContent(player, text);
/*  87 */         text = gmRes.content;
/*  88 */         return (PomeloResponse)new ErrorResponse(text);
/*     */       } 
/*     */       
/*  91 */       Date forbidTalkTime = (player.getPlayer()).forbidTalkTime;
/*     */       
/*  93 */       if (forbidTalkTime != null && forbidTalkTime.getTime() > System.currentTimeMillis()) {
/*  94 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("CHAT_PLAYER_SHUTUP"));
/*     */       }
/*  96 */       int sys = 0;
/*  97 */       if (scope == Const.CHAT_SCOPE.SYSTEM.getValue())
/*  98 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("CHAT_SYS_SCOPE_ERR")); 
/*  99 */       if (scope == Const.CHAT_SCOPE.DAOYOU.getValue()) {
/* 100 */         DaoYouMemberPO dymp = DaoYouCenter.getInstance().getDaoYouMember(player.getId());
/* 101 */         if (dymp == null) {
/* 102 */           return (PomeloResponse)new ErrorResponse(LangService.getValue("CHAT_DAOYOU_ERR"));
/*     */         }
/* 104 */       } else if (scope == Const.CHAT_SCOPE.GUILD.getValue()) {
/* 105 */         if (player.guildManager.guild == null) {
/* 106 */           return (PomeloResponse)new ErrorResponse(LangService.getValue("CHAT_GUILD_ERR"));
/*     */         }
/* 108 */       } else if (scope == Const.CHAT_SCOPE.TEAM.getValue()) {
/* 109 */         if (!player.getTeamManager().isInTeam()) {
/* 110 */           return (PomeloResponse)new ErrorResponse(LangService.getValue("CHAT_NOT_IN_TEAM"));
/*     */         }
/* 112 */       } else if (scope == Const.CHAT_SCOPE.HORM.getValue()) {
/* 113 */         sys = 2;
/* 114 */         String itemCode = GlobalConfig.HornCode;
/* 115 */         int itemNum = GlobalConfig.HornCount;
/* 116 */         if (player.bag.findItemNumByCode(itemCode) < itemNum) {
/* 117 */           player.onFunctionGoTo(Const.FUNCTION_GOTO_TYPE.LOUD_NOT_ENOUGH, itemCode, null, null);
/* 118 */           return (PomeloResponse)new ErrorResponse(LangService.getValue("ITEM_LOUD_NOT_ENOUGH"));
/*     */         } 
/* 120 */         scope = Const.CHAT_SCOPE.WORLD.getValue();
/*     */       } 
/*     */ 
/*     */       
/* 124 */       if (!GWorld.DEBUG) {
/* 125 */         ChatSettingCO setting = (ChatSettingCO)GameData.ChatSettings.get(Integer.valueOf(scope));
/* 126 */         if (setting != null) {
/* 127 */           if (setting.openLv > player.getLevel()) {
/* 128 */             return (PomeloResponse)new ErrorResponse(LangService.format("CHAT_LV_LESS", new Object[] { Integer.valueOf(setting.openLv) }));
/*     */           }
/* 130 */           if (player.chatTime == null) {
/* 131 */             player.chatTime = new HashMap<>();
/*     */           }
/* 133 */           Long lasttime = (Long)player.chatTime.get(Integer.valueOf(scope));
/* 134 */           long currTime = System.currentTimeMillis();
/* 135 */           if (lasttime != null) {
/* 136 */             long second = setting.coolDown - (currTime - lasttime.longValue()) / 1000L;
/* 137 */             if (second > 0L) {
/* 138 */               return (PomeloResponse)new ErrorResponse(LangService.format("CHAT_WORLD_COOL", new Object[] { Long.valueOf(second) }));
/*     */             }
/*     */           } 
/* 141 */           player.chatTime.put(Integer.valueOf(scope), Long.valueOf(currTime));
/*     */         } 
/*     */       } 
/*     */       
/* 145 */       JSONObject json = JSONObject.parseObject(serverData);
/* 146 */       if ("toushaizi".equals(text)) {
/* 147 */         if (json.containsKey("s2c_funtype") && json.getIntValue("s2c_funtype") == 1) {
/* 148 */           sys = 3;
/* 149 */           text = LangService.format("CHAT_DICE", new Object[] { player.getName(), Integer.valueOf(RandomUtil.getInt(100)) });
/*     */         } 
/*     */       } else {
/* 152 */         boolean ignoreCode = ChannelUtil.extractChatItem(player, text);
/* 153 */         text = BlackWordUtil.replaceBlackString(text, ignoreCode);
/*     */       } 
/*     */ 
/*     */       
/* 157 */       serverData = checkServerData(player, serverData, json);
/*     */       
/* 159 */       final ChatHandler.OnChatPush.Builder push = ChatHandler.OnChatPush.newBuilder();
/* 160 */       push.setS2CContent(text);
/* 161 */       push.setS2CPlayerId(player.getId());
/* 162 */       push.setS2CServerData(serverData);
/* 163 */       push.setS2CScope(scope);
/* 164 */       push.setS2CUid(this.pak.getUid());
/* 165 */       push.setS2CTime(chatTime);
/* 166 */       push.setS2CIndex(0);
/* 167 */       push.setS2CSys(sys);
/*     */       
/* 169 */       if (scope == Const.CHAT_SCOPE.PRIVATE.getValue()) {
/* 170 */         push.setS2CAcceptRid(req.getC2SAcceptRoleId());
/*     */       }
/* 172 */       PomeloPush chatPush = new PomeloPush()
/*     */         {
/*     */           protected void write() throws IOException {
/* 175 */             this.body.writeBytes(push.build().toByteArray());
/*     */           }
/*     */ 
/*     */           
/*     */           public String getRoute() {
/* 180 */             return "chat.chatPush.onChatPush";
/*     */           }
/*     */         };
/*     */       
/* 184 */       if (scope == Const.CHAT_SCOPE.PRIVATE.getValue()) {
/* 185 */         String acceptRid = req.getC2SAcceptRoleId();
/* 186 */         WNPlayer receiver = GWorld.getInstance().getPlayer(acceptRid);
/* 187 */         if (receiver != null) {
/* 188 */           receiver.receive((Message)chatPush);
/*     */         }
/* 190 */         player.receive((Message)chatPush);
/*     */         
/* 192 */         ChatMsg msg = new ChatMsg();
/* 193 */         msg.playerId = player.getId();
/* 194 */         msg.acceptRid = acceptRid;
/* 195 */         msg.content = text;
/* 196 */         msg.time = chatTime;
/*     */         
/* 198 */         RecentChatCenter.getInstance().getRecentChatMgr(acceptRid).addRecentMsg(player.getId(), msg);
/*     */ 
/*     */         
/* 201 */         player.getRecentChatMgr().addRecentMsg(acceptRid, msg);
/*     */         
/* 203 */         target = (receiver == null) ? acceptRid : receiver.getName();
/* 204 */         Out.info(new Object[] { "[私聊]【", player.getName(), "】对【", target, "】说：", req.getC2SContent() });
/* 205 */       } else if (scope == Const.CHAT_SCOPE.TEAM.getValue()) {
/* 206 */         Out.info(new Object[] { "[队伍]【", player.getName(), "】说：", req.getC2SContent() });
/* 207 */         sendTeam(player, chatPush);
/* 208 */       } else if (scope == Const.CHAT_SCOPE.DAOYOU.getValue()) {
/* 209 */         DaoYouService.getInstance().sendDaoYou(player, chatPush);
/* 210 */       } else if (scope == Const.CHAT_SCOPE.GUILD.getValue()) {
/* 211 */         Out.info(new Object[] { "[公会]【", player.getName(), "】说：", req.getC2SContent() });
/* 212 */         GuildUtil.broadcast(player.guildManager.getGuildId(), (Message)chatPush);
/*     */       } else {
/* 214 */         if (req.getC2SScope() == Const.CHAT_SCOPE.HORM.getValue()) {
/* 215 */           Out.info(new Object[] { "[喇叭]【", player.getName(), "】说：", req.getC2SContent() });
/* 216 */           player.bag.discardItem(GlobalConfig.HornCode, GlobalConfig.HornCount, Const.GOODS_CHANGE_TYPE.chat);
/*     */         } else {
/* 218 */           Out.info(new Object[] { "[世界]【", player.getName(), "】说：", req.getC2SContent() });
/*     */         } 
/* 220 */         GWorld.getInstance().broadcast((Message)chatPush, player.getLogicServerId());
/*     */         
/* 222 */         player.achievementManager.onWorldSpeakTimes();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 227 */     ChatMonitor monitor = new ChatMonitor();
/* 228 */     monitor.setSid(GWorld.__SERVER_ID);
/* 229 */     monitor.setDate(new Date());
/* 230 */     monitor.setId(player.getId());
/* 231 */     monitor.setName(player.getName());
/* 232 */     monitor.setLevel(player.getLevel());
/* 233 */     monitor.setPro(player.getPro());
/* 234 */     monitor.setScope(req.getC2SScope());
/* 235 */     monitor.setText(req.getC2SContent());
/* 236 */     monitor.setTarget(target);
/* 237 */     monitor.setIp(this.pak.getIp());
/* 238 */     GWorld.getInstance().ansycExec(() -> PublishCenter.publish("chat_monitor", JSON.toJSONString(monitor)));
/*     */ 
/*     */ 
/*     */     
/* 242 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/* 245 */           ChatHandler.SendChatResponse.Builder res = ChatHandler.SendChatResponse.newBuilder();
/* 246 */           res.setS2CCode(200);
/* 247 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   private String checkServerData(WNPlayer player, String serverData, JSONObject json) {
/* 254 */     int level = player.getLevel();
/* 255 */     String name = player.getName();
/* 256 */     int pro = player.getPro();
/* 257 */     int vip = player.baseDataManager.getVip();
/* 258 */     json.put("s2c_level", Integer.valueOf(level));
/* 259 */     json.put("s2c_name", name);
/* 260 */     json.put("s2c_pro", Integer.valueOf(pro));
/* 261 */     json.put("s2c_vip", Integer.valueOf(vip));
/* 262 */     json.put("s2c_zoneId", Integer.valueOf(player.getLogicServerId()));
/* 263 */     return json.toJSONString();
/*     */   }
/*     */   
/*     */   private void sendTeam(WNPlayer player, PomeloPush chatPush) {
/* 267 */     TeamData team = player.getTeamManager().getTeam();
/* 268 */     if (team != null) {
/* 269 */       team.receive(chatPush);
/*     */     }
/*     */   }
/*     */   
/*     */   private String teamCall(WNPlayer player, String text, String serverData, String chatTime, int scope) {
/* 274 */     if (!(player.getTeamManager().getTeamMember()).isLeader)
/* 275 */       return LangService.format("TEAM_NO_AUTHORITY", new Object[0]); 
/* 276 */     Long callTime = (Long)this.pak.getAttr(INVITE_CALL);
/* 277 */     long currTime = System.currentTimeMillis();
/* 278 */     if (callTime != null) {
/* 279 */       long second = 60L - (currTime - callTime.longValue()) / 1000L;
/* 280 */       if (second > 0L) {
/* 281 */         return LangService.format("TEAM_CALL_COOL", new Object[] { Long.valueOf(second) });
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 288 */     this.pak.setAttr(INVITE_CALL, Long.valueOf(currTime));
/* 289 */     Collection<GPlayer> players = GWorld.getInstance().getOnlinePlayers().values();
/* 290 */     final ChatHandler.OnChatPush.Builder push = ChatHandler.OnChatPush.newBuilder();
/* 291 */     push.setS2CContent(text);
/* 292 */     push.setS2CPlayerId(player.getId());
/* 293 */     push.setS2CServerData(serverData);
/* 294 */     push.setS2CScope(Const.CHAT_SCOPE.TEAM.getValue());
/* 295 */     push.setS2CUid(this.pak.getUid());
/* 296 */     push.setS2CTime(chatTime);
/* 297 */     push.setS2CIndex(0);
/* 298 */     push.setS2CSys(scope);
/* 299 */     PomeloPush chatPush = new PomeloPush()
/*     */       {
/*     */         protected void write() throws IOException {
/* 302 */           this.body.writeBytes(push.build().toByteArray());
/*     */         }
/*     */ 
/*     */         
/*     */         public String getRoute() {
/* 307 */           return "chat.chatPush.onChatPush";
/*     */         }
/*     */       };
/* 310 */     for (GPlayer freer : players) {
/* 311 */       WNPlayer receiver = (WNPlayer)freer;
/* 312 */       if (receiver.getLevel() < GlobalConfig.Team_Min_Level)
/*     */         continue; 
/* 314 */       if (receiver.getTeamManager().getTeam() == player.getTeamManager().getTeam() || !receiver.getTeamManager().isInTeam()) {
/* 315 */         freer.receive((Message)chatPush);
/*     */       }
/*     */     } 
/* 318 */     Out.info(new Object[] { "[队伍]【", player.getName(), "】说：", text });
/*     */     
/* 320 */     return null;
/*     */   }
/*     */   
/*     */   public short getType() {
/* 324 */     return 513;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\chat\SendChatHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */