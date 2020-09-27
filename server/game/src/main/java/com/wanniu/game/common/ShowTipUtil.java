/*     */ package com.wanniu.game.common;
/*     */ 
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import java.util.ArrayList;
/*     */ import pomelo.area.PlayerHandler;
/*     */ import pomelo.chat.ChatHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ShowTipUtil
/*     */ {
/*     */   public static void sendSysTip(WNPlayer player, String msg, Const.TipsType type) {
/*  21 */     ChatHandler.TipPush.Builder data = ChatHandler.TipPush.newBuilder();
/*  22 */     data.setS2CMsg(msg);
/*  23 */     if (type == null) {
/*  24 */       type = Const.TipsType.NORMAL;
/*     */     }
/*  26 */     data.setS2CType(type.getValue());
/*     */     
/*  28 */     player.receive("chat.chatPush.tipPush", (GeneratedMessage)data.build());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void sendItemTip(WNPlayer player, String itemName, int color, int itemCount) {
/*  36 */     String key = getColor(color);
/*  37 */     String name = LangService.getValue(key);
/*  38 */     name = name.replace("{a}", itemName);
/*  39 */     String str = LangService.getValue("ITEM_GET");
/*  40 */     str = str.replace("{itemName}", name);
/*  41 */     str = str.replace("{itemNm}", String.valueOf(itemCount));
/*  42 */     sendSysTip(player, str, Const.TipsType.NORMAL);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void sendFightTip(String playerId, int fightPower) {
/*  49 */     String str = LangService.getValue("FIGHT_POWER_ADD");
/*  50 */     str = str.replace("{fightPower}", String.valueOf(fightPower));
/*     */     
/*  52 */     WNPlayer player = GWorld.getInstance().getPlayer(playerId);
/*  53 */     if (player != null) {
/*  54 */       sendSysTip(player, str, Const.TipsType.NORMAL);
/*     */     }
/*     */   }
/*     */   
/*     */   public static String getColor(int quality) {
/*  59 */     String color = "WHITE";
/*  60 */     if (quality == Const.ItemQuality.WHITE.getValue()) {
/*  61 */       color = "WHITE";
/*  62 */     } else if (quality == Const.ItemQuality.GREEN.getValue()) {
/*  63 */       color = "GREEN";
/*  64 */     } else if (quality == Const.ItemQuality.BLUE.getValue()) {
/*  65 */       color = "BLUE";
/*  66 */     } else if (quality == Const.ItemQuality.PURPLE.getValue()) {
/*  67 */       color = "PURPLE";
/*  68 */     } else if (quality == Const.ItemQuality.ORANGE.getValue()) {
/*  69 */       color = "ORANGE";
/*  70 */     } else if (quality == Const.ItemQuality.RED.getValue()) {
/*  71 */       color = "RED";
/*     */     } 
/*  73 */     return color;
/*     */   }
/*     */   
/*     */   public static String getColorLink(int quality) {
/*  77 */     String color = "WHITE_LINK";
/*  78 */     if (quality == Const.ItemQuality.WHITE.getValue()) {
/*  79 */       color = "WHITE_LINK";
/*  80 */     } else if (quality == Const.ItemQuality.GREEN.getValue()) {
/*  81 */       color = "GREEN_LINK";
/*  82 */     } else if (quality == Const.ItemQuality.BLUE.getValue()) {
/*  83 */       color = "BLUE_LINK";
/*  84 */     } else if (quality == Const.ItemQuality.PURPLE.getValue()) {
/*  85 */       color = "PURPLE_LINK";
/*  86 */     } else if (quality == Const.ItemQuality.ORANGE.getValue()) {
/*  87 */       color = "ORANGE_LINK";
/*  88 */     } else if (quality == Const.ItemQuality.RED.getValue()) {
/*  89 */       color = "RED_LINK";
/*     */     } 
/*  91 */     return color;
/*     */   }
/*     */   
/*     */   public static String getMonsterName(String name, int qColor) {
/*  95 */     String key = getColor(qColor);
/*  96 */     String str = LangService.getValue(key);
/*  97 */     str = str.replace("{a}", name);
/*  98 */     return str;
/*     */   }
/*     */   
/*     */   public static void sendSysAttrMessageNew(WNPlayer player, int type, ArrayList<PlayerHandler.CommonProperty> propertys) {
/* 102 */     PlayerHandler.CommonPropertyPush.Builder push = PlayerHandler.CommonPropertyPush.newBuilder();
/* 103 */     push.setS2CType(type);
/* 104 */     push.addAllS2CProperty(propertys);
/* 105 */     player.receive("area.playerPush.commonPropertyPush", (GeneratedMessage)push.build());
/*     */   }
/*     */   
/*     */   public static String getPlayerNameColor(String name, int pro) {
/* 109 */     return LangService.format("NAME_COLOR", new Object[] { name });
/*     */   }
/*     */   
/*     */   public static String itemColorName(int qColor, String name) {
/* 113 */     String key = getColor(qColor);
/* 114 */     String colorStr = LangService.getValue(key);
/* 115 */     String nameStr = colorStr.replace("{a}", name);
/* 116 */     return nameStr;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\common\ShowTipUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */