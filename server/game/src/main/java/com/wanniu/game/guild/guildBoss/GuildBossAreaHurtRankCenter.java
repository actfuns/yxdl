package com.wanniu.game.guild.guildBoss;

import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.LangService;
import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.game.common.msg.MessagePush;
import com.wanniu.game.guild.GuildServiceCenter;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.GuildPO;
import com.wanniu.game.poes.PlayerPO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import pomelo.area.GuildBossHandler;


public class GuildBossAreaHurtRankCenter {
    public static GuildBossAreaHurtRankCenter instance = new GuildBossAreaHurtRankCenter();

    public static final Comparator<RankBean> SORT_HURT = new Comparator<RankBean>() {
        public int compare(RankBean o1, RankBean o2) {
            if (o1.getHurt() > o2.getHurt())
                return -1;
            if (o1.getHurt() < o2.getHurt()) {
                return 1;
            }
            return 0;
        }
    };


    public static final Comparator<GuildRankBean> SORT_GUILD = new Comparator<GuildRankBean>() {
        public int compare(GuildRankBean o1, GuildRankBean o2) {
            if (o1.getBossKillTime() > o2.getBossKillTime())
                return 1;
            if (o1.getBossKillTime() < o2.getBossKillTime()) {
                return -1;
            }
            return 0;
        }
    };


    public static final Comparator<GuildRankBean> SORT_GUILD_HURT = new Comparator<GuildRankBean>() {
        public int compare(GuildRankBean o1, GuildRankBean o2) {
            if (o1.getTotalHurt() > o2.getTotalHurt())
                return -1;
            if (o1.getTotalHurt() < o2.getTotalHurt()) {
                return 1;
            }
            if (o1.getBossKillTime() > o2.getBossKillTime())
                return 1;
            if (o1.getBossKillTime() < o2.getBossKillTime()) {
                return -1;
            }
            return 0;
        }
    };


    public static final Comparator<GuildRankBean> SORT_GUILD_ONLY_HURT = new Comparator<GuildRankBean>() {
        public int compare(GuildRankBean o1, GuildRankBean o2) {
            if (o1.getTotalHurt() > o2.getTotalHurt())
                return -1;
            if (o1.getTotalHurt() < o2.getTotalHurt()) {
                return 1;
            }
            return 0;
        }
    };


    private Map<String, GuildRankBean> dataMap = new ConcurrentHashMap<>();
    private Map<String, List<RankBean>> oldData = new ConcurrentHashMap<>();
    private List<GuildRankBean> guildList = new ArrayList<>();
    private Map<String, RankBean> totalHurtMap = new HashMap<>();
    private List<RankBean> totalHurtList = new ArrayList<>();
    private boolean isChanged = false;

    public void processSortHurtRank(String guildId, Collection<String> pushRoleIds, boolean isForcePush, long bossKillTime, boolean hasKilled) {
        GuildRankBean bean = getGuildRankBean(guildId);
        processSortHurtRank(guildId, pushRoleIds, isForcePush);
        if (bossKillTime > 0L && !bean.hasKilled() && !hasKilled) {
            bean.setBossKillTime(bossKillTime);
        }
        if (!bean.hasKilled() && hasKilled) {
            bean.setHasKilled(true);
            bean.setBossKillTime(bossKillTime);
        }
    }


    public void overStaticsRanks(String guildId, Collection<String> roleIds) {
        GuildRankBean bean = getGuildRankBean(guildId);
        bean.sort();
        processSortHurtRank(guildId, roleIds, true);
        pushOverRanks(roleIds, bean);
    }

    public void pushOverRanks(Collection<String> roleIds, GuildRankBean bean) {
        for (String pId : roleIds) {
            WNPlayer py = PlayerUtil.getOnlinePlayer(pId);
            if (py != null) {
                RankBean myBean = bean.onlyGetRankBean(pId);
                int myRank = (myBean == null) ? 0 : myBean.getGuildRank();
                long hurt = (myBean == null) ? 0L : myBean.getHurt();
                GuildBossHandler.OnEndGuildBossPush.Builder msg = GuildBossHandler.OnEndGuildBossPush.newBuilder();
                msg.setInfo(String.format(LangService.getValue("GUILD_BOSS_END_DETAIL_INFO"), new Object[]{convertNumToStr(hurt), String.valueOf(myRank)}));
                msg.setSec(GlobalConfig.GuildBoss_LeaveTime);
                MessagePush push = new MessagePush("area.guildBossPush.onEndGuildBossPush", (GeneratedMessage) msg.build());
                py.receive((Message) push);
            }
        }
    }


    public void processSortHurtRank(String guildId, Collection<String> pushRoleIds, boolean isForcePush) {
        if (isForcePush) {
            pushRankData(pushRoleIds, guildId);

        } else {


            if (pushRoleIds == null || pushRoleIds.isEmpty()) {
                return;
            }
            for (RankBean bean : this.totalHurtList) {
                bean.reset();
            }
            sort(this.totalHurtList);
            Collections.sort(this.guildList, SORT_GUILD_ONLY_HURT);
            pushRankData(pushRoleIds, guildId);
        }
    }

    private GuildBossHandler.HurtRankInfo.Builder getHurtRankInfo(int rank, String playerId, long hurt) {
        PlayerPO playerBase = PlayerUtil.getPlayerBaseData(playerId);
        if (playerBase != null) {
            GuildBossHandler.HurtRankInfo.Builder bd = GuildBossHandler.HurtRankInfo.newBuilder();
            bd.setHurt(hurt);
            bd.setRank(rank);
            bd.setId(playerId);
            bd.setName(playerBase.name);
            return bd;
        }
        return null;
    }

    private GuildBossHandler.HurtRankInfo.Builder getGuildHurtRankInfo(int rank, String guildId, long hurt) {
        GuildPO guildPO = GuildServiceCenter.getInstance().getGuild(guildId);
        if (guildPO != null) {
            GuildBossHandler.HurtRankInfo.Builder bd = GuildBossHandler.HurtRankInfo.newBuilder();
            bd.setHurt(hurt);
            bd.setRank(rank);
            bd.setId(guildId);
            bd.setName(guildPO.name);
            return bd;
        }
        return null;
    }

    private void sort(List<RankBean> list) {
        Collections.sort(list, SORT_HURT);
    }


    private void pushRankData(Collection<String> pushRoleIds, String guildId) {
        if (pushRoleIds == null || pushRoleIds.isEmpty()) {
            return;
        }
        GuildBossHandler.OnHurtRankChangePush.Builder msg = GuildBossHandler.OnHurtRankChangePush.newBuilder();
        msg.setS2CCode(200);
        if (this.totalHurtList != null && !this.totalHurtList.isEmpty()) {
            for (int i = 0; i < this.totalHurtList.size(); i++) {
                RankBean bean = this.totalHurtList.get(i);
                int rank = i + 1;
                bean.setRank(rank);
                if (i <= 9) {
                    GuildBossHandler.HurtRankInfo.Builder bd = getHurtRankInfo(rank, bean.getId(), bean.getHurt());
                    if (bd != null) {
                        msg.addOtherInfo(bd);
                    }
                }
            }
        }

        if (this.guildList != null && !this.guildList.isEmpty()) {

            int rank = 0;
            for (int i = 0; i < this.guildList.size(); i++) {
                GuildRankBean bean = this.guildList.get(i);
                long totalHurt = bean.getTotalHurt();
                if (rank <= 10 && totalHurt > 0L) {
                    GuildBossHandler.HurtRankInfo.Builder bd = getGuildHurtRankInfo(++rank, bean.getGuildId(), totalHurt);
                    if (bd != null) {
                        msg.addOtherGuildInfo(bd);
                    }
                }

                if (guildId.equals(bean.getGuildId())) {
                    int myRank = (totalHurt <= 0L) ? 0 : rank;
                    GuildBossHandler.HurtRankInfo.Builder myGuildInfo = getGuildHurtRankInfo(myRank, bean.getGuildId(), totalHurt);
                    if (myGuildInfo != null) {
                        msg.setMyGuildInfo(myGuildInfo);
                    }
                }
            }
        }

        msg.setJoinCount(pushRoleIds.size());

        for (String pId : pushRoleIds) {
            WNPlayer py = PlayerUtil.getOnlinePlayer(pId);
            if (py != null) {
                RankBean myBean = this.totalHurtMap.get(pId);
                int myRank = (myBean == null) ? 0 : myBean.getRank();
                long hurt = (myBean == null) ? 0L : myBean.getHurt();
                GuildBossHandler.HurtRankInfo.Builder myInfo = getHurtRankInfo(myRank, pId, hurt);
                if (myInfo != null) {
                    msg.setMyInfo(myInfo);
                }
                py.receive("area.guildBossPush.onHurtRankChangePush", (GeneratedMessage) msg.build());
            }
        }
    }

    public void clearRankData() {
        this.totalHurtMap.clear();
        this.totalHurtList.clear();
    }

    public static String convertNumToStr(long hurt) {
        long T1 = (long) Math.pow(10.0D, 8.0D);
        long T2 = (long) Math.pow(10.0D, 5.0D);
        long T3 = (long) Math.pow(10.0D, 2.0D);
        long T4 = (long) Math.pow(10.0D, 6.0D);
        if (hurt / T1 >= 1L) {
            hurt = (long) Math.floor(((float) hurt * 1.0F / (float) T4));
            return String.format("%.2f", new Object[]{Float.valueOf((float) hurt * 1.0F / (float) T3)}) + "亿";
        }
        if (hurt / T2 >= 1L) {
            hurt = (long) Math.floor(((float) hurt * 1.0F / (float) T3));
            return String.format("%.2f", new Object[]{Float.valueOf((float) hurt * 1.0F / (float) T3)}) + "万";
        }
        return String.valueOf(hurt);
    }


    public void processOver(String guildId) {
        GuildRankBean bean = getGuildRankBean(guildId);
        if (bean.getHurtList() == null || bean.getHurtList().isEmpty()) {
            return;
        }
        List<RankBean> newList = new ArrayList<>(bean.getHurtList());
        sort(newList);
        replaceShowData(guildId, newList);
        GuildBossAreaHurtRankService.getInstance().saveAfterOver(guildId, newList);
    }

    public void clearOldData() {
        this.dataMap.clear();
        this.guildList.clear();
        clearRankData();
    }

    public void replaceShowData(String guildId, List<RankBean> newList) {
        synchronized (this.oldData) {
            this.oldData.put(guildId, newList);
        }
    }


    public void replaceIfnullShowData(String guildId, List<RankBean> newList) {
        synchronized (this.oldData) {
            List<RankBean> currentList = this.oldData.get(guildId);
            if (currentList == null) {
                this.oldData.put(guildId, newList);
            }
        }
    }

    public boolean isChanged() {
        return this.isChanged;
    }

    public void setChanged(boolean isChanged) {
        this.isChanged = isChanged;
    }

    public void setNewData(String guildId, String playerId, long hurt, int enterCount) {
        RankBean bean = getAndSetRankBean(playerId);
        bean.setNewData(enterCount, hurt);
        if (!this.isChanged) {
            this.isChanged = true;
        }
        GuildRankBean guildBean = getGuildRankBean(guildId);
        guildBean.setRankBeanIfNull(bean);
    }

    public GuildRankBean getGuildRankBean(String guildId) {
        GuildRankBean bean = this.dataMap.get(guildId);
        if (bean == null) {
            bean = new GuildRankBean(guildId);
            this.dataMap.put(guildId, bean);
            this.guildList.add(bean);
        }
        return bean;
    }

    public RankBean getAndSetRankBean(String playerId) {
        RankBean bean = this.totalHurtMap.get(playerId);
        if (bean == null) {
            bean = new RankBean();
            bean.setId(playerId);
            this.totalHurtMap.put(playerId, bean);
            this.totalHurtList.add(bean);
        }
        return bean;
    }

    public GuildRankBean onlyGetGuildRankBean(String guildId) {
        return this.dataMap.get(guildId);
    }

    public Map<String, GuildRankBean> getDataMap() {
        return this.dataMap;
    }

    public List<RankBean> getRankList(String guildId) {
        return this.oldData.get(guildId);
    }

    public static class GuildStaticRankBean {
        private String guildId;
        private long totalHurt;
        private int seconds;

        public String getGuildId() {
            return this.guildId;
        }

        public void setGuildId(String guildId) {
            this.guildId = guildId;
        }

        public long getTotalHurt() {
            return this.totalHurt;
        }

        public void setTotalHurt(long totalHurt) {
            this.totalHurt = totalHurt;
        }

        public int getSeconds() {
            return this.seconds;
        }

        public void setSeconds(int seconds) {
            this.seconds = seconds;
        }

        public static GuildStaticRankBean getGuildStaticRankBean(GuildRankBean bean) {
            GuildStaticRankBean rb = new GuildStaticRankBean();
            rb.setGuildId(bean.getGuildId());
            rb.setTotalHurt(bean.getTotalHurt());
            if (bean.hasKilled()) {
                rb.setSeconds((int) ((bean.getBossKillTime() - GuildBossCenter.getInstance().getBeginTime()) / 1000L));
            }
            return rb;
        }
    }


    public static GuildBossAreaHurtRankCenter getInstance() {
        return instance;
    }
}


