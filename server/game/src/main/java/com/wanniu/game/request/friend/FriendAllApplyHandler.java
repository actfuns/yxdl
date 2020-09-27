package com.wanniu.game.request.friend;

import com.google.protobuf.ProtocolStringList;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.Const;
import com.wanniu.game.friend.FriendManager;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import pomelo.area.FriendHandler;


@GClientEvent("area.friendHandler.friendAllApplyRequest")
public class FriendAllApplyHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        FriendHandler.FriendAllApplyRequest msg = FriendHandler.FriendAllApplyRequest.parseFrom(this.pak.getRemaingBytes());
        final ProtocolStringList toPlayerIds = msg.getC2SToPlayerIdsList();
        return new PomeloResponse() {
            protected void write() throws IOException {
                FriendHandler.FriendAllApplyResponse.Builder res = FriendHandler.FriendAllApplyResponse.newBuilder();
                FriendManager friendManager = player.getFriendManager();
                TreeMap<String, Object> rtData = friendManager.friendAllApply(toPlayerIds, player);
                boolean result = ((Boolean) rtData.get("result")).booleanValue();
                String info = (String) rtData.get("info");
                if (result) {
                    player.getPlayerTasks().dealTaskEvent(Const.TaskType.ADD_FRIEND, toPlayerIds.size());
                    res.setS2CCode(200);
                    res.setS2CMsg(info);
                } else {

                    res.setS2CCode(500);
                    res.setS2CMsg(info);
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


