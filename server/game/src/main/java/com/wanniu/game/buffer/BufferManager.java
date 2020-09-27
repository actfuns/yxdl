package com.wanniu.game.buffer;

import Xmds.RefreshPlayerPropertyChange;
import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.data.AttributeCO;
import com.wanniu.game.player.AttributeUtil;
import com.wanniu.game.player.WNPlayer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import pomelo.area.PlayerHandler;


public class BufferManager {
    public WNPlayer player;
    public List<RefreshPlayerPropertyChange> buffs;
    public List<RefreshPlayerPropertyChange> localBuffs;

    protected BufferManager() {
    }

    public BufferManager(WNPlayer player) {
        this.buffs = new ArrayList<>();
        this.localBuffs = new ArrayList<>();
        this.player = player;

        _clear();
        clearLocalBuff();
    }


    public void _clear() {
        int len = this.buffs.size();
        long nowTime = System.currentTimeMillis();
        for (int i = len - 1; i >= 0; i--) {
            RefreshPlayerPropertyChange buff = this.buffs.get(i);
            if (buff.timestamp < nowTime) {
                this.buffs.remove(i);
            }
        }
    }

    public void clearLocalBuff() {
        long nowTime = System.currentTimeMillis();
        int len = this.localBuffs.size();
        for (int i = len - 1; i >= 0; i--) {
            RefreshPlayerPropertyChange buff = this.localBuffs.get(i);
            if (buff.timestamp < nowTime) {
                this.localBuffs.remove(i);
            }
        }
    }


    public void toJson4Serialize() {
    }


    public void add(RefreshPlayerPropertyChange buff) {
        this.buffs.add(buff);
    }

    public void send2BattleServer() {
        _clear();
        Out.debug(new Object[]{"send2BattleServer :", this.buffs});
        for (int i = 0; i < this.buffs.size(); i++) {
            this.player.refreshPlayerPropertyChange(this.buffs.get(i));
        }
    }


    public boolean addLocalBuff(String key, long time, int value) {
        boolean addResult = false;
        long nowTime = System.currentTimeMillis();
        int len = this.localBuffs.size();
        for (int i = len - 1; i >= 0; i--) {
            RefreshPlayerPropertyChange buff = this.localBuffs.get(i);
            if (buff.key.equals(key) && buff.value == value) {
                long oldExpireTime = Math.max(buff.timestamp, nowTime);
                buff.timestamp = oldExpireTime + time;
                addResult = true;
                break;
            }
        }
        if (!addResult) {
            AttributeCO prop = AttributeUtil.getPropByKey(key);
            if (prop != null) {
                RefreshPlayerPropertyChange buff = new RefreshPlayerPropertyChange();
                buff.key = key;
                buff.value = value;
                buff.timestamp = nowTime + time;
                this.localBuffs.add(buff);
                addResult = true;
            }
        }
        if (addResult) {
            pushLocalBuffToClient();
        }
        return addResult;
    }


    public int getBuffAttrValue(String key) {
        int attrValue = 0;
        int len = this.localBuffs.size();
        long nowTime = System.currentTimeMillis();
        for (int i = len - 1; i >= 0; i--) {
            RefreshPlayerPropertyChange buff = this.localBuffs.get(i);
            if (buff.key.equals(key) && buff.timestamp >= nowTime) {

                attrValue += buff.value;
            }
        }
        return attrValue;
    }

    public List<PlayerHandler.BuffInfo> toJson4LocalBuffPayLoad() {
        List<PlayerHandler.BuffInfo> buffList = new ArrayList<>();
        int len = this.localBuffs.size();
        long nowTime = System.currentTimeMillis();
        for (int i = len - 1; i >= 0; i--) {
            RefreshPlayerPropertyChange buff = this.localBuffs.get(i);
            if (buff.timestamp < nowTime) {
                this.localBuffs.remove(i);
            } else {

                AttributeCO prop = AttributeUtil.getPropByKey(buff.key);
                if (prop != null) {
                    PlayerHandler.BuffInfo.Builder temp = PlayerHandler.BuffInfo.newBuilder();
                    temp.setId(prop.iD);
                    temp.setValue(buff.value);
                    temp.setIsFormat(prop.isFormat);
                    temp.setExpireTime((int) Math.floor((buff.timestamp / 1000L)));

                    buffList.add(temp.build());
                }
            }
        }
        buffList.sort(new Comparator<PlayerHandler.BuffInfo>() {
            public int compare(PlayerHandler.BuffInfo o1, PlayerHandler.BuffInfo o2) {
                return o1.getExpireTime() - o2.getExpireTime();
            }
        });


        return buffList;
    }


    public void pushLocalBuffToClient() {
        if (this.localBuffs.isEmpty()) {
            return;
        }
        List<PlayerHandler.BuffInfo> buffs = toJson4LocalBuffPayLoad();
        PlayerHandler.BuffPropertyPush.Builder data = PlayerHandler.BuffPropertyPush.newBuilder();
        data.addAllBuffList(buffs);
        this.player.receive("area.playerPush.buffPropertyPush", (GeneratedMessage) data.build());
    }
}


