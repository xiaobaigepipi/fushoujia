package com.lxh.fushoujia.service.serviceImpl;

import com.lxh.fushoujia.mapper.BudgetMapper;
import com.lxh.fushoujia.pojo.Budget;
import com.lxh.fushoujia.pojo.BudgetRemark;
import com.lxh.fushoujia.pojo.Page;
import com.lxh.fushoujia.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @PackageName: com.lxh.fushoujia.service.serviceImpl
 * @ClassName: BudgetServiceImpl
 * @Description:
 * @author: 辉
 * @date: 2019/10/30 19:16
 * */
@Service
public class BudgetServiceImpl implements BudgetService {
    @Autowired
    BudgetMapper budgetMapper;

    @Override
    public List<Budget> listBudget(Page page) {
        return budgetMapper.listBudget(page);
    }

    @Override
    public int getTotal(Page page) {
        return budgetMapper.getTotal(page);
    }

    @Override
    public int addBudget(Budget budget) {
        return budgetMapper.addBudget(budget);
    }

    @Override
    public int addBudgetRemark(BudgetRemark budgetRemark) {
        return budgetMapper.addBudgetRemark(budgetRemark);
    }

    @Override
    public Budget getBudget(Integer id) {
        return budgetMapper.getBudget(id);
    }

    @Override
    public BudgetRemark getBudgetRemark(Integer budgetId) {
        return budgetMapper.getBudgetRemark(budgetId);
    }

    @Override
    public int updateBudget(Budget budget) {
        return budgetMapper.updateBudget(budget);
    }

    @Override
    public int updateBudgetRemark(BudgetRemark budgetRemark) {
        return budgetMapper.updateBudgetRemark(budgetRemark);
    }
}
