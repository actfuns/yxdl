package com.wanniu.game.player;

import cn.qeng.common.login.TokenInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.GConfig;
import com.wanniu.core.GGame;
import com.wanniu.core.GGlobal;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.game.PoolFactory;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.http.HttpRequester;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.data.base.DItemBase;
import com.wanniu.game.downjoy.HttpClientUtil;
import com.wanniu.game.downjoy.MD5;
import com.wanniu.game.item.ItemConfig;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.redis.GlobalDao;
import io.netty.channel.Channel;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import org.apache.commons.lang3.StringUtils;


public class BILogService {
    private String downjoyReportUrl = GConfig.getInstance().get("downjoy.report.url");
    private int downjoyAppId = GConfig.getInstance().getInt("downjoy.report.appId", 0);
    private String downjoyAppKey = GConfig.getInstance().get("downjoy.report.appKey");


    private int aliAppId = GConfig.getInstance().getInt("ali.report.appId", 0);
    private String aliAppKey = GConfig.getInstance().get("ali.report.appKey");
    private String aliReportUrl = GConfig.getInstance().get("ali.report.url");

    private static BILogService instance;

    private final ExecutorService ansycReportExec;

    public static BILogService getInstance() {
        if (instance == null) {
            synchronized (BILogService.class) {
                if (instance == null) {
                    instance = new BILogService();
                }
            }
        }
        return instance;
    }

    private static Map<String, Map<Const.BiLogType, List<BILogItem>>> items = new ConcurrentHashMap<>();

    private BILogService() {
        this.ansycReportExec = Executors.newSingleThreadExecutor((ThreadFactory) new PoolFactory("ansyc-report"));

        JobFactory.addFixedRateJob(() -> {
            for (Map<Const.BiLogType, List<BILogItem>> pitems : items.values()) {
                for (Const.BiLogType logType : pitems.keySet()) {
                    List<BILogItem> list = pitems.get(logType);
                    if (list == null) continue;
                    for (BILogItem item : list) {
                        long now = GWorld.APP_TIME;
                        switch (logType) {
                            case Gold_Total:
                            case Cash_Total:
                            case Diamond_Total:
                            case Exp_Total:
                                if (item.time + Const.Time.Minute.getValue() < now) list.remove(item);
                                continue;
                            case Consignment_Total:
                                if (item.time + Const.Time.Day.getValue() < now) list.remove(item);
                                continue;
                            case Gift_Total:
                                if (item.time + Const.Time.Hour.getValue() < now) list.remove(item);
                                continue;
                        }
                        list.remove(item);
                    }
                }
            }
            if (items.size() > 10000) {
                Out.warn(new Object[]{"BILogService size: ", Integer.valueOf(items.size())}, );
                if (items.size() > 20000) items.clear();
            }
        } 0L, 10000L);
    }


