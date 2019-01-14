package com.example.dongyaouterdata.outdata.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.dongyaouterdata.outdata.model.OutData;
import com.example.dongyaouterdata.outdata.service.OutDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by 快乐123 on 2018/11/30.
 * 于评分小于等于5分的客户，调用外部数据
 */
@RestController
@RequestMapping("outdata")
public class OutDataController {

    @Autowired
    private OutDataService outDataService;

    @RequestMapping(value = "list",method ={RequestMethod.POST},produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String findByCondition(@RequestParam Map<String,Object> params){ //@RequestBody String jsonStr
        String name = (String) params.get("name");
        String id_card = (String) params.get("id_card");
        String phone_no = (String) params.get("phone_no");
        //调用service层
        OutData outData = outDataService.findByCondition(name,id_card,phone_no);
        //将对象转为转为json字符串
        String outDataJSON = JSON.toJSONString(outData);
        return outDataJSON;
    }

}
