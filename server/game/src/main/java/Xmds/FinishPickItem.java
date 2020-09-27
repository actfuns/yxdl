package Xmds;

import Ice.Current;
import Ice.Object;
import Ice.ObjectFactory;
import Ice.ObjectImpl;
import IceInternal.BasicStream;

import java.util.Arrays;


public class FinishPickItem
        extends ObjectImpl {
    public FinishPickItem() {
        this.itemIcon = "";
    }


    public FinishPickItem(String itemIcon, int quality, int num) {
        this.itemIcon = itemIcon;
        this.quality = quality;
        this.num = num;
    }

    private static class __F implements ObjectFactory {
        private __F() {
        }

        public Object create(String type) {
            assert type.equals(FinishPickItem.ice_staticId());
            return (Object) new FinishPickItem();
        }


        public void destroy() {
        }
    }

    private static ObjectFactory _factory = new __F();


    public static ObjectFactory ice_factory() {
        return _factory;
    }

    public static final String[] __ids = new String[]{"::Ice::Object", "::Xmds::FinishPickItem"};

    public String itemIcon;
    public int quality;
    public int num;
    public static final long serialVersionUID = -460233274L;

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
        __os.writeString(this.itemIcon);
        __os.writeInt(this.quality);
        __os.writeInt(this.num);
        __os.endWriteSlice();
    }


    protected void __readImpl(BasicStream __is) {
        __is.startReadSlice();
        this.itemIcon = __is.readString();
        this.quality = __is.readInt();
        this.num = __is.readInt();
        __is.endReadSlice();
    }


    public FinishPickItem clone() {
        return (FinishPickItem) super.clone();
    }
}


