
package com.github.framework.core.mapper;

import com.esotericsoftware.reflectasm.ConstructorAccess;
import com.github.framework.core.collection.CustomMap;
import com.github.framework.core.exception.Ex;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.String.format;

/**
 * 代码来自网上：https://russxia.github.io/2018/07/17/Java%E4%B8%AD%E5%87%A0%E7%A7%8D-%E5%B1%9E%E6%80%A7copy%E5%B7%A5%E5%85%B7%E6%AF%94%E8%BE%83.html
 *
 * @ClassName Beans
 * @Description 基于cglib的bean快速copy工具
 */
public class Beans {

    private static final int MAX_CACHE_SIZE = 1000;

    /**
     * cached BeanCopier
     */
    private static final Map<String, BeanCopier>               beanCopierCache = new ConcurrentHashMap<>();

    /**
     * cached ConstructorAccess
     */
    private static final Map<String, ConstructorAccess> constructorAccessCache = new ConcurrentHashMap<>();

    /**
     * Bean属性值copy
     * @param source 源bean
     * @param target 目标bean
     */
    public static void copy(Object source, Object target) {
        if (source == null || target == null) {
            return;
        }
        BeanCopier copier = getBeanCopier(source.getClass(), target.getClass());
        copier.copy(source, target, null);
    }

    /**
     * Bean属性值copy
     * @param source
     * @param targetClass
     * @param <T>
     * @return
     */
    public static <T> T copy(Object source, Class<T> targetClass) {
        if (source == null) {return null;}
        T t ;
        try {
            if (targetClass == Map.class) {
                t = (T) CustomMap.hashmap();
            } else {
                ConstructorAccess<T> constructorAccess = getConstructorAccess(targetClass);
                t = constructorAccess.newInstance();
            }
        } catch (RuntimeException e) {
            try {
                t = targetClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e1) {
                throw new RuntimeException(format("Create new instance of %s failed: %s", targetClass, e.getMessage()));
            }
        }
        copy(source, t);
        return t;
    }

    /**
     * list copy，跟bean属性相同，不过是copy整个集合而已
     * @param sourceList 源集合
     * @param targetClass 目标类型
     * @param <T>
     * @return
     */
    public static <T> List<T> copyList(List<?> sourceList, Class<T> targetClass) {
        if (sourceList == null || sourceList.isEmpty()) {
            return Collections.emptyList();
        }
        ConstructorAccess<T> constructorAccess = getConstructorAccess(targetClass);
        List<T> resultList = new ArrayList<>(sourceList.size());
        for (Object o : sourceList) {
            T t = null;
            try {
                t = constructorAccess.newInstance();
                copy(o, t);
                resultList.add(t);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return resultList;
    }


    private static String generateKey(Class<?> class1, Class<?> class2) {
        return class1.getName().concat("|").concat(class2.getName());
    }

    private static BeanCopier getBeanCopier(Class sourceClass, Class targetClass) {

        if (Map.class.isAssignableFrom(sourceClass) && Map.class.isAssignableFrom(targetClass)) {
            return new Map2MapBeanCopier();
        }

        if (!Map.class.isAssignableFrom(sourceClass) && Map.class.isAssignableFrom(targetClass)) {
            return new Bean2MapBeanCopier();
        }

        if (Map.class.isAssignableFrom(sourceClass) && !Map.class.isAssignableFrom(targetClass)) {
            return new Bean2MapBeanCopier();
        }

        String beanKey = generateKey(sourceClass, targetClass);
        BeanCopier copier = null;
        if (!beanCopierCache.containsKey(beanKey)) {
            copier = BeanCopier.create(sourceClass, targetClass, false);
            if (beanCopierCache.size() > MAX_CACHE_SIZE) {
                beanCopierCache.clear();
            }
            beanCopierCache.put(beanKey, copier);
        } else {
            copier = beanCopierCache.get(beanKey);
        }
        return copier;
    }
 

    private static <T> ConstructorAccess<T> getConstructorAccess(Class<T> targetClass) {
        ConstructorAccess<T> constructorAccess = constructorAccessCache.get(targetClass.getName());
        if(constructorAccess != null) {
            return constructorAccess;
        }
        try {
            constructorAccess = ConstructorAccess.get(targetClass);
            if (constructorAccessCache.size() > MAX_CACHE_SIZE) {
                constructorAccessCache.clear();
            }

            constructorAccessCache.put(targetClass.getName(),constructorAccess);
        } catch (Exception e) {
            throw Ex.systemError("Create new instance of %s failed: %s", targetClass, e.getMessage());
        }
        return constructorAccess;
    }



}