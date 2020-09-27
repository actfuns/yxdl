package com.wanniu.game.friend;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GEntity;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.DateUtil;
import com.wanniu.game.area.Area;
import com.wanniu.game.common.CommonUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.daoyou.DaoYouService;
import com.wanniu.game.data.SShopCO;
import com.wanniu.game.data.SocialFriendCO;
import com.wanniu.game.functionOpen.FunctionOpenUtil;
import com.wanniu.game.guild.GuildUtil;
import com.wanniu.game.message.MessageData;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.GuildMemberPO;
import com.wanniu.game.poes.GuildPO;
import com.wanniu.game.poes.PlayerAttachPO;
import com.wanniu.game.poes.PlayerFriendsPO;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.game.poes.SevenGoalPO;
import com.wanniu.game.sevengoal.SevenGoalManager;
import com.wanniu.game.social.SocialFriendProps;
import com.wanniu.game.sysSet.SysSetFlag;
import com.wanniu.redis.PlayerPOManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import pomelo.Common;
import pomelo.area.FriendHandler;
import pomelo.chat.ChatHandler;


public class FriendManager {
    private static BlackListComparator blackListComparator = new BlackListComparator();
    private static FriendMessageComparator friendMessageComparator = new FriendMessageComparator();
    private static FriendInfoComparator friendInfoComparator = new FriendInfoComparator();
    private static FriendComparator friendComparator = new FriendComparator();

    private String playerId;

    private PlayerPO player;
    public PlayerFriendsPO po;

    public static class ApplyFriendData {
        public String id;
        public long time;

        public ApplyFriendData() {
        }

        public ApplyFriendData(String id, long time) {
            this.id = id;
            this.time = time;
        }
    }


    public static class RecordInfo {
        public String friendId;
        public Date concernTime;
    }

    public FriendManager() {
    }

    public FriendManager(String playerId, PlayerFriendsPO data) {
        setPlayerId(playerId);
        this.po = data;
        this.player = PlayerUtil.getPlayerBaseData(playerId);

        if (this.po == null) {
            this.po = new PlayerFriendsPO();
            PlayerPOManager.put(ConstsTR.player_friendsTR, playerId, (GEntity) this.po);
        }
    }

    public List<FriendHandler.PlayerInfo> getAllFriends() {
        List<FriendHandler.PlayerInfo> friends = new ArrayList<>();
        for (Map.Entry<String, FriendData> node : (Iterable<Map.Entry<String, FriendData>>) this.po.friends.entrySet()) {
            FriendData data = node.getValue();
            FriendHandler.PlayerInfo friend = data.friendToJson4PayLoad((RecordInfo) this.po.recordInfos.get(data.friendId));
            if (friend != null) {
                friends.add(friend);
            }
        }

        friends.sort(friendComparator);
        return friends;
    }

    public final String friendApply(String toPlayerId, WNPlayer player) {
        boolean bOpen = PlayerUtil.isPlayerOpenedFunction(this.playerId, Const.FunctionType.FRIEND.getValue());

        if (!bOpen) {
            return FunctionOpenUtil.getTipsByName(Const.FunctionType.FRIEND.getValue());
        }
        bOpen = PlayerUtil.isPlayerOpenedFunction(toPlayerId, Const.FunctionType.FRIEND.getValue());
        if (!bOpen) {
            return LangService.getValue("FUNC_SET_TARGET_NOT_OPEN");
        }
        if (this.po.blackList.containsKey(toPlayerId)) {
            return LangService.getValue("FRIEND_TARGET_IN_BLACK_LIST");
        }

        PlayerPO toPlayer = PlayerUtil.getPlayerBaseData(toPlayerId);
        if (toPlayer == null) {
            return LangService.getValue("CROSS_SERVER_AUTH_LIMIT_ADDFRIEND");
        }


        PlayerAttachPO playerAttachPO = (PlayerAttachPO) PlayerPOManager.findPO(ConstsTR.playerAttachTR, toPlayerId, PlayerAttachPO.class);
        if (null != playerAttachPO && (
                playerAttachPO.sysSet & SysSetFlag.recvAddFriendSet.getValue()) == 0) {
            return LangService.getValue("FRIEND_FORBIDDEN_APPLY");
        }


        if (hasApplyFriend(toPlayerId)) {
            return LangService.getValue("FRIEND_HAVE_ALREADY_APPLY");
        }

        FriendManager toPlayerFriendManager = FriendsCenter.getInstance().getFriendsMgr(toPlayerId);
        if (toPlayerFriendManager.isInBlackList(this.playerId)) {
            return LangService.getValue("FRIEND_IN_BLACK_LIST");
        }

        int num = applyFriendLength();
        if (num >= GlobalConfig.Social_InviteFriendMax) {
            return LangService.getValue("FRIEND_APPLY_FULL");
        }


        if (toPlayerId.equals(this.playerId)) {
            return LangService.getValue("FRIEND_TARGET PLAYER_YOUSELF");
        }
        int friendNumLimit = GlobalConfig.Social_MaxFriendNum;

        if (this.po.friends.size() >= friendNumLimit) {
            return LangService.getValue("FRIEND_LIST_FULL");
        }
        if (this.po.friends.containsKey(toPlayerId)) {
            return LangService.getValue("FRIEND_HAVE_BEEN_FRIENDS");
        }
        if (toPlayerFriendManager.po.friends.size() >= friendNumLimit) {
            return LangService.getValue("FRIEND_TARGET_LIST_FULL");
        }

        if (isInFriendMessage(toPlayerId)) {
            return LangService.getValue("FRIEND_HAVE_IN_YOU_APPLY");
        }

        addApplyFriend(toPlayerId);
        addFriendMessageToFriend(player, toPlayerId);
        return null;
    }


