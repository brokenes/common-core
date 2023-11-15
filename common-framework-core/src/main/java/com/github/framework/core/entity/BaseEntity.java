package com.github.framework.core.entity;

import lombok.*;

import java.util.Date;

/** 
 * @ClassName: EntityImpl 
 * @Description: 基础实体实现类 
 *
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity implements Entity {

    /**
     * id
     */
    private Long id;

    private Date createDate;

    private Date updateDate;

    private Long createBy;

    private Long updateBy;

    private String remark;



}
