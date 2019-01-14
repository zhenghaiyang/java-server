package com.example.dongyaouterdata.freeShareData.dao.impl;

import com.example.dongyaouterdata.freeShareData.dao.FreeShareDataDao;
import com.example.dongyaouterdata.freeShareData.model.FreeShareData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by 快乐123 on 2018/11/29.
 */
@Repository
public class FreeShareDataDaoImpl implements FreeShareDataDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public FreeShareData findByCondition(String name, String id_card,String phone_number) {

        String sql = "select have_car_flag,have_fang_flag,last_6m_avg_asset_total from freesharedata where name=? and id_card=? and phone_no=?";
        RowMapper<FreeShareData> rowMapper = new BeanPropertyRowMapper(FreeShareData.class);
        FreeShareData freeShareData = jdbcTemplate.queryForObject(sql,rowMapper,name,id_card,phone_number);
        return  freeShareData;
    }

    @Override
    public FreeShareData getZmScoreByCondition(String name, String id_card, String phone_no) {
        String sql = "select ZM_SCORE from freesharedata where name=? and id_card=? and phone_no=?";
        RowMapper<FreeShareData> rowMapper = new BeanPropertyRowMapper(FreeShareData.class);
        FreeShareData freeShareData = jdbcTemplate.queryForObject(sql,rowMapper,name,id_card,phone_no);
        return  freeShareData;

    }
}