    public void recordNum(WNPlayer player, Const.BiLogType logType, long num, Const.GOODS_CHANGE_TYPE from) {
        if (player.isRobot())
            return;
        GWorld.getInstance().ansycExec(() -> {
            List<BILogItem> list = null;
            if (logType == Const.BiLogType.Gold || logType == Const.BiLogType.Cash || logType == Const.BiLogType.Diamond || logType == Const.BiLogType.Exp || logType == Const.BiLogType.FightPower || logType == Const.BiLogType.Consignment || logType == Const.BiLogType.Gift) {
                Map<Const.BiLogType, List<BILogItem>> pitem = items.get(player.getId());
                if (pitem == null) {
                    pitem = new ConcurrentHashMap<>();
                    items.put(player.getId(), pitem);
                }
                list = pitem.get(logType);
                if (list == null) {
                    list = new CopyOnWriteArrayList<>();
                    pitem.put(logType, list);
                }
                list.add(new BILogItem(GWorld.APP_TIME, Math.abs(num)));
            }
            long total = 0L;
            if (list != null && list.size() > 0) {
                for (BILogItem item : list) {
                    total += item.num;
                }
            }
            switch (logType) {
                case Gold:
                    if (Math.abs(num) > 2000000L) {
                        PlayerUtil.bi(getClass(), Const.BiLogType.Gold, player, new Object[]{Long.valueOf(num), from});
                    }
                    if (total > 10000000L) {
                        PlayerUtil.bi(getClass(), Const.BiLogType.Gold_Total, player, new Object[]{Long.valueOf(total)});
                    }
                    break;
                case Cash:
                    if (Math.abs(num) > 5000L) {
                        PlayerUtil.bi(getClass(), Const.BiLogType.Cash, player, new Object[]{Long.valueOf(num), from});
                    }
                    if (total > 10000L) {
                        PlayerUtil.bi(getClass(), Const.BiLogType.Cash_Total, player, new Object[]{Long.valueOf(total)});
                    }
                    break;
                case Diamond:
                    PlayerUtil.bi(getClass(), Const.BiLogType.Diamond, player, new Object[]{Long.valueOf(num), from});
                    PlayerUtil.bi(getClass(), Const.BiLogType.Diamond_Total, player, new Object[]{Long.valueOf(total)});
                    break;
                case Exp:
                    if (Math.abs(num) > 500000L) {
                        PlayerUtil.bi(getClass(), Const.BiLogType.Exp, player, new Object[]{Long.valueOf(num), from});
                    }
                    if (total > 2000000L) {
                        PlayerUtil.bi(getClass(), Const.BiLogType.Exp_Total, player, new Object[]{Long.valueOf(total)});
                    }
                    break;
                case FightPower:
                    if (num > 5000L) {
                        PlayerUtil.bi(getClass(), Const.BiLogType.FightPower, player, new Object[]{Long.valueOf(num), from});
                    }
                    if (total > 30000L) {
                        PlayerUtil.bi(getClass(), Const.BiLogType.FightPower_Total, player, new Object[]{Long.valueOf(total)});
                    }
                    break;
                case Consignment:
                    if (Math.abs(num) > 3000L) {
                        PlayerUtil.bi(getClass(), Const.BiLogType.Consignment, player, new Object[]{Long.valueOf(num), from});
                    }
                    if (list.size() > 50) {
                        PlayerUtil.bi(getClass(), Const.BiLogType.Consignment_Total, player, new Object[]{Integer.valueOf(list.size())});
                    }
                    break;
                case Gift:
                    if (list.size() > 10) {
                        PlayerUtil.bi(getClass(), Const.BiLogType.Gift_Total, player, new Object[]{Integer.valueOf(list.size())});
                    }
                    break;
            }
        });
    }


    private static class BILogItem {
        public long time;


        public long num;


        public BILogItem(long time, long num) {
            this.time = time;
            this.num = num;
        }
    }


    public void ansycReportOnline(int onlineCount) {
        String reportUrl = GConfig.getInstance().get("server.bi.reportUrl");
        if (StringUtils.isNotEmpty(reportUrl)) {
            Map<String, Integer> ps = new HashMap<>();
            ps.put("type", Integer.valueOf(0));
            ps.put("area_id", Integer.valueOf(GWorld.__AREA_ID));
            ps.put("server_id", Integer.valueOf(GGame.__SERVER_ID));
            ps.put("count", Integer.valueOf(onlineCount));

            Map<String, String> params = new HashMap<>();
            params.put("name", "Online");
            params.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
            params.put("data", JSON.toJSONString(ps));

            this.ansycReportExec.execute(() -> {
                try {
                    Out.info(new Object[]{"online report result:", (new HttpRequester()).sendPost(reportUrl, params).getContent()});
                } catch (IOException e) {
                    Out.warn(new Object[]{"online report exception", JSON.toJSONString(params), e});
                }
            });
        }
    }


    public void ansycReportRegister(Channel channel, String uid, String ip) {
        String reportUrl = GConfig.getInstance().get("server.bi.reportUrl");
        if (StringUtils.isNotEmpty(reportUrl) && !GlobalDao.hexists(ConstsTR.FIRST_LOGIN.value, uid)) {
            GlobalDao.hset(ConstsTR.FIRST_LOGIN.value, uid, "1");

            Map<String, Object> ps = new HashMap<>();
            ps.put("kingdom", Integer.valueOf(1));
            ps.put("userid", uid);

            Map<String, String> params = new HashMap<>();
            params.put("name", "Register");
            params.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
            params.put("data", JSON.toJSONString(ps));

            TokenInfo tokenInfo = (TokenInfo) channel.attr(GGlobal.__KEY_TOKEN_INFO).get();
            this.ansycReportExec.execute(() -> {
                try {
                    if (tokenInfo != null) {
                        params.put("source", tokenInfo.getSubchannel());
                        params.put("device_id", tokenInfo.getMac());
                        params.put("platform", String.valueOf(osToPlatform(tokenInfo.getOs())));
                        params.put("ip", ip);
                    }
                    Out.info(new Object[]{"register report result:", (new HttpRequester()).sendPost(reportUrl, params).getContent()});
                } catch (IOException e) {
                    Out.warn(new Object[]{"register report exception", JSON.toJSONString(params), e});
                    GlobalDao.hremove(ConstsTR.FIRST_LOGIN.value, uid);
                }
            });
        }
    }


