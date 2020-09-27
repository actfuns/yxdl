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
/*     */ public class RefreshPlayerPropertyChange
/*     */   extends ObjectImpl
/*     */ {
/*     */   public RefreshPlayerPropertyChange() {
/*  30 */     this.key = "";
/*     */   }
/*     */ 
/*     */   
/*     */   public RefreshPlayerPropertyChange(String key, int changeType, int valueType, int value, int duration, long timestamp) {
/*  35 */     this.key = key;
/*  36 */     this.changeType = changeType;
/*  37 */     this.valueType = valueType;
/*  38 */     this.value = value;
/*  39 */     this.duration = duration;
/*  40 */     this.timestamp = timestamp;
/*     */   }
/*     */   
/*     */   private static class __F implements ObjectFactory {
/*     */     private __F() {}
/*     */     
/*     */     public Object create(String type) {
/*  47 */       assert type.equals(RefreshPlayerPropertyChange.ice_staticId());
/*  48 */       return (Object)new RefreshPlayerPropertyChange();
/*     */     }
/*     */ 
/*     */     
/*     */     public void destroy() {}
/*     */   }
/*     */   
/*  55 */   private static ObjectFactory _factory = new __F();
/*     */ 
/*     */ 
/*     */   
/*     */   public static ObjectFactory ice_factory() {
/*  60 */     return _factory;
/*     */   }
/*     */   
/*  63 */   public static final String[] __ids = new String[] { "::Ice::Object", "::Xmds::RefreshPlayerPropertyChange" };
/*     */   
/*     */   public String key;
/*     */   
/*     */   public int changeType;
/*     */   public int valueType;
/*     */   
/*     */   public boolean ice_isA(String s) {
/*  71 */     return (Arrays.binarySearch((Object[])__ids, s) >= 0);
/*     */   }
/*     */   public int value; public int duration; public long timestamp; public static final long serialVersionUID = 706043069L;
/*     */   
/*     */   public boolean ice_isA(String s, Current __current) {
/*  76 */     return (Arrays.binarySearch((Object[])__ids, s) >= 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] ice_ids() {
/*  81 */     return __ids;
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] ice_ids(Current __current) {
/*  86 */     return __ids;
/*     */   }
/*     */ 
/*     */   
/*     */   public String ice_id() {
/*  91 */     return __ids[1];
/*     */   }
/*     */ 
/*     */   
/*     */   public String ice_id(Current __current) {
/*  96 */     return __ids[1];
/*     */   }
/*     */ 
/*     */   
/*     */   public static String ice_staticId() {
/* 101 */     return __ids[1];
/*     */   }
/*     */ 
/*     */   
/*     */   protected void __writeImpl(BasicStream __os) {
/* 106 */     __os.startWriteSlice(ice_staticId(), -1, true);
/* 107 */     __os.writeString(this.key);
/* 108 */     __os.writeInt(this.changeType);
/* 109 */     __os.writeInt(this.valueType);
/* 110 */     __os.writeInt(this.value);
/* 111 */     __os.writeInt(this.duration);
/* 112 */     __os.writeLong(this.timestamp);
/* 113 */     __os.endWriteSlice();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void __readImpl(BasicStream __is) {
/* 118 */     __is.startReadSlice();
/* 119 */     this.key = __is.readString();
/* 120 */     this.changeType = __is.readInt();
/* 121 */     this.valueType = __is.readInt();
/* 122 */     this.value = __is.readInt();
/* 123 */     this.duration = __is.readInt();
/* 124 */     this.timestamp = __is.readLong();
/* 125 */     __is.endReadSlice();
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
/*     */   public RefreshPlayerPropertyChange clone() {
/* 143 */     return (RefreshPlayerPropertyChange)super.clone();
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\Xmds\RefreshPlayerPropertyChange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */