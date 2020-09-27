package com.wanniu.core;

import java.io.File;


interface GFile {
    public static final String _ROOT_DIR_ = String.valueOf(System.getProperty("user.dir")) + File.separator + "%s" + File.separator;


    public static final String DIR_CONF_SERVER = String.format(_ROOT_DIR_, new Object[]{"conf"});


    public static final String DIR_CONF_GAME = GConfig.getInstance().get("dir.conf.game", DIR_CONF_SERVER);


    public static final String DIR_DATA = GConfig.getInstance().get("dir.data", String.format(_ROOT_DIR_, new Object[]{"data"}));


    public static final String DIR_COMMON = GConfig.getInstance().get("dir.common", String.valueOf(DIR_DATA) + "common" + File.separator);


    public static final String DIR_SCRIPT_ROOT = GConfig.getInstance().get("dir.scripts", String.format(_ROOT_DIR_, new Object[]{"classes"}));


    public static final String DIR_RESOURCE_ROOT = String.valueOf((new File(GConfig.getInstance().get("dir.resource.root", String.format(_ROOT_DIR_, new Object[]{"resource"})))).getPath()) + File.separator;


    public static final String DIR_FILTER = GConfig.getInstance().get("dir.filter", String.valueOf(DIR_COMMON) + "filter" + File.separator);


    public static final String DIR_NICKNAME = GConfig.getInstance().get("dir.nickname", String.valueOf(DIR_COMMON) + "nickname" + File.separator);


    public static final String DIR_LANGUAGE = GConfig.getInstance().get("dir.language", String.valueOf(DIR_COMMON) + "language" + File.separator);


    public static final String FILE_CONF_DS = String.valueOf(DIR_CONF_SERVER) + "conf.ds.xml";


    public static final String DIR_LOG = GConfig.getInstance().get("log.dir", String.valueOf(System.getProperty("user.dir")) + File.separator + "logs");
}


