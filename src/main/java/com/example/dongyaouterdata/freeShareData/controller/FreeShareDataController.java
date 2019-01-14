package com.example.dongyaouterdata.freeShareData.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.dongyaouterdata.freeShareData.model.FreeShareData;
import com.example.dongyaouterdata.freeShareData.service.FreeShareDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by 快乐123 on 2018/11/29.
 */
@RestController
@RequestMapping("freesharedata")
public class FreeShareDataController {

    @Autowired
    private FreeShareDataService freeShareDataService;

    @RequestMapping(value = "list",method ={RequestMethod.POST},produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String findByCondition(@RequestParam Map<String,Object> params){//@RequestBody String jsonStr
        String name = (String) params.get("name");
        String id_card = (String) params.get("id_card");
        String phone_no = (String) params.get("phone_no");
        //调用service层方法
        FreeShareData freeShareData = freeShareDataService.findByCondition(name,id_card,phone_no);
        //将对象转为json字符串
        String freeShareDataJSON = JSON.toJSONString(freeShareData);
        return freeShareDataJSON;
    }

    @RequestMapping(value = "zmscore",method ={RequestMethod.POST},produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String getZmScoreByCondition(@RequestParam Map<String,Object> params){
        String name = (String) params.get("name");
        String id_card = (String) params.get("id_card");
        String phone_no = (String) params.get("phone_no");
        //调用service层方法
        FreeShareData freeShareData = freeShareDataService.getZmScoreByCondition(name,id_card,phone_no);
        //将对象转为json字符串
        String freeShareDataJSON = JSON.toJSONString(freeShareData);
        return freeShareDataJSON;
    }
}
