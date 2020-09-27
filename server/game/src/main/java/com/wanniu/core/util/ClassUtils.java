package com.wanniu.core.util;

import com.wanniu.core.logfs.Out;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;


public class ClassUtils {
    private static final String URL_PROTOCOL_FILE = "file";
    private static final String URL_PROTOCOL_JAR = "jar";

    public static Class<?> loadClass(String className) {
        try {
            return Thread.currentThread().getContextClassLoader().loadClass(className);
        } catch (ClassNotFoundException classNotFoundException) {

            try {
                return Class.forName(className);
            } catch (ClassNotFoundException classNotFoundException1) {

                throw new RuntimeException("无法加载指定类" + className);
            }
        }
    }


    public static <T> T newInstance(Class<T> klass) {
        try {
            return klass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("无法创建实例对象" + klass.getName(), e);
        }
    }


    public static void scanPackage(String packagePath, ResourceCallback callback) {
        packagePath = packagePath.replace('.', '/').replace('\\', '/');
        if (!packagePath.endsWith("/")) {
            packagePath = packagePath + "/";
        }

        try {
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                switch (url.getProtocol()) {

                    case "file":
                        doFindFileResources(packagePath, new File(url.getFile()), callback);


                    case "jar":
                        doFindJarResources(url, callback, packagePath);
                }


            }
        } catch (IOException e) {
            throw new RuntimeException("扫描过程中出异常啦", e);
        }
    }


    private static void doFindJarResources(URL url, ResourceCallback callback, String rootEntryPath) throws IOException {
        JarURLConnection jarCon = (JarURLConnection) url.openConnection();
        try (JarFile jarFile = jarCon.getJarFile()) {
            for (Enumeration<JarEntry> entries = jarFile.entries(); entries.hasMoreElements(); ) {
                String entryPath = ((JarEntry) entries.nextElement()).getName();
                if (entryPath.startsWith(rootEntryPath)) {
                    findJarFile(entryPath, callback);
                }
            }
        }
    }


    private static void doFindFileResources(String packagePath, File file, ResourceCallback callback) {
        String path = file.getAbsolutePath();


        if (!file.exists()) {
            Out.debug(new Object[]{"Skipping [", path, "] because it does not exist"});

            return;
        }

        if (!file.canRead()) {
            Out.warn(new Object[]{"Cannot search for matching files underneath directory [", path, "] because the application is not allowed to read the directory"});


            return;
        }

        if (file.isDirectory()) {
            findDir(packagePath, file, callback);

        } else if (file.isFile()) {
            findFile(packagePath, file, callback);
        }
    }


    private static void findDir(String packagePath, File dir, ResourceCallback callback) {
        File[] dirContents = dir.listFiles();


        if (dirContents == null) {
            Out.warn(new Object[]{"Could not retrieve contents of directory [", dir.getAbsolutePath(), "]"});

            return;
        }
        for (File content : dirContents) {

            if (content.isFile()) {
                findFile(packagePath, content, callback);

            } else if (content.isDirectory()) {

                findDir(packagePath + content.getName() + "/", content, callback);
            }
        }
    }


    private static void findJarFile(String entryPath, ResourceCallback callback) {
        analysisResource(callback, entryPath);
    }


    private static void findFile(String packagePath, File file, ResourceCallback callback) {
        analysisResource(callback, packagePath + file.getName());
    }


    private static void analysisResource(ResourceCallback callback, String resourceName) {
        if ("package-info.class".equals(resourceName)) {
            return;
        }

        if (!resourceName.endsWith(".class")) {
            return;
        }

        callback.handleResource(
                loadClass(resourceName.substring(0, resourceName.length() - 6).replaceAll("[/\\\\]", ".")));
    }

    public static interface ResourceCallback {
        void handleResource(Class<?> param1Class);
    }
}


