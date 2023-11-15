package com.github.framework.core.common.base;


import com.github.framework.core.IEnum;

/**
 * @ClassName DataStatus
 * @Description 数据状态
 *
 */
public enum DataStatus implements IEnum<String> {
    /**
     * 数据状态：草稿，此状态下的数据可以任务编辑和删除等行为
     */
    DRAFT("draft","草稿"),

    /**
     * 数据状态：正常，表示此数据审核过，不能随意编辑和删除
     */
    NORMAL("normal","正常"),

    /**
     * 数据状态：废弃，在草稿和正常状态下删除后为废弃状态
     */
    DISCARD("discard","废弃"),

    /**
     * 数据状态：冻结，在正常状态下对某条数据作冻结，被冻结的纪录为暂时无效但并非永久无效
     */
    FREEZE("freezed","冻结"),
    ;

    String value;
    String named;

    DataStatus(String value,String named) {
        this.value = value;
        this.named = named;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public String named() {
        return named;
    }
}
