package com.test.bean;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/3 20:10
 */
@Data
@Accessors(chain = true)
public class Item {
    private String itemId;
    private Integer num;
    private String title;
    private BigDecimal price;
    private BigDecimal totalFee;
}
