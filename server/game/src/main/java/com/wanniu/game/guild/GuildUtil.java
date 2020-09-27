package com.wanniu.game.guild;

import com.wanniu.core.game.LangService;
import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.Utils;
import com.wanniu.game.data.BlessItemCO;
import com.wanniu.game.data.GDungeonCO;
import com.wanniu.game.data.GTechnologyItemCO;
import com.wanniu.game.data.GTechnologyLevelCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.GuildBuildingCO;
import com.wanniu.game.data.GuildContributeCO;
import com.wanniu.game.data.GuildLevelCO;
import com.wanniu.game.data.GuildPositionCO;
import com.wanniu.game.data.WareHouseLevelCO;
import com.wanniu.game.data.WareHouseValueCO;
import com.wanniu.game.data.ext.BlessBuffExt;
import com.wanniu.game.data.ext.BlessLevelExt;
import com.wanniu.game.data.ext.GBuffExt;
import com.wanniu.game.data.ext.GShopExt;
import com.wanniu.game.data.ext.GTechnologyExt;
import com.wanniu.game.data.ext.GuildSettingExt;
import com.wanniu.game.guild.dao.GuildApplyDao;
import com.wanniu.game.guild.dao.GuildBlessDao;
import com.wanniu.game.guild.dao.GuildDao;
import com.wanniu.game.guild.dao.GuildDepotDao;
import com.wanniu.game.guild.dao.GuildImpeachDao;
import com.wanniu.game.guild.dao.GuildMemberDao;
import com.wanniu.game.guild.guidDepot.GuildCond;
import com.wanniu.game.guild.guidDepot.GuildDepotCondition;
import com.wanniu.game.guild.guidDepot.GuildRecordData;
import com.wanniu.game.guild.guildImpeach.GuildImpeachData;
import com.wanniu.game.guild.po.GuildBlessPO;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.GuildApplyPO;
import com.wanniu.game.poes.GuildDepotPO;
import com.wanniu.game.poes.GuildDungeonPO;
import com.wanniu.game.poes.GuildMemberPO;
import com.wanniu.game.poes.GuildPO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pomelo.guild.GuildManagerHandler;


public class GuildUtil {
    public static String getUpLevelName(int upLevel) {
        return "";
    }

    public static GuildSettingExt getGuildSettingExtProp() {
        Map<Integer, GuildSettingExt> list = GameData.GuildSettings;
        Iterator<GuildSettingExt> iterator = list.values().iterator();
        if (iterator.hasNext()) {
            GuildSettingExt setting = iterator.next();
            return setting;
        }

        return null;
    }

    public static Map<Integer, GuildLevelCO> getGuileLevelPropList() {
        return GameData.GuildLevels;
    }

    public static GuildLevelCO getGuildLevelPropByLevel(int level) {
        return (GuildLevelCO) GameData.GuildLevels.get(Integer.valueOf(level));
    }

    public static Map<Integer, GuildPositionCO> getGuildJobPositon() {
        return GameData.GuildPositions;
    }

    public static Map<Integer, String> getJobNameMap() {
        Map<Integer, GuildPositionCO> list = getGuildJobPositon();
        Map<Integer, String> jobNames = new HashMap<>();
        for (Integer key : list.keySet()) {
            jobNames.put(key, ((GuildPositionCO) list.get(key)).position);
        }
        return jobNames;
    }

    public static GuildPositionCO getGuildJobPropByJobId(int job) {
        return (GuildPositionCO) GameData.GuildPositions.get(Integer.valueOf(job));
    }

    public static Map<String, GuildContributeCO> getGuildContributePropMap() {
        return GameData.GuildContributes;
    }

