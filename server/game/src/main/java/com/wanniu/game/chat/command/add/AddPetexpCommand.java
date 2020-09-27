package com.wanniu.game.chat.command.add;

import com.wanniu.game.chat.command.AbsCommand;
import com.wanniu.game.chat.command.Command;
import com.wanniu.game.player.WNPlayer;


@Command({"@gm add petexp"})
public class AddPetexpCommand
        extends AbsCommand {
    public String help() {
        return "@gm add petexp <petId> <exp>\t添加宠物经验命令";
    }


    protected String exec(WNPlayer player, String... args) {
        Integer petId = Integer.valueOf(1);
        if (args.length > 3) {
            petId = Integer.valueOf(Integer.parseInt(args[3]));
        }
        Integer exp = Integer.valueOf(1);
        if (args.length > 4) {
            exp = Integer.valueOf(Integer.parseInt(args[4]));
        }

        player.petNewManager.addExp(petId.intValue(), exp.intValue());
        return "已成功添加" + exp + "经验";
    }
}


