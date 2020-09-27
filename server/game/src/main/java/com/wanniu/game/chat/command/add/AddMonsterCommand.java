/*    */ package com.wanniu.game.chat.command.add;
/*    */ 
/*    */ import com.wanniu.game.area.MonsterUnit;
/*    */ import com.wanniu.game.chat.command.AbsCommand;
/*    */ import com.wanniu.game.chat.command.Command;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.base.MonsterBase;
/*    */ import com.wanniu.game.monster.MonsterConfig;
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
/*    */ @Command({"@gm add monster"})
/*    */ public class AddMonsterCommand
/*    */   extends AbsCommand
/*    */ {
/*    */   public String help() {
/* 24 */     return "@gm add monster <id>\t添加怪物命令";
/*    */   }
/*    */ 
/*    */   
/*    */   protected String exec(WNPlayer player, String... args) {
/* 29 */     player.getArea().syncPlayerHistoryData(player);
/*    */     
/* 31 */     Integer monsterId = Integer.valueOf(Integer.parseInt(args[3]));
/* 32 */     MonsterBase prop = MonsterConfig.getInstance().get(monsterId.intValue());
/* 33 */     List<MonsterUnit> data = new ArrayList<>();
/* 34 */     MonsterUnit unit = new MonsterUnit();
/* 35 */     unit.id = monsterId.intValue();
/* 36 */     unit.x = (int)player.playerTempData.x;
/* 37 */     unit.y = (int)player.playerTempData.y;
/* 38 */     unit.force = Const.AreaForce.MONSTER.value;
/* 39 */     unit.autoGuard = true;
/* 40 */     unit.shareType = prop.shareType;
/* 41 */     data.add(unit);
/* 42 */     player.getArea().addUnitsToArea(data);
/* 43 */     return "";
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\chat\command\add\AddMonsterCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */