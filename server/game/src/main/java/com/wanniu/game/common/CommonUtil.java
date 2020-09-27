package com.wanniu.game.common;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.base.FourProp;
import com.wanniu.game.data.ext.AffixExt;
import com.wanniu.game.data.ext.AttributeExt;
import com.wanniu.game.data.ext.BaseDataExt;
import com.wanniu.game.data.ext.CharacterExt;
import com.wanniu.game.message.MessageData;
import com.wanniu.game.util.BlackWordUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import pomelo.Common;


public class CommonUtil {
    public static Common.PropertyStruct.Builder transferDataType(String key, Object value) {
        Common.PropertyStruct.Builder data = Common.PropertyStruct.newBuilder();
        data.setKey(key);
        data.setValue(String.valueOf(value));

        if (value instanceof Integer) {
            data.setType(1);
        } else {
            data.setType(2);
        }
        return data;
    }


    public static int calFightPower(Map<Const.PlayerBtlData, Integer> allInflus) {
        float fightPower = 0.0F;
        Map<Integer, AttributeExt> map = GameData.Attributes;
        for (AttributeExt att : map.values()) {
            if (att.isEffect == 1 &&
                    allInflus.containsKey(att.btlProp)) {
                int value = ((Integer) allInflus.get(att.btlProp)).intValue();
                if (value > 0) {
                    fightPower += Math.abs(value) * att.scoreRatio;
                }
            }
        }


        return (int) fightPower;
    }


    public static int calPlayerFightPower(Map<Const.PlayerBtlData, Integer> allInflus, int pro) {
        float fightPower = 0.0F;
        Map<Integer, AttributeExt> map = GameData.Attributes;
        for (AttributeExt att : map.values()) {
            if (att.isEffect == 1) {
                if (att.btlProp == null) {
                    Out.error(new Object[]{"calPlayerFightPower :: ", att.attName});
                    continue;
                }
                if (allInflus.containsKey(att.btlProp)) {
                    int value = ((Integer) allInflus.get(att.btlProp)).intValue();
                    if (att.btlProp == Const.PlayerBtlData.CritDamage) {
                        value -= ((CharacterExt) GameData.Characters.get(Integer.valueOf(pro))).critDamage;
                    }
                    fightPower += Math.abs(value) * att.scoreRatio;
                }
            }
        }
        return (int) fightPower;
    }


    public static int calOneAttributeFightScroreByStr(String key, int value) {
        Const.PlayerBtlData data = Const.PlayerBtlData.valueOf(key);
        if (data == null) {
            Out.warn(new Object[]{"发现属性不存在2:", key});
            return 0;
        }
        AttributeExt att = (AttributeExt) GameData.Attributes.get(Integer.valueOf(data.id));
        if (att == null) {
            Out.warn(new Object[]{"发现属性不存在1:", key});
            return 0;
        }
        return (int) (Math.abs(value) * att.scoreRatio);
    }


    public static int calOneAttributeFightScroreById(int key, int value, int qColor) {
        AffixExt affix = (AffixExt) GameData.Affixs.get(Integer.valueOf(key));
        if (affix == null) {
            Out.warn(new Object[]{"发现属性不存在3:", Integer.valueOf(key)});
            return 0;
        }
        FourProp pair = (FourProp) affix.props.get(Integer.valueOf(qColor));
        if (pair == null) {
            Out.warn(new Object[]{"发现属性不存在4:", Integer.valueOf(key), ",", Integer.valueOf(qColor)});
            return 0;
        }
        return calOneAttributeFightScroreByStr(pair.prop, value);
    }


    public static int calPetFightPower(Map<Const.PlayerBtlData, Integer> allInflus, int petId) {
        float fightPower = 0.0F;
        Map<Integer, AttributeExt> map = GameData.Attributes;
        for (AttributeExt att : map.values()) {
            if (att.isEffect == 1 &&
                    allInflus.containsKey(att.btlProp)) {
                int value = ((Integer) allInflus.get(att.btlProp)).intValue();
                if (att.btlProp == Const.PlayerBtlData.CritDamage) {
                    value -= ((BaseDataExt) GameData.BaseDatas.get(Integer.valueOf(petId))).initCritDamage;
                }
                if (value > 0) {
                    fightPower += Math.abs(value) * att.scoreRatio;
                }
            }
        }

        return (int) fightPower;
    }


    public static int calFightPowerByData(Map<String, Integer> influs) {
        return 0;
    }


    public static int getUnRealLogicServerId(int logicServerId, int acrossServerId, boolean isAcross) {
        if (isAcross) {
            return acrossServerId;
        }
        return logicServerId;
    }


    public static int getGrowUpValue(int initValue, float growUpValue, int lvl) {
        return (int) Math.round(initValue * Math.pow(growUpValue, (lvl - 1)));
    }

    public static boolean isLegalString(String name) {
        String pattern = "^[一-龥_a-zA-Z0-9]+$";
        if (!name.matches("^[一-龥_a-zA-Z0-9]+$")) {
            return false;
        }
        if (BlackWordUtil.isIncludeBlackString(name)) {
            return false;
        }

        return true;
    }


    public static int getWeek() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(7) - 1;
        if (0 == w) {
            w = 7;
        }
        return w;
    }


    public static List<WNBag.SimpleItemInfo> parseItems(String itemStr) {
        List<WNBag.SimpleItemInfo> items = new ArrayList<>();
        if (StringUtil.isEmpty(itemStr)) {
            return items;
        }
        String[] timeStr = itemStr.split(";");
        for (int i = 0; i < timeStr.length; i++) {
            String elemStr = timeStr[i];
            if (!StringUtil.isEmpty(elemStr)) {


                String[] tmp = elemStr.split(":");

                if (tmp.length == 2) {

                    WNBag.SimpleItemInfo item = new WNBag.SimpleItemInfo();
                    item.itemCode = tmp[0];
                    item.itemNum = Integer.parseInt(tmp[1]);
                    items.add(item);
                }
            }
        }
        return items;
    }


    public static void sendIconMsgType(Const.MESSAGE_TYPE msgType, String playerId) {
        MessageData message = MessageUtil.createMessage(msgType.getValue(), playerId, null);
        MessageUtil.sendMessageToPlayer(message, playerId);
    }

    public static void printAttrMap(Map<Const.PlayerBtlData, Integer> map) {
        StringBuffer sb = new StringBuffer("");
        for (Const.PlayerBtlData pbd : map.keySet()) {
            sb.append(pbd.chName + ":" + map.get(pbd)).append("  ");
        }
        System.out.println(sb);
    }

    public static void printAttrList(List<Common.AttributeSimple> list) {
        StringBuffer sb = new StringBuffer("");
        for (Common.AttributeSimple attr : list) {
            int id = attr.getId();
            Const.PlayerBtlData pbd = Const.PlayerBtlData.getE(id);
            sb.append(pbd.chName + ":" + attr.getValue()).append("  ");
        }
        System.out.println(sb);
    }
}


