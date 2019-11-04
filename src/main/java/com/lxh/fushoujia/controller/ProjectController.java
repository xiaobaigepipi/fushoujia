package com.lxh.fushoujia.controller;

import com.lxh.fushoujia.pojo.Page;
import com.lxh.fushoujia.pojo.Project;
import com.lxh.fushoujia.service.ProjectService;
import com.lxh.fushoujia.util.Result;
import com.lxh.fushoujia.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @PackageName: com.lxh.fushoujia.controller
 * @ClassName: ProjectController
 * @Description:
 * @author: 辉
 * @date: 2019/11/4 18:57
 * */
@Controller
@RequestMapping("")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/project", method = RequestMethod.GET)
    @ResponseBody
    public Result listProject(Project project, @RequestParam("start")Integer start, @RequestParam("count")Integer count, @RequestParam("year") String year, @RequestParam("month") String month, @RequestParam("date") String date) {
        System.out.println(month);
        Map<String, Object> map = new HashMap<>();
        if (year == null || year.length() == 0) {
            map.put("year", 0);
        } else {
            map.put("year", Integer.parseInt(year));
        }

        if (month == null || month.length() == 0) {
            map.put("month", 0);
        } else {
            map.put("month", Integer.parseInt(month));
        }
        if (date == null || date.length() == 0) {
            map.put("projectDate", null);
        } else {
            map.put("projectDate", date);
        }

        map.put("start", start);
        map.put("count", count);
        map.put("type", Util.decode(project.getType()));
        map.put("name", Util.decode(project.getName()));
        map.put("property", Util.decode(project.getProperty()));
        map.put("principal", Util.decode(project.getPrincipal()));

        int total = projectService.getTotal(map);
        Page page = new Page();
        page.setTotal(total);
        page.setStart(start);
        page.setCount(count);
        List<Project> list = projectService.listProject(map);
        return new Result("查询成功", "200", page, list);
    }
}













