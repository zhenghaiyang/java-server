package com.example.dongyaouterdata.user.dao.impl;

import com.example.dongyaouterdata.user.model.Project;
import com.example.dongyaouterdata.user.dao.ProjectDao;
import com.example.dongyaouterdata.user.model.ProjectAndUser;
import com.example.dongyaouterdata.user.model.ProjectTime;
import com.example.dongyaouterdata.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.List;

@Repository
public class ProjectDaoImpl implements ProjectDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 获取全部项目
    @Override
    public List<Project> getAllProject() {
        String sql ="SELECT * FROM pproject";
        RowMapper<Project> rowMapper = new BeanPropertyRowMapper<>(Project.class);
        List<Project> projcetList = jdbcTemplate.query(sql,rowMapper);
        return projcetList;
    }
    // 删除项目
    @Override
    public Integer delProjectById(Project project) {
        String sql ="DELETE FROM pproject " +
                "WHERE id=?";
        Integer rep = jdbcTemplate.update(sql,project.getId().toString().trim());
        return rep;
    }

    // 添加项目
    @Override
    public Integer addProject(Project project) {
        String sql= "INSERT into pproject" +
                "(projectName,createdTime,startTime)" +
                "VALUE" +
                "(?,?,?)";
        System.out.print(sql);
        Integer rep =jdbcTemplate.update(sql,project.getProjectName().trim(),project.getCreatedTime(),project.getStartTime());
        return rep;
    }
    // 根据项目id获取项目下的全部人员
    @Override
    public List<ProjectAndUser> getUpByPId(Project project) {
        String sql = "SELECT " +
                "up.id," +
                "up.projectId," +
                "up.userId," +
                "up.userTime, " +
                "u.userName, " +
                "p.value AS positionName, "+
                "pt.value AS timeName "+
                "FROM userAndProject up " +
                "LEFT JOIN puser u ON (up.userId=u.id) " +
                "LEFT JOIN pposition p ON (up.userPosition = p.key) " +
                "LEFT JOIN ptime pt ON (up.userTime = pt.key) " +
                "WHERE up.projectId=?";
        RowMapper<ProjectAndUser> rowMapper = new BeanPropertyRowMapper<>(ProjectAndUser.class);
        List<ProjectAndUser> projectAndUser = jdbcTemplate.query(sql,rowMapper,project.getId());
        System.out.print(jdbcTemplate.query(sql,rowMapper,project.getId()));
        System.out.print(project.getId());
        return projectAndUser;
    }

    // 用户录入项目
    @Override
    public Integer importProject(ProjectAndUser projectAndUser) {
        String sql= "INSERT into userAndProject" +
                "(userId,projectId,userTime,userPosition,importProjectTime)" +
                "VALUE" +
                "(?,?,?,?,?)";
        System.out.print(sql);
        Integer rep =jdbcTemplate.update(sql,projectAndUser.getUserId(),projectAndUser.getProjectId(),projectAndUser.getUserTime(),projectAndUser.getUserPosition().trim(),projectAndUser.getImportProjectTime());
        return rep;
    }
    // 获取全部时长
    @Override
    public List<ProjectTime> getAllTime() {
        String sql ="SELECT * FROM ptime";
        RowMapper<ProjectTime> rowMapper = new BeanPropertyRowMapper<>(ProjectTime.class);
        List<ProjectTime> projectTime = jdbcTemplate.query(sql,rowMapper);
        return projectTime;
    }

    // 根据用户id删除项目用户关联表
    @Override
    public Integer delProjcetByUserId(User user) {
        String sql= "DELETE FROM userAndProject " +
                    "WHERE userId = ? ";
        System.out.print(sql);
        Integer rep =jdbcTemplate.update(sql,user.getId());
        return rep;
    }

    // 根据项目ID删除用户项目关联表
    @Override
    public Integer delProjectByProject(Project project) {
        String sql= "DELETE FROM userAndProject " +
                "WHERE projectId = ? ";
        System.out.print(sql);
        Integer rep =jdbcTemplate.update(sql,project.getId());
        return rep;
    }

    // 根据项目名称查询是否相同项目
    @Override
    public List<Project> selectProjectByProjectName(Project project) {
        String sql ="SELECT * FROM pproject " +
                "WHERE projectName = ?";
        RowMapper<Project> rowMapper = new BeanPropertyRowMapper<>(Project.class);
        List<Project> projects= jdbcTemplate.query(sql,rowMapper,project.getProjectName().trim());
        return projects;
    }

    // 根据用户id和用户项目录入时间查询项目
    @Override
    public List<ProjectAndUser> selectListByUserIdAndProjectImportTime(ProjectAndUser projectAndUser) {
        String sql = "SELECT * FROM userAndProject " +
                "WHERE userId=? AND importProjectTime=? ";
        RowMapper<ProjectAndUser> rowMapper = new BeanPropertyRowMapper<>(ProjectAndUser.class);
        List<ProjectAndUser> projectAndUserList= jdbcTemplate.query(sql,rowMapper,projectAndUser.getUserId(),projectAndUser.getImportProjectTime());
        System.out.print(sql);
        return projectAndUserList;
    }

}