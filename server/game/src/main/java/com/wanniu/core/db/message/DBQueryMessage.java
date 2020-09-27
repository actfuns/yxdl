package com.wanniu.core.db.message;

import com.wanniu.core.db.DBType;
import com.wanniu.core.db.QueryVo;
import com.wanniu.core.tcp.protocol.RequestMessage;

import java.io.IOException;


public class DBQueryMessage
        extends RequestMessage {
    private QueryVo query;

    public DBQueryMessage(QueryVo query) {
        this.query = query;
    }


    protected void write() throws IOException {
        this.body.writeLong(this.reqId);
        this.body.writeString(this.query.getQueryTR());
        this.body.writeByte(this.query.type);
        this.body.writeString(this.query.getConVal());
    }


    public short getType() {
        return DBType.QUERY;
    }
}


