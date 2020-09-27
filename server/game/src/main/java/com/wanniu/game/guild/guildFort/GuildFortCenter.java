package com.wanniu.game.guild.guildFort;

import com.wanniu.core.db.GCache;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.DateUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.GuildFortExt;
import com.wanniu.game.guild.guildFort.dao.GuildFortBattleReportPO;
import com.wanniu.game.guild.guildFort.dao.GuildFortDao;
import com.wanniu.game.guild.guildFort.dao.GuildFortPO;
import com.wanniu.game.guild.guildFort.dao.GuildFortReportPO;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuildFortCenter {
    private static final int MAX_BID_FORT_NUM = 3;

    public enum Status {
        NOT_BEGIN(0),
        INTIME_NOTBID(1),
        BID_ENDED(2),
        IN_PREPARE(3),
        IN_BATTLE(4),
        INTIME_BIDDED(5);


        public int value;


        Status(int value) {
            this.value = value;
        }
    }


    private Map<Integer, GuildFort> forts = new HashMap<>();
    private List<GuildFortReportPO> reports = new ArrayList<>();

    private static final String Tradenionstrongholds = "Tradenionstrongholds";

    private GuildFortCenter() {
        init();
    }

    private void init() {
        for (GuildFortExt fortExt : GameData.GuildForts.values()) {
            GuildFort fort = new GuildFort(fortExt);
            GuildFortPO po = GuildFortDao.getFort(fortExt.iD);
            if (po != null) {
                fort.setPo(po);
            }
            this.forts.put(Integer.valueOf(fortExt.iD), new GuildFort(fortExt));
        }
        this.reports = GuildFortDao.getReports();
    }

    private static class GuildFortCenterHolder {
        public static final GuildFortCenter INSTANCE = new GuildFortCenter();
    }

    public static GuildFortCenter getInstance() {
        return GuildFortCenterHolder.INSTANCE;
    }

    public int getStatus(boolean isBidded) {
        GuildFortService service = GuildFortService.getInstance();
        if (service.isInBidTime()) {
            if (isBidded) {
                return Status.INTIME_BIDDED.value;
            }
            return Status.INTIME_NOTBID.value;
        }
        if (service.isInBidEndedTime())
            return Status.BID_ENDED.value;
        if (service.isInPrepareBattleTime())
            return Status.IN_PREPARE.value;
        if (service.isInBattleTime()) {
            return Status.IN_BATTLE.value;
        }
        return Status.NOT_BEGIN.value;
    }


    public void onBidTimeBegin() {
        GuildFortUtil.pushRedPointToAll();
    }


    public void onBidOperation() {
        saveForts();
    }

    private String getBidOverReportMessage() {
        StringBuilder title = new StringBuilder(LangService.getValue("GUILDFORT_BIDRESULT_TITILE_NOTICE"));
        String msgStr = LangService.getValue("GUILDFORT_BIDRESULT_LOOP_NOTICE");
        String noBidderStr = LangService.getValue("GUILDFORT_BIDRESULT_NOBIDDER_NOTICE");
        for (GuildFort fort : this.forts.values()) {
            String str = msgStr.replace("{fortname}", fort.getName());
            String defName = fort.getDefenserName();
            String attName = fort.getAttackerName();
            if (defName.equals("") && attName.equals("")) {
                str = noBidderStr.replace("{fortname}", fort.getName());
            } else if (!defName.equals("") && attName.equals("")) {
                str = str.replace("{defguildname}", defName).replace("{attguildname}", "据点守卫军");
            } else {
                str = str.replace("{defguildname}", defName).replace("{attguildname}", attName);
            }

            title.append(str);
        }

        return title.toString();
    }

    public void onBidTimeEnd() {
        for (GuildFort fort : this.forts.values()) {
            fort.onBidOver();
        }
        saveForts();
    }


    public void onPrepareBattle() {
        Map<String, Integer> members = new HashMap<>();
        for (GuildFort fort : this.forts.values()) {
            List<String> ids = fort.getAllMemberIds();
            for (String id : ids) {
                members.put(id, Integer.valueOf(0));
            }
        }

        GuildFortUtil.pushRedPoint(members.keySet());
    }

    public void onBattleTimeBegin() {
        for (GuildFort fort : this.forts.values()) {
            fort.onBattleBegin();
        }
        clearAllDailyAwards();
    }


    public void onBattleTimeEnd() {
        for (GuildFort fort : this.forts.values()) {
            fort.onBattleOver();
            String occupyGuildId = fort.getOccupyGuildId();
            System.out.println(fort.getId() + "=======================================fortId");
            System.out.println(fort.getOccupyGuildIds() + "=======================================occIds");
            if (fort.getOccupyGuildIds() == null || fort.getOccupyGuildIds().equals("")) {
                GCache.hset("Tradenionstrongholds", String.valueOf(fort.getId()), "");
                System.out.println("Tradenionstrongholds--------------------------------------------------------------------占领工会id" + occupyGuildId);
                continue;
            }
            GCache.hset("Tradenionstrongholds", String.valueOf(fort.getId()), fort.getOccupyGuildIds());
            System.out.println("Tradenionstrongholds--------------------------------------------------------------------占领工会id" + occupyGuildId);
        }


        saveForts();
        GuildFortUtil.pushRedPointToAll();
        resetAllDailyAwards();
    }


    private void resetAllDailyAwards() {
        GWorld.getInstance().ansycExec(() -> {
            for (GPlayer p : PlayerUtil.getAllOnlinePlayer()) {
                WNPlayer wp = (WNPlayer) p;
                wp.guildFortManager.recalcDailyAwards();
            }
        });
        Out.info(new Object[]{"Guildfort daily awards recalc completed..."});
    }

    private void clearAllDailyAwards() {
        GWorld.getInstance().ansycExec(() -> {
            for (GPlayer p : PlayerUtil.getAllOnlinePlayer()) {
                WNPlayer wp = (WNPlayer) p;
                wp.guildFortManager.clearDailyAwards();
            }
        });
        Out.info(new Object[]{"Guildfort daily awards cleared..."});
    }


    public void addBattleReport(GuildFortBattleReportPO battleReport) {
        String date = DateUtil.getDate();
        if (GWorld.DEBUG) {
            date = DateUtil.getDateTime();
            date = date.substring(0, date.length() - 3);
        }

        GuildFortReportPO report = null;
        for (GuildFortReportPO rep : this.reports) {
            if (rep.date.equals(date)) {
                report = rep;

                break;
            }
        }
        if (report == null) {
            report = new GuildFortReportPO();
            this.reports.add(report);
        }
        report.date = date;
        report.battleReports.put(Integer.valueOf(battleReport.fortId), battleReport);

        if (this.reports.size() >= GlobalConfig.GuildFort_BattleRecordNum) {
            this.reports.remove(0);
        }

        saveReports();
    }

    public GuildFort getFort(int fortId) {
        return this.forts.get(Integer.valueOf(fortId));
    }


    public List<GuildFort> getOccupiedForts(String guildId) {
        List<GuildFort> list = new ArrayList<>();
        for (GuildFort fort : this.forts.values()) {
            if (fort.isOccupier(guildId)) {
                list.add(fort);
            }
        }


        return list;
    }

    public boolean isBitFortExceeded(String guildId) {
        int num = 0;
        for (GuildFort fort : this.forts.values()) {
            if (fort.isInBidders(guildId)) {
                num++;
            }
        }

        return (num >= 3);
    }

    public Collection<GuildFort> getAllGuildFort() {
        return this.forts.values();
    }

    public List<GuildFortReportPO> getReports() {
        return this.reports;
    }

    private void saveForts() {
        for (GuildFort fort : this.forts.values()) {
            GuildFortDao.saveFort(fort.getPo());
        }
    }

    private void saveReports() {
        GuildFortDao.saveReports(this.reports);
    }


    public void test() {
    }


    public void onCloseGame() {
        saveForts();
        saveReports();
    }
}


