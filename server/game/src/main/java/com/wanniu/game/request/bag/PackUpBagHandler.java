package com.wanniu.game.request.bag;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.bag.BagUtil;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.ItemIdConfigExt;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import pomelo.area.BagHandler;


@GClientEvent("area.bagHandler.packUpBagRequest")
public class PackUpBagHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        BagHandler.PackUpBagRequest req = BagHandler.PackUpBagRequest.parseFrom(this.pak.getRemaingBytes());
        final int _type = req.getC2SType();
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        return new PomeloResponse() {
            protected void write() throws IOException {
                BagHandler.PackUpBagResponse.Builder res = BagHandler.PackUpBagResponse.newBuilder();


                WNBag store = BagUtil.getStoreByType(player, _type);
                if (store == null) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                if (!store.canPackUp()) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("BAG_PACKUP_CDTIME"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                PackUpBagHandler.this.packUpBag(store);

                res.setS2CCode(200);
                res.setS2CType(_type);
                res.addAllS2CBagGrids(store.getGrids4PayLoad());
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }

    public void packUpBag(WNBag bag) {
        bag.bagGridPackUpTime = System.currentTimeMillis();


        List<NormalItem> data = bag._packUpStackNum();
        Collections.sort(data, new Comparator<NormalItem>() {
            public int compare(NormalItem left, NormalItem right) {
                if (left.prop == null) {
                    Out.error(new Object[]{"Item compare prop error, code:", left.itemDb.code, ", left.prop:", left.prop});
                }


                int flag = 0;

                ItemIdConfigExt itemidconfig_l = (ItemIdConfigExt) GameData.ItemIdConfigs.get(left.prop.type);
                ItemIdConfigExt itemidconfig_r = (ItemIdConfigExt) GameData.ItemIdConfigs.get(right.prop.type);
                if (itemidconfig_l.order == itemidconfig_r.order) {
                    if (left.prop.qcolor == right.prop.qcolor) {
                        if (left.itemDb.gotTime.getTime() == right.itemDb.gotTime.getTime()) {
                            flag = 0;
                        } else if (left.itemDb.gotTime.getTime() < right.itemDb.gotTime.getTime()) {
                            flag = -1;
                        } else {
                            flag = 1;
                        }
                    } else if (left.prop.qcolor < right.prop.qcolor) {
                        flag = 1;
                    } else {
                        flag = -1;
                    }
                } else if (itemidconfig_l.order < itemidconfig_r.order) {
                    flag = -1;
                } else {
                    flag = 1;
                }


                return flag;
            }
        });


        bag.bagGrids.clear();
        for (int i = 0; i < data.size(); i++) {
            bag.bagGrids.put(Integer.valueOf(i + 1), data.get(i));
        }


        bag.usedGridCount = data.size();
        bag._gridNumChangePush(true);
    }
}


