package com.test.helper;

import com.lh708.field.IEnum;
import com.lh708.field.IField;
import com.lh708.result.ResultContainer;
import com.lh708.validator.CumulativeValidator;
import com.lh708.validator.IValidator;
import com.test.bean.Item;
import com.test.bean.Order;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/6/30 9:43
 */
public class OrderValidationHelper {

    public enum  OrderField implements IField<Order> {
        OrderId{
            public Object getValue(Order input) {
                return input.getOrderId();
            }
        },
        PaymentAccount {
            public Object getValue(Order input) {
                return input.getPaymentAccount();
            }
        },
        PaymentType{
            public Object getValue(Order input) {
                return input.getPaymentType();
            }

            @Override
            public IEnum[] getEnums() {
                return OrderFieldEnums.PaymentTypeEnums.values();
            }
        },
        PaymentTime{
            public Object getValue(Order input) {
                return input.getPaymentTime();
            }
        },
        PostFee{
            public Object getValue(Order input) {
                return input.getPostFee();
            }
        },
        Status{
            public Object getValue(Order input) {
                return input.getStatus();
            }
        },
        ShippingName{
            public Object getValue(Order input) {
                return input.getShippingName();
            }
        },
        ShippingCode{
            public Object getValue(Order input) {
                return input.getShippingCode();
            }
        },
        CustomerId{
            public Object getValue(Order input) {
                return input.getCustomerId();
            }
        },
        CustomerType{
            public Object getValue(Order input) {
                return input.getCustomerType();
            }

            @Override
            public IEnum[] getEnums() {
                return OrderFieldEnums.CustomerTypeEnums.values();
            }
        },
        BuyerMessage{
            public Object getValue(Order input) {
                return input.getBuyerMessage();
            }
        },
        BuyerNick{
            public Object getValue(Order input) {
                return input.getBuyerNick();
            }
        },
        BuyerRate{
            public Object getValue(Order input) {
                return input.getBuyerRate();
            }
        },
        ContactType{
            public Object getValue(Order input) {
                return input.getContactType();
            }

            @Override
            public IEnum[] getEnums() {
                return OrderFieldEnums.ContactTypeEnums.values();
            }
        },
        Contact{
            public Object getValue(Order input) {
                return input.getContact();
            }
        },
        Details{
            public Object getValue(Order input) {
                return input.getDetails();
            }

            @Override
            public IField<?>[] getGroup() {
                return ItemField.values();
            }
        },
        ;
        public final IValidator<Order> validator
                = new CumulativeValidator<Order>(this);

        public boolean validate(Order input, ResultContainer output) {
            return validator.validate(input, output);
        }

        public String getName() {
            return name();
        }

        public IEnum[] getEnums() {
            return new IEnum[0];
        }

        public IField<?>[] getGroup() {
            return new IField[0];
        }
    }
    public enum ItemField implements IField<Item> {
        ItemId{
            public Object getValue(Item input) {
                return input.getItemId();
            }
        },
        Num{
            public Object getValue(Item input) {
                return input.getNum();
            }
        },
        Title{
            public Object getValue(Item input) {
                return input.getTitle();
            }
        },
        Price{
            public Object getValue(Item input) {
                return input.getPrice();
            }
        },
        TotalFee{
            public Object getValue(Item input) {
                return input.getTotalFee();
            }
        },
        ;
        public final IValidator<Item> validator
                = new CumulativeValidator<Item>(this);

        public boolean validate(Item input, ResultContainer output) {
            return validator.validate(input, output);
        }

        public String getName() {
            return name();
        }

        public IEnum[] getEnums() {
            return new IEnum[0];
        }

        public IField<?>[] getGroup() {
            return new IField[0];
        }
    }
}
