package org.imhui.jdbc.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author: zyixh
 * @date: 2020/10/14 21:29
 * @description:
 */
@Data
@Builder
public class Foo {
    private Long id;
    private String bar;
}