    public void ansycReportLogout(WNPlayer player) {
        String reportUrl = GConfig.getInstance().get("server.bi.reportUrl");
        if (StringUtils.isNotEmpty(reportUrl)) {
            Map<String, Object> ps = new HashMap<>();
            ps.put("kingdom", Integer.valueOf(1));
            ps.put("userid", player.getUid());
            ps.put("clientid", Integer.valueOf(GGame.__SERVER_ID));
            ps.put("roleid", player.getId());


            Map<String, Object> extra = new HashMap<>();
            extra.put("区服", Integer.valueOf(GGame.__SERVER_ID));
            extra.put("角色名", (player.getPlayer()).name);
            extra.put("角色职业", Integer.valueOf((player.getPlayer()).pro));
            extra.put("角色等级", Integer.valueOf((player.getPlayer()).level));
            extra.put("角色突破等级", Integer.valueOf((player.getPlayer()).upLevel));
            extra.put("角色VIP等级", Integer.valueOf(player.baseDataManager.getVip()));
            extra.put("角色战斗力", Integer.valueOf((player.getPlayer()).fightPower));
            extra.put("元宝存量", Integer.valueOf((player.getPlayer()).diamond));
            extra.put("绑元存量", Integer.valueOf((player.getPlayer()).ticket));
            extra.put("银两存量", Integer.valueOf((player.getPlayer()).gold));
            ps.put("extra", extra);

            Map<String, String> params = new HashMap<>();
            params.put("name", "Logout");
            params.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
            params.put("data", JSON.toJSONString(ps));
            params.put("source", String.valueOf((player.getPlayer()).subchannel));
            params.put("device_id", (player.getPlayer()).mac);
            params.put("platform", String.valueOf(osToPlatform((player.getPlayer()).os)));
            params.put("ip", (player.getPlayer()).ip);

            this.ansycReportExec.execute(() -> {
                try {
                    Out.info(new Object[]{"logout report result:", (new HttpRequester()).sendPost(reportUrl, params).getContent()});
                } catch (IOException e) {
                    Out.warn(new Object[]{"logout report exception", JSON.toJSONString(params), e});
                }
            });
        }
    }

    public void ansycReportRechargeSuccess(PlayerPO player, int chargeDiamond, int payMoneyAmount, String classfield) {
        String reportUrl = GConfig.getInstance().get("server.bi.reportUrl");
        if (StringUtils.isNotEmpty(reportUrl)) {
            Map<String, Object> ps = new HashMap<>();
            ps.put("type", Integer.valueOf(1));
            ps.put("userid", player.uid);
            ps.put("clientid", Integer.valueOf(GGame.__SERVER_ID));
            ps.put("user_level", Integer.valueOf(player.level));
            ps.put("kingdom", Integer.valueOf(chargeDiamond));
            ps.put("phylum", Integer.valueOf(payMoneyAmount));
            ps.put("roleid", player.id);
            ps.put("classfield", classfield);

            Map<String, Object> extra = new HashMap<>();
            extra.put("区服", Integer.valueOf(GGame.__SERVER_ID));
            extra.put("角色名", player.name);
            extra.put("角色职业", Integer.valueOf(player.pro));
            extra.put("角色等级", Integer.valueOf(player.level));
            extra.put("角色突破等级", Integer.valueOf(player.upLevel));
            extra.put("角色战斗力", Integer.valueOf(player.fightPower));
            extra.put("元宝存量", Integer.valueOf(player.diamond));
            extra.put("绑元存量", Integer.valueOf(player.ticket));
            extra.put("银两存量", Integer.valueOf(player.gold));

            ps.put("extra", extra);
            Map<String, String> params = new HashMap<>();
            params.put("name", "RechargeSuccess");
            params.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
            params.put("data", JSON.toJSONString(ps));
            params.put("source", String.valueOf(player.subchannel));
            params.put("device_id", player.mac);
            params.put("platform", String.valueOf(osToPlatform(player.os)));
            params.put("ip", player.ip);

            this.ansycReportExec.execute(() -> {
                try {
                    Out.info(new Object[]{"RechargeSuccess report result:", (new HttpRequester()).sendPost(reportUrl, params).getContent()});
                } catch (IOException e) {
                    Out.warn(new Object[]{"RechargeSuccess report exception", JSON.toJSONString(params), e});
                }
            });
        }
    }


    public int osToPlatform(String os) {
        if ("6".equals(os))
            return 2;
        if ("5".equals(os)) {
            return 1;
        }
        return 0;
    }


    public void ansycReportPlayerData(Channel session, PlayerPO player, boolean upgrade) {
        try {
            if (session == null || player == null) {
                Out.warn(new Object[]{"异步上报玩家数据时，Session为空"});

                return;
            }
            TokenInfo tokenInfo = (TokenInfo) session.attr(GGlobal.__KEY_TOKEN_INFO).get();
            if (tokenInfo != null && StringUtils.isNotEmpty(tokenInfo.getSubchannel())) {
                String subchannel = tokenInfo.getSubchannel();
                switch (subchannel) {
                    case "P_ALI":
                        ansycReportPlayerDataBy1001P_Ali(tokenInfo, player, upgrade);
                        break;
                    case "1003":
                        if (upgrade) {
                            ansycReportPlayerDataBy1003(tokenInfo, player);
                        }
                        break;
                }


            }
        } catch (Exception e) {
            Out.error(new Object[]{"异步上报玩家数据时发生异常啦.", e});
        }
    }


    private void ansycReportPlayerDataBy1001P_Ali(TokenInfo tokenInfo, PlayerPO player, boolean upgrade) throws UnsupportedEncodingException {
        long timeStamp = System.currentTimeMillis() / 1000L;

        JSONObject object = new JSONObject();
        object.put("id", Long.valueOf(timeStamp));
        object.put("service", "ucid.game.gameData");

        JSONObject data = new JSONObject();

        JSONObject gameData = new JSONObject();
        gameData.put("category", "loginGameRole");


        JSONObject content = new JSONObject();
        content.put("zoneId", Integer.valueOf(GWorld.__SERVER_ID));
        content.put("zoneName", GWorld.__SERVER_NAME);
        content.put("roleId", player.id);
        content.put("roleName", player.name);
        content.put("roleCTime", Long.valueOf(player.createTime.getTime() / 1000L));
        content.put("roleLevel", String.valueOf(player.level));
        content.put("os", "6".equals(player.os) ? "android" : "ios");
        if (upgrade) {
            content.put("roleLevelMTime", Long.valueOf(timeStamp));
        }
        gameData.put("content", content);


        data.put("accountId", player.subchannelUID);
        data.put("gameData", URLEncoder.encode(gameData.toJSONString(), "UTF-8"));


        object.put("sign", sign((Map<String, Object>) data, this.aliAppKey));
        object.put("data", data);


        JSONObject game = new JSONObject();
        game.put("gameId", Integer.valueOf(this.aliAppId));
        object.put("game", game);


        String postData = object.toJSONString();
        this.ansycReportExec.execute(() -> {
            try {
                String result = HttpClientUtil.doPost(this.aliReportUrl, postData, "application/json");
                Out.info(new Object[]{"AliReport result:", result});
            } catch (Exception e) {
                Out.warn(new Object[]{"AliReport report exception", e});
            }
        });
    }


    public static String sign(Map<String, Object> reqMap, String signKey) {
        TreeMap<String, Object> signMap = new TreeMap<>(reqMap);
        StringBuilder stringBuilder = new StringBuilder(1024);
        for (Map.Entry<String, Object> entry : signMap.entrySet()) {

            if ("sign".equals(entry.getKey()) || "signType".equals(entry.getKey())) {
                continue;
            }

            if (entry.getValue() != null) {
                stringBuilder.append(entry.getKey()).append("=").append(entry.getValue());
            }
        }

        stringBuilder.append(signKey);

        String signSrc = stringBuilder.toString().replaceAll("&", "");
        return MD5.encrypt(signSrc).toLowerCase();
    }


