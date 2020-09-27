package com.wanniu.game.mail;

import com.wanniu.core.logfs.Out;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.MailOperateCO;

import java.util.Map;

public class MailConfig {
    private static MailConfig instance;
    private Map<Integer, MailOperateCO> opreateMailTable;

    public static MailConfig getInstance() {
        if (instance == null) {
            instance = new MailConfig();
        }
        return instance;
    }


    private MailConfig() {
        this.opreateMailTable = GameData.MailOperates;
    }


    public final MailOperateCO findDOperateMailByMailId(int mailId) {
        if (this.opreateMailTable.containsKey(Integer.valueOf(mailId))) {
            return this.opreateMailTable.get(Integer.valueOf(mailId));
        }
        Out.error(new Object[]{getClass().getName(), " : Can`t find MailOperate By mailId = ", Integer.valueOf(mailId)});
        return null;
    }
}


