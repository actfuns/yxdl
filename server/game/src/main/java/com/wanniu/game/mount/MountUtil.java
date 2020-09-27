/*    */ package com.wanniu.game.mount;
/*    */ 
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.ext.RideListExt;
/*    */ import com.wanniu.game.data.ext.SkinListExt;
/*    */ import com.wanniu.game.player.AttributeUtil;
/*    */ import com.wanniu.game.poes.MountPO;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import pomelo.Common;
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
/*    */ public class MountUtil
/*    */ {
/*    */   public static final List<Common.Avatar> getCurMountAvatarInfo(MountPO mountData) {
/* 27 */     ArrayList<Common.Avatar> avatarData = new ArrayList<>();
/* 28 */     if (mountData != null && mountData.rideFlag == Const.MOUNT_RIDING_STATE.on.getValue()) {
/* 29 */       int avatarPoint = 16;
/*    */ 
/*    */       
/* 32 */       if (mountData.usingSkinId > 0) {
/* 33 */         SkinListExt skinProp = MountConfig.getInstance().getMountSkinPropByID(mountData.usingSkinId);
/* 34 */         Common.Avatar.Builder builder = Common.Avatar.newBuilder();
/* 35 */         builder.setTag(avatarPoint);
/* 36 */         builder.setFileName(skinProp.modelFile);
/* 37 */         builder.setEffectType(0);
/* 38 */         avatarData.add(builder.build());
/*    */       } 
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 50 */     return avatarData;
/*    */   }
/*    */   
/*    */   public static final Map<Const.PlayerBtlData, Integer> getMountBaseProp(int rideLevel, int starLv) {
/* 54 */     Map<Const.PlayerBtlData, Integer> baseMap = new HashMap<>();
/* 55 */     RideListExt prop = (RideListExt)GameData.RideLists.get(Integer.valueOf(rideLevel));
/* 56 */     if (prop == null) {
/* 57 */       return baseMap;
/*    */     }
/* 59 */     AttributeUtil.addData2AllData(prop.levelAttrs, baseMap);
/* 60 */     Map<Const.PlayerBtlData, Integer> map = prop.starAttrs;
/* 61 */     Map<Const.PlayerBtlData, Integer> map_star = new HashMap<>();
/* 62 */     for (Const.PlayerBtlData pbd : map.keySet()) {
/* 63 */       int value = ((Integer)map.get(pbd)).intValue();
/* 64 */       value *= starLv;
/* 65 */       value += ((Integer)prop.totalPreStarAttrs.get(pbd)).intValue();
/* 66 */       map_star.put(pbd, Integer.valueOf(value));
/*    */     } 
/* 68 */     AttributeUtil.addData2AllData(map_star, baseMap);
/* 69 */     return baseMap;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\mount\MountUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */