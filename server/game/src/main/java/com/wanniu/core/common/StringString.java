package com.wanniu.core.common;

import java.io.Serializable;

public class StringString
        implements Serializable {
    private static final long serialVersionUID = 1L;
    public String key;
    public String value;

    public StringString() {
    }

    public StringString(String key, String value) {
        this.key = key;
        this.value = value;
    }
}


