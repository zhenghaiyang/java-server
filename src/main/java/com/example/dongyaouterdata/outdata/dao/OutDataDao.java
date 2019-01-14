package com.example.dongyaouterdata.outdata.dao;

import com.example.dongyaouterdata.outdata.model.OutData;

/**
 * Created by 快乐123 on 2018/11/29.
 */
public interface OutDataDao {

    OutData findByCondition(String name, String id_card,String phone_number);
}
