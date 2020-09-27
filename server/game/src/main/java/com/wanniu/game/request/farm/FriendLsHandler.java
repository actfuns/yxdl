package com.wanniu.game.request.farm;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.farm.FarmMgr;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.FarmPO;

import java.io.IOException;
import java.util.List;

import pomelo.area.FriendHandler;
import pomelo.farm.Farm;
import pomelo.farm.FarmHandler;


@GClientEvent("farm.farmHandler.friendLsRequest")
public class FriendLsHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        FarmHandler.FriendLsRequest msg = FarmHandler.FriendLsRequest.parseFrom(this.pak.getRemaingBytes());
        return new PomeloResponse() {
            protected void write() throws IOException {
                FarmHandler.FriendLsResponse.Builder res = FarmHandler.FriendLsResponse.newBuilder();
                FarmMgr farmMgr = player.getFarmMgr();
                FarmPO farmPO = farmMgr.myPO;


                List<FriendHandler.PlayerInfo> playerFriendInfos = player.friendManager.getAllFriends();

                for (FriendHandler.PlayerInfo friendInfo : playerFriendInfos) {


                    Farm.PlayerSummary.Builder playerSummaryBuilder = Farm.PlayerSummary.newBuilder();
                    playerSummaryBuilder.setPlayerId(friendInfo.getId());
                    playerSummaryBuilder.setRoleName(friendInfo.getName());
                    playerSummaryBuilder.setLv(friendInfo.getLevel());
                    playerSummaryBuilder.setFarmLv(farmPO.lv);
                    playerSummaryBuilder.setCanSow(farmMgr.getPlayerCultivatable(friendInfo.getId()));
                    playerSummaryBuilder.setCanSteal(farmMgr.getPlayerStealable(friendInfo.getId()));

                    res.addPlayerSummary(playerSummaryBuilder.build());
                }


                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


