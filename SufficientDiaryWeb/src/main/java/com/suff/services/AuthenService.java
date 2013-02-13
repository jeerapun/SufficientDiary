/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suff.services;

import com.suff.dao.TrxUserDao;
import com.suff.domain.AuthenResultDTO;
import com.suff.domain.TrxUser;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jeerapu
 */
@Service
public class AuthenService 
{
    private static Logger log = Logger.getLogger(AuthenService.class);
    
    @Autowired
    private TrxUserDao trxUserDao;
            
    public AuthenResultDTO authen(String username, String password) 
    {
        log.info("## begin AuthenService.authen ##");
        AuthenResultDTO authenResultDTO = new AuthenResultDTO();
        try
        {
            log.info("step 1.begin findUser By Username >> "+username);
            TrxUser trxUser =  trxUserDao.getByUserName(username);
            if(trxUser != null)
            {
                log.info("step 2.begin check is password valid");
                String credential = trxUser.getCredential();
                if(password.equals(credential))
                {
                    log.info("login success");
                    authenResultDTO.setNamespace("LOGIN");
                    authenResultDTO.setResultCode("0");
                    authenResultDTO.setResultDesc("SUCCESS");
                    authenResultDTO.setTrxUser(trxUser);
                    
                }else
                {
                    log.warn("invalid user or password");               
                    
                    authenResultDTO.setNamespace("LOGIN");
                    authenResultDTO.setResultCode("10002");
                    authenResultDTO.setResultDesc("Invalid User Or Password");
                }
                
            }else
            {
                authenResultDTO.setNamespace("LOGIN");
                authenResultDTO.setResultCode("10001");
                authenResultDTO.setResultDesc("Invalid Data");
            }
            
        }catch(Exception e)
        {
            log.error("authen service exception", e);
            authenResultDTO.setNamespace("SYSTEM");
            authenResultDTO.setResultCode("10065");
            authenResultDTO.setResultDesc("Application Exception");
        }
        log.info("## finish AuthenService.authen ##");
        return authenResultDTO;
    }
    
}
