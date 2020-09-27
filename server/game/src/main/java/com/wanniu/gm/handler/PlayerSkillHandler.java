/*    */ package com.wanniu.gm.handler;
/*    */ 
/*    */ import cn.qeng.common.gm.vo.GmPlayerSkillVO;
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.wanniu.game.common.ConstsTR;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.ext.SkillDataExt;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.playerSkill.po.SkillDB;
/*    */ import com.wanniu.game.poes.SkillsPO;
/*    */ import com.wanniu.gm.GMEvent;
/*    */ import com.wanniu.gm.GMJsonResponse;
/*    */ import com.wanniu.gm.GMResponse;
/*    */ import com.wanniu.redis.PlayerPOManager;
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
/*    */ public class PlayerSkillHandler
/*    */   extends GMBaseHandler
/*    */ {
/*    */   public GMResponse execute(JSONArray arr) {
/* 34 */     String id = arr.getString(0);
/* 35 */     WNPlayer wnPlayer = PlayerUtil.getOnlinePlayer(id);
/* 36 */     SkillsPO skillDb = null;
/* 37 */     if (wnPlayer == null) {
/* 38 */       skillDb = (SkillsPO)PlayerPOManager.findPO(ConstsTR.skillTR, id, SkillsPO.class);
/*    */     } else {
/* 40 */       skillDb = wnPlayer.skillKeyManager.player_skills;
/*    */     } 
/*    */     
/* 43 */     List<GmPlayerSkillVO> list = new ArrayList<>();
/* 44 */     for (Map.Entry<Integer, SkillDB> entry : (Iterable<Map.Entry<Integer, SkillDB>>)skillDb.skills.entrySet()) {
/* 45 */       String skillName = ((SkillDataExt)GameData.SkillDatas.get(entry.getKey())).skillName;
/* 46 */       list.add(new GmPlayerSkillVO(skillName, ((SkillDB)entry.getValue()).lv));
/*    */     } 
/* 48 */     Map<String, Object> data = new HashMap<>();
/* 49 */     data.put("total", Integer.valueOf(list.size()));
/* 50 */     data.put("rows", list);
/* 51 */     JSONObject jo = new JSONObject(data);
/*    */     
/* 53 */     return (GMResponse)new GMJsonResponse(jo);
/*    */   }
/*    */   
/*    */   public short getType() {
/* 57 */     return 12324;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\handler\PlayerSkillHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */