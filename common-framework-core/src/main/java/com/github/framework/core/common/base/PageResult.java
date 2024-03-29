package com.github.framework.core.common.base;

import com.github.framework.core.page.DataPage;
import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> extends DataPage {



    public static <T> DataPage<T> of(Long totalCount,List<T> data) {
        PageResult<T> dataPage = new PageResult<>();
        dataPage.setDataList(data);
        dataPage.setTotalCount(totalCount);
        return dataPage;
    }
}
