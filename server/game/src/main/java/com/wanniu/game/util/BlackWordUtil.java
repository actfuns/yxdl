package com.wanniu.game.util;

import com.wanniu.core.XLang;
import com.wanniu.game.GWorld;
import com.wanniu.game.data.BlackWordCO;
import com.wanniu.game.data.GameData;

import java.util.ArrayList;
import java.util.List;


public final class BlackWordUtil {
    private static DFAScanner scaner = null;

    public static DFAScanner getScaner() {
        if (scaner == null) {
            synchronized (BlackWordUtil.class) {
                if (scaner == null) {
                    List<String> words = new ArrayList<>(GameData.BlackWords.size());
                    for (BlackWordCO bw : GameData.BlackWords.values()) {
                        words.add(bw.word);
                    }
                    scaner = new DFAScanner(words);
                }
            }
        }
        return scaner;
    }


    public static boolean isIncludeBlackString(String srcString) {
        return getScaner().findSensitiveWord(srcString);
    }


    public static boolean isIncludeSpecialChar(String srcString) {
        int unicodeStart = GWorld.__SERVER_LANG.getUnicodeStart();
        int unicodeEnd = GWorld.__SERVER_LANG.getUnicodeEnd();

        for (int i = 0; i < srcString.length(); i++) {
            char _char = srcString.charAt(i);
            int charUnicode = _char;

            if ((_char < 'a' || _char > 'z') && (_char < 'A' || _char > 'Z') && (_char < '0' || _char > '9') && (charUnicode < unicodeStart || charUnicode > unicodeEnd)) {


                if (GWorld.__SERVER_LANG != XLang.VN || _char != ' ') {


                    return true;
                }
            }
        }
        return false;
    }

    public static String replaceBlackString(String srcString) {
        return getScaner().replaceSensitiveWord(srcString, false);
    }


    public static String replaceBlackString(String srcString, boolean ignoreCode) {
        return getScaner().replaceSensitiveWord(srcString, ignoreCode);
    }

    public static boolean isNumberString(String str) {
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}


