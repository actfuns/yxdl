package com.wanniu.csharp;

import com.wanniu.core.GGame;


public class CSharpNode {
    public String serverId;
    public String host;
    public int port;
    public int icePort = 3905;

    public String getNodeId() {
        return this.serverId + ":" + GGame.__SERVER_ID;
    }


    public CSharpNode() {
    }


    public CSharpNode(String serverId, String host, int port, int icePort) {
        this.serverId = serverId;
        this.host = host;
        this.port = port;
        this.icePort = icePort;
    }

    public String toString() {
        return this.serverId + " <-> " + this.host + ":" + this.port + ":" + this.icePort;
    }
}


