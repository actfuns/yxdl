package com.wanniu.game.data.ext;

import com.wanniu.game.data.PetAssociateCO;

import java.util.HashMap;
import java.util.Map;


public class PetAssociateExt
        extends PetAssociateCO {
    public Map<Integer, Integer> petIDMap = new HashMap<>();

    public Map<Integer, Integer> addProMap = new HashMap<>();


    public void initProperty() {
        String[] petIDStrs = this.petID.split(";");
        for (String petIDStr : petIDStrs) {
            String[] subPetIDStr = petIDStr.split(":");
            this.petIDMap.put(Integer.valueOf(Integer.parseInt(subPetIDStr[0])), Integer.valueOf(Integer.parseInt(subPetIDStr[1])));
        }

        String[] addProStrs = this.addPro.split(";");
        for (String addProStr : addProStrs) {
            String[] subAddProStr = addProStr.split(":");
            this.addProMap.put(Integer.valueOf(Integer.parseInt(subAddProStr[0])), Integer.valueOf(Integer.parseInt(subAddProStr[1])));
        }
    }
}


