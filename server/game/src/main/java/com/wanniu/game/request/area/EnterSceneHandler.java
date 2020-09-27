package com.wanniu.game.request.area;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.area.Area;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import pomelo.area.PlayerHandler;


@GClientEvent("area.playerHandler.enterSceneRequest")
public class EnterSceneHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        PlayerHandler.EnterSceneRequest rquest = PlayerHandler.EnterSceneRequest.parseFrom(this.pak.getRemaingBytes());
        String instanceId = rquest.getC2SInstanceId();

        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        Area area = player.getArea();


        if (StringUtils.isNotEmpty(instanceId) && !area.instanceId.equals(instanceId)) {
            if (StringUtils.isNotEmpty(instanceId)) {
                Out.warn(new Object[]{"连续切图吗？playerId=", player.getId(), ",name=", player.getName(), ",area.instanceId=", area.instanceId, ",C2SInstanceId=", instanceId});
            }
            return (PomeloResponse) new ErrorResponse("");
        }

        area.playerEnterRequest(player);

        area.onPlayerEntered(player);

        player.onEndEnterScene();


        return new PomeloResponse() {
            protected void write() throws IOException {
                PlayerHandler.EnterSceneResponse.Builder res = PlayerHandler.EnterSceneResponse.newBuilder();
                res.setS2CCode(200);
                res.setS2CInstanceId(player.getInstanceId());
                res.setS2CAreaIndex(player.getLineIndex());
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }

    public short getType() {
        return 1282;
    }
}


