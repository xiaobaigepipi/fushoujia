package com.lxh.fushoujia.pojo;

import java.math.BigDecimal;
import java.util.Date;

/*
 * @PackageName: com.lxh.fushoujia.pojo
 * @ClassName: Budget
 * @Description:
 * @author: 辉
 * @date: 219/1/3 :23
 * */
public class Budget {
    private int id;
    private BigDecimal expectedIncome;  //预计合同收入
    private BigDecimal tenderCost; //招投标成本
    private BigDecimal netIncome;   //净收入
    private BigDecimal outCost;  //外包成本
    private BigDecimal publicCost;  //公关费
    private BigDecimal humanCost;   //人力成本
    private BigDecimal serveCost;  //招待费
    private BigDecimal travelCost;  //差旅费
    private BigDecimal otherCos;   //其他成本
    private BigDecimal allCost;  //成本合计
    private BigDecimal VAT;   //增值税
    private BigDecimal grossProfit;  // 项目毛利
    private BigDecimal incomeTax;  //所得税
    private BigDecimal netProfit;  //项目净利
    private String taxRate;
    private String status;
    private Date createDate;
    private Date updateDate;
    private int projectId;
    private Project project;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getExpectedIncome() {
        return expectedIncome;
    }

    public void setExpectedIncome(BigDecimal expectedIncome) {
        this.expectedIncome = expectedIncome;
    }

    public BigDecimal getTenderCost() {
        return tenderCost;
    }

    public void setTenderCost(BigDecimal tenderCost) {
        this.tenderCost = tenderCost;
    }

    public BigDecimal getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(BigDecimal netIncome) {
        this.netIncome = netIncome;
    }

    public BigDecimal getOutCost() {
        return outCost;
    }

    public void setOutCost(BigDecimal outCost) {
        this.outCost = outCost;
    }

    public BigDecimal getPublicCost() {
        return publicCost;
    }

    public void setPublicCost(BigDecimal publicCost) {
        this.publicCost = publicCost;
    }

    public BigDecimal getHumanCost() {
        return humanCost;
    }

    public void setHumanCost(BigDecimal humanCost) {
        this.humanCost = humanCost;
    }

    public BigDecimal getServeCost() {
        return serveCost;
    }

    public void setServeCost(BigDecimal serveCost) {
        this.serveCost = serveCost;
    }

    public BigDecimal getTravelCost() {
        return travelCost;
    }

    public void setTravelCost(BigDecimal travelCost) {
        this.travelCost = travelCost;
    }

    public BigDecimal getOtherCos() {
        return otherCos;
    }

    public void setOtherCos(BigDecimal otherCos) {
        this.otherCos = otherCos;
    }

    public BigDecimal getAllCost() {
        return allCost;
    }

    public void setAllCost(BigDecimal allCost) {
        this.allCost = allCost;
    }

    public BigDecimal getVAT() {
        return VAT;
    }

    public void setVAT(BigDecimal VAT) {
        this.VAT = VAT;
    }

    public BigDecimal getGrossProfit() {
        return grossProfit;
    }

    public void setGrossProfit(BigDecimal grossProfit) {
        this.grossProfit = grossProfit;
    }

    public BigDecimal getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(BigDecimal incomeTax) {
        this.incomeTax = incomeTax;
    }

    public BigDecimal getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(BigDecimal netProfit) {
        this.netProfit = netProfit;
    }

    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
