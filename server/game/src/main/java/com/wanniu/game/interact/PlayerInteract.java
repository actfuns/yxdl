/*     */ package com.wanniu.game.interact;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.alibaba.fastjson.JSONArray;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.db.GCache;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.common.msg.MessageUtil;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.InteractionCO;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import pomelo.area.InteractHandler;
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
/*     */ public class PlayerInteract
/*     */ {
/*     */   private WNPlayer player;
/*     */   private int friendNum;
/*     */   private int commonNum;
/*     */   
/*     */   public PlayerInteract(WNPlayer player) {
/*  39 */     this.player = player;
/*  40 */     this.friendNum = 10;
/*  41 */     this.commonNum = 10;
/*  42 */     init();
/*     */   }
/*     */   
/*     */   private final void init() {
/*  46 */     String interact = GCache.hget(ConstsTR.player_interact_numTR.value, this.player.getId());
/*  47 */     if (interact != null) {
/*  48 */       String[] arr = interact.split("#");
/*  49 */       this.friendNum = Integer.parseInt(arr[0]);
/*  50 */       this.commonNum = Integer.parseInt(arr[1]);
/*     */     } else {
/*  52 */       this.friendNum = 10;
/*  53 */       this.commonNum = 10;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void sync() {
/*  58 */     GCache.hset(ConstsTR.player_interact_numTR.value, this.player.getId(), this.friendNum + "#" + this.commonNum);
/*     */   }
/*     */   
/*     */   public void push() {
/*  62 */     String interact = GCache.hget(ConstsTR.player_interactTR.value, this.player.getId());
/*  63 */     if (interact != null) {
/*  64 */       JSONArray arr = JSON.parseArray(interact);
/*  65 */       for (int i = 0; i < arr.size(); i++) {
/*  66 */         JSONObject data = arr.getJSONObject(i);
/*  67 */         receive(data.getIntValue("id"), data.getString("name"));
/*     */       } 
/*  69 */       GCache.hremove(ConstsTR.player_interactTR.value, this.player.getId());
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean send(int id, String playerId, String playerName) {
/*  74 */     InteractionCO prop = getPropById(id);
/*  75 */     if (prop == null) {
/*  76 */       return false;
/*     */     }
/*  78 */     WNPlayer player = GWorld.getInstance().getPlayer(playerId);
/*  79 */     if (player != null) {
/*  80 */       player.getInteractManager().receive(id, this.player.getName());
/*     */     } else {
/*  82 */       String interact = GCache.hget(ConstsTR.player_interactTR.value, playerId);
/*  83 */       JSONArray arr = (interact != null) ? JSON.parseArray(interact) : new JSONArray();
/*  84 */       arr.add(Utils.toJSON(new Object[] { "id", Integer.valueOf(id), "name", this.player.getName() }));
/*  85 */       GCache.hset(ConstsTR.player_interactTR.value, playerId, arr.toJSONString());
/*     */     } 
/*  87 */     subTimes(id);
/*  88 */     sendMessage(id, playerName);
/*  89 */     return true;
/*     */   }
/*     */   
/*     */   public void receive(int id, String name) {
/*  93 */     InteractionCO prop = getPropById(id);
/*  94 */     if (prop == null) {
/*     */       return;
/*     */     }
/*  97 */     this.player.player.charm += prop.charm;
/*  98 */     InteractHandler.ReceiveInteractPush.Builder data = InteractHandler.ReceiveInteractPush.newBuilder();
/*  99 */     data.setS2CCode(200);
/* 100 */     data.setId(id);
/* 101 */     data.setSendPlayerName(name);
/* 102 */     data.setShow(prop.show);
/* 103 */     this.player.receive("area.interactPush.receiveInteractPush", (GeneratedMessage)data.build());
/*     */   }
/*     */   
/*     */   public final InteractHandler.InteractTimesResponse.Builder interactTimes(WNPlayer player) {
/* 107 */     InteractHandler.InteractTimesResponse.Builder data = InteractHandler.InteractTimesResponse.newBuilder();
/* 108 */     data.setS2CCharm((player.getPlayer()).charm);
/* 109 */     ArrayList<InteractHandler.InteractTimes> list = new ArrayList<>();
/* 110 */     InteractHandler.InteractTimes.Builder time1 = InteractHandler.InteractTimes.newBuilder();
/* 111 */     time1.setType(Const.InteractType.FRIEND.getValue());
/* 112 */     time1.setTimes(this.friendNum);
/* 113 */     list.add(time1.build());
/* 114 */     InteractHandler.InteractTimes.Builder time2 = InteractHandler.InteractTimes.newBuilder();
/* 115 */     time2.setType(Const.InteractType.UNFRIEND.getValue());
/* 116 */     time2.setTimes(this.commonNum);
/* 117 */     list.add(time2.build());
/* 118 */     data.addAllS2CData(list);
/* 119 */     return data;
/*     */   }
/*     */   
/*     */   public final boolean enoughTimes(int id) {
/* 123 */     InteractionCO prop = getPropById(id);
/* 124 */     if (prop == null) {
/* 125 */       return false;
/*     */     }
/*     */     
/* 128 */     if (prop.type == Const.InteractType.FRIEND.getValue()) {
/* 129 */       if (this.friendNum > 0) {
/* 130 */         return true;
/*     */       }
/*     */     }
/* 133 */     else if (this.commonNum > 0) {
/* 134 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 138 */     return false;
/*     */   }
/*     */   
/*     */   public void subTimes(int id) {
/* 142 */     InteractionCO prop = getPropById(id);
/* 143 */     if (prop == null) {
/*     */       return;
/*     */     }
/*     */     
/* 147 */     if (prop.type == Const.InteractType.FRIEND.getValue()) {
/* 148 */       if (this.friendNum > 0) {
/* 149 */         this.friendNum--;
/*     */       }
/*     */     }
/* 152 */     else if (this.commonNum > 0) {
/* 153 */       this.commonNum--;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void sendMessage(int id, String name) {
/* 159 */     InteractionCO prop = getPropById(id);
/* 160 */     if (prop == null) {
/*     */       return;
/*     */     }
/*     */     
/* 164 */     String message = prop.message;
/* 165 */     message = message.replaceAll("\\|1\\|", this.player.getName());
/* 166 */     message = message.replaceAll("\\|2\\|", name);
/*     */     
/* 168 */     Out.debug(new Object[] { prop.message, "\n", message });
/*     */     
/* 170 */     MessageUtil.sendRollChat(this.player.getLogicServerId(), message, Const.CHAT_SCOPE.SYSTEM);
/*     */   }
/*     */   
/*     */   public static InteractionCO getPropById(int id) {
/* 174 */     return (InteractionCO)GameData.Interactions.get(Integer.valueOf(id));
/*     */   }
/*     */   
/*     */   public static ArrayList<InteractHandler.InteractConfig> getConfig() {
/* 178 */     ArrayList<InteractHandler.InteractConfig> data = new ArrayList<>();
/* 179 */     Collection<InteractionCO> props = GameData.Interactions.values();
/* 180 */     for (InteractionCO prop : props) {
/* 181 */       InteractHandler.InteractConfig.Builder tmp = InteractHandler.InteractConfig.newBuilder();
/* 182 */       tmp.setId(prop.id);
/* 183 */       tmp.setName(prop.name);
/* 184 */       tmp.setType(prop.type);
/* 185 */       tmp.setCharm(prop.charm);
/* 186 */       tmp.setGold(prop.gold);
/* 187 */       tmp.setDiamond(prop.diamond);
/* 188 */       tmp.setShow(prop.show);
/* 189 */       data.add(tmp.build());
/*     */     } 
/* 191 */     return data;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\interact\PlayerInteract.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */