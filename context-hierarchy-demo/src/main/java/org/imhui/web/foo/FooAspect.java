package org.imhui.web.foo;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author: zyixh
 * @date: 2020/9/26 16:33
 * @description:
 */
@Aspect
@Slf4j
public class FooAspect {

    @AfterReturning("bean(testBean*)")
    public void printAfter(){
        log.error("After hello() -- aspect import");
    }


}
