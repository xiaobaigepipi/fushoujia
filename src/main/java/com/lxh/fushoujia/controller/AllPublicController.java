package com.lxh.fushoujia.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lxh.fushoujia.pojo.*;
import com.lxh.fushoujia.service.*;
import com.lxh.fushoujia.util.Result;
import com.lxh.fushoujia.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: fushoujia
 * @description: 全部公共接口访问，没有权限限制的
 * @author: Mr.Wang
 * @create: 2019-10-18 22:40
 * git更新gitgebfxib
 * 你好我的歌
 * dhajdhhdjahdajajdas
 **/
@Controller
@RequestMapping("/all")
public class AllPublicController {
    @Autowired
    UserService userService;
    @Autowired
    BasicService basicService;
    @Autowired
    ProcessService processService;
    @Autowired
    CustomerService customerService;
    @Autowired
    SupplierService supplierService;
    @Autowired
    ProjectService projectService;

    /*
    * 获取未删除的部门信息
    * */
    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    @ResponseBody
    public Result listDepartments(HttpServletRequest request) {
        List<Department> list = basicService.listDepartmentByTrue();
        Result result = new Result("数据获取成功", "200",  list);
        return result;
    }

    /*
    * 获取未删除的职位信息
    * */
    @RequestMapping(value = "/positions", method = RequestMethod.GET)
    @ResponseBody
    public Result listPositions(){
        List<Position> list = basicService.listPositionByTrue();
        return new Result("查询成功", "200", list);
    }
    /*
     * @Author 辉
     * @Description //TODO
     * @Date 20:57 2019/10/26
     * @Param []
     * @return com.lxh.fushoujia.util.Result
     **/
    @RequestMapping(value="/address", method = RequestMethod.GET)
    @ResponseBody
    public Result listAddress() {
        List<Province> list = basicService.listAddress();
        return new Result("查询成功", "200", list);
    }

    @RequestMapping(value="/suppliertype", method = RequestMethod.GET)
    @ResponseBody
    public Result listSupplierType() {
        List<SupplierType> list = basicService.listSupplierType();
        return new Result("查询成功", "200", list);
    }

    @RequestMapping(value = "/projectUsers", method = RequestMethod.GET)
    @ResponseBody
    public Result listProjectUser() {
        List<User> list = userService.listUserAction();
        List<User> lists = new ArrayList<>();
        for (User u : list) {
            List<UserRole> urs = u.getUserRoles();
            sign:
            for (UserRole ur : urs) {
                List<RoleAction> ras = ur.getRole().getRoleActions();
                for (RoleAction ra : ras) {
                    Action a = ra.getAction();
                    if (a.getCode().equals("project")) {
                        lists.add(u);
                        break sign;
                    }
                }
            }
        }

        return new Result("查询成功", "200", lists);
    }

    @RequestMapping(value = "/process", method= RequestMethod.GET)
    @ResponseBody
    public Result listFirstProcess() {
        ///PageHelper.startPage(page.getStart(), page.getCount());
        List<FirstProcess> list = processService.listFirstProcess();
        //PageInfo info = new PageInfo(list);
        //page.setTotal((int)info.getTotal());
        return new Result("查询成功", "200", list);
    }

    @RequestMapping(value = "/process/second", method= RequestMethod.GET)
    @ResponseBody
    public Result listSecondProcess(@RequestParam("firstProcess") String firstProcess) {
        ///PageHelper.startPage(page.getStart(), page.getCount());
        firstProcess = Util.decode(firstProcess);
        List<FirstProcess> list = processService.listFirstProcess();
        int id = 0;
        for (FirstProcess f : list) {
            if (firstProcess.equals(f.getName())) {
                id = f.getId();
                break;
            }
        }
        List<SecondProcess> seconds = processService.listSecondProcess(id);
        //PageInfo info = new PageInfo(list);
        //page.setTotal((int)info.getTotal());
        return new Result("查询成功", "200", seconds);
    }

    @RequestMapping(value = "/customers", method= RequestMethod.GET)
    @ResponseBody
    public Result listCustomers() {

        List<Customer> list = customerService.listAllCustomer();

        return new Result("查询成功", "200", list);
    }

    @RequestMapping(value = "/tsuppliers", method= RequestMethod.GET)
    @ResponseBody
    public Result listTSuppliers() {
        List<TSupplier> list = supplierService.listAllTSupplier();

        return new Result("查询成功", "200", list);
    }

    @RequestMapping(value = "/projects", method= RequestMethod.GET)
    @ResponseBody
    public Result listAllProjects() {
        List<Project> list = projectService.listAllProject();

        return new Result("查询成功", "200", list);
    }

}
