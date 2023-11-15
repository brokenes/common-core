
package com.github.framework.core.mapper;

import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.cglib.core.Converter;

import java.util.Map;


public class Bean2MapBeanCopier extends BeanCopier {
    @Override
    public void copy(Object o, Object o1, Converter converter) {
        if (!(o instanceof Map) && o1 instanceof Map) {
            BeanMap beanMap = BeanMap.create(o);
            ((Map)o1).putAll(beanMap);
            return;
        }
        if (o instanceof Map && !(o1 instanceof Map)) {
            BeanMap beanMap = BeanMap.create(o1);
            beanMap.putAll(((Map)o));
        }
    }
}
