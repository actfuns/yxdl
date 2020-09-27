package Xmds;

import Ice.ObjectPrx;
import Ice.ObjectPrxHelperBase;
import IceInternal.BasicStream;

import java.util.Map;


public final class CanTalkWithNpcPrxHelper
        extends ObjectPrxHelperBase
        implements CanTalkWithNpcPrx {
    public static CanTalkWithNpcPrx checkedCast(ObjectPrx __obj) {
        return (CanTalkWithNpcPrx) checkedCastImpl(__obj, ice_staticId(), CanTalkWithNpcPrx.class, CanTalkWithNpcPrxHelper.class);
    }


    public static CanTalkWithNpcPrx checkedCast(ObjectPrx __obj, Map<String, String> __ctx) {
        return (CanTalkWithNpcPrx) checkedCastImpl(__obj, __ctx, ice_staticId(), CanTalkWithNpcPrx.class, CanTalkWithNpcPrxHelper.class);
    }


    public static CanTalkWithNpcPrx checkedCast(ObjectPrx __obj, String __facet) {
        return (CanTalkWithNpcPrx) checkedCastImpl(__obj, __facet, ice_staticId(), CanTalkWithNpcPrx.class, CanTalkWithNpcPrxHelper.class);
    }


    public static CanTalkWithNpcPrx checkedCast(ObjectPrx __obj, String __facet, Map<String, String> __ctx) {
        return (CanTalkWithNpcPrx) checkedCastImpl(__obj, __facet, __ctx, ice_staticId(), CanTalkWithNpcPrx.class, CanTalkWithNpcPrxHelper.class);
    }


    public static CanTalkWithNpcPrx uncheckedCast(ObjectPrx __obj) {
        return (CanTalkWithNpcPrx) uncheckedCastImpl(__obj, CanTalkWithNpcPrx.class, CanTalkWithNpcPrxHelper.class);
    }


    public static CanTalkWithNpcPrx uncheckedCast(ObjectPrx __obj, String __facet) {
        return (CanTalkWithNpcPrx) uncheckedCastImpl(__obj, __facet, CanTalkWithNpcPrx.class, CanTalkWithNpcPrxHelper.class);
    }

    public static final String[] __ids = new String[]{"::Ice::Object", "::Xmds::CanTalkWithNpc"};


    public static final long serialVersionUID = 0L;


    public static String ice_staticId() {
        return __ids[1];
    }


    public static void __write(BasicStream __os, CanTalkWithNpcPrx v) {
        __os.writeProxy(v);
    }


    public static CanTalkWithNpcPrx __read(BasicStream __is) {
        ObjectPrx proxy = __is.readProxy();
        if (proxy != null) {

            CanTalkWithNpcPrxHelper result = new CanTalkWithNpcPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}


