package Xmds;

import java.util.Map;

public final class XmdsManagerPrxHelper extends ObjectPrxHelperBase implements XmdsManagerPrx {
    private static final String __addPlayerAtt_name = "addPlayerAtt";
    private static final String __addUnit_name = "addUnit";
    private static final String __addUnits_name = "addUnits";
    private static final String __autoBattle_name = "autoBattle";
    private static final String __canTalkWithNpc_name = "canTalkWithNpc";
    private static final String __canUseItem_name = "canUseItem";
    private static final String __getAllNpcInfo_name = "getAllNpcInfo";
    private static final String __getAllPlayerUUID_name = "getAllPlayerUUID";
    private static final String __getAllUnitInfo_name = "getAllUnitInfo";
    private static final String __getBornPlace_name = "getBornPlace";
    private static final String __getInstanceStatistic_name = "getInstanceStatistic";
    private static final String __getPlayerData_name = "getPlayerData";
    private static final String __getPlayerPKInfoData_name = "getPlayerPKInfoData";
    private static final String __getPlayerPetData_name = "getPlayerPetData";
    private static final String __getPlayerSkillCDTime_name = "getPlayerSkillCDTime";
    private static final String __getPlayerStatistic_name = "getPlayerStatistic";
    private static final String __getZoneRegions_name = "getZoneRegions";
    private static final String __getZoneStaticData_name = "getZoneStaticData";
    private static final String __helpRevivePlayer_name = "helpRevivePlayer";
    private static final String __notifyBattleServer_name = "notifyBattleServer";
    private static final String __onFinishPickItem_name = "onFinishPickItem";
    private static final String __onMonsterDiedDrops_name = "onMonsterDiedDrops";

    public void addPlayerAtt(String playerId, String notifyPlayerIds, String key, int value) {
        addPlayerAtt(playerId, notifyPlayerIds, key, value, (Map<String, String>) null, false);
    }

    private static final String __playerReady_name = "playerReady";
    private static final String __refreshPlayerAvatar_name = "refreshPlayerAvatar";
    private static final String __refreshPlayerBasicData_name = "refreshPlayerBasicData";
    private static final String __refreshPlayerBattleEffect_name = "refreshPlayerBattleEffect";
    private static final String __refreshPlayerPKLevel_name = "refreshPlayerPKLevel";
    private static final String __refreshPlayerPKMode_name = "refreshPlayerPKMode";
    private static final String __refreshPlayerPKValue_name = "refreshPlayerPKValue";
    private static final String __refreshPlayerPetBaseInfoChange_name = "refreshPlayerPetBaseInfoChange";
    private static final String __refreshPlayerPetDataChange_name = "refreshPlayerPetDataChange";
    private static final String __refreshPlayerPetFollowModeChange_name = "refreshPlayerPetFollowModeChange";
    private static final String __refreshPlayerPetPropertyChange_name = "refreshPlayerPetPropertyChange";
    private static final String __refreshPlayerPetSkillChange_name = "refreshPlayerPetSkillChange";
    private static final String __refreshPlayerPropertyChange_name = "refreshPlayerPropertyChange";
    private static final String __refreshPlayerRemainBagCountData_name = "refreshPlayerRemainBagCountData";
    private static final String __refreshPlayerRemainTeamBagCountData_name = "refreshPlayerRemainTeamBagCountData";
    private static final String __refreshPlayerSkill_name = "refreshPlayerSkill";
    private static final String __refreshPlayerTeamData_name = "refreshPlayerTeamData";
    private static final String __refreshSummonMount_name = "refreshSummonMount";
    private static final String __refreshTeamData_name = "refreshTeamData";
    private static final String __removeUnit_name = "removeUnit";
    private static final String __revivePlayer_name = "revivePlayer";
    private static final String __triggrBattleFunction_name = "triggrBattleFunction";

    public void addPlayerAtt(String playerId, String notifyPlayerIds, String key, int value, Map<String, String> __ctx) {
        addPlayerAtt(playerId, notifyPlayerIds, key, value, __ctx, true);
    }


