package com.example.dongyaouterdata.outdata.model;

import lombok.Data;

/**
 * Created by 快乐123 on 2018/11/29.
 * 外部数据
 */
@Data
public class OutData {
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
     * 长期收入能力
     */
    private String PC_RCNT_INCOME;
    /**
     * 长期收入稳定性
     */
    private String PC_LONG_ECON;
}
