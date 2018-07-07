package com.test.cases;

import com.lh708.condition.CF;
import com.lh708.result.SingleResultContainer;
import com.test.bean.Order;
import com.test.validator.OrderValidator;

import static com.test.helper.OrderValidationHelper.OrderField.*;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/7 18:40
 */
public class MultipleConditionTest extends BaseTestCase {

    public void testAnd(){
        PostFee.validator
                .required(CF.AND(
                            CF.NON(CF.Empty(Status)),
                            CF.Empty(CustomerId)
                        )
                );

        Order order = new Order();
        SingleResultContainer resultContainer = new SingleResultContainer();

        assertTrue(OrderValidator.validate(order, resultContainer));

        order.setStatus(4);
        assertFalse(OrderValidator.validate(order, resultContainer));
        assertEquals("PostFee must not be empty when [  non [ Status is empty]  and [ CustomerId is empty] ]",
                resultContainer.getResult());
    }

    public void testOr(){
        PostFee.validator
                .required(CF.OR(
                            CF.NON(CF.Empty(Status)),
                            CF.Empty(CustomerId)
                        )
                );

        Order order = new Order();
        SingleResultContainer resultContainer = new SingleResultContainer();

        assertFalse(OrderValidator.validate(order, resultContainer));
        assertEquals("PostFee must not be empty when [  non [ Status is empty]  or [ CustomerId is empty] ]",
                resultContainer.getResult());
    }

    public void testOrWithMsgDefined(){
        PostFee.validator
                .required(CF.OR(
                            CF.NON(CF.Empty(Status)),
                            CF.Empty(CustomerId)
                        ).setMessage("when status is not empty or customerId is empty")
                );

        Order order = new Order();
        SingleResultContainer resultContainer = new SingleResultContainer();

        assertFalse(OrderValidator.validate(order, resultContainer));
        assertEquals("PostFee must not be empty when when status is not empty or customerId is empty",
                resultContainer.getResult());
    }
}