    private void addPlayerAtt(String playerId, String notifyPlayerIds, String key, int value, Map<String, String> __ctx, boolean __explicitCtx) {
        end_addPlayerAtt(begin_addPlayerAtt(playerId, notifyPlayerIds, key, value, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_addPlayerAtt(String playerId, String notifyPlayerIds, String key, int value) {
        return begin_addPlayerAtt(playerId, notifyPlayerIds, key, value, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_addPlayerAtt(String playerId, String notifyPlayerIds, String key, int value, Map<String, String> __ctx) {
        return begin_addPlayerAtt(playerId, notifyPlayerIds, key, value, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_addPlayerAtt(String playerId, String notifyPlayerIds, String key, int value, Callback __cb) {
        return begin_addPlayerAtt(playerId, notifyPlayerIds, key, value, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_addPlayerAtt(String playerId, String notifyPlayerIds, String key, int value, Map<String, String> __ctx, Callback __cb) {
        return begin_addPlayerAtt(playerId, notifyPlayerIds, key, value, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_addPlayerAtt(String playerId, String notifyPlayerIds, String key, int value, Callback_XmdsManager_addPlayerAtt __cb) {
        return begin_addPlayerAtt(playerId, notifyPlayerIds, key, value, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_addPlayerAtt(String playerId, String notifyPlayerIds, String key, int value, Map<String, String> __ctx, Callback_XmdsManager_addPlayerAtt __cb) {
        return begin_addPlayerAtt(playerId, notifyPlayerIds, key, value, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_addPlayerAtt(String playerId, String notifyPlayerIds, String key, int value, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_addPlayerAtt(playerId, notifyPlayerIds, key, value, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_addPlayerAtt(String playerId, String notifyPlayerIds, String key, int value, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_addPlayerAtt(playerId, notifyPlayerIds, key, value, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_addPlayerAtt(String playerId, String notifyPlayerIds, String key, int value, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_addPlayerAtt(playerId, notifyPlayerIds, key, value, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_addPlayerAtt(String playerId, String notifyPlayerIds, String key, int value, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_addPlayerAtt(playerId, notifyPlayerIds, key, value, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_addPlayerAtt(String playerId, String notifyPlayerIds, String key, int value, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_addPlayerAtt(playerId, notifyPlayerIds, key, value, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }


    private AsyncResult begin_addPlayerAtt(String playerId, String notifyPlayerIds, String key, int value, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        OutgoingAsync __result = getOutgoingAsync("addPlayerAtt", __cb);

        try {
            __result.prepare("addPlayerAtt", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(playerId);
            __os.writeString(notifyPlayerIds);
            __os.writeString(key);
            __os.writeInt(value);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public void end_addPlayerAtt(AsyncResult __iresult) {
        __end(__iresult, "addPlayerAtt");
    }


    public int addUnit(String instanceId, int unitTemplateID, String data) {
        return addUnit(instanceId, unitTemplateID, data, (Map<String, String>) null, false);
    }


    public int addUnit(String instanceId, int unitTemplateID, String data, Map<String, String> __ctx) {
        return addUnit(instanceId, unitTemplateID, data, __ctx, true);
    }


    private int addUnit(String instanceId, int unitTemplateID, String data, Map<String, String> __ctx, boolean __explicitCtx) {
        __checkTwowayOnly("addUnit");
        return end_addUnit(begin_addUnit(instanceId, unitTemplateID, data, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_addUnit(String instanceId, int unitTemplateID, String data) {
        return begin_addUnit(instanceId, unitTemplateID, data, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_addUnit(String instanceId, int unitTemplateID, String data, Map<String, String> __ctx) {
        return begin_addUnit(instanceId, unitTemplateID, data, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_addUnit(String instanceId, int unitTemplateID, String data, Callback __cb) {
        return begin_addUnit(instanceId, unitTemplateID, data, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_addUnit(String instanceId, int unitTemplateID, String data, Map<String, String> __ctx, Callback __cb) {
        return begin_addUnit(instanceId, unitTemplateID, data, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_addUnit(String instanceId, int unitTemplateID, String data, Callback_XmdsManager_addUnit __cb) {
        return begin_addUnit(instanceId, unitTemplateID, data, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_addUnit(String instanceId, int unitTemplateID, String data, Map<String, String> __ctx, Callback_XmdsManager_addUnit __cb) {
        return begin_addUnit(instanceId, unitTemplateID, data, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_addUnit(String instanceId, int unitTemplateID, String data, Functional_IntCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_addUnit(instanceId, unitTemplateID, data, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_addUnit(String instanceId, int unitTemplateID, String data, Functional_IntCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_addUnit(instanceId, unitTemplateID, data, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_addUnit(String instanceId, int unitTemplateID, String data, Map<String, String> __ctx, Functional_IntCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_addUnit(instanceId, unitTemplateID, data, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_addUnit(String instanceId, int unitTemplateID, String data, Map<String, String> __ctx, Functional_IntCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_addUnit(instanceId, unitTemplateID, data, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_addUnit(String instanceId, int unitTemplateID, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_IntCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_addUnit(instanceId, unitTemplateID, data, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_TwowayCallbackInt(__responseCb, __exceptionCb, __sentCb) {

            public final void __completed(AsyncResult __result) {
                XmdsManagerPrxHelper.__addUnit_completed((TwowayCallbackInt) this, __result);
            }
        });
    }


    private AsyncResult begin_addUnit(String instanceId, int unitTemplateID, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        __checkAsyncTwowayOnly("addUnit");
        OutgoingAsync __result = getOutgoingAsync("addUnit", __cb);

        try {
            __result.prepare("addUnit", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(instanceId);
            __os.writeInt(unitTemplateID);
            __os.writeString(data);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public int end_addUnit(AsyncResult __iresult) {
        OutgoingAsync __result = OutgoingAsync.check(__iresult, this, "addUnit");

        try {
            if (!__result.__wait()) {

                try {

                    __result.throwUserException();
                } catch (UserException __ex) {

                    throw new UnknownUserException(__ex.ice_name(), __ex);
                }
            }
            BasicStream __is = __result.startReadParams();

            int __ret = __is.readInt();
            __result.endReadParams();
            return __ret;
        } finally {

            if (__result != null) {
                __result.cacheMessageBuffers();
            }
        }
    }


    public static void __addUnit_completed(TwowayCallbackInt __cb, AsyncResult __result) {
        XmdsManagerPrx __proxy = (XmdsManagerPrx) __result.getProxy();
        int __ret = 0;

        try {
            __ret = __proxy.end_addUnit(__result);
        } catch (LocalException __ex) {

            __cb.exception(__ex);

            return;
        } catch (SystemException __ex) {

            __cb.exception(__ex);
            return;
        }
        __cb.response(__ret);
    }


    public void addUnits(String instanceId, String data) {
        addUnits(instanceId, data, (Map<String, String>) null, false);
    }


    public void addUnits(String instanceId, String data, Map<String, String> __ctx) {
        addUnits(instanceId, data, __ctx, true);
    }


    private void addUnits(String instanceId, String data, Map<String, String> __ctx, boolean __explicitCtx) {
        end_addUnits(begin_addUnits(instanceId, data, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_addUnits(String instanceId, String data) {
        return begin_addUnits(instanceId, data, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_addUnits(String instanceId, String data, Map<String, String> __ctx) {
        return begin_addUnits(instanceId, data, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_addUnits(String instanceId, String data, Callback __cb) {
        return begin_addUnits(instanceId, data, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_addUnits(String instanceId, String data, Map<String, String> __ctx, Callback __cb) {
        return begin_addUnits(instanceId, data, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_addUnits(String instanceId, String data, Callback_XmdsManager_addUnits __cb) {
        return begin_addUnits(instanceId, data, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_addUnits(String instanceId, String data, Map<String, String> __ctx, Callback_XmdsManager_addUnits __cb) {
        return begin_addUnits(instanceId, data, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_addUnits(String instanceId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_addUnits(instanceId, data, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_addUnits(String instanceId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_addUnits(instanceId, data, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_addUnits(String instanceId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_addUnits(instanceId, data, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_addUnits(String instanceId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_addUnits(instanceId, data, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_addUnits(String instanceId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_addUnits(instanceId, data, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }


    private AsyncResult begin_addUnits(String instanceId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        OutgoingAsync __result = getOutgoingAsync("addUnits", __cb);

        try {
            __result.prepare("addUnits", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(instanceId);
            __os.writeString(data);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public void end_addUnits(AsyncResult __iresult) {
        __end(__iresult, "addUnits");
    }


    public void autoBattle(String instanceId, String playerId, boolean enable) {
        autoBattle(instanceId, playerId, enable, (Map<String, String>) null, false);
    }


    public void autoBattle(String instanceId, String playerId, boolean enable, Map<String, String> __ctx) {
        autoBattle(instanceId, playerId, enable, __ctx, true);
    }


    private void autoBattle(String instanceId, String playerId, boolean enable, Map<String, String> __ctx, boolean __explicitCtx) {
        end_autoBattle(begin_autoBattle(instanceId, playerId, enable, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_autoBattle(String instanceId, String playerId, boolean enable) {
        return begin_autoBattle(instanceId, playerId, enable, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_autoBattle(String instanceId, String playerId, boolean enable, Map<String, String> __ctx) {
        return begin_autoBattle(instanceId, playerId, enable, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_autoBattle(String instanceId, String playerId, boolean enable, Callback __cb) {
        return begin_autoBattle(instanceId, playerId, enable, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_autoBattle(String instanceId, String playerId, boolean enable, Map<String, String> __ctx, Callback __cb) {
        return begin_autoBattle(instanceId, playerId, enable, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_autoBattle(String instanceId, String playerId, boolean enable, Callback_XmdsManager_autoBattle __cb) {
        return begin_autoBattle(instanceId, playerId, enable, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_autoBattle(String instanceId, String playerId, boolean enable, Map<String, String> __ctx, Callback_XmdsManager_autoBattle __cb) {
        return begin_autoBattle(instanceId, playerId, enable, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_autoBattle(String instanceId, String playerId, boolean enable, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_autoBattle(instanceId, playerId, enable, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_autoBattle(String instanceId, String playerId, boolean enable, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_autoBattle(instanceId, playerId, enable, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_autoBattle(String instanceId, String playerId, boolean enable, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_autoBattle(instanceId, playerId, enable, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_autoBattle(String instanceId, String playerId, boolean enable, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_autoBattle(instanceId, playerId, enable, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_autoBattle(String instanceId, String playerId, boolean enable, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_autoBattle(instanceId, playerId, enable, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }


    private AsyncResult begin_autoBattle(String instanceId, String playerId, boolean enable, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        OutgoingAsync __result = getOutgoingAsync("autoBattle", __cb);

        try {
            __result.prepare("autoBattle", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(instanceId);
            __os.writeString(playerId);
            __os.writeBool(enable);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public void end_autoBattle(AsyncResult __iresult) {
        __end(__iresult, "autoBattle");
    }


    public String canTalkWithNpc(String playerId, int npcId) {
        return canTalkWithNpc(playerId, npcId, (Map<String, String>) null, false);
    }


    public String canTalkWithNpc(String playerId, int npcId, Map<String, String> __ctx) {
        return canTalkWithNpc(playerId, npcId, __ctx, true);
    }


    private String canTalkWithNpc(String playerId, int npcId, Map<String, String> __ctx, boolean __explicitCtx) {
        __checkTwowayOnly("canTalkWithNpc");
        return end_canTalkWithNpc(begin_canTalkWithNpc(playerId, npcId, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_canTalkWithNpc(String playerId, int npcId) {
        return begin_canTalkWithNpc(playerId, npcId, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_canTalkWithNpc(String playerId, int npcId, Map<String, String> __ctx) {
        return begin_canTalkWithNpc(playerId, npcId, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_canTalkWithNpc(String playerId, int npcId, Callback __cb) {
        return begin_canTalkWithNpc(playerId, npcId, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_canTalkWithNpc(String playerId, int npcId, Map<String, String> __ctx, Callback __cb) {
        return begin_canTalkWithNpc(playerId, npcId, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_canTalkWithNpc(String playerId, int npcId, Callback_XmdsManager_canTalkWithNpc __cb) {
        return begin_canTalkWithNpc(playerId, npcId, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_canTalkWithNpc(String playerId, int npcId, Map<String, String> __ctx, Callback_XmdsManager_canTalkWithNpc __cb) {
        return begin_canTalkWithNpc(playerId, npcId, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_canTalkWithNpc(String playerId, int npcId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_canTalkWithNpc(playerId, npcId, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_canTalkWithNpc(String playerId, int npcId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_canTalkWithNpc(playerId, npcId, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_canTalkWithNpc(String playerId, int npcId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_canTalkWithNpc(playerId, npcId, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_canTalkWithNpc(String playerId, int npcId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_canTalkWithNpc(playerId, npcId, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_canTalkWithNpc(String playerId, int npcId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_canTalkWithNpc(playerId, npcId, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_TwowayCallbackArg1<String>(__responseCb, __exceptionCb, __sentCb) {

            public final void __completed(AsyncResult __result) {
                XmdsManagerPrxHelper.__canTalkWithNpc_completed((TwowayCallbackArg1<String>) this, __result);
            }
        });
    }


    private AsyncResult begin_canTalkWithNpc(String playerId, int npcId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        __checkAsyncTwowayOnly("canTalkWithNpc");
        OutgoingAsync __result = getOutgoingAsync("canTalkWithNpc", __cb);

        try {
            __result.prepare("canTalkWithNpc", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(playerId);
            __os.writeInt(npcId);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public String end_canTalkWithNpc(AsyncResult __iresult) {
        OutgoingAsync __result = OutgoingAsync.check(__iresult, this, "canTalkWithNpc");

        try {
            if (!__result.__wait()) {

                try {

                    __result.throwUserException();
                } catch (UserException __ex) {

                    throw new UnknownUserException(__ex.ice_name(), __ex);
                }
            }
            BasicStream __is = __result.startReadParams();

            String __ret = __is.readString();
            __result.endReadParams();
            return __ret;
        } finally {

            if (__result != null) {
                __result.cacheMessageBuffers();
            }
        }
    }


    public static void __canTalkWithNpc_completed(TwowayCallbackArg1<String> __cb, AsyncResult __result) {
        XmdsManagerPrx __proxy = (XmdsManagerPrx) __result.getProxy();
        String __ret = null;

        try {
            __ret = __proxy.end_canTalkWithNpc(__result);
        } catch (LocalException __ex) {

            __cb.exception(__ex);

            return;
        } catch (SystemException __ex) {

            __cb.exception(__ex);
            return;
        }
        __cb.response(__ret);
    }


    public boolean canUseItem(String playerId) {
        return canUseItem(playerId, (Map<String, String>) null, false);
    }


    public boolean canUseItem(String playerId, Map<String, String> __ctx) {
        return canUseItem(playerId, __ctx, true);
    }


    private boolean canUseItem(String playerId, Map<String, String> __ctx, boolean __explicitCtx) {
        __checkTwowayOnly("canUseItem");
        return end_canUseItem(begin_canUseItem(playerId, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_canUseItem(String playerId) {
        return begin_canUseItem(playerId, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_canUseItem(String playerId, Map<String, String> __ctx) {
        return begin_canUseItem(playerId, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_canUseItem(String playerId, Callback __cb) {
        return begin_canUseItem(playerId, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_canUseItem(String playerId, Map<String, String> __ctx, Callback __cb) {
        return begin_canUseItem(playerId, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_canUseItem(String playerId, Callback_XmdsManager_canUseItem __cb) {
        return begin_canUseItem(playerId, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_canUseItem(String playerId, Map<String, String> __ctx, Callback_XmdsManager_canUseItem __cb) {
        return begin_canUseItem(playerId, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_canUseItem(String playerId, Functional_BoolCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_canUseItem(playerId, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_canUseItem(String playerId, Functional_BoolCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_canUseItem(playerId, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_canUseItem(String playerId, Map<String, String> __ctx, Functional_BoolCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_canUseItem(playerId, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_canUseItem(String playerId, Map<String, String> __ctx, Functional_BoolCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_canUseItem(playerId, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_canUseItem(String playerId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_BoolCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_canUseItem(playerId, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_TwowayCallbackBool(__responseCb, __exceptionCb, __sentCb) {

            public final void __completed(AsyncResult __result) {
                XmdsManagerPrxHelper.__canUseItem_completed((TwowayCallbackBool) this, __result);
            }
        });
    }


    private AsyncResult begin_canUseItem(String playerId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        __checkAsyncTwowayOnly("canUseItem");
        OutgoingAsync __result = getOutgoingAsync("canUseItem", __cb);

        try {
            __result.prepare("canUseItem", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(playerId);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public boolean end_canUseItem(AsyncResult __iresult) {
        OutgoingAsync __result = OutgoingAsync.check(__iresult, this, "canUseItem");

        try {
            if (!__result.__wait()) {

                try {

                    __result.throwUserException();
                } catch (UserException __ex) {

                    throw new UnknownUserException(__ex.ice_name(), __ex);
                }
            }
            BasicStream __is = __result.startReadParams();

            boolean __ret = __is.readBool();
            __result.endReadParams();
            return __ret;
        } finally {

            if (__result != null) {
                __result.cacheMessageBuffers();
            }
        }
    }


    public static void __canUseItem_completed(TwowayCallbackBool __cb, AsyncResult __result) {
        XmdsManagerPrx __proxy = (XmdsManagerPrx) __result.getProxy();
        boolean __ret = false;

        try {
            __ret = __proxy.end_canUseItem(__result);
        } catch (LocalException __ex) {

            __cb.exception(__ex);

            return;
        } catch (SystemException __ex) {

            __cb.exception(__ex);
            return;
        }
        __cb.response(__ret);
    }


    public String getAllNpcInfo(String instanceId) {
        return getAllNpcInfo(instanceId, (Map<String, String>) null, false);
    }


    public String getAllNpcInfo(String instanceId, Map<String, String> __ctx) {
        return getAllNpcInfo(instanceId, __ctx, true);
    }


    private String getAllNpcInfo(String instanceId, Map<String, String> __ctx, boolean __explicitCtx) {
        __checkTwowayOnly("getAllNpcInfo");
        return end_getAllNpcInfo(begin_getAllNpcInfo(instanceId, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_getAllNpcInfo(String instanceId) {
        return begin_getAllNpcInfo(instanceId, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_getAllNpcInfo(String instanceId, Map<String, String> __ctx) {
        return begin_getAllNpcInfo(instanceId, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_getAllNpcInfo(String instanceId, Callback __cb) {
        return begin_getAllNpcInfo(instanceId, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getAllNpcInfo(String instanceId, Map<String, String> __ctx, Callback __cb) {
        return begin_getAllNpcInfo(instanceId, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getAllNpcInfo(String instanceId, Callback_XmdsManager_getAllNpcInfo __cb) {
        return begin_getAllNpcInfo(instanceId, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getAllNpcInfo(String instanceId, Map<String, String> __ctx, Callback_XmdsManager_getAllNpcInfo __cb) {
        return begin_getAllNpcInfo(instanceId, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getAllNpcInfo(String instanceId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_getAllNpcInfo(instanceId, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_getAllNpcInfo(String instanceId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getAllNpcInfo(instanceId, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_getAllNpcInfo(String instanceId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_getAllNpcInfo(instanceId, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_getAllNpcInfo(String instanceId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getAllNpcInfo(instanceId, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_getAllNpcInfo(String instanceId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getAllNpcInfo(instanceId, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_TwowayCallbackArg1<String>(__responseCb, __exceptionCb, __sentCb) {

            public final void __completed(AsyncResult __result) {
                XmdsManagerPrxHelper.__getAllNpcInfo_completed((TwowayCallbackArg1<String>) this, __result);
            }
        });
    }


    private AsyncResult begin_getAllNpcInfo(String instanceId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        __checkAsyncTwowayOnly("getAllNpcInfo");
        OutgoingAsync __result = getOutgoingAsync("getAllNpcInfo", __cb);

        try {
            __result.prepare("getAllNpcInfo", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(instanceId);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public String end_getAllNpcInfo(AsyncResult __iresult) {
        OutgoingAsync __result = OutgoingAsync.check(__iresult, this, "getAllNpcInfo");

        try {
            if (!__result.__wait()) {

                try {

                    __result.throwUserException();
                } catch (UserException __ex) {

                    throw new UnknownUserException(__ex.ice_name(), __ex);
                }
            }
            BasicStream __is = __result.startReadParams();

            String __ret = __is.readString();
            __result.endReadParams();
            return __ret;
        } finally {

            if (__result != null) {
                __result.cacheMessageBuffers();
            }
        }
    }


    public static void __getAllNpcInfo_completed(TwowayCallbackArg1<String> __cb, AsyncResult __result) {
        XmdsManagerPrx __proxy = (XmdsManagerPrx) __result.getProxy();
        String __ret = null;

        try {
            __ret = __proxy.end_getAllNpcInfo(__result);
        } catch (LocalException __ex) {

            __cb.exception(__ex);

            return;
        } catch (SystemException __ex) {

            __cb.exception(__ex);
            return;
        }
        __cb.response(__ret);
    }


    public String getAllPlayerUUID() {
        return getAllPlayerUUID((Map<String, String>) null, false);
    }


    public String getAllPlayerUUID(Map<String, String> __ctx) {
        return getAllPlayerUUID(__ctx, true);
    }


    private String getAllPlayerUUID(Map<String, String> __ctx, boolean __explicitCtx) {
        __checkTwowayOnly("getAllPlayerUUID");
        return end_getAllPlayerUUID(begin_getAllPlayerUUID(__ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_getAllPlayerUUID() {
        return begin_getAllPlayerUUID((Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_getAllPlayerUUID(Map<String, String> __ctx) {
        return begin_getAllPlayerUUID(__ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_getAllPlayerUUID(Callback __cb) {
        return begin_getAllPlayerUUID((Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getAllPlayerUUID(Map<String, String> __ctx, Callback __cb) {
        return begin_getAllPlayerUUID(__ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getAllPlayerUUID(Callback_XmdsManager_getAllPlayerUUID __cb) {
        return begin_getAllPlayerUUID((Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getAllPlayerUUID(Map<String, String> __ctx, Callback_XmdsManager_getAllPlayerUUID __cb) {
        return begin_getAllPlayerUUID(__ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getAllPlayerUUID(Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_getAllPlayerUUID((Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_getAllPlayerUUID(Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getAllPlayerUUID((Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_getAllPlayerUUID(Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_getAllPlayerUUID(__ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_getAllPlayerUUID(Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getAllPlayerUUID(__ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_getAllPlayerUUID(Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getAllPlayerUUID(__ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_TwowayCallbackArg1<String>(__responseCb, __exceptionCb, __sentCb) {

            public final void __completed(AsyncResult __result) {
                XmdsManagerPrxHelper.__getAllPlayerUUID_completed((TwowayCallbackArg1<String>) this, __result);
            }
        });
    }


    private AsyncResult begin_getAllPlayerUUID(Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        __checkAsyncTwowayOnly("getAllPlayerUUID");
        OutgoingAsync __result = getOutgoingAsync("getAllPlayerUUID", __cb);

        try {
            __result.prepare("getAllPlayerUUID", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            __result.writeEmptyParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public String end_getAllPlayerUUID(AsyncResult __iresult) {
        OutgoingAsync __result = OutgoingAsync.check(__iresult, this, "getAllPlayerUUID");

        try {
            if (!__result.__wait()) {

                try {

                    __result.throwUserException();
                } catch (UserException __ex) {

                    throw new UnknownUserException(__ex.ice_name(), __ex);
                }
            }
            BasicStream __is = __result.startReadParams();

            String __ret = __is.readString();
            __result.endReadParams();
            return __ret;
        } finally {

            if (__result != null) {
                __result.cacheMessageBuffers();
            }
        }
    }


    public static void __getAllPlayerUUID_completed(TwowayCallbackArg1<String> __cb, AsyncResult __result) {
        XmdsManagerPrx __proxy = (XmdsManagerPrx) __result.getProxy();
        String __ret = null;

        try {
            __ret = __proxy.end_getAllPlayerUUID(__result);
        } catch (LocalException __ex) {

            __cb.exception(__ex);

            return;
        } catch (SystemException __ex) {

            __cb.exception(__ex);
            return;
        }
        __cb.response(__ret);
    }


    public String getAllUnitInfo(String instanceId) {
        return getAllUnitInfo(instanceId, (Map<String, String>) null, false);
    }


    public String getAllUnitInfo(String instanceId, Map<String, String> __ctx) {
        return getAllUnitInfo(instanceId, __ctx, true);
    }


    private String getAllUnitInfo(String instanceId, Map<String, String> __ctx, boolean __explicitCtx) {
        __checkTwowayOnly("getAllUnitInfo");
        return end_getAllUnitInfo(begin_getAllUnitInfo(instanceId, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_getAllUnitInfo(String instanceId) {
        return begin_getAllUnitInfo(instanceId, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_getAllUnitInfo(String instanceId, Map<String, String> __ctx) {
        return begin_getAllUnitInfo(instanceId, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_getAllUnitInfo(String instanceId, Callback __cb) {
        return begin_getAllUnitInfo(instanceId, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getAllUnitInfo(String instanceId, Map<String, String> __ctx, Callback __cb) {
        return begin_getAllUnitInfo(instanceId, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getAllUnitInfo(String instanceId, Callback_XmdsManager_getAllUnitInfo __cb) {
        return begin_getAllUnitInfo(instanceId, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getAllUnitInfo(String instanceId, Map<String, String> __ctx, Callback_XmdsManager_getAllUnitInfo __cb) {
        return begin_getAllUnitInfo(instanceId, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getAllUnitInfo(String instanceId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_getAllUnitInfo(instanceId, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_getAllUnitInfo(String instanceId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getAllUnitInfo(instanceId, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_getAllUnitInfo(String instanceId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_getAllUnitInfo(instanceId, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_getAllUnitInfo(String instanceId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getAllUnitInfo(instanceId, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_getAllUnitInfo(String instanceId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getAllUnitInfo(instanceId, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_TwowayCallbackArg1<String>(__responseCb, __exceptionCb, __sentCb) {

            public final void __completed(AsyncResult __result) {
                XmdsManagerPrxHelper.__getAllUnitInfo_completed((TwowayCallbackArg1<String>) this, __result);
            }
        });
    }


    private AsyncResult begin_getAllUnitInfo(String instanceId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        __checkAsyncTwowayOnly("getAllUnitInfo");
        OutgoingAsync __result = getOutgoingAsync("getAllUnitInfo", __cb);

        try {
            __result.prepare("getAllUnitInfo", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(instanceId);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public String end_getAllUnitInfo(AsyncResult __iresult) {
        OutgoingAsync __result = OutgoingAsync.check(__iresult, this, "getAllUnitInfo");

        try {
            if (!__result.__wait()) {

                try {

                    __result.throwUserException();
                } catch (UserException __ex) {

                    throw new UnknownUserException(__ex.ice_name(), __ex);
                }
            }
            BasicStream __is = __result.startReadParams();

            String __ret = __is.readString();
            __result.endReadParams();
            return __ret;
        } finally {

            if (__result != null) {
                __result.cacheMessageBuffers();
            }
        }
    }


    public static void __getAllUnitInfo_completed(TwowayCallbackArg1<String> __cb, AsyncResult __result) {
        XmdsManagerPrx __proxy = (XmdsManagerPrx) __result.getProxy();
        String __ret = null;

        try {
            __ret = __proxy.end_getAllUnitInfo(__result);
        } catch (LocalException __ex) {

            __cb.exception(__ex);

            return;
        } catch (SystemException __ex) {

            __cb.exception(__ex);
            return;
        }
        __cb.response(__ret);
    }


    public String getBornPlace(String instanceId, int areaId) {
        return getBornPlace(instanceId, areaId, (Map<String, String>) null, false);
    }


    public String getBornPlace(String instanceId, int areaId, Map<String, String> __ctx) {
        return getBornPlace(instanceId, areaId, __ctx, true);
    }


    private String getBornPlace(String instanceId, int areaId, Map<String, String> __ctx, boolean __explicitCtx) {
        __checkTwowayOnly("getBornPlace");
        return end_getBornPlace(begin_getBornPlace(instanceId, areaId, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_getBornPlace(String instanceId, int areaId) {
        return begin_getBornPlace(instanceId, areaId, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_getBornPlace(String instanceId, int areaId, Map<String, String> __ctx) {
        return begin_getBornPlace(instanceId, areaId, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_getBornPlace(String instanceId, int areaId, Callback __cb) {
        return begin_getBornPlace(instanceId, areaId, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getBornPlace(String instanceId, int areaId, Map<String, String> __ctx, Callback __cb) {
        return begin_getBornPlace(instanceId, areaId, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getBornPlace(String instanceId, int areaId, Callback_XmdsManager_getBornPlace __cb) {
        return begin_getBornPlace(instanceId, areaId, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getBornPlace(String instanceId, int areaId, Map<String, String> __ctx, Callback_XmdsManager_getBornPlace __cb) {
        return begin_getBornPlace(instanceId, areaId, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getBornPlace(String instanceId, int areaId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_getBornPlace(instanceId, areaId, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_getBornPlace(String instanceId, int areaId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getBornPlace(instanceId, areaId, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_getBornPlace(String instanceId, int areaId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_getBornPlace(instanceId, areaId, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_getBornPlace(String instanceId, int areaId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getBornPlace(instanceId, areaId, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_getBornPlace(String instanceId, int areaId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getBornPlace(instanceId, areaId, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_TwowayCallbackArg1<String>(__responseCb, __exceptionCb, __sentCb) {

            public final void __completed(AsyncResult __result) {
                XmdsManagerPrxHelper.__getBornPlace_completed((TwowayCallbackArg1<String>) this, __result);
            }
        });
    }


    private AsyncResult begin_getBornPlace(String instanceId, int areaId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        __checkAsyncTwowayOnly("getBornPlace");
        OutgoingAsync __result = getOutgoingAsync("getBornPlace", __cb);

        try {
            __result.prepare("getBornPlace", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(instanceId);
            __os.writeInt(areaId);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public String end_getBornPlace(AsyncResult __iresult) {
        OutgoingAsync __result = OutgoingAsync.check(__iresult, this, "getBornPlace");

        try {
            if (!__result.__wait()) {

                try {

                    __result.throwUserException();
                } catch (UserException __ex) {

                    throw new UnknownUserException(__ex.ice_name(), __ex);
                }
            }
            BasicStream __is = __result.startReadParams();

            String __ret = __is.readString();
            __result.endReadParams();
            return __ret;
        } finally {

            if (__result != null) {
                __result.cacheMessageBuffers();
            }
        }
    }


    public static void __getBornPlace_completed(TwowayCallbackArg1<String> __cb, AsyncResult __result) {
        XmdsManagerPrx __proxy = (XmdsManagerPrx) __result.getProxy();
        String __ret = null;

        try {
            __ret = __proxy.end_getBornPlace(__result);
        } catch (LocalException __ex) {

            __cb.exception(__ex);

            return;
        } catch (SystemException __ex) {

            __cb.exception(__ex);
            return;
        }
        __cb.response(__ret);
    }


    public String getInstanceStatistic(String instanceId) {
        return getInstanceStatistic(instanceId, (Map<String, String>) null, false);
    }


    public String getInstanceStatistic(String instanceId, Map<String, String> __ctx) {
        return getInstanceStatistic(instanceId, __ctx, true);
    }


    private String getInstanceStatistic(String instanceId, Map<String, String> __ctx, boolean __explicitCtx) {
        __checkTwowayOnly("getInstanceStatistic");
        return end_getInstanceStatistic(begin_getInstanceStatistic(instanceId, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_getInstanceStatistic(String instanceId) {
        return begin_getInstanceStatistic(instanceId, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_getInstanceStatistic(String instanceId, Map<String, String> __ctx) {
        return begin_getInstanceStatistic(instanceId, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_getInstanceStatistic(String instanceId, Callback __cb) {
        return begin_getInstanceStatistic(instanceId, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getInstanceStatistic(String instanceId, Map<String, String> __ctx, Callback __cb) {
        return begin_getInstanceStatistic(instanceId, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getInstanceStatistic(String instanceId, Callback_XmdsManager_getInstanceStatistic __cb) {
        return begin_getInstanceStatistic(instanceId, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getInstanceStatistic(String instanceId, Map<String, String> __ctx, Callback_XmdsManager_getInstanceStatistic __cb) {
        return begin_getInstanceStatistic(instanceId, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getInstanceStatistic(String instanceId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_getInstanceStatistic(instanceId, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_getInstanceStatistic(String instanceId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getInstanceStatistic(instanceId, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_getInstanceStatistic(String instanceId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_getInstanceStatistic(instanceId, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_getInstanceStatistic(String instanceId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getInstanceStatistic(instanceId, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_getInstanceStatistic(String instanceId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getInstanceStatistic(instanceId, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_TwowayCallbackArg1<String>(__responseCb, __exceptionCb, __sentCb) {

            public final void __completed(AsyncResult __result) {
                XmdsManagerPrxHelper.__getInstanceStatistic_completed((TwowayCallbackArg1<String>) this, __result);
            }
        });
    }


    private AsyncResult begin_getInstanceStatistic(String instanceId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        __checkAsyncTwowayOnly("getInstanceStatistic");
        OutgoingAsync __result = getOutgoingAsync("getInstanceStatistic", __cb);

        try {
            __result.prepare("getInstanceStatistic", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(instanceId);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public String end_getInstanceStatistic(AsyncResult __iresult) {
        OutgoingAsync __result = OutgoingAsync.check(__iresult, this, "getInstanceStatistic");

        try {
            if (!__result.__wait()) {

                try {

                    __result.throwUserException();
                } catch (UserException __ex) {

                    throw new UnknownUserException(__ex.ice_name(), __ex);
                }
            }
            BasicStream __is = __result.startReadParams();

            String __ret = __is.readString();
            __result.endReadParams();
            return __ret;
        } finally {

            if (__result != null) {
                __result.cacheMessageBuffers();
            }
        }
    }


    public static void __getInstanceStatistic_completed(TwowayCallbackArg1<String> __cb, AsyncResult __result) {
        XmdsManagerPrx __proxy = (XmdsManagerPrx) __result.getProxy();
        String __ret = null;

        try {
            __ret = __proxy.end_getInstanceStatistic(__result);
        } catch (LocalException __ex) {

            __cb.exception(__ex);

            return;
        } catch (SystemException __ex) {

            __cb.exception(__ex);
            return;
        }
        __cb.response(__ret);
    }


    public String getPlayerData(String playerId, boolean changeArea) {
        return getPlayerData(playerId, changeArea, (Map<String, String>) null, false);
    }


    public String getPlayerData(String playerId, boolean changeArea, Map<String, String> __ctx) {
        return getPlayerData(playerId, changeArea, __ctx, true);
    }


    private String getPlayerData(String playerId, boolean changeArea, Map<String, String> __ctx, boolean __explicitCtx) {
        __checkTwowayOnly("getPlayerData");
        return end_getPlayerData(begin_getPlayerData(playerId, changeArea, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_getPlayerData(String playerId, boolean changeArea) {
        return begin_getPlayerData(playerId, changeArea, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_getPlayerData(String playerId, boolean changeArea, Map<String, String> __ctx) {
        return begin_getPlayerData(playerId, changeArea, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_getPlayerData(String playerId, boolean changeArea, Callback __cb) {
        return begin_getPlayerData(playerId, changeArea, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getPlayerData(String playerId, boolean changeArea, Map<String, String> __ctx, Callback __cb) {
        return begin_getPlayerData(playerId, changeArea, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getPlayerData(String playerId, boolean changeArea, Callback_XmdsManager_getPlayerData __cb) {
        return begin_getPlayerData(playerId, changeArea, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getPlayerData(String playerId, boolean changeArea, Map<String, String> __ctx, Callback_XmdsManager_getPlayerData __cb) {
        return begin_getPlayerData(playerId, changeArea, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getPlayerData(String playerId, boolean changeArea, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_getPlayerData(playerId, changeArea, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_getPlayerData(String playerId, boolean changeArea, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getPlayerData(playerId, changeArea, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_getPlayerData(String playerId, boolean changeArea, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_getPlayerData(playerId, changeArea, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_getPlayerData(String playerId, boolean changeArea, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getPlayerData(playerId, changeArea, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_getPlayerData(String playerId, boolean changeArea, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getPlayerData(playerId, changeArea, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_TwowayCallbackArg1<String>(__responseCb, __exceptionCb, __sentCb) {

            public final void __completed(AsyncResult __result) {
                XmdsManagerPrxHelper.__getPlayerData_completed((TwowayCallbackArg1<String>) this, __result);
            }
        });
    }


    private AsyncResult begin_getPlayerData(String playerId, boolean changeArea, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        __checkAsyncTwowayOnly("getPlayerData");
        OutgoingAsync __result = getOutgoingAsync("getPlayerData", __cb);

        try {
            __result.prepare("getPlayerData", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(playerId);
            __os.writeBool(changeArea);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public String end_getPlayerData(AsyncResult __iresult) {
        OutgoingAsync __result = OutgoingAsync.check(__iresult, this, "getPlayerData");

        try {
            if (!__result.__wait()) {

                try {

                    __result.throwUserException();
                } catch (UserException __ex) {

                    throw new UnknownUserException(__ex.ice_name(), __ex);
                }
            }
            BasicStream __is = __result.startReadParams();

            String __ret = __is.readString();
            __result.endReadParams();
            return __ret;
        } finally {

            if (__result != null) {
                __result.cacheMessageBuffers();
            }
        }
    }


    public static void __getPlayerData_completed(TwowayCallbackArg1<String> __cb, AsyncResult __result) {
        XmdsManagerPrx __proxy = (XmdsManagerPrx) __result.getProxy();
        String __ret = null;

        try {
            __ret = __proxy.end_getPlayerData(__result);
        } catch (LocalException __ex) {

            __cb.exception(__ex);

            return;
        } catch (SystemException __ex) {

            __cb.exception(__ex);
            return;
        }
        __cb.response(__ret);
    }


    public String getPlayerPKInfoData(String playerId) {
        return getPlayerPKInfoData(playerId, (Map<String, String>) null, false);
    }


    public String getPlayerPKInfoData(String playerId, Map<String, String> __ctx) {
        return getPlayerPKInfoData(playerId, __ctx, true);
    }


    private String getPlayerPKInfoData(String playerId, Map<String, String> __ctx, boolean __explicitCtx) {
        __checkTwowayOnly("getPlayerPKInfoData");
        return end_getPlayerPKInfoData(begin_getPlayerPKInfoData(playerId, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_getPlayerPKInfoData(String playerId) {
        return begin_getPlayerPKInfoData(playerId, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_getPlayerPKInfoData(String playerId, Map<String, String> __ctx) {
        return begin_getPlayerPKInfoData(playerId, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_getPlayerPKInfoData(String playerId, Callback __cb) {
        return begin_getPlayerPKInfoData(playerId, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getPlayerPKInfoData(String playerId, Map<String, String> __ctx, Callback __cb) {
        return begin_getPlayerPKInfoData(playerId, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getPlayerPKInfoData(String playerId, Callback_XmdsManager_getPlayerPKInfoData __cb) {
        return begin_getPlayerPKInfoData(playerId, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getPlayerPKInfoData(String playerId, Map<String, String> __ctx, Callback_XmdsManager_getPlayerPKInfoData __cb) {
        return begin_getPlayerPKInfoData(playerId, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getPlayerPKInfoData(String playerId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_getPlayerPKInfoData(playerId, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_getPlayerPKInfoData(String playerId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getPlayerPKInfoData(playerId, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_getPlayerPKInfoData(String playerId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_getPlayerPKInfoData(playerId, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_getPlayerPKInfoData(String playerId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getPlayerPKInfoData(playerId, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_getPlayerPKInfoData(String playerId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getPlayerPKInfoData(playerId, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_TwowayCallbackArg1<String>(__responseCb, __exceptionCb, __sentCb) {

            public final void __completed(AsyncResult __result) {
                XmdsManagerPrxHelper.__getPlayerPKInfoData_completed((TwowayCallbackArg1<String>) this, __result);
            }
        });
    }


    private AsyncResult begin_getPlayerPKInfoData(String playerId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        __checkAsyncTwowayOnly("getPlayerPKInfoData");
        OutgoingAsync __result = getOutgoingAsync("getPlayerPKInfoData", __cb);

        try {
            __result.prepare("getPlayerPKInfoData", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(playerId);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public String end_getPlayerPKInfoData(AsyncResult __iresult) {
        OutgoingAsync __result = OutgoingAsync.check(__iresult, this, "getPlayerPKInfoData");

        try {
            if (!__result.__wait()) {

                try {

                    __result.throwUserException();
                } catch (UserException __ex) {

                    throw new UnknownUserException(__ex.ice_name(), __ex);
                }
            }
            BasicStream __is = __result.startReadParams();

            String __ret = __is.readString();
            __result.endReadParams();
            return __ret;
        } finally {

            if (__result != null) {
                __result.cacheMessageBuffers();
            }
        }
    }


    public static void __getPlayerPKInfoData_completed(TwowayCallbackArg1<String> __cb, AsyncResult __result) {
        XmdsManagerPrx __proxy = (XmdsManagerPrx) __result.getProxy();
        String __ret = null;

        try {
            __ret = __proxy.end_getPlayerPKInfoData(__result);
        } catch (LocalException __ex) {

            __cb.exception(__ex);

            return;
        } catch (SystemException __ex) {

            __cb.exception(__ex);
            return;
        }
        __cb.response(__ret);
    }


    public String getPlayerPetData(String playerId) {
        return getPlayerPetData(playerId, (Map<String, String>) null, false);
    }


    public String getPlayerPetData(String playerId, Map<String, String> __ctx) {
        return getPlayerPetData(playerId, __ctx, true);
    }


    private String getPlayerPetData(String playerId, Map<String, String> __ctx, boolean __explicitCtx) {
        __checkTwowayOnly("getPlayerPetData");
        return end_getPlayerPetData(begin_getPlayerPetData(playerId, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_getPlayerPetData(String playerId) {
        return begin_getPlayerPetData(playerId, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_getPlayerPetData(String playerId, Map<String, String> __ctx) {
        return begin_getPlayerPetData(playerId, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_getPlayerPetData(String playerId, Callback __cb) {
        return begin_getPlayerPetData(playerId, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getPlayerPetData(String playerId, Map<String, String> __ctx, Callback __cb) {
        return begin_getPlayerPetData(playerId, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getPlayerPetData(String playerId, Callback_XmdsManager_getPlayerPetData __cb) {
        return begin_getPlayerPetData(playerId, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getPlayerPetData(String playerId, Map<String, String> __ctx, Callback_XmdsManager_getPlayerPetData __cb) {
        return begin_getPlayerPetData(playerId, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getPlayerPetData(String playerId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_getPlayerPetData(playerId, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_getPlayerPetData(String playerId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getPlayerPetData(playerId, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_getPlayerPetData(String playerId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_getPlayerPetData(playerId, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_getPlayerPetData(String playerId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getPlayerPetData(playerId, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_getPlayerPetData(String playerId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getPlayerPetData(playerId, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_TwowayCallbackArg1<String>(__responseCb, __exceptionCb, __sentCb) {

            public final void __completed(AsyncResult __result) {
                XmdsManagerPrxHelper.__getPlayerPetData_completed((TwowayCallbackArg1<String>) this, __result);
            }
        });
    }


    private AsyncResult begin_getPlayerPetData(String playerId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        __checkAsyncTwowayOnly("getPlayerPetData");
        OutgoingAsync __result = getOutgoingAsync("getPlayerPetData", __cb);

        try {
            __result.prepare("getPlayerPetData", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(playerId);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public String end_getPlayerPetData(AsyncResult __iresult) {
        OutgoingAsync __result = OutgoingAsync.check(__iresult, this, "getPlayerPetData");

        try {
            if (!__result.__wait()) {

                try {

                    __result.throwUserException();
                } catch (UserException __ex) {

                    throw new UnknownUserException(__ex.ice_name(), __ex);
                }
            }
            BasicStream __is = __result.startReadParams();

            String __ret = __is.readString();
            __result.endReadParams();
            return __ret;
        } finally {

            if (__result != null) {
                __result.cacheMessageBuffers();
            }
        }
    }


    public static void __getPlayerPetData_completed(TwowayCallbackArg1<String> __cb, AsyncResult __result) {
        XmdsManagerPrx __proxy = (XmdsManagerPrx) __result.getProxy();
        String __ret = null;

        try {
            __ret = __proxy.end_getPlayerPetData(__result);
        } catch (LocalException __ex) {

            __cb.exception(__ex);

            return;
        } catch (SystemException __ex) {

            __cb.exception(__ex);
            return;
        }
        __cb.response(__ret);
    }


    public String getPlayerSkillCDTime(String playerId) {
        return getPlayerSkillCDTime(playerId, (Map<String, String>) null, false);
    }


    public String getPlayerSkillCDTime(String playerId, Map<String, String> __ctx) {
        return getPlayerSkillCDTime(playerId, __ctx, true);
    }


    private String getPlayerSkillCDTime(String playerId, Map<String, String> __ctx, boolean __explicitCtx) {
        __checkTwowayOnly("getPlayerSkillCDTime");
        return end_getPlayerSkillCDTime(begin_getPlayerSkillCDTime(playerId, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_getPlayerSkillCDTime(String playerId) {
        return begin_getPlayerSkillCDTime(playerId, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_getPlayerSkillCDTime(String playerId, Map<String, String> __ctx) {
        return begin_getPlayerSkillCDTime(playerId, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_getPlayerSkillCDTime(String playerId, Callback __cb) {
        return begin_getPlayerSkillCDTime(playerId, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getPlayerSkillCDTime(String playerId, Map<String, String> __ctx, Callback __cb) {
        return begin_getPlayerSkillCDTime(playerId, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getPlayerSkillCDTime(String playerId, Callback_XmdsManager_getPlayerSkillCDTime __cb) {
        return begin_getPlayerSkillCDTime(playerId, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getPlayerSkillCDTime(String playerId, Map<String, String> __ctx, Callback_XmdsManager_getPlayerSkillCDTime __cb) {
        return begin_getPlayerSkillCDTime(playerId, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getPlayerSkillCDTime(String playerId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_getPlayerSkillCDTime(playerId, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_getPlayerSkillCDTime(String playerId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getPlayerSkillCDTime(playerId, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_getPlayerSkillCDTime(String playerId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_getPlayerSkillCDTime(playerId, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_getPlayerSkillCDTime(String playerId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getPlayerSkillCDTime(playerId, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_getPlayerSkillCDTime(String playerId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getPlayerSkillCDTime(playerId, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_TwowayCallbackArg1<String>(__responseCb, __exceptionCb, __sentCb) {

            public final void __completed(AsyncResult __result) {
                XmdsManagerPrxHelper.__getPlayerSkillCDTime_completed((TwowayCallbackArg1<String>) this, __result);
            }
        });
    }


    private AsyncResult begin_getPlayerSkillCDTime(String playerId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        __checkAsyncTwowayOnly("getPlayerSkillCDTime");
        OutgoingAsync __result = getOutgoingAsync("getPlayerSkillCDTime", __cb);

        try {
            __result.prepare("getPlayerSkillCDTime", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(playerId);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public String end_getPlayerSkillCDTime(AsyncResult __iresult) {
        OutgoingAsync __result = OutgoingAsync.check(__iresult, this, "getPlayerSkillCDTime");

        try {
            if (!__result.__wait()) {

                try {

                    __result.throwUserException();
                } catch (UserException __ex) {

                    throw new UnknownUserException(__ex.ice_name(), __ex);
                }
            }
            BasicStream __is = __result.startReadParams();

            String __ret = __is.readString();
            __result.endReadParams();
            return __ret;
        } finally {

            if (__result != null) {
                __result.cacheMessageBuffers();
            }
        }
    }


    public static void __getPlayerSkillCDTime_completed(TwowayCallbackArg1<String> __cb, AsyncResult __result) {
        XmdsManagerPrx __proxy = (XmdsManagerPrx) __result.getProxy();
        String __ret = null;

        try {
            __ret = __proxy.end_getPlayerSkillCDTime(__result);
        } catch (LocalException __ex) {

            __cb.exception(__ex);

            return;
        } catch (SystemException __ex) {

            __cb.exception(__ex);
            return;
        }
        __cb.response(__ret);
    }


    public String getPlayerStatistic(String playerId) {
        return getPlayerStatistic(playerId, (Map<String, String>) null, false);
    }


    public String getPlayerStatistic(String playerId, Map<String, String> __ctx) {
        return getPlayerStatistic(playerId, __ctx, true);
    }


    private String getPlayerStatistic(String playerId, Map<String, String> __ctx, boolean __explicitCtx) {
        __checkTwowayOnly("getPlayerStatistic");
        return end_getPlayerStatistic(begin_getPlayerStatistic(playerId, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_getPlayerStatistic(String playerId) {
        return begin_getPlayerStatistic(playerId, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_getPlayerStatistic(String playerId, Map<String, String> __ctx) {
        return begin_getPlayerStatistic(playerId, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_getPlayerStatistic(String playerId, Callback __cb) {
        return begin_getPlayerStatistic(playerId, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getPlayerStatistic(String playerId, Map<String, String> __ctx, Callback __cb) {
        return begin_getPlayerStatistic(playerId, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getPlayerStatistic(String playerId, Callback_XmdsManager_getPlayerStatistic __cb) {
        return begin_getPlayerStatistic(playerId, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getPlayerStatistic(String playerId, Map<String, String> __ctx, Callback_XmdsManager_getPlayerStatistic __cb) {
        return begin_getPlayerStatistic(playerId, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getPlayerStatistic(String playerId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_getPlayerStatistic(playerId, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_getPlayerStatistic(String playerId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getPlayerStatistic(playerId, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_getPlayerStatistic(String playerId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_getPlayerStatistic(playerId, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_getPlayerStatistic(String playerId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getPlayerStatistic(playerId, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_getPlayerStatistic(String playerId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getPlayerStatistic(playerId, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_TwowayCallbackArg1<String>(__responseCb, __exceptionCb, __sentCb) {

            public final void __completed(AsyncResult __result) {
                XmdsManagerPrxHelper.__getPlayerStatistic_completed((TwowayCallbackArg1<String>) this, __result);
            }
        });
    }


    private AsyncResult begin_getPlayerStatistic(String playerId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        __checkAsyncTwowayOnly("getPlayerStatistic");
        OutgoingAsync __result = getOutgoingAsync("getPlayerStatistic", __cb);

        try {
            __result.prepare("getPlayerStatistic", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(playerId);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public String end_getPlayerStatistic(AsyncResult __iresult) {
        OutgoingAsync __result = OutgoingAsync.check(__iresult, this, "getPlayerStatistic");

        try {
            if (!__result.__wait()) {

                try {

                    __result.throwUserException();
                } catch (UserException __ex) {

                    throw new UnknownUserException(__ex.ice_name(), __ex);
                }
            }
            BasicStream __is = __result.startReadParams();

            String __ret = __is.readString();
            __result.endReadParams();
            return __ret;
        } finally {

            if (__result != null) {
                __result.cacheMessageBuffers();
            }
        }
    }


    public static void __getPlayerStatistic_completed(TwowayCallbackArg1<String> __cb, AsyncResult __result) {
        XmdsManagerPrx __proxy = (XmdsManagerPrx) __result.getProxy();
        String __ret = null;

        try {
            __ret = __proxy.end_getPlayerStatistic(__result);
        } catch (LocalException __ex) {

            __cb.exception(__ex);

            return;
        } catch (SystemException __ex) {

            __cb.exception(__ex);
            return;
        }
        __cb.response(__ret);
    }


    public String getZoneRegions(String instanceId) {
        return getZoneRegions(instanceId, (Map<String, String>) null, false);
    }


    public String getZoneRegions(String instanceId, Map<String, String> __ctx) {
        return getZoneRegions(instanceId, __ctx, true);
    }


    private String getZoneRegions(String instanceId, Map<String, String> __ctx, boolean __explicitCtx) {
        __checkTwowayOnly("getZoneRegions");
        return end_getZoneRegions(begin_getZoneRegions(instanceId, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_getZoneRegions(String instanceId) {
        return begin_getZoneRegions(instanceId, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_getZoneRegions(String instanceId, Map<String, String> __ctx) {
        return begin_getZoneRegions(instanceId, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_getZoneRegions(String instanceId, Callback __cb) {
        return begin_getZoneRegions(instanceId, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getZoneRegions(String instanceId, Map<String, String> __ctx, Callback __cb) {
        return begin_getZoneRegions(instanceId, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getZoneRegions(String instanceId, Callback_XmdsManager_getZoneRegions __cb) {
        return begin_getZoneRegions(instanceId, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getZoneRegions(String instanceId, Map<String, String> __ctx, Callback_XmdsManager_getZoneRegions __cb) {
        return begin_getZoneRegions(instanceId, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getZoneRegions(String instanceId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_getZoneRegions(instanceId, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_getZoneRegions(String instanceId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getZoneRegions(instanceId, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_getZoneRegions(String instanceId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_getZoneRegions(instanceId, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_getZoneRegions(String instanceId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getZoneRegions(instanceId, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_getZoneRegions(String instanceId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getZoneRegions(instanceId, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_TwowayCallbackArg1<String>(__responseCb, __exceptionCb, __sentCb) {

            public final void __completed(AsyncResult __result) {
                XmdsManagerPrxHelper.__getZoneRegions_completed((TwowayCallbackArg1<String>) this, __result);
            }
        });
    }


    private AsyncResult begin_getZoneRegions(String instanceId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        __checkAsyncTwowayOnly("getZoneRegions");
        OutgoingAsync __result = getOutgoingAsync("getZoneRegions", __cb);

        try {
            __result.prepare("getZoneRegions", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(instanceId);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public String end_getZoneRegions(AsyncResult __iresult) {
        OutgoingAsync __result = OutgoingAsync.check(__iresult, this, "getZoneRegions");

        try {
            if (!__result.__wait()) {

                try {

                    __result.throwUserException();
                } catch (UserException __ex) {

                    throw new UnknownUserException(__ex.ice_name(), __ex);
                }
            }
            BasicStream __is = __result.startReadParams();

            String __ret = __is.readString();
            __result.endReadParams();
            return __ret;
        } finally {

            if (__result != null) {
                __result.cacheMessageBuffers();
            }
        }
    }


    public static void __getZoneRegions_completed(TwowayCallbackArg1<String> __cb, AsyncResult __result) {
        XmdsManagerPrx __proxy = (XmdsManagerPrx) __result.getProxy();
        String __ret = null;

        try {
            __ret = __proxy.end_getZoneRegions(__result);
        } catch (LocalException __ex) {

            __cb.exception(__ex);

            return;
        } catch (SystemException __ex) {

            __cb.exception(__ex);
            return;
        }
        __cb.response(__ret);
    }


    public String getZoneStaticData(String instanceId) {
        return getZoneStaticData(instanceId, (Map<String, String>) null, false);
    }


    public String getZoneStaticData(String instanceId, Map<String, String> __ctx) {
        return getZoneStaticData(instanceId, __ctx, true);
    }


    private String getZoneStaticData(String instanceId, Map<String, String> __ctx, boolean __explicitCtx) {
        __checkTwowayOnly("getZoneStaticData");
        return end_getZoneStaticData(begin_getZoneStaticData(instanceId, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_getZoneStaticData(String instanceId) {
        return begin_getZoneStaticData(instanceId, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_getZoneStaticData(String instanceId, Map<String, String> __ctx) {
        return begin_getZoneStaticData(instanceId, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_getZoneStaticData(String instanceId, Callback __cb) {
        return begin_getZoneStaticData(instanceId, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getZoneStaticData(String instanceId, Map<String, String> __ctx, Callback __cb) {
        return begin_getZoneStaticData(instanceId, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getZoneStaticData(String instanceId, Callback_XmdsManager_getZoneStaticData __cb) {
        return begin_getZoneStaticData(instanceId, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getZoneStaticData(String instanceId, Map<String, String> __ctx, Callback_XmdsManager_getZoneStaticData __cb) {
        return begin_getZoneStaticData(instanceId, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_getZoneStaticData(String instanceId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_getZoneStaticData(instanceId, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_getZoneStaticData(String instanceId, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getZoneStaticData(instanceId, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_getZoneStaticData(String instanceId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_getZoneStaticData(instanceId, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_getZoneStaticData(String instanceId, Map<String, String> __ctx, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getZoneStaticData(instanceId, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_getZoneStaticData(String instanceId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_GenericCallback1<String> __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_getZoneStaticData(instanceId, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_TwowayCallbackArg1<String>(__responseCb, __exceptionCb, __sentCb) {

            public final void __completed(AsyncResult __result) {
                XmdsManagerPrxHelper.__getZoneStaticData_completed((TwowayCallbackArg1<String>) this, __result);
            }
        });
    }


    private AsyncResult begin_getZoneStaticData(String instanceId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        __checkAsyncTwowayOnly("getZoneStaticData");
        OutgoingAsync __result = getOutgoingAsync("getZoneStaticData", __cb);

        try {
            __result.prepare("getZoneStaticData", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(instanceId);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public String end_getZoneStaticData(AsyncResult __iresult) {
        OutgoingAsync __result = OutgoingAsync.check(__iresult, this, "getZoneStaticData");

        try {
            if (!__result.__wait()) {

                try {

                    __result.throwUserException();
                } catch (UserException __ex) {

                    throw new UnknownUserException(__ex.ice_name(), __ex);
                }
            }
            BasicStream __is = __result.startReadParams();

            String __ret = __is.readString();
            __result.endReadParams();
            return __ret;
        } finally {

            if (__result != null) {
                __result.cacheMessageBuffers();
            }
        }
    }


    public static void __getZoneStaticData_completed(TwowayCallbackArg1<String> __cb, AsyncResult __result) {
        XmdsManagerPrx __proxy = (XmdsManagerPrx) __result.getProxy();
        String __ret = null;

        try {
            __ret = __proxy.end_getZoneStaticData(__result);
        } catch (LocalException __ex) {

            __cb.exception(__ex);

            return;
        } catch (SystemException __ex) {

            __cb.exception(__ex);
            return;
        }
        __cb.response(__ret);
    }


    public void helpRevivePlayer(String playerId, String revivePlayerId, int time) {
        helpRevivePlayer(playerId, revivePlayerId, time, (Map<String, String>) null, false);
    }


    public void helpRevivePlayer(String playerId, String revivePlayerId, int time, Map<String, String> __ctx) {
        helpRevivePlayer(playerId, revivePlayerId, time, __ctx, true);
    }


    private void helpRevivePlayer(String playerId, String revivePlayerId, int time, Map<String, String> __ctx, boolean __explicitCtx) {
        end_helpRevivePlayer(begin_helpRevivePlayer(playerId, revivePlayerId, time, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_helpRevivePlayer(String playerId, String revivePlayerId, int time) {
        return begin_helpRevivePlayer(playerId, revivePlayerId, time, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_helpRevivePlayer(String playerId, String revivePlayerId, int time, Map<String, String> __ctx) {
        return begin_helpRevivePlayer(playerId, revivePlayerId, time, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_helpRevivePlayer(String playerId, String revivePlayerId, int time, Callback __cb) {
        return begin_helpRevivePlayer(playerId, revivePlayerId, time, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_helpRevivePlayer(String playerId, String revivePlayerId, int time, Map<String, String> __ctx, Callback __cb) {
        return begin_helpRevivePlayer(playerId, revivePlayerId, time, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_helpRevivePlayer(String playerId, String revivePlayerId, int time, Callback_XmdsManager_helpRevivePlayer __cb) {
        return begin_helpRevivePlayer(playerId, revivePlayerId, time, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_helpRevivePlayer(String playerId, String revivePlayerId, int time, Map<String, String> __ctx, Callback_XmdsManager_helpRevivePlayer __cb) {
        return begin_helpRevivePlayer(playerId, revivePlayerId, time, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_helpRevivePlayer(String playerId, String revivePlayerId, int time, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_helpRevivePlayer(playerId, revivePlayerId, time, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_helpRevivePlayer(String playerId, String revivePlayerId, int time, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_helpRevivePlayer(playerId, revivePlayerId, time, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_helpRevivePlayer(String playerId, String revivePlayerId, int time, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_helpRevivePlayer(playerId, revivePlayerId, time, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_helpRevivePlayer(String playerId, String revivePlayerId, int time, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_helpRevivePlayer(playerId, revivePlayerId, time, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_helpRevivePlayer(String playerId, String revivePlayerId, int time, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_helpRevivePlayer(playerId, revivePlayerId, time, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }


    private AsyncResult begin_helpRevivePlayer(String playerId, String revivePlayerId, int time, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        OutgoingAsync __result = getOutgoingAsync("helpRevivePlayer", __cb);

        try {
            __result.prepare("helpRevivePlayer", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(playerId);
            __os.writeString(revivePlayerId);
            __os.writeInt(time);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public void end_helpRevivePlayer(AsyncResult __iresult) {
        __end(__iresult, "helpRevivePlayer");
    }


    public void notifyBattleServer(String instanceId, String name, String data) {
        notifyBattleServer(instanceId, name, data, (Map<String, String>) null, false);
    }


    public void notifyBattleServer(String instanceId, String name, String data, Map<String, String> __ctx) {
        notifyBattleServer(instanceId, name, data, __ctx, true);
    }


    private void notifyBattleServer(String instanceId, String name, String data, Map<String, String> __ctx, boolean __explicitCtx) {
        end_notifyBattleServer(begin_notifyBattleServer(instanceId, name, data, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_notifyBattleServer(String instanceId, String name, String data) {
        return begin_notifyBattleServer(instanceId, name, data, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_notifyBattleServer(String instanceId, String name, String data, Map<String, String> __ctx) {
        return begin_notifyBattleServer(instanceId, name, data, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_notifyBattleServer(String instanceId, String name, String data, Callback __cb) {
        return begin_notifyBattleServer(instanceId, name, data, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_notifyBattleServer(String instanceId, String name, String data, Map<String, String> __ctx, Callback __cb) {
        return begin_notifyBattleServer(instanceId, name, data, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_notifyBattleServer(String instanceId, String name, String data, Callback_XmdsManager_notifyBattleServer __cb) {
        return begin_notifyBattleServer(instanceId, name, data, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_notifyBattleServer(String instanceId, String name, String data, Map<String, String> __ctx, Callback_XmdsManager_notifyBattleServer __cb) {
        return begin_notifyBattleServer(instanceId, name, data, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_notifyBattleServer(String instanceId, String name, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_notifyBattleServer(instanceId, name, data, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_notifyBattleServer(String instanceId, String name, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_notifyBattleServer(instanceId, name, data, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_notifyBattleServer(String instanceId, String name, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_notifyBattleServer(instanceId, name, data, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_notifyBattleServer(String instanceId, String name, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_notifyBattleServer(instanceId, name, data, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_notifyBattleServer(String instanceId, String name, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_notifyBattleServer(instanceId, name, data, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }


    private AsyncResult begin_notifyBattleServer(String instanceId, String name, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        OutgoingAsync __result = getOutgoingAsync("notifyBattleServer", __cb);

        try {
            __result.prepare("notifyBattleServer", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(instanceId);
            __os.writeString(name);
            __os.writeString(data);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public void end_notifyBattleServer(AsyncResult __iresult) {
        __end(__iresult, "notifyBattleServer");
    }


    public void onFinishPickItem(String playerId, String data) {
        onFinishPickItem(playerId, data, (Map<String, String>) null, false);
    }


    public void onFinishPickItem(String playerId, String data, Map<String, String> __ctx) {
        onFinishPickItem(playerId, data, __ctx, true);
    }


    private void onFinishPickItem(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx) {
        end_onFinishPickItem(begin_onFinishPickItem(playerId, data, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_onFinishPickItem(String playerId, String data) {
        return begin_onFinishPickItem(playerId, data, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_onFinishPickItem(String playerId, String data, Map<String, String> __ctx) {
        return begin_onFinishPickItem(playerId, data, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_onFinishPickItem(String playerId, String data, Callback __cb) {
        return begin_onFinishPickItem(playerId, data, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_onFinishPickItem(String playerId, String data, Map<String, String> __ctx, Callback __cb) {
        return begin_onFinishPickItem(playerId, data, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_onFinishPickItem(String playerId, String data, Callback_XmdsManager_onFinishPickItem __cb) {
        return begin_onFinishPickItem(playerId, data, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_onFinishPickItem(String playerId, String data, Map<String, String> __ctx, Callback_XmdsManager_onFinishPickItem __cb) {
        return begin_onFinishPickItem(playerId, data, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_onFinishPickItem(String playerId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_onFinishPickItem(playerId, data, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_onFinishPickItem(String playerId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_onFinishPickItem(playerId, data, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_onFinishPickItem(String playerId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_onFinishPickItem(playerId, data, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_onFinishPickItem(String playerId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_onFinishPickItem(playerId, data, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_onFinishPickItem(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_onFinishPickItem(playerId, data, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }


    private AsyncResult begin_onFinishPickItem(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        OutgoingAsync __result = getOutgoingAsync("onFinishPickItem", __cb);

        try {
            __result.prepare("onFinishPickItem", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(playerId);
            __os.writeString(data);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public void end_onFinishPickItem(AsyncResult __iresult) {
        __end(__iresult, "onFinishPickItem");
    }


    public void onMonsterDiedDrops(String instanceId, String data) {
        onMonsterDiedDrops(instanceId, data, (Map<String, String>) null, false);
    }


    public void onMonsterDiedDrops(String instanceId, String data, Map<String, String> __ctx) {
        onMonsterDiedDrops(instanceId, data, __ctx, true);
    }


    private void onMonsterDiedDrops(String instanceId, String data, Map<String, String> __ctx, boolean __explicitCtx) {
        end_onMonsterDiedDrops(begin_onMonsterDiedDrops(instanceId, data, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_onMonsterDiedDrops(String instanceId, String data) {
        return begin_onMonsterDiedDrops(instanceId, data, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_onMonsterDiedDrops(String instanceId, String data, Map<String, String> __ctx) {
        return begin_onMonsterDiedDrops(instanceId, data, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_onMonsterDiedDrops(String instanceId, String data, Callback __cb) {
        return begin_onMonsterDiedDrops(instanceId, data, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_onMonsterDiedDrops(String instanceId, String data, Map<String, String> __ctx, Callback __cb) {
        return begin_onMonsterDiedDrops(instanceId, data, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_onMonsterDiedDrops(String instanceId, String data, Callback_XmdsManager_onMonsterDiedDrops __cb) {
        return begin_onMonsterDiedDrops(instanceId, data, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_onMonsterDiedDrops(String instanceId, String data, Map<String, String> __ctx, Callback_XmdsManager_onMonsterDiedDrops __cb) {
        return begin_onMonsterDiedDrops(instanceId, data, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_onMonsterDiedDrops(String instanceId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_onMonsterDiedDrops(instanceId, data, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_onMonsterDiedDrops(String instanceId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_onMonsterDiedDrops(instanceId, data, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_onMonsterDiedDrops(String instanceId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_onMonsterDiedDrops(instanceId, data, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_onMonsterDiedDrops(String instanceId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_onMonsterDiedDrops(instanceId, data, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_onMonsterDiedDrops(String instanceId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_onMonsterDiedDrops(instanceId, data, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }


    private AsyncResult begin_onMonsterDiedDrops(String instanceId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        OutgoingAsync __result = getOutgoingAsync("onMonsterDiedDrops", __cb);

        try {
            __result.prepare("onMonsterDiedDrops", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(instanceId);
            __os.writeString(data);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public void end_onMonsterDiedDrops(AsyncResult __iresult) {
        __end(__iresult, "onMonsterDiedDrops");
    }


    public void playerReady(String playerId) {
        playerReady(playerId, (Map<String, String>) null, false);
    }


    public void playerReady(String playerId, Map<String, String> __ctx) {
        playerReady(playerId, __ctx, true);
    }


    private void playerReady(String playerId, Map<String, String> __ctx, boolean __explicitCtx) {
        end_playerReady(begin_playerReady(playerId, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_playerReady(String playerId) {
        return begin_playerReady(playerId, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_playerReady(String playerId, Map<String, String> __ctx) {
        return begin_playerReady(playerId, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_playerReady(String playerId, Callback __cb) {
        return begin_playerReady(playerId, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_playerReady(String playerId, Map<String, String> __ctx, Callback __cb) {
        return begin_playerReady(playerId, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_playerReady(String playerId, Callback_XmdsManager_playerReady __cb) {
        return begin_playerReady(playerId, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_playerReady(String playerId, Map<String, String> __ctx, Callback_XmdsManager_playerReady __cb) {
        return begin_playerReady(playerId, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_playerReady(String playerId, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_playerReady(playerId, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_playerReady(String playerId, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_playerReady(playerId, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_playerReady(String playerId, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_playerReady(playerId, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_playerReady(String playerId, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_playerReady(playerId, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_playerReady(String playerId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_playerReady(playerId, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }


    private AsyncResult begin_playerReady(String playerId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        OutgoingAsync __result = getOutgoingAsync("playerReady", __cb);

        try {
            __result.prepare("playerReady", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(playerId);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public void end_playerReady(AsyncResult __iresult) {
        __end(__iresult, "playerReady");
    }


    public void refreshPlayerAvatar(String playerId, String avatars) {
        refreshPlayerAvatar(playerId, avatars, (Map<String, String>) null, false);
    }


    public void refreshPlayerAvatar(String playerId, String avatars, Map<String, String> __ctx) {
        refreshPlayerAvatar(playerId, avatars, __ctx, true);
    }


    private void refreshPlayerAvatar(String playerId, String avatars, Map<String, String> __ctx, boolean __explicitCtx) {
        end_refreshPlayerAvatar(begin_refreshPlayerAvatar(playerId, avatars, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_refreshPlayerAvatar(String playerId, String avatars) {
        return begin_refreshPlayerAvatar(playerId, avatars, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerAvatar(String playerId, String avatars, Map<String, String> __ctx) {
        return begin_refreshPlayerAvatar(playerId, avatars, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerAvatar(String playerId, String avatars, Callback __cb) {
        return begin_refreshPlayerAvatar(playerId, avatars, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerAvatar(String playerId, String avatars, Map<String, String> __ctx, Callback __cb) {
        return begin_refreshPlayerAvatar(playerId, avatars, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerAvatar(String playerId, String avatars, Callback_XmdsManager_refreshPlayerAvatar __cb) {
        return begin_refreshPlayerAvatar(playerId, avatars, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerAvatar(String playerId, String avatars, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerAvatar __cb) {
        return begin_refreshPlayerAvatar(playerId, avatars, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerAvatar(String playerId, String avatars, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerAvatar(playerId, avatars, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerAvatar(String playerId, String avatars, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerAvatar(playerId, avatars, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_refreshPlayerAvatar(String playerId, String avatars, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerAvatar(playerId, avatars, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerAvatar(String playerId, String avatars, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerAvatar(playerId, avatars, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_refreshPlayerAvatar(String playerId, String avatars, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerAvatar(playerId, avatars, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }


    private AsyncResult begin_refreshPlayerAvatar(String playerId, String avatars, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        OutgoingAsync __result = getOutgoingAsync("refreshPlayerAvatar", __cb);

        try {
            __result.prepare("refreshPlayerAvatar", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(playerId);
            __os.writeString(avatars);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public void end_refreshPlayerAvatar(AsyncResult __iresult) {
        __end(__iresult, "refreshPlayerAvatar");
    }


    public void refreshPlayerBasicData(String playerId, String basic) {
        refreshPlayerBasicData(playerId, basic, (Map<String, String>) null, false);
    }


    public void refreshPlayerBasicData(String playerId, String basic, Map<String, String> __ctx) {
        refreshPlayerBasicData(playerId, basic, __ctx, true);
    }


    private void refreshPlayerBasicData(String playerId, String basic, Map<String, String> __ctx, boolean __explicitCtx) {
        end_refreshPlayerBasicData(begin_refreshPlayerBasicData(playerId, basic, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_refreshPlayerBasicData(String playerId, String basic) {
        return begin_refreshPlayerBasicData(playerId, basic, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerBasicData(String playerId, String basic, Map<String, String> __ctx) {
        return begin_refreshPlayerBasicData(playerId, basic, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerBasicData(String playerId, String basic, Callback __cb) {
        return begin_refreshPlayerBasicData(playerId, basic, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerBasicData(String playerId, String basic, Map<String, String> __ctx, Callback __cb) {
        return begin_refreshPlayerBasicData(playerId, basic, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerBasicData(String playerId, String basic, Callback_XmdsManager_refreshPlayerBasicData __cb) {
        return begin_refreshPlayerBasicData(playerId, basic, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerBasicData(String playerId, String basic, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerBasicData __cb) {
        return begin_refreshPlayerBasicData(playerId, basic, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerBasicData(String playerId, String basic, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerBasicData(playerId, basic, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerBasicData(String playerId, String basic, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerBasicData(playerId, basic, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_refreshPlayerBasicData(String playerId, String basic, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerBasicData(playerId, basic, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerBasicData(String playerId, String basic, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerBasicData(playerId, basic, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_refreshPlayerBasicData(String playerId, String basic, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerBasicData(playerId, basic, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }


    private AsyncResult begin_refreshPlayerBasicData(String playerId, String basic, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        OutgoingAsync __result = getOutgoingAsync("refreshPlayerBasicData", __cb);

        try {
            __result.prepare("refreshPlayerBasicData", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(playerId);
            __os.writeString(basic);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public void end_refreshPlayerBasicData(AsyncResult __iresult) {
        __end(__iresult, "refreshPlayerBasicData");
    }


    public void refreshPlayerBattleEffect(String playerId, String effects) {
        refreshPlayerBattleEffect(playerId, effects, (Map<String, String>) null, false);
    }


    public void refreshPlayerBattleEffect(String playerId, String effects, Map<String, String> __ctx) {
        refreshPlayerBattleEffect(playerId, effects, __ctx, true);
    }


    private void refreshPlayerBattleEffect(String playerId, String effects, Map<String, String> __ctx, boolean __explicitCtx) {
        end_refreshPlayerBattleEffect(begin_refreshPlayerBattleEffect(playerId, effects, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_refreshPlayerBattleEffect(String playerId, String effects) {
        return begin_refreshPlayerBattleEffect(playerId, effects, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerBattleEffect(String playerId, String effects, Map<String, String> __ctx) {
        return begin_refreshPlayerBattleEffect(playerId, effects, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerBattleEffect(String playerId, String effects, Callback __cb) {
        return begin_refreshPlayerBattleEffect(playerId, effects, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerBattleEffect(String playerId, String effects, Map<String, String> __ctx, Callback __cb) {
        return begin_refreshPlayerBattleEffect(playerId, effects, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerBattleEffect(String playerId, String effects, Callback_XmdsManager_refreshPlayerBattleEffect __cb) {
        return begin_refreshPlayerBattleEffect(playerId, effects, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerBattleEffect(String playerId, String effects, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerBattleEffect __cb) {
        return begin_refreshPlayerBattleEffect(playerId, effects, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerBattleEffect(String playerId, String effects, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerBattleEffect(playerId, effects, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerBattleEffect(String playerId, String effects, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerBattleEffect(playerId, effects, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_refreshPlayerBattleEffect(String playerId, String effects, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerBattleEffect(playerId, effects, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerBattleEffect(String playerId, String effects, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerBattleEffect(playerId, effects, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_refreshPlayerBattleEffect(String playerId, String effects, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerBattleEffect(playerId, effects, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }


    private AsyncResult begin_refreshPlayerBattleEffect(String playerId, String effects, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        OutgoingAsync __result = getOutgoingAsync("refreshPlayerBattleEffect", __cb);

        try {
            __result.prepare("refreshPlayerBattleEffect", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(playerId);
            __os.writeString(effects);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public void end_refreshPlayerBattleEffect(AsyncResult __iresult) {
        __end(__iresult, "refreshPlayerBattleEffect");
    }


    public void refreshPlayerPKLevel(String playerId, int level) {
        refreshPlayerPKLevel(playerId, level, (Map<String, String>) null, false);
    }


    public void refreshPlayerPKLevel(String playerId, int level, Map<String, String> __ctx) {
        refreshPlayerPKLevel(playerId, level, __ctx, true);
    }


    private void refreshPlayerPKLevel(String playerId, int level, Map<String, String> __ctx, boolean __explicitCtx) {
        end_refreshPlayerPKLevel(begin_refreshPlayerPKLevel(playerId, level, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_refreshPlayerPKLevel(String playerId, int level) {
        return begin_refreshPlayerPKLevel(playerId, level, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerPKLevel(String playerId, int level, Map<String, String> __ctx) {
        return begin_refreshPlayerPKLevel(playerId, level, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerPKLevel(String playerId, int level, Callback __cb) {
        return begin_refreshPlayerPKLevel(playerId, level, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPKLevel(String playerId, int level, Map<String, String> __ctx, Callback __cb) {
        return begin_refreshPlayerPKLevel(playerId, level, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPKLevel(String playerId, int level, Callback_XmdsManager_refreshPlayerPKLevel __cb) {
        return begin_refreshPlayerPKLevel(playerId, level, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPKLevel(String playerId, int level, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerPKLevel __cb) {
        return begin_refreshPlayerPKLevel(playerId, level, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPKLevel(String playerId, int level, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerPKLevel(playerId, level, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerPKLevel(String playerId, int level, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerPKLevel(playerId, level, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_refreshPlayerPKLevel(String playerId, int level, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerPKLevel(playerId, level, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerPKLevel(String playerId, int level, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerPKLevel(playerId, level, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_refreshPlayerPKLevel(String playerId, int level, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerPKLevel(playerId, level, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }


    private AsyncResult begin_refreshPlayerPKLevel(String playerId, int level, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        OutgoingAsync __result = getOutgoingAsync("refreshPlayerPKLevel", __cb);

        try {
            __result.prepare("refreshPlayerPKLevel", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(playerId);
            __os.writeInt(level);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public void end_refreshPlayerPKLevel(AsyncResult __iresult) {
        __end(__iresult, "refreshPlayerPKLevel");
    }


    public void refreshPlayerPKMode(String playerId, int mode) {
        refreshPlayerPKMode(playerId, mode, (Map<String, String>) null, false);
    }


    public void refreshPlayerPKMode(String playerId, int mode, Map<String, String> __ctx) {
        refreshPlayerPKMode(playerId, mode, __ctx, true);
    }


    private void refreshPlayerPKMode(String playerId, int mode, Map<String, String> __ctx, boolean __explicitCtx) {
        end_refreshPlayerPKMode(begin_refreshPlayerPKMode(playerId, mode, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_refreshPlayerPKMode(String playerId, int mode) {
        return begin_refreshPlayerPKMode(playerId, mode, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerPKMode(String playerId, int mode, Map<String, String> __ctx) {
        return begin_refreshPlayerPKMode(playerId, mode, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerPKMode(String playerId, int mode, Callback __cb) {
        return begin_refreshPlayerPKMode(playerId, mode, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPKMode(String playerId, int mode, Map<String, String> __ctx, Callback __cb) {
        return begin_refreshPlayerPKMode(playerId, mode, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPKMode(String playerId, int mode, Callback_XmdsManager_refreshPlayerPKMode __cb) {
        return begin_refreshPlayerPKMode(playerId, mode, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPKMode(String playerId, int mode, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerPKMode __cb) {
        return begin_refreshPlayerPKMode(playerId, mode, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPKMode(String playerId, int mode, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerPKMode(playerId, mode, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerPKMode(String playerId, int mode, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerPKMode(playerId, mode, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_refreshPlayerPKMode(String playerId, int mode, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerPKMode(playerId, mode, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerPKMode(String playerId, int mode, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerPKMode(playerId, mode, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_refreshPlayerPKMode(String playerId, int mode, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerPKMode(playerId, mode, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }


    private AsyncResult begin_refreshPlayerPKMode(String playerId, int mode, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        OutgoingAsync __result = getOutgoingAsync("refreshPlayerPKMode", __cb);

        try {
            __result.prepare("refreshPlayerPKMode", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(playerId);
            __os.writeInt(mode);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public void end_refreshPlayerPKMode(AsyncResult __iresult) {
        __end(__iresult, "refreshPlayerPKMode");
    }


    public void refreshPlayerPKValue(String playerId, int value) {
        refreshPlayerPKValue(playerId, value, (Map<String, String>) null, false);
    }


    public void refreshPlayerPKValue(String playerId, int value, Map<String, String> __ctx) {
        refreshPlayerPKValue(playerId, value, __ctx, true);
    }


    private void refreshPlayerPKValue(String playerId, int value, Map<String, String> __ctx, boolean __explicitCtx) {
        end_refreshPlayerPKValue(begin_refreshPlayerPKValue(playerId, value, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_refreshPlayerPKValue(String playerId, int value) {
        return begin_refreshPlayerPKValue(playerId, value, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerPKValue(String playerId, int value, Map<String, String> __ctx) {
        return begin_refreshPlayerPKValue(playerId, value, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerPKValue(String playerId, int value, Callback __cb) {
        return begin_refreshPlayerPKValue(playerId, value, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPKValue(String playerId, int value, Map<String, String> __ctx, Callback __cb) {
        return begin_refreshPlayerPKValue(playerId, value, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPKValue(String playerId, int value, Callback_XmdsManager_refreshPlayerPKValue __cb) {
        return begin_refreshPlayerPKValue(playerId, value, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPKValue(String playerId, int value, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerPKValue __cb) {
        return begin_refreshPlayerPKValue(playerId, value, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPKValue(String playerId, int value, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerPKValue(playerId, value, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerPKValue(String playerId, int value, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerPKValue(playerId, value, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_refreshPlayerPKValue(String playerId, int value, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerPKValue(playerId, value, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerPKValue(String playerId, int value, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerPKValue(playerId, value, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_refreshPlayerPKValue(String playerId, int value, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerPKValue(playerId, value, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }


    private AsyncResult begin_refreshPlayerPKValue(String playerId, int value, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        OutgoingAsync __result = getOutgoingAsync("refreshPlayerPKValue", __cb);

        try {
            __result.prepare("refreshPlayerPKValue", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(playerId);
            __os.writeInt(value);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public void end_refreshPlayerPKValue(AsyncResult __iresult) {
        __end(__iresult, "refreshPlayerPKValue");
    }


    public void refreshPlayerPetBaseInfoChange(String playerId, String data) {
        refreshPlayerPetBaseInfoChange(playerId, data, (Map<String, String>) null, false);
    }


    public void refreshPlayerPetBaseInfoChange(String playerId, String data, Map<String, String> __ctx) {
        refreshPlayerPetBaseInfoChange(playerId, data, __ctx, true);
    }


    private void refreshPlayerPetBaseInfoChange(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx) {
        end_refreshPlayerPetBaseInfoChange(begin_refreshPlayerPetBaseInfoChange(playerId, data, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_refreshPlayerPetBaseInfoChange(String playerId, String data) {
        return begin_refreshPlayerPetBaseInfoChange(playerId, data, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerPetBaseInfoChange(String playerId, String data, Map<String, String> __ctx) {
        return begin_refreshPlayerPetBaseInfoChange(playerId, data, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerPetBaseInfoChange(String playerId, String data, Callback __cb) {
        return begin_refreshPlayerPetBaseInfoChange(playerId, data, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPetBaseInfoChange(String playerId, String data, Map<String, String> __ctx, Callback __cb) {
        return begin_refreshPlayerPetBaseInfoChange(playerId, data, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPetBaseInfoChange(String playerId, String data, Callback_XmdsManager_refreshPlayerPetBaseInfoChange __cb) {
        return begin_refreshPlayerPetBaseInfoChange(playerId, data, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPetBaseInfoChange(String playerId, String data, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerPetBaseInfoChange __cb) {
        return begin_refreshPlayerPetBaseInfoChange(playerId, data, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPetBaseInfoChange(String playerId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerPetBaseInfoChange(playerId, data, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerPetBaseInfoChange(String playerId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerPetBaseInfoChange(playerId, data, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_refreshPlayerPetBaseInfoChange(String playerId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerPetBaseInfoChange(playerId, data, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerPetBaseInfoChange(String playerId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerPetBaseInfoChange(playerId, data, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_refreshPlayerPetBaseInfoChange(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerPetBaseInfoChange(playerId, data, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }


    private AsyncResult begin_refreshPlayerPetBaseInfoChange(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        OutgoingAsync __result = getOutgoingAsync("refreshPlayerPetBaseInfoChange", __cb);

        try {
            __result.prepare("refreshPlayerPetBaseInfoChange", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(playerId);
            __os.writeString(data);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public void end_refreshPlayerPetBaseInfoChange(AsyncResult __iresult) {
        __end(__iresult, "refreshPlayerPetBaseInfoChange");
    }


    public void refreshPlayerPetDataChange(String playerId, int type, String data) {
        refreshPlayerPetDataChange(playerId, type, data, (Map<String, String>) null, false);
    }


    public void refreshPlayerPetDataChange(String playerId, int type, String data, Map<String, String> __ctx) {
        refreshPlayerPetDataChange(playerId, type, data, __ctx, true);
    }


    private void refreshPlayerPetDataChange(String playerId, int type, String data, Map<String, String> __ctx, boolean __explicitCtx) {
        end_refreshPlayerPetDataChange(begin_refreshPlayerPetDataChange(playerId, type, data, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_refreshPlayerPetDataChange(String playerId, int type, String data) {
        return begin_refreshPlayerPetDataChange(playerId, type, data, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerPetDataChange(String playerId, int type, String data, Map<String, String> __ctx) {
        return begin_refreshPlayerPetDataChange(playerId, type, data, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerPetDataChange(String playerId, int type, String data, Callback __cb) {
        return begin_refreshPlayerPetDataChange(playerId, type, data, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPetDataChange(String playerId, int type, String data, Map<String, String> __ctx, Callback __cb) {
        return begin_refreshPlayerPetDataChange(playerId, type, data, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPetDataChange(String playerId, int type, String data, Callback_XmdsManager_refreshPlayerPetDataChange __cb) {
        return begin_refreshPlayerPetDataChange(playerId, type, data, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPetDataChange(String playerId, int type, String data, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerPetDataChange __cb) {
        return begin_refreshPlayerPetDataChange(playerId, type, data, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPetDataChange(String playerId, int type, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerPetDataChange(playerId, type, data, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerPetDataChange(String playerId, int type, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerPetDataChange(playerId, type, data, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_refreshPlayerPetDataChange(String playerId, int type, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerPetDataChange(playerId, type, data, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerPetDataChange(String playerId, int type, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerPetDataChange(playerId, type, data, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_refreshPlayerPetDataChange(String playerId, int type, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerPetDataChange(playerId, type, data, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }


    private AsyncResult begin_refreshPlayerPetDataChange(String playerId, int type, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        OutgoingAsync __result = getOutgoingAsync("refreshPlayerPetDataChange", __cb);

        try {
            __result.prepare("refreshPlayerPetDataChange", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(playerId);
            __os.writeInt(type);
            __os.writeString(data);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public void end_refreshPlayerPetDataChange(AsyncResult __iresult) {
        __end(__iresult, "refreshPlayerPetDataChange");
    }


    public void refreshPlayerPetFollowModeChange(String playerId, int mode) {
        refreshPlayerPetFollowModeChange(playerId, mode, (Map<String, String>) null, false);
    }


    public void refreshPlayerPetFollowModeChange(String playerId, int mode, Map<String, String> __ctx) {
        refreshPlayerPetFollowModeChange(playerId, mode, __ctx, true);
    }


    private void refreshPlayerPetFollowModeChange(String playerId, int mode, Map<String, String> __ctx, boolean __explicitCtx) {
        end_refreshPlayerPetFollowModeChange(begin_refreshPlayerPetFollowModeChange(playerId, mode, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_refreshPlayerPetFollowModeChange(String playerId, int mode) {
        return begin_refreshPlayerPetFollowModeChange(playerId, mode, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerPetFollowModeChange(String playerId, int mode, Map<String, String> __ctx) {
        return begin_refreshPlayerPetFollowModeChange(playerId, mode, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerPetFollowModeChange(String playerId, int mode, Callback __cb) {
        return begin_refreshPlayerPetFollowModeChange(playerId, mode, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPetFollowModeChange(String playerId, int mode, Map<String, String> __ctx, Callback __cb) {
        return begin_refreshPlayerPetFollowModeChange(playerId, mode, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPetFollowModeChange(String playerId, int mode, Callback_XmdsManager_refreshPlayerPetFollowModeChange __cb) {
        return begin_refreshPlayerPetFollowModeChange(playerId, mode, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPetFollowModeChange(String playerId, int mode, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerPetFollowModeChange __cb) {
        return begin_refreshPlayerPetFollowModeChange(playerId, mode, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPetFollowModeChange(String playerId, int mode, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerPetFollowModeChange(playerId, mode, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerPetFollowModeChange(String playerId, int mode, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerPetFollowModeChange(playerId, mode, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_refreshPlayerPetFollowModeChange(String playerId, int mode, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerPetFollowModeChange(playerId, mode, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerPetFollowModeChange(String playerId, int mode, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerPetFollowModeChange(playerId, mode, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_refreshPlayerPetFollowModeChange(String playerId, int mode, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerPetFollowModeChange(playerId, mode, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }


    private AsyncResult begin_refreshPlayerPetFollowModeChange(String playerId, int mode, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        OutgoingAsync __result = getOutgoingAsync("refreshPlayerPetFollowModeChange", __cb);

        try {
            __result.prepare("refreshPlayerPetFollowModeChange", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(playerId);
            __os.writeInt(mode);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public void end_refreshPlayerPetFollowModeChange(AsyncResult __iresult) {
        __end(__iresult, "refreshPlayerPetFollowModeChange");
    }


    public void refreshPlayerPetPropertyChange(String playerId, String data) {
        refreshPlayerPetPropertyChange(playerId, data, (Map<String, String>) null, false);
    }


    public void refreshPlayerPetPropertyChange(String playerId, String data, Map<String, String> __ctx) {
        refreshPlayerPetPropertyChange(playerId, data, __ctx, true);
    }


    private void refreshPlayerPetPropertyChange(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx) {
        end_refreshPlayerPetPropertyChange(begin_refreshPlayerPetPropertyChange(playerId, data, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_refreshPlayerPetPropertyChange(String playerId, String data) {
        return begin_refreshPlayerPetPropertyChange(playerId, data, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerPetPropertyChange(String playerId, String data, Map<String, String> __ctx) {
        return begin_refreshPlayerPetPropertyChange(playerId, data, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerPetPropertyChange(String playerId, String data, Callback __cb) {
        return begin_refreshPlayerPetPropertyChange(playerId, data, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPetPropertyChange(String playerId, String data, Map<String, String> __ctx, Callback __cb) {
        return begin_refreshPlayerPetPropertyChange(playerId, data, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPetPropertyChange(String playerId, String data, Callback_XmdsManager_refreshPlayerPetPropertyChange __cb) {
        return begin_refreshPlayerPetPropertyChange(playerId, data, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPetPropertyChange(String playerId, String data, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerPetPropertyChange __cb) {
        return begin_refreshPlayerPetPropertyChange(playerId, data, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPetPropertyChange(String playerId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerPetPropertyChange(playerId, data, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerPetPropertyChange(String playerId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerPetPropertyChange(playerId, data, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_refreshPlayerPetPropertyChange(String playerId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerPetPropertyChange(playerId, data, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerPetPropertyChange(String playerId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerPetPropertyChange(playerId, data, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_refreshPlayerPetPropertyChange(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerPetPropertyChange(playerId, data, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }


    private AsyncResult begin_refreshPlayerPetPropertyChange(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        OutgoingAsync __result = getOutgoingAsync("refreshPlayerPetPropertyChange", __cb);

        try {
            __result.prepare("refreshPlayerPetPropertyChange", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(playerId);
            __os.writeString(data);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public void end_refreshPlayerPetPropertyChange(AsyncResult __iresult) {
        __end(__iresult, "refreshPlayerPetPropertyChange");
    }


    public void refreshPlayerPetSkillChange(String playerId, int operateID, String skills) {
        refreshPlayerPetSkillChange(playerId, operateID, skills, (Map<String, String>) null, false);
    }


    public void refreshPlayerPetSkillChange(String playerId, int operateID, String skills, Map<String, String> __ctx) {
        refreshPlayerPetSkillChange(playerId, operateID, skills, __ctx, true);
    }


    private void refreshPlayerPetSkillChange(String playerId, int operateID, String skills, Map<String, String> __ctx, boolean __explicitCtx) {
        end_refreshPlayerPetSkillChange(begin_refreshPlayerPetSkillChange(playerId, operateID, skills, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_refreshPlayerPetSkillChange(String playerId, int operateID, String skills) {
        return begin_refreshPlayerPetSkillChange(playerId, operateID, skills, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerPetSkillChange(String playerId, int operateID, String skills, Map<String, String> __ctx) {
        return begin_refreshPlayerPetSkillChange(playerId, operateID, skills, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerPetSkillChange(String playerId, int operateID, String skills, Callback __cb) {
        return begin_refreshPlayerPetSkillChange(playerId, operateID, skills, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPetSkillChange(String playerId, int operateID, String skills, Map<String, String> __ctx, Callback __cb) {
        return begin_refreshPlayerPetSkillChange(playerId, operateID, skills, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPetSkillChange(String playerId, int operateID, String skills, Callback_XmdsManager_refreshPlayerPetSkillChange __cb) {
        return begin_refreshPlayerPetSkillChange(playerId, operateID, skills, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPetSkillChange(String playerId, int operateID, String skills, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerPetSkillChange __cb) {
        return begin_refreshPlayerPetSkillChange(playerId, operateID, skills, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPetSkillChange(String playerId, int operateID, String skills, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerPetSkillChange(playerId, operateID, skills, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerPetSkillChange(String playerId, int operateID, String skills, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerPetSkillChange(playerId, operateID, skills, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_refreshPlayerPetSkillChange(String playerId, int operateID, String skills, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerPetSkillChange(playerId, operateID, skills, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerPetSkillChange(String playerId, int operateID, String skills, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerPetSkillChange(playerId, operateID, skills, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_refreshPlayerPetSkillChange(String playerId, int operateID, String skills, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerPetSkillChange(playerId, operateID, skills, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }


    private AsyncResult begin_refreshPlayerPetSkillChange(String playerId, int operateID, String skills, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        OutgoingAsync __result = getOutgoingAsync("refreshPlayerPetSkillChange", __cb);

        try {
            __result.prepare("refreshPlayerPetSkillChange", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(playerId);
            __os.writeInt(operateID);
            __os.writeString(skills);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public void end_refreshPlayerPetSkillChange(AsyncResult __iresult) {
        __end(__iresult, "refreshPlayerPetSkillChange");
    }


    public void refreshPlayerPropertyChange(String playerId, String data) {
        refreshPlayerPropertyChange(playerId, data, (Map<String, String>) null, false);
    }


    public void refreshPlayerPropertyChange(String playerId, String data, Map<String, String> __ctx) {
        refreshPlayerPropertyChange(playerId, data, __ctx, true);
    }


    private void refreshPlayerPropertyChange(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx) {
        end_refreshPlayerPropertyChange(begin_refreshPlayerPropertyChange(playerId, data, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_refreshPlayerPropertyChange(String playerId, String data) {
        return begin_refreshPlayerPropertyChange(playerId, data, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerPropertyChange(String playerId, String data, Map<String, String> __ctx) {
        return begin_refreshPlayerPropertyChange(playerId, data, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerPropertyChange(String playerId, String data, Callback __cb) {
        return begin_refreshPlayerPropertyChange(playerId, data, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPropertyChange(String playerId, String data, Map<String, String> __ctx, Callback __cb) {
        return begin_refreshPlayerPropertyChange(playerId, data, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPropertyChange(String playerId, String data, Callback_XmdsManager_refreshPlayerPropertyChange __cb) {
        return begin_refreshPlayerPropertyChange(playerId, data, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPropertyChange(String playerId, String data, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerPropertyChange __cb) {
        return begin_refreshPlayerPropertyChange(playerId, data, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerPropertyChange(String playerId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerPropertyChange(playerId, data, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerPropertyChange(String playerId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerPropertyChange(playerId, data, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_refreshPlayerPropertyChange(String playerId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerPropertyChange(playerId, data, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerPropertyChange(String playerId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerPropertyChange(playerId, data, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_refreshPlayerPropertyChange(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerPropertyChange(playerId, data, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }


    private AsyncResult begin_refreshPlayerPropertyChange(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        OutgoingAsync __result = getOutgoingAsync("refreshPlayerPropertyChange", __cb);

        try {
            __result.prepare("refreshPlayerPropertyChange", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(playerId);
            __os.writeString(data);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public void end_refreshPlayerPropertyChange(AsyncResult __iresult) {
        __end(__iresult, "refreshPlayerPropertyChange");
    }


    public void refreshPlayerRemainBagCountData(String playerId, int remainCount) {
        refreshPlayerRemainBagCountData(playerId, remainCount, (Map<String, String>) null, false);
    }


    public void refreshPlayerRemainBagCountData(String playerId, int remainCount, Map<String, String> __ctx) {
        refreshPlayerRemainBagCountData(playerId, remainCount, __ctx, true);
    }


    private void refreshPlayerRemainBagCountData(String playerId, int remainCount, Map<String, String> __ctx, boolean __explicitCtx) {
        end_refreshPlayerRemainBagCountData(begin_refreshPlayerRemainBagCountData(playerId, remainCount, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_refreshPlayerRemainBagCountData(String playerId, int remainCount) {
        return begin_refreshPlayerRemainBagCountData(playerId, remainCount, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerRemainBagCountData(String playerId, int remainCount, Map<String, String> __ctx) {
        return begin_refreshPlayerRemainBagCountData(playerId, remainCount, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerRemainBagCountData(String playerId, int remainCount, Callback __cb) {
        return begin_refreshPlayerRemainBagCountData(playerId, remainCount, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerRemainBagCountData(String playerId, int remainCount, Map<String, String> __ctx, Callback __cb) {
        return begin_refreshPlayerRemainBagCountData(playerId, remainCount, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerRemainBagCountData(String playerId, int remainCount, Callback_XmdsManager_refreshPlayerRemainBagCountData __cb) {
        return begin_refreshPlayerRemainBagCountData(playerId, remainCount, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerRemainBagCountData(String playerId, int remainCount, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerRemainBagCountData __cb) {
        return begin_refreshPlayerRemainBagCountData(playerId, remainCount, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerRemainBagCountData(String playerId, int remainCount, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerRemainBagCountData(playerId, remainCount, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerRemainBagCountData(String playerId, int remainCount, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerRemainBagCountData(playerId, remainCount, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_refreshPlayerRemainBagCountData(String playerId, int remainCount, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerRemainBagCountData(playerId, remainCount, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerRemainBagCountData(String playerId, int remainCount, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerRemainBagCountData(playerId, remainCount, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_refreshPlayerRemainBagCountData(String playerId, int remainCount, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerRemainBagCountData(playerId, remainCount, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }


    private AsyncResult begin_refreshPlayerRemainBagCountData(String playerId, int remainCount, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        OutgoingAsync __result = getOutgoingAsync("refreshPlayerRemainBagCountData", __cb);

        try {
            __result.prepare("refreshPlayerRemainBagCountData", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(playerId);
            __os.writeInt(remainCount);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public void end_refreshPlayerRemainBagCountData(AsyncResult __iresult) {
        __end(__iresult, "refreshPlayerRemainBagCountData");
    }


    public void refreshPlayerRemainTeamBagCountData(String playerId, int remainCount) {
        refreshPlayerRemainTeamBagCountData(playerId, remainCount, (Map<String, String>) null, false);
    }


    public void refreshPlayerRemainTeamBagCountData(String playerId, int remainCount, Map<String, String> __ctx) {
        refreshPlayerRemainTeamBagCountData(playerId, remainCount, __ctx, true);
    }


    private void refreshPlayerRemainTeamBagCountData(String playerId, int remainCount, Map<String, String> __ctx, boolean __explicitCtx) {
        end_refreshPlayerRemainTeamBagCountData(begin_refreshPlayerRemainTeamBagCountData(playerId, remainCount, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_refreshPlayerRemainTeamBagCountData(String playerId, int remainCount) {
        return begin_refreshPlayerRemainTeamBagCountData(playerId, remainCount, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerRemainTeamBagCountData(String playerId, int remainCount, Map<String, String> __ctx) {
        return begin_refreshPlayerRemainTeamBagCountData(playerId, remainCount, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerRemainTeamBagCountData(String playerId, int remainCount, Callback __cb) {
        return begin_refreshPlayerRemainTeamBagCountData(playerId, remainCount, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerRemainTeamBagCountData(String playerId, int remainCount, Map<String, String> __ctx, Callback __cb) {
        return begin_refreshPlayerRemainTeamBagCountData(playerId, remainCount, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerRemainTeamBagCountData(String playerId, int remainCount, Callback_XmdsManager_refreshPlayerRemainTeamBagCountData __cb) {
        return begin_refreshPlayerRemainTeamBagCountData(playerId, remainCount, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerRemainTeamBagCountData(String playerId, int remainCount, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerRemainTeamBagCountData __cb) {
        return begin_refreshPlayerRemainTeamBagCountData(playerId, remainCount, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerRemainTeamBagCountData(String playerId, int remainCount, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerRemainTeamBagCountData(playerId, remainCount, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerRemainTeamBagCountData(String playerId, int remainCount, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerRemainTeamBagCountData(playerId, remainCount, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_refreshPlayerRemainTeamBagCountData(String playerId, int remainCount, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerRemainTeamBagCountData(playerId, remainCount, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerRemainTeamBagCountData(String playerId, int remainCount, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerRemainTeamBagCountData(playerId, remainCount, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_refreshPlayerRemainTeamBagCountData(String playerId, int remainCount, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerRemainTeamBagCountData(playerId, remainCount, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }


    private AsyncResult begin_refreshPlayerRemainTeamBagCountData(String playerId, int remainCount, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        OutgoingAsync __result = getOutgoingAsync("refreshPlayerRemainTeamBagCountData", __cb);

        try {
            __result.prepare("refreshPlayerRemainTeamBagCountData", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(playerId);
            __os.writeInt(remainCount);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public void end_refreshPlayerRemainTeamBagCountData(AsyncResult __iresult) {
        __end(__iresult, "refreshPlayerRemainTeamBagCountData");
    }


    public void refreshPlayerSkill(String playerId, int operateID, String skills) {
        refreshPlayerSkill(playerId, operateID, skills, (Map<String, String>) null, false);
    }


    public void refreshPlayerSkill(String playerId, int operateID, String skills, Map<String, String> __ctx) {
        refreshPlayerSkill(playerId, operateID, skills, __ctx, true);
    }


    private void refreshPlayerSkill(String playerId, int operateID, String skills, Map<String, String> __ctx, boolean __explicitCtx) {
        end_refreshPlayerSkill(begin_refreshPlayerSkill(playerId, operateID, skills, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_refreshPlayerSkill(String playerId, int operateID, String skills) {
        return begin_refreshPlayerSkill(playerId, operateID, skills, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerSkill(String playerId, int operateID, String skills, Map<String, String> __ctx) {
        return begin_refreshPlayerSkill(playerId, operateID, skills, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerSkill(String playerId, int operateID, String skills, Callback __cb) {
        return begin_refreshPlayerSkill(playerId, operateID, skills, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerSkill(String playerId, int operateID, String skills, Map<String, String> __ctx, Callback __cb) {
        return begin_refreshPlayerSkill(playerId, operateID, skills, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerSkill(String playerId, int operateID, String skills, Callback_XmdsManager_refreshPlayerSkill __cb) {
        return begin_refreshPlayerSkill(playerId, operateID, skills, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerSkill(String playerId, int operateID, String skills, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerSkill __cb) {
        return begin_refreshPlayerSkill(playerId, operateID, skills, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerSkill(String playerId, int operateID, String skills, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerSkill(playerId, operateID, skills, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerSkill(String playerId, int operateID, String skills, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerSkill(playerId, operateID, skills, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_refreshPlayerSkill(String playerId, int operateID, String skills, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerSkill(playerId, operateID, skills, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerSkill(String playerId, int operateID, String skills, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerSkill(playerId, operateID, skills, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_refreshPlayerSkill(String playerId, int operateID, String skills, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerSkill(playerId, operateID, skills, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }


    private AsyncResult begin_refreshPlayerSkill(String playerId, int operateID, String skills, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        OutgoingAsync __result = getOutgoingAsync("refreshPlayerSkill", __cb);

        try {
            __result.prepare("refreshPlayerSkill", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(playerId);
            __os.writeInt(operateID);
            __os.writeString(skills);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public void end_refreshPlayerSkill(AsyncResult __iresult) {
        __end(__iresult, "refreshPlayerSkill");
    }


    public void refreshPlayerTeamData(String playerId, String uuidList) {
        refreshPlayerTeamData(playerId, uuidList, (Map<String, String>) null, false);
    }


    public void refreshPlayerTeamData(String playerId, String uuidList, Map<String, String> __ctx) {
        refreshPlayerTeamData(playerId, uuidList, __ctx, true);
    }


    private void refreshPlayerTeamData(String playerId, String uuidList, Map<String, String> __ctx, boolean __explicitCtx) {
        end_refreshPlayerTeamData(begin_refreshPlayerTeamData(playerId, uuidList, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_refreshPlayerTeamData(String playerId, String uuidList) {
        return begin_refreshPlayerTeamData(playerId, uuidList, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerTeamData(String playerId, String uuidList, Map<String, String> __ctx) {
        return begin_refreshPlayerTeamData(playerId, uuidList, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshPlayerTeamData(String playerId, String uuidList, Callback __cb) {
        return begin_refreshPlayerTeamData(playerId, uuidList, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerTeamData(String playerId, String uuidList, Map<String, String> __ctx, Callback __cb) {
        return begin_refreshPlayerTeamData(playerId, uuidList, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerTeamData(String playerId, String uuidList, Callback_XmdsManager_refreshPlayerTeamData __cb) {
        return begin_refreshPlayerTeamData(playerId, uuidList, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerTeamData(String playerId, String uuidList, Map<String, String> __ctx, Callback_XmdsManager_refreshPlayerTeamData __cb) {
        return begin_refreshPlayerTeamData(playerId, uuidList, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshPlayerTeamData(String playerId, String uuidList, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerTeamData(playerId, uuidList, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerTeamData(String playerId, String uuidList, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerTeamData(playerId, uuidList, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_refreshPlayerTeamData(String playerId, String uuidList, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshPlayerTeamData(playerId, uuidList, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshPlayerTeamData(String playerId, String uuidList, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerTeamData(playerId, uuidList, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_refreshPlayerTeamData(String playerId, String uuidList, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshPlayerTeamData(playerId, uuidList, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }


    private AsyncResult begin_refreshPlayerTeamData(String playerId, String uuidList, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        OutgoingAsync __result = getOutgoingAsync("refreshPlayerTeamData", __cb);

        try {
            __result.prepare("refreshPlayerTeamData", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(playerId);
            __os.writeString(uuidList);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public void end_refreshPlayerTeamData(AsyncResult __iresult) {
        __end(__iresult, "refreshPlayerTeamData");
    }


    public void refreshSummonMount(String playerId, int time, int isUp) {
        refreshSummonMount(playerId, time, isUp, (Map<String, String>) null, false);
    }


    public void refreshSummonMount(String playerId, int time, int isUp, Map<String, String> __ctx) {
        refreshSummonMount(playerId, time, isUp, __ctx, true);
    }


    private void refreshSummonMount(String playerId, int time, int isUp, Map<String, String> __ctx, boolean __explicitCtx) {
        end_refreshSummonMount(begin_refreshSummonMount(playerId, time, isUp, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_refreshSummonMount(String playerId, int time, int isUp) {
        return begin_refreshSummonMount(playerId, time, isUp, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshSummonMount(String playerId, int time, int isUp, Map<String, String> __ctx) {
        return begin_refreshSummonMount(playerId, time, isUp, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshSummonMount(String playerId, int time, int isUp, Callback __cb) {
        return begin_refreshSummonMount(playerId, time, isUp, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshSummonMount(String playerId, int time, int isUp, Map<String, String> __ctx, Callback __cb) {
        return begin_refreshSummonMount(playerId, time, isUp, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshSummonMount(String playerId, int time, int isUp, Callback_XmdsManager_refreshSummonMount __cb) {
        return begin_refreshSummonMount(playerId, time, isUp, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshSummonMount(String playerId, int time, int isUp, Map<String, String> __ctx, Callback_XmdsManager_refreshSummonMount __cb) {
        return begin_refreshSummonMount(playerId, time, isUp, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshSummonMount(String playerId, int time, int isUp, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshSummonMount(playerId, time, isUp, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshSummonMount(String playerId, int time, int isUp, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshSummonMount(playerId, time, isUp, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_refreshSummonMount(String playerId, int time, int isUp, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshSummonMount(playerId, time, isUp, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshSummonMount(String playerId, int time, int isUp, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshSummonMount(playerId, time, isUp, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_refreshSummonMount(String playerId, int time, int isUp, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshSummonMount(playerId, time, isUp, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }


    private AsyncResult begin_refreshSummonMount(String playerId, int time, int isUp, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        OutgoingAsync __result = getOutgoingAsync("refreshSummonMount", __cb);

        try {
            __result.prepare("refreshSummonMount", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(playerId);
            __os.writeInt(time);
            __os.writeInt(isUp);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public void end_refreshSummonMount(AsyncResult __iresult) {
        __end(__iresult, "refreshSummonMount");
    }


    public void refreshTeamData(String playerId, String data) {
        refreshTeamData(playerId, data, (Map<String, String>) null, false);
    }


    public void refreshTeamData(String playerId, String data, Map<String, String> __ctx) {
        refreshTeamData(playerId, data, __ctx, true);
    }


    private void refreshTeamData(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx) {
        end_refreshTeamData(begin_refreshTeamData(playerId, data, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_refreshTeamData(String playerId, String data) {
        return begin_refreshTeamData(playerId, data, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshTeamData(String playerId, String data, Map<String, String> __ctx) {
        return begin_refreshTeamData(playerId, data, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_refreshTeamData(String playerId, String data, Callback __cb) {
        return begin_refreshTeamData(playerId, data, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshTeamData(String playerId, String data, Map<String, String> __ctx, Callback __cb) {
        return begin_refreshTeamData(playerId, data, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshTeamData(String playerId, String data, Callback_XmdsManager_refreshTeamData __cb) {
        return begin_refreshTeamData(playerId, data, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshTeamData(String playerId, String data, Map<String, String> __ctx, Callback_XmdsManager_refreshTeamData __cb) {
        return begin_refreshTeamData(playerId, data, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_refreshTeamData(String playerId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshTeamData(playerId, data, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshTeamData(String playerId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshTeamData(playerId, data, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_refreshTeamData(String playerId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_refreshTeamData(playerId, data, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_refreshTeamData(String playerId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshTeamData(playerId, data, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_refreshTeamData(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_refreshTeamData(playerId, data, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }


    private AsyncResult begin_refreshTeamData(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        OutgoingAsync __result = getOutgoingAsync("refreshTeamData", __cb);

        try {
            __result.prepare("refreshTeamData", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(playerId);
            __os.writeString(data);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public void end_refreshTeamData(AsyncResult __iresult) {
        __end(__iresult, "refreshTeamData");
    }


    public void removeUnit(String instanceId, int unitId) {
        removeUnit(instanceId, unitId, (Map<String, String>) null, false);
    }


    public void removeUnit(String instanceId, int unitId, Map<String, String> __ctx) {
        removeUnit(instanceId, unitId, __ctx, true);
    }


    private void removeUnit(String instanceId, int unitId, Map<String, String> __ctx, boolean __explicitCtx) {
        end_removeUnit(begin_removeUnit(instanceId, unitId, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_removeUnit(String instanceId, int unitId) {
        return begin_removeUnit(instanceId, unitId, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_removeUnit(String instanceId, int unitId, Map<String, String> __ctx) {
        return begin_removeUnit(instanceId, unitId, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_removeUnit(String instanceId, int unitId, Callback __cb) {
        return begin_removeUnit(instanceId, unitId, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_removeUnit(String instanceId, int unitId, Map<String, String> __ctx, Callback __cb) {
        return begin_removeUnit(instanceId, unitId, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_removeUnit(String instanceId, int unitId, Callback_XmdsManager_removeUnit __cb) {
        return begin_removeUnit(instanceId, unitId, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_removeUnit(String instanceId, int unitId, Map<String, String> __ctx, Callback_XmdsManager_removeUnit __cb) {
        return begin_removeUnit(instanceId, unitId, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_removeUnit(String instanceId, int unitId, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_removeUnit(instanceId, unitId, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_removeUnit(String instanceId, int unitId, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_removeUnit(instanceId, unitId, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_removeUnit(String instanceId, int unitId, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_removeUnit(instanceId, unitId, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_removeUnit(String instanceId, int unitId, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_removeUnit(instanceId, unitId, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_removeUnit(String instanceId, int unitId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_removeUnit(instanceId, unitId, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }


    private AsyncResult begin_removeUnit(String instanceId, int unitId, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        OutgoingAsync __result = getOutgoingAsync("removeUnit", __cb);

        try {
            __result.prepare("removeUnit", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(instanceId);
            __os.writeInt(unitId);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public void end_removeUnit(AsyncResult __iresult) {
        __end(__iresult, "removeUnit");
    }


    public void revivePlayer(String playerId, String data) {
        revivePlayer(playerId, data, (Map<String, String>) null, false);
    }


    public void revivePlayer(String playerId, String data, Map<String, String> __ctx) {
        revivePlayer(playerId, data, __ctx, true);
    }


    private void revivePlayer(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx) {
        end_revivePlayer(begin_revivePlayer(playerId, data, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_revivePlayer(String playerId, String data) {
        return begin_revivePlayer(playerId, data, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_revivePlayer(String playerId, String data, Map<String, String> __ctx) {
        return begin_revivePlayer(playerId, data, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_revivePlayer(String playerId, String data, Callback __cb) {
        return begin_revivePlayer(playerId, data, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_revivePlayer(String playerId, String data, Map<String, String> __ctx, Callback __cb) {
        return begin_revivePlayer(playerId, data, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_revivePlayer(String playerId, String data, Callback_XmdsManager_revivePlayer __cb) {
        return begin_revivePlayer(playerId, data, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_revivePlayer(String playerId, String data, Map<String, String> __ctx, Callback_XmdsManager_revivePlayer __cb) {
        return begin_revivePlayer(playerId, data, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_revivePlayer(String playerId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_revivePlayer(playerId, data, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_revivePlayer(String playerId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_revivePlayer(playerId, data, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_revivePlayer(String playerId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_revivePlayer(playerId, data, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_revivePlayer(String playerId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_revivePlayer(playerId, data, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_revivePlayer(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_revivePlayer(playerId, data, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }


    private AsyncResult begin_revivePlayer(String playerId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        OutgoingAsync __result = getOutgoingAsync("revivePlayer", __cb);

        try {
            __result.prepare("revivePlayer", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(playerId);
            __os.writeString(data);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public void end_revivePlayer(AsyncResult __iresult) {
        __end(__iresult, "revivePlayer");
    }


    public void triggrBattleFunction(String playerId, int eventId, String data) {
        triggrBattleFunction(playerId, eventId, data, (Map<String, String>) null, false);
    }


    public void triggrBattleFunction(String playerId, int eventId, String data, Map<String, String> __ctx) {
        triggrBattleFunction(playerId, eventId, data, __ctx, true);
    }


    private void triggrBattleFunction(String playerId, int eventId, String data, Map<String, String> __ctx, boolean __explicitCtx) {
        end_triggrBattleFunction(begin_triggrBattleFunction(playerId, eventId, data, __ctx, __explicitCtx, true, (CallbackBase) null));
    }


    public AsyncResult begin_triggrBattleFunction(String playerId, int eventId, String data) {
        return begin_triggrBattleFunction(playerId, eventId, data, (Map<String, String>) null, false, false, (CallbackBase) null);
    }


    public AsyncResult begin_triggrBattleFunction(String playerId, int eventId, String data, Map<String, String> __ctx) {
        return begin_triggrBattleFunction(playerId, eventId, data, __ctx, true, false, (CallbackBase) null);
    }


    public AsyncResult begin_triggrBattleFunction(String playerId, int eventId, String data, Callback __cb) {
        return begin_triggrBattleFunction(playerId, eventId, data, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_triggrBattleFunction(String playerId, int eventId, String data, Map<String, String> __ctx, Callback __cb) {
        return begin_triggrBattleFunction(playerId, eventId, data, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_triggrBattleFunction(String playerId, int eventId, String data, Callback_XmdsManager_triggrBattleFunction __cb) {
        return begin_triggrBattleFunction(playerId, eventId, data, (Map<String, String>) null, false, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_triggrBattleFunction(String playerId, int eventId, String data, Map<String, String> __ctx, Callback_XmdsManager_triggrBattleFunction __cb) {
        return begin_triggrBattleFunction(playerId, eventId, data, __ctx, true, false, (CallbackBase) __cb);
    }


    public AsyncResult begin_triggrBattleFunction(String playerId, int eventId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_triggrBattleFunction(playerId, eventId, data, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_triggrBattleFunction(String playerId, int eventId, String data, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_triggrBattleFunction(playerId, eventId, data, (Map<String, String>) null, false, false, __responseCb, __exceptionCb, __sentCb);
    }


    public AsyncResult begin_triggrBattleFunction(String playerId, int eventId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb) {
        return begin_triggrBattleFunction(playerId, eventId, data, __ctx, true, false, __responseCb, __exceptionCb, (Functional_BoolCallback) null);
    }


    public AsyncResult begin_triggrBattleFunction(String playerId, int eventId, String data, Map<String, String> __ctx, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_triggrBattleFunction(playerId, eventId, data, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }


    private AsyncResult begin_triggrBattleFunction(String playerId, int eventId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, Functional_VoidCallback __responseCb, Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
        return begin_triggrBattleFunction(playerId, eventId, data, __ctx, __explicitCtx, __synchronous, (CallbackBase) new Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }


    private AsyncResult begin_triggrBattleFunction(String playerId, int eventId, String data, Map<String, String> __ctx, boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
        OutgoingAsync __result = getOutgoingAsync("triggrBattleFunction", __cb);

        try {
            __result.prepare("triggrBattleFunction", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
            __os.writeString(playerId);
            __os.writeInt(eventId);
            __os.writeString(data);
            __result.endWriteParams();
            __result.invoke();
        } catch (Exception __ex) {

            __result.abort(__ex);
        }
        return (AsyncResult) __result;
    }


    public void end_triggrBattleFunction(AsyncResult __iresult) {
        __end(__iresult, "triggrBattleFunction");
    }


    public static XmdsManagerPrx checkedCast(ObjectPrx __obj) {
        return (XmdsManagerPrx) checkedCastImpl(__obj, ice_staticId(), XmdsManagerPrx.class, XmdsManagerPrxHelper.class);
    }


    public static XmdsManagerPrx checkedCast(ObjectPrx __obj, Map<String, String> __ctx) {
        return (XmdsManagerPrx) checkedCastImpl(__obj, __ctx, ice_staticId(), XmdsManagerPrx.class, XmdsManagerPrxHelper.class);
    }


    public static XmdsManagerPrx checkedCast(ObjectPrx __obj, String __facet) {
        return (XmdsManagerPrx) checkedCastImpl(__obj, __facet, ice_staticId(), XmdsManagerPrx.class, XmdsManagerPrxHelper.class);
    }


    public static XmdsManagerPrx checkedCast(ObjectPrx __obj, String __facet, Map<String, String> __ctx) {
        return (XmdsManagerPrx) checkedCastImpl(__obj, __facet, __ctx, ice_staticId(), XmdsManagerPrx.class, XmdsManagerPrxHelper.class);
    }


    public static XmdsManagerPrx uncheckedCast(ObjectPrx __obj) {
        return (XmdsManagerPrx) uncheckedCastImpl(__obj, XmdsManagerPrx.class, XmdsManagerPrxHelper.class);
    }


    public static XmdsManagerPrx uncheckedCast(ObjectPrx __obj, String __facet) {
        return (XmdsManagerPrx) uncheckedCastImpl(__obj, __facet, XmdsManagerPrx.class, XmdsManagerPrxHelper.class);
    }

    public static final String[] __ids = new String[]{"::Ice::Object", "::Xmds::XmdsManager"};


    public static final long serialVersionUID = 0L;


    public static String ice_staticId() {
        return __ids[1];
    }


    public static void __write(BasicStream __os, XmdsManagerPrx v) {
        __os.writeProxy(v);
    }


    public static XmdsManagerPrx __read(BasicStream __is) {
        ObjectPrx proxy = __is.readProxy();
        if (proxy != null) {

            XmdsManagerPrxHelper result = new XmdsManagerPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}


