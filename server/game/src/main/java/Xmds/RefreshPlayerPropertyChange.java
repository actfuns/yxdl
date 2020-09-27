package Xmds;

import Ice.Current;
import Ice.Object;
import Ice.ObjectFactory;
import Ice.ObjectImpl;
import IceInternal.BasicStream;

import java.util.Arrays;


public class RefreshPlayerPropertyChange
        extends ObjectImpl {
    public RefreshPlayerPropertyChange() {
        this.key = "";
    }


    public RefreshPlayerPropertyChange(String key, int changeType, int valueType, int value, int duration, long timestamp) {
        this.key = key;
        this.changeType = changeType;
        this.valueType = valueType;
        this.value = value;
        this.duration = duration;
        this.timestamp = timestamp;
    }

    private static class __F implements ObjectFactory {
        private __F() {
        }

        public Object create(String type) {
            assert type.equals(RefreshPlayerPropertyChange.ice_staticId());
            return (Object) new RefreshPlayerPropertyChange();
        }


        public void destroy() {
        }
    }

    private static ObjectFactory _factory = new __F();


    public static ObjectFactory ice_factory() {
        return _factory;
    }

    public static final String[] __ids = new String[]{"::Ice::Object", "::Xmds::RefreshPlayerPropertyChange"};

    public String key;

    public int changeType;
    public int valueType;

    public boolean ice_isA(String s) {
        return (Arrays.binarySearch((Object[]) __ids, s) >= 0);
    }

    public int value;
    public int duration;
    public long timestamp;
    public static final long serialVersionUID = 706043069L;

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
        __os.writeString(this.key);
        __os.writeInt(this.changeType);
        __os.writeInt(this.valueType);
        __os.writeInt(this.value);
        __os.writeInt(this.duration);
        __os.writeLong(this.timestamp);
        __os.endWriteSlice();
    }


    protected void __readImpl(BasicStream __is) {
        __is.startReadSlice();
        this.key = __is.readString();
        this.changeType = __is.readInt();
        this.valueType = __is.readInt();
        this.value = __is.readInt();
        this.duration = __is.readInt();
        this.timestamp = __is.readLong();
        __is.endReadSlice();
    }


    public RefreshPlayerPropertyChange clone() {
        return (RefreshPlayerPropertyChange) super.clone();
    }
}


