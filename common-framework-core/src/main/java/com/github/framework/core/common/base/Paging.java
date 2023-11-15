package com.github.framework.core.common.base;

import com.github.framework.core.lang.Numbers;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * @ClassName Paging
 * @Description 分页信息基础类，定义分类查询的基本属性
 */
@Data
public class Paging implements Serializable {

    /**  默认页码为1 */
    public static final int DEFAULT_PAGE_NO = 1;

    /** 默认每页显示10条记录 */
    public static final int DEFAULT_PAGE_SIZE = 10;

    /** 页码 */
    protected Integer pageNum;

    /** 每页显示记录数 */
    protected Integer pageSize;

    /** 总记录数 */
    protected Long totalRows;

    /** 总页数 */
    protected Long totalPages;

    /**
     * 分页后的记录开始的地方 第一条记录是1
     */
    private Integer startRow;

    /**
     * 分页后的记录结束的地方
     */
    private Integer endRow;

    /**
     * 是否需要count
     * true-
     */
    private Boolean count;

    public Paging() {
        this.pageNum = DEFAULT_PAGE_NO;
        this.pageSize = DEFAULT_PAGE_SIZE;
        this.count = Boolean.TRUE;
    }

    /**
     * 开始行
     * @return
     */
    public Integer getStartRow() {
        int start = Objects.isNull(this.startRow) ? 0 : this.startRow;
        if (start == Numbers.INTEGER_ZERO) {
            start = (getPageNum() - 1) * getPageSize() + 1;
        }
        return start;
    }

    public Integer getEndRow() {
        int end = Objects.isNull(this.endRow) ? 0 : this.endRow;
        if (end == 0) {
            end = getPageNum() * getPageSize();
        }
        return end;
    }

    public Long getTotalPages() {
        if (totalPages == null) {
            calcTotalPage();
        }
        return totalPages;
    }

    public void calcTotalPage() {
        if (totalRows != null && pageSize != null) {
            if (totalRows <= pageSize) {
                totalPages = DEFAULT_TOTAL_PAGES;
            } else {
                totalPages = totalRows / pageSize + (((int) (totalRows % pageSize) > 0) ? 1 : 0);
            }
        }
    }

    private static long DEFAULT_TOTAL_PAGES = 1L;
}
