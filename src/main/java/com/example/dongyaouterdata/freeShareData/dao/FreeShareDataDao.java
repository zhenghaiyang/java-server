package com.example.dongyaouterdata.freeShareData.dao;

import com.example.dongyaouterdata.freeShareData.model.FreeShareData;

/**
 * Created by 快乐123 on 2018/11/29.
 */
public interface FreeShareDataDao {

    FreeShareData findByCondition(String name, String id_card,String phone_number);

    FreeShareData getZmScoreByCondition(String name, String id_card, String phone_no);
}
