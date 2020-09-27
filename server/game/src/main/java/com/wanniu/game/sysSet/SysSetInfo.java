package com.wanniu.game.sysSet;

import com.wanniu.game.player.WNPlayer;
import pomelo.area.SysSetHandler;
import pomelo.player.PlayerOuterClass;

public class SysSetInfo {
    private final WNPlayer player;

    public SysSetInfo(WNPlayer player) {
        this.player = player;
    }

    public boolean isPermission(SysSetFlag setFlag) {
        return ((this.player.playerAttachPO.sysSet & setFlag.getValue()) != 0);
    }


    public boolean canRecvMail() {
        return ((this.player.playerAttachPO.sysSet & SysSetFlag.recvMailSet.getValue()) != 0);
    }


    public boolean canTeamInvite() {
        return ((this.player.playerAttachPO.sysSet & SysSetFlag.teamInviteSet.getValue()) != 0);
    }


    public boolean canRecvStrangerMsg() {
        return ((this.player.playerAttachPO.sysSet & SysSetFlag.recvStrangerMsgSet.getValue()) != 0);
    }


    public boolean canRecvAddFriend() {
        return ((this.player.playerAttachPO.sysSet & SysSetFlag.recvAddFriendSet.getValue()) != 0);
    }


    public void changeSet(SysSetHandler.SetData setData) {
        int oldFlag = this.player.playerAttachPO.sysSet;
        int newFlag = converToFlag(setData);
        if (newFlag == oldFlag) {
            return;
        }
        this.player.playerAttachPO.sysSet = newFlag;
    }


    public int converToFlag(SysSetHandler.SetData setData) {
        int ret = 0;
        if (setData.getRecvMailSet() > 0) {
            ret |= SysSetFlag.recvMailSet.getValue();
        }
        if (setData.getTeamInviteSet() > 0) {
            ret |= SysSetFlag.teamInviteSet.getValue();
        }
        if (setData.getRecvStrangerMsgSet() > 0) {
            ret |= SysSetFlag.recvStrangerMsgSet.getValue();
        }
        if (setData.getRecvAddFriendSet() > 0) {
            ret |= SysSetFlag.recvAddFriendSet.getValue();
        }
        return ret;
    }

    public SysSetHandler.SetData getSetData() {
        SysSetHandler.SetData.Builder ret = SysSetHandler.SetData.newBuilder();
        ret.setRecvMailSet(canRecvMail() ? 1 : 0);
        ret.setTeamInviteSet(canTeamInvite() ? 1 : 0);
        ret.setRecvStrangerMsgSet(canRecvStrangerMsg() ? 1 : 0);
        ret.setRecvAddFriendSet(canRecvAddFriend() ? 1 : 0);
        return ret.build();
    }

    public PlayerOuterClass.SetData toJson4Payload() {
        PlayerOuterClass.SetData.Builder data = PlayerOuterClass.SetData.newBuilder();
        data.setRecvMailSet(canRecvMail() ? 1 : 0);
        data.setTeamInviteSet(canTeamInvite() ? 1 : 0);
        data.setRecvStrangerMsgSet(canRecvStrangerMsg() ? 1 : 0);
        data.setRecvAddFriendSet(canRecvAddFriend() ? 1 : 0);
        return data.build();
    }
}


