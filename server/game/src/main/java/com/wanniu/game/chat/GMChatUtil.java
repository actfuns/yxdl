/*     */ package com.wanniu.game.chat;
/*     */ 
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.GMain;
/*     */ import com.wanniu.game.chat.command.GmCommand;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.guild.guildBoss.GuildBossService;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.prepaid.PrepaidService;
/*     */ 
/*     */ public class GMChatUtil
/*     */ {
/*     */   public static GMChatResult checkContent(WNPlayer player, String content) {
/*  15 */     String[] contents = content.split(" ");
/*     */ 
/*     */     
/*  18 */     GmCommand command = GmCommandManager.find(contents);
/*  19 */     if (command != null) {
/*  20 */       return command.call(player, contents);
/*     */     }
/*     */     
/*  23 */     String startContent = contents[0];
/*  24 */     String operate = contents[1];
/*  25 */     String helpData = "@gm help \t帮助\n@gm add exp num \t添加经验\n@gm add gold num \t添加金币\n@gm add itemCode num \t添加道具\n@gm finishTask id \t结束任务\n@gm finishTask 0:主线 1:支线 2:师门 3:一条龙 \t任务类型\n@gm tp mapId \t传送场景\n@gm addRank id\n@gm addReiki num\n@gm openWing \n@gm addPetExp petId num\n@gm prepaid MoneyNum\n@gm openFunc functionID\n@gm config k v\n@gm guildAdd name num \n@gm guildFundAdd num \t添加仙盟基金\n@gm guildExpAdd num \t添加仙盟声望\n@gm allSkin \t获得所有坐骑皮肤\n@gm give name \t把某个玩家绑定到自己身上\n";
/*     */     
/*  27 */     if (StringUtil.isNotEmpty(startContent) && startContent.toLowerCase().equals("@gm") && StringUtil.isNotEmpty(operate)) {
/*     */       
/*  29 */       if (operate.equals("help")) {
/*  30 */         return new GMChatResult(true, helpData);
/*     */       }
/*  32 */       if (operate.equals("refresh")) {
/*  33 */         if (contents.length >= 2 && !"lang".equals(contents[2]))
/*     */         {
/*  35 */           GMain.initData();
/*     */         }
/*  37 */         return new GMChatResult(true, "success");
/*  38 */       }  if (operate.equals("add")) {
/*     */         try {
/*  40 */           String itemCode = contents[2];
/*  41 */           int num = Integer.parseInt(contents[3]);
/*  42 */           if (StringUtil.isNotEmpty(itemCode) && num > 0) {
/*  43 */             PlayerUtil.handleGMChat(player, Utils.ofMap(new Object[] { "operate", "add", "itemCode", itemCode, "num", Integer.valueOf(num) }));
/*     */           }
/*  45 */         } catch (Exception e) {
/*  46 */           return new GMChatResult(true, helpData);
/*     */         } 
/*  48 */         return new GMChatResult(true, "success");
/*  49 */       }  if (operate.equalsIgnoreCase("addRank") || operate.equalsIgnoreCase("finishTask") || operate.equalsIgnoreCase("acceptTask") || operate.equals("finishTaskTarget") || operate.equalsIgnoreCase("discardTask") || operate.equalsIgnoreCase("newTask")) {
/*     */         try {
/*  51 */           String id = contents[2];
/*  52 */           if (StringUtil.isNotEmpty(id) || operate.equals("discardTask")) {
/*  53 */             PlayerUtil.handleGMChat(player, Utils.ofMap(new Object[] { "operate", operate, "id", Integer.valueOf(Integer.parseInt(id)) }));
/*     */           }
/*  55 */         } catch (Exception e) {
/*  56 */           return new GMChatResult(true, helpData);
/*     */         } 
/*  58 */         return new GMChatResult(true, "success");
/*  59 */       }  if (operate.equals("config")) {
/*     */         try {
/*  61 */           String key = contents[2];
/*  62 */           String v = contents[3];
/*  63 */           if (StringUtil.isNotEmpty(key)) {
/*  64 */             player.setClientCustomConfig(key, v, true);
/*     */           }
/*  66 */         } catch (Exception e) {
/*  67 */           return new GMChatResult(true, helpData);
/*     */         } 
/*  69 */         return new GMChatResult(true, "success");
/*  70 */       }  if (operate.equals("addReiki")) {
/*     */         try {
/*  72 */           String num = contents[2];
/*  73 */           if (StringUtil.isNotEmpty(num)) {
/*  74 */             int _num = Integer.parseInt(num);
/*  75 */             PlayerUtil.handleGMChat(player, Utils.ofMap(new Object[] { "operate", "addReiki", "num", Integer.valueOf(_num) }));
/*     */           } 
/*  77 */         } catch (Exception e) {
/*  78 */           return new GMChatResult(true, helpData);
/*     */         } 
/*  80 */         return new GMChatResult(true, "success");
/*  81 */       }  if (operate.equals("openWing")) {
/*     */         try {
/*  83 */           PlayerUtil.handleGMChat(player, Utils.ofMap(new Object[] { "operate", "openWing" }));
/*  84 */         } catch (Exception e) {
/*  85 */           return new GMChatResult(true, helpData);
/*     */         } 
/*  87 */         return new GMChatResult(true, "success");
/*  88 */       }  if (operate.equals("addPetExp")) {
/*     */         try {
/*  90 */           String petId = contents[2];
/*  91 */           String num = contents[3];
/*  92 */           PlayerUtil.handleGMChat(player, Utils.ofMap(new Object[] { "operate", "addPetExp", "petId", petId, "num", num }));
/*  93 */         } catch (Exception e) {
/*  94 */           return new GMChatResult(true, helpData);
/*     */         } 
/*  96 */         return new GMChatResult(true, "success");
/*  97 */       }  if (operate.equals("test"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 103 */         return new GMChatResult(true, "success"); } 
/* 104 */       if (operate.equals("prepaid")) {
/*     */         try {
/* 106 */           int money = Integer.parseInt(contents[2]);
/* 107 */           PlayerUtil.handleGMChat(player, Utils.ofMap(new Object[] { "operate", "prepaid", "money", Integer.valueOf(money) }));
/* 108 */         } catch (Exception e) {
/* 109 */           return new GMChatResult(true, helpData);
/*     */         } 
/* 111 */         return new GMChatResult(true, "success");
/* 112 */       }  if (operate.equals("openFunc")) {
/*     */         try {
/* 114 */           int functionID = 0;
/* 115 */           if (contents.length >= 3) {
/* 116 */             functionID = Integer.parseInt(contents[2]);
/*     */           }
/* 118 */           PlayerUtil.handleGMChat(player, Utils.ofMap(new Object[] { "operate", "openFunc", "functionID", Integer.valueOf(functionID) }));
/* 119 */         } catch (Exception e) {
/* 120 */           return new GMChatResult(true, helpData);
/*     */         } 
/* 122 */         return new GMChatResult(true, "success");
/* 123 */       }  if (operate.equals("guildAdd")) {
/*     */         try {
/* 125 */           String moneyName = contents[2];
/* 126 */           int num = StringUtil.isNotEmpty(contents[3]) ? Integer.parseInt(contents[3]) : 1;
/* 127 */           if (StringUtil.isNotEmpty(moneyName) && num > 0) {
/* 128 */             PlayerUtil.handleGMChat(player, Utils.ofMap(new Object[] { "operate", "guildAdd", "moneyName", moneyName, "num", Integer.valueOf(num) }));
/*     */           }
/* 130 */         } catch (Exception e) {
/* 131 */           return new GMChatResult(true, helpData);
/*     */         } 
/* 133 */         return new GMChatResult(true, "success");
/* 134 */       }  if (operate.equals("tp")) {
/* 135 */         int mapID = 0;
/* 136 */         if (contents.length >= 3) {
/* 137 */           mapID = Integer.parseInt(contents[2]);
/*     */         }
/* 139 */         PlayerUtil.handleGMChat(player, Utils.ofMap(new Object[] { "operate", "tp", "mapID", Integer.valueOf(mapID) }));
/* 140 */         return new GMChatResult(true, "success");
/* 141 */       }  if (operate.equals("guildboss")) {
/* 142 */         String tp = null;
/* 143 */         if (contents.length >= 3) {
/* 144 */           tp = contents[2];
/*     */         }
/* 146 */         if ("begin".equals(tp)) {
/* 147 */           GuildBossService.getInstance().gmBegin();
/*     */         } else {
/* 149 */           GuildBossService.getInstance().gmEnd();
/*     */         } 
/*     */         
/* 152 */         return new GMChatResult(true, "success");
/* 153 */       }  if (operate.equals("guildFundAdd")) {
/*     */         try {
/* 155 */           String num = contents[2];
/* 156 */           if (StringUtil.isNotEmpty(num)) {
/* 157 */             int _num = Integer.parseInt(num);
/* 158 */             PlayerUtil.handleGMChat(player, Utils.ofMap(new Object[] { "operate", "guildFundAdd", "num", Integer.valueOf(_num) }));
/*     */           } 
/* 160 */         } catch (Exception e) {
/* 161 */           return new GMChatResult(true, helpData);
/*     */         } 
/* 163 */         return new GMChatResult(true, "success");
/* 164 */       }  if (operate.equals("guildExpAdd")) {
/*     */         try {
/* 166 */           String num = contents[2];
/* 167 */           if (StringUtil.isNotEmpty(num)) {
/* 168 */             int _num = Integer.parseInt(num);
/* 169 */             PlayerUtil.handleGMChat(player, Utils.ofMap(new Object[] { "operate", "guildExpAdd", "num", Integer.valueOf(_num) }));
/*     */           } 
/* 171 */         } catch (Exception e) {
/* 172 */           return new GMChatResult(true, helpData);
/*     */         } 
/* 174 */         return new GMChatResult(true, "success");
/* 175 */       }  if (operate.equals("allSkin")) {
/*     */         try {
/* 177 */           player.mountManager.addAllSkin();
/* 178 */         } catch (Exception e) {
/* 179 */           return new GMChatResult(true, helpData);
/*     */         } 
/* 181 */         return new GMChatResult(true, "success");
/* 182 */       }  if (operate.equals("unlock")) {
/* 183 */         int num = Integer.parseInt(contents[2]);
/* 184 */         player.getWnBag().addBagGridCount(num);
/* 185 */         return new GMChatResult(true, "success");
/* 186 */       }  if (operate.equals("paySuccess")) {
/* 187 */         String orderId = contents[2];
/* 188 */         PrepaidService.getInstance().onPaySuccess(orderId);
/* 189 */         return new GMChatResult(true, "success");
/*     */       } 
/* 191 */       return new GMChatResult(true, helpData);
/*     */     } 
/*     */     
/* 194 */     return new GMChatResult(false, content);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class GMChatResult
/*     */   {
/*     */     public boolean isGm;
/*     */     
/*     */     public String content;
/*     */     
/*     */     public GMChatResult() {}
/*     */     
/*     */     public GMChatResult(boolean isGm, String content) {
/* 207 */       this.isGm = isGm;
/* 208 */       this.content = content;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\chat\GMChatUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */