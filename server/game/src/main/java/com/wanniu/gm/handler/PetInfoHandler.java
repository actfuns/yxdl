/*    */ package com.wanniu.gm.handler;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.wanniu.core.common.StringInt;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.ext.PetSkillExt;
/*    */ import com.wanniu.game.petNew.PetNew;
/*    */ import com.wanniu.game.petNew.PetSkill;
/*    */ import com.wanniu.game.player.PlayerDao;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.player.po.AllBlobPO;
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
/*    */ @GMEvent
/*    */ public class PetInfoHandler
/*    */   extends GMBaseHandler
/*    */ {
/*    */   public GMResponse execute(JSONArray arr) {
/* 34 */     String id = arr.getString(0);
/* 35 */     int petId = arr.getIntValue(1);
/* 36 */     WNPlayer wnPlayer = PlayerUtil.getOnlinePlayer(id);
/* 37 */     if (wnPlayer == null) {
/* 38 */       AllBlobPO allBlobData = PlayerDao.getAllBlobData(id);
/* 39 */       wnPlayer = new WNPlayer(allBlobData);
/*    */     } 
/* 41 */     PetNew pw = (PetNew)wnPlayer.petNewManager.playerPets.get(Integer.valueOf(petId));
/*    */     
/* 43 */     List<StringInt> skills = new ArrayList<>();
/* 44 */     for (PetSkill s : pw.po.skills.values()) {
/* 45 */       skills.add(new StringInt(s.level, ((PetSkillExt)GameData.PetSkills.get(Integer.valueOf(s.id))).skillName));
/*    */     }
/*    */ 
/*    */     
/* 49 */     List<StringInt> attr = new ArrayList<>();
/* 50 */     for (Map.Entry<Const.PlayerBtlData, Integer> entry : (Iterable<Map.Entry<Const.PlayerBtlData, Integer>>)pw.attr_final_pet.entrySet()) {
/* 51 */       attr.add(new StringInt(((Integer)entry.getValue()).intValue(), ((Const.PlayerBtlData)entry.getKey()).chName));
/*    */     }
/*    */ 
/*    */     
/* 55 */     List<StringInt> master = new ArrayList<>();
/* 56 */     for (Map.Entry<Const.PlayerBtlData, Integer> entry : (Iterable<Map.Entry<Const.PlayerBtlData, Integer>>)pw.attr_master.entrySet()) {
/* 57 */       master.add(new StringInt(((Integer)entry.getValue()).intValue(), ((Const.PlayerBtlData)entry.getKey()).chName));
/*    */     }
/*    */     
/* 60 */     Map<String, Object> all = new HashMap<>();
/*    */     
/* 62 */     Map<String, Object> data = new HashMap<>();
/* 63 */     data.put("total", Integer.valueOf(skills.size()));
/* 64 */     data.put("rows", skills);
/* 65 */     all.put("skills", data);
/*    */     
/* 67 */     data = new HashMap<>();
/* 68 */     data.put("total", Integer.valueOf(attr.size()));
/* 69 */     data.put("rows", attr);
/* 70 */     all.put("attr", data);
/*    */     
/* 72 */     data = new HashMap<>();
/* 73 */     data.put("total", Integer.valueOf(master.size()));
/* 74 */     data.put("rows", master);
/* 75 */     all.put("master", data);
/*    */     
/* 77 */     JSONObject jo = new JSONObject(all);
/*    */     
/* 79 */     return (GMResponse)new GMJsonResponse(jo);
/*    */   }
/*    */   
/*    */   public short getType() {
/* 83 */     return 12326;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\handler\PetInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */