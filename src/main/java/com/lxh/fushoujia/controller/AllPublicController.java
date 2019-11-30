package com.lxh.fushoujia.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lxh.fushoujia.pojo.*;
import com.lxh.fushoujia.service.*;
import com.lxh.fushoujia.util.JwtUtil;
import com.lxh.fushoujia.util.Result;
import com.lxh.fushoujia.util.Util;
import com.sun.corba.se.spi.servicecontext.SendingContextServiceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

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
    @Autowired
    FirstSendService firstSendService;
    @Autowired
    SecondSendService secondSendService;
    @Autowired
    BillService billService;
    @Autowired
    BudgetService budgetService;

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

    @RequestMapping(value = "/actions", method= RequestMethod.GET)
    @ResponseBody
    public Result getAllActions(HttpServletRequest request) {
        String token = request.getHeader("token");
        int uid = JwtUtil.getUserId(token);
        User user = userService.getUserAction(uid);
        List<Action> list = new ArrayList<>();
        List<UserRole> userRoles = user.getUserRoles();
        //获取所有权限
        for (UserRole ur : userRoles) {
            Role role = ur.getRole();
            List<RoleAction> roleActions = role.getRoleActions();
            for (RoleAction ra : roleActions) {
                Action a = ra.getAction();
                list.add(a);
            }
        }

        return new Result("查询成功", "200", list);
    }

    @RequestMapping(value = "/dynamics", method= RequestMethod.GET)
    @ResponseBody
    public Result listDynamic(Page page, HttpServletRequest request) {
        String token = request.getHeader("token");
        int userId = JwtUtil.getUserId(token);
        User user = userService.getUser(userId);
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("start", page.getStart());
        map.put("count", page.getCount());
        List<Dynamic> list =userService.listDynamic(map);
        for (Dynamic d : list) {
            d.setUser(user);
        }
        return new Result("查询成功", "200", list);
    }

    @RequestMapping(value = "/number", method= RequestMethod.GET)
    @ResponseBody
    public Result getNumber(HttpServletRequest request) {

        String token = request.getHeader("token");
        int id = JwtUtil.getUserId(token);
        User user = userService.getUser(id);

        String position = user.getPosition().getName();
        Map<String, Object> map = new HashMap<>();
        map.put("userId",id);
        map.put("year", 0);
        map.put("month", 0);
        map.put("start", 0);
        map.put("count", Integer.MAX_VALUE);
        List<Project> projects = projectService.listProject(map);
        Integer one = projects.size();
        Integer two = 0;
        if (position.equals("所长")) {
            Map<String, Object> map1 = new HashMap<>();

            map1.put("searchKey", null);
            map1.put("departmentId", user.getDepartmentId());
            List<FirstSend> firsts = firstSendService.listFirstSendByDepart(map1);
            two = firsts.size();
        }

        Map<String, Object> map2 = new HashMap<>();
        map2.put("userId", id);
        map2.put("start", 0);
        map2.put("count", Integer.MAX_VALUE);
        map2.put("searchKey", null);
        List<SecondSend> list = secondSendService.listSecondSendByUser(map2);
        Integer three = list.size();
        List<Integer> ins = new ArrayList<>();
        ins.add(one);
        ins.add(two);
        ins.add(three);
        return new Result("查询成功", "200", ins);
    }

    @RequestMapping(value = "/payments", method= RequestMethod.GET)
    @ResponseBody
    public Result getPayments(HttpServletRequest request) {
        List<PaymentNode> list = projectService.listPaymentNodeByTime(new Date());
        for (PaymentNode p : list) {
            Project project = projectService.getProject(p.getProjectId());
            p.setProject(project);
        }
        return new Result("查询成功", "200", list);
    }

    @RequestMapping(value = "/work/first", method= RequestMethod.GET)
    @ResponseBody
    public Result getFirst(HttpServletRequest request) {
        String token = request.getHeader("token");
        int id = JwtUtil.getUserId(token);
        List<FirstSend> list = firstSendService.listFirstSendByApproval(id);

        return new Result("查询成功", "200", list);
    }

    @RequestMapping(value = "/work/second", method= RequestMethod.GET)
    @ResponseBody
    public Result getSecond(HttpServletRequest request) {
        String token = request.getHeader("token");
        int id = JwtUtil.getUserId(token);
        User user = userService.getUser(id);
        int departId = user.getDepartmentId();
        List<SecondSend> list = secondSendService.listSecondSendByApproval(departId);

        return new Result("查询成功", "200", list);
    }

    @RequestMapping(value = "/work/invalid", method= RequestMethod.GET)
    @ResponseBody
    public Result getInvalid(HttpServletRequest request) {
        String token = request.getHeader("token");
        int id = JwtUtil.getUserId(token);
        //User user = userService.getUser(id);
        //int departId = user.getDepartmentId();
        List<SecondSend> list = secondSendService.listSecondSendByInvalid(id);

        return new Result("查询成功", "200", list);
    }

    @RequestMapping(value = "/work/bill", method= RequestMethod.GET)
    @ResponseBody
    public Result getBill() {
        List<Bill> list = billService.listBillByStatus("toApproval");
        for (Bill bill : list) {
            Project p = projectService.getProject(bill.getProjectId());
            bill.setProject(p);
        }

        return new Result("查询成功", "200", list);
    }

    @RequestMapping(value = "/work/budget", method= RequestMethod.GET)
    @ResponseBody
    public Result getBudget() {
        List<Budget> list = budgetService.listBudgetByApproval();

        return new Result("查询成功", "200", list);
    }

    @RequestMapping(value = "/work", method= RequestMethod.GET)
    @ResponseBody
    public Result getWork(HttpServletRequest request) {

        String token = request.getHeader("token");
        int id = JwtUtil.getUserId(token);
        User user = userService.getUser(id);
        int departId = user.getDepartmentId();

        Map<String, Object> map = new HashMap<>();

        map.put("year", 0);
        map.put("month", 0);
        map.put("start", 0);
        map.put("count", Integer.MAX_VALUE);
        map.put("status","toApproval");
        List<Project> project = projectService.listProject(map);

        map.put("contract", "noContract");
        map.put("userId", id);
        map.put("status", "approval");
        List<Project> contract = projectService.listProject(map);

        List<FirstSend> first = firstSendService.listFirstSendByApproval(id);
        List<SecondSend> second = secondSendService.listSecondSendByInvalid(id);
        List<SecondSend> invalid = secondSendService.listSecondSendByInvalid(id);
        List<Bill> bill = billService.listBillByStatus("toApproval");
        List<Budget> budget = budgetService.listBudgetByApproval();

        String position = user.getPosition().getName();

        List<User> users = userService.listUserAction();
        List<User> lists = new ArrayList<>();
        for (User u : users) {
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
        boolean projectUser = false;
        for (User u : lists) {
            if (u.getId() == user.getId()) {
                projectUser = true;
            }
        }

        if (projectUser) {
            if (project.size() > 0 || contract.size() > 0 || first.size() > 0 || invalid.size() > 0) {
                return new Result("查询成功", "200");
            }
            if (position.equals("总经理")) {
                if (project.size() > 0 || contract.size() > 0 || first.size() > 0 || invalid.size() > 0 || second.size() > 0 || bill.size() > 0 || budget.size() > 0) {
                    return new Result("查询成功", "200");
                }
            }
        }

        if (position.equals("财务")) {
            if (bill.size() > 0 || budget.size() > 0) {
                return new Result("查询成功", "200");
            }
        }

        if (position.equals("所长")) {
            if (second.size() > 0) {
                return new Result("查询成功", "200");
            }
        }

        return new Result("查询成功", "888");
    }

}
