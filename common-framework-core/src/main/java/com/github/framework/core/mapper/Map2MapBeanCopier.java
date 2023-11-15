
package com.github.framework.core.mapper;

import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

import java.util.Map;

/**
 * @ClassName Map2MapBeanCopier
 * @Description TODO
 */
public class Map2MapBeanCopier extends BeanCopier {

    @Override
    public void copy(Object o, Object o1, Converter converter) {
        boolean isMap = o instanceof Map && o1 instanceof Map;
        if (isMap) {
            Map m1 = ((Map)o);
            Map m2 = ((Map)o1);
            m2.putAll(m1);
        }
    }
}
