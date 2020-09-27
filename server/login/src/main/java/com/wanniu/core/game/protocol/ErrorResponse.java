package com.wanniu.core.game.protocol;

import com.wanniu.login.proto.Common;

import java.io.IOException;

public class ErrorResponse
        extends PomeloResponse {
    private String errMsg;

    public ErrorResponse(String errMsg) {
        this.errMsg = errMsg;
    }


    protected void write() throws IOException {
        Common.ErrMsg.Builder err = Common.ErrMsg.newBuilder();
        err.setS2CCode(500);
        err.setS2CMsg(this.errMsg);
        this.body.writeBytes(err.build().toByteArray());
    }
}


