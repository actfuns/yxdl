package com.wanniu.gm.handler;

import cn.qeng.common.gm.vo.GmGuildMemberVO;
import cn.qeng.common.gm.vo.GmGuildVO;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.CharacterExt;
import com.wanniu.game.guild.GuildUtil;
import com.wanniu.game.guild.dao.GuildDao;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.poes.GuildMemberPO;
import com.wanniu.game.poes.GuildPO;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.gm.GMErrorResponse;
import com.wanniu.gm.GMEvent;
import com.wanniu.gm.GMJsonResponse;
import com.wanniu.gm.GMResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@GMEvent
public class GuildQueryHandler
        extends GMBaseHandler {
    public GMResponse execute(JSONArray arr) {
        String guildName = arr.getString(0);
        int type = arr.getIntValue(1);
        if (type == 0) {
            String guildId = GuildUtil.getGuildByFullName(guildName);
            if (guildId == null) {
                return (GMResponse) new GMErrorResponse();
            }
            List<GmGuildMemberVO> list1 = new ArrayList<>();
            List<GuildMemberPO> members = GuildUtil.getGuildMemberList(guildId);
            for (GuildMemberPO m : members) {
                PlayerPO playerPo = PlayerUtil.getPlayerBaseData(m.playerId);
                String state = PlayerUtil.isOnline(m.playerId) ? "在线" : "";
                if (state.isEmpty()) {
                    long minute = (System.currentTimeMillis() - playerPo.logoutTime.getTime()) / 60000L;
                    if (minute < 60L) {
                        state = "离线" + minute + "分钟";
                    } else {
                        state = "离线" + (minute / 60L) + "小时";
                    }
                }
                list1.add(new GmGuildMemberVO(playerPo.name, playerPo.level, playerPo.fightPower, (GuildUtil.getGuildJobPropByJobId(m.job)).position, m.lastContributeValue, state, ((CharacterExt) GameData.Characters.get(Integer.valueOf(playerPo.pro))).proName, m.job));
            }
            Collections.sort(list1, new Comparator<GmGuildMemberVO>() {
                public int compare(GmGuildMemberVO o1, GmGuildMemberVO o2) {
                    int i = o1.getJob() - o2.getJob();
                    if (i == 0) {
                        i = o2.getLevel() - o1.getLevel();
                    } else if (i == 0) {
                        i = o2.getPower() - o1.getPower();
                    }
                    return i;
                }
            });
            GuildPO guild = GuildUtil.getGuild(guildId);
            Map<String, Object> map = new HashMap<>();
            map.put("total", Integer.valueOf(list1.size()));
            map.put("rows", list1);
            map.put("id", guild.id);
            map.put("level", Integer.valueOf(guild.level));
            map.put("notice", guild.notice);
            JSONObject jSONObject = new JSONObject(map);

            return (GMResponse) new GMJsonResponse(jSONObject);
        }
        List<GmGuildVO> list = new ArrayList<>();
        for (GuildPO guild : GuildDao.GuildMap.values()) {
            if (guild.name.indexOf(guildName) >= 0) {
                list.add(new GmGuildVO(guild.name, guild.level, guild.presidentName));
            }
        }

        Map<String, Object> data = new HashMap<>();
        data.put("total", Integer.valueOf(list.size()));
        data.put("rows", list);
        JSONObject jo = new JSONObject(data);
        return (GMResponse) new GMJsonResponse(jo);
    }


    public short getType() {
        return 12337;
    }
}


