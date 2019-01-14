package com.example.dongyaouterdata.user.service.impl;
import com.example.dongyaouterdata.user.model.Position;
import com.example.dongyaouterdata.user.model.User;
import com.example.dongyaouterdata.user.service.UserService;
import com.example.dongyaouterdata.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findOneUser(String userCode,String userPassword){
        User user = userDao.findOneUser(userCode,userPassword);
        return user;
    }

    @Override
    public List findMenuByUserType(String userType) {
        return userDao.findMenuByUserType(userType);
    }

    @Override
    public Integer addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public List<Position> getAllPosition() {
        return userDao.getAllPosition();
    }

    @Override
    public Integer resetPassword(User user) {
        return userDao.resetPassword(user);
    }

    @Override
    public Integer delUserByid(User user) {
        return userDao.delUserByid(user);
    }

    @Override
    public List<User> selectUserByUserCode(User user){return userDao.selectUserByUserCode(user);}
}

