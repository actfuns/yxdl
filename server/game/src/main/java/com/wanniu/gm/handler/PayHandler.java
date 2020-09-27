package com.wanniu.gm.handler;

import com.alibaba.fastjson.JSONArray;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.player.PlayerDao;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.prepaid.PrepaidCenter;
import com.wanniu.game.prepaid.PrepaidManager;
import com.wanniu.gm.GMEvent;
import com.wanniu.gm.GMResponse;
import com.wanniu.gm.GMStateResponse;


@GMEvent
public class PayHandler
        extends GMBaseHandler {
    public GMResponse execute(JSONArray arr) {
        String roleType = arr.getString(0);
        String roleId = arr.getString(1);
        int productId = arr.getIntValue(2);
        boolean logBI = true;
        if (arr.size() > 3) {
            logBI = (arr.getIntValue(3) == 1);
        }

        if (roleType.equals("id")) {
            if (PlayerUtil.getPlayerBaseData(roleId) == null) {
                return (GMResponse) new GMStateResponse(-2);
            }
        } else {
            String id = PlayerDao.getIdByName(roleId);
            if (id == null) {
                return (GMResponse) new GMStateResponse(-2);
            }
            roleId = id;
        }

        boolean isCard = false;

        if (productId == 1 || productId == 2) {
            isCard = true;
        }


        boolean isSuperPackage = false;
        if (productId > 300) {
            isSuperPackage = true;
        }

        PrepaidManager manager = PrepaidCenter.getInstance().findPrepaid(roleId);
        manager.onCharge(productId, isCard, isSuperPackage, logBI);
        PrepaidCenter.getInstance().update(roleId, manager);
        Out.info(new Object[]{"GM补单记录 roleId=", roleId, ",productId=", Integer.valueOf(productId), ",isCard=", Boolean.valueOf(isCard), ",isSuperPackage=", Boolean.valueOf(isSuperPackage), ",logBI=", Boolean.valueOf(logBI)});
        return (GMResponse) new GMStateResponse(1);
    }

    public short getType() {
        return 8240;
    }
}


