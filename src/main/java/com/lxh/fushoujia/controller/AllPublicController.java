package com.lxh.fushoujia.controller;

import com.lxh.fushoujia.pojo.Department;
import com.lxh.fushoujia.pojo.Position;
import com.lxh.fushoujia.service.BasicService;
import com.lxh.fushoujia.service.UserService;
import com.lxh.fushoujia.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @program: fushoujia
 * @description: 全部公共接口访问，没有权限限制的
 * @author: Mr.Wang
 * @create: 2019-10-18 22:40
 * git更新gitgebfxib
 * 你好我的歌
 **/
@Controller
@RequestMapping("/all")
public class AllPublicController {
    @Autowired
    UserService userService;
    @Autowired
    BasicService basicService;

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
}
