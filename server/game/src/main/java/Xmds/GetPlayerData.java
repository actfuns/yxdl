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
/*     */ public class GetPlayerData
/*     */   extends ObjectImpl
/*     */ {
/*     */   public GetPlayerData() {}
/*     */   
/*     */   public GetPlayerData(float x, float y, float direction, int hp, int mp, int pkMode, int pkValue, int pkLevel, SkillDataICE[] skillData, int combatState) {
/*  31 */     this.x = x;
/*  32 */     this.y = y;
/*  33 */     this.direction = direction;
/*  34 */     this.hp = hp;
/*  35 */     this.mp = mp;
/*  36 */     this.pkMode = pkMode;
/*  37 */     this.pkValue = pkValue;
/*  38 */     this.pkLevel = pkLevel;
/*  39 */     this.skillData = skillData;
/*  40 */     this.combatState = combatState;
/*     */   }
/*     */   
/*     */   private static class __F implements ObjectFactory {
/*     */     private __F() {}
/*     */     
/*     */     public Object create(String type) {
/*  47 */       assert type.equals(GetPlayerData.ice_staticId());
/*  48 */       return (Object)new GetPlayerData();
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
/*  63 */   public static final String[] __ids = new String[] { "::Ice::Object", "::Xmds::GetPlayerData" };
/*     */   public float x;
/*     */   public float y;
/*     */   public float direction;
/*     */   public int hp;
/*     */   public int mp;
/*     */   
/*     */   public boolean ice_isA(String s) {
/*  71 */     return (Arrays.binarySearch((Object[])__ids, s) >= 0);
/*     */   }
/*     */   public int pkMode; public int pkValue; public int pkLevel; public SkillDataICE[] skillData; public int combatState; public static final long serialVersionUID = 803543938L;
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
/* 107 */     __os.writeFloat(this.x);
/* 108 */     __os.writeFloat(this.y);
/* 109 */     __os.writeFloat(this.direction);
/* 110 */     __os.writeInt(this.hp);
/* 111 */     __os.writeInt(this.mp);
/* 112 */     __os.writeInt(this.pkMode);
/* 113 */     __os.writeInt(this.pkValue);
/* 114 */     __os.writeInt(this.pkLevel);
/* 115 */     SkillDataSeqHelper.write(__os, this.skillData);
/* 116 */     __os.writeInt(this.combatState);
/* 117 */     __os.endWriteSlice();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void __readImpl(BasicStream __is) {
/* 122 */     __is.startReadSlice();
/* 123 */     this.x = __is.readFloat();
/* 124 */     this.y = __is.readFloat();
/* 125 */     this.direction = __is.readFloat();
/* 126 */     this.hp = __is.readInt();
/* 127 */     this.mp = __is.readInt();
/* 128 */     this.pkMode = __is.readInt();
/* 129 */     this.pkValue = __is.readInt();
/* 130 */     this.pkLevel = __is.readInt();
/* 131 */     this.skillData = SkillDataSeqHelper.read(__is);
/* 132 */     this.combatState = __is.readInt();
/* 133 */     __is.endReadSlice();
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
/*     */ 
/*     */ 
/*     */   
/*     */   public GetPlayerData clone() {
/* 159 */     return (GetPlayerData)super.clone();
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\Xmds\GetPlayerData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */