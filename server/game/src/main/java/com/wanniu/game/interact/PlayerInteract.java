package com.wanniu.game.interact;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.db.GCache;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.Utils;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.InteractionCO;
import com.wanniu.game.player.WNPlayer;

import java.util.ArrayList;
import java.util.Collection;

import pomelo.area.InteractHandler;


public class PlayerInteract {
    private WNPlayer player;
    private int friendNum;
    private int commonNum;

    public PlayerInteract(WNPlayer player) {
        this.player = player;
        this.friendNum = 10;
        this.commonNum = 10;
        init();
    }

    private final void init() {
        String interact = GCache.hget(ConstsTR.player_interact_numTR.value, this.player.getId());
        if (interact != null) {
            String[] arr = interact.split("#");
            this.friendNum = Integer.parseInt(arr[0]);
            this.commonNum = Integer.parseInt(arr[1]);
        } else {
            this.friendNum = 10;
            this.commonNum = 10;
        }
    }

    public void sync() {
        GCache.hset(ConstsTR.player_interact_numTR.value, this.player.getId(), this.friendNum + "#" + this.commonNum);
    }

    public void push() {
        String interact = GCache.hget(ConstsTR.player_interactTR.value, this.player.getId());
        if (interact != null) {
            JSONArray arr = JSON.parseArray(interact);
            for (int i = 0; i < arr.size(); i++) {
                JSONObject data = arr.getJSONObject(i);
                receive(data.getIntValue("id"), data.getString("name"));
            }
            GCache.hremove(ConstsTR.player_interactTR.value, this.player.getId());
        }
    }

    public boolean send(int id, String playerId, String playerName) {
        InteractionCO prop = getPropById(id);
        if (prop == null) {
            return false;
        }
        WNPlayer player = GWorld.getInstance().getPlayer(playerId);
        if (player != null) {
            player.getInteractManager().receive(id, this.player.getName());
        } else {
            String interact = GCache.hget(ConstsTR.player_interactTR.value, playerId);
            JSONArray arr = (interact != null) ? JSON.parseArray(interact) : new JSONArray();
            arr.add(Utils.toJSON(new Object[]{"id", Integer.valueOf(id), "name", this.player.getName()}));
            GCache.hset(ConstsTR.player_interactTR.value, playerId, arr.toJSONString());
        }
        subTimes(id);
        sendMessage(id, playerName);
        return true;
    }

    public void receive(int id, String name) {
        InteractionCO prop = getPropById(id);
        if (prop == null) {
            return;
        }
        this.player.player.charm += prop.charm;
        InteractHandler.ReceiveInteractPush.Builder data = InteractHandler.ReceiveInteractPush.newBuilder();
        data.setS2CCode(200);
        data.setId(id);
        data.setSendPlayerName(name);
        data.setShow(prop.show);
        this.player.receive("area.interactPush.receiveInteractPush", (GeneratedMessage) data.build());
    }

    public final InteractHandler.InteractTimesResponse.Builder interactTimes(WNPlayer player) {
        InteractHandler.InteractTimesResponse.Builder data = InteractHandler.InteractTimesResponse.newBuilder();
        data.setS2CCharm((player.getPlayer()).charm);
        ArrayList<InteractHandler.InteractTimes> list = new ArrayList<>();
        InteractHandler.InteractTimes.Builder time1 = InteractHandler.InteractTimes.newBuilder();
        time1.setType(Const.InteractType.FRIEND.getValue());
        time1.setTimes(this.friendNum);
        list.add(time1.build());
        InteractHandler.InteractTimes.Builder time2 = InteractHandler.InteractTimes.newBuilder();
        time2.setType(Const.InteractType.UNFRIEND.getValue());
        time2.setTimes(this.commonNum);
        list.add(time2.build());
        data.addAllS2CData(list);
        return data;
    }

    public final boolean enoughTimes(int id) {
        InteractionCO prop = getPropById(id);
        if (prop == null) {
            return false;
        }

        if (prop.type == Const.InteractType.FRIEND.getValue()) {
            if (this.friendNum > 0) {
                return true;
            }
        } else if (this.commonNum > 0) {
            return true;
        }


        return false;
    }

    public void subTimes(int id) {
        InteractionCO prop = getPropById(id);
        if (prop == null) {
            return;
        }

        if (prop.type == Const.InteractType.FRIEND.getValue()) {
            if (this.friendNum > 0) {
                this.friendNum--;
            }
        } else if (this.commonNum > 0) {
            this.commonNum--;
        }
    }


    public void sendMessage(int id, String name) {
        InteractionCO prop = getPropById(id);
        if (prop == null) {
            return;
        }

        String message = prop.message;
        message = message.replaceAll("\\|1\\|", this.player.getName());
        message = message.replaceAll("\\|2\\|", name);

        Out.debug(new Object[]{prop.message, "\n", message});

        MessageUtil.sendRollChat(this.player.getLogicServerId(), message, Const.CHAT_SCOPE.SYSTEM);
    }

    public static InteractionCO getPropById(int id) {
        return (InteractionCO) GameData.Interactions.get(Integer.valueOf(id));
    }

    public static ArrayList<InteractHandler.InteractConfig> getConfig() {
        ArrayList<InteractHandler.InteractConfig> data = new ArrayList<>();
        Collection<InteractionCO> props = GameData.Interactions.values();
        for (InteractionCO prop : props) {
            InteractHandler.InteractConfig.Builder tmp = InteractHandler.InteractConfig.newBuilder();
            tmp.setId(prop.id);
            tmp.setName(prop.name);
            tmp.setType(prop.type);
            tmp.setCharm(prop.charm);
            tmp.setGold(prop.gold);
            tmp.setDiamond(prop.diamond);
            tmp.setShow(prop.show);
            data.add(tmp.build());
        }
        return data;
    }
}


