package com.test.helper;

import com.lh708.field.IEnum;
import com.lh708.common.ValidationUtil;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/3 21:03
 */
public class OrderFieldEnums {
    public enum CustomerTypeEnums implements IEnum {
        Common("COMMON", "common user"),
        Member("MEMBER", "vip user"),
        Cooperator("COOPERATOR", "Cooperation partner"),
        ;
        private final String value;
        private final String description;
        CustomerTypeEnums(String value, String description){
            this.value = value;
            this.description = description;
        }

        public String getValue() {
            return this.value;
        }

        @Override
        public String toString() {
            return this.value + (
                    ValidationUtil.isNotEmpty(description) ?
                            String.format("[%s]",this.description) : "");
        }
    }
    public enum PaymentTypeEnums implements IEnum {
        CreditCard("CRDT", "credit card"),
        WeChat("WECHAT", "wei xin pay"),
        AliPay("ALIPAY", "alibaba pay"),
        Cash("CASH", "cash"),
        ;
        private final String value;
        private final String description;
        PaymentTypeEnums(String value, String description){
            this.value = value;
            this.description = description;
        }

        public String getValue() {
            return this.value;
        }

        @Override
        public String toString() {
            return this.value + (
                    ValidationUtil.isNotEmpty(description) ?
                            String.format("[%s]",this.description) : "");
        }
    }
    public enum ContactTypeEnums implements IEnum {
        PhoneNumber("PHONE", "telephone number"),
        Email("EMAIL", "E-mail"),
        POST("POST", "post"),
        ;
        private final String value;
        private final String description;
        ContactTypeEnums(String value, String description){
            this.value = value;
            this.description = description;
        }

        public String getValue() {
            return this.value;
        }

        @Override
        public String toString() {
            return this.value + (
                    ValidationUtil.isNotEmpty(description) ?
                            String.format("[%s]",this.description) : "");
        }
    }
}
