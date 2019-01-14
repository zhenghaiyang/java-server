package com.example.dongyaouterdata.user.dao.impl;
import com.example.dongyaouterdata.user.model.Position;
import com.example.dongyaouterdata.user.model.User;
import com.example.dongyaouterdata.user.model.Menu;
import com.example.dongyaouterdata.user.dao.UserDao;
import jnr.ffi.annotations.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 根据用户code 和 密码查找用户
    @Override
    public User findOneUser(String userCode,String userPassword) {
        String sql = "SELECT * FROM puser WHERE userCode=? and userPassword=?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        User user = jdbcTemplate.queryForObject(sql, rowMapper, userCode.trim(), userPassword.trim());
        return user;
    }

    // 根据用户类型获取用户权限
    @Override
    public List findMenuByUserType(String userType) {
        String sql = "SELECT * FROM pmenu WHERE userType=?";
        RowMapper<Menu> rowMapper = new BeanPropertyRowMapper<>(Menu.class);
        List<Menu> query = jdbcTemplate.query(sql, rowMapper, userType.trim());
        return query;
    }

    // 添加用户
    @Override
    public Integer addUser(User user) {
        String sql= "INSERT into puser" +
                "(userName,userCode,userPassword,userType,userPositionCode)" +
                "VALUE" +
                "(?,?,?,?,?)";
        Integer rep =jdbcTemplate.update(sql,user.getUserName().trim(),user.getUserCode().trim(),user.getUserPassword().trim(),user.getUserType(),user.getUserPositionCode().trim());
        return rep;
    }

    // 查询全部用户
    @Override
    public List<User> getAllUser() {
        String sql ="SELECT * FROM puser";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        List<User> userList = jdbcTemplate.query(sql,rowMapper);
        return userList;
    }

    // 获取全部职位
    @Override
    public List<Position> getAllPosition() {
        String  sql = "SELECT * FROM pposition";
        RowMapper<Position> rowMapper = new BeanPropertyRowMapper<>(Position.class);
        List<Position> positionList = jdbcTemplate.query(sql,rowMapper);
        return positionList;
    }

    // 重置密码
    @Override
    public Integer resetPassword(User user) {
        String sql = "UPDATE puser SET userPassword = ?" +
                "WHERE id = ?";
        Integer rep =jdbcTemplate.update(sql,user.getUserPassword().trim(),user.getId().toString().trim());
        return rep;
    }

    // 根据用户id删除用户
    @Override
    public Integer delUserByid(User user) {
        String sql ="DELETE FROM puser " +
                "WHERE id=?";
        Integer rep = jdbcTemplate.update(sql,user.getId().toString().trim());
        return rep;
    }

    // 根据用户账号查询相同账号
    @Override
    public List<User> selectUserByUserCode(User user) {
        String sql = "SELECT * FROM puser " +
                "WHERE userCode = ? ";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        List<User> userList= jdbcTemplate.query(sql,rowMapper,user.getUserCode().trim());
        return userList;
    }

}
