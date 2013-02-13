/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suff.facade.impl;

import com.suff.domain.AuthenResultDTO;
import com.suff.domain.LoginDTO;
import com.suff.facade.AuthenServiceFacade;
import com.suff.services.AuthenService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jeerapu
 */
@Component
public class AuthenServiceFacadeImpl implements AuthenServiceFacade{
    
    private static Logger log = Logger.getLogger(AuthenServiceFacadeImpl.class); 
    @Autowired
    private AuthenService authenService;
    
    public AuthenResultDTO authen(LoginDTO loginDTO) 
    {
       log.info("## begin authen ##");
       AuthenResultDTO authenResultDTO = null;
       try
       {           
          authenResultDTO = authenService.authen(loginDTO.getUsername(),loginDTO.getPassword());
           
       }catch(Exception e)
       {
           log.error("authen exception", e);
       }
       log.info("## finish authen ##");     
       return authenResultDTO;
    }
    
}
