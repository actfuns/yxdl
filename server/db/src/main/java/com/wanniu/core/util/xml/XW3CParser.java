/*     */ package com.wanniu.core.util.xml;
/*     */ 
/*     */ import com.wanniu.core.GGlobal;
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
/*  35 */     DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
/*     */     
/*  37 */     InputStream is = null;
/*     */     try {
/*  39 */       DocumentBuilder dombuilder = domfac.newDocumentBuilder();
/*  40 */       is = new FileInputStream(xmlFile);
/*  41 */       Document doc = dombuilder.parse(is);
/*  42 */       return doc.getDocumentElement();
/*     */     } finally {
/*  44 */       if (is != null) {
/*     */         try {
/*  46 */           is.close();
/*  47 */         } catch (IOException e) {
/*  48 */           e.printStackTrace();
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
/*  59 */     ArrayList<T> beans = new ArrayList<>();
/*  60 */     Element root = getRootElement(xmlFile);
/*     */     
/*  62 */     NodeList nhosts = root.getChildNodes();
/*     */     
/*  64 */     if (nhosts != null) {
/*  65 */       for (int i = 0; i < nhosts.getLength(); i++) {
/*  66 */         XW3CParsable xW3CParsable = (XW3CParsable)clas.newInstance();
/*     */         
/*  68 */         if (xW3CParsable.parse(nhosts.item(i))) {
/*  69 */           beans.add((T)xW3CParsable);
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*  74 */     return beans;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void parse(String xmlFile, XW3CParsable parser) throws Exception {
/*  81 */     Element root = getRootElement(xmlFile);
/*     */     
/*  83 */     NodeList nhosts = root.getChildNodes();
/*     */     
/*  85 */     if (nhosts != null) {
/*  86 */       for (int i = 0; i < nhosts.getLength(); i++) {
/*  87 */         parser.parse(nhosts.item(i));
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void parseText(String text, XW3CParsable parser) throws Exception {
/*  94 */     DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
/*     */     
/*  96 */     ByteArrayInputStream is = null;
/*  97 */     Element root = null;
/*     */     try {
/*  99 */       DocumentBuilder dombuilder = domfac.newDocumentBuilder();
/* 100 */       is = new ByteArrayInputStream(text.getBytes(GGlobal.UTF_8));
/* 101 */       Document doc = dombuilder.parse(is);
/* 102 */       root = doc.getDocumentElement();
/*     */     } finally {
/* 104 */       if (is != null) {
/*     */         try {
/* 106 */           is.close();
/* 107 */         } catch (IOException e) {
/* 108 */           e.printStackTrace();
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 113 */     NodeList nhosts = root.getChildNodes();
/*     */     
/* 115 */     if (nhosts != null)
/* 116 */       for (int i = 0; i < nhosts.getLength(); i++)
/* 117 */         parser.parse(nhosts.item(i));  
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-db\xmds-db.jar!\com\wanniu\cor\\util\xml\XW3CParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */