package Xmds;

import Ice.Object;
import IceInternal.BasicStream;
import IceInternal.Patcher;
import IceInternal.SequencePatcher;


public final class SkillDataSeqHelper {
    public static void write(BasicStream __os, SkillDataICE[] __v) {
        if (__v == null) {

            __os.writeSize(0);
        } else {

            __os.writeSize(__v.length);
            for (int __i0 = 0; __i0 < __v.length; __i0++) {
                __os.writeObject((Object) __v[__i0]);
            }
        }
    }


    public static SkillDataICE[] read(BasicStream __is) {
        int __len0 = __is.readAndCheckSeqSize(1);
        String __type0 = SkillDataICE.ice_staticId();
        SkillDataICE[] __v = new SkillDataICE[__len0];
        for (int __i0 = 0; __i0 < __len0; __i0++) {
            __is.readObject((Patcher) new SequencePatcher((Object[]) __v, SkillDataICE.class, __type0, __i0));
        }
        return __v;
    }
}


