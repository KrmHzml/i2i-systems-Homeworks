package com.example.firstSpring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SubscriberDAO {
	@Autowired
    private JdbcTemplate jdbcTemplate;
  
    public List<Subscriber> list() {
    	String sql = "SELECT * FROM SUBSCRIBER";
    	 
        List<Subscriber> listSubscriber = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Subscriber.class));
     
        return listSubscriber;
    }

    public void save(Subscriber subscriber) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("subscriber").usingColumns("SUBSC_ID", "SUBSC_NAME", "SUBSC_SURNAME","MSISDN","TARIFF_ID","START_DATE");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(subscriber);
        insertActor.execute(param);
    }
  

	
	
	
}
