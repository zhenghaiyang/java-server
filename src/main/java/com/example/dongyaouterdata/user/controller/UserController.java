package com.example.dongyaouterdata.user.controller;
import com.example.dongyaouterdata.Base.ResponseData;
import com.example.dongyaouterdata.user.model.Position;
import com.example.dongyaouterdata.user.model.User;
import com.example.dongyaouterdata.user.service.ProjectService;
import com.example.dongyaouterdata.user.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProjectService projectService;
    // 登录
    @RequestMapping(value="/login")
    private ResponseData login(@RequestBody Map<String,Object> requestBody) {
        String userCode = requestBody.get("userCode").toString();
        String userPassword = DigestUtils.md5Hex(requestBody.get("userPassword").toString());
        System.out.print(userPassword);
        HashMap<String, Object> map = new HashMap<>();
            // 先判断账号面是否正确
            HashMap<String, Object> userMap = new HashMap<>();
            try{
                User user =userService.findOneUser(userCode,userPassword);
                // 根据用户类型去查询菜单
                if(user!=null) {
                    userMap.put("username",user.getUserName().toString());
                    userMap.put("userCode",user.getUserCode());
                    userMap.put("userId",user.getId());
                    userMap.put("userType",user.getUserType().toString());
                    List list = userService.findMenuByUserType(user.getUserType().toString());
                    if(list != null) {
                        map.put("userInfo",userMap);
                        map.put("menulist",list);
                    }
                }
            }catch (EmptyResultDataAccessException e) {
                return ResponseData.response(map,"账号密码错误",500);
            }

        return ResponseData.response(map,"操作成功",200);
    }
    // 添加用户
    @RequestMapping(value="/add")
    private ResponseData userAdd(@RequestBody User user) {
        HashMap<String, Object> map = new HashMap<>();
        List<User> userlist=userService.selectUserByUserCode(user);
        if(userlist.size()==0) {
            user.setUserPassword(DigestUtils.md5Hex(DigestUtils.md5Hex("12345")));
            user.setUserType(2);
            System.out.print(user);
            int rep = userService.addUser(user);
            if(rep !=0 ) {
                return ResponseData.response(map,"操作成功",200);
            }else {
                return ResponseData.response(map,"添加失败",500);
            }
        }else{
            return ResponseData.response(map,"账号相同",500);
        }
    }

    // 查询全部用户
    @RequestMapping(value="/all")
    private ResponseData getAllUser(@RequestBody Map<String,Object> requestBody) {
        List<User> userList =  userService.getAllUser();
        if(userList != null) {
            return ResponseData.response(userList,"操作成功",200);
        }else {
            return ResponseData.response(userList,"添加失败",500);
        }
    }
    // 获取全部职位
    @RequestMapping(value="/allPosition")
    private ResponseData getAllPosition(@RequestBody Map<String,Object> requestBody) {
        List<Position> positionList = userService.getAllPosition();
        if( positionList != null) {
            return ResponseData.response(positionList,"操作成功",200);
        }else{
            return ResponseData.response(positionList,"添加失败",500);
        }
    }

    // 重置用户密码
    @RequestMapping(value="/resetPassword")
    private ResponseData resetPassword(@RequestBody User user) {
        HashMap<String, Object> map = new HashMap<>();
        user.setUserPassword("123456");
        Integer rep = userService.resetPassword(user);
        if(rep !=0 ) {
            return ResponseData.response(map,"操作成功",200);
        }else{
            return ResponseData.response(map,"操作失败",500);
        }
    }
    // 用户自己修改密码
    @RequestMapping(value="/userResetPassword")
    private ResponseData userResetPassword(@RequestBody User user) {
        HashMap<String, Object> map = new HashMap<>();
        Integer rep =0;
        try {
            User users = userService.findOneUser(user.getUserCode(), DigestUtils.md5Hex(user.getUserPassword()));
            if (users != null) {
                users.setUserPassword(DigestUtils.md5Hex(user.getNewUserPassword()));
                rep = userService.resetPassword(users);
            }
        } catch (EmptyResultDataAccessException e) {
            return ResponseData.response(map, "原账号密码或错误", 500);
        }
        if (rep != 0) {
            return ResponseData.response(map, "操作成功", 200);
        } else {
            return ResponseData.response(map, "操作失败", 500);
        }
    }
    // 删除用户
    @RequestMapping(value="/del")
    public ResponseData delUserByUserId(@RequestBody User user) {
        HashMap<String, Object> map = new HashMap<>();
        Integer rep = userService.delUserByid(user);
        Integer reps = projectService.delProjcetByUserId(user);
        if (rep != 0 && reps >=0 ) {
            return ResponseData.response(map, "操作成功", 200);
        } else {
            return ResponseData.response(map, "操作失败", 500);
        }
    }

}
