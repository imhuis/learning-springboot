package org.imhui.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: zyixh
 * @date: 2020/10/1 18:12
 * @description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coffee implements Serializable {
    private Long id;
    private String name;
//    private BigDecimal price;
    private Money price;
    private Date createTime;
    private Date updateTime;
}
