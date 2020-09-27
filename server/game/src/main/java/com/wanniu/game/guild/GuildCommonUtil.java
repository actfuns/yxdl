package com.wanniu.game.guild;

import com.wanniu.core.db.GCache;
import com.wanniu.core.game.LangService;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.Utils;
import com.wanniu.game.data.GDungeonMapCO;
import com.wanniu.game.data.GDungeonRankCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.GuildSettingExt;
import com.wanniu.game.guild.guidDepot.GuildCond;
import com.wanniu.game.guild.guidDepot.GuildDepotCondition;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import pomelo.area.GuildDepotHandler;
import pomelo.area.GuildHandler;
import pomelo.guild.GuildManagerHandler;
import redis.clients.jedis.Jedis;


public class GuildCommonUtil {
    public static List<Integer> toList(int[] arr) {
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ls.add(Integer.valueOf(arr[i]));
        }
        return ls;
    }

    public static void sendMailSystenType(String playerId, String key, Map<String, String> map) {
        MailSysData mailData = new MailSysData(key);
        mailData.replace = map;
        MailUtil.getInstance().sendMailToOnePlayer(playerId, (MailData) mailData, Const.GOODS_CHANGE_TYPE.guild_mail);
    }

    public static List<GDungeonMapCO> findAndSortDungeonMap() {
        List<GDungeonMapCO> props = GameData.findGDungeonMaps(t -> (t.type == Const.SCENE_TYPE.GUILD_DUNGEON.getValue()));


        props.sort(new Comparator<GDungeonMapCO>() {
            public int compare(GDungeonMapCO o1, GDungeonMapCO o2) {
                return o1.layer - o2.layer;
            }
        });
        return props;
    }

    public static GDungeonRankCO findGDungeonRanks(int rankType, int rank) {
        List<GDungeonRankCO> rankPropList = GameData.findGDungeonRanks(t ->
                (t.rankType == rankType && t.openTime == rank));


        GDungeonRankCO rankProp = null;
        if (null != rankPropList && rankPropList.size() > 0) {
            rankProp = rankPropList.get(0);
        }
        return rankProp;
    }

    public static String getJoinGuildErrorMsg(GuildResult resData) {
        int result = resData.result;
        GuildResult.JoinGuild data = (GuildResult.JoinGuild) resData.data;
        GuildSettingExt prop = GuildUtil.getGuildSettingExtProp();
        if (result == 0)
            return "";
        if (result == -1)
            return LangService.getValue("SOMETHING_ERR");
        if (result == -2)
            return LangService.getValue("GUILD_CREATE_ERROR");
        if (result == -3)
            return LangService.getValue("GUILD_NOT_EXIST");
        if (result == -4) {
            if (null == data)
                return "";
            String upLevelName = GuildUtil.getUpLevelName(data.needUpLevel);
            return LangService.getValue("GUILD_JOIN_UP_LEVEL").replace("{roleUpLevel}", upLevelName);
        }
        if (result == -5)
            return LangService.getValue("GUILD_JOIN_LEVEL").replace("{roleLevel}", String.valueOf(resData.needLevel));
        if (result == -6) {
            if (null == data)
                return "";
            return LangService.getValue("GUILD_SELF_OUT_CD").replace("{time}", data.cdInfo);
        }
        if (result == -7)
            return LangService.getValue("GUILD_NOT_EXIST");
        if (result == -20)
            return LangService.getValue("GUILD_HE_IS_NOT_IN_GUILD");
        if (result == 1)
            return LangService.getValue("GUILD_JOIN_FULL").replace("{applyMax}", String.valueOf(prop.applyMax));
        if (result == 2)
            return LangService.getValue("GUILD_NOT_EXIST");
        if (result == 3)
            return LangService.getValue("GUILD_FULL");
        if (result == 4) {
            return LangService.getValue("GUILD_HAVE_APPLY");
        }
        return LangService.getValue("SOMETHING_ERR");
    }

    public static List<String> smembers(String id) {
        Jedis redis = GCache.getRedis();
        try {
            return new ArrayList(redis.smembers(id));
        } finally {
            GCache.release(redis);
        }
    }

    public static Date newDateByStr(String timeStr) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long time = Long.parseLong(timeStr);
        String d = format.format(Long.valueOf(time));
        Date date = format.parse(d);
        return date;
    }

    public static GuildManagerHandler.QualityCond.Builder toManagerQuality(int level, int upLevel, int qColor) {
        GuildManagerHandler.QualityCond.Builder cond = GuildManagerHandler.QualityCond.newBuilder();
        cond.setLevel(level);
        cond.setUpLevel(upLevel);
        cond.setQColor(qColor);
        return cond;
    }


    public static GuildManagerHandler.DepotCondition toManagerCond(GuildDepotCondition cond) {
        if (null == cond) {
            return null;
        }

        GuildManagerHandler.UseCond.Builder useCond = GuildManagerHandler.UseCond.newBuilder();
        useCond.setLevel(cond.useCond.level);
        useCond.setUpLevel(cond.useCond.upLevel);
        useCond.setJob(cond.useCond.job);

        GuildManagerHandler.QualityCond.Builder minCond = toManagerQuality(cond.minCond.level, cond.minCond.upLevel, cond.minCond.qColor);
        GuildManagerHandler.QualityCond.Builder maxCond = toManagerQuality(cond.maxCond.level, cond.maxCond.upLevel, cond.maxCond.qColor);

        GuildManagerHandler.DepotCondition.Builder condition = GuildManagerHandler.DepotCondition.newBuilder();
        condition.setUseCond(useCond);
        condition.setMinCond(minCond);
        condition.setMaxCond(maxCond);
        return condition.build();
    }


    public static GuildDepotHandler.DepotCondition toHandlerDepot(GuildDepotCondition cond) {
        GuildDepotHandler.UseCond.Builder useCond = GuildDepotHandler.UseCond.newBuilder();
        useCond.setLevel(cond.useCond.level);
        useCond.setUpLevel(cond.useCond.upLevel);
        useCond.setJob(cond.useCond.job);

        GuildDepotHandler.QualityCond.Builder minCond = GuildDepotHandler.QualityCond.newBuilder();
        minCond.setLevel(cond.minCond.level);
        minCond.setUpLevel(cond.minCond.upLevel);
        minCond.setQColor(cond.minCond.qColor);

        GuildDepotHandler.QualityCond.Builder maxCond = GuildDepotHandler.QualityCond.newBuilder();
        maxCond.setLevel(cond.maxCond.level);
        maxCond.setUpLevel(cond.maxCond.upLevel);
        maxCond.setQColor(cond.maxCond.qColor);

        GuildDepotHandler.DepotCondition.Builder condition = GuildDepotHandler.DepotCondition.newBuilder();
        condition.setUseCond(useCond);
        condition.setMinCond(minCond);
        condition.setMaxCond(maxCond);
        return condition.build();
    }


    public static GuildCond useCond2GuildCond(GuildManagerHandler.UseCond useCond) {
        GuildCond newCond = new GuildCond();
        newCond.level = useCond.getLevel();
        newCond.upLevel = useCond.getUpLevel();
        newCond.job = useCond.getJob();
        return newCond;
    }

    public static GuildCond quality2GuildCond(GuildManagerHandler.QualityCond useCond) {
        GuildCond newCond = new GuildCond();
        newCond.level = useCond.getLevel();
        newCond.upLevel = useCond.getUpLevel();
        newCond.qColor = useCond.getQColor();
        return newCond;
    }

    public static GuildManagerHandler.UseCond newUseCond(int level, int upLevel, int job) {
        GuildManagerHandler.UseCond.Builder useCond = GuildManagerHandler.UseCond.newBuilder();
        useCond.setLevel(level);
        useCond.setUpLevel(upLevel);
        useCond.setJob(job);
        return useCond.build();
    }

    public static GuildManagerHandler.QualityCond newQualityCond(int level, int upLevel, int color) {
        GuildManagerHandler.QualityCond.Builder qualityCond = GuildManagerHandler.QualityCond.newBuilder();
        qualityCond.setLevel(level);
        qualityCond.setUpLevel(upLevel);
        qualityCond.setQColor(color);
        return qualityCond.build();
    }

    public static GuildDepotHandler.DepotCondition convertCond(GuildManagerHandler.DepotCondition retCond) {
        GuildDepotHandler.UseCond.Builder useCond = GuildDepotHandler.UseCond.newBuilder();
        useCond.setLevel(retCond.toBuilder().getUseCond().getLevel());
        useCond.setUpLevel(retCond.toBuilder().getUseCond().getUpLevel());
        useCond.setJob(retCond.toBuilder().getUseCond().getJob());

        GuildDepotHandler.QualityCond.Builder minCond = GuildDepotHandler.QualityCond.newBuilder();
        minCond.setLevel(retCond.toBuilder().getMinCond().getLevel());
        minCond.setUpLevel(retCond.toBuilder().getMinCond().getUpLevel());
        minCond.setQColor(retCond.toBuilder().getMinCond().getQColor());

        GuildDepotHandler.QualityCond.Builder maxCond = GuildDepotHandler.QualityCond.newBuilder();
        maxCond.setLevel(retCond.toBuilder().getMaxCond().getLevel());
        maxCond.setUpLevel(retCond.toBuilder().getMaxCond().getUpLevel());
        maxCond.setQColor(retCond.toBuilder().getMaxCond().getQColor());

        GuildDepotHandler.DepotCondition.Builder condition = GuildDepotHandler.DepotCondition.newBuilder();
        condition.setUseCond(useCond);
        condition.setMinCond(minCond);
        condition.setMaxCond(maxCond);
        return condition.build();
    }

    public static GuildManagerHandler.RoleInfo.Builder toMgrRoleInfo(int pro, String name) {
        GuildManagerHandler.RoleInfo.Builder roleInfo = GuildManagerHandler.RoleInfo.newBuilder();
        roleInfo.setPro(pro);
        roleInfo.setName(name);
        return roleInfo;
    }

    public static GuildManagerHandler.ItemRecordInfo.Builder toMgrItemRecordInfo(int qColor, String name) {
        GuildManagerHandler.ItemRecordInfo.Builder tmp = GuildManagerHandler.ItemRecordInfo.newBuilder();
        tmp.setQColor(qColor);
        tmp.setName(name);
        return tmp;
    }

    public static GuildHandler.RoleInfo convertRoleInfo(RoleInfo roleInfo) {
        GuildHandler.RoleInfo.Builder role = GuildHandler.RoleInfo.newBuilder();
        role.setPro(roleInfo.pro);
        if (StringUtil.isNotEmpty(roleInfo.name)) {
            role.setName(roleInfo.name);
        }
        return role.build();
    }


    public static GuildManagerHandler.RoleInfo toGuildMgrHandler(RoleInfo roleInfo) {
        if (null != roleInfo) {
            GuildManagerHandler.RoleInfo.Builder role = GuildManagerHandler.RoleInfo.newBuilder();
            role.setPro(roleInfo.pro);
            role.setName(roleInfo.name);
            return role.build();
        }
        return null;
    }


    public static <T> void hset(ConstsTR key, String field, T po) {
        GCache.hset(key.value, field, Utils.serialize(po));
    }


    public static <T> ArrayList<T> hgetAll(ConstsTR key, Class<T> clazz) {
        try {
            Map<String, String> dataMap = GCache.hgetAll(key.value);
            ArrayList<T> list = new ArrayList<>();
            for (String data : dataMap.values()) {
                T po = (T) Utils.deserialize(data, clazz);
                list.add(po);
            }
            return list;
        } catch (Exception e) {
            Out.error(new Object[]{e});
            return null;
        }
    }


    public static <T> T hget(ConstsTR key, String field, Class<T> clazz) {
        try {
            String data = GCache.hget(key.value, field);
            if (StringUtil.isNotEmpty(data)) {
                return (T) Utils.deserialize(data, clazz);
            }
            return null;
        } catch (Exception e) {
            Out.error(new Object[]{e});
            return null;
        }
    }


    public static String leftTimeTips(long needMs) {
        int leftHour = (int) Math.floor((needMs / Const.Time.Hour.getValue()));
        int leftMinute = (int) Math.ceil((needMs % Const.Time.Hour.getValue() / Const.Time.Minute.getValue()));
        int leftSec = (int) Math.ceil((needMs % Const.Time.Hour.getValue() % Const.Time.Minute.getValue() / Const.Time.Second.getValue()));
        String cdInfo = "";
        if (leftHour > 0) {
            cdInfo = cdInfo + leftHour + LangService.getValue("GUILD_HOUR");
            cdInfo = cdInfo + leftMinute + LangService.getValue("GUILD_MIN");
        } else if (leftHour <= 0 && leftMinute > 0) {
            cdInfo = cdInfo + leftMinute + LangService.getValue("GUILD_MIN");
        } else if (leftMinute == 0) {
            cdInfo = cdInfo + leftSec + LangService.getValue("GUILD_SEC");
        }
        return cdInfo;
    }
}


