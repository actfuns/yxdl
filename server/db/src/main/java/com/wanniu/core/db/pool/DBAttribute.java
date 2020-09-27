package com.wanniu.core.db.pool;

import com.wanniu.core.util.xml.XW3CParsable;
import org.w3c.dom.Node;


public final class DBAttribute
        implements XW3CParsable {
    private static final long CHECK_INTERVAL = 300000L;
    private String dsName;
    private String driver;
    private String url;
    private String username;
    private String password;
    private int minConnection = 2;

    private int maxConnection = 30;

    private long timeout = 300000L;

    private int waitTime = 10000;

    private boolean checkAble = true;

    private long checkInterval = 300000L;

    public String getDriver() {
        return this.driver;
    }

    public int getMaxConnection() {
        return this.maxConnection;
    }

    public int getMinConnection() {
        return this.minConnection;
    }

    public String getPassword() {
        return this.password;
    }

    public long getTimeout() {
        return this.timeout;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUserName() {
        return this.username;
    }

    public int getWaitTime() {
        return this.waitTime;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setMaxConnection(int maxConnection) {
        this.maxConnection = maxConnection;
    }

    public void setMinConnection(int minConnection) {
        this.minConnection = (minConnection < 0) ? 0 : minConnection;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTimeoutValue(long timeoutValue) {
        this.timeout = timeoutValue;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public String getDsName() {
        return this.dsName;
    }

    public void setDsName(String dsName) {
        this.dsName = dsName;
    }

    public long getCheckInterval() {
        return this.checkInterval;
    }

    public boolean isCheckAble() {
        return this.checkAble;
    }

    public boolean parse(Node xmlBean) {
        if (xmlBean.getNodeName().equals("pool")) {
            for (Node node = xmlBean.getFirstChild(); node != null; node = node.getNextSibling()) {
                if (node.getNodeType() == 1) {
                    String nodeName = node.getNodeName().intern();
                    if (nodeName.equals("dsname")) {
                        this.dsName = node.getTextContent();
                    } else if (nodeName.equals("driver")) {
                        this.driver = node.getTextContent();
                    } else if (nodeName.equals("url")) {
                        this.url = node.getTextContent();
                    } else if (nodeName.equals("username")) {
                        this.username = node.getTextContent();
                    } else if (nodeName.equals("password")) {
                        this.password = node.getTextContent();
                    } else if (nodeName.equals("minconn")) {
                        this.minConnection = Integer.parseInt(node.getTextContent());
                    } else if (nodeName.equals("maxconn")) {
                        this.maxConnection = Integer.parseInt(node.getTextContent());
                    } else if (nodeName.equals("timeout")) {
                        this.timeout = Long.parseLong(node.getTextContent());
                    } else if (nodeName.equals("waittime")) {
                        this.waitTime = Integer.parseInt(node.getTextContent());
                    } else if (nodeName.equals("checkable")) {
                        this.checkAble = Boolean.parseBoolean(node.getTextContent());
                    } else if (nodeName.equals("checkinterval")) {
                        this.checkInterval = Long.parseLong(node.getTextContent());
                    }
                }
            }

            return true;
        }
        return false;
    }
}


