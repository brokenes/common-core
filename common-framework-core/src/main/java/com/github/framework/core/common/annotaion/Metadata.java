package com.github.framework.core.common.annotaion;

import java.lang.annotation.*;

/**
 * 用于注解类或属性的元数据，这些元数据可用于代码生成或运行时动态内容生成
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PACKAGE })
public @interface Metadata {

    /**
     * 简要注解说明：一般对应表单项Label属性显示
     */
    String value();

    /**
     * 注释说明：用于描述代码内部用法说明，一般不用于前端UI显示
     */
    String comments() default "";

    /**
     * 数据长度
     */
    int length() default 255;

    /**
     * 数据精度
     */
    int precision() default 0;

    /**
     * 数据小数位
     */
    int scale() default 0;

    /**
     * 是否允许插入；例如：version, created, modified都不允许插入
     */
    boolean insertable() default true;

    /**
     * 是否允许修改；例如：id version, created, modified都不允许修改
     */
    boolean updatable() default true;

    /**
     * 是否是主键；例如:id是主键
     */
    boolean primaryKey() default false;

    /**
     *最小值 
     */
    long minValue() default 0;

    /**
     *最大值 
     */
    long maxValue() default 0;

    /**
     *数据匹配模式 
     */
    String patten() default "";

    /**
     *数据验证工具 
     */
    String validator() default "";
}