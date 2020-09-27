/*    */ package com.wanniu.db;
/*    */ 
/*    */ import com.wanniu.core.GGlobal;
/*    */ import com.wanniu.core.GSystem;
/*    */ import com.wanniu.core.db.DBType;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.db.connet.DBDispatcher;
/*    */ import com.wanniu.db.handler.QueryHandler;
/*    */ import com.wanniu.db.handler.RegisterHandler;
/*    */ import io.netty.channel.Channel;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DBServer
/*    */ {
/* 24 */   public static final DBDispatcher Dispatcher = new DBDispatcher();
/*    */   
/* 26 */   public static final Map<Integer, Channel> Channels = new ConcurrentHashMap<>();
/*    */   
/*    */   public static void onProcessExit() {
/* 29 */     while (Dispatcher.getQueueSize() > 0) {
/* 30 */       Out.info(new Object[] { String.format("等待数据保存到数据库，还有【%d】条记录！", new Object[] { Integer.valueOf(Dispatcher.getQueueSize()) }) });
/* 31 */       GSystem.waitMills(500);
/*    */     } 
/*    */   }
/*    */   
/* 35 */   private static final QueryHandler Query = new QueryHandler();
/*    */   
/*    */   public static void handlePacket(Packet pak) {
/* 38 */     short type = pak.getPacketType();
/* 39 */     if (type == DBType.QUERY) {
/* 40 */       Query.execute(pak); return;
/*    */     } 
/* 42 */     if (type == DBType.PING) {
/* 43 */       Out.debug(new Object[] { pak.getAttr(GGlobal._KEY_LOGICSERVERID), " ping..." }); return;
/*    */     } 
/* 45 */     if (type == DBType.JOIN) {
/* 46 */       RegisterHandler registerHandler = new RegisterHandler();
/* 47 */       registerHandler.bindSession(pak.getSession());
/* 48 */       registerHandler.execute(pak);
/*    */       return;
/*    */     } 
/* 51 */     Dispatcher.add(pak);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void onClose(Channel channel) {
/* 56 */     Integer logicServerId = (Integer)channel.attr(GGlobal._KEY_LOGICSERVERID).get();
/* 57 */     if (logicServerId != null) {
/* 58 */       Channels.remove(logicServerId);
/* 59 */       Out.info(new Object[] { logicServerId, " close!!!" });
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-db\xmds-db.jar!\com\wanniu\db\DBServer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */