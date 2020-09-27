package com.wanniu.core.db;


public class ModifyVo {
    private String modifyTR;
    private String modifyPKey;
    private int modifyOperate;
    private int modifyDataType;

    public ModifyVo(String modifyTR, String modifyPKey, ModifyOperateType modifyOperate) {
        this.modifyTR = modifyTR;
        this.modifyPKey = modifyPKey;
        this.modifyOperate = modifyOperate.value;
    }

    public ModifyVo(String modifyTR, String modifyPKey, ModifyOperateType modifyOperate, ModifyDataType modifyDataType) {
        this(modifyTR, modifyPKey, modifyOperate);
        this.modifyDataType = modifyDataType.value;
    }


    public String getModifyTR() {
        return this.modifyTR;
    }


    public String getModifyPKey() {
        return this.modifyPKey;
    }


    public int getModifyOperate() {
        return this.modifyOperate;
    }


    public int getModifyDataType() {
        return this.modifyDataType;
    }
}


