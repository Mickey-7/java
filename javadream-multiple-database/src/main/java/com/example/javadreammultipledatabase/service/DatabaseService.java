package com.example.javadreammultipledatabase.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

//5.Create a Service class and Autowired both the initialize jdbctemplate in that class and perform query to save data in different databases tables.
@Service
public class DatabaseService {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseService.class);
    private static final String query = "insert into testing(id,name) values(?,?)";

    @Autowired
    @Qualifier("db1_template")
    private JdbcTemplate template_database_1;

    @Autowired
    @Qualifier("db2_template")
    private JdbcTemplate template_database_2;

    @Transactional
    public int save(){
        try{
            int insertDB1Status = template_database_1.update(query, new Object[]{1,"rajput"});
            logger.info("insertDB1Status= "+insertDB1Status);

            int insertDB2Status = template_database_2.update(query, new Object[]{2,"rajput"});
            logger.info("insertDB1Status= "+insertDB2Status);

            return 1;
        }catch (Exception e){
            logger.error("Exception: "+e);
            return 0;
        }
    }


}
