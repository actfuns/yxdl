package com.wanniu.game.guild.guildBoss;

import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GEntity;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.DateUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.area.Area;
import com.wanniu.game.area.AreaData;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.ModuleManager;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.data.base.MapBase;
import com.wanniu.game.data.ext.InspireLevelExt;
import com.wanniu.game.monster.GuildBossRatioConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.GuildBossPo;
import com.wanniu.game.poes.GuildPO;
import com.wanniu.game.poes.InspirePO;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.game.team.TeamData;
import com.wanniu.redis.PlayerPOManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pomelo.area.GuildBossHandler;
import pomelo.area.PlayerHandler;


public class GuildBossManager
        extends ModuleManager {
    private WNPlayer player;
    private MapBase mapProp;

    public GuildBossManager(WNPlayer player) {
        this.player = player;
        this.mapProp = GuildBossService.getInstance().getGuildBossMap();
    }

    public String handleEnterGuildBossArea() {
        GuildPO guildPo = this.player.guildManager.getGuildInfo();
        String msg = canEnter(guildPo);
        if (msg == null) {
            String instanceId = GuildBossCenter.getInstance().getGuildBossScenceIdByGuildId(guildPo.id, guildPo);
            if (instanceId == null) {
                Out.info(new Object[]{"仙盟活动有新的工会进入场景。。。guildId=", guildPo.id});
                Area area = GuildBossService.getInstance().enterGuildBossSence(this.player, GuildBossService.getInstance().getGuildBossLevel());
                GuildBossCenter.getInstance().addOneGuildId(guildPo.id, area.instanceId, guildPo);
            } else {
                Area area = AreaUtil.getArea(instanceId);
                if (area == null) {
                    Out.warn(new Object[]{"发现有玩家在进工会BOSS场景的时候发现场景为空,guildId=", guildPo.id});
                    area = GuildBossService.getInstance().enterGuildBossSence(this.player, GuildBossService.getInstance().getGuildBossLevel());
                    GuildBossCenter.getInstance().addOneGuildId(guildPo.id, area.instanceId, guildPo);
                } else {
                    AreaUtil.dispatchByInstanceId(this.player, new AreaData(52001, instanceId));
                }
            }
        }
        return msg;
    }


    public Map<String, Integer> calAllInfluence() {
        Map<String, Integer> map = new HashMap<>();
        if (this.player.area == null) {
            return map;
        }
        if (this.player.area.areaId == 52001) {
            GuildPO guildPO = this.player.guildManager.guild;
            if (guildPO == null) {
                return map;
            }
            String instanceId = GuildBossCenter.getInstance().getGuildBossScenceIdByGuildIdNoLock(guildPO.id);
            if (instanceId != null) {
                Area currentArea = AreaUtil.getArea(instanceId);
                if (currentArea != null &&
                        currentArea.getActor(this.player.getId()) != null) {
                    int totalAtkAdd = ((GuildBossArea) currentArea).getTotalAtkAdd(this.player);
                    map.put(Const.PlayerBtlData.PhyPer.toString(), Integer.valueOf(totalAtkAdd));
                    map.put(Const.PlayerBtlData.MagPer.toString(), Integer.valueOf(totalAtkAdd));
                    int totalDefAdd = ((GuildBossArea) currentArea).getTotalDefAdd(this.player);
                    map.put(Const.PlayerBtlData.Def.toString(), Integer.valueOf(totalDefAdd / 100));
                }
            }
        } else {

            return map;
        }
        return map;
    }


    public String handlerInspireGuildBoss(int index) {
        GuildPO guildPO = this.player.guildManager.guild;
        if (this.player.area.areaId != 52001) {
            return LangService.getValue("GUILD_BOSS_INSPIRE_SCENE");
        }
        InspirePO inspirePO = null;
        GuildBossPo guildBossPO = null;
        if (guildPO != null) {
            GuildRankBean bean = GuildBossAreaHurtRankCenter.getInstance().onlyGetGuildRankBean(guildPO.id);
            if (bean == null) {
                Out.warn(new Object[]{"在进行工会鼓舞的时候发生了未知错误2...playerId=", this.player.getId()});
                return LangService.getValue("GUILD_BOSS_INSPIRE_SCENE");
            }
            if (bean.hasKilled()) {
                return LangService.getValue("GUILD_BOSS_INSPIRE_DEAD");
            }
        }

        if (index == 1) {
            guildBossPO = getAndCheckUpdateGuildBossPo(this.player.player.id);
            inspirePO = guildBossPO.inspire;
        } else if (index == 2) {
            if (guildPO == null) {
                Out.warn(new Object[]{"在进行工会鼓舞的时候发生了未知错误...playerId=", this.player.getId()});
                return LangService.getValue("PLAYER_PRO_ILLEGALITY");
            }
            inspirePO = getAndCheckGuildBossAtkPoForGuild(guildPO);
        } else if (index == 3) {
            if (guildPO == null) {
                Out.warn(new Object[]{"在进行工会鼓舞的时候发生了未知错误...playerId=", this.player.getId()});
                return LangService.getValue("PLAYER_PRO_ILLEGALITY");
            }
            inspirePO = getAndCheckGuildBossDefPoForGuild(guildPO);
        } else {
            return LangService.getValue("PARAM_ERROR");
        }
        int currentCount = inspirePO.count;
        int nextCount = currentCount + 1;
        InspireLevelExt co = GuildBossRatioConfig.getInspireLevelCO(index, nextCount);
        if (co == null) {
            return LangService.getValue("GUILD_BOSS_INSPIRE_MAXCOUNT");
        }
        boolean isEnoughMoney = this.player.moneyManager.costTicketAndDiamond(co.inspireCost, Const.GOODS_CHANGE_TYPE.BOSS_GUILD_INSPIRE).isSuccess();
        if (!isEnoughMoney) {
            return LangService.getValue("TICKET_NOT_ENOUGH");
        }
        inspirePO.count = nextCount;
        String instanceId = GuildBossCenter.getInstance().getGuildBossScenceIdByGuildIdNoLock(guildPO.id);
        if (instanceId != null) {
            Area currentArea = AreaUtil.getArea(instanceId);
            if (currentArea != null) {
                if (index == 1) {
                    ((GuildBossArea) currentArea).receiveSinlgInspire(this.player, guildBossPO, true);
                } else if (index == 2 || index == 3) {
                    guildPO.modify = true;
                    ((GuildBossArea) currentArea).receiveGuildInspire(index, nextCount);
                    pushAllAfterinprire(guildPO.name, this.player.getName(), co.totalInspirePlus / 100, index);
                }
            }
        }
        return null;
    }

    public void pushAllAfterinprire(String guildName, String roleName, int totalAdd, int index) {
        String tempStr2 = "";
        if (index == 2) {
            tempStr2 = String.format(LangService.getValue("ACTIVITY_DAILY_GUILD_BOSS"), new Object[]{guildName, roleName, "" + totalAdd + "%", Const.TipsType.NORMAL});
        } else {
            tempStr2 = String.format(LangService.getValue("ACTIVITY_DAILY_GUILD_DEF_BOSS"), new Object[]{guildName, roleName, "" + totalAdd, Const.TipsType.NORMAL});
        }
        MessageUtil.sendRollChat(GWorld.__SERVER_ID, tempStr2, Const.CHAT_SCOPE.WORLD);
    }

    public GuildBossPo getAndCheckUpdateGuildBossPo(String playerId) {
        GuildBossPo guildBossPO = (GuildBossPo) PlayerPOManager.findPO(ConstsTR.guildBossTR, playerId, GuildBossPo.class);
        if (guildBossPO == null) {
            synchronized (this.player) {
                guildBossPO = (GuildBossPo) PlayerPOManager.findPO(ConstsTR.guildBossTR, playerId, GuildBossPo.class);
                if (guildBossPO == null) {
                    guildBossPO = new GuildBossPo();
                    PlayerPOManager.put(ConstsTR.guildBossTR, playerId, (GEntity) guildBossPO);
                }
            }
        }
        checkUpdate(guildBossPO.inspire);
        Date now = new Date();
        boolean isSameDay = DateUtil.isSameDay(guildBossPO.pointDate, now);
        if (!isSameDay) {
            guildBossPO.pointDate = new Date();
            guildBossPO.hasPoint = 0;
        }
        boolean isUpdateAuc = false;
        if (guildBossPO.aucpointDate == null) {
            isUpdateAuc = true;
        } else if (!DateUtil.isSameDay(guildBossPO.aucpointDate, now)) {
            isUpdateAuc = true;
        }
        if (isUpdateAuc) {
            guildBossPO.aucpointDate = new Date();
            guildBossPO.aucpoint = 0;
        }
        return guildBossPO;
    }

    public InspirePO getAndCheckGuildBossAtkPoForGuild(GuildPO guildPO) {
        InspirePO inspirePo = guildPO.inspire;
        if (inspirePo == null) {
            synchronized (guildPO) {
                inspirePo = guildPO.inspire;
                if (inspirePo == null) {
                    inspirePo = new InspirePO();
                    guildPO.inspire = inspirePo;
                    guildPO.modify = true;
                }
            }
        }
        if (checkUpdate(guildPO.inspire)) {
            guildPO.modify = true;
        }
        return inspirePo;
    }

    public InspirePO getAndCheckGuildBossDefPoForGuild(GuildPO guildPO) {
        InspirePO defInspirePo = guildPO.defInspire;
        if (defInspirePo == null) {
            synchronized (guildPO) {
                defInspirePo = guildPO.defInspire;
                if (defInspirePo == null) {
                    defInspirePo = new InspirePO();
                    guildPO.defInspire = defInspirePo;
                    guildPO.modify = true;
                }
            }
        }
        if (checkUpdate(guildPO.defInspire)) {
            guildPO.modify = true;
        }
        return defInspirePo;
    }

    private boolean checkUpdate(InspirePO inspire) {
        if (inspire == null || inspire.date == null) {
            return false;
        }
        Date now = new Date();
        boolean isSameDay = DateUtil.isSameDay(inspire.date, now);
        if (!isSameDay) {
            inspire.count = 0;
            inspire.date = now;
            return true;
        }

        return false;
    }

    public String handlerGetBossInfo(GuildBossHandler.GetGuildBossInfoResponse.Builder res) {
        GuildPO guildPo = this.player.guildManager.getGuildInfo();
        String msg = canShow(guildPo);
        if (msg == null) {
            if (GuildBossCenter.getInstance().isOpen()) {
                GuildBossPo guildBossPO = this.player.guildBossManager.getAndCheckUpdateGuildBossPo(this.player.player.id);
                guildBossPO.hasPoint = 1;
            }
            pushScripts();
            String guildId = guildPo.id;
            int rank = 1;
            List<RankBean> list = null;
            if (GuildBossCenter.getInstance().isOpen()) {
                list = this.player.guildBossAreaHurtRankManager.getRankBeanListOnBegin(guildId);
            } else {
                list = this.player.guildBossAreaHurtRankManager.getAndSetRankBeanList(guildId);
            }
            if (list != null && !list.isEmpty()) {
                for (RankBean rankBean : list) {
                    GuildBossHandler.GuildBossRankInfo.Builder bd = getGuildBossRankInfo(rankBean, rank++);
                    res.addRankList(bd);
                }
            }
            GuildRankBean bean = GuildBossAreaHurtRankCenter.getInstance().onlyGetGuildRankBean(guildId);
            if (bean == null) {
                res.setKilled(false);
            } else if (bean.hasKilled()) {
                res.setKilled(true);
            } else {
                res.setKilled(false);
            }
        }

        return msg;
    }

    private GuildBossHandler.GuildBossRankInfo.Builder getGuildBossRankInfo(RankBean bean, int rank) {
        String playerId = bean.getId();
        PlayerPO po = PlayerUtil.getPlayerBaseData(playerId);
        if (po != null) {
            GuildBossHandler.GuildBossRankInfo.Builder bd = GuildBossHandler.GuildBossRankInfo.newBuilder();
            bd.setDamage(bean.getHurt());
            bd.setId(playerId);
            bd.setName(po.name);
            bd.setPro(po.pro);
            bd.setLevel(po.level);
            bd.setRank(rank);
            return bd;
        }
        Out.warn(new Object[]{"根据工会BOSS伤害排行榜获取某个玩家的数据的时候发现角色不存在！,playerId=", playerId});
        return null;
    }


    public List<PlayerHandler.SuperScriptType> getSuperScript() {
        boolean isOpen = GuildBossCenter.getInstance().isOpen();
        GuildBossPo guildBossPO = this.player.guildBossManager.getAndCheckUpdateGuildBossPo(this.player.player.id);
        List<PlayerHandler.SuperScriptType> list = new ArrayList<>();

        PlayerHandler.SuperScriptType.Builder data2 = PlayerHandler.SuperScriptType.newBuilder();
        data2.setType(Const.SUPERSCRIPT_TYPE.GUILD_BOSS.getValue());
        if (isOpen && guildBossPO.hasPoint == 0) {
            data2.setNumber(1);
        } else {
            data2.setNumber(0);
        }
        list.add(data2.build());
        return list;
    }

    public boolean needUpdateRedPoint() {
        boolean isOpen = GuildBossCenter.getInstance().isOpen();
        GuildBossPo guildBossPO = this.player.guildBossManager.getAndCheckUpdateGuildBossPo(this.player.player.id);
        if (isOpen && guildBossPO.hasPoint == 0) {
            return true;
        }
        return false;
    }

    public void pushScripts() {
        PlayerHandler.SuperScriptPush.Builder data = PlayerHandler.SuperScriptPush.newBuilder();
        List<PlayerHandler.SuperScriptType> list = getSuperScript();
        if (list != null && !list.isEmpty()) {
            data.addAllS2CData(list);
            this.player.receive("area.playerPush.onSuperScriptPush", (GeneratedMessage) data.build());
        }
        this.player.guildManager.pushRedPoint();
    }


    private String canEnter(GuildPO guildPo) {
        if (guildPo == null) {
            return LangService.getValue("DUNGEON_GUILDBOSS_NOT_GUILDMEMBER");
        }
        GuildRankBean bean = GuildBossAreaHurtRankCenter.getInstance().onlyGetGuildRankBean(guildPo.id);
        if (bean != null && bean.hasKilled()) {
            return LangService.getValue("DUNGEON_GUILDBOSS_BOSS_DEAD");
        }
        if (this.mapProp.reqUpLevel > 0 && (this.player.getPlayer()).upLevel < this.mapProp.reqUpLevel)
            return LangService.getValue("PLAER_UPLEVEL_NOT_ENOUGH");
        if (this.mapProp.reqLevel > 0 && this.player.getLevel() < this.mapProp.reqLevel) {
            return LangService.getValue("PLAYER_LEVEL_NOT_ENOUGH") + this.mapProp.reqUpLevel;
        }
        if (GuildBossCenter.getInstance().isOpen()) {

            Map<String, TeamData.TeamMemberData> members = this.player.getTeamManager().getTeamMembers();
            if (members == null || members.isEmpty()) {
                return null;
            }
            for (TeamData.TeamMemberData member : members.values()) {
                if (member.getPlayer() == null || (member.getPlayer()).guildManager == null || (member.getPlayer()).guildManager.guild == null)
                    return LangService.getValue("DUNGEON_GUILDBOSS_NOT_JOIN_GUILD");
                if (!(member.getPlayer()).guildManager.guild.id.equals(guildPo.id)) {
                    return LangService.getValue("DUNGEON_GUILDBOSS_NOT_SAME_GUILD");
                }
            }
            return null;
        }
        return LangService.getValue("DUNGEON_GUILDBOSS_NOT_OPEN");
    }


    private String canShow(GuildPO guildPo) {
        if (guildPo == null) {
            return LangService.getValue("DUNGEON_GUILDBOSS_NOT_GUILDMEMBER");
        }
        return null;
    }


    public void onPlayerEvent(Const.PlayerEventType eventType) {
    }


    public Const.ManagerType getManagerType() {
        return Const.ManagerType.GUILD_BOSS;
    }
}


