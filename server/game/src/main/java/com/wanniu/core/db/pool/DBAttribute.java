/*     */ package com.wanniu.core.db.pool;
/*     */ 
/*     */ import com.wanniu.core.util.xml.XW3CParsable;
/*     */ import org.w3c.dom.Node;
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
/*     */ public final class DBAttribute
/*     */   implements XW3CParsable
/*     */ {
/*     */   private static final long CHECK_INTERVAL = 300000L;
/*     */   private String dsName;
/*     */   private String driver;
/*     */   private String url;
/*     */   private String username;
/*     */   private String password;
/*  26 */   private int minConnection = 2;
/*     */   
/*  28 */   private int maxConnection = 30;
/*     */   
/*  30 */   private long timeout = 300000L;
/*     */   
/*  32 */   private int waitTime = 10000;
/*     */   
/*     */   private boolean checkAble = true;
/*     */   
/*  36 */   private long checkInterval = 300000L;
/*     */   
/*     */   public String getDriver() {
/*  39 */     return this.driver;
/*     */   }
/*     */   
/*     */   public int getMaxConnection() {
/*  43 */     return this.maxConnection;
/*     */   }
/*     */   
/*     */   public int getMinConnection() {
/*  47 */     return this.minConnection;
/*     */   }
/*     */   
/*     */   public String getPassword() {
/*  51 */     return this.password;
/*     */   }
/*     */   
/*     */   public long getTimeout() {
/*  55 */     return this.timeout;
/*     */   }
/*     */   
/*     */   public String getUrl() {
/*  59 */     return this.url;
/*     */   }
/*     */   
/*     */   public String getUserName() {
/*  63 */     return this.username;
/*     */   }
/*     */   
/*     */   public int getWaitTime() {
/*  67 */     return this.waitTime;
/*     */   }
/*     */   
/*     */   public void setDriver(String driver) {
/*  71 */     this.driver = driver;
/*     */   }
/*     */   
/*     */   public void setMaxConnection(int maxConnection) {
/*  75 */     this.maxConnection = maxConnection;
/*     */   }
/*     */   
/*     */   public void setMinConnection(int minConnection) {
/*  79 */     this.minConnection = (minConnection < 0) ? 0 : minConnection;
/*     */   }
/*     */   
/*     */   public void setPassword(String password) {
/*  83 */     this.password = password;
/*     */   }
/*     */   
/*     */   public void setTimeoutValue(long timeoutValue) {
/*  87 */     this.timeout = timeoutValue;
/*     */   }
/*     */   
/*     */   public void setUrl(String url) {
/*  91 */     this.url = url;
/*     */   }
/*     */   
/*     */   public void setUserName(String username) {
/*  95 */     this.username = username;
/*     */   }
/*     */   
/*     */   public void setWaitTime(int waitTime) {
/*  99 */     this.waitTime = waitTime;
/*     */   }
/*     */   
/*     */   public String getDsName() {
/* 103 */     return this.dsName;
/*     */   }
/*     */   
/*     */   public void setDsName(String dsName) {
/* 107 */     this.dsName = dsName;
/*     */   }
/*     */   
/*     */   public long getCheckInterval() {
/* 111 */     return this.checkInterval;
/*     */   }
/*     */   
/*     */   public boolean isCheckAble() {
/* 115 */     return this.checkAble;
/*     */   }
/*     */   
/*     */   public boolean parse(Node xmlBean) {
/* 119 */     if (xmlBean.getNodeName().equals("pool")) {
/* 120 */       for (Node node = xmlBean.getFirstChild(); node != null; node = node.getNextSibling()) {
/* 121 */         if (node.getNodeType() == 1) {
/* 122 */           String nodeName = node.getNodeName().intern();
/* 123 */           if (nodeName.equals("dsname")) {
/* 124 */             this.dsName = node.getTextContent();
/* 125 */           } else if (nodeName.equals("driver")) {
/* 126 */             this.driver = node.getTextContent();
/* 127 */           } else if (nodeName.equals("url")) {
/* 128 */             this.url = node.getTextContent();
/* 129 */           } else if (nodeName.equals("username")) {
/* 130 */             this.username = node.getTextContent();
/* 131 */           } else if (nodeName.equals("password")) {
/* 132 */             this.password = node.getTextContent();
/* 133 */           } else if (nodeName.equals("minconn")) {
/* 134 */             this.minConnection = Integer.parseInt(node.getTextContent());
/* 135 */           } else if (nodeName.equals("maxconn")) {
/* 136 */             this.maxConnection = Integer.parseInt(node.getTextContent());
/* 137 */           } else if (nodeName.equals("timeout")) {
/* 138 */             this.timeout = Long.parseLong(node.getTextContent());
/* 139 */           } else if (nodeName.equals("waittime")) {
/* 140 */             this.waitTime = Integer.parseInt(node.getTextContent());
/* 141 */           } else if (nodeName.equals("checkable")) {
/* 142 */             this.checkAble = Boolean.parseBoolean(node.getTextContent());
/* 143 */           } else if (nodeName.equals("checkinterval")) {
/* 144 */             this.checkInterval = Long.parseLong(node.getTextContent());
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 149 */       return true;
/*     */     } 
/* 151 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\db\pool\DBAttribute.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */