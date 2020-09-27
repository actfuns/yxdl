package com.wanniu.game.data.ext;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.ClassUtil;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.data.AffixCO;
import com.wanniu.game.data.base.FourProp;
import com.wanniu.game.player.AttributeUtil;

import java.util.HashMap;
import java.util.Map;


public class AffixExt
        extends AffixCO {
    public Map<Integer, FourProp> props;
    public String attName;

    public int getKey() {
        return super.getKey();
    }


    public void initProperty() {
        this.props = new HashMap<>();

        try {
            for (int i = 0; i < 5; i++) {
                String propName = (String) ClassUtil.getProperty(this, "prop" + i);
                if (StringUtil.isNotEmpty(propName)) {


                    FourProp _prop = new FourProp(AttributeUtil.getKeyByName(propName), ((Integer) ClassUtil.getProperty(this, "par" + i)).intValue(), ((Integer) ClassUtil.getProperty(this, "min" + i)).intValue(), ((Integer) ClassUtil.getProperty(this, "max" + i)).intValue());
                    this.props.put(Integer.valueOf(i), _prop);
                    if (!StringUtil.isEmpty(_prop.prop)) {
                        this.attName = _prop.prop;
                    }
                }
            }
        } catch (Exception e) {
            Out.error(new Object[]{e});
        }
    }
}


