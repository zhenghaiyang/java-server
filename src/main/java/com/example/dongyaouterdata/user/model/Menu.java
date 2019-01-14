package com.example.dongyaouterdata.user.model;

import lombok.Data;

import java.util.List;

@Data
public class Menu {
    // 主键 id
    private Integer id;
    // 路由地址
    private String menuPath;
    // 路由名称
    private String menuName;
    // 路由Code
    private String menuCode;
    // 父节点code
    private String parentCode;
    // 用户类型
    private String userType;
}
