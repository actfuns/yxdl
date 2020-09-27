package Xmds;

import Ice.Object;
import Ice.ObjectHolderBase;
import IceInternal.Ex;


public final class SkillDataICEHolder
        extends ObjectHolderBase<SkillDataICE> {
    public SkillDataICEHolder() {
    }

    public SkillDataICEHolder(SkillDataICE value) {
        this.value = (Object) value;
    }


    public void patch(Object v) {
        if (v == null || v instanceof SkillDataICE) {

            this.value = v;
        } else {

            Ex.throwUOE(type(), v);
        }
    }


    public String type() {
        return SkillDataICE.ice_staticId();
    }
}


