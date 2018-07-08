package com.test.cases;

import com.lh708.result.SingleResultContainer;
import com.test.bean.Item;
import com.test.bean.Order;
import com.test.validator.OrderValidator;

import static com.test.helper.OrderValidationHelper.ItemField.*;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/8 10:57
 */
public class ChildFieldTest extends BaseTestCase {
    public void testChildFieldRequired(){
        ItemId.validator
                .required();
        Order order = new Order();
        SingleResultContainer container = new SingleResultContainer();

        assertTrue(OrderValidator.validate(order, container));

        Item item = new Item();
        order.addItem(item);
        assertFalse(OrderValidator.validate(order, container));
        assertEquals("ItemId must not be empty ", container.getResult());

        item.setItemId("12345");
        assertTrue(OrderValidator.validate(order, container));

        Item item1 = new Item();
        order.addItem(item1);
        assertFalse(OrderValidator.validate(order, container));
        assertEquals("ItemId must not be empty ", container.getResult());

        item1.setItemId("1234546");
        assertTrue(OrderValidator.validate(order, container));
    }
}
