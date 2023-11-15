package com.github.framework.core.common.base;

import lombok.*;

import java.io.Serializable;

/**
 * @ClassName PagingQuery
 * @Description 查询参数基类接口
 *
 */
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public abstract class PagingQuery implements Serializable {


    private Integer pageNo = 1;

    private Integer pageSize = 10;

    /** 分组的字段 */
    private String groupBy;

    /** 排序的字段   */
    private String orderBy;

    /** 排序的方向 */
    private String order;

    /** 是否开启分页查询 */
    private boolean pageEnable;

    public PagingQuery() {
        this.pageEnable = true;
    }
}
