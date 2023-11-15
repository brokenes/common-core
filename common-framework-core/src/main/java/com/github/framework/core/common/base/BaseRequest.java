package com.github.framework.core.common.base;

import lombok.*;

import java.io.Serializable;


@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseRequest implements Serializable {


    private Integer pageNo = 1;

    private Integer pageSize = 10;

    private String orderByColumn;

    private String asc;

    private String startDate;

    private String endDate;

    private Long createBy;

    private Long updateBy;

    private String remark;



}
