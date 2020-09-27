/*    */ package com.wanniu.game.request.equip;
/*    */ 
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import com.wanniu.core.db.GCache;
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.common.ConstsTR;
/*    */ import com.wanniu.game.item.ItemUtil;
/*    */ import com.wanniu.game.item.NormalItem;
/*    */ import com.wanniu.game.item.po.PlayerItemPO;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.EquipHandler;
/*    */ import pomelo.item.ItemOuterClass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.equipHandler.chatEquipDetailRequest")
/*    */ public class ChatEquipDetailHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 33 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 35 */     EquipHandler.ChatEquipDetailRequest req = EquipHandler.ChatEquipDetailRequest.parseFrom(this.pak.getRemaingBytes());
/* 36 */     final String itemId = req.getC2SId();
/*    */     
/* 38 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 41 */           EquipHandler.ChatEquipDetailResponse.Builder res = EquipHandler.ChatEquipDetailResponse.newBuilder();
/* 42 */           String showItem = GCache.get(ConstsTR.chat_item_tr.value + "/" + itemId);
/* 43 */           if (StringUtil.isNotEmpty(showItem)) {
/* 44 */             NormalItem item = ItemUtil.createItemByDbOpts((PlayerItemPO)JSON.parseObject(showItem, PlayerItemPO.class));
/* 45 */             ItemOuterClass.ItemDetail.Builder itemDetail = item.getItemDetail(player.playerBasePO);
/* 46 */             res.setS2CCode(200);
/* 47 */             res.setS2CData(itemDetail);
/*    */           } else {
/* 49 */             res.setS2CCode(500);
/* 50 */             res.setS2CMsg(LangService.getValue("LINK_HAS_FAILED"));
/*    */           } 
/* 52 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\equip\ChatEquipDetailHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */