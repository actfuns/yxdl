package com.wanniu.core.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;


public final class StringUtil {
    public static final String ASCII_CHARSET = "US-ASCII";
    public static final String GBK = "GBK";

    public static final String join(int[] os, String tag) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < os.length; i++) {
            if (i > 0) {
                builder.append(tag);
            }
            builder.append(os[i]);
        }
        return builder.toString();
    }

    public static final String join(Object[] os, String tag) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < os.length; i++) {
            if (i > 0) {
                builder.append(tag);
            }
            builder.append(os[i]);
        }
        return builder.toString();
    }


    public static final String[] split(String txt, String tag) {
        StringTokenizer tokenizer = new StringTokenizer(txt, tag);
        String[] result = new String[tokenizer.countTokens()];
        for (int index = 0; tokenizer.hasMoreTokens(); ) {
            result[index++] = tokenizer.nextToken();
        }
        return result;
    }


    public static final boolean isEmpty(String param) {
        return (param == null || param.length() == 0 || param.trim().equals(""));
    }

    public static final boolean isNotEmpty(String param) {
        return !isEmpty(param);
    }


    public static final boolean hasChinese(String txt) {
        char[] chars = txt.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            if (isChinese(chars[i])) {
                return true;
            }
        }
        return false;
    }


    public static final boolean isChinese(String txt) {
        char[] chars = txt.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            if (!isChinese(chars[i])) {
                return false;
            }
        }
        return true;
    }

    public static final boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {


            return true;
        }
        return false;
    }


    public static final boolean isAlpha(String value) {
        if (value == null || value.length() == 0) {
            return false;
        }
        for (int i = 0; i < value.length(); i++) {
            if (!isAlpha(value.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static final boolean isAlpha(char c) {
        if (('A' > c || c > 'Z') && ('a' > c || c > 'z')) {
            return false;
        }
        return true;
    }


    public static final boolean isNumeric(String value) {
        if (value == null || value.length() == 0) {
            return false;
        }
        for (int i = 0; i < value.length(); i++) {
            if (!isNumeric(value.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static final boolean isNumeric(char c) {
        if ('0' > c || c > '9') {
            return false;
        }
        return true;
    }


    public static final boolean isAlphaNumeric(String value) {
        if (value == null || value.trim().length() == 0) {
            return true;
        }
        for (int i = 0; i < value.length(); i++) {
            char letter = value.charAt(i);
            if (!isAlpha(letter) && !isNumeric(letter)) {
                return false;
            }
        }
        return true;
    }


    public static final boolean isAlphaNumeric_(String value) {
        if (value == null || value.trim().length() == 0) {
            return true;
        }
        for (int i = 0; i < value.length(); i++) {
            char letter = value.charAt(i);
            if (!isAlpha(letter) && !isNumeric(letter) && letter != '_') {
                return false;
            }
        }
        return true;
    }


    public static final String replace(String string, String oldString, String newString) {
        if (string == null) {
            return null;
        }
        if (newString == null) {
            return string;
        }
        int i = 0;
        if ((i = string.indexOf(oldString, i)) >= 0) {
            char[] string2 = string.toCharArray();
            char[] newString2 = newString.toCharArray();
            int oLength = oldString.length();
            StringBuffer buf = new StringBuffer(string2.length);
            buf.append(string2, 0, i).append(newString2);
            i += oLength;
            int j;
            for (j = i; (i = string.indexOf(oldString, i)) > 0; j = i) {
                buf.append(string2, j, i - j).append(newString2);
                i += oLength;
            }

            buf.append(string2, j, string2.length - j);
            return buf.toString();
        }
        return string;
    }


    public static final String replaceIgnoreCase(String line, String oldString, String newString) {
        if (line == null) {
            return null;
        }
        String lcLine = line.toLowerCase();
        String lcOldString = oldString.toLowerCase();
        int i = 0;
        if ((i = lcLine.indexOf(lcOldString, i)) >= 0) {
            char[] line2 = line.toCharArray();
            char[] newString2 = newString.toCharArray();
            int oLength = oldString.length();
            StringBuffer buf = new StringBuffer(line2.length);
            buf.append(line2, 0, i).append(newString2);
            i += oLength;
            int j;
            for (j = i; (i = lcLine.indexOf(lcOldString, i)) > 0; j = i) {
                buf.append(line2, j, i - j).append(newString2);
                i += oLength;
            }

            buf.append(line2, j, line2.length - j);
            return buf.toString();
        }
        return line;
    }


    public static String WESTERN = " 0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-=[];,./~!@#$%^&*()+_{}:|<>?'\\\"æøåÆØÅäöüÄÖÜßåäöÅÄÖÑñ";

    public static final byte[] getAsciiBytes(String data) {
        if (data == null) {
            throw new IllegalArgumentException("Parameter may not be null");
        }
        try {
            return data.getBytes("US-ASCII");
        } catch (UnsupportedEncodingException unsupportedEncodingException) {

            throw new RuntimeException("LGame requires ASCII support");
        }
    }

    public static final String getAsciiString(byte[] data, int offset, int length) {
        if (data == null) {
            throw new IllegalArgumentException("Parameter may not be null");
        }
        try {
            return new String(data, offset, length, "US-ASCII");
        } catch (UnsupportedEncodingException unsupportedEncodingException) {

            throw new RuntimeException("LGame requires ASCII support");
        }
    }

    public static final String getAsciiString(byte[] data) {
        return getAsciiString(data, 0, data.length);
    }


    public static final String getSpecialString(String context, String encoding) {
        try {
            ByteArrayInputStream in = new ByteArrayInputStream(context.getBytes());
            InputStreamReader isr = new InputStreamReader(in, encoding);
            BufferedReader reader = new BufferedReader(isr);
            StringBuffer buffer = new StringBuffer();
            String result;
            while ((result = reader.readLine()) != null) {
                buffer.append(result);
            }
            return buffer.toString();
        } catch (Exception ex) {
            return context;
        }
    }


    public static final String fillSpace(String txt, int length) {
        byte[] txtBytes = txt.getBytes();
        if (txtBytes.length >= length) {
            return txt;
        }
        StringBuffer txtBuffer = new StringBuffer(length);
        txtBuffer.append(txt);
        for (int i = 0; i < length - txtBytes.length; i++) {
            txtBuffer.append(" ");
        }
        return txtBuffer.toString();
    }


    public static final int charCount(String txt, char c) {
        if (txt != null) {
            int count = 0;
            int length = txt.length();
            for (int i = 0; i < length; i++) {
                if (txt.charAt(i) == c) {
                    count++;
                }
            }
            return count;
        }
        return 0;
    }


    public static final int getBytesLength(String txt, String encoding) {
        if (txt == null || txt.length() == 0) {
            return 0;
        }
        try {
            byte[] bytes = txt.getBytes(encoding);
            int length = bytes.length;
            return length;
        } catch (UnsupportedEncodingException exception) {
            System.err.println(exception.getMessage());

            return 0;
        }
    }


    public static final String getGbkString(byte[] chars) {
        String value = null;
        try {
            value = new String(chars, "GBK");
        } catch (UnsupportedEncodingException e) {
            value = new String(chars);
        }
        return value;
    }


    public static final byte[] getGbkBytes(String value) {
        byte[] bytes;
        try {
            bytes = value.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            bytes = value.getBytes();
        }
        return bytes;
    }


    public static final boolean isWestern(String string) {
        char[] chars = string.toCharArray();
        int size = chars.length;
        for (int i = 0; i < size; i++) {
            if (WESTERN.indexOf(chars[i]) == -1) {
                return false;
            }
        }
        return true;
    }
}


