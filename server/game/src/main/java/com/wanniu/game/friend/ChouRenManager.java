package com.wanniu.game.friend;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GEntity;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.area.Area;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.functionOpen.FunctionOpenUtil;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PlayerChouRenPO;
import com.wanniu.game.social.SocialFriendProps;
import com.wanniu.redis.PlayerPOManager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import pomelo.area.FriendHandler;


public class ChouRenManager {
    private WNPlayer player;
    public PlayerChouRenPO data;
    private int chouRensNum;

    public ChouRenManager(WNPlayer player, PlayerChouRenPO data) {
        this.player = player;
        this.data = data;
        if (this.data == null) {
            this.data = new PlayerChouRenPO();
            this.data.chouRens = new HashMap<>();
            PlayerPOManager.put(ConstsTR.player_chourenTR, player.getId(), (GEntity) this.data);
        }
        this.chouRensNum = this.data.chouRens.size();
    }

    public FriendHandler.PlayerInfo chouRenToJson4PayLoad(ChouRenData chouRen) {
        String chouRenId = chouRen.chouRenId;
        Out.debug(new Object[]{"payload仇人数据ID: ", chouRen.chouRenId});

        FriendHandler.PlayerInfo.Builder data = this.player.getFriendManager().getPlayerBaseData(chouRenId);
        data.setId(chouRenId);
        data.setIcon(1);
        data.setChouHenPoint(chouRen.chouHenPoint);
        data.setCreateTimeStamp(chouRen.createTimeStamp.toString());
        data.setIsOnline(PlayerUtil.isOnline(chouRenId) ? 1 : 0);

        FriendHandler.Position.Builder currentPos = FriendHandler.Position.newBuilder();

        if (data.getIsOnline() > 0) {
            WNPlayer chouRenPlayer = PlayerUtil.findPlayer(chouRenId);
            Area area = chouRenPlayer.getArea();
            if (null != area) {
                currentPos.setAreaName(area.getSceneName());
                currentPos.setAreaId(area.areaId);
            }
        }
        data.setCurrentPos(currentPos.build());

        Out.debug(new Object[]{"payload仇人数据: ", data});
        return data.build();
    }

    public List<FriendHandler.PlayerInfo> getAllChouRens() {
        List<FriendHandler.PlayerInfo> chouRens = new ArrayList<>();
        for (Map.Entry<String, ChouRenData> node : (Iterable<Map.Entry<String, ChouRenData>>) this.data.chouRens.entrySet()) {
            FriendHandler.PlayerInfo chouRen = chouRenToJson4PayLoad(node.getValue());
            chouRens.add(chouRen);
        }
        chouRens.sort(new Comparator<FriendHandler.PlayerInfo>() {
            public int compare(FriendHandler.PlayerInfo data1, FriendHandler.PlayerInfo data2) {
                if (data1.getIsOnline() != data2.getIsOnline()) {
                    return (data1.getIsOnline() < data2.getIsOnline()) ? 1 : -1;
                }

                if (data1.getChouHenPoint() != data2.getChouHenPoint()) {
                    return (data1.getChouHenPoint() < data2.getChouHenPoint()) ? 1 : -1;
                }

                if (data1.getStageLevel() != data2.getStageLevel()) {
                    return (data1.getStageLevel() < data2.getStageLevel()) ? 1 : -1;
                }

                return Integer.compare(data2.getLevel(), data1.getLevel());
            }
        });
        return chouRens;
    }

    public TreeMap<String, Object> add2ChouRenList(String chouRenId) {
        TreeMap<String, Object> rtData = new TreeMap<>();
        rtData.put("result", Boolean.valueOf(true));
        rtData.put("info", LangService.getValue("FRIEND_ADD_SUCCESS"));
        boolean bOpen = PlayerUtil.isPlayerOpenedFunction(this.player.getId(), Const.FunctionType.FRIEND.getValue());
        if (!bOpen) {
            rtData.put("result", Boolean.valueOf(false));
            rtData.put("info", FunctionOpenUtil.getTipsByName(Const.FunctionType.FRIEND.getValue()));
            return rtData;
        }
        bOpen = PlayerUtil.isPlayerOpenedFunction(chouRenId, Const.FunctionType.FRIEND.getValue());
        if (!bOpen) {
            rtData.put("result", Boolean.valueOf(false));
            rtData.put("info", LangService.getValue("FUNC_SET_TARGET_NOT_OPEN"));
            return rtData;
        }
        if (this.data.chouRens.containsKey(chouRenId)) {
            rtData.put("result", Boolean.valueOf(false));
            rtData.put("info", LangService.getValue("FRIEND_HAVE_IN_CHOUREN_LIST"));
            return rtData;
        }
        if (this.chouRensNum >= GlobalConfig.Social_MaxEnemyNum) {
            rtData.put("result", Boolean.valueOf(false));
            rtData.put("info", LangService.getValue("FRIEND_CHOUREN_LIST_FULL"));
            return rtData;
        }
        ChouRenData data = new ChouRenData();
        data.chouRenId = chouRenId;
        data.chouHenPoint = 0;
        data.createTimeStamp = new Date();
        this.data.chouRens.put(chouRenId, data);
        this.chouRensNum++;
        Out.debug(new Object[]{"添加了一个仇人，id： ", chouRenId});

        return rtData;
    }

    public boolean deleteChouRenById(String id) {
        if (this.data.chouRens.containsKey(id)) {
            this.data.chouRens.remove(id);
            this.chouRensNum--;
            Out.debug(new Object[]{"删除一个仇人，id：", id});

            return true;
        }
        Out.debug(new Object[]{"删除一个仇人失败，id：", id});
        return false;
    }


    public boolean addChouHenPoint(String chouRenId, int point) {
        if (!this.data.chouRens.containsKey(chouRenId)) {
            return false;
        }
        int killNumMax = GlobalConfig.Social_KillNumMax;
        int killNumMin = GlobalConfig.Social_KillNumMin;

        if (point >= killNumMax || point <= killNumMin) {
            return false;
        }
        ChouRenData data = (ChouRenData) this.data.chouRens.get(chouRenId);
        data.chouHenPoint += point;
        Out.debug(new Object[]{"增加仇恨值1点"});

        return true;
    }

    public void killOtherOnce(String playerId) {
        addChouHenPoint(playerId, (SocialFriendProps.findByMSocialAction(3)).killNum);
    }


    public void beKilledOnce(String playerId) {
        add2ChouRenList(playerId);
        addChouHenPoint(playerId, (SocialFriendProps.findByMSocialAction(4)).killNum);
    }

    public void removeChouRensData(String playerId) {
        this.data.chouRens.remove(playerId);
    }

    public void refreshNewDay() {
    }
}


