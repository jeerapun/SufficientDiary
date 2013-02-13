/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suff.services;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.suff.config.SpringConfigTest;
import com.suff.dao.TrxUserDao;
import com.suff.dao.impl.TrxUserDaoImpl;
import com.suff.domain.AuthenResultDTO;
import com.suff.domain.TrxUser;
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
import org.springframework.test.util.ReflectionTestUtils;
import static org.junit.Assert.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

/**
 *
 * @author Jeerapu
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfigTest.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
public class AuthenServiceTest {
    
    @Autowired
    private AuthenService authenService ;
    
    //for mock
    private TrxUserDao trxUserDao;
    
    public AuthenServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        this.trxUserDao = mock(TrxUserDaoImpl.class);
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
          TrxUser trxUser = new TrxUser();
          trxUser.setUsername("jeerapun.m");
          trxUser.setCredential("ao1234");
          when(this.trxUserDao.getByUserName(any(String.class))).thenReturn(trxUser);
          ReflectionTestUtils.setField(authenService, "trxUserDao", trxUserDao);
          
          AuthenResultDTO authenResultDTO = authenService.authen("jeerapun.m","ao1234");        
          assertEquals("0", authenResultDTO.getResultCode());     
     }
     
      @Test
     public void testAuthenFailUserNotFound() 
     {
          
          when(this.trxUserDao.getByUserName(any(String.class))).thenReturn(null);
          ReflectionTestUtils.setField(authenService, "trxUserDao", trxUserDao);
          
         AuthenResultDTO authenResultDTO  = authenService.authen("jeerapun.mx","ao#$1701");        
         assertEquals("10001", authenResultDTO.getResultCode());
         
         
     }
      
     @Test
     public void testAuthenFailUserOrPasswordInvalid() 
     { 
         TrxUser trxUser = new TrxUser();
         trxUser.setUsername("jeerapun.m");
         trxUser.setCredential("ao1234");
         when(this.trxUserDao.getByUserName(any(String.class))).thenReturn(trxUser);
         ReflectionTestUtils.setField(authenService, "trxUserDao", trxUserDao);
         
         AuthenResultDTO authenResultDTO  = authenService.authen("jeerapun.m","xxx");        
         assertEquals("10002", authenResultDTO.getResultCode());       
         
     }
     
     @Test
     public void testAuthenException() 
     {
        doThrow(new NullPointerException("Something Wrong")).when(this.trxUserDao).getByUserName(any(String.class));
        ReflectionTestUtils.setField(authenService, "trxUserDao", trxUserDao);
        AuthenResultDTO authenResultDTO  = authenService.authen("jeerapun.m","xxx");        
        assertEquals("10065", authenResultDTO.getResultCode());       
         
     }
     
     
     
}
