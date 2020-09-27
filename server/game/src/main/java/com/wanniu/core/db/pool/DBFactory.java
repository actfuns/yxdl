package com.wanniu.core.db.pool;

import com.wanniu.core.GGlobal;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.xml.XW3CParser;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.naming.NameAlreadyBoundException;
import javax.naming.NameNotFoundException;
import javax.sql.DataSource;


public final class DBFactory {
    private static boolean inited;
    static Map<String, DBSource> dsPools = null;


    public static DBSource lookup(String dataSource) {
        DBSource ds = null;
        if (dsPools != null) {
            ds = dsPools.get(dataSource);
        }
        return ds;
    }


    public static DBSource start(String name, DBAttribute param) throws NameAlreadyBoundException, SQLException {
        if (lookup(name) != null) {
            throw new NameAlreadyBoundException(name);
        }
        DBSource source = new DBSource(param);
        if (dsPools == null) {
            dsPools = new ConcurrentHashMap<>();
        }
        dsPools.put(name, source);
        return source;
    }


    public static DBSource restart(String name, DBAttribute param) throws NameAlreadyBoundException, ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        try {
            shutdown(name);
        } catch (Exception exception) {
        }

        return start(name, param);
    }


    public static void shutdown(String name) throws NameNotFoundException {
        if (dsPools == null) {
            return;
        }
        DataSource dataSource = lookup(name);

        if (dataSource != null && dataSource instanceof DBSource) {
            DBSource datasource = (DBSource) dataSource;
            datasource.shutdown();
            datasource = null;
        }

        dsPools.remove(name);
    }


    public static synchronized void init() {
        if (!inited) {

            dsPools = new ConcurrentHashMap<>(2, 0.75F);
            List<DBAttribute> drivers = null;
            try {
                drivers = XW3CParser.parse(GGlobal.FILE_CONF_DS, DBAttribute.class);
            } catch (Exception e) {
                Out.error(new Object[]{"读取连接池配置文件错误 -> ", GGlobal.FILE_CONF_DS});
                e.printStackTrace();
                System.exit(-1);
            }

            if (drivers.size() == 0) {
                Out.warn(new Object[]{"连接池配置文件中未配置 -> ", GGlobal.FILE_CONF_DS});

                return;
            }
            StringBuilder dsInfo = new StringBuilder();
            DBAttribute cp = null;

            for (int i = 0; i < drivers.size(); i++) {
                try {
                    cp = drivers.get(i);
                    start(cp.getDsName(), cp);
                    dsInfo.append(cp.getDsName());

                    if (i < drivers.size() - 1) {
                        dsInfo.append(" & ");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Out.error(new Object[]{"绑定连接池 [", ((DBAttribute) drivers.get(i)).getDsName(), "] 错误！"});
                    System.exit(-1);
                }
            }
            inited = true;
            Out.info(new Object[]{String.format("\n\n初始化成功连接池数量：%d\n数据库连接池【  %s 】\n", new Object[]{Integer.valueOf(drivers.size()), dsInfo.toString()})});
        }
    }
}


