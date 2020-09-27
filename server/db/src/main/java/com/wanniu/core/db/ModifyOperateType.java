package com.wanniu.core.db;


public enum ModifyOperateType {
    UPDATE(1), INSERT(2), DELETE(0);

    public int value;

    ModifyOperateType(int tr) {
        this.value = tr;
    }
}


