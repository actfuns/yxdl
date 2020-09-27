package com.wanniu.game.chat.command.test;

import com.wanniu.game.chat.command.AbsCommand;
import com.wanniu.game.chat.command.Command;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.AchievementDataPO;


@Command({"@gm test armour"})
public class TestArmourCommand
        extends AbsCommand {
    public String help() {
        return "@gm test armour <id>\t 测试激活元始圣甲命令";
    }


    protected String exec(WNPlayer player, String... args) {
        Integer holyArmourId = Integer.valueOf(Integer.parseInt(args[3]));
        AchievementDataPO.HolyArmour holyArmour = (AchievementDataPO.HolyArmour) player.achievementManager.achievementDataPO.holyArmourMap.get(holyArmourId);
        if (holyArmour == null) {
            return "ID未找到";
        }
        if (holyArmour.states == 1) {
            holyArmour.states = 2;
        }
        player.achievementManager.activateHolyArmour(holyArmourId.intValue());
        return "OK";
    }
}


