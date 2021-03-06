package com.lxh.fushoujia.service;

import com.lxh.fushoujia.pojo.Budget;
import com.lxh.fushoujia.pojo.BudgetRemark;
import com.lxh.fushoujia.pojo.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BudgetService {
    List<Budget> listBudget(Page page);
    int getTotal(Page page);
    int addBudget(Budget budget);
    int addBudgetRemark(BudgetRemark budgetRemark);
    Budget getBudget(@Param("id") Integer id);
    BudgetRemark getBudgetRemark(@Param("budgetId") Integer budgetId);
    int updateBudget(Budget budget);
    int updateBudgetRemark(BudgetRemark budgetRemark);

    Budget getBudgetByTrue(Integer id);
    List<Budget> listBudgetByApproval();
}
