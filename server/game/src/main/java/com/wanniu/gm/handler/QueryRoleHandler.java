/*    */ package com.wanniu.gm.handler;
/*    */ 
/*    */ import cn.qeng.common.gm.vo.GmManagerVO;
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.wanniu.core.util.DateUtil;
/*    */ import com.wanniu.game.player.PlayerDao;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.poes.PlayerPO;
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
/*    */ public class QueryRoleHandler
/*    */   extends GMBaseHandler
/*    */ {
/*    */   public GMResponse execute(JSONArray arr) {
/* 32 */     String roleName = arr.getString(0);
/* 33 */     String id = PlayerDao.getIdByName(roleName);
/* 34 */     if (id == null) {
/* 35 */       return (GMResponse)new GMErrorResponse();
/*    */     }
/* 37 */     List<GmManagerVO> list = new ArrayList<>();
/*    */     
/* 39 */     PlayerPO po = PlayerUtil.getPlayerBaseData(id);
/* 40 */     GmManagerVO vo = new GmManagerVO(po.id, po.name, "", "", po.freezeReason, po.forbidTalkReason);
/* 41 */     if (po.freezeTime != null) {
/* 42 */       vo.setFreezeTime(DateUtil.format(po.freezeTime));
/*    */     }
/* 44 */     if (po.forbidTalkTime != null) {
/* 45 */       vo.setForbidTime(DateUtil.format(po.forbidTalkTime));
/*    */     }
/* 47 */     list.add(vo);
/*    */     
/* 49 */     Map<String, Object> data = new HashMap<>();
/* 50 */     data.put("total", Integer.valueOf(1));
/* 51 */     data.put("rows", list);
/*    */     
/* 53 */     JSONObject jo = new JSONObject(data);
/* 54 */     return (GMResponse)new GMJsonResponse(jo);
/*    */   }
/*    */   
/*    */   public short getType() {
/* 58 */     return 12289;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\handler\QueryRoleHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */