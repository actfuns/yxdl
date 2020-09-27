package com.wanniu.game.chat.command.test;

import com.wanniu.core.util.FileUtil;
import com.wanniu.game.chat.command.AbsCommand;
import com.wanniu.game.chat.command.Command;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.base.DEquipBase;
import com.wanniu.game.data.base.DItemBase;
import com.wanniu.game.item.ItemConfig;
import com.wanniu.game.player.WNPlayer;

import java.io.File;
import java.util.HashSet;
import java.util.Set;


@Command({"@gm test automation"})
public class TestAutomationCommand
        extends AbsCommand {
    public String help() {
        return "@gm test automation\t\t生成后台所需的命令";
    }


    protected String exec(WNPlayer player, String... args) {
        genItemTemplateLog();
        genFuncTemplateLog();

        return "OK";
    }

    private void genFuncTemplateLog() {
        Set<Integer> test = new HashSet<>();
        StringBuilder sb = new StringBuilder(2048);
        for (Const.GOODS_CHANGE_TYPE type : Const.GOODS_CHANGE_TYPE.values()) {
            if (test.contains(Integer.valueOf(type.value))) {
                throw new RuntimeException("来源有重复的ID：" + type.value);
            }
            test.add(Integer.valueOf(type.value));
            sb.append("i18n.func.code." + type.value + "=" + type.getDesc() + "\n");
        }
        FileUtil.write(new File("E:\\mmoarpg\\platform-gm\\src\\main\\resources\\template-func.properties"), sb.toString());
    }

    private void genItemTemplateLog() {
        StringBuilder sb = new StringBuilder(2048);
        for (DItemBase it : ItemConfig.getInstance().getItemTemplates().values()) {
            sb.append("i18n.item." + it.code + "=" + it.name + "\n");
        }
        for (DEquipBase it : ItemConfig.getInstance().getEquipTemplates().values()) {
            sb.append("i18n.item." + it.code + "=" + it.name + "\n");
        }
        FileUtil.write(new File("E:\\mmoarpg\\platform-gm\\src\\main\\resources\\template-item.properties"), sb.toString());
    }
}


