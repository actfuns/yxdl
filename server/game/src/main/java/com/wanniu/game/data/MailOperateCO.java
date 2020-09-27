package com.wanniu.game.data;


public class MailOperateCO {
    public int mailId;
    public int mailType;
    public int server;
    public int channel;
    public String accept;
    public int level;
    public int vipLevel;
    public String mailSender;
    public String sendDay;
    public String mailTitle;
    public String mailText;
    public String mailAttach;
    public String startTime;
    public String endTime;
    public String deleteTime;
    public int mailRead;

    public int getKey() {
        return this.mailId;
    }

    public void initProperty() {
    }

    public void beforeProperty() {
    }
}


