package com.example.dongyaouterdata.user.service.impl;
import com.example.dongyaouterdata.user.dao.ProjectDao;
import com.example.dongyaouterdata.user.model.Project;
import com.example.dongyaouterdata.user.model.ProjectAndUser;
import com.example.dongyaouterdata.user.model.ProjectTime;
import com.example.dongyaouterdata.user.model.User;
import com.example.dongyaouterdata.user.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    // 获取全部项目
    @Override
    public List<Project> getAllProject() {
        return projectDao.getAllProject();
    }
    // 删除项目
    @Override
    public Integer delProjectById(Project project) {
        return projectDao.delProjectById(project);
    }
    // 添加项目
    @Override
    public Integer addProject(Project project) {
        return projectDao.addProject(project);
    }
    // 根据项目id获取项目下的全部人员
    @Override
    public List<ProjectAndUser> getUpByPId(Project project) {
        return projectDao.getUpByPId(project);
    }
    // 用户录入项目
    @Override
    public Integer importProject(ProjectAndUser projectAndUser) {
        return projectDao.importProject(projectAndUser);
    }
    // 获取全部时长
    @Override
    public List<ProjectTime> getAllTime() {
        return projectDao.getAllTime();
    }
    // 根据用户id删除项目用户关联表
    @Override
    public Integer delProjcetByUserId(User user) {
        return projectDao.delProjcetByUserId(user);
    }
    // 根据项目id删除项目用户关联表
    @Override
    public Integer delProjectByProject(Project project) {
        return projectDao.delProjectByProject(project);
    }

    // 根据项目名称查询相同项目
    @Override
    public List<Project> selectProjectByProjectName(Project project) {return projectDao.selectProjectByProjectName(project);}

    // 根据用户id 和用户项目录入时间查询项目
    @Override
    public List<ProjectAndUser> selectListByUserIdAndProjectImportTime(ProjectAndUser projectAndUser) {
        return projectDao.selectListByUserIdAndProjectImportTime(projectAndUser);
    }

}
