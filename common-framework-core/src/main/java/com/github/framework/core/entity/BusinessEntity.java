package com.github.framework.core.entity;

import java.time.LocalDateTime;

/**
 * @ClassName BusinessEntity
 * @Description 业务实体标准结构接口，定义每个业务实体的隐含字段
 *
 */
public interface BusinessEntity extends Entity {
    /** 
     * 返回业务编号
     * @return the businessNo  
     */
    public String getBusinessNo();

    /** 
     * 设置业务编号
     * @param businessNo the businessNo to set  
     */
    public void setBusinessNo(final String businessNo);

    /** 
     * 返回业务版本号
     * @return the businessVersion  
     */
    public Integer getBusinessVersion();

    /** 
     * 设置业务版本号
     * @param businessVersion the businessVersion to set  
     */
    public void setBusinessVersion(final Integer businessVersion);

    /** 
     * 返回业务状态
     * @return the businessStatus  
     */
    public String getBusinessStatus();

    /** 
     * 设置业务状态
     * @param businessStatus the businessStatus to set  
     */
    public void setBusinessStatus(final String businessStatus);

    /** 
     * 返回过期时间
     * @return the gmtExpired  
     */
    public LocalDateTime getGmtExpired();

    /** 
     * 设置过期时间
     * @param gmtExpired the gmtExpired to set  
     */
    public void setGmtExpired(final LocalDateTime gmtExpired);

}
