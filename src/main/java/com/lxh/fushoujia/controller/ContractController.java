package com.lxh.fushoujia.controller;

import com.lxh.fushoujia.pojo.Contract;
import com.lxh.fushoujia.pojo.Document;
import com.lxh.fushoujia.pojo.Page;
import com.lxh.fushoujia.pojo.Project;
import com.lxh.fushoujia.service.ContractService;
import com.lxh.fushoujia.service.ProjectService;
import com.lxh.fushoujia.util.Result;
import com.lxh.fushoujia.util.Util;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @PackageName: com.lxh.fushoujia.controller
 * @ClassName: ContractController
 * @Description:
 * @author: 辉
 * @date: 2019/11/19 15:29
 * */
@Controller
@RequestMapping("")
public class ContractController {

    @Autowired
    ContractService contractService;
    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/contracts", method = RequestMethod.GET)
    @ResponseBody
    public Result listContract(Page page, @RequestParam("type") String type) {
        page.setSearchKey(Util.decode(page.getSearchKey()));
        Map<String, Object> map = new HashMap<>();
        map.put("start", page.getStart());
        map.put("count", page.getCount());
        map.put("searchKey", page.getSearchKey());
        map.put("type", type);
        List<Contract> list = contractService.listContract(map);

        map.put("start", 0);
        map.put("count", Integer.MAX_VALUE);
        List<Contract> max = contractService.listContract(map);

        page.setTotal(max.size());

        return new Result("查询成功", "200", page, list);

    }

    @RequestMapping(value = "/contracts/delete", method = RequestMethod.PUT)
    @ResponseBody
    public Result deleteContract(@RequestBody Integer[] ids, HttpServletRequest request) {
        String path = request.getServletContext().getRealPath("/uploadFiles/document");
        String newpath= "http://127.0.0.1:8080/uploadFiles/document/";
        for (int i = 0; i < ids.length; i++) {
            contractService.deleteContract(ids[i]);
            List<Document> list = projectService.listDocumentByContract(ids[i]);
            for (Document d : list) {
                String url = d.getUrl();
                String[] urls = StringUtils.split(url, '/');
                String filename = urls[urls.length-1];
                //System.out.println(filename);
                File f = new File(path, filename);
                if (f.exists()) {
                    f.delete();
                }
            }
        }
        return new Result("删除成功", "200");
    }


    @RequestMapping(value = "/contracts/sale", method = RequestMethod.POST)
    @ResponseBody
    public Result addContract(Contract contract, @RequestParam("files")MultipartFile[] files, HttpServletRequest request) {
        Project project = projectService.getProject(contract.getProjectId());
        String code = project.getCode();
        int number = contractService.getTotal(contract.getProjectId(), contract.getType());
        number = number + 1;
        if (number < 10) {
            code = code + "-" + "00" + number;
        } else if (number >10 && number <100) {
            code = code + "-" + "0" + number;
        } else {
            code = code + "-" + number;
        }
        contract.setCode(code);
        contractService.addContract(contract);
        int cid = contract.getId();
        if (files.length == 0 || files == null) {
            return new Result("新增成功", "200", contract);
        }
        String path = request.getServletContext().getRealPath("/uploadFiles/document");
        String newpath= "http://127.0.0.1:8080/uploadFiles/document/";
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            String filename = file.getOriginalFilename();

            int index = StringUtils.indexOf(filename, '.');
            String suffix = StringUtils.substring(filename, index + 1);
            long time = new Date().getTime();
            long random = Math.round(Math.random() * 10000);
            String newFileName = time + random +"." + suffix;
            String url = newpath + newFileName;
            Document document = new Document();
            document.setUrl(url);
            document.setName(filename);
            document.setType(suffix);
            document.setContractId(cid);
            projectService.addDocument(document);

            //String newpath= "D:\\web\\fushoujia\\src\\static\\img\\contract";
            File f = new File(path, newFileName);
            if (!f.getParentFile().exists()) {
                f.mkdirs();
            }

            try {
                file.transferTo(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return new Result("新增成功", "200", contract);
    }

    @RequestMapping(value = "/contracts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result listContract(@PathVariable Integer id) {
        Contract c = contractService.getContract(id);
        List<Document> list = projectService.listDocumentByContract(id);
        return new Result("查询成功", "200", c, list);
    }

    @RequestMapping(value = "/contracts/download/{id}", method = RequestMethod.GET)
    @ResponseBody
    public File download(@PathVariable Integer id, HttpServletResponse response, HttpServletRequest request) {
        Document d = projectService.getDocument(id);
        String downloadName = d.getName();
        String url = d.getUrl();
        String[] urls = StringUtils.split(url, "/");
        String filename = urls[urls.length - 1];
        return Util.download(response, filename, downloadName, request);
    }

    @RequestMapping(value = "/contracts/file/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteFile(@PathVariable Integer id, HttpServletRequest request) {
        String path = request.getServletContext().getRealPath("/uploadFiles/document");
        String newpath= "http://127.0.0.1:8080/uploadFiles/document/";
        Document d = projectService.getDocument(id);
        String url = d.getUrl();
        String[] urls = StringUtils.split(url, '/');
        String filename = urls[urls.length-1];
        //System.out.println(filename);
        File f = new File(path, filename);
        projectService.deleteDocument(id);
        if (f.exists()) {
            f.delete();
        }
        return new Result("删除成功", "200");
    }

    @RequestMapping(value = "/contracts/sale/put", method = RequestMethod.POST)
    @ResponseBody
    public Result updateContract(Contract contract, @RequestParam("files")MultipartFile[] files, HttpServletRequest request) {
        contractService.updateContract(contract);
        int cid = contract.getId();
        System.out.println(cid);
        if (files.length == 0 || files == null) {
            return new Result("新增成功", "200", contract);
        }
        String path = request.getServletContext().getRealPath("/uploadFiles/document");
        String newpath = "http://127.0.0.1:8080/uploadFiles/document/";
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            String filename = file.getOriginalFilename();

            int index = StringUtils.indexOf(filename, '.');
            String suffix = StringUtils.substring(filename, index + 1);
            long time = new Date().getTime();
            long random = Math.round(Math.random() * 10000);
            String newFileName = time + random +"." + suffix;
            String url = newpath + newFileName;
            Document document = new Document();
            document.setUrl(url);
            document.setName(filename);
            document.setType(suffix);
            document.setContractId(cid);
            projectService.addDocument(document);

            //String newpath= "D:\\web\\fushoujia\\src\\static\\img\\contract";
            File f = new File(path, newFileName);
            if (!f.getParentFile().exists()) {
                f.mkdirs();
            }

            try {
                file.transferTo(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return new Result("新增成功", "200", contract);
    }
}
