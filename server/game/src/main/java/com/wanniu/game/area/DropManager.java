package com.wanniu.game.area;

import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.base.MonsterBase;
import com.wanniu.game.data.ext.MonsterRefreshExt;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.game.monster.MonsterConfig;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.MonsterDropPO;
import com.wanniu.redis.PlayerPOManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pomelo.area.ItemHandler;
import pomelo.item.ItemOuterClass;


public class DropManager {
    public WNPlayer player;
    private MonsterDropPO po;

    public DropManager(WNPlayer player, MonsterDropPO po) {
        this.player = player;
        if (po == null) {
            po = new MonsterDropPO();
        }
        this.po = po;
        PlayerPOManager.put(ConstsTR.monster_drop_infoTR, player.getId(), (GEntity) po);
    }


    public boolean canDrop(int bossId, Area area) {
        if (bossId == 0 || area.sceneType == Const.SCENE_TYPE.FIGHT_LEVEL.getValue()) {
            return true;
        }

        MonsterBase prop = MonsterConfig.getInstance().get(bossId);
        if (prop == null || prop.type < 4) {
            return true;
        }
        List<MonsterRefreshExt> refreshProps = GameData.findMonsterRefreshs(t ->
                (t.monsterID == bossId && t.mapID == area.areaId));

        if (refreshProps == null || refreshProps.isEmpty()) {
            return true;
        }
        MonsterRefreshExt ext = refreshProps.get(0);
        if (ext.useType == 1) {
            int count = this.po.getTodayCount();
            return (count < GlobalConfig.Lords_MaxNumEveryday);
        }
        return true;
    }

    public void sendJoinReward(int bossId, String bossName, List<MonsterRefreshExt> refreshProps) {
        if (refreshProps == null || refreshProps.isEmpty()) {
            return;
        }
        MonsterRefreshExt ext = refreshProps.get(0);
        sendJoinRward(bossName, ext.joinReward);
    }

    private void sendJoinRward(String name, Map<String, Integer> rankRewards) {
        if (rankRewards == null) {
            return;
        }
        List<ItemOuterClass.MiniItem> miniItem = new ArrayList<>();
        for (Map.Entry<String, Integer> attach : rankRewards.entrySet()) {
            miniItem.add(ItemUtil.getMiniItemData(attach.getKey(), ((Integer) attach.getValue()).intValue(), Const.ForceType.BIND).build());
        }

        if (!miniItem.isEmpty()) {
            ItemHandler.RewardItemPush.Builder data = ItemHandler.RewardItemPush.newBuilder();
            data.setS2CCode(200);
            data.addAllS2CItem(miniItem);
            this.player.receive("area.itemPush.rewardItemPush", (GeneratedMessage) data.build());


            MailSysData mailData = new MailSysData("Lords_Reward_ForPartake");
            Map<String, String> replace = new HashMap<>();
            replace.put("name", name);
            mailData.replace = replace;
            mailData.attachments = new ArrayList();
            for (Map.Entry<String, Integer> attach : rankRewards.entrySet()) {
                MailData.Attachment item = new MailData.Attachment();
                item.itemCode = attach.getKey();
                item.itemNum = ((Integer) attach.getValue()).intValue();
                mailData.attachments.add(item);
            }
            MailUtil.getInstance().sendMailToOnePlayer(this.player.getId(), (MailData) mailData, Const.GOODS_CHANGE_TYPE.BOSS_ASSISTS);
        }
    }


    public void onBossDead(int bossId) {
        if (bossId == 0) {
            return;
        }
        MonsterBase prop = MonsterConfig.getInstance().get(bossId);
        if (prop == null || prop.type < 4) {
            return;
        }
        this.po.addBossCount();
    }

    public void refreshNewDay() {
        if (this.po != null)
            this.po.clear();
    }
}


