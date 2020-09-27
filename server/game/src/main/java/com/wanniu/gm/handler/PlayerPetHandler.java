/*    */ package com.wanniu.gm.handler;
/*    */ 
/*    */ import cn.qeng.common.gm.vo.GmPetVO;
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.ext.BaseDataExt;
/*    */ import com.wanniu.game.petNew.PetCenter;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.PetNewPO;
/*    */ import com.wanniu.game.poes.PlayerPetsNewPO;
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
/*    */ public class PlayerPetHandler
/*    */   extends GMBaseHandler
/*    */ {
/*    */   public GMResponse execute(JSONArray arr) {
/* 33 */     String id = arr.getString(0);
/* 34 */     WNPlayer wnPlayer = PlayerUtil.getOnlinePlayer(id);
/* 35 */     PlayerPetsNewPO petPo = null;
/* 36 */     if (wnPlayer == null) {
/* 37 */       petPo = PetCenter.getInstance().findPet(id);
/*    */     } else {
/* 39 */       petPo = wnPlayer.petNewManager.petsPO;
/*    */     } 
/*    */     
/* 42 */     List<GmPetVO> list = new ArrayList<>();
/* 43 */     for (PetNewPO p : petPo.pets.values()) {
/* 44 */       list.add(new GmPetVO(p.id, p.name, p.level, p.upLevel, p.fightPower, ((BaseDataExt)GameData.BaseDatas.get(Integer.valueOf(p.id))).type, (p.id == petPo.fightPetId) ? "是" : "否", p.skills.size()));
/*    */     }
/* 46 */     Map<String, Object> data = new HashMap<>();
/* 47 */     data.put("total", Integer.valueOf(list.size()));
/* 48 */     data.put("rows", list);
/* 49 */     JSONObject jo = new JSONObject(data);
/*    */     
/* 51 */     return (GMResponse)new GMJsonResponse(jo);
/*    */   }
/*    */   
/*    */   public short getType() {
/* 55 */     return 12325;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\handler\PlayerPetHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */