package com.lh708.rule;

import com.lh708.common.ValidationUtil;
import com.lh708.condition.ICondition;
import com.lh708.field.IField;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/7 11:04
 */
public class EmptyRule<I> extends AbstractValidationRule<I> {
    public EmptyRule(IField<I> field, ICondition<I> condition){
        super(field, condition);
        this.errorMsg = String.format("%s must be empty %s",
                this.field.getName(), getConditionMsg());
    }

    @Override
    public boolean validate(I input) {
        if (! condition.check(input))
            return true;

        Object value = this.field.getValue(input);
        return ValidationUtil.isEmpty(value);
    }
}
