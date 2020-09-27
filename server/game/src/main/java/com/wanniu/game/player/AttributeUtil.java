package com.wanniu.game.player;

import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.AttributeCO;
import com.wanniu.game.data.GameData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import pomelo.Common;


public class AttributeUtil {
    public static String getKeyByName(String name) {
        for (AttributeCO dAttr : GameData.Attributes.values()) {
            if (dAttr.attName.equals(name)) {
                return dAttr.attKey;
            }
        }
        Out.error(new Object[]{name, " is not found:getKeyByName"});
        throw new RuntimeException();
    }

    public static String getNameByKey(String key) {
        for (AttributeCO dAttr : GameData.Attributes.values()) {
            if (dAttr.attKey.equals(key)) {
                return dAttr.attName;
            }
        }
        Out.error(new Object[]{key, " is not found:getNameByKey"});
        throw new RuntimeException();
    }

    public static AttributeCO find(String key) {
        for (AttributeCO dAttr : GameData.Attributes.values()) {
            if (dAttr.attKey.equals(key)) {
                return dAttr;
            }
        }
        Out.error(new Object[]{key, " is not found:find"});
        throw new RuntimeException();
    }

    public static String getDescByKey(String key) {
        for (AttributeCO dAttr : GameData.Attributes.values()) {
            if (dAttr.attKey.equals(key)) {
                return dAttr.attDesc;
            }
        }
        Out.error(new Object[]{key, " is not found:getDescByKey"});
        throw new RuntimeException();
    }

    public static int getIdByKey(String key) {
        for (AttributeCO dAttr : GameData.Attributes.values()) {
            if (dAttr.attKey.equals(key)) {
                return dAttr.iD;
            }
        }
        Out.error(new Object[]{key, " is not found:getIdByKey"});
        throw new RuntimeException();
    }

    public static int getIdByName(String name) {
        for (AttributeCO dAttr : GameData.Attributes.values()) {
            if (dAttr.attName.equals(name)) {
                return dAttr.iD;
            }
        }
        Out.error(new Object[]{name, " is not found:name"});
        throw new RuntimeException();
    }

    public static int getFormatByName(String name) {
        for (AttributeCO dAttr : GameData.Attributes.values()) {
            if (dAttr.attName.equals(name)) {
                return dAttr.isFormat;
            }
        }
        Out.error(new Object[]{name, " is not found:getFormatByName"});
        throw new RuntimeException();
    }

    public static AttributeCO getPropByKey(String key) {
        for (AttributeCO dAttr : GameData.Attributes.values()) {
            if (dAttr.attKey.equals(key)) {
                return dAttr;
            }
        }
        Out.error(new Object[]{key, " is not found:getPropByKey"});
        throw new RuntimeException();
    }

    public static AttributeCO getPropByName(String name) {
        for (AttributeCO dAttr : GameData.Attributes.values()) {
            if (dAttr.attName.equals(name)) {
                return dAttr;
            }
        }
        Out.error(new Object[]{name, " is not found:getPropByName"});
        throw new RuntimeException();
    }

    public static int getFormatByKey(String key) {
        for (AttributeCO dAttr : GameData.Attributes.values()) {
            if (dAttr.attKey.equals(key)) {
                return dAttr.isFormat;
            }
        }
        Out.error(new Object[]{key, " is not found:getFormatByKey"});
        throw new RuntimeException();
    }

    public static List<Common.AttributeSimple> getAttributeSimple(Map<String, Integer> attrs) {
        List<Common.AttributeSimple> data = new ArrayList<>();
        for (String key : attrs.keySet()) {
            for (AttributeCO da : GameData.Attributes.values()) {
                if (da.attKey.equals(key)) {
                    Common.AttributeSimple.Builder as = Common.AttributeSimple.newBuilder();
                    as.setId(da.iD);
                    as.setValue(((Integer) attrs.get(key)).intValue());
                    data.add(as.build());
                }
            }
        }
        return data;
    }


    public static List<Common.AttributeBase> getAttributeBase(Map<String, Integer> attrs) {
        ArrayList<Common.AttributeBase> data = new ArrayList<>();
        for (Map.Entry<String, Integer> node : attrs.entrySet()) {
            for (AttributeCO dAttr : GameData.Attributes.values()) {
                if (dAttr.attKey.equals(node.getKey())) {
                    Common.AttributeBase.Builder builder = Common.AttributeBase.newBuilder();
                    builder.setId(dAttr.iD);
                    builder.setValue(((Integer) node.getValue()).intValue());
                    builder.setIsFormat(dAttr.isFormat);
                    data.add(builder.build());
                }
            }
        }
        return data;
    }


