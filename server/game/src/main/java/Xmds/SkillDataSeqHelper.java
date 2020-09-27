/*    */ package Xmds;
/*    */ 
/*    */ import Ice.Object;
/*    */ import IceInternal.BasicStream;
/*    */ import IceInternal.Patcher;
/*    */ import IceInternal.SequencePatcher;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class SkillDataSeqHelper
/*    */ {
/*    */   public static void write(BasicStream __os, SkillDataICE[] __v) {
/* 28 */     if (__v == null) {
/*    */       
/* 30 */       __os.writeSize(0);
/*    */     }
/*    */     else {
/*    */       
/* 34 */       __os.writeSize(__v.length);
/* 35 */       for (int __i0 = 0; __i0 < __v.length; __i0++)
/*    */       {
/* 37 */         __os.writeObject((Object)__v[__i0]);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static SkillDataICE[] read(BasicStream __is) {
/* 46 */     int __len0 = __is.readAndCheckSeqSize(1);
/* 47 */     String __type0 = SkillDataICE.ice_staticId();
/* 48 */     SkillDataICE[] __v = new SkillDataICE[__len0];
/* 49 */     for (int __i0 = 0; __i0 < __len0; __i0++)
/*    */     {
/* 51 */       __is.readObject((Patcher)new SequencePatcher((Object[])__v, SkillDataICE.class, __type0, __i0));
/*    */     }
/* 53 */     return __v;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\Xmds\SkillDataSeqHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */