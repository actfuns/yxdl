package Xmds;

import Ice.Current;
import Ice.Object;
import Ice.ObjectFactory;
import Ice.ObjectImpl;
import IceInternal.BasicStream;

import java.util.Arrays;


public class PlayerPKInfoData
        extends ObjectImpl {
    public PlayerPKInfoData() {
    }

    public PlayerPKInfoData(int pkMode, int pkValue, int pkLevel) {
        this.pkMode = pkMode;
        this.pkValue = pkValue;
        this.pkLevel = pkLevel;
    }

    private static class __F implements ObjectFactory {
        private __F() {
        }

        public Object create(String type) {
            assert type.equals(PlayerPKInfoData.ice_staticId());
            return (Object) new PlayerPKInfoData();
        }


        public void destroy() {
        }
    }

    private static ObjectFactory _factory = new __F();


    public static ObjectFactory ice_factory() {
        return _factory;
    }

    public static final String[] __ids = new String[]{"::Ice::Object", "::Xmds::PlayerPKInfoData"};

    public int pkMode;
    public int pkValue;
    public int pkLevel;
    public static final long serialVersionUID = 1679009383L;

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
        __os.writeInt(this.pkMode);
        __os.writeInt(this.pkValue);
        __os.writeInt(this.pkLevel);
        __os.endWriteSlice();
    }


    protected void __readImpl(BasicStream __is) {
        __is.startReadSlice();
        this.pkMode = __is.readInt();
        this.pkValue = __is.readInt();
        this.pkLevel = __is.readInt();
        __is.endReadSlice();
    }


    public PlayerPKInfoData clone() {
        return (PlayerPKInfoData) super.clone();
    }
}


