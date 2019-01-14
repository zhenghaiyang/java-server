package com.example.dongyaouterdata.freeShareData.service.impl;

import com.example.dongyaouterdata.freeShareData.dao.FreeShareDataDao;
import com.example.dongyaouterdata.freeShareData.model.FreeShareData;
import com.example.dongyaouterdata.freeShareData.service.FreeShareDataService;
import com.example.dongyaouterdata.outdata.model.OutData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 快乐123 on 2018/11/29.
 */
@Service
public class FreeShareDataServiceImpl implements FreeShareDataService {

    @Autowired
    private FreeShareDataDao freeShareDataDao;

    @Override
    public FreeShareData findByCondition(String name, String id_card,String phone_number) {
        FreeShareData freeShareData = freeShareDataDao.findByCondition(name, id_card,phone_number);
        return freeShareData;
    }

    @Override
    public FreeShareData getZmScoreByCondition(String name, String id_card, String phone_no) {
        FreeShareData freeShareData = freeShareDataDao.getZmScoreByCondition(name, id_card,phone_no);
        return freeShareData;
    }


}
