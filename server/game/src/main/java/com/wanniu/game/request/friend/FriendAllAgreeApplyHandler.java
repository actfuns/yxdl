package com.wanniu.game.request.friend;

import com.google.protobuf.ProtocolStringList;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.Const;
import com.wanniu.game.friend.FriendManager;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import pomelo.area.FriendHandler;


@GClientEvent("area.friendHandler.friendAllAgreeApplyRequest")
public class FriendAllAgreeApplyHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        FriendHandler.FriendAllAgreeApplyRequest msg = FriendHandler.FriendAllAgreeApplyRequest.parseFrom(this.pak.getRemaingBytes());
        final ProtocolStringList requestIds = msg.getC2SRequestIdsList();
        return new PomeloResponse() {
            protected void write() throws IOException {
                FriendHandler.FriendAllAgreeApplyResponse.Builder res = FriendHandler.FriendAllAgreeApplyResponse.newBuilder();
                FriendManager friendManager = player.getFriendManager();
                TreeMap<String, Object> rtData = friendManager.friendAllAgreeApply(requestIds, player);
                boolean result = ((Boolean) rtData.get("result")).booleanValue();
                if (result) {
                    player.getPlayerTasks().dealTaskEvent(Const.TaskType.ADD_FRIEND, requestIds.size());
                    res.setS2CCode(200);
                    res.setS2CMsg(LangService.getValue("FRIEND_ADD_SUCCESS"));


                    player.achievementManager.onFriendNumber(requestIds.size());
                    for (String requestId : requestIds) {
                        if (PlayerUtil.isOnline(requestId)) {
                            (PlayerUtil.getOnlinePlayer(requestId)).achievementManager.onFriendNumber(1);
                        }
                    }

                } else {

                    res.setS2CCode(500);
                    String info = (String) rtData.get("info");
                    res.setS2CMsg(info);
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


