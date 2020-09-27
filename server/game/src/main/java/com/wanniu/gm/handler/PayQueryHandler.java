/*    */ package com.wanniu.gm.handler;
/*    */ 
/*    */ import cn.qeng.common.gm.vo.GmPayVO;
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.wanniu.core.util.DateUtil;
/*    */ import com.wanniu.game.player.PlayerDao;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.poes.PlayerPO;
/*    */ import com.wanniu.game.prepaid.PrepaidCenter;
/*    */ import com.wanniu.game.prepaid.PrepaidManager;
/*    */ import com.wanniu.game.prepaid.po.PrepaidRecord;
/*    */ import com.wanniu.gm.GMErrorResponse;
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
/*    */ public class PayQueryHandler
/*    */   extends GMBaseHandler
/*    */ {
/*    */   public GMResponse execute(JSONArray arr) {
/* 35 */     String roleName = arr.getString(0);
/* 36 */     String id = PlayerDao.getIdByName(roleName);
/* 37 */     if (id == null) {
/* 38 */       return (GMResponse)new GMErrorResponse();
/*    */     }
/* 40 */     PlayerPO playerPo = PlayerUtil.getPlayerBaseData(id);
/* 41 */     PrepaidManager manager = PrepaidCenter.getInstance().findPrepaid(id);
/* 42 */     List<GmPayVO> list = new ArrayList<>();
/* 43 */     for (PrepaidRecord p : manager.po.chargeRecord) {
/* 44 */       list.add(new GmPayVO(playerPo.uid, playerPo.name, DateUtil.format(p.date), p.money, p.isCard ? "是" : "否"));
/*    */     }
/*    */     
/* 47 */     Map<String, Object> data = new HashMap<>();
/* 48 */     data.put("total", Integer.valueOf(1));
/* 49 */     data.put("rows", list);
/* 50 */     JSONObject jo = new JSONObject(data);
/*    */     
/* 52 */     return (GMResponse)new GMJsonResponse(jo);
/*    */   }
/*    */   
/*    */   public short getType() {
/* 56 */     return 8208;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\handler\PayQueryHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */