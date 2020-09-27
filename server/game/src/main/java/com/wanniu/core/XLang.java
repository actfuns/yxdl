package com.wanniu.core;


public enum XLang {
    CN(19968, 40869, 6),


    VN(7680, 7935, 15);

    private final int unicodeStart;
    private final int unicodeEnd;
    private final int nameLimit;

    XLang(int unicodeStart, int unicodeEnd, int nameLimit) {
        this.unicodeStart = unicodeStart;
        this.unicodeEnd = unicodeEnd;
        this.nameLimit = nameLimit;
    }

    public int getUnicodeStart() {
        return this.unicodeStart;
    }

    public int getUnicodeEnd() {
        return this.unicodeEnd;
    }

    public int getNameLimit() {
        return this.nameLimit;
    }
}


