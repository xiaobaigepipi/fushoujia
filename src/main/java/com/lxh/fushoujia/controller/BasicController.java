package com.lxh.fushoujia.controller;

import com.lxh.fushoujia.pojo.*;
import com.lxh.fushoujia.service.BasicService;
import com.lxh.fushoujia.service.UserService;
import com.lxh.fushoujia.util.JwtUtil;
import com.lxh.fushoujia.util.Result;
import com.lxh.fushoujia.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @program: fushoujia
 * @description: 基础数据的控制器
 * @author: Mr.Wang
 * @create: 2019-10-15 16:42
 **/
@Controller
@RequestMapping("")
public class BasicController {

    @Autowired
    BasicService basicService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/basic/departments", method = RequestMethod.GET)
    @ResponseBody
    public Result listDepartment(HttpServletRequest request) {
        List<Department> list = basicService.listDepartment();
        Result result = new Result("数据获取成功", "200",  list);
        return result;
    }

    /*
    * 新增部门信息
    * */
    @RequestMapping(value = "/basic/departments", method = RequestMethod.POST)
    @ResponseBody
    public Result addDepartment(@RequestBody Department department) {
        Date d = new Date();
        String number = d.getTime() + "" + (int)(Math.random()*1000);
        department.setCode(number);
        basicService.addDepartment(department);
        Result result = new Result("保存成功", "200");
        return result;
    }

    /*
    * 修改部门信息
    * */
    @RequestMapping(value = "/basic/departments/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateDepartment(@RequestBody Department department, @PathVariable Integer id) {
        basicService.updateDepartment(department);
        //System.out.println(department.isDelete());
        Result result = new Result("修改成功", "200");
        return result;
    }

    /*
    * 查询职务信息
    * */
    @RequestMapping(value = "/basic/positions", method = RequestMethod.GET)
    @ResponseBody
    public Result listPosition() {
        List<Position> list = basicService.listPosition();
        Result result =new Result("查询成功", "200", list);
        return result;
    }

    /*
    * 增加职务信息
    * */
    @RequestMapping(value = "/basic/positions", method = RequestMethod.POST)
    @ResponseBody
    public Result addPosition(@RequestBody Position position) {
        int id = basicService.addPosition(position);
        Result result = new Result("保存成功", "200",  id);
        return result;
    }

    /*
    * 修改职务信息
    * */
    @RequestMapping(value = "/basic/positions/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result updatePosition(@RequestBody Position position, @PathVariable Integer id) {
        basicService.updatePosition(position);
        Result r = new Result("修改成功", "200");
        return r;
    }

    /*
    * 查询收支类别
    * */
    @RequestMapping(value = "/all/incomeouts", method = RequestMethod.GET)
    @ResponseBody
    public Result listIncomeout() {
        List<IncomeOutCategory> list = basicService.listIncomeOutCategory();
        Result result = new Result("查询成功", "200", list);
        return result;
    }

    /*
    * 增加收支类别
    *
    * */
    @RequestMapping(value = "/basic/incomeouts", method = RequestMethod.POST)
    @ResponseBody
    public Result addIncomout(@RequestBody IncomeOutCategory in) {
        int id = basicService.addIncomeOutCategory(in);
        return new Result("保存成功", "200", id);
    }

    /*
    * 修改收支类别
    * */
    @RequestMapping(value = "/basic/incomeouts/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateIncomout(@RequestBody IncomeOutCategory in, @PathVariable Integer id) {
        basicService.updateIncomeOutCategory(in);
        return new Result("修改成功", "200");
    }

    /*
    * 删除收支类别
    * */
    @RequestMapping(value = "/basic/incomeouts/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteIncomeout(@PathVariable Integer id) {
        basicService.deleteIncomeOutCategory(id);
        return new Result("删除成功", "200");
    }


    /*
     * 查询供应商类型
     * */
    @RequestMapping(value = "/all/supplierTypes", method = RequestMethod.GET)
    @ResponseBody
    public Result listSupplier() {
        List<SupplierType> list = basicService.listSupplierType();
        Result result = new Result("查询成功", "200", list);
        return result;
    }

    /*
     * 增加供应商类型
     *
     * */
    @RequestMapping(value = "/basic/supplierTypes", method = RequestMethod.POST)
    @ResponseBody
    public Result addSupplier(@RequestBody SupplierType supplier) {
        int id = basicService.addSupplierType(supplier);
        return new Result("保存成功", "200", id);
    }

    /*
     * 修改供应商类型
     * */
    @RequestMapping(value = "/basic/supplierTypes/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateSupplier(@RequestBody SupplierType supplier, @PathVariable Integer id) {
        basicService.updateSupplierType(supplier);
        return new Result("修改成功", "200");
    }

    /*
     * 删除供应商类型
     * */
    @RequestMapping(value = "/basic/supplierTypes/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteSupplier(@PathVariable Integer id) {
        basicService.deleteSupplierType(id);
        return new Result("删除成功", "200");
    }


    /*
     * 查询项目类型
     * */
    @RequestMapping(value = "/all/projectTypes", method = RequestMethod.GET)
    @ResponseBody
    public Result listProjectType() {
        List<ProjectType> list = basicService.listProjectType();
        Result result = new Result("查询成功", "200", list);
        return result;
    }


    /*
     * 增加项目类型
     *
     * */
    @RequestMapping(value = "/basic/projectTypes", method = RequestMethod.POST)
    @ResponseBody
    public Result addProjectType(@RequestBody ProjectType projectType) {
        int id = basicService.addProjectType(projectType);
        return new Result("保存成功", "200", id);
    }

    /*
     * 修改项目类型
     * */
    @RequestMapping(value = "/basic/projectTypes/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateProjectType(@RequestBody ProjectType projectType, @PathVariable Integer id) {
        basicService.updateProjectType(projectType);
        return new Result("修改成功", "200");
    }

    /*
     * 删除项目类型
     * */
    @RequestMapping(value = "/basic/projectTypes/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteProjectType(@PathVariable Integer id) {
        basicService.deleteProjectType(id);
        return new Result("删除成功", "200");
    }


    /*
     * 查询项目属性
     * */
    @RequestMapping(value = "/all/projectPropertys", method = RequestMethod.GET)
    @ResponseBody
    public Result listProjectProperty() {
        List<ProjectProperty> list = basicService.listProjectProperty();
        Result result = new Result("查询成功", "200", list);
        return result;
    }


    /*
     * 增加项目属性
     *
     * */
    @RequestMapping(value = "/basic/projectPropertys", method = RequestMethod.POST)
    @ResponseBody
    public Result addProjectProperty(@RequestBody ProjectProperty projectProperty) {
        int id = basicService.addProjectProperty(projectProperty);
        return new Result("保存成功", "200", id);
    }

    /*
     * 修改项目属性
     * */
    @RequestMapping(value = "/basic/projectPropertys/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateProjectProperty(@RequestBody ProjectProperty projectProperty, @PathVariable Integer id) {
        basicService.updateProjectProperty(projectProperty);
        return new Result("修改成功", "200");
    }

    /*
     * 删除项目属性
     * */
    @RequestMapping(value = "/basic/projectPropertys/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteProjectProperty(@PathVariable Integer id) {
        basicService.deleteProjectProperty(id);
        return new Result("删除成功", "200");
    }



    /*
     * 查询省份
     * */
    @RequestMapping(value = "/basic/provinces", method = RequestMethod.GET)
    @ResponseBody
    public Result listProvince() {
        List<Province> list = basicService.listProvince();
        Result result = new Result("查询成功", "200", list);
        return result;
    }

    @RequestMapping(value = "/basic/provinces/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getProvince(@PathVariable Integer id) {
        Province p = basicService.getProvince(id);
        Result result = new Result("查询成功", "200", p);
        return result;
    }

    /*
     * 增加省份
     *
     * */
    @RequestMapping(value = "/basic/provinces", method = RequestMethod.POST)
    @ResponseBody
    public Result addProvince(@RequestBody Province province) {
        int id = basicService.addProvince(province);
        return new Result("保存成功", "200", id);
    }

    /*
     * 修改省份
     * */
    @RequestMapping(value = "/basic/provinces/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateProvince(@RequestBody Province province, @PathVariable Integer id) {
        basicService.updateProvince(province);
        return new Result("修改成功", "200");
    }

    /*
     * 删除省份
     * */
    @RequestMapping(value = "/basic/provinces/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteProvince(@PathVariable Integer id) {
        //basicService.deleteProvince(id);
        try {
            basicService.deleteProvince(id);
        } catch (Exception e) {
            //e.printStackTrace();
            return new Result("删除失败，请检查是否有相关隶属城市信息", "404");
        }

        return new Result("删除成功", "200");
    }


    /*
     * 查询城市
     * */
    @RequestMapping(value = "/basic/citys", method = RequestMethod.GET)
    @ResponseBody
    public Result listCity(Integer id) {
        List<City> list = basicService.listCity(id);
        Result result = new Result("查询成功", "200", list);
        return result;
    }
    @RequestMapping(value = "/basic/citys/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getCity(@PathVariable Integer id) {
        City c = basicService.getCity(id);
        Result result = new Result("查询成功", "200", c);
        return result;
    }



    /*
     * 增加城市
     * */
    @RequestMapping(value = "/basic/citys", method = RequestMethod.POST)
    @ResponseBody
    public Result addCity(@RequestBody City City) {
        int id = basicService.addCity(City);
        return new Result("保存成功", "200", id);
    }

    /*
     * 修改城市
     * */
    @RequestMapping(value = "/basic/citys/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateCity(@RequestBody City City, @PathVariable Integer id) {
        basicService.updateCity(City);
        return new Result("修改成功", "200");
    }

    /*
     * 删除城市
     * */
    @RequestMapping(value = "/basic/citys/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteCity(@PathVariable Integer id) {
        try {
            basicService.deleteCity(id);
        } catch (Exception e) {
            //e.printStackTrace();
            return new Result("删除失败，请检查是否有相关隶属地区信息", "404");
        }
        return new Result("删除成功", "200");
    }

    /*
     * 查询地区
     * */
    @RequestMapping(value = "/basic/areas", method = RequestMethod.GET)
    @ResponseBody
    public Result listArea(Integer id) {
        List<Area> list = basicService.listArea(id);
        Result result = new Result("查询成功", "200", list);
        return result;
    }


    /*
     * 增加地区
     *
     * */
    @RequestMapping(value = "/basic/areas", method = RequestMethod.POST)
    @ResponseBody
    public Result addArea(@RequestBody Area Area) {
        int id = basicService.addArea(Area);
        return new Result("保存成功", "200", id);
    }

    /*
     * 修改地区
     * */
    @RequestMapping(value = "/basic/areas/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateArea(@RequestBody Area Area, @PathVariable Integer id) {
        basicService.updateArea(Area);
        return new Result("修改成功", "200");
    }

    /*
     * 删除地区
     * */
    @RequestMapping(value = "/basic/areas/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteArea(@PathVariable Integer id) {
        basicService.deleteArea(id);
        return new Result("删除成功", "200");
    }





}
