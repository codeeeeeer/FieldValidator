package com.test.cases;

import com.lh708.common.ValidationConstant;
import com.lh708.condition.CF;
import com.lh708.result.SingleResultContainer;
import com.test.bean.Item;
import com.test.bean.Order;
import com.test.validator.OrderValidator;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import static com.test.helper.OrderValidationHelper.OrderField.*;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/5 19:34
 */
@Slf4j
public class RuleTest extends BaseTestCase {

    public void testCheckEnumRule(){
        CustomerType.validator
                .checkEnums();

        Order order = new Order();
        SingleResultContainer container = new SingleResultContainer();

        assertTrue(OrderValidator.validate(order, container));

        order.setCustomerType("ABCD");
        assertFalse(OrderValidator.validate(order, container));
        assertEquals("CustomerType must be one of the values [COMMON, MEMBER, COOPERATOR] "
                , container.getResult());

        order.setCustomerType("COMMON");
        assertTrue(OrderValidator.validate(order, container));
    }

    public void testMustEmptyIfEmptyRule(){
        Contact.validator
                .mustEmpty(CF.Empty(ContactType));

        Order order = new Order();
        SingleResultContainer container = new SingleResultContainer();

        assertTrue(OrderValidator.validate(order, container));

        order.setContact("12345678910");
        assertFalse(OrderValidator.validate(order, container));
        assertEquals("Contact must be empty when [ ContactType is empty]",
                container.getResult());

        order.setContactType("EMAIL");
        assertTrue(OrderValidator.validate(order, container));
    }

    public void testRangeRule1(){
        BuyerRate.validator
                .range(Double.valueOf(0.50), null);

        Order order = new Order();
        SingleResultContainer container = new SingleResultContainer();

        order.setBuyerRate(0.2);
        assertFalse(OrderValidator.validate(order, container));
        assertEquals("the value of BuyerRate must greater than or equal to 0.5 ",
                container.getResult());
    }

    public void testRangeRule2(){
        BuyerRate.validator
                .range(null, Double.valueOf(0.50));

        Order order = new Order();
        SingleResultContainer container = new SingleResultContainer();

        order.setBuyerRate(0.7);
        assertFalse(OrderValidator.validate(order, container));
        assertEquals("the value of BuyerRate must smaller than or equal to 0.5 ",
                container.getResult());
    }

    public void testRangeRule3(){
        BuyerRate.validator
                .range(Double.valueOf(0.20), Double.valueOf(0.50));

        Order order = new Order();
        SingleResultContainer container = new SingleResultContainer();

        order.setBuyerRate(0.1);
        assertFalse(OrderValidator.validate(order, container));
        assertEquals("the value of BuyerRate must between 0.2 and 0.5 ",
                container.getResult());

        order.setBuyerRate(0.8);
        assertFalse(OrderValidator.validate(order, container));
        assertEquals("the value of BuyerRate must between 0.2 and 0.5 ",
                container.getResult());

        order.setBuyerRate(0.4);
        assertTrue(OrderValidator.validate(order, container));
    }

    public void testRegexIfEqualsRule(){
        Contact.validator
                .regex(ValidationConstant.REGEX_EMAIL, CF.Equals(ContactType, "EMAIL"))
                .regex(ValidationConstant.REGEX_PHONENUMBER, CF.Equals(ContactType, "PHONE"))
                .regex(ValidationConstant.REGEX_POST, CF.Equals(ContactType, "POST"));

        Order order = new Order();
        SingleResultContainer container = new SingleResultContainer();

        order.setContact("12345678910");
        order.setContactType("PHONE");
        assertFalse(OrderValidator.validate(order, container));
        assertEquals("Contact is invalid when [ ContactType is PHONE]",
                container.getResult());

        order.setContact("13912345678");
        assertTrue(OrderValidator.validate(order, container));

        order.setContact("1234567");
        order.setContactType("EMAIL");
        assertFalse(OrderValidator.validate(order, container));
        assertEquals("Contact is invalid when [ ContactType is EMAIL]",
                container.getResult());

        order.setContact("1391234@qq.com");
        assertTrue(OrderValidator.validate(order, container));

        order.setContact("adsf123");
        order.setContactType("POST");
        assertFalse(OrderValidator.validate(order, container));
        assertEquals("Contact is invalid when [ ContactType is POST]",
                container.getResult());

        order.setContact("123456");
        assertTrue(OrderValidator.validate(order, container));
    }

    public void testRegexRule(){
        Contact.validator
                .regex(ValidationConstant.REGEX_EMAIL);
        Order order = new Order();
        SingleResultContainer container = new SingleResultContainer();

        order.setContact("12345678910");
        assertFalse(OrderValidator.validate(order, container));
        assertEquals("Contact is invalid ",
                container.getResult());

        order.setContact("123456@qq.com");
        assertTrue(OrderValidator.validate(order, container));
    }

    public void testRequiredIfEmptyRule(){
        ShippingCode.validator
                .required(CF.Empty(ShippingName));

        Order order = new Order();
        SingleResultContainer container = new SingleResultContainer();

        assertFalse(OrderValidator.validate(order, container));
        assertEquals("ShippingCode must not be empty when [ ShippingName is empty]",
                container.getResult());

        order.setShippingCode("abc");
        assertTrue(OrderValidator.validate(order, container));

        order.setShippingCode(null);
        order.setShippingName("123");
        assertTrue(OrderValidator.validate(order, container));
    }

    public void testRequiredIfEqualsRule(){
        PaymentAccount.validator
                .required(CF.Equals(PaymentType, "CRDT"));

        Order order = new Order();
        SingleResultContainer container = new SingleResultContainer();

        order.setPaymentType("WECHAT");
        assertTrue(OrderValidator.validate(order, container));

        order.setPaymentType("CRDT");
        assertFalse(OrderValidator.validate(order, container));
        assertEquals("PaymentAccount must not be empty when [ PaymentType is CRDT]",
                container.getResult());

        order.setPaymentAccount("1234");
        assertTrue(OrderValidator.validate(order, container));
    }

    public void testRequiredRule(){
        OrderId.validator
                .required();

        Order order = new Order();
        SingleResultContainer container = new SingleResultContainer();

        assertFalse(OrderValidator.validate(order, container));
        assertEquals("OrderId must not be empty ",
                container.getResult());

        order.setOrderId("12345");
        assertTrue(OrderValidator.validate(order, container));
    }

    public void testSizeRule1(){
        OrderId.validator
                .size(5, null);

        Order order = new Order();
        SingleResultContainer container = new SingleResultContainer();

        order.setOrderId("123");
        assertFalse(OrderValidator.validate(order, container));
        assertEquals("the size/length of OrderId must greater than or equal to 5 ",
                container.getResult());
    }

    public void testSizeIfEqualsRule(){
        Details.validator
                .size(2, 4, CF.Equals(CustomerType, "COMMON"));

        Order order = new Order();
        SingleResultContainer container = new SingleResultContainer();

        List<Item> items = new ArrayList<Item>();
        items.add(new Item());
        order.setDetails(items);

        order.setCustomerType("COMMON");
        assertFalse(OrderValidator.validate(order, container));
        assertEquals("the size/length of Details must between 2 and 4 when [ CustomerType is COMMON]",
                container.getResult());

        items.add(new Item());
        assertTrue(OrderValidator.validate(order, container));
    }
}