    private void ansycReportPlayerDataBy1003(TokenInfo tokenInfo, PlayerPO player) {
        if (StringUtils.isNotEmpty(this.downjoyReportUrl)) {
            long timeStamp = System.currentTimeMillis();
            this.ansycReportExec.execute(() -> {
                try {
                    Long appId = Long.valueOf(this.downjoyAppId);

                    String umid = tokenInfo.getSubchannelUid();

                    String token = tokenInfo.getAccessToken();
                    String zoneId = String.valueOf(GWorld.__SERVER_ID);
                    String zoneName = GWorld.__SERVER_NAME;
                    String roleId = player.id;
                    String roleName = player.name;
                    Date roleCreateTime = player.createTime;
                    String roleLevel = String.valueOf(player.level);
                    Date roleLevelModifyTime = new Date(timeStamp);
                    JSONObject object = new JSONObject();
                    object.put("appId", appId);
                    object.put("timestamp", Long.valueOf(timeStamp));
                    JSONObject data = new JSONObject();
                    data.put("umid", umid);
                    data.put("zoneId", zoneId);
                    data.put("zoneName", zoneName);
                    data.put("roleId", roleId);
                    data.put("roleName", roleName);
                    data.put("roleCTime", Long.valueOf(roleCreateTime.getTime() / 1000L));
                    data.put("roleLevel", roleLevel);
                    data.put("roleLevelMTime", Long.valueOf(roleLevelModifyTime.getTime() / 1000L));
                    String encodeData = URLEncoder.encode(data.toJSONString(), "UTF-8");
                    object.put("data", encodeData);
                    String signParam = (new StringBuilder(512)).append("appId=").append(appId).append("&data=").append(encodeData).append("&timestamp=").append(timeStamp).append(token).append(this.downjoyAppKey).toString();
                    String sign = MD5.getDigest(signParam);
                    object.put("sig", sign);
                    object.put("token", token);
                    String postData = object.toJSONString();
                    String result = HttpClientUtil.doPost(this.downjoyReportUrl, postData, "application/json");
                    Out.info(new Object[]{"DownjoyReport result:", result});
                } catch (Exception e) {
                    Out.warn(new Object[]{"DownjoyReport report exception", e});
                }
            });
        }
    }

    public static void main(String[] args) {
        String test = "%7bcode=value2name=value3personid=value1202cb962234w4ers2aa";
        System.out.println(MD5.encrypt(test).toLowerCase());
    }

    public void ansycReportHolyArmour(PlayerPO player, Map<Integer, String> data) {
        Map<String, Object> param = new HashMap<>();
        param.put("phylum", JSON.toJSON(data));
        ansycReport(player, "ActivateHolyArmour", param);
    }


    private void ansycReport(PlayerPO player, String name, Map<String, Object> param) {
        String reportUrl = GConfig.getInstance().get("server.bi.reportUrl");
        if (StringUtils.isNotEmpty(reportUrl)) {
            Map<String, Object> ps = new HashMap<>();
            ps.put("userid", player.uid);
            ps.put("clientid", Integer.valueOf(GGame.__SERVER_ID));
            ps.put("user_level", Integer.valueOf(player.level));
            ps.put("roleid", player.id);
            ps.putAll(param);

            Map<String, Object> extra = new HashMap<>();
            extra.put("角色名", player.name);
            extra.put("角色职业", Integer.valueOf(player.pro));
            extra.put("角色突破等级", Integer.valueOf(player.upLevel));
            extra.put("角色战斗力", Integer.valueOf(player.fightPower));
            extra.put("元宝存量", Integer.valueOf(player.diamond));
            extra.put("绑元存量", Integer.valueOf(player.ticket));
            extra.put("银两存量", Integer.valueOf(player.gold));

            ps.put("extra", extra);
            Map<String, String> params = new HashMap<>();
            params.put("name", name);
            params.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
            params.put("data", JSON.toJSONString(ps));
            params.put("source", String.valueOf(player.subchannel));
            params.put("device_id", player.mac);
            params.put("platform", String.valueOf(osToPlatform(player.os)));
            params.put("ip", player.ip);

            this.ansycReportExec.execute(() -> {
                try {
                    Out.info(new Object[]{"ansycReport ", name, " report result:", (new HttpRequester()).sendPost(reportUrl, params).getContent()});
                } catch (IOException e) {
                    Out.warn(new Object[]{"ansycReport", name, " report exception", JSON.toJSONString(params), e});
                }
            });
        }
    }

