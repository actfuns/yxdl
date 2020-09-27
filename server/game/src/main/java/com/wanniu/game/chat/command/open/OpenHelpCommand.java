package com.wanniu.game.chat.command.open;

import com.wanniu.game.chat.command.AbsCommand;
import com.wanniu.game.chat.command.Command;


@Command({"@gm open ?", "@gm open help"})
public class OpenHelpCommand
        extends AbsCommand {
    public String help() {
        return "@gm open [月卡|尊享卡]";
    }
}


