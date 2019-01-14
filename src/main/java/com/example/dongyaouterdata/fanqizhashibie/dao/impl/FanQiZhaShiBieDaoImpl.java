package com.example.dongyaouterdata.fanqizhashibie.dao.impl;

import com.example.dongyaouterdata.fanqizhashibie.dao.FanQiZhaShiBieDao;
import com.example.dongyaouterdata.fanqizhashibie.model.FanQiZhaShiBie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Created by 快乐123 on 2018/12/4.
 */
@Repository
public class FanQiZhaShiBieDaoImpl implements FanQiZhaShiBieDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public FanQiZhaShiBie findByCondition(String name, String id_card, String phone_no) {
        String sql = "select ALS_D15_ID_NBANK_ORGNUM,ALS_D15_CELL_NBANK_ORGNUM,ALS_M12_ID_NBANK_ALLNUM,ALS_M12_CELL_NBANK_ALLNUM,\n" +
                "ALS_M12_ID_PDL_ALLNUM,ALS_M12_ID_CAON_ALLNUM,ALS_M12_ID_REL_ALLNUM,ALS_M12_ID_CAOFF_ALLNUM,\n" +
                "ALS_M12_ID_COOFF_ALLNUM,ALS_M12_ID_AF_ALLNUM,ALS_M12_ID_COON_ALLNUM,ALS_M12_ID_OTH_ALLNUM,\n" +
                "ALS_M12_CELL_PDL_ALLNUM,ALS_M12_CELL_CAON_ALLNUM,ALS_M12_CELL_REL_ALLNUM,ALS_M12_CELL_CAOFF_ALLNUM,\n" +
                "ALS_M12_CELL_COOFF_ALLNUM,ALS_M12_CELL_AF_ALLNUM,ALS_M12_CELL_COON_ALLNUM,ALS_M12_CELL_OTH_ALLNUM\n" +
                "from fanqizhashibie\n" +
                "where name=? and id_card=? and phone_no=?;";

        RowMapper<FanQiZhaShiBie> rowMapper = new BeanPropertyRowMapper<>(FanQiZhaShiBie.class);
        FanQiZhaShiBie fanQiZhaShiBie = jdbcTemplate.queryForObject(sql, rowMapper, name, id_card, phone_no);

        return fanQiZhaShiBie;
    }
}
