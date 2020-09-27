package com.wanniu.core.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


public final class BytesUtil {
    public static long bytes2long(byte[] bytes) {
        return (bytes[7] & 0xFF | (
                bytes[6] & 0xFF) << 8 | (
                bytes[5] & 0xFF) << 16 | (
                bytes[4] & 0xFF) << 24 | (
                bytes[3] & 0xFF) << 32 | (
                bytes[2] & 0xFF) << 40 | (
                bytes[1] & 0xFF) << 48 | (
                bytes[0] & 0xFF) << 56);
    }

    public static byte[] long2bytes(long n) {
        byte[] bytes = new byte[8];

        bytes[7] = (byte) (int) (n & 0xFFL);
        bytes[6] = (byte) (int) (n >> 8L & 0xFFL);
        bytes[5] = (byte) (int) (n >> 16L & 0xFFL);
        bytes[4] = (byte) (int) (n >> 24L & 0xFFL);
        bytes[3] = (byte) (int) (n >> 32L & 0xFFL);
        bytes[2] = (byte) (int) (n >> 40L & 0xFFL);
        bytes[1] = (byte) (int) (n >> 48L & 0xFFL);
        bytes[0] = (byte) (int) (n >> 56L & 0xFFL);

        return bytes;
    }

    public static int bytes2int(byte[] bytes) {
        return bytes[3] & 0xFF | (
                bytes[2] & 0xFF) << 8 | (
                bytes[1] & 0xFF) << 16 | (
                bytes[0] & 0xFF) << 24;
    }

    public static byte[] int2bytes(int n) {
        byte[] bytes = new byte[4];

        bytes[3] = (byte) (n & 0xFF);
        bytes[2] = (byte) (n >> 8 & 0xFF);
        bytes[1] = (byte) (n >> 16 & 0xFF);
        bytes[0] = (byte) (n >> 24 & 0xFF);

        return bytes;
    }

    public static short bytes2short(byte[] bytes) {
        return (short) (bytes[1] & 0xFF | (
                bytes[0] & 0xFF) << 8);
    }

    public static byte[] short2bytes(short n) {
        return new byte[]{
                (byte) (n >>> 8 & 0xFF),
                (byte) (n & 0xFF)};
    }

    public static byte[] short2bytes(int n) {
        return new byte[]{
                (byte) (n >>> 8 & 0xFF),
                (byte) (n & 0xFF)};
    }

    public static byte[] short2bytes(long n) {
        return new byte[]{
                (byte) (int) (n >>> 8L & 0xFFL),
                (byte) (int) (n & 0xFFL)};
    }

    public static byte[] object2bytes(Serializable obj) {
        byte[] bytes = null;
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream(512);
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(obj);

            bytes = bo.toByteArray();

            bo.close();
            oo.close();
        } catch (Exception e) {
            System.out.println("object2bytes:" + e.getMessage());
            e.printStackTrace();
        }
        return bytes;
    }

    public static <T extends Serializable> T bytes2object(byte[] bytes) {
        Serializable serializable;
        T t = null;
        try {
            ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
            ObjectInputStream oi = new ObjectInputStream(bi);
            serializable = (Serializable) oi.readObject();
            bi.close();
            oi.close();
        } catch (Exception e) {
            System.out.println("bytes2object:" + e.getMessage());
            e.printStackTrace();
        }
        return (T) serializable;
    }

    public static String bytes2String(byte[] bytes) {
        return new String(bytes, Charset.defaultCharset());
    }


    public static byte[] zip(byte[] data) {
        byte[] b = null;
        ByteArrayOutputStream bos = null;
        ZipOutputStream zip = null;
        try {
            bos = new ByteArrayOutputStream();
            zip = new ZipOutputStream(bos);
            ZipEntry entry = new ZipEntry("zip");
            entry.setSize(data.length);
            zip.putNextEntry(entry);
            zip.write(data);
            zip.closeEntry();
            b = bos.toByteArray();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (zip != null) zip.close();
                if (bos != null) bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return b;
    }


    public static byte[] unZip(byte[] data) {
        byte[] b = null;
        ByteArrayInputStream bis = null;
        ZipInputStream zip = null;
        try {
            bis = new ByteArrayInputStream(data);
            zip = new ZipInputStream(bis);
            while (zip.getNextEntry() != null) {
                byte[] buf = new byte[1024];
                int num = -1;
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                while ((num = zip.read(buf, 0, buf.length)) != -1) {
                    baos.write(buf, 0, num);
                }
                b = baos.toByteArray();
                baos.flush();
                baos.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (zip != null) zip.close();
                if (bis != null) bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return b;
    }


    public static void clean(ByteBuffer byteBuffer) {
        if (byteBuffer.isDirect()) {
            try {
                Object cleaner = invoke(byteBuffer, "cleaner");
                invoke(cleaner, "clean");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static Object invoke(final Object target, String methodName) throws Exception {
        final Method method = target.getClass().getMethod(methodName, new Class[0]);
        return AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                try {
                    method.setAccessible(true);
                    return method.invoke(target, new Object[0]);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}


