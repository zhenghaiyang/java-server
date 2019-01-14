package com.example.dongyaouterdata.user.service;
import com.example.dongyaouterdata.user.model.Position;
import com.example.dongyaouterdata.user.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    // 根据账号面获取用户信息
    User findOneUser(String userCode,String userPassword);
    // 根据用户类型获取菜单
    List findMenuByUserType(String userType);
    // 新增用户
    Integer addUser(User user);
    // 获取全部用户
    List<User> getAllUser();
    // 获取全部职位
    List<Position> getAllPosition();
    // 重置密码
    Integer resetPassword(User user);
    // 根据用户id删除用户
    Integer delUserByid(User user);
    // 根据用户账号检查是否有相同
    List<User> selectUserByUserCode(User user);
}
