package com.wanniu.game.player;

import com.alibaba.fastjson.JSON;
import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.proxy.ProxyClient;
import com.wanniu.core.tcp.protocol.Body;
import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.achievement.AchievementManager;
import com.wanniu.game.area.Area;
import com.wanniu.game.area.AreaData;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.buffer.BufferManager;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.Utils;
import com.wanniu.game.common.msg.MessagePush;
import com.wanniu.game.daily.DailyActivityMgr;
import com.wanniu.game.illusion.IllusionManager;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.message.MessageData;
import com.wanniu.game.petNew.PetNew;
import com.wanniu.game.poes.IllusionPO;
import com.wanniu.game.poes.PetNewPO;
import com.wanniu.game.poes.PlayerAttachPO;
import com.wanniu.game.poes.VipPO;
import com.wanniu.game.poes.XianYuanPO;
import com.wanniu.game.task.TaskEvent;
import com.wanniu.game.vip.VipManager;

import java.io.IOException;
import java.util.ArrayList;

public class WNProxy
        extends WNPlayer {
    public String playerId;
    public String name;
    public int sid;
    public int level;
    public int pro;
    public int guildExdExp;
    public int guildExdGold;
    public int btlExdGold;
    public PetNew pet;
    public float vipExpRatio;
    public float vipGoldRatio;
    public boolean robot;
    public XianYuanPO xianYuan;

    class BufferManagerProxy
            extends BufferManager {
        public int getBuffAttrValue(String key) {
            return 0;
        }
    }

    class IllusionManagerProxy
            extends IllusionManager {
        public IllusionManagerProxy(WNPlayer player, IllusionPO illusionPO) {
            super(player, illusionPO);
        }

        public int addAward(String code, int value) {
            WNProxy.this.onProxyEvent(4, body -> {
                body.writeString(code);
                body.writeInt(value);
            });
            return value;
        }
    }

    class VipManagerProxy
            extends VipManager {
        public VipManagerProxy(WNPlayer player, VipPO po) {
            super(player, po);
        }

        public float getVipExpRatio() {
            return WNProxy.this.vipExpRatio;
        }

        public float getExtGoldRatio() {
            return WNProxy.this.vipGoldRatio;
        }
    }


    class WNBagProxy
            extends WNBag {
        public void addEntityItem(NormalItem item, Const.GOODS_CHANGE_TYPE fromDes) {
            WNProxy.this.onProxyEvent(2, body -> {
                body.writeInt(fromDes.value);
                body.writeString(Utils.serialize(item.itemDb));
            });
        }

        public boolean addCodeItemMail(String itemCode, int number, Const.ForceType forceType, Const.GOODS_CHANGE_TYPE fromDes, String mailKey) {
            WNProxy.this.onProxyEvent(14, body -> {
                body.writeString(itemCode);
                body.writeInt(number);
                body.writeInt((forceType == null) ? 0 : forceType.getValue());
                body.writeInt((fromDes == null) ? 0 : fromDes.getValue());
                body.writeString(mailKey);
            });
            return true;
        }

        public boolean testAddCodeItem(String itemCode, int itemNum) {
            return true;
        }
    }

    class PetNewProxy
            extends PetNew {
        public PetNewProxy(WNPlayer master, PetNewPO po) {
            super(po, master);
        }

        public int addExp(int exp, boolean synchBattleServer) {
            WNProxy.this.onProxyEvent(5, body -> body.writeInt(exp));


            return exp;
        }
    }


    class AchievementManagerProxy
            extends AchievementManager {
        public void onPassedDungeon(int id) {
            WNProxy.this.onProxyEvent(8, body -> body.writeInt(id));
        }
    }


    class DailyActivityMgrProxy
            extends DailyActivityMgr {
        public void onEvent(Const.DailyType type, String target, int num) {
            WNProxy.this.onProxyEvent(9, body -> {
                body.writeString(type.toString());
                body.writeString(target);
                body.writeInt(num);
            });
        }
    }


    class PlayerAttachPOProxy
            extends PlayerAttachPO {
        public void addFirstMonsterId(int monsterId) {
            WNProxy.this.onProxyEvent(6, body -> body.writeInt(monsterId));
        }
    }


    public WNProxy(String playerId, int sid) {
        this.playerId = playerId;
        this.sid = sid;
        this.bag = new WNBagProxy();
        this.dailyActivityMgr = new DailyActivityMgrProxy();
        this.achievementManager = new AchievementManagerProxy();
        this.bufferManager = new BufferManagerProxy();
    }

    public void from(Packet pak) {
        this.robot = pak.getBoolean();
        this.vipExpRatio = pak.getFloat();
        this.guildExdExp = pak.getInt();
        this.guildExdGold = pak.getInt();
        this.btlExdGold = pak.getInt();
        this.playerAttachPO = new PlayerAttachPOProxy();
        String petPo = pak.getString();
        String illusionPO = pak.getString();
        String vipPO = pak.getString();
        String xianYuan = pak.getString();
        int count = pak.getShort();
        this.playerAttachPO.firstKillMonsterIds = new ArrayList(count);
        for (int i = 0; i < count; i++) {
            this.playerAttachPO.firstKillMonsterIds.add(Integer.valueOf(pak.getInt()));
        }
        if (StringUtil.isNotEmpty(petPo)) {
            this.pet = new PetNewProxy(this, (PetNewPO) JSON.parseObject(petPo, PetNewPO.class));
        }
        this.illusionManager = new IllusionManagerProxy(this, (IllusionPO) JSON.parseObject(illusionPO, IllusionPO.class));
        this.vipManager = new VipManagerProxy(this, (VipPO) JSON.parseObject(vipPO, VipPO.class));
        if (StringUtil.isNotEmpty(xianYuan)) {
            this.xianYuan = (XianYuanPO) Utils.deserialize(xianYuan, XianYuanPO.class);
        }

        Out.info(new Object[]{"set proxy data."});
    }


    public WNBag getWnBag() {
        return this.bag;
    }

    public boolean isRemote() {
        return true;
    }

    public boolean isProxy() {
        return true;
    }

    public boolean isRobot() {
        return this.robot;
    }

    public void changeArea(final AreaData areaData) {
        Out.debug(new Object[]{"proxy change area : ", areaData});
        ProxyClient.getInstance().add(new Message() {
            protected void write() throws IOException {
                this.body.writeString(WNProxy.this.playerId);
                this.body.writeInt(areaData.areaId);
                this.body.writeString(areaData.instanceId);
            }


            public short getType() {
                return 1266;
            }
        });
    }


    public String getId() {
        return this.playerId;
    }

    public int getSid() {
        return this.sid;
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    public int getPro() {
        return this.pro;
    }


    public void sync() {
        Out.info(new Object[]{"proxy sync................"});
    }


    public boolean onMessage(int operate, MessageData message) {
        Out.info(new Object[]{"proxy onMessage................", Integer.valueOf(message.messageType)});
        return false;
    }


    public void update() {
        Out.warn(new Object[]{"proxy update................"});
    }

    public void free() {
        free(false);
    }

    public void free(boolean keepObject) {
        Out.info(new Object[]{"free proxy >> ", getName(), " - ", Boolean.valueOf(keepObject)});
        if (!keepObject) {
            GWorld.Proxys.remove(this.playerId);
        }
        Area area = getArea();
        if (area != null) {
            area.removePlayer(this, keepObject);
        }
    }


    public void receive(Message msg) {
        processMessage(msg);
    }


    public void write(Message msg) {
        processMessage(msg);
    }


    public void receive(String route, GeneratedMessage msg) {
        processMessage((Message) new MessagePush(route, msg));
    }

    private void processMessage(final Message msg) {
        ProxyClient.getInstance().add(new Message() {
            protected void write() throws IOException {
                this.body.writeString(WNProxy.this.playerId);
                this.body.writeBuffer(msg.getContent());
            }


            public short getType() {
                return 1267;
            }
        });
    }


    public void onEvent(TaskEvent event) {
        onProxyEvent(1, body -> {
            body.writeInt(event.type);
            body.writeString(Utils.serialize(event.params));
        });
    }

    public PetNew getFightingPet() {
        return this.pet;
    }

    public void finishFightLevel(int currHard, int templateID) {
        onProxyEvent(7, body -> {
            body.writeInt(currHard);
            body.writeInt(templateID);
        });
    }

    public void onProxyEvent(final int type, final ProxyEventCB cb) {
        ProxyClient.getInstance().add(new Message() {
            protected void write() throws IOException {
                this.body.writeString(WNProxy.this.getId());
                this.body.writeByte(type);
                cb.put(this.body);
            }


            public short getType() {
                return 1026;
            }
        });
    }

    public int getGuildExdExp() {
        return this.guildExdExp;
    }

    public int getGuildExdGold() {
        return this.guildExdGold;
    }

    public int getBtlExdGold() {
        return this.btlExdGold;
    }


    public int processXianYuanGet(int from) {
        return 0;
    }
}


