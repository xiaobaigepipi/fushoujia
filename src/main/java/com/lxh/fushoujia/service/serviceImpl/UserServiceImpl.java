package com.lxh.fushoujia.service.serviceImpl;

import com.lxh.fushoujia.mapper.BasicMapper;
import com.lxh.fushoujia.mapper.UserMapper;
import com.lxh.fushoujia.pojo.Page;
import com.lxh.fushoujia.pojo.Role;
import com.lxh.fushoujia.pojo.User;
import com.lxh.fushoujia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @program: fushoujia
 * @description:
 * @author: Mr.Wang
 * @create: 2019-10-09 14:17
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    BasicMapper basic;

    @Override
    public int getTotal(Page page) {
        return userMapper.getTotal(page);
    }

    @Override
    public List<User> list(Page page) {
        return userMapper.list(page);
    }

    @Override
    public User listByLogin(String email, String password) {
        return userMapper.listByLogin(email, password);
    }

    @Override
    public User listByEmail(String email) {
        return userMapper.listByEmail(email);
    }

    @Override
    public void updateFailNumber(User user) {
        userMapper.updateFailNumber(user);
    }

    @Override
    public User getUser(int id) {
        User user =  userMapper.getUser(id);
        user.setDepartment(basic.getDepartment(user.getDepartmentId()));
        user.setPosition(basic.getPosition(user.getPositionId()));
        return user;
    }

    @Override
    public List<Role> listRole() {
        return userMapper.listRole();
    }

    @Override
    public int checkUserName(Map<String, String> map) {
        return userMapper.checkUserName(map);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int addUserRole(int userId, int roleId) {
        return userMapper.addUserRole(userId, roleId);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int updatePassword(User user) {
        return userMapper.updatePassword(user);
    }

    @Override
    public void deleteUserRole(int id) {
        userMapper.deleteUserRoles(id);
    }
}
