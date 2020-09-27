package com.wanniu.game.util;

import com.alibaba.fastjson.JSON;
import com.wanniu.core.db.GCache;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.game.entity.GEntity;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.RandomUtil;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.area.Area;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.Utils;
import com.wanniu.game.data.base.DItemBase;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.player.WNRobot;
import com.wanniu.game.player.po.AllBlobPO;
import com.wanniu.game.poes.MountPO;
import com.wanniu.game.poes.PlayerBasePO;
import com.wanniu.game.poes.PlayerPetsNewPO;
import com.wanniu.game.poes.SkillsPO;
import com.wanniu.game.request.bag.UseItemHandler;
import com.wanniu.game.team.TeamData;
import com.wanniu.game.team.TeamUtil;
import com.wanniu.redis.GameDao;
import com.wanniu.redis.PlayerPOManager;

import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


public final class RobotUtil {
    private static final String BASE = "base/";
    private static final String SKILL = "skill/";
    private static final String MOUNT = "mount/";
    private static final String PET = "pet/";
    public static Map<Integer, Map<Integer, String>> SkillEntities = new ConcurrentHashMap<>();

    public static Map<Integer, Map<Integer, String>> BaseEntities = new ConcurrentHashMap<>();

    public static Map<Integer, Map<Integer, String>> MountEntities = new ConcurrentHashMap<>();

    public static Map<Integer, Map<Integer, String>> PetEntities = new ConcurrentHashMap<>();

    public static int[] PROS = new int[]{1, 3, 5};

    public static AtomicInteger UUID = new AtomicInteger(0);

    public static void freeRobot(WNRobot robot) {
        try {
            Area area = robot.getArea();
            if (area != null) {
                area.removePlayer((WNPlayer) robot, false);
                Out.debug(new Object[]{"robot ", robot.getName(), " removed from area ", area.getSceneName()});
            }
        } finally {
            TeamUtil.removeAcrossMatch((WNPlayer) robot);
            GWorld.Robots.remove(robot.getId());
            PlayerPOManager.pos.remove(robot.getId());
            GameDao.freeName(robot.getName());


            GCache.expire(robot.getId(), 300);
        }
    }

    private static final String MATCH_ROBOT = "MATCH_ROBOT";

    public static void newRobot(WNRobot robot) {
        GWorld.Robots.put(robot.getId(), robot);
    }


    public static void cloneRobot(WNPlayer player) {
        int lv = player.getLevel();
        if (lv < GlobalConfig.Robot_Level) {
            return;
        }
        int pro = player.getPro();
        String field = lv + "/" + pro;

        Map<Integer, String> pro_skills = SkillEntities.get(Integer.valueOf(lv));
        if (pro_skills == null) {
            pro_skills = new ConcurrentHashMap<>();
            SkillEntities.put(Integer.valueOf(lv), pro_skills);
        }
        if (!pro_skills.containsKey(Integer.valueOf(pro))) {
            String skill = Utils.serialize(player.skillManager.player_skills);
            pro_skills.put(Integer.valueOf(pro), skill);
            GCache.hset("MATCH_ROBOT", "skill/" + field, skill);
        }

        Map<Integer, String> pro_bases = BaseEntities.get(Integer.valueOf(lv));
        if (pro_bases == null) {
            pro_bases = new ConcurrentHashMap<>();
            BaseEntities.put(Integer.valueOf(lv), pro_bases);
        }
        if (!pro_bases.containsKey(Integer.valueOf(pro))) {
            String base = Utils.serialize(player.playerBasePO);
            pro_bases.put(Integer.valueOf(pro), base);
            GCache.hset("MATCH_ROBOT", "base/" + field, base);
        }

        if (player.mountManager.mount != null) {
            Map<Integer, String> pro_mount = MountEntities.get(Integer.valueOf(lv));
            if (pro_mount == null) {
                pro_mount = new ConcurrentHashMap<>();
                MountEntities.put(Integer.valueOf(lv), pro_mount);
            }
            if (!pro_mount.containsKey(Integer.valueOf(pro))) {
                String mount = Utils.serialize(player.mountManager.mount);
                pro_mount.put(Integer.valueOf(pro), mount);
                GCache.hset("MATCH_ROBOT", "mount/" + field, mount);
            }
        }

        if (player.petNewManager.petsPO != null) {
            Map<Integer, String> pro_pet = PetEntities.get(Integer.valueOf(lv));
            if (pro_pet == null) {
                pro_pet = new ConcurrentHashMap<>();
                PetEntities.put(Integer.valueOf(lv), pro_pet);
            }
            if (!pro_pet.containsKey(Integer.valueOf(pro))) {
                String pet = Utils.serialize(player.petNewManager.petsPO);
                pro_pet.put(Integer.valueOf(pro), pet);
                GCache.hset("MATCH_ROBOT", "pet/" + field, pet);
            }
        }
    }


    public static String getTemplate(String key, int lv, int pro) {
        Map<Integer, Map<Integer, String>> entities = null;
        switch (key) {
            case "base/":
                entities = BaseEntities;
                break;

            case "skill/":
                entities = SkillEntities;
                break;

            case "mount/":
                entities = MountEntities;
                break;

            case "pet/":
                entities = PetEntities;
                break;

            default:
                return null;
        }

        Map<Integer, String> entity = entities.get(Integer.valueOf(lv));
        if (entity == null) {
            entity = new ConcurrentHashMap<>();
            entities.put(Integer.valueOf(lv), entity);
        }
        if (entity.containsKey(Integer.valueOf(pro))) {
            return entity.get(Integer.valueOf(pro));
        }

        String field = key + lv + "/" + pro;
        String template = GCache.hget("MATCH_ROBOT", field);
        if (StringUtil.isNotEmpty(template)) {
            entity.put(Integer.valueOf(pro), template);
            return template;
        }
        return null;
    }

    public static void initMathData(int lv) {
        for (int pro : PROS) {
            if (getTemplate("base/", lv, pro) != null) {


                getTemplate("skill/", lv, pro);
                getTemplate("mount/", lv, pro);
                getTemplate("pet/", lv, pro);
            }
        }
    }

    public static AllBlobPO matchRobot(WNPlayer fromPlayer, int minLevel) {
        int maxLevel = fromPlayer.getLevel();
        if (minLevel > maxLevel) {
            return null;
        }
        WNPlayer mirror = null, tmpPlayer = null;
        for (GPlayer player : GWorld.getInstance().getOnlinePlayers().values()) {
            tmpPlayer = (WNPlayer) player;
            if (tmpPlayer.getLevel() >= minLevel && tmpPlayer.getLevel() <= maxLevel && (tmpPlayer != fromPlayer || tmpPlayer.getPro() != fromPlayer.getPro())) {
                TeamData team = fromPlayer.teamManager.getTeam();
                if (team == null)
                    return null;
                boolean noPro = true;
                for (String str : team.teamMembers.keySet()) {
                    WNPlayer actor = team.getPlayer(str);
                    if (actor != null && actor.getPro() == fromPlayer.getPro()) {
                        noPro = false;
                        break;
                    }
                }
                if (noPro) {
                    mirror = tmpPlayer;
                }
            }
        }

        int pro = fromPlayer.getPro();
        int level = fromPlayer.getLevel();
        SkillsPO player_skill = null;
        PlayerBasePO player_base = null;
        MountPO player_mount = null;
        PlayerPetsNewPO player_pet = null;

        if (mirror != null) {
            pro = mirror.getPro();
            level = mirror.getLevel();
        } else {
            int matchLv = RandomUtil.getInt(minLevel, maxLevel);
            initMathData(matchLv);
            if (SkillEntities.containsKey(Integer.valueOf(matchLv)) && BaseEntities.containsKey(Integer.valueOf(matchLv))) {
                Map<Integer, String> skills = SkillEntities.get(Integer.valueOf(matchLv));
                Map<Integer, String> bases = BaseEntities.get(Integer.valueOf(matchLv));
                Map<Integer, String> mounts = MountEntities.get(Integer.valueOf(matchLv));
                Map<Integer, String> pets = PetEntities.get(Integer.valueOf(matchLv));
                int matchPro = PROS[RandomUtil.getIndex(PROS.length)];
                if (!skills.containsKey(Integer.valueOf(matchPro)) || !bases.containsKey(Integer.valueOf(matchPro))) {
                    for (Iterator<Integer> iterator = skills.keySet().iterator(); iterator.hasNext(); ) {
                        int tmpPro = ((Integer) iterator.next()).intValue();
                        if (tmpPro != fromPlayer.getPro() && bases.containsKey(Integer.valueOf(tmpPro))) {
                            matchPro = tmpPro;
                            break;
                        }
                    }

                }
                if (skills.containsKey(Integer.valueOf(matchPro)) && bases.containsKey(Integer.valueOf(matchPro))) {
                    pro = matchPro;
                    level = matchLv;
                    player_skill = (SkillsPO) Utils.deserialize(skills.get(Integer.valueOf(matchPro)), SkillsPO.class);
                    player_base = (PlayerBasePO) Utils.deserialize(bases.get(Integer.valueOf(matchPro)), PlayerBasePO.class);
                    if (mounts.containsKey(Integer.valueOf(matchPro))) {
                        player_mount = (MountPO) Utils.deserialize(mounts.get(Integer.valueOf(matchPro)), MountPO.class);
                    }
                    if (pets.containsKey(Integer.valueOf(matchPro))) {
                        player_pet = (PlayerPetsNewPO) Utils.deserialize(pets.get(Integer.valueOf(matchPro)), PlayerPetsNewPO.class);
                    }
                }
            }
        }

        String name = PlayerUtil.getRandomName(pro);
        String playerId = UUID.randomUUID().toString();
        boolean isPutSuccess = GameDao.putName(name, playerId);
        if (!isPutSuccess) {
            Out.warn(new Object[]{"发现有机器人重名,创角失败!", name});
            return null;
        }

        if (mirror == null) {
            mirror = fromPlayer;
        }

        if (player_skill == null) {
            player_skill = mirror.skillManager.player_skills;
            player_skill = (SkillsPO) Utils.deserialize(Utils.serialize(player_skill), SkillsPO.class);
        }

        if (player_base == null) {
            player_base = (PlayerBasePO) Utils.deserialize(Utils.serialize(mirror.playerBasePO), PlayerBasePO.class);
            if (mirror.mountManager.mount != null) {
                player_mount = (MountPO) Utils.deserialize(Utils.serialize(mirror.mountManager.mount), MountPO.class);
            }
            if (mirror.petNewManager.petsPO != null) {
                player_pet = (PlayerPetsNewPO) Utils.deserialize(Utils.serialize(mirror.petNewManager.petsPO), PlayerPetsNewPO.class);
            }
        }
        String robotId = String.valueOf("RO-" + UUID.incrementAndGet());
        AllBlobPO allBlob = PlayerUtil.createPlayer(playerId, robotId, name, pro, fromPlayer.getLogicServerId());
        allBlob.player.uid = robotId;
        allBlob.player.level = level;
        allBlob.player.exp = allBlob.player.exp;
        PlayerPOManager.put(ConstsTR.skillTR, playerId, (GEntity) player_skill);

        allBlob.playerBase = player_base;
        PlayerPOManager.put(ConstsTR.playerBaseTR, playerId, (GEntity) player_base);

        if (player_mount != null) {
            allBlob.player.openMount = true;
            PlayerPOManager.put(ConstsTR.mountTR, playerId, (GEntity) player_mount);
        }

        if (player_pet != null) {
            PlayerPOManager.put(ConstsTR.playerPetTR, playerId, (GEntity) player_pet);
        }

        return allBlob;
    }

