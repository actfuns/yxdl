package Xmds;

import Ice.Object;
import Ice.ObjectHolderBase;
import IceInternal.Ex;


public final class RefreshPlayerPropertyChangeHolder
        extends ObjectHolderBase<RefreshPlayerPropertyChange> {
    public RefreshPlayerPropertyChangeHolder() {
    }

    public RefreshPlayerPropertyChangeHolder(RefreshPlayerPropertyChange value) {
        this.value = (Object) value;
    }


    public void patch(Object v) {
        if (v == null || v instanceof RefreshPlayerPropertyChange) {

            this.value = v;
        } else {

            Ex.throwUOE(type(), v);
        }
    }


    public String type() {
        return RefreshPlayerPropertyChange.ice_staticId();
    }
}


