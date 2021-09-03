package com.lxh.fushoujia.controller;

import com.github.pagehelper.util.StringUtil;
import com.lxh.fushoujia.pojo.*;
import com.lxh.fushoujia.service.BudgetService;
import com.lxh.fushoujia.service.FirstSendService;
import com.lxh.fushoujia.service.ProjectService;
import com.lxh.fushoujia.util.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

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

    @Autowired
    BudgetService budgetService;

    @Autowired
    FirstSendService firstSendService;


    @RequestMapping(value = "/project/work/project", method = RequestMethod.GET)
    @ResponseBody
    public Result listProject() {
        Map<String, Object> map = new HashMap<>();

        map.put("year", 0);
        map.put("month", 0);


        map.put("start", 0);
        map.put("count", Integer.MAX_VALUE);
        map.put("status","toApproval");
        //int total = projectService.getTotal(map);

        List<Project> list = projectService.listProject(map);
        return new Result("查询成功", "200", list);
    }


    @RequestMapping(value = "/project/work/contract", method = RequestMethod.GET)
    @ResponseBody
    public Result listProject(HttpServletRequest request, String status, String contract) {
        String token = request.getHeader("token");
        int id = JwtUtil.getUserId(token);
        Map<String, Object> map = new HashMap<>();

        map.put("year", 0);
        map.put("month", 0);


        map.put("start", 0);
        map.put("count", Integer.MAX_VALUE);
        map.put("contract", contract);
        map.put("userId", id);
        map.put("status", status);
        //int total = projectService.getTotal(map);

        List<Project> list = projectService.listProject(map);
        return new Result("查询成功", "200", list);
    }

    @RequestMapping(value = "/project", method = RequestMethod.GET)
    @ResponseBody
    public Result listProject(Project project, @RequestParam("start")Integer start, @RequestParam("count")Integer count, @RequestParam("year") String year, @RequestParam("month") String month, @RequestParam("date") String date) {
        //System.out.println(month);
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

    @RequestMapping(value = "/project", method = RequestMethod.POST)
    @ResponseBody
    public Result addProject(@RequestBody Project project) {
        //获取周期
        long start = project.getStartDate().getTime();
        long end = project.getEndDate().getTime();
        int cycle = Integer.parseInt(String.valueOf(((end-start)/(1000*60*60*24))));
        project.setCycle(cycle);
        //设置项目状态
        project.setStatus(ProjectStatus.toSave);
        String city = project.getCity();
        String newCity = "";
        //去掉城市的市字
        for (int i = 0; i < city.length(); i++) {
            if (city.charAt(i) != '市') {
                newCity += city.charAt(i);
            }
        }
        //获取城市首字母
        String pinyin = ChineseUtil.getFirstPinyin(newCity);

        //获取最后一个项目编号
        String code = projectService.getCode();

        //检查有多少个字母
        int count = 0;
        char[] cs = code.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (Character.isLetter(cs[i])) {
                count++;
            }
        }
        if (count == 0) {
            count = 1;
        }
        //获取编号中的年份
        int oldYear = Integer.parseInt(code.substring(count, count+4));
        //获取今年
        int newYear = Calendar.getInstance().get(Calendar.YEAR);
        //取得增加后的编号
        int number = Integer.parseInt(code.substring(count+4)) + 1;
        String newCode;
        if (newYear > oldYear) {
            newCode = pinyin + newYear + "001";
        } else {
            String newNumber;
            if (number < 10) {
                newNumber = "00" + number;
            } else if (number < 100 && number >= 10) {
                newNumber = "0" + number;
            } else {
                newNumber = String.valueOf(number);
            }
            newCode = pinyin + newYear + newNumber;
        }
        project.setCode(newCode);
        projectService.addProject(project);
        return new Result("提交成功", "200", project);
    }

    @RequestMapping(value = "/project", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateProject(@RequestBody Project project) {
        if (project.getStartDate() != null) {
            long start = project.getStartDate().getTime();
            long end = project.getEndDate().getTime();
            int cycle = Integer.parseInt(String.valueOf(((end-start)/(1000*60*60*24))));
            project.setCycle(cycle);
        }

        projectService.updateProject(project);
        return new Result("修改成功", "200");
    }

    @RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getProject(@PathVariable Integer id) {
        Project p = projectService.getProject(id);
        return new Result("获取成功", "200", p);
    }

    @RequestMapping(value = "/project/budget", method = RequestMethod.POST)
    @ResponseBody
    public Result addBudget(@RequestBody Budget budget) {
        budgetService.addBudget(budget);
        return new Result("新增成功", "200", budget);
    }

    @RequestMapping(value = "/project/budget", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateBudget(@RequestBody Budget budget) {
        budgetService.updateBudget(budget);
        int id = budget.getProjectId();
        Project p = new Project();
        p.setId(id);
        p.setSubject(budget.getExpectedIncome());
        p.setStatus(budget.getStatus());
        if (budget.getStatus().equals("review")) {
            p.setStatus("toApproval");
        }
        projectService.updateProject(p);
        return new Result("新增成功", "200", budget);
    }

    @RequestMapping(value = "/project/budgetRemark", method = RequestMethod.POST)
    @ResponseBody
    public Result addBudget(@RequestBody BudgetRemark budgetRemark) {
        budgetService.addBudgetRemark(budgetRemark);
        return new Result("新增成功", "200");
    }

    @RequestMapping(value = "/project/budgetRemark", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateBudgetRemark(@RequestBody BudgetRemark budgetRemark) {
        budgetService.updateBudgetRemark(budgetRemark);
        return new Result("新增成功", "200");
    }

    @RequestMapping(value = "/project/budget", method = RequestMethod.GET)
    @ResponseBody
    public Result getBudget(@RequestParam("projectId") Integer projectId) {
        Budget b = budgetService.getBudget(projectId);
        return new Result("新增成功", "200", b);
    }

    @RequestMapping(value = "/project/budget/account", method = RequestMethod.GET)
    @ResponseBody
    public Result getBudgetByTrue(@RequestParam("projectId") Integer projectId) {
        Budget b = budgetService.getBudgetByTrue(projectId);
        return new Result("新增成功", "200", b);
    }

    @RequestMapping(value = "/project/budgetRemark", method = RequestMethod.GET)
    @ResponseBody
    public Result getBudgetRemark(@RequestParam("budgetId") Integer budgetId) {
        BudgetRemark b = budgetService.getBudgetRemark(budgetId);
        return new Result("新增成功", "200", b);
    }

    @RequestMapping(value = "/budget", method = RequestMethod.GET)
    @ResponseBody
    public Result listBudget(Page page) {
        page.setSearchKey(Util.decode(page.getSearchKey()));
        List<Budget> list = budgetService.listBudget(page);
        int total = budgetService.getTotal(page);
        page.setTotal(total);

        return new Result("查询成功", "200", page, list);
    }


    @RequestMapping(value = "/send/projects", method = RequestMethod.GET)
    @ResponseBody
    public Result listProjectFirstSend(Project project, @RequestParam("start")Integer start, @RequestParam("count")Integer count, @RequestParam("year") String year, @RequestParam("month") String month, @RequestParam("date") String date) {
        //System.out.println(month);
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
        List<Project> projects = new ArrayList<>();
        for (Project p : list) {
            List<FirstSend> firstSends = firstSendService.listFirstSend(p.getId());
            //System.out.println(firstSends);
            if (firstSends.size() != 0) {
                p.setFirstSends(firstSends);
                projects.add(p);
            }
        }

        return new Result("查询成功", "200", page, projects);
    }



    @RequestMapping(value = "/budget/payment", method = RequestMethod.GET)
    @ResponseBody
    public Result listPaymentNode(@RequestParam("projectId") Integer id) {
       List<PaymentNode> list = projectService.listPaymentNode(id);
       return new Result("查询成功", "200", list);
    }

    @RequestMapping(value = "/budget/payment", method = RequestMethod.PUT)
    @ResponseBody
    public Result listPaymentNode(@RequestBody PaymentNode paymentNode) {
        projectService.updatePaymentNode(paymentNode);
        return new Result("修改成功", "200");
    }

    @RequestMapping(value = "/project/payment", method = RequestMethod.POST)
    @ResponseBody
    public Result addPaymentNode(@RequestBody List<PaymentNode> paymentNodes) {
        int projectId = 0;
        for (PaymentNode p : paymentNodes) {
            projectId = p.getProjectId();
            projectService.addPaymentNode(p);
        }
        Project pp = new Project();
        pp.setId(projectId);
        pp.setContract(ProjectStatus.contract);
        pp.setAcceptDate(new Date());
        projectService.updateProject(pp);
        return new Result("修改成功", "200");
    }

    @RequestMapping(value = "/accept/post", method = RequestMethod.POST)
    @ResponseBody
    public Result addImg(@RequestParam("projectId") Integer projectId, @RequestParam("files") MultipartFile[] files, HttpServletRequest request) {
        if (files == null || files.length == 0) {
            return new Result("上传成功", "200");
        }
        //获取保存文件的路径
        String path = request.getServletContext().getRealPath("/uploadFiles/project");
        for (int i = 0; i < files.length; i++) {
            //获取原文件名
            String filename = files[i].getOriginalFilename();
            //获取文件后缀名
            int index = StringUtils.indexOf(filename, '.');
            String suffix = StringUtils.substring(filename, index+1);
            //生成新的文件名
            long times = new Date().getTime();
            int random = Math.round((float)Math.random() * 10000);
            //System.out.println(random);
            String newFilename = times + "" + random + "." + suffix;

            Document document = new Document();
            document.setType(suffix);
            document.setName(filename);
            document.setUrl("http://127.0.0.1:8080/uploadFiles/project/"  + newFilename);
            document.setProjectId(projectId);
            projectService.addDocument(document);
            System.out.println(path);
            //String newpath= "D:\\web\\fushoujia\\src\\static\\img\\project";

            File file = new File(path, newFilename);
            if (!file.getParentFile().exists()) {
                file.mkdirs();
            }

            //传递文件
            try{
                files[i].transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Project p = new Project();
        p.setId(projectId);
        p.setAccept(ProjectStatus.accept);
        projectService.updateProject(p);
        return new Result("上传成功", "200");
    }


    @RequestMapping(value = "/accept/get", method = RequestMethod.GET)
    @ResponseBody
    public Result listImg(@RequestParam("projectId") Integer id) {
        List<Document> list = projectService.listDocumentByProject(id);
        return new Result("查询成功", "200", list);
    }

}













