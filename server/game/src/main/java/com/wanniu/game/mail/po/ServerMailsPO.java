package com.wanniu.game.mail.po;

import com.wanniu.game.mail.data.MailGmData;

import java.util.concurrent.ConcurrentHashMap;

public class ServerMailsPO {
    public ConcurrentHashMap<String, MailGmData> serverMail = new ConcurrentHashMap<>();
}


