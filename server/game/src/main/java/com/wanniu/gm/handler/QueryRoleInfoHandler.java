/*    */ package com.wanniu.gm.handler;
/*    */ 
/*    */ import cn.qeng.common.gm.vo.GmPlayerInfoVO;
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.wanniu.core.util.DateUtil;
/*    */ import com.wanniu.game.common.ConstsTR;
/*    */ import com.wanniu.game.daoyou.DaoYouService;
/*    */ import com.wanniu.game.data.CharacterLevelCO;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.ext.CharacterExt;
/*    */ import com.wanniu.game.data.ext.UpLevelExpExt;
/*    */ import com.wanniu.game.guild.GuildUtil;
/*    */ import com.wanniu.game.player.PlayerDao;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.poes.DaoYouPO;
/*    */ import com.wanniu.game.poes.PlayerPO;
/*    */ import com.wanniu.gm.GMErrorResponse;
/*    */ import com.wanniu.gm.GMEvent;
/*    */ import com.wanniu.gm.GMJsonResponse;
/*    */ import com.wanniu.gm.GMResponse;
/*    */ import com.wanniu.redis.GameDao;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GMEvent
/*    */ public class QueryRoleInfoHandler
/*    */   extends GMBaseHandler
/*    */ {
/*    */   public GMResponse execute(JSONArray arr) {
/* 41 */     String roleName = arr.getString(0);
/* 42 */     int type = arr.getIntValue(1);
/* 43 */     if (type == 0) {
/* 44 */       String id = PlayerDao.getIdByName(roleName);
/* 45 */       if (id == null) {
/* 46 */         return (GMResponse)new GMErrorResponse();
/*    */       }
/* 48 */       PlayerPO po = PlayerUtil.getPlayerBaseData(id);
/* 49 */       CharacterExt character = (CharacterExt)GameData.Characters.get(Integer.valueOf(po.pro));
/* 50 */       String vip = "无";
/* 51 */       if (po.vip == 1) {
/* 52 */         vip = "月惠卡";
/* 53 */       } else if (po.vip == 2) {
/* 54 */         vip = "尊享卡";
/*    */       } 
/* 56 */       DaoYouPO daoyou = DaoYouService.getInstance().getDaoYou(po.id);
/* 57 */       GmPlayerInfoVO vo = new GmPlayerInfoVO(po.id, po.uid, po.name, po.level, po.exp + "/" + ((CharacterLevelCO)GameData.CharacterLevels.get(Integer.valueOf(po.level))).experience, po.diamond, po.gold, vip, (po.loginTime != null) ? DateUtil.format(po.loginTime) : "", character.proName, PlayerUtil.isOnline(id) ? "是" : "否", (po.logoutTime != null) ? DateUtil.format(po.logoutTime) : "", (po.isDelete == 1) ? "已删除" : "正常", po.classExp + "/" + ((UpLevelExpExt)GameData.UpLevelExps.get(Integer.valueOf(po.upOrder + 1))).reqClassExp, po.ticket, GuildUtil.getGuildName(po.id), (daoyou == null) ? "" : daoyou.name, po.fightPower);
/*    */ 
/*    */       
/* 60 */       return (GMResponse)new GMJsonResponse(JSON.toJSONString(vo));
/*    */     } 
/* 62 */     List<GmPlayerInfoVO> list = new ArrayList<>();
/* 63 */     Set<String> names = GameDao.hkeys(ConstsTR.NAME_MODULE.value);
/* 64 */     for (String n : names) {
/* 65 */       if (n.contains(roleName)) {
/* 66 */         String id = PlayerDao.getIdByName(n);
/* 67 */         PlayerPO po = PlayerUtil.getPlayerBaseData(id);
/* 68 */         if (po == null) {
/*    */           continue;
/*    */         }
/* 71 */         GmPlayerInfoVO vo = new GmPlayerInfoVO();
/* 72 */         vo.setName(po.name);
/* 73 */         vo.setLevel(po.level);
/* 74 */         vo.setPro(((CharacterExt)GameData.Characters.get(Integer.valueOf(po.pro))).proName);
/* 75 */         list.add(vo);
/*    */       } 
/*    */     } 
/* 78 */     Map<String, Object> data = new HashMap<>();
/* 79 */     data.put("total", Integer.valueOf(list.size()));
/* 80 */     data.put("rows", list);
/* 81 */     JSONObject jo = new JSONObject(data);
/* 82 */     return (GMResponse)new GMJsonResponse(jo);
/*    */   }
/*    */ 
/*    */   
/*    */   public short getType() {
/* 87 */     return 12320;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\handler\QueryRoleInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */