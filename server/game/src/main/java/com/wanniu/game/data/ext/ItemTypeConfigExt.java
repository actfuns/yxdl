package com.wanniu.game.data.ext;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.ClassUtil;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.data.ItemTypeConfigCO;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class ItemTypeConfigExt
        extends ItemTypeConfigCO {
    public List<String> subTypes;

    public void beforeProperty() {
        this.subTypes = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            Field f_sub_type = ClassUtil.getDeclaredField(this, "subType" + i);
            try {
                Object subType = f_sub_type.get(this);
                if (subType != null && StringUtil.isNotEmpty(subType.toString())) {
                    this.subTypes.add(subType.toString());
                }
            } catch (Exception e) {
                Out.error(new Object[]{e});
            }
        }
    }


    public int getKey() {
        return this.iD;
    }
}


