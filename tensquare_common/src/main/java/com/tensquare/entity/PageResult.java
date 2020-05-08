package com.tensquare.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Author : 闵波路三舅
 * @Date : 2020-05-06 21:08
 * @ClassName : PageResult
 * @Description : 封装分页查询结果
 */
public class PageResult<T> implements Serializable {

    private Long total;
    private List<T> rows;

    public PageResult() {
    }

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

}