package com.wanniu.csharp.ice;

import Ice.Communicator;
import Ice.ObjectPrx;
import Ice.Util;
import Xmds.XmdsManagerPrx;
import Xmds.XmdsManagerPrxHelper;
import com.wanniu.core.logfs.Out;
import com.wanniu.csharp.CSharpNode;

public class XmdsManager {
    private CSharpNode node;

    public XmdsManager(CSharpNode node) {
        this.node = node;
    }

    private XmdsManagerPrx xmdsManager;
    private Communicator ic;

    public XmdsManager bind() {
        try {
            this.ic = Util.initialize(new String[0]);
            ObjectPrx proxy = this.ic.stringToProxy(String.format("XmdsManager:default -h %s -p %d -t 3000", new Object[]{this.node.host, Integer.valueOf(this.node.icePort)}));
            this.xmdsManager = XmdsManagerPrxHelper.checkedCast(proxy);
        } catch (Exception e) {
            Out.error(new Object[]{"XmdsManager bind() exception.", e});
        }
        return this;
    }

    public XmdsManagerPrx getManager() {
        return this.xmdsManager;
    }

    public void destory() {
        try {
            if (this.ic != null) {
                this.ic.destroy();
            }
        } catch (Exception e) {
            Out.error(new Object[]{"XmdsManager destory() exception.", e});
        }
    }
}


