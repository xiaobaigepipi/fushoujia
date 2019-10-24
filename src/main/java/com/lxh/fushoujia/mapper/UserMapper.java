package com.lxh.fushoujia.mapper;

import com.lxh.fushoujia.pojo.Page;
import com.lxh.fushoujia.pojo.Role;
import com.lxh.fushoujia.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> list(Page page);
    User listByLogin(@Param("email") String email, @Param("password") String password);
    User listByEmail(@Param("email") String email);
    void updateFailNumber(User user);
    User getUser(int id);
    int getTotal(Page page);

    //查找角色
    List<Role> listRole();

    //检查是否有相同用户名
    int checkUserName(Map<String, String> map);

    int addUser(User user);
    int addUserRole(@Param("userId")int userId, @Param("roleId")int roleId );

    //修改用户信息
    int updateUser(User user);
    //修改密码
    int updatePassword(User user);
    //删除用户角色表
    void deleteUserRoles(@Param("id") int id);
}
