package com.wanniu.game.guild.dao;

import com.wanniu.core.db.GCache;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.Utils;
import com.wanniu.game.data.ext.GuildSettingExt;
import com.wanniu.game.guild.GuildCommonUtil;
import com.wanniu.game.guild.GuildUtil;
import com.wanniu.game.poes.GuildApplyPO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class GuildApplyDao {
    public static class GuildApplyMap
            extends ConcurrentHashMap<String, GuildApplyPO> {
        private static final long serialVersionUID = 1L;
        private Map<String, Map<String, GuildApplyPO>> playerApplys = new HashMap<>();

        private Map<String, Map<String, GuildApplyPO>> guildApplys = new HashMap<>();


        public GuildApplyPO put(String key, GuildApplyPO value) {
            Map<String, GuildApplyPO> applys = this.playerApplys.get(value.playerId);
            if (applys == null) {
                applys = new HashMap<>();
                this.playerApplys.put(value.playerId, applys);
            }
            applys.put(value.id, value);


            applys = this.guildApplys.get(value.guildId);
            if (applys == null) {
                applys = new HashMap<>();
                this.guildApplys.put(value.guildId, applys);
            }
            applys.put(value.id, value);

            Out.debug(new Object[]{entrySet()});
            Out.debug(new Object[]{key});
            GuildApplyPO result = super.put(key, value);
            Out.debug(new Object[]{entrySet()});
            return result;
        }


        public GuildApplyPO remove(Object key) {
            Out.debug(new Object[]{key});
            Out.debug(new Object[]{entrySet()});
            GuildApplyPO value = super.remove(key);
            Out.debug(new Object[]{entrySet()});
            if (value != null) {

                Map<String, GuildApplyPO> applys = this.playerApplys.get(value.playerId);
                if (applys != null) {
                    applys.remove(value.id);
                }


                applys = this.guildApplys.get(value.guildId);
                if (applys != null) {
                    applys.remove(value.id);
                }
            }

            return value;
        }


        public void clear() {
            this.playerApplys.clear();
            this.guildApplys.clear();
            super.clear();
        }

        public Map<String, GuildApplyPO> getPlayerApplys(String playerId) {
            return this.playerApplys.get(playerId);
        }

        public Map<String, GuildApplyPO> getGuildApplys(String guildId) {
            return this.guildApplys.get(guildId);
        }
    }


    public static final GuildApplyMap GuildApplys = new GuildApplyMap();

    public static void init() {
        List<GuildApplyPO> applys = GuildCommonUtil.hgetAll(ConstsTR.guildApplyTR, GuildApplyPO.class);
        for (GuildApplyPO po : applys) {
            GuildApplys.put(po.id, po);
        }
        Out.debug(new Object[]{GuildApplys});
        JobFactory.addFixedRateJob(() -> {
            long currTime = System.currentTimeMillis();
            GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
            int expireTime = settingProp.applicationFail * Const.Time.Minute.getValue();
            for (GuildApplyPO apply : GuildApplys.values()) {
                if (currTime - apply.createTime.getTime() >= expireTime) {
                    removeGuildApply(apply.id);
                    Out.debug(new Object[]{"timeout guild apply : ", apply.id}, );
                }
            }
        } 1000L, Const.Time.Minute


                .getValue());
    }

    public static GuildApplyPO getGuildApply(String id) {
        return GuildApplys.get(id);
    }

    public static int getGuildApplyCount(String guildId) {
        Map<String, GuildApplyPO> applyMap = GuildApplys.getGuildApplys(guildId);
        return (applyMap != null) ? applyMap.size() : 0;
    }

    public static List<GuildApplyPO> getGuildApplyList(String guildId) {
        List<GuildApplyPO> applys = new ArrayList<>();
        Map<String, GuildApplyPO> applyMap = GuildApplys.getGuildApplys(guildId);
        if (applyMap != null) {
            applys.addAll(applyMap.values());
        }
        return applys;
    }

    public static List<GuildApplyPO> getPlayerApplyIdList(String playerId) {
        List<GuildApplyPO> applys = new ArrayList<>();
        Map<String, GuildApplyPO> applyMap = GuildApplys.getPlayerApplys(playerId);
        if (applyMap != null) {
            applys.addAll(applyMap.values());
        }
        return applys;
    }

    public static void addGuildApply(GuildApplyPO data) {
        GuildApplys.put(data.id, data);
        GCache.hset(ConstsTR.guildApplyTR.value, data.id, Utils.serialize(data));
    }

    public static void removeGuildApply(String id) {
        GuildApplys.remove(id);
        GCache.hremove(ConstsTR.guildApplyTR.value, id);
    }
}


