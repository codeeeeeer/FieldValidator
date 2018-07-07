package com.lh708.rule;

import com.lh708.condition.ICondition;
import com.lh708.field.IField;
import com.lh708.common.ValidationUtil;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/2 20:54
 */
public class RangeRule<I, V extends Comparable> extends AbstractValidationRule<I> {
    private final V min, max;

    public RangeRule(IField<I> field, V min, V max, ICondition<I> condition) {
        super(field, condition);
        this.min = min;
        this.max = max;
        if (min != null && max != null){
            this.errorMsg = String.format("the value of %s must between %s and %s %s",
                    this.field.getName(), this.min.toString(), this.max.toString(), getConditionMsg());
        }else if (min != null){
            this.errorMsg = String.format("the value of %s must greater than or equal to %s %s",
                    this.field.getName(), this.min.toString(), getConditionMsg()) ;
        }else if (max != null){
            this.errorMsg = String.format("the value of %s must smaller than or equal to %s %s",
                    this.field.getName(), this.max.toString(), getConditionMsg());
        }
    }

    @Override
    public boolean validate(I input) {
        if (! condition.check(input))
            return true;

        Object value = this.field.getValue(input);
        if (ValidationUtil.isEmpty(value)){
            return true;
        }

        if (min != null && max != null){
            return this.min.compareTo(value) <= 0 && this.max.compareTo(value) >= 0;
        }else if (min != null){
            return this.min.compareTo(value) <= 0;
        }else if (max != null){
            return this.max.compareTo(value) >= 0;
        }

        return true;
    }
}
