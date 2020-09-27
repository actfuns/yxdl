package com.wanniu.game.equip;

import com.wanniu.core.game.LangService;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.RandomUtil;
import com.wanniu.game.chat.ChannelUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.Utils;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.data.base.DItemEquipBase;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class EquipCraftUtil {
    public static List<Integer> getRefineMagicGroupIds() {
        return EquipCraftConfig.getInstance().getRefineMagicGroupIds();
    }


    public static List<Integer> getAddGroupIds(List<Integer> oldGroupIds, List<Integer> allGroupIds, int maxCount, int maxRepeatGroupNum) {
        List<Integer> result = new ArrayList<>();
        int maxRepeatNum = maxRepeatGroupNum;
        if (maxRepeatNum == 0) {
            maxRepeatNum = 2;
        }
        List<Integer> addIds = new ArrayList<>();
        if (oldGroupIds.size() >= maxCount) {
            return result;
        }
        Map<Integer, Integer> groupCount = new HashMap<>();
        List<Integer> oldList = new ArrayList<>();
        List<Integer> allList = new ArrayList<>();
        allGroupIds.forEach(groupId -> allList.add(groupId));


        Iterator<Integer> iter = oldGroupIds.iterator();
        while (iter.hasNext()) {
            int groupId = ((Integer) iter.next()).intValue();

            oldList.add(Integer.valueOf(groupId));
            if (groupCount.get(Integer.valueOf(groupId)) == null || ((Integer) groupCount.get(Integer.valueOf(groupId))).intValue() == 0) {
                groupCount.put(Integer.valueOf(groupId), Integer.valueOf(1));
            } else {
                groupCount.put(Integer.valueOf(groupId), Integer.valueOf(((Integer) groupCount.get(Integer.valueOf(groupId))).intValue() + 1));
            }
            if (((Integer) groupCount.get(Integer.valueOf(groupId))).intValue() >= maxRepeatNum) {
                int index = allList.indexOf(Integer.valueOf(groupId));
                allList.remove(index);
            }
        }

        for (int i = oldList.size(); i < maxCount; i++) {
            int index = Utils.random(1, allList.size());
            if (index <= 0) {
                break;
            }
            index--;
            int groupId = ((Integer) allList.get(index)).intValue();
            addIds.add(Integer.valueOf(groupId));
            if (groupCount.get(Integer.valueOf(groupId)) != null && ((Integer) groupCount.get(Integer.valueOf(groupId))).intValue() != 0) {
                groupCount.put(Integer.valueOf(groupId), Integer.valueOf(((Integer) groupCount.get(Integer.valueOf(groupId))).intValue() + 1));
            } else {
                groupCount.put(Integer.valueOf(groupId), Integer.valueOf(1));
            }
            if (((Integer) groupCount.get(Integer.valueOf(groupId))).intValue() >= maxRepeatNum) {
                allList.remove(index);
            }
        }

        return addIds;
    }


    public static int getRefreshGroupId(List<Integer> oldGroupIds, List<Integer> allGroupIds, int refreshIndex, int maxRepeatGroupNum) {
        if (refreshIndex >= oldGroupIds.size()) {
            return 0;
        }
        List<Integer> oldList = new ArrayList<>();
        oldGroupIds.forEach(groupId -> oldList.add(groupId));


        oldList.remove(refreshIndex);
        List<Integer> addIds = getAddGroupIds(oldList, allGroupIds, oldGroupIds.size(), maxRepeatGroupNum);
        if (addIds.size() > 0) {
            return ((Integer) addIds.get(0)).intValue();
        }
        return 0;
    }


    public static void sendEquipCombineMsg(WNPlayer player, DItemEquipBase prop) {
        int minColor = GlobalConfig.Item_Qcolor_Combine_Notice;
        Out.debug(new Object[]{"sendEquipCombineMsg minColor", Integer.valueOf(minColor), ",itemColor:", Integer.valueOf(prop.qcolor), ", item:", prop.code});
        if (prop.qcolor < minColor) {
            return;
        }

        String playerName = PlayerUtil.getColorPlayerNameByPro(player.player.pro, player.getName());
        String targetName = ItemUtil.getColorItemNameByQcolor(prop.qcolor, prop.name);
        int msgIndex = RandomUtil.getInt(1, 3);
        String msgKey = "ITEM_COMBINE_SPEAKER" + msgIndex;
        String msgStr = LangService.getValue(msgKey);
        msgStr = msgStr.replace("{playerName}", playerName);
        msgStr = msgStr.replace("{ItemName}", targetName);
        MessageUtil.sendRollChat(player.getLogicServerId(), msgStr, Const.CHAT_SCOPE.SYSTEM);
    }

    public static void sendEquipMakeMsg(WNPlayer player, NormalItem item) {
        int minColor = GlobalConfig.Equipment_Qcolor_Make_Notice;
        if (item.prop.qcolor < minColor) {
            return;
        }

        String playerName = PlayerUtil.getColorPlayerNameByPro(player.getPro(), player.getName());


        String targetName = LangService.getValue(MessageUtil.getColorLink(item.prop.qcolor));
        String itemLink = ChannelUtil.setItemInfo(item);
        targetName = targetName.replace("{a}", item.prop.name).replace("{b}", itemLink);

        int msgIndex = Utils.random(1, 3);
        String msgKey = "EQUIPMENT_MAKE_SPEAKER" + msgIndex;
        String msgStr = LangService.getValue(msgKey);
        msgStr = msgStr.replace("{playerName}", playerName);
        msgStr = msgStr.replace("{ItemName}", targetName);
        MessageUtil.sendRollChat(player.getLogicServerId(), msgStr, Const.CHAT_SCOPE.SYSTEM);
    }

    public static void sendEquipLevelUpMsg(WNPlayer player, NormalItem item) {
        int minUpLevel = GlobalConfig.Equipment_UpLevel_LevelUp_Notice;
        if (item.getUpLevel() < minUpLevel) {
            return;
        }

        String playerName = PlayerUtil.getColorPlayerNameByPro(player.getPro(), player.getName());
        String targetName = ItemUtil.getColorItemNameByQcolor(item.prop.qcolor, item.prop.name);
        String levelKey = "upnmb" + item.getUpLevel();
        String levelName = LangService.getValue(levelKey);

        int msgIndex = Utils.random(1, 3);
        String msgKey = "EQUIPMENT_LEVELUP_SPEAKER" + msgIndex;
        String msgStr = LangService.getValue(msgKey);
        msgStr = msgStr.replace("{playerName}", playerName);
        msgStr = msgStr.replace("{EquipmentName}", targetName);
        msgStr = msgStr.replace("{EquipmentWearLv}", levelName);
        MessageUtil.sendRollChat(player.getLogicServerId(), msgStr, Const.CHAT_SCOPE.SYSTEM);
    }
}


