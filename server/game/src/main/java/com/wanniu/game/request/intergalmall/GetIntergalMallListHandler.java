package com.wanniu.game.request.intergalmall;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.List;

import pomelo.area.IntergalMallHandler;


@GClientEvent("area.intergalMallHandler.getMallScoreItemListRequest")
public class GetIntergalMallListHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        GPlayer player = this.pak.getPlayer();
        final WNPlayer wPlayer = (WNPlayer) player;

        IntergalMallHandler.GetIntergalMallListRequest req = IntergalMallHandler.GetIntergalMallListRequest.parseFrom(this.pak.getRemaingBytes());

        final int shopType = req.getC2SType();

        return new PomeloResponse() {
            protected void write() throws IOException {
                IntergalMallHandler.GetIntergalMallListResponse.Builder res = IntergalMallHandler.GetIntergalMallListResponse.newBuilder();

                List<IntergalMallHandler.IntergalMallTab> tabItems = wPlayer.getIntergalMallManager().getIntergalMallItemList(shopType);
                res.setS2CCode(200);
                res.addAllS2CTabitems(tabItems);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


