package com.github.framework.core.common.base;

import com.github.framework.core.common.annotaion.Metadata;
import lombok.Data;

import java.time.LocalDateTime;

/** 
 * @ClassName: BaseDTO 
 * @Description:
 *  
 */
@Data
public class BaseDTO implements java.io.Serializable, Cloneable {
    /** 
     * @Fields serialVersionUID : 
     */
    private static final long serialVersionUID = 3863673780206074875L;

    @Metadata(value = "ID", comments = "数据唯一标识", insertable = true, updatable = false, primaryKey = true)
    private Long id;

    @Metadata(value = "创建时间", comments = "数据的创建时间，不能编辑；由系统框架提供", insertable = false, updatable = false)
    private LocalDateTime createDate;

    @Metadata(value = "修改时间", comments = "数据的修改时间，不能编辑；由系统框架提供", insertable = false, updatable = false)
    private LocalDateTime updateDate;

    /**
     * 
     * @Title: cloneObj 
     * @Description: 浅clone
     * @return 
     * @throws 
     *
     */
    public Object cloneObj() {
        try {
            return super.clone();
        }
        catch (final CloneNotSupportedException e) {
            return null;
        }
    }
}
