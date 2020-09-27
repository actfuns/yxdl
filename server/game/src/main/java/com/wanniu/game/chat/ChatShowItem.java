package com.wanniu.game.chat;

public class ChatShowItem {
    public int MsgType;

    public ChatShowItemData data;

    public static class ChatShowItemData {
        public String Id;

        public String PlayerId;

        public int Quality;

        public String TemplateId;

        public int needQuery;
    }
}


