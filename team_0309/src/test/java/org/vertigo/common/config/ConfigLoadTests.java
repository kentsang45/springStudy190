package org.vertigo.common.config;

import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.vertigo.common.config.RootConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

import static org.junit.Assert.assertNotNull;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={RootConfig.class})
public class ConfigLoadTests {

    @Autowired
    private DataSource ds;

    @Autowired
    private SqlSessionFactory ssf;

    @Test
    public void testRootConfig(){
        log.info("================= CommonConfigTest ====================");
    }

    @Test
    public void testDataSource(){
        log.info("================= testDataSource ====================");
        log.info("================= ds : "+ds+" ====================");
        assertNotNull(ds);
    }

    @Test
    public void testSSF(){
        log.info("================= testSqlSessionFactory ====================");

        try(SqlSession session = ssf.openSession()){
            log.info("================= testSqlSessionFactory : "+session+" ====================");
            assertNotNull(ssf);
        }catch(Exception e) {
            log.info(e.getMessage());
        }

        log.info("================= testSqlSessionFactory Done ====================");
    }
}
