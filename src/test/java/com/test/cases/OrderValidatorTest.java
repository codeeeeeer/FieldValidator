package com.test.cases;

import com.lh708.result.ListResultContainer;
import com.test.bean.Order;
import com.test.validator.OrderValidator;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/6/30 18:14
 */
public class OrderValidatorTest extends TestCase {
    public void test(){
        Order order = new Order();
        ListResultContainer resultHolder = new ListResultContainer();
        boolean validate = OrderValidator.validate(order, resultHolder);

        List<String> expectedResult = new ArrayList<String>();
        expectedResult.add("OrderId must not be empty ");
        expectedResult.add("PaymentAccount must not be empty ");
        expectedResult.add("PaymentType must not be empty ");
        expectedResult.add("PaymentTime must not be empty ");
        expectedResult.add("ShippingName must not be empty when [ ShippingCode is empty]");
        expectedResult.add("CustomerId must not be empty ");
        expectedResult.add("CustomerType must not be empty ");
        expectedResult.add("Details must not be empty ");

        assertFalse(validate);
        assertEquals(expectedResult, resultHolder.getResult());
    }
}
