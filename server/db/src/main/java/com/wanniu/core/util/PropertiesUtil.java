package com.wanniu.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public final class PropertiesUtil {
    public static Map<String, String> loadProperties(File file) {
        Map<String, String> ret = new HashMap<>();
        Properties props = new Properties();
        try {
            InputStream in = new FileInputStream(file);
            props.load(in);
            Enumeration<?> en = props.propertyNames();
            while (en.hasMoreElements()) {
                String key = (String) en.nextElement();
                String value = props.getProperty(key);
                ret.put(key, value);
            }
            props.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }


    public static void writeProperties(File file, String name, String value) {
        Properties prop = new Properties();
        try {
            InputStream fis = new FileInputStream(file);

            prop.load(fis);


            OutputStream fos = new FileOutputStream(file);
            prop.setProperty(name, value);


            prop.store(fos, "Update '" + name + "' value");
        } catch (IOException e) {
            System.err.println("Visit " + file.getPath() + " for updating " + name + " value error");
        }
    }
}


