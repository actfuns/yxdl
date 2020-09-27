package com.wanniu.game.request.friend;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.Const;
import com.wanniu.game.friend.FriendManager;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.FriendHandler;


@GClientEvent("area.friendHandler.friendApplyRequest")
public class FriendApplyHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        FriendHandler.FriendApplyRequest msg = FriendHandler.FriendApplyRequest.parseFrom(this.pak.getRemaingBytes());
        final String toPlayerId = msg.getC2SToPlayerId();
        return new PomeloResponse() {
            protected void write() throws IOException {
                FriendHandler.FriendApplyResponse.Builder res = FriendHandler.FriendApplyResponse.newBuilder();
                FriendManager friendManager = player.getFriendManager();
                String result = friendManager.friendApply(toPlayerId, player);
                if (result == null) {
                    player.getPlayerTasks().dealTaskEvent(Const.TaskType.ADD_FRIEND, 1);
                    res.setS2CCode(200);
                    res.setS2CMsg(LangService.getValue("FRIEND_SEND_MESSAGE"));
                } else {

                    res.setS2CCode(500);
                    res.setS2CMsg(result);
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


