package com.wanniu.core.tcp.protocol;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.BufferUtil;
import io.netty.buffer.ByteBuf;

import java.io.IOException;


public abstract class Message {
    protected Header header;
    protected Body body;
    protected ByteBuf content;

    public Message() {
        this(new Body());
    }


    public Message(Body body) {
        this.header = newHeader();
        this.body = body;
    }


    protected Header newHeader() {
        return new Header();
    }


    protected ByteBuf newContent() {
        return BufferUtil.getAutoBuffer(this.body.getBuffer().readableBytes() + Header.SIZE);
    }


    protected void encodeHeader() {
        this.header.setType(getType());
        this.header.setLength(this.body.getBuffer().readableBytes());
        this.header.encode(this.content);
    }


    protected void encodeBody() {
        this.content.writeBytes(this.body.getBuffer());
    }


    public ByteBuf getContent() {
        try {
            if (null == this.content) {

                write();

                this.content = newContent();
                encodeHeader();
                encodeBody();

                this.body = null;
                this.header = null;
            }

            return this.content;
        } catch (Exception e) {
            Out.error(new Object[]{"Message getContent", e});
            return null;
        }
    }

    protected abstract void write() throws IOException;

    public abstract short getType();
}


