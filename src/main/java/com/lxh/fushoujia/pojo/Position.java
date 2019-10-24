package com.lxh.fushoujia.pojo;

/**
 * @program: fushoujia
 * @description: 职位信息
 * @author: Mr.Wang
 * @create: 2019-10-15 15:40
 **/

public class Position {
    private int id;
    private String name;
    private boolean isDelete;

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
