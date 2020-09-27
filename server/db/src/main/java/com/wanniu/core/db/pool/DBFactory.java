/*     */ package com.wanniu.core.db.pool;
/*     */ 
/*     */ import com.wanniu.core.GGlobal;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.xml.XW3CParser;
/*     */ import java.sql.SQLException;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import javax.naming.NameAlreadyBoundException;
/*     */ import javax.naming.NameNotFoundException;
/*     */ import javax.sql.DataSource;
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
/*     */ public final class DBFactory
/*     */ {
/*     */   private static boolean inited;
/*  31 */   static Map<String, DBSource> dsPools = null;
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
/*     */   public static DBSource lookup(String dataSource) {
/*  43 */     DBSource ds = null;
/*  44 */     if (dsPools != null) {
/*  45 */       ds = dsPools.get(dataSource);
/*     */     }
/*  47 */     return ds;
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DBSource start(String name, DBAttribute param) throws NameAlreadyBoundException, SQLException {
/*  70 */     if (lookup(name) != null) {
/*  71 */       throw new NameAlreadyBoundException(name);
/*     */     }
/*  73 */     DBSource source = new DBSource(param);
/*  74 */     if (dsPools == null) {
/*  75 */       dsPools = new ConcurrentHashMap<>();
/*     */     }
/*  77 */     dsPools.put(name, source);
/*  78 */     return source;
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DBSource restart(String name, DBAttribute param) throws NameAlreadyBoundException, ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
/*     */     try {
/* 102 */       shutdown(name);
/* 103 */     } catch (Exception exception) {}
/*     */     
/* 105 */     return start(name, param);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void shutdown(String name) throws NameNotFoundException {
/* 115 */     if (dsPools == null) {
/*     */       return;
/*     */     }
/* 118 */     DataSource dataSource = lookup(name);
/*     */     
/* 120 */     if (dataSource != null && dataSource instanceof DBSource) {
/* 121 */       DBSource datasource = (DBSource)dataSource;
/* 122 */       datasource.shutdown();
/* 123 */       datasource = null;
/*     */     } 
/*     */     
/* 126 */     dsPools.remove(name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static synchronized void init() {
/* 135 */     if (!inited) {
/*     */       
/* 137 */       dsPools = new ConcurrentHashMap<>(2, 0.75F);
/* 138 */       List<DBAttribute> drivers = null;
/*     */       try {
/* 140 */         drivers = XW3CParser.parse(GGlobal.FILE_CONF_DS, DBAttribute.class);
/* 141 */       } catch (Exception e) {
/* 142 */         Out.error(new Object[] { "读取连接池配置文件错误 -> " + GGlobal.FILE_CONF_DS });
/* 143 */         e.printStackTrace();
/* 144 */         System.exit(-1);
/*     */       } 
/*     */       
/* 147 */       if (drivers.size() == 0) {
/* 148 */         Out.warn(new Object[] { "连接池配置文件中未配置 -> " + GGlobal.FILE_CONF_DS });
/*     */         
/*     */         return;
/*     */       } 
/* 152 */       StringBuilder dsInfo = new StringBuilder();
/* 153 */       DBAttribute cp = null;
/*     */       
/* 155 */       for (int i = 0; i < drivers.size(); i++) {
/*     */         try {
/* 157 */           cp = drivers.get(i);
/* 158 */           start(cp.getDsName(), cp);
/* 159 */           dsInfo.append(cp.getDsName());
/*     */           
/* 161 */           if (i < drivers.size() - 1) {
/* 162 */             dsInfo.append(" & ");
/*     */           }
/* 164 */         } catch (Exception e) {
/* 165 */           e.printStackTrace();
/* 166 */           Out.error(new Object[] { "绑定连接池 [" + ((DBAttribute)drivers.get(i)).getDsName() + "] 错误！" });
/* 167 */           System.exit(-1);
/*     */         } 
/*     */       } 
/* 170 */       inited = true;
/* 171 */       Out.info(new Object[] { String.format("\n\n初始化成功连接池数量：%d\n数据库连接池【  %s 】\n", new Object[] { Integer.valueOf(drivers.size()), dsInfo.toString() }) });
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-db\xmds-db.jar!\com\wanniu\core\db\pool\DBFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */