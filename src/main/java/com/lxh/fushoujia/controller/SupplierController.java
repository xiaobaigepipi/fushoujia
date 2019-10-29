package com.lxh.fushoujia.controller;

import com.lxh.fushoujia.pojo.Page;
import com.lxh.fushoujia.pojo.TSupplier;
import com.lxh.fushoujia.pojo.ZSupplier;
import com.lxh.fushoujia.service.SupplierService;
import com.lxh.fushoujia.util.Result;
import com.lxh.fushoujia.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @PackageName: com.lxh.fushoujia.controller
 * @ClassName: SupplierController
 * @Description:技术供应商和资质供应商的操作
 * @author: 辉
 * @date: 2019/10/28 15:13
 * */
@Controller
@RequestMapping("/")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @RequestMapping(value = "/tsupplier", method = RequestMethod.GET)
    @ResponseBody
    public Result listTSupplier(TSupplier tsupplier, @RequestParam("start") Integer start, @RequestParam("count") Integer count){
        Map<String, Object> map = new HashMap<>();
        map.put("start", start);
        map.put("count", count);
        map.put("name", Util.decode(tsupplier.getName()));
        map.put("code",Util.decode(tsupplier.getCode()));
        map.put("address", Util.decode(tsupplier.getAddress()));
        map.put("contact", Util.decode(tsupplier.getContact()));
        map.put("phone", Util.decode(tsupplier.getPhone()));
        List<TSupplier> list = supplierService.listTSupplier(map);
        int total = supplierService.getTotal(map);
        Page page = new Page();
        page.setCount(count);
        page.setStart(start);
        page.setTotal(total);
        return new Result("查询成功", "200", page, list);
    }

    @RequestMapping(value = "/tsupplier", method = RequestMethod.POST)
    @ResponseBody
    public Result addTSupplier(@RequestBody TSupplier tsupplier) {
        String data = supplierService.getCode();
        String code = Util.getCode(data, "GS");
        tsupplier.setCode(code);
        supplierService.addTSupplier(tsupplier);
        return new Result("新增供应商信息成功", "200", tsupplier);
    }

    @RequestMapping(value = "/tsupplier/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getTSupplier(@PathVariable Integer id) {
        TSupplier tSupplier = supplierService.getTSupplier(id);
        return new Result("查询成功", "200", tSupplier);
    }

    @RequestMapping(value = "/tsupplier/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateTSupplier(@PathVariable Integer id, @RequestBody TSupplier tsupplier) {
        tsupplier.setId(id);
        supplierService.updateTSupplier(tsupplier);
        return new Result("修改供应商信息成功", "200");
    }

    @RequestMapping(value = "/tsupplier", method = RequestMethod.PUT)
    @ResponseBody
    public Result deleteTSupplier(@RequestBody Integer[] ids) {
        for (int i = 0; i < ids.length; i++) {
            TSupplier ts = new TSupplier();
            ts.setId(ids[i]);
            ts.setDelete(true);
            supplierService.updateTSupplier(ts);
        }
        return new Result("删除供应商信息成功", "200");
    }


    @RequestMapping(value = "/zsupplier", method = RequestMethod.GET)
    @ResponseBody
    public Result listZSupplier(Page page) {
        page.setSearchKey(Util.decode(page.getSearchKey()));
        List<ZSupplier> list = supplierService.listZSupplier(page);
        int total = supplierService.getZTotal(page.getSearchKey());
        page.setTotal(total);
        return new Result("查询成功", "200", page, list);
    }

    @RequestMapping(value = "/zsupplier", method = RequestMethod.POST)
    @ResponseBody
    public Result addZSupplier(@RequestBody ZSupplier zsupplier) {
        supplierService.addZSupplier(zsupplier);
        return new Result("新增资质供应商信息成功", "200");
    }

    @RequestMapping(value = "/zsupplier/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateZSupplier(@RequestBody ZSupplier zsupplier, @PathVariable Integer id) {
        zsupplier.setId(id);
        supplierService.updateZSupplier(zsupplier);
        return new Result("修改资质供应商信息成功", "200");
    }

    @RequestMapping(value = "/zsupplier", method = RequestMethod.PUT)
    @ResponseBody
    public Result deleteZSupplier(@RequestBody Integer[] ids) {
        for (int i = 0; i < ids.length; i++) {
            ZSupplier zs = new ZSupplier();
            zs.setId(ids[i]);
            zs.setDelete(true);
            supplierService.updateZSupplier(zs);
        }
        return new Result("删除资质供应商信息成功", "200");
    }

}







