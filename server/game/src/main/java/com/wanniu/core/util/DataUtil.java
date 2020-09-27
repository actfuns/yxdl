package com.wanniu.core.util;

import com.alibaba.fastjson.JSONArray;
import com.wanniu.core.logfs.Out;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


public class DataUtil {
    public static Map<String, String> Classes = new HashMap<>();

    public static Map<String, String> superClasses = new HashMap<>();

    public static String extendClass = "Ext";
    public static String pakName = "Ext";


    public static void addExtClass(String pakName) {
        DataUtil.pakName = pakName;
        File file = new File(DIR + File.separator + "ext" + File.separator);
        if (file.exists() && file.isDirectory()) {
            for (String f : file.list()) {
                String name = f.substring(0, f.indexOf(".java"));
                Classes.put(name, pakName + ".ext." + name);
            }
        }
    }

    public static String getClassName(String name) {
        if (name.indexOf(File.separator) >= 0) {
            name = name.substring(name.lastIndexOf(File.separator) + 1);
        }
        StringBuilder builder = new StringBuilder();
        builder.append(Character.toUpperCase(name.charAt(0)));
        for (int i = 1; i < name.length() &&
                name.charAt(i) != '.'; i++) {
            if (name.charAt(i) == '-') {
                builder.append("_");

            } else if (name.charAt(i) == '_') {
                if (name.charAt(i + 1) != '.') {
                    builder.append(Character.toUpperCase(name.charAt(i + 1)));
                    i++;
                }
            } else {
                builder.append(name.charAt(i));
            }
        }
        return builder.toString();
    }

    public static String getFieldName(String name) {
        if (name.length() < 1) return null;
        name = name.trim();
        StringBuilder builder = new StringBuilder();
        builder.append(Character.toLowerCase(name.charAt(0)));
        for (int i = 1; i < name.length(); i++) {
            if (name.charAt(i) != ' ')
                if (name.charAt(i) == '-') {
                    builder.append("_");

                } else if (name.charAt(i) == '_') {
                    if (name.length() > i + 1) {
                        builder.append("_").append(Character.toLowerCase(name.charAt(i + 1)));
                        i++;
                    }
                } else {
                    builder.append(name.charAt(i));
                }
        }
        String field = builder.toString();
        if ("long".equals(field)) {
            field = "long_v";
        } else if ("goto".equals(field)) {
            field = "goto_v";
        } else if ("default".equals(field)) {
            field = "default_v";
        } else if ("new".equals(field)) {
            field = "new_v";
        } else if ("try".equals(field)) {
            field = "try_v";
        } else if ("final".equals(field)) {
            field = "final_v";
        }
        return field;
    }

    private static String DIR = "/";

    public static void setDir(String path) {
        File toDir = new File(path);
        toDir.mkdirs();
        DIR = toDir.getAbsolutePath() + File.separator;
    }

    private static String type(Object type) {
        if ("NUMBER".equals(type))
            return "int";
        if ("STRING".equals(type))
            return "String";
        if ("FLOAT".equals(type)) {
            return "float";
        }
        Out.error(new Object[]{" undefine type : ", type});

        return "Object";
    }

    private static Map<String, String> DataNames = new HashMap<>();
    private static StringBuilder BaseBuilder;

