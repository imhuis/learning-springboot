package org.imhui.jdbc.tx;

import javax.persistence.RollbackException;

/**
 * @author: zyixh
 * @date: 2020/10/14 22:31
 * @description:
 */
public interface TxService {

    void insertRecord();
    void insertThenRollback() throws RollbackException;
    void invokeInsertThenRollback() throws RollbackException;
}
