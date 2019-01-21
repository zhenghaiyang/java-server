package com.example.dongyaouterdata.user.model;

import lombok.Data;

import java.util.Date;

@Data
public class Project {
    // 主键id
    private Integer id;
    // 项目名称
    private String projectName;
    // 项目创建时间
    private Date createdTime;
    // 项目开始时间
    private Date startTime;
    // 项目结束时间
    private Date endTime;
    // 项目负责人
    private String projectManage;
}
