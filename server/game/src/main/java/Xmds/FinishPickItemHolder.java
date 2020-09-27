package Xmds;

import Ice.Object;
import Ice.ObjectHolderBase;
import IceInternal.Ex;


public final class FinishPickItemHolder
        extends ObjectHolderBase<FinishPickItem> {
    public FinishPickItemHolder() {
    }

    public FinishPickItemHolder(FinishPickItem value) {
        this.value = (Object) value;
    }


    public void patch(Object v) {
        if (v == null || v instanceof FinishPickItem) {

            this.value = v;
        } else {

            Ex.throwUOE(type(), v);
        }
    }


    public String type() {
        return FinishPickItem.ice_staticId();
    }
}


