/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suff.authen;

import com.suff.domain.LoginDTO;
import com.suff.example.ConfigTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jeerapu
 */
public class LoginTest extends ConfigTest{
    
    public LoginTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testClickLogin() throws Exception 
     {
        LoginDTO loginDTO = new LoginDTO();       
        loginDTO.setUsername("jeerapun");
        assertEquals("jeerapun", loginDTO.getUsername());
        loginDTO.setPassword("ao#$17");
        assertEquals("ao#$17", loginDTO.getPassword());
        Login login = new Login();
        login.setLoginDTO(loginDTO);        
        assertEquals("jeerapun", login.getLoginDTO().getUsername());
        assertEquals("ao#$17", login.getLoginDTO().getPassword());
        
        String result = login.authen();
        assertSuccess(result);
     }
}
