
package com.github.framework.core.common.base;

import com.github.framework.core.common.annotaion.Metadata;
import lombok.Data;

/** 
 * @ClassName: BusinessNoDTO 
 *
 *  
 */
@Data
public class BusinessNoDTO {
    @Metadata(value = "业务编号", comments = "业务编号")
    private String businessNo;

    @Metadata(value = "业务版本号", comments = "业务版本号")
    private Integer version;
}
