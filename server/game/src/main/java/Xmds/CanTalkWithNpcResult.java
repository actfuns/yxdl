package Xmds;

import Ice.Current;
import Ice.Object;
import Ice.ObjectFactory;
import Ice.ObjectImpl;
import IceInternal.BasicStream;

import java.util.Arrays;


public class CanTalkWithNpcResult
        extends ObjectImpl {
    public CanTalkWithNpcResult() {
    }

    public CanTalkWithNpcResult(int templateId, boolean canTalk) {
        this.templateId = templateId;
        this.canTalk = canTalk;
    }

    private static class __F implements ObjectFactory {
        private __F() {
        }

        public Object create(String type) {
            assert type.equals(CanTalkWithNpcResult.ice_staticId());
            return (Object) new CanTalkWithNpcResult();
        }


        public void destroy() {
        }
    }

    private static ObjectFactory _factory = new __F();


    public static ObjectFactory ice_factory() {
        return _factory;
    }

    public static final String[] __ids = new String[]{"::Ice::Object", "::Xmds::CanTalkWithNpcResult"};

    public int templateId;

    public boolean canTalk;
    public static final long serialVersionUID = -6558856L;

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
        __os.writeInt(this.templateId);
        __os.writeBool(this.canTalk);
        __os.endWriteSlice();
    }


    protected void __readImpl(BasicStream __is) {
        __is.startReadSlice();
        this.templateId = __is.readInt();
        this.canTalk = __is.readBool();
        __is.endReadSlice();
    }


    public CanTalkWithNpcResult clone() {
        return (CanTalkWithNpcResult) super.clone();
    }
}


