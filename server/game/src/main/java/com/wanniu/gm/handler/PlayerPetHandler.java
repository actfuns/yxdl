package com.wanniu.gm.handler;

import cn.qeng.common.gm.vo.GmPetVO;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.BaseDataExt;
import com.wanniu.game.petNew.PetCenter;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PetNewPO;
import com.wanniu.game.poes.PlayerPetsNewPO;
import com.wanniu.gm.GMEvent;
import com.wanniu.gm.GMJsonResponse;
import com.wanniu.gm.GMResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@GMEvent
public class PlayerPetHandler
        extends GMBaseHandler {
    public GMResponse execute(JSONArray arr) {
        String id = arr.getString(0);
        WNPlayer wnPlayer = PlayerUtil.getOnlinePlayer(id);
        PlayerPetsNewPO petPo = null;
        if (wnPlayer == null) {
            petPo = PetCenter.getInstance().findPet(id);
        } else {
            petPo = wnPlayer.petNewManager.petsPO;
        }

        List<GmPetVO> list = new ArrayList<>();
        for (PetNewPO p : petPo.pets.values()) {
            list.add(new GmPetVO(p.id, p.name, p.level, p.upLevel, p.fightPower, ((BaseDataExt) GameData.BaseDatas.get(Integer.valueOf(p.id))).type, (p.id == petPo.fightPetId) ? "是" : "否", p.skills.size()));
        }
        Map<String, Object> data = new HashMap<>();
        data.put("total", Integer.valueOf(list.size()));
        data.put("rows", list);
        JSONObject jo = new JSONObject(data);

        return (GMResponse) new GMJsonResponse(jo);
    }

    public short getType() {
        return 12325;
    }
}


