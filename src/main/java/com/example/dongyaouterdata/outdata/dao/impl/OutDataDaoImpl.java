package com.example.dongyaouterdata.outdata.dao.impl;


import com.example.dongyaouterdata.outdata.dao.OutDataDao;
import com.example.dongyaouterdata.outdata.model.OutData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Created by 快乐123 on 2018/11/29.
 */
@Repository
public class OutDataDaoImpl implements OutDataDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public OutData findByCondition(String name, String id_card,String phone_number) {
        String sql = "select PC_RCNT_INCOME,PC_LONG_ECON from outData where name=? and id_card=? and phone_no=?";
        RowMapper<OutData> rowMapper = new BeanPropertyRowMapper<>(OutData.class);
        OutData outData = jdbcTemplate.queryForObject(sql, rowMapper, name,id_card,phone_number);

        return outData;
    }
}
