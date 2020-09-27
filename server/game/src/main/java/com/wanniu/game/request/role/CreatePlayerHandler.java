/*     */ package com.wanniu.game.request.role;
/*     */ 
/*     */ import cn.qeng.common.login.TokenInfo;
/*     */ import com.wanniu.core.GGlobal;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.area.PlayerRemote;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.msg.ErrorResponse;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.ext.CharacterExt;
/*     */ import com.wanniu.game.player.BILogService;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.RebateService;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.player.bi.LogReportService;
/*     */ import com.wanniu.game.util.BlackWordUtil;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import pomelo.connector.RoleHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @GClientEvent("connector.roleHandler.createPlayerRequest")
/*     */ public class CreatePlayerHandler
/*     */   extends PomeloRequest
/*     */ {
/*     */   public PomeloResponse request() throws Exception {
/*  39 */     RoleHandler.CreatePlayerRequest req = RoleHandler.CreatePlayerRequest.parseFrom(this.pak.getRemaingBytes());
/*  40 */     String uid = this.pak.getUid();
/*  41 */     int pro = req.getC2SPro();
/*  42 */     if (pro == Const.PlayerPro.YU_JIAN.value || pro == Const.PlayerPro.SHEN_JIAN.value) {
/*  43 */       return (PomeloResponse)new ErrorResponse("该职业暂未开放！");
/*     */     }
/*  45 */     String name = req.getC2SName();
/*  46 */     if (StringUtil.isEmpty(uid)) {
/*  47 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PLAYER_UID_NULL"));
/*     */     }
/*     */     
/*  50 */     if (StringUtil.isEmpty(name)) {
/*  51 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PLAYER_NAME_NULL"));
/*     */     }
/*     */     
/*  54 */     if (name.length() > GWorld.__SERVER_LANG.getNameLimit()) {
/*  55 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PLAYER_NAME_LONG"));
/*     */     }
/*     */     
/*  58 */     if (pro == 0) {
/*  59 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PLAYER_PRO_ILLEGALITY"));
/*     */     }
/*     */     
/*  62 */     Integer count = (Integer)this.pak.getAttr(GGlobal.__KEY_ROLE_COUNT);
/*  63 */     if (count != null && count.intValue() >= 5) {
/*  64 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("ROLE_NUM_UPPER_LIMIT"));
/*     */     }
/*     */ 
/*     */     
/*  68 */     if (BlackWordUtil.isIncludeBlackString(name)) {
/*  69 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PLAYER_ID_SENSITIVE"));
/*     */     }
/*     */     
/*  72 */     if (BlackWordUtil.isIncludeSpecialChar(name)) {
/*  73 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PLAYER_ID_CHARACTER"));
/*     */     }
/*     */     
/*  76 */     List<CharacterExt> charData = GameData.findCharacters(t -> (t.pro == pro));
/*  77 */     if (charData.size() == 0) {
/*  78 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PLAYER_PRO_ILLEGALITY"));
/*     */     }
/*     */ 
/*     */     
/*  82 */     final WNPlayer player = PlayerRemote.createPlayer(uid, name, pro, ((Integer)this.pak.getAttr(GGlobal.__KEY_LOGIC_SERVERID)).intValue());
/*  83 */     if (player == null) {
/*  84 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PLAYER_NAME_HAS_USED"));
/*     */     }
/*     */ 
/*     */     
/*  88 */     TokenInfo token = (TokenInfo)this.pak.getAttr(GGlobal.__KEY_TOKEN_INFO);
/*  89 */     if (token != null) {
/*  90 */       (player.getPlayer()).channel = token.getChannel();
/*  91 */       (player.getPlayer()).subchannel = token.getSubchannel();
/*  92 */       (player.getPlayer()).subchannelUID = token.getSubchannelUid();
/*  93 */       (player.getPlayer()).mac = token.getMac();
/*  94 */       (player.getPlayer()).os = token.getOs();
/*  95 */       (player.getPlayer()).ip = this.pak.getIp();
/*     */     } 
/*     */     
/*  98 */     Out.info(new Object[] { "创建角色 playerId=", player.getId(), ",name=", player.getName(), ",uid=", uid });
/*  99 */     BILogService.getInstance().ansycReportPlayerData(this.pak.getSession(), player.getPlayer(), true);
/* 100 */     RebateService.getInstance().ansycCheckRebate(player);
/* 101 */     LogReportService.getInstance().ansycReportCreatePlayer(player);
/*     */     
/* 103 */     this.pak.setAttr(GGlobal.__KEY_ROLE_COUNT, Integer.valueOf(count.intValue() + 1));
/* 104 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/* 107 */           RoleHandler.CreatePlayerResponse.Builder res = RoleHandler.CreatePlayerResponse.newBuilder();
/*     */           
/* 109 */           res.setS2CPlayer(PlayerUtil.transToJson4Basic(player));
/*     */           
/* 111 */           res.setS2CCode(200);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 116 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\role\CreatePlayerHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */