/*     */ package com.wanniu.game.mail;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.common.CommonUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ModuleManager;
/*     */ import com.wanniu.game.common.msg.WNNotifyManager;
/*     */ import com.wanniu.game.data.base.DItemEquipBase;
/*     */ import com.wanniu.game.item.ItemConfig;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.item.po.ItemSpeData;
/*     */ import com.wanniu.game.item.po.PlayerItemPO;
/*     */ import com.wanniu.game.message.MessageData;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.PlayerMailDataPO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import pomelo.area.MailHandler;
/*     */ import pomelo.area.PlayerHandler;
/*     */ 
/*     */ public class MailManager
/*     */   extends ModuleManager
/*     */ {
/*     */   public Map<String, WNMail> mails;
/*     */   public String playerId;
/*     */   public PlayerMailDataPO data;
/*     */   
/*     */   public enum ERR_CODE
/*     */   {
/*  36 */     ERR_CODE_OK(0), ERR_CODE_BAG_FULL(1), ERR_CODE_NO_ATTACH(2), ERR_CODE_NO_SUCH_MAIL(3);
/*     */     private int value;
/*     */     
/*     */     ERR_CODE(int value) {
/*  40 */       this.value = value;
/*     */     }
/*     */     
/*     */     public int getValue() {
/*  44 */       return this.value;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WNPlayer getPlayer() {
/*  53 */     return PlayerUtil.getOnlinePlayer(this.playerId);
/*     */   }
/*     */   
/*     */   public MailManager(String playerId, PlayerMailDataPO data) {
/*  57 */     this.data = data;
/*  58 */     this.playerId = playerId;
/*  59 */     this.mails = data.mails;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addServerMailRecord(String serverMailId) {
/*  68 */     this.data.serverMailRecord.put(serverMailId, serverMailId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int[] getUnReadMailCount() {
/*  77 */     int[] retValue = new int[2];
/*  78 */     for (WNMail mail : this.mails.values()) {
/*  79 */       if (mail.status == Const.MailState.MAIL_STATE_NULL.getValue()) {
/*  80 */         retValue[Const.MailStaus.MAIL_UNREAD.getValue()] = retValue[Const.MailStaus.MAIL_UNREAD.getValue()] + 1;
/*     */       }
/*  82 */       if (hasAttachment(mail)) {
/*  83 */         retValue[Const.MailStaus.MAIL_UNRECEIVE.getValue()] = retValue[Const.MailStaus.MAIL_UNRECEIVE.getValue()] + 1;
/*     */       }
/*     */     } 
/*  86 */     return retValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean hasAttachment(WNMail mail) {
/*  96 */     if (mail.attachment == null || mail.attachment.size() == 0) {
/*  97 */       return false;
/*     */     }
/*  99 */     return true;
/*     */   }
/*     */   
/*     */   public final int getMailCount() {
/* 103 */     return this.mails.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final ArrayList<WNMail> getSortMailList() {
/* 110 */     ArrayList<WNMail> list = new ArrayList<>();
/* 111 */     for (Map.Entry<String, WNMail> node : this.mails.entrySet()) {
/* 112 */       list.add(node.getValue());
/*     */     }
/* 114 */     Collections.sort(list, new Comparator<WNMail>()
/*     */         {
/*     */           public int compare(WNMail arg0, WNMail arg1) {
/* 117 */             return arg0.compareTo(arg1);
/*     */           }
/*     */         });
/* 120 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean addMail(WNMail mail, boolean isUpdateScript) {
/* 133 */     WNPlayer player = getPlayer();
/* 134 */     if (player != null && player.isRobot()) {
/* 135 */       return false;
/*     */     }
/* 137 */     if (this.mails.containsKey(mail.id)) {
/* 138 */       return false;
/*     */     }
/* 140 */     if (this.mails.size() >= Const.MailSysParam.MAIL_MAX_NUM.getValue()) {
/*     */       
/* 142 */       ArrayList<WNMail> mailArray = getSortMailList();
/* 143 */       int delCount = this.mails.size() - Const.MailSysParam.MAIL_MAX_NUM.getValue() + 1;
/* 144 */       for (int i = 0; i < delCount; i++) {
/* 145 */         mailDelete(((WNMail)mailArray.get(mailArray.size() - 1)).id, true);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 153 */     this.mails.put(mail.id, mail);
/* 154 */     Out.info(new Object[] { "新增邮件 playerId=", mail.playerId, ",mailId=", mail.id, ",attachment=", JSON.toJSONString(mail.attachment) });
/*     */     
/* 156 */     if (player == null) {
/* 157 */       return false;
/*     */     }
/*     */     
/* 160 */     MailHandler.Mail data = mail.toMailBuilder(player.getPlayerAttach()).build();
/* 161 */     ArrayList<MailHandler.Mail> list = new ArrayList<>();
/* 162 */     list.add(data);
/*     */     
/* 164 */     WNNotifyManager.getInstance().pushMails(player, list);
/*     */     
/* 166 */     if (isUpdateScript) {
/* 167 */       updateSuperScript();
/* 168 */       CommonUtil.sendIconMsgType(Const.MESSAGE_TYPE.mail_receive, player.getId());
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 191 */     Out.debug(new Object[] { "mail count :", Integer.valueOf(getMailCount()) });
/* 192 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void readMail(String[] ids) {
/* 201 */     if (ids != null) {
/* 202 */       for (String key : ids) {
/* 203 */         WNMail mail = this.mails.get(key);
/* 204 */         if (mail != null) {
/* 205 */           if (mail.mailRead == Const.MailReadDeal.MAIL_READ_DEL.getValue()) {
/* 206 */             mail.status = Const.MailState.MAIL_STATE_READ.getValue();
/* 207 */             if (!hasAttachment(mail)) {
/* 208 */               mailDelete(mail.id, false);
/*     */             }
/* 210 */           } else if (mail.status == Const.MailState.MAIL_STATE_NULL.getValue()) {
/* 211 */             mail.status = Const.MailState.MAIL_STATE_READ.getValue();
/* 212 */             updateSuperScript();
/*     */           } 
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean mailDelete(String id, boolean isForce) {
/* 232 */     WNMail mail = this.mails.get(id);
/* 233 */     boolean isDelete = false;
/* 234 */     if (mail != null) {
/* 235 */       if (isForce) {
/* 236 */         isDelete = true;
/*     */       } else {
/* 238 */         if (mail.status == Const.MailState.MAIL_STATE_ATTACH_RECEIVE.getValue()) {
/* 239 */           isDelete = true;
/*     */         }
/* 241 */         if (mail.status == Const.MailState.MAIL_STATE_READ.getValue() && !hasAttachment(mail)) {
/* 242 */           isDelete = true;
/*     */         }
/*     */       } 
/* 245 */       if (isDelete) {
/* 246 */         this.mails.remove(id);
/* 247 */         Out.info(new Object[] { "删除邮件 playerId=", mail.playerId, ",mailId=", mail.id, ",isForce=", Boolean.valueOf(isForce) });
/* 248 */         updateSuperScript();
/* 249 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/* 253 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String[] mailDeleteOneKey() {
/* 262 */     List<String> deleteIds = new ArrayList<>();
/* 263 */     for (Map.Entry<String, WNMail> node : this.mails.entrySet()) {
/* 264 */       WNMail mail = node.getValue();
/* 265 */       String id = node.getKey();
/* 266 */       if (mail.status == Const.MailState.MAIL_STATE_ATTACH_RECEIVE.getValue()) {
/* 267 */         deleteIds.add(id);
/*     */       }
/*     */       
/* 270 */       if (mail.status == Const.MailState.MAIL_STATE_READ.getValue() && !hasAttachment(mail)) {
/* 271 */         deleteIds.add(id);
/*     */       }
/*     */     } 
/* 274 */     String[] ids = new String[deleteIds.size()];
/* 275 */     int index = 0;
/* 276 */     for (String id : deleteIds) {
/* 277 */       this.mails.remove(id);
/* 278 */       ids[index++] = id;
/*     */     } 
/* 280 */     deleteIds.clear();
/* 281 */     updateSuperScript();
/* 282 */     return ids;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int mailGetAttachment(String id, boolean isUpdate) {
/* 293 */     if (!this.mails.containsKey(id)) {
/* 294 */       return ERR_CODE.ERR_CODE_NO_SUCH_MAIL.getValue();
/*     */     }
/* 296 */     WNMail mail = this.mails.get(id);
/* 297 */     if (!hasAttachment(mail)) {
/* 298 */       return ERR_CODE.ERR_CODE_NO_ATTACH.getValue();
/*     */     }
/* 300 */     List<PlayerItemPO> attachment = mail.attachment;
/*     */ 
/*     */     
/* 303 */     if (!getPlayer().getWnBag().testAddEntityItemsPO(attachment, true)) {
/* 304 */       return ERR_CODE.ERR_CODE_BAG_FULL.getValue();
/*     */     }
/*     */     
/* 307 */     Out.info(new Object[] { "领取邮件附件 playerId=", getPlayer().getId(), ",mailId=", mail.id, ",attachment=", JSON.toJSONString(attachment) });
/*     */     
/* 309 */     Const.GOODS_CHANGE_TYPE origin = Const.GOODS_CHANGE_TYPE.getE(mail.origin);
/* 310 */     getPlayer().getWnBag().addEntityItemsPO(attachment, (origin == null) ? Const.GOODS_CHANGE_TYPE.mail : origin);
/* 311 */     mail.status = Const.MailState.MAIL_STATE_ATTACH_RECEIVE.getValue();
/* 312 */     mail.attachment = new ArrayList<>();
/* 313 */     if (mail.mailRead == Const.MailReadDeal.MAIL_READ_DEL.getValue()) {
/* 314 */       mailDelete(id, false);
/*     */     }
/*     */     
/* 317 */     if (StringUtil.isNotEmpty(mail.mailSubType) && mail.mailSubType.equals("Consignment_sale")) {
/* 318 */       for (PlayerItemPO item : attachment) {
/* 319 */         if (item.code.equals("diamond"))
/*     */         {
/* 321 */           (getPlayer()).achievementManager.onGetDiamondInConsignment(item.speData.worth);
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 326 */     for (PlayerItemPO item : attachment) {
/* 327 */       if (item.code.equals("diamond")) {
/* 328 */         if (item.speData.worth >= 6480)
/* 329 */           PlayerUtil.bi(getClass(), Const.BiLogType.Mail, getPlayer(), new Object[] { id, mail.mailSenderId, Integer.valueOf(item.speData.worth) }); 
/*     */         continue;
/*     */       } 
/* 332 */       DItemEquipBase prop = ItemConfig.getInstance().getItemProp(item.code);
/* 333 */       if (prop != null && prop.qcolor >= Const.ItemQuality.ORANGE.getValue() && ItemUtil.isEquipByItemType(prop.itemType)) {
/* 334 */         StringBuffer sb = new StringBuffer();
/* 335 */         if (item.speData != null) {
/* 336 */           ItemSpeData speData = item.speData;
/* 337 */           if (speData != null) {
/* 338 */             sb.append(speData.baseAtts.toString());
/* 339 */             if (speData.extAtts != null) {
/* 340 */               sb.append("|||").append(speData.extAtts.toString());
/*     */             }
/* 342 */             if (speData.legendAtts != null) {
/* 343 */               sb.append("|||").append(speData.legendAtts.toString());
/*     */             }
/*     */           } 
/*     */         } 
/* 347 */         PlayerUtil.bi(getClass(), Const.BiLogType.Mail, getPlayer(), new Object[] { id, mail.mailSenderId, item.id, item.code, sb.toString() });
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 352 */     if (!isUpdate) {
/* 353 */       return ERR_CODE.ERR_CODE_OK.getValue();
/*     */     }
/*     */     
/* 356 */     updateSuperScript();
/* 357 */     return ERR_CODE.ERR_CODE_OK.getValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Const.MailAttachments mailGetAttachmentOneKey() {
/* 366 */     Const.MailAttachments mailAttachments = new Const.MailAttachments();
/* 367 */     List<String> ids = new ArrayList<>();
/* 368 */     String[] idstr = new String[this.mails.size()];
/* 369 */     idstr = (String[])this.mails.keySet().toArray((Object[])idstr);
/* 370 */     for (String id : idstr) {
/* 371 */       int code = mailGetAttachment(id, false);
/* 372 */       if (code == ERR_CODE.ERR_CODE_OK.getValue())
/* 373 */       { ids.add(id); }
/* 374 */       else { if (code == ERR_CODE.ERR_CODE_BAG_FULL.getValue()) {
/* 375 */           mailAttachments.code = code;
/*     */           break;
/*     */         } 
/* 378 */         mailAttachments.code = code; }
/*     */     
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 385 */     mailAttachments.mailIds = ids;
/* 386 */     updateSuperScript();
/* 387 */     return mailAttachments;
/*     */   }
/*     */   
/*     */   public final boolean onMessage(int operate, MessageData message) {
/* 391 */     if (message.getMessageType() == Const.MESSAGE_TYPE.mail_receive.getValue()) {
/* 392 */       return false;
/*     */     }
/* 394 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final WNMail getMailByID(String id) {
/* 399 */     if (this.mails.containsKey(id)) {
/* 400 */       return this.mails.get(id);
/*     */     }
/* 402 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void updateSuperScript() {
/* 407 */     if (getPlayer() != null)
/* 408 */       getPlayer().updateSuperScriptList(getSuperScript()); 
/*     */   }
/*     */   
/*     */   public final List<PlayerHandler.SuperScriptType> getSuperScript() {
/* 412 */     int[] countInfo = getUnReadMailCount();
/* 413 */     int number = 0;
/* 414 */     if (countInfo[Const.MailStaus.MAIL_UNREAD.getValue()] > 0) {
/* 415 */       number = countInfo[Const.MailStaus.MAIL_UNREAD.getValue()];
/* 416 */     } else if (countInfo[Const.MailStaus.MAIL_UNRECEIVE.getValue()] > 0) {
/* 417 */       number = countInfo[Const.MailStaus.MAIL_UNRECEIVE.getValue()];
/*     */     } 
/*     */     
/* 420 */     List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
/* 421 */     PlayerHandler.SuperScriptType.Builder script = PlayerHandler.SuperScriptType.newBuilder();
/* 422 */     script.setType(Const.SUPERSCRIPT_TYPE.MAIL.getValue());
/* 423 */     script.setNumber(number);
/* 424 */     list.add(script.build());
/* 425 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final MailHandler.Mail[] getAllMails(WNPlayer player) {
/* 434 */     MailHandler.Mail[] mailArray = new MailHandler.Mail[this.mails.size()];
/* 435 */     ArrayList<WNMail> list_mailArray = getSortMailList();
/* 436 */     int index = 0;
/* 437 */     for (WNMail mail : list_mailArray) {
/* 438 */       mailArray[index++] = mail.toMailBuilder(player.getPlayerAttach()).build();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 445 */     return mailArray;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPlayerEvent(Const.PlayerEventType eventType) {
/* 450 */     switch (eventType) {
/*     */       case AFTER_LOGIN:
/* 452 */         MailCenter.getInstance().checkServerMail(this);
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Const.ManagerType getManagerType() {
/* 462 */     return Const.ManagerType.MAIL;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\mail\MailManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */