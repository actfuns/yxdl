/*     */ package com.wanniu.game.request.player;
/*     */ 
/*     */ import com.alibaba.fastjson.TypeReference;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.core.tcp.protocol.Packet;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.equip.EquipUtil;
/*     */ import com.wanniu.game.guild.GuildUtil;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.GuildMemberPO;
/*     */ import com.wanniu.game.poes.GuildPO;
/*     */ import com.wanniu.game.poes.PlayerBasePO;
/*     */ import com.wanniu.game.poes.PlayerPO;
/*     */ import com.wanniu.game.poes.TitlePO;
/*     */ import com.wanniu.redis.GameDao;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import pomelo.Common;
/*     */ import pomelo.area.PlayerHandler;
/*     */ import pomelo.item.ItemOuterClass;
/*     */ import pomelo.player.PlayerOuterClass;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @GClientEvent("area.playerHandler.lookUpOtherPlayerRequest")
/*     */ public class LookUpOtherPlayerHandler
/*     */   extends PomeloRequest
/*     */ {
/*     */   public PomeloResponse request() throws Exception {
/*  43 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*  44 */     return new PomeloResponse() {
/*     */         protected void write() throws IOException {
/*  46 */           PlayerHandler.LookUpOtherPlayerRequest req = PlayerHandler.LookUpOtherPlayerRequest.parseFrom(LookUpOtherPlayerHandler.this.pak.getRemaingBytes());
/*  47 */           String other_playerId = req.getC2SPlayerId();
/*     */           
/*  49 */           PlayerHandler.LookUpOtherPlayerResponse.Builder res = PlayerHandler.LookUpOtherPlayerResponse.newBuilder();
/*  50 */           if (StringUtil.isEmpty(other_playerId)) {
/*  51 */             res.setS2CCode(500);
/*  52 */             res.setS2CMsg("");
/*  53 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*  57 */           if (player.getId().equals(other_playerId)) {
/*  58 */             res.setS2CCode(500);
/*  59 */             res.setS2CMsg(LangService.getValue("PLEASE_OPEN_PLAYER_INTERFACE"));
/*  60 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*  64 */           WNPlayer target = PlayerUtil.getOnlinePlayer(other_playerId);
/*  65 */           if (target != null && target.isProxy()) {
/*  66 */             res.setS2CCode(500);
/*  67 */             res.setS2CMsg(LangService.getValue("CANNOT_LOOKUP"));
/*  68 */             this.body.writeBytes(res.build().toByteArray());
/*     */             return;
/*     */           } 
/*  71 */           PlayerPO otherPlayer = null;
/*  72 */           int titleId = 0;
/*  73 */           List<ItemOuterClass.ItemDetail> equipments = new ArrayList<>();
/*  74 */           List<Common.AttributeSimple> attr_list = new ArrayList<>();
/*  75 */           List<ItemOuterClass.EquipGridStrengthInfo> strenght_list = new ArrayList<>();
/*  76 */           if (target == null) {
/*  77 */             otherPlayer = (PlayerPO)PlayerPOManager.findPO(ConstsTR.playerTR, other_playerId, PlayerPO.class);
/*  78 */             if (otherPlayer == null) {
/*  79 */               res.setS2CCode(500);
/*  80 */               res.setS2CMsg(LangService.getValue("CANNOT_LOOKUP"));
/*  81 */               this.body.writeBytes(res.build().toByteArray());
/*     */               return;
/*     */             } 
/*  84 */             TitlePO rankpo = (TitlePO)PlayerPOManager.findPO(ConstsTR.playerTitleTR, other_playerId, TitlePO.class);
/*  85 */             if (rankpo != null)
/*  86 */               titleId = rankpo.selectedRankId; 
/*  87 */             PlayerBasePO playerBasePO = (PlayerBasePO)PlayerPOManager.findPO(ConstsTR.playerBaseTR, otherPlayer.id, PlayerBasePO.class);
/*  88 */             equipments = EquipUtil.getAllEquipDetails4PayLoad(playerBasePO, playerBasePO.equipGrids);
/*  89 */             Map<Const.PlayerBtlData, Integer> attr_map = new HashMap<>();
/*  90 */             attr_map = (Map<Const.PlayerBtlData, Integer>)GameDao.get(otherPlayer.id, ConstsTR.playerBtlData.value, new TypeReference<Map<Const.PlayerBtlData, Integer>>() {  }
/*     */               );
/*  92 */             if (attr_map != null) {
/*  93 */               for (Const.PlayerBtlData pbd : attr_map.keySet()) {
/*  94 */                 Common.AttributeSimple.Builder asb = Common.AttributeSimple.newBuilder();
/*  95 */                 asb.setId(pbd.id);
/*  96 */                 asb.setValue(((Integer)attr_map.get(pbd)).intValue());
/*  97 */                 attr_list.add(asb.build());
/*     */               } 
/*     */             }
/* 100 */             strenght_list = LookUpOtherPlayerHandler.toJson4StrengthPos(playerBasePO.strengthPos);
/*     */           } else {
/* 102 */             otherPlayer = target.player;
/* 103 */             titleId = target.titleManager.getTitleId();
/* 104 */             equipments = target.equipManager.getAllEquipDetails4PayLoad();
/* 105 */             attr_list = target.btlDataManager._getPlayerAttr();
/* 106 */             strenght_list = LookUpOtherPlayerHandler.toJson4StrengthPos(target.playerBasePO.strengthPos);
/*     */           } 
/*     */           
/* 109 */           if (otherPlayer != null) {
/* 110 */             PlayerOuterClass.LookUpPlayer.Builder data = PlayerOuterClass.LookUpPlayer.newBuilder();
/* 111 */             data.setName(otherPlayer.name);
/* 112 */             data.setLevel(otherPlayer.level);
/* 113 */             data.setUpLevel(otherPlayer.upLevel);
/* 114 */             data.setUpOrder(otherPlayer.upOrder);
/* 115 */             data.setPro(otherPlayer.pro);
/* 116 */             data.setFightPower(otherPlayer.fightPower);
/* 117 */             data.setExp(otherPlayer.exp);
/*     */             
/* 119 */             data.setTitleId(titleId);
/* 120 */             data.addAllEquipments(equipments);
/* 121 */             List<Common.Avatar> avatars = new ArrayList<>();
/* 122 */             List<Common.Avatar> equipAvatars = PlayerUtil.getBattlerServerAvatar(otherPlayer.id);
/* 123 */             avatars.addAll(equipAvatars);
/* 124 */             data.addAllAvatars(avatars);
/*     */             
/* 126 */             data.addAllAttrs(attr_list);
/* 127 */             GuildPO guildPO = GuildUtil.getPlayerGuild(otherPlayer.id);
/* 128 */             if (guildPO != null) {
/* 129 */               GuildMemberPO guildMemberPO = GuildUtil.getGuildMember(otherPlayer.id);
/* 130 */               data.setGuildName(guildPO.name);
/* 131 */               data.setGuildIcon(guildPO.icon);
/* 132 */               data.setGuildJob(guildMemberPO.job);
/*     */             } 
/*     */             
/* 135 */             if (target != null) {
/* 136 */               data.setPkValue(target.pkRuleManager.getPkValueData());
/*     */             }
/* 138 */             data.addAllStrengthPos(strenght_list);
/* 139 */             res.setS2CData(data.build());
/* 140 */             res.setS2CCode(200);
/* 141 */             this.body.writeBytes(res.build().toByteArray());
/*     */             return;
/*     */           } 
/* 144 */           res.setS2CCode(500);
/* 145 */           res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/* 146 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static List<ItemOuterClass.EquipGridStrengthInfo> toJson4StrengthPos(Map<Integer, PlayerBasePO.EquipStrengthPos> strengthPos) {
/* 155 */     List<ItemOuterClass.EquipGridStrengthInfo> list = new ArrayList<>();
/* 156 */     if (strengthPos == null)
/* 157 */       return list; 
/* 158 */     for (Iterator<Integer> iterator = strengthPos.keySet().iterator(); iterator.hasNext(); ) { int pos = ((Integer)iterator.next()).intValue();
/* 159 */       list.add(getStrenghInfo(strengthPos, pos)); }
/*     */     
/* 161 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static ItemOuterClass.EquipGridStrengthInfo getStrenghInfo(Map<Integer, PlayerBasePO.EquipStrengthPos> strengthPos, int pos) {
/* 168 */     PlayerBasePO.EquipStrengthPos info = strengthPos.get(Integer.valueOf(pos));
/* 169 */     ItemOuterClass.EquipGridStrengthInfo.Builder data = ItemOuterClass.EquipGridStrengthInfo.newBuilder();
/* 170 */     data.setPos(pos);
/* 171 */     data.setEnSection(info.enSection);
/* 172 */     data.setEnLevel(info.enLevel);
/* 173 */     data.addAllJewelAtts(EquipUtil.toJson4Gem(info));
/* 174 */     data.setSocks(info.socks);
/* 175 */     return data.build();
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\player\LookUpOtherPlayerHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */