package org.imhui.jdbc;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.imhui.jdbc.dao.BatchFooDao;
import org.imhui.jdbc.dao.FooDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
@Slf4j
/**
 * datasource-pool - hikariCP
 * dao - jdbcTemplate
 * tx -
 */
public class JdbcDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JdbcDemoApplication.class, args);
    }





    @Autowired
    private DataSource dataSource;
    @Autowired
    private FooDao fooDao;
    @Autowired
    private BatchFooDao batchFooDao;

    @Override
    public void run(String... args) throws Exception {
        showConnection();

        fooDao.insertData();
        batchFooDao.batchInsert();
        fooDao.listData();
    }


    private void showConnection() throws SQLException {

        log.info(dataSource.toString());
        Connection conn = dataSource.getConnection();
        log.info(conn.toString());
        conn.close();
    }

}
