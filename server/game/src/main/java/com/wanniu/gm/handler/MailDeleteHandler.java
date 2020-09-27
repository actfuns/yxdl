package com.wanniu.gm.handler;

import com.alibaba.fastjson.JSONArray;
import com.wanniu.game.mail.MailCenter;
import com.wanniu.gm.GMEvent;
import com.wanniu.gm.GMResponse;
import com.wanniu.gm.GMStateResponse;


@GMEvent
public class MailDeleteHandler
        extends GMBaseHandler {
    public GMResponse execute(JSONArray arr) {
        String mailId = arr.getString(0);
        MailCenter.getInstance().removeServerMail(mailId);
        return (GMResponse) new GMStateResponse(1);
    }

    public short getType() {
        return 4578;
    }
}


