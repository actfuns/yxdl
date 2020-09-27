package com.wanniu.game.player;

import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.game.protocol.PomeloPush;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.core.util.RandomUtil;
import com.wanniu.game.area.Area;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.Utils;
import com.wanniu.game.common.msg.MessagePush;
import com.wanniu.game.message.MessageData;
import com.wanniu.game.player.po.AllBlobPO;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.game.util.RobotUtil;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

import pomelo.Common;
import pomelo.area.FightLevelHandler;


public class WNRobot
        extends WNPlayer {
    public ScheduledFuture<?> quitTeamFuture;
    public ScheduledFuture<?> handFuture;
    public ScheduledFuture<?> hpFuture;

    public WNRobot(AllBlobPO allBlobData) {
        super(allBlobData);
    }

    public WNRobot(PlayerPO player) {
        super(player);
    }

    public boolean isRobot() {
        return true;
    }


    public void sync() {
        Out.debug(new Object[]{"sync................"});
    }


    public boolean onMessage(int operate, MessageData message) {
        Out.debug(new Object[]{"onMessage................", Integer.valueOf(message.messageType)});
        return false;
    }


    public void pushEffectData() {
        Out.debug(new Object[]{"pushEffectData................"});
    }


    public void pushDynamicData(String key, Object value) {
        Out.debug(new Object[]{"pushDynamicData1................"});
    }


    public void pushDynamicData(String key, Object value, Const.GOODS_CHANGE_TYPE origin) {
        Out.debug(new Object[]{"pushDynamicData2................"});
    }


    public void pushDynamicData(String key, Object value, Const.GOODS_CHANGE_TYPE origin, List<Common.KeyValueStruct> itemChange) {
        Out.debug(new Object[]{"pushDynamicData3................"});
    }


    public void pushDynamicData(Map<String, Object> atts) {
        Out.debug(new Object[]{"pushDynamicData4................"});
    }


    public void pushAndRefreshEffect(boolean isHpMpValid) {
        Out.debug(new Object[]{"pushAndRefreshEffect................"});
    }


    public void sendSysTip(String content) {
        Out.debug(new Object[]{"sendSysTip................"});
    }


    public void sendSysTip(String content, Const.TipsType type) {
        Out.debug(new Object[]{"sendSysTip2................"});
    }


    public void puchFuncGoToTicketNotEnough() {
        Out.debug(new Object[]{"puchFuncGoToTicketNotEnough................"});
    }


    public void puchFuncGoToPickItem() {
        Out.debug(new Object[]{"puchFuncGoToPickItem................"});
    }


    public void sendLeaveWord() {
        Out.debug(new Object[]{"sendLeaveWord................"});
    }


    public void pushChatSystemMessage(Const.SYS_CHAT_TYPE type, String value1, Object value2, String value3) {
        Out.debug(new Object[]{"pushChatSystemMessage................"});
    }


    public void pushChatSystemMessage(Const.SYS_CHAT_TYPE type, String value1, Object value2, String value3, Const.GOODS_CHANGE_TYPE from) {
        Out.debug(new Object[]{"pushChatSystemMessage2................"});
    }


    public void update() {
        Out.warn(new Object[]{"update................"});
    }

    public void free() {
        Out.info(new Object[]{"free robot >> ", getName()});
        try {
            if (this.hpFuture != null) {
                this.hpFuture.cancel(true);
                this.hpFuture = null;
            }
            getTeamManager().setTeamData(null);
            if (this.quitTeamFuture != null) {
                this.quitTeamFuture.cancel(true);
                this.quitTeamFuture = null;
            }
        } finally {
            JobFactory.addDelayJob(() -> RobotUtil.freeRobot(this),

                    Utils.getSecMills(5, 10));
        }
    }


    public void receive(Message msg) {
        String route = ((PomeloPush) msg).getRoute();
        if (route == null) {
            return;
        }
        if (route.endsWith("throwPointItemListPush") &&
                RandomUtil.getInt(100) < 70) {
            Area area = getArea();
            area.onRobotThrowPoint(this);
        }
    }


    public void write(Message msg) {
        String route = ((PomeloPush) msg).getRoute();
        if (route == null) {
            return;
        }
        if (route.endsWith("onConfirmEnterFubenPush")) {
            handConfirmEnterFuben(((MessagePush) msg).getMsg());
        } else if (route.endsWith("closeHandUpPush") &&
                this.handFuture != null) {
            this.handFuture.cancel(true);
            this.handFuture = null;
        }
    }


    public void receive(String route, GeneratedMessage msg) {
        if (route.endsWith("playerRelivePush")) {
            RobotUtil.onRobotDie(this.area, this);
        } else if (route.endsWith("onConfirmEnterFubenPush")) {
            handConfirmEnterFuben(msg);
        } else if (route.endsWith("five2FiveApplyMatchPush")) {
            JobFactory.addDelayJob(() -> this.five2FiveManager.refuseMatch(this),

                    Utils.getSecMills(2, 8));
        }
    }


    public void handConfirmEnterFuben(GeneratedMessage msg) {
        FightLevelHandler.OnConfirmEnterFubenPush fuben = (FightLevelHandler.OnConfirmEnterFubenPush) msg;
        this.handFuture = JobFactory.addDelayJob(() -> {
            this.handFuture = null;
            this.fightLevelManager.replyEnterDungeon(this, Const.HandsUpState.ACCEPT.value, fuben.getS2CFubenId());
        }Utils.getSecMills(1, 10));
    }
}


