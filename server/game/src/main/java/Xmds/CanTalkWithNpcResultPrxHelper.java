package Xmds;

import Ice.ObjectPrx;
import Ice.ObjectPrxHelperBase;
import IceInternal.BasicStream;

import java.util.Map;


public final class CanTalkWithNpcResultPrxHelper
        extends ObjectPrxHelperBase
        implements CanTalkWithNpcResultPrx {
    public static CanTalkWithNpcResultPrx checkedCast(ObjectPrx __obj) {
        return (CanTalkWithNpcResultPrx) checkedCastImpl(__obj, ice_staticId(), CanTalkWithNpcResultPrx.class, CanTalkWithNpcResultPrxHelper.class);
    }


    public static CanTalkWithNpcResultPrx checkedCast(ObjectPrx __obj, Map<String, String> __ctx) {
        return (CanTalkWithNpcResultPrx) checkedCastImpl(__obj, __ctx, ice_staticId(), CanTalkWithNpcResultPrx.class, CanTalkWithNpcResultPrxHelper.class);
    }


    public static CanTalkWithNpcResultPrx checkedCast(ObjectPrx __obj, String __facet) {
        return (CanTalkWithNpcResultPrx) checkedCastImpl(__obj, __facet, ice_staticId(), CanTalkWithNpcResultPrx.class, CanTalkWithNpcResultPrxHelper.class);
    }


    public static CanTalkWithNpcResultPrx checkedCast(ObjectPrx __obj, String __facet, Map<String, String> __ctx) {
        return (CanTalkWithNpcResultPrx) checkedCastImpl(__obj, __facet, __ctx, ice_staticId(), CanTalkWithNpcResultPrx.class, CanTalkWithNpcResultPrxHelper.class);
    }


    public static CanTalkWithNpcResultPrx uncheckedCast(ObjectPrx __obj) {
        return (CanTalkWithNpcResultPrx) uncheckedCastImpl(__obj, CanTalkWithNpcResultPrx.class, CanTalkWithNpcResultPrxHelper.class);
    }


    public static CanTalkWithNpcResultPrx uncheckedCast(ObjectPrx __obj, String __facet) {
        return (CanTalkWithNpcResultPrx) uncheckedCastImpl(__obj, __facet, CanTalkWithNpcResultPrx.class, CanTalkWithNpcResultPrxHelper.class);
    }

    public static final String[] __ids = new String[]{"::Ice::Object", "::Xmds::CanTalkWithNpcResult"};


    public static final long serialVersionUID = 0L;


    public static String ice_staticId() {
        return __ids[1];
    }


    public static void __write(BasicStream __os, CanTalkWithNpcResultPrx v) {
        __os.writeProxy(v);
    }


    public static CanTalkWithNpcResultPrx __read(BasicStream __is) {
        ObjectPrx proxy = __is.readProxy();
        if (proxy != null) {

            CanTalkWithNpcResultPrxHelper result = new CanTalkWithNpcResultPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}


