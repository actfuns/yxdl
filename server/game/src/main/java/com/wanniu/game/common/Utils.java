package com.wanniu.game.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.RandomUtil;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.base.FourProp;
import com.wanniu.game.data.ext.AffixExt;
import com.wanniu.game.equip.RepeatKeyMap;
import com.wanniu.game.item.data.AttsObj;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class Utils {
    private static SerializeConfig mapping = new SerializeConfig();


    private static String dateFormat = "yyyy-MM-dd HH:mm:ss";

    static {
        mapping.put(Date.class, (ObjectSerializer) new SimpleDateFormatSerializer(dateFormat));
    }

    public static boolean randomPercent(int per) {
        int ran = random(1, 100);
        return (ran >= 1 && ran <= per);
    }

    public static int getIndexByRareByList(List<Integer> rareArray) {
        if (rareArray == null || rareArray.size() == 0) {
            return 0;
        }
        int[] array = new int[rareArray.size()];
        for (int i = 0; i < rareArray.size(); i++) {
            array[i] = ((Integer) rareArray.get(i)).intValue();
        }
        return getIndexByRare(array);
    }


    public static int getIndexByRare(int[] rareArray) {
        if (rareArray == null || rareArray.length == 0) {
            return 0;
        }
        int result = 0;
        int rares = 0;
        for (int rare : rareArray) {
            rares += rare;
        }
        int ranRare = random(0, rares);
        int maxRare = 0;
        for (int i = 0; i < rareArray.length; i++) {
            int rare = rareArray[i];
            maxRare += rare;
            if (ranRare <= maxRare) {
                result = i;
                break;
            }
        }
        return result;
    }


    public static int random(int min, int max) {
        return RandomUtil.getInt(min, max);
    }

    public static final Map<String, Integer> splitItems(String itemStr, String separator1, String separator2) {
        Map<String, Integer> ret = new TreeMap<>();
        itemStr = itemStr.trim();
        if (itemStr != null && itemStr.length() > 0) {
            String[] items = itemStr.trim().split(separator1);
            for (String item : items) {
                String[] tmp = item.split(separator2);
                if (tmp.length > 1) {
                    ret.put(tmp[0], Integer.valueOf(Integer.parseInt(tmp[1])));
                } else {
                    ret.put(tmp[0], Integer.valueOf(1));
                }
            }
        }
        return ret;
    }

    public static final List<Map<String, Object>> splitItems2(String itemStr, String separator1, String separator2) {
        List<Map<String, Object>> ret = new ArrayList<>();
        itemStr = itemStr.trim();
        if (itemStr != null && itemStr.length() > 0) {
            String[] items = itemStr.trim().split(separator1);
            for (String item : items) {
                String[] tmp = item.split(separator2);

                Map<String, Object> map = new HashMap<>();
                map.put("itemCode", tmp[0]);
                map.put("itemNum", Integer.valueOf((tmp.length > 1) ? Integer.parseInt(tmp[1]) : 1));
                map.put("forceType", (tmp.length > 2) ? Const.ForceType.getE(Integer.parseInt(tmp[1])) : Const.ForceType.DEFAULT);
                ret.add(map);
            }
        }
        return ret;
    }

    public static final int[] listToArray(List<Integer> list) {
        int[] ret = new int[list.size()];
        for (int i = list.size() - 1; i >= 0; i--) {
            ret[i] = ((Integer) list.get(i)).intValue();
        }
        return ret;
    }


    public static Date getZeroDate() {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(11, 0);
        c.set(12, 0);
        c.set(13, 0);
        c.set(14, 0);

        return c.getTime();
    }


    public static <T> T clone(T t) {
        T newObj = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(t);


            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            newObj = (T) ois.readObject();
        } catch (Exception e) {
            Out.error(new Object[]{e});
        }
        return newObj;
    }


    public static void deepCopyAffix(Map<String, Integer> data, Map<Integer, Integer> source, int qcolor) {
        if (source == null) {
            return;
        }
        for (Map.Entry<Integer, Integer> entry : source.entrySet()) {
            AffixExt affix = (AffixExt) GameData.Affixs.get(entry.getKey());
            if (affix == null) {
                Out.warn(new Object[]{"key=" + entry.getKey() + " val=" + entry.getValue()});
                continue;
            }
            FourProp pair = (FourProp) affix.props.get(Integer.valueOf(qcolor));
            if (pair == null) {
                continue;
            }
            if (data.get(pair.prop) != null && ((Integer) data.get(pair.prop)).intValue() > 0) {
                data.put(pair.prop, Integer.valueOf(((Integer) data.get(pair.prop)).intValue() + ((Integer) entry.getValue()).intValue()));
                continue;
            }
            data.put(pair.prop, entry.getValue());
        }
    }


    public static void deepCopyAffix(Map<String, Integer> data, RepeatKeyMap<Integer, Integer> source, int qcolor) {
        if (source == null) {
            return;
        }
        for (RepeatKeyMap.Pair<Integer, Integer> entry : (Iterable<RepeatKeyMap.Pair<Integer, Integer>>) source.entrySet()) {
            AffixExt affix = (AffixExt) GameData.Affixs.get(entry.k);
            if (affix == null) {
                Out.warn(new Object[]{"key=" + entry.k + " val=" + entry.v});
                continue;
            }
            FourProp pair = (FourProp) affix.props.get(Integer.valueOf(qcolor));
            if (pair == null) {
                continue;
            }
            if (data.get(pair.prop) != null && ((Integer) data.get(pair.prop)).intValue() > 0) {
                data.put(pair.prop, Integer.valueOf(((Integer) data.get(pair.prop)).intValue() + ((Integer) entry.v).intValue()));
                continue;
            }
            data.put(pair.prop, entry.v);
        }
    }


    public static void deepCopy(Map<String, Integer> data, Map<String, Integer> source) {
        if (source == null) {
            return;
        }
        for (Map.Entry<String, Integer> entry : source.entrySet()) {
            if (data.get(entry.getKey()) != null && ((Integer) data.get(entry.getKey())).intValue() > 0) {
                data.put(entry.getKey(), Integer.valueOf(((Integer) data.get(entry.getKey())).intValue() + ((Integer) entry.getValue()).intValue()));
                continue;
            }
            data.put(entry.getKey(), entry.getValue());
        }
    }


    public static void deepCopy(Map<String, Integer> data, List<AttsObj> source) {
        for (AttsObj entry : source) {
            if (data.get(entry.key) != null && ((Integer) data.get(entry.key)).intValue() > 0) {
                data.put(entry.key, Integer.valueOf(((Integer) data.get(entry.key)).intValue() + entry.value));
                continue;
            }
            data.put(entry.key, Integer.valueOf(entry.value));
        }
    }


    public static void deepCopy(Map<String, Integer> data, AttsObj source) {
        if (source == null) {
            return;
        }
        if (data.get(source.key) != null && ((Integer) data.get(source.key)).intValue() > 0) {
            data.put(source.key, Integer.valueOf(((Integer) data.get(source.key)).intValue() + source.value));
        } else {
            data.put(source.key, Integer.valueOf(source.value));
        }
    }

    public static Date getTodayTimeFromString(String stringTime, String separator) {
        String separatorStr = ":";
        if (separator != null) {
            separatorStr = separator;
        }
        String[] numbers = stringTime.split(separatorStr);
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        if (numbers.length == 3) {
            c.set(11, Integer.parseInt(numbers[0]));
            c.set(12, Integer.parseInt(numbers[1]));
            c.set(13, Integer.parseInt(numbers[2]));
        }
        return c.getTime();
    }


    public static <K, V> Map<K, V> ofMap(Object... params) {
        LinkedHashMap<K, V> result = new LinkedHashMap<>();


        if (params == null || params.length == 0) {
            return result;
        }


        int len = params.length;
        for (int i = 0; i < len; i += 2) {
            K key = (K) params[i];
            V val = (V) params[i + 1];

            result.put(key, val);
        }

        return result;
    }

    public static String toJSONString(Object... params) {
        JSONObject json = toJSON(params);
        return json.toJSONString();
    }

    public static JSONObject toJSON(Object... params) {
        JSONObject json = new JSONObject(params.length / 2);

        if (params != null) {
            for (int i = 0, len = params.length; i < len; i += 2) {
                json.put(params[i].toString(), params[i + 1]);
            }
        }
        return json;
    }

    public static String serialize(Object obj) {
        return JSON.toJSONString(obj, mapping, new com.alibaba.fastjson.serializer.SerializerFeature[0]);
    }

    public static <T> T deserialize(String buf, Class<T> clazz) {
        return (T) JSON.parseObject(buf, clazz);
    }


    public static byte[] longToByte(long number) {
        long temp = number;
        byte[] b = new byte[8];
        for (int i = 0; i < b.length; i++) {
            b[i] = (new Long(temp & 0xFFL)).byteValue();
            temp >>= 8L;
        }
        return b;
    }


    public static long byteToLong(byte[] b) {
        long s = 0L;
        long s0 = (b[0] & 0xFF);
        long s1 = (b[1] & 0xFF);
        long s2 = (b[2] & 0xFF);
        long s3 = (b[3] & 0xFF);
        long s4 = (b[4] & 0xFF);
        long s5 = (b[5] & 0xFF);
        long s6 = (b[6] & 0xFF);
        long s7 = (b[7] & 0xFF);


        s1 <<= 8L;
        s2 <<= 16L;
        s3 <<= 24L;
        s4 <<= 32L;
        s5 <<= 40L;
        s6 <<= 48L;
        s7 <<= 56L;
        s = s0 | s1 | s2 | s3 | s4 | s5 | s6 | s7;
        return s;
    }

    public static int getStackLineNumber() {
        return Thread.currentThread().getStackTrace()[0].getLineNumber();
    }

    public static int getSecMills(int min, int max) {
        return RandomUtil.getInt(min, max) * 1000;
    }
}


