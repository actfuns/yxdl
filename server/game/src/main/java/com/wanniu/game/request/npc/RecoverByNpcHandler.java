package com.wanniu.game.request.npc;

import Xmds.CanTalkWithNpc;
import Xmds.RefreshPlayerPropertyChange;
import com.alibaba.fastjson.JSON;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.Const;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.NpcHandler;


@GClientEvent("area.npcHandler.recoverByNpcRequest")
public class RecoverByNpcHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        NpcHandler.RecoverByNpcRequest msg = NpcHandler.RecoverByNpcRequest.parseFrom(this.pak.getRemaingBytes());
        GWorld.getInstance().ansycExec(() -> {
            int npcObjId = Integer.parseInt(msg.getNpcObjId());

            String res_str = player.getXmdsManager().canTalkWithNpc(player.getId(), npcObjId);

            CanTalkWithNpc npcResult = null;
            if (StringUtil.isNotEmpty(res_str)) {
                npcResult = (CanTalkWithNpc) JSON.parseObject(res_str, CanTalkWithNpc.class);
                Out.debug(new Object[]{"npcResult:", npcResult});
                if (npcResult.canTalk) {
                    RefreshPlayerPropertyChange refreshChange = new RefreshPlayerPropertyChange();
                    refreshChange.changeType = Const.PropertyChangeType.NPC.value;
                    refreshChange.valueType = 0;
                    refreshChange.value = 0;
                    refreshChange.duration = 0;
                    refreshChange.timestamp = 0L;
                    player.refreshPlayerPropertyChange(refreshChange);
                }
            }
        });
        return new PomeloResponse() {
            protected void write() throws IOException {
                NpcHandler.RecoverByNpcResponse.Builder res = NpcHandler.RecoverByNpcResponse.newBuilder();
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


