package com.wanniu.core.util.http;

import java.io.UnsupportedEncodingException;


public class Base64 {
    private static final byte[] encodingTable = new byte[]{65, 66, 67, 68, 69,
            70, 71, 72, 73, 74, 75, 76, 77, 78,
            79, 80, 81, 82, 83, 84, 85, 86, 87,
            88, 89, 90, 97, 98, 99, 100, 101, 102,
            103, 104, 105, 106, 107, 108, 109, 110, 111,
            112, 113, 114, 115, 116, 117, 118, 119, 120,
            121, 122, 48, 49, 50, 51, 52, 53, 54,
            55, 56, 57, 43, 47};


    private static byte[] encodeInner(byte[] data) {
        byte[] bytes;
        int b1, b2, b3, d1, d2, modulus = data.length % 3;
        if (modulus == 0) {
            bytes = new byte[4 * data.length / 3];
        } else {
            bytes = new byte[4 * (data.length / 3 + 1)];
        }

        int dataLength = data.length - modulus;

        for (int i = 0, j = 0; i < dataLength; i += 3, j += 4) {
            int a1 = data[i] & 0xFF;
            int a2 = data[i + 1] & 0xFF;
            int a3 = data[i + 2] & 0xFF;

            bytes[j] = encodingTable[a1 >>> 2 & 0x3F];
            bytes[j + 1] = encodingTable[(a1 << 4 | a2 >>> 4) & 0x3F];
            bytes[j + 2] = encodingTable[(a2 << 2 | a3 >>> 6) & 0x3F];
            bytes[j + 3] = encodingTable[a3 & 0x3F];
        }


        switch (modulus) {


            case 1:
                d1 = data[data.length - 1] & 0xFF;
                b1 = d1 >>> 2 & 0x3F;
                b2 = d1 << 4 & 0x3F;

                bytes[bytes.length - 4] = encodingTable[b1];
                bytes[bytes.length - 3] = encodingTable[b2];
                bytes[bytes.length - 2] = 61;
                bytes[bytes.length - 1] = 61;
                break;
            case 2:
                d1 = data[data.length - 2] & 0xFF;
                d2 = data[data.length - 1] & 0xFF;

                b1 = d1 >>> 2 & 0x3F;
                b2 = (d1 << 4 | d2 >>> 4) & 0x3F;
                b3 = d2 << 2 & 0x3F;

                bytes[bytes.length - 4] = encodingTable[b1];
                bytes[bytes.length - 3] = encodingTable[b2];
                bytes[bytes.length - 2] = encodingTable[b3];
                bytes[bytes.length - 1] = 61;
                break;
        }

        return bytes;
    }

    public static String encodeToString(byte[] data) {
        if (data == null) {
            return null;
        }

        return new String(encodeInner(data));
    }


    public static String encodeToString(String data) {
        if (data == null) {
            return null;
        }
        return encodeToString(data.getBytes());
    }


    private static final byte[] decodingTable = new byte[128];

    static {
        int i;
        for (i = 0; i < 128; i++) {
            decodingTable[i] = -1;
        }

        for (i = 65; i <= 90; i++) {
            decodingTable[i] = (byte) (i - 65);
        }

        for (i = 97; i <= 122; i++) {
            decodingTable[i] = (byte) (i - 97 + 26);
        }

        for (i = 48; i <= 57; i++) {
            decodingTable[i] = (byte) (i - 48 + 52);
        }

        decodingTable[43] = 62;
        decodingTable[47] = 63;
    }


    public static byte[] decode(byte[] data) {
        byte[] bytes;
        if (data == null) {
            return null;
        }


        data = discardNonBase64Bytes(data);

        if (data[data.length - 2] == 61) {
            bytes = new byte[(data.length / 4 - 1) * 3 + 1];
        } else if (data[data.length - 1] == 61) {
            bytes = new byte[(data.length / 4 - 1) * 3 + 2];
        } else {
            bytes = new byte[data.length / 4 * 3];
        }

        for (int i = 0, j = 0; i < data.length - 4; i += 4, j += 3) {
            byte b1 = decodingTable[data[i]];
            byte b2 = decodingTable[data[i + 1]];
            byte b3 = decodingTable[data[i + 2]];
            byte b4 = decodingTable[data[i + 3]];

            bytes[j] = (byte) (b1 << 2 | b2 >> 4);
            bytes[j + 1] = (byte) (b2 << 4 | b3 >> 2);
            bytes[j + 2] = (byte) (b3 << 6 | b4);
        }

        if (data[data.length - 2] == 61) {
            byte b1 = decodingTable[data[data.length - 4]];
            byte b2 = decodingTable[data[data.length - 3]];

            bytes[bytes.length - 1] = (byte) (b1 << 2 | b2 >> 4);
        } else if (data[data.length - 1] == 61) {
            byte b1 = decodingTable[data[data.length - 4]];
            byte b2 = decodingTable[data[data.length - 3]];
            byte b3 = decodingTable[data[data.length - 2]];

            bytes[bytes.length - 2] = (byte) (b1 << 2 | b2 >> 4);
            bytes[bytes.length - 1] = (byte) (b2 << 4 | b3 >> 2);
        } else {
            byte b1 = decodingTable[data[data.length - 4]];
            byte b2 = decodingTable[data[data.length - 3]];
            byte b3 = decodingTable[data[data.length - 2]];
            byte b4 = decodingTable[data[data.length - 1]];

            bytes[bytes.length - 3] = (byte) (b1 << 2 | b2 >> 4);
            bytes[bytes.length - 2] = (byte) (b2 << 4 | b3 >> 2);
            bytes[bytes.length - 1] = (byte) (b3 << 6 | b4);
        }

        return bytes;
    }