    public static List<Common.AttributeBase> getAttributeBaseByArray(List<Map<String, Integer>> attrArray) {
        List<Common.AttributeBase> data = new ArrayList<>();
        for (int i = 0; i < attrArray.size(); i++) {
            Map<String, Integer> attrs = attrArray.get(i);
            for (String key : attrs.keySet()) {
                AttributeCO prop = find(key);
                if (null != prop) {
                    Common.AttributeBase.Builder attrBase = Common.AttributeBase.newBuilder();
                    attrBase.setId(prop.iD);
                    attrBase.setValue(((Integer) attrs.get(key)).intValue());
                    attrBase.setIsFormat(prop.isFormat);
                    data.add(attrBase.build());
                }
            }
        }
        return data;
    }


    public static List<Common.AttributeBase> getAttributeWithNext(Map<String, Integer> attrs, Map<String, Integer> nextAttrs) {
        List<Common.AttributeBase> data = new ArrayList<>();
        Iterator<String> nextKeys = nextAttrs.keySet().iterator();
        while (nextKeys.hasNext()) {
            String nextkey = nextKeys.next();
            AttributeCO prop = getPropByKey(nextkey);
            if (prop != null) {
                Common.AttributeBase.Builder ab = Common.AttributeBase.newBuilder();
                if (attrs.get(nextkey) != null && ((Integer) attrs.get(nextkey)).intValue() > 0) {
                    ab.setId(prop.iD);
                    ab.setValue(((Integer) attrs.get(nextkey)).intValue());
                    ab.setNextValue(((Integer) nextAttrs.get(nextkey)).intValue());
                    ab.setIsFormat(prop.isFormat);


                } else {


                    ab.setId(prop.iD);
                    ab.setValue(0);
                    ab.setNextValue(((Integer) nextAttrs.get(nextkey)).intValue());
                    ab.setIsFormat(prop.isFormat);
                }
                data.add(ab.build());
            }
        }

        return data;
    }


    public static ArrayList<Common.AttributeBase> getAttributeBaseWithParam1(Map<String, Integer> attrs, Map<String, Integer> param1Attrs) {
        ArrayList<Common.AttributeBase> data = new ArrayList<>();
        for (Map.Entry<String, Integer> node : attrs.entrySet()) {
            String key = node.getKey();
            AttributeCO prop = find(key);
            if (!param1Attrs.containsKey(key)) {
                param1Attrs.put(key, Integer.valueOf(0));
            }
            Common.AttributeBase.Builder builder = Common.AttributeBase.newBuilder();
            builder.setId(prop.iD);
            builder.setValue(((Integer) node.getValue()).intValue());
            builder.setParam1(((Integer) param1Attrs.get(key)).intValue());
            builder.setIsFormat(prop.isFormat);
            data.add(builder.build());
        }
        return data;
    }

    public static float getScoreRatioByKey(String key) {
        for (AttributeCO dAttr : GameData.Attributes.values()) {
            if (dAttr.attKey.equals(key)) {
                if (dAttr.isEffect == 1) {
                    return dAttr.scoreRatio;
                }
                return 0.0F;
            }
        }

        Out.error(new Object[]{key, " is not found:getScoreRatioByKey"});
        throw new RuntimeException();
    }


    public static void addData2AllData(Map<Const.PlayerBtlData, Integer> src, Map<Const.PlayerBtlData, Integer> dest) {
        for (Const.PlayerBtlData key : src.keySet()) {
            if (dest.containsKey(key)) {
                int value = ((Integer) dest.get(key)).intValue() + ((Integer) src.get(key)).intValue();
                dest.put(key, Integer.valueOf(value));
                continue;
            }
            dest.put(key, src.get(key));
        }
    }


    public static void addData2AllDataByKey(Map<String, Integer> src, Map<Const.PlayerBtlData, Integer> dest) {
        for (String key : src.keySet()) {
            Const.PlayerBtlData btlData = Const.PlayerBtlData.getEByKey(key);
            if (btlData == null) {
                Out.error(new Object[]{"找不到装备对应的属性：", key});
                continue;
            }
            if (dest.containsKey(btlData)) {
                int value = ((Integer) dest.get(btlData)).intValue() + ((Integer) src.get(key)).intValue();
                dest.put(btlData, Integer.valueOf(value));
                continue;
            }
            dest.put(btlData, src.get(key));
        }
    }
}


