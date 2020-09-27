/*     */ package com.wanniu.game.equip;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.RandomUtil;
/*     */ import com.wanniu.game.chat.ChannelUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.common.msg.MessageUtil;
/*     */ import com.wanniu.game.data.base.DItemEquipBase;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ public class EquipCraftUtil
/*     */ {
/*     */   public static List<Integer> getRefineMagicGroupIds() {
/*  49 */     return EquipCraftConfig.getInstance().getRefineMagicGroupIds();
/*     */   }
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
/*     */   public static List<Integer> getAddGroupIds(List<Integer> oldGroupIds, List<Integer> allGroupIds, int maxCount, int maxRepeatGroupNum) {
/* 120 */     List<Integer> result = new ArrayList<>();
/* 121 */     int maxRepeatNum = maxRepeatGroupNum;
/* 122 */     if (maxRepeatNum == 0) {
/* 123 */       maxRepeatNum = 2;
/*     */     }
/* 125 */     List<Integer> addIds = new ArrayList<>();
/* 126 */     if (oldGroupIds.size() >= maxCount) {
/* 127 */       return result;
/*     */     }
/* 129 */     Map<Integer, Integer> groupCount = new HashMap<>();
/* 130 */     List<Integer> oldList = new ArrayList<>();
/* 131 */     List<Integer> allList = new ArrayList<>();
/* 132 */     allGroupIds.forEach(groupId -> allList.add(groupId));
/*     */ 
/*     */ 
/*     */     
/* 136 */     Iterator<Integer> iter = oldGroupIds.iterator();
/* 137 */     while (iter.hasNext()) {
/* 138 */       int groupId = ((Integer)iter.next()).intValue();
/*     */       
/* 140 */       oldList.add(Integer.valueOf(groupId));
/* 141 */       if (groupCount.get(Integer.valueOf(groupId)) == null || ((Integer)groupCount.get(Integer.valueOf(groupId))).intValue() == 0) {
/* 142 */         groupCount.put(Integer.valueOf(groupId), Integer.valueOf(1));
/*     */       } else {
/* 144 */         groupCount.put(Integer.valueOf(groupId), Integer.valueOf(((Integer)groupCount.get(Integer.valueOf(groupId))).intValue() + 1));
/*     */       } 
/* 146 */       if (((Integer)groupCount.get(Integer.valueOf(groupId))).intValue() >= maxRepeatNum) {
/* 147 */         int index = allList.indexOf(Integer.valueOf(groupId));
/* 148 */         allList.remove(index);
/*     */       } 
/*     */     } 
/*     */     
/* 152 */     for (int i = oldList.size(); i < maxCount; i++) {
/* 153 */       int index = Utils.random(1, allList.size());
/* 154 */       if (index <= 0) {
/*     */         break;
/*     */       }
/* 157 */       index--;
/* 158 */       int groupId = ((Integer)allList.get(index)).intValue();
/* 159 */       addIds.add(Integer.valueOf(groupId));
/* 160 */       if (groupCount.get(Integer.valueOf(groupId)) != null && ((Integer)groupCount.get(Integer.valueOf(groupId))).intValue() != 0) {
/* 161 */         groupCount.put(Integer.valueOf(groupId), Integer.valueOf(((Integer)groupCount.get(Integer.valueOf(groupId))).intValue() + 1));
/*     */       } else {
/* 163 */         groupCount.put(Integer.valueOf(groupId), Integer.valueOf(1));
/*     */       } 
/* 165 */       if (((Integer)groupCount.get(Integer.valueOf(groupId))).intValue() >= maxRepeatNum) {
/* 166 */         allList.remove(index);
/*     */       }
/*     */     } 
/*     */     
/* 170 */     return addIds;
/*     */   }
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
/*     */   public static int getRefreshGroupId(List<Integer> oldGroupIds, List<Integer> allGroupIds, int refreshIndex, int maxRepeatGroupNum) {
/* 183 */     if (refreshIndex >= oldGroupIds.size()) {
/* 184 */       return 0;
/*     */     }
/* 186 */     List<Integer> oldList = new ArrayList<>();
/* 187 */     oldGroupIds.forEach(groupId -> oldList.add(groupId));
/*     */ 
/*     */ 
/*     */     
/* 191 */     oldList.remove(refreshIndex);
/* 192 */     List<Integer> addIds = getAddGroupIds(oldList, allGroupIds, oldGroupIds.size(), maxRepeatGroupNum);
/* 193 */     if (addIds.size() > 0) {
/* 194 */       return ((Integer)addIds.get(0)).intValue();
/*     */     }
/* 196 */     return 0;
/*     */   }
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
/*     */   public static void sendEquipCombineMsg(WNPlayer player, DItemEquipBase prop) {
/* 210 */     int minColor = GlobalConfig.Item_Qcolor_Combine_Notice;
/* 211 */     Out.debug(new Object[] { "sendEquipCombineMsg minColor", Integer.valueOf(minColor), ",itemColor:", Integer.valueOf(prop.qcolor), ", item:", prop.code });
/* 212 */     if (prop.qcolor < minColor) {
/*     */       return;
/*     */     }
/*     */     
/* 216 */     String playerName = PlayerUtil.getColorPlayerNameByPro(player.player.pro, player.getName());
/* 217 */     String targetName = ItemUtil.getColorItemNameByQcolor(prop.qcolor, prop.name);
/* 218 */     int msgIndex = RandomUtil.getInt(1, 3);
/* 219 */     String msgKey = "ITEM_COMBINE_SPEAKER" + msgIndex;
/* 220 */     String msgStr = LangService.getValue(msgKey);
/* 221 */     msgStr = msgStr.replace("{playerName}", playerName);
/* 222 */     msgStr = msgStr.replace("{ItemName}", targetName);
/* 223 */     MessageUtil.sendRollChat(player.getLogicServerId(), msgStr, Const.CHAT_SCOPE.SYSTEM);
/*     */   }
/*     */   
/*     */   public static void sendEquipMakeMsg(WNPlayer player, NormalItem item) {
/* 227 */     int minColor = GlobalConfig.Equipment_Qcolor_Make_Notice;
/* 228 */     if (item.prop.qcolor < minColor) {
/*     */       return;
/*     */     }
/*     */     
/* 232 */     String playerName = PlayerUtil.getColorPlayerNameByPro(player.getPro(), player.getName());
/*     */ 
/*     */     
/* 235 */     String targetName = LangService.getValue(MessageUtil.getColorLink(item.prop.qcolor));
/* 236 */     String itemLink = ChannelUtil.setItemInfo(item);
/* 237 */     targetName = targetName.replace("{a}", item.prop.name).replace("{b}", itemLink);
/*     */     
/* 239 */     int msgIndex = Utils.random(1, 3);
/* 240 */     String msgKey = "EQUIPMENT_MAKE_SPEAKER" + msgIndex;
/* 241 */     String msgStr = LangService.getValue(msgKey);
/* 242 */     msgStr = msgStr.replace("{playerName}", playerName);
/* 243 */     msgStr = msgStr.replace("{ItemName}", targetName);
/* 244 */     MessageUtil.sendRollChat(player.getLogicServerId(), msgStr, Const.CHAT_SCOPE.SYSTEM);
/*     */   }
/*     */   
/*     */   public static void sendEquipLevelUpMsg(WNPlayer player, NormalItem item) {
/* 248 */     int minUpLevel = GlobalConfig.Equipment_UpLevel_LevelUp_Notice;
/* 249 */     if (item.getUpLevel() < minUpLevel) {
/*     */       return;
/*     */     }
/*     */     
/* 253 */     String playerName = PlayerUtil.getColorPlayerNameByPro(player.getPro(), player.getName());
/* 254 */     String targetName = ItemUtil.getColorItemNameByQcolor(item.prop.qcolor, item.prop.name);
/* 255 */     String levelKey = "upnmb" + item.getUpLevel();
/* 256 */     String levelName = LangService.getValue(levelKey);
/*     */     
/* 258 */     int msgIndex = Utils.random(1, 3);
/* 259 */     String msgKey = "EQUIPMENT_LEVELUP_SPEAKER" + msgIndex;
/* 260 */     String msgStr = LangService.getValue(msgKey);
/* 261 */     msgStr = msgStr.replace("{playerName}", playerName);
/* 262 */     msgStr = msgStr.replace("{EquipmentName}", targetName);
/* 263 */     msgStr = msgStr.replace("{EquipmentWearLv}", levelName);
/* 264 */     MessageUtil.sendRollChat(player.getLogicServerId(), msgStr, Const.CHAT_SCOPE.SYSTEM);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\equip\EquipCraftUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */