/*    */ package com.wanniu.csharp.ice;
/*    */ 
/*    */ import Ice.Communicator;
/*    */ import Ice.Current;
/*    */ import Ice.Object;
/*    */ import Ice.ObjectAdapter;
/*    */ import Ice.ObjectPrx;
/*    */ import Ice.Util;
/*    */
/*    */
/*    */
/*    */ import com.wanniu.core.GGame;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.csharp.CSharpNode;
/*    */ 
/*    */ public class ZoneManager
/*    */ {
/*    */   private CSharpNode node;
/*    */   
/*    */   public ZoneManager(CSharpNode node) {
/* 21 */     this.node = node;
/*    */   }
/*    */   private ZoneManagerPrx zoneManager; private Communicator ic;
/*    */   public ZoneManager bind() {
/*    */     try {
/* 26 */       this.ic = Util.initialize(new String[0]);
/* 27 */       ObjectPrx proxy = this.ic.stringToProxy(String.format("zoneManager:default -h %s -p %d -t 3000", new Object[] { this.node.host, Integer.valueOf(this.node.icePort) })).ice_twoway().ice_secure(false);
/* 28 */       this.zoneManager = ZoneManagerPrxHelper.checkedCast(proxy);
/* 29 */       if (this.zoneManager == null) {
/* 30 */         throw new Error("Invalid proxy");
/*    */       }
/* 32 */       ObjectAdapter adapter = this.ic.createObjectAdapter("");
/* 33 */       ObjectPrx prx = adapter.add((Object)new _ZoneManagerCallbackDisp()
/*    */           {
/*    */             private static final long serialVersionUID = 0L;
/*    */             
/*    */             public void eventNotify(String eventType, String msg, Current __current) {
/*    */               try {
/* 39 */                 GGame.getInstance().battleServerEvent(eventType, msg);
/* 40 */               } catch (Exception e) {
/* 41 */                 Out.error(new Object[] { e });
/*    */               } 
/*    */             }
/* 44 */           }Util.stringToIdentity(this.node.getNodeId()));
/* 45 */       proxy.ice_getCachedConnection().setAdapter(adapter);
/* 46 */       this.zoneManager.setCallback(prx.ice_getIdentity());
/* 47 */     } catch (Exception e) {
/* 48 */       Out.error(new Object[] { "ZoneManager bind() exception.", e });
/*    */     } 
/* 50 */     return this;
/*    */   }
/*    */   
/*    */   public ZoneManagerPrx getManager() {
/* 54 */     return this.zoneManager;
/*    */   }
/*    */   
/*    */   public void destory() {
/*    */     try {
/* 59 */       if (this.ic != null) {
/* 60 */         this.ic.destroy();
/*    */       }
/* 62 */     } catch (Exception e) {
/* 63 */       Out.error(new Object[] { "ZoneManager destory() exception.", e });
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\csharp\ice\ZoneManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */