package com.wanniu.game.common.msg;

import com.wanniu.core.game.protocol.PomeloResponse;

import java.io.IOException;

import pomelo.Common;


public class ErrorResponse
        extends PomeloResponse {
    private String errMsg;

    public ErrorResponse() {
    }

    public ErrorResponse(String errMsg) {
        this.errMsg = errMsg;
    }


    protected void write() throws IOException {
        Common.ErrMsg.Builder err = Common.ErrMsg.newBuilder();
        err.setS2CCode(500);
        err.setS2CMsg((this.errMsg != null) ? this.errMsg : "");
        this.body.writeBytes(err.build().toByteArray());
    }
}


