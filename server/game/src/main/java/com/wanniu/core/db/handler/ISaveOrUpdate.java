package com.wanniu.core.db.handler;

public interface ISaveOrUpdate {
    String getSaveSQL();

    Object[] getSaveParams();

    String getUpdateSQL();

    Object[] getUpdateParams();
}


