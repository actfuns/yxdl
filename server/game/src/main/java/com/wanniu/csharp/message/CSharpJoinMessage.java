package com.wanniu.csharp.message;

import com.wanniu.core.GGlobal;
import com.wanniu.csharp.protocol.CSharpHeader;
import com.wanniu.csharp.protocol.CSharpMessage;

import java.io.IOException;


public class CSharpJoinMessage
        extends CSharpMessage {
    private byte[] serverId;

    public CSharpJoinMessage(String serverId) {
        this.serverId = serverId.getBytes(GGlobal.UTF_8);
        CSharpHeader header = getHeader();
        header.setUid("connetorId");
        header.setLength(this.serverId.length);
    }


    protected void write() throws IOException {
        this.body.writeBytes(this.serverId);
    }
}


