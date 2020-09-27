package com.wanniu.csharp.ice;

import Ice.Communicator;
import Ice.Current;
import Ice.Object;
import Ice.ObjectAdapter;
import Ice.ObjectPrx;
import Ice.Util;


import com.wanniu.core.GGame;
import com.wanniu.core.logfs.Out;
import com.wanniu.csharp.CSharpNode;

public class ZoneManager {
    private CSharpNode node;

    public ZoneManager(CSharpNode node) {
        this.node = node;
    }

    private ZoneManagerPrx zoneManager;
    private Communicator ic;

    public ZoneManager bind() {
        try {
            this.ic = Util.initialize(new String[0]);
            ObjectPrx proxy = this.ic.stringToProxy(String.format("zoneManager:default -h %s -p %d -t 3000", new Object[]{this.node.host, Integer.valueOf(this.node.icePort)})).ice_twoway().ice_secure(false);
            this.zoneManager = ZoneManagerPrxHelper.checkedCast(proxy);
            if (this.zoneManager == null) {
                throw new Error("Invalid proxy");
            }
            ObjectAdapter adapter = this.ic.createObjectAdapter("");
            ObjectPrx prx = adapter.add((Object) new _ZoneManagerCallbackDisp() {
                private static final long serialVersionUID = 0L;

                public void eventNotify(String eventType, String msg, Current __current) {
                    try {
                        GGame.getInstance().battleServerEvent(eventType, msg);
                    } catch (Exception e) {
                        Out.error(new Object[]{e});
                    }
                }
            }Util.stringToIdentity(this.node.getNodeId()));
            proxy.ice_getCachedConnection().setAdapter(adapter);
            this.zoneManager.setCallback(prx.ice_getIdentity());
        } catch (Exception e) {
            Out.error(new Object[]{"ZoneManager bind() exception.", e});
        }
        return this;
    }

    public ZoneManagerPrx getManager() {
        return this.zoneManager;
    }

    public void destory() {
        try {
            if (this.ic != null) {
                this.ic.destroy();
            }
        } catch (Exception e) {
            Out.error(new Object[]{"ZoneManager destory() exception.", e});
        }
    }
}


