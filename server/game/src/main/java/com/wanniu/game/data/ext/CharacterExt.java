package com.wanniu.game.data.ext;

import com.wanniu.core.util.StringUtil;
import com.wanniu.game.data.CharacterCO;

import java.util.ArrayList;
import java.util.List;


public class CharacterExt
        extends CharacterCO {
    public List<InitItem> initItems;
    public List<InitSkill> initSkills;
    public List<String> initEquips;

    public void initProperty() {
        this.initItems = new ArrayList<>();
        if (StringUtil.isNotEmpty(this.initItem)) {
            String[] itemStrs = this.initItem.split("\\|");
            for (String itemStr : itemStrs) {
                if (StringUtil.isNotEmpty(itemStr)) {
                    String[] item = itemStr.split(":");
                    this.initItems.add(new InitItem(item[0], Integer.valueOf(item[1]).intValue()));
                }
            }
        }

        this.initSkills = new ArrayList<>();
        if (StringUtil.isNotEmpty(this.initSkill)) {
            String[] skillStrs = this.initSkill.split("\\|");
            int index = 0;
            for (String skillStr : skillStrs) {
                if (StringUtil.isNotEmpty(skillStr)) {
                    String[] skill = skillStr.split(":");
                    if (skill.length > 1) {


                        this.initSkills.add(new InitSkill(Integer.parseInt(skill[0]), Integer.parseInt(skill[1]), index));
                        index++;
                    }
                }
            }
        }


        this.initEquips = new ArrayList<>();
        if (StringUtil.isNotEmpty(this.initEquip)) {
            String[] equips = this.initEquip.split("\\|");
            for (String equip : equips) {
                if (StringUtil.isNotEmpty(equip)) {
                    this.initEquips.add(equip);
                }
            }
        }
    }

    public class InitItem {
        public String itemCode;
        public int itemNum;

        public InitItem(String itemCode, int itemNum) {
            this.itemCode = itemCode;
            this.itemNum = itemNum;
        }
    }


    public class InitSkill {
        public int id;

        public int level;

        public int pos;


        public InitSkill(int id, int level, int pos) {
            this.id = id;
            this.level = level;
            this.pos = pos;
        }
    }
}


