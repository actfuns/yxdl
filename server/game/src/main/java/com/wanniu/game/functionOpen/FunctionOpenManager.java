/*     */ package com.wanniu.game.functionOpen;
/*     */ 
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.GuideCO;
/*     */ import com.wanniu.game.data.OpenLvCO;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.FunctionOpenPO;
/*     */ import com.wanniu.game.task.TaskEvent;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import pomelo.area.FunctionOpenHandler;
/*     */ import pomelo.player.PlayerOuterClass;
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
/*     */ 
/*     */ 
/*     */ public class FunctionOpenManager
/*     */ {
/*     */   public WNPlayer player;
/*     */   public FunctionOpenPO data;
/*     */   
/*     */   public FunctionOpenManager(WNPlayer player, FunctionOpenPO data) {
/*  49 */     this.player = player;
/*     */     
/*  51 */     if (data == null) {
/*  52 */       data = new FunctionOpenPO();
/*     */     }
/*  54 */     this.data = data;
/*  55 */     if (this.data.openMap == null) {
/*  56 */       this.data.openMap = new HashMap<>();
/*     */     }
/*  58 */     if (this.data.playMap == null) {
/*  59 */       this.data.playMap = new HashMap<>();
/*     */     }
/*  61 */     if (this.data.functionAwards == null) {
/*  62 */       this.data.functionAwards = new ArrayList();
/*     */     }
/*  64 */     init();
/*     */   }
/*     */   
/*     */   public void init() {
/*  68 */     List<OpenLvCO> propList = FunctionOpenUtil.getPropList();
/*  69 */     for (OpenLvCO prop : propList) {
/*  70 */       if (this.data.openMap.containsKey(prop.fun)) {
/*     */         continue;
/*     */       }
/*  73 */       if (prop.isReq == 0 && 
/*  74 */         checkLevelReq(prop)) {
/*  75 */         this.data.openMap.put(prop.fun, Integer.valueOf(1));
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
/*     */   public boolean checkLevelReq(OpenLvCO prop) {
/*  88 */     int level = Math.max(prop.openLv, 1);
/*  89 */     int upLevel = prop.openUpLv;
/*  90 */     int vipLevel = prop.openVIPLv;
/*     */     
/*  92 */     if (upLevel > 0) {
/*  93 */       if ((this.player.getPlayer()).upLevel < upLevel)
/*  94 */         return false; 
/*  95 */     } else if ((this.player.getPlayer()).level < level) {
/*  96 */       return false;
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
/*     */     
/* 120 */     return true;
/*     */   }
/*     */   
/*     */   public List<PlayerOuterClass.FunctionInfo> toJson4PayLoad() {
/* 124 */     List<PlayerOuterClass.FunctionInfo> data = new ArrayList<>();
/*     */     
/* 126 */     List<OpenLvCO> propList = FunctionOpenUtil.getPropList();
/* 127 */     for (OpenLvCO prop : propList) {
/* 128 */       if (prop.isOpen > 0 && prop.type == 0) {
/*     */         continue;
/*     */       }
/* 131 */       PlayerOuterClass.FunctionInfo.Builder tempInfo = PlayerOuterClass.FunctionInfo.newBuilder();
/* 132 */       tempInfo.setFuncName(prop.fun);
/* 133 */       tempInfo.setOpenFlag(0);
/* 134 */       tempInfo.setPlayFlag(0);
/*     */       
/* 136 */       if (this.data.playMap.containsKey(prop.fun)) {
/* 137 */         tempInfo.setPlayFlag(1);
/*     */       }
/* 139 */       if (prop.isOpen > 0 && this.data.openMap.containsKey(prop.fun)) {
/* 140 */         tempInfo.setOpenFlag(1);
/*     */       }
/* 142 */       data.add(tempInfo.build());
/*     */     } 
/*     */     
/* 145 */     return data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<PlayerOuterClass.FunctionInfo> getFunctionOpenPushList(List<String> nameArray) {
/* 155 */     List<PlayerOuterClass.FunctionInfo> data = new ArrayList<>();
/* 156 */     List<OpenLvCO> propList = FunctionOpenUtil.getPropListByFunctionNameArray(nameArray);
/* 157 */     for (OpenLvCO prop : propList) {
/* 158 */       if (prop.isOpen > 0 && prop.type == 0) {
/*     */         continue;
/*     */       }
/* 161 */       PlayerOuterClass.FunctionInfo.Builder tempInfo = PlayerOuterClass.FunctionInfo.newBuilder();
/* 162 */       tempInfo.setFuncName(prop.fun);
/* 163 */       tempInfo.setOpenFlag(0);
/* 164 */       tempInfo.setPlayFlag(0);
/* 165 */       if (this.data.playMap.containsKey(prop.fun)) {
/* 166 */         tempInfo.setPlayFlag(1);
/*     */       }
/* 168 */       if (prop.isOpen > 0 && this.data.openMap.containsKey(prop.fun)) {
/* 169 */         tempInfo.setOpenFlag(1);
/* 170 */         data.add(tempInfo.build());
/*     */       } 
/*     */     } 
/*     */     
/* 174 */     return data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String receiveFunctionAward(int guideId) {
/* 181 */     if (this.data.functionAwards.contains(Integer.valueOf(guideId))) {
/* 182 */       return LangService.getValue("SOLO_REWARD_HAS_DRAWED");
/*     */     }
/* 184 */     GuideCO guideCO = (GuideCO)GameData.Guides.get(Integer.valueOf(guideId));
/* 185 */     if (guideCO == null) {
/* 186 */       return LangService.getValue("SOLO_REWARD_NOT_EXIST");
/*     */     }
/*     */ 
/*     */     
/* 190 */     this.data.functionAwards.add(Integer.valueOf(guideId));
/*     */     
/* 192 */     if (StringUtil.isNotEmpty(guideCO.reward)) {
/* 193 */       String[] codeNum = guideCO.reward.split(":");
/* 194 */       this.player.bag.addCodeItemMail(codeNum[0], Integer.parseInt(codeNum[1]), null, Const.GOODS_CHANGE_TYPE.FUNCTION_OPEN, "Bag_full_common");
/*     */     } 
/* 196 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkFunctoinAward() {
/* 203 */     FunctionOpenHandler.FunctionAwardListPush.Builder functionAwardPush = FunctionOpenHandler.FunctionAwardListPush.newBuilder();
/* 204 */     for (GuideCO guideCO : GameData.Guides.values()) {
/*     */       
/* 206 */       if (this.player.getLevel() < guideCO.closeLv) {
/*     */         continue;
/*     */       }
/*     */       
/* 210 */       if (this.data.functionAwards.contains(Integer.valueOf(guideCO.iD))) {
/*     */         continue;
/*     */       }
/*     */       
/* 214 */       functionAwardPush.addGuideIds(guideCO.iD);
/*     */     } 
/* 216 */     if (functionAwardPush.getGuideIdsCount() > 0) {
/* 217 */       this.player.receive("area.functionOpenPush.functionAwardListPush", (GeneratedMessage)functionAwardPush.build());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpgradeLevelOrVip() {
/* 225 */     List<Integer> reqTypeArray = new ArrayList<>();
/* 226 */     reqTypeArray.add(Integer.valueOf(ReqType.LEVEL.getValue()));
/* 227 */     reqTypeArray.add(Integer.valueOf(ReqType.FINISH_TASK.getValue()));
/* 228 */     List<OpenLvCO> propList = FunctionOpenUtil.getPropListByReqTypeArray(reqTypeArray);
/* 229 */     checkOpenFunctions(propList, null);
/*     */ 
/*     */     
/* 232 */     checkFunctoinAward();
/*     */   }
/*     */   
/*     */   public void checkAll() {
/* 236 */     List<OpenLvCO> propList = FunctionOpenUtil.getPropList();
/* 237 */     checkOpenFunctions(propList, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onFinishTask(String taskId) {
/* 242 */     List<OpenLvCO> propList = FunctionOpenUtil.getPropListByReqEvent(ReqType.FINISH_TASK.getValue(), taskId);
/* 243 */     checkOpenFunctions(propList, taskId);
/*     */   }
/*     */   
/*     */   public void onAcceptTask(String taskId) {
/* 247 */     List<OpenLvCO> propList = FunctionOpenUtil.getPropListByReqEvent(ReqType.ACCEPT_TASK.getValue(), taskId);
/* 248 */     checkOpenFunctions(propList, taskId);
/*     */   }
/*     */   
/*     */   public void onInteract(String objId) {
/* 252 */     List<OpenLvCO> propList = FunctionOpenUtil.getPropListByReqEvent(ReqType.INTERACT_ITEM.getValue(), objId);
/* 253 */     checkOpenFunctions(propList, objId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkOpenFunctions(List<OpenLvCO> propList, String param) {
/* 263 */     List<String> openIdArray = new ArrayList<>();
/* 264 */     for (OpenLvCO prop : propList) {
/* 265 */       if (this.data.openMap.containsKey(prop.fun)) {
/*     */         continue;
/*     */       }
/* 268 */       if (prop.isReq == 0) {
/* 269 */         if (!checkLevelReq(prop)) {
/*     */           continue;
/*     */         }
/* 272 */       } else if (prop.isReq == 1) {
/* 273 */         if (!prop.openReq.equals(param)) {
/*     */           continue;
/*     */         }
/* 276 */       } else if (prop.isReq == 2) {
/* 277 */         if (!checkLevelReq(prop)) {
/*     */           continue;
/*     */         }
/* 280 */         if (!prop.openReq.equals(param)) {
/*     */           continue;
/*     */         }
/* 283 */         if (!this.player.getPlayerTasks().isFinishTask(Integer.parseInt(param))) {
/*     */           continue;
/*     */         }
/* 286 */       } else if (prop.isReq != 3 || 
/* 287 */         !prop.openReq.equals(param)) {
/*     */         continue;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 294 */       this.data.openMap.put(prop.fun, Integer.valueOf(1));
/* 295 */       openIdArray.add(prop.fun);
/*     */     } 
/* 297 */     onOpenNewFunctions(openIdArray);
/*     */   }
/*     */   
/*     */   public void pushAllFunctionOpenInfoToClient() {
/* 301 */     FunctionOpenHandler.FunctionOpenListPush.Builder data = FunctionOpenHandler.FunctionOpenListPush.newBuilder();
/* 302 */     data.setS2CCode(200);
/* 303 */     data.getS2CListBuilderList().clear();
/* 304 */     data.addAllS2CList(toJson4PayLoad());
/* 305 */     data.setS2CIsAll(1);
/*     */     
/* 307 */     this.player.receive("area.functionOpenPush.functionOpenListPush", (GeneratedMessage)data.build());
/*     */   }
/*     */   
/*     */   public void pushNewFunctionOpenInfoToClient(List<String> pushIdArray) {
/* 311 */     if (pushIdArray == null || pushIdArray.size() == 0) {
/*     */       return;
/*     */     }
/* 314 */     FunctionOpenHandler.FunctionOpenListPush.Builder data = FunctionOpenHandler.FunctionOpenListPush.newBuilder();
/* 315 */     data.setS2CCode(200);
/*     */     
/* 317 */     List<PlayerOuterClass.FunctionInfo> list = getFunctionOpenPushList(pushIdArray);
/* 318 */     if (list.size() == 0) {
/*     */       return;
/*     */     }
/*     */     
/* 322 */     data.addAllS2CList(list);
/* 323 */     data.setS2CIsAll(0);
/* 324 */     this.player.receive("area.functionOpenPush.functionOpenListPush", (GeneratedMessage)data.build());
/*     */   }
/*     */   
/*     */   public void onOpenNewFunctions(List<String> openArray) {
/* 328 */     if (openArray.size() == 0) {
/*     */       return;
/*     */     }
/* 331 */     pushNewFunctionOpenInfoToClient(openArray);
/*     */     
/* 333 */     if (openArray.indexOf(Const.FunctionType.RIDING.getValue()) != -1 || openArray.indexOf(Const.FunctionType.MOUNT.getValue()) != -1) {
/* 334 */       this.player.mountManager.openMount();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onEvent(TaskEvent event) {
/* 342 */     if (event.type == Const.EventType.interActiveItem.getValue()) {
/* 343 */       onInteract(event.params[0].toString());
/*     */     }
/*     */   }
/*     */   
/*     */   public void gmOpenFunction(int id) {
/* 348 */     if (id > 0) {
/* 349 */       OpenLvCO prop = FunctionOpenUtil.getPropById(id);
/* 350 */       if (prop == null) {
/*     */         return;
/*     */       }
/* 353 */       if (this.data.openMap.containsKey(prop.fun)) {
/*     */         return;
/*     */       }
/* 356 */       this.data.openMap.put(prop.fun, Integer.valueOf(1));
/* 357 */       List<String> idArray = new ArrayList<>();
/* 358 */       idArray.add(prop.fun);
/* 359 */       onOpenNewFunctions(idArray);
/*     */     } else {
/* 361 */       List<String> idArray = new ArrayList<>();
/* 362 */       List<OpenLvCO> propList = FunctionOpenUtil.getPropList();
/* 363 */       for (OpenLvCO prop : propList) {
/* 364 */         if (this.data.openMap.containsKey(prop.fun)) {
/*     */           continue;
/*     */         }
/* 367 */         this.data.openMap.put(prop.fun, Integer.valueOf(1));
/* 368 */         idArray.add(prop.fun);
/*     */       } 
/* 370 */       onOpenNewFunctions(idArray);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOpen(String functionName) {
/* 381 */     OpenLvCO prop = FunctionOpenUtil.getPropByName(functionName);
/*     */     
/* 383 */     if (prop == null) {
/* 384 */       return true;
/*     */     }
/* 386 */     if (prop.isOpen == 0) {
/* 387 */       return false;
/*     */     }
/* 389 */     if (prop.type == 0) {
/* 390 */       return true;
/*     */     }
/* 392 */     if (!this.data.openMap.containsKey(functionName)) {
/* 393 */       return false;
/*     */     }
/* 395 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean IsOpen(String functionName, String playerId) {
/* 400 */     OpenLvCO prop = FunctionOpenUtil.getPropByName(functionName);
/*     */     
/* 402 */     if (prop == null) {
/* 403 */       return true;
/*     */     }
/* 405 */     if (prop.isOpen == 0) {
/* 406 */       return false;
/*     */     }
/* 408 */     if (prop.type == 0) {
/* 409 */       return true;
/*     */     }
/* 411 */     FunctionOpenPO functionOpenPO = (FunctionOpenPO)PlayerPOManager.findPO(ConstsTR.player_func_openTR, playerId, FunctionOpenPO.class);
/* 412 */     if (!functionOpenPO.openMap.containsKey(functionName)) {
/* 413 */       return false;
/*     */     }
/* 415 */     return true;
/*     */   }
/*     */   
/*     */   public int setFunctionPlayed(String funcName) {
/* 419 */     if (!isOpen(funcName)) {
/* 420 */       return -1;
/*     */     }
/* 422 */     if (this.data.playMap.containsKey(funcName)) {
/* 423 */       return 0;
/*     */     }
/* 425 */     this.data.playMap.put(funcName, Integer.valueOf(1));
/* 426 */     return 0;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\functionOpen\FunctionOpenManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */