package com.lh708.validator;

import com.lh708.field.IField;
import com.lh708.result.ResultContainer;
import com.lh708.rule.AbstractValidationRule;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/2 20:26
 */
public class OneOffValidator<I> extends AbstractValidator<I> {
    public OneOffValidator(IField<I> field) {
        super(field);
    }
    public boolean validate(I input, ResultContainer output) {
        for (AbstractValidationRule<I> rule:
                this.rules) {
            if (rule.validate(input)){
                output.addResult(rule.getErrorMsg());
                return false;
            }
        }
        return true;
    }
}
