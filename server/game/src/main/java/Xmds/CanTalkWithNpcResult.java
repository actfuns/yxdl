/*     */ package Xmds;
/*     */ 
/*     */ import Ice.Current;
/*     */ import Ice.Object;
/*     */ import Ice.ObjectFactory;
/*     */ import Ice.ObjectImpl;
/*     */ import IceInternal.BasicStream;
/*     */ import java.util.Arrays;
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
/*     */ public class CanTalkWithNpcResult
/*     */   extends ObjectImpl
/*     */ {
/*     */   public CanTalkWithNpcResult() {}
/*     */   
/*     */   public CanTalkWithNpcResult(int templateId, boolean canTalk) {
/*  34 */     this.templateId = templateId;
/*  35 */     this.canTalk = canTalk;
/*     */   }
/*     */   
/*     */   private static class __F implements ObjectFactory {
/*     */     private __F() {}
/*     */     
/*     */     public Object create(String type) {
/*  42 */       assert type.equals(CanTalkWithNpcResult.ice_staticId());
/*  43 */       return (Object)new CanTalkWithNpcResult();
/*     */     }
/*     */ 
/*     */     
/*     */     public void destroy() {}
/*     */   }
/*     */   
/*  50 */   private static ObjectFactory _factory = new __F();
/*     */ 
/*     */ 
/*     */   
/*     */   public static ObjectFactory ice_factory() {
/*  55 */     return _factory;
/*     */   }
/*     */   
/*  58 */   public static final String[] __ids = new String[] { "::Ice::Object", "::Xmds::CanTalkWithNpcResult" };
/*     */   
/*     */   public int templateId;
/*     */   
/*     */   public boolean canTalk;
/*     */   public static final long serialVersionUID = -6558856L;
/*     */   
/*     */   public boolean ice_isA(String s) {
/*  66 */     return (Arrays.binarySearch((Object[])__ids, s) >= 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ice_isA(String s, Current __current) {
/*  71 */     return (Arrays.binarySearch((Object[])__ids, s) >= 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] ice_ids() {
/*  76 */     return __ids;
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] ice_ids(Current __current) {
/*  81 */     return __ids;
/*     */   }
/*     */ 
/*     */   
/*     */   public String ice_id() {
/*  86 */     return __ids[1];
/*     */   }
/*     */ 
/*     */   
/*     */   public String ice_id(Current __current) {
/*  91 */     return __ids[1];
/*     */   }
/*     */ 
/*     */   
/*     */   public static String ice_staticId() {
/*  96 */     return __ids[1];
/*     */   }
/*     */ 
/*     */   
/*     */   protected void __writeImpl(BasicStream __os) {
/* 101 */     __os.startWriteSlice(ice_staticId(), -1, true);
/* 102 */     __os.writeInt(this.templateId);
/* 103 */     __os.writeBool(this.canTalk);
/* 104 */     __os.endWriteSlice();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void __readImpl(BasicStream __is) {
/* 109 */     __is.startReadSlice();
/* 110 */     this.templateId = __is.readInt();
/* 111 */     this.canTalk = __is.readBool();
/* 112 */     __is.endReadSlice();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CanTalkWithNpcResult clone() {
/* 122 */     return (CanTalkWithNpcResult)super.clone();
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\Xmds\CanTalkWithNpcResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */