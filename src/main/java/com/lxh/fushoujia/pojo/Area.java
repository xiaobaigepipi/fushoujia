package com.lxh.fushoujia.pojo;

/**
 * @program: fushoujia
 * @description: 地区信息
 * @author: Mr.Wang
 * @create: 2019-10-15 15:46
 **/

public class Area {
    private int id;
    private String name;
    private City city;
    private int cityId;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
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
