package Xmds;

import Ice.Object;
import Ice.ObjectHolderBase;
import IceInternal.Ex;


public final class PlayerPKInfoDataHolder
        extends ObjectHolderBase<PlayerPKInfoData> {
    public PlayerPKInfoDataHolder() {
    }

    public PlayerPKInfoDataHolder(PlayerPKInfoData value) {
        this.value = (Object) value;
    }


    public void patch(Object v) {
        if (v == null || v instanceof PlayerPKInfoData) {

            this.value = v;
        } else {

            Ex.throwUOE(type(), v);
        }
    }


    public String type() {
        return PlayerPKInfoData.ice_staticId();
    }
}


