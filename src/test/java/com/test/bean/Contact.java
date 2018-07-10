package com.test.bean;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/10 19:27
 */
@Data
@Accessors(chain = true)
public class Contact {
    private String type;
    private String number;
    private String name;
}
