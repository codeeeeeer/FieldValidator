package com.lh708.condition;

import com.lh708.common.ValidationUtil;
import com.lh708.field.IField;

/**
 * 〈check whether the field is the expected value〉
 *
 * @author LewJay
 * @create 2018/7/7 9:51
 */
public class EqualsCondition<I> extends AbstractCondition<I> {
    private final IField<I> field;
    private final Object expected;

    public EqualsCondition(IField<I> field, Object expected){
        this.field = field;
        this.expected = expected;
        this.message = String.format("[ %s is %s]",
                this.field.getName(), this.expected.toString());
    }

    public boolean check(I input) {
        Object value = this.field.getValue(input);
        return ValidationUtil.equals(expected, value);
    }
}
