package org.imhui.jdbc.exception;

import org.springframework.dao.DuplicateKeyException;

/**
 * @author: zyixh
 * @date: 2020/10/15 22:50
 * @description:
 */
public class CustomDuplicatedKeyException extends DuplicateKeyException {

    /**
     * {@link org.springframework.jdbc.support.sql-error-codes.xml}
     */

    public CustomDuplicatedKeyException(String msg) {
        super(msg);
    }
    public CustomDuplicatedKeyException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
