package com.lxh.fushoujia.pojo;

import java.util.List;

/**
 * @program: fushoujia
 * @description: 城市
 * @author: Mr.Wang
 * @create: 2019-10-15 15:46
 **/

public class City {
    private int id;
    private String name;
    private List<Area> areas;
    private int provinceId;
    private Province province;

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
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

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }
}
