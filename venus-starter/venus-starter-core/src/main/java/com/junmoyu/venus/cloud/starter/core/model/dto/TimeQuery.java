package com.junmoyu.venus.cloud.starter.core.model.dto;

import java.util.Date;

/**
 * 带时间的查询条件
 *
 * @author moyu.jun
 * @date 2021/12/18
 */
public class TimeQuery extends Query {

    private static final long serialVersionUID = 1L;

    /**
     * 查询开始时间
     */
    private Date queryStartTime;

    /**
     * 查询结束时间
     */
    private Date queryEndTime;

    public TimeQuery() {
    }

    public TimeQuery(Date queryStartTime, Date queryEndTime) {
        this.queryStartTime = queryStartTime;
        this.queryEndTime = queryEndTime;
    }

    public Date getQueryStartTime() {
        return queryStartTime;
    }

    public void setQueryStartTime(Date queryStartTime) {
        this.queryStartTime = queryStartTime;
    }

    public Date getQueryEndTime() {
        return queryEndTime;
    }

    public void setQueryEndTime(Date queryEndTime) {
        this.queryEndTime = queryEndTime;
    }

    @Override
    public String toString() {
        return "TimeQuery{" +
                "queryStartTime=" + queryStartTime +
                ", queryEndTime=" + queryEndTime +
                '}';
    }
}
