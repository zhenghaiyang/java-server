package com.example.dongyaouterdata.fanqizhashibie.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by 快乐123 on 2018/12/4.
 */
@Data
public class FanQiZhaShiBie implements Serializable{
    /**
     * 姓名
     */
    private String name;
    /**
     * 身份证号
     */
    private String id_card;
    /**
     * 手机号
     */
    private String phone_no;
    /**
     * 按身份证号查询近15天申请机构数（非银）
     */
    private Integer ALS_D15_ID_NBANK_ORGNUM;
    /**
     * 按手机号查询近15天申请机构数（非银）
     */
    private Integer ALS_D15_CELL_NBANK_ORGNUM;
    /**
     * 按身份证号查询，近12个月在非银机构申请次数
     */
    private Integer ALS_M12_ID_NBANK_ALLNUM;
    /**
     * 按手机号查询，近12个月在非银机构申请次数
     */
    private Integer ALS_M12_CELL_NBANK_ALLNUM;
    /**
     * 按身份证号查询，近12个月申请线上小额现金贷的次数
     */
    private Integer ALS_M12_ID_PDL_ALLNUM;
    /**
     * 按身份证号查询，近12个月申请线上现金分期的次数
     */
    private Integer ALS_M12_ID_CAON_ALLNUM;
    /**
     * 按身份证号查询，近12个月申请信用卡（类信用卡）的次数
     */
    private Integer ALS_M12_ID_REL_ALLNUM;
    /**
     * 按身份证号查询，近12个月申请线下现金分期的次数
     */
    private Integer ALS_M12_ID_CAOFF_ALLNUM;
    /**
     * 按身份证号查询，近12个月申请线下消费分期的次数
     */
    private Integer ALS_M12_ID_COOFF_ALLNUM;
    /**
     * 按身份证号查询，近12个月申请汽车金融的次数
     */
    private Integer ALS_M12_ID_AF_ALLNUM;
    /**
     * 按身份证号查询，近12个月申请线上消费分期的次数
     */
    private Integer ALS_M12_ID_COON_ALLNUM;
    /**
     * 按身份证号查询，近12个月申请其他的次数
     */
    private Integer ALS_M12_ID_OTH_ALLNUM;
    /**
     * 按手机号查询，近12个月申请线上小额现金贷的次数
     */
    private Integer ALS_M12_CELL_PDL_ALLNUM;
    /**
     * 按手机号查询，近12个月申请线上现金分期的次数
     */
    private Integer ALS_M12_CELL_CAON_ALLNUM;
    /**
     * 按手机号查询，近12个月申请信用卡（类信用卡）的次数
     */
    private Integer ALS_M12_CELL_REL_ALLNUM;
    /**
     * 按手机号查询，近12个月申请线下现金分期的次数
     */
    private Integer ALS_M12_CELL_CAOFF_ALLNUM;
    /**
     * 按手机号查询，近12个月申请线下消费分期的次数
     */
    private Integer ALS_M12_CELL_COOFF_ALLNUM;
    /**
     * 按手机号查询，近12个月申请汽车金融的次数
     */
    private Integer ALS_M12_CELL_AF_ALLNUM;
    /**
     * 按手机号查询，近12个月申请线上消费分期的次数
     */
    private Integer ALS_M12_CELL_COON_ALLNUM;
    /**
     * 按手机号查询，近12个月申请其他的次数
     */
    private Integer ALS_M12_CELL_OTH_ALLNUM;
}
