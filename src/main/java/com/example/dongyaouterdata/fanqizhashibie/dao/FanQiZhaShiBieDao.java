package com.example.dongyaouterdata.fanqizhashibie.dao;

import com.example.dongyaouterdata.fanqizhashibie.model.FanQiZhaShiBie;

/**
 * Created by 快乐123 on 2018/12/4.
 */
public interface FanQiZhaShiBieDao {

    FanQiZhaShiBie findByCondition(String name, String id_card, String phone_no);
}
