package com.example.dongyaouterdata.freeShareData.service;

import com.example.dongyaouterdata.freeShareData.model.FreeShareData;

import java.util.List;
import java.util.Map;

/**
 * Created by 快乐123 on 2018/11/29.
 */
public interface FreeShareDataService {

    FreeShareData findByCondition(String name, String id_card,String phone_number);

    FreeShareData getZmScoreByCondition(String name, String id_card, String phone_no);
}
