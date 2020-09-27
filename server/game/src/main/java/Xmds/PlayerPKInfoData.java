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
/*     */ public class PlayerPKInfoData
/*     */   extends ObjectImpl
/*     */ {
/*     */   public PlayerPKInfoData() {}
/*     */   
/*     */   public PlayerPKInfoData(int pkMode, int pkValue, int pkLevel) {
/*  34 */     this.pkMode = pkMode;
/*  35 */     this.pkValue = pkValue;
/*  36 */     this.pkLevel = pkLevel;
/*     */   }
/*     */   
/*     */   private static class __F implements ObjectFactory {
/*     */     private __F() {}
/*     */     
/*     */     public Object create(String type) {
/*  43 */       assert type.equals(PlayerPKInfoData.ice_staticId());
/*  44 */       return (Object)new PlayerPKInfoData();
/*     */     }
/*     */ 
/*     */     
/*     */     public void destroy() {}
/*     */   }
/*     */   
/*  51 */   private static ObjectFactory _factory = new __F();
/*     */ 
/*     */ 
/*     */   
/*     */   public static ObjectFactory ice_factory() {
/*  56 */     return _factory;
/*     */   }
/*     */   
/*  59 */   public static final String[] __ids = new String[] { "::Ice::Object", "::Xmds::PlayerPKInfoData" };
/*     */   
/*     */   public int pkMode;
/*     */   public int pkValue;
/*     */   public int pkLevel;
/*     */   public static final long serialVersionUID = 1679009383L;
/*     */   
/*     */   public boolean ice_isA(String s) {
/*  67 */     return (Arrays.binarySearch((Object[])__ids, s) >= 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ice_isA(String s, Current __current) {
/*  72 */     return (Arrays.binarySearch((Object[])__ids, s) >= 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] ice_ids() {
/*  77 */     return __ids;
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] ice_ids(Current __current) {
/*  82 */     return __ids;
/*     */   }
/*     */ 
/*     */   
/*     */   public String ice_id() {
/*  87 */     return __ids[1];
/*     */   }
/*     */ 
/*     */   
/*     */   public String ice_id(Current __current) {
/*  92 */     return __ids[1];
/*     */   }
/*     */ 
/*     */   
/*     */   public static String ice_staticId() {
/*  97 */     return __ids[1];
/*     */   }
/*     */ 
/*     */   
/*     */   protected void __writeImpl(BasicStream __os) {
/* 102 */     __os.startWriteSlice(ice_staticId(), -1, true);
/* 103 */     __os.writeInt(this.pkMode);
/* 104 */     __os.writeInt(this.pkValue);
/* 105 */     __os.writeInt(this.pkLevel);
/* 106 */     __os.endWriteSlice();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void __readImpl(BasicStream __is) {
/* 111 */     __is.startReadSlice();
/* 112 */     this.pkMode = __is.readInt();
/* 113 */     this.pkValue = __is.readInt();
/* 114 */     this.pkLevel = __is.readInt();
/* 115 */     __is.endReadSlice();
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
/*     */   public PlayerPKInfoData clone() {
/* 127 */     return (PlayerPKInfoData)super.clone();
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\Xmds\PlayerPKInfoData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */