package com.wanniu.core.db;

import com.wanniu.core.util.StringUtil;


public class QueryVo {
    private String table;
    private String conVal;
    public int type;

    public QueryVo(String tr, String conVal) {
        this.table = tr;
        this.conVal = conVal;
        this.type = StringUtil.isEmpty(conVal) ? 0 : 1;
    }


    public String getQueryTR() {
        return this.table;
    }


    public String getConVal() {
        return this.conVal;
    }
}


