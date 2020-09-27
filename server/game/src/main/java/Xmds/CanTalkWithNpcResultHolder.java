package Xmds;

import Ice.Object;
import Ice.ObjectHolderBase;
import IceInternal.Ex;


public final class CanTalkWithNpcResultHolder
        extends ObjectHolderBase<CanTalkWithNpcResult> {
    public CanTalkWithNpcResultHolder() {
    }

    public CanTalkWithNpcResultHolder(CanTalkWithNpcResult value) {
        this.value = (Object) value;
    }


    public void patch(Object v) {
        if (v == null || v instanceof CanTalkWithNpcResult) {

            this.value = v;
        } else {

            Ex.throwUOE(type(), v);
        }
    }


    public String type() {
        return CanTalkWithNpcResult.ice_staticId();
    }
}


