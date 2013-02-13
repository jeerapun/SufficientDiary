/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suff.domain.rowmapper;

import com.suff.domain.TrxUser;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Jeerapu
 */
public class TrxUserRowMapper implements RowMapper<TrxUser> {
    
    public TrxUser mapRow(ResultSet rs, int rowNum) throws SQLException 
    {
       TrxUser trxUser = null;
       if(rs != null)
       {
           trxUser = new TrxUser();
           trxUser.setSuffId(rs.getString("SUFF_ID"));
           trxUser.setUsername(rs.getString("USERNAME"));
           trxUser.setCredential(rs.getString("CREDENTIAL"));
           trxUser.setExpiry(rs.getTimestamp("EXPIRY"));
           trxUser.setStatus(rs.getString("STATUS"));
           trxUser.setLastLogin(rs.getTimestamp("LAST_LOGIN"));
           trxUser.setCreated(rs.getTimestamp("CREATED"));
           trxUser.setCreatedBy(rs.getString("CREATED_BY"));
           trxUser.setLastUpd(rs.getTimestamp("LAST_UPD"));
           trxUser.setUpdBy(rs.getString("UPD_BY"));
       }
       return trxUser;
    }
    
}
