package Xmds;

import Ice.ObjectPrx;
import Ice.ObjectPrxHelperBase;
import IceInternal.BasicStream;

import java.util.Map;


public final class SkillDataICEPrxHelper
        extends ObjectPrxHelperBase
        implements SkillDataICEPrx {
    public static SkillDataICEPrx checkedCast(ObjectPrx __obj) {
        return (SkillDataICEPrx) checkedCastImpl(__obj, ice_staticId(), SkillDataICEPrx.class, SkillDataICEPrxHelper.class);
    }


    public static SkillDataICEPrx checkedCast(ObjectPrx __obj, Map<String, String> __ctx) {
        return (SkillDataICEPrx) checkedCastImpl(__obj, __ctx, ice_staticId(), SkillDataICEPrx.class, SkillDataICEPrxHelper.class);
    }


    public static SkillDataICEPrx checkedCast(ObjectPrx __obj, String __facet) {
        return (SkillDataICEPrx) checkedCastImpl(__obj, __facet, ice_staticId(), SkillDataICEPrx.class, SkillDataICEPrxHelper.class);
    }


    public static SkillDataICEPrx checkedCast(ObjectPrx __obj, String __facet, Map<String, String> __ctx) {
        return (SkillDataICEPrx) checkedCastImpl(__obj, __facet, __ctx, ice_staticId(), SkillDataICEPrx.class, SkillDataICEPrxHelper.class);
    }


    public static SkillDataICEPrx uncheckedCast(ObjectPrx __obj) {
        return (SkillDataICEPrx) uncheckedCastImpl(__obj, SkillDataICEPrx.class, SkillDataICEPrxHelper.class);
    }


    public static SkillDataICEPrx uncheckedCast(ObjectPrx __obj, String __facet) {
        return (SkillDataICEPrx) uncheckedCastImpl(__obj, __facet, SkillDataICEPrx.class, SkillDataICEPrxHelper.class);
    }

    public static final String[] __ids = new String[]{"::Ice::Object", "::Xmds::SkillDataICE"};


    public static final long serialVersionUID = 0L;


    public static String ice_staticId() {
        return __ids[1];
    }


    public static void __write(BasicStream __os, SkillDataICEPrx v) {
        __os.writeProxy(v);
    }


    public static SkillDataICEPrx __read(BasicStream __is) {
        ObjectPrx proxy = __is.readProxy();
        if (proxy != null) {

            SkillDataICEPrxHelper result = new SkillDataICEPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}


