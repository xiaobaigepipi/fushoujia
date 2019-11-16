package com.lxh.fushoujia.pojo;

import java.util.Date;

/*
 * @PackageName: com.lxh.fushoujia.pojo
 * @ClassName: SecondSend
 * @Description:
 * @author: 辉
 * @date: 2019/10/30 0:37
 * */
public class SecondSend {
    private int id;
    private String process;//工序名称
    private Date sendTime; //派遣时间
    private Date endTime;  //结束时间
    private int cycle; //派遣周期
    private String remark; //
    private String status; //派遣状态
    private boolean isDelete;
    private int firstId;
    private boolean special; //是否是特殊工序
    private int userId; //
    private Date createDate ;
    private Date updateDate;

    private User user;
    private FirstSend firstSend;

    private String principal;

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getCycle() {
        return cycle;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public int getFirstId() {
        return firstId;
    }

    public void setFirstId(int firstId) {
        this.firstId = firstId;
    }

    public boolean isSpecial() {
        return special;
    }

    public void setSpecial(boolean special) {
        this.special = special;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public FirstSend getFirstSend() {
        return firstSend;
    }

    public void setFirstSend(FirstSend firstSend) {
        this.firstSend = firstSend;
    }
}
