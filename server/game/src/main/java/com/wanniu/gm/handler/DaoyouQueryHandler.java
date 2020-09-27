package com.wanniu.gm.handler;

import cn.qeng.common.gm.vo.GmDaoYouVO;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wanniu.game.daoyou.DaoYouCenter;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.CharacterExt;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.poes.DaoYouMemberPO;
import com.wanniu.game.poes.DaoYouPO;
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
public class DaoyouQueryHandler
        extends GMBaseHandler {
    public GMResponse execute(JSONArray arr) {
        String daoyouName = arr.getString(0);
        String daoyouId = DaoYouCenter.getInstance().getDaoYouId(daoyouName);
        if (daoyouId == null) {
            return (GMResponse) new GMErrorResponse();
        }
        DaoYouPO daoyouPo = DaoYouCenter.getInstance().getDaoYou(daoyouId);
        List<GmDaoYouVO> list = new ArrayList<>();
        List<String> members = DaoYouCenter.getInstance().getAllDaoYouMember(daoyouId);
        for (String pid : members) {
            PlayerPO playerPo = PlayerUtil.getPlayerBaseData(pid);
            if (playerPo == null) {
                continue;
            }
            DaoYouMemberPO memberPo = DaoYouCenter.getInstance().getDaoYouMember(pid);
            list.add(new GmDaoYouVO(playerPo.name, playerPo.level, playerPo.fightPower, ((CharacterExt) GameData.Characters.get(Integer.valueOf(playerPo.pro))).proName, daoyouPo.adminPlayerId.equals(pid) ? "是" : "否", String.valueOf(memberPo.todayReciveRebate), String.valueOf(memberPo.totalReciveRebate)));
        }
        Map<String, Object> data = new HashMap<>();
        data.put("total", Integer.valueOf(list.size()));
        data.put("rows", list);
        data.put("power", Integer.valueOf(daoyouPo.fightPower));
        JSONObject jo = new JSONObject(data);
        return (GMResponse) new GMJsonResponse(jo);
    }

    public short getType() {
        return 16400;
    }
}


