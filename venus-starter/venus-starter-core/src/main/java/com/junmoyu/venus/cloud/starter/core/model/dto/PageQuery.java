package com.junmoyu.venus.cloud.starter.core.model.dto;

import com.junmoyu.venus.cloud.starter.core.util.SqlUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 分页查询请求参数
 *
 * @author moyu.jun
 * @date 2021/12/18
 */
public class PageQuery extends Query {

    private static final long serialVersionUID = 1L;

    public static final String ASC = "ASC";

    public static final String DESC = "DESC";

    private static final int DEFAULT_PAGE_SIZE = 10;

    private static final int MAX_PAGE_SIZE = 100;

    private int pageSize = DEFAULT_PAGE_SIZE;

    private int pageNum;

    private String orderBy;

    private String orderDirection = DESC;

    private String groupBy;

    private boolean needTotalCount = true;

    public PageQuery() {
    }

    public int getPageNum() {
        if (pageNum < 1) {
            return 1;
        }
        return pageNum;
    }

    public PageQuery setPageNum(int pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public int getPageSize() {
        if (pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        if (pageSize > MAX_PAGE_SIZE) {
            pageSize = MAX_PAGE_SIZE;
        }
        return pageSize;
    }

    public PageQuery setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public int getOffset() {
        return (getPageNum() - 1) * getPageSize();
    }

    public String getOrderBy() {
        if (StringUtils.isBlank(orderBy)) {
            return orderBy;
        }
        if (!SqlUtils.isValidOrderBySql(orderBy)) {
            // orderBy 有 SQL 注入风险
            orderBy = null;
        }
        return orderBy;
    }

    public PageQuery setOrderBy(String orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public String getOrderDirection() {
        return orderDirection;
    }

    public PageQuery setOrderDirection(String orderDirection) {
        if (ASC.equalsIgnoreCase(orderDirection) || DESC.equalsIgnoreCase(orderDirection)) {
            this.orderDirection = orderDirection;
        }
        return this;
    }

    public String getGroupBy() {
        if (StringUtils.isBlank(groupBy)) {
            return groupBy;
        }
        if (!SqlUtils.isValidOrderBySql(groupBy)) {
            // groupBy 有 SQL 注入风险
            groupBy = null;
        }
        return groupBy;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }

    public boolean isNeedTotalCount() {
        return needTotalCount;
    }

    public void setNeedTotalCount(boolean needTotalCount) {
        this.needTotalCount = needTotalCount;
    }
}
