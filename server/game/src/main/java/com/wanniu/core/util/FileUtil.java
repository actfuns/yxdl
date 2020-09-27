package com.wanniu.core.util;

import com.wanniu.core.GGlobal;
import com.wanniu.core.logfs.Out;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class FileUtil {
    public static List<String> readLines(String filename) {
        File file = new File(filename);
        return readLines(file);
    }

    public static void eachLine(String file, FileReader cloure) {
        eachLine(new File(file), cloure);
    }

    public static void eachLine(File file, FileReader cloure) {
        BufferedReader bufferReader = null;
        InputStreamReader reader = null;
        if (file.exists()) {
            try {
                reader = new InputStreamReader(new FileInputStream(file), GGlobal.UTF_8);
                bufferReader = new BufferedReader(reader);
                String line = null;
                while ((line = bufferReader.readLine()) != null) {
                    cloure.read(line);
                }
            } catch (Exception e) {
                Out.error(new Object[]{"FileUtil eachLine", e});
            } finally {
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    Out.error(new Object[]{"FileUtil eachLine", e});
                }
                try {
                    if (bufferReader != null) {
                        bufferReader.close();
                    }
                } catch (IOException e) {
                    Out.error(new Object[]{"FileUtil eachLine", e});
                }
            }
        } else {
            Out.error(new Object[]{"FileUtil eachLine", String.format("Not found %s!", new Object[]{file.getAbsolutePath()})});
        }
    }

    public static String checkLine(String file, FileChecker cloure) {
        return checkLine(new File(file), cloure);
    }

    public static String checkLine(File file, FileChecker cloure) {
        BufferedReader bufferReader = null;
        InputStreamReader reader = null;
        if (file.exists()) {
            try {
                reader = new InputStreamReader(new FileInputStream(file), GGlobal.UTF_8);
                bufferReader = new BufferedReader(reader);
                String line = null;
                while ((line = bufferReader.readLine()) != null) {
                    if (cloure.check(line)) {
                        return line;
                    }
                }
            } catch (Exception e) {
                Out.error(new Object[]{"FileUtil checkLine", e});
            } finally {
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    Out.error(new Object[]{"FileUtil checkLine", e});
                }
                try {
                    if (bufferReader != null) {
                        bufferReader.close();
                    }
                } catch (IOException e) {
                    Out.error(new Object[]{"FileUtil checkLine", e});
                }
            }
        } else {
            Out.error(new Object[]{"FileUtil checkLine", String.format("Not found %s!", new Object[]{file.getAbsolutePath()})});
        }
        return null;
    }

    public static List<String> readLines(File file) {
        final List<String> lines = new ArrayList<>();
        eachLine(file, new FileReader() {
            public void read(String line) {
                lines.add(line);
            }
        });
        return lines;
    }

    public static String readText(File file) {
        final StringBuilder lines = new StringBuilder();
        eachLine(file, new FileReader() {
            public void read(String line) {
                lines.append(line).append('\n');
            }
        });
        return lines.toString();
    }


    public static boolean copy(String src, String dest) {
        File srcFile = new File(src);
        if (!srcFile.exists() || !srcFile.isFile() || !srcFile.canRead()) {
            return false;
        }
        File destFile = new File(dest);
        if (destFile.exists()) {
            destFile.delete();
        }

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(srcFile));
            bos = new BufferedOutputStream(new FileOutputStream(destFile));
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = bis.read(buf)) != -1) {
                bos.write(buf, 0, len);
            }

            return true;
        } catch (FileNotFoundException e) {
            Out.error(new Object[]{"FileUtil copy", e});
        } catch (IOException e) {
            Out.error(new Object[]{"FileUtil copy", e});
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException iOException) {
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException iOException) {
                }
            }
        }

        return false;
    }


    public static boolean clear(File file) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(file, false));
            writer.close();
        } catch (IOException e) {
            Out.error(new Object[]{"FileUtil clear", e});
            return false;
        }
        return true;
    }


    public static byte[] file2bytes(File file) {
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(file));
            ByteArrayOutputStream out = new ByteArrayOutputStream(in.available());
            byte[] temp = new byte[1024];
            int size = 0;
            while ((size = in.read(temp)) != -1) {
                out.write(temp, 0, size);
            }
            return out.toByteArray();
        } catch (Exception e) {
            Out.error(new Object[]{"FileUtil file2bytes", e});
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    Out.error(new Object[]{"FileUtil file2bytes", e});
                }
            }
        }
        return null;
    }


    public static void copyNio(File from, File to) throws IOException {
        RandomAccessFile inFile = new RandomAccessFile(from, "r");
        try {
            RandomAccessFile outFile = new RandomAccessFile(to, "rw");
            try {
                FileChannel inChannel = inFile.getChannel();
                FileChannel outChannel = outFile.getChannel();
                long pos = 0L;
                long toCopy = inFile.length();
                while (toCopy > 0L) {
                    long bytes = inChannel.transferTo(pos, toCopy, outChannel);
                    pos += bytes;
                    toCopy -= bytes;
                }
            } finally {
                outFile.close();
            }
        } finally {
            inFile.close();
        }
    }


    public static void write(File file, Collection<String> lines) {
        try {
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file, false), GGlobal.UTF_8), true);
            for (String key : lines) {
                writer.println(key);
            }
            writer.close();
            writer = null;
        } catch (Exception e) {
            Out.error(new Object[]{"FileUtil write", e});
        }
    }


    public static void write(File file, String content) {
        try {
            if (file.exists()) {
                byte[] text = Files.readAllBytes(file.toPath());
                byte[] newText = content.getBytes("UTF-8");

                boolean same = true;
                if (text.length == newText.length) {
                    for (int i = 0; i < text.length; i++) {
                        if (text[i] != newText[i]) {
                            same = false;
                            break;
                        }
                    }
                } else {
                    same = false;
                }

                if (!same) {
                    Files.write(file.toPath(), newText, new java.nio.file.OpenOption[0]);
                } else {
                    Out.info(new Object[]{"检查未变更，忽略生成", file.getName()});
                }
            } else {
                Files.write(file.toPath(), content.getBytes("UTF-8"), new java.nio.file.OpenOption[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static interface FileReader {
        void read(String param1String);
    }

    public static interface FileChecker {
        boolean check(String param1String);
    }
}