    static GuildContributeCO getGuildContributePropByType(int type) {
        List<GuildContributeCO> list = GameData.findGuildContributes(t -> (t.type == type));


        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public static WareHouseLevelCO getDepotLevelProp(int level) {
        return (WareHouseLevelCO) GameData.WareHouseLevels.get(Integer.valueOf(level));
    }


    public static WareHouseValueCO getDepotDepositValueProp(int level, int qColor) {
        List<WareHouseValueCO> list = GameData.findWareHouseValues(t -> (t.equipLv == level && t.equipColor == qColor));

        if (list.size() > 0) {
            return list.get(0);
        }

        return null;
    }

    public static GuildBuildingCO getGuildBuildingProp(int buildingId) {
        return (GuildBuildingCO) GameData.GuildBuildings.get(Integer.valueOf(buildingId));
    }

    public static List<BlessItemCO> getBlessItemListByLevel(int level) {
        return GameData.findBlessItems(t -> (t.blessLevel == level));
    }


    public static BlessItemCO getBlessItemById(int id) {
        return (BlessItemCO) GameData.BlessItems.get(Integer.valueOf(id));
    }

    public static BlessLevelExt getBlessPropByLevel(int level) {
        return (BlessLevelExt) GameData.BlessLevels.get(Integer.valueOf(level));
    }

    public static BlessBuffExt getBlessBuffProp(int buffID) {
        return (BlessBuffExt) GameData.BlessBuffs.get(Integer.valueOf(buffID));
    }


    public static Map<String, Integer> getBlessBuffAttrs(List<Integer> buffIdArray) {
        Map<String, Integer> attrs = new HashMap<>();
        for (int i = 0; i < buffIdArray.size(); i++) {
            BlessBuffExt buffProp = getBlessBuffProp(((Integer) buffIdArray.get(i)).intValue());
            String attrKey = buffProp.attr.getString("attrKey");
            int attrValue = buffProp.attr.getIntValue("attrValue");

            if (!attrs.containsKey(attrKey)) {
                attrs.put(attrKey, Integer.valueOf(attrValue));
            } else {
                int tmpValue = ((Integer) attrs.get(attrKey)).intValue();
                attrs.put(attrKey, Integer.valueOf(tmpValue + attrValue));
            }
        }
        return attrs;
    }


    public static List<Map<String, Integer>> getBlessBuffAttrsList(List<Integer> buffIdArray) {
        List<Map<String, Integer>> attrs = new ArrayList<>();
        for (int i = 0; i < buffIdArray.size(); i++) {
            BlessBuffExt buffProp = getBlessBuffProp(((Integer) buffIdArray.get(i)).intValue());
            if (null != buffProp && null != buffProp.attr) {


                String attrKey = buffProp.attr.getString("attrKey");
                int attrValue = buffProp.attr.getInteger("attrValue").intValue();
                Map<String, Integer> attr = new HashMap<>();
                attr.put(attrKey, Integer.valueOf(attrValue));
                attrs.add(attr);
            }
        }
        return attrs;
    }

    public static List<GShopExt> getShopPropList() {
        return GameData.findGShops(t -> (t.isValid == 1));
    }


    public static GShopExt getShopPropById(int id) {
        return (GShopExt) GameData.GShops.get(Integer.valueOf(id));
    }

    public static GTechnologyLevelCO getTechLevelPropByLevel(int level) {
        return (GTechnologyLevelCO) GameData.GTechnologyLevels.get(Integer.valueOf(level));
    }

    public static List<GTechnologyExt> findGuildTechSkillPropsByTechIDAndTechLevel(int techID, int techLevel) {
        return GameData.findGTechnologys(t -> (t.techID == techID && t.techLevel == techLevel));
    }

    public static GTechnologyExt getTechSkillPropByIdLevel(int id, int level) {
        List<GTechnologyExt> list = findGuildTechSkillPropsByTechIDAndTechLevel(id, level);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public static List<GTechnologyExt> findGuildTechSkillPropsByTechLevel(int techLevel) {
        return GameData.findGTechnologys(t -> (t.techLevel == techLevel));
    }


    public static List<Integer> getTechSkillIdList() {
        List<Integer> skills = new ArrayList<>();
        List<GTechnologyExt> list = findGuildTechSkillPropsByTechLevel(1);
        for (int i = 0; i < list.size(); i++) {
            skills.add(Integer.valueOf(((GTechnologyExt) list.get(i)).techID));
        }
        return skills;
    }

    public static Map<Integer, GTechnologyItemCO> getTechProducePropList() {
        return GameData.GTechnologyItems;
    }

    public static GTechnologyItemCO getTechProducePropById(int id) {
        return (GTechnologyItemCO) GameData.GTechnologyItems.get(Integer.valueOf(id));
    }

    public static GBuffExt getTechBuffPropByLevel(int level) {
        return (GBuffExt) GameData.GBuffs.get(Integer.valueOf(level));
    }

    public static void updateGuild(GuildPO guildData) {
        GuildDao.updateGuild(guildData);
    }

    public static void removeGuild(GuildPO guildPo) {
        GuildDao.removeGuild(guildPo);
    }

    public static void updateGuildMember(GuildMemberPO memberData) {
        GuildMemberDao.updateGuildMember(memberData);
    }

    public static void addGuildApply(GuildApplyPO applyData) {
        GuildApplyDao.addGuildApply(applyData);
    }

    public static void updateGuildImpeach(GuildImpeachData impeachData) {
        GuildImpeachDao.updateGuildImpeach(impeachData);
    }

    public static GuildPO getGuild(String guildId) {
        return GuildDao.getGuild(guildId);
    }

    public static GuildPO getPlayerGuild(String playerId) {
        GuildMemberPO po = getGuildMember(playerId);
        if (null == po) {
            return null;
        }

        return getGuild(po.guildId);
    }

    public static String getGuildName(String playerId) {
        GuildPO guild = getPlayerGuild(playerId);
        return (guild == null) ? LangService.getValue("TEAM_NO_GUILD") : guild.name;
    }


    public static GuildMemberPO getGuildMember(String playerId) {
        return GuildMemberDao.getGuildMember(playerId);
    }

    public static GuildApplyPO getGuildApply(String applyId) {
        return GuildApplyDao.getGuildApply(applyId);
    }

    public static GuildImpeachData getGuildImpeach(String guildId) {
        return GuildImpeachDao.getGuildImpeach(guildId);
    }

    public static void removeGuildNameIndex(int logicServerId, String guildName) {
        GuildDao.removeGuildNameIndex(guildName);
    }

    public static void removeGuildMember(String playerId) {
        GuildMemberDao.removeGuildMember(playerId);
    }

    public static void removeGuildApply(String applyId) {
        GuildApplyDao.removeGuildApply(applyId);
    }

    public static List<GuildPO> getGuildList(int logicServerId, String name) {
        return GuildDao.getGuildList(logicServerId, name);
    }


    public static List<String> getMemberIds(Const.GuildJob... jobs) {
        List<String> ids = new ArrayList<>();

        for (GuildMemberPO member : GuildMemberDao.PlayerMemberMap.values()) {
            for (Const.GuildJob job : jobs) {
                if (member.job == job.getValue()) {
                    ids.add(member.playerId);
                }
            }
        }

        return ids;
    }

    public static Set<String> getGuildMemberIdList(String guildId) {
        return GuildMemberDao.getGuildMemberIdList(guildId);
    }

    public static int getGuildMemberCount(String guildId) {
        return GuildMemberDao.getGuildMemberCount(guildId);
    }

    public static List<GuildMemberPO> getGuildMemberList(String guildId) {
        List<GuildMemberPO> list = new ArrayList<>();
        Set<String> idList = getGuildMemberIdList(guildId);
        for (String id : idList) {
            GuildMemberPO member = getGuildMember(id);
            list.add(member);
        }
        return list;
    }

    public static int getGuildMemberCountByJob(String guildId, int job) {
        int count = 0;
        Set<String> idList = getGuildMemberIdList(guildId);
        for (String id : idList) {
            GuildMemberPO member = getGuildMember(id);
            if (member.job == job) {
                count++;
            }
        }
        return count;
    }

    public static int getGuildApplyCount(String guildId) {
        return GuildApplyDao.getGuildApplyCount(guildId);
    }

    public static List<GuildApplyPO> getGuildApplyList(String guildId) {
        return GuildApplyDao.getGuildApplyList(guildId);
    }

    public static List<GuildApplyPO> getPlayerApplyIdList(String playerId) {
        return GuildApplyDao.getPlayerApplyIdList(playerId);
    }

    public static boolean isInGuild(String playerId) {
        GuildMemberPO guildMember = getGuildMember(playerId);
        if (null != guildMember) {
            return true;
        }
        return false;
    }

    public static String getGuildByFullName(String name) {
        return GuildDao.getGuildIdByName(name);
    }

    public static boolean existGuildName(int logicServerId, String name) {
        String guildId = getGuildByFullName(name);
        return StringUtil.isNotEmpty(guildId);
    }

    public static GuildDepotPO getGuildDepot(String guildId) {
        return GuildDepotDao.getDepot(guildId);
    }

    public static ArrayList<GuildDepotPO> getGuildDepotList() {
        return GuildDepotDao.getDepotList();
    }

    public static void updateGuildDepot(GuildDepotPO data) {
        GuildDepotDao.updateDepot(data);
    }


    public static boolean checkCondition(GuildDepotCondition cond) {
        GuildSettingExt settingProp = getGuildSettingExtProp();
        if (cond.minCond.qColor < settingProp.warehouseMinQ || cond.maxCond.qColor < settingProp.warehouseMinQ) {
            return false;
        }


        if (cond.maxCond.level == 0 && cond.maxCond.level < settingProp.warehouseMinLv) {
            return false;
        }
        return lessCompare(cond.minCond, cond.maxCond, false);
    }


    public static boolean isInCondition(GuildCond quality, GuildDepotCondition cond) {
        return (lessCompare(cond.minCond, quality, true) && lessCompare(quality, cond.maxCond, true));
    }


    public static boolean lessCompare(GuildCond minCond, GuildCond maxCond, boolean canEqual) {
        if (minCond.level != maxCond.level)
            return (minCond.level < maxCond.level);
        if (minCond.qColor != maxCond.qColor) {
            return (minCond.qColor < maxCond.qColor);
        }

        if (canEqual) {
            return true;
        }
        return false;
    }


    public static ArrayList<GuildBlessPO> getGuildBlessList() {
        return GuildBlessDao.getGuildBlessList();
    }

    public static void updateGuildBless(GuildBlessPO blessData) {
        GuildBlessDao.updateGuildBless(blessData);
    }

    public static GDungeonCO getGuildDungeonConfig() {
        Map<String, GDungeonCO> map = GameData.GDungeons;
        if (map.size() > 0) {
            return map.get("0");
        }
        return null;
    }

    public static GuildDungeonPO getGuildDungeon(String id) {
        return GuildServiceCenter.getInstance().getGuildDungeon(id);
    }

    public static void updateGuildDungeon(GuildDungeonPO guildDungeonData) {
        GuildDao.updateGuildDungeon(guildDungeonData);
    }

    public static ArrayList<GuildDungeonPO> getAllGuildDungeon() {
        return new ArrayList<>();
    }

    public static GuildManagerHandler.QualityCond qualityCond(int level, int upLevel, int qColor) {
        GuildManagerHandler.QualityCond.Builder cond = GuildManagerHandler.QualityCond.newBuilder();
        cond.setLevel(level);
        cond.setUpLevel(upLevel);
        cond.setQColor(qColor);

        return cond.build();
    }

    public GuildRecordData getNewGuildReocrd(int type, RoleInfo role1, RoleInfo role2) {
        GuildRecordData record = new GuildRecordData();
        record.type = Const.GuildRecord.UPGRADE.getValue();
        if (null != role1) {
            record.role1 = new RoleInfo();
            record.role1.pro = role1.pro;
            record.role1.name = role1.name;
        }

        if (null != role2) {
            record.role2.pro = role2.pro;
            record.role2.name = role2.name;
        }

        return record;
    }

    public static GuildResult checkGuildMember(String playerId) {
        GuildResult ret = new GuildResult();
        GuildMemberPO myInfo = GuildServiceCenter.getInstance().getGuildMember(playerId);
        GuildPO myGuild = GuildServiceCenter.getInstance().getGuild(myInfo.guildId);
        if (null == myInfo || null == myGuild) {
            ret.result = -1;
            ret.des = "不是公会成员";
            return ret;
        }
        return null;
    }

    public static void broadcast(String guildId, Message msg) {
        getGuildMemberIdList(guildId).forEach(playerId -> {
            WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
            if (player != null) {
                player.receive(msg);
            }
        });
    }


    public static void refreshGuildJobPush(WNPlayer player) {
        if (null != player) {
            GuildManager guildManager = player.guildManager;
            String guildId = guildManager.getGuildId();
            String guildName = guildManager.getGuildName();
            int guildJob = guildManager.getJob();
            String guildIcon = guildManager.getGuildIcon();
            player.pushDynamicData(Utils.ofMap(new Object[]{"guildId", guildId, "guildName", guildName, "guildJob", Integer.valueOf(guildJob), "guildIcon", guildIcon}));
        }
    }
}


