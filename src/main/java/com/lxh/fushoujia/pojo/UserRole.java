package com.lxh.fushoujia.pojo;

/**
 * @program: fushoujia
 * @description: 用户角色表
 * @author: Mr.Wang
 * @create: 2019-10-20 18:35
 **/

public class UserRole {
    private int id;
    private User user;
    private Role role;
    private int userId;
    private int roleId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
