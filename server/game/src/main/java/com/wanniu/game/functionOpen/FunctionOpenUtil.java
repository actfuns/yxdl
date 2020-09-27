package com.wanniu.game.functionOpen;

import com.wanniu.game.data.GameData;
import com.wanniu.game.data.OpenLvCO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class FunctionOpenUtil {
    public static List<OpenLvCO> getPropList() {
        List<OpenLvCO> list = new ArrayList<>();
        for (Map.Entry<Integer, OpenLvCO> node : (Iterable<Map.Entry<Integer, OpenLvCO>>) GameData.OpenLvs.entrySet()) {
            list.add(node.getValue());
        }
        return list;
    }

    public static List<OpenLvCO> findFunctionOpenPropsByIsReq(int isReq) {
        List<OpenLvCO> props = new ArrayList<>();
        for (Map.Entry<Integer, OpenLvCO> node : (Iterable<Map.Entry<Integer, OpenLvCO>>) GameData.OpenLvs.entrySet()) {
            OpenLvCO data = node.getValue();
            if (data.isReq == isReq) {
                props.add(data);
            }
        }
        return props;
    }

    public static List<OpenLvCO> findFunctionOpenPropsByIsReqAndOpenReq(int isReq, String openReq) {
        List<OpenLvCO> props = new ArrayList<>();
        for (Map.Entry<Integer, OpenLvCO> node : (Iterable<Map.Entry<Integer, OpenLvCO>>) GameData.OpenLvs.entrySet()) {
            OpenLvCO each = node.getValue();
            if (each.isReq == isReq && each.openReq.equals(openReq)) {
                props.add(each);
            }
        }
        return props;
    }


    public static List<OpenLvCO> getPropListByReqEvent(int reqType, String reqEvent) {
        if (reqEvent == null) {
            return findFunctionOpenPropsByIsReq(reqType);
        }


        return findFunctionOpenPropsByIsReqAndOpenReq(reqType, reqEvent);
    }


    public static List<OpenLvCO> getPropListByReqTypeArray(List<Integer> reqTypeArray) {
        List<OpenLvCO> props = new ArrayList<>();
        for (Map.Entry<Integer, OpenLvCO> node : (Iterable<Map.Entry<Integer, OpenLvCO>>) GameData.OpenLvs.entrySet()) {
            OpenLvCO each = node.getValue();
            if (reqTypeArray.indexOf(Integer.valueOf(each.isReq)) != -1) {
                props.add(each);
            }
        }
        return props;
    }


    public static List<OpenLvCO> getPropListByIdArray(ArrayList<Integer> idArray) {
        List<OpenLvCO> props = new ArrayList<>();
        for (Map.Entry<Integer, OpenLvCO> node : (Iterable<Map.Entry<Integer, OpenLvCO>>) GameData.OpenLvs.entrySet()) {
            OpenLvCO each = node.getValue();
            if (idArray.indexOf(Integer.valueOf(each.iD)) != -1) {
                props.add(each);
            }
        }
        return props;
    }

    public static List<OpenLvCO> getPropListByFunctionNameArray(List<String> nameArray) {
        List<OpenLvCO> props = new ArrayList<>();
        for (Map.Entry<Integer, OpenLvCO> node : (Iterable<Map.Entry<Integer, OpenLvCO>>) GameData.OpenLvs.entrySet()) {
            OpenLvCO each = node.getValue();
            if (nameArray.indexOf(each.fun) != -1) {
                props.add(each);
            }
        }
        return props;
    }

    public static OpenLvCO getPropById(int funcId) {
        return (OpenLvCO) GameData.OpenLvs.get(Integer.valueOf(funcId));
    }

    public static OpenLvCO findFunctionOpenPropsByFuncName(String funcName) {
        for (Map.Entry<Integer, OpenLvCO> node : (Iterable<Map.Entry<Integer, OpenLvCO>>) GameData.OpenLvs.entrySet()) {
            OpenLvCO each = node.getValue();
            if (each.fun.equals(funcName)) {
                return each;
            }
        }
        return null;
    }

    public static OpenLvCO getPropByName(String funcName) {
        return findFunctionOpenPropsByFuncName(funcName);
    }

    public static String getTipsByName(String funcName) {
        OpenLvCO prop = getPropByName(funcName);
        if (prop != null) {
            return prop.tips;
        }
        return "";
    }


    public static boolean isDefaultOpen(String funcName) {
        int state = getDefaultOpenState(funcName);
        return (state == 1);
    }

    public static boolean isDefaultClose(String funcName) {
        int state = getDefaultOpenState(funcName);
        return (state == -1);
    }


    public static int getDefaultOpenState(String funcName) {
        OpenLvCO prop = getPropByName(funcName);
        if (prop == null) {
            return 1;
        }
        if (prop.isOpen == 0) {
            return -1;
        }
        if (prop.type == 0) {
            return 1;
        }
        return 0;
    }
}