    public final TreeMap<String, Object> friendAllApply(List<String> toPlayerIds, WNPlayer player) {
        TreeMap<String, Object> rtData = new TreeMap<>();
        rtData.put("result", Boolean.valueOf(true));
        rtData.put("info", LangService.getValue("FRIEND_SEND_MESSAGE"));

        boolean bOpen = PlayerUtil.isPlayerOpenedFunction(this.playerId, Const.FunctionType.FRIEND.getValue());

        if (!bOpen) {
            rtData.put("result", Boolean.valueOf(false));
            rtData.put("info", FunctionOpenUtil.getTipsByName(Const.FunctionType.FRIEND.getValue()));
            return rtData;
        }

        int friendNumLimit = GlobalConfig.Social_MaxFriendNum;

        if (this.po.friends.size() >= friendNumLimit) {
            rtData.put("result", Boolean.valueOf(false));
            rtData.put("info", LangService.getValue("FRIEND_LIST_FULL"));
            return rtData;
        }

        int num = applyFriendLength();
        if (num >= GlobalConfig.Social_InviteFriendMax) {
            rtData.put("result", Boolean.valueOf(false));
            rtData.put("info", LangService.getValue("FRIEND_APPLY_FULL"));
            return rtData;
        }

        boolean bNeedApply = false;
        bOpen = false;

        for (String playerId : toPlayerIds) {
            boolean result = PlayerUtil.isPlayerOpenedFunction(playerId, Const.FunctionType.FRIEND.getValue());
            if (result) {
                bOpen = true;
                if (!hasApplyFriend(playerId)) {
                    bNeedApply = true;

                    break;
                }
            }
        }
        if (!bOpen) {
            rtData.put("result", Boolean.valueOf(false));
            rtData.put("info", LangService.getValue("FUNC_SET_TARGET_NOT_OPEN"));
            return rtData;
        }

        if (!bNeedApply) {
            rtData.put("result", Boolean.valueOf(false));
            rtData.put("info", LangService.getValue("FRIEND_HAVE_ALREADY_APPLY"));
            return rtData;
        }

        for (String playerId : toPlayerIds) {
            friendApply(playerId, player);
        }
        return rtData;
    }

    public final void addFriendMessageToFriend(WNPlayer player, String friendId) {
        FriendManager friendMgr = FriendsCenter.getInstance().getFriendsMgr(friendId);
        friendMgr.addFriendMessage(this.playerId, Const.FriendMessageType.TYPE_INVITE.getValue());

        Map<String, String> strMsg = new HashMap<>(1);
        strMsg.put("playerName", player.getName());
        MessageData message = MessageUtil.createMessage(Const.MESSAGE_TYPE.friend_invite.getValue(), this.playerId, null, strMsg);
        if (player.messageManager.addSendedMessage(message)) {
            MessageUtil.sendMessageToPlayer(message, friendId);
        }
    }


    public TreeMap<String, Object> friendAllAgreeApply(List<String> requestIds, WNPlayer player) {
        TreeMap<String, Object> rtData = new TreeMap<>();
        rtData.put("result", Boolean.valueOf(true));

        if (this.po.friends.size() >= GlobalConfig.Social_MaxFriendNum) {
            rtData.put("result", Boolean.valueOf(false));
            rtData.put("info", LangService.getValue("FRIEND_LIST_FULL"));
            return rtData;
        }
        for (String s : requestIds) {
            friendAgreeApply(s);
        }
        return rtData;
    }


    public Map<String, Object> friendAgreeApply(String requestId) {
        Map<String, Object> rtData = new HashMap<>();
        rtData.put("result", Boolean.valueOf(true));

        if (requestId.equals(this.playerId)) {
            rtData.put("result", Boolean.valueOf(false));
            rtData.put("info", LangService.getValue("FRIEND_TARGET"));
            return rtData;
        }

        if (this.po.friends.size() >= GlobalConfig.Social_MaxFriendNum) {
            removeFriendMessage(requestId, Const.FriendMessageType.TYPE_INVITE.getValue());
            rtData.put("result", Boolean.valueOf(false));
            rtData.put("info", LangService.getValue("FRIEND_LIST_FULL"));
            return rtData;
        }

        if (this.po.friends.containsKey(requestId)) {
            removeFriendMessage(requestId, Const.FriendMessageType.TYPE_INVITE.getValue());
            rtData.put("result", Boolean.valueOf(false));
            rtData.put("info", LangService.getValue("FRIEND_HAVE_BEEN_FRIENDS"));
            return rtData;
        }

        FriendManager friendMgr = FriendsCenter.getInstance().getFriendsMgr(requestId);
        if (friendMgr.po.friends.size() >= GlobalConfig.Social_MaxFriendNum) {
            removeFriendMessage(requestId, Const.FriendMessageType.TYPE_INVITE.getValue());
            rtData.put("result", Boolean.valueOf(false));
            rtData.put("info", LangService.getValue("FRIEND_TARGET_LIST_FULL"));
            return rtData;
        }

        if (friendMgr.po.blackList.containsKey(this.playerId)) {
            rtData.put("result", Boolean.valueOf(false));
            rtData.put("info", LangService.getValue("FRIEND_IN_BLACK_LIST"));
            return rtData;
        }


        addFriend(requestId);
        removeApplyFriend(requestId);
        removeFriendMessage(requestId, Const.FriendMessageType.TYPE_INVITE.getValue());


        friendMgr.addFriend(this.playerId);
        friendMgr.removeFriendMessage(this.playerId, Const.FriendMessageType.TYPE_INVITE.getValue());
        friendMgr.removeApplyFriend(this.player.id);


        WNPlayer player = PlayerUtil.findPlayer(this.playerId);
        String msg = LangService.getValue("FRIEND_INVITATION_SUCCESS");
        if (null != player) {
            msg = msg.replace("{friendName}", player.getName());
        }

        Out.debug(new Object[]{"fromPlayer.sendSysMessage ", msg});
        PlayerUtil.sendSysMessageToPlayer(msg, requestId, null);

        player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.ADD_FRIEND, new Object[0]);
        WNPlayer friend = PlayerUtil.getOnlinePlayer(requestId);
        if (friend != null) {
            friend.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.ADD_FRIEND, new Object[0]);
        } else {

            SevenGoalPO sevenGoalPO = (SevenGoalPO) PlayerPOManager.findPO(ConstsTR.SevenGoal, requestId, SevenGoalPO.class);
            sevenGoalPO.processAddFriend();
        }
        return rtData;
    }


    public final void addFriend(String requestId) {
        if (this.playerId.equals(requestId)) {
            return;
        }


        if (this.po.friends.containsKey(requestId)) {
            return;
        }

        FriendData friend = new FriendData();
        friend.friendId = requestId;
        friend.friendLv = 0;
        friend.createTimeStamp = new Date();
        friend.addFriendLvTime = new Date(0L);
        friend.addFriendLvToday = 0;

        Out.debug(new Object[]{"add a new Friend: ", friend});
        this.po.friends.put(friend.friendId, friend);
    }


    public final FriendHandler.Position getFriendPosition(String friendId) {
        FriendHandler.Position.Builder currentPos = FriendHandler.Position.newBuilder();
        WNPlayer friendPlayer = PlayerUtil.findPlayer(friendId);
        if (null != friendPlayer) {
            Area area = friendPlayer.getArea();
            if (null != area) {
                currentPos.setAreaName(area.getSceneName());
                currentPos.setAreaId(area.areaId);
            }
        } else {
            currentPos.setAreaName("");
            currentPos.setTargetX(0);
            currentPos.setTargetY(0);
            currentPos.setAreaId(0);
        }

        return currentPos.build();
    }

    public final boolean isFriend(String friendId) {
        for (Map.Entry<String, FriendData> node : (Iterable<Map.Entry<String, FriendData>>) this.po.friends.entrySet()) {
            if (((FriendData) node.getValue()).friendId.equals(friendId)) {
                return true;
            }
        }
        return false;
    }


    public Set<String> getAllFriendId() {
        return this.po.friends.keySet();
    }

    public final List<String> getAllOnlineFriendId() {
        ArrayList<String> data = new ArrayList<>();
        for (Map.Entry<String, FriendData> node : (Iterable<Map.Entry<String, FriendData>>) this.po.friends.entrySet()) {
            if (PlayerUtil.isOnline(node.getKey())) {
                data.add(node.getKey());
            }
        }
        return data;
    }

    public final int getFriendsNum() {
        return this.po.friends.size();
    }


    public final ArrayList<FriendHandler.PlayerInfo> addFriendInfo(int selfLevel) {
        ArrayList<FriendHandler.PlayerInfo> friendInfos = new ArrayList<>();
        ArrayList<FriendHandler.PlayerInfo> otherfriendInfos = new ArrayList<>();

        int recommendNumLimit = GlobalConfig.Social_RecommendNum;
        int levelRange = GlobalConfig.Social_LevelRange;

        List<GPlayer> players = new ArrayList<>();
        for (GPlayer player : PlayerUtil.getAllOnlinePlayer()) {
            boolean isOpen = PlayerUtil.isPlayerOpenedFunction(player.getId(), Const.FunctionType.FRIEND.getValue());
            if (isOpen) {
                players.add(player);
            }
        }
        Random r = new Random();
        while (players.size() > 0) {
            int idx = r.nextInt(players.size());
            WNPlayer friendPlayer = (WNPlayer) players.get(idx);
            if (null == friendPlayer) {
                players.remove(idx);

                continue;
            }
            String playerId = friendPlayer.getId();
            if (null == friendPlayer || playerId.equals(this.playerId) || this.po.friends
                    .containsKey(playerId) || this.po.blackList
                    .containsKey(playerId) ||
                    hasApplyFriend(playerId) ||
                    isInFriendMessage(playerId)) {

                players.remove(idx);

                continue;
            }
            if (friendPlayer.getLogicServerId() != this.player.logicServerId) {
                players.remove(idx);

                continue;
            }
            FriendHandler.PlayerInfo.Builder friendInfo = FriendHandler.PlayerInfo.newBuilder();
            friendInfo.setId(playerId);
            friendInfo.setGuildId(friendPlayer.guildManager.getGuildId());
            friendInfo.setGuildName(friendPlayer.guildManager.getGuildName());
            friendInfo.setName(friendPlayer.getName());
            friendInfo.setLevel(friendPlayer.getLevel());
            friendInfo.setPro(friendPlayer.getPro());
            friendInfo.setStageLevel(friendPlayer.player.upLevel);
            friendInfo.setVip(0);
            friendInfo.setFightPower(CommonUtil.calFightPower(friendPlayer.btlDataManager.allInflus));

            List<Common.Avatar> avatars = PlayerUtil.getBattlerServerAvatar(playerId);
            friendInfo.addAllAvatars(avatars);
            if (Math.abs(friendInfo.getLevel() - selfLevel) < levelRange) {
                friendInfos.add(friendInfo.build());
                if (friendInfos.size() >= recommendNumLimit) {
                    players.remove(idx);

                    break;
                }
            } else if (otherfriendInfos.size() < recommendNumLimit) {
                otherfriendInfos.add(friendInfo.build());
            }

            players.remove(idx);
        }

        if (friendInfos.size() < recommendNumLimit) {
            while (otherfriendInfos.size() > 0) {
                int idx = r.nextInt(otherfriendInfos.size());
                friendInfos.add(otherfriendInfos.get(idx));
                if (friendInfos.size() >= recommendNumLimit) {
                    otherfriendInfos.remove(idx);
                    break;
                }
                otherfriendInfos.remove(idx);
            }
        }
        friendInfos.sort(friendInfoComparator);
        return friendInfos;
    }

    public FriendHandler.PlayerInfo.Builder getPlayerBaseData(String playerId) {
        FriendHandler.PlayerInfo.Builder datas = FriendHandler.PlayerInfo.newBuilder();
        FriendHandler.Position.Builder currentPos = FriendHandler.Position.newBuilder();
        boolean isOnline = PlayerUtil.isOnline(playerId);
        datas.setIsOnline(isOnline ? 1 : 0);

        if (isOnline) {
            WNPlayer friendPlayer = PlayerUtil.findPlayer(playerId);
            if (null == friendPlayer) {
                return datas;
            }

            datas.setGuildId(friendPlayer.guildManager.getGuildId());
            datas.setGuildName(friendPlayer.guildManager.getGuildName());

            datas.setName(friendPlayer.getName());
            datas.setLevel(friendPlayer.getLevel());
            datas.setPro(friendPlayer.getPro());
            datas.setStageLevel(friendPlayer.player.upLevel);
            datas.setVip(0);
            datas.setFightPower(CommonUtil.calFightPower(friendPlayer.btlDataManager.allInflus));

            if (DaoYouService.getInstance().getDaoYou(friendPlayer.getId()) != null) {
                datas.setHasAlly(1);
            }
            Area area = friendPlayer.getArea();
            if (area != null) {
                currentPos.setAreaName(area.getSceneName());
                currentPos.setAreaId(area.areaId);
            }
        } else {
            PlayerPO friendPlayer = PlayerUtil.getPlayerBaseData(playerId);

            if (null == friendPlayer) {
                return datas;
            }

            datas.setName(friendPlayer.name);
            datas.setLevel(friendPlayer.level);
            datas.setPro(friendPlayer.pro);
            datas.setStageLevel(friendPlayer.upLevel);
            datas.setVip(0);
            datas.setGuildId("");
            datas.setGuildName("");

            GuildMemberPO myInfo = GuildUtil.getGuildMember(playerId);
            if (null != myInfo) {
                GuildPO myGuild = GuildUtil.getGuild(myInfo.guildId);
                if (null != myGuild) {
                    datas.setGuildId(myGuild.id);
                    datas.setGuildName(myGuild.name);
                }
            }

            datas.setFightPower(friendPlayer.fightPower);
        }

        datas.setId(playerId);
        datas.setCurrentPos(currentPos.build());
        return datas;
    }


    public FriendHandler.QueryPlayerNameResponse.Builder queryPlayerName(String strName) {
        FriendHandler.QueryPlayerNameResponse.Builder data = FriendHandler.QueryPlayerNameResponse.newBuilder();

        int playerNum = 0;

        int recommendNumLimit = GlobalConfig.Social_RecommendNum;
        ArrayList<FriendHandler.PlayerInfo> list = new ArrayList<>();
        Collection<GPlayer> players = PlayerUtil.getAllOnlinePlayer();
        for (GPlayer player : players) {
            WNPlayer friendPlayer = (WNPlayer) player;

            if (this.playerId.equals(friendPlayer.getId())) {
                continue;
            }
            FriendHandler.PlayerInfo.Builder playerName = FriendHandler.PlayerInfo.newBuilder();
            playerName.setId(friendPlayer.getId());
            playerName.setGuildId(friendPlayer.guildManager.getGuildId());
            playerName.setGuildName(friendPlayer.guildManager.getGuildName());
            playerName.setName(friendPlayer.getName());
            playerName.setLevel(friendPlayer.getLevel());
            playerName.setPro(friendPlayer.getPro());
            playerName.setStageLevel(friendPlayer.player.upLevel);
            playerName.setVip(0);
            playerName.setFightPower(CommonUtil.calFightPower(friendPlayer.btlDataManager.allInflus));
            List<Common.Avatar> avatars = PlayerUtil.getBattlerServerAvatar(friendPlayer.getId());
            playerName.addAllAvatars(avatars);
            if (playerName.getName().equals(strName)) {
                list.add(playerName.build());
                playerNum++;
            }
            if (playerNum >= recommendNumLimit)
                break;
        }
        if (list.size() == 0) {
            data.setS2CMsg(LangService.getValue("FRIEND_FIND_NONE"));
            data.setS2CCode(500);
        } else {
            data.setS2CCode(200);
        }
        data.addAllData(list);
        return data;
    }

    public final void onPlayerEnter(Date logoutTime) {
        Date nowTime = new Date();
        int days = (int) Math.floor(((nowTime.getTime() - logoutTime.getTime()) / 86400000L));

        int decreaseFriendLv = days * GlobalConfig.Social_FavorReduce;

        for (Map.Entry<String, FriendData> node : (Iterable<Map.Entry<String, FriendData>>) this.po.friends.entrySet()) {
            FriendData data = node.getValue();
            if (days > 0) {
                data.friendLv -= decreaseFriendLv;

                if (data.friendLv < 0) {
                    data.friendLv = 0;
                }
            }

            String strData = MessageUtil.getPlayerNameColor(this.player.name, this.player.pro);

            String msg = LangService.getValue("FRIEND_ONLINE");

            msg = msg.replace("{playerName}", strData);
            WNPlayer player = PlayerUtil.getOnlinePlayer(this.playerId);
            if (null != player) {
                MessageUtil.sendSysChat(player, msg, Const.TipsType.NORMAL);
            }
        }
    }


    public final void onPlayerOffline() {
        WNPlayer selfPlayer = PlayerUtil.getOnlinePlayer(this.playerId);
        if (null == selfPlayer) {
            return;
        }
        for (Map.Entry<String, FriendData> node : (Iterable<Map.Entry<String, FriendData>>) this.po.friends.entrySet()) {
            String strData = MessageUtil.getPlayerNameColor(this.player.name, this.player.pro);
            String msg = LangService.getValue("FRIEND_OFFLINE");
            msg = msg.replace("{playerName}", strData);
            ChatHandler.OnChatPush.Builder chatMsg = MessageUtil.createChatMsg(selfPlayer, msg, Const.CHAT_SCOPE.SYSTEM, Const.TipsType.NORMAL);
            WNPlayer player = PlayerUtil.findPlayer(node.getKey());
            if (null != player) {
                player.receive("chat.chatPush.onChatPush", (GeneratedMessage) chatMsg.build());
            }
        }
    }

    public final TreeMap<String, Object> concernFriend(String friendId, WNPlayer player) {
        TreeMap<String, Object> rtData = new TreeMap<>();
        rtData.put("result", Boolean.valueOf(true));
        rtData.put("info", "");
        if (!this.po.friends.containsKey(friendId)) {
            rtData.put("result", Boolean.valueOf(false));
            rtData.put("info", LangService.getValue("FRIEND_TARGET_HAVE_DELETE"));
            return rtData;
        }
        if (!PlayerUtil.isOnline(friendId)) {
            rtData.put("result", Boolean.valueOf(false));
            rtData.put("info", LangService.getValue("PLAYER_NOT_ONLINE"));
            return rtData;
        }

        if (!this.po.recordInfos.containsKey(friendId)) {
            RecordInfo recordInfo = new RecordInfo();
            recordInfo.friendId = friendId;
            recordInfo.concernTime = new Date(0L);
            this.po.recordInfos.put(friendId, recordInfo);
        }
        Date concernTime = ((RecordInfo) this.po.recordInfos.get(friendId)).concernTime;

        Date currDate = new Date();
        if (DateUtil.isSameDay(concernTime, currDate)) {
            rtData.put("result", Boolean.valueOf(false));
            rtData.put("info", LangService.getValue("FRIEND_ALREAD_CONCERNED"));
            return rtData;
        }
        RecordInfo info = (RecordInfo) this.po.recordInfos.get(friendId);
        info.concernTime = currDate;
        this.po.recordInfos.put(friendId, info);

        SocialFriendCO socialFriendProp = SocialFriendProps.findByMSocialAction(1);

        addFriendLv(friendId, socialFriendProp.favorNum);

        socialFriendProp = SocialFriendProps.findByMSocialAction(2);

        int friendLv = socialFriendProp.favorNum;

        FriendManager friendMgr = FriendsCenter.getInstance().getFriendsMgr(friendId);
        friendMgr.addFriendMessage(this.playerId, Const.FriendMessageType.TYPE_CONCERN.getValue());
        friendMgr.addFriendShipPoint();
        friendMgr.addFriendLv(this.playerId, friendLv);

        WNPlayer selfPlayer = PlayerUtil.getOnlinePlayer(this.playerId);

        if (friendConcernTimesToday() == GlobalConfig.Social_FocusNum) {

            selfPlayer.initAndCalAllInflu(null);
            selfPlayer.pushAndRefreshEffect(false);
        }

        player.getPlayerTasks().dealTaskEvent(Const.TaskType.CONCERN_FRIEND, 1);

        return rtData;
    }


    public final void addFriendLv(String friendId, int addFriendLv) {
        if (!this.po.friends.containsKey(friendId)) {
            return;
        }
        FriendData friendData = (FriendData) this.po.friends.get(friendId);
        if (addFriendLv < 0) {
            friendData.friendLv += addFriendLv;

            if (friendData.friendLv < 0) {
                friendData.friendLv = 0;
            }
            this.po.friends.put(friendId, friendData);

            return;
        }

        Date currDate = new Date();
        if (!DateUtil.isSameDay(friendData.addFriendLvTime, currDate)) {
            friendData.addFriendLvToday = 0;
            friendData.addFriendLvTime = currDate;
        }

        int favorNumMax = GlobalConfig.Social_FavorNumMax;
        int favorNumDailyMax = GlobalConfig.Social_FavorNumDailyMax;

        if (friendData.friendLv >= favorNumMax || friendData.addFriendLvToday >= favorNumDailyMax) {
            return;
        }

        friendData.friendLv += addFriendLv;
        friendData.addFriendLvToday += addFriendLv;

        if (friendData.friendLv > favorNumMax) {
            friendData.addFriendLvToday -= friendData.friendLv - favorNumMax;

            friendData.friendLv = favorNumMax;
        }

        if (friendData.addFriendLvToday > favorNumDailyMax) {
            friendData.friendLv -= friendData.addFriendLvToday - favorNumDailyMax;

            friendData.addFriendLvToday = favorNumDailyMax;
        }
        this.po.friends.put(friendId, friendData);
    }


    public final int friendConcernTimesToday() {
        int concernTimes = 0;

        Date currDate = new Date();
        for (Map.Entry<String, FriendData> node : (Iterable<Map.Entry<String, FriendData>>) this.po.friends.entrySet()) {
            String id = node.getKey();
            if (!this.po.recordInfos.containsKey(id)) {
                continue;
            }
            RecordInfo recordInfo = (RecordInfo) this.po.recordInfos.get(id);
            if (DateUtil.isSameDay(recordInfo.concernTime, currDate)) {
                concernTimes++;
            }
        }
        return concernTimes;
    }


    public final Map<String, Integer> calAllInfluence() {
        Map<String, Integer> influs = new HashMap<>();

        if (friendConcernTimesToday() >= GlobalConfig.Social_FocusNum) {

            String values = GlobalConfig.Social_FocusBuff;
            String[] nodeValues = values.split(";");
            for (int i = 0; i < nodeValues.length; i++) {
                String[] buffValue = nodeValues[i].split(",");
                int value = 0;
                if (influs.containsKey(buffValue[0])) {
                    value = ((Integer) influs.get(buffValue[0])).intValue();
                }
                value += Integer.parseInt(buffValue[1]);
                influs.put(buffValue[0], Integer.valueOf(value));
            }
        }
        return influs;
    }

    public final void addFriendShipPoint() {
        Date currDate = new Date();
        if (!DateUtil.isSameDay(this.po.addPointTime, currDate)) {
            this.po.addPointToday = 0;
            this.po.addPointTime = currDate;
        }

        int friendshipNum = (SocialFriendProps.findByMSocialAction(2)).friendshipNum;
        int friendshipNumDailyMax = GlobalConfig.Social_FriendshipNumDailyMax;
        WNPlayer selfPlayer = PlayerUtil.getOnlinePlayer(this.playerId);
        if (this.po.addPointToday < friendshipNumDailyMax - friendshipNum) {
            this.po.addPointToday += friendshipNum;
            selfPlayer.baseDataManager.addFriendly(friendshipNum);
            selfPlayer.pushDynamicData("friendly", Integer.valueOf(selfPlayer.player.friendly));
        } else if (this.po.addPointToday < friendshipNumDailyMax) {
            selfPlayer.baseDataManager.addFriendly(friendshipNumDailyMax - this.po.addPointToday);
            selfPlayer.pushDynamicData("friendly", Integer.valueOf(selfPlayer.player.friendly));

            this.po.addPointToday = friendshipNumDailyMax;
        }
    }


    public final int applyFriendLength() {
        int number = 0;
        Date now = new Date();
        for (Map.Entry<String, ApplyFriendData> node : (Iterable<Map.Entry<String, ApplyFriendData>>) this.po.applyFriendIds.entrySet()) {
            ApplyFriendData data = node.getValue();
            if (now.getTime() - data.time < 86400000L) {
                number++;
            }
        }
        return number;
    }

    public final boolean hasApplyFriend(String friendId) {
        ApplyFriendData data = (ApplyFriendData) this.po.applyFriendIds.get(friendId);
        if (data == null) {
            return false;
        }
        Date now = new Date();
        if (now.getTime() - data.time < 86400000L) {
            return true;
        }
        return false;
    }

    public final void addApplyFriend(String friendId) {
        Date now = new Date();
        ApplyFriendData data = (ApplyFriendData) this.po.applyFriendIds.get(friendId);
        if (data != null) {
            if (now.getTime() - data.time < 86400000L) {
                return;
            }
            data.time = now.getTime();
        } else {

            data = new ApplyFriendData(friendId, now.getTime());
            this.po.applyFriendIds.put(friendId, data);
        }
    }


    public final void removeApplyFriend(String friendId) {
        ApplyFriendData data = (ApplyFriendData) this.po.applyFriendIds.get(friendId);
        if (data != null) {
            this.po.applyFriendIds.remove(friendId);
        }
    }


    public final FriendHandler.FriendMessageListResponse.Builder friendMessageList() {
        FriendHandler.FriendMessageListResponse.Builder data = FriendHandler.FriendMessageListResponse.newBuilder();

        ArrayList<FriendHandler.PlayerInfo> friendMessageInfos = new ArrayList<>();

        Out.debug(new Object[]{"friendMessageList :", this.po.friendMessage});

        for (MessageDate message : this.po.friendMessage) {
            FriendHandler.PlayerInfo.Builder info = getPlayerBaseData(message.playerId);
            info.setType(message.type);
            info.setId(message.playerId);
            info.setTime(JSON.toJSONString(message.time));
            info.setAddFriendShipPoint((SocialFriendProps.findByMSocialAction(2)).friendshipNum);

            friendMessageInfos.add(info.build());
        }
        friendMessageInfos.sort(friendMessageComparator);
        data.addAllFriendMessageInfos(friendMessageInfos);
        data.setMessageNumMax(GlobalConfig.Social_MaxFriendMessageNum);
        data.setFriendlyCode("friendly");
        return data;
    }

    public final void deleteFriendMessage() {
        this.po.friendMessage.clear();
    }


    public final List<FriendHandler.PlayerInfo> getAllBlackList() {
        List<FriendHandler.PlayerInfo> blackList = new ArrayList<>();
        for (Map.Entry<String, BlackActor> node : (Iterable<Map.Entry<String, BlackActor>>) this.po.blackList.entrySet()) {
            String id = node.getKey();
            FriendHandler.PlayerInfo.Builder info = getPlayerBaseData(id);
            info.setId(id);
            info.setCreateTime(JSON.toJSONString(((BlackActor) node.getValue()).createTime));
            blackList.add(info.build());
        }
        blackList.sort(blackListComparator);
        return blackList;
    }

    public final boolean deleteBlackListById(String blackListId) {
        if (!this.po.blackList.containsKey(blackListId)) {
            return false;
        }
        this.po.blackList.remove(blackListId);


        return true;
    }

    public final void deleteBlackList() {
        this.po.blackList.clear();
    }


    public final String addBlackList(String blackListId) {
        boolean bOpen = PlayerUtil.isPlayerOpenedFunction(this.playerId, Const.FunctionType.FRIEND.getValue());

        if (!bOpen) {
            return FunctionOpenUtil.getTipsByName(Const.FunctionType.FRIEND.getValue());
        }

        bOpen = PlayerUtil.isPlayerOpenedFunction(blackListId, Const.FunctionType.FRIEND.getValue());

        if (!bOpen) {
            return LangService.getValue("FUNC_SET_TARGET_NOT_OPEN");
        }

        if (this.po.blackList.size() >= GlobalConfig.Social_MaxBlacklistNum) {
            return LangService.getValue("FRIEND_BLACK_LIST_FULL");
        }

        if (this.po.blackList.containsKey(blackListId)) {
            return LangService.getValue("FRIEND_HAVE_IN_BLACK_LIST");
        }

        BlackActor blackList = new BlackActor();
        blackList.id = blackListId;
        blackList.createTime = new Date();
        this.po.blackList.put(blackListId, blackList);


        deleteFriend(blackListId);
        return null;
    }

    public final boolean isInBlackList(String playerId) {
        return this.po.blackList.containsKey(playerId);
    }

    public final void killOtherOnce(String playerId) {
        int FavorNum = (SocialFriendProps.findByMSocialAction(3)).favorNum;
        addFriendLv(playerId, FavorNum);
    }

    public final void beKilledOnce(String playerId) {
        int FavorNum = (SocialFriendProps.findByMSocialAction(4)).favorNum;
        addFriendLv(playerId, FavorNum);
    }

    public final FriendHandler.GetSocialInfoResponse.Builder getSocialInfo(String playerId) {
        FriendHandler.GetSocialInfoResponse.Builder data = FriendHandler.GetSocialInfoResponse.newBuilder();
        Date currDate = new Date();
        if (!DateUtil.isSameDay(this.po.addPointTime, currDate)) {
            data.setAddPointToday(0);
        } else {
            data.setAddPointToday(this.po.addPointToday);
        }
        data.setFriendShipPoint(this.player.friendly);
        data.setAddPointTodayMax(GlobalConfig.Social_FriendshipNumDailyMax);
        return data;
    }


    public final TreeMap<String, Object> friendRefuseApply(String requestId, WNPlayer player) {
        TreeMap<String, Object> rtData = new TreeMap<>();
        rtData.put("result", Boolean.valueOf(true));

        removeFriendMessage(requestId, Const.FriendMessageType.TYPE_INVITE.getValue());
        removeApplyFriend(requestId);

        FriendManager friendMgr = FriendsCenter.getInstance().getFriendsMgr(requestId);
        friendMgr.removeFriendMessage(this.playerId, Const.FriendMessageType.TYPE_INVITE.getValue());
        friendMgr.removeApplyFriend(this.playerId);

        String msg = LangService.getValue("FRIEND_INVITATION_REDUSE");
        msg = msg.replace("{inviterName}", player.getName());
        PlayerUtil.sendSysMessageToPlayer(msg, requestId, null);
        return rtData;
    }

    public final ArrayList<FriendHandler.FriendShopCondition> getConditions(SShopCO prop) {
        ArrayList<FriendHandler.FriendShopCondition> data = new ArrayList<>();
        FriendHandler.FriendShopCondition.Builder level = FriendHandler.FriendShopCondition.newBuilder();
        level.setType(1);
        level.setNumber(prop.levelReq);
        data.add(level.build());
        FriendHandler.FriendShopCondition.Builder up = FriendHandler.FriendShopCondition.newBuilder();
        up.setType(2);
        up.setNumber(prop.upReq);
        data.add(up.build());
        FriendHandler.FriendShopCondition.Builder vip = FriendHandler.FriendShopCondition.newBuilder();
        vip.setType(3);
        vip.setNumber(prop.vipReq);
        data.add(vip.build());
        FriendHandler.FriendShopCondition.Builder race = FriendHandler.FriendShopCondition.newBuilder();
        race.setType(4);
        race.setNumber(prop.raceReq);
        data.add(race.build());
        FriendHandler.FriendShopCondition.Builder raceClass = FriendHandler.FriendShopCondition.newBuilder();
        raceClass.setType(5);
        raceClass.setNumber(prop.raceClass);
        data.add(raceClass.build());
        return data;
    }


    public final String getConditionStatus(SShopCO prop) {
        // Byte code:
        //   0: aload_0
        //   1: aload_1
        //   2: invokevirtual getConditions : (Lcom/wanniu/game/data/SShopCO;)Ljava/util/ArrayList;
        //   5: astore_2
        //   6: iconst_0
        //   7: istore_3
        //   8: iload_3
        //   9: aload_2
        //   10: invokevirtual size : ()I
        //   13: if_icmpge -> 122
        //   16: aload_2
        //   17: iload_3
        //   18: invokevirtual get : (I)Ljava/lang/Object;
        //   21: checkcast pomelo/area/FriendHandler$FriendShopCondition
        //   24: astore #4
        //   26: aload #4
        //   28: invokevirtual getType : ()I
        //   31: istore #5
        //   33: aload #4
        //   35: invokevirtual getNumber : ()I
        //   38: istore #6
        //   40: iload #5
        //   42: iconst_1
        //   43: if_icmpne -> 65
        //   46: aload_0
        //   47: getfield player : Lcom/wanniu/game/poes/PlayerPO;
        //   50: getfield level : I
        //   53: iload #6
        //   55: if_icmpge -> 65
        //   58: ldc_w 'EXCHANGE_LEVEL_NOT_REACH'
        //   61: invokestatic getValue : (Ljava/lang/String;)Ljava/lang/String;
        //   64: areturn
        //   65: iload #5
        //   67: iconst_2
        //   68: if_icmpne -> 90
        //   71: aload_0
        //   72: getfield player : Lcom/wanniu/game/poes/PlayerPO;
        //   75: getfield upLevel : I
        //   78: iload #6
        //   80: if_icmpge -> 90
        //   83: ldc_w 'EXCHANGE_STAGE_NOT_REACH'
        //   86: invokestatic getValue : (Ljava/lang/String;)Ljava/lang/String;
        //   89: areturn
        //   90: iload #5
        //   92: iconst_4
        //   93: if_icmpne -> 96
        //   96: iload #5
        //   98: iconst_5
        //   99: if_icmpne -> 102
        //   102: iload #5
        //   104: bipush #6
        //   106: if_icmpne -> 109
        //   109: iload #5
        //   111: bipush #7
        //   113: if_icmpne -> 116
        //   116: iinc #3, 1
        //   119: goto -> 8
        //   122: aconst_null
        //   123: areturn
        // Line number table:
        //   Java source line number -> byte code offset
        //   #1057	-> 0
        //   #1058	-> 6
        //   #1059	-> 16
        //   #1060	-> 26
        //   #1061	-> 33
        //   #1062	-> 40
        //   #1063	-> 58
        //   #1065	-> 65
        //   #1066	-> 83
        //   #1071	-> 90
        //   #1072	-> 96
        //   #1073	-> 102
        //   #1074	-> 109
        //   #1058	-> 116
        //   #1076	-> 122
        // Local variable table:
        //   start	length	slot	name	descriptor
        //   26	90	4	condition	Lpomelo/area/FriendHandler$FriendShopCondition;
        //   33	83	5	type	I
        //   40	76	6	number	I
        //   8	114	3	i	I
        //   0	124	0	this	Lcom/wanniu/game/friend/FriendManager;
        //   0	124	1	prop	Lcom/wanniu/game/data/SShopCO;
        //   6	118	2	conditions	Ljava/util/ArrayList;
        // Local variable type table:
        //   start	length	slot	name	signature
        //   6	118	2	conditions	Ljava/util/ArrayList<Lpomelo/area/FriendHandler$FriendShopCondition;>;
    }


    public void removeFriendMessage(String playerId, int type) {
        for (MessageDate messageData : this.po.friendMessage) {
            if (messageData.type == type && messageData.playerId.equals(playerId)) {
                this.po.friendMessage.remove(messageData);
                return;
            }
        }
    }


    public void addFriendMessage(String playerId, int type) {
        if (this.po.friendMessage.size() >= GlobalConfig.Social_MaxFriendMessageNum) {
            this.po.friendMessage.remove(this.po.friendMessage.size() - 1);
        }

        MessageDate messageData = new MessageDate();
        messageData.type = type;
        messageData.playerId = playerId;
        messageData.time = new Date();
        this.po.friendMessage.add(messageData);
    }


    public boolean isInFriendMessage(String playerId) {
        boolean isIn = false;
        for (int i = 0; i < this.po.friendMessage.size(); i++) {
            MessageDate elem = this.po.friendMessage.get(i);
            if (elem.playerId.equals(playerId)) {
                isIn = true;
                break;
            }
        }
        return isIn;
    }


    public void removeFriend(String id) {
        if (this.po.friends.containsKey(id)) {
            this.po.friends.remove(id);
        }
    }


    public JSONObject deleteFriend(String friendId) {
        JSONObject ret = new JSONObject();

        if (!this.po.friends.containsKey(friendId)) {
            ret.put("code", Integer.valueOf(500));
            ret.put("des", LangService.getValue("FRIEND_NOT_EXIST"));
            return ret;
        }

        removeFriend(friendId);

        FriendManager friendMgr = FriendsCenter.getInstance().getFriendsMgr(friendId);
        friendMgr.removeFriend(this.playerId);
        ret.put("code", Integer.valueOf(200));
        ret.put("des", LangService.getValue("FRIEND_DEL_SUCESS"));
        return ret;
    }

    public String getPlayerId() {
        return this.playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    private static class BlackListComparator
            implements Comparator<FriendHandler.PlayerInfo> {
        public int compare(FriendHandler.PlayerInfo data1, FriendHandler.PlayerInfo data2) {
            return data1.getCreateTime().compareTo(data2.getCreateTime());
        }

        private BlackListComparator() {
        }
    }

    private static class FriendMessageComparator implements Comparator<FriendHandler.PlayerInfo> {
        private FriendMessageComparator() {
        }

        public int compare(FriendHandler.PlayerInfo data1, FriendHandler.PlayerInfo data2) {
            return data1.getTime().compareTo(data2.getTime());
        }
    }


    private static class FriendInfoComparator implements Comparator<FriendHandler.PlayerInfo> {
        private FriendInfoComparator() {
        }

        public int compare(FriendHandler.PlayerInfo data1, FriendHandler.PlayerInfo data2) {
            return (data1.getLevel() < data2.getLevel()) ? 1 : -1;
        }
    }

    private static class FriendComparator implements Comparator<FriendHandler.PlayerInfo> {
        private FriendComparator() {
        }

        public int compare(FriendHandler.PlayerInfo data1, FriendHandler.PlayerInfo data2) {
            if (data1.getIsOnline() != data2.getIsOnline()) {
                return (data1.getIsOnline() < data2.getIsOnline()) ? 1 : -1;
            }
            if (data1.getFriendLv() != data2.getFriendLv()) {
                return (data1.getFriendLv() < data2.getFriendLv()) ? 1 : -1;
            }
            if (data1.getVip() != data2.getVip()) {
                return (data1.getVip() < data2.getVip()) ? 1 : -1;
            }

            if (data1.getStageLevel() != data2.getStageLevel()) {
                return (data1.getStageLevel() < data2.getStageLevel()) ? 1 : -1;
            }

            if (data1.getLevel() == data2.getLevel()) {
                return 0;
            }

            return (data1.getLevel() <= data2.getLevel()) ? 1 : -1;
        }
    }
}


