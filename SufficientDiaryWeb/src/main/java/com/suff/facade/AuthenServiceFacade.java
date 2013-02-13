/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suff.facade;

import com.suff.domain.AuthenResultDTO;
import com.suff.domain.LoginDTO;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jeerapu
 */
@Component
public interface AuthenServiceFacade {

    public AuthenResultDTO authen(LoginDTO loginDTO);
    
}
