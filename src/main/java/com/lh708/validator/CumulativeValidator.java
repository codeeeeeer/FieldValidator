package com.lh708.validator;

import com.lh708.field.IField;
import com.lh708.result.ResultContainer;
import com.lh708.rule.AbstractValidationRule;

import java.util.List;

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
        if ( ! validateChild(input, output)){
            flag = false;
        }
        return flag;
    }

    private boolean validateChild(I input, ResultContainer output){
        boolean flag = true;
        Object value = this.field.getValue(input);
        if (value != null && value instanceof List){

            IField<?>[] group = this.field.getGroup();
            if (group != null && group.length > 0){
                for (Object child:
                        (List)value) {
                    for (IField childField:
                            group) {
                        boolean validate = childField.validate(child, output);
                        if (! validate) {
                            flag = false;
                        }
                    }
                }
            }
        }
        return flag;
    }
}
