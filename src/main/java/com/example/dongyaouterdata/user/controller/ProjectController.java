package com.example.dongyaouterdata.user.controller;
import com.example.dongyaouterdata.user.model.Project;
import com.example.dongyaouterdata.Base.ResponseData;
import com.example.dongyaouterdata.user.service.ProjectService;
import com.example.dongyaouterdata.user.model.ProjectAndUser;
import com.example.dongyaouterdata.user.model.ProjectTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // 获取全部项目
    @RequestMapping(value="/all")
    private ResponseData getAllProject(@RequestBody Map<String,Object> requestBody)  {
        List<Project> projectList =  projectService.getAllProject();
        if(projectList != null) {
            return ResponseData.response(projectList,"操作成功",200);
        }else {
            return ResponseData.response(projectList,"操作失败",500);
        }
    }

    // 删除项目
    @RequestMapping(value="/del")
    private ResponseData delProjectById(@RequestBody Project project) {
        HashMap<String, Object> map = new HashMap<>();
        Integer rep = projectService.delProjectById(project);
        Integer resp = projectService.delProjectByProject(project);
        if( rep !=0 && resp>=0) {
            return ResponseData.response(map,"操作成功",200);
        }else{
            return ResponseData.response(map,"操作失败",500);
        }
    }

    // 新建项目
    @RequestMapping(value="/add")
    private ResponseData addProject(@RequestBody Project project) {
        HashMap<String, Object> map = new HashMap<>();

        List<Project> projectList = projectService.selectProjectByProjectName(project);
        if(projectList.size() == 0) {
            Integer rep = projectService.addProject(project);
            if( rep !=0 ) {
                return ResponseData.response(map,"操作成功",200);
            }else{
                return ResponseData.response(map,"操作失败",500);
            }
        }else{
            return ResponseData.response(map,"项目名称已存在",500);
        }
    }
    // 根据项目id获取项目下的全部用户
    @RequestMapping(value="/getUpByPId")
    private ResponseData getUpByPId(@RequestBody  Project project) {
        List<ProjectAndUser> projectAndUserList = projectService.getUpByPId(project);
        if(projectAndUserList != null) {
            return ResponseData.response(projectAndUserList,"操作成功",200);
        }else {
            return ResponseData.response(projectAndUserList,"操作失败",500);
        }
    }

    // 用户录入数据
    @RequestMapping(value="/importProject")
    private ResponseData importProject(@RequestBody List<ProjectAndUser> projectAndUserList) {
        HashMap<String, Object> map = new HashMap<>();
        try {
            ProjectAndUser p = projectAndUserList.get(0);
            List<ProjectAndUser> projectAndUserLists = projectService.selectListByUserIdAndProjectImportTime(p);

            if(projectAndUserLists.size() >0 ) {
                return ResponseData.response(map,"操作失败!一天只能录入一次项目",500);
            }else {
                for(ProjectAndUser projectAndUser: projectAndUserList) {
                    System.out.print(projectAndUser);
                    Integer rep = projectService.importProject(projectAndUser);
                }
            }
        }catch (EmptyResultDataAccessException e) {
            return ResponseData.response(map,"操作失败",500);
        }
        return ResponseData.response(map,"操作成功",200);
    }
    // 获取全部时长
    @RequestMapping(value="/getAlltime")
    private ResponseData getAllTime(@RequestBody Map<String,String> maps) {
        List<ProjectTime> projectTime =  projectService.getAllTime();
        if(projectTime != null) {
            return ResponseData.response(projectTime,"操作成功",200);
        }else {
            return ResponseData.response(projectTime,"操作失败",500);
        }
    }
    // 根据用户id和时间段查询数据
    @RequestMapping(value="/userDetils")
    private ResponseData getDetilsByUser(@RequestBody Map<String,String> requestBody) {
        String userId = requestBody.get("userId");
        String startTime = requestBody.get("startTime");
        String endTime = requestBody.get("endTime");
        List<ProjectAndUser> projectAndUser = projectService.getDetilsByUser(userId,startTime,endTime);
        try{
            return ResponseData.response(projectAndUser,"操作成功",200);
        }catch (EmptyResultDataAccessException e){
            return ResponseData.response(projectAndUser,"操作失败",500);
        }
    }
}
