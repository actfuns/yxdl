package Xmds;

import Ice.Current;
import Ice.Object;
import Ice.ObjectFactory;
import Ice.ObjectImpl;
import IceInternal.BasicStream;

import java.util.Arrays;


public class GetPlayerData
        extends ObjectImpl {
    public GetPlayerData() {
    }

    public GetPlayerData(float x, float y, float direction, int hp, int mp, int pkMode, int pkValue, int pkLevel, SkillDataICE[] skillData, int combatState) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.hp = hp;
        this.mp = mp;
        this.pkMode = pkMode;
        this.pkValue = pkValue;
        this.pkLevel = pkLevel;
        this.skillData = skillData;
        this.combatState = combatState;
    }

    private static class __F implements ObjectFactory {
        private __F() {
        }

        public Object create(String type) {
            assert type.equals(GetPlayerData.ice_staticId());
            return (Object) new GetPlayerData();
        }


        public void destroy() {
        }
    }

    private static ObjectFactory _factory = new __F();


    public static ObjectFactory ice_factory() {
        return _factory;
    }

    public static final String[] __ids = new String[]{"::Ice::Object", "::Xmds::GetPlayerData"};
    public float x;
    public float y;
    public float direction;
    public int hp;
    public int mp;

    public boolean ice_isA(String s) {
        return (Arrays.binarySearch((Object[]) __ids, s) >= 0);
    }

    public int pkMode;
    public int pkValue;
    public int pkLevel;
    public SkillDataICE[] skillData;
    public int combatState;
    public static final long serialVersionUID = 803543938L;

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
        __os.writeFloat(this.x);
        __os.writeFloat(this.y);
        __os.writeFloat(this.direction);
        __os.writeInt(this.hp);
        __os.writeInt(this.mp);
        __os.writeInt(this.pkMode);
        __os.writeInt(this.pkValue);
        __os.writeInt(this.pkLevel);
        SkillDataSeqHelper.write(__os, this.skillData);
        __os.writeInt(this.combatState);
        __os.endWriteSlice();
    }


    protected void __readImpl(BasicStream __is) {
        __is.startReadSlice();
        this.x = __is.readFloat();
        this.y = __is.readFloat();
        this.direction = __is.readFloat();
        this.hp = __is.readInt();
        this.mp = __is.readInt();
        this.pkMode = __is.readInt();
        this.pkValue = __is.readInt();
        this.pkLevel = __is.readInt();
        this.skillData = SkillDataSeqHelper.read(__is);
        this.combatState = __is.readInt();
        __is.endReadSlice();
    }


    public GetPlayerData clone() {
        return (GetPlayerData) super.clone();
    }
}


