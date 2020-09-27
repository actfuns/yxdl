package Xmds;

import Ice.AsyncResult;
import Ice.Callback;
import Ice.Exception;
import Ice.ObjectPrx;
import IceInternal.Functional_BoolCallback;
import IceInternal.Functional_GenericCallback1;
import IceInternal.Functional_IntCallback;
import IceInternal.Functional_VoidCallback;
import java.util.Map;

public interface XmdsManagerPrx extends ObjectPrx {
  void notifyBattleServer(String paramString1, String paramString2, String paramString3);
  
  void notifyBattleServer(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap);
  
  AsyncResult begin_notifyBattleServer(String paramString1, String paramString2, String paramString3);
  
  AsyncResult begin_notifyBattleServer(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap);
  
  AsyncResult begin_notifyBattleServer(String paramString1, String paramString2, String paramString3, Callback paramCallback);
  
  AsyncResult begin_notifyBattleServer(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_notifyBattleServer(String paramString1, String paramString2, String paramString3, Callback_XmdsManager_notifyBattleServer paramCallback_XmdsManager_notifyBattleServer);
  
  AsyncResult begin_notifyBattleServer(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap, Callback_XmdsManager_notifyBattleServer paramCallback_XmdsManager_notifyBattleServer);
  
  AsyncResult begin_notifyBattleServer(String paramString1, String paramString2, String paramString3, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_notifyBattleServer(String paramString1, String paramString2, String paramString3, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_notifyBattleServer(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_notifyBattleServer(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  void end_notifyBattleServer(AsyncResult paramAsyncResult);
  
  String getBornPlace(String paramString, int paramInt);
  
  String getBornPlace(String paramString, int paramInt, Map<String, String> paramMap);
  
  AsyncResult begin_getBornPlace(String paramString, int paramInt);
  
  AsyncResult begin_getBornPlace(String paramString, int paramInt, Map<String, String> paramMap);
  
  AsyncResult begin_getBornPlace(String paramString, int paramInt, Callback paramCallback);
  
  AsyncResult begin_getBornPlace(String paramString, int paramInt, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_getBornPlace(String paramString, int paramInt, Callback_XmdsManager_getBornPlace paramCallback_XmdsManager_getBornPlace);
  
  AsyncResult begin_getBornPlace(String paramString, int paramInt, Map<String, String> paramMap, Callback_XmdsManager_getBornPlace paramCallback_XmdsManager_getBornPlace);
  
  AsyncResult begin_getBornPlace(String paramString, int paramInt, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11);
  
  AsyncResult begin_getBornPlace(String paramString, int paramInt, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_getBornPlace(String paramString, int paramInt, Map<String, String> paramMap, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11);
  
  AsyncResult begin_getBornPlace(String paramString, int paramInt, Map<String, String> paramMap, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11, Functional_BoolCallback paramFunctional_BoolCallback);
  
  String end_getBornPlace(AsyncResult paramAsyncResult);
  
  String getAllUnitInfo(String paramString);
  
  String getAllUnitInfo(String paramString, Map<String, String> paramMap);
  
  AsyncResult begin_getAllUnitInfo(String paramString);
  
  AsyncResult begin_getAllUnitInfo(String paramString, Map<String, String> paramMap);
  
  AsyncResult begin_getAllUnitInfo(String paramString, Callback paramCallback);
  
  AsyncResult begin_getAllUnitInfo(String paramString, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_getAllUnitInfo(String paramString, Callback_XmdsManager_getAllUnitInfo paramCallback_XmdsManager_getAllUnitInfo);
  
  AsyncResult begin_getAllUnitInfo(String paramString, Map<String, String> paramMap, Callback_XmdsManager_getAllUnitInfo paramCallback_XmdsManager_getAllUnitInfo);
  
  AsyncResult begin_getAllUnitInfo(String paramString, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11);
  
  AsyncResult begin_getAllUnitInfo(String paramString, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_getAllUnitInfo(String paramString, Map<String, String> paramMap, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11);
  
  AsyncResult begin_getAllUnitInfo(String paramString, Map<String, String> paramMap, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11, Functional_BoolCallback paramFunctional_BoolCallback);
  
  String end_getAllUnitInfo(AsyncResult paramAsyncResult);
  
  String getAllNpcInfo(String paramString);
  
  String getAllNpcInfo(String paramString, Map<String, String> paramMap);
  
  AsyncResult begin_getAllNpcInfo(String paramString);
  
  AsyncResult begin_getAllNpcInfo(String paramString, Map<String, String> paramMap);
  
  AsyncResult begin_getAllNpcInfo(String paramString, Callback paramCallback);
  
  AsyncResult begin_getAllNpcInfo(String paramString, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_getAllNpcInfo(String paramString, Callback_XmdsManager_getAllNpcInfo paramCallback_XmdsManager_getAllNpcInfo);
  
  AsyncResult begin_getAllNpcInfo(String paramString, Map<String, String> paramMap, Callback_XmdsManager_getAllNpcInfo paramCallback_XmdsManager_getAllNpcInfo);
  
  AsyncResult begin_getAllNpcInfo(String paramString, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11);
  
  AsyncResult begin_getAllNpcInfo(String paramString, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_getAllNpcInfo(String paramString, Map<String, String> paramMap, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11);
  
  AsyncResult begin_getAllNpcInfo(String paramString, Map<String, String> paramMap, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11, Functional_BoolCallback paramFunctional_BoolCallback);
  
  String end_getAllNpcInfo(AsyncResult paramAsyncResult);
  
  String getPlayerData(String paramString, boolean paramBoolean);
  
  String getPlayerData(String paramString, boolean paramBoolean, Map<String, String> paramMap);
  
  AsyncResult begin_getPlayerData(String paramString, boolean paramBoolean);
  
  AsyncResult begin_getPlayerData(String paramString, boolean paramBoolean, Map<String, String> paramMap);
  
  AsyncResult begin_getPlayerData(String paramString, boolean paramBoolean, Callback paramCallback);
  
  AsyncResult begin_getPlayerData(String paramString, boolean paramBoolean, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_getPlayerData(String paramString, boolean paramBoolean, Callback_XmdsManager_getPlayerData paramCallback_XmdsManager_getPlayerData);
  
  AsyncResult begin_getPlayerData(String paramString, boolean paramBoolean, Map<String, String> paramMap, Callback_XmdsManager_getPlayerData paramCallback_XmdsManager_getPlayerData);
  
  AsyncResult begin_getPlayerData(String paramString, boolean paramBoolean, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11);
  
  AsyncResult begin_getPlayerData(String paramString, boolean paramBoolean, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_getPlayerData(String paramString, boolean paramBoolean, Map<String, String> paramMap, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11);
  
  AsyncResult begin_getPlayerData(String paramString, boolean paramBoolean, Map<String, String> paramMap, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11, Functional_BoolCallback paramFunctional_BoolCallback);
  
  String end_getPlayerData(AsyncResult paramAsyncResult);
  
  void onMonsterDiedDrops(String paramString1, String paramString2);
  
  void onMonsterDiedDrops(String paramString1, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_onMonsterDiedDrops(String paramString1, String paramString2);
  
  AsyncResult begin_onMonsterDiedDrops(String paramString1, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_onMonsterDiedDrops(String paramString1, String paramString2, Callback paramCallback);
  
  AsyncResult begin_onMonsterDiedDrops(String paramString1, String paramString2, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_onMonsterDiedDrops(String paramString1, String paramString2, Callback_XmdsManager_onMonsterDiedDrops paramCallback_XmdsManager_onMonsterDiedDrops);
  
  AsyncResult begin_onMonsterDiedDrops(String paramString1, String paramString2, Map<String, String> paramMap, Callback_XmdsManager_onMonsterDiedDrops paramCallback_XmdsManager_onMonsterDiedDrops);
  
  AsyncResult begin_onMonsterDiedDrops(String paramString1, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_onMonsterDiedDrops(String paramString1, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_onMonsterDiedDrops(String paramString1, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_onMonsterDiedDrops(String paramString1, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  void end_onMonsterDiedDrops(AsyncResult paramAsyncResult);
  
  void revivePlayer(String paramString1, String paramString2);
  
  void revivePlayer(String paramString1, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_revivePlayer(String paramString1, String paramString2);
  
  AsyncResult begin_revivePlayer(String paramString1, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_revivePlayer(String paramString1, String paramString2, Callback paramCallback);
  
  AsyncResult begin_revivePlayer(String paramString1, String paramString2, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_revivePlayer(String paramString1, String paramString2, Callback_XmdsManager_revivePlayer paramCallback_XmdsManager_revivePlayer);
  
  AsyncResult begin_revivePlayer(String paramString1, String paramString2, Map<String, String> paramMap, Callback_XmdsManager_revivePlayer paramCallback_XmdsManager_revivePlayer);
  
  AsyncResult begin_revivePlayer(String paramString1, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_revivePlayer(String paramString1, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_revivePlayer(String paramString1, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_revivePlayer(String paramString1, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  void end_revivePlayer(AsyncResult paramAsyncResult);
  
  void refreshSummonMount(String paramString, int paramInt1, int paramInt2);
  
  void refreshSummonMount(String paramString, int paramInt1, int paramInt2, Map<String, String> paramMap);
  
  AsyncResult begin_refreshSummonMount(String paramString, int paramInt1, int paramInt2);
  
  AsyncResult begin_refreshSummonMount(String paramString, int paramInt1, int paramInt2, Map<String, String> paramMap);
  
  AsyncResult begin_refreshSummonMount(String paramString, int paramInt1, int paramInt2, Callback paramCallback);
  
  AsyncResult begin_refreshSummonMount(String paramString, int paramInt1, int paramInt2, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_refreshSummonMount(String paramString, int paramInt1, int paramInt2, Callback_XmdsManager_refreshSummonMount paramCallback_XmdsManager_refreshSummonMount);
  
  AsyncResult begin_refreshSummonMount(String paramString, int paramInt1, int paramInt2, Map<String, String> paramMap, Callback_XmdsManager_refreshSummonMount paramCallback_XmdsManager_refreshSummonMount);
  
  AsyncResult begin_refreshSummonMount(String paramString, int paramInt1, int paramInt2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshSummonMount(String paramString, int paramInt1, int paramInt2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_refreshSummonMount(String paramString, int paramInt1, int paramInt2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshSummonMount(String paramString, int paramInt1, int paramInt2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  void end_refreshSummonMount(AsyncResult paramAsyncResult);
  
  void refreshPlayerBasicData(String paramString1, String paramString2);
  
  void refreshPlayerBasicData(String paramString1, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerBasicData(String paramString1, String paramString2);
  
  AsyncResult begin_refreshPlayerBasicData(String paramString1, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerBasicData(String paramString1, String paramString2, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerBasicData(String paramString1, String paramString2, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerBasicData(String paramString1, String paramString2, Callback_XmdsManager_refreshPlayerBasicData paramCallback_XmdsManager_refreshPlayerBasicData);
  
  AsyncResult begin_refreshPlayerBasicData(String paramString1, String paramString2, Map<String, String> paramMap, Callback_XmdsManager_refreshPlayerBasicData paramCallback_XmdsManager_refreshPlayerBasicData);
  
  AsyncResult begin_refreshPlayerBasicData(String paramString1, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerBasicData(String paramString1, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_refreshPlayerBasicData(String paramString1, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerBasicData(String paramString1, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  void end_refreshPlayerBasicData(AsyncResult paramAsyncResult);
  
  void refreshPlayerTeamData(String paramString1, String paramString2);
  
  void refreshPlayerTeamData(String paramString1, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerTeamData(String paramString1, String paramString2);
  
  AsyncResult begin_refreshPlayerTeamData(String paramString1, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerTeamData(String paramString1, String paramString2, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerTeamData(String paramString1, String paramString2, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerTeamData(String paramString1, String paramString2, Callback_XmdsManager_refreshPlayerTeamData paramCallback_XmdsManager_refreshPlayerTeamData);
  
  AsyncResult begin_refreshPlayerTeamData(String paramString1, String paramString2, Map<String, String> paramMap, Callback_XmdsManager_refreshPlayerTeamData paramCallback_XmdsManager_refreshPlayerTeamData);
  
  AsyncResult begin_refreshPlayerTeamData(String paramString1, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerTeamData(String paramString1, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_refreshPlayerTeamData(String paramString1, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerTeamData(String paramString1, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  void end_refreshPlayerTeamData(AsyncResult paramAsyncResult);
  
  void refreshPlayerRemainBagCountData(String paramString, int paramInt);
  
  void refreshPlayerRemainBagCountData(String paramString, int paramInt, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerRemainBagCountData(String paramString, int paramInt);
  
  AsyncResult begin_refreshPlayerRemainBagCountData(String paramString, int paramInt, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerRemainBagCountData(String paramString, int paramInt, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerRemainBagCountData(String paramString, int paramInt, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerRemainBagCountData(String paramString, int paramInt, Callback_XmdsManager_refreshPlayerRemainBagCountData paramCallback_XmdsManager_refreshPlayerRemainBagCountData);
  
  AsyncResult begin_refreshPlayerRemainBagCountData(String paramString, int paramInt, Map<String, String> paramMap, Callback_XmdsManager_refreshPlayerRemainBagCountData paramCallback_XmdsManager_refreshPlayerRemainBagCountData);
  
  AsyncResult begin_refreshPlayerRemainBagCountData(String paramString, int paramInt, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerRemainBagCountData(String paramString, int paramInt, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_refreshPlayerRemainBagCountData(String paramString, int paramInt, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerRemainBagCountData(String paramString, int paramInt, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  void end_refreshPlayerRemainBagCountData(AsyncResult paramAsyncResult);
  
  void refreshPlayerRemainTeamBagCountData(String paramString, int paramInt);
  
  void refreshPlayerRemainTeamBagCountData(String paramString, int paramInt, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerRemainTeamBagCountData(String paramString, int paramInt);
  
  AsyncResult begin_refreshPlayerRemainTeamBagCountData(String paramString, int paramInt, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerRemainTeamBagCountData(String paramString, int paramInt, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerRemainTeamBagCountData(String paramString, int paramInt, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerRemainTeamBagCountData(String paramString, int paramInt, Callback_XmdsManager_refreshPlayerRemainTeamBagCountData paramCallback_XmdsManager_refreshPlayerRemainTeamBagCountData);
  
  AsyncResult begin_refreshPlayerRemainTeamBagCountData(String paramString, int paramInt, Map<String, String> paramMap, Callback_XmdsManager_refreshPlayerRemainTeamBagCountData paramCallback_XmdsManager_refreshPlayerRemainTeamBagCountData);
  
  AsyncResult begin_refreshPlayerRemainTeamBagCountData(String paramString, int paramInt, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerRemainTeamBagCountData(String paramString, int paramInt, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_refreshPlayerRemainTeamBagCountData(String paramString, int paramInt, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerRemainTeamBagCountData(String paramString, int paramInt, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  void end_refreshPlayerRemainTeamBagCountData(AsyncResult paramAsyncResult);
  
  void refreshPlayerPetDataChange(String paramString1, int paramInt, String paramString2);
  
  void refreshPlayerPetDataChange(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerPetDataChange(String paramString1, int paramInt, String paramString2);
  
  AsyncResult begin_refreshPlayerPetDataChange(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerPetDataChange(String paramString1, int paramInt, String paramString2, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerPetDataChange(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerPetDataChange(String paramString1, int paramInt, String paramString2, Callback_XmdsManager_refreshPlayerPetDataChange paramCallback_XmdsManager_refreshPlayerPetDataChange);
  
  AsyncResult begin_refreshPlayerPetDataChange(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap, Callback_XmdsManager_refreshPlayerPetDataChange paramCallback_XmdsManager_refreshPlayerPetDataChange);
  
  AsyncResult begin_refreshPlayerPetDataChange(String paramString1, int paramInt, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerPetDataChange(String paramString1, int paramInt, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_refreshPlayerPetDataChange(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerPetDataChange(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  void end_refreshPlayerPetDataChange(AsyncResult paramAsyncResult);
  
  void refreshPlayerBattleEffect(String paramString1, String paramString2);
  
  void refreshPlayerBattleEffect(String paramString1, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerBattleEffect(String paramString1, String paramString2);
  
  AsyncResult begin_refreshPlayerBattleEffect(String paramString1, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerBattleEffect(String paramString1, String paramString2, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerBattleEffect(String paramString1, String paramString2, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerBattleEffect(String paramString1, String paramString2, Callback_XmdsManager_refreshPlayerBattleEffect paramCallback_XmdsManager_refreshPlayerBattleEffect);
  
  AsyncResult begin_refreshPlayerBattleEffect(String paramString1, String paramString2, Map<String, String> paramMap, Callback_XmdsManager_refreshPlayerBattleEffect paramCallback_XmdsManager_refreshPlayerBattleEffect);
  
  AsyncResult begin_refreshPlayerBattleEffect(String paramString1, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerBattleEffect(String paramString1, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_refreshPlayerBattleEffect(String paramString1, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerBattleEffect(String paramString1, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  void end_refreshPlayerBattleEffect(AsyncResult paramAsyncResult);
  
  void addPlayerAtt(String paramString1, String paramString2, String paramString3, int paramInt);
  
  void addPlayerAtt(String paramString1, String paramString2, String paramString3, int paramInt, Map<String, String> paramMap);
  
  AsyncResult begin_addPlayerAtt(String paramString1, String paramString2, String paramString3, int paramInt);
  
  AsyncResult begin_addPlayerAtt(String paramString1, String paramString2, String paramString3, int paramInt, Map<String, String> paramMap);
  
  AsyncResult begin_addPlayerAtt(String paramString1, String paramString2, String paramString3, int paramInt, Callback paramCallback);
  
  AsyncResult begin_addPlayerAtt(String paramString1, String paramString2, String paramString3, int paramInt, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_addPlayerAtt(String paramString1, String paramString2, String paramString3, int paramInt, Callback_XmdsManager_addPlayerAtt paramCallback_XmdsManager_addPlayerAtt);
  
  AsyncResult begin_addPlayerAtt(String paramString1, String paramString2, String paramString3, int paramInt, Map<String, String> paramMap, Callback_XmdsManager_addPlayerAtt paramCallback_XmdsManager_addPlayerAtt);
  
  AsyncResult begin_addPlayerAtt(String paramString1, String paramString2, String paramString3, int paramInt, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_addPlayerAtt(String paramString1, String paramString2, String paramString3, int paramInt, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_addPlayerAtt(String paramString1, String paramString2, String paramString3, int paramInt, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_addPlayerAtt(String paramString1, String paramString2, String paramString3, int paramInt, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  void end_addPlayerAtt(AsyncResult paramAsyncResult);
  
  void refreshPlayerSkill(String paramString1, int paramInt, String paramString2);
  
  void refreshPlayerSkill(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerSkill(String paramString1, int paramInt, String paramString2);
  
  AsyncResult begin_refreshPlayerSkill(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerSkill(String paramString1, int paramInt, String paramString2, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerSkill(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerSkill(String paramString1, int paramInt, String paramString2, Callback_XmdsManager_refreshPlayerSkill paramCallback_XmdsManager_refreshPlayerSkill);
  
  AsyncResult begin_refreshPlayerSkill(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap, Callback_XmdsManager_refreshPlayerSkill paramCallback_XmdsManager_refreshPlayerSkill);
  
  AsyncResult begin_refreshPlayerSkill(String paramString1, int paramInt, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerSkill(String paramString1, int paramInt, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_refreshPlayerSkill(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerSkill(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  void end_refreshPlayerSkill(AsyncResult paramAsyncResult);
  
  void refreshPlayerAvatar(String paramString1, String paramString2);
  
  void refreshPlayerAvatar(String paramString1, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerAvatar(String paramString1, String paramString2);
  
  AsyncResult begin_refreshPlayerAvatar(String paramString1, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerAvatar(String paramString1, String paramString2, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerAvatar(String paramString1, String paramString2, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerAvatar(String paramString1, String paramString2, Callback_XmdsManager_refreshPlayerAvatar paramCallback_XmdsManager_refreshPlayerAvatar);
  
  AsyncResult begin_refreshPlayerAvatar(String paramString1, String paramString2, Map<String, String> paramMap, Callback_XmdsManager_refreshPlayerAvatar paramCallback_XmdsManager_refreshPlayerAvatar);
  
  AsyncResult begin_refreshPlayerAvatar(String paramString1, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerAvatar(String paramString1, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_refreshPlayerAvatar(String paramString1, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerAvatar(String paramString1, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  void end_refreshPlayerAvatar(AsyncResult paramAsyncResult);
  
  String getPlayerPKInfoData(String paramString);
  
  String getPlayerPKInfoData(String paramString, Map<String, String> paramMap);
  
  AsyncResult begin_getPlayerPKInfoData(String paramString);
  
  AsyncResult begin_getPlayerPKInfoData(String paramString, Map<String, String> paramMap);
  
  AsyncResult begin_getPlayerPKInfoData(String paramString, Callback paramCallback);
  
  AsyncResult begin_getPlayerPKInfoData(String paramString, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_getPlayerPKInfoData(String paramString, Callback_XmdsManager_getPlayerPKInfoData paramCallback_XmdsManager_getPlayerPKInfoData);
  
  AsyncResult begin_getPlayerPKInfoData(String paramString, Map<String, String> paramMap, Callback_XmdsManager_getPlayerPKInfoData paramCallback_XmdsManager_getPlayerPKInfoData);
  
  AsyncResult begin_getPlayerPKInfoData(String paramString, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11);
  
  AsyncResult begin_getPlayerPKInfoData(String paramString, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_getPlayerPKInfoData(String paramString, Map<String, String> paramMap, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11);
  
  AsyncResult begin_getPlayerPKInfoData(String paramString, Map<String, String> paramMap, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11, Functional_BoolCallback paramFunctional_BoolCallback);
  
  String end_getPlayerPKInfoData(AsyncResult paramAsyncResult);
  
  String getPlayerSkillCDTime(String paramString);
  
  String getPlayerSkillCDTime(String paramString, Map<String, String> paramMap);
  
  AsyncResult begin_getPlayerSkillCDTime(String paramString);
  
  AsyncResult begin_getPlayerSkillCDTime(String paramString, Map<String, String> paramMap);
  
  AsyncResult begin_getPlayerSkillCDTime(String paramString, Callback paramCallback);
  
  AsyncResult begin_getPlayerSkillCDTime(String paramString, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_getPlayerSkillCDTime(String paramString, Callback_XmdsManager_getPlayerSkillCDTime paramCallback_XmdsManager_getPlayerSkillCDTime);
  
  AsyncResult begin_getPlayerSkillCDTime(String paramString, Map<String, String> paramMap, Callback_XmdsManager_getPlayerSkillCDTime paramCallback_XmdsManager_getPlayerSkillCDTime);
  
  AsyncResult begin_getPlayerSkillCDTime(String paramString, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11);
  
  AsyncResult begin_getPlayerSkillCDTime(String paramString, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_getPlayerSkillCDTime(String paramString, Map<String, String> paramMap, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11);
  
  AsyncResult begin_getPlayerSkillCDTime(String paramString, Map<String, String> paramMap, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11, Functional_BoolCallback paramFunctional_BoolCallback);
  
  String end_getPlayerSkillCDTime(AsyncResult paramAsyncResult);
  
  String canTalkWithNpc(String paramString, int paramInt);
  
  String canTalkWithNpc(String paramString, int paramInt, Map<String, String> paramMap);
  
  AsyncResult begin_canTalkWithNpc(String paramString, int paramInt);
  
  AsyncResult begin_canTalkWithNpc(String paramString, int paramInt, Map<String, String> paramMap);
  
  AsyncResult begin_canTalkWithNpc(String paramString, int paramInt, Callback paramCallback);
  
  AsyncResult begin_canTalkWithNpc(String paramString, int paramInt, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_canTalkWithNpc(String paramString, int paramInt, Callback_XmdsManager_canTalkWithNpc paramCallback_XmdsManager_canTalkWithNpc);
  
  AsyncResult begin_canTalkWithNpc(String paramString, int paramInt, Map<String, String> paramMap, Callback_XmdsManager_canTalkWithNpc paramCallback_XmdsManager_canTalkWithNpc);
  
  AsyncResult begin_canTalkWithNpc(String paramString, int paramInt, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11);
  
  AsyncResult begin_canTalkWithNpc(String paramString, int paramInt, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_canTalkWithNpc(String paramString, int paramInt, Map<String, String> paramMap, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11);
  
  AsyncResult begin_canTalkWithNpc(String paramString, int paramInt, Map<String, String> paramMap, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11, Functional_BoolCallback paramFunctional_BoolCallback);
  
  String end_canTalkWithNpc(AsyncResult paramAsyncResult);
  
  void refreshPlayerPropertyChange(String paramString1, String paramString2);
  
  void refreshPlayerPropertyChange(String paramString1, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerPropertyChange(String paramString1, String paramString2);
  
  AsyncResult begin_refreshPlayerPropertyChange(String paramString1, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerPropertyChange(String paramString1, String paramString2, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerPropertyChange(String paramString1, String paramString2, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerPropertyChange(String paramString1, String paramString2, Callback_XmdsManager_refreshPlayerPropertyChange paramCallback_XmdsManager_refreshPlayerPropertyChange);
  
  AsyncResult begin_refreshPlayerPropertyChange(String paramString1, String paramString2, Map<String, String> paramMap, Callback_XmdsManager_refreshPlayerPropertyChange paramCallback_XmdsManager_refreshPlayerPropertyChange);
  
  AsyncResult begin_refreshPlayerPropertyChange(String paramString1, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerPropertyChange(String paramString1, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_refreshPlayerPropertyChange(String paramString1, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerPropertyChange(String paramString1, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  void end_refreshPlayerPropertyChange(AsyncResult paramAsyncResult);
  
  void refreshPlayerPKMode(String paramString, int paramInt);
  
  void refreshPlayerPKMode(String paramString, int paramInt, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerPKMode(String paramString, int paramInt);
  
  AsyncResult begin_refreshPlayerPKMode(String paramString, int paramInt, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerPKMode(String paramString, int paramInt, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerPKMode(String paramString, int paramInt, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerPKMode(String paramString, int paramInt, Callback_XmdsManager_refreshPlayerPKMode paramCallback_XmdsManager_refreshPlayerPKMode);
  
  AsyncResult begin_refreshPlayerPKMode(String paramString, int paramInt, Map<String, String> paramMap, Callback_XmdsManager_refreshPlayerPKMode paramCallback_XmdsManager_refreshPlayerPKMode);
  
  AsyncResult begin_refreshPlayerPKMode(String paramString, int paramInt, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerPKMode(String paramString, int paramInt, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_refreshPlayerPKMode(String paramString, int paramInt, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerPKMode(String paramString, int paramInt, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  void end_refreshPlayerPKMode(AsyncResult paramAsyncResult);
  
  void refreshPlayerPKValue(String paramString, int paramInt);
  
  void refreshPlayerPKValue(String paramString, int paramInt, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerPKValue(String paramString, int paramInt);
  
  AsyncResult begin_refreshPlayerPKValue(String paramString, int paramInt, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerPKValue(String paramString, int paramInt, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerPKValue(String paramString, int paramInt, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerPKValue(String paramString, int paramInt, Callback_XmdsManager_refreshPlayerPKValue paramCallback_XmdsManager_refreshPlayerPKValue);
  
  AsyncResult begin_refreshPlayerPKValue(String paramString, int paramInt, Map<String, String> paramMap, Callback_XmdsManager_refreshPlayerPKValue paramCallback_XmdsManager_refreshPlayerPKValue);
  
  AsyncResult begin_refreshPlayerPKValue(String paramString, int paramInt, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerPKValue(String paramString, int paramInt, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_refreshPlayerPKValue(String paramString, int paramInt, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerPKValue(String paramString, int paramInt, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  void end_refreshPlayerPKValue(AsyncResult paramAsyncResult);
  
  void onFinishPickItem(String paramString1, String paramString2);
  
  void onFinishPickItem(String paramString1, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_onFinishPickItem(String paramString1, String paramString2);
  
  AsyncResult begin_onFinishPickItem(String paramString1, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_onFinishPickItem(String paramString1, String paramString2, Callback paramCallback);
  
  AsyncResult begin_onFinishPickItem(String paramString1, String paramString2, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_onFinishPickItem(String paramString1, String paramString2, Callback_XmdsManager_onFinishPickItem paramCallback_XmdsManager_onFinishPickItem);
  
  AsyncResult begin_onFinishPickItem(String paramString1, String paramString2, Map<String, String> paramMap, Callback_XmdsManager_onFinishPickItem paramCallback_XmdsManager_onFinishPickItem);
  
  AsyncResult begin_onFinishPickItem(String paramString1, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_onFinishPickItem(String paramString1, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_onFinishPickItem(String paramString1, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_onFinishPickItem(String paramString1, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  void end_onFinishPickItem(AsyncResult paramAsyncResult);
  
  void refreshPlayerPetSkillChange(String paramString1, int paramInt, String paramString2);
  
  void refreshPlayerPetSkillChange(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerPetSkillChange(String paramString1, int paramInt, String paramString2);
  
  AsyncResult begin_refreshPlayerPetSkillChange(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerPetSkillChange(String paramString1, int paramInt, String paramString2, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerPetSkillChange(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerPetSkillChange(String paramString1, int paramInt, String paramString2, Callback_XmdsManager_refreshPlayerPetSkillChange paramCallback_XmdsManager_refreshPlayerPetSkillChange);
  
  AsyncResult begin_refreshPlayerPetSkillChange(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap, Callback_XmdsManager_refreshPlayerPetSkillChange paramCallback_XmdsManager_refreshPlayerPetSkillChange);
  
  AsyncResult begin_refreshPlayerPetSkillChange(String paramString1, int paramInt, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerPetSkillChange(String paramString1, int paramInt, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_refreshPlayerPetSkillChange(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerPetSkillChange(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  void end_refreshPlayerPetSkillChange(AsyncResult paramAsyncResult);
  
  void refreshPlayerPetPropertyChange(String paramString1, String paramString2);
  
  void refreshPlayerPetPropertyChange(String paramString1, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerPetPropertyChange(String paramString1, String paramString2);
  
  AsyncResult begin_refreshPlayerPetPropertyChange(String paramString1, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerPetPropertyChange(String paramString1, String paramString2, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerPetPropertyChange(String paramString1, String paramString2, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerPetPropertyChange(String paramString1, String paramString2, Callback_XmdsManager_refreshPlayerPetPropertyChange paramCallback_XmdsManager_refreshPlayerPetPropertyChange);
  
  AsyncResult begin_refreshPlayerPetPropertyChange(String paramString1, String paramString2, Map<String, String> paramMap, Callback_XmdsManager_refreshPlayerPetPropertyChange paramCallback_XmdsManager_refreshPlayerPetPropertyChange);
  
  AsyncResult begin_refreshPlayerPetPropertyChange(String paramString1, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerPetPropertyChange(String paramString1, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_refreshPlayerPetPropertyChange(String paramString1, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerPetPropertyChange(String paramString1, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  void end_refreshPlayerPetPropertyChange(AsyncResult paramAsyncResult);
  
  void addUnits(String paramString1, String paramString2);
  
  void addUnits(String paramString1, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_addUnits(String paramString1, String paramString2);
  
  AsyncResult begin_addUnits(String paramString1, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_addUnits(String paramString1, String paramString2, Callback paramCallback);
  
  AsyncResult begin_addUnits(String paramString1, String paramString2, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_addUnits(String paramString1, String paramString2, Callback_XmdsManager_addUnits paramCallback_XmdsManager_addUnits);
  
  AsyncResult begin_addUnits(String paramString1, String paramString2, Map<String, String> paramMap, Callback_XmdsManager_addUnits paramCallback_XmdsManager_addUnits);
  
  AsyncResult begin_addUnits(String paramString1, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_addUnits(String paramString1, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_addUnits(String paramString1, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_addUnits(String paramString1, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  void end_addUnits(AsyncResult paramAsyncResult);
  
  void refreshPlayerPetFollowModeChange(String paramString, int paramInt);
  
  void refreshPlayerPetFollowModeChange(String paramString, int paramInt, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerPetFollowModeChange(String paramString, int paramInt);
  
  AsyncResult begin_refreshPlayerPetFollowModeChange(String paramString, int paramInt, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerPetFollowModeChange(String paramString, int paramInt, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerPetFollowModeChange(String paramString, int paramInt, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerPetFollowModeChange(String paramString, int paramInt, Callback_XmdsManager_refreshPlayerPetFollowModeChange paramCallback_XmdsManager_refreshPlayerPetFollowModeChange);
  
  AsyncResult begin_refreshPlayerPetFollowModeChange(String paramString, int paramInt, Map<String, String> paramMap, Callback_XmdsManager_refreshPlayerPetFollowModeChange paramCallback_XmdsManager_refreshPlayerPetFollowModeChange);
  
  AsyncResult begin_refreshPlayerPetFollowModeChange(String paramString, int paramInt, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerPetFollowModeChange(String paramString, int paramInt, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_refreshPlayerPetFollowModeChange(String paramString, int paramInt, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerPetFollowModeChange(String paramString, int paramInt, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  void end_refreshPlayerPetFollowModeChange(AsyncResult paramAsyncResult);
  
  void playerReady(String paramString);
  
  void playerReady(String paramString, Map<String, String> paramMap);
  
  AsyncResult begin_playerReady(String paramString);
  
  AsyncResult begin_playerReady(String paramString, Map<String, String> paramMap);
  
  AsyncResult begin_playerReady(String paramString, Callback paramCallback);
  
  AsyncResult begin_playerReady(String paramString, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_playerReady(String paramString, Callback_XmdsManager_playerReady paramCallback_XmdsManager_playerReady);
  
  AsyncResult begin_playerReady(String paramString, Map<String, String> paramMap, Callback_XmdsManager_playerReady paramCallback_XmdsManager_playerReady);
  
  AsyncResult begin_playerReady(String paramString, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_playerReady(String paramString, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_playerReady(String paramString, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_playerReady(String paramString, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  void end_playerReady(AsyncResult paramAsyncResult);
  
  void refreshTeamData(String paramString1, String paramString2);
  
  void refreshTeamData(String paramString1, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_refreshTeamData(String paramString1, String paramString2);
  
  AsyncResult begin_refreshTeamData(String paramString1, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_refreshTeamData(String paramString1, String paramString2, Callback paramCallback);
  
  AsyncResult begin_refreshTeamData(String paramString1, String paramString2, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_refreshTeamData(String paramString1, String paramString2, Callback_XmdsManager_refreshTeamData paramCallback_XmdsManager_refreshTeamData);
  
  AsyncResult begin_refreshTeamData(String paramString1, String paramString2, Map<String, String> paramMap, Callback_XmdsManager_refreshTeamData paramCallback_XmdsManager_refreshTeamData);
  
  AsyncResult begin_refreshTeamData(String paramString1, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshTeamData(String paramString1, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_refreshTeamData(String paramString1, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshTeamData(String paramString1, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  void end_refreshTeamData(AsyncResult paramAsyncResult);
  
  void autoBattle(String paramString1, String paramString2, boolean paramBoolean);
  
  void autoBattle(String paramString1, String paramString2, boolean paramBoolean, Map<String, String> paramMap);
  
  AsyncResult begin_autoBattle(String paramString1, String paramString2, boolean paramBoolean);
  
  AsyncResult begin_autoBattle(String paramString1, String paramString2, boolean paramBoolean, Map<String, String> paramMap);
  
  AsyncResult begin_autoBattle(String paramString1, String paramString2, boolean paramBoolean, Callback paramCallback);
  
  AsyncResult begin_autoBattle(String paramString1, String paramString2, boolean paramBoolean, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_autoBattle(String paramString1, String paramString2, boolean paramBoolean, Callback_XmdsManager_autoBattle paramCallback_XmdsManager_autoBattle);
  
  AsyncResult begin_autoBattle(String paramString1, String paramString2, boolean paramBoolean, Map<String, String> paramMap, Callback_XmdsManager_autoBattle paramCallback_XmdsManager_autoBattle);
  
  AsyncResult begin_autoBattle(String paramString1, String paramString2, boolean paramBoolean, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_autoBattle(String paramString1, String paramString2, boolean paramBoolean, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_autoBattle(String paramString1, String paramString2, boolean paramBoolean, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_autoBattle(String paramString1, String paramString2, boolean paramBoolean, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  void end_autoBattle(AsyncResult paramAsyncResult);
  
  String getInstanceStatistic(String paramString);
  
  String getInstanceStatistic(String paramString, Map<String, String> paramMap);
  
  AsyncResult begin_getInstanceStatistic(String paramString);
  
  AsyncResult begin_getInstanceStatistic(String paramString, Map<String, String> paramMap);
  
  AsyncResult begin_getInstanceStatistic(String paramString, Callback paramCallback);
  
  AsyncResult begin_getInstanceStatistic(String paramString, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_getInstanceStatistic(String paramString, Callback_XmdsManager_getInstanceStatistic paramCallback_XmdsManager_getInstanceStatistic);
  
  AsyncResult begin_getInstanceStatistic(String paramString, Map<String, String> paramMap, Callback_XmdsManager_getInstanceStatistic paramCallback_XmdsManager_getInstanceStatistic);
  
  AsyncResult begin_getInstanceStatistic(String paramString, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11);
  
  AsyncResult begin_getInstanceStatistic(String paramString, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_getInstanceStatistic(String paramString, Map<String, String> paramMap, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11);
  
  AsyncResult begin_getInstanceStatistic(String paramString, Map<String, String> paramMap, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11, Functional_BoolCallback paramFunctional_BoolCallback);
  
  String end_getInstanceStatistic(AsyncResult paramAsyncResult);
  
  int addUnit(String paramString1, int paramInt, String paramString2);
  
  int addUnit(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_addUnit(String paramString1, int paramInt, String paramString2);
  
  AsyncResult begin_addUnit(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_addUnit(String paramString1, int paramInt, String paramString2, Callback paramCallback);
  
  AsyncResult begin_addUnit(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_addUnit(String paramString1, int paramInt, String paramString2, Callback_XmdsManager_addUnit paramCallback_XmdsManager_addUnit);
  
  AsyncResult begin_addUnit(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap, Callback_XmdsManager_addUnit paramCallback_XmdsManager_addUnit);
  
  AsyncResult begin_addUnit(String paramString1, int paramInt, String paramString2, Functional_IntCallback paramFunctional_IntCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_addUnit(String paramString1, int paramInt, String paramString2, Functional_IntCallback paramFunctional_IntCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_addUnit(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap, Functional_IntCallback paramFunctional_IntCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_addUnit(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap, Functional_IntCallback paramFunctional_IntCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  int end_addUnit(AsyncResult paramAsyncResult);
  
  void removeUnit(String paramString, int paramInt);
  
  void removeUnit(String paramString, int paramInt, Map<String, String> paramMap);
  
  AsyncResult begin_removeUnit(String paramString, int paramInt);
  
  AsyncResult begin_removeUnit(String paramString, int paramInt, Map<String, String> paramMap);
  
  AsyncResult begin_removeUnit(String paramString, int paramInt, Callback paramCallback);
  
  AsyncResult begin_removeUnit(String paramString, int paramInt, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_removeUnit(String paramString, int paramInt, Callback_XmdsManager_removeUnit paramCallback_XmdsManager_removeUnit);
  
  AsyncResult begin_removeUnit(String paramString, int paramInt, Map<String, String> paramMap, Callback_XmdsManager_removeUnit paramCallback_XmdsManager_removeUnit);
  
  AsyncResult begin_removeUnit(String paramString, int paramInt, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_removeUnit(String paramString, int paramInt, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_removeUnit(String paramString, int paramInt, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_removeUnit(String paramString, int paramInt, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  void end_removeUnit(AsyncResult paramAsyncResult);
  
  String getZoneStaticData(String paramString);
  
  String getZoneStaticData(String paramString, Map<String, String> paramMap);
  
  AsyncResult begin_getZoneStaticData(String paramString);
  
  AsyncResult begin_getZoneStaticData(String paramString, Map<String, String> paramMap);
  
  AsyncResult begin_getZoneStaticData(String paramString, Callback paramCallback);
  
  AsyncResult begin_getZoneStaticData(String paramString, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_getZoneStaticData(String paramString, Callback_XmdsManager_getZoneStaticData paramCallback_XmdsManager_getZoneStaticData);
  
  AsyncResult begin_getZoneStaticData(String paramString, Map<String, String> paramMap, Callback_XmdsManager_getZoneStaticData paramCallback_XmdsManager_getZoneStaticData);
  
  AsyncResult begin_getZoneStaticData(String paramString, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11);
  
  AsyncResult begin_getZoneStaticData(String paramString, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_getZoneStaticData(String paramString, Map<String, String> paramMap, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11);
  
  AsyncResult begin_getZoneStaticData(String paramString, Map<String, String> paramMap, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11, Functional_BoolCallback paramFunctional_BoolCallback);
  
  String end_getZoneStaticData(AsyncResult paramAsyncResult);
  
  String getZoneRegions(String paramString);
  
  String getZoneRegions(String paramString, Map<String, String> paramMap);
  
  AsyncResult begin_getZoneRegions(String paramString);
  
  AsyncResult begin_getZoneRegions(String paramString, Map<String, String> paramMap);
  
  AsyncResult begin_getZoneRegions(String paramString, Callback paramCallback);
  
  AsyncResult begin_getZoneRegions(String paramString, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_getZoneRegions(String paramString, Callback_XmdsManager_getZoneRegions paramCallback_XmdsManager_getZoneRegions);
  
  AsyncResult begin_getZoneRegions(String paramString, Map<String, String> paramMap, Callback_XmdsManager_getZoneRegions paramCallback_XmdsManager_getZoneRegions);
  
  AsyncResult begin_getZoneRegions(String paramString, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11);
  
  AsyncResult begin_getZoneRegions(String paramString, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_getZoneRegions(String paramString, Map<String, String> paramMap, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11);
  
  AsyncResult begin_getZoneRegions(String paramString, Map<String, String> paramMap, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11, Functional_BoolCallback paramFunctional_BoolCallback);
  
  String end_getZoneRegions(AsyncResult paramAsyncResult);
  
  String getAllPlayerUUID();
  
  String getAllPlayerUUID(Map<String, String> paramMap);
  
  AsyncResult begin_getAllPlayerUUID();
  
  AsyncResult begin_getAllPlayerUUID(Map<String, String> paramMap);
  
  AsyncResult begin_getAllPlayerUUID(Callback paramCallback);
  
  AsyncResult begin_getAllPlayerUUID(Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_getAllPlayerUUID(Callback_XmdsManager_getAllPlayerUUID paramCallback_XmdsManager_getAllPlayerUUID);
  
  AsyncResult begin_getAllPlayerUUID(Map<String, String> paramMap, Callback_XmdsManager_getAllPlayerUUID paramCallback_XmdsManager_getAllPlayerUUID);
  
  AsyncResult begin_getAllPlayerUUID(Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11);
  
  AsyncResult begin_getAllPlayerUUID(Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_getAllPlayerUUID(Map<String, String> paramMap, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11);
  
  AsyncResult begin_getAllPlayerUUID(Map<String, String> paramMap, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11, Functional_BoolCallback paramFunctional_BoolCallback);
  
  String end_getAllPlayerUUID(AsyncResult paramAsyncResult);
  
  String getPlayerPetData(String paramString);
  
  String getPlayerPetData(String paramString, Map<String, String> paramMap);
  
  AsyncResult begin_getPlayerPetData(String paramString);
  
  AsyncResult begin_getPlayerPetData(String paramString, Map<String, String> paramMap);
  
  AsyncResult begin_getPlayerPetData(String paramString, Callback paramCallback);
  
  AsyncResult begin_getPlayerPetData(String paramString, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_getPlayerPetData(String paramString, Callback_XmdsManager_getPlayerPetData paramCallback_XmdsManager_getPlayerPetData);
  
  AsyncResult begin_getPlayerPetData(String paramString, Map<String, String> paramMap, Callback_XmdsManager_getPlayerPetData paramCallback_XmdsManager_getPlayerPetData);
  
  AsyncResult begin_getPlayerPetData(String paramString, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11);
  
  AsyncResult begin_getPlayerPetData(String paramString, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_getPlayerPetData(String paramString, Map<String, String> paramMap, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11);
  
  AsyncResult begin_getPlayerPetData(String paramString, Map<String, String> paramMap, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11, Functional_BoolCallback paramFunctional_BoolCallback);
  
  String end_getPlayerPetData(AsyncResult paramAsyncResult);
  
  String getPlayerStatistic(String paramString);
  
  String getPlayerStatistic(String paramString, Map<String, String> paramMap);
  
  AsyncResult begin_getPlayerStatistic(String paramString);
  
  AsyncResult begin_getPlayerStatistic(String paramString, Map<String, String> paramMap);
  
  AsyncResult begin_getPlayerStatistic(String paramString, Callback paramCallback);
  
  AsyncResult begin_getPlayerStatistic(String paramString, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_getPlayerStatistic(String paramString, Callback_XmdsManager_getPlayerStatistic paramCallback_XmdsManager_getPlayerStatistic);
  
  AsyncResult begin_getPlayerStatistic(String paramString, Map<String, String> paramMap, Callback_XmdsManager_getPlayerStatistic paramCallback_XmdsManager_getPlayerStatistic);
  
  AsyncResult begin_getPlayerStatistic(String paramString, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11);
  
  AsyncResult begin_getPlayerStatistic(String paramString, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_getPlayerStatistic(String paramString, Map<String, String> paramMap, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11);
  
  AsyncResult begin_getPlayerStatistic(String paramString, Map<String, String> paramMap, Functional_GenericCallback1<String> paramFunctional_GenericCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback11, Functional_BoolCallback paramFunctional_BoolCallback);
  
  String end_getPlayerStatistic(AsyncResult paramAsyncResult);
  
  boolean canUseItem(String paramString);
  
  boolean canUseItem(String paramString, Map<String, String> paramMap);
  
  AsyncResult begin_canUseItem(String paramString);
  
  AsyncResult begin_canUseItem(String paramString, Map<String, String> paramMap);
  
  AsyncResult begin_canUseItem(String paramString, Callback paramCallback);
  
  AsyncResult begin_canUseItem(String paramString, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_canUseItem(String paramString, Callback_XmdsManager_canUseItem paramCallback_XmdsManager_canUseItem);
  
  AsyncResult begin_canUseItem(String paramString, Map<String, String> paramMap, Callback_XmdsManager_canUseItem paramCallback_XmdsManager_canUseItem);
  
  AsyncResult begin_canUseItem(String paramString, Functional_BoolCallback paramFunctional_BoolCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_canUseItem(String paramString, Functional_BoolCallback paramFunctional_BoolCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback2);
  
  AsyncResult begin_canUseItem(String paramString, Map<String, String> paramMap, Functional_BoolCallback paramFunctional_BoolCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_canUseItem(String paramString, Map<String, String> paramMap, Functional_BoolCallback paramFunctional_BoolCallback1, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback2);
  
  boolean end_canUseItem(AsyncResult paramAsyncResult);
  
  void helpRevivePlayer(String paramString1, String paramString2, int paramInt);
  
  void helpRevivePlayer(String paramString1, String paramString2, int paramInt, Map<String, String> paramMap);
  
  AsyncResult begin_helpRevivePlayer(String paramString1, String paramString2, int paramInt);
  
  AsyncResult begin_helpRevivePlayer(String paramString1, String paramString2, int paramInt, Map<String, String> paramMap);
  
  AsyncResult begin_helpRevivePlayer(String paramString1, String paramString2, int paramInt, Callback paramCallback);
  
  AsyncResult begin_helpRevivePlayer(String paramString1, String paramString2, int paramInt, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_helpRevivePlayer(String paramString1, String paramString2, int paramInt, Callback_XmdsManager_helpRevivePlayer paramCallback_XmdsManager_helpRevivePlayer);
  
  AsyncResult begin_helpRevivePlayer(String paramString1, String paramString2, int paramInt, Map<String, String> paramMap, Callback_XmdsManager_helpRevivePlayer paramCallback_XmdsManager_helpRevivePlayer);
  
  AsyncResult begin_helpRevivePlayer(String paramString1, String paramString2, int paramInt, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_helpRevivePlayer(String paramString1, String paramString2, int paramInt, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_helpRevivePlayer(String paramString1, String paramString2, int paramInt, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_helpRevivePlayer(String paramString1, String paramString2, int paramInt, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  void end_helpRevivePlayer(AsyncResult paramAsyncResult);
  
  void refreshPlayerPetBaseInfoChange(String paramString1, String paramString2);
  
  void refreshPlayerPetBaseInfoChange(String paramString1, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerPetBaseInfoChange(String paramString1, String paramString2);
  
  AsyncResult begin_refreshPlayerPetBaseInfoChange(String paramString1, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerPetBaseInfoChange(String paramString1, String paramString2, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerPetBaseInfoChange(String paramString1, String paramString2, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerPetBaseInfoChange(String paramString1, String paramString2, Callback_XmdsManager_refreshPlayerPetBaseInfoChange paramCallback_XmdsManager_refreshPlayerPetBaseInfoChange);
  
  AsyncResult begin_refreshPlayerPetBaseInfoChange(String paramString1, String paramString2, Map<String, String> paramMap, Callback_XmdsManager_refreshPlayerPetBaseInfoChange paramCallback_XmdsManager_refreshPlayerPetBaseInfoChange);
  
  AsyncResult begin_refreshPlayerPetBaseInfoChange(String paramString1, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerPetBaseInfoChange(String paramString1, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_refreshPlayerPetBaseInfoChange(String paramString1, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerPetBaseInfoChange(String paramString1, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  void end_refreshPlayerPetBaseInfoChange(AsyncResult paramAsyncResult);
  
  void triggrBattleFunction(String paramString1, int paramInt, String paramString2);
  
  void triggrBattleFunction(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_triggrBattleFunction(String paramString1, int paramInt, String paramString2);
  
  AsyncResult begin_triggrBattleFunction(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap);
  
  AsyncResult begin_triggrBattleFunction(String paramString1, int paramInt, String paramString2, Callback paramCallback);
  
  AsyncResult begin_triggrBattleFunction(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_triggrBattleFunction(String paramString1, int paramInt, String paramString2, Callback_XmdsManager_triggrBattleFunction paramCallback_XmdsManager_triggrBattleFunction);
  
  AsyncResult begin_triggrBattleFunction(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap, Callback_XmdsManager_triggrBattleFunction paramCallback_XmdsManager_triggrBattleFunction);
  
  AsyncResult begin_triggrBattleFunction(String paramString1, int paramInt, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_triggrBattleFunction(String paramString1, int paramInt, String paramString2, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_triggrBattleFunction(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_triggrBattleFunction(String paramString1, int paramInt, String paramString2, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  void end_triggrBattleFunction(AsyncResult paramAsyncResult);
  
  void refreshPlayerPKLevel(String paramString, int paramInt);
  
  void refreshPlayerPKLevel(String paramString, int paramInt, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerPKLevel(String paramString, int paramInt);
  
  AsyncResult begin_refreshPlayerPKLevel(String paramString, int paramInt, Map<String, String> paramMap);
  
  AsyncResult begin_refreshPlayerPKLevel(String paramString, int paramInt, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerPKLevel(String paramString, int paramInt, Map<String, String> paramMap, Callback paramCallback);
  
  AsyncResult begin_refreshPlayerPKLevel(String paramString, int paramInt, Callback_XmdsManager_refreshPlayerPKLevel paramCallback_XmdsManager_refreshPlayerPKLevel);
  
  AsyncResult begin_refreshPlayerPKLevel(String paramString, int paramInt, Map<String, String> paramMap, Callback_XmdsManager_refreshPlayerPKLevel paramCallback_XmdsManager_refreshPlayerPKLevel);
  
  AsyncResult begin_refreshPlayerPKLevel(String paramString, int paramInt, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerPKLevel(String paramString, int paramInt, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  AsyncResult begin_refreshPlayerPKLevel(String paramString, int paramInt, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1);
  
  AsyncResult begin_refreshPlayerPKLevel(String paramString, int paramInt, Map<String, String> paramMap, Functional_VoidCallback paramFunctional_VoidCallback, Functional_GenericCallback1<Exception> paramFunctional_GenericCallback1, Functional_BoolCallback paramFunctional_BoolCallback);
  
  void end_refreshPlayerPKLevel(AsyncResult paramAsyncResult);
}


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\Xmds\XmdsManagerPrx.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */