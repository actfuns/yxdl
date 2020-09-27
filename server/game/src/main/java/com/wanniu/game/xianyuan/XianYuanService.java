package com.wanniu.game.xianyuan;

import com.wanniu.core.game.LangService;
import com.wanniu.game.data.FateCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.XianYuanPO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import pomelo.xianyuan.XianYuanHandler;


public class XianYuanService {
    private XianYuanService() {
    }

    public static XianYuanService getInstance() {
        return Inner.instance;
    }

    private static class Inner {
        private static XianYuanService instance = new XianYuanService();
    }


    public void applyXianYuanGetInfo(WNPlayer player, XianYuanHandler.XianYuanResponse.Builder res) {
        XianYuanPO xianYuanPo = player.allBlobData.xianYuan;
        if (xianYuanPo == null) {
            res.setS2CCode(500);
            res.setS2CMsg(LangService.getValue("XIAN_YUAN_NOT_OPEN"));

            return;
        }
        res.setS2CCode(200);
        res.setTotalXianYuan(player.moneyManager.getXianYuan());
        Map<Integer, Integer> reviceNumbers = xianYuanPo.reviceNumbers;
        Map<Integer, FateCO> fates = GameData.Fates;
        List<XianYuanHandler.XianYuanGetInfo> xianYuanGetInfos = new ArrayList<>();
        for (Map.Entry<Integer, FateCO> fate : fates.entrySet()) {
            XianYuanHandler.XianYuanGetInfo.Builder xianYuanGetInfo = XianYuanHandler.XianYuanGetInfo.newBuilder();
            int configId = ((Integer) fate.getKey()).intValue();
            FateCO fc = fate.getValue();
            xianYuanGetInfo.setConfigId(configId);
            int todayRecive = 0;
            if (reviceNumbers != null && reviceNumbers.containsKey(Integer.valueOf(configId))) {
                todayRecive = ((Integer) reviceNumbers.get(Integer.valueOf(configId))).intValue();
            }
            xianYuanGetInfo.setTodayRecive(todayRecive);
            xianYuanGetInfo.setTodayLimite(fc.numLimit);
            xianYuanGetInfos.add(xianYuanGetInfo.build());
        }
        res.addAllXianYuanGetInfo(xianYuanGetInfos);
    }


    public XianYuanPO createXianYuan(String playerId) {
        XianYuanPO xianYuanPo = new XianYuanPO();
        xianYuanPo.createTime = new Date();
        xianYuanPo.updateTime = new Date();
        return xianYuanPo;
    }


    public int processXianYuanGet(int from, XianYuanPO xianYuanPo) {
        FateCO fate = (FateCO) GameData.Fates.get(Integer.valueOf(from));
        if (fate == null || xianYuanPo == null) {
            return 0;
        }

        int singleNumber = fate.singleNum;
        int numLimit = fate.numLimit;
        Map<Integer, Integer> reviceNumbers = xianYuanPo.reviceNumbers;
        int todayReciveNum = 0;
        if (reviceNumbers != null) {
            Integer reciveNumber = reviceNumbers.get(Integer.valueOf(from));
            if (reciveNumber != null) {
                todayReciveNum = reciveNumber.intValue();
            }
            if (todayReciveNum >= numLimit) {
                return 0;
            }

            if (todayReciveNum + singleNumber > numLimit) {
                return numLimit - todayReciveNum;
            }
        }
        return singleNumber;
    }


    public void refreshNewDay(XianYuanPO xianYuanPo) {
        if (xianYuanPo.reviceNumbers != null)
            xianYuanPo.reviceNumbers.clear();
    }
}


