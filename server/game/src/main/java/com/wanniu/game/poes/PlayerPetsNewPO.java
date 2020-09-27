package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;

import java.util.HashMap;
import java.util.Map;


@DBTable("player_pets")
public class PlayerPetsNewPO
        extends GEntity {
    public Map<Integer, PetNewPO> pets = new HashMap<>();

    public int fightPetId;
    public int pkModel = 1;
}


