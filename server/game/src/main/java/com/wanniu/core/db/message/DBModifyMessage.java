package com.wanniu.core.db.message;

import com.wanniu.core.db.DBType;
import com.wanniu.core.db.ModifyVo;
import com.wanniu.core.tcp.protocol.RequestMessage;

import java.io.IOException;


public class DBModifyMessage
        extends RequestMessage {
    private ModifyVo vo;

    public DBModifyMessage(ModifyVo vo) {
        this.vo = vo;
    }


    protected void write() throws IOException {
        this.body.writeString(this.vo.getModifyTR());
        this.body.writeString(this.vo.getModifyPKey());
        this.body.writeByte(this.vo.getModifyOperate());
        this.body.writeByte(this.vo.getModifyDataType());
    }


    public short getType() {
        return DBType.UPDATE;
    }
}


