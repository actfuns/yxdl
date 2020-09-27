/*     */ package com.wanniu.game.chat;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.wanniu.core.db.GCache;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.equip.NormalEquip;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.item.po.PlayerItemPO;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChannelUtil
/*     */ {
/*     */   private static final String ITEM_FLAG = "<a {\"Id\":\"";
/*     */   private static final String POSITION_FLAG = "<";
/*     */   
/*     */   public static String setItemInfo(NormalItem item) {
/*  25 */     Map<String, Object> o = new HashMap<>();
/*  26 */     o.put("MsgType", Integer.valueOf(1));
/*  27 */     o.put("Id", item.itemDb.id);
/*  28 */     o.put("Name", item.prop.name);
/*  29 */     o.put("Quality", Integer.valueOf(item.prop.qcolor));
/*  30 */     o.put("TemplateId", item.itemDb.code);
/*     */     
/*  32 */     if (item.isEquip()) {
/*  33 */       o.put("needQuery", Integer.valueOf(1));
/*  34 */       cacheChatItem(item.itemDb);
/*     */     } else {
/*  36 */       o.put("needQuery", Integer.valueOf(0));
/*     */     } 
/*     */     
/*  39 */     return JSON.toJSONString(o);
/*     */   }
/*     */   
/*     */   public static String setAreaPosInfo(int mapId, int areaId, String instanceId, int x, int y) {
/*  43 */     Map<String, Object> o = new HashMap<>();
/*  44 */     o.put("MsgType", Integer.valueOf(6));
/*  45 */     Map<String, Object> data = new HashMap<>();
/*  46 */     data.put("mapId", Integer.valueOf(mapId));
/*  47 */     data.put("areaId", Integer.valueOf(areaId));
/*  48 */     data.put("instanceId", instanceId);
/*  49 */     data.put("targetX", Integer.valueOf(x));
/*  50 */     data.put("targetY", Integer.valueOf(y));
/*  51 */     o.put("data", data);
/*     */     
/*  53 */     return JSON.toJSONString(o);
/*     */   }
/*     */   
/*     */   public static String setPlayerInfo(WNPlayer player) {
/*  57 */     Map<String, Object> o = new HashMap<>();
/*  58 */     o.put("MsgType", Integer.valueOf(3));
/*  59 */     o.put("s2c_playerId", player.getId());
/*  60 */     o.put("s2c_name", player.getName());
/*  61 */     o.put("s2c_level", Integer.valueOf(player.getLevel()));
/*  62 */     o.put("s2c_pro", Integer.valueOf(player.getPro()));
/*     */     
/*  64 */     return JSON.toJSONString(o);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void cacheChatItem(PlayerItemPO item) {
/*  71 */     if (item != null) {
/*  72 */       GCache.put(ConstsTR.chat_item_tr.value + "/" + item.id, JSON.toJSONString(item), 600);
/*     */     }
/*     */   }
/*     */   
/*     */   public static boolean extractChatItem(WNPlayer player, String content) {
/*  77 */     boolean flag = false;
/*  78 */     for (int i = content.indexOf("<a {\"Id\":\"", 0); i >= 0; ) {
/*  79 */       int sIndex = i + "<a {\"Id\":\"".length();
/*  80 */       int eIndex = content.indexOf("\"", sIndex + 1);
/*  81 */       if (eIndex > sIndex) {
/*  82 */         NormalEquip normalEquip; String uuid = content.substring(i + "<a {\"Id\":\"".length(), eIndex);
/*  83 */         i = content.indexOf("<a {\"Id\":\"", eIndex);
/*  84 */         NormalItem item = player.getWnBag().findItemById(uuid);
/*  85 */         if (item == null) {
/*  86 */           normalEquip = player.equipManager.getEquipById(uuid);
/*     */         }
/*  88 */         if (normalEquip != null) {
/*  89 */           cacheChatItem(((NormalItem)normalEquip).itemDb);
/*  90 */           flag = true;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  96 */     if (!flag) {
/*  97 */       flag = (content.indexOf("<", 0) >= 0);
/*     */     }
/*  99 */     return flag;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getChatLinkItem(NormalItem item) {
/* 106 */     if (item == null) {
/* 107 */       return "";
/*     */     }
/* 109 */     StringBuffer sb = new StringBuffer("|<a ");
/*     */     
/* 111 */     ChatLinkItem cli = new ChatLinkItem();
/* 112 */     cli.Id = item.getId();
/* 113 */     cli.MsgType = 1;
/*     */     
/* 115 */     cli.Name = "[" + item.getName() + "]";
/* 116 */     cli.Quality = item.getQLevel();
/* 117 */     cli.TemplateId = (item.getTemplate()).code;
/* 118 */     cli.needQuery = 1;
/*     */     
/* 120 */     sb.append(JSON.toJSONString(cli));
/*     */     
/* 122 */     sb.append("></a>|");
/*     */     
/* 124 */     cacheChatItem(item.itemDb);
/* 125 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\chat\ChannelUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */