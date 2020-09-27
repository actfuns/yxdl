package com.wanniu.core.common;

import java.io.Serializable;

public class IntIntPair
        implements Serializable {
    private static final long serialVersionUID = 1L;
    public int first;
    public int second;

    public IntIntPair() {
    }

    public IntIntPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}


