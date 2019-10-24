package com.lxh.fushoujia.pojo;

import java.util.Date;
import java.util.List;

/*
 * @PackageName: com.lxh.fushoujia.pojo
 * @ClassName: FirstProcess
 * @Description:一级工序名称
 * @author: 辉
 * @date: 2019/10/25 0:42
 * */
public class FirstProcess {
    private int id;
    private String name;
    private Date createDate;
    private List<SecondProcess> seconds;

    public List<SecondProcess> getSeconds() {
        return seconds;
    }

    public void setSeconds(List<SecondProcess> seconds) {
        this.seconds = seconds;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
