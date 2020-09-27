package com.wanniu.game.data.ext;

import com.wanniu.game.data.BloodSuitListCO;

import java.util.LinkedList;
import java.util.List;


public class BloodSuitListExt
        extends BloodSuitListCO {
    public List<Integer> partIdList;
    public List<Integer> occupationProIds;

    public void initProperty() {
        this.partIdList = new LinkedList<>();
        this.occupationProIds = new LinkedList<>();

        String[] partCodeListStrs = this.partCodeList.split(",");
        for (String partCodeListItem : partCodeListStrs) {
            this.partIdList.add(Integer.valueOf(Integer.parseInt(partCodeListItem)));
        }

        String[] occupationStrs = this.occupation.split(",");
        for (String occupationItem : occupationStrs)
            this.occupationProIds.add(Integer.valueOf(Integer.parseInt(occupationItem)));
    }
}


