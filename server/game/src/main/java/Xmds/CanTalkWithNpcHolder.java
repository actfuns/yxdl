package Xmds;

import Ice.Object;
import Ice.ObjectHolderBase;
import IceInternal.Ex;


public final class CanTalkWithNpcHolder
        extends ObjectHolderBase<CanTalkWithNpc> {
    public CanTalkWithNpcHolder() {
    }

    public CanTalkWithNpcHolder(CanTalkWithNpc value) {
        this.value = (Object) value;
    }


    public void patch(Object v) {
        if (v == null || v instanceof CanTalkWithNpc) {

            this.value = v;
        } else {

            Ex.throwUOE(type(), v);
        }
    }


    public String type() {
        return CanTalkWithNpc.ice_staticId();
    }
}


