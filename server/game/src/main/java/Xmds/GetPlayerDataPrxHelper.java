package Xmds;

import Ice.ObjectPrx;
import Ice.ObjectPrxHelperBase;
import IceInternal.BasicStream;

import java.util.Map;


public final class GetPlayerDataPrxHelper
        extends ObjectPrxHelperBase
        implements GetPlayerDataPrx {
    public static GetPlayerDataPrx checkedCast(ObjectPrx __obj) {
        return (GetPlayerDataPrx) checkedCastImpl(__obj, ice_staticId(), GetPlayerDataPrx.class, GetPlayerDataPrxHelper.class);
    }


    public static GetPlayerDataPrx checkedCast(ObjectPrx __obj, Map<String, String> __ctx) {
        return (GetPlayerDataPrx) checkedCastImpl(__obj, __ctx, ice_staticId(), GetPlayerDataPrx.class, GetPlayerDataPrxHelper.class);
    }


    public static GetPlayerDataPrx checkedCast(ObjectPrx __obj, String __facet) {
        return (GetPlayerDataPrx) checkedCastImpl(__obj, __facet, ice_staticId(), GetPlayerDataPrx.class, GetPlayerDataPrxHelper.class);
    }


    public static GetPlayerDataPrx checkedCast(ObjectPrx __obj, String __facet, Map<String, String> __ctx) {
        return (GetPlayerDataPrx) checkedCastImpl(__obj, __facet, __ctx, ice_staticId(), GetPlayerDataPrx.class, GetPlayerDataPrxHelper.class);
    }


    public static GetPlayerDataPrx uncheckedCast(ObjectPrx __obj) {
        return (GetPlayerDataPrx) uncheckedCastImpl(__obj, GetPlayerDataPrx.class, GetPlayerDataPrxHelper.class);
    }


    public static GetPlayerDataPrx uncheckedCast(ObjectPrx __obj, String __facet) {
        return (GetPlayerDataPrx) uncheckedCastImpl(__obj, __facet, GetPlayerDataPrx.class, GetPlayerDataPrxHelper.class);
    }

    public static final String[] __ids = new String[]{"::Ice::Object", "::Xmds::GetPlayerData"};


    public static final long serialVersionUID = 0L;


    public static String ice_staticId() {
        return __ids[1];
    }


    public static void __write(BasicStream __os, GetPlayerDataPrx v) {
        __os.writeProxy(v);
    }


    public static GetPlayerDataPrx __read(BasicStream __is) {
        ObjectPrx proxy = __is.readProxy();
        if (proxy != null) {

            GetPlayerDataPrxHelper result = new GetPlayerDataPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}


