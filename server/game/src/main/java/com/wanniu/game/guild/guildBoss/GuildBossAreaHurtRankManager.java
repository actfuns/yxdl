package com.wanniu.game.guild.guildBoss;

import com.alibaba.fastjson.JSON;
import com.wanniu.core.db.GCache;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.player.WNPlayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class GuildBossAreaHurtRankManager {
    private WNPlayer player;

    public GuildBossAreaHurtRankManager(WNPlayer player) {
        this.player = player;
    }


    public List<RankBean> getAndSetRankBeanList(String guildId) {
        List<RankBean> list = GuildBossAreaHurtRankCenter.getInstance().getRankList(guildId);
        if (list == null) {
            String vl = GCache.hget(ConstsTR.guildBossHurtTR.value, guildId);
            if (!StringUtil.isEmpty(vl)) {
                list = JSON.parseArray(vl, RankBean.class);
            } else {
                list = new ArrayList<>();
            }
            GuildBossAreaHurtRankCenter.getInstance().replaceIfnullShowData(guildId, list);
        }
        return list;
    }


    public List<RankBean> getRankBeanListOnBegin(String guildId) {
        GuildRankBean guildBean = GuildBossAreaHurtRankCenter.getInstance().onlyGetGuildRankBean(guildId);
        if (guildBean == null) {
            return null;
        }
        List<RankBean> list = guildBean.getHurtListWithLock();
        if (!list.isEmpty()) {
            Collections.sort(list, GuildBossAreaHurtRankCenter.SORT_HURT);
        }
        return list;
    }


    public WNPlayer getPlayer() {
        return this.player;
    }

    public void setPlayer(WNPlayer player) {
        this.player = player;
    }
}


