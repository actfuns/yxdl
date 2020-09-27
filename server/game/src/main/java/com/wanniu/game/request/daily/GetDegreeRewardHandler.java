/*    */ package com.wanniu.game.request.daily;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.game.attendance.PlayerAttendance;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.daily.DailyActivityMgr;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.ext.VitBonusExt;
/*    */ import com.wanniu.game.item.ItemUtil;
/*    */ import com.wanniu.game.item.NormalItem;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import pomelo.area.DailyActivityHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.dailyActivityHandler.getDegreeRewardRequest")
/*    */ public class GetDegreeRewardHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 35 */     return new PomeloResponse() {
/* 36 */         WNPlayer player = (WNPlayer)GetDegreeRewardHandler.this.pak.getPlayer();
/* 37 */         DailyActivityHandler.GetDegreeRewardRequest req = DailyActivityHandler.GetDegreeRewardRequest.parseFrom(GetDegreeRewardHandler.this.pak.getRemaingBytes());
/*    */ 
/*    */         
/*    */         protected void write() throws IOException {
/* 41 */           DailyActivityHandler.GetDegreeRewardResponse.Builder res = DailyActivityHandler.GetDegreeRewardResponse.newBuilder();
/*    */           try {
/* 43 */             if (null == this.player) {
/* 44 */               res.setS2CCode(500);
/* 45 */               res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 46 */               this.body.writeBytes(res.build().toByteArray());
/*    */               
/*    */               return;
/*    */             } 
/* 50 */             DailyActivityMgr mgr = this.player.dailyActivityMgr;
/* 51 */             if (null == mgr) {
/*    */               return;
/*    */             }
/*    */             
/* 55 */             JSONObject ret = mgr.getReward(this.req.getId());
/* 56 */             if (0 == ret.getIntValue("result")) {
/* 57 */               VitBonusExt prop = (VitBonusExt)GameData.VitBonuss.get(Integer.valueOf(this.req.getId()));
/* 58 */               List<NormalItem> list_items = ItemUtil.createItemsByItemCode(prop.rewards);
/* 59 */               this.player.bag.addCodeItemMail(list_items, null, Const.GOODS_CHANGE_TYPE.daily_activity, "Bag_full_common");
/* 60 */               res.setS2CCode(200);
/* 61 */               res.setId(this.req.getId());
/* 62 */               res.setS2CState(PlayerAttendance.GiftState.RECEIVED.getValue());
/* 63 */               mgr.updateRewardState();
/* 64 */               mgr.updateSuperScript();
/* 65 */               this.body.writeBytes(res.build().toByteArray());
/*    */             } else {
/* 67 */               res.setS2CCode(500);
/* 68 */               res.setS2CMsg(ret.getString("des"));
/* 69 */               this.body.writeBytes(res.build().toByteArray());
/*    */               
/*    */               return;
/*    */             } 
/* 73 */           } catch (Exception err) {
/* 74 */             Out.error(new Object[] { err });
/* 75 */             res.setS2CCode(500);
/* 76 */             this.body.writeBytes(res.build().toByteArray());
/*    */           } 
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\daily\GetDegreeRewardHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */