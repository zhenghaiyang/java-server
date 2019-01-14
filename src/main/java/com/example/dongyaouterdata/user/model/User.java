package com.example.dongyaouterdata.user.model;

import lombok.Data;

@Data
public class User {
    // 用户id 主键
    private Integer id;

    // 用户姓名
    private String userName;

    // 用户账号
    private String userCode;

    // 用户密码
    private String userPassword;

    // 用户类型
    private Integer userType;

    // 用户职位
    private String userPositionCode;
    // 新密码
    private String newUserPassword;
}
