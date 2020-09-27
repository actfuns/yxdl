package com.wanniu.gm.handler;

import cn.qeng.common.gm.vo.GmPayVO;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.util.DateUtil;
import com.wanniu.game.player.PlayerDao;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.game.prepaid.PrepaidCenter;
import com.wanniu.game.prepaid.PrepaidManager;
import com.wanniu.game.prepaid.po.PrepaidRecord;
import com.wanniu.gm.GMErrorResponse;
import com.wanniu.gm.GMEvent;
import com.wanniu.gm.GMJsonResponse;
import com.wanniu.gm.GMResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@GMEvent
public class PayQueryHandler
        extends GMBaseHandler {
    public GMResponse execute(JSONArray arr) {
        String roleName = arr.getString(0);
        String id = PlayerDao.getIdByName(roleName);
        if (id == null) {
            return (GMResponse) new GMErrorResponse();
        }
        PlayerPO playerPo = PlayerUtil.getPlayerBaseData(id);
        PrepaidManager manager = PrepaidCenter.getInstance().findPrepaid(id);
        List<GmPayVO> list = new ArrayList<>();
        for (PrepaidRecord p : manager.po.chargeRecord) {
            list.add(new GmPayVO(playerPo.uid, playerPo.name, DateUtil.format(p.date), p.money, p.isCard ? "是" : "否"));
        }

        Map<String, Object> data = new HashMap<>();
        data.put("total", Integer.valueOf(1));
        data.put("rows", list);
        JSONObject jo = new JSONObject(data);

        return (GMResponse) new GMJsonResponse(jo);
    }

    public short getType() {
        return 8208;
    }
}


