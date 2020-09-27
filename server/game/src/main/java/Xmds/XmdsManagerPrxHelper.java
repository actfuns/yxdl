/*      */ package Xmds;
/*      */ import java.util.Map;
/*      */ 
/*      */ public final class XmdsManagerPrxHelper extends ObjectPrxHelperBase implements XmdsManagerPrx {
/*      */   private static final String __addPlayerAtt_name = "addPlayerAtt";
/*      */   private static final String __addUnit_name = "addUnit";
/*      */   private static final String __addUnits_name = "addUnits";
/*      */   private static final String __autoBattle_name = "autoBattle";
/*      */   private static final String __canTalkWithNpc_name = "canTalkWithNpc";
/*      */   private static final String __canUseItem_name = "canUseItem";
/*      */   private static final String __getAllNpcInfo_name = "getAllNpcInfo";
/*      */   private static final String __getAllPlayerUUID_name = "getAllPlayerUUID";
/*      */   private static final String __getAllUnitInfo_name = "getAllUnitInfo";
/*      */   private static final String __getBornPlace_name = "getBornPlace";
/*      */   private static final String __getInstanceStatistic_name = "getInstanceStatistic";
/*      */   private static final String __getPlayerData_name = "getPlayerData";
/*      */   private static final String __getPlayerPKInfoData_name = "getPlayerPKInfoData";
/*      */   private static final String __getPlayerPetData_name = "getPlayerPetData";
/*      */   private static final String __getPlayerSkillCDTime_name = "getPlayerSkillCDTime";
/*      */   private static final String __getPlayerStatistic_name = "getPlayerStatistic";
/*      */   private static final String __getZoneRegions_name = "getZoneRegions";
/*      */   private static final String __getZoneStaticData_name = "getZoneStaticData";
/*      */   private static final String __helpRevivePlayer_name = "helpRevivePlayer";
/*      */   private static final String __notifyBattleServer_name = "notifyBattleServer";
/*      */   private static final String __onFinishPickItem_name = "onFinishPickItem";
/*      */   private static final String __onMonsterDiedDrops_name = "onMonsterDiedDrops";
/*      */   
/*      */   public void addPlayerAtt(String playerId, String notifyPlayerIds, String key, int value) {
/*   29 */     addPlayerAtt(playerId, notifyPlayerIds, key, value, (Map<String, String>)null, false);
/*      */   }
/*      */   private static final String __playerReady_name = "playerReady"; private static final String __refreshPlayerAvatar_name = "refreshPlayerAvatar"; private static final String __refreshPlayerBasicData_name = "refreshPlayerBasicData"; private static final String __refreshPlayerBattleEffect_name = "refreshPlayerBattleEffect"; private static final String __refreshPlayerPKLevel_name = "refreshPlayerPKLevel"; private static final String __refreshPlayerPKMode_name = "refreshPlayerPKMode"; private static final String __refreshPlayerPKValue_name = "refreshPlayerPKValue"; private static final String __refreshPlayerPetBaseInfoChange_name = "refreshPlayerPetBaseInfoChange"; private static final String __refreshPlayerPetDataChange_name = "refreshPlayerPetDataChange"; private static final String __refreshPlayerPetFollowModeChange_name = "refreshPlayerPetFollowModeChange"; private static final String __refreshPlayerPetPropertyChange_name = "refreshPlayerPetPropertyChange"; private static final String __refreshPlayerPetSkillChange_name = "refreshPlayerPetSkillChange"; private static final String __refreshPlayerPropertyChange_name = "refreshPlayerPropertyChange"; private static final String __refreshPlayerRemainBagCountData_name = "refreshPlayerRemainBagCountData"; private static final String __refreshPlayerRemainTeamBagCountData_name = "refreshPlayerRemainTeamBagCountData"; private static final String __refreshPlayerSkill_name = "refreshPlayerSkill"; private static final String __refreshPlayerTeamData_name = "refreshPlayerTeamData"; private static final String __refreshSummonMount_name = "refreshSummonMount"; private static final String __refreshTeamData_name = "refreshTeamData"; private static final String __removeUnit_name = "removeUnit"; private static final String __revivePlayer_name = "revivePlayer"; private static final String __triggrBattleFunction_name = "triggrBattleFunction";
/*      */   
/*      */   public void addPlayerAtt(String playerId, String notifyPlayerIds, String key, int value, Map<String, String> __ctx) {
/*   34 */     addPlayerAtt(playerId, notifyPlayerIds, key, value, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void addPlayerAtt(String playerId, String notifyPlayerIds, String key, int value, Map<String, String> __ctx, boolean __explicitCtx) {
/*   39 */     end_addPlayerAtt(begin_addPlayerAtt(playerId, notifyPlayerIds, key, value, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_addPlayerAtt(String playerId, String notifyPlayerIds, String key, int value) {
/*   44 */     return begin_addPlayerAtt(playerId, notifyPlayerIds, key, value, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_addPlayerAtt(String playerId, String notifyPlayerIds, String key, int value, Map<String, String> __ctx) {
/*   49 */     return begin_addPlayerAtt(playerId, notifyPlayerIds, key, value, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_addPlayerAtt(String playerId, String notifyPlayerIds, String key, int value, Callback __cb) {
/*   54 */     return begin_addPlayerAtt(playerId, notifyPlayerIds, key, value, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_addPlayerAtt(String playerId, String notifyPlayerIds, String key, int value, Map<String, String> __ctx, Callback __cb) {
/*   59 */     return begin_addPlayerAtt(playerId, notifyPlayerIds, key, value, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_addPlayerAtt(String playerId, String notifyPlayerIds, String key, int value, Callback_XmdsManager_addPlayerAtt __cb) {
/*   64 */     return begin_addPlayerAtt(playerId, notifyPlayerIds, key, value, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_addPlayerAtt(String playerId, String notifyPlayerIds, String key, int value, Map<String, String> __ctx, Callback_XmdsManager_addPlayerAtt __cb) {
/*   69 */     return begin_addPlayerAtt(playerId, notifyPlayerIds, key, value, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_addPlayerAtt(String playerId, String notifyPlayerIds, String key, int value, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/*   79 */     return begin_addPlayerAtt(playerId, notifyPlayerIds, key, value, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_addPlayerAtt(String playerId, String notifyPlayerIds, String key, int value, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/*   90 */     return begin_addPlayerAtt(playerId, notifyPlayerIds, key, value, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_addPlayerAtt(String playerId, String notifyPlayerIds, String key, int value, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/*  101 */     return begin_addPlayerAtt(playerId, notifyPlayerIds, key, value, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_addPlayerAtt(String playerId, String notifyPlayerIds, String key, int value, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/*  113 */     return begin_addPlayerAtt(playerId, notifyPlayerIds, key, value, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_addPlayerAtt(String playerId, String notifyPlayerIds, String key, int value, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/*  127 */     return begin_addPlayerAtt(playerId, notifyPlayerIds, key, value, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_addPlayerAtt(String playerId, String notifyPlayerIds, String key, int value, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/*  146 */     OutgoingAsync __result = getOutgoingAsync("addPlayerAtt", __cb);
/*      */     
/*      */     try {
/*  149 */       __result.prepare("addPlayerAtt", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/*  150 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/*  151 */       __os.writeString(playerId);
/*  152 */       __os.writeString(notifyPlayerIds);
/*  153 */       __os.writeString(key);
/*  154 */       __os.writeInt(value);
/*  155 */       __result.endWriteParams();
/*  156 */       __result.invoke();
/*      */     }
/*  158 */     catch (Exception __ex) {
/*      */       
/*  160 */       __result.abort(__ex);
/*      */     } 
/*  162 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end_addPlayerAtt(AsyncResult __iresult) {
/*  167 */     __end(__iresult, "addPlayerAtt");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int addUnit(String instanceId, int unitTemplateID, String data) {
/*  174 */     return addUnit(instanceId, unitTemplateID, data, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public int addUnit(String instanceId, int unitTemplateID, String data, Map<String, String> __ctx) {
/*  179 */     return addUnit(instanceId, unitTemplateID, data, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private int addUnit(String instanceId, int unitTemplateID, String data, Map<String, String> __ctx, boolean __explicitCtx) {
/*  184 */     __checkTwowayOnly("addUnit");
/*  185 */     return end_addUnit(begin_addUnit(instanceId, unitTemplateID, data, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_addUnit(String instanceId, int unitTemplateID, String data) {
/*  190 */     return begin_addUnit(instanceId, unitTemplateID, data, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_addUnit(String instanceId, int unitTemplateID, String data, Map<String, String> __ctx) {
/*  195 */     return begin_addUnit(instanceId, unitTemplateID, data, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_addUnit(String instanceId, int unitTemplateID, String data, Callback __cb) {
/*  200 */     return begin_addUnit(instanceId, unitTemplateID, data, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_addUnit(String instanceId, int unitTemplateID, String data, Map<String, String> __ctx, Callback __cb) {
/*  205 */     return begin_addUnit(instanceId, unitTemplateID, data, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_addUnit(String instanceId, int unitTemplateID, String data, Callback_XmdsManager_addUnit __cb) {
/*  210 */     return begin_addUnit(instanceId, unitTemplateID, data, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_addUnit(String instanceId, int unitTemplateID, String data, Map<String, String> __ctx, Callback_XmdsManager_addUnit __cb) {
/*  215 */     return begin_addUnit(instanceId, unitTemplateID, data, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_addUnit(String instanceId, int unitTemplateID, String data, Functional_IntCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/*  224 */     return begin_addUnit(instanceId, unitTemplateID, data, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_addUnit(String instanceId, int unitTemplateID, String data, Functional_IntCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/*  234 */     return begin_addUnit(instanceId, unitTemplateID, data, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_addUnit(String instanceId, int unitTemplateID, String data, Map<String, String> __ctx, Functional_IntCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/*  244 */     return begin_addUnit(instanceId, unitTemplateID, data, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_addUnit(String instanceId, int unitTemplateID, String data, Map<String, String> __ctx, Functional_IntCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/*  255 */     return begin_addUnit(instanceId, unitTemplateID, data, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_addUnit(String instanceId, int unitTemplateID, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_IntCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/*  268 */     return begin_addUnit(instanceId, unitTemplateID, data, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_TwowayCallbackInt(__responseCb, __exceptionCb, __sentCb)
/*      */         {
/*      */           
/*      */           public final void __completed(AsyncResult __result)
/*      */           {
/*  273 */             XmdsManagerPrxHelper.__addUnit_completed((TwowayCallbackInt)this, __result);
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_addUnit(String instanceId, int unitTemplateID, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/*  286 */     __checkAsyncTwowayOnly("addUnit");
/*  287 */     OutgoingAsync __result = getOutgoingAsync("addUnit", __cb);
/*      */     
/*      */     try {
/*  290 */       __result.prepare("addUnit", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/*  291 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/*  292 */       __os.writeString(instanceId);
/*  293 */       __os.writeInt(unitTemplateID);
/*  294 */       __os.writeString(data);
/*  295 */       __result.endWriteParams();
/*  296 */       __result.invoke();
/*      */     }
/*  298 */     catch (Exception __ex) {
/*      */       
/*  300 */       __result.abort(__ex);
/*      */     } 
/*  302 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public int end_addUnit(AsyncResult __iresult) {
/*  307 */     OutgoingAsync __result = OutgoingAsync.check(__iresult, this, "addUnit");
/*      */     
/*      */     try {
/*  310 */       if (!__result.__wait()) {
/*      */         
/*      */         try {
/*      */           
/*  314 */           __result.throwUserException();
/*      */         }
/*  316 */         catch (UserException __ex) {
/*      */           
/*  318 */           throw new UnknownUserException(__ex.ice_name(), __ex);
/*      */         } 
/*      */       }
/*  321 */       BasicStream __is = __result.startReadParams();
/*      */       
/*  323 */       int __ret = __is.readInt();
/*  324 */       __result.endReadParams();
/*  325 */       return __ret;
/*      */     }
/*      */     finally {
/*      */       
/*  329 */       if (__result != null)
/*      */       {
/*  331 */         __result.cacheMessageBuffers();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void __addUnit_completed(TwowayCallbackInt __cb, AsyncResult __result) {
/*  338 */     XmdsManagerPrx __proxy = (XmdsManagerPrx)__result.getProxy();
/*  339 */     int __ret = 0;
/*      */     
/*      */     try {
/*  342 */       __ret = __proxy.end_addUnit(__result);
/*      */     }
/*  344 */     catch (LocalException __ex) {
/*      */       
/*  346 */       __cb.exception(__ex);
/*      */       
/*      */       return;
/*  349 */     } catch (SystemException __ex) {
/*      */       
/*  351 */       __cb.exception(__ex);
/*      */       return;
/*      */     } 
/*  354 */     __cb.response(__ret);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addUnits(String instanceId, String data) {
/*  361 */     addUnits(instanceId, data, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void addUnits(String instanceId, String data, Map<String, String> __ctx) {
/*  366 */     addUnits(instanceId, data, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void addUnits(String instanceId, String data, Map<String, String> __ctx, boolean __explicitCtx) {
/*  371 */     end_addUnits(begin_addUnits(instanceId, data, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_addUnits(String instanceId, String data) {
/*  376 */     return begin_addUnits(instanceId, data, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_addUnits(String instanceId, String data, Map<String, String> __ctx) {
/*  381 */     return begin_addUnits(instanceId, data, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_addUnits(String instanceId, String data, Callback __cb) {
/*  386 */     return begin_addUnits(instanceId, data, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_addUnits(String instanceId, String data, Map<String, String> __ctx, Callback __cb) {
/*  391 */     return begin_addUnits(instanceId, data, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_addUnits(String instanceId, String data, Callback_XmdsManager_addUnits __cb) {
/*  396 */     return begin_addUnits(instanceId, data, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_addUnits(String instanceId, String data, Map<String, String> __ctx, Callback_XmdsManager_addUnits __cb) {
/*  401 */     return begin_addUnits(instanceId, data, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_addUnits(String instanceId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/*  409 */     return begin_addUnits(instanceId, data, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_addUnits(String instanceId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/*  418 */     return begin_addUnits(instanceId, data, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_addUnits(String instanceId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/*  427 */     return begin_addUnits(instanceId, data, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_addUnits(String instanceId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/*  437 */     return begin_addUnits(instanceId, data, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_addUnits(String instanceId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/*  449 */     return begin_addUnits(instanceId, data, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_addUnits(String instanceId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/*  464 */     OutgoingAsync __result = getOutgoingAsync("addUnits", __cb);
/*      */     
/*      */     try {
/*  467 */       __result.prepare("addUnits", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/*  468 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/*  469 */       __os.writeString(instanceId);
/*  470 */       __os.writeString(data);
/*  471 */       __result.endWriteParams();
/*  472 */       __result.invoke();
/*      */     }
/*  474 */     catch (Exception __ex) {
/*      */       
/*  476 */       __result.abort(__ex);
/*      */     } 
/*  478 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end_addUnits(AsyncResult __iresult) {
/*  483 */     __end(__iresult, "addUnits");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void autoBattle(String instanceId, String playerId, boolean enable) {
/*  490 */     autoBattle(instanceId, playerId, enable, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void autoBattle(String instanceId, String playerId, boolean enable, Map<String, String> __ctx) {
/*  495 */     autoBattle(instanceId, playerId, enable, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void autoBattle(String instanceId, String playerId, boolean enable, Map<String, String> __ctx, boolean __explicitCtx) {
/*  500 */     end_autoBattle(begin_autoBattle(instanceId, playerId, enable, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_autoBattle(String instanceId, String playerId, boolean enable) {
/*  505 */     return begin_autoBattle(instanceId, playerId, enable, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_autoBattle(String instanceId, String playerId, boolean enable, Map<String, String> __ctx) {
/*  510 */     return begin_autoBattle(instanceId, playerId, enable, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_autoBattle(String instanceId, String playerId, boolean enable, Callback __cb) {
/*  515 */     return begin_autoBattle(instanceId, playerId, enable, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_autoBattle(String instanceId, String playerId, boolean enable, Map<String, String> __ctx, Callback __cb) {
/*  520 */     return begin_autoBattle(instanceId, playerId, enable, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_autoBattle(String instanceId, String playerId, boolean enable, Callback_XmdsManager_autoBattle __cb) {
/*  525 */     return begin_autoBattle(instanceId, playerId, enable, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_autoBattle(String instanceId, String playerId, boolean enable, Map<String, String> __ctx, Callback_XmdsManager_autoBattle __cb) {
/*  530 */     return begin_autoBattle(instanceId, playerId, enable, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_autoBattle(String instanceId, String playerId, boolean enable, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/*  539 */     return begin_autoBattle(instanceId, playerId, enable, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_autoBattle(String instanceId, String playerId, boolean enable, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/*  549 */     return begin_autoBattle(instanceId, playerId, enable, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_autoBattle(String instanceId, String playerId, boolean enable, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/*  559 */     return begin_autoBattle(instanceId, playerId, enable, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_autoBattle(String instanceId, String playerId, boolean enable, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/*  570 */     return begin_autoBattle(instanceId, playerId, enable, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_autoBattle(String instanceId, String playerId, boolean enable, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/*  583 */     return begin_autoBattle(instanceId, playerId, enable, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_autoBattle(String instanceId, String playerId, boolean enable, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/*  600 */     OutgoingAsync __result = getOutgoingAsync("autoBattle", __cb);
/*      */     
/*      */     try {
/*  603 */       __result.prepare("autoBattle", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/*  604 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/*  605 */       __os.writeString(instanceId);
/*  606 */       __os.writeString(playerId);
/*  607 */       __os.writeBool(enable);
/*  608 */       __result.endWriteParams();
/*  609 */       __result.invoke();
/*      */     }
/*  611 */     catch (Exception __ex) {
/*      */       
/*  613 */       __result.abort(__ex);
/*      */     } 
/*  615 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end_autoBattle(AsyncResult __iresult) {
/*  620 */     __end(__iresult, "autoBattle");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String canTalkWithNpc(String playerId, int npcId) {
/*  627 */     return canTalkWithNpc(playerId, npcId, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public String canTalkWithNpc(String playerId, int npcId, Map<String, String> __ctx) {
/*  632 */     return canTalkWithNpc(playerId, npcId, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private String canTalkWithNpc(String playerId, int npcId, Map<String, String> __ctx, boolean __explicitCtx) {
/*  637 */     __checkTwowayOnly("canTalkWithNpc");
/*  638 */     return end_canTalkWithNpc(begin_canTalkWithNpc(playerId, npcId, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_canTalkWithNpc(String playerId, int npcId) {
/*  643 */     return begin_canTalkWithNpc(playerId, npcId, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_canTalkWithNpc(String playerId, int npcId, Map<String, String> __ctx) {
/*  648 */     return begin_canTalkWithNpc(playerId, npcId, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_canTalkWithNpc(String playerId, int npcId, Callback __cb) {
/*  653 */     return begin_canTalkWithNpc(playerId, npcId, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_canTalkWithNpc(String playerId, int npcId, Map<String, String> __ctx, Callback __cb) {
/*  658 */     return begin_canTalkWithNpc(playerId, npcId, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_canTalkWithNpc(String playerId, int npcId, Callback_XmdsManager_canTalkWithNpc __cb) {
/*  663 */     return begin_canTalkWithNpc(playerId, npcId, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_canTalkWithNpc(String playerId, int npcId, Map<String, String> __ctx, Callback_XmdsManager_canTalkWithNpc __cb) {
/*  668 */     return begin_canTalkWithNpc(playerId, npcId, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_canTalkWithNpc(String playerId, int npcId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/*  676 */     return begin_canTalkWithNpc(playerId, npcId, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_canTalkWithNpc(String playerId, int npcId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/*  685 */     return begin_canTalkWithNpc(playerId, npcId, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_canTalkWithNpc(String playerId, int npcId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/*  694 */     return begin_canTalkWithNpc(playerId, npcId, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_canTalkWithNpc(String playerId, int npcId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/*  704 */     return begin_canTalkWithNpc(playerId, npcId, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_canTalkWithNpc(String playerId, int npcId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/*  716 */     return begin_canTalkWithNpc(playerId, npcId, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_TwowayCallbackArg1<String>(__responseCb, __exceptionCb, __sentCb)
/*      */         {
/*      */           
/*      */           public final void __completed(AsyncResult __result)
/*      */           {
/*  721 */             XmdsManagerPrxHelper.__canTalkWithNpc_completed((TwowayCallbackArg1<String>)this, __result);
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_canTalkWithNpc(String playerId, int npcId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/*  733 */     __checkAsyncTwowayOnly("canTalkWithNpc");
/*  734 */     OutgoingAsync __result = getOutgoingAsync("canTalkWithNpc", __cb);
/*      */     
/*      */     try {
/*  737 */       __result.prepare("canTalkWithNpc", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/*  738 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/*  739 */       __os.writeString(playerId);
/*  740 */       __os.writeInt(npcId);
/*  741 */       __result.endWriteParams();
/*  742 */       __result.invoke();
/*      */     }
/*  744 */     catch (Exception __ex) {
/*      */       
/*  746 */       __result.abort(__ex);
/*      */     } 
/*  748 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public String end_canTalkWithNpc(AsyncResult __iresult) {
/*  753 */     OutgoingAsync __result = OutgoingAsync.check(__iresult, this, "canTalkWithNpc");
/*      */     
/*      */     try {
/*  756 */       if (!__result.__wait()) {
/*      */         
/*      */         try {
/*      */           
/*  760 */           __result.throwUserException();
/*      */         }
/*  762 */         catch (UserException __ex) {
/*      */           
/*  764 */           throw new UnknownUserException(__ex.ice_name(), __ex);
/*      */         } 
/*      */       }
/*  767 */       BasicStream __is = __result.startReadParams();
/*      */       
/*  769 */       String __ret = __is.readString();
/*  770 */       __result.endReadParams();
/*  771 */       return __ret;
/*      */     }
/*      */     finally {
/*      */       
/*  775 */       if (__result != null)
/*      */       {
/*  777 */         __result.cacheMessageBuffers();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void __canTalkWithNpc_completed(TwowayCallbackArg1<String> __cb, AsyncResult __result) {
/*  784 */     XmdsManagerPrx __proxy = (XmdsManagerPrx)__result.getProxy();
/*  785 */     String __ret = null;
/*      */     
/*      */     try {
/*  788 */       __ret = __proxy.end_canTalkWithNpc(__result);
/*      */     }
/*  790 */     catch (LocalException __ex) {
/*      */       
/*  792 */       __cb.exception(__ex);
/*      */       
/*      */       return;
/*  795 */     } catch (SystemException __ex) {
/*      */       
/*  797 */       __cb.exception(__ex);
/*      */       return;
/*      */     } 
/*  800 */     __cb.response(__ret);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canUseItem(String playerId) {
/*  807 */     return canUseItem(playerId, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean canUseItem(String playerId, Map<String, String> __ctx) {
/*  812 */     return canUseItem(playerId, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean canUseItem(String playerId, Map<String, String> __ctx, boolean __explicitCtx) {
/*  817 */     __checkTwowayOnly("canUseItem");
/*  818 */     return end_canUseItem(begin_canUseItem(playerId, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_canUseItem(String playerId) {
/*  823 */     return begin_canUseItem(playerId, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_canUseItem(String playerId, Map<String, String> __ctx) {
/*  828 */     return begin_canUseItem(playerId, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_canUseItem(String playerId, Callback __cb) {
/*  833 */     return begin_canUseItem(playerId, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_canUseItem(String playerId, Map<String, String> __ctx, Callback __cb) {
/*  838 */     return begin_canUseItem(playerId, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_canUseItem(String playerId, Callback_XmdsManager_canUseItem __cb) {
/*  843 */     return begin_canUseItem(playerId, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_canUseItem(String playerId, Map<String, String> __ctx, Callback_XmdsManager_canUseItem __cb) {
/*  848 */     return begin_canUseItem(playerId, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_canUseItem(String playerId, Functional_BoolCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/*  855 */     return begin_canUseItem(playerId, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_canUseItem(String playerId, Functional_BoolCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/*  863 */     return begin_canUseItem(playerId, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_canUseItem(String playerId, Map<String, String> __ctx, Functional_BoolCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/*  871 */     return begin_canUseItem(playerId, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_canUseItem(String playerId, Map<String, String> __ctx, Functional_BoolCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/*  880 */     return begin_canUseItem(playerId, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_canUseItem(String playerId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_BoolCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/*  891 */     return begin_canUseItem(playerId, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_TwowayCallbackBool(__responseCb, __exceptionCb, __sentCb)
/*      */         {
/*      */           
/*      */           public final void __completed(AsyncResult __result)
/*      */           {
/*  896 */             XmdsManagerPrxHelper.__canUseItem_completed((TwowayCallbackBool)this, __result);
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_canUseItem(String playerId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/*  907 */     __checkAsyncTwowayOnly("canUseItem");
/*  908 */     OutgoingAsync __result = getOutgoingAsync("canUseItem", __cb);
/*      */     
/*      */     try {
/*  911 */       __result.prepare("canUseItem", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/*  912 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/*  913 */       __os.writeString(playerId);
/*  914 */       __result.endWriteParams();
/*  915 */       __result.invoke();
/*      */     }
/*  917 */     catch (Exception __ex) {
/*      */       
/*  919 */       __result.abort(__ex);
/*      */     } 
/*  921 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean end_canUseItem(AsyncResult __iresult) {
/*  926 */     OutgoingAsync __result = OutgoingAsync.check(__iresult, this, "canUseItem");
/*      */     
/*      */     try {
/*  929 */       if (!__result.__wait()) {
/*      */         
/*      */         try {
/*      */           
/*  933 */           __result.throwUserException();
/*      */         }
/*  935 */         catch (UserException __ex) {
/*      */           
/*  937 */           throw new UnknownUserException(__ex.ice_name(), __ex);
/*      */         } 
/*      */       }
/*  940 */       BasicStream __is = __result.startReadParams();
/*      */       
/*  942 */       boolean __ret = __is.readBool();
/*  943 */       __result.endReadParams();
/*  944 */       return __ret;
/*      */     }
/*      */     finally {
/*      */       
/*  948 */       if (__result != null)
/*      */       {
/*  950 */         __result.cacheMessageBuffers();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void __canUseItem_completed(TwowayCallbackBool __cb, AsyncResult __result) {
/*  957 */     XmdsManagerPrx __proxy = (XmdsManagerPrx)__result.getProxy();
/*  958 */     boolean __ret = false;
/*      */     
/*      */     try {
/*  961 */       __ret = __proxy.end_canUseItem(__result);
/*      */     }
/*  963 */     catch (LocalException __ex) {
/*      */       
/*  965 */       __cb.exception(__ex);
/*      */       
/*      */       return;
/*  968 */     } catch (SystemException __ex) {
/*      */       
/*  970 */       __cb.exception(__ex);
/*      */       return;
/*      */     } 
/*  973 */     __cb.response(__ret);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAllNpcInfo(String instanceId) {
/*  980 */     return getAllNpcInfo(instanceId, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public String getAllNpcInfo(String instanceId, Map<String, String> __ctx) {
/*  985 */     return getAllNpcInfo(instanceId, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private String getAllNpcInfo(String instanceId, Map<String, String> __ctx, boolean __explicitCtx) {
/*  990 */     __checkTwowayOnly("getAllNpcInfo");
/*  991 */     return end_getAllNpcInfo(begin_getAllNpcInfo(instanceId, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getAllNpcInfo(String instanceId) {
/*  996 */     return begin_getAllNpcInfo(instanceId, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getAllNpcInfo(String instanceId, Map<String, String> __ctx) {
/* 1001 */     return begin_getAllNpcInfo(instanceId, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getAllNpcInfo(String instanceId, Callback __cb) {
/* 1006 */     return begin_getAllNpcInfo(instanceId, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getAllNpcInfo(String instanceId, Map<String, String> __ctx, Callback __cb) {
/* 1011 */     return begin_getAllNpcInfo(instanceId, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getAllNpcInfo(String instanceId, Callback_XmdsManager_getAllNpcInfo __cb) {
/* 1016 */     return begin_getAllNpcInfo(instanceId, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getAllNpcInfo(String instanceId, Map<String, String> __ctx, Callback_XmdsManager_getAllNpcInfo __cb) {
/* 1021 */     return begin_getAllNpcInfo(instanceId, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getAllNpcInfo(String instanceId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 1028 */     return begin_getAllNpcInfo(instanceId, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getAllNpcInfo(String instanceId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 1036 */     return begin_getAllNpcInfo(instanceId, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getAllNpcInfo(String instanceId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 1044 */     return begin_getAllNpcInfo(instanceId, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getAllNpcInfo(String instanceId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 1053 */     return begin_getAllNpcInfo(instanceId, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_getAllNpcInfo(String instanceId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 1064 */     return begin_getAllNpcInfo(instanceId, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_TwowayCallbackArg1<String>(__responseCb, __exceptionCb, __sentCb)
/*      */         {
/*      */           
/*      */           public final void __completed(AsyncResult __result)
/*      */           {
/* 1069 */             XmdsManagerPrxHelper.__getAllNpcInfo_completed((TwowayCallbackArg1<String>)this, __result);
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_getAllNpcInfo(String instanceId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 1080 */     __checkAsyncTwowayOnly("getAllNpcInfo");
/* 1081 */     OutgoingAsync __result = getOutgoingAsync("getAllNpcInfo", __cb);
/*      */     
/*      */     try {
/* 1084 */       __result.prepare("getAllNpcInfo", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 1085 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 1086 */       __os.writeString(instanceId);
/* 1087 */       __result.endWriteParams();
/* 1088 */       __result.invoke();
/*      */     }
/* 1090 */     catch (Exception __ex) {
/*      */       
/* 1092 */       __result.abort(__ex);
/*      */     } 
/* 1094 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public String end_getAllNpcInfo(AsyncResult __iresult) {
/* 1099 */     OutgoingAsync __result = OutgoingAsync.check(__iresult, this, "getAllNpcInfo");
/*      */     
/*      */     try {
/* 1102 */       if (!__result.__wait()) {
/*      */         
/*      */         try {
/*      */           
/* 1106 */           __result.throwUserException();
/*      */         }
/* 1108 */         catch (UserException __ex) {
/*      */           
/* 1110 */           throw new UnknownUserException(__ex.ice_name(), __ex);
/*      */         } 
/*      */       }
/* 1113 */       BasicStream __is = __result.startReadParams();
/*      */       
/* 1115 */       String __ret = __is.readString();
/* 1116 */       __result.endReadParams();
/* 1117 */       return __ret;
/*      */     }
/*      */     finally {
/*      */       
/* 1121 */       if (__result != null)
/*      */       {
/* 1123 */         __result.cacheMessageBuffers();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void __getAllNpcInfo_completed(TwowayCallbackArg1<String> __cb, AsyncResult __result) {
/* 1130 */     XmdsManagerPrx __proxy = (XmdsManagerPrx)__result.getProxy();
/* 1131 */     String __ret = null;
/*      */     
/*      */     try {
/* 1134 */       __ret = __proxy.end_getAllNpcInfo(__result);
/*      */     }
/* 1136 */     catch (LocalException __ex) {
/*      */       
/* 1138 */       __cb.exception(__ex);
/*      */       
/*      */       return;
/* 1141 */     } catch (SystemException __ex) {
/*      */       
/* 1143 */       __cb.exception(__ex);
/*      */       return;
/*      */     } 
/* 1146 */     __cb.response(__ret);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAllPlayerUUID() {
/* 1153 */     return getAllPlayerUUID((Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public String getAllPlayerUUID(Map<String, String> __ctx) {
/* 1158 */     return getAllPlayerUUID(__ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private String getAllPlayerUUID(Map<String, String> __ctx, boolean __explicitCtx) {
/* 1163 */     __checkTwowayOnly("getAllPlayerUUID");
/* 1164 */     return end_getAllPlayerUUID(begin_getAllPlayerUUID(__ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getAllPlayerUUID() {
/* 1169 */     return begin_getAllPlayerUUID((Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getAllPlayerUUID(Map<String, String> __ctx) {
/* 1174 */     return begin_getAllPlayerUUID(__ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getAllPlayerUUID(Callback __cb) {
/* 1179 */     return begin_getAllPlayerUUID((Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getAllPlayerUUID(Map<String, String> __ctx, Callback __cb) {
/* 1184 */     return begin_getAllPlayerUUID(__ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getAllPlayerUUID(Callback_XmdsManager_getAllPlayerUUID __cb) {
/* 1189 */     return begin_getAllPlayerUUID((Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getAllPlayerUUID(Map<String, String> __ctx, Callback_XmdsManager_getAllPlayerUUID __cb) {
/* 1194 */     return begin_getAllPlayerUUID(__ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getAllPlayerUUID(Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 1200 */     return begin_getAllPlayerUUID((Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getAllPlayerUUID(Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 1207 */     return begin_getAllPlayerUUID((Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getAllPlayerUUID(Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 1214 */     return begin_getAllPlayerUUID(__ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getAllPlayerUUID(Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 1222 */     return begin_getAllPlayerUUID(__ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_getAllPlayerUUID(Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 1232 */     return begin_getAllPlayerUUID(__ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_TwowayCallbackArg1<String>(__responseCb, __exceptionCb, __sentCb)
/*      */         {
/*      */           
/*      */           public final void __completed(AsyncResult __result)
/*      */           {
/* 1237 */             XmdsManagerPrxHelper.__getAllPlayerUUID_completed((TwowayCallbackArg1<String>)this, __result);
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_getAllPlayerUUID(Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 1247 */     __checkAsyncTwowayOnly("getAllPlayerUUID");
/* 1248 */     OutgoingAsync __result = getOutgoingAsync("getAllPlayerUUID", __cb);
/*      */     
/*      */     try {
/* 1251 */       __result.prepare("getAllPlayerUUID", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 1252 */       __result.writeEmptyParams();
/* 1253 */       __result.invoke();
/*      */     }
/* 1255 */     catch (Exception __ex) {
/*      */       
/* 1257 */       __result.abort(__ex);
/*      */     } 
/* 1259 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public String end_getAllPlayerUUID(AsyncResult __iresult) {
/* 1264 */     OutgoingAsync __result = OutgoingAsync.check(__iresult, this, "getAllPlayerUUID");
/*      */     
/*      */     try {
/* 1267 */       if (!__result.__wait()) {
/*      */         
/*      */         try {
/*      */           
/* 1271 */           __result.throwUserException();
/*      */         }
/* 1273 */         catch (UserException __ex) {
/*      */           
/* 1275 */           throw new UnknownUserException(__ex.ice_name(), __ex);
/*      */         } 
/*      */       }
/* 1278 */       BasicStream __is = __result.startReadParams();
/*      */       
/* 1280 */       String __ret = __is.readString();
/* 1281 */       __result.endReadParams();
/* 1282 */       return __ret;
/*      */     }
/*      */     finally {
/*      */       
/* 1286 */       if (__result != null)
/*      */       {
/* 1288 */         __result.cacheMessageBuffers();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void __getAllPlayerUUID_completed(TwowayCallbackArg1<String> __cb, AsyncResult __result) {
/* 1295 */     XmdsManagerPrx __proxy = (XmdsManagerPrx)__result.getProxy();
/* 1296 */     String __ret = null;
/*      */     
/*      */     try {
/* 1299 */       __ret = __proxy.end_getAllPlayerUUID(__result);
/*      */     }
/* 1301 */     catch (LocalException __ex) {
/*      */       
/* 1303 */       __cb.exception(__ex);
/*      */       
/*      */       return;
/* 1306 */     } catch (SystemException __ex) {
/*      */       
/* 1308 */       __cb.exception(__ex);
/*      */       return;
/*      */     } 
/* 1311 */     __cb.response(__ret);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAllUnitInfo(String instanceId) {
/* 1318 */     return getAllUnitInfo(instanceId, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public String getAllUnitInfo(String instanceId, Map<String, String> __ctx) {
/* 1323 */     return getAllUnitInfo(instanceId, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private String getAllUnitInfo(String instanceId, Map<String, String> __ctx, boolean __explicitCtx) {
/* 1328 */     __checkTwowayOnly("getAllUnitInfo");
/* 1329 */     return end_getAllUnitInfo(begin_getAllUnitInfo(instanceId, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getAllUnitInfo(String instanceId) {
/* 1334 */     return begin_getAllUnitInfo(instanceId, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getAllUnitInfo(String instanceId, Map<String, String> __ctx) {
/* 1339 */     return begin_getAllUnitInfo(instanceId, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getAllUnitInfo(String instanceId, Callback __cb) {
/* 1344 */     return begin_getAllUnitInfo(instanceId, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getAllUnitInfo(String instanceId, Map<String, String> __ctx, Callback __cb) {
/* 1349 */     return begin_getAllUnitInfo(instanceId, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getAllUnitInfo(String instanceId, Callback_XmdsManager_getAllUnitInfo __cb) {
/* 1354 */     return begin_getAllUnitInfo(instanceId, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getAllUnitInfo(String instanceId, Map<String, String> __ctx, Callback_XmdsManager_getAllUnitInfo __cb) {
/* 1359 */     return begin_getAllUnitInfo(instanceId, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getAllUnitInfo(String instanceId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 1366 */     return begin_getAllUnitInfo(instanceId, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getAllUnitInfo(String instanceId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 1374 */     return begin_getAllUnitInfo(instanceId, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getAllUnitInfo(String instanceId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 1382 */     return begin_getAllUnitInfo(instanceId, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getAllUnitInfo(String instanceId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 1391 */     return begin_getAllUnitInfo(instanceId, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_getAllUnitInfo(String instanceId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 1402 */     return begin_getAllUnitInfo(instanceId, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_TwowayCallbackArg1<String>(__responseCb, __exceptionCb, __sentCb)
/*      */         {
/*      */           
/*      */           public final void __completed(AsyncResult __result)
/*      */           {
/* 1407 */             XmdsManagerPrxHelper.__getAllUnitInfo_completed((TwowayCallbackArg1<String>)this, __result);
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_getAllUnitInfo(String instanceId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 1418 */     __checkAsyncTwowayOnly("getAllUnitInfo");
/* 1419 */     OutgoingAsync __result = getOutgoingAsync("getAllUnitInfo", __cb);
/*      */     
/*      */     try {
/* 1422 */       __result.prepare("getAllUnitInfo", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 1423 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 1424 */       __os.writeString(instanceId);
/* 1425 */       __result.endWriteParams();
/* 1426 */       __result.invoke();
/*      */     }
/* 1428 */     catch (Exception __ex) {
/*      */       
/* 1430 */       __result.abort(__ex);
/*      */     } 
/* 1432 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public String end_getAllUnitInfo(AsyncResult __iresult) {
/* 1437 */     OutgoingAsync __result = OutgoingAsync.check(__iresult, this, "getAllUnitInfo");
/*      */     
/*      */     try {
/* 1440 */       if (!__result.__wait()) {
/*      */         
/*      */         try {
/*      */           
/* 1444 */           __result.throwUserException();
/*      */         }
/* 1446 */         catch (UserException __ex) {
/*      */           
/* 1448 */           throw new UnknownUserException(__ex.ice_name(), __ex);
/*      */         } 
/*      */       }
/* 1451 */       BasicStream __is = __result.startReadParams();
/*      */       
/* 1453 */       String __ret = __is.readString();
/* 1454 */       __result.endReadParams();
/* 1455 */       return __ret;
/*      */     }
/*      */     finally {
/*      */       
/* 1459 */       if (__result != null)
/*      */       {
/* 1461 */         __result.cacheMessageBuffers();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void __getAllUnitInfo_completed(TwowayCallbackArg1<String> __cb, AsyncResult __result) {
/* 1468 */     XmdsManagerPrx __proxy = (XmdsManagerPrx)__result.getProxy();
/* 1469 */     String __ret = null;
/*      */     
/*      */     try {
/* 1472 */       __ret = __proxy.end_getAllUnitInfo(__result);
/*      */     }
/* 1474 */     catch (LocalException __ex) {
/*      */       
/* 1476 */       __cb.exception(__ex);
/*      */       
/*      */       return;
/* 1479 */     } catch (SystemException __ex) {
/*      */       
/* 1481 */       __cb.exception(__ex);
/*      */       return;
/*      */     } 
/* 1484 */     __cb.response(__ret);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getBornPlace(String instanceId, int areaId) {
/* 1491 */     return getBornPlace(instanceId, areaId, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public String getBornPlace(String instanceId, int areaId, Map<String, String> __ctx) {
/* 1496 */     return getBornPlace(instanceId, areaId, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private String getBornPlace(String instanceId, int areaId, Map<String, String> __ctx, boolean __explicitCtx) {
/* 1501 */     __checkTwowayOnly("getBornPlace");
/* 1502 */     return end_getBornPlace(begin_getBornPlace(instanceId, areaId, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getBornPlace(String instanceId, int areaId) {
/* 1507 */     return begin_getBornPlace(instanceId, areaId, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getBornPlace(String instanceId, int areaId, Map<String, String> __ctx) {
/* 1512 */     return begin_getBornPlace(instanceId, areaId, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getBornPlace(String instanceId, int areaId, Callback __cb) {
/* 1517 */     return begin_getBornPlace(instanceId, areaId, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getBornPlace(String instanceId, int areaId, Map<String, String> __ctx, Callback __cb) {
/* 1522 */     return begin_getBornPlace(instanceId, areaId, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getBornPlace(String instanceId, int areaId, Callback_XmdsManager_getBornPlace __cb) {
/* 1527 */     return begin_getBornPlace(instanceId, areaId, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getBornPlace(String instanceId, int areaId, Map<String, String> __ctx, Callback_XmdsManager_getBornPlace __cb) {
/* 1532 */     return begin_getBornPlace(instanceId, areaId, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getBornPlace(String instanceId, int areaId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 1540 */     return begin_getBornPlace(instanceId, areaId, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getBornPlace(String instanceId, int areaId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 1549 */     return begin_getBornPlace(instanceId, areaId, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getBornPlace(String instanceId, int areaId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 1558 */     return begin_getBornPlace(instanceId, areaId, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getBornPlace(String instanceId, int areaId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 1568 */     return begin_getBornPlace(instanceId, areaId, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_getBornPlace(String instanceId, int areaId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 1580 */     return begin_getBornPlace(instanceId, areaId, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_TwowayCallbackArg1<String>(__responseCb, __exceptionCb, __sentCb)
/*      */         {
/*      */           
/*      */           public final void __completed(AsyncResult __result)
/*      */           {
/* 1585 */             XmdsManagerPrxHelper.__getBornPlace_completed((TwowayCallbackArg1<String>)this, __result);
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_getBornPlace(String instanceId, int areaId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 1597 */     __checkAsyncTwowayOnly("getBornPlace");
/* 1598 */     OutgoingAsync __result = getOutgoingAsync("getBornPlace", __cb);
/*      */     
/*      */     try {
/* 1601 */       __result.prepare("getBornPlace", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 1602 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 1603 */       __os.writeString(instanceId);
/* 1604 */       __os.writeInt(areaId);
/* 1605 */       __result.endWriteParams();
/* 1606 */       __result.invoke();
/*      */     }
/* 1608 */     catch (Exception __ex) {
/*      */       
/* 1610 */       __result.abort(__ex);
/*      */     } 
/* 1612 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public String end_getBornPlace(AsyncResult __iresult) {
/* 1617 */     OutgoingAsync __result = OutgoingAsync.check(__iresult, this, "getBornPlace");
/*      */     
/*      */     try {
/* 1620 */       if (!__result.__wait()) {
/*      */         
/*      */         try {
/*      */           
/* 1624 */           __result.throwUserException();
/*      */         }
/* 1626 */         catch (UserException __ex) {
/*      */           
/* 1628 */           throw new UnknownUserException(__ex.ice_name(), __ex);
/*      */         } 
/*      */       }
/* 1631 */       BasicStream __is = __result.startReadParams();
/*      */       
/* 1633 */       String __ret = __is.readString();
/* 1634 */       __result.endReadParams();
/* 1635 */       return __ret;
/*      */     }
/*      */     finally {
/*      */       
/* 1639 */       if (__result != null)
/*      */       {
/* 1641 */         __result.cacheMessageBuffers();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void __getBornPlace_completed(TwowayCallbackArg1<String> __cb, AsyncResult __result) {
/* 1648 */     XmdsManagerPrx __proxy = (XmdsManagerPrx)__result.getProxy();
/* 1649 */     String __ret = null;
/*      */     
/*      */     try {
/* 1652 */       __ret = __proxy.end_getBornPlace(__result);
/*      */     }
/* 1654 */     catch (LocalException __ex) {
/*      */       
/* 1656 */       __cb.exception(__ex);
/*      */       
/*      */       return;
/* 1659 */     } catch (SystemException __ex) {
/*      */       
/* 1661 */       __cb.exception(__ex);
/*      */       return;
/*      */     } 
/* 1664 */     __cb.response(__ret);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getInstanceStatistic(String instanceId) {
/* 1671 */     return getInstanceStatistic(instanceId, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public String getInstanceStatistic(String instanceId, Map<String, String> __ctx) {
/* 1676 */     return getInstanceStatistic(instanceId, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private String getInstanceStatistic(String instanceId, Map<String, String> __ctx, boolean __explicitCtx) {
/* 1681 */     __checkTwowayOnly("getInstanceStatistic");
/* 1682 */     return end_getInstanceStatistic(begin_getInstanceStatistic(instanceId, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getInstanceStatistic(String instanceId) {
/* 1687 */     return begin_getInstanceStatistic(instanceId, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getInstanceStatistic(String instanceId, Map<String, String> __ctx) {
/* 1692 */     return begin_getInstanceStatistic(instanceId, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getInstanceStatistic(String instanceId, Callback __cb) {
/* 1697 */     return begin_getInstanceStatistic(instanceId, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getInstanceStatistic(String instanceId, Map<String, String> __ctx, Callback __cb) {
/* 1702 */     return begin_getInstanceStatistic(instanceId, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getInstanceStatistic(String instanceId, Callback_XmdsManager_getInstanceStatistic __cb) {
/* 1707 */     return begin_getInstanceStatistic(instanceId, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getInstanceStatistic(String instanceId, Map<String, String> __ctx, Callback_XmdsManager_getInstanceStatistic __cb) {
/* 1712 */     return begin_getInstanceStatistic(instanceId, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getInstanceStatistic(String instanceId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 1719 */     return begin_getInstanceStatistic(instanceId, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getInstanceStatistic(String instanceId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 1727 */     return begin_getInstanceStatistic(instanceId, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getInstanceStatistic(String instanceId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 1735 */     return begin_getInstanceStatistic(instanceId, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getInstanceStatistic(String instanceId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 1744 */     return begin_getInstanceStatistic(instanceId, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_getInstanceStatistic(String instanceId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 1755 */     return begin_getInstanceStatistic(instanceId, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_TwowayCallbackArg1<String>(__responseCb, __exceptionCb, __sentCb)
/*      */         {
/*      */           
/*      */           public final void __completed(AsyncResult __result)
/*      */           {
/* 1760 */             XmdsManagerPrxHelper.__getInstanceStatistic_completed((TwowayCallbackArg1<String>)this, __result);
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_getInstanceStatistic(String instanceId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 1771 */     __checkAsyncTwowayOnly("getInstanceStatistic");
/* 1772 */     OutgoingAsync __result = getOutgoingAsync("getInstanceStatistic", __cb);
/*      */     
/*      */     try {
/* 1775 */       __result.prepare("getInstanceStatistic", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 1776 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 1777 */       __os.writeString(instanceId);
/* 1778 */       __result.endWriteParams();
/* 1779 */       __result.invoke();
/*      */     }
/* 1781 */     catch (Exception __ex) {
/*      */       
/* 1783 */       __result.abort(__ex);
/*      */     } 
/* 1785 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public String end_getInstanceStatistic(AsyncResult __iresult) {
/* 1790 */     OutgoingAsync __result = OutgoingAsync.check(__iresult, this, "getInstanceStatistic");
/*      */     
/*      */     try {
/* 1793 */       if (!__result.__wait()) {
/*      */         
/*      */         try {
/*      */           
/* 1797 */           __result.throwUserException();
/*      */         }
/* 1799 */         catch (UserException __ex) {
/*      */           
/* 1801 */           throw new UnknownUserException(__ex.ice_name(), __ex);
/*      */         } 
/*      */       }
/* 1804 */       BasicStream __is = __result.startReadParams();
/*      */       
/* 1806 */       String __ret = __is.readString();
/* 1807 */       __result.endReadParams();
/* 1808 */       return __ret;
/*      */     }
/*      */     finally {
/*      */       
/* 1812 */       if (__result != null)
/*      */       {
/* 1814 */         __result.cacheMessageBuffers();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void __getInstanceStatistic_completed(TwowayCallbackArg1<String> __cb, AsyncResult __result) {
/* 1821 */     XmdsManagerPrx __proxy = (XmdsManagerPrx)__result.getProxy();
/* 1822 */     String __ret = null;
/*      */     
/*      */     try {
/* 1825 */       __ret = __proxy.end_getInstanceStatistic(__result);
/*      */     }
/* 1827 */     catch (LocalException __ex) {
/*      */       
/* 1829 */       __cb.exception(__ex);
/*      */       
/*      */       return;
/* 1832 */     } catch (SystemException __ex) {
/*      */       
/* 1834 */       __cb.exception(__ex);
/*      */       return;
/*      */     } 
/* 1837 */     __cb.response(__ret);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPlayerData(String playerId, boolean changeArea) {
/* 1844 */     return getPlayerData(playerId, changeArea, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public String getPlayerData(String playerId, boolean changeArea, Map<String, String> __ctx) {
/* 1849 */     return getPlayerData(playerId, changeArea, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private String getPlayerData(String playerId, boolean changeArea, Map<String, String> __ctx, boolean __explicitCtx) {
/* 1854 */     __checkTwowayOnly("getPlayerData");
/* 1855 */     return end_getPlayerData(begin_getPlayerData(playerId, changeArea, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerData(String playerId, boolean changeArea) {
/* 1860 */     return begin_getPlayerData(playerId, changeArea, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerData(String playerId, boolean changeArea, Map<String, String> __ctx) {
/* 1865 */     return begin_getPlayerData(playerId, changeArea, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerData(String playerId, boolean changeArea, Callback __cb) {
/* 1870 */     return begin_getPlayerData(playerId, changeArea, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerData(String playerId, boolean changeArea, Map<String, String> __ctx, Callback __cb) {
/* 1875 */     return begin_getPlayerData(playerId, changeArea, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerData(String playerId, boolean changeArea, Callback_XmdsManager_getPlayerData __cb) {
/* 1880 */     return begin_getPlayerData(playerId, changeArea, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerData(String playerId, boolean changeArea, Map<String, String> __ctx, Callback_XmdsManager_getPlayerData __cb) {
/* 1885 */     return begin_getPlayerData(playerId, changeArea, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerData(String playerId, boolean changeArea, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 1893 */     return begin_getPlayerData(playerId, changeArea, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerData(String playerId, boolean changeArea, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 1902 */     return begin_getPlayerData(playerId, changeArea, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerData(String playerId, boolean changeArea, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 1911 */     return begin_getPlayerData(playerId, changeArea, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerData(String playerId, boolean changeArea, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 1921 */     return begin_getPlayerData(playerId, changeArea, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_getPlayerData(String playerId, boolean changeArea, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 1933 */     return begin_getPlayerData(playerId, changeArea, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_TwowayCallbackArg1<String>(__responseCb, __exceptionCb, __sentCb)
/*      */         {
/*      */           
/*      */           public final void __completed(AsyncResult __result)
/*      */           {
/* 1938 */             XmdsManagerPrxHelper.__getPlayerData_completed((TwowayCallbackArg1<String>)this, __result);
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_getPlayerData(String playerId, boolean changeArea, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 1950 */     __checkAsyncTwowayOnly("getPlayerData");
/* 1951 */     OutgoingAsync __result = getOutgoingAsync("getPlayerData", __cb);
/*      */     
/*      */     try {
/* 1954 */       __result.prepare("getPlayerData", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 1955 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 1956 */       __os.writeString(playerId);
/* 1957 */       __os.writeBool(changeArea);
/* 1958 */       __result.endWriteParams();
/* 1959 */       __result.invoke();
/*      */     }
/* 1961 */     catch (Exception __ex) {
/*      */       
/* 1963 */       __result.abort(__ex);
/*      */     } 
/* 1965 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public String end_getPlayerData(AsyncResult __iresult) {
/* 1970 */     OutgoingAsync __result = OutgoingAsync.check(__iresult, this, "getPlayerData");
/*      */     
/*      */     try {
/* 1973 */       if (!__result.__wait()) {
/*      */         
/*      */         try {
/*      */           
/* 1977 */           __result.throwUserException();
/*      */         }
/* 1979 */         catch (UserException __ex) {
/*      */           
/* 1981 */           throw new UnknownUserException(__ex.ice_name(), __ex);
/*      */         } 
/*      */       }
/* 1984 */       BasicStream __is = __result.startReadParams();
/*      */       
/* 1986 */       String __ret = __is.readString();
/* 1987 */       __result.endReadParams();
/* 1988 */       return __ret;
/*      */     }
/*      */     finally {
/*      */       
/* 1992 */       if (__result != null)
/*      */       {
/* 1994 */         __result.cacheMessageBuffers();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void __getPlayerData_completed(TwowayCallbackArg1<String> __cb, AsyncResult __result) {
/* 2001 */     XmdsManagerPrx __proxy = (XmdsManagerPrx)__result.getProxy();
/* 2002 */     String __ret = null;
/*      */     
/*      */     try {
/* 2005 */       __ret = __proxy.end_getPlayerData(__result);
/*      */     }
/* 2007 */     catch (LocalException __ex) {
/*      */       
/* 2009 */       __cb.exception(__ex);
/*      */       
/*      */       return;
/* 2012 */     } catch (SystemException __ex) {
/*      */       
/* 2014 */       __cb.exception(__ex);
/*      */       return;
/*      */     } 
/* 2017 */     __cb.response(__ret);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPlayerPKInfoData(String playerId) {
/* 2024 */     return getPlayerPKInfoData(playerId, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public String getPlayerPKInfoData(String playerId, Map<String, String> __ctx) {
/* 2029 */     return getPlayerPKInfoData(playerId, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private String getPlayerPKInfoData(String playerId, Map<String, String> __ctx, boolean __explicitCtx) {
/* 2034 */     __checkTwowayOnly("getPlayerPKInfoData");
/* 2035 */     return end_getPlayerPKInfoData(begin_getPlayerPKInfoData(playerId, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerPKInfoData(String playerId) {
/* 2040 */     return begin_getPlayerPKInfoData(playerId, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerPKInfoData(String playerId, Map<String, String> __ctx) {
/* 2045 */     return begin_getPlayerPKInfoData(playerId, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerPKInfoData(String playerId, Callback __cb) {
/* 2050 */     return begin_getPlayerPKInfoData(playerId, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerPKInfoData(String playerId, Map<String, String> __ctx, Callback __cb) {
/* 2055 */     return begin_getPlayerPKInfoData(playerId, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerPKInfoData(String playerId, Callback_XmdsManager_getPlayerPKInfoData __cb) {
/* 2060 */     return begin_getPlayerPKInfoData(playerId, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerPKInfoData(String playerId, Map<String, String> __ctx, Callback_XmdsManager_getPlayerPKInfoData __cb) {
/* 2065 */     return begin_getPlayerPKInfoData(playerId, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerPKInfoData(String playerId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 2072 */     return begin_getPlayerPKInfoData(playerId, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerPKInfoData(String playerId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 2080 */     return begin_getPlayerPKInfoData(playerId, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerPKInfoData(String playerId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 2088 */     return begin_getPlayerPKInfoData(playerId, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerPKInfoData(String playerId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 2097 */     return begin_getPlayerPKInfoData(playerId, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_getPlayerPKInfoData(String playerId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 2108 */     return begin_getPlayerPKInfoData(playerId, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_TwowayCallbackArg1<String>(__responseCb, __exceptionCb, __sentCb)
/*      */         {
/*      */           
/*      */           public final void __completed(AsyncResult __result)
/*      */           {
/* 2113 */             XmdsManagerPrxHelper.__getPlayerPKInfoData_completed((TwowayCallbackArg1<String>)this, __result);
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_getPlayerPKInfoData(String playerId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 2124 */     __checkAsyncTwowayOnly("getPlayerPKInfoData");
/* 2125 */     OutgoingAsync __result = getOutgoingAsync("getPlayerPKInfoData", __cb);
/*      */     
/*      */     try {
/* 2128 */       __result.prepare("getPlayerPKInfoData", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 2129 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 2130 */       __os.writeString(playerId);
/* 2131 */       __result.endWriteParams();
/* 2132 */       __result.invoke();
/*      */     }
/* 2134 */     catch (Exception __ex) {
/*      */       
/* 2136 */       __result.abort(__ex);
/*      */     } 
/* 2138 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public String end_getPlayerPKInfoData(AsyncResult __iresult) {
/* 2143 */     OutgoingAsync __result = OutgoingAsync.check(__iresult, this, "getPlayerPKInfoData");
/*      */     
/*      */     try {
/* 2146 */       if (!__result.__wait()) {
/*      */         
/*      */         try {
/*      */           
/* 2150 */           __result.throwUserException();
/*      */         }
/* 2152 */         catch (UserException __ex) {
/*      */           
/* 2154 */           throw new UnknownUserException(__ex.ice_name(), __ex);
/*      */         } 
/*      */       }
/* 2157 */       BasicStream __is = __result.startReadParams();
/*      */       
/* 2159 */       String __ret = __is.readString();
/* 2160 */       __result.endReadParams();
/* 2161 */       return __ret;
/*      */     }
/*      */     finally {
/*      */       
/* 2165 */       if (__result != null)
/*      */       {
/* 2167 */         __result.cacheMessageBuffers();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void __getPlayerPKInfoData_completed(TwowayCallbackArg1<String> __cb, AsyncResult __result) {
/* 2174 */     XmdsManagerPrx __proxy = (XmdsManagerPrx)__result.getProxy();
/* 2175 */     String __ret = null;
/*      */     
/*      */     try {
/* 2178 */       __ret = __proxy.end_getPlayerPKInfoData(__result);
/*      */     }
/* 2180 */     catch (LocalException __ex) {
/*      */       
/* 2182 */       __cb.exception(__ex);
/*      */       
/*      */       return;
/* 2185 */     } catch (SystemException __ex) {
/*      */       
/* 2187 */       __cb.exception(__ex);
/*      */       return;
/*      */     } 
/* 2190 */     __cb.response(__ret);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPlayerPetData(String playerId) {
/* 2197 */     return getPlayerPetData(playerId, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public String getPlayerPetData(String playerId, Map<String, String> __ctx) {
/* 2202 */     return getPlayerPetData(playerId, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private String getPlayerPetData(String playerId, Map<String, String> __ctx, boolean __explicitCtx) {
/* 2207 */     __checkTwowayOnly("getPlayerPetData");
/* 2208 */     return end_getPlayerPetData(begin_getPlayerPetData(playerId, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerPetData(String playerId) {
/* 2213 */     return begin_getPlayerPetData(playerId, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerPetData(String playerId, Map<String, String> __ctx) {
/* 2218 */     return begin_getPlayerPetData(playerId, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerPetData(String playerId, Callback __cb) {
/* 2223 */     return begin_getPlayerPetData(playerId, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerPetData(String playerId, Map<String, String> __ctx, Callback __cb) {
/* 2228 */     return begin_getPlayerPetData(playerId, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerPetData(String playerId, Callback_XmdsManager_getPlayerPetData __cb) {
/* 2233 */     return begin_getPlayerPetData(playerId, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerPetData(String playerId, Map<String, String> __ctx, Callback_XmdsManager_getPlayerPetData __cb) {
/* 2238 */     return begin_getPlayerPetData(playerId, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerPetData(String playerId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 2245 */     return begin_getPlayerPetData(playerId, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerPetData(String playerId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 2253 */     return begin_getPlayerPetData(playerId, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerPetData(String playerId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 2261 */     return begin_getPlayerPetData(playerId, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerPetData(String playerId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 2270 */     return begin_getPlayerPetData(playerId, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_getPlayerPetData(String playerId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 2281 */     return begin_getPlayerPetData(playerId, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_TwowayCallbackArg1<String>(__responseCb, __exceptionCb, __sentCb)
/*      */         {
/*      */           
/*      */           public final void __completed(AsyncResult __result)
/*      */           {
/* 2286 */             XmdsManagerPrxHelper.__getPlayerPetData_completed((TwowayCallbackArg1<String>)this, __result);
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_getPlayerPetData(String playerId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 2297 */     __checkAsyncTwowayOnly("getPlayerPetData");
/* 2298 */     OutgoingAsync __result = getOutgoingAsync("getPlayerPetData", __cb);
/*      */     
/*      */     try {
/* 2301 */       __result.prepare("getPlayerPetData", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 2302 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 2303 */       __os.writeString(playerId);
/* 2304 */       __result.endWriteParams();
/* 2305 */       __result.invoke();
/*      */     }
/* 2307 */     catch (Exception __ex) {
/*      */       
/* 2309 */       __result.abort(__ex);
/*      */     } 
/* 2311 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public String end_getPlayerPetData(AsyncResult __iresult) {
/* 2316 */     OutgoingAsync __result = OutgoingAsync.check(__iresult, this, "getPlayerPetData");
/*      */     
/*      */     try {
/* 2319 */       if (!__result.__wait()) {
/*      */         
/*      */         try {
/*      */           
/* 2323 */           __result.throwUserException();
/*      */         }
/* 2325 */         catch (UserException __ex) {
/*      */           
/* 2327 */           throw new UnknownUserException(__ex.ice_name(), __ex);
/*      */         } 
/*      */       }
/* 2330 */       BasicStream __is = __result.startReadParams();
/*      */       
/* 2332 */       String __ret = __is.readString();
/* 2333 */       __result.endReadParams();
/* 2334 */       return __ret;
/*      */     }
/*      */     finally {
/*      */       
/* 2338 */       if (__result != null)
/*      */       {
/* 2340 */         __result.cacheMessageBuffers();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void __getPlayerPetData_completed(TwowayCallbackArg1<String> __cb, AsyncResult __result) {
/* 2347 */     XmdsManagerPrx __proxy = (XmdsManagerPrx)__result.getProxy();
/* 2348 */     String __ret = null;
/*      */     
/*      */     try {
/* 2351 */       __ret = __proxy.end_getPlayerPetData(__result);
/*      */     }
/* 2353 */     catch (LocalException __ex) {
/*      */       
/* 2355 */       __cb.exception(__ex);
/*      */       
/*      */       return;
/* 2358 */     } catch (SystemException __ex) {
/*      */       
/* 2360 */       __cb.exception(__ex);
/*      */       return;
/*      */     } 
/* 2363 */     __cb.response(__ret);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPlayerSkillCDTime(String playerId) {
/* 2370 */     return getPlayerSkillCDTime(playerId, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public String getPlayerSkillCDTime(String playerId, Map<String, String> __ctx) {
/* 2375 */     return getPlayerSkillCDTime(playerId, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private String getPlayerSkillCDTime(String playerId, Map<String, String> __ctx, boolean __explicitCtx) {
/* 2380 */     __checkTwowayOnly("getPlayerSkillCDTime");
/* 2381 */     return end_getPlayerSkillCDTime(begin_getPlayerSkillCDTime(playerId, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerSkillCDTime(String playerId) {
/* 2386 */     return begin_getPlayerSkillCDTime(playerId, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerSkillCDTime(String playerId, Map<String, String> __ctx) {
/* 2391 */     return begin_getPlayerSkillCDTime(playerId, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerSkillCDTime(String playerId, Callback __cb) {
/* 2396 */     return begin_getPlayerSkillCDTime(playerId, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerSkillCDTime(String playerId, Map<String, String> __ctx, Callback __cb) {
/* 2401 */     return begin_getPlayerSkillCDTime(playerId, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerSkillCDTime(String playerId, Callback_XmdsManager_getPlayerSkillCDTime __cb) {
/* 2406 */     return begin_getPlayerSkillCDTime(playerId, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerSkillCDTime(String playerId, Map<String, String> __ctx, Callback_XmdsManager_getPlayerSkillCDTime __cb) {
/* 2411 */     return begin_getPlayerSkillCDTime(playerId, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerSkillCDTime(String playerId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 2418 */     return begin_getPlayerSkillCDTime(playerId, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerSkillCDTime(String playerId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 2426 */     return begin_getPlayerSkillCDTime(playerId, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerSkillCDTime(String playerId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 2434 */     return begin_getPlayerSkillCDTime(playerId, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerSkillCDTime(String playerId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 2443 */     return begin_getPlayerSkillCDTime(playerId, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_getPlayerSkillCDTime(String playerId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 2454 */     return begin_getPlayerSkillCDTime(playerId, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_TwowayCallbackArg1<String>(__responseCb, __exceptionCb, __sentCb)
/*      */         {
/*      */           
/*      */           public final void __completed(AsyncResult __result)
/*      */           {
/* 2459 */             XmdsManagerPrxHelper.__getPlayerSkillCDTime_completed((TwowayCallbackArg1<String>)this, __result);
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_getPlayerSkillCDTime(String playerId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 2470 */     __checkAsyncTwowayOnly("getPlayerSkillCDTime");
/* 2471 */     OutgoingAsync __result = getOutgoingAsync("getPlayerSkillCDTime", __cb);
/*      */     
/*      */     try {
/* 2474 */       __result.prepare("getPlayerSkillCDTime", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 2475 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 2476 */       __os.writeString(playerId);
/* 2477 */       __result.endWriteParams();
/* 2478 */       __result.invoke();
/*      */     }
/* 2480 */     catch (Exception __ex) {
/*      */       
/* 2482 */       __result.abort(__ex);
/*      */     } 
/* 2484 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public String end_getPlayerSkillCDTime(AsyncResult __iresult) {
/* 2489 */     OutgoingAsync __result = OutgoingAsync.check(__iresult, this, "getPlayerSkillCDTime");
/*      */     
/*      */     try {
/* 2492 */       if (!__result.__wait()) {
/*      */         
/*      */         try {
/*      */           
/* 2496 */           __result.throwUserException();
/*      */         }
/* 2498 */         catch (UserException __ex) {
/*      */           
/* 2500 */           throw new UnknownUserException(__ex.ice_name(), __ex);
/*      */         } 
/*      */       }
/* 2503 */       BasicStream __is = __result.startReadParams();
/*      */       
/* 2505 */       String __ret = __is.readString();
/* 2506 */       __result.endReadParams();
/* 2507 */       return __ret;
/*      */     }
/*      */     finally {
/*      */       
/* 2511 */       if (__result != null)
/*      */       {
/* 2513 */         __result.cacheMessageBuffers();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void __getPlayerSkillCDTime_completed(TwowayCallbackArg1<String> __cb, AsyncResult __result) {
/* 2520 */     XmdsManagerPrx __proxy = (XmdsManagerPrx)__result.getProxy();
/* 2521 */     String __ret = null;
/*      */     
/*      */     try {
/* 2524 */       __ret = __proxy.end_getPlayerSkillCDTime(__result);
/*      */     }
/* 2526 */     catch (LocalException __ex) {
/*      */       
/* 2528 */       __cb.exception(__ex);
/*      */       
/*      */       return;
/* 2531 */     } catch (SystemException __ex) {
/*      */       
/* 2533 */       __cb.exception(__ex);
/*      */       return;
/*      */     } 
/* 2536 */     __cb.response(__ret);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPlayerStatistic(String playerId) {
/* 2543 */     return getPlayerStatistic(playerId, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public String getPlayerStatistic(String playerId, Map<String, String> __ctx) {
/* 2548 */     return getPlayerStatistic(playerId, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private String getPlayerStatistic(String playerId, Map<String, String> __ctx, boolean __explicitCtx) {
/* 2553 */     __checkTwowayOnly("getPlayerStatistic");
/* 2554 */     return end_getPlayerStatistic(begin_getPlayerStatistic(playerId, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerStatistic(String playerId) {
/* 2559 */     return begin_getPlayerStatistic(playerId, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerStatistic(String playerId, Map<String, String> __ctx) {
/* 2564 */     return begin_getPlayerStatistic(playerId, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerStatistic(String playerId, Callback __cb) {
/* 2569 */     return begin_getPlayerStatistic(playerId, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerStatistic(String playerId, Map<String, String> __ctx, Callback __cb) {
/* 2574 */     return begin_getPlayerStatistic(playerId, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerStatistic(String playerId, Callback_XmdsManager_getPlayerStatistic __cb) {
/* 2579 */     return begin_getPlayerStatistic(playerId, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerStatistic(String playerId, Map<String, String> __ctx, Callback_XmdsManager_getPlayerStatistic __cb) {
/* 2584 */     return begin_getPlayerStatistic(playerId, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerStatistic(String playerId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 2591 */     return begin_getPlayerStatistic(playerId, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerStatistic(String playerId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 2599 */     return begin_getPlayerStatistic(playerId, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerStatistic(String playerId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 2607 */     return begin_getPlayerStatistic(playerId, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getPlayerStatistic(String playerId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 2616 */     return begin_getPlayerStatistic(playerId, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_getPlayerStatistic(String playerId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 2627 */     return begin_getPlayerStatistic(playerId, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_TwowayCallbackArg1<String>(__responseCb, __exceptionCb, __sentCb)
/*      */         {
/*      */           
/*      */           public final void __completed(AsyncResult __result)
/*      */           {
/* 2632 */             XmdsManagerPrxHelper.__getPlayerStatistic_completed((TwowayCallbackArg1<String>)this, __result);
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_getPlayerStatistic(String playerId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 2643 */     __checkAsyncTwowayOnly("getPlayerStatistic");
/* 2644 */     OutgoingAsync __result = getOutgoingAsync("getPlayerStatistic", __cb);
/*      */     
/*      */     try {
/* 2647 */       __result.prepare("getPlayerStatistic", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 2648 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 2649 */       __os.writeString(playerId);
/* 2650 */       __result.endWriteParams();
/* 2651 */       __result.invoke();
/*      */     }
/* 2653 */     catch (Exception __ex) {
/*      */       
/* 2655 */       __result.abort(__ex);
/*      */     } 
/* 2657 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public String end_getPlayerStatistic(AsyncResult __iresult) {
/* 2662 */     OutgoingAsync __result = OutgoingAsync.check(__iresult, this, "getPlayerStatistic");
/*      */     
/*      */     try {
/* 2665 */       if (!__result.__wait()) {
/*      */         
/*      */         try {
/*      */           
/* 2669 */           __result.throwUserException();
/*      */         }
/* 2671 */         catch (UserException __ex) {
/*      */           
/* 2673 */           throw new UnknownUserException(__ex.ice_name(), __ex);
/*      */         } 
/*      */       }
/* 2676 */       BasicStream __is = __result.startReadParams();
/*      */       
/* 2678 */       String __ret = __is.readString();
/* 2679 */       __result.endReadParams();
/* 2680 */       return __ret;
/*      */     }
/*      */     finally {
/*      */       
/* 2684 */       if (__result != null)
/*      */       {
/* 2686 */         __result.cacheMessageBuffers();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void __getPlayerStatistic_completed(TwowayCallbackArg1<String> __cb, AsyncResult __result) {
/* 2693 */     XmdsManagerPrx __proxy = (XmdsManagerPrx)__result.getProxy();
/* 2694 */     String __ret = null;
/*      */     
/*      */     try {
/* 2697 */       __ret = __proxy.end_getPlayerStatistic(__result);
/*      */     }
/* 2699 */     catch (LocalException __ex) {
/*      */       
/* 2701 */       __cb.exception(__ex);
/*      */       
/*      */       return;
/* 2704 */     } catch (SystemException __ex) {
/*      */       
/* 2706 */       __cb.exception(__ex);
/*      */       return;
/*      */     } 
/* 2709 */     __cb.response(__ret);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getZoneRegions(String instanceId) {
/* 2716 */     return getZoneRegions(instanceId, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public String getZoneRegions(String instanceId, Map<String, String> __ctx) {
/* 2721 */     return getZoneRegions(instanceId, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private String getZoneRegions(String instanceId, Map<String, String> __ctx, boolean __explicitCtx) {
/* 2726 */     __checkTwowayOnly("getZoneRegions");
/* 2727 */     return end_getZoneRegions(begin_getZoneRegions(instanceId, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getZoneRegions(String instanceId) {
/* 2732 */     return begin_getZoneRegions(instanceId, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getZoneRegions(String instanceId, Map<String, String> __ctx) {
/* 2737 */     return begin_getZoneRegions(instanceId, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getZoneRegions(String instanceId, Callback __cb) {
/* 2742 */     return begin_getZoneRegions(instanceId, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getZoneRegions(String instanceId, Map<String, String> __ctx, Callback __cb) {
/* 2747 */     return begin_getZoneRegions(instanceId, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getZoneRegions(String instanceId, Callback_XmdsManager_getZoneRegions __cb) {
/* 2752 */     return begin_getZoneRegions(instanceId, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getZoneRegions(String instanceId, Map<String, String> __ctx, Callback_XmdsManager_getZoneRegions __cb) {
/* 2757 */     return begin_getZoneRegions(instanceId, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getZoneRegions(String instanceId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 2764 */     return begin_getZoneRegions(instanceId, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getZoneRegions(String instanceId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 2772 */     return begin_getZoneRegions(instanceId, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getZoneRegions(String instanceId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 2780 */     return begin_getZoneRegions(instanceId, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getZoneRegions(String instanceId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 2789 */     return begin_getZoneRegions(instanceId, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_getZoneRegions(String instanceId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 2800 */     return begin_getZoneRegions(instanceId, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_TwowayCallbackArg1<String>(__responseCb, __exceptionCb, __sentCb)
/*      */         {
/*      */           
/*      */           public final void __completed(AsyncResult __result)
/*      */           {
/* 2805 */             XmdsManagerPrxHelper.__getZoneRegions_completed((TwowayCallbackArg1<String>)this, __result);
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_getZoneRegions(String instanceId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 2816 */     __checkAsyncTwowayOnly("getZoneRegions");
/* 2817 */     OutgoingAsync __result = getOutgoingAsync("getZoneRegions", __cb);
/*      */     
/*      */     try {
/* 2820 */       __result.prepare("getZoneRegions", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 2821 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 2822 */       __os.writeString(instanceId);
/* 2823 */       __result.endWriteParams();
/* 2824 */       __result.invoke();
/*      */     }
/* 2826 */     catch (Exception __ex) {
/*      */       
/* 2828 */       __result.abort(__ex);
/*      */     } 
/* 2830 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public String end_getZoneRegions(AsyncResult __iresult) {
/* 2835 */     OutgoingAsync __result = OutgoingAsync.check(__iresult, this, "getZoneRegions");
/*      */     
/*      */     try {
/* 2838 */       if (!__result.__wait()) {
/*      */         
/*      */         try {
/*      */           
/* 2842 */           __result.throwUserException();
/*      */         }
/* 2844 */         catch (UserException __ex) {
/*      */           
/* 2846 */           throw new UnknownUserException(__ex.ice_name(), __ex);
/*      */         } 
/*      */       }
/* 2849 */       BasicStream __is = __result.startReadParams();
/*      */       
/* 2851 */       String __ret = __is.readString();
/* 2852 */       __result.endReadParams();
/* 2853 */       return __ret;
/*      */     }
/*      */     finally {
/*      */       
/* 2857 */       if (__result != null)
/*      */       {
/* 2859 */         __result.cacheMessageBuffers();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void __getZoneRegions_completed(TwowayCallbackArg1<String> __cb, AsyncResult __result) {
/* 2866 */     XmdsManagerPrx __proxy = (XmdsManagerPrx)__result.getProxy();
/* 2867 */     String __ret = null;
/*      */     
/*      */     try {
/* 2870 */       __ret = __proxy.end_getZoneRegions(__result);
/*      */     }
/* 2872 */     catch (LocalException __ex) {
/*      */       
/* 2874 */       __cb.exception(__ex);
/*      */       
/*      */       return;
/* 2877 */     } catch (SystemException __ex) {
/*      */       
/* 2879 */       __cb.exception(__ex);
/*      */       return;
/*      */     } 
/* 2882 */     __cb.response(__ret);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getZoneStaticData(String instanceId) {
/* 2889 */     return getZoneStaticData(instanceId, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public String getZoneStaticData(String instanceId, Map<String, String> __ctx) {
/* 2894 */     return getZoneStaticData(instanceId, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private String getZoneStaticData(String instanceId, Map<String, String> __ctx, boolean __explicitCtx) {
/* 2899 */     __checkTwowayOnly("getZoneStaticData");
/* 2900 */     return end_getZoneStaticData(begin_getZoneStaticData(instanceId, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getZoneStaticData(String instanceId) {
/* 2905 */     return begin_getZoneStaticData(instanceId, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getZoneStaticData(String instanceId, Map<String, String> __ctx) {
/* 2910 */     return begin_getZoneStaticData(instanceId, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getZoneStaticData(String instanceId, Callback __cb) {
/* 2915 */     return begin_getZoneStaticData(instanceId, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getZoneStaticData(String instanceId, Map<String, String> __ctx, Callback __cb) {
/* 2920 */     return begin_getZoneStaticData(instanceId, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getZoneStaticData(String instanceId, Callback_XmdsManager_getZoneStaticData __cb) {
/* 2925 */     return begin_getZoneStaticData(instanceId, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getZoneStaticData(String instanceId, Map<String, String> __ctx, Callback_XmdsManager_getZoneStaticData __cb) {
/* 2930 */     return begin_getZoneStaticData(instanceId, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getZoneStaticData(String instanceId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 2937 */     return begin_getZoneStaticData(instanceId, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getZoneStaticData(String instanceId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 2945 */     return begin_getZoneStaticData(instanceId, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getZoneStaticData(String instanceId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 2953 */     return begin_getZoneStaticData(instanceId, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_getZoneStaticData(String instanceId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 2962 */     return begin_getZoneStaticData(instanceId, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_getZoneStaticData(String instanceId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 2973 */     return begin_getZoneStaticData(instanceId, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_TwowayCallbackArg1<String>(__responseCb, __exceptionCb, __sentCb)
/*      */         {
/*      */           
/*      */           public final void __completed(AsyncResult __result)
/*      */           {
/* 2978 */             XmdsManagerPrxHelper.__getZoneStaticData_completed((TwowayCallbackArg1<String>)this, __result);
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_getZoneStaticData(String instanceId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 2989 */     __checkAsyncTwowayOnly("getZoneStaticData");
/* 2990 */     OutgoingAsync __result = getOutgoingAsync("getZoneStaticData", __cb);
/*      */     
/*      */     try {
/* 2993 */       __result.prepare("getZoneStaticData", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 2994 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 2995 */       __os.writeString(instanceId);
/* 2996 */       __result.endWriteParams();
/* 2997 */       __result.invoke();
/*      */     }
/* 2999 */     catch (Exception __ex) {
/*      */       
/* 3001 */       __result.abort(__ex);
/*      */     } 
/* 3003 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public String end_getZoneStaticData(AsyncResult __iresult) {
/* 3008 */     OutgoingAsync __result = OutgoingAsync.check(__iresult, this, "getZoneStaticData");
/*      */     
/*      */     try {
/* 3011 */       if (!__result.__wait()) {
/*      */         
/*      */         try {
/*      */           
/* 3015 */           __result.throwUserException();
/*      */         }
/* 3017 */         catch (UserException __ex) {
/*      */           
/* 3019 */           throw new UnknownUserException(__ex.ice_name(), __ex);
/*      */         } 
/*      */       }
/* 3022 */       BasicStream __is = __result.startReadParams();
/*      */       
/* 3024 */       String __ret = __is.readString();
/* 3025 */       __result.endReadParams();
/* 3026 */       return __ret;
/*      */     }
/*      */     finally {
/*      */       
/* 3030 */       if (__result != null)
/*      */       {
/* 3032 */         __result.cacheMessageBuffers();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void __getZoneStaticData_completed(TwowayCallbackArg1<String> __cb, AsyncResult __result) {
/* 3039 */     XmdsManagerPrx __proxy = (XmdsManagerPrx)__result.getProxy();
/* 3040 */     String __ret = null;
/*      */     
/*      */     try {
/* 3043 */       __ret = __proxy.end_getZoneStaticData(__result);
/*      */     }
/* 3045 */     catch (LocalException __ex) {
/*      */       
/* 3047 */       __cb.exception(__ex);
/*      */       
/*      */       return;
/* 3050 */     } catch (SystemException __ex) {
/*      */       
/* 3052 */       __cb.exception(__ex);
/*      */       return;
/*      */     } 
/* 3055 */     __cb.response(__ret);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void helpRevivePlayer(String playerId, String revivePlayerId, int time) {
/* 3062 */     helpRevivePlayer(playerId, revivePlayerId, time, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void helpRevivePlayer(String playerId, String revivePlayerId, int time, Map<String, String> __ctx) {
/* 3067 */     helpRevivePlayer(playerId, revivePlayerId, time, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void helpRevivePlayer(String playerId, String revivePlayerId, int time, Map<String, String> __ctx, boolean __explicitCtx) {
/* 3072 */     end_helpRevivePlayer(begin_helpRevivePlayer(playerId, revivePlayerId, time, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_helpRevivePlayer(String playerId, String revivePlayerId, int time) {
/* 3077 */     return begin_helpRevivePlayer(playerId, revivePlayerId, time, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_helpRevivePlayer(String playerId, String revivePlayerId, int time, Map<String, String> __ctx) {
/* 3082 */     return begin_helpRevivePlayer(playerId, revivePlayerId, time, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_helpRevivePlayer(String playerId, String revivePlayerId, int time, Callback __cb) {
/* 3087 */     return begin_helpRevivePlayer(playerId, revivePlayerId, time, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_helpRevivePlayer(String playerId, String revivePlayerId, int time, Map<String, String> __ctx, Callback __cb) {
/* 3092 */     return begin_helpRevivePlayer(playerId, revivePlayerId, time, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_helpRevivePlayer(String playerId, String revivePlayerId, int time, Callback_XmdsManager_helpRevivePlayer __cb) {
/* 3097 */     return begin_helpRevivePlayer(playerId, revivePlayerId, time, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_helpRevivePlayer(String playerId, String revivePlayerId, int time, Map<String, String> __ctx, Callback_XmdsManager_helpRevivePlayer __cb) {
/* 3102 */     return begin_helpRevivePlayer(playerId, revivePlayerId, time, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_helpRevivePlayer(String playerId, String revivePlayerId, int time, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 3111 */     return begin_helpRevivePlayer(playerId, revivePlayerId, time, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_helpRevivePlayer(String playerId, String revivePlayerId, int time, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 3121 */     return begin_helpRevivePlayer(playerId, revivePlayerId, time, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_helpRevivePlayer(String playerId, String revivePlayerId, int time, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 3131 */     return begin_helpRevivePlayer(playerId, revivePlayerId, time, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_helpRevivePlayer(String playerId, String revivePlayerId, int time, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 3142 */     return begin_helpRevivePlayer(playerId, revivePlayerId, time, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_helpRevivePlayer(String playerId, String revivePlayerId, int time, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 3155 */     return begin_helpRevivePlayer(playerId, revivePlayerId, time, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_helpRevivePlayer(String playerId, String revivePlayerId, int time, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 3172 */     OutgoingAsync __result = getOutgoingAsync("helpRevivePlayer", __cb);
/*      */     
/*      */     try {
/* 3175 */       __result.prepare("helpRevivePlayer", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 3176 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 3177 */       __os.writeString(playerId);
/* 3178 */       __os.writeString(revivePlayerId);
/* 3179 */       __os.writeInt(time);
/* 3180 */       __result.endWriteParams();
/* 3181 */       __result.invoke();
/*      */     }
/* 3183 */     catch (Exception __ex) {
/*      */       
/* 3185 */       __result.abort(__ex);
/*      */     } 
/* 3187 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end_helpRevivePlayer(AsyncResult __iresult) {
/* 3192 */     __end(__iresult, "helpRevivePlayer");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void notifyBattleServer(String instanceId, String name, String data) {
/* 3199 */     notifyBattleServer(instanceId, name, data, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void notifyBattleServer(String instanceId, String name, String data, Map<String, String> __ctx) {
/* 3204 */     notifyBattleServer(instanceId, name, data, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void notifyBattleServer(String instanceId, String name, String data, Map<String, String> __ctx, boolean __explicitCtx) {
/* 3209 */     end_notifyBattleServer(begin_notifyBattleServer(instanceId, name, data, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_notifyBattleServer(String instanceId, String name, String data) {
/* 3214 */     return begin_notifyBattleServer(instanceId, name, data, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_notifyBattleServer(String instanceId, String name, String data, Map<String, String> __ctx) {
/* 3219 */     return begin_notifyBattleServer(instanceId, name, data, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_notifyBattleServer(String instanceId, String name, String data, Callback __cb) {
/* 3224 */     return begin_notifyBattleServer(instanceId, name, data, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_notifyBattleServer(String instanceId, String name, String data, Map<String, String> __ctx, Callback __cb) {
/* 3229 */     return begin_notifyBattleServer(instanceId, name, data, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_notifyBattleServer(String instanceId, String name, String data, Callback_XmdsManager_notifyBattleServer __cb) {
/* 3234 */     return begin_notifyBattleServer(instanceId, name, data, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_notifyBattleServer(String instanceId, String name, String data, Map<String, String> __ctx, Callback_XmdsManager_notifyBattleServer __cb) {
/* 3239 */     return begin_notifyBattleServer(instanceId, name, data, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_notifyBattleServer(String instanceId, String name, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 3248 */     return begin_notifyBattleServer(instanceId, name, data, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_notifyBattleServer(String instanceId, String name, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 3258 */     return begin_notifyBattleServer(instanceId, name, data, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_notifyBattleServer(String instanceId, String name, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 3268 */     return begin_notifyBattleServer(instanceId, name, data, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_notifyBattleServer(String instanceId, String name, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 3279 */     return begin_notifyBattleServer(instanceId, name, data, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_notifyBattleServer(String instanceId, String name, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 3292 */     return begin_notifyBattleServer(instanceId, name, data, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_notifyBattleServer(String instanceId, String name, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 3309 */     OutgoingAsync __result = getOutgoingAsync("notifyBattleServer", __cb);
/*      */     
/*      */     try {
/* 3312 */       __result.prepare("notifyBattleServer", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 3313 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 3314 */       __os.writeString(instanceId);
/* 3315 */       __os.writeString(name);
/* 3316 */       __os.writeString(data);
/* 3317 */       __result.endWriteParams();
/* 3318 */       __result.invoke();
/*      */     }
/* 3320 */     catch (Exception __ex) {
/*      */       
/* 3322 */       __result.abort(__ex);
/*      */     } 
/* 3324 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end_notifyBattleServer(AsyncResult __iresult) {
/* 3329 */     __end(__iresult, "notifyBattleServer");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onFinishPickItem(String playerId, String data) {
/* 3336 */     onFinishPickItem(playerId, data, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void onFinishPickItem(String playerId, String data, Map<String, String> __ctx) {
/* 3341 */     onFinishPickItem(playerId, data, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void onFinishPickItem(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx) {
/* 3346 */     end_onFinishPickItem(begin_onFinishPickItem(playerId, data, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_onFinishPickItem(String playerId, String data) {
/* 3351 */     return begin_onFinishPickItem(playerId, data, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_onFinishPickItem(String playerId, String data, Map<String, String> __ctx) {
/* 3356 */     return begin_onFinishPickItem(playerId, data, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_onFinishPickItem(String playerId, String data, Callback __cb) {
/* 3361 */     return begin_onFinishPickItem(playerId, data, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_onFinishPickItem(String playerId, String data, Map<String, String> __ctx, Callback __cb) {
/* 3366 */     return begin_onFinishPickItem(playerId, data, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_onFinishPickItem(String playerId, String data, Callback_XmdsManager_onFinishPickItem __cb) {
/* 3371 */     return begin_onFinishPickItem(playerId, data, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_onFinishPickItem(String playerId, String data, Map<String, String> __ctx, Callback_XmdsManager_onFinishPickItem __cb) {
/* 3376 */     return begin_onFinishPickItem(playerId, data, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_onFinishPickItem(String playerId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 3384 */     return begin_onFinishPickItem(playerId, data, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_onFinishPickItem(String playerId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 3393 */     return begin_onFinishPickItem(playerId, data, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_onFinishPickItem(String playerId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 3402 */     return begin_onFinishPickItem(playerId, data, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_onFinishPickItem(String playerId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 3412 */     return begin_onFinishPickItem(playerId, data, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_onFinishPickItem(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 3424 */     return begin_onFinishPickItem(playerId, data, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_onFinishPickItem(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 3439 */     OutgoingAsync __result = getOutgoingAsync("onFinishPickItem", __cb);
/*      */     
/*      */     try {
/* 3442 */       __result.prepare("onFinishPickItem", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 3443 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 3444 */       __os.writeString(playerId);
/* 3445 */       __os.writeString(data);
/* 3446 */       __result.endWriteParams();
/* 3447 */       __result.invoke();
/*      */     }
/* 3449 */     catch (Exception __ex) {
/*      */       
/* 3451 */       __result.abort(__ex);
/*      */     } 
/* 3453 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end_onFinishPickItem(AsyncResult __iresult) {
/* 3458 */     __end(__iresult, "onFinishPickItem");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onMonsterDiedDrops(String instanceId, String data) {
/* 3465 */     onMonsterDiedDrops(instanceId, data, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void onMonsterDiedDrops(String instanceId, String data, Map<String, String> __ctx) {
/* 3470 */     onMonsterDiedDrops(instanceId, data, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void onMonsterDiedDrops(String instanceId, String data, Map<String, String> __ctx, boolean __explicitCtx) {
/* 3475 */     end_onMonsterDiedDrops(begin_onMonsterDiedDrops(instanceId, data, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_onMonsterDiedDrops(String instanceId, String data) {
/* 3480 */     return begin_onMonsterDiedDrops(instanceId, data, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_onMonsterDiedDrops(String instanceId, String data, Map<String, String> __ctx) {
/* 3485 */     return begin_onMonsterDiedDrops(instanceId, data, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_onMonsterDiedDrops(String instanceId, String data, Callback __cb) {
/* 3490 */     return begin_onMonsterDiedDrops(instanceId, data, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_onMonsterDiedDrops(String instanceId, String data, Map<String, String> __ctx, Callback __cb) {
/* 3495 */     return begin_onMonsterDiedDrops(instanceId, data, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_onMonsterDiedDrops(String instanceId, String data, Callback_XmdsManager_onMonsterDiedDrops __cb) {
/* 3500 */     return begin_onMonsterDiedDrops(instanceId, data, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_onMonsterDiedDrops(String instanceId, String data, Map<String, String> __ctx, Callback_XmdsManager_onMonsterDiedDrops __cb) {
/* 3505 */     return begin_onMonsterDiedDrops(instanceId, data, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_onMonsterDiedDrops(String instanceId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 3513 */     return begin_onMonsterDiedDrops(instanceId, data, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_onMonsterDiedDrops(String instanceId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 3522 */     return begin_onMonsterDiedDrops(instanceId, data, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_onMonsterDiedDrops(String instanceId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 3531 */     return begin_onMonsterDiedDrops(instanceId, data, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_onMonsterDiedDrops(String instanceId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 3541 */     return begin_onMonsterDiedDrops(instanceId, data, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_onMonsterDiedDrops(String instanceId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 3553 */     return begin_onMonsterDiedDrops(instanceId, data, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_onMonsterDiedDrops(String instanceId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 3568 */     OutgoingAsync __result = getOutgoingAsync("onMonsterDiedDrops", __cb);
/*      */     
/*      */     try {
/* 3571 */       __result.prepare("onMonsterDiedDrops", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 3572 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 3573 */       __os.writeString(instanceId);
/* 3574 */       __os.writeString(data);
/* 3575 */       __result.endWriteParams();
/* 3576 */       __result.invoke();
/*      */     }
/* 3578 */     catch (Exception __ex) {
/*      */       
/* 3580 */       __result.abort(__ex);
/*      */     } 
/* 3582 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end_onMonsterDiedDrops(AsyncResult __iresult) {
/* 3587 */     __end(__iresult, "onMonsterDiedDrops");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void playerReady(String playerId) {
/* 3594 */     playerReady(playerId, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void playerReady(String playerId, Map<String, String> __ctx) {
/* 3599 */     playerReady(playerId, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void playerReady(String playerId, Map<String, String> __ctx, boolean __explicitCtx) {
/* 3604 */     end_playerReady(begin_playerReady(playerId, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_playerReady(String playerId) {
/* 3609 */     return begin_playerReady(playerId, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_playerReady(String playerId, Map<String, String> __ctx) {
/* 3614 */     return begin_playerReady(playerId, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_playerReady(String playerId, Callback __cb) {
/* 3619 */     return begin_playerReady(playerId, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_playerReady(String playerId, Map<String, String> __ctx, Callback __cb) {
/* 3624 */     return begin_playerReady(playerId, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_playerReady(String playerId, Callback_XmdsManager_playerReady __cb) {
/* 3629 */     return begin_playerReady(playerId, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_playerReady(String playerId, Map<String, String> __ctx, Callback_XmdsManager_playerReady __cb) {
/* 3634 */     return begin_playerReady(playerId, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_playerReady(String playerId, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 3641 */     return begin_playerReady(playerId, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_playerReady(String playerId, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 3649 */     return begin_playerReady(playerId, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_playerReady(String playerId, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 3657 */     return begin_playerReady(playerId, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_playerReady(String playerId, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 3666 */     return begin_playerReady(playerId, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_playerReady(String playerId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 3677 */     return begin_playerReady(playerId, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_playerReady(String playerId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 3690 */     OutgoingAsync __result = getOutgoingAsync("playerReady", __cb);
/*      */     
/*      */     try {
/* 3693 */       __result.prepare("playerReady", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 3694 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 3695 */       __os.writeString(playerId);
/* 3696 */       __result.endWriteParams();
/* 3697 */       __result.invoke();
/*      */     }
/* 3699 */     catch (Exception __ex) {
/*      */       
/* 3701 */       __result.abort(__ex);
/*      */     } 
/* 3703 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end_playerReady(AsyncResult __iresult) {
/* 3708 */     __end(__iresult, "playerReady");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void refreshPlayerAvatar(String playerId, String avatars) {
/* 3715 */     refreshPlayerAvatar(playerId, avatars, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void refreshPlayerAvatar(String playerId, String avatars, Map<String, String> __ctx) {
/* 3720 */     refreshPlayerAvatar(playerId, avatars, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void refreshPlayerAvatar(String playerId, String avatars, Map<String, String> __ctx, boolean __explicitCtx) {
/* 3725 */     end_refreshPlayerAvatar(begin_refreshPlayerAvatar(playerId, avatars, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerAvatar(String playerId, String avatars) {
/* 3730 */     return begin_refreshPlayerAvatar(playerId, avatars, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerAvatar(String playerId, String avatars, Map<String, String> __ctx) {
/* 3735 */     return begin_refreshPlayerAvatar(playerId, avatars, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerAvatar(String playerId, String avatars, Callback __cb) {
/* 3740 */     return begin_refreshPlayerAvatar(playerId, avatars, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerAvatar(String playerId, String avatars, Map<String, String> __ctx, Callback __cb) {
/* 3745 */     return begin_refreshPlayerAvatar(playerId, avatars, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerAvatar(String playerId, String avatars, Callback_XmdsManager_refreshPlayerAvatar __cb) {
/* 3750 */     return begin_refreshPlayerAvatar(playerId, avatars, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerAvatar(String playerId, String avatars, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerAvatar __cb) {
/* 3755 */     return begin_refreshPlayerAvatar(playerId, avatars, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerAvatar(String playerId, String avatars, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 3763 */     return begin_refreshPlayerAvatar(playerId, avatars, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerAvatar(String playerId, String avatars, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 3772 */     return begin_refreshPlayerAvatar(playerId, avatars, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerAvatar(String playerId, String avatars, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 3781 */     return begin_refreshPlayerAvatar(playerId, avatars, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerAvatar(String playerId, String avatars, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 3791 */     return begin_refreshPlayerAvatar(playerId, avatars, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerAvatar(String playerId, String avatars, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 3803 */     return begin_refreshPlayerAvatar(playerId, avatars, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerAvatar(String playerId, String avatars, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 3818 */     OutgoingAsync __result = getOutgoingAsync("refreshPlayerAvatar", __cb);
/*      */     
/*      */     try {
/* 3821 */       __result.prepare("refreshPlayerAvatar", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 3822 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 3823 */       __os.writeString(playerId);
/* 3824 */       __os.writeString(avatars);
/* 3825 */       __result.endWriteParams();
/* 3826 */       __result.invoke();
/*      */     }
/* 3828 */     catch (Exception __ex) {
/*      */       
/* 3830 */       __result.abort(__ex);
/*      */     } 
/* 3832 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end_refreshPlayerAvatar(AsyncResult __iresult) {
/* 3837 */     __end(__iresult, "refreshPlayerAvatar");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void refreshPlayerBasicData(String playerId, String basic) {
/* 3844 */     refreshPlayerBasicData(playerId, basic, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void refreshPlayerBasicData(String playerId, String basic, Map<String, String> __ctx) {
/* 3849 */     refreshPlayerBasicData(playerId, basic, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void refreshPlayerBasicData(String playerId, String basic, Map<String, String> __ctx, boolean __explicitCtx) {
/* 3854 */     end_refreshPlayerBasicData(begin_refreshPlayerBasicData(playerId, basic, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerBasicData(String playerId, String basic) {
/* 3859 */     return begin_refreshPlayerBasicData(playerId, basic, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerBasicData(String playerId, String basic, Map<String, String> __ctx) {
/* 3864 */     return begin_refreshPlayerBasicData(playerId, basic, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerBasicData(String playerId, String basic, Callback __cb) {
/* 3869 */     return begin_refreshPlayerBasicData(playerId, basic, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerBasicData(String playerId, String basic, Map<String, String> __ctx, Callback __cb) {
/* 3874 */     return begin_refreshPlayerBasicData(playerId, basic, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerBasicData(String playerId, String basic, Callback_XmdsManager_refreshPlayerBasicData __cb) {
/* 3879 */     return begin_refreshPlayerBasicData(playerId, basic, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerBasicData(String playerId, String basic, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerBasicData __cb) {
/* 3884 */     return begin_refreshPlayerBasicData(playerId, basic, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerBasicData(String playerId, String basic, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 3892 */     return begin_refreshPlayerBasicData(playerId, basic, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerBasicData(String playerId, String basic, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 3901 */     return begin_refreshPlayerBasicData(playerId, basic, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerBasicData(String playerId, String basic, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 3910 */     return begin_refreshPlayerBasicData(playerId, basic, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerBasicData(String playerId, String basic, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 3920 */     return begin_refreshPlayerBasicData(playerId, basic, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerBasicData(String playerId, String basic, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 3932 */     return begin_refreshPlayerBasicData(playerId, basic, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerBasicData(String playerId, String basic, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 3947 */     OutgoingAsync __result = getOutgoingAsync("refreshPlayerBasicData", __cb);
/*      */     
/*      */     try {
/* 3950 */       __result.prepare("refreshPlayerBasicData", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 3951 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 3952 */       __os.writeString(playerId);
/* 3953 */       __os.writeString(basic);
/* 3954 */       __result.endWriteParams();
/* 3955 */       __result.invoke();
/*      */     }
/* 3957 */     catch (Exception __ex) {
/*      */       
/* 3959 */       __result.abort(__ex);
/*      */     } 
/* 3961 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end_refreshPlayerBasicData(AsyncResult __iresult) {
/* 3966 */     __end(__iresult, "refreshPlayerBasicData");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void refreshPlayerBattleEffect(String playerId, String effects) {
/* 3973 */     refreshPlayerBattleEffect(playerId, effects, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void refreshPlayerBattleEffect(String playerId, String effects, Map<String, String> __ctx) {
/* 3978 */     refreshPlayerBattleEffect(playerId, effects, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void refreshPlayerBattleEffect(String playerId, String effects, Map<String, String> __ctx, boolean __explicitCtx) {
/* 3983 */     end_refreshPlayerBattleEffect(begin_refreshPlayerBattleEffect(playerId, effects, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerBattleEffect(String playerId, String effects) {
/* 3988 */     return begin_refreshPlayerBattleEffect(playerId, effects, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerBattleEffect(String playerId, String effects, Map<String, String> __ctx) {
/* 3993 */     return begin_refreshPlayerBattleEffect(playerId, effects, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerBattleEffect(String playerId, String effects, Callback __cb) {
/* 3998 */     return begin_refreshPlayerBattleEffect(playerId, effects, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerBattleEffect(String playerId, String effects, Map<String, String> __ctx, Callback __cb) {
/* 4003 */     return begin_refreshPlayerBattleEffect(playerId, effects, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerBattleEffect(String playerId, String effects, Callback_XmdsManager_refreshPlayerBattleEffect __cb) {
/* 4008 */     return begin_refreshPlayerBattleEffect(playerId, effects, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerBattleEffect(String playerId, String effects, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerBattleEffect __cb) {
/* 4013 */     return begin_refreshPlayerBattleEffect(playerId, effects, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerBattleEffect(String playerId, String effects, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 4021 */     return begin_refreshPlayerBattleEffect(playerId, effects, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerBattleEffect(String playerId, String effects, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 4030 */     return begin_refreshPlayerBattleEffect(playerId, effects, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerBattleEffect(String playerId, String effects, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 4039 */     return begin_refreshPlayerBattleEffect(playerId, effects, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerBattleEffect(String playerId, String effects, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 4049 */     return begin_refreshPlayerBattleEffect(playerId, effects, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerBattleEffect(String playerId, String effects, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 4061 */     return begin_refreshPlayerBattleEffect(playerId, effects, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerBattleEffect(String playerId, String effects, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 4076 */     OutgoingAsync __result = getOutgoingAsync("refreshPlayerBattleEffect", __cb);
/*      */     
/*      */     try {
/* 4079 */       __result.prepare("refreshPlayerBattleEffect", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 4080 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 4081 */       __os.writeString(playerId);
/* 4082 */       __os.writeString(effects);
/* 4083 */       __result.endWriteParams();
/* 4084 */       __result.invoke();
/*      */     }
/* 4086 */     catch (Exception __ex) {
/*      */       
/* 4088 */       __result.abort(__ex);
/*      */     } 
/* 4090 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end_refreshPlayerBattleEffect(AsyncResult __iresult) {
/* 4095 */     __end(__iresult, "refreshPlayerBattleEffect");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void refreshPlayerPKLevel(String playerId, int level) {
/* 4102 */     refreshPlayerPKLevel(playerId, level, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void refreshPlayerPKLevel(String playerId, int level, Map<String, String> __ctx) {
/* 4107 */     refreshPlayerPKLevel(playerId, level, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void refreshPlayerPKLevel(String playerId, int level, Map<String, String> __ctx, boolean __explicitCtx) {
/* 4112 */     end_refreshPlayerPKLevel(begin_refreshPlayerPKLevel(playerId, level, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPKLevel(String playerId, int level) {
/* 4117 */     return begin_refreshPlayerPKLevel(playerId, level, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPKLevel(String playerId, int level, Map<String, String> __ctx) {
/* 4122 */     return begin_refreshPlayerPKLevel(playerId, level, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPKLevel(String playerId, int level, Callback __cb) {
/* 4127 */     return begin_refreshPlayerPKLevel(playerId, level, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPKLevel(String playerId, int level, Map<String, String> __ctx, Callback __cb) {
/* 4132 */     return begin_refreshPlayerPKLevel(playerId, level, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPKLevel(String playerId, int level, Callback_XmdsManager_refreshPlayerPKLevel __cb) {
/* 4137 */     return begin_refreshPlayerPKLevel(playerId, level, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPKLevel(String playerId, int level, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerPKLevel __cb) {
/* 4142 */     return begin_refreshPlayerPKLevel(playerId, level, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPKLevel(String playerId, int level, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 4150 */     return begin_refreshPlayerPKLevel(playerId, level, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPKLevel(String playerId, int level, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 4159 */     return begin_refreshPlayerPKLevel(playerId, level, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPKLevel(String playerId, int level, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 4168 */     return begin_refreshPlayerPKLevel(playerId, level, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPKLevel(String playerId, int level, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 4178 */     return begin_refreshPlayerPKLevel(playerId, level, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerPKLevel(String playerId, int level, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 4190 */     return begin_refreshPlayerPKLevel(playerId, level, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerPKLevel(String playerId, int level, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 4205 */     OutgoingAsync __result = getOutgoingAsync("refreshPlayerPKLevel", __cb);
/*      */     
/*      */     try {
/* 4208 */       __result.prepare("refreshPlayerPKLevel", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 4209 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 4210 */       __os.writeString(playerId);
/* 4211 */       __os.writeInt(level);
/* 4212 */       __result.endWriteParams();
/* 4213 */       __result.invoke();
/*      */     }
/* 4215 */     catch (Exception __ex) {
/*      */       
/* 4217 */       __result.abort(__ex);
/*      */     } 
/* 4219 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end_refreshPlayerPKLevel(AsyncResult __iresult) {
/* 4224 */     __end(__iresult, "refreshPlayerPKLevel");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void refreshPlayerPKMode(String playerId, int mode) {
/* 4231 */     refreshPlayerPKMode(playerId, mode, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void refreshPlayerPKMode(String playerId, int mode, Map<String, String> __ctx) {
/* 4236 */     refreshPlayerPKMode(playerId, mode, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void refreshPlayerPKMode(String playerId, int mode, Map<String, String> __ctx, boolean __explicitCtx) {
/* 4241 */     end_refreshPlayerPKMode(begin_refreshPlayerPKMode(playerId, mode, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPKMode(String playerId, int mode) {
/* 4246 */     return begin_refreshPlayerPKMode(playerId, mode, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPKMode(String playerId, int mode, Map<String, String> __ctx) {
/* 4251 */     return begin_refreshPlayerPKMode(playerId, mode, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPKMode(String playerId, int mode, Callback __cb) {
/* 4256 */     return begin_refreshPlayerPKMode(playerId, mode, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPKMode(String playerId, int mode, Map<String, String> __ctx, Callback __cb) {
/* 4261 */     return begin_refreshPlayerPKMode(playerId, mode, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPKMode(String playerId, int mode, Callback_XmdsManager_refreshPlayerPKMode __cb) {
/* 4266 */     return begin_refreshPlayerPKMode(playerId, mode, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPKMode(String playerId, int mode, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerPKMode __cb) {
/* 4271 */     return begin_refreshPlayerPKMode(playerId, mode, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPKMode(String playerId, int mode, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 4279 */     return begin_refreshPlayerPKMode(playerId, mode, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPKMode(String playerId, int mode, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 4288 */     return begin_refreshPlayerPKMode(playerId, mode, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPKMode(String playerId, int mode, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 4297 */     return begin_refreshPlayerPKMode(playerId, mode, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPKMode(String playerId, int mode, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 4307 */     return begin_refreshPlayerPKMode(playerId, mode, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerPKMode(String playerId, int mode, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 4319 */     return begin_refreshPlayerPKMode(playerId, mode, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerPKMode(String playerId, int mode, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 4334 */     OutgoingAsync __result = getOutgoingAsync("refreshPlayerPKMode", __cb);
/*      */     
/*      */     try {
/* 4337 */       __result.prepare("refreshPlayerPKMode", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 4338 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 4339 */       __os.writeString(playerId);
/* 4340 */       __os.writeInt(mode);
/* 4341 */       __result.endWriteParams();
/* 4342 */       __result.invoke();
/*      */     }
/* 4344 */     catch (Exception __ex) {
/*      */       
/* 4346 */       __result.abort(__ex);
/*      */     } 
/* 4348 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end_refreshPlayerPKMode(AsyncResult __iresult) {
/* 4353 */     __end(__iresult, "refreshPlayerPKMode");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void refreshPlayerPKValue(String playerId, int value) {
/* 4360 */     refreshPlayerPKValue(playerId, value, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void refreshPlayerPKValue(String playerId, int value, Map<String, String> __ctx) {
/* 4365 */     refreshPlayerPKValue(playerId, value, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void refreshPlayerPKValue(String playerId, int value, Map<String, String> __ctx, boolean __explicitCtx) {
/* 4370 */     end_refreshPlayerPKValue(begin_refreshPlayerPKValue(playerId, value, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPKValue(String playerId, int value) {
/* 4375 */     return begin_refreshPlayerPKValue(playerId, value, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPKValue(String playerId, int value, Map<String, String> __ctx) {
/* 4380 */     return begin_refreshPlayerPKValue(playerId, value, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPKValue(String playerId, int value, Callback __cb) {
/* 4385 */     return begin_refreshPlayerPKValue(playerId, value, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPKValue(String playerId, int value, Map<String, String> __ctx, Callback __cb) {
/* 4390 */     return begin_refreshPlayerPKValue(playerId, value, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPKValue(String playerId, int value, Callback_XmdsManager_refreshPlayerPKValue __cb) {
/* 4395 */     return begin_refreshPlayerPKValue(playerId, value, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPKValue(String playerId, int value, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerPKValue __cb) {
/* 4400 */     return begin_refreshPlayerPKValue(playerId, value, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPKValue(String playerId, int value, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 4408 */     return begin_refreshPlayerPKValue(playerId, value, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPKValue(String playerId, int value, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 4417 */     return begin_refreshPlayerPKValue(playerId, value, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPKValue(String playerId, int value, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 4426 */     return begin_refreshPlayerPKValue(playerId, value, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPKValue(String playerId, int value, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 4436 */     return begin_refreshPlayerPKValue(playerId, value, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerPKValue(String playerId, int value, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 4448 */     return begin_refreshPlayerPKValue(playerId, value, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerPKValue(String playerId, int value, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 4463 */     OutgoingAsync __result = getOutgoingAsync("refreshPlayerPKValue", __cb);
/*      */     
/*      */     try {
/* 4466 */       __result.prepare("refreshPlayerPKValue", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 4467 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 4468 */       __os.writeString(playerId);
/* 4469 */       __os.writeInt(value);
/* 4470 */       __result.endWriteParams();
/* 4471 */       __result.invoke();
/*      */     }
/* 4473 */     catch (Exception __ex) {
/*      */       
/* 4475 */       __result.abort(__ex);
/*      */     } 
/* 4477 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end_refreshPlayerPKValue(AsyncResult __iresult) {
/* 4482 */     __end(__iresult, "refreshPlayerPKValue");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void refreshPlayerPetBaseInfoChange(String playerId, String data) {
/* 4489 */     refreshPlayerPetBaseInfoChange(playerId, data, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void refreshPlayerPetBaseInfoChange(String playerId, String data, Map<String, String> __ctx) {
/* 4494 */     refreshPlayerPetBaseInfoChange(playerId, data, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void refreshPlayerPetBaseInfoChange(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx) {
/* 4499 */     end_refreshPlayerPetBaseInfoChange(begin_refreshPlayerPetBaseInfoChange(playerId, data, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetBaseInfoChange(String playerId, String data) {
/* 4504 */     return begin_refreshPlayerPetBaseInfoChange(playerId, data, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetBaseInfoChange(String playerId, String data, Map<String, String> __ctx) {
/* 4509 */     return begin_refreshPlayerPetBaseInfoChange(playerId, data, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetBaseInfoChange(String playerId, String data, Callback __cb) {
/* 4514 */     return begin_refreshPlayerPetBaseInfoChange(playerId, data, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetBaseInfoChange(String playerId, String data, Map<String, String> __ctx, Callback __cb) {
/* 4519 */     return begin_refreshPlayerPetBaseInfoChange(playerId, data, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetBaseInfoChange(String playerId, String data, Callback_XmdsManager_refreshPlayerPetBaseInfoChange __cb) {
/* 4524 */     return begin_refreshPlayerPetBaseInfoChange(playerId, data, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetBaseInfoChange(String playerId, String data, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerPetBaseInfoChange __cb) {
/* 4529 */     return begin_refreshPlayerPetBaseInfoChange(playerId, data, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetBaseInfoChange(String playerId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 4537 */     return begin_refreshPlayerPetBaseInfoChange(playerId, data, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetBaseInfoChange(String playerId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 4546 */     return begin_refreshPlayerPetBaseInfoChange(playerId, data, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetBaseInfoChange(String playerId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 4555 */     return begin_refreshPlayerPetBaseInfoChange(playerId, data, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetBaseInfoChange(String playerId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 4565 */     return begin_refreshPlayerPetBaseInfoChange(playerId, data, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerPetBaseInfoChange(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 4577 */     return begin_refreshPlayerPetBaseInfoChange(playerId, data, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerPetBaseInfoChange(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 4592 */     OutgoingAsync __result = getOutgoingAsync("refreshPlayerPetBaseInfoChange", __cb);
/*      */     
/*      */     try {
/* 4595 */       __result.prepare("refreshPlayerPetBaseInfoChange", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 4596 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 4597 */       __os.writeString(playerId);
/* 4598 */       __os.writeString(data);
/* 4599 */       __result.endWriteParams();
/* 4600 */       __result.invoke();
/*      */     }
/* 4602 */     catch (Exception __ex) {
/*      */       
/* 4604 */       __result.abort(__ex);
/*      */     } 
/* 4606 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end_refreshPlayerPetBaseInfoChange(AsyncResult __iresult) {
/* 4611 */     __end(__iresult, "refreshPlayerPetBaseInfoChange");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void refreshPlayerPetDataChange(String playerId, int type, String data) {
/* 4618 */     refreshPlayerPetDataChange(playerId, type, data, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void refreshPlayerPetDataChange(String playerId, int type, String data, Map<String, String> __ctx) {
/* 4623 */     refreshPlayerPetDataChange(playerId, type, data, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void refreshPlayerPetDataChange(String playerId, int type, String data, Map<String, String> __ctx, boolean __explicitCtx) {
/* 4628 */     end_refreshPlayerPetDataChange(begin_refreshPlayerPetDataChange(playerId, type, data, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetDataChange(String playerId, int type, String data) {
/* 4633 */     return begin_refreshPlayerPetDataChange(playerId, type, data, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetDataChange(String playerId, int type, String data, Map<String, String> __ctx) {
/* 4638 */     return begin_refreshPlayerPetDataChange(playerId, type, data, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetDataChange(String playerId, int type, String data, Callback __cb) {
/* 4643 */     return begin_refreshPlayerPetDataChange(playerId, type, data, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetDataChange(String playerId, int type, String data, Map<String, String> __ctx, Callback __cb) {
/* 4648 */     return begin_refreshPlayerPetDataChange(playerId, type, data, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetDataChange(String playerId, int type, String data, Callback_XmdsManager_refreshPlayerPetDataChange __cb) {
/* 4653 */     return begin_refreshPlayerPetDataChange(playerId, type, data, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetDataChange(String playerId, int type, String data, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerPetDataChange __cb) {
/* 4658 */     return begin_refreshPlayerPetDataChange(playerId, type, data, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetDataChange(String playerId, int type, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 4667 */     return begin_refreshPlayerPetDataChange(playerId, type, data, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetDataChange(String playerId, int type, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 4677 */     return begin_refreshPlayerPetDataChange(playerId, type, data, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetDataChange(String playerId, int type, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 4687 */     return begin_refreshPlayerPetDataChange(playerId, type, data, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetDataChange(String playerId, int type, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 4698 */     return begin_refreshPlayerPetDataChange(playerId, type, data, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerPetDataChange(String playerId, int type, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 4711 */     return begin_refreshPlayerPetDataChange(playerId, type, data, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerPetDataChange(String playerId, int type, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 4728 */     OutgoingAsync __result = getOutgoingAsync("refreshPlayerPetDataChange", __cb);
/*      */     
/*      */     try {
/* 4731 */       __result.prepare("refreshPlayerPetDataChange", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 4732 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 4733 */       __os.writeString(playerId);
/* 4734 */       __os.writeInt(type);
/* 4735 */       __os.writeString(data);
/* 4736 */       __result.endWriteParams();
/* 4737 */       __result.invoke();
/*      */     }
/* 4739 */     catch (Exception __ex) {
/*      */       
/* 4741 */       __result.abort(__ex);
/*      */     } 
/* 4743 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end_refreshPlayerPetDataChange(AsyncResult __iresult) {
/* 4748 */     __end(__iresult, "refreshPlayerPetDataChange");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void refreshPlayerPetFollowModeChange(String playerId, int mode) {
/* 4755 */     refreshPlayerPetFollowModeChange(playerId, mode, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void refreshPlayerPetFollowModeChange(String playerId, int mode, Map<String, String> __ctx) {
/* 4760 */     refreshPlayerPetFollowModeChange(playerId, mode, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void refreshPlayerPetFollowModeChange(String playerId, int mode, Map<String, String> __ctx, boolean __explicitCtx) {
/* 4765 */     end_refreshPlayerPetFollowModeChange(begin_refreshPlayerPetFollowModeChange(playerId, mode, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetFollowModeChange(String playerId, int mode) {
/* 4770 */     return begin_refreshPlayerPetFollowModeChange(playerId, mode, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetFollowModeChange(String playerId, int mode, Map<String, String> __ctx) {
/* 4775 */     return begin_refreshPlayerPetFollowModeChange(playerId, mode, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetFollowModeChange(String playerId, int mode, Callback __cb) {
/* 4780 */     return begin_refreshPlayerPetFollowModeChange(playerId, mode, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetFollowModeChange(String playerId, int mode, Map<String, String> __ctx, Callback __cb) {
/* 4785 */     return begin_refreshPlayerPetFollowModeChange(playerId, mode, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetFollowModeChange(String playerId, int mode, Callback_XmdsManager_refreshPlayerPetFollowModeChange __cb) {
/* 4790 */     return begin_refreshPlayerPetFollowModeChange(playerId, mode, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetFollowModeChange(String playerId, int mode, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerPetFollowModeChange __cb) {
/* 4795 */     return begin_refreshPlayerPetFollowModeChange(playerId, mode, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetFollowModeChange(String playerId, int mode, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 4803 */     return begin_refreshPlayerPetFollowModeChange(playerId, mode, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetFollowModeChange(String playerId, int mode, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 4812 */     return begin_refreshPlayerPetFollowModeChange(playerId, mode, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetFollowModeChange(String playerId, int mode, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 4821 */     return begin_refreshPlayerPetFollowModeChange(playerId, mode, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetFollowModeChange(String playerId, int mode, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 4831 */     return begin_refreshPlayerPetFollowModeChange(playerId, mode, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerPetFollowModeChange(String playerId, int mode, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 4843 */     return begin_refreshPlayerPetFollowModeChange(playerId, mode, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerPetFollowModeChange(String playerId, int mode, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 4858 */     OutgoingAsync __result = getOutgoingAsync("refreshPlayerPetFollowModeChange", __cb);
/*      */     
/*      */     try {
/* 4861 */       __result.prepare("refreshPlayerPetFollowModeChange", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 4862 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 4863 */       __os.writeString(playerId);
/* 4864 */       __os.writeInt(mode);
/* 4865 */       __result.endWriteParams();
/* 4866 */       __result.invoke();
/*      */     }
/* 4868 */     catch (Exception __ex) {
/*      */       
/* 4870 */       __result.abort(__ex);
/*      */     } 
/* 4872 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end_refreshPlayerPetFollowModeChange(AsyncResult __iresult) {
/* 4877 */     __end(__iresult, "refreshPlayerPetFollowModeChange");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void refreshPlayerPetPropertyChange(String playerId, String data) {
/* 4884 */     refreshPlayerPetPropertyChange(playerId, data, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void refreshPlayerPetPropertyChange(String playerId, String data, Map<String, String> __ctx) {
/* 4889 */     refreshPlayerPetPropertyChange(playerId, data, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void refreshPlayerPetPropertyChange(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx) {
/* 4894 */     end_refreshPlayerPetPropertyChange(begin_refreshPlayerPetPropertyChange(playerId, data, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetPropertyChange(String playerId, String data) {
/* 4899 */     return begin_refreshPlayerPetPropertyChange(playerId, data, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetPropertyChange(String playerId, String data, Map<String, String> __ctx) {
/* 4904 */     return begin_refreshPlayerPetPropertyChange(playerId, data, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetPropertyChange(String playerId, String data, Callback __cb) {
/* 4909 */     return begin_refreshPlayerPetPropertyChange(playerId, data, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetPropertyChange(String playerId, String data, Map<String, String> __ctx, Callback __cb) {
/* 4914 */     return begin_refreshPlayerPetPropertyChange(playerId, data, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetPropertyChange(String playerId, String data, Callback_XmdsManager_refreshPlayerPetPropertyChange __cb) {
/* 4919 */     return begin_refreshPlayerPetPropertyChange(playerId, data, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetPropertyChange(String playerId, String data, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerPetPropertyChange __cb) {
/* 4924 */     return begin_refreshPlayerPetPropertyChange(playerId, data, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetPropertyChange(String playerId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 4932 */     return begin_refreshPlayerPetPropertyChange(playerId, data, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetPropertyChange(String playerId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 4941 */     return begin_refreshPlayerPetPropertyChange(playerId, data, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetPropertyChange(String playerId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 4950 */     return begin_refreshPlayerPetPropertyChange(playerId, data, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetPropertyChange(String playerId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 4960 */     return begin_refreshPlayerPetPropertyChange(playerId, data, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerPetPropertyChange(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 4972 */     return begin_refreshPlayerPetPropertyChange(playerId, data, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerPetPropertyChange(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 4987 */     OutgoingAsync __result = getOutgoingAsync("refreshPlayerPetPropertyChange", __cb);
/*      */     
/*      */     try {
/* 4990 */       __result.prepare("refreshPlayerPetPropertyChange", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 4991 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 4992 */       __os.writeString(playerId);
/* 4993 */       __os.writeString(data);
/* 4994 */       __result.endWriteParams();
/* 4995 */       __result.invoke();
/*      */     }
/* 4997 */     catch (Exception __ex) {
/*      */       
/* 4999 */       __result.abort(__ex);
/*      */     } 
/* 5001 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end_refreshPlayerPetPropertyChange(AsyncResult __iresult) {
/* 5006 */     __end(__iresult, "refreshPlayerPetPropertyChange");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void refreshPlayerPetSkillChange(String playerId, int operateID, String skills) {
/* 5013 */     refreshPlayerPetSkillChange(playerId, operateID, skills, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void refreshPlayerPetSkillChange(String playerId, int operateID, String skills, Map<String, String> __ctx) {
/* 5018 */     refreshPlayerPetSkillChange(playerId, operateID, skills, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void refreshPlayerPetSkillChange(String playerId, int operateID, String skills, Map<String, String> __ctx, boolean __explicitCtx) {
/* 5023 */     end_refreshPlayerPetSkillChange(begin_refreshPlayerPetSkillChange(playerId, operateID, skills, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetSkillChange(String playerId, int operateID, String skills) {
/* 5028 */     return begin_refreshPlayerPetSkillChange(playerId, operateID, skills, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetSkillChange(String playerId, int operateID, String skills, Map<String, String> __ctx) {
/* 5033 */     return begin_refreshPlayerPetSkillChange(playerId, operateID, skills, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetSkillChange(String playerId, int operateID, String skills, Callback __cb) {
/* 5038 */     return begin_refreshPlayerPetSkillChange(playerId, operateID, skills, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetSkillChange(String playerId, int operateID, String skills, Map<String, String> __ctx, Callback __cb) {
/* 5043 */     return begin_refreshPlayerPetSkillChange(playerId, operateID, skills, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetSkillChange(String playerId, int operateID, String skills, Callback_XmdsManager_refreshPlayerPetSkillChange __cb) {
/* 5048 */     return begin_refreshPlayerPetSkillChange(playerId, operateID, skills, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetSkillChange(String playerId, int operateID, String skills, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerPetSkillChange __cb) {
/* 5053 */     return begin_refreshPlayerPetSkillChange(playerId, operateID, skills, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetSkillChange(String playerId, int operateID, String skills, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 5062 */     return begin_refreshPlayerPetSkillChange(playerId, operateID, skills, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetSkillChange(String playerId, int operateID, String skills, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 5072 */     return begin_refreshPlayerPetSkillChange(playerId, operateID, skills, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetSkillChange(String playerId, int operateID, String skills, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 5082 */     return begin_refreshPlayerPetSkillChange(playerId, operateID, skills, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPetSkillChange(String playerId, int operateID, String skills, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 5093 */     return begin_refreshPlayerPetSkillChange(playerId, operateID, skills, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerPetSkillChange(String playerId, int operateID, String skills, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 5106 */     return begin_refreshPlayerPetSkillChange(playerId, operateID, skills, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerPetSkillChange(String playerId, int operateID, String skills, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 5123 */     OutgoingAsync __result = getOutgoingAsync("refreshPlayerPetSkillChange", __cb);
/*      */     
/*      */     try {
/* 5126 */       __result.prepare("refreshPlayerPetSkillChange", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 5127 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 5128 */       __os.writeString(playerId);
/* 5129 */       __os.writeInt(operateID);
/* 5130 */       __os.writeString(skills);
/* 5131 */       __result.endWriteParams();
/* 5132 */       __result.invoke();
/*      */     }
/* 5134 */     catch (Exception __ex) {
/*      */       
/* 5136 */       __result.abort(__ex);
/*      */     } 
/* 5138 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end_refreshPlayerPetSkillChange(AsyncResult __iresult) {
/* 5143 */     __end(__iresult, "refreshPlayerPetSkillChange");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void refreshPlayerPropertyChange(String playerId, String data) {
/* 5150 */     refreshPlayerPropertyChange(playerId, data, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void refreshPlayerPropertyChange(String playerId, String data, Map<String, String> __ctx) {
/* 5155 */     refreshPlayerPropertyChange(playerId, data, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void refreshPlayerPropertyChange(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx) {
/* 5160 */     end_refreshPlayerPropertyChange(begin_refreshPlayerPropertyChange(playerId, data, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPropertyChange(String playerId, String data) {
/* 5165 */     return begin_refreshPlayerPropertyChange(playerId, data, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPropertyChange(String playerId, String data, Map<String, String> __ctx) {
/* 5170 */     return begin_refreshPlayerPropertyChange(playerId, data, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPropertyChange(String playerId, String data, Callback __cb) {
/* 5175 */     return begin_refreshPlayerPropertyChange(playerId, data, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPropertyChange(String playerId, String data, Map<String, String> __ctx, Callback __cb) {
/* 5180 */     return begin_refreshPlayerPropertyChange(playerId, data, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPropertyChange(String playerId, String data, Callback_XmdsManager_refreshPlayerPropertyChange __cb) {
/* 5185 */     return begin_refreshPlayerPropertyChange(playerId, data, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPropertyChange(String playerId, String data, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerPropertyChange __cb) {
/* 5190 */     return begin_refreshPlayerPropertyChange(playerId, data, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPropertyChange(String playerId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 5198 */     return begin_refreshPlayerPropertyChange(playerId, data, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPropertyChange(String playerId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 5207 */     return begin_refreshPlayerPropertyChange(playerId, data, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPropertyChange(String playerId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 5216 */     return begin_refreshPlayerPropertyChange(playerId, data, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerPropertyChange(String playerId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 5226 */     return begin_refreshPlayerPropertyChange(playerId, data, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerPropertyChange(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 5238 */     return begin_refreshPlayerPropertyChange(playerId, data, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerPropertyChange(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 5253 */     OutgoingAsync __result = getOutgoingAsync("refreshPlayerPropertyChange", __cb);
/*      */     
/*      */     try {
/* 5256 */       __result.prepare("refreshPlayerPropertyChange", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 5257 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 5258 */       __os.writeString(playerId);
/* 5259 */       __os.writeString(data);
/* 5260 */       __result.endWriteParams();
/* 5261 */       __result.invoke();
/*      */     }
/* 5263 */     catch (Exception __ex) {
/*      */       
/* 5265 */       __result.abort(__ex);
/*      */     } 
/* 5267 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end_refreshPlayerPropertyChange(AsyncResult __iresult) {
/* 5272 */     __end(__iresult, "refreshPlayerPropertyChange");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void refreshPlayerRemainBagCountData(String playerId, int remainCount) {
/* 5279 */     refreshPlayerRemainBagCountData(playerId, remainCount, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void refreshPlayerRemainBagCountData(String playerId, int remainCount, Map<String, String> __ctx) {
/* 5284 */     refreshPlayerRemainBagCountData(playerId, remainCount, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void refreshPlayerRemainBagCountData(String playerId, int remainCount, Map<String, String> __ctx, boolean __explicitCtx) {
/* 5289 */     end_refreshPlayerRemainBagCountData(begin_refreshPlayerRemainBagCountData(playerId, remainCount, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerRemainBagCountData(String playerId, int remainCount) {
/* 5294 */     return begin_refreshPlayerRemainBagCountData(playerId, remainCount, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerRemainBagCountData(String playerId, int remainCount, Map<String, String> __ctx) {
/* 5299 */     return begin_refreshPlayerRemainBagCountData(playerId, remainCount, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerRemainBagCountData(String playerId, int remainCount, Callback __cb) {
/* 5304 */     return begin_refreshPlayerRemainBagCountData(playerId, remainCount, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerRemainBagCountData(String playerId, int remainCount, Map<String, String> __ctx, Callback __cb) {
/* 5309 */     return begin_refreshPlayerRemainBagCountData(playerId, remainCount, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerRemainBagCountData(String playerId, int remainCount, Callback_XmdsManager_refreshPlayerRemainBagCountData __cb) {
/* 5314 */     return begin_refreshPlayerRemainBagCountData(playerId, remainCount, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerRemainBagCountData(String playerId, int remainCount, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerRemainBagCountData __cb) {
/* 5319 */     return begin_refreshPlayerRemainBagCountData(playerId, remainCount, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerRemainBagCountData(String playerId, int remainCount, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 5327 */     return begin_refreshPlayerRemainBagCountData(playerId, remainCount, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerRemainBagCountData(String playerId, int remainCount, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 5336 */     return begin_refreshPlayerRemainBagCountData(playerId, remainCount, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerRemainBagCountData(String playerId, int remainCount, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 5345 */     return begin_refreshPlayerRemainBagCountData(playerId, remainCount, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerRemainBagCountData(String playerId, int remainCount, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 5355 */     return begin_refreshPlayerRemainBagCountData(playerId, remainCount, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerRemainBagCountData(String playerId, int remainCount, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 5367 */     return begin_refreshPlayerRemainBagCountData(playerId, remainCount, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerRemainBagCountData(String playerId, int remainCount, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 5382 */     OutgoingAsync __result = getOutgoingAsync("refreshPlayerRemainBagCountData", __cb);
/*      */     
/*      */     try {
/* 5385 */       __result.prepare("refreshPlayerRemainBagCountData", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 5386 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 5387 */       __os.writeString(playerId);
/* 5388 */       __os.writeInt(remainCount);
/* 5389 */       __result.endWriteParams();
/* 5390 */       __result.invoke();
/*      */     }
/* 5392 */     catch (Exception __ex) {
/*      */       
/* 5394 */       __result.abort(__ex);
/*      */     } 
/* 5396 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end_refreshPlayerRemainBagCountData(AsyncResult __iresult) {
/* 5401 */     __end(__iresult, "refreshPlayerRemainBagCountData");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void refreshPlayerRemainTeamBagCountData(String playerId, int remainCount) {
/* 5408 */     refreshPlayerRemainTeamBagCountData(playerId, remainCount, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void refreshPlayerRemainTeamBagCountData(String playerId, int remainCount, Map<String, String> __ctx) {
/* 5413 */     refreshPlayerRemainTeamBagCountData(playerId, remainCount, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void refreshPlayerRemainTeamBagCountData(String playerId, int remainCount, Map<String, String> __ctx, boolean __explicitCtx) {
/* 5418 */     end_refreshPlayerRemainTeamBagCountData(begin_refreshPlayerRemainTeamBagCountData(playerId, remainCount, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerRemainTeamBagCountData(String playerId, int remainCount) {
/* 5423 */     return begin_refreshPlayerRemainTeamBagCountData(playerId, remainCount, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerRemainTeamBagCountData(String playerId, int remainCount, Map<String, String> __ctx) {
/* 5428 */     return begin_refreshPlayerRemainTeamBagCountData(playerId, remainCount, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerRemainTeamBagCountData(String playerId, int remainCount, Callback __cb) {
/* 5433 */     return begin_refreshPlayerRemainTeamBagCountData(playerId, remainCount, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerRemainTeamBagCountData(String playerId, int remainCount, Map<String, String> __ctx, Callback __cb) {
/* 5438 */     return begin_refreshPlayerRemainTeamBagCountData(playerId, remainCount, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerRemainTeamBagCountData(String playerId, int remainCount, Callback_XmdsManager_refreshPlayerRemainTeamBagCountData __cb) {
/* 5443 */     return begin_refreshPlayerRemainTeamBagCountData(playerId, remainCount, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerRemainTeamBagCountData(String playerId, int remainCount, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerRemainTeamBagCountData __cb) {
/* 5448 */     return begin_refreshPlayerRemainTeamBagCountData(playerId, remainCount, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerRemainTeamBagCountData(String playerId, int remainCount, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 5456 */     return begin_refreshPlayerRemainTeamBagCountData(playerId, remainCount, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerRemainTeamBagCountData(String playerId, int remainCount, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 5465 */     return begin_refreshPlayerRemainTeamBagCountData(playerId, remainCount, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerRemainTeamBagCountData(String playerId, int remainCount, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 5474 */     return begin_refreshPlayerRemainTeamBagCountData(playerId, remainCount, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerRemainTeamBagCountData(String playerId, int remainCount, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 5484 */     return begin_refreshPlayerRemainTeamBagCountData(playerId, remainCount, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerRemainTeamBagCountData(String playerId, int remainCount, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 5496 */     return begin_refreshPlayerRemainTeamBagCountData(playerId, remainCount, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerRemainTeamBagCountData(String playerId, int remainCount, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 5511 */     OutgoingAsync __result = getOutgoingAsync("refreshPlayerRemainTeamBagCountData", __cb);
/*      */     
/*      */     try {
/* 5514 */       __result.prepare("refreshPlayerRemainTeamBagCountData", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 5515 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 5516 */       __os.writeString(playerId);
/* 5517 */       __os.writeInt(remainCount);
/* 5518 */       __result.endWriteParams();
/* 5519 */       __result.invoke();
/*      */     }
/* 5521 */     catch (Exception __ex) {
/*      */       
/* 5523 */       __result.abort(__ex);
/*      */     } 
/* 5525 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end_refreshPlayerRemainTeamBagCountData(AsyncResult __iresult) {
/* 5530 */     __end(__iresult, "refreshPlayerRemainTeamBagCountData");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void refreshPlayerSkill(String playerId, int operateID, String skills) {
/* 5537 */     refreshPlayerSkill(playerId, operateID, skills, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void refreshPlayerSkill(String playerId, int operateID, String skills, Map<String, String> __ctx) {
/* 5542 */     refreshPlayerSkill(playerId, operateID, skills, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void refreshPlayerSkill(String playerId, int operateID, String skills, Map<String, String> __ctx, boolean __explicitCtx) {
/* 5547 */     end_refreshPlayerSkill(begin_refreshPlayerSkill(playerId, operateID, skills, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerSkill(String playerId, int operateID, String skills) {
/* 5552 */     return begin_refreshPlayerSkill(playerId, operateID, skills, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerSkill(String playerId, int operateID, String skills, Map<String, String> __ctx) {
/* 5557 */     return begin_refreshPlayerSkill(playerId, operateID, skills, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerSkill(String playerId, int operateID, String skills, Callback __cb) {
/* 5562 */     return begin_refreshPlayerSkill(playerId, operateID, skills, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerSkill(String playerId, int operateID, String skills, Map<String, String> __ctx, Callback __cb) {
/* 5567 */     return begin_refreshPlayerSkill(playerId, operateID, skills, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerSkill(String playerId, int operateID, String skills, Callback_XmdsManager_refreshPlayerSkill __cb) {
/* 5572 */     return begin_refreshPlayerSkill(playerId, operateID, skills, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerSkill(String playerId, int operateID, String skills, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerSkill __cb) {
/* 5577 */     return begin_refreshPlayerSkill(playerId, operateID, skills, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerSkill(String playerId, int operateID, String skills, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 5586 */     return begin_refreshPlayerSkill(playerId, operateID, skills, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerSkill(String playerId, int operateID, String skills, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 5596 */     return begin_refreshPlayerSkill(playerId, operateID, skills, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerSkill(String playerId, int operateID, String skills, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 5606 */     return begin_refreshPlayerSkill(playerId, operateID, skills, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerSkill(String playerId, int operateID, String skills, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 5617 */     return begin_refreshPlayerSkill(playerId, operateID, skills, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerSkill(String playerId, int operateID, String skills, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 5630 */     return begin_refreshPlayerSkill(playerId, operateID, skills, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerSkill(String playerId, int operateID, String skills, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 5647 */     OutgoingAsync __result = getOutgoingAsync("refreshPlayerSkill", __cb);
/*      */     
/*      */     try {
/* 5650 */       __result.prepare("refreshPlayerSkill", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 5651 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 5652 */       __os.writeString(playerId);
/* 5653 */       __os.writeInt(operateID);
/* 5654 */       __os.writeString(skills);
/* 5655 */       __result.endWriteParams();
/* 5656 */       __result.invoke();
/*      */     }
/* 5658 */     catch (Exception __ex) {
/*      */       
/* 5660 */       __result.abort(__ex);
/*      */     } 
/* 5662 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end_refreshPlayerSkill(AsyncResult __iresult) {
/* 5667 */     __end(__iresult, "refreshPlayerSkill");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void refreshPlayerTeamData(String playerId, String uuidList) {
/* 5674 */     refreshPlayerTeamData(playerId, uuidList, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void refreshPlayerTeamData(String playerId, String uuidList, Map<String, String> __ctx) {
/* 5679 */     refreshPlayerTeamData(playerId, uuidList, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void refreshPlayerTeamData(String playerId, String uuidList, Map<String, String> __ctx, boolean __explicitCtx) {
/* 5684 */     end_refreshPlayerTeamData(begin_refreshPlayerTeamData(playerId, uuidList, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerTeamData(String playerId, String uuidList) {
/* 5689 */     return begin_refreshPlayerTeamData(playerId, uuidList, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerTeamData(String playerId, String uuidList, Map<String, String> __ctx) {
/* 5694 */     return begin_refreshPlayerTeamData(playerId, uuidList, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerTeamData(String playerId, String uuidList, Callback __cb) {
/* 5699 */     return begin_refreshPlayerTeamData(playerId, uuidList, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerTeamData(String playerId, String uuidList, Map<String, String> __ctx, Callback __cb) {
/* 5704 */     return begin_refreshPlayerTeamData(playerId, uuidList, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerTeamData(String playerId, String uuidList, Callback_XmdsManager_refreshPlayerTeamData __cb) {
/* 5709 */     return begin_refreshPlayerTeamData(playerId, uuidList, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerTeamData(String playerId, String uuidList, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerTeamData __cb) {
/* 5714 */     return begin_refreshPlayerTeamData(playerId, uuidList, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerTeamData(String playerId, String uuidList, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 5722 */     return begin_refreshPlayerTeamData(playerId, uuidList, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerTeamData(String playerId, String uuidList, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 5731 */     return begin_refreshPlayerTeamData(playerId, uuidList, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerTeamData(String playerId, String uuidList, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 5740 */     return begin_refreshPlayerTeamData(playerId, uuidList, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshPlayerTeamData(String playerId, String uuidList, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 5750 */     return begin_refreshPlayerTeamData(playerId, uuidList, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerTeamData(String playerId, String uuidList, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 5762 */     return begin_refreshPlayerTeamData(playerId, uuidList, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshPlayerTeamData(String playerId, String uuidList, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 5777 */     OutgoingAsync __result = getOutgoingAsync("refreshPlayerTeamData", __cb);
/*      */     
/*      */     try {
/* 5780 */       __result.prepare("refreshPlayerTeamData", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 5781 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 5782 */       __os.writeString(playerId);
/* 5783 */       __os.writeString(uuidList);
/* 5784 */       __result.endWriteParams();
/* 5785 */       __result.invoke();
/*      */     }
/* 5787 */     catch (Exception __ex) {
/*      */       
/* 5789 */       __result.abort(__ex);
/*      */     } 
/* 5791 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end_refreshPlayerTeamData(AsyncResult __iresult) {
/* 5796 */     __end(__iresult, "refreshPlayerTeamData");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void refreshSummonMount(String playerId, int time, int isUp) {
/* 5803 */     refreshSummonMount(playerId, time, isUp, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void refreshSummonMount(String playerId, int time, int isUp, Map<String, String> __ctx) {
/* 5808 */     refreshSummonMount(playerId, time, isUp, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void refreshSummonMount(String playerId, int time, int isUp, Map<String, String> __ctx, boolean __explicitCtx) {
/* 5813 */     end_refreshSummonMount(begin_refreshSummonMount(playerId, time, isUp, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshSummonMount(String playerId, int time, int isUp) {
/* 5818 */     return begin_refreshSummonMount(playerId, time, isUp, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshSummonMount(String playerId, int time, int isUp, Map<String, String> __ctx) {
/* 5823 */     return begin_refreshSummonMount(playerId, time, isUp, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshSummonMount(String playerId, int time, int isUp, Callback __cb) {
/* 5828 */     return begin_refreshSummonMount(playerId, time, isUp, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshSummonMount(String playerId, int time, int isUp, Map<String, String> __ctx, Callback __cb) {
/* 5833 */     return begin_refreshSummonMount(playerId, time, isUp, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshSummonMount(String playerId, int time, int isUp, Callback_XmdsManager_refreshSummonMount __cb) {
/* 5838 */     return begin_refreshSummonMount(playerId, time, isUp, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshSummonMount(String playerId, int time, int isUp, Map<String, String> __ctx, Callback_XmdsManager_refreshSummonMount __cb) {
/* 5843 */     return begin_refreshSummonMount(playerId, time, isUp, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshSummonMount(String playerId, int time, int isUp, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 5852 */     return begin_refreshSummonMount(playerId, time, isUp, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshSummonMount(String playerId, int time, int isUp, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 5862 */     return begin_refreshSummonMount(playerId, time, isUp, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshSummonMount(String playerId, int time, int isUp, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 5872 */     return begin_refreshSummonMount(playerId, time, isUp, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshSummonMount(String playerId, int time, int isUp, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 5883 */     return begin_refreshSummonMount(playerId, time, isUp, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshSummonMount(String playerId, int time, int isUp, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 5896 */     return begin_refreshSummonMount(playerId, time, isUp, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshSummonMount(String playerId, int time, int isUp, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 5913 */     OutgoingAsync __result = getOutgoingAsync("refreshSummonMount", __cb);
/*      */     
/*      */     try {
/* 5916 */       __result.prepare("refreshSummonMount", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 5917 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 5918 */       __os.writeString(playerId);
/* 5919 */       __os.writeInt(time);
/* 5920 */       __os.writeInt(isUp);
/* 5921 */       __result.endWriteParams();
/* 5922 */       __result.invoke();
/*      */     }
/* 5924 */     catch (Exception __ex) {
/*      */       
/* 5926 */       __result.abort(__ex);
/*      */     } 
/* 5928 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end_refreshSummonMount(AsyncResult __iresult) {
/* 5933 */     __end(__iresult, "refreshSummonMount");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void refreshTeamData(String playerId, String data) {
/* 5940 */     refreshTeamData(playerId, data, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void refreshTeamData(String playerId, String data, Map<String, String> __ctx) {
/* 5945 */     refreshTeamData(playerId, data, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void refreshTeamData(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx) {
/* 5950 */     end_refreshTeamData(begin_refreshTeamData(playerId, data, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshTeamData(String playerId, String data) {
/* 5955 */     return begin_refreshTeamData(playerId, data, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshTeamData(String playerId, String data, Map<String, String> __ctx) {
/* 5960 */     return begin_refreshTeamData(playerId, data, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshTeamData(String playerId, String data, Callback __cb) {
/* 5965 */     return begin_refreshTeamData(playerId, data, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshTeamData(String playerId, String data, Map<String, String> __ctx, Callback __cb) {
/* 5970 */     return begin_refreshTeamData(playerId, data, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshTeamData(String playerId, String data, Callback_XmdsManager_refreshTeamData __cb) {
/* 5975 */     return begin_refreshTeamData(playerId, data, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshTeamData(String playerId, String data, Map<String, String> __ctx, Callback_XmdsManager_refreshTeamData __cb) {
/* 5980 */     return begin_refreshTeamData(playerId, data, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshTeamData(String playerId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 5988 */     return begin_refreshTeamData(playerId, data, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshTeamData(String playerId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 5997 */     return begin_refreshTeamData(playerId, data, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshTeamData(String playerId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 6006 */     return begin_refreshTeamData(playerId, data, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_refreshTeamData(String playerId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 6016 */     return begin_refreshTeamData(playerId, data, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshTeamData(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 6028 */     return begin_refreshTeamData(playerId, data, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_refreshTeamData(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 6043 */     OutgoingAsync __result = getOutgoingAsync("refreshTeamData", __cb);
/*      */     
/*      */     try {
/* 6046 */       __result.prepare("refreshTeamData", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 6047 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 6048 */       __os.writeString(playerId);
/* 6049 */       __os.writeString(data);
/* 6050 */       __result.endWriteParams();
/* 6051 */       __result.invoke();
/*      */     }
/* 6053 */     catch (Exception __ex) {
/*      */       
/* 6055 */       __result.abort(__ex);
/*      */     } 
/* 6057 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end_refreshTeamData(AsyncResult __iresult) {
/* 6062 */     __end(__iresult, "refreshTeamData");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeUnit(String instanceId, int unitId) {
/* 6069 */     removeUnit(instanceId, unitId, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void removeUnit(String instanceId, int unitId, Map<String, String> __ctx) {
/* 6074 */     removeUnit(instanceId, unitId, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void removeUnit(String instanceId, int unitId, Map<String, String> __ctx, boolean __explicitCtx) {
/* 6079 */     end_removeUnit(begin_removeUnit(instanceId, unitId, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_removeUnit(String instanceId, int unitId) {
/* 6084 */     return begin_removeUnit(instanceId, unitId, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_removeUnit(String instanceId, int unitId, Map<String, String> __ctx) {
/* 6089 */     return begin_removeUnit(instanceId, unitId, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_removeUnit(String instanceId, int unitId, Callback __cb) {
/* 6094 */     return begin_removeUnit(instanceId, unitId, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_removeUnit(String instanceId, int unitId, Map<String, String> __ctx, Callback __cb) {
/* 6099 */     return begin_removeUnit(instanceId, unitId, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_removeUnit(String instanceId, int unitId, Callback_XmdsManager_removeUnit __cb) {
/* 6104 */     return begin_removeUnit(instanceId, unitId, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_removeUnit(String instanceId, int unitId, Map<String, String> __ctx, Callback_XmdsManager_removeUnit __cb) {
/* 6109 */     return begin_removeUnit(instanceId, unitId, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_removeUnit(String instanceId, int unitId, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 6117 */     return begin_removeUnit(instanceId, unitId, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_removeUnit(String instanceId, int unitId, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 6126 */     return begin_removeUnit(instanceId, unitId, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_removeUnit(String instanceId, int unitId, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 6135 */     return begin_removeUnit(instanceId, unitId, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_removeUnit(String instanceId, int unitId, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 6145 */     return begin_removeUnit(instanceId, unitId, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_removeUnit(String instanceId, int unitId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 6157 */     return begin_removeUnit(instanceId, unitId, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_removeUnit(String instanceId, int unitId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 6172 */     OutgoingAsync __result = getOutgoingAsync("removeUnit", __cb);
/*      */     
/*      */     try {
/* 6175 */       __result.prepare("removeUnit", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 6176 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 6177 */       __os.writeString(instanceId);
/* 6178 */       __os.writeInt(unitId);
/* 6179 */       __result.endWriteParams();
/* 6180 */       __result.invoke();
/*      */     }
/* 6182 */     catch (Exception __ex) {
/*      */       
/* 6184 */       __result.abort(__ex);
/*      */     } 
/* 6186 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end_removeUnit(AsyncResult __iresult) {
/* 6191 */     __end(__iresult, "removeUnit");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void revivePlayer(String playerId, String data) {
/* 6198 */     revivePlayer(playerId, data, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void revivePlayer(String playerId, String data, Map<String, String> __ctx) {
/* 6203 */     revivePlayer(playerId, data, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void revivePlayer(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx) {
/* 6208 */     end_revivePlayer(begin_revivePlayer(playerId, data, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_revivePlayer(String playerId, String data) {
/* 6213 */     return begin_revivePlayer(playerId, data, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_revivePlayer(String playerId, String data, Map<String, String> __ctx) {
/* 6218 */     return begin_revivePlayer(playerId, data, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_revivePlayer(String playerId, String data, Callback __cb) {
/* 6223 */     return begin_revivePlayer(playerId, data, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_revivePlayer(String playerId, String data, Map<String, String> __ctx, Callback __cb) {
/* 6228 */     return begin_revivePlayer(playerId, data, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_revivePlayer(String playerId, String data, Callback_XmdsManager_revivePlayer __cb) {
/* 6233 */     return begin_revivePlayer(playerId, data, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_revivePlayer(String playerId, String data, Map<String, String> __ctx, Callback_XmdsManager_revivePlayer __cb) {
/* 6238 */     return begin_revivePlayer(playerId, data, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_revivePlayer(String playerId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 6246 */     return begin_revivePlayer(playerId, data, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_revivePlayer(String playerId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 6255 */     return begin_revivePlayer(playerId, data, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_revivePlayer(String playerId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 6264 */     return begin_revivePlayer(playerId, data, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_revivePlayer(String playerId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 6274 */     return begin_revivePlayer(playerId, data, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_revivePlayer(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 6286 */     return begin_revivePlayer(playerId, data, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_revivePlayer(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 6301 */     OutgoingAsync __result = getOutgoingAsync("revivePlayer", __cb);
/*      */     
/*      */     try {
/* 6304 */       __result.prepare("revivePlayer", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 6305 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 6306 */       __os.writeString(playerId);
/* 6307 */       __os.writeString(data);
/* 6308 */       __result.endWriteParams();
/* 6309 */       __result.invoke();
/*      */     }
/* 6311 */     catch (Exception __ex) {
/*      */       
/* 6313 */       __result.abort(__ex);
/*      */     } 
/* 6315 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end_revivePlayer(AsyncResult __iresult) {
/* 6320 */     __end(__iresult, "revivePlayer");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void triggrBattleFunction(String playerId, int eventId, String data) {
/* 6327 */     triggrBattleFunction(playerId, eventId, data, (Map<String, String>)null, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void triggrBattleFunction(String playerId, int eventId, String data, Map<String, String> __ctx) {
/* 6332 */     triggrBattleFunction(playerId, eventId, data, __ctx, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void triggrBattleFunction(String playerId, int eventId, String data, Map<String, String> __ctx, boolean __explicitCtx) {
/* 6337 */     end_triggrBattleFunction(begin_triggrBattleFunction(playerId, eventId, data, __ctx, __explicitCtx, true, (CallbackBase)null));
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_triggrBattleFunction(String playerId, int eventId, String data) {
/* 6342 */     return begin_triggrBattleFunction(playerId, eventId, data, (Map<String, String>)null, false, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_triggrBattleFunction(String playerId, int eventId, String data, Map<String, String> __ctx) {
/* 6347 */     return begin_triggrBattleFunction(playerId, eventId, data, __ctx, true, false, (CallbackBase)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_triggrBattleFunction(String playerId, int eventId, String data, Callback __cb) {
/* 6352 */     return begin_triggrBattleFunction(playerId, eventId, data, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_triggrBattleFunction(String playerId, int eventId, String data, Map<String, String> __ctx, Callback __cb) {
/* 6357 */     return begin_triggrBattleFunction(playerId, eventId, data, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_triggrBattleFunction(String playerId, int eventId, String data, Callback_XmdsManager_triggrBattleFunction __cb) {
/* 6362 */     return begin_triggrBattleFunction(playerId, eventId, data, (Map<String, String>)null, false, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */   
/*      */   public AsyncResult begin_triggrBattleFunction(String playerId, int eventId, String data, Map<String, String> __ctx, Callback_XmdsManager_triggrBattleFunction __cb) {
/* 6367 */     return begin_triggrBattleFunction(playerId, eventId, data, __ctx, true, false, (CallbackBase)__cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_triggrBattleFunction(String playerId, int eventId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 6376 */     return begin_triggrBattleFunction(playerId, eventId, data, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_triggrBattleFunction(String playerId, int eventId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 6386 */     return begin_triggrBattleFunction(playerId, eventId, data, (Map<String, String>)null, false, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_triggrBattleFunction(String playerId, int eventId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
/* 6396 */     return begin_triggrBattleFunction(playerId, eventId, data, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AsyncResult begin_triggrBattleFunction(String playerId, int eventId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 6407 */     return begin_triggrBattleFunction(playerId, eventId, data, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_triggrBattleFunction(String playerId, int eventId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
/* 6420 */     return begin_triggrBattleFunction(playerId, eventId, data, __ctx, __explicitCtx, __synchronous, (CallbackBase)new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AsyncResult begin_triggrBattleFunction(String playerId, int eventId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
/* 6437 */     OutgoingAsync __result = getOutgoingAsync("triggrBattleFunction", __cb);
/*      */     
/*      */     try {
/* 6440 */       __result.prepare("triggrBattleFunction", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
/* 6441 */       BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
/* 6442 */       __os.writeString(playerId);
/* 6443 */       __os.writeInt(eventId);
/* 6444 */       __os.writeString(data);
/* 6445 */       __result.endWriteParams();
/* 6446 */       __result.invoke();
/*      */     }
/* 6448 */     catch (Exception __ex) {
/*      */       
/* 6450 */       __result.abort(__ex);
/*      */     } 
/* 6452 */     return (AsyncResult)__result;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end_triggrBattleFunction(AsyncResult __iresult) {
/* 6457 */     __end(__iresult, "triggrBattleFunction");
/*      */   }
/*      */ 
/*      */   
/*      */   public static XmdsManagerPrx checkedCast(ObjectPrx __obj) {
/* 6462 */     return (XmdsManagerPrx)checkedCastImpl(__obj, ice_staticId(), XmdsManagerPrx.class, XmdsManagerPrxHelper.class);
/*      */   }
/*      */ 
/*      */   
/*      */   public static XmdsManagerPrx checkedCast(ObjectPrx __obj, Map<String, String> __ctx) {
/* 6467 */     return (XmdsManagerPrx)checkedCastImpl(__obj, __ctx, ice_staticId(), XmdsManagerPrx.class, XmdsManagerPrxHelper.class);
/*      */   }
/*      */ 
/*      */   
/*      */   public static XmdsManagerPrx checkedCast(ObjectPrx __obj, String __facet) {
/* 6472 */     return (XmdsManagerPrx)checkedCastImpl(__obj, __facet, ice_staticId(), XmdsManagerPrx.class, XmdsManagerPrxHelper.class);
/*      */   }
/*      */ 
/*      */   
/*      */   public static XmdsManagerPrx checkedCast(ObjectPrx __obj, String __facet, Map<String, String> __ctx) {
/* 6477 */     return (XmdsManagerPrx)checkedCastImpl(__obj, __facet, __ctx, ice_staticId(), XmdsManagerPrx.class, XmdsManagerPrxHelper.class);
/*      */   }
/*      */ 
/*      */   
/*      */   public static XmdsManagerPrx uncheckedCast(ObjectPrx __obj) {
/* 6482 */     return (XmdsManagerPrx)uncheckedCastImpl(__obj, XmdsManagerPrx.class, XmdsManagerPrxHelper.class);
/*      */   }
/*      */ 
/*      */   
/*      */   public static XmdsManagerPrx uncheckedCast(ObjectPrx __obj, String __facet) {
/* 6487 */     return (XmdsManagerPrx)uncheckedCastImpl(__obj, __facet, XmdsManagerPrx.class, XmdsManagerPrxHelper.class);
/*      */   }
/*      */   
/* 6490 */   public static final String[] __ids = new String[] { "::Ice::Object", "::Xmds::XmdsManager" };
/*      */ 
/*      */   
/*      */   public static final long serialVersionUID = 0L;
/*      */ 
/*      */ 
/*      */   
/*      */   public static String ice_staticId() {
/* 6498 */     return __ids[1];
/*      */   }
/*      */ 
/*      */   
/*      */   public static void __write(BasicStream __os, XmdsManagerPrx v) {
/* 6503 */     __os.writeProxy(v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static XmdsManagerPrx __read(BasicStream __is) {
/* 6508 */     ObjectPrx proxy = __is.readProxy();
/* 6509 */     if (proxy != null) {
/*      */       
/* 6511 */       XmdsManagerPrxHelper result = new XmdsManagerPrxHelper();
/* 6512 */       result.__copyFrom(proxy);
/* 6513 */       return result;
/*      */     } 
/* 6515 */     return null;
/*      */   }
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\Xmds\XmdsManagerPrxHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */