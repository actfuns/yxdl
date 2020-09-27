package com.wanniu.game.functionOpen;

import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.LangService;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.GuideCO;
import com.wanniu.game.data.OpenLvCO;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.FunctionOpenPO;
import com.wanniu.game.task.TaskEvent;
import com.wanniu.redis.PlayerPOManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pomelo.area.FunctionOpenHandler;
import pomelo.player.PlayerOuterClass;


public class FunctionOpenManager {
    public WNPlayer player;
    public FunctionOpenPO data;

    public FunctionOpenManager(WNPlayer player, FunctionOpenPO data) {
        this.player = player;

        if (data == null) {
            data = new FunctionOpenPO();
        }
        this.data = data;
        if (this.data.openMap == null) {
            this.data.openMap = new HashMap<>();
        }
        if (this.data.playMap == null) {
            this.data.playMap = new HashMap<>();
        }
        if (this.data.functionAwards == null) {
            this.data.functionAwards = new ArrayList();
        }
        init();
    }

    public void init() {
        List<OpenLvCO> propList = FunctionOpenUtil.getPropList();
        for (OpenLvCO prop : propList) {
            if (this.data.openMap.containsKey(prop.fun)) {
                continue;
            }
            if (prop.isReq == 0 &&
                    checkLevelReq(prop)) {
                this.data.openMap.put(prop.fun, Integer.valueOf(1));
            }
        }
    }


    public boolean checkLevelReq(OpenLvCO prop) {
        int level = Math.max(prop.openLv, 1);
        int upLevel = prop.openUpLv;
        int vipLevel = prop.openVIPLv;

        if (upLevel > 0) {
            if ((this.player.getPlayer()).upLevel < upLevel)
                return false;
        } else if ((this.player.getPlayer()).level < level) {
            return false;
        }


        return true;
    }

    public List<PlayerOuterClass.FunctionInfo> toJson4PayLoad() {
        List<PlayerOuterClass.FunctionInfo> data = new ArrayList<>();

        List<OpenLvCO> propList = FunctionOpenUtil.getPropList();
        for (OpenLvCO prop : propList) {
            if (prop.isOpen > 0 && prop.type == 0) {
                continue;
            }
            PlayerOuterClass.FunctionInfo.Builder tempInfo = PlayerOuterClass.FunctionInfo.newBuilder();
            tempInfo.setFuncName(prop.fun);
            tempInfo.setOpenFlag(0);
            tempInfo.setPlayFlag(0);

            if (this.data.playMap.containsKey(prop.fun)) {
                tempInfo.setPlayFlag(1);
            }
            if (prop.isOpen > 0 && this.data.openMap.containsKey(prop.fun)) {
                tempInfo.setOpenFlag(1);
            }
            data.add(tempInfo.build());
        }

        return data;
    }


    public List<PlayerOuterClass.FunctionInfo> getFunctionOpenPushList(List<String> nameArray) {
        List<PlayerOuterClass.FunctionInfo> data = new ArrayList<>();
        List<OpenLvCO> propList = FunctionOpenUtil.getPropListByFunctionNameArray(nameArray);
        for (OpenLvCO prop : propList) {
            if (prop.isOpen > 0 && prop.type == 0) {
                continue;
            }
            PlayerOuterClass.FunctionInfo.Builder tempInfo = PlayerOuterClass.FunctionInfo.newBuilder();
            tempInfo.setFuncName(prop.fun);
            tempInfo.setOpenFlag(0);
            tempInfo.setPlayFlag(0);
            if (this.data.playMap.containsKey(prop.fun)) {
                tempInfo.setPlayFlag(1);
            }
            if (prop.isOpen > 0 && this.data.openMap.containsKey(prop.fun)) {
                tempInfo.setOpenFlag(1);
                data.add(tempInfo.build());
            }
        }

        return data;
    }


    public String receiveFunctionAward(int guideId) {
        if (this.data.functionAwards.contains(Integer.valueOf(guideId))) {
            return LangService.getValue("SOLO_REWARD_HAS_DRAWED");
        }
        GuideCO guideCO = (GuideCO) GameData.Guides.get(Integer.valueOf(guideId));
        if (guideCO == null) {
            return LangService.getValue("SOLO_REWARD_NOT_EXIST");
        }


        this.data.functionAwards.add(Integer.valueOf(guideId));

        if (StringUtil.isNotEmpty(guideCO.reward)) {
            String[] codeNum = guideCO.reward.split(":");
            this.player.bag.addCodeItemMail(codeNum[0], Integer.parseInt(codeNum[1]), null, Const.GOODS_CHANGE_TYPE.FUNCTION_OPEN, "Bag_full_common");
        }
        return null;
    }


    public void checkFunctoinAward() {
        FunctionOpenHandler.FunctionAwardListPush.Builder functionAwardPush = FunctionOpenHandler.FunctionAwardListPush.newBuilder();
        for (GuideCO guideCO : GameData.Guides.values()) {

            if (this.player.getLevel() < guideCO.closeLv) {
                continue;
            }

            if (this.data.functionAwards.contains(Integer.valueOf(guideCO.iD))) {
                continue;
            }

            functionAwardPush.addGuideIds(guideCO.iD);
        }
        if (functionAwardPush.getGuideIdsCount() > 0) {
            this.player.receive("area.functionOpenPush.functionAwardListPush", (GeneratedMessage) functionAwardPush.build());
        }
    }


    public void onUpgradeLevelOrVip() {
        List<Integer> reqTypeArray = new ArrayList<>();
        reqTypeArray.add(Integer.valueOf(ReqType.LEVEL.getValue()));
        reqTypeArray.add(Integer.valueOf(ReqType.FINISH_TASK.getValue()));
        List<OpenLvCO> propList = FunctionOpenUtil.getPropListByReqTypeArray(reqTypeArray);
        checkOpenFunctions(propList, null);


        checkFunctoinAward();
    }

    public void checkAll() {
        List<OpenLvCO> propList = FunctionOpenUtil.getPropList();
        checkOpenFunctions(propList, null);
    }


    public void onFinishTask(String taskId) {
        List<OpenLvCO> propList = FunctionOpenUtil.getPropListByReqEvent(ReqType.FINISH_TASK.getValue(), taskId);
        checkOpenFunctions(propList, taskId);
    }

    public void onAcceptTask(String taskId) {
        List<OpenLvCO> propList = FunctionOpenUtil.getPropListByReqEvent(ReqType.ACCEPT_TASK.getValue(), taskId);
        checkOpenFunctions(propList, taskId);
    }

    public void onInteract(String objId) {
        List<OpenLvCO> propList = FunctionOpenUtil.getPropListByReqEvent(ReqType.INTERACT_ITEM.getValue(), objId);
        checkOpenFunctions(propList, objId);
    }


    public void checkOpenFunctions(List<OpenLvCO> propList, String param) {
        List<String> openIdArray = new ArrayList<>();
        for (OpenLvCO prop : propList) {
            if (this.data.openMap.containsKey(prop.fun)) {
                continue;
            }
            if (prop.isReq == 0) {
                if (!checkLevelReq(prop)) {
                    continue;
                }
            } else if (prop.isReq == 1) {
                if (!prop.openReq.equals(param)) {
                    continue;
                }
            } else if (prop.isReq == 2) {
                if (!checkLevelReq(prop)) {
                    continue;
                }
                if (!prop.openReq.equals(param)) {
                    continue;
                }
                if (!this.player.getPlayerTasks().isFinishTask(Integer.parseInt(param))) {
                    continue;
                }
            } else if (prop.isReq != 3 ||
                    !prop.openReq.equals(param)) {
                continue;
            }


            this.data.openMap.put(prop.fun, Integer.valueOf(1));
            openIdArray.add(prop.fun);
        }
        onOpenNewFunctions(openIdArray);
    }

    public void pushAllFunctionOpenInfoToClient() {
        FunctionOpenHandler.FunctionOpenListPush.Builder data = FunctionOpenHandler.FunctionOpenListPush.newBuilder();
        data.setS2CCode(200);
        data.getS2CListBuilderList().clear();
        data.addAllS2CList(toJson4PayLoad());
        data.setS2CIsAll(1);

        this.player.receive("area.functionOpenPush.functionOpenListPush", (GeneratedMessage) data.build());
    }

    public void pushNewFunctionOpenInfoToClient(List<String> pushIdArray) {
        if (pushIdArray == null || pushIdArray.size() == 0) {
            return;
        }
        FunctionOpenHandler.FunctionOpenListPush.Builder data = FunctionOpenHandler.FunctionOpenListPush.newBuilder();
        data.setS2CCode(200);

        List<PlayerOuterClass.FunctionInfo> list = getFunctionOpenPushList(pushIdArray);
        if (list.size() == 0) {
            return;
        }

        data.addAllS2CList(list);
        data.setS2CIsAll(0);
        this.player.receive("area.functionOpenPush.functionOpenListPush", (GeneratedMessage) data.build());
    }

    public void onOpenNewFunctions(List<String> openArray) {
        if (openArray.size() == 0) {
            return;
        }
        pushNewFunctionOpenInfoToClient(openArray);

        if (openArray.indexOf(Const.FunctionType.RIDING.getValue()) != -1 || openArray.indexOf(Const.FunctionType.MOUNT.getValue()) != -1) {
            this.player.mountManager.openMount();
        }
    }


    public void onEvent(TaskEvent event) {
        if (event.type == Const.EventType.interActiveItem.getValue()) {
            onInteract(event.params[0].toString());
        }
    }

    public void gmOpenFunction(int id) {
        if (id > 0) {
            OpenLvCO prop = FunctionOpenUtil.getPropById(id);
            if (prop == null) {
                return;
            }
            if (this.data.openMap.containsKey(prop.fun)) {
                return;
            }
            this.data.openMap.put(prop.fun, Integer.valueOf(1));
            List<String> idArray = new ArrayList<>();
            idArray.add(prop.fun);
            onOpenNewFunctions(idArray);
        } else {
            List<String> idArray = new ArrayList<>();
            List<OpenLvCO> propList = FunctionOpenUtil.getPropList();
            for (OpenLvCO prop : propList) {
                if (this.data.openMap.containsKey(prop.fun)) {
                    continue;
                }
                this.data.openMap.put(prop.fun, Integer.valueOf(1));
                idArray.add(prop.fun);
            }
            onOpenNewFunctions(idArray);
        }
    }


    public boolean isOpen(String functionName) {
        OpenLvCO prop = FunctionOpenUtil.getPropByName(functionName);

        if (prop == null) {
            return true;
        }
        if (prop.isOpen == 0) {
            return false;
        }
        if (prop.type == 0) {
            return true;
        }
        if (!this.data.openMap.containsKey(functionName)) {
            return false;
        }
        return true;
    }


    public static boolean IsOpen(String functionName, String playerId) {
        OpenLvCO prop = FunctionOpenUtil.getPropByName(functionName);

        if (prop == null) {
            return true;
        }
        if (prop.isOpen == 0) {
            return false;
        }
        if (prop.type == 0) {
            return true;
        }
        FunctionOpenPO functionOpenPO = (FunctionOpenPO) PlayerPOManager.findPO(ConstsTR.player_func_openTR, playerId, FunctionOpenPO.class);
        if (!functionOpenPO.openMap.containsKey(functionName)) {
            return false;
        }
        return true;
    }

    public int setFunctionPlayed(String funcName) {
        if (!isOpen(funcName)) {
            return -1;
        }
        if (this.data.playMap.containsKey(funcName)) {
            return 0;
        }
        this.data.playMap.put(funcName, Integer.valueOf(1));
        return 0;
    }
}


