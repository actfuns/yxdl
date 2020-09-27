package com.wanniu.game.request.player;

import com.alibaba.fastjson.TypeReference;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.equip.EquipUtil;
import com.wanniu.game.guild.GuildUtil;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.GuildMemberPO;
import com.wanniu.game.poes.GuildPO;
import com.wanniu.game.poes.PlayerBasePO;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.game.poes.TitlePO;
import com.wanniu.redis.GameDao;
import com.wanniu.redis.PlayerPOManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import pomelo.Common;
import pomelo.area.PlayerHandler;
import pomelo.item.ItemOuterClass;
import pomelo.player.PlayerOuterClass;


@GClientEvent("area.playerHandler.lookUpOtherPlayerRequest")
public class LookUpOtherPlayerHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        return new PomeloResponse() {
            protected void write() throws IOException {
                PlayerHandler.LookUpOtherPlayerRequest req = PlayerHandler.LookUpOtherPlayerRequest.parseFrom(LookUpOtherPlayerHandler.this.pak.getRemaingBytes());
                String other_playerId = req.getC2SPlayerId();

                PlayerHandler.LookUpOtherPlayerResponse.Builder res = PlayerHandler.LookUpOtherPlayerResponse.newBuilder();
                if (StringUtil.isEmpty(other_playerId)) {
                    res.setS2CCode(500);
                    res.setS2CMsg("");
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                if (player.getId().equals(other_playerId)) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("PLEASE_OPEN_PLAYER_INTERFACE"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                WNPlayer target = PlayerUtil.getOnlinePlayer(other_playerId);
                if (target != null && target.isProxy()) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("CANNOT_LOOKUP"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                PlayerPO otherPlayer = null;
                int titleId = 0;
                List<ItemOuterClass.ItemDetail> equipments = new ArrayList<>();
                List<Common.AttributeSimple> attr_list = new ArrayList<>();
                List<ItemOuterClass.EquipGridStrengthInfo> strenght_list = new ArrayList<>();
                if (target == null) {
                    otherPlayer = (PlayerPO) PlayerPOManager.findPO(ConstsTR.playerTR, other_playerId, PlayerPO.class);
                    if (otherPlayer == null) {
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("CANNOT_LOOKUP"));
                        this.body.writeBytes(res.build().toByteArray());
                        return;
                    }
                    TitlePO rankpo = (TitlePO) PlayerPOManager.findPO(ConstsTR.playerTitleTR, other_playerId, TitlePO.class);
                    if (rankpo != null)
                        titleId = rankpo.selectedRankId;
                    PlayerBasePO playerBasePO = (PlayerBasePO) PlayerPOManager.findPO(ConstsTR.playerBaseTR, otherPlayer.id, PlayerBasePO.class);
                    equipments = EquipUtil.getAllEquipDetails4PayLoad(playerBasePO, playerBasePO.equipGrids);
                    Map<Const.PlayerBtlData, Integer> attr_map = new HashMap<>();
                    attr_map = (Map<Const.PlayerBtlData, Integer>) GameDao.get(otherPlayer.id, ConstsTR.playerBtlData.value, new TypeReference<Map<Const.PlayerBtlData, Integer>>() {
                            }
                    );
                    if (attr_map != null) {
                        for (Const.PlayerBtlData pbd : attr_map.keySet()) {
                            Common.AttributeSimple.Builder asb = Common.AttributeSimple.newBuilder();
                            asb.setId(pbd.id);
                            asb.setValue(((Integer) attr_map.get(pbd)).intValue());
                            attr_list.add(asb.build());
                        }
                    }
                    strenght_list = LookUpOtherPlayerHandler.toJson4StrengthPos(playerBasePO.strengthPos);
                } else {
                    otherPlayer = target.player;
                    titleId = target.titleManager.getTitleId();
                    equipments = target.equipManager.getAllEquipDetails4PayLoad();
                    attr_list = target.btlDataManager._getPlayerAttr();
                    strenght_list = LookUpOtherPlayerHandler.toJson4StrengthPos(target.playerBasePO.strengthPos);
                }

                if (otherPlayer != null) {
                    PlayerOuterClass.LookUpPlayer.Builder data = PlayerOuterClass.LookUpPlayer.newBuilder();
                    data.setName(otherPlayer.name);
                    data.setLevel(otherPlayer.level);
                    data.setUpLevel(otherPlayer.upLevel);
                    data.setUpOrder(otherPlayer.upOrder);
                    data.setPro(otherPlayer.pro);
                    data.setFightPower(otherPlayer.fightPower);
                    data.setExp(otherPlayer.exp);

                    data.setTitleId(titleId);
                    data.addAllEquipments(equipments);
                    List<Common.Avatar> avatars = new ArrayList<>();
                    List<Common.Avatar> equipAvatars = PlayerUtil.getBattlerServerAvatar(otherPlayer.id);
                    avatars.addAll(equipAvatars);
                    data.addAllAvatars(avatars);

                    data.addAllAttrs(attr_list);
                    GuildPO guildPO = GuildUtil.getPlayerGuild(otherPlayer.id);
                    if (guildPO != null) {
                        GuildMemberPO guildMemberPO = GuildUtil.getGuildMember(otherPlayer.id);
                        data.setGuildName(guildPO.name);
                        data.setGuildIcon(guildPO.icon);
                        data.setGuildJob(guildMemberPO.job);
                    }

                    if (target != null) {
                        data.setPkValue(target.pkRuleManager.getPkValueData());
                    }
                    data.addAllStrengthPos(strenght_list);
                    res.setS2CData(data.build());
                    res.setS2CCode(200);
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                res.setS2CCode(500);
                res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }


    private static List<ItemOuterClass.EquipGridStrengthInfo> toJson4StrengthPos(Map<Integer, PlayerBasePO.EquipStrengthPos> strengthPos) {
        List<ItemOuterClass.EquipGridStrengthInfo> list = new ArrayList<>();
        if (strengthPos == null)
            return list;
        for (Iterator<Integer> iterator = strengthPos.keySet().iterator(); iterator.hasNext(); ) {
            int pos = ((Integer) iterator.next()).intValue();
            list.add(getStrenghInfo(strengthPos, pos));
        }

        return list;
    }


    private static ItemOuterClass.EquipGridStrengthInfo getStrenghInfo(Map<Integer, PlayerBasePO.EquipStrengthPos> strengthPos, int pos) {
        PlayerBasePO.EquipStrengthPos info = strengthPos.get(Integer.valueOf(pos));
        ItemOuterClass.EquipGridStrengthInfo.Builder data = ItemOuterClass.EquipGridStrengthInfo.newBuilder();
        data.setPos(pos);
        data.setEnSection(info.enSection);
        data.setEnLevel(info.enLevel);
        data.addAllJewelAtts(EquipUtil.toJson4Gem(info));
        data.setSocks(info.socks);
        return data.build();
    }
}