    public void ansycReportSkillUpgrade(PlayerPO player, int skillId, String skillName, int skillLevel) {
        Map<String, Object> param = new HashMap<>();
        param.put("kingdom", Integer.valueOf(skillId));
        param.put("phylum", Integer.valueOf(skillLevel));
        param.put("classfield", skillName);
        ansycReport(player, "UpgradeSkill", param);
    }

    public void ansycReportEquipChange(PlayerPO player, int type, int position, Map<String, Object> data) {
        Map<String, Object> param = new HashMap<>();
        param.put("kingdom", Integer.valueOf(type));
        param.put("phylum", Integer.valueOf(position));
        param.put("classfield", data);
        ansycReport(player, "EquipChange", param);
    }

    public void ansycReportPetActivate(PlayerPO player, int id, String petName) {
        Map<String, Object> param = new HashMap<>();
        param.put("kingdom", Integer.valueOf(id));
        param.put("phylum", petName);
        ansycReport(player, "PetActivate", param);
    }

    public void ansycReportPetBattle(PlayerPO player, int petId, String petName, int level, int upLevel, int type) {
        Map<String, Object> param = new HashMap<>();
        param.put("kingdom", Integer.valueOf(petId));
        param.put("phylum", petName);
        param.put("classfield", Integer.valueOf(level));
        param.put("family", Integer.valueOf(upLevel));
        param.put("genus", Integer.valueOf(type));
        ansycReport(player, "PetBattle", param);
    }

    public void ansycReportMountActivate(PlayerPO player, int id, String skinName) {
        Map<String, Object> param = new HashMap<>();
        param.put("kingdom", Integer.valueOf(id));
        param.put("phylum", skinName);
        ansycReport(player, "MountActivate", param);
    }

    public void ansycReportBloodChange(PlayerPO player, int type, int position, Map<String, Object> data) {
        Map<String, Object> param = new HashMap<>();
        param.put("kingdom", Integer.valueOf(type));
        param.put("phylum", Integer.valueOf(position));
        param.put("classfield", data);
        ansycReport(player, "BloodChange", param);
    }

    public void ansycReportResourceDungeon(PlayerPO player, int win, int mapID) {
        Map<String, Object> param = new HashMap<>();
        param.put("kingdom", Integer.valueOf(win));
        param.put("phylum", Integer.valueOf(mapID));
        ansycReport(player, "ResourceDungeon", param);
    }

    public void ansycReportDemonTower(PlayerPO player, int win, int mapID) {
        Map<String, Object> param = new HashMap<>();
        param.put("kingdom", Integer.valueOf(win));
        param.put("phylum", Integer.valueOf(mapID));
        ansycReport(player, "DemonTower", param);
    }

    public void ansycReportFightLevel(PlayerPO player, int win, int mapID, String instanceId) {
        Map<String, Object> param = new HashMap<>();
        param.put("kingdom", Integer.valueOf(win));
        param.put("phylum", Integer.valueOf(mapID));
        param.put("classfield", instanceId);
        ansycReport(player, "FightLevel", param);
    }

    public void ansycReportEnteredArea(PlayerPO player, int sceneType, int areaId) {
        Map<String, Object> param = new HashMap<>();
        param.put("kingdom", Integer.valueOf(sceneType));
        param.put("phylum", Integer.valueOf(areaId));
        ansycReport(player, "EnteredArea", param);
    }

    public void ansycReportLeaderBoard(PlayerPO player, int type) {
        Map<String, Object> param = new HashMap<>();
        param.put("kingdom", Integer.valueOf(type));
        ansycReport(player, "LeaderBoard", param);
    }

    public void ansycReportKillBoss(PlayerPO player, int sceneType, int monsterId) {
        Map<String, Object> param = new HashMap<>();
        param.put("kingdom", Integer.valueOf(sceneType));
        param.put("phylum", Integer.valueOf(monsterId));
        ansycReport(player, "KillBoss", param);
    }

