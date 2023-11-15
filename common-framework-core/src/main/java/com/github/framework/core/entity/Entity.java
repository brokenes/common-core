package com.github.framework.core.entity;

import java.util.Date;

/**
 * @ClassName Entity
 * @Description 实体标准结构接口，定义每个实体的隐含字段。
 *
 */
public interface Entity {

    public Long getId();

    public void setId(Long id);

    public Date getCreateDate();

    public void setCreateDate(Date createDate);

    public Date getUpdateDate();

    public void setUpdateDate(Date updateDate);

    public Long getCreateBy();

    public void setCreateBy(Long createBy);

    public Long getUpdateBy();

    public void setUpdateBy(Long updateBy);

    public String getRemark();

    public void setRemark(String remark);


}
