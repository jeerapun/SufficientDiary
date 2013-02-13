/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suff.authen;

import com.suff.domain.AuthenResultDTO;
import com.suff.domain.LoginDTO;
import com.suff.facade.AuthenServiceFacade;
import com.suff.utility.ActionHelper;
import org.apache.log4j.Logger;

/**
 *
 * @author Jeerapu
 */
public class Login extends ActionHelper {
    
    private static Logger log = Logger.getLogger(Login.class);
    private LoginDTO loginDTO = null;
    
    private AuthenServiceFacade authenService ; 
    
    String authen() 
    {
        log.info("## begin login action ##");
        String forward = null;
        try
        {
           log.info("step 1.prepare data");
           log.info("username >> "+this.loginDTO.getUsername() + " ,password : ********");
           AuthenResultDTO authenResultDTO = authenService.authen(this.loginDTO);  
           
        }catch(Exception e)
        {
            log.error("authen exception", e);
            forward = AUTHEN;
        }
        log.info("action forward result is >> "+forward);
        log.info("## finish login action ##");
        return forward;
    }

    public void setLoginDTO(LoginDTO loginDTO) 
    {
        this.loginDTO = loginDTO;
    }

    public LoginDTO getLoginDTO() 
    {
       return loginDTO;
    }
    
}