    public static byte[] decode(String data) {
        byte[] bytes;
        if (data == null) {
            return null;
        }


        data = discardNonBase64Chars(data);

        if (data.charAt(data.length() - 2) == '=') {
            bytes = new byte[(data.length() / 4 - 1) * 3 + 1];
        } else if (data.charAt(data.length() - 1) == '=') {
            bytes = new byte[(data.length() / 4 - 1) * 3 + 2];
        } else {
            bytes = new byte[data.length() / 4 * 3];
        }

        for (int i = 0, j = 0; i < data.length() - 4; i += 4, j += 3) {
            byte b1 = decodingTable[data.charAt(i)];
            byte b2 = decodingTable[data.charAt(i + 1)];
            byte b3 = decodingTable[data.charAt(i + 2)];
            byte b4 = decodingTable[data.charAt(i + 3)];

            bytes[j] = (byte) (b1 << 2 | b2 >> 4);
            bytes[j + 1] = (byte) (b2 << 4 | b3 >> 2);
            bytes[j + 2] = (byte) (b3 << 6 | b4);
        }

        if (data.charAt(data.length() - 2) == '=') {
            byte b1 = decodingTable[data.charAt(data.length() - 4)];
            byte b2 = decodingTable[data.charAt(data.length() - 3)];

            bytes[bytes.length - 1] = (byte) (b1 << 2 | b2 >> 4);
        } else if (data.charAt(data.length() - 1) == '=') {
            byte b1 = decodingTable[data.charAt(data.length() - 4)];
            byte b2 = decodingTable[data.charAt(data.length() - 3)];
            byte b3 = decodingTable[data.charAt(data.length() - 2)];

            bytes[bytes.length - 2] = (byte) (b1 << 2 | b2 >> 4);
            bytes[bytes.length - 1] = (byte) (b2 << 4 | b3 >> 2);
        } else {
            byte b1 = decodingTable[data.charAt(data.length() - 4)];
            byte b2 = decodingTable[data.charAt(data.length() - 3)];
            byte b3 = decodingTable[data.charAt(data.length() - 2)];
            byte b4 = decodingTable[data.charAt(data.length() - 1)];

            bytes[bytes.length - 3] = (byte) (b1 << 2 | b2 >> 4);
            bytes[bytes.length - 2] = (byte) (b2 << 4 | b3 >> 2);
            bytes[bytes.length - 1] = (byte) (b3 << 6 | b4);
        }

        return bytes;
    }


    public static String decode(String data, String charset) {
        if (data == null) {
            return null;
        }
        if (charset == null) {
            return new String(decode(data));
        }

        try {
            return new String(decode(data), charset);
        } catch (UnsupportedEncodingException ex) {
            return new String(decode(data));
        }
    }


    public static String decode(byte[] data, String charset) {
        if (data == null) {
            return null;
        }
        if (charset == null) {
            return new String(decode(data));
        }

        try {
            return new String(decode(data), charset);
        } catch (UnsupportedEncodingException ex) {
            return new String(decode(data));
        }
    }


    private static byte[] discardNonBase64Bytes(byte[] data) {
        byte[] temp = new byte[data.length];
        int bytesCopied = 0;

        for (int i = 0; i < data.length; i++) {
            if (isValidBase64Byte(data[i])) {
                temp[bytesCopied++] = data[i];
            }
        }

        byte[] newData = new byte[bytesCopied];

        System.arraycopy(temp, 0, newData, 0, bytesCopied);

        return newData;
    }


    private static String discardNonBase64Chars(String data) {
        StringBuilder sb = new StringBuilder();

        int length = data.length();

        for (int i = 0; i < length; i++) {
            if (isValidBase64Byte((byte) data.charAt(i))) {
                sb.append(data.charAt(i));
            }
        }

        return sb.toString();
    }


    private static boolean isValidBase64Byte(byte b) {
        if (b == 61)
            return true;
        if (b < 0 || b >= 128)
            return false;
        if (decodingTable[b] == -1) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String str = "PD94bWwgdmVyc2lvbj0nMS4wJyBlbmNvZGluZz0nVVRGLTgnIHN0YW5kYWxvbmU9J3llcycgPz4NCjxCPg0KICA8VHM+MjAxMjA4MDEwNDI5NDQ0MTQ8L1RzPg0KICA8VHlwZT4xPC9UeXBlPg0KICA8RXh0PlRnPT08L0V4dD4NCjwvQj4=";
        System.out.println(decode(str, "utf-8"));
    }
}


