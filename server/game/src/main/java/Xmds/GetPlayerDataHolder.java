package Xmds;

import Ice.Object;
import Ice.ObjectHolderBase;
import IceInternal.Ex;


public final class GetPlayerDataHolder
        extends ObjectHolderBase<GetPlayerData> {
    public GetPlayerDataHolder() {
    }

    public GetPlayerDataHolder(GetPlayerData value) {
        this.value = (Object) value;
    }


    public void patch(Object v) {
        if (v == null || v instanceof GetPlayerData) {

            this.value = v;
        } else {

            Ex.throwUOE(type(), v);
        }
    }


    public String type() {
        return GetPlayerData.ice_staticId();
    }
}


