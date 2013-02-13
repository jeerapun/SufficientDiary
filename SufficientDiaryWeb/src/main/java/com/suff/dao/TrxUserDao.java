/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suff.dao;

import com.suff.domain.TrxUser;
import javax.sql.DataSource;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jeerapu
 */
@Repository
public interface TrxUserDao 
{
    public void setDataSource(DataSource dataSource);   
    public TrxUser getByUserName(String username);   
}
