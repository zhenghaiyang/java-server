package com.example.dongyaouterdata.outdata.service;

import com.example.dongyaouterdata.outdata.model.OutData;

/**
 * Created by 快乐123 on 2018/11/30.
 */
public interface OutDataService {

    OutData findByCondition(String name, String id_card, String phone_number);
}
