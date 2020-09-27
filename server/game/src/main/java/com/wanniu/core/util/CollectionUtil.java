/*     */ package com.wanniu.core.util;
/*     */ 
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.NoSuchElementException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class CollectionUtil
/*     */ {
/*     */   public static final int INITIAL_CAPACITY = 10;
/*     */   
/*     */   public static int indexOf(Object[] array, Object obj) {
/*  22 */     for (int i = 0; i < array.length; i++) {
/*  23 */       if (obj == array[i]) {
/*  24 */         return i;
/*     */       }
/*     */     } 
/*  27 */     throw new NoSuchElementException("" + obj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int hashCode(int[][] arrays) {
/*  34 */     if (arrays == null) {
/*  35 */       return 0;
/*     */     }
/*  37 */     int result = 1;
/*  38 */     int h = arrays.length;
/*  39 */     int w = (arrays[0]).length;
/*  40 */     int value = 0;
/*  41 */     for (int i = 0; i < h; i++) {
/*  42 */       for (int j = 0; j < w; j++) {
/*  43 */         value = arrays[i][j];
/*  44 */         int elementHash = value ^ value >>> 32;
/*  45 */         result = 31 * result + elementHash;
/*     */       } 
/*     */     } 
/*  48 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object expand(Object array, int size) {
/*  55 */     int len = Array.getLength(array);
/*  56 */     Object dstArray = Array.newInstance(array.getClass().getComponentType(), len + size);
/*  57 */     System.arraycopy(array, 0, dstArray, size, len);
/*  58 */     return dstArray;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object expand(Object array, int size, Class<?> clazz) {
/*  65 */     if (array == null) {
/*  66 */       return Array.newInstance(clazz, 1);
/*     */     }
/*  68 */     return expand(array, size);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object cut(Object array, int size) {
/*     */     int len;
/*  77 */     if ((len = Array.getLength(array)) == 1) {
/*  78 */       return Array.newInstance(array.getClass().getComponentType(), 0);
/*     */     }
/*     */     int k;
/*  81 */     if ((k = len - size - 1) > 0) {
/*  82 */       System.arraycopy(array, size + 1, array, size, k);
/*     */     }
/*  84 */     len--;
/*  85 */     Object newArray = Array.newInstance(array.getClass().getComponentType(), len);
/*  86 */     System.arraycopy(array, 0, newArray, 0, len);
/*  87 */     return newArray;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object copyOf(Object array) {
/*  94 */     int len = Array.getLength(array);
/*  95 */     Class<?> type = array.getClass().getComponentType();
/*  96 */     Object dest = Array.newInstance(type, len);
/*  97 */     if (type.isArray()) {
/*  98 */       for (int i = 0; i < Array.getLength(array); i++) {
/*  99 */         Array.set(dest, i, copyOf(Array.get(array, i)));
/*     */       }
/*     */     } else {
/* 102 */       System.arraycopy(array, 0, dest, 0, len);
/*     */     } 
/* 104 */     return dest;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int[][] copyOf(int[][] arrays) {
/* 111 */     int size = arrays.length;
/* 112 */     int[][] copy = new int[size][];
/* 113 */     for (int i = 0; i < size; i++) {
/* 114 */       int len = (arrays[i]).length;
/* 115 */       System.arraycopy(arrays[i], 0, copy[i], 0, len);
/*     */     } 
/* 117 */     return copy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String[] copyOf(String[] array) {
/* 124 */     return copyOf(array, array.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String[] copyOf(String[] array, int newSize) {
/* 131 */     String[] result = new String[newSize];
/* 132 */     System.arraycopy(array, 0, result, 0, Math.min(array.length, newSize));
/* 133 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int[] copyOf(int[] array) {
/* 140 */     return copyOf(array, array.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int[] copyOf(int[] array, int newSize) {
/* 147 */     int[] result = new int[newSize];
/* 148 */     System.arraycopy(array, 0, result, 0, Math.min(array.length, newSize));
/* 149 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double[] copyOf(double[] array) {
/* 156 */     return copyOf(array, array.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double[] copyOf(double[] array, int newSize) {
/* 163 */     double[] result = new double[newSize];
/* 164 */     System.arraycopy(array, 0, result, 0, Math.min(array.length, newSize));
/* 165 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float[] copyOf(float[] array) {
/* 172 */     return copyOf(array, array.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float[] copyOf(float[] array, int newSize) {
/* 179 */     float[] result = new float[newSize];
/* 180 */     System.arraycopy(array, 0, result, 0, Math.min(array.length, newSize));
/* 181 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] copyOf(byte[] array) {
/* 188 */     return copyOf(array, array.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] copyOf(byte[] array, int newSize) {
/* 195 */     byte[] result = new byte[newSize];
/* 196 */     System.arraycopy(array, 0, result, 0, Math.min(array.length, newSize));
/* 197 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static char[] copyOf(char[] array) {
/* 204 */     return copyOf(array, array.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static char[] copyOf(char[] array, int newSize) {
/* 211 */     char[] result = new char[newSize];
/* 212 */     System.arraycopy(array, 0, result, 0, Math.min(array.length, newSize));
/* 213 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long[] copyOf(long[] array) {
/* 220 */     return copyOf(array, array.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long[] copyOf(long[] array, int newSize) {
/* 227 */     long[] result = new long[newSize];
/* 228 */     System.arraycopy(array, 0, result, 0, Math.min(array.length, newSize));
/* 229 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean[] copyOf(boolean[] array) {
/* 236 */     return copyOf(array, array.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean[] copyOf(boolean[] array, int newSize) {
/* 243 */     boolean[] result = new boolean[newSize];
/* 244 */     System.arraycopy(array, 0, result, 0, Math.min(array.length, newSize));
/* 245 */     return result;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\cor\\util\CollectionUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */