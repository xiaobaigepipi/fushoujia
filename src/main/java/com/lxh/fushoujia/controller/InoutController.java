package com.lxh.fushoujia.controller;

import com.lxh.fushoujia.pojo.Dynamic;
import com.lxh.fushoujia.pojo.Income;
import com.lxh.fushoujia.pojo.Outlay;
import com.lxh.fushoujia.pojo.Page;
import com.lxh.fushoujia.service.IncomeService;
import com.lxh.fushoujia.service.OutlayService;
import com.lxh.fushoujia.service.UserService;
import com.lxh.fushoujia.util.Result;
import com.lxh.fushoujia.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @PackageName: com.lxh.fushoujia.controller
 * @ClassName: InoutController
 * @Description:
 * @author: 辉
 * @date: 2019/11/27 20:49
 * */
@Controller
@RequestMapping("")
public class InoutController {
    @Autowired
    IncomeService incomeService;
    @Autowired
    OutlayService outlayService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/inout/income", method = RequestMethod.GET)
    @ResponseBody
    public Result listIncome(Page page) {
        page.setSearchKey(Util.decode(page.getSearchKey()));
        List<Income> list = incomeService.listIncome(page);
        Page p = new Page();
        p.setCount(Integer.MAX_VALUE);
        p.setStart(0);
        p.setSearchKey(page.getSearchKey());
        List<Income> list1 = incomeService.listIncome(p);
        page.setTotal(list1.size());
        return new Result("查询成功", "200", page, list);
    }

    @RequestMapping(value = "/inout/income/delete", method = RequestMethod.PUT)
    @ResponseBody
    public Result deleteIncome(@RequestBody Integer[] ids) {
        for (Integer i : ids) {
            incomeService.deleteIncome(i);
        }
        return new Result("删除成功", "200");
    }

    @RequestMapping(value = "/inout/income", method = RequestMethod.POST)
    @ResponseBody
    public Result addIncome(@RequestBody Income ids, HttpServletRequest request) {
        incomeService.addIncome(ids);
        Dynamic d = Util.getDynamic(request, "新增了一笔项目收入", "/inout/income/"+ ids.getId());
        userService.addDynamic(d);
        return new Result("新增成功", "200", ids);
    }

    @RequestMapping(value = "/inout/income/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result addIncome(@PathVariable Integer id) {
        Income i = incomeService.getIncome(id);
        return new Result("查询成功", "200", i);
    }

    @RequestMapping(value = "/inout/out", method = RequestMethod.GET)
    @ResponseBody
    public Result listOut(int start, int count, @RequestParam(value = "searchKey", required = false) String searchKey, Boolean sunk) {
        //System.out.println(sunk);
        Page page = new Page();
        page.setStart(start);
        page.setCount(count);
        page.setSearchKey(Util.decode(searchKey));
        Map<String, Object> map = new HashMap<>();
        map.put("start", page.getStart());
        map.put("count", page.getCount());
        map.put("searchKey", page.getSearchKey());
        map.put("sunk", sunk);
        List<Outlay> list = outlayService.listOutlay(map);
        map.put("start", 0);
        map.put("count", Integer.MAX_VALUE);
        page.setTotal(outlayService.listOutlay(map).size());
        return new Result("删除成功", "200", page, list);
    }

    @RequestMapping(value = "/inout/out/delete", method = RequestMethod.PUT)
    @ResponseBody
    public Result deleteOut(@RequestBody Integer[] ids) {
        for (Integer i : ids) {
            outlayService.deleteOutlay(i);
        }
        return new Result("删除成功", "200");
    }

    @RequestMapping(value = "/inout/out", method = RequestMethod.POST)
    @ResponseBody
    public Result addOut(@RequestBody Outlay ids, HttpServletRequest request) {
        outlayService.addOutlay(ids);
        Dynamic d = Util.getDynamic(request, "新增了一笔项目支出", "/inout/out/"+ ids.getId());
        userService.addDynamic(d);
        return new Result("新增成功", "200", ids);
    }

    @RequestMapping(value = "/inout/out/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getOut(@PathVariable Integer id) {
       Outlay l = outlayService.getOutlay(id);
        return new Result("查询成功", "200", l);
    }

    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getSunk(@PathVariable Integer id) {
        BigDecimal all = incomeService.getAll();
        Integer allIncome = incomeService.getAllIncome(id);
        BigDecimal sunk = outlayService.getSunk();
        BigDecimal bincome = new BigDecimal(String.valueOf(allIncome));
        BigDecimal newSunk = sunk.multiply(bincome.divide(all, 2, BigDecimal.ROUND_HALF_DOWN));
        return new Result("查询成功", "200", newSunk);
    }
}














