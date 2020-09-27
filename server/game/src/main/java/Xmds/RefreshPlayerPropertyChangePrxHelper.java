package Xmds;

import Ice.ObjectPrx;
import Ice.ObjectPrxHelperBase;
import IceInternal.BasicStream;

import java.util.Map;


public final class RefreshPlayerPropertyChangePrxHelper
        extends ObjectPrxHelperBase
        implements RefreshPlayerPropertyChangePrx {
    public static RefreshPlayerPropertyChangePrx checkedCast(ObjectPrx __obj) {
        return (RefreshPlayerPropertyChangePrx) checkedCastImpl(__obj, ice_staticId(), RefreshPlayerPropertyChangePrx.class, RefreshPlayerPropertyChangePrxHelper.class);
    }


    public static RefreshPlayerPropertyChangePrx checkedCast(ObjectPrx __obj, Map<String, String> __ctx) {
        return (RefreshPlayerPropertyChangePrx) checkedCastImpl(__obj, __ctx, ice_staticId(), RefreshPlayerPropertyChangePrx.class, RefreshPlayerPropertyChangePrxHelper.class);
    }


    public static RefreshPlayerPropertyChangePrx checkedCast(ObjectPrx __obj, String __facet) {
        return (RefreshPlayerPropertyChangePrx) checkedCastImpl(__obj, __facet, ice_staticId(), RefreshPlayerPropertyChangePrx.class, RefreshPlayerPropertyChangePrxHelper.class);
    }


    public static RefreshPlayerPropertyChangePrx checkedCast(ObjectPrx __obj, String __facet, Map<String, String> __ctx) {
        return (RefreshPlayerPropertyChangePrx) checkedCastImpl(__obj, __facet, __ctx, ice_staticId(), RefreshPlayerPropertyChangePrx.class, RefreshPlayerPropertyChangePrxHelper.class);
    }


    public static RefreshPlayerPropertyChangePrx uncheckedCast(ObjectPrx __obj) {
        return (RefreshPlayerPropertyChangePrx) uncheckedCastImpl(__obj, RefreshPlayerPropertyChangePrx.class, RefreshPlayerPropertyChangePrxHelper.class);
    }


    public static RefreshPlayerPropertyChangePrx uncheckedCast(ObjectPrx __obj, String __facet) {
        return (RefreshPlayerPropertyChangePrx) uncheckedCastImpl(__obj, __facet, RefreshPlayerPropertyChangePrx.class, RefreshPlayerPropertyChangePrxHelper.class);
    }

    public static final String[] __ids = new String[]{"::Ice::Object", "::Xmds::RefreshPlayerPropertyChange"};


    public static final long serialVersionUID = 0L;


    public static String ice_staticId() {
        return __ids[1];
    }


    public static void __write(BasicStream __os, RefreshPlayerPropertyChangePrx v) {
        __os.writeProxy(v);
    }


    public static RefreshPlayerPropertyChangePrx __read(BasicStream __is) {
        ObjectPrx proxy = __is.readProxy();
        if (proxy != null) {

            RefreshPlayerPropertyChangePrxHelper result = new RefreshPlayerPropertyChangePrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}


