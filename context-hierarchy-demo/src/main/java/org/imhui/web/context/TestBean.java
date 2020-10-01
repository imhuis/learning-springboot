package org.imhui.web.context;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: zyixh
 * @date: 2020/9/26 16:31
 * @description:
 */
@AllArgsConstructor
@Slf4j
public class TestBean {

    private String context;

    public void hello(){
        log.error("Hello " + context);
    }
}