    public static void onRobotDie(Area area, WNPlayer robot) {
        if (robot.isRobot()) {
            Area.Actor actor = area.getActor(robot.getId());
            if (actor == null)
                return;
            if (actor.rebornNum < 99 || area.isNormal()) {
                long deleyTime = actor.reliveCoolTime - System.currentTimeMillis();
                JobFactory.addDelayJob(() -> {
                    if (!area.isClose()) {
                        area.relive(robot.getId(), (RandomUtil.getInt(100) < 70) ? area.getReliveType() : Area.ReliveType.NOW);
                    }
                }Math.max(deleyTime, Utils.getSecMills(1, 5)));
            } else {
                JobFactory.addDelayJob(() -> {
                    if (robot.getArea() == area) {
                        robot.fightLevelManager.leaveDungeon(robot, area);
                    }
                }Utils.getSecMills(5, 20));
            }
        }
    }

    public static void onRobotLeaderQuit(Area area, WNPlayer leader) {
        if (area.isNormal() || area.isClose() || leader.isRobot())
            return;
        TeamData team = leader.getTeamManager().getTeam();
        if (team != null && team.isRobotJoin) {
            for (TeamData.TeamMemberData member : team.teamMembers.values()) {
                if (member.robot && area.hasPlayer(member.id)) {
                    JobFactory.addDelayJob(() -> {
                        if (area.isAllRobot() && area.hasPlayer(member.id)) {
                            WNPlayer robot = member.getPlayer();
                            robot.fightLevelManager.leaveDungeon(robot, area);
                        }
                    }Utils.getSecMills(3, 10));
                }
            }
        }
    }


    public static void onRobotReplyHP(WNPlayer player) {
        if (!player.isRobot() || !(player instanceof WNRobot))
            return;
        WNRobot robot = (WNRobot) player;
        if (robot.hpFuture != null)
            return;
        DItemBase item = ItemUtil.getUnEquipPropByCode("hp1");
        UseItemHandler.GetItemChanagePropertyResult data = ItemUtil.getItemChanageProperty(item);
        robot.hpFuture = JobFactory.addScheduleJob(() -> {
            Area area = player.getArea();

            if (area == null || area.prop.useAgent == 0) {
                return;
            }
            data.itemData.timestamp = GWorld.APP_TIME + item.par;
            String hp = JSON.toJSONString(data.itemData);
            player.getXmdsManager().refreshPlayerPropertyChange(player.getId(), hp);
        }Utils.random(30, 60), (item.useCD + 1000));
    }
}


