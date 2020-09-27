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
/*  19 */     if (size <= 1)
/*  20 */       return 0; 
/*  21 */     return __RANDOM__.nextInt(size);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getInt(int limit) {
/*  28 */     if (limit <= 1)
/*  29 */       return 1; 
/*  30 */     return __RANDOM__.nextInt(limit) + 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getInt(int lower, int limit) {
/*  37 */     if (limit <= lower) {
/*  38 */       return lower;
/*     */     }
/*  40 */     return __RANDOM__.nextInt(limit - lower + 1) + lower;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float getFloat() {
/*  47 */     return __RANDOM__.nextFloat();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int random(int max) {
/*  54 */     return __RANDOM__.nextInt(max);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double randomDouble() {
/*  63 */     return __RANDOM__.nextDouble();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int[] select(int srcCount, int dstCount) {
/*  70 */     if (dstCount > srcCount) {
/*  71 */       dstCount = srcCount;
/*     */     }
/*  73 */     int[] result = new int[dstCount];
/*  74 */     if (dstCount < srcCount) {
/*     */       
/*  76 */       int[] source = new int[srcCount];
/*  77 */       for (int i = 0; i < source.length; i++) {
/*  78 */         source[i] = i;
/*     */       }
/*     */       
/*  81 */       for (int j = 0; j < dstCount; j++, srcCount--) {
/*  82 */         int index = __RANDOM__.nextInt(srcCount);
/*  83 */         result[j] = source[index];
/*  84 */         source[index] = source[srcCount - 1];
/*     */       } 
/*     */     } else {
/*     */       
/*  88 */       for (int i = 0; i < result.length; i++) {
/*  89 */         result[i] = i;
/*     */       }
/*     */     } 
/*  92 */     return result;
/*     */   }
/*     */   
/*     */   public static int randomValue(int range) {
/*  96 */     if (range <= 0) {
/*  97 */       return 0;
/*     */     }
/*  99 */     return __RANDOM__.nextInt(range);
/*     */   }
/*     */   
/*     */   public static boolean hasHitRate(int range, int rate) {
/* 103 */     int cos = randomValue(range);
/* 104 */     if (cos < rate) {
/* 105 */       return true;
/*     */     }
/* 107 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int hit(int[] weights) {
/* 117 */     int weight = 0;
/*     */     
/* 119 */     for (int i = 0; i < weights.length; i++) {
/* 120 */       weight += weights[i];
/* 121 */       weights[i] = weight;
/*     */     } 
/* 123 */     int random = random(weight);
/*     */     
/* 125 */     for (int index = 0; index < weights.length; index++) {
/* 126 */       if (random < weights[index]) {
/* 127 */         return index;
/*     */       }
/*     */     } 
/* 130 */     return 0;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\cor\\util\RandomUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */