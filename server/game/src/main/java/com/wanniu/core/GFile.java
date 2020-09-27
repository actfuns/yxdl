/*    */ package com.wanniu.core;
/*    */ 
/*    */ import java.io.File;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ interface GFile
/*    */ {
/* 14 */   public static final String _ROOT_DIR_ = System.getProperty("user.dir") + File.separator + "%s" + File.separator;
/*    */ 
/*    */   
/* 17 */   public static final String DIR_CONF_SERVER = String.format(_ROOT_DIR_, new Object[] { "conf" });
/*    */ 
/*    */   
/* 20 */   public static final String DIR_CONF_GAME = GConfig.getInstance().get("dir.conf.game", DIR_CONF_SERVER);
/*    */ 
/*    */   
/* 23 */   public static final String DIR_DATA = GConfig.getInstance().get("dir.data", String.format(_ROOT_DIR_, new Object[] { "data" }));
/*    */ 
/*    */   
/* 26 */   public static final String DIR_COMMON = GConfig.getInstance().get("dir.common", DIR_DATA + "common" + File.separator);
/*    */ 
/*    */   
/* 29 */   public static final String DIR_SCRIPT_ROOT = GConfig.getInstance().get("dir.scripts", String.format(_ROOT_DIR_, new Object[] { "classes" }));
/*    */ 
/*    */   
/* 32 */   public static final String DIR_RESOURCE_ROOT = (new File(GConfig.getInstance().get("dir.resource.root", String.format(_ROOT_DIR_, new Object[] { "resource" })))).getPath() + File.separator;
/*    */ 
/*    */   
/* 35 */   public static final String DIR_FILTER = GConfig.getInstance().get("dir.filter", DIR_COMMON + "filter" + File.separator);
/*    */ 
/*    */   
/* 38 */   public static final String DIR_NICKNAME = GConfig.getInstance().get("dir.nickname", DIR_COMMON + "nickname" + File.separator);
/*    */ 
/*    */   
/* 41 */   public static final String DIR_LANGUAGE = GConfig.getInstance().get("dir.language", DIR_COMMON + "language" + File.separator);
/*    */ 
/*    */   
/* 44 */   public static final String DIR_VERSION = GConfig.getInstance().get("dir.version", DIR_COMMON + "version" + File.separator);
/*    */ 
/*    */   
/* 47 */   public static final String FILE_CONF_DS = DIR_CONF_SERVER + "conf.ds.xml";
/*    */ 
/*    */   
/* 50 */   public static final String DIR_LOG = GConfig.getInstance().get("log.dir", System.getProperty("user.dir"));
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\GFile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */