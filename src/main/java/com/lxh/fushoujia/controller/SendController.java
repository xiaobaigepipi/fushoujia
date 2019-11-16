package com.lxh.fushoujia.controller;

import com.lxh.fushoujia.pojo.*;
import com.lxh.fushoujia.service.BasicService;
import com.lxh.fushoujia.service.FirstSendService;
import com.lxh.fushoujia.service.ProjectService;
import com.lxh.fushoujia.service.UserService;
import com.lxh.fushoujia.util.JwtUtil;
import com.lxh.fushoujia.util.ProjectStatus;
import com.lxh.fushoujia.util.Result;
import com.lxh.fushoujia.util.Util;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/*
 * @PackageName: com.lxh.fushoujia.controller
 * @ClassName: SendController
 * @Description:
 * @author: 辉
 * @date: 2019/11/8 18:20
 * */
@Controller
@RequestMapping("")
public class SendController {

    @Autowired
    FirstSendService firstSendService;

    @Autowired
    ProjectService projectService;

    @Autowired
    UserService userService;

    @Autowired
    BasicService basicService;

    @RequestMapping(value = "/project/firstSends", method = RequestMethod.POST)
    @ResponseBody
    public Result addFirstSend(@RequestBody List<FirstSend> firsts) {
        int projectId = 0;
        for (FirstSend f : firsts) {
            Date date = f.getSendTime();
            int cycle = f.getCycle();
            projectId = f.getProjectId();
            f.setEndTime(new Date(date.getTime() + cycle*24*60*60*1000));
            firstSendService.addFirstSend(f);
        }
        Project project = new Project();
        project.setId(projectId);
        project.setStatus(ProjectStatus.toReview);
        projectService.updateProject(project);
        return new Result("新增成功", "200");
    }

    @RequestMapping(value = "/project/firstSends", method = RequestMethod.GET)
    @ResponseBody
    public Result getFirstSend(@RequestParam("projectId") Integer projectId) {
        List<FirstSend> list = firstSendService.listFirstSend(projectId);
        return new Result("查询成功", "200", list);
    }

    @RequestMapping(value = "/project/firstSends/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteFirstSend(@PathVariable Integer id) {
        FirstSend f = new FirstSend();
        f.setId(id);
        f.setDelete(true);
        firstSendService.updateFirstSend(f);
        return new Result("删除成功", "200");
    }

    @RequestMapping(value = "/project/firstSends", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateFirstSend(@RequestBody List<FirstSend> firsts) {
        int projectId = 0;
        for (FirstSend f : firsts) {
            Date date = f.getSendTime();
            int cycle = f.getCycle();
            projectId = f.getProjectId();
            f.setEndTime(new Date(date.getTime() + cycle*24*60*60*1000));
            firstSendService.updateFirstSend(f);
        }
        Project project = new Project();
        project.setId(projectId);
        project.setStatus(ProjectStatus.toApproval);
        projectService.updateProject(project);
        return new Result("修改成功", "200");
    }


    @RequestMapping(value = "/send/firstSends", method = RequestMethod.GET)
    @ResponseBody
    public Result getFirstSend(HttpServletRequest request, Page page) {
        page.setSearchKey(Util.decode(page.getSearchKey()));
        String token = request.getHeader("token");
        int id = JwtUtil.getUserId(token);
        User user = userService.getUser(id);
        int departmentId = user.getDepartmentId();
        Map<String, Object> map = new HashMap<>();
        map.put("start", page.getStart());
        map.put("count", page.getCount());
        map.put("searchKey", page.getSearchKey());
        map.put("departmentId", departmentId);
        map.put("page", "地点");
        List<FirstSend> list = firstSendService.listFirstSendByDepart(map);
        map.put("page", null);
        List<FirstSend> s = firstSendService.listFirstSendByDepart(map);
        page.setTotal(s.size());
        return new Result("查询成功", "200", page, list);
    }

    //
    @RequestMapping(value = "/send/user", method = RequestMethod.GET)
    @ResponseBody
    public Result checkUser(HttpServletRequest request) {
        String token = request.getHeader("token");
        if (token == null) {
            return null;
        }
        int id = JwtUtil.getUserId(token);
        User user = userService.getUser(id);
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
        Position position = basicService.getPosition(user.getPositionId());
        String name = position.getName();
        //System.out.println(name);
        if (name.equals("总经理") || name.equals("副总经理")) {
            //System.out.println(name);
            return new Result("查询成功", "all");
        }
        boolean b = false;
        if (name.equals("所长")) {
            for (User u : lists) {

                if (u.getId() == user.getId()) {
                    b = true;
                    System.out.println(name);
                }
            }
        }

        if (b) {
            return new Result("查询成功", "all");
        }
        if (!b){
            return new Result("查询成功", "director");
        }

        return new Result("查询成功", "staff");

    }


    @RequestMapping(value = "/send/firstSends/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getFirstSendById(@PathVariable Integer id) {
        FirstSend firstSend = firstSendService.getFirstSend(id);
        return new Result("查询成功", "200", firstSend);
    }

}
