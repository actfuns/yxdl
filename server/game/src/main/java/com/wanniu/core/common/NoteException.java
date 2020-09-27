package com.wanniu.core.common;

import java.io.Serializable;


public class NoteException
        extends Exception
        implements Serializable {
    private static final long serialVersionUID = 1L;
    public String reason;

    public NoteException() {
    }

    public NoteException(String reason) {
        this.reason = reason;
    }
}


