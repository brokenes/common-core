package com.github.framework.core.common.base;

import com.github.framework.core.common.annotaion.Metadata;
import lombok.Data;

/** 
 * @ClassName: IdDTO 
 *
 *  
 */
@Data
public class IdDTO {
    @Metadata(value = "ID", comments = "ID")
    private Long id;
}
