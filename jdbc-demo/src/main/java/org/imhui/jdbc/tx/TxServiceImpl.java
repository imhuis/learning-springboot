package org.imhui.jdbc.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.RollbackException;

/**
 * @author: zyixh
 * @date: 2020/10/14 22:31
 * @description:
 */
@Service
public class TxServiceImpl implements TxService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TxService txService;

    @Override
    @Transactional
    public void insertRecord() {
        jdbcTemplate.execute("INSERT INTO TX (BAR) VALUES ('AAA')");
    }

    @Override
    @Transactional(rollbackFor = RollbackException.class)
    public void insertThenRollback() throws RollbackException {
        jdbcTemplate.execute("INSERT INTO TX (BAR) VALUES ('BBB')");
        throw new RollbackException();
    }

    /**
     * 没有使用真正的事务 只是使用数据库的隐式事务
     * @throws RollbackException
     */
    @Override
    public void invokeInsertThenRollback() throws RollbackException {
//        insertThenRollback();
        txService.insertThenRollback();
    }
}
