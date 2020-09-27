/*    */ package com.wanniu.gm.handler;
/*    */ 
/*    */ import cn.qeng.common.gm.vo.GmDaoYouVO;
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.wanniu.game.daoyou.DaoYouCenter;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.ext.CharacterExt;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.poes.DaoYouMemberPO;
/*    */ import com.wanniu.game.poes.DaoYouPO;
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
/*    */ @GMEvent
/*    */ public class DaoyouQueryHandler
/*    */   extends GMBaseHandler
/*    */ {
/*    */   public GMResponse execute(JSONArray arr) {
/* 34 */     String daoyouName = arr.getString(0);
/* 35 */     String daoyouId = DaoYouCenter.getInstance().getDaoYouId(daoyouName);
/* 36 */     if (daoyouId == null) {
/* 37 */       return (GMResponse)new GMErrorResponse();
/*    */     }
/* 39 */     DaoYouPO daoyouPo = DaoYouCenter.getInstance().getDaoYou(daoyouId);
/* 40 */     List<GmDaoYouVO> list = new ArrayList<>();
/* 41 */     List<String> members = DaoYouCenter.getInstance().getAllDaoYouMember(daoyouId);
/* 42 */     for (String pid : members) {
/* 43 */       PlayerPO playerPo = PlayerUtil.getPlayerBaseData(pid);
/* 44 */       if (playerPo == null) {
/*    */         continue;
/*    */       }
/* 47 */       DaoYouMemberPO memberPo = DaoYouCenter.getInstance().getDaoYouMember(pid);
/* 48 */       list.add(new GmDaoYouVO(playerPo.name, playerPo.level, playerPo.fightPower, ((CharacterExt)GameData.Characters.get(Integer.valueOf(playerPo.pro))).proName, daoyouPo.adminPlayerId.equals(pid) ? "是" : "否", String.valueOf(memberPo.todayReciveRebate), String.valueOf(memberPo.totalReciveRebate)));
/*    */     } 
/* 50 */     Map<String, Object> data = new HashMap<>();
/* 51 */     data.put("total", Integer.valueOf(list.size()));
/* 52 */     data.put("rows", list);
/* 53 */     data.put("power", Integer.valueOf(daoyouPo.fightPower));
/* 54 */     JSONObject jo = new JSONObject(data);
/* 55 */     return (GMResponse)new GMJsonResponse(jo);
/*    */   }
/*    */   
/*    */   public short getType() {
/* 59 */     return 16400;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\handler\DaoyouQueryHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */