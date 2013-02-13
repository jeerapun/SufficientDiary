/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suff.facade;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.suff.config.SpringConfigTest;
import com.suff.domain.AuthenResultDTO;
import com.suff.domain.LoginDTO;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import static org.junit.Assert.*;

/**
 *
 * @author Jeerapu
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfigTest.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
public class AuthenServiceFacadeTest {
    
    private static Logger log = Logger.getLogger(AuthenServiceFacadeTest.class);
    
    @Autowired
    private AuthenServiceFacade authenServiceFacade;
    
    private LoginDTO loginDTO = null;
    
    public AuthenServiceFacadeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() 
    {
        log.info("## begin setup data ##");
        
        this.loginDTO = new LoginDTO();
        this.loginDTO.setPassword("ao1234");
        this.loginDTO.setUsername("jeerapun.m");
        
        log.info("## finish setup data ##");
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
    public void testAuthenSuccess() 
    {
        AuthenResultDTO authenResultDTO = this.authenServiceFacade.authen(loginDTO);
        assertEquals("0", authenResultDTO.getResultCode());
        
        assertNotNull(authenResultDTO.getTrxUser());
      
    }
}
