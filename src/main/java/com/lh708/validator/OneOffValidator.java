package com.lh708.validator;

import com.lh708.field.IField;
import com.lh708.result.ResultContainer;
import com.lh708.rule.AbstractValidationRule;

import java.util.Collection;
import java.util.List;

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
        return validateChild(input, output);
    }

    private boolean validateChild(I input, ResultContainer output){
        Object value = this.field.getValue(input);
        if (value == null) return true;

        IField<?>[] group = this.field.getGroup();
        if (group != null && group.length > 0){
            if (value instanceof Collection){
                for (Object child: (Collection)value) {
                    for (IField childField: group) {
                        boolean validate = childField.validate(child, output);
                        if (! validate)
                            return false;
                    }
                }
            }else{
                for (IField childField: group) {
                    boolean validate = childField.validate(value, output);
                    if (! validate)
                        return false;
                }
            }
        }
        return true;
    }
}
