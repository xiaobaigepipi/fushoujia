package com.lxh.fushoujia.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/*
 * @PackageName: com.lxh.fushoujia.pojo
 * @ClassName: Project
 * @Description:
 * @author: 辉
 * @date: 2019/10/30 0:09
 * */
public class Project {
    private int id;
    private String name;
    private String code;
    private String type; //项目类型
    private String property; //项目属性

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date projectDate; //立项日期
    private String client; //甲方客户
    private String origin; //项目来源
    private String province; //项目所属省份
    private String city; //项目所属城市
    private String workPlace; //项目工作地点
    private BigDecimal buildArea; //项目建筑面积
    private BigDecimal landArea; //项目用地面积
    private BigDecimal subject; //预计合同标的
    private String principal; //负责人
    private String tenderType; //合同招投标类型
    private String supplier; //供应商
    private String description; //项目描述

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate; //项目开始日期
    @DateTimeFormat(pattern = "yy-MM-dd")
    private Date endDate; //项目结束日期
    private int cycle; //项目周期 单位：天
    private String status; //项目状态
    private String contract; //项目合同状态
    private String payment; //款项状态
    private String departments; //实施所
    private Date createDate;
    private Date updateDate;
    private boolean isDelete;
    private int userId;
    private User user;

    private List<FirstSend> firstSends;

    private String accept;

    @DateTimeFormat(pattern = "yy-MM-dd")
    private Date acceptDate;

    public List<FirstSend> getFirstSends() {
        return firstSends;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public Date getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    public void setFirstSends(List<FirstSend> firstSends) {
        this.firstSends = firstSends;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getDepartments() {
        return departments;
    }

    public void setDepartments(String departments) {
        this.departments = departments;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Date getProjectDate() {
        return projectDate;
    }

    public void setProjectDate(Date projectDate) {
        this.projectDate = projectDate;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public BigDecimal getBuildArea() {
        return buildArea;
    }

    public void setBuildArea(BigDecimal buildArea) {
        this.buildArea = buildArea;
    }

    public BigDecimal getLandArea() {
        return landArea;
    }

    public void setLandArea(BigDecimal landArea) {
        this.landArea = landArea;
    }

    public BigDecimal getSubject() {
        return subject;
    }

    public void setSubject(BigDecimal subject) {
        this.subject = subject;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getTenderType() {
        return tenderType;
    }

    public void setTenderType(String tenderType) {
        this.tenderType = tenderType;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getCycle() {
        return cycle;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
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

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
