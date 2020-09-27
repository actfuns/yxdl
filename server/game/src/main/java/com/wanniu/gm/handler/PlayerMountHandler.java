/*    */ package com.wanniu.gm.handler;
/*    */ 
/*    */ import cn.qeng.common.gm.vo.GmMountVO;
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.ext.SkinListExt;
/*    */ import com.wanniu.game.player.PlayerDao;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.player.po.AllBlobPO;
/*    */ import com.wanniu.game.poes.MountPO;
/*    */ import com.wanniu.gm.GMEvent;
/*    */ import com.wanniu.gm.GMJsonResponse;
/*    */ import com.wanniu.gm.GMResponse;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GMEvent
/*    */ public class PlayerMountHandler
/*    */   extends GMBaseHandler
/*    */ {
/*    */   public GMResponse execute(JSONArray arr) {
/* 35 */     String id = arr.getString(0);
/* 36 */     WNPlayer wnPlayer = PlayerUtil.getOnlinePlayer(id);
/* 37 */     if (wnPlayer == null) {
/* 38 */       AllBlobPO allBlobData = PlayerDao.getAllBlobData(id);
/* 39 */       wnPlayer = new WNPlayer(allBlobData);
/*    */     } 
/* 41 */     List<GmMountVO> list = new ArrayList<>();
/* 42 */     MountPO mount = wnPlayer.mountManager.mount;
/* 43 */     StringBuilder attr = new StringBuilder();
/* 44 */     for (Map.Entry<Const.PlayerBtlData, Integer> entry : (Iterable<Map.Entry<Const.PlayerBtlData, Integer>>)wnPlayer.mountManager.data_mount_final.entrySet()) {
/* 45 */       attr.append(((Const.PlayerBtlData)entry.getKey()).chName + "+" + entry.getValue() + "<br />");
/*    */     }
/* 47 */     if (mount != null) {
/* 48 */       list.add(new GmMountVO(((SkinListExt)GameData.SkinLists.get(Integer.valueOf(mount.usingSkinId))).skinName, String.valueOf(mount.rideLevel), mount.starLv, attr.toString()));
/*    */     }
/* 50 */     Map<String, Object> data = new HashMap<>();
/* 51 */     data.put("total", Integer.valueOf(1));
/* 52 */     data.put("rows", list);
/* 53 */     JSONObject jo = new JSONObject(data);
/*    */     
/* 55 */     return (GMResponse)new GMJsonResponse(jo);
/*    */   }
/*    */   
/*    */   public short getType() {
/* 59 */     return 12327;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\handler\PlayerMountHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */