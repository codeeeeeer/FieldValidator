package com.test.cases;

import com.lh708.validator.AbstractValidator;
import com.test.helper.OrderValidationHelper;
import junit.framework.TestCase;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/7 18:42
 */
public class BaseTestCase extends TestCase {
    @Override
    protected void setUp() throws Exception {
        clearRules();
    }

    protected void clearRules() {
        try {
            Class.forName("com.test.validator.OrderValidator");
            for (OrderValidationHelper.OrderField field:
                    OrderValidationHelper.OrderField.values()) {
                AbstractValidator validator = (AbstractValidator) field.validator;
                clear(validator);
            }
            for (OrderValidationHelper.ItemField field:
                    OrderValidationHelper.ItemField.values()) {
                AbstractValidator validator = (AbstractValidator) field.validator;
                clear(validator);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void clear(AbstractValidator validator) throws Exception{
        Field field = AbstractValidator.class.getDeclaredField("rules");
        field.setAccessible(true);
        List rules = (List) field.get(validator);
        rules.clear();
    }
}
