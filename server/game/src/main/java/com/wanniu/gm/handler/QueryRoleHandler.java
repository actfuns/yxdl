package com.wanniu.gm.handler;

import cn.qeng.common.gm.vo.GmManagerVO;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.util.DateUtil;
import com.wanniu.game.player.PlayerDao;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.gm.GMErrorResponse;
import com.wanniu.gm.GMEvent;
import com.wanniu.gm.GMJsonResponse;
import com.wanniu.gm.GMResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@GMEvent
public class QueryRoleHandler
        extends GMBaseHandler {
    public GMResponse execute(JSONArray arr) {
        String roleName = arr.getString(0);
        String id = PlayerDao.getIdByName(roleName);
        if (id == null) {
            return (GMResponse) new GMErrorResponse();
        }
        List<GmManagerVO> list = new ArrayList<>();

        PlayerPO po = PlayerUtil.getPlayerBaseData(id);
        GmManagerVO vo = new GmManagerVO(po.id, po.name, "", "", po.freezeReason, po.forbidTalkReason);
        if (po.freezeTime != null) {
            vo.setFreezeTime(DateUtil.format(po.freezeTime));
        }
        if (po.forbidTalkTime != null) {
            vo.setForbidTime(DateUtil.format(po.forbidTalkTime));
        }
        list.add(vo);

        Map<String, Object> data = new HashMap<>();
        data.put("total", Integer.valueOf(1));
        data.put("rows", list);

        JSONObject jo = new JSONObject(data);
        return (GMResponse) new GMJsonResponse(jo);
    }

    public short getType() {
        return 12289;
    }
}


