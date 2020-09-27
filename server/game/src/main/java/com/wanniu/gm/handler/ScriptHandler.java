/*    */ package com.wanniu.gm.handler;
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.wanniu.core.logfs.Level;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.GWorld;
/*    */ import com.wanniu.game.util.RobotUtil;
/*    */ import com.wanniu.gm.GMEvent;
/*    */ import com.wanniu.gm.GMResponse;
/*    */ import com.wanniu.gm.GMStateResponse;
/*    */ 
/*    */ @GMEvent
/*    */ public class ScriptHandler extends GMBaseHandler {
/*    */   public GMResponse execute(JSONArray arr) {
/*    */     String[] pros;
/*    */     int proes[], i;
/* 16 */     String[] cmd = arr.getString(0).split(" ");
/* 17 */     switch (cmd[0]) {
/*    */       case "debug":
/* 19 */         GWorld.DEBUG = Boolean.parseBoolean(cmd[1]);
/*    */         break;
/*    */       
/*    */       case "robot":
/* 23 */         GWorld.ROBOT = Boolean.parseBoolean(cmd[1]);
/*    */         break;
/*    */       
/*    */       case "robot_level":
/* 27 */         GWorld.ROBOT_MAX_LEVEL = Integer.parseInt(cmd[1]);
/*    */         break;
/*    */       
/*    */       case "monitor":
/* 31 */         GWorld.MONITOR = Boolean.parseBoolean(cmd[1]);
/*    */         break;
/*    */       
/*    */       case "robots":
/* 35 */         GWorld.ROBOTS = Boolean.parseBoolean(cmd[1]);
/*    */         break;
/*    */       
/*    */       case "out":
/* 39 */         Out.setLevel(Level.valueOf(cmd[1].toUpperCase()));
/*    */         break;
/*    */       
/*    */       case "pros":
/* 43 */         pros = cmd[1].split(",");
/* 44 */         proes = new int[pros.length];
/* 45 */         for (i = 0; i < proes.length; i++) {
/* 46 */           proes[i] = Integer.valueOf(pros[i]).intValue();
/*    */         }
/* 48 */         RobotUtil.PROS = proes;
/*    */         break;
/*    */     } 
/*    */     
/* 52 */     return (GMResponse)new GMStateResponse(1);
/*    */   }
/*    */   
/*    */   public short getType() {
/* 56 */     return 4556;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\handler\ScriptHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */