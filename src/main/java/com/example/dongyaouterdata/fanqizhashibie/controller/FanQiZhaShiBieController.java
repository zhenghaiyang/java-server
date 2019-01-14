package com.example.dongyaouterdata.fanqizhashibie.controller;

import com.alibaba.fastjson.JSON;
import com.example.dongyaouterdata.fanqizhashibie.model.FanQiZhaShiBie;
import com.example.dongyaouterdata.fanqizhashibie.service.FanQiZhaShiBieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by 快乐123 on 2018/12/4.
 */
@RestController
@RequestMapping("fanqizhashibie")
public class FanQiZhaShiBieController {

    @Autowired
    private FanQiZhaShiBieService fanQiZhaShiBieService;

    @RequestMapping(value = "list",method ={RequestMethod.POST},produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String findByCondition(@RequestParam Map<String,Object> params){
        String name = (String) params.get("name");
        String id_card = (String) params.get("id_card");
        String phone_no = (String) params.get("phone_no");
        //调用service层查询所需要的数据
        FanQiZhaShiBie fanQiZhaShiBie = fanQiZhaShiBieService.findByCondition(name,id_card,phone_no);
        //将对象转为json字符串
        String fanQiZhaShiBieJSON = JSON.toJSONString(fanQiZhaShiBie);
        return fanQiZhaShiBieJSON;
    }
}
