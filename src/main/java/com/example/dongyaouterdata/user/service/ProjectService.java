package com.example.dongyaouterdata.user.service;
import com.example.dongyaouterdata.user.model.Project;
import com.example.dongyaouterdata.user.model.ProjectAndUser;
import com.example.dongyaouterdata.user.model.ProjectTime;
import com.example.dongyaouterdata.user.model.User;

import java.util.List;


public interface ProjectService {
    // 获取全部项目
    List<Project> getAllProject();
    // 删除项目
    Integer delProjectById(Project project);
    // 添加项目
    Integer addProject(Project project);
    // 根据项目id获取项目下的人员
    List<ProjectAndUser> getUpByPId(Project project);
    // 用户录入项目
    Integer importProject(ProjectAndUser projectAndUser);
    // 获取全部时长
    List<ProjectTime> getAllTime();
    // 根据用户id删除用户项目关联表
    Integer delProjcetByUserId(User user);
    // 根据项目id删除用户项目关联表
    Integer delProjectByProject(Project project);
    // 根据项目名称查询是否有相同项目
    List<Project> selectProjectByProjectName(Project project);
    // 根据用户id 和 用户录入时间查询项目
    List<ProjectAndUser> selectListByUserIdAndProjectImportTime(ProjectAndUser projectAndUser);
    // 根据用户id 和时间段查询
    List<ProjectAndUser> getDetilsByUser(String userId, String startTime, String endTime);
    // 统计页面获取全部项目
    List<Project> getAllProjectByParams(String projectName, String startTime, String endTime);
    // 结束项目
    Integer closeProject(Project project);
}
