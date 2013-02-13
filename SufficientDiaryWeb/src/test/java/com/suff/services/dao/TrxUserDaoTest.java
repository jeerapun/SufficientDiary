/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suff.services.dao;

import com.suff.domain.TrxUser;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.suff.dao.TrxUserDao;
import com.suff.config.SpringConfigTest;
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
public class TrxUserDaoTest {
    
    private static Logger log = Logger.getLogger(TrxUserDaoTest.class);
    
    @Autowired
    private TrxUserDao trxUserDao;
    
    public TrxUserDaoTest() {
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
    public void getUserByName()
    {
        String username = "jeerapun.m";
        TrxUser trxUser = this.trxUserDao.getByUserName(username);
        log.info(trxUser.toString());
        assertNotNull(trxUser);
    }
    
    @Test
    public void userNotFound()
    {
        String username = "jeerapun.mx";
        TrxUser trxUser = this.trxUserDao.getByUserName(username);
        assertNull(trxUser);
    }
}
