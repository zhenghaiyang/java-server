package com.example.dongyaouterdata.freeShareData.model;

import lombok.Data;

/**
 * Created by 快乐123 on 2018/11/29.
 * 免费共享数据
 */
@Data
public class FreeShareData {
    /**
     * 姓名
     */
    private String name;
    /**
     * 身份证号
     */
    private String id_card;
    /**
     * 手机号码
     */
    private String phone_no;
    /**
     * 是否有车
     */
    private String have_car_flag;
    /**
     * 是否有房
     */
    private String have_fang_flag;
    /**
     * 最近6个月流动资产日均值
     */
    private String last_6m_avg_asset_total;
    /**
     * 合作方信用评分  （芝麻分）
     */
    private Integer ZM_SCORE;
}
