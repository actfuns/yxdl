package com.wanniu.core.game.protocol;

import com.wanniu.core.tcp.BufferUtil;
import io.netty.buffer.ByteBuf;


public final class Protocol {
    public static final byte TYPE_HANDSHAKE = 1;
    public static final byte TYPE_HANDSHAKE_ACK = 2;
    public static final byte TYPE_HEARTBEAT = 3;
    public static final byte TYPE_DATA = 4;
    public static final byte TYPE_KICK = 5;
    public static final byte TYPE_REQUEST = 0;
    public static final byte TYPE_NOTIFY = 1;
    public static final byte TYPE_RESPONSE = 2;
    public static final byte TYPE_PUSH = 3;
    public static final byte MSG_FLAG_BYTES = 1;
    public static final byte MSG_ROUTE_CODE_BYTES = 2;
    public static final byte MSG_ID_MAX_BYTES = 5;
    public static final byte MSG_ROUTE_LEN_BYTES = 1;
    public static final int MSG_ROUTE_CODE_MAX = 65535;
    public static final byte MSG_COMPRESS_ROUTE_MASK = 1;
    public static final byte MSG_COMPRESS_GZIP_MASK = 1;
    public static final byte MSG_COMPRESS_GZIP_ENCODE_MASK = 16;
    public static final byte MSG_TYPE_MASK = 7;
    private static final int LEFT_SHIFT_BITS = 128;

    public static ByteBuf strencode(String str) {
        ByteBuf buf = BufferUtil.getAutoBuffer(str.length() * 3);
        for (int i = 0; i < str.length(); i++) {
            byte charCode = (byte) str.charAt(i);
            byte[] codes = null;
            if (charCode <= Byte.MAX_VALUE) {
                codes = new byte[]{charCode};
            } else if (charCode <= 2047) {
                codes = new byte[]{(byte) (0xC0 | charCode >> 6), (byte) (0x80 | charCode & 0x3F)};
            } else {
                codes = new byte[]{(byte) (0xE0 | charCode >> 12), (byte) (0x80 | (charCode & 0xFC0) >> 6),
                        (byte) (0x80 | charCode & 0x3F)};
            }
            for (int j = 0; j < codes.length; j++) {
                buf.writeByte(codes[j]);
            }
        }
        return buf;
    }


    public static String strdecode(byte[] bytes) {
        ByteBuf array = BufferUtil.getAutoBuffer(bytes.length);
        int offset = 0;
        int charCode = 0;
        int end = bytes.length;
        while (offset < end) {
            if (bytes[offset] < 128) {
                charCode = bytes[offset];
                offset++;
            } else if (bytes[offset] < 224) {
                charCode = ((bytes[offset] & 0x3F) << 6) + (bytes[offset + 1] & 0x3F);
                offset += 2;
            } else {
                charCode = ((bytes[offset] & 0xF) << 12) + ((bytes[offset + 1] & 0x3F) << 6) + (
                        bytes[offset + 2] & 0x3F);
                offset += 3;
            }
            array.writeByte((byte) charCode);
        }
        byte[] b = array.array();
        return new String(b);
    }


    public static byte[] writeLength(int length, int contentLen) {
        int offset = contentLen - 1;
        byte[] bytes = new byte[contentLen];
        for (; offset >= 0; offset--) {
            int b = length % 128;
            if (offset < contentLen - 1) {
                b |= 0x80;
            }
            bytes[offset] = (byte) b;
            length >>= 7;
        }
        return bytes;
    }

    public static int calLengthSize(int length) {
        int res = 0;
        while (length > 0) {
            length >>= 7;
            res++;
        }
        return res;
    }

    public static int caculateMsgIdBytes(int id) {
        int len = 0;
        do {
            len++;
            id >>= 7;
        } while (id > 0);
        return len;
    }

    public static boolean msgHasId(byte type) {
        return !(type != 0 && type != 2);
    }

    public static boolean msgHasRoute(int type) {
        return !(type != 0 && type != 1 && type != 3);
    }
}