    public static void writeClass(File file) {
        try {
            if (BaseBuilder == null) {
                BaseBuilder = new StringBuilder();
                BaseBuilder.append("package ").append(pakName).append("; \n\n");
                for (String fullName : Classes.values()) {
                    BaseBuilder.append("import " + fullName + ";\n");
                }
                BaseBuilder.append("import java.util.Map; \n");
                BaseBuilder.append("import java.util.HashMap; \n\n");
                BaseBuilder.append("import java.util.function.Predicate; \n\n");
                BaseBuilder.append("import java.util.List; \n\n");
                BaseBuilder.append("import java.util.ArrayList; \n\n");
                BaseBuilder.append("/** 游戏-策划配置 */\n");
                BaseBuilder.append("public final class GameData { \n\n");
            }
            StringBuilder builder = new StringBuilder();
            builder.append("package ").append(pakName).append("; \n\n");
            String baseName = getClassName(file.getName());
            String clsName = baseName + "CO";
            if (DataNames.containsKey(clsName)) {
                Out.error(new Object[]{baseName, " 表名冲突：\n", file.getAbsolutePath(), "\n", DataNames.get(clsName)});
                return;
            }
            DataNames.put(clsName, file.getAbsolutePath());
            builder.append("public class ").append(clsName);
            if (superClasses.containsKey(clsName)) {
                builder.append(" extends ").append(superClasses.get(clsName));
            }
            builder.append(" { \n\n");

            JSONArray doc = JSONArray.parseArray(FileUtil.readText(file));
            if (doc.size() < 3) {
                Out.error(new Object[]{"空数据：", file.getAbsolutePath()});
                return;
            }
            JSONArray descs = (JSONArray) doc.get(0);
            JSONArray keys = (JSONArray) doc.get(1);
            JSONArray types = (JSONArray) doc.get(2);
            String k_type = type(types.get(0));
            if (!superClasses.containsKey(clsName)) {
                for (int i = 0; i < keys.size(); i++) {
                    String field = getFieldName(keys.get(i).toString());
                    if (field == null) {
                        Out.warn(new Object[]{"空列：", file.getAbsolutePath()});
                    } else {

                        builder.append("\t/** ").append(descs.get(i)).append(" */\n");
                        builder.append("\tpublic ").append(type(types.get(i)));
                        builder.append(" ").append(field).append(";\n");
                    }
                }
                builder.append(String.format("\n\t/** 主键 */\n\tpublic %s getKey() {\n\t\treturn this.%s; \n\t}\n", new Object[]{k_type,
                        getFieldName(keys.get(0).toString())}));

                builder.append("\n\t/** 构造属性 */\n\tpublic void initProperty() { }\n");
            }

            builder.append("\n\t/** 构造前置属性 */\n\tpublic void beforeProperty() { }\n");

            builder.append("\n}");

            String keyName = clsName;
            String classNameExt = baseName + extendClass;
            if (Classes.containsKey(classNameExt)) {
                keyName = classNameExt;
            }

            if (k_type.equals("int")) {
                k_type = "Integer";
            }
            BaseBuilder.append(String.format("\tpublic static Map<%s, %s> %ss = new HashMap<%s, %s>();\n", new Object[]{k_type, keyName, baseName, k_type, keyName}));


            BaseBuilder.append("\t");
            BaseBuilder.append("public static List<" + keyName + "> find" + baseName + "s(Predicate<" + keyName + "> pre) {\n");
            BaseBuilder.append("\t\tList<" + keyName + "> results = new ArrayList<>();\n");
            BaseBuilder.append("\t\tfor(" + keyName + " t : " + baseName + "s.values()) {\n");
            BaseBuilder.append("\t\t\tif(pre.test(t)) {\n");
            BaseBuilder.append("\t\t\t\tresults.add(t);\n");
            BaseBuilder.append("\t\t\t}\n\t\t}\n");
            BaseBuilder.append("\t\treturn results;\n");
            BaseBuilder.append("\t}\r\n\n");

            BaseBuilder.append("");
            clsName = clsName + ".java";
            Out.info(new Object[]{"生成：", clsName});
            FileUtil.write(new File(DIR + clsName), builder.toString());
        } catch (Exception e) {
            Out.error(new Object[]{e});
            Out.error(new Object[]{file.getAbsolutePath()});
        }
    }

    public static void writeGameData() {
        if (BaseBuilder != null) {
            BaseBuilder.append("\n}");
            FileUtil.write(new File(DIR + "GameData.java"), BaseBuilder.toString());
        }
    }


    private static Map<String, Map> Datas = new HashMap<>();

    public static void loadData(File file) {
        String fieldName = null;
        int row = 0;
        int col = 0;
        try {
            String name = getClassName(file.getName());
            String className = pakName + "." + name + "CO";
            String classNameExt = name + extendClass;
            if (Classes.containsKey(classNameExt)) {
                className = Classes.get(classNameExt);
            }
            String dataName = name + "s";
            JSONArray doc = JSONArray.parseArray(FileUtil.readText(file));
            if (doc.size() < 3) {
                Out.debug(new Object[]{file.getAbsolutePath(), " json doc row < 3"});

                return;
            }
            Map<Object, Object> data = (Map) ClassUtil.getStaticProperty(Class.forName(pakName + ".GameData"), dataName);
            if (!Datas.containsKey(dataName)) {
                Datas.put(dataName, data);
            } else {
                Out.error(new Object[]{dataName, " 数据表名冲突 -> ", file.getAbsolutePath()});
                return;
            }
            JSONArray keys = (JSONArray) doc.get(1);
            Class<?> clz = null;

            try {
                clz = Class.forName(pakName + ".ext." + classNameExt);
            } catch (Exception e) {
                clz = Class.forName(className);
            }
            Object owner = null;
            Field field = null;
            Map<String, Field> fields = new HashMap<>();
            for (int i = 3; i < doc.size(); i++) {
                row = i;
                owner = clz.newInstance();
                JSONArray values = (JSONArray) doc.get(i);
                for (int k = 0; k < keys.size(); k++) {
                    col = k;
                    fieldName = getFieldName(keys.get(k).toString());
                    if (fieldName == null) {
                        Out.debug(new Object[]{file.getAbsolutePath(), " ", keys.get(k), " 没有这个字段名"});
                    } else {

                        Object o = values.get(k);
                        field = fields.get(fieldName);
                        if (field == null) {
                            field = ClassUtil.getDeclaredField(owner, fieldName);
                            fields.put(fieldName, field);
                        }
                        if (field == null) {
                            Out.warn(new Object[]{className, " not exists ", fieldName});
                        } else {

                            String typeName = field.getType().getSimpleName();
                            if ("int".equals(typeName)) {
                                field.set(owner, Integer.valueOf(((Number) o).intValue()));
                            } else if ("float".equals(typeName)) {
                                field.set(owner, Float.valueOf(((Number) o).floatValue()));
                            } else {
                                field.set(owner, o);
                            }
                        }
                    }
                }
                Object key = ClassUtil.invokeMethod(owner, "getKey", new Object[0]);
                data.put(key, owner);
            }
            fields.clear();
            Out.info(new Object[]{"加载：", dataName, " - ", Integer.valueOf(data.size())});
        } catch (Exception e) {
            Out.error(new Object[]{e});
            Out.error(new Object[]{file.getAbsolutePath(), " : ", fieldName, "&row=", Integer.valueOf(row), " col=", Integer.valueOf(col)});
        }
    }


