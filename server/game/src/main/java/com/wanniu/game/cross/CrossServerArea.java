package com.wanniu.game.cross;

import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.game.protocol.PomeloPush;
import com.wanniu.core.proxy.ProxyClient;
import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;


public class CrossServerArea
        extends CrossServerLocalArea {
    private boolean isLocal;

    public CrossServerArea(JSONObject opts) {
        super(opts);
        if (opts.containsKey("lineIndex")) {
            this.lineIndex = opts.getIntValue("lineIndex");
        }
        this.isLocal = !opts.containsKey("exists");
    }

    public void init() {
        super.init();
    }


    public void onPlayerEntered(final WNPlayer player) {
        super.onPlayerEntered(player);
        ProxyClient.getInstance().add(new Message() {
            protected void write() throws IOException {
                this.body.writeString(CrossServerArea.this.instanceId);
                this.body.writeString(player.getId());
            }


            public short getType() {
                return 258;
            }
        });
    }


    public void onPlayerLeaved(final WNPlayer player) {
        ProxyClient.getInstance().add(new Message() {
            protected void write() throws IOException {
                this.body.writeString(CrossServerArea.this.instanceId);
                this.body.writeString(player.getId());
            }


            public short getType() {
                return 259;
            }
        });
    }


    public void dispose() {
        if (this.isLocal) {
            super.dispose();
        }
    }


    public void receive(final PomeloPush push) {
        ProxyClient.getInstance().add(new Message() {
            protected void write() throws IOException {
                this.body.writeString(CrossServerArea.this.instanceId);
                this.body.writeBuffer(push.getContent());
            }


            public short getType() {
                return 497;
            }
        });
    }


    public void onUnitDead(JSONObject msg) {
        int unitType = msg.getIntValue("unitType");
        if (unitType == 1) {
            final String unitPlayerId = msg.getString("unitPlayerId");
            final String hitFinalPlayerId = msg.getString("hitFinal");

            WNPlayer deadPlayer = getPlayer(unitPlayerId);
            if (deadPlayer != null) {
                pushRelive(deadPlayer);
            } else {
                ProxyClient.getInstance().add(new Message() {
                    protected void write() throws IOException {
                        this.body.writeString(CrossServerArea.this.instanceId);
                        this.body.writeString(unitPlayerId);
                        this.body.writeString(hitFinalPlayerId);
                    }


                    public short getType() {
                        return 499;
                    }
                });
            }
        }
    }
}


