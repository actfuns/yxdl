package Xmds;

import Ice.Current;
import Ice.Object;
import Ice.ObjectFactory;
import Ice.ObjectImpl;
import IceInternal.BasicStream;

import java.util.Arrays;


public class SkillDataICE
        extends ObjectImpl {
    public SkillDataICE() {
    }

    public SkillDataICE(int skillId, long skillTime) {
        this.skillId = skillId;
        this.skillTime = skillTime;
    }

    private static class __F implements ObjectFactory {
        private __F() {
        }

        public Object create(String type) {
            assert type.equals(SkillDataICE.ice_staticId());
            return (Object) new SkillDataICE();
        }


        public void destroy() {
        }
    }

    private static ObjectFactory _factory = new __F();


    public static ObjectFactory ice_factory() {
        return _factory;
    }

    public static final String[] __ids = new String[]{"::Ice::Object", "::Xmds::SkillDataICE"};

    public int skillId;

    public long skillTime;
    public static final long serialVersionUID = 1243971557L;

    public boolean ice_isA(String s) {
        return (Arrays.binarySearch((Object[]) __ids, s) >= 0);
    }


    public boolean ice_isA(String s, Current __current) {
        return (Arrays.binarySearch((Object[]) __ids, s) >= 0);
    }


    public String[] ice_ids() {
        return __ids;
    }


    public String[] ice_ids(Current __current) {
        return __ids;
    }


    public String ice_id() {
        return __ids[1];
    }


    public String ice_id(Current __current) {
        return __ids[1];
    }


    public static String ice_staticId() {
        return __ids[1];
    }


    protected void __writeImpl(BasicStream __os) {
        __os.startWriteSlice(ice_staticId(), -1, true);
        __os.writeInt(this.skillId);
        __os.writeLong(this.skillTime);
        __os.endWriteSlice();
    }


    protected void __readImpl(BasicStream __is) {
        __is.startReadSlice();
        this.skillId = __is.readInt();
        this.skillTime = __is.readLong();
        __is.endReadSlice();
    }


    public SkillDataICE clone() {
        return (SkillDataICE) super.clone();
    }
}


