package com.wanniu.game.request.farm;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.farm.FarmMgr;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.FarmPO;

import java.io.IOException;
import java.util.Date;

import pomelo.area.FriendHandler;
import pomelo.farm.Farm;
import pomelo.farm.FarmHandler;


@GClientEvent("farm.farmHandler.friendFarmInfoRequest")
public class FriendFarmInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        FarmHandler.FriendFarmInfoRequest msg = FarmHandler.FriendFarmInfoRequest.parseFrom(this.pak.getRemaingBytes());
        final String friendId = msg.getPlayerId();
        return new PomeloResponse() {
            protected void write() throws IOException {
                FarmHandler.FriendFarmInfoResponse.Builder res = FarmHandler.FriendFarmInfoResponse.newBuilder();
                FarmMgr farmMgr = player.getFarmMgr();
                FarmPO farmPO = farmMgr.myPO;


                FriendHandler.PlayerInfo playerFriendInfo = null;
                for (FriendHandler.PlayerInfo tempInfo : player.friendManager.getAllFriends()) {
                    if (tempInfo.getId().equals(friendId))
                        playerFriendInfo = tempInfo;
                }
                if (playerFriendInfo == null) {

                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("FARM_NOT_MY_FRIEND"));
                }


                Farm.PlayerInfo.Builder playerInfoBuilder = Farm.PlayerInfo.newBuilder();


                playerInfoBuilder.setPlayerId(playerFriendInfo.getId());


                Farm.PlayerSummary.Builder playerSummaryBuilder = Farm.PlayerSummary.newBuilder();
                playerSummaryBuilder.setPlayerId(playerFriendInfo.getId());
                playerSummaryBuilder.setRoleName(playerFriendInfo.getName());
                playerSummaryBuilder.setLv(playerFriendInfo.getLevel());
                playerSummaryBuilder.setFarmLv(farmPO.lv);
                playerSummaryBuilder.setCanSow(farmMgr.getPlayerCultivatable(playerFriendInfo.getId()));
                playerSummaryBuilder.setCanSteal(farmMgr.getPlayerStealable(playerFriendInfo.getId()));
                playerInfoBuilder.setPlayerSummary(playerSummaryBuilder.build());


                for (FarmMgr.Block farmMgrBlock : farmPO.blockMap.values()) {
                    Farm.Block.Builder blockBuilder = Farm.Block.newBuilder();
                    blockBuilder.setBlockId(farmMgrBlock.blockId);
                    blockBuilder.setBlockState(farmMgrBlock.blockState.value);
                    blockBuilder.setSeedCode(farmMgrBlock.seedCode);
                    blockBuilder.setSeedState(farmMgrBlock.seedState.value);
                    blockBuilder.setCultivateType(farmMgrBlock.cultivateType.value);
                    blockBuilder.setHarvestTime(FarmMgr.evaluateHarvestTime(farmPO.playerId, farmMgrBlock.blockId).getTime());
                    Date protectionEndTime = FarmMgr.getProtectEndTime(farmPO.playerId, farmMgrBlock.blockId);
                    if (protectionEndTime != null)
                        blockBuilder.setProtectEndTime(protectionEndTime.getTime());
                    playerInfoBuilder.addBlockLs(blockBuilder.build());
                }

                Farm.PlayerInfo handlerPlayerInfo = playerInfoBuilder.build();
                res.setPlayerInfo(handlerPlayerInfo);


                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


