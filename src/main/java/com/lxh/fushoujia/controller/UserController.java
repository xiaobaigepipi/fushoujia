package com.lxh.fushoujia.controller;

import com.lxh.fushoujia.pojo.Role;
import com.lxh.fushoujia.pojo.User;
import com.lxh.fushoujia.service.UserService;
import com.lxh.fushoujia.pojo.Page;
import com.lxh.fushoujia.util.Util;
import com.lxh.fushoujia.util.JwtUtil;
import com.lxh.fushoujia.util.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.HtmlUtils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: fushoujia
 * @description:
 * @author: Mr.Wang
 * @create: 2019-10-09 14:26
 **/
@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public User listUser(HttpServletRequest request) {
        String token = request.getHeader("token");
        if (token == null) {
            return null;
        }
        int id = JwtUtil.getUserId(token);
        //System.out.println(id);
        User user = userService.getUser(id);

        System.out.println(user.getHeadImage());
        return user;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestBody User user, HttpServletRequest request) {
        Result result = new Result();
        user.setEmail(HtmlUtils.htmlEscape(user.getEmail()));
        //List<User> list = userService.list();

        User u = userService.listByEmail(user.getEmail());
        //System.out.println(u);
        //判断登录账号是否存在
        if (u == null) {
            result.setCode("404");
            result.setMessage("账号不存在，请联系管理员处理！");
            //u.setPassword(user.getPassword());
        }
        else {
            //判断登录失败次数
            if (u.getFailNumber() > 5) {
                result.setCode("404");
                result.setMessage("账号已锁定，请联系管理员！");
                return result;
            }
            //判断密码是否正确
            User u1 = userService.listByLogin(user.getEmail(), user.getPassword());
            if (u1 == null) {
                result.setCode("404");
                result.setMessage("账号密码错误，请联系管理员处理！");
                //System.out.println(u.getId());
                u.setFailNumber(u.getFailNumber() + 1);
                userService.updateFailNumber(u);
            } else {
                //request.getSession().setAttribute("loginUser", u1);
                result.setToken(JwtUtil.sign(u1.getEmail(), u1.getId()));
                result.setCode("200");
                result.setMessage("登录成功");
                u.setFailNumber(0);
                userService.updateFailNumber(u);
            }
        }
        return result;

    }
    /*
    * 获取角色
    * */
    @RequestMapping(value = "/all/roles", method = RequestMethod.GET)
    @ResponseBody
    public Result getRoles() {
        List<Role> list = userService.listRole();
        return new Result("查询成功", "200", list);
    }

    /*
    * 检查用户名是否相同
    * */
    @RequestMapping(value = "/all/users", method = RequestMethod.GET)
    @ResponseBody
    public Result checkUserName(@Param("userName") String userName, @Param("email") String email) {
        try {
            userName = URLDecoder.decode(userName, "UTF-8");
        } catch (Exception e) {

        }
        Map<String, String> map = new HashMap<>();
        map.put("userName", userName);
        map.put("email", email);
        int number = userService.checkUserName(map);
        //System.out.println(userName);
        //System.out.println(email);
        if (number > 0) {
            return new Result("有相同用户名称", "404");
        }
        return new Result("没有相同用户名称", "200");
    }

    /*
     * 新增用户
     * */
    @RequestMapping(value = "/adduser/users", method = RequestMethod.POST)
    @ResponseBody
    public Result addUser(User user, MultipartFile file, HttpServletRequest request) {
        if (file != null) {
            user.setHeadImage(true);
        } else {
            user.setHeadImage(false);
        }
        userService.addUser(user);
        int userId = user.getId();
        //System.out.println(file);
        //System.out.println(userId);
        List<Role> list = user.getRoles();
        for (Role role : list) {
            userService.addUserRole(userId, role.getId());
        }

        //判断文件是否为空
        if(file != null) {
            //获取项目存放用户头像路径
            String path = request.getServletContext().getRealPath("/src/static/img/user");
            //System.out.println(path);

            //获取原文件名
            String filename = file.getOriginalFilename();
            //System.out.println(filename);

            //
            File f = new File(path, userId+ ".jpg");
            //前端显示的文件，在开发环境中有
            String newpath= "D:\\web\\fushoujia\\src\\static\\img\\user";
            File newfile = new File(newpath, userId + ".jpg" );
            System.out.println(f.getAbsolutePath());
            //判断文件夹是否存在
            if (!f.getParentFile().exists()) {
                f.getParentFile().mkdirs();
            }

            //传递文件
            try {
                //file.transferTo(f);
                file.transferTo(newfile);
                //返回jpg格式的图片
                BufferedImage bi = Util.changeJpg(newfile);
                //以jpg格式写进文件
                ImageIO.write(bi, "jpg", newfile);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return new Result("新增用户信息成功", "200");
    }

    /*
    * 修改用户信息
    * */
    @RequestMapping(value = "/all/users/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Result updateUser(User user, @RequestParam(value = "file", required = false) MultipartFile file, @PathVariable Integer id, HttpServletRequest request) {
        User u = userService.getUser(id);
        if (u.getHeadImage() == null) {
            u.setHeadImage(false);
        }
        user.setHeadImage(u.getHeadImage());
        if (file != null) {
            if (!u.getHeadImage()){
                user.setHeadImage(true);
            }

            //获取项目路径
            String path = request.getServletContext().getRealPath("/src/static/img/user");
            String newpath= "D:\\web\\fushoujia\\src\\static\\img\\user";
            File newfile = new File(newpath, user.getId() + ".jpg" );
            File f = new File(path,user.getId() + ".jpg");
            try {
                file.transferTo(newfile);
                //修改成jpg格式
                BufferedImage bf = Util.changeJpg(newfile);
                ImageIO.write(bf, "jpg", newfile);
            } catch (IOException e) {

            }
        }

        userService.updateUser(user);

        return new Result("修改成功", "200");
    }

    /*
    * 修改密码
    * */
    @RequestMapping(value = "/all/passwords/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result updatePassword(@RequestBody User user, @PathVariable Integer id) {
        userService.updatePassword(user);
        return new Result("修改密码成功", "200");
    }

    /*
    * 判断原密码是否正确
    * */
    @RequestMapping(value = "/all/passwords/{id}", method = RequestMethod.GET )
    @ResponseBody
    public Result checkPassword(String password, @PathVariable Integer id) {
        User user = userService.getUser(id);
        System.out.println(user.getPassword());
        System.out.println(password);
        if (user.getPassword().equals(password)) {
            return new Result("密码正确", "200");
        }
        return new Result("原密码错误", "404");
    }

    /*
    * 获取user数组
    * */
    @RequestMapping(value = "/action/users", method = RequestMethod.GET)
    @ResponseBody
    public Result listUser(Page page){
        List<User> list = userService.list(page);
        page.setTotal(userService.getTotal(page));
        return new Result("查询成功！", "200", page, list);
    }

    /*
    * 修改用户信息,使用的json格式传递数据
    * */
    @RequestMapping(value="/action/users/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateUserByAction(@RequestBody User user, @PathVariable Integer id) {
        userService.updateUser(user);
        return new Result("修改用户信息成功", "200");
    }

    /*
    * 重新设置用户权限角色
    * */
    @RequestMapping(value="/action/roles/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Result updateUserRoles(@RequestBody List<Integer> selectRoles, @PathVariable Integer id) {
        userService.deleteUserRole(id);
        for (Integer i : selectRoles) {
            userService.addUserRole(id, i);
            //System.out.println(i);
        }
        return new Result("设置用户权限成功", "200");
    }
}
