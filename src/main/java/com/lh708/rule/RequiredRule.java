package com.lh708.rule;

import com.lh708.condition.ICondition;
import com.lh708.field.IField;
import com.lh708.common.ValidationUtil;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/6/30 9:02
 */
public class RequiredRule<I> extends AbstractValidationRule<I> {
    public RequiredRule(IField<I> field, ICondition<I> condition) {
        super(field, condition);
        this.errorMsg = String.format("%s must not be empty %s",
                this.field.getName(), getConditionMsg());
    }

    @Override
    public boolean validate(I input) {
        if (! condition.check(input))
            return true;

        Object value = this.field.getValue(input);
        return ValidationUtil.isNotEmpty(value);
    }
}
