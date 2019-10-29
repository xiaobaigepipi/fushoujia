package com.lxh.fushoujia.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lxh.fushoujia.pojo.FirstProcess;
import com.lxh.fushoujia.pojo.Page;
import com.lxh.fushoujia.pojo.SecondProcess;
import com.lxh.fushoujia.service.ProcessService;
import com.lxh.fushoujia.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * @PackageName: com.lxh.fushoujia.controller
 * @ClassName: ProcessController
 * @Description:
 * @author: 辉
 * @date: 2019/10/29 17:18
 * */
@Controller
@RequestMapping("")
public class ProcessController {
    @Autowired
    ProcessService processService;

    @RequestMapping(value = "/process", method= RequestMethod.GET)
    @ResponseBody
    public Result listFirstProcess(Page page) {
        PageHelper.startPage(page.getStart(), page.getCount());
        List<FirstProcess> list = processService.listFirstProcess();
        PageInfo info = new PageInfo(list);
        page.setTotal((int)info.getTotal());
        return new Result("查询成功", "200", page, list);
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    @ResponseBody
    public Result addFirstProcess(@RequestBody FirstProcess first) {
        processService.addFirstProcess(first);
        return new Result("新增成功", "200");
    }

    @RequestMapping(value = "/process/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateFirstProcess(@RequestBody FirstProcess first, @PathVariable Integer id) {
        first.setId(id);
        processService.updateFirstProcess(first);
        return new Result("修改成功", "200");
    }

    @RequestMapping(value = "/process/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteFirstProcess(@PathVariable Integer id) {
        try {
            processService.deleteFirstProcess(id);
        } catch (Exception e) {
            return new Result("删除失败！请先删除相关二级工序", "404");
        }
       // processService.deleteFirstProcess(id);
        return new Result("删除成功", "200");
    }

    @RequestMapping(value = "/process/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getFirstProcess(@PathVariable Integer id) {
        FirstProcess first = processService.getFirstProcess(id);
        return new Result("查询成功", "200", first);
    }

    @RequestMapping(value = "/process/second", method= RequestMethod.GET)
    @ResponseBody
    public Result listSecondProcess(Page page, @RequestParam("firstId")Integer firstId) {
        PageHelper.startPage(page.getStart(), page.getCount());
        List<SecondProcess> list = processService.listSecondProcess(firstId);
        PageInfo info = new PageInfo(list);
        page.setTotal((int)info.getTotal());
        return new Result("查询成功", "200", page, list);
    }

    @RequestMapping(value = "/process/second", method = RequestMethod.POST)
    @ResponseBody
    public Result addSecondProcess(@RequestBody SecondProcess second) {
        processService.addSecondProcess(second);
        return new Result("新增成功", "200");
    }

    @RequestMapping(value = "/process/second/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateSecondProcess(@RequestBody SecondProcess secondProcess, @PathVariable Integer id) {
        secondProcess.setId(id);
        processService.updateSecondProcess(secondProcess);
        return new Result("修改成功", "200");
    }

    @RequestMapping(value = "/process/second/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteSecondProcess(@PathVariable Integer id) {
        processService.deleteSecondProcess(id);
        return new Result("删除成功", "200");
    }
}
