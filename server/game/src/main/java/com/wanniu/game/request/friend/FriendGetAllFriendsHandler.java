package com.wanniu.game.request.friend;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.friend.ChouRenManager;
import com.wanniu.game.friend.FriendManager;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.List;

import pomelo.area.FriendHandler;


@GClientEvent("area.friendHandler.friendGetAllFriendsRequest")
public class FriendGetAllFriendsHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        return new PomeloResponse() {
            protected void write() throws IOException {
                FriendManager friendManager = player.getFriendManager();
                FriendHandler.FriendGetAllFriendsResponse.Builder res = FriendHandler.FriendGetAllFriendsResponse.newBuilder();
                List<FriendHandler.PlayerInfo> friendList = friendManager.getAllFriends();
                int concernNumber = 0;
                for (int i = 0; i < friendList.size(); i++) {
                    if (1 == ((FriendHandler.PlayerInfo) friendList.get(i)).getIsConcerned()) {
                        concernNumber++;
                    }
                }
                res.setS2CCode(200);
                res.addAllFriends(friendList);
                res.setConcernNum(concernNumber);
                res.setAllConcernNum(GlobalConfig.Social_FocusNum);
                res.setFriendsNumMax(GlobalConfig.Social_MaxFriendNum);

                ChouRenManager chouRenManager = player.getChouRenManager();
                List<FriendHandler.PlayerInfo> chouRenList = chouRenManager.getAllChouRens();
                res.addAllChouRens(chouRenList);
                res.setChouRensNumMax(GlobalConfig.Social_MaxEnemyNum);

                List<FriendHandler.PlayerInfo> blackList = friendManager.getAllBlackList();
                res.addAllBlackList(blackList);
                res.setBlackListNumMax(GlobalConfig.Social_MaxBlacklistNum);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


