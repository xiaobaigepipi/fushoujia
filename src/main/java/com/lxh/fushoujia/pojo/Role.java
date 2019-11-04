package com.lxh.fushoujia.pojo;

import java.util.List;

/**
 * @program: fushoujia
 * @description:
 * @author: Mr.Wang
 * @create: 2019-10-18 22:05
 **/

public class Role {
    private int id;
    private String name;
    private String code;
    private String remark;
    private List<RoleAction> roleActions;

    public List<RoleAction> getRoleActions() {
        return roleActions;
    }

    public void setRoleActions(List<RoleAction> roleActions) {
        this.roleActions = roleActions;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
