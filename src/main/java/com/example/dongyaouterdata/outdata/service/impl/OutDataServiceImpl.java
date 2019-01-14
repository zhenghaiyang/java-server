package com.example.dongyaouterdata.outdata.service.impl;

import com.example.dongyaouterdata.outdata.dao.OutDataDao;
import com.example.dongyaouterdata.outdata.model.OutData;
import com.example.dongyaouterdata.outdata.service.OutDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 快乐123 on 2018/11/30.
 */
@Service
public class OutDataServiceImpl implements OutDataService {

    @Autowired
    private OutDataDao outDataDao;

    @Override
    public OutData findByCondition(String name, String id_card, String phone_number) {
        OutData outData = outDataDao.findByCondition(name, id_card, phone_number);
        return outData;
    }
}
