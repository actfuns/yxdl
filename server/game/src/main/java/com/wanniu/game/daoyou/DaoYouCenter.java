package com.wanniu.game.daoyou;

import com.wanniu.core.game.JobFactory;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.DateUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.Const;
import com.wanniu.game.daoyou.dao.DaoYouDao;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.TeamPropExt;
import com.wanniu.game.player.AttributeUtil;
import com.wanniu.game.poes.DaoYouMemberPO;
import com.wanniu.game.poes.DaoYouPO;
import com.wanniu.game.rank.RankType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class DaoYouCenter {
    private static DaoYouCenter instance;
    public ConcurrentHashMap<String, DaoYouPO> daoYouMap;
    public ConcurrentHashMap<String, String> daoYouNameMap;
    public ConcurrentHashMap<String, DaoYouMemberPO> daoYouMemberMap;
    public ConcurrentHashMap<String, List<String>> daoYouMemberIdMap;
    public ConcurrentHashMap<String, Map<Const.PlayerBtlData, Integer>> daoYouBtlAdd;

    public static DaoYouCenter getInstance() {
        if (instance == null) {
            instance = new DaoYouCenter();
        }
        return instance;
    }


    private DaoYouCenter() {
        this.daoYouMap = new ConcurrentHashMap<>();
        this.daoYouNameMap = new ConcurrentHashMap<>();
        this.daoYouMemberMap = new ConcurrentHashMap<>();
        this.daoYouMemberIdMap = new ConcurrentHashMap<>();
        this.daoYouBtlAdd = new ConcurrentHashMap<>();
        init();
    }


    public void init() {
        List<DaoYouMemberPO> daoYouMemberList = DaoYouDao.getAllDaoYouMember();
        for (DaoYouMemberPO dymp : daoYouMemberList) {
            addDaoYouMember(dymp, true);
        }

        List<DaoYouPO> daoYouList = DaoYouDao.getAllDaoYouList();
        for (DaoYouPO dyp : daoYouList) {
            addDaoYou(dyp, true);


            calDaoYouData(dyp.id);
        }


        long period = 86400000L;
        long initialDelay = DateUtil.getFiveDelay();
        JobFactory.addFixedRateJob(new Runnable() {
            public void run() {
                try {
                    ConcurrentHashMap<String, DaoYouMemberPO> daoYouMem = (DaoYouCenter.getInstance()).daoYouMemberMap;
                    Iterator<Map.Entry<String, DaoYouMemberPO>> daoYouMemIt = daoYouMem.entrySet().iterator();
                    while (daoYouMemIt.hasNext()) {
                        Map.Entry<String, DaoYouMemberPO> daoYouMemEntry = daoYouMemIt.next();
                        String daoYouMemPlayer = daoYouMemEntry.getKey();
                        DaoYouMemberPO dymp = daoYouMemEntry.getValue();
                        int needReciveRebate = dymp.todayReciveRebate;
                        Map<String, Integer> todaySendRebate = dymp.todaySendRebate;
                        int todaySendRebateNumber = 0;
                        if (todaySendRebate != null) {
                            for (Iterator<Integer> iterator = todaySendRebate.values().iterator(); iterator.hasNext(); ) {
                                int sendRebateNumber = ((Integer) iterator.next()).intValue();
                                todaySendRebateNumber += sendRebateNumber;
                            }

                        }
                        dymp.totalSendRebate += todaySendRebateNumber;
                        dymp.todaySendRebate = null;
                        dymp.totalReciveRebate += needReciveRebate;
                        dymp.todayReciveRebate = 0;
                        if (needReciveRebate > 0) {
                            DaoYouService.getInstance().sendRebateMail(daoYouMemPlayer, needReciveRebate);
                        }
                        DaoYouDao.updateDaoYouMember(dymp);
                    }

                } catch (Exception e) {
                    Out.error(new Object[]{e});
                }
            }
        }initialDelay, period);
    }


    public DaoYouPO getDaoYou(String daoYouId) {
        return this.daoYouMap.get(daoYouId);
    }


    public String getDaoYouId(String daoYouName) {
        return this.daoYouNameMap.get(daoYouName);
    }


    public DaoYouMemberPO getDaoYouMember(String dyMemPlayerId) {
        return this.daoYouMemberMap.get(dyMemPlayerId);
    }


    public Map<Const.PlayerBtlData, Integer> getDaoYouBtl(String daoYouId) {
        return this.daoYouBtlAdd.get(daoYouId);
    }


    public List<String> getAllDaoYouMember(String daoYouId) {
        return this.daoYouMemberIdMap.get(daoYouId);
    }


    public void addDaoYou(DaoYouPO dyp, boolean isInit) {
        String dypId = dyp.id;
        if (this.daoYouMap.get(dypId) != null) {
            return;
        }
        this.daoYouMap.put(dypId, dyp);
        addDaoYouName(dyp.name, dypId);
        if (!isInit) {
            saveDaoYou(dyp);
        }
    }


    public void addDaoYouName(String logicName, String daoYouId) {
        if (logicName != null && !logicName.isEmpty() && daoYouId != null && !daoYouId.isEmpty()) {
            this.daoYouNameMap.put(logicName, daoYouId);
        }
    }


    public void saveDaoYou(DaoYouPO dyp) {
        if (dyp == null) {
            return;
        }
        DaoYouDao.updateDaoYou(dyp);
    }


    public void addDaoYouMember(DaoYouMemberPO dymp, boolean isInit) {
        String dyMemPlayerId = dymp.playerId;
        if (this.daoYouMemberMap.get(dyMemPlayerId) != null) {
            return;
        }
        this.daoYouMemberMap.put(dyMemPlayerId, dymp);
        String daoYouId = dymp.daoYouId;
        List<String> dyMemPIds = this.daoYouMemberIdMap.get(daoYouId);
        if (dyMemPIds == null) {
            dyMemPIds = new ArrayList<>();
        }
        String playerId = dymp.playerId;
        dyMemPIds.add(playerId);
        this.daoYouMemberIdMap.put(daoYouId, dyMemPIds);
        if (!isInit) {
            saveDaoYouMember(dymp);
        }
        calDaoYouData(daoYouId);
    }


    public void saveDaoYouMember(DaoYouMemberPO dymp) {
        if (dymp == null) {
            return;
        }
        DaoYouDao.updateDaoYouMember(dymp);
    }


    public void removeDaoYou(String daoYouId) {
        DaoYouPO dyp = this.daoYouMap.get(daoYouId);
        String dypName = dyp.name;
        this.daoYouNameMap.remove(dypName);
        this.daoYouMap.remove(daoYouId);
        this.daoYouBtlAdd.remove(daoYouId);
        DaoYouDao.removeDaoYou(dyp);

        RankType.DAOYOU.getHandler().delRankMember(GWorld.__SERVER_ID, daoYouId);
    }


    public void removeDaoYouMember(String dyMemPlayerId) {
        DaoYouMemberPO dymp = this.daoYouMemberMap.get(dyMemPlayerId);
        if (dymp == null) {
            return;
        }
        String dyId = dymp.daoYouId;
        List<String> dyMemPlayerIds = this.daoYouMemberIdMap.get(dyId);
        if (dyMemPlayerIds.size() == 2) {
            this.daoYouMemberIdMap.remove(dyId);
            removeDaoYou(dyId);
            DaoYouMemberPO dympA = this.daoYouMemberMap.get(dyMemPlayerIds.get(0));
            DaoYouMemberPO dympB = this.daoYouMemberMap.get(dyMemPlayerIds.get(1));
            this.daoYouMemberMap.remove(dyMemPlayerIds.get(0));
            this.daoYouMemberMap.remove(dyMemPlayerIds.get(1));
            DaoYouDao.removeDaoYouMember(dympA);
            DaoYouDao.removeDaoYouMember(dympB);
        } else {
            dyMemPlayerIds.remove(dyMemPlayerId);
            calDaoYouData(dyId);
            this.daoYouMemberMap.remove(dyMemPlayerId);
            DaoYouDao.removeDaoYouMember(dymp);
        }
    }


    public void calDaoYouData(String daoYouId) {
        Map<Const.PlayerBtlData, Integer> thisDaoYouBtlAdd = getDaoYouBtl(daoYouId);
        if (thisDaoYouBtlAdd == null) {
            thisDaoYouBtlAdd = new HashMap<>();
        } else {
            thisDaoYouBtlAdd.clear();
        }
        List<TeamPropExt> props = GameData.findTeamProps(t -> (t.iD == 1));
        if (props.isEmpty())
            return;
        TeamPropExt prop = props.get(0);
        List<String> dyMemPlayerId = getAllDaoYouMember(daoYouId);
        if (dyMemPlayerId == null) {
            Out.error(new Object[]{daoYouId, "============找不到成员"});
            return;
        }
        int length = dyMemPlayerId.size();
        for (int i = 0; i < length - 1; i++) {
            AttributeUtil.addData2AllDataByKey(prop.attrs, thisDaoYouBtlAdd);
        }
        this.daoYouBtlAdd.put(daoYouId, thisDaoYouBtlAdd);
    }
}


