package com.lxh.fushoujia.pojo;

import java.util.List;

/**
 * @program: fushoujia
 * @description: 部门信息
 * @author: Mr.Wang
 * @create: 2019-10-15 15:38
 **/

public class Department {
    private int id;
    private String name;
    private String code;
    private List<User> users;
    private boolean isDelete;
    private String director;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
