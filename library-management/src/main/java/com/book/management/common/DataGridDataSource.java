package com.book.management.common;

import lombok.Data;

import java.util.List;

/**
 * 数据源
 * @param <T>
 */
//@Data //注解@Data可以省略get、set方法
public class DataGridDataSource<T> {

    //总条数
    private int total;

    //显示的条数
    private List<T> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
