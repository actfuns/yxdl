package Xmds;

import Ice.Object;
import Ice.ObjectHolderBase;
import IceInternal.Ex;


public final class XmdsManagerHolder
        extends ObjectHolderBase<XmdsManager> {
    public XmdsManagerHolder() {
    }

    public XmdsManagerHolder(XmdsManager value) {
        this.value = value;
    }


    public void patch(Object v) {
        if (v == null || v instanceof XmdsManager) {

            this.value = v;
        } else {

            Ex.throwUOE(type(), v);
        }
    }


    public String type() {
        return _XmdsManagerDisp.ice_staticId();
    }
}


