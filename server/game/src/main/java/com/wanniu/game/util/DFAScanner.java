package com.wanniu.game.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public final class DFAScanner {
    private static final char SBC_CHAR_START = '！';
    private static final char SBC_CHAR_END = '～';
    private static final int CONVERT_STEP = 65248;
    private static final char SBC_SPACE = '　';
    private static final char DBC_SPACE = ' ';
    private final Set<Integer> separatesSymbols = new HashSet<>();
    private final Map<Integer, DFANode> nodes = new HashMap<>();


    public DFAScanner(List<String> sensitivewords) {
        this(" `~!1@2#3$4%5^6&7*8(9)0_-+={[}]|\\:;\"'<,>.?/！￥%……｛｝【】", sensitivewords);
    }


    public DFAScanner(String symbols, List<String> sensitivewords) {
        initSeparatesSymbol(symbols);
        initSensitiveWords(sensitivewords);
    }


    private void initSensitiveWords(List<String> sensitivewords) {
        if (!sensitivewords.isEmpty()) {


            for (String curr : sensitivewords) {
                DFANode fnode;
                char[] chs = curr.toCharArray();
                int fchar = charConvert(chs[0]);
                if (!this.nodes.containsKey(Integer.valueOf(fchar))) {
                    fnode = new DFANode(fchar, (chs.length == 1));
                    this.nodes.put(Integer.valueOf(fchar), fnode);
                } else {
                    fnode = this.nodes.get(Integer.valueOf(fchar));
                    if (!fnode.isLast() && chs.length == 1)
                        fnode.setLast(true);
                }
                int lastIndex = chs.length - 1;
                for (int i = 1; i < chs.length; i++) {
                    fnode = fnode.addIfNoExist(charConvert(chs[i]), (i == lastIndex));
                }
            }
        }
    }


    private void initSeparatesSymbol(String symbols) {
        for (int i = 0, len = symbols.length(); i < len; i++) {
            this.separatesSymbols.add(Integer.valueOf(charConvert(symbols.charAt(i))));
        }
    }


    private int qj2bj(char src) {
        int r = src;
        if (src >= '！' && src <= '～') {
            r = src - 65248;
        } else if (src == '　') {
            r = 32;
        }
        return r;
    }


    private int charConvert(char src) {
        int r = qj2bj(src);
        return (r >= 65 && r <= 90) ? (r + 32) : r;
    }


    public boolean findSensitiveWord(String text) {
        char[] chs = text.toCharArray();
        for (int i = 0, length = chs.length; i < length; i++) {
            int currc = charConvert(chs[i]);

            DFANode node = this.nodes.get(Integer.valueOf(currc));

            if (node != null) {


                boolean couldMark = false;
                if (node.isLast()) {
                    couldMark = true;
                }
                int cpcurrc = currc;
                for (int k = i; ++k < length; ) {
                    int temp = charConvert(chs[k]);
                    if (temp == cpcurrc)
                        continue;
                    if (this.separatesSymbols.contains(Integer.valueOf(temp)))
                        continue;
                    node = node.querySub(temp);
                    if (node == null) {
                        break;
                    }
                    if (node.isLast()) {
                        couldMark = true;
                        break;
                    }
                    cpcurrc = temp;
                }
                if (couldMark)
                    return true;
            }
        }
        return false;
    }


    public String replaceSensitiveWord(String text, boolean ignoreCode) {
        char[] chs = text.toCharArray();
        boolean flag = false;
        boolean startIgnore = false;
        for (int i = 0, length = chs.length; i < length; i++) {
            if (ignoreCode && chs[i] == '>') {
                startIgnore = false;

            } else if (!startIgnore) {


                if (ignoreCode && chs[i] == '<') {
                    startIgnore = true;
                } else {

                    int currc = charConvert(chs[i]);
                    DFANode node = this.nodes.get(Integer.valueOf(currc));
                    if (node != null) {

                        int markNum = -1;
                        boolean couldMark = false;
                        if (node.isLast()) {
                            couldMark = true;
                            markNum = 0;
                        }


                        int cpcurrc = currc;
                        int k;
                        for (k = i; ++k < length; ) {
                            int temp = charConvert(chs[k]);
                            if (temp == cpcurrc)
                                continue;
                            if (this.separatesSymbols.contains(Integer.valueOf(temp)))
                                continue;
                            node = node.querySub(temp);
                            if (node == null)
                                break;
                            if (node.isLast()) {
                                couldMark = true;
                                markNum = k - i;
                                break;
                            }
                            cpcurrc = temp;
                        }
                        if (couldMark) {
                            for (k = 0; k <= markNum; k++) {
                                chs[k + i] = '*';
                            }
                            i += markNum;
                            flag = true;
                        }
                    }
                }
            }
        }
        return flag ? new String(chs) : text;
    }
}


