/*    */ package com.wanniu.game.chat.command.add;
/*    */ 
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.auction.AuctionService;
/*    */ import com.wanniu.game.chat.command.AbsCommand;
/*    */ import com.wanniu.game.chat.command.Command;
/*    */ import com.wanniu.game.item.ItemUtil;
/*    */ import com.wanniu.game.item.NormalItem;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Command({"@gm add auction"})
/*    */ public class AddAuctionCommand
/*    */   extends AbsCommand
/*    */ {
/*    */   public String help() {
/* 24 */     return "@gm add auction \t添加竞拍物品命令";
/*    */   }
/*    */ 
/*    */   
/*    */   protected String exec(WNPlayer player, String... args) {
/* 29 */     List<NormalItem> items = new ArrayList<>();
/* 30 */     items.addAll(ItemUtil.createItemsByItemCode("pet3003-p", 1));
/* 31 */     AuctionService.getInstance().addAuctionItem(items, player.guildManager.getGuildId(), "GM命令");
/* 32 */     if (StringUtil.isEmpty(player.guildManager.getGuildId())) {
/* 33 */       AuctionService.getInstance().processWorldAuctionsPoint();
/*    */     } else {
/* 35 */       AuctionService.getInstance().processGuildAuctionsPoint(player.guildManager.getGuildId());
/*    */     } 
/* 37 */     return "";
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\chat\command\add\AddAuctionCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */