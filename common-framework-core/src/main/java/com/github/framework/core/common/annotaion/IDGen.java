
package com.github.framework.core.common.annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName IDGen
 * @Description IDGen 基于注解实现为实体注入ID功能
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface IDGen {
    /**
     * id 生成器类型
     * 如果指定为 IDGenType.LEAF，则必须指定name()
     * @return
     */
    IDGenType value();

    /**
     * id 生成器名称
     * @return
     */
    String name() default "";

}
