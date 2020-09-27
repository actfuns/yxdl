package com.wanniu.core.util;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;


public final class CollectionUtil {
    public static final int INITIAL_CAPACITY = 10;

    public static int indexOf(Object[] array, Object obj) {
        for (int i = 0; i < array.length; i++) {
            if (obj == array[i]) {
                return i;
            }
        }
        throw new NoSuchElementException(obj);
    }


    public static int hashCode(int[][] arrays) {
        if (arrays == null) {
            return 0;
        }
        int result = 1;
        int h = arrays.length;
        int w = (arrays[0]).length;
        int value = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                value = arrays[i][j];
                int elementHash = value ^ value >>> 32;
                result = 31 * result + elementHash;
            }
        }
        return result;
    }


    public static Object expand(Object array, int size) {
        int len = Array.getLength(array);
        Object dstArray = Array.newInstance(array.getClass().getComponentType(), len + size);
        System.arraycopy(array, 0, dstArray, size, len);
        return dstArray;
    }


    public static Object expand(Object array, int size, Class<?> clazz) {
        if (array == null) {
            return Array.newInstance(clazz, 1);
        }
        return expand(array, size);
    }


    public static Object cut(Object array, int size) {
        int len;
        if ((len = Array.getLength(array)) == 1) {
            return Array.newInstance(array.getClass().getComponentType(), 0);
        }
        int k;
        if ((k = len - size - 1) > 0) {
            System.arraycopy(array, size + 1, array, size, k);
        }
        len--;
        Object newArray = Array.newInstance(array.getClass().getComponentType(), len);
        System.arraycopy(array, 0, newArray, 0, len);
        return newArray;
    }


    public static Object copyOf(Object array) {
        int len = Array.getLength(array);
        Class<?> type = array.getClass().getComponentType();
        Object dest = Array.newInstance(type, len);
        if (type.isArray()) {
            for (int i = 0; i < Array.getLength(array); i++) {
                Array.set(dest, i, copyOf(Array.get(array, i)));
            }
        } else {
            System.arraycopy(array, 0, dest, 0, len);
        }
        return dest;
    }


    public static int[][] copyOf(int[][] arrays) {
        int size = arrays.length;
        int[][] copy = new int[size][];
        for (int i = 0; i < size; i++) {
            int len = (arrays[i]).length;
            System.arraycopy(arrays[i], 0, copy[i], 0, len);
        }
        return copy;
    }


    public static String[] copyOf(String[] array) {
        return copyOf(array, array.length);
    }


    public static String[] copyOf(String[] array, int newSize) {
        String[] result = new String[newSize];
        System.arraycopy(array, 0, result, 0, Math.min(array.length, newSize));
        return result;
    }


    public static int[] copyOf(int[] array) {
        return copyOf(array, array.length);
    }


    public static int[] copyOf(int[] array, int newSize) {
        int[] result = new int[newSize];
        System.arraycopy(array, 0, result, 0, Math.min(array.length, newSize));
        return result;
    }


    public static double[] copyOf(double[] array) {
        return copyOf(array, array.length);
    }


    public static double[] copyOf(double[] array, int newSize) {
        double[] result = new double[newSize];
        System.arraycopy(array, 0, result, 0, Math.min(array.length, newSize));
        return result;
    }


    public static float[] copyOf(float[] array) {
        return copyOf(array, array.length);
    }


    public static float[] copyOf(float[] array, int newSize) {
        float[] result = new float[newSize];
        System.arraycopy(array, 0, result, 0, Math.min(array.length, newSize));
        return result;
    }


    public static byte[] copyOf(byte[] array) {
        return copyOf(array, array.length);
    }


    public static byte[] copyOf(byte[] array, int newSize) {
        byte[] result = new byte[newSize];
        System.arraycopy(array, 0, result, 0, Math.min(array.length, newSize));
        return result;
    }


    public static char[] copyOf(char[] array) {
        return copyOf(array, array.length);
    }


    public static char[] copyOf(char[] array, int newSize) {
        char[] result = new char[newSize];
        System.arraycopy(array, 0, result, 0, Math.min(array.length, newSize));
        return result;
    }


    public static long[] copyOf(long[] array) {
        return copyOf(array, array.length);
    }


    public static long[] copyOf(long[] array, int newSize) {
        long[] result = new long[newSize];
        System.arraycopy(array, 0, result, 0, Math.min(array.length, newSize));
        return result;
    }


    public static boolean[] copyOf(boolean[] array) {
        return copyOf(array, array.length);
    }


    public static boolean[] copyOf(boolean[] array, int newSize) {
        boolean[] result = new boolean[newSize];
        System.arraycopy(array, 0, result, 0, Math.min(array.length, newSize));
        return result;
    }
}


