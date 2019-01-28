package com.example.dongyaouterdata.user.controller;

import com.example.dongyaouterdata.user.model.Project;
import com.example.dongyaouterdata.user.service.ProjectService;
import com.xiaoleilu.hutool.http.HttpRequest;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.sun.tools.doclint.Entity.sim;

@RestController
@CrossOrigin
@RequestMapping("export")
public class exportExcelController {

    @Autowired
    private ProjectService projectService;

    // 测试导出execl
    @RequestMapping(value="/exportTest")
    public void exportTest(@RequestParam(value ="projectName") String projectName,@RequestParam(value="startTime") String startTime, @RequestParam(value="endTime") String endTime,HttpServletResponse response) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Project> projectList =  projectService.getAllProjectByParams(projectName,startTime,endTime);
        HSSFWorkbook wb = new HSSFWorkbook();//建立新HSSFWorkbook对象
        HSSFSheet sheet = wb.createSheet();
        HSSFRow row=sheet.createRow(0);
        row.createCell(0).setCellValue("项目名称");
        row.createCell(1).setCellValue("项目状态");
        row.createCell(2).setCellValue("项目创建日期");
        row.createCell(3).setCellValue("项目开始日期");
        row.createCell(4).setCellValue("项目预计结束日期");
        row.createCell(5).setCellValue("项目结束日期");
        row.createCell(6).setCellValue("项目负责人");
        row.createCell(7).setCellValue("项目是否延期");
        row.createCell(8).setCellValue("延期天数(天)");
        row.createCell(9).setCellValue("项目耗时(天)");
        for(int i=0;i<projectList.size();i++) {
            HSSFRow rows=sheet.createRow(i+1);
            Project tempProject = projectList.get(i);
            rows.createCell(0).setCellValue(tempProject.getProjectName());
            rows.createCell(1).setCellValue(tempProject.getProjectStatus().equals("1")?"已结束":"未结束");
            rows.createCell(2).setCellValue(tempProject.getCreatedTime()!=null?sdf.format(tempProject.getCreatedTime()):"");
            rows.createCell(3).setCellValue(tempProject.getStartTime()!=null?sdf.format(tempProject.getStartTime()):"");
            rows.createCell(4).setCellValue(tempProject.getEndTime()!=null?sdf.format(tempProject.getEndTime()):"");
            rows.createCell(5).setCellValue(tempProject.getTrueEndTime()!=null?sdf.format(tempProject.getTrueEndTime()):"");
            rows.createCell(6).setCellValue(tempProject.getProjectManage());
            rows.createCell(7).setCellValue(checkProjectPostpone(tempProject));
            rows.createCell(8).setCellValue(calcPostponeDate(tempProject));
            rows.createCell(9).setCellValue(calcProjectAddTime(tempProject));
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        wb.write(byteArrayOutputStream);

        String dateTime = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm");
        String outFile = "统计报表-"+dateTime + ".xls";

        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        outFile = response.encodeURL(new String(outFile.getBytes("gb2312"), "iso8859-1"));

        response.addHeader("Content-Disposition", "attachment;filename=" + outFile);
        response.setContentLength(byteArrayOutputStream.size());

        ServletOutputStream outputstream = response.getOutputStream();
        byteArrayOutputStream.writeTo(outputstream);

        byteArrayOutputStream.close();
        outputstream.flush();
    }

    // 判断项目是否延期
    public String checkProjectPostpone(Project project) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String submit = "";
        System.out.print(project.getProjectStatus());
        if(project.getProjectStatus().equals("1")) {
            if(sdf.format(project.getTrueEndTime()).equals(sdf.format(project.getEndTime()))) {
                submit="未延期";
            }else{
                submit="已延期";
            }
        }else{
            submit="进行中";
        }
        return submit;
    }
    // 计算延期天数
    public String calcPostponeDate(Project project) {
        Long submit = 0L;
        if(project.getProjectStatus().equals("1")) {
            Long tempTime = project.getTrueEndTime().getTime() - project.getEndTime().getTime();
            submit = tempTime/(1000*60*60*24);
        }
        return submit.toString();
    }
    // 计算项目耗时天数
    public String calcProjectAddTime(Project project) {
        Long submit = 0L;
        Date date = new Date();
        if(project.getProjectStatus().equals("1")) {
            Long tempTime = project.getTrueEndTime().getTime() - project.getStartTime().getTime();
            submit = tempTime/(1000*60*60*24);
        }else{
            Long tempTime = date.getTime()-project.getStartTime().getTime();
            submit = tempTime/(1000*60*60*24);
        }
        return submit.toString();
    }

}
