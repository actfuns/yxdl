package com.wanniu.game.request.consignment;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.Const;
import com.wanniu.game.consignmentShop.ConsignmentLineService;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.ConsignmentLineHandler;


@GClientEvent("area.consignmentLineHandler.consignmentListRequest")
public class ConsignmentListHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        ConsignmentLineHandler.ConsignmentListRequest msg = ConsignmentLineHandler.ConsignmentListRequest.parseFrom(this.pak.getRemaingBytes());
        int pro = msg.getC2SPro();
        int qColor = msg.getC2SQcolor();
        int order = msg.getC2SOrder();
        int itemSecondType = msg.getC2SItemSecondType();
        int page = msg.getC2SPage();
        String itemType = msg.getC2SItemType();
        int level = msg.getC2SLevel();

        ConsignmentLineService.ConsignmentQueryParam opts = new ConsignmentLineService.ConsignmentQueryParam();
        opts.pro = pro;
        opts.qColor = qColor;
        opts.order = order;
        opts.itemSecondType = itemSecondType;
        opts.page = page;
        opts.itemType = itemType;
        opts.level = level;

        final ConsignmentLineHandler.ConsignmentListResponse.Builder result = ConsignmentLineService.getInstance().query(player, GWorld.__SERVER_ID, opts);
        result.setS2CCode(200);

        player.getPlayerTasks().dealTaskEvent(Const.TaskType.OPEN_SONSIGMENT, 1);

        return new PomeloResponse() {
            protected void write() throws IOException {
                this.body.writeBytes(result.build().toByteArray());
            }
        };
    }
}


