package com.fy.util;

import java.util.List;

/**
 * @author: fy
 * @create: 2022-03-24 18:10
 **/
public class Page<T> {
    private int total; // 总条数
    private int page; // 当前页
    private int size; // 每页数:每页的行数
    private List<T> rows; // 结果集：每页需要显示的数据的集合

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