    public void ansycReportEconomy(PlayerPO player, String currency, boolean kingdom, int value, int origin) {
        Map<String, Object> param = new HashMap<>();
        param.put("currency", currency);
        param.put("kingdom", kingdom ? "earing" : "expenditure");
        param.put("amount", Integer.valueOf(value));
        param.put("phylum", Integer.valueOf(origin));
        ansycReport(player, "Economy", param);
    }

    public void ansycReportItem(PlayerPO player, boolean kingdom, String itemcode, int count, Const.GOODS_CHANGE_TYPE origin, String name) {
        Map<String, Object> param = new HashMap<>();
        param.put("kingdom", kingdom ? "获得" : "消耗");
        param.put("phylum", Integer.valueOf(origin.value));
        param.put("family", name + "(" + itemcode + "):" + count);
        ansycReport(player, "Item", param);
    }

    public void ansycReportMeltCultivate(PlayerPO player, List<NormalItem> items) {
        Map<String, Object> param = new HashMap<>();
        StringBuilder sb = new StringBuilder(128);
        for (NormalItem item : items) {
            sb.append(item.getName()).append("(").append(item.itemCode()).append(")").append(item.getNum()).append(",");
        }
        param.put("family", sb.toString());
        ansycReport(player, "MeltCultivate", param);
    }

    public void ansycReportMission(PlayerPO player, String phylum, int kind, int id, String name) {
        Map<String, Object> param = new HashMap<>();


        if (kind == 1) {
            param.put("kingdom", "主线任务main");
        } else if (kind == 2) {
            param.put("kingdom", "支线任务side");
        } else if (kind == 3) {
            param.put("kingdom", "日常任务daily");
        } else {
            return;
        }
        param.put("phylum", phylum);
        param.put("genus", Integer.valueOf(id));
        param.put("family", name);
        ansycReport(player, "Mission", param);
    }

    public void ansycReportPetCultivate(PlayerPO player, int upLevel, String itemcode, int count, int id) {
        Map<String, Object> param = new HashMap<>();
        param.put("kingdom", Integer.valueOf(2));
        param.put("phylum", "");
        param.put("classfield", (upLevel - 1) + "_" + upLevel);
        DItemBase it = (DItemBase) ItemConfig.getInstance().getItemTemplates().get(itemcode);
        param.put("family", ((it == null) ? "" : it.name) + "(" + itemcode + "):" + count);
        param.put("genus", Integer.valueOf(id));
        ansycReport(player, "PetCultivate", param);
    }

    public void ansycReportPetCultivate(PlayerPO player, int oldLevel, int level, long oldExp, long exp, int id) {
        Map<String, Object> param = new HashMap<>();
        param.put("kingdom", Integer.valueOf(1));
        param.put("phylum", oldLevel + "_" + level + "," + oldExp + "_" + exp);
        param.put("classfield", "");
        param.put("family", "");
        param.put("genus", Integer.valueOf(id));
        ansycReport(player, "PetCultivate", param);
    }

    public void ansycReportRideTrainBI(PlayerPO player, int kingdom, int level, int starLv, String itemcode, int count) {
        Map<String, Object> param = new HashMap<>();
        param.put("kingdom", Integer.valueOf(kingdom));
        param.put("phylum", Integer.valueOf(level));
        param.put("classfield", Integer.valueOf(starLv));
        DItemBase it = (DItemBase) ItemConfig.getInstance().getItemTemplates().get(itemcode);
        param.put("family", ((it == null) ? "" : it.name) + "(" + itemcode + "):" + count);
        ansycReport(player, "RideTrainBI", param);
    }

    public void ansycReportStrengthenCultivate(PlayerPO player, int pos, int oldLevel, int level, JSONObject mates) {
        Map<String, Object> param = new HashMap<>();
        param.put("kingdom", Integer.valueOf(pos));
        param.put("phylum", "强化前等级：" + oldLevel);
        param.put("classfield", "强化后等级:" + level);
        StringBuilder sb = new StringBuilder(128);
        for (String itemcode : mates.keySet()) {
            int needNum = mates.getIntValue(itemcode);
            DItemBase it = (DItemBase) ItemConfig.getInstance().getItemTemplates().get(itemcode);
            sb.append((it == null) ? "" : it.name).append("(").append(itemcode).append(")").append(needNum).append(",");
        }
        param.put("family", sb.toString());
        ansycReport(player, "StrengthenCultivate", param);
    }
}


