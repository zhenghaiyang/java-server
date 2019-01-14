package com.example.dongyaouterdata.fanqizhashibie.service.impl;

import com.example.dongyaouterdata.fanqizhashibie.dao.FanQiZhaShiBieDao;
import com.example.dongyaouterdata.fanqizhashibie.model.FanQiZhaShiBie;
import com.example.dongyaouterdata.fanqizhashibie.service.FanQiZhaShiBieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 快乐123 on 2018/12/4.
 */
@Service
public class FanQiZhaShiBieServiceImpl implements FanQiZhaShiBieService {

    @Autowired
    private FanQiZhaShiBieDao fanQiZhaShiBieDao;

    @Override
    public FanQiZhaShiBie findByCondition(String name, String id_card, String phone_no) {

        //调用dao层
        FanQiZhaShiBie fanQiZhaShiBie = fanQiZhaShiBieDao.findByCondition(name,id_card,phone_no);
        return fanQiZhaShiBie;
    }
}
