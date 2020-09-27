package com.wanniu.game.request.shopmall;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.List;

import pomelo.area.ShopMallHandler;


@GClientEvent("area.shopMallHandler.getMallTabsRequest")
public class GetMallTabsHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        GPlayer player = this.pak.getPlayer();
        final WNPlayer wPlayer = (WNPlayer) player;
        return new PomeloResponse() {
            protected void write() throws IOException {
                ShopMallHandler.GetMallTabsResponse.Builder res = ShopMallHandler.GetMallTabsResponse.newBuilder();
                List<ShopMallHandler.MallTab.Builder> items = wPlayer.shopMallManager.getMallTabs();
                res.setS2CCode(200);
                for (int i = 0; i < items.size(); i++) {
                    res.addS2CTabs(((ShopMallHandler.MallTab.Builder) items.get(i)).build());
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