    public static void reloadData(File file) {
        String fieldName = null;
        int row = 0;
        int col = 0;
        try {
            String name = getClassName(file.getName());
            String className = pakName + "." + name + "CO";
            String classNameExt = name + extendClass;
            if (Classes.containsKey(classNameExt)) {
                className = Classes.get(classNameExt);
            }
            String dataName = name + "s";
            JSONArray doc = JSONArray.parseArray(FileUtil.readText(file));
            if (doc.size() < 3) {
                Out.debug(new Object[]{file.getAbsolutePath(), " json doc row < 3"});

                return;
            }
            Map<Object, Object> data = (Map) ClassUtil.getStaticProperty(Class.forName(pakName + ".GameData"), dataName);
            Datas.put(dataName, data);

            JSONArray keys = (JSONArray) doc.get(1);
            Class<?> clz = null;

            try {
                clz = Class.forName(pakName + ".ext." + classNameExt);
            } catch (Exception e) {
                clz = Class.forName(className);
            }
            Object owner = null;
            Field field = null;
            Map<String, Field> fields = new HashMap<>();
            for (int i = 3; i < doc.size(); i++) {
                row = i;
                owner = clz.newInstance();
                JSONArray values = (JSONArray) doc.get(i);
                for (int k = 0; k < keys.size(); k++) {
                    col = k;
                    fieldName = getFieldName(keys.get(k).toString());
                    if (fieldName == null) {
                        Out.debug(new Object[]{file.getAbsolutePath(), " ", keys.get(k), " 没有这个字段名"});
                    } else {

                        Object o = values.get(k);
                        field = fields.get(fieldName);
                        if (field == null) {
                            field = ClassUtil.getDeclaredField(owner, fieldName);
                            fields.put(fieldName, field);
                        }
                        if (field == null) {
                            Out.warn(new Object[]{className, " not exists ", fieldName});
                        } else {

                            String typeName = field.getType().getSimpleName();
                            if ("int".equals(typeName)) {
                                field.set(owner, Integer.valueOf(((Number) o).intValue()));
                            } else if ("float".equals(typeName)) {
                                field.set(owner, Float.valueOf(((Number) o).floatValue()));
                            } else {
                                field.set(owner, o);
                            }
                        }
                    }
                }
                Object key = ClassUtil.invokeMethod(owner, "getKey", new Object[0]);
                data.put(key, owner);
            }
            fields.clear();
            Out.info(new Object[]{"重新加载：", dataName, " - ", Integer.valueOf(data.size())});
        } catch (Exception e) {
            Out.error(new Object[]{e});
            Out.error(new Object[]{file.getAbsolutePath(), " : ", fieldName, "&row=", Integer.valueOf(row), " col=", Integer.valueOf(col)});
        }
    }


    private static void initProperty(String methodName) {
        for (Map.Entry<String, Map> entry : Datas.entrySet()) {
            try {
                long starTime = System.currentTimeMillis();
                Method method = null;
                for (Object o : ((Map) entry.getValue()).values()) {
                    if (method == null) {
                        Class<?> ownerClass = o.getClass();
                        method = ownerClass.getMethod(methodName, new Class[0]);
                    }
                    method.invoke(o, new Object[0]);
                }
                long useTime = System.currentTimeMillis() - starTime;
                if (useTime > 0L) {
                    Out.info(new Object[]{methodName, " - ", entry.getKey(), " use \t", Long.valueOf(useTime)});
                }
            } catch (Exception e) {
                Out.error(new Object[]{"DataUtil initProperty", e});
            }
        }
    }

    public static void initProperty() {
        initProperty("beforeProperty");
        initProperty("initProperty");
        Datas.clear();
    }
}


