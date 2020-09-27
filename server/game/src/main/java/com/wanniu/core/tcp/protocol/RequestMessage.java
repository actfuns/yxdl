package com.wanniu.core.tcp.protocol;


public abstract class RequestMessage
        extends Message {
    protected long reqId;

    public long setReqId(long reqId) {
        this.reqId = reqId;
        return this.reqId;
    }
}


