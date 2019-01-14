package com.example.dongyaouterdata.user.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ProjectAndUser {
    // 主键id
    private Integer id;
    // 用户id
    private Integer userId;
    // 项目id
    private Integer projectId;
    // 用户报工时
    private String userTime;
    // 用户报工职位
    private String userPosition;
    // 用户姓名
    private String userName;
    // 用户职位
    private String positionName;
    // 用户工时
    private String timeName;
    // 用户录入项目时间
    private String importProjectTime;
}
