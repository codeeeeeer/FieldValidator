package com.test.bean;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/6/30 9:27
 */
@Data
@Accessors(chain = true)
public class Order {
    private String orderId;
    private String paymentAccount;
    private String paymentType;
    private Date paymentTime;
    private String postFee;
    private Integer status;
    private String shippingName;
    private String shippingCode;
    private Long customerId;
    private String customerType;
    private String buyerMessage;
    private String buyerNick;
    private Double buyerRate;
    private String contactType;
    private String contact;

    private Contact contact2;

    private List<Item> details;

    public Order addItem(Item item){
        if (this.details == null){
            this.details = new ArrayList<Item>();
        }
        this.details.add(item);
        return this;
    }
}
