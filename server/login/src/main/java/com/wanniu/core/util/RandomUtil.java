/*     */ package com.wanniu.core.util;
/*     */ 
/*     */ import java.util.Random;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class RandomUtil
/*     */ {
/*  13 */   private static final Random __RANDOM__ = new Random();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getIndex(int size) {
/*  19 */     return __RANDOM__.nextInt(size);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getInt(int limit) {
/*  26 */     return __RANDOM__.nextInt(limit) + 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static short getShort(int limit) {
/*  37 */     if (limit > 32767) {
/*  38 */       return Short.MAX_VALUE;
/*     */     }
/*  40 */     return (short)(__RANDOM__.nextInt(limit) + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getInt(int lower, int limit) {
/*  47 */     if (limit <= lower) {
/*  48 */       return 0;
/*     */     }
/*  50 */     return __RANDOM__.nextInt(limit - lower) + lower;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static short getShort(int lower, int limit) {
/*  57 */     if (limit <= lower || limit >= 32767) {
/*  58 */       return 0;
/*     */     }
/*  60 */     return (short)(__RANDOM__.nextInt(limit - lower) + lower);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte getByte(int lower, int limit) {
/*  67 */     if (limit <= lower || limit > 127) {
/*  68 */       return 0;
/*     */     }
/*     */     
/*  71 */     return (byte)(__RANDOM__.nextInt(limit - lower) + lower);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float getFloat() {
/*  78 */     return __RANDOM__.nextFloat();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getPercent() {
/*  86 */     return __RANDOM__.nextInt(100) + 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long getLong(long min, long limit) {
/*  94 */     long value = 0L;
/*  95 */     if (min != limit) {
/*  96 */       value = Math.abs(__RANDOM__.nextLong()) % (limit - min) + min;
/*     */     } else {
/*  98 */       value = min;
/*     */     } 
/* 100 */     return value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int random(int max) {
/* 107 */     return __RANDOM__.nextInt(max);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int[] select(int srcCount, int dstCount) {
/* 114 */     if (dstCount > srcCount) {
/* 115 */       dstCount = srcCount;
/*     */     }
/* 117 */     int[] result = new int[dstCount];
/* 118 */     if (dstCount < srcCount) {
/*     */       
/* 120 */       int[] source = new int[srcCount];
/* 121 */       for (int i = 0; i < source.length; i++) {
/* 122 */         source[i] = i;
/*     */       }
/*     */       
/* 125 */       for (int j = 0; j < dstCount; j++, srcCount--) {
/* 126 */         int index = __RANDOM__.nextInt(srcCount);
/* 127 */         result[j] = source[index];
/* 128 */         source[index] = source[srcCount - 1];
/*     */       } 
/*     */     } else {
/*     */       
/* 132 */       for (int i = 0; i < result.length; i++) {
/* 133 */         result[i] = i;
/*     */       }
/*     */     } 
/* 136 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int hit(int[] weights) {
/* 145 */     int weight = 0;
/*     */     
/* 147 */     for (int i = 0; i < weights.length; i++) {
/* 148 */       weight += weights[i];
/* 149 */       weights[i] = weight;
/*     */     } 
/* 151 */     int random = random(weight);
/*     */     
/* 153 */     for (int index = 0; index < weights.length; index++) {
/* 154 */       if (random < weights[index]) {
/* 155 */         return index;
/*     */       }
/*     */     } 
/* 158 */     return 0;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\cor\\util\RandomUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */