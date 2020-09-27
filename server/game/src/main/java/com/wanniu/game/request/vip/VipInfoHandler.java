/*    */ package com.wanniu.game.request.vip;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.core.util.DateUtil;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.VipHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.vipHandler.vipInfoRequest")
/*    */ public class VipInfoHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 21 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException
/*    */         {
/* 25 */           WNPlayer player = (WNPlayer)VipInfoHandler.this.pak.getPlayer();
/* 26 */           VipHandler.VipResponse.Builder res = VipHandler.VipResponse.newBuilder();
/* 27 */           res.setS2CCode(200);
/* 28 */           VipHandler.VipGiftInfo.Builder info_month = VipHandler.VipGiftInfo.newBuilder();
/* 29 */           info_month.setType(Const.VipType.month.value);
/* 30 */           boolean flag = false;
/* 31 */           if (player.vipManager.po.lastMonthRewardDate != null && 
/* 32 */             DateUtil.isToday(player.vipManager.po.lastMonthRewardDate)) {
/* 33 */             flag = true;
/*    */           }
/* 35 */           info_month.setFlag(flag ? 1 : 0);
/* 36 */           res.addDatas(info_month);
/*    */           
/* 38 */           VipHandler.VipGiftInfo.Builder info_forever = VipHandler.VipGiftInfo.newBuilder();
/* 39 */           info_forever.setType(Const.VipType.forever.value);
/* 40 */           flag = false;
/* 41 */           if (player.vipManager.po.lastForeverRewardDate != null && 
/* 42 */             DateUtil.isToday(player.vipManager.po.lastForeverRewardDate)) {
/* 43 */             flag = true;
/*    */           }
/* 45 */           info_forever.setFlag(flag ? 1 : 0);
/* 46 */           res.addDatas(info_forever);
/* 47 */           res.setS2CRemainTime(player.vipManager.getVipRemainTime());
/*    */           
/* 49 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\vip\VipInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */