package com.wanniu.game.request.rank;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;
import pomelo.area.RankHandler;


@GClientEvent("area.rankHandler.saveRankNotify")
public class SaveRankNotifyHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        RankHandler.SaveRankNotify req = RankHandler.SaveRankNotify.parseFrom(this.pak.getRemaingBytes());
        GPlayer player = this.pak.getPlayer();
        WNPlayer wPlayer = (WNPlayer) player;
        int selectedRankId = req.getC2SSelectedRankId();
        wPlayer.titleManager.saveRank(selectedRankId);
        return null;
    }
}


