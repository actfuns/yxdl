package com.wanniu.gm.handler;

import cn.qeng.common.gm.vo.GmPlayerInfoVO;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.util.DateUtil;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.daoyou.DaoYouService;
import com.wanniu.game.data.CharacterLevelCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.CharacterExt;
import com.wanniu.game.data.ext.UpLevelExpExt;
import com.wanniu.game.guild.GuildUtil;
import com.wanniu.game.player.PlayerDao;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.poes.DaoYouPO;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.gm.GMErrorResponse;
import com.wanniu.gm.GMEvent;
import com.wanniu.gm.GMJsonResponse;
import com.wanniu.gm.GMResponse;
import com.wanniu.redis.GameDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


@GMEvent
public class QueryRoleInfoHandler
        extends GMBaseHandler {
    public GMResponse execute(JSONArray arr) {
        String roleName = arr.getString(0);
        int type = arr.getIntValue(1);
        if (type == 0) {
            String id = PlayerDao.getIdByName(roleName);
            if (id == null) {
                return (GMResponse) new GMErrorResponse();
            }
            PlayerPO po = PlayerUtil.getPlayerBaseData(id);
            CharacterExt character = (CharacterExt) GameData.Characters.get(Integer.valueOf(po.pro));
            String vip = "无";
            if (po.vip == 1) {
                vip = "月惠卡";
            } else if (po.vip == 2) {
                vip = "尊享卡";
            }
            DaoYouPO daoyou = DaoYouService.getInstance().getDaoYou(po.id);
            GmPlayerInfoVO vo = new GmPlayerInfoVO(po.id, po.uid, po.name, po.level, po.exp + "/" + ((CharacterLevelCO) GameData.CharacterLevels.get(Integer.valueOf(po.level))).experience, po.diamond, po.gold, vip, (po.loginTime != null) ? DateUtil.format(po.loginTime) : "", character.proName, PlayerUtil.isOnline(id) ? "是" : "否", (po.logoutTime != null) ? DateUtil.format(po.logoutTime) : "", (po.isDelete == 1) ? "已删除" : "正常", po.classExp + "/" + ((UpLevelExpExt) GameData.UpLevelExps.get(Integer.valueOf(po.upOrder + 1))).reqClassExp, po.ticket, GuildUtil.getGuildName(po.id), (daoyou == null) ? "" : daoyou.name, po.fightPower);


            return (GMResponse) new GMJsonResponse(JSON.toJSONString(vo));
        }
        List<GmPlayerInfoVO> list = new ArrayList<>();
        Set<String> names = GameDao.hkeys(ConstsTR.NAME_MODULE.value);
        for (String n : names) {
            if (n.contains(roleName)) {
                String id = PlayerDao.getIdByName(n);
                PlayerPO po = PlayerUtil.getPlayerBaseData(id);
                if (po == null) {
                    continue;
                }
                GmPlayerInfoVO vo = new GmPlayerInfoVO();
                vo.setName(po.name);
                vo.setLevel(po.level);
                vo.setPro(((CharacterExt) GameData.Characters.get(Integer.valueOf(po.pro))).proName);
                list.add(vo);
            }
        }
        Map<String, Object> data = new HashMap<>();
        data.put("total", Integer.valueOf(list.size()));
        data.put("rows", list);
        JSONObject jo = new JSONObject(data);
        return (GMResponse) new GMJsonResponse(jo);
    }


    public short getType() {
        return 12320;
    }
}


