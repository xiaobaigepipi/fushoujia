package com.lxh.fushoujia.controller;

import com.lxh.fushoujia.pojo.*;
import com.lxh.fushoujia.service.*;
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
import javax.ws.rs.Path;
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

    @Autowired
    SecondSendService secondSendService;

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

    @RequestMapping(value = "/all/firstSends", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateFirstSend(@RequestBody FirstSend first) {
        firstSendService.updateFirstSend(first);
        if (first.getStatus().equals("invalid")) {
            List<SecondSend> list = secondSendService.listSecondSend(first.getId());
            if (list.size() == 0) {
                return new Result("修改成功", "200");
            }
            for (SecondSend s : list) {
                s.setStatus("invalid");
                secondSendService.updateSecondSend(s);
            }
        }
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
        boolean b1 = false;
        if (name.equals("所长")) {
            b1 = true;
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
        if (b1){
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

    @RequestMapping(value = "/send/users", method = RequestMethod.GET)
    @ResponseBody
    public Result getStaff() {
        List<User> users = userService.listAllUser();
        List<User> list = new ArrayList<>();
        for (User u : users) {
            if (u.getPosition().getName().equals("设计师") || u.getPosition().getName().equals("所长")) {
                list.add(u);
            }
        }
        return new Result("查询成功", "200", list);
    }


    @RequestMapping(value = "/send/seconds", method = RequestMethod.POST)
    @ResponseBody
    public Result addSecondSend(@RequestBody List<SecondSend> secondSends) {
        int firstId = 0;
        for (SecondSend s : secondSends) {
            long start = s.getSendTime().getTime();
            firstId = s.getFirstId();
            s.setEndTime(new Date(start + s.getCycle()*1000*60*60*24));
            secondSendService.addSecondSend(s);
        }
        FirstSend f = new FirstSend();
        f.setId(firstId);
        f.setStatus(ProjectStatus.send);
        firstSendService.updateFirstSend(f);
        return new Result("新增成功", "200");
    }

    @RequestMapping(value = "/send/seconds", method = RequestMethod.GET)
    @ResponseBody
    public Result listSecondSend(@RequestParam("firstId") Integer firstId) {
        List<SecondSend> list = secondSendService.listSecondSend(firstId);
        return new Result("查询成功", "200", list);
    }

    @RequestMapping(value = "/send/seconds", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateSecondSend(@RequestBody List<SecondSend> secondSends) {
        for (SecondSend s : secondSends) {
            long start = s.getSendTime().getTime();
            s.setEndTime(new Date(start + s.getCycle()*1000*60*60*24));
            secondSendService.updateSecondSend(s);
        }
        return new Result("修改成功", "200");
    }

    @RequestMapping(value = "/send/seconds/user", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateSecondSend(@RequestBody SecondSend secondSend) {

        secondSendService.updateSecondSend(secondSend);
        return new Result("修改成功", "200");
    }


    @RequestMapping(value = "/send/seconds", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteSecondSend(@RequestParam("secondId") Integer secondId) {
        SecondSend s = new SecondSend();
        s.setId(secondId);
        s.setDelete(true);
        secondSendService.updateSecondSend(s);
        return new Result("删除成功", "200");
    }

    @RequestMapping(value = "/send/seconds/user", method = RequestMethod.GET)
    @ResponseBody
    public Result listSecondSendByUser(Page page, HttpServletRequest request) {
        page.setSearchKey(Util.decode(page.getSearchKey()));
        Map<String, Object> map = new HashMap<>();
        String token = request.getHeader("token");
        int id = JwtUtil.getUserId(token);
        map.put("userId", id);
        map.put("start", page.getStart());
        map.put("count", page.getCount());
        map.put("searchKey", page.getSearchKey());
        List<SecondSend> list = secondSendService.listSecondSendByUser(map);

        map.put("start", 0);
        map.put("count", Integer.MAX_VALUE);
        List<SecondSend> max = secondSendService.listSecondSendByUser(map);
        page.setTotal(max.size());
        return new Result("删除成功", "200", page, list);
    }

    @RequestMapping(value = "/send/seconds/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getSecondSend(@PathVariable Integer id ) {
        SecondSend second = secondSendService.getSecondSend(id);
        return new Result("删除成功", "200", second);
    }
}
