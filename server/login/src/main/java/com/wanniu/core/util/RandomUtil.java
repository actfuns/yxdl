package com.wanniu.core.util;

import java.util.Random;


public final class RandomUtil {
    private static final Random __RANDOM__ = new Random();


    public static int getIndex(int size) {
        return __RANDOM__.nextInt(size);
    }


    public static int getInt(int limit) {
        return __RANDOM__.nextInt(limit) + 1;
    }


    public static short getShort(int limit) {
        if (limit > 32767) {
            return Short.MAX_VALUE;
        }
        return (short) (__RANDOM__.nextInt(limit) + 1);
    }


    public static int getInt(int lower, int limit) {
        if (limit <= lower) {
            return 0;
        }
        return __RANDOM__.nextInt(limit - lower) + lower;
    }


    public static short getShort(int lower, int limit) {
        if (limit <= lower || limit >= 32767) {
            return 0;
        }
        return (short) (__RANDOM__.nextInt(limit - lower) + lower);
    }


    public static byte getByte(int lower, int limit) {
        if (limit <= lower || limit > 127) {
            return 0;
        }

        return (byte) (__RANDOM__.nextInt(limit - lower) + lower);
    }


    public static float getFloat() {
        return __RANDOM__.nextFloat();
    }


    public static int getPercent() {
        return __RANDOM__.nextInt(100) + 1;
    }


    public static long getLong(long min, long limit) {
        long value = 0L;
        if (min != limit) {
            value = Math.abs(__RANDOM__.nextLong()) % (limit - min) + min;
        } else {
            value = min;
        }
        return value;
    }


    public static int random(int max) {
        return __RANDOM__.nextInt(max);
    }


    public static int[] select(int srcCount, int dstCount) {
        if (dstCount > srcCount) {
            dstCount = srcCount;
        }
        int[] result = new int[dstCount];
        if (dstCount < srcCount) {

            int[] source = new int[srcCount];
            for (int i = 0; i < source.length; i++) {
                source[i] = i;
            }

            for (int j = 0; j < dstCount; j++, srcCount--) {
                int index = __RANDOM__.nextInt(srcCount);
                result[j] = source[index];
                source[index] = source[srcCount - 1];
            }
        } else {

            for (int i = 0; i < result.length; i++) {
                result[i] = i;
            }
        }
        return result;
    }


    public static int hit(int[] weights) {
        int weight = 0;

        for (int i = 0; i < weights.length; i++) {
            weight += weights[i];
            weights[i] = weight;
        }
        int random = random(weight);

        for (int index = 0; index < weights.length; index++) {
            if (random < weights[index]) {
                return index;
            }
        }
        return 0;
    }
}


