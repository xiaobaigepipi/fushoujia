package com.lxh.fushoujia.pojo;

/**
 * @program: fushoujia
 * @description: 分页
 * @author: Mr.Wang
 * @create: 2019-10-20 18:17
 **/

public class Page {
    private int start;
    private int count;
    private int total;
    private String searchKey;

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
