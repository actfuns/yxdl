/*    */ package com.wanniu.csharp.ice;
/*    */ 
/*    */ import Ice.Communicator;
/*    */ import Ice.ObjectPrx;
/*    */ import Ice.Util;
/*    */ import Xmds.XmdsManagerPrx;
/*    */ import Xmds.XmdsManagerPrxHelper;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.csharp.CSharpNode;
/*    */ 
/*    */ public class XmdsManager
/*    */ {
/*    */   private CSharpNode node;
/*    */   
/*    */   public XmdsManager(CSharpNode node) {
/* 16 */     this.node = node;
/*    */   }
/*    */   private XmdsManagerPrx xmdsManager; private Communicator ic;
/*    */   public XmdsManager bind() {
/*    */     try {
/* 21 */       this.ic = Util.initialize(new String[0]);
/* 22 */       ObjectPrx proxy = this.ic.stringToProxy(String.format("XmdsManager:default -h %s -p %d -t 3000", new Object[] { this.node.host, Integer.valueOf(this.node.icePort) }));
/* 23 */       this.xmdsManager = XmdsManagerPrxHelper.checkedCast(proxy);
/* 24 */     } catch (Exception e) {
/* 25 */       Out.error(new Object[] { "XmdsManager bind() exception.", e });
/*    */     } 
/* 27 */     return this;
/*    */   }
/*    */   
/*    */   public XmdsManagerPrx getManager() {
/* 31 */     return this.xmdsManager;
/*    */   }
/*    */   
/*    */   public void destory() {
/*    */     try {
/* 36 */       if (this.ic != null) {
/* 37 */         this.ic.destroy();
/*    */       }
/* 39 */     } catch (Exception e) {
/* 40 */       Out.error(new Object[] { "XmdsManager destory() exception.", e });
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\csharp\ice\XmdsManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */