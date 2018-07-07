package com.test.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/3 20:10
 */
@Data
public class Item {
    private String itemId;
    private Integer num;
    private String title;
    private BigDecimal price;
    private BigDecimal totalFee;
}
