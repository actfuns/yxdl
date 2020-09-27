package com.wanniu.game.chat;

import com.alibaba.fastjson.JSON;
import com.wanniu.core.db.GCache;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.equip.NormalEquip;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.item.po.PlayerItemPO;
import com.wanniu.game.player.WNPlayer;

import java.util.HashMap;
import java.util.Map;


public class ChannelUtil {
    private static final String ITEM_FLAG = "<a {\"Id\":\"";
    private static final String POSITION_FLAG = "<";

    public static String setItemInfo(NormalItem item) {
        Map<String, Object> o = new HashMap<>();
        o.put("MsgType", Integer.valueOf(1));
        o.put("Id", item.itemDb.id);
        o.put("Name", item.prop.name);
        o.put("Quality", Integer.valueOf(item.prop.qcolor));
        o.put("TemplateId", item.itemDb.code);

        if (item.isEquip()) {
            o.put("needQuery", Integer.valueOf(1));
            cacheChatItem(item.itemDb);
        } else {
            o.put("needQuery", Integer.valueOf(0));
        }

        return JSON.toJSONString(o);
    }

    public static String setAreaPosInfo(int mapId, int areaId, String instanceId, int x, int y) {
        Map<String, Object> o = new HashMap<>();
        o.put("MsgType", Integer.valueOf(6));
        Map<String, Object> data = new HashMap<>();
        data.put("mapId", Integer.valueOf(mapId));
        data.put("areaId", Integer.valueOf(areaId));
        data.put("instanceId", instanceId);
        data.put("targetX", Integer.valueOf(x));
        data.put("targetY", Integer.valueOf(y));
        o.put("data", data);

        return JSON.toJSONString(o);
    }

    public static String setPlayerInfo(WNPlayer player) {
        Map<String, Object> o = new HashMap<>();
        o.put("MsgType", Integer.valueOf(3));
        o.put("s2c_playerId", player.getId());
        o.put("s2c_name", player.getName());
        o.put("s2c_level", Integer.valueOf(player.getLevel()));
        o.put("s2c_pro", Integer.valueOf(player.getPro()));

        return JSON.toJSONString(o);
    }


    private static void cacheChatItem(PlayerItemPO item) {
        if (item != null) {
            GCache.put(ConstsTR.chat_item_tr.value + "/" + item.id, JSON.toJSONString(item), 600);
        }
    }

    public static boolean extractChatItem(WNPlayer player, String content) {
        boolean flag = false;
        for (int i = content.indexOf("<a {\"Id\":\"", 0); i >= 0; ) {
            int sIndex = i + "<a {\"Id\":\"".length();
            int eIndex = content.indexOf("\"", sIndex + 1);
            if (eIndex > sIndex) {
                NormalEquip normalEquip;
                String uuid = content.substring(i + "<a {\"Id\":\"".length(), eIndex);
                i = content.indexOf("<a {\"Id\":\"", eIndex);
                NormalItem item = player.getWnBag().findItemById(uuid);
                if (item == null) {
                    normalEquip = player.equipManager.getEquipById(uuid);
                }
                if (normalEquip != null) {
                    cacheChatItem(((NormalItem) normalEquip).itemDb);
                    flag = true;
                }
            }
        }


        if (!flag) {
            flag = (content.indexOf("<", 0) >= 0);
        }
        return flag;
    }


    public static String getChatLinkItem(NormalItem item) {
        if (item == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer("|<a ");

        ChatLinkItem cli = new ChatLinkItem();
        cli.Id = item.getId();
        cli.MsgType = 1;

        cli.Name = "[" + item.getName() + "]";
        cli.Quality = item.getQLevel();
        cli.TemplateId = (item.getTemplate()).code;
        cli.needQuery = 1;

        sb.append(JSON.toJSONString(cli));

        sb.append("></a>|");

        cacheChatItem(item.itemDb);
        return sb.toString();
    }
}


