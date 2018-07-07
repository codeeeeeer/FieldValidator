package com.lh708.validator;

import com.lh708.field.IField;
import com.lh708.result.ResultContainer;
import com.lh708.rule.AbstractValidationRule;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/6/30 8:56
 */
public class CumulativeValidator<I> extends AbstractValidator<I> {
    public CumulativeValidator(IField<I> field) {
        super(field);
    }

    public boolean validate(I input, ResultContainer output) {
        boolean flag = true;
        for (AbstractValidationRule<I> rule:
                this.rules) {
            if ( ! rule.validate(input)){
                flag = false;
                output.addResult(rule.getErrorMsg());
            }
        }
        return flag;
    }
}
