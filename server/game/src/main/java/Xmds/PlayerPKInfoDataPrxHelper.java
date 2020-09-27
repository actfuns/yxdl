package Xmds;

import Ice.ObjectPrx;
import Ice.ObjectPrxHelperBase;
import IceInternal.BasicStream;

import java.util.Map;


public final class PlayerPKInfoDataPrxHelper
        extends ObjectPrxHelperBase
        implements PlayerPKInfoDataPrx {
    public static PlayerPKInfoDataPrx checkedCast(ObjectPrx __obj) {
        return (PlayerPKInfoDataPrx) checkedCastImpl(__obj, ice_staticId(), PlayerPKInfoDataPrx.class, PlayerPKInfoDataPrxHelper.class);
    }


    public static PlayerPKInfoDataPrx checkedCast(ObjectPrx __obj, Map<String, String> __ctx) {
        return (PlayerPKInfoDataPrx) checkedCastImpl(__obj, __ctx, ice_staticId(), PlayerPKInfoDataPrx.class, PlayerPKInfoDataPrxHelper.class);
    }


    public static PlayerPKInfoDataPrx checkedCast(ObjectPrx __obj, String __facet) {
        return (PlayerPKInfoDataPrx) checkedCastImpl(__obj, __facet, ice_staticId(), PlayerPKInfoDataPrx.class, PlayerPKInfoDataPrxHelper.class);
    }


    public static PlayerPKInfoDataPrx checkedCast(ObjectPrx __obj, String __facet, Map<String, String> __ctx) {
        return (PlayerPKInfoDataPrx) checkedCastImpl(__obj, __facet, __ctx, ice_staticId(), PlayerPKInfoDataPrx.class, PlayerPKInfoDataPrxHelper.class);
    }


    public static PlayerPKInfoDataPrx uncheckedCast(ObjectPrx __obj) {
        return (PlayerPKInfoDataPrx) uncheckedCastImpl(__obj, PlayerPKInfoDataPrx.class, PlayerPKInfoDataPrxHelper.class);
    }


    public static PlayerPKInfoDataPrx uncheckedCast(ObjectPrx __obj, String __facet) {
        return (PlayerPKInfoDataPrx) uncheckedCastImpl(__obj, __facet, PlayerPKInfoDataPrx.class, PlayerPKInfoDataPrxHelper.class);
    }

    public static final String[] __ids = new String[]{"::Ice::Object", "::Xmds::PlayerPKInfoData"};


    public static final long serialVersionUID = 0L;


    public static String ice_staticId() {
        return __ids[1];
    }


    public static void __write(BasicStream __os, PlayerPKInfoDataPrx v) {
        __os.writeProxy(v);
    }


    public static PlayerPKInfoDataPrx __read(BasicStream __is) {
        ObjectPrx proxy = __is.readProxy();
        if (proxy != null) {

            PlayerPKInfoDataPrxHelper result = new PlayerPKInfoDataPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}


