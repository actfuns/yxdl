/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBTable;
/*    */ import com.wanniu.game.redpacket.RedPacket;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @DBTable("player_red_packet")
/*    */ public class RedPacketCenterPO
/*    */   extends GEntity
/*    */ {
/* 16 */   public Map<String, RedPacket> redPackets = new HashMap<>();
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\RedPacketCenterPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */