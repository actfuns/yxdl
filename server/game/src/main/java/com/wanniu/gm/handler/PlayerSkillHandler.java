package com.wanniu.gm.handler;

import cn.qeng.common.gm.vo.GmPlayerSkillVO;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.SkillDataExt;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.playerSkill.po.SkillDB;
import com.wanniu.game.poes.SkillsPO;
import com.wanniu.gm.GMEvent;
import com.wanniu.gm.GMJsonResponse;
import com.wanniu.gm.GMResponse;
import com.wanniu.redis.PlayerPOManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@GMEvent
public class PlayerSkillHandler
        extends GMBaseHandler {
    public GMResponse execute(JSONArray arr) {
        String id = arr.getString(0);
        WNPlayer wnPlayer = PlayerUtil.getOnlinePlayer(id);
        SkillsPO skillDb = null;
        if (wnPlayer == null) {
            skillDb = (SkillsPO) PlayerPOManager.findPO(ConstsTR.skillTR, id, SkillsPO.class);
        } else {
            skillDb = wnPlayer.skillKeyManager.player_skills;
        }

        List<GmPlayerSkillVO> list = new ArrayList<>();
        for (Map.Entry<Integer, SkillDB> entry : (Iterable<Map.Entry<Integer, SkillDB>>) skillDb.skills.entrySet()) {
            String skillName = ((SkillDataExt) GameData.SkillDatas.get(entry.getKey())).skillName;
            list.add(new GmPlayerSkillVO(skillName, ((SkillDB) entry.getValue()).lv));
        }
        Map<String, Object> data = new HashMap<>();
        data.put("total", Integer.valueOf(list.size()));
        data.put("rows", list);
        JSONObject jo = new JSONObject(data);

        return (GMResponse) new GMJsonResponse(jo);
    }

    public short getType() {
        return 12324;
    }
}


