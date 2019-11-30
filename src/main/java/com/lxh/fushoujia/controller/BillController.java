package com.lxh.fushoujia.controller;

import com.lxh.fushoujia.pojo.Bill;
import com.lxh.fushoujia.pojo.Dynamic;
import com.lxh.fushoujia.pojo.Page;
import com.lxh.fushoujia.pojo.Project;
import com.lxh.fushoujia.service.BillService;
import com.lxh.fushoujia.service.IncomeService;
import com.lxh.fushoujia.service.ProjectService;
import com.lxh.fushoujia.service.UserService;
import com.lxh.fushoujia.util.ProjectStatus;
import com.lxh.fushoujia.util.Result;
import com.lxh.fushoujia.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/*
 * @PackageName: com.lxh.fushoujia.controller
 * @ClassName: BillController
 * @Description:
 * @author: 辉
 * @date: 2019/11/28 16:18
 * */
@Controller
@RequestMapping("")
public class BillController {
    @Autowired
    BillService billService;

    @Autowired
    ProjectService projectService;

    @Autowired
    IncomeService incomeService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/bill", method = RequestMethod.GET)
    @ResponseBody
    public Result listBill(Page page) {
        page.setSearchKey(Util.decode(page.getSearchKey()));
        List<Bill> list = billService.listBill(page);
        for (Bill b : list) {
            Project p = projectService.getProject(b.getProjectId());
            b.setProject(p);
        }
        Page page1 = new Page();
        page1.setCount(page.getCount());
        page1.setStart(page.getStart());
        page.setSearchKey(page.getSearchKey());
        page.setTotal(billService.listBill(page1).size());
        return new Result("查询成功", "200", page, list);
    }


    @RequestMapping(value = "/bill/delete", method = RequestMethod.PUT)
    @ResponseBody
    public Result deleteIncome(@RequestBody Integer[] ids) {
        for (Integer i : ids) {
            billService.deleteBill(i);
        }
        return new Result("删除成功", "200");
    }

    @RequestMapping(value = "/bill/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result deleteIncome(@PathVariable Integer id) {
        Bill bill = billService.getBill(id);
        Project p = projectService.getProject(bill.getProjectId());
        bill.setProject(p);
        return new Result("删除成功", "200", bill);
    }

    @RequestMapping(value = "/bill/{id}", method = RequestMethod.PUT )
    @ResponseBody
    public Result updateIncome(@PathVariable Integer id, @RequestBody Bill bill, HttpServletRequest request) {

        billService.updateBill(bill);
        if (bill.getStatus().equals(ProjectStatus.approval)) {
            Dynamic d = Util.getDynamic(request, "审核了一笔开票信息", "/bill/"+ bill.getId());
            userService.addDynamic(d);
        } else {
            Dynamic d = Util.getDynamic(request, "修改了一笔开票信息", "/bill/"+ bill.getId());
            userService.addDynamic(d);
        }
        //bill.setProject(p);
        return new Result("删除成功", "200");
    }

    @RequestMapping(value = "/bill/allIncome", method = RequestMethod.GET )
    @ResponseBody
    public Result getAllIncome(Integer projectId) {

        Integer sum = incomeService.getAllIncome(projectId);
        //bill.setProject(p);
        return new Result("删除成功", "200", sum);
    }

    @RequestMapping(value = "/bill/allBill", method = RequestMethod.GET )
    @ResponseBody
    public Result getAllBill(Integer projectId) {

        Integer sum = billService.getAllBill(projectId);
        //bill.setProject(p);
        return new Result("删除成功", "200", sum);
    }

    @RequestMapping(value = "/bill", method = RequestMethod.POST )
    @ResponseBody
    public Result addBill(@RequestBody Bill bill, HttpServletRequest request) {

        billService.addBill(bill);
        //bill.setProject(p);
        Dynamic d = Util.getDynamic(request, "申请了新的开票信息", "/bill/"+ bill.getId());
        userService.addDynamic(d);
        return new Result("删除成功", "200", bill);
    }
}











