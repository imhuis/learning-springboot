package org.imhui.jdbc;

import org.imhui.jdbc.exception.CustomDuplicatedKeyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author: zyixh
 * @date: 2020/10/15 22:51
 * @description:
 */
@SpringBootTest
public class ErrorCodeDemoApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testThrowingCustomException() {
//        jdbcTemplate.execute("INSERT INTO FOO (ID, BAR) VALUES (1, 'a')");
//        jdbcTemplate.execute("INSERT INTO FOO (ID, BAR) VALUES (1, 'b')");

        assertThrows(CustomDuplicatedKeyException.class, () -> {
            jdbcTemplate.execute("INSERT INTO FOO (ID, BAR) VALUES (1, 'a')");
            jdbcTemplate.execute("INSERT INTO FOO (ID, BAR) VALUES (1, 'b')");
        });
    }
}
