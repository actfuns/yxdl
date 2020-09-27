package com.wanniu.game.request.fightLevel;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.List;

import pomelo.area.FightLevelHandler;
import pomelo.item.ItemOuterClass;


@GClientEvent("area.fightLevelHandler.getMonsterLeaderRequest")
public class GetMonsterLeaderHandler
        extends FightLevelLine {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        FightLevelHandler.GetMonsterLeaderRequest req = FightLevelHandler.GetMonsterLeaderRequest.parseFrom(this.pak.getRemaingBytes());
        final int monsterId = req.getS2CMonsterId();
        final int areaId = req.getS2CAreaId();

        return new PomeloResponse() {
            protected void write() throws IOException {
                FightLevelHandler.GetMonsterLeaderResponse.Builder res = FightLevelHandler.GetMonsterLeaderResponse.newBuilder();

                GetMonsterLeaderHandler.GetMonsterLeaderData data = player.fightLevelManager.getMonsterLeader(player, monsterId, areaId);
                res.setS2CCode(200);
                res.addAllS2CDropItems(data.dropItems);
                res.setS2CReqLevel(data.reqLevel);
                res.setS2CReqUpLevel(data.reqUpLevel);
                res.setS2CRefreshPoint(data.refreshPoint);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }

    public static class GetMonsterLeaderData {
        public List<ItemOuterClass.MiniItem> dropItems;
        public int reqLevel;
        public int reqUpLevel;
        public String refreshPoint;

        public GetMonsterLeaderData(List<ItemOuterClass.MiniItem> dropItems, int reqLevel, int reqUpLevel, String refreshPoint) {
            this.dropItems = dropItems;
            this.reqLevel = reqLevel;
            this.reqUpLevel = reqUpLevel;
            this.refreshPoint = refreshPoint;
        }
    }
}


