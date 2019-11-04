package com.lxh.fushoujia.pojo;

import java.util.Date;

/*
 * @PackageName: com.lxh.fushoujia.pojo
 * @ClassName: Action
 * @Description:
 * @author: 辉
 * @date: 2019/11/4 16:17
 * */
public class Action {
    private int id;
    private String name;
    private String code;
    private String url;
    private Date createDate;
    private Date updateDate;
    private int groupId;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
