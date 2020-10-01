package org.imhui.mvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: zyixh
 * @date: 2020/9/29 19:50
 * @description:
 */
@RestControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> validationExceptionHandler(ValidationException exception) {
        Map<String, String> map = new HashMap<>();
        map.put("message", exception.getMessage());
        return map;
    }

    /**
     * @ExceptionHandler 使用位置 @Controller @RestController(优先级高) @ControllerAdvice @RestControllerAdvice
     */

    /**
     * 异常处理核心类 {@link org.springframework.web.servlet.HandlerExceptionResolver}
     * 实现类
     * {@link org.springframework.web.servlet.handler.SimpleMappingExceptionResolver}
     * {@link org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver}
     * {@link org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver}
     * {@link org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver}
     */
}
