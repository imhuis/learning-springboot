package org.imhui.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.imhui.jdbc.tx.TxService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author: zyixh
 * @date: 2020/10/14 22:34
 * @description:
 */
@SpringBootTest
@Slf4j
public class DeclarativeTransactionTest {

    @Autowired
    private TxService txService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test() {
        txService.insertRecord();
        log.info("AAA {}",
                jdbcTemplate
                        .queryForObject("SELECT COUNT(*) FROM TX WHERE BAR='AAA'", Long.class));
        try {
            txService.insertThenRollback();
        } catch (Exception e) {
            log.info("BBB {}",
                    jdbcTemplate
                            .queryForObject("SELECT COUNT(*) FROM TX WHERE BAR='BBB'", Long.class));
        }

        try {
            txService.invokeInsertThenRollback();
        } catch (Exception e) {
            log.info("BBB {}",
                    jdbcTemplate
                            .queryForObject("SELECT COUNT(*) FROM TX WHERE BAR='BBB'", Long.class));
        }

    }
}
