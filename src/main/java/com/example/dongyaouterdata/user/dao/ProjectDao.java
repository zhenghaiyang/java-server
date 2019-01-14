package com.example.dongyaouterdata.user.dao;
import com.example.dongyaouterdata.user.model.Project;
import com.example.dongyaouterdata.user.model.ProjectAndUser;
import com.example.dongyaouterdata.user.model.ProjectTime;
import com.example.dongyaouterdata.user.model.User;

import java.util.List;

public interface ProjectDao {
    // 获取全部项目
    List<Project> getAllProject();
    // 删除项目
    Integer delProjectById(Project project);
    // 添加项目
    Integer addProject(Project project);
    // 根据项目id获取项目下的全部用户
    List<ProjectAndUser> getUpByPId(Project project);
    // 用户导入项目
    Integer importProject(ProjectAndUser projectAndUser);

    // 获取全部时长
    List<ProjectTime> getAllTime();
    // 根据用户id删除项目用户关联表
    Integer delProjcetByUserId(User user);
    // 根据项目id删除项目用户关联表
    Integer delProjectByProject(Project project);
    // 根据项目名称查询相同项目
    List<Project> selectProjectByProjectName(Project project);
    // 根据用户id 和用户项目录入时间查询项目
    List<ProjectAndUser> selectListByUserIdAndProjectImportTime(ProjectAndUser projectAndUser);
}
