package com.lxh.fushoujia.service;

import com.lxh.fushoujia.pojo.Page;
import com.lxh.fushoujia.pojo.Role;
import com.lxh.fushoujia.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> list(Page page);
    User listByLogin(String email, String password);
    User listByEmail(String email);
    void updateFailNumber(User user);
    User getUser(int id);
    int getTotal(Page page);

    //查找角色
    List<Role> listRole();

    int checkUserName(Map<String, String> map);

    int addUser(User user);
    int addUserRole(int userId, int roleId );

    //修改用户信息
    int updateUser(User user);
    //修改密码
    int updatePassword(User user);
    //删除用户角色表
    void deleteUserRole(int id);
    //查找全部用户和权限
    List<User> listUserAction();
    List<User> listAllUser();
}
