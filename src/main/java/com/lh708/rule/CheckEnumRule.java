package com.lh708.rule;

import com.lh708.condition.ICondition;
import com.lh708.field.IEnum;
import com.lh708.field.IField;
import com.lh708.common.ValidationUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/6/30 9:02
 */
public class CheckEnumRule<I> extends AbstractValidationRule<I> {

    public CheckEnumRule(IField<I> field, ICondition<I> condition) {
        super(field, condition);
        this.errorMsg = String.format("%s must be one of the values %s %s",
                field.getName(), getEnumValues(), getConditionMsg());
    }

    @Override
    public boolean validate(I input) {
        if (! condition.check(input)) return true;

        Object value = this.field.getValue(input);
        if (ValidationUtil.isEmpty(value))
            return true;

        IEnum[] enums = this.field.getEnums();
        if (enums == null || enums.length == 0) {
            return true;
        }
        for (IEnum enumValue:
                enums) {
            if (ValidationUtil.equals(enumValue.getValue(), value)) {
                return true;
            }
        }
        return false;
    }

    private List<String> getEnumValues(){
        List<String> result = new ArrayList<String>();
        for (IEnum enumValue:
            this.field.getEnums()) {
            result.add(enumValue.getValue());
        }
        return result;
    }
}
