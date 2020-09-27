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
/*     */ public class FinishPickItem
/*     */   extends ObjectImpl
/*     */ {
/*     */   public FinishPickItem() {
/*  30 */     this.itemIcon = "";
/*     */   }
/*     */ 
/*     */   
/*     */   public FinishPickItem(String itemIcon, int quality, int num) {
/*  35 */     this.itemIcon = itemIcon;
/*  36 */     this.quality = quality;
/*  37 */     this.num = num;
/*     */   }
/*     */   
/*     */   private static class __F implements ObjectFactory {
/*     */     private __F() {}
/*     */     
/*     */     public Object create(String type) {
/*  44 */       assert type.equals(FinishPickItem.ice_staticId());
/*  45 */       return (Object)new FinishPickItem();
/*     */     }
/*     */ 
/*     */     
/*     */     public void destroy() {}
/*     */   }
/*     */   
/*  52 */   private static ObjectFactory _factory = new __F();
/*     */ 
/*     */ 
/*     */   
/*     */   public static ObjectFactory ice_factory() {
/*  57 */     return _factory;
/*     */   }
/*     */   
/*  60 */   public static final String[] __ids = new String[] { "::Ice::Object", "::Xmds::FinishPickItem" };
/*     */   
/*     */   public String itemIcon;
/*     */   public int quality;
/*     */   public int num;
/*     */   public static final long serialVersionUID = -460233274L;
/*     */   
/*     */   public boolean ice_isA(String s) {
/*  68 */     return (Arrays.binarySearch((Object[])__ids, s) >= 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ice_isA(String s, Current __current) {
/*  73 */     return (Arrays.binarySearch((Object[])__ids, s) >= 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] ice_ids() {
/*  78 */     return __ids;
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] ice_ids(Current __current) {
/*  83 */     return __ids;
/*     */   }
/*     */ 
/*     */   
/*     */   public String ice_id() {
/*  88 */     return __ids[1];
/*     */   }
/*     */ 
/*     */   
/*     */   public String ice_id(Current __current) {
/*  93 */     return __ids[1];
/*     */   }
/*     */ 
/*     */   
/*     */   public static String ice_staticId() {
/*  98 */     return __ids[1];
/*     */   }
/*     */ 
/*     */   
/*     */   protected void __writeImpl(BasicStream __os) {
/* 103 */     __os.startWriteSlice(ice_staticId(), -1, true);
/* 104 */     __os.writeString(this.itemIcon);
/* 105 */     __os.writeInt(this.quality);
/* 106 */     __os.writeInt(this.num);
/* 107 */     __os.endWriteSlice();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void __readImpl(BasicStream __is) {
/* 112 */     __is.startReadSlice();
/* 113 */     this.itemIcon = __is.readString();
/* 114 */     this.quality = __is.readInt();
/* 115 */     this.num = __is.readInt();
/* 116 */     __is.endReadSlice();
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
/*     */   public FinishPickItem clone() {
/* 128 */     return (FinishPickItem)super.clone();
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\Xmds\FinishPickItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */