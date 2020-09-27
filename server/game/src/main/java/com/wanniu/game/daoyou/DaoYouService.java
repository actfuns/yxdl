package com.wanniu.game.daoyou;

import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.protocol.PomeloPush;
import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.core.util.DateUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.Utils;
import com.wanniu.game.daoyou.dao.DaoYouDao;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.game.message.MessageData;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.DaoYouMemberPO;
import com.wanniu.game.poes.DaoYouPO;
import com.wanniu.game.poes.MessagePO;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.game.rank.handler.DaoYouRankHandler;
import com.wanniu.game.team.TeamData;
import com.wanniu.game.team.TeamUtil;
import com.wanniu.game.util.BlackWordUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import pomelo.area.MessageHandler;
import pomelo.daoyou.DaoYouHandler;


public class DaoYouService {
    public Map<String, Long> inviteTime = new HashMap<>();


    private static DaoYouService instance = null;

    public static DaoYouService getInstance() {
        if (instance == null) {
            instance = new DaoYouService();
        }
        return instance;
    }


    public void applyDaoYouList(String playerId, DaoYouHandler.DaoYouResponse.Builder daoYouResponse) {
        DaoYouMemberPO dymp = DaoYouCenter.getInstance().getDaoYouMember(playerId);
        if (dymp == null) {
            daoYouResponse.setS2CCode(200);
            daoYouResponse.setIsHasDaoYou(0);
            return;
        }
        String dyId = dymp.daoYouId;
        DaoYouPO daoYou = DaoYouCenter.getInstance().getDaoYou(dyId);
        daoYouResponse.setS2CCode(200);
        daoYouResponse.setIsHasDaoYou(1);
        daoYouResponse.setIsEditedDyName(daoYou.isEditedDyName);
        daoYouResponse.setDyId(daoYou.id);
        daoYouResponse.setDyName(daoYou.name);

        List<DaoYouHandler.DaoYouInfo> daoYouList = new ArrayList<>();
        DaoYouHandler.DaoYouInfo.Builder adminDaoYouInfo = DaoYouHandler.DaoYouInfo.newBuilder();
        List<String> dyMemPlayerIds = DaoYouCenter.getInstance().getAllDaoYouMember(dyId);
        for (String dyMemPlayerId : dyMemPlayerIds) {
            DaoYouHandler.DaoYouInfo.Builder daoYouInfo = DaoYouHandler.DaoYouInfo.newBuilder();
            daoYouInfo.setPlayerId(dyMemPlayerId);
            PlayerPO playerBase = PlayerUtil.getPlayerBaseData(dyMemPlayerId);
            if (playerBase == null) {
                continue;
            }
            daoYouInfo.setPlayerName(playerBase.name);
            daoYouInfo.setPlayerLvl(playerBase.level);
            daoYouInfo.setPro(playerBase.pro);


            daoYouInfo.setPlayerUpLvl(playerBase.upLevel);
            daoYouInfo.setPlayerFightPower(playerBase.fightPower);
            boolean isOnline = PlayerUtil.isOnline(dyMemPlayerId);
            if (isOnline) {
                WNPlayer dyMemPlayer = PlayerUtil.getOnlinePlayer(dyMemPlayerId);
                daoYouInfo.setAreaName(dyMemPlayer.getSceneName());
            } else {
                daoYouInfo.setAreaName("");
            }
            daoYouInfo.setOnlineState(isOnline ? 1 : 0);
            daoYouInfo.setLastActiveTime((int) Math.floor((playerBase.logoutTime.getTime() / 1000L)));
            DaoYouMemberPO tempMemberPO = DaoYouCenter.getInstance().getDaoYouMember(dyMemPlayerId);
            daoYouInfo.setJoinTime((int) Math.floor((tempMemberPO.joinTime.getTime() / 1000L)));
            if (dyMemPlayerId.equals(daoYou.adminPlayerId)) {
                daoYouInfo.setIsAdmin(1);
                adminDaoYouInfo = daoYouInfo;
                continue;
            }
            daoYouInfo.setIsAdmin(0);
            daoYouList.add(daoYouInfo.build());
        }

        daoYouList.sort(new Comparator<DaoYouHandler.DaoYouInfo>() {
            public int compare(DaoYouHandler.DaoYouInfo o1, DaoYouHandler.DaoYouInfo o2) {
                DaoYouHandler.DaoYouInfo.Builder dyi1 = o1.toBuilder();
                DaoYouHandler.DaoYouInfo.Builder dyi2 = o2.toBuilder();
                if (dyi1.getOnlineState() != dyi2.getOnlineState()) {
                    return (dyi1.getOnlineState() < dyi2.getOnlineState()) ? 1 : -1;
                }
                return (dyi1.getJoinTime() > dyi2.getJoinTime()) ? 1 : -1;
            }
        });

        daoYouList.add(0, adminDaoYouInfo.build());
        daoYouResponse.addAllDyInfo(daoYouList);

        daoYouResponse.setDyFightPower(daoYou.fightPower);
        daoYouResponse.setDyRank(getDaoYouRank(dyId));
        daoYouResponse.setDyNotice(daoYou.notice);
        List<DaoYouMessageVo> messages = daoYou.messages;
        List<DaoYouHandler.DaoYouMessage> responseMessages = new ArrayList<>();
        if (messages != null) {
            for (int i = messages.size() - 1; i >= 0; i--) {
                DaoYouMessageVo dm = messages.get(i);
                DaoYouHandler.DaoYouMessage.Builder sm = DaoYouHandler.DaoYouMessage.newBuilder();
                sm.setType(dm.type);
                sm.setContent(dm.message);
                sm.setTime((int) Math.floor((dm.time.getTime() / 1000L)));
                responseMessages.add(sm.build());
            }
        }
        daoYouResponse.addAllMessage(responseMessages);
    }


    public int getDaoYouRank(String daoYouId) {
        DaoYouPO daoYouPO = (DaoYouCenter.getInstance()).daoYouMap.get(daoYouId);
        if (daoYouPO == null) {
            return -1;
        }
        long rank = DaoYouRankHandler.getInstance().getRank(GWorld.__SERVER_ID, daoYouId);
        return (int) rank;
    }


    public String editDaoYouName(String adminPlayerId, String adminPlayerName, String newDouYouname) {
        DaoYouMemberPO dyMemPo = DaoYouCenter.getInstance().getDaoYouMember(adminPlayerId);
        if (dyMemPo == null) {
            return LangService.getValue("DAO_YOU_NOT_HAS");
        }
        String dyId = dyMemPo.daoYouId;
        DaoYouPO dyp = DaoYouCenter.getInstance().getDaoYou(dyId);
        if (dyp == null) {
            return LangService.getValue("DAO_YOU_NOT_HAS");
        }
        if (!dyp.adminPlayerId.equals(adminPlayerId)) {
            return LangService.getValue("DAO_YOU_NOT_ADMIN");
        }
        if (newDouYouname.length() < Const.DaoYou.DaoYouNameMinLength.getValue()) {
            return LangService.getValue("DAO_YOU_NAME_TOO_SHORT");
        }
        if (newDouYouname.length() > Const.DaoYou.DaoYouNameMaxLength.getValue()) {
            return LangService.getValue("DAO_YOU_NAME_TOO_LANG");
        }
        if (BlackWordUtil.isIncludeSpecialChar(newDouYouname)) {
            return LangService.getValue("DAO_YOU_NAME_CONTAIN_SPECIAL_CHAR");
        }
        if (BlackWordUtil.isIncludeBlackString(newDouYouname)) {
            return LangService.getValue("DAO_YOU_NAME_CONTAIN_BLACK_CHAR");
        }
        Date lastEditNameTime = dyp.lastEditNameTime;
        if (lastEditNameTime != null) {
            Date editeNameAfterTime = DateUtil.getDateAfter(Const.DaoYou.DaoYouEditNameInterval.getValue());
            if (editeNameAfterTime.getTime() > System.currentTimeMillis()) {
                return LangService.getValue("DAO_YOU_EDITE_NAME_OFTEN");
            }
        }
        Map<String, String> daoYouNameMap = (DaoYouCenter.getInstance()).daoYouNameMap;
        String daoYouId = daoYouNameMap.get(newDouYouname);
        if (daoYouId != null && !daoYouId.equals(dyId)) {
            return LangService.getValue("DAO_YOU_NAME_EXSIT");
        }


        String oldName = dyp.name;
        daoYouNameMap.remove(oldName);
        daoYouNameMap.put(newDouYouname, dyId);
        dyp.name = newDouYouname;
        dyp.isEditedDyName = 1;
        dyp.updateTime = new Date();
        dyp.lastEditNameTime = new Date();
        addDaoYouMessage(Const.DaoYou.DaoYouMessageTypeSystem.getValue(), null, dyp, "DAO_YOU_EDIT_NAME_MESSAGE", new Object[]{adminPlayerName, newDouYouname});
        DaoYouDao.updateDaoYou(dyp);
        return "";
    }


    public String fastInviteDaoYouCreateTeam(WNPlayer player) {
        String playerId = player.getId();
        DaoYouMemberPO dyMemPo = DaoYouCenter.getInstance().getDaoYouMember(playerId);
        if (dyMemPo == null) {
            return LangService.getValue("DAO_YOU_NOT_HAS");
        }

        String dyId = dyMemPo.daoYouId;
        TeamData team = player.teamManager.getTeam();

        List<String> daoYouMemPlayerIds = DaoYouCenter.getInstance().getAllDaoYouMember(dyId);
        List<String> realInvitePlayer = new ArrayList<>();
        List<WNPlayer> inTeamPlayer = new ArrayList<>();
        for (String memPlayerId : daoYouMemPlayerIds) {
            if (!PlayerUtil.isOnline(memPlayerId) || memPlayerId.equals(playerId)) {
                continue;
            }
            if (TeamUtil.isInTeam(memPlayerId)) {
                inTeamPlayer.add(PlayerUtil.getOnlinePlayer(memPlayerId));
                continue;
            }
            realInvitePlayer.add(memPlayerId);
        }


        if (realInvitePlayer.size() > 0) {
            if (team == null) {
                String createResult = TeamUtil.createLocaleTeam(playerId, null);
                if (createResult == null) {
                    team = player.teamManager.getTeam();
                } else {
                    return createResult;
                }
            }
            for (String memPlayerId : realInvitePlayer) {
                team.invite(player, memPlayerId);
            }
        }
        for (WNPlayer p : inTeamPlayer) {
            if (team != null && TeamUtil.isInTeam(team.id, p.getId())) {
                continue;
            }
            PlayerUtil.sendSysMessageToPlayer(String.format(LangService.getValue("DAO_YOU_PLAYER_IN_TEAM"), new Object[]{p.getName()}), playerId);
        }


        player.taskManager.dealTaskEvent(Const.TaskType.JOIN_LEAGUE, 1);
        return "";
    }


    public String inviteDaoYou(WNPlayer player, String toPlayerId, boolean isFastInvite) {
        String fromPlayerId = player.getId();
        String fromPlayerName = player.getName();
        DaoYouMemberPO dyMemPo = DaoYouCenter.getInstance().getDaoYouMember(fromPlayerId);
        if (dyMemPo != null) {
            String dyId = dyMemPo.daoYouId;
            DaoYouPO dyPo = DaoYouCenter.getInstance().getDaoYou(dyId);
            if (dyPo != null && !dyPo.adminPlayerId.equals(fromPlayerId)) {
                return LangService.getValue("DAO_YOU_ONLY_ADMIN_CAN_DO_THIS");
            }
            List<String> daoYouMemPlayerIds = DaoYouCenter.getInstance().getAllDaoYouMember(dyId);
            if (daoYouMemPlayerIds != null && daoYouMemPlayerIds.size() == AllyConfiguration.getInstance().getConfigI("MaxPlayer")) {
                return LangService.getValue("DAO_YOU_MEMBER_COUNT_MAX");
            }
        }
        WNPlayer toPlayer = PlayerUtil.getOnlinePlayer(toPlayerId);
        if (toPlayer == null) {
            return LangService.getValue("DAO_YOU_PLAYER_OFFLINE");
        }

        if (!toPlayer.functionOpenManager.isOpen(Const.FunctionType.DaoYou.getValue())) {
            return LangService.getValue("DAO_YOU_NOT_OPEN_FRIEND");
        }

        if (this.inviteTime.containsKey(toPlayerId) && System.currentTimeMillis() - ((Long) this.inviteTime.get(toPlayerId)).longValue() < 60000L) {
            return LangService.getValue("DAO_YOU_INVITE_NOTICE");
        }

        DaoYouMemberPO toPlayerDaoYouMem = DaoYouCenter.getInstance().getDaoYouMember(toPlayerId);
        if (toPlayerDaoYouMem != null) {
            return LangService.getValue("DAO_YOU_PLAYER_IS_ANOTHER_DAO_YOU");
        }

        MessageData.MessageData_DaoYou md = new MessageData.MessageData_DaoYou();
        md.fromPlayerId = fromPlayerId;
        md.fromPlayerName = fromPlayerName;
        HashMap<String, String> strMsg = new HashMap<>();
        strMsg.put("playerName", PlayerUtil.getFullColorName(player));
        MessagePO opts = new MessagePO();
        opts.createPlayerId = fromPlayerId;
        opts.id = fromPlayerId;
        opts.strMsg = strMsg;
        opts.createTime = new Date();
        opts.messageType = Const.MESSAGE_TYPE.daoyou_invite.getValue();
        opts.data = (MessageData.MessageData_Data) md;
        MessageData message = new MessageData(opts);
        MessageHandler.OnMessageAddPush.Builder builder = MessageHandler.OnMessageAddPush.newBuilder();
        builder.setS2CCode(200);
        builder.setS2CData(message.toJson4PayLoad());
        toPlayer.receive("area.messagePush.onMessageAddPush", (GeneratedMessage) builder.build());
        if (!isFastInvite) {
            this.inviteTime.put(toPlayerId, Long.valueOf(System.currentTimeMillis()));
        }


        player.taskManager.dealTaskEvent(Const.TaskType.JOIN_LEAGUE, 1);
        return "";
    }


    public boolean onMessage(WNPlayer toPlayer, int operate, String fromPlayerId) {
        String toPlayerId = toPlayer.getId();

        if (this.inviteTime.containsKey(toPlayerId)) {
            this.inviteTime.remove(toPlayerId);
        }
        if (operate == Const.MESSAGE_OPERATE.TYPE_ACCEPT.getValue()) {
            if (!toPlayer.functionOpenManager.isOpen(Const.FunctionType.DaoYou.getValue())) {
                toPlayer.sendSysTip(LangService.getValue("DAO_YOU_NOT_OPEN"));
                return false;
            }

            DaoYouMemberPO daoYouMem = DaoYouCenter.getInstance().getDaoYouMember(toPlayerId);
            if (daoYouMem != null) {
                toPlayer.sendSysTip(LangService.getValue("DAO_YOU_ALREADY_IN_DAO_YOU"));
                return false;
            }

            DaoYouMemberPO fromDaoYouMem = DaoYouCenter.getInstance().getDaoYouMember(fromPlayerId);
            List<String> daoYouMemPlayerIds = new ArrayList<>();
            List<String> oldDaoYouMemIds = new ArrayList<>();
            if (fromDaoYouMem != null) {
                daoYouMemPlayerIds = DaoYouCenter.getInstance().getAllDaoYouMember(fromDaoYouMem.daoYouId);
                oldDaoYouMemIds.addAll(daoYouMemPlayerIds);
                if (daoYouMemPlayerIds.size() == AllyConfiguration.getInstance().getConfigI("MaxPlayer")) {
                    toPlayer.sendSysTip(LangService.getValue("DAO_YOU_MEMBER_COUNT_MAX"));
                    return false;
                }
            } else {
                oldDaoYouMemIds.add(fromPlayerId);
            }

            PlayerPO fromPlayerPo = PlayerUtil.getPlayerBaseData(fromPlayerId);
            if (fromPlayerPo == null) {
                return false;
            }
            PlayerPO toPlayerPo = toPlayer.getPlayer();
            boolean ret = processInviteDaoYou(fromPlayerPo, toPlayerPo);
            if (ret) {
                toPlayer.sendSysTip(LangService.getValue("DAO_YOU_JOIN_SUCCESS_TIPS"));

                DaoYouMemberPO toDaoYouMemPo = DaoYouCenter.getInstance().getDaoYouMember(toPlayerId);
                processDaoYouChange(oldDaoYouMemIds, toDaoYouMemPo, true);
                return true;
            }
            toPlayer.sendSysTip(LangService.getValue("DAO_YOU_JOIN_FAIL_TIPS"));
            return false;
        }

        toPlayer.sendSysTip(LangService.getValue("DAO_YOU_JOIN_FAIL_TIPS"));
        return false;
    }


    public boolean processInviteDaoYou(PlayerPO fromPlayer, PlayerPO toPlayer) {
        String fromPlayerId = fromPlayer.id;
        DaoYouMemberPO daoYouMemPo = DaoYouCenter.getInstance().getDaoYouMember(fromPlayerId);
        if (daoYouMemPo == null) {
            createDaoYou(fromPlayer, toPlayer);
            return true;
        }
        String dypId = daoYouMemPo.daoYouId;
        DaoYouPO dyp = DaoYouCenter.getInstance().getDaoYou(dypId);
        createDaoYouMember(dyp, toPlayer);
        return true;
    }


    public int calDaoYouFightPower(String dyId, List<String> daoYouMems) {
        int daoYouFightPower = 0;
        for (int i = 0; i < daoYouMems.size(); i++) {
            String dyMemPlayerId = daoYouMems.get(i);
            PlayerPO playerBase = PlayerUtil.getPlayerBaseData(dyMemPlayerId);
            if (playerBase != null) {
                int playerFightPower = playerBase.fightPower;
                daoYouFightPower += playerFightPower;
            }
        }
        return daoYouFightPower;
    }


    public DaoYouPO createDaoYou(PlayerPO fromPlayer, PlayerPO toPlayer) {
        DaoYouPO dyp = new DaoYouPO();
        dyp.id = UUID.randomUUID().toString();
        dyp.adminPlayerId = fromPlayer.id;
        dyp.name = getRandDaoYouName();
        dyp.notice = "";
        dyp.isEditedDyName = 0;
        dyp.createTime = new Date();
        dyp.updateTime = new Date();

        addDaoYouMessage(Const.DaoYou.DaoYouMessageTypeSystem.getValue(), null, dyp, "DAO_YOU_CREATE_NOTICE", new Object[]{fromPlayer.name, dyp.name});

        DaoYouCenter.getInstance().addDaoYou(dyp, false);
        createDaoYouMember(dyp, fromPlayer);
        createDaoYouMember(dyp, toPlayer);

        List<String> dyMemPlayerIds = DaoYouCenter.getInstance().getAllDaoYouMember(dyp.id);
        int daoYouFightPower = calDaoYouFightPower(dyp.id, dyMemPlayerIds);


        DaoYouRankHandler.getInstance().asyncUpdateRank(GWorld.__SERVER_ID, dyp.id, daoYouFightPower);
        return dyp;
    }


    public DaoYouMemberPO createDaoYouMember(DaoYouPO dyp, PlayerPO playerPO) {
        DaoYouMemberPO mem = new DaoYouMemberPO();
        mem.daoYouId = dyp.id;
        mem.playerId = playerPO.id;
        mem.totalSendRebate = 0;
        mem.totalReciveRebate = 0;
        mem.todayReciveRebate = 0;
        mem.joinTime = new Date();
        mem.createTime = new Date();
        mem.updateTime = new Date();
        DaoYouCenter.getInstance().addDaoYouMember(mem, false);

        addDaoYouMessage(Const.DaoYou.DaoYouMessageTypeSystem.getValue(), null, dyp, "DAO_YOU_JOIN_SUCCESS_NOTICE", new Object[]{playerPO.name});
        return mem;
    }


    public void addDaoYouMessage(int messageType, String playerName, DaoYouPO dyp, String content, Object... param) {
        DaoYouMessageVo dym = new DaoYouMessageVo();
        List<DaoYouMessageVo> messages = dyp.messages;
        if (messages == null) {
            messages = new ArrayList<>();
        }
        dym.type = messageType;
        if (messageType == Const.DaoYou.DaoYouMessageTypeSystem.getValue()) {
            dym.message = LangService.format(content, param);
        } else {
            dym.message = playerName + ":" + content;
        }
        while (messages.size() >= AllyConfiguration.getInstance().getConfigI("MaxMessage")) {
            messages.remove(0);
        }

        dym.time = new Date();
        dyp.updateTime = new Date();
        messages.add(dym);
        dyp.messages = messages;
    }


    public synchronized String getRandDaoYouName() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, 2017);
        calendar.set(2, 0);
        calendar.set(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        long time = (System.currentTimeMillis() - calendar.getTimeInMillis()) / 1000L;
        String suffix = (new Long(time)).toString();
        return "DY" + suffix;
    }


    public String kickDaoYou(String adminPlayerId, String adminPlayerName, String kickPlayerId) {
        String kickPlayerName = "";
        DaoYouMemberPO dyMemPo = DaoYouCenter.getInstance().getDaoYouMember(adminPlayerId);
        if (dyMemPo == null) {
            return LangService.getValue("DAO_YOU_NOT_HAS");
        }
        String dyId = dyMemPo.daoYouId;
        DaoYouPO dyp = DaoYouCenter.getInstance().getDaoYou(dyId);
        if (dyp == null) {
            return LangService.getValue("DAO_YOU_NOT_HAS");
        }
        if (!dyp.adminPlayerId.equals(adminPlayerId)) {
            return LangService.getValue("DAO_YOU_ONLY_ADMIN_CAN_DO_THIS");
        }
        List<String> daoYouMemIds = DaoYouCenter.getInstance().getAllDaoYouMember(dyId);
        if (daoYouMemIds == null) {
            return LangService.getValue("DAO_YOU_NOT_HAS");
        }

        DaoYouMemberPO kickMemPo = DaoYouCenter.getInstance().getDaoYouMember(kickPlayerId);
        int todayReciveRebate = kickMemPo.todayReciveRebate;

        List<String> oldDaoYouMemIds = new ArrayList<>();
        oldDaoYouMemIds.addAll(daoYouMemIds);
        DaoYouCenter.getInstance().removeDaoYouMember(kickPlayerId);

        if (PlayerUtil.isOnline(kickPlayerId)) {
            WNPlayer player = PlayerUtil.findPlayer(kickPlayerId);
            player.sendSysTip(LangService.format("DAO_YOU_KICKED_TIPS", new Object[]{dyp.name}));
            kickPlayerName = player.getName();
        } else {
            sendKickedMail(kickPlayerId, adminPlayerName);
            kickPlayerName = (PlayerUtil.getPlayerBaseData(kickPlayerId)).name;
        }


        processDaoYouChange(oldDaoYouMemIds, kickMemPo, false);

        dyp = DaoYouCenter.getInstance().getDaoYou(dyId);
        if (dyp != null) {
            if (todayReciveRebate == 0) {
                addDaoYouMessage(Const.DaoYou.DaoYouMessageTypeSystem.getValue(), null, dyp, "DAO_YOU_KICKED_NOTICE_NO_REBEATE", new Object[]{kickPlayerName, Integer.valueOf(todayReciveRebate)});
            } else {
                addDaoYouMessage(Const.DaoYou.DaoYouMessageTypeSystem.getValue(), null, dyp, "DAO_YOU_KICKED_NOTICE", new Object[]{kickPlayerName, Integer.valueOf(todayReciveRebate)});
            }
        }
        return "";
    }


    public String transferAdmin(WNPlayer oldAdminPlayer, String newAdminPlayerId) {
        String oldAdminPlayerId = oldAdminPlayer.getId();
        DaoYouMemberPO dyMemPo = DaoYouCenter.getInstance().getDaoYouMember(oldAdminPlayerId);
        if (dyMemPo == null) {
            return LangService.getValue("DAO_YOU_NOT_HAS");
        }
        String dyId = dyMemPo.daoYouId;
        DaoYouPO dyp = DaoYouCenter.getInstance().getDaoYou(dyId);
        if (dyp == null) {
            return LangService.getValue("DAO_YOU_NOT_HAS");
        }
        if (!dyp.adminPlayerId.equals(oldAdminPlayerId)) {
            return LangService.getValue("DAO_YOU_ONLY_ADMIN_CAN_DO_THIS");
        }
        List<String> daoYouMemIds = DaoYouCenter.getInstance().getAllDaoYouMember(dyId);
        if (daoYouMemIds == null) {
            return LangService.getValue("DAO_YOU_NOT_HAS");
        }
        if (!daoYouMemIds.contains(newAdminPlayerId)) {
            return LangService.getValue("DAO_YOU_NOT_CONTAIN_MEMBER");
        }

        dyp.adminPlayerId = newAdminPlayerId;
        DaoYouDao.updateDaoYou(dyp);
        PlayerPO playerPo = PlayerUtil.getPlayerBaseData(newAdminPlayerId);
        addDaoYouMessage(Const.DaoYou.DaoYouMessageTypeSystem.getValue(), null, dyp, "DAO_YOU_TRANSFER_ADMIN", new Object[]{oldAdminPlayer.getName(), playerPo.name});
        return "";
    }


    public String leaveMessage(WNPlayer player, String content) {
        DaoYouMemberPO dyMemPo = DaoYouCenter.getInstance().getDaoYouMember(player.getId());
        if (dyMemPo == null) {
            return LangService.getValue("DAO_YOU_NOT_HAS");
        }
        String dyId = dyMemPo.daoYouId;
        DaoYouPO dyp = DaoYouCenter.getInstance().getDaoYou(dyId);
        if (dyp == null) {
            return LangService.getValue("DAO_YOU_NOT_HAS");
        }
        if (content.equals("")) {
            return LangService.getValue("DAO_YOU_LEAVE_MESSAGE_EMPTY");
        }
        if (content.length() > Const.DaoYou.DaoYouLeaveMessageMaxLength.getValue()) {
            return LangService.getValue("DAO_YOU_LEAVE_MESSAGE_TOO_LANG");
        }

        content = BlackWordUtil.replaceBlackString(content);
        addDaoYouMessage(Const.DaoYou.DaoYouMessageTypeLeave.getValue(), player.getName(), dyp, content, new Object[0]);
        DaoYouDao.updateDaoYou(dyp);
        return "";
    }


    public String editNotice(String playerId, String notice) {
        DaoYouMemberPO dyMemPo = DaoYouCenter.getInstance().getDaoYouMember(playerId);
        if (dyMemPo == null) {
            return LangService.getValue("DAO_YOU_NOT_HAS");
        }
        String dyId = dyMemPo.daoYouId;
        DaoYouPO dyp = DaoYouCenter.getInstance().getDaoYou(dyId);
        if (dyp == null) {
            return LangService.getValue("DAO_YOU_NOT_HAS");
        }
        if (notice.equals("")) {
            return LangService.getValue("DAO_YOU_NOTICE_EMPTY");
        }
        if (notice.length() > Const.DaoYou.DaoYouNoticeMaxLength.getValue()) {
            return LangService.getValue("DAO_YOU_NOTICE_TOO_LANG");
        }
        notice = BlackWordUtil.replaceBlackString(notice);
        dyp.notice = notice;
        dyp.updateTime = new Date();
        DaoYouDao.updateDaoYou(dyp);
        return "";
    }


    public String quitDaoYou(WNPlayer player) {
        String playerId = player.getId();
        String playerName = player.getName();
        DaoYouMemberPO dyMemPo = DaoYouCenter.getInstance().getDaoYouMember(playerId);
        if (dyMemPo == null) {
            return LangService.getValue("DAO_YOU_NOT_HAS");
        }
        String dyId = dyMemPo.daoYouId;
        DaoYouPO dyp = DaoYouCenter.getInstance().getDaoYou(dyId);
        if (dyp == null) {
            return LangService.getValue("DAO_YOU_NOT_HAS");
        }
        List<String> daoYouMemIds = DaoYouCenter.getInstance().getAllDaoYouMember(dyId);
        List<String> oldDaoYouMemIds = new ArrayList<>();
        oldDaoYouMemIds.addAll(daoYouMemIds);
        DaoYouCenter.getInstance().removeDaoYouMember(playerId);
        String adminPlayerId = dyp.id;
        if (PlayerUtil.isOnline(adminPlayerId)) {
            WNPlayer adminPlayer = PlayerUtil.findPlayer(adminPlayerId);
            adminPlayer.sendSysTip(LangService.format("DAO_YOU_LEAVE", new Object[]{playerName}));
        }


        processDaoYouChange(daoYouMemIds, dyMemPo, false);

        dyp = DaoYouCenter.getInstance().getDaoYou(dyId);
        int todayReciveRebate = dyMemPo.todayReciveRebate;
        if (dyp != null) {
            if (todayReciveRebate == 0) {
                addDaoYouMessage(Const.DaoYou.DaoYouMessageTypeSystem.getValue(), null, dyp, "DAO_YOU_LEAVE_NO_REBEATE", new Object[]{playerName, Integer.valueOf(todayReciveRebate)});
            } else {
                addDaoYouMessage(Const.DaoYou.DaoYouMessageTypeSystem.getValue(), null, dyp, "DAO_YOU_LEAVE", new Object[]{playerName, Integer.valueOf(todayReciveRebate)});
            }
        }
        return "";
    }


    public boolean sendKickedMail(String toPlayerId, String adminPlayerName) {
        MailSysData mailData = new MailSysData("Ally_kick");
        mailData.replace = new HashMap<>();
        mailData.replace.put("AllyName", adminPlayerName);
        mailData.attachments = new ArrayList();
        MailData.Attachment item1 = new MailData.Attachment();
        mailData.attachments.add(item1);
        return MailUtil.getInstance().sendMailToOnePlayer(toPlayerId, (MailData) mailData, Const.GOODS_CHANGE_TYPE.DAOYOU);
    }


    public void getAllRebate(WNPlayer player, DaoYouHandler.DaoYouRebateResponse.Builder daoYouRebateResponse) {
        String playerId = player.getId();
        String playerName = player.getName();
        DaoYouMemberPO dyMemPo = DaoYouCenter.getInstance().getDaoYouMember(playerId);
        if (dyMemPo == null) {
            daoYouRebateResponse.setS2CCode(500);
            daoYouRebateResponse.setS2CMsg(LangService.getValue("DAO_YOU_NOT_HAS"));
            return;
        }
        String dyId = dyMemPo.daoYouId;
        DaoYouPO dyp = DaoYouCenter.getInstance().getDaoYou(dyId);
        if (dyp == null) {
            daoYouRebateResponse.setS2CCode(500);
            daoYouRebateResponse.setS2CMsg(LangService.getValue("DAO_YOU_NOT_HAS"));

            return;
        }
        List<String> daoYouMemPlayerIds = DaoYouCenter.getInstance().getAllDaoYouMember(dyId);
        if (daoYouMemPlayerIds == null) {
            daoYouRebateResponse.setS2CCode(500);
            daoYouRebateResponse.setS2CMsg(LangService.getValue("DAO_YOU_NOT_HAS"));
            return;
        }
        List<DaoYouHandler.DaoYouRebateInfo> list = new ArrayList<>();
        DaoYouMemberPO selfDyMemPo = null;
        for (String id : daoYouMemPlayerIds) {
            DaoYouMemberPO tempDyMemPo = DaoYouCenter.getInstance().getDaoYouMember(id);
            if (!id.equals(playerId)) {
                PlayerPO pp = PlayerUtil.getPlayerBaseData(id);
                if (tempDyMemPo != null && pp != null) {
                    DaoYouHandler.DaoYouRebateInfo.Builder builder = DaoYouHandler.DaoYouRebateInfo.newBuilder();
                    builder.setPlayerName(pp.name);
                    builder.setTotalSendRebate(tempDyMemPo.totalSendRebate);
                    Map<String, Integer> map = tempDyMemPo.todaySendRebate;
                    if (map == null) {
                        map = new HashMap<>();
                    }
                    int todaySendRebateNumber = 0;
                    List<DaoYouHandler.DaoYouMemRebaeReciveInfo> list1 = new ArrayList<>();
                    if (map.size() > 0) {
                        for (Map.Entry<String, Integer> everySend : map.entrySet()) {
                            DaoYouHandler.DaoYouMemRebaeReciveInfo.Builder dymr = DaoYouHandler.DaoYouMemRebaeReciveInfo.newBuilder();
                            String name = everySend.getKey();
                            Integer reciveNumber = everySend.getValue();
                            dymr.setPlayerName(name);
                            dymr.setReciveNumber(reciveNumber.intValue());
                            list1.add(dymr.build());
                            todaySendRebateNumber += reciveNumber.intValue();
                        }
                    }
                    builder.setTodaySendRebate(todaySendRebateNumber);
                    builder.addAllMemRebaeReciveInfo(list1);
                    list.add(builder.build());
                }
                continue;
            }
            selfDyMemPo = tempDyMemPo;
        }

        DaoYouHandler.DaoYouRebateInfo.Builder r = DaoYouHandler.DaoYouRebateInfo.newBuilder();
        r.setPlayerName(playerName);
        r.setTotalSendRebate(selfDyMemPo.totalSendRebate);
        Map<String, Integer> todaySendRebateMap = selfDyMemPo.todaySendRebate;
        if (todaySendRebateMap == null) {
            todaySendRebateMap = new HashMap<>();
        }
        int todaySendRebate = 0;
        List<DaoYouHandler.DaoYouMemRebaeReciveInfo> everyMemRecives = new ArrayList<>();
        for (Map.Entry<String, Integer> everySend : todaySendRebateMap.entrySet()) {
            DaoYouHandler.DaoYouMemRebaeReciveInfo.Builder dymr = DaoYouHandler.DaoYouMemRebaeReciveInfo.newBuilder();
            String name = everySend.getKey();
            Integer reciveNumber = everySend.getValue();
            dymr.setPlayerName(name);
            dymr.setReciveNumber(reciveNumber.intValue());
            everyMemRecives.add(dymr.build());
            todaySendRebate += ((Integer) everySend.getValue()).intValue();
        }
        r.setTodaySendRebate(todaySendRebate);
        r.addAllMemRebaeReciveInfo(everyMemRecives);
        list.add(0, r.build());

        daoYouRebateResponse.setS2CCode(200);
        daoYouRebateResponse.setSelfTotalReciveRebate(selfDyMemPo.totalReciveRebate);
        daoYouRebateResponse.setSelfTodayReciveRebate(selfDyMemPo.todayReciveRebate);
        daoYouRebateResponse.addAllRi(list);
    }


    public void calDaoYouRebate(WNPlayer player, int rebateDiamond) {
        String playerId = player.getId();
        String playerName = player.getName();
        DaoYouMemberPO dyMemPo = DaoYouCenter.getInstance().getDaoYouMember(playerId);
        if (dyMemPo == null) {
            return;
        }

        String dyId = dyMemPo.daoYouId;
        DaoYouPO dyp = DaoYouCenter.getInstance().getDaoYou(dyId);
        if (dyp == null) {
            return;
        }

        List<String> daoYouMemPlayerIds = DaoYouCenter.getInstance().getAllDaoYouMember(dyId);
        if (daoYouMemPlayerIds == null) {
            return;
        }

        Map<String, Integer> todaySendRebate = dyMemPo.todaySendRebate;
        if (todaySendRebate == null) {
            todaySendRebate = new HashMap<>();
        }
        int sumSendRebate = 0;
        for (Integer v : todaySendRebate.values()) {
            sumSendRebate += v.intValue();
        }

        int max = AllyConfiguration.getInstance().getConfigI("MaxFeeBack");

        if (sumSendRebate >= max) {
            return;
        }
        rebateDiamond = Math.min(max - sumSendRebate, rebateDiamond);

        List<DaoYouMemberPO> ranPlayer = new ArrayList<>();
        for (int i = 0; i < daoYouMemPlayerIds.size(); i++) {
            DaoYouMemberPO tempDyMemPo = DaoYouCenter.getInstance().getDaoYouMember(daoYouMemPlayerIds.get(i));
            ranPlayer.add(tempDyMemPo);
        }

        int len = ranPlayer.size();
        if (len > rebateDiamond) {
            int leftValue = rebateDiamond;
            for (int j = 0; j < len; j++) {
                DaoYouMemberPO tempDyMemPo = ranPlayer.get(j);
                PlayerPO po = PlayerUtil.getPlayerBaseData(tempDyMemPo.playerId);
                if (po != null) {
                    Integer old = todaySendRebate.get(po.name);
                    if (old == null) {
                        old = Integer.valueOf(0);
                    }
                    if (leftValue > 0) {
                        int randomV = Utils.random(1, leftValue);
                        tempDyMemPo.todayReciveRebate += randomV;
                        leftValue -= randomV;
                        todaySendRebate.put(po.name, Integer.valueOf(randomV + old.intValue()));
                    } else {
                        tempDyMemPo.todayReciveRebate += 0;
                    }
                    DaoYouDao.updateDaoYouMember(tempDyMemPo);
                }
            }
        } else if (len == rebateDiamond) {
            for (int j = 0; j < len; j++) {
                DaoYouMemberPO tempDyMemPo = ranPlayer.get(j);
                tempDyMemPo.todayReciveRebate++;
                DaoYouDao.updateDaoYouMember(tempDyMemPo);
                PlayerPO po = PlayerUtil.getPlayerBaseData(tempDyMemPo.playerId);
                if (po != null) {


                    Integer old = todaySendRebate.get(po.name);
                    if (old == null) {
                        old = Integer.valueOf(0);
                    }
                    todaySendRebate.put(po.name, Integer.valueOf(1 + old.intValue()));
                }
            }
        } else {
            int leftValue = rebateDiamond - len;
            for (int j = 0; j < len; j++) {
                DaoYouMemberPO tempDyMemPo = ranPlayer.get(j);
                PlayerPO po = PlayerUtil.getPlayerBaseData(tempDyMemPo.playerId);
                if (po != null) {


                    if (leftValue > 0) {
                        int vaLeft = Utils.random(1, leftValue);
                        tempDyMemPo.todayReciveRebate += 1 + vaLeft;
                        leftValue -= vaLeft;
                        leftValue = (leftValue > 0) ? leftValue : 0;

                        Integer old = todaySendRebate.get(po.name);
                        if (old == null) {
                            old = Integer.valueOf(0);
                        }
                        todaySendRebate.put(po.name, Integer.valueOf(old.intValue() + 1 + vaLeft));
                    } else {
                        tempDyMemPo.todayReciveRebate++;
                        Integer old = todaySendRebate.get(po.name);
                        if (old == null) {
                            old = Integer.valueOf(0);
                        }
                        todaySendRebate.put(po.name, Integer.valueOf(1 + old.intValue()));
                    }
                    DaoYouDao.updateDaoYouMember(tempDyMemPo);
                    if (j == len - 1 &&
                            leftValue > 0) {
                        DaoYouMemberPO firstDyMemPo = ranPlayer.get(0);
                        firstDyMemPo.todayReciveRebate += leftValue;
                        DaoYouDao.updateDaoYouMember(firstDyMemPo);
                        po = PlayerUtil.getPlayerBaseData(firstDyMemPo.playerId);
                        Integer old = todaySendRebate.get(po.name);
                        if (old == null) {
                            old = Integer.valueOf(0);
                        }
                        todaySendRebate.put(po.name, Integer.valueOf(leftValue + old.intValue()));
                    }
                }
            }
        }

        dyMemPo.todaySendRebate = todaySendRebate;
        dyMemPo.updateTime = new Date();
        DaoYouDao.updateDaoYouMember(dyMemPo);
        addDaoYouMessage(Const.DaoYou.DaoYouMessageTypeSystem.getValue(), null, dyp, "DAO_YOU_COST_DIAMOND", new Object[]{playerName});
        DaoYouDao.updateDaoYou(dyp);
    }


    public void sendRebateMail(String toPlayerId, int rebateCount) {
        MailSysData mailData = new MailSysData("Ally_rebate");
        Map<String, String> replace = new HashMap<>();
        replace.put("price", String.valueOf(rebateCount));
        mailData.replace = replace;
        mailData.attachments = new ArrayList();
        MailData.Attachment item = new MailData.Attachment();
        item.itemCode = "cash";
        item.itemNum = rebateCount;
        mailData.attachments.add(item);
        MailUtil.getInstance().sendMailToOnePlayer(toPlayerId, (MailData) mailData, Const.GOODS_CHANGE_TYPE.DAOYOU);
    }


    public List<String> getDaoYouMemPlayerId(String playerId) {
        DaoYouMemberPO memberPo = DaoYouCenter.getInstance().getDaoYouMember(playerId);
        if (memberPo == null) {
            return null;
        }

        String daoYouId = memberPo.daoYouId;
        List<String> memPlayerId = DaoYouCenter.getInstance().getAllDaoYouMember(daoYouId);
        return memPlayerId;
    }


    public void sendDaoYou(WNPlayer player, PomeloPush chatPush) {
        DaoYouMemberPO dymp = DaoYouCenter.getInstance().getDaoYouMember(player.getId());
        List<String> playerIds = DaoYouCenter.getInstance().getAllDaoYouMember(dymp.daoYouId);
        for (String playerId : playerIds) {
            WNPlayer daoyou = PlayerUtil.getOnlinePlayer(playerId);
            if (daoyou != null) {
                daoyou.receive((Message) chatPush);
            }
        }
    }


    public DaoYouPO getDaoYou(String playerId) {
        DaoYouMemberPO member = DaoYouCenter.getInstance().getDaoYouMember(playerId);
        if (member == null) {
            return null;
        }
        DaoYouPO daoYou = DaoYouCenter.getInstance().getDaoYou(member.daoYouId);
        return daoYou;
    }


    private void processDaoYouChange(List<String> daoYouMemPlayerId, DaoYouMemberPO changeMemPo, boolean isJoin) {
        String daoYouId = changeMemPo.daoYouId;
        String changePlayerId = changeMemPo.playerId;
        PlayerPO changePlayerPo = PlayerUtil.getPlayerBaseData(changePlayerId);
        if (isJoin) {
            if (daoYouMemPlayerId == null) {
                return;
            }
            for (int i = 0; i < daoYouMemPlayerId.size(); i++) {
                String tempPlayerId = daoYouMemPlayerId.get(i);
                WNPlayer player = PlayerUtil.findPlayer(tempPlayerId);
                if (player != null) {


                    player.sendSysTip(LangService.format("DAO_YOU_JOIN_SUCCESS_NOTICE", new Object[]{changePlayerPo.name}));
                    player.btlDataManager.onDaoYouChange();
                    player.refreshBattlerServerEffect(false);
                    player.calFightPower();
                    player.pushDynamicData("fightPower", Integer.valueOf(player.player.fightPower));
                }
            }
            WNPlayer changePlayer = PlayerUtil.findPlayer(changePlayerId);
            if (changePlayer != null) {
                changePlayer.btlDataManager.onDaoYouChange();
                changePlayer.refreshBattlerServerEffect(false);
                changePlayer.calFightPower();
                changePlayer.pushDynamicData("fightPower", Integer.valueOf(changePlayer.player.fightPower));
            }
        } else {
            int everyMemRecive = 0;
            int todayReciveRebate = changeMemPo.todayReciveRebate;
            int leftMemCount = daoYouMemPlayerId.size() - 1;
            everyMemRecive = todayReciveRebate / leftMemCount;
            for (int i = 0; i < daoYouMemPlayerId.size(); i++) {
                String tempPlayerId = daoYouMemPlayerId.get(i);
                WNPlayer player = PlayerUtil.findPlayer(tempPlayerId);
                if (player != null) {


                    if (!tempPlayerId.equals(changePlayerId)) {
                        String sendMessage = LangService.format("DAO_YOU_LEAVE_NO_REBEATE", new Object[]{changePlayerPo.name});
                        DaoYouMemberPO tempDaoYouMemberPo = DaoYouCenter.getInstance().getDaoYouMember(tempPlayerId);
                        if (tempDaoYouMemberPo != null) {
                            if (changeMemPo.todayReciveRebate != 0) {
                                sendMessage = LangService.format("DAO_YOU_LEAVE", new Object[]{changePlayerPo.name, Integer.valueOf(changeMemPo.todayReciveRebate)});
                            }
                            tempDaoYouMemberPo.todayReciveRebate += everyMemRecive;
                            DaoYouDao.updateDaoYouMember(tempDaoYouMemberPo);
                        }
                        player.sendSysTip(sendMessage);
                    }
                    player.btlDataManager.onDaoYouChange();
                    player.refreshBattlerServerEffect(false);
                    player.calFightPower();
                    player.pushDynamicData("fightPower", Integer.valueOf(player.player.fightPower));
                }
            }
        }
        DaoYouPO dyp = DaoYouCenter.getInstance().getDaoYou(daoYouId);
        if (dyp != null) {
            dyp.fightPower = calDaoYouFightPower(daoYouId, DaoYouCenter.getInstance().getAllDaoYouMember(dyp.id));
            DaoYouDao.updateDaoYou(dyp);
        }
    }
}


