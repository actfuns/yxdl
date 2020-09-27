package com.wanniu.game.data.ext;

import com.wanniu.game.data.PetConfigCO;

public class PetConfigExt
        extends PetConfigCO {
    public int intValue = 0;

    public void initProperty() {
        if (this.paramType.trim().equals("NUMBER"))
            this.intValue = Integer.parseInt(this.paramValue);
    }
}


