/*     */ package com.wanniu.game.util;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
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
/*     */ public final class DFAScanner
/*     */ {
/*     */   private static final char SBC_CHAR_START = '！';
/*     */   private static final char SBC_CHAR_END = '～';
/*     */   private static final int CONVERT_STEP = 65248;
/*     */   private static final char SBC_SPACE = '　';
/*     */   private static final char DBC_SPACE = ' ';
/*  26 */   private final Set<Integer> separatesSymbols = new HashSet<>();
/*  27 */   private final Map<Integer, DFANode> nodes = new HashMap<>();
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
/*     */   public DFAScanner(List<String> sensitivewords) {
/*  39 */     this(" `~!1@2#3$4%5^6&7*8(9)0_-+={[}]|\\:;\"'<,>.?/！￥%……｛｝【】", sensitivewords);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DFAScanner(String symbols, List<String> sensitivewords) {
/*  49 */     initSeparatesSymbol(symbols);
/*  50 */     initSensitiveWords(sensitivewords);
/*     */   }
/*     */ 
/*     */   
/*     */   private void initSensitiveWords(List<String> sensitivewords) {
/*  55 */     if (!sensitivewords.isEmpty())
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  61 */       for (String curr : sensitivewords) {
/*  62 */         DFANode fnode; char[] chs = curr.toCharArray();
/*  63 */         int fchar = charConvert(chs[0]);
/*  64 */         if (!this.nodes.containsKey(Integer.valueOf(fchar))) {
/*  65 */           fnode = new DFANode(fchar, (chs.length == 1));
/*  66 */           this.nodes.put(Integer.valueOf(fchar), fnode);
/*     */         } else {
/*  68 */           fnode = this.nodes.get(Integer.valueOf(fchar));
/*  69 */           if (!fnode.isLast() && chs.length == 1)
/*  70 */             fnode.setLast(true); 
/*     */         } 
/*  72 */         int lastIndex = chs.length - 1;
/*  73 */         for (int i = 1; i < chs.length; i++) {
/*  74 */           fnode = fnode.addIfNoExist(charConvert(chs[i]), (i == lastIndex));
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void initSeparatesSymbol(String symbols) {
/*  82 */     for (int i = 0, len = symbols.length(); i < len; i++) {
/*  83 */       this.separatesSymbols.add(Integer.valueOf(charConvert(symbols.charAt(i))));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int qj2bj(char src) {
/*  91 */     int r = src;
/*  92 */     if (src >= '！' && src <= '～') {
/*  93 */       r = src - 65248;
/*  94 */     } else if (src == '　') {
/*  95 */       r = 32;
/*     */     } 
/*  97 */     return r;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int charConvert(char src) {
/* 104 */     int r = qj2bj(src);
/* 105 */     return (r >= 65 && r <= 90) ? (r + 32) : r;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean findSensitiveWord(String text) {
/* 115 */     char[] chs = text.toCharArray();
/* 116 */     for (int i = 0, length = chs.length; i < length; i++) {
/* 117 */       int currc = charConvert(chs[i]);
/*     */       
/* 119 */       DFANode node = this.nodes.get(Integer.valueOf(currc));
/*     */       
/* 121 */       if (node != null) {
/*     */ 
/*     */         
/* 124 */         boolean couldMark = false;
/* 125 */         if (node.isLast())
/*     */         {
/* 127 */           couldMark = true;
/*     */         }
/* 129 */         int cpcurrc = currc;
/* 130 */         for (int k = i; ++k < length; ) {
/* 131 */           int temp = charConvert(chs[k]);
/* 132 */           if (temp == cpcurrc)
/*     */             continue; 
/* 134 */           if (this.separatesSymbols.contains(Integer.valueOf(temp)))
/*     */             continue; 
/* 136 */           node = node.querySub(temp);
/* 137 */           if (node == null) {
/*     */             break;
/*     */           }
/* 140 */           if (node.isLast()) {
/* 141 */             couldMark = true;
/*     */             break;
/*     */           } 
/* 144 */           cpcurrc = temp;
/*     */         } 
/* 146 */         if (couldMark)
/* 147 */           return true; 
/*     */       } 
/*     */     } 
/* 150 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String replaceSensitiveWord(String text, boolean ignoreCode) {
/* 160 */     char[] chs = text.toCharArray();
/* 161 */     boolean flag = false;
/* 162 */     boolean startIgnore = false;
/* 163 */     for (int i = 0, length = chs.length; i < length; i++) {
/* 164 */       if (ignoreCode && chs[i] == '>') {
/* 165 */         startIgnore = false;
/*     */       
/*     */       }
/* 168 */       else if (!startIgnore) {
/*     */ 
/*     */         
/* 171 */         if (ignoreCode && chs[i] == '<') {
/* 172 */           startIgnore = true;
/*     */         }
/*     */         else {
/*     */           
/* 176 */           int currc = charConvert(chs[i]);
/* 177 */           DFANode node = this.nodes.get(Integer.valueOf(currc));
/* 178 */           if (node != null)
/*     */           
/*     */           { 
/*     */             
/* 182 */             int markNum = -1;
/* 183 */             boolean couldMark = false;
/* 184 */             if (node.isLast()) {
/* 185 */               couldMark = true;
/* 186 */               markNum = 0;
/*     */             } 
/*     */ 
/*     */             
/* 190 */             int cpcurrc = currc; int k;
/* 191 */             for (k = i; ++k < length; ) {
/* 192 */               int temp = charConvert(chs[k]);
/* 193 */               if (temp == cpcurrc)
/*     */                 continue; 
/* 195 */               if (this.separatesSymbols.contains(Integer.valueOf(temp)))
/*     */                 continue; 
/* 197 */               node = node.querySub(temp);
/* 198 */               if (node == null)
/*     */                 break; 
/* 200 */               if (node.isLast()) {
/* 201 */                 couldMark = true;
/* 202 */                 markNum = k - i;
/*     */                 break;
/*     */               } 
/* 205 */               cpcurrc = temp;
/*     */             } 
/* 207 */             if (couldMark)
/* 208 */             { for (k = 0; k <= markNum; k++) {
/* 209 */                 chs[k + i] = '*';
/*     */               }
/* 211 */               i += markNum;
/* 212 */               flag = true; }  } 
/*     */         } 
/*     */       } 
/* 215 */     }  return flag ? new String(chs) : text;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gam\\util\DFAScanner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */