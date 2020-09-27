/*     */ package com.wanniu.core.util.xml;
/*     */ 
/*     */ import com.wanniu.core.GGlobal;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.NodeList;
/*     */ import org.xml.sax.SAXException;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class XW3CParser
/*     */ {
/*     */   private static Element getRootElement(String xmlFile) throws ParserConfigurationException, SAXException, IOException {
/*  36 */     DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
/*     */     
/*  38 */     InputStream is = null;
/*     */     try {
/*  40 */       DocumentBuilder dombuilder = domfac.newDocumentBuilder();
/*  41 */       is = new FileInputStream(xmlFile);
/*  42 */       Document doc = dombuilder.parse(is);
/*  43 */       return doc.getDocumentElement();
/*     */     } finally {
/*  45 */       if (is != null) {
/*     */         try {
/*  47 */           is.close();
/*  48 */         } catch (IOException e) {
/*  49 */           Out.error(new Object[] { "XW3CParser getRootElement", e });
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends XW3CParsable> List<T> parse(String xmlFile, Class<T> clas) throws Exception {
/*  60 */     ArrayList<T> beans = new ArrayList<>();
/*  61 */     Element root = getRootElement(xmlFile);
/*     */     
/*  63 */     NodeList nhosts = root.getChildNodes();
/*     */     
/*  65 */     if (nhosts != null) {
/*  66 */       for (int i = 0; i < nhosts.getLength(); i++) {
/*  67 */         XW3CParsable xW3CParsable = (XW3CParsable)clas.newInstance();
/*     */         
/*  69 */         if (xW3CParsable.parse(nhosts.item(i))) {
/*  70 */           beans.add((T)xW3CParsable);
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*  75 */     return beans;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void parse(String xmlFile, XW3CParsable parser) throws Exception {
/*  82 */     Element root = getRootElement(xmlFile);
/*     */     
/*  84 */     NodeList nhosts = root.getChildNodes();
/*     */     
/*  86 */     if (nhosts != null) {
/*  87 */       for (int i = 0; i < nhosts.getLength(); i++) {
/*  88 */         parser.parse(nhosts.item(i));
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void parseText(String text, XW3CParsable parser) throws Exception {
/*  95 */     DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
/*     */     
/*  97 */     ByteArrayInputStream is = null;
/*  98 */     Element root = null;
/*     */     try {
/* 100 */       DocumentBuilder dombuilder = domfac.newDocumentBuilder();
/* 101 */       is = new ByteArrayInputStream(text.getBytes(GGlobal.UTF_8));
/* 102 */       Document doc = dombuilder.parse(is);
/* 103 */       root = doc.getDocumentElement();
/*     */     } finally {
/* 105 */       if (is != null) {
/*     */         try {
/* 107 */           is.close();
/* 108 */         } catch (IOException e) {
/* 109 */           Out.error(new Object[] { "XW3CParser parseText", e });
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 114 */     NodeList nhosts = root.getChildNodes();
/*     */     
/* 116 */     if (nhosts != null)
/* 117 */       for (int i = 0; i < nhosts.getLength(); i++)
/* 118 */         parser.parse(nhosts.item(i));  
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\cor\\util\xml\XW3CParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */