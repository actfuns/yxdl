package com.wanniu.gm.handler;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.common.StringInt;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.PetSkillExt;
import com.wanniu.game.petNew.PetNew;
import com.wanniu.game.petNew.PetSkill;
import com.wanniu.game.player.PlayerDao;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.player.po.AllBlobPO;
import com.wanniu.gm.GMEvent;
import com.wanniu.gm.GMJsonResponse;
import com.wanniu.gm.GMResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@GMEvent
public class PetInfoHandler
        extends GMBaseHandler {
    public GMResponse execute(JSONArray arr) {
        String id = arr.getString(0);
        int petId = arr.getIntValue(1);
        WNPlayer wnPlayer = PlayerUtil.getOnlinePlayer(id);
        if (wnPlayer == null) {
            AllBlobPO allBlobData = PlayerDao.getAllBlobData(id);
            wnPlayer = new WNPlayer(allBlobData);
        }
        PetNew pw = (PetNew) wnPlayer.petNewManager.playerPets.get(Integer.valueOf(petId));

        List<StringInt> skills = new ArrayList<>();
        for (PetSkill s : pw.po.skills.values()) {
            skills.add(new StringInt(s.level, ((PetSkillExt) GameData.PetSkills.get(Integer.valueOf(s.id))).skillName));
        }


        List<StringInt> attr = new ArrayList<>();
        for (Map.Entry<Const.PlayerBtlData, Integer> entry : (Iterable<Map.Entry<Const.PlayerBtlData, Integer>>) pw.attr_final_pet.entrySet()) {
            attr.add(new StringInt(((Integer) entry.getValue()).intValue(), ((Const.PlayerBtlData) entry.getKey()).chName));
        }


        List<StringInt> master = new ArrayList<>();
        for (Map.Entry<Const.PlayerBtlData, Integer> entry : (Iterable<Map.Entry<Const.PlayerBtlData, Integer>>) pw.attr_master.entrySet()) {
            master.add(new StringInt(((Integer) entry.getValue()).intValue(), ((Const.PlayerBtlData) entry.getKey()).chName));
        }

        Map<String, Object> all = new HashMap<>();

        Map<String, Object> data = new HashMap<>();
        data.put("total", Integer.valueOf(skills.size()));
        data.put("rows", skills);
        all.put("skills", data);

        data = new HashMap<>();
        data.put("total", Integer.valueOf(attr.size()));
        data.put("rows", attr);
        all.put("attr", data);

        data = new HashMap<>();
        data.put("total", Integer.valueOf(master.size()));
        data.put("rows", master);
        all.put("master", data);

        JSONObject jo = new JSONObject(all);

        return (GMResponse) new GMJsonResponse(jo);
    }

    public short getType() {
        return 12326;
    }
}


