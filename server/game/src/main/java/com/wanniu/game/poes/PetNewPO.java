package com.wanniu.game.poes;

import com.wanniu.game.DBField;
import com.wanniu.game.petNew.PetSkill;
import java.util.HashMap;

public class PetNewPO {
  @DBField(isPKey = true, fieldType = "int")
  public int id;
  
  public String name;
  
  public int level;
  
  public long exp;
  
  public int upLevel;
  
  public int fightPower;
  
  public HashMap<Integer, PetSkill> skills;
  
  public HashMap<Integer, PetSkill> passiveSkills;
}


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\PetNewPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */