package com.lxh.fushoujia.pojo;


import java.util.Date;

/*
 * @PackageName: com.lxh.fushoujia.pojo
 * @ClassName: BudgetRemark
 * @Description:
 * @author: 辉
 * @date: 2019/10/30 0:28
 * */
public class BudgetRemark {
    private int id;
    private String expectedIncome;  //预计合同收入
    private String tenderCost; //招投标成本
    private String netIncome;   //净收入
    private String outCost;  //外包成本
    private String publicCost;  //公关费
    private String humanCost;   //人力成本
    private String serveCost;  //招待费
    private String travelCost;  //差旅费
    private String otherCos;   //其他成本
    private String allCost;  //成本合计
    private String VAT;   //增值税
    private String grossProfit;  // 项目毛利
    private String incomeTax;  //所得税
    private String netProfit;  //项目净利

    private int budgetId;
    private Date createDate;
    private Date updateDate;

    public int getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(int budgetId) {
        this.budgetId = budgetId;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpectedIncome() {
        return expectedIncome;
    }

    public void setExpectedIncome(String expectedIncome) {
        this.expectedIncome = expectedIncome;
    }

    public String getTenderCost() {
        return tenderCost;
    }

    public void setTenderCost(String tenderCost) {
        this.tenderCost = tenderCost;
    }

    public String getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(String netIncome) {
        this.netIncome = netIncome;
    }

    public String getOutCost() {
        return outCost;
    }

    public void setOutCost(String outCost) {
        this.outCost = outCost;
    }

    public String getPublicCost() {
        return publicCost;
    }

    public void setPublicCost(String publicCost) {
        this.publicCost = publicCost;
    }

    public String getHumanCost() {
        return humanCost;
    }

    public void setHumanCost(String humanCost) {
        this.humanCost = humanCost;
    }

    public String getServeCost() {
        return serveCost;
    }

    public void setServeCost(String serveCost) {
        this.serveCost = serveCost;
    }

    public String getTravelCost() {
        return travelCost;
    }

    public void setTravelCost(String travelCost) {
        this.travelCost = travelCost;
    }

    public String getOtherCos() {
        return otherCos;
    }

    public void setOtherCos(String otherCos) {
        this.otherCos = otherCos;
    }

    public String getAllCost() {
        return allCost;
    }

    public void setAllCost(String allCost) {
        this.allCost = allCost;
    }

    public String getVAT() {
        return VAT;
    }

    public void setVAT(String VAT) {
        this.VAT = VAT;
    }

    public String getGrossProfit() {
        return grossProfit;
    }

    public void setGrossProfit(String grossProfit) {
        this.grossProfit = grossProfit;
    }

    public String getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(String incomeTax) {
        this.incomeTax = incomeTax;
    }

    public String getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(String netProfit) {
        this.netProfit = netProfit;
    }
}
