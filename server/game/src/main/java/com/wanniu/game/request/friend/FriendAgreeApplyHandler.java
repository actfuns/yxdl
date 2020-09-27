package com.wanniu.game.request.friend;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.achievement.AchievementServiceNew;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.ext.AchievementExt;
import com.wanniu.game.friend.FriendsCenter;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import pomelo.area.FriendHandler;


@GClientEvent("area.friendHandler.friendAgreeApplyRequest")
public class FriendAgreeApplyHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        FriendHandler.FriendAgreeApplyRequest msg = FriendHandler.FriendAgreeApplyRequest.parseFrom(this.pak.getRemaingBytes());
        final String requestId = msg.getC2SRequestId();
        return new PomeloResponse() {
            protected void write() throws IOException {
                FriendHandler.FriendAgreeApplyResponse.Builder res = FriendHandler.FriendAgreeApplyResponse.newBuilder();
                Map<String, Object> rtData = FriendsCenter.getInstance().friendAgreeApply(player.getId(), requestId);
                boolean result = ((Boolean) rtData.get("result")).booleanValue();
                if (result) {
                    player.getPlayerTasks().dealTaskEvent(Const.TaskType.ADD_FRIEND, 1);
                    res.setS2CCode(200);
                    res.setS2CMsg(LangService.getValue("FRIEND_ADD_SUCCESS"));

                    AchievementServiceNew achievementService = AchievementServiceNew.getInstance();

                    player.achievementManager.onFriendNumber(1);
                    if (PlayerUtil.isOnline(requestId)) {
                        (PlayerUtil.getOnlinePlayer(requestId)).achievementManager.onFriendNumber(1);
                    } else {
                        List<AchievementExt> achievementArray = achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.FRIENDS_NUM);
                        if (achievementArray.size() > 0) {
                            AchievementServiceNew.OnFriendAchieveOfOfflinePlayer(1, achievementArray, requestId);
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


