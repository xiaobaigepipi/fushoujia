package com.lxh.fushoujia.pojo;

import java.util.List;

/**
 * @program: fushoujia
 * @description: 省份信息
 * @author: Mr.Wang
 * @create: 2019-10-15 15:45
 **/

public class Province {
    private int id;
    private String name;
    private List<City> citys;

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

    public List<City> getCitys() {
        return citys;
    }

    public void setCitys(List<City> citys) {
        this.citys = citys;
    }
}
