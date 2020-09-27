package com.wanniu.gm.handler;

import com.alibaba.fastjson.JSONArray;
import com.wanniu.gm.GMResponse;

public abstract class GMBaseHandler {
  public abstract GMResponse execute(JSONArray paramJSONArray);
  
  public abstract short getType();
}


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\handler\GMBaseHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */