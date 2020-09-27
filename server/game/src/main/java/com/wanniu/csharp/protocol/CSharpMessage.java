package com.wanniu.csharp.protocol;

import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.game.protocol.PomeloPacket;
import com.wanniu.core.tcp.BufferUtil;
import com.wanniu.core.tcp.protocol.Header;
import com.wanniu.core.tcp.protocol.Message;
import io.netty.buffer.ByteBuf;

import java.io.IOException;


public class CSharpMessage
        extends Message {
    private static final int HEAD_SIZE = 6;
    private ByteBuf pakBody;
    private String csharpServerId;

    public String getServerId() {
        return this.csharpServerId;
    }


    public CSharpMessage() {
    }

    public CSharpMessage(PomeloPacket pak) {
        super(null);
        this.pakBody = pak.getBody();
        CSharpHeader header = getHeader();
        this.pakBody.skipBytes(2);
        header.setLength(this.pakBody.readableBytes());
        GPlayer player = pak.getPlayer();
        header.setUid(player.getId());
        this.csharpServerId = player.getBattleServerId();
    }

    protected Header newHeader() {
        return new CSharpHeader();
    }

    public CSharpHeader getHeader() {
        return (CSharpHeader) this.header;
    }

    protected ByteBuf newContent() {
        CSharpHeader header = getHeader();
        return BufferUtil.getAutoBuffer(6 + header.getUidLength() + header.getBodyLength());
    }

    protected void encodeHeader() {
        CSharpHeader header = getHeader();
        header.encode(this.content);
    }

    protected void encodeBody() {
        if (this.pakBody != null) {
            this.content.writeBytes(this.pakBody);
        } else {
            super.encodeBody();
        }
    }

    public short getType() {
        return 0;
    }

    protected void write() throws IOException {
    }
}


