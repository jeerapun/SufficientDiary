/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suff.dao.impl;

import com.suff.dao.TrxUserDao;
import com.suff.domain.TrxUser;
import com.suff.domain.rowmapper.TrxUserRowMapper;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jeerapu
 */
@Repository
public class TrxUserDaoImpl implements TrxUserDao 
{
    private static Logger log = Logger.getLogger(TrxUserDaoImpl.class); 
    private JdbcTemplate jdbcTemplate = null;
    
    @Autowired
    public void setDataSource(DataSource dataSource) 
    {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public TrxUser getByUserName(String username) 
    {
        log.info("## begin get data by username  >> "+username);
        StringBuilder sql = new StringBuilder();
        sql.append("select t.suff_id,t.username,t.credential,t.expiry,t.status,t.last_login,t.created,t.created_by,t.last_upd,t.upd_by ");
        sql.append("from trx_user t ");
        sql.append("where t.username = ? ");
        log.info("sql query is >> "+sql.toString());
        
        TrxUser trxUser = null;
        try
        {
            trxUser = this.jdbcTemplate.queryForObject(sql.toString(), new TrxUserRowMapper(), (Object[]) new String[]{username});
        }catch(EmptyResultDataAccessException e)
        {
            log.warn("Warning User >> "+username + " No data Found!");
            trxUser = null;
        }
        
        return trxUser;
    }

    
    
}
