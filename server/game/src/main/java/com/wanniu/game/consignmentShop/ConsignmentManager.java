package com.wanniu.game.consignmentShop;

import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.msg.WNNotifyManager;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.ConsignmentItemsPO;
import com.wanniu.game.poes.PlayerConsignmentItemsPO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import pomelo.item.ItemOuterClass;

public class ConsignmentManager {
    private WNPlayer player;
    public PlayerConsignmentItemsPO po;

    public ConsignmentManager(WNPlayer player, PlayerConsignmentItemsPO po) {
        this.player = player;
        this.po = po;
    }

    public final boolean hasBuyFirstConsignItem() {
        return (this.po.buyFirstConsignItem == 1);
    }

    public final void signBuyFirstConsignItem() {
        this.po.buyFirstConsignItem = 1;
    }

    public void afterPlayerChangeName() {
        List<ConsignmentItemsPO> list_consignment = ConsignmentLineService.getInstance().findByPlayerId(this.player.getId());
        if (list_consignment != null && !list_consignment.isEmpty()) {
            for (ConsignmentItemsPO po : list_consignment) {
                po.consignmentPlayerName = this.player.player.name;
            }
        }
    }


    public final boolean remove(String id, boolean isPush) {
        if (ConsignmentLineService.getInstance().remove(id)) {
            if (isPush) {
                WNNotifyManager.getInstance().consignmentRemovePush(this.player, id);
            }
            return true;
        }
        Out.error(new Object[]{"consignment remove :", this.player.getId(), ":", id, " not exits"});
        return false;
    }

    public final List<ItemOuterClass.ConsignmentItem> getAll() {
        List<ItemOuterClass.ConsignmentItem> data = new ArrayList<>();
        List<ConsignmentItemsPO> list_consignment = ConsignmentLineService.getInstance().findByPlayerId(this.player.getId());
        Collections.sort(list_consignment, new Comparator<ConsignmentItemsPO>() {
            public int compare(ConsignmentItemsPO o1, ConsignmentItemsPO o2) {
                return (int) (o2.consignmentTime - o1.consignmentTime);
            }
        });

        for (ConsignmentItemsPO item : list_consignment) {
            data.add(ConsignmentUtil.buildConsignmentItem(this.player, item));
        }
        return data;
    }

    public void refreshNewDay() {
    }
}


