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


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\chat\ChatShowItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */