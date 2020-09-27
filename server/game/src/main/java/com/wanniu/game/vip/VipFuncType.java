package com.wanniu.game.vip;


public enum VipFuncType {
    SINGLE_SCENE(1),
    TEAM_SCENE(2),
    SECRET_SCENE(3),
    SUPER_SCENE(4),
    SIN_COM(5),
    MONSTER_KILL_EXP(6),
    EVERY_SIGN(7),
    FAME_ADD(8),
    MONERY_TREE(9),
    CONSIGNMENT_STORE(10),
    BUY_SINGLE_SCENE(11),
    BUY_TEAM_SCENE(12),
    BUY_SUPER_SCENE(13);

    private int value;

    VipFuncType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}


