package com.wanniu.game.chat.command.add;

import com.wanniu.game.chat.command.AbsCommand;
import com.wanniu.game.chat.command.Command;


@Command({"@gm add help", "@gm add ?"})
public class AddHelpCommand
        extends AbsCommand {
    public String help() {
        return "\n@gm add rmb <value>\t\t\t添加充值元宝命令\n@gm add money <value>\t\t添加绑定元宝命令\n@gm add gold <value>\t\t\t添加银两命令\n@gm add monster <id>\t\t\t添加怪物命令\n@gm add item <code> [num]\t添加道具命令\n@gm add petexp <petId> [exp]\t添加宠物经验命令\n@gm add auction \t\t\t\t添加竞拍物品命令\n@gm add level <value>\t\t添加等级命令\n";
    }
}


