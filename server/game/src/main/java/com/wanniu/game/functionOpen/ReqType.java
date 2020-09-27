package com.wanniu.game.functionOpen;


enum ReqType {
    LEVEL(0),
    ACCEPT_TASK(1),
    FINISH_TASK(2),
    INTERACT_ITEM(3);

    private int value;

    ReqType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}


