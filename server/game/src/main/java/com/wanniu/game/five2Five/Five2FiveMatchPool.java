package com.wanniu.game.five2Five;

import com.wanniu.core.GConfig;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.game.team.TeamData;
import com.wanniu.game.team.TeamService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class Five2FiveMatchPool {
    private static final int TEAM_NUMBER = GConfig.getInstance().getInt("five_2_five_match_number", 1);


    private static final CopyOnWriteArrayList<Five2FiveSingleApplyVo> playerApplysPool = new CopyOnWriteArrayList<>();


    private static final CopyOnWriteArrayList<Five2FiveTeamApplyVo> teamApplysPool = new CopyOnWriteArrayList<>();


    private static final CopyOnWriteArrayList<Five2FiveMatchTeamVo> teamMatchPool = new CopyOnWriteArrayList<>();


    private static final Map<String, Five2FiveMatchTeamVo> matchedPool = new ConcurrentHashMap<>();


    private static final ReentrantReadWriteLock poolLock = new ReentrantReadWriteLock();


    private static final long MAX_WAIT_LOCK_MILL = 100L;


    public static final int getBeginNeedCount() {
        return TEAM_NUMBER;
    }


    public static void clearMatchPool() {
        playerApplysPool.clear();
        teamApplysPool.clear();
        teamMatchPool.clear();
    }


    public static final List<String> getApplyPlayer() {
        List<String> playerIds = new ArrayList<>();
        int i;
        for (i = 0; i < playerApplysPool.size(); i++) {
            WNPlayer tempPlayer = ((Five2FiveSingleApplyVo) playerApplysPool.get(i)).player;
            if (tempPlayer != null) {
                playerIds.add(tempPlayer.getId());
            }
        }
        for (i = 0; i < teamApplysPool.size(); i++) {
            Five2FiveTeamApplyVo temp = teamApplysPool.get(i);
            if (temp != null) {


                Set<String> memPlayerIds = temp.teamMembers.keySet();
                playerIds.addAll(memPlayerIds);
            }
        }
        for (i = 0; i < teamMatchPool.size(); i++) {
            Five2FiveMatchTeamVo temp = teamMatchPool.get(i);
            if (temp != null) {

                if (temp.tempTeamMember != null) {


                    List<Five2FiveTempTeamMember> tempTeamMember = temp.tempTeamMember;
                    for (int j = 0; j < tempTeamMember.size(); j++) {
                        Five2FiveTempTeamMember tempMem = tempTeamMember.get(j);
                        String tempMemPlayerId = tempMem.playerId;
                        playerIds.add(tempMemPlayerId);
                    }
                }
            }
        }
        return playerIds;
    }


    public static final Five2FiveMatchTeamVo removeMatchedTeam(String tempTeamId) {
        return matchedPool.remove(tempTeamId);
    }


    public static final void singlePutInApplyPool(WNPlayer player) {
        Five2FiveSingleApplyVo singleMatchVo = new Five2FiveSingleApplyVo();
        singleMatchVo.joinTime = new Date();
        singleMatchVo.player = player;
        try {
            if (!poolLock.writeLock().tryLock(100L, TimeUnit.MILLISECONDS)) {
                Out.warn(new Object[]{"Try writeLock timeout"});
            }
            playerApplysPool.add(singleMatchVo);
        } catch (Exception e) {
            Out.error(new Object[]{e});
        } finally {
            poolLock.writeLock().unlock();
        }
    }


    public static final void teamPutInApplyPool(Map<String, TeamData.TeamMemberData> teamMembers, String teamId) {
        Five2FiveTeamApplyVo teamMatchVo = new Five2FiveTeamApplyVo(teamMembers, teamId);
        teamMatchVo.joinTime = new Date();
        try {
            if (!poolLock.writeLock().tryLock(100L, TimeUnit.MILLISECONDS)) {
                Out.warn(new Object[]{"Try writeLock timeout"});
            }

            if (teamMatchVo.teamMembers.size() == TEAM_NUMBER) {
                Five2FiveMatchTeamVo tempTeam = createTempTeam(null, Arrays.asList(new Five2FiveTeamApplyVo[]{teamMatchVo}));
                if (tempTeam == null) {
                    teamApplysPool.add(teamMatchVo);
                } else {
                    teamMatchPool.add(tempTeam);
                }
            } else {
                teamApplysPool.add(teamMatchVo);
            }
        } catch (Exception e) {
            Out.error(new Object[]{e});
        } finally {
            poolLock.writeLock().unlock();
        }
    }


    public static final boolean singleRemoveApplyPool(String playerId) {
        try {
            if (!poolLock.writeLock().tryLock(100L, TimeUnit.MILLISECONDS)) {
                Out.warn(new Object[]{"Try writeLock timeout"});
            }
            int i;
            for (i = 0; i < playerApplysPool.size(); i++) {
                Five2FiveSingleApplyVo singleMatchVo = playerApplysPool.get(i);
                WNPlayer player = singleMatchVo.player;
                if (player == null) {
                    playerApplysPool.remove(singleMatchVo);

                } else if (player.getId().equals(playerId)) {
                    playerApplysPool.remove(singleMatchVo);
                    Five2FiveService.getInstance().pushMatchPool();
                    return true;
                }
            }

            for (i = 0; i < teamApplysPool.size(); i++) {
                Five2FiveTeamApplyVo teamMatchVo = teamApplysPool.get(i);
                TeamData teamData = TeamService.getTeam(teamMatchVo.teamId);
                if (teamData == null) {
                    teamApplysPool.remove(teamMatchVo);
                } else {

                    Map<String, TeamData.TeamMemberData> teamMembers = teamMatchVo.teamMembers;
                    if (teamMembers.size() == 0) {
                        teamApplysPool.remove(teamMatchVo);

                    } else if (teamMembers.containsKey(playerId)) {
                        teamApplysPool.remove(teamMatchVo);


                        for (TeamData.TeamMemberData td : teamMatchVo.teamMembers.values()) {
                            if (td.id.equals(playerId)) {
                                continue;
                            }
                            Five2FiveService.getInstance().pushCancelMatch(td.id);
                        }

                        Five2FiveService.getInstance().pushMatchPool();
                        return true;
                    }
                }
            }
            for (i = 0; i < teamMatchPool.size(); i++) {
                Five2FiveMatchTeamVo matchTeamVo = teamMatchPool.get(i);
                CopyOnWriteArrayList<Five2FiveTempTeamMember> tempTeamMember = matchTeamVo.tempTeamMember;
                for (int j = 0; j < tempTeamMember.size(); j++) {
                    Five2FiveTempTeamMember ttm = tempTeamMember.get(j);
                    String tempPlayerId = ttm.playerId;
                    if (tempPlayerId.equals(playerId)) {
                        if (matchTeamVo.useNumber.getAndAdd(1) == 0) {
                            teamMatchPool.remove(matchTeamVo);
                            if (matchTeamVo.singleMatchVos != null) {
                                List<Five2FiveSingleApplyVo> noContainThisPlayerApplys = new ArrayList<>();
                                for (int k = 0; k < matchTeamVo.singleMatchVos.size(); k++) {
                                    Five2FiveSingleApplyVo temp = matchTeamVo.singleMatchVos.get(k);
                                    if (temp.player != null) {


                                        String tempId = temp.player.getId();
                                        if (!tempId.equals(playerId))
                                            noContainThisPlayerApplys.add(temp);
                                    }
                                }
                                if (!noContainThisPlayerApplys.isEmpty()) {
                                    playerApplysPool.addAll(noContainThisPlayerApplys);
                                }
                            }
                            if (matchTeamVo.teamMatchVos != null)
                                for (int k = 0; k < matchTeamVo.teamMatchVos.size(); k++) {
                                    Five2FiveTeamApplyVo tempTeam = matchTeamVo.teamMatchVos.get(k);
                                    Map<String, TeamData.TeamMemberData> teamMembers = tempTeam.teamMembers;
                                    if (teamMembers.size() == 0 || teamMembers.containsKey(playerId)) {

                                        for (TeamData.TeamMemberData td : teamMembers.values()) {
                                            if (td.id.equals(playerId)) {
                                                continue;
                                            }
                                            Five2FiveService.getInstance().pushCancelMatch(td.id);
                                        }

                                    } else {

                                        teamApplysPool.add(tempTeam);
                                    }
                                }
                            Five2FiveService.getInstance().pushMatchPool();
                            return true;
                        }

                        break;
                    }
                }
            }
        } catch (Exception e) {
            Out.error(new Object[]{e});
        } finally {
            poolLock.writeLock().unlock();
        }

        return false;
    }


    @Deprecated
    public static final boolean teamRemoveApplyPool(String teamId) {
        int i;
        for (i = 0; i < teamApplysPool.size(); i++) {
            Five2FiveTeamApplyVo teamMatchVo = teamApplysPool.get(i);
            if (teamMatchVo.teamId.equals(teamId)) {
                teamApplysPool.remove(teamMatchVo);
                return true;
            }
        }

        for (i = 0; i < teamMatchPool.size(); i++) {
            Five2FiveMatchTeamVo matchTeamVo = teamMatchPool.get(i);
            List<Five2FiveTeamApplyVo> teamMatchVos = matchTeamVo.teamMatchVos;
            if (teamMatchVos != null) {

                for (int j = 0; j < teamMatchVos.size(); j++) {
                    Five2FiveTeamApplyVo teamMatchVo = teamMatchVos.get(j);
                    if (teamMatchVo.teamMembers.size() == 0) {
                        teamMatchPool.remove(matchTeamVo);
                    } else if (teamMatchVo.teamId.equals(teamId)) {
                        if (matchTeamVo.useNumber.getAndAdd(1) == 0) {
                            teamMatchPool.remove(matchTeamVo);
                            if (matchTeamVo.singleMatchVos != null) {
                                playerApplysPool.addAll(matchTeamVo.singleMatchVos);
                            }
                            for (int k = 0; k < teamMatchVos.size(); k++) {
                                Five2FiveTeamApplyVo teamMatchVo_1 = teamMatchVos.get(k);
                                if (!teamMatchVo_1.teamId.equals(teamId)) {
                                    teamApplysPool.add(teamMatchVo_1);
                                }
                            }
                            return true;
                        }

                        break;
                    }
                }
            }
        }
        return false;
    }


    @Deprecated
    public static final boolean teamIsMakeWithOthers(String teamId) {
        for (Map.Entry<String, Five2FiveMatchTeamVo> matchedVo : matchedPool.entrySet()) {
            Five2FiveMatchTeamVo matchTeamVo = matchedVo.getValue();
            List<Five2FiveTeamApplyVo> teamMatchVos = matchTeamVo.teamMatchVos;
            if (teamMatchVos != null) {
                for (int j = 0; j < teamMatchVos.size(); j++) {
                    Five2FiveTeamApplyVo teamMatchVo = teamMatchVos.get(j);
                    String teamMatchId = teamMatchVo.teamId;
                    if (teamMatchId.equals(teamId)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public static final Date applyMatchTime(String playerId) {
        int i;
        for (i = 0; i < playerApplysPool.size(); i++) {
            Five2FiveSingleApplyVo singleMatchVo = playerApplysPool.get(i);
            if (singleMatchVo.player.getId().equals(playerId)) {
                return singleMatchVo.joinTime;
            }
        }

        for (i = 0; i < teamApplysPool.size(); i++) {
            Five2FiveTeamApplyVo teamMatchVo = teamApplysPool.get(i);
            Map<String, TeamData.TeamMemberData> teamMembers = teamMatchVo.teamMembers;
            if (teamMembers.containsKey(playerId)) {
                return teamMatchVo.joinTime;
            }
        }

        for (i = 0; i < teamMatchPool.size(); i++) {
            Five2FiveMatchTeamVo matchTeamVo = teamMatchPool.get(i);
            List<Five2FiveTeamApplyVo> teamMatchVos = matchTeamVo.teamMatchVos;
            if (teamMatchVos != null) {
                for (int j = 0; j < teamMatchVos.size(); j++) {
                    Five2FiveTeamApplyVo tempTeamApplyVo = teamMatchVos.get(j);
                    Map<String, TeamData.TeamMemberData> teamMembers = tempTeamApplyVo.teamMembers;
                    if (teamMembers.containsKey(playerId)) {
                        return tempTeamApplyVo.joinTime;
                    }
                }
            }
            List<Five2FiveSingleApplyVo> singleMatchVos = matchTeamVo.singleMatchVos;
            if (singleMatchVos != null) {
                for (int j = 0; j < singleMatchVos.size(); j++) {
                    WNPlayer single = ((Five2FiveSingleApplyVo) singleMatchVos.get(j)).player;
                    if (single != null && single.getId().equals(playerId)) {
                        return ((Five2FiveSingleApplyVo) singleMatchVos.get(j)).joinTime;
                    }
                }
            }
        }


        for (Five2FiveMatchTeamVo vo : matchedPool.values()) {
            for (Five2FiveTempTeamMember m : vo.tempTeamMember) {
                if (m.playerId.equals(playerId)) {
                    return new Date();
                }
            }
        }
        return null;
    }


    public static final int getSingleApplyPoolSize() {
        return playerApplysPool.size();
    }


    public static final int getTeamApplyPoolSize() {
        return teamApplysPool.size();
    }


    public static final int getTeamMatchPoolSize() {
        return teamMatchPool.size();
    }


    public static final Five2FiveMatchTeamVo getMatchingTeam(String tempTeamId) {
        return matchedPool.get(tempTeamId);
    }


    private static final void teamMatchTeam() {
        for (int i = 0; i < teamMatchPool.size(); i++) {
            Five2FiveMatchTeamVo matchTeam = teamMatchPool.get(i);
            int totalSize = 0;
            List<Five2FiveSingleApplyVo> singleMatchVos = matchTeam.singleMatchVos;
            if (singleMatchVos != null) {
                totalSize += singleMatchVos.size();
            }
            List<Five2FiveTeamApplyVo> teamMatchVos = matchTeam.teamMatchVos;
            if (teamMatchVos != null) {
                for (int j = 0; j < teamMatchVos.size(); j++) {
                    Five2FiveTeamApplyVo teamApply = teamMatchVos.get(j);
                    Map<String, TeamData.TeamMemberData> teamMembers = teamApply.teamMembers;
                    totalSize += teamMembers.size();
                }
            }
            if (totalSize != TEAM_NUMBER) {
                teamMatchPool.remove(matchTeam);
                if (matchTeam.singleMatchVos != null) {
                    playerApplysPool.addAll(matchTeam.singleMatchVos);
                }
                if (matchTeam.teamMatchVos != null) {
                    teamApplysPool.addAll(matchTeam.teamMatchVos);
                }
            } else {

                String tempTeamId = matchTeam.tempTeamId;
                Date joinTime = matchTeam.joinTime;
                Date now = new Date();
                long diff = (now.getTime() - joinTime.getTime()) / 1000L;
                int addNumber = (int) ((diff / GlobalConfig.Group_MatchingTime == 0L) ? 1L : (diff / GlobalConfig.Group_MatchingTime));
                int teamScore = matchTeam.teamScore;
                int scoreChange = GlobalConfig.Group_PlusPoint * addNumber;
                int matchMinScore = getMinMatchScore(teamScore, scoreChange);
                int matchMaxScore = getMaxMatchScore(teamScore, scoreChange);
                Five2FiveMatchTeamVo conformTeam = getConformToRulesTeamsEqual5(tempTeamId, matchMinScore, matchMaxScore);
                if (conformTeam != null) {
                    matchSuccess(matchTeam, conformTeam);
                }
            }
        }
    }


    static final void doMatchJob() {
        if (!Five2FiveService.getInstance().isInOpenTime()) {
            return;
        }
        try {
            poolLock.writeLock().lock();
            long begin = System.currentTimeMillis();
            makeFiveTeam();
            teamMatchTeam();
            long spendTimeMill = begin - System.currentTimeMillis();
            if (spendTimeMill > 100L) {
                Out.warn(new Object[]{"5v5 doMatchJob spend too much time mills : " + spendTimeMill});
            }
        } finally {
            poolLock.writeLock().unlock();
        }
    }


    private static final void makeFiveTeam() {
        teamFindTeam();
        playerFindPlayer();
    }


    private static Five2FiveMatchTeamVo createTempTeam(List<Five2FiveSingleApplyVo> singleMatchVos, List<Five2FiveTeamApplyVo> teamMatchVos) {
        Out.debug(new Object[]{"5v5 createTempTeam"});
        Five2FiveMatchTeamVo matchVo = new Five2FiveMatchTeamVo();
        CopyOnWriteArrayList<Five2FiveTempTeamMember> tempTeamMember = new CopyOnWriteArrayList<>();
        int totalScore = 0;
        if (singleMatchVos != null) {
            for (int i = 0; i < singleMatchVos.size(); i++) {
                Five2FiveSingleApplyVo singleMatchVo = singleMatchVos.get(i);
                WNPlayer player = singleMatchVo.player;
                if (player == null) {
                    playerApplysPool.remove(singleMatchVo);
                    Out.debug(new Object[]{"5v5 createTempTeam failed:player is null"});
                    return null;
                }
                Five2FiveTempTeamMember temp = new Five2FiveTempTeamMember();
                temp.playerId = player.getId();
                temp.playerPro = player.getPro();
                temp.playerLvl = player.getLevel();
                temp.playerName = player.getName();
                tempTeamMember.add(temp);
                totalScore += Five2FiveService.getInstance().getFive2FiveScore(player.getId());
            }
        }
        if (teamMatchVos != null) {
            for (int i = 0; i < teamMatchVos.size(); i++) {
                Five2FiveTeamApplyVo teamMatchVo = teamMatchVos.get(i);
                if (teamMatchVo == null) {
                    Out.debug(new Object[]{"5v5 createTempTeam failed:teamData is null"});
                    return null;
                }
                Map<String, TeamData.TeamMemberData> teamMembers = teamMatchVo.teamMembers;
                if (teamMembers.size() == 0) {
                    teamApplysPool.remove(teamMatchVo);
                    Out.debug(new Object[]{"5v5 createTempTeam failed:teamMembers is null"});
                    return null;
                }
                for (Map.Entry<String, TeamData.TeamMemberData> tempMemEntry : teamMembers.entrySet()) {
                    String playerId = tempMemEntry.getKey();
                    PlayerPO player = PlayerUtil.getPlayerBaseData(playerId);
                    Five2FiveTempTeamMember temp = new Five2FiveTempTeamMember();
                    temp.playerId = player.id;
                    temp.playerPro = player.pro;
                    temp.playerLvl = player.level;
                    temp.playerName = player.name;
                    tempTeamMember.add(temp);
                    totalScore += Five2FiveService.getInstance().getFive2FiveScore(player.id);
                }
            }
        }
        if (tempTeamMember.size() != TEAM_NUMBER) {
            Out.debug(new Object[]{"5v5 createTempTeam failed: tempTeam size not full"});
            return null;
        }
        Out.debug(new Object[]{"5v5 createTempTeam success"});
        matchVo.tempTeamId = UUID.randomUUID().toString();
        matchVo.joinTime = new Date();
        matchVo.tempTeamMember = tempTeamMember;
        totalScore /= TEAM_NUMBER;
        matchVo.teamScore = totalScore;
        matchVo.singleMatchVos = singleMatchVos;
        matchVo.teamMatchVos = teamMatchVos;
        Out.info(new Object[]{"组建临时队伍:tempTeamId=", matchVo.tempTeamId});
        for (Five2FiveTempTeamMember v : matchVo.tempTeamMember) {
            Out.info(new Object[]{"成员：", v.playerId});
        }

        return matchVo;
    }


    private static void teamFindTeam() {
        int i = 0;
        while (true) {
            if (i < teamApplysPool.size()) {
                Five2FiveTeamApplyVo matchTeam = teamApplysPool.get(i);
                Date joinTime = matchTeam.joinTime;
                Date now = new Date();
                long diff = (now.getTime() - joinTime.getTime()) / 1000L;
                int addNumber = (int) ((diff / GlobalConfig.Group_MatchingTime == 0L) ? 1L : (diff / GlobalConfig.Group_MatchingTime));
                Map<String, TeamData.TeamMemberData> teamMembers = matchTeam.teamMembers;
                if (teamMembers == null || teamMembers.size() == 0) {
                    teamApplysPool.remove(matchTeam);
                } else {

                    if (teamMembers.size() == TEAM_NUMBER) {
                        Five2FiveMatchTeamVo tempTeam = createTempTeam(null, Arrays.asList(new Five2FiveTeamApplyVo[]{matchTeam}));
                        if (tempTeam == null) {
                            teamApplysPool.add(matchTeam);
                        } else {
                            teamMatchPool.add(tempTeam);
                            teamApplysPool.remove(matchTeam);
                            i++;
                        }
                    }
                    int teamScore = getTeamScore(teamMembers);
                    int scoreChange = GlobalConfig.Group_PlusPoint * addNumber;
                    int matchMinScore = getMinMatchScore(teamScore, scoreChange);
                    int matchMaxScore = getMaxMatchScore(teamScore, scoreChange);
                    int memSizeDiff = TEAM_NUMBER - teamMembers.size();
                    String teamId = matchTeam.teamId;
                    Five2FiveTeamApplyVo conformTeam = getConformToRulesTeamsLess5(teamId, matchMinScore, matchMaxScore, memSizeDiff);
                    if (conformTeam != null) {
                        removeTeamAndAddTeam(matchTeam, conformTeam);
                        break;
                    }
                    List<Five2FiveSingleApplyVo> conformSingle = getConformToRulesPlayer(null, matchMinScore, matchMaxScore);
                    if (conformSingle.size() >= memSizeDiff) {
                        for (int j = 0; j < memSizeDiff; j++) {
                            Five2FiveSingleApplyVo singleMatchVo = conformSingle.get(j);
                            removeSingleAndAddTeam(singleMatchVo, matchTeam);
                        }
                    }
                }
            } else {
                break;
            }
            i++;
        }

    }

    private static void playerFindPlayer() {
        for (int i = 0; i < playerApplysPool.size(); i++) {
            Five2FiveSingleApplyVo matchPlayer = playerApplysPool.get(i);
            WNPlayer player = matchPlayer.player;
            if (player == null) {
                playerApplysPool.remove(matchPlayer);
            } else {

                String playerId = player.getId();
                Date joinTime = matchPlayer.joinTime;
                Date now = new Date();
                long diff = (now.getTime() - joinTime.getTime()) / 1000L;
                int addNumber = (int) ((diff / GlobalConfig.Group_MatchingTime == 0L) ? 1L : (diff / GlobalConfig.Group_MatchingTime));
                int scoreChange = GlobalConfig.Group_PlusPoint * addNumber;
                int score = Five2FiveService.getInstance().getFive2FiveScore(playerId);
                int matchMinScore = getMinMatchScore(score, scoreChange);
                int matchMaxScore = getMaxMatchScore(score, scoreChange);
                List<Five2FiveSingleApplyVo> conformSingle = getConformToRulesPlayer(playerId, matchMinScore, matchMaxScore);
                if (conformSingle.size() >= TEAM_NUMBER - 1) {
                    removeSingleAndCreateTeam(matchPlayer, conformSingle);
                }
            }
        }
    }


    private static void matchSuccess(Five2FiveMatchTeamVo teamMatchVoA, Five2FiveMatchTeamVo teamMatchVoB) {
        teamMatchPool.remove(teamMatchVoA);
        teamMatchPool.remove(teamMatchVoB);
        matchedPool.put(teamMatchVoA.tempTeamId, teamMatchVoA);
        matchedPool.put(teamMatchVoB.tempTeamId, teamMatchVoB);

        Out.info(new Object[]{"匹配成功 A队:", teamMatchVoA.tempTeamId, "，B队:", teamMatchVoB.tempTeamId});
        int index = 1;
        int i;
        for (i = 0; i < teamMatchVoA.tempTeamMember.size(); i++) {
            Five2FiveTempTeamMember tempTeamMember = teamMatchVoA.tempTeamMember.get(i);
            tempTeamMember.force = Const.AreaForce.FORCEA.value;
            tempTeamMember.index = index;
            index++;
            Out.info(new Object[]{"匹配A队成员:", tempTeamMember.playerId});
        }
        index = 1;
        for (i = 0; i < teamMatchVoB.tempTeamMember.size(); i++) {
            Five2FiveTempTeamMember tempTeamMember = teamMatchVoB.tempTeamMember.get(i);
            tempTeamMember.force = Const.AreaForce.FORCEB.value;
            tempTeamMember.index = index;
            index++;
            Out.info(new Object[]{"匹配B队成员:", tempTeamMember.playerId});
        }
        teamMatchVoA.oppoTempTeamId = teamMatchVoB.tempTeamId;
        teamMatchVoB.oppoTempTeamId = teamMatchVoA.tempTeamId;

        Five2FiveService.getInstance().five2FiveAfterMatchSucess(teamMatchVoA, teamMatchVoB);
    }


    private static void removeSingleAndCreateTeam(Five2FiveSingleApplyVo matchPlayer, List<Five2FiveSingleApplyVo> conformSingle) {
        List<Five2FiveSingleApplyVo> singleApplyVos = new ArrayList<>();
        singleApplyVos.add(matchPlayer);
        for (int i = 0; i < TEAM_NUMBER - 1; i++) {
            Five2FiveSingleApplyVo tempMatchTeamVo = conformSingle.get(i);
            singleApplyVos.add(tempMatchTeamVo);
        }
        Five2FiveMatchTeamVo matchTeamVo = createTempTeam(singleApplyVos, null);
        if (matchTeamVo != null) {
            playerApplysPool.removeAll(singleApplyVos);
            teamMatchPool.add(matchTeamVo);
        }
    }


    private static void removeSingleAndAddTeam(Five2FiveSingleApplyVo singleMatchVo, Five2FiveTeamApplyVo matchTeam) {
        List<Five2FiveSingleApplyVo> singleApplyVos = new ArrayList<>();
        singleApplyVos.add(singleMatchVo);
        Five2FiveMatchTeamVo matchTeamVo = createTempTeam(singleApplyVos, Arrays.asList(new Five2FiveTeamApplyVo[]{matchTeam}));
        if (matchTeamVo != null) {
            playerApplysPool.remove(singleMatchVo);
            teamApplysPool.remove(matchTeam);
            teamMatchPool.add(matchTeamVo);
        }
    }


    private static void removeTeamAndAddTeam(Five2FiveTeamApplyVo teamMemA, Five2FiveTeamApplyVo teamMemB) {
        Five2FiveMatchTeamVo matchTeamVo = createTempTeam(null, Arrays.asList(new Five2FiveTeamApplyVo[]{teamMemA, teamMemB}));
        if (matchTeamVo != null) {
            teamApplysPool.remove(teamMemA);
            teamApplysPool.remove(teamMemB);
            teamMatchPool.add(matchTeamVo);
        }
    }


    private static int getTeamScore(Map<String, TeamData.TeamMemberData> teamMembers) {
        int teamScore = 0;
        for (Map.Entry<String, TeamData.TeamMemberData> tempMemEntry : teamMembers.entrySet()) {
            String teamMemPlayerId = tempMemEntry.getKey();
            int teamMemScore = Five2FiveService.getInstance().getFive2FiveScore(teamMemPlayerId);
            teamScore += teamMemScore;
        }
        int size = teamMembers.size();
        if (size != 0) {
            return teamScore / size;
        }
        return 0;
    }


    private static int getMinMatchScore(int score, int scoreChange) {
        int minScore = -1;
        if (scoreChange < GlobalConfig.Group_MaxPoint) {
            minScore = (score - scoreChange < 0) ? 0 : (score - scoreChange);
        }
        return minScore;
    }


    private static int getMaxMatchScore(int score, int scoreChange) {
        int maxScore = -1;
        if (scoreChange < GlobalConfig.Group_MaxPoint) {
            maxScore = score + scoreChange;
        }
        return maxScore;
    }


    private static Five2FiveTeamApplyVo getConformToRulesTeamsLess5(String teamId, int minTeamScore, int maxTeamScore, int memNumber) {
        for (int i = 0; i < teamApplysPool.size(); i++) {
            Five2FiveTeamApplyVo matchTeam = teamApplysPool.get(i);
            Map<String, TeamData.TeamMemberData> teamMembers = matchTeam.teamMembers;
            if (teamMembers == null || teamMembers.size() == 0) {
                teamApplysPool.remove(matchTeam);

            } else if (teamId == null || !teamId.equals(matchTeam.teamId)) {


                if (teamMembers.size() == memNumber) {
                    int currentTeamScore = getTeamScore(teamMembers);
                    if (minTeamScore == -1 || maxTeamScore == -1 || (currentTeamScore >= minTeamScore && currentTeamScore <= maxTeamScore))
                        return matchTeam;
                }
            }
        }
        return null;
    }


    private static Five2FiveMatchTeamVo getConformToRulesTeamsEqual5(String tempTeamId, int minTeamScore, int maxTeamScore) {
        for (int i = 0; i < teamMatchPool.size(); i++) {
            Five2FiveMatchTeamVo matchTeam = teamMatchPool.get(i);
            if (matchTeam.tempTeamMember.size() != TEAM_NUMBER) {
                teamMatchPool.remove(matchTeam);
                if (matchTeam.singleMatchVos != null) {
                    playerApplysPool.addAll(matchTeam.singleMatchVos);
                }
                if (matchTeam.teamMatchVos != null) {
                    teamApplysPool.addAll(matchTeam.teamMatchVos);
                }
            } else {

                int currentTeamScore = matchTeam.teamScore;
                if (tempTeamId == null || !tempTeamId.equals(matchTeam.tempTeamId)) {

                    if (minTeamScore == -1 || maxTeamScore == -1 || (currentTeamScore >= minTeamScore && currentTeamScore <= maxTeamScore && matchTeam.useNumber.getAndAdd(1) == 0))
                        return matchTeam;
                }
            }
        }
        return null;
    }


    private static List<Five2FiveSingleApplyVo> getConformToRulesPlayer(String playerId, int minTeamScore, int maxTeamScore) {
        List<Five2FiveSingleApplyVo> conformToRulesSingles = new ArrayList<>();
        for (int i = 0; i < playerApplysPool.size(); i++) {
            Five2FiveSingleApplyVo matchSingle = playerApplysPool.get(i);
            WNPlayer player = matchSingle.player;
            if (player == null) {
                playerApplysPool.remove(matchSingle);
            } else {

                String matchPlayerId = player.getId();
                if (playerId == null || !matchPlayerId.equals(playerId)) {


                    int currentTeamScore = Five2FiveService.getInstance().getFive2FiveScore(matchPlayerId);
                    if (minTeamScore == -1 || maxTeamScore == -1 || (currentTeamScore >= minTeamScore && currentTeamScore <= maxTeamScore))
                        conformToRulesSingles.add(matchSingle);
                }
            }
        }
        return conformToRulesSingles;
    }
}


