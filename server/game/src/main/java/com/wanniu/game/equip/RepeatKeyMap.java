/*     */ package com.wanniu.game.equip;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RepeatKeyMap<K, V>
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public static class Pair<K, V>
/*     */     implements Serializable
/*     */   {
/*     */     private static final long serialVersionUID = 6716065295786812835L;
/*     */     public K k;
/*     */     public V v;
/*     */     
/*     */     public Pair() {}
/*     */     
/*     */     public Pair(K k, V v) {
/*  27 */       this.k = k;
/*  28 */       this.v = v;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  36 */   private List<Pair<K, V>> values = null;
/*     */   
/*     */   public List<Pair<K, V>> getValues() {
/*  39 */     return this.values;
/*     */   }
/*     */   
/*     */   public void clear() {
/*  43 */     if (this.values != null) {
/*  44 */       this.values.clear();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/*  49 */     return (this.values == null || this.values.isEmpty());
/*     */   }
/*     */   
/*     */   public void setValues(List<Pair<K, V>> values) {
/*  53 */     this.values = values;
/*     */   }
/*     */   
/*     */   public static long getSerialversionuid() {
/*  57 */     return 1L;
/*     */   }
/*     */   
/*     */   public RepeatKeyMap() {
/*  61 */     this.values = new ArrayList<>();
/*     */   }
/*     */   
/*     */   public V put(K key, V value) {
/*  65 */     this.values.add(new Pair<>(key, value));
/*  66 */     return value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void putIfEmpty(K key, V value) {
/*  76 */     boolean hit = false;
/*  77 */     for (Pair<K, V> pair : this.values) {
/*  78 */       if (String.valueOf(pair.k).equals("0")) {
/*  79 */         pair.k = key;
/*  80 */         pair.v = value;
/*  81 */         hit = true;
/*     */         break;
/*     */       } 
/*     */     } 
/*  85 */     if (!hit) {
/*  86 */       this.values.add(new Pair<>(key, value));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void put(Pair<K, V> pair) {
/*  92 */     this.values.add(pair);
/*     */   }
/*     */   
/*     */   public List<K> keySet() {
/*  96 */     List<K> list = new ArrayList<>();
/*  97 */     for (Pair<K, V> pair : this.values) {
/*  98 */       list.add(pair.k);
/*     */     }
/* 100 */     return list;
/*     */   }
/*     */   
/*     */   public List<Pair<K, V>> entrySet() {
/* 104 */     return this.values;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 108 */     StringBuilder sb = new StringBuilder();
/* 109 */     sb.append("{");
/* 110 */     for (Pair<K, V> pair : this.values) {
/* 111 */       sb.append(pair.k).append("=").append(pair.v).append(",");
/*     */     }
/* 113 */     sb.deleteCharAt(sb.length() - 1);
/* 114 */     sb.append("}");
/* 115 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public boolean containsKey(K key) {
/* 119 */     for (Pair<K, V> pair : this.values) {
/* 120 */       if (pair.k.equals(key)) {
/* 121 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 125 */     return false;
/*     */   }
/*     */   
/*     */   public int size() {
/* 129 */     return this.values.size();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 133 */     RepeatKeyMap<Integer, Integer> tm = new RepeatKeyMap<>();
/* 134 */     for (int i = 1; i <= 10; i++) {
/* 135 */       tm.put(Integer.valueOf(100 + i), Integer.valueOf(100 * i));
/*     */     }
/*     */     
/* 138 */     System.out.println(tm.toString());
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\equip\RepeatKeyMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */