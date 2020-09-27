package com.wanniu.game.sysSet;

public enum SysSetFlag {
    recvMailSet(1), teamInviteSet(2), recvStrangerMsgSet(4), recvAddFriendSet(8);

    private int value;

    SysSetFlag(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}


