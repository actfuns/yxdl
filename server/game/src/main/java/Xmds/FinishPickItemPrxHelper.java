package Xmds;

import Ice.ObjectPrx;
import Ice.ObjectPrxHelperBase;
import IceInternal.BasicStream;

import java.util.Map;


public final class FinishPickItemPrxHelper
        extends ObjectPrxHelperBase
        implements FinishPickItemPrx {
    public static FinishPickItemPrx checkedCast(ObjectPrx __obj) {
        return (FinishPickItemPrx) checkedCastImpl(__obj, ice_staticId(), FinishPickItemPrx.class, FinishPickItemPrxHelper.class);
    }


    public static FinishPickItemPrx checkedCast(ObjectPrx __obj, Map<String, String> __ctx) {
        return (FinishPickItemPrx) checkedCastImpl(__obj, __ctx, ice_staticId(), FinishPickItemPrx.class, FinishPickItemPrxHelper.class);
    }


    public static FinishPickItemPrx checkedCast(ObjectPrx __obj, String __facet) {
        return (FinishPickItemPrx) checkedCastImpl(__obj, __facet, ice_staticId(), FinishPickItemPrx.class, FinishPickItemPrxHelper.class);
    }


    public static FinishPickItemPrx checkedCast(ObjectPrx __obj, String __facet, Map<String, String> __ctx) {
        return (FinishPickItemPrx) checkedCastImpl(__obj, __facet, __ctx, ice_staticId(), FinishPickItemPrx.class, FinishPickItemPrxHelper.class);
    }


    public static FinishPickItemPrx uncheckedCast(ObjectPrx __obj) {
        return (FinishPickItemPrx) uncheckedCastImpl(__obj, FinishPickItemPrx.class, FinishPickItemPrxHelper.class);
    }


    public static FinishPickItemPrx uncheckedCast(ObjectPrx __obj, String __facet) {
        return (FinishPickItemPrx) uncheckedCastImpl(__obj, __facet, FinishPickItemPrx.class, FinishPickItemPrxHelper.class);
    }

    public static final String[] __ids = new String[]{"::Ice::Object", "::Xmds::FinishPickItem"};


    public static final long serialVersionUID = 0L;


    public static String ice_staticId() {
        return __ids[1];
    }


    public static void __write(BasicStream __os, FinishPickItemPrx v) {
        __os.writeProxy(v);
    }


    public static FinishPickItemPrx __read(BasicStream __is) {
        ObjectPrx proxy = __is.readProxy();
        if (proxy != null) {

            FinishPickItemPrxHelper result = new FinishPickItemPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}


