package com.lh708.rule;

import com.lh708.condition.ICondition;
import com.lh708.condition.TrueCondition;
import com.lh708.field.IField;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/6/30 9:01
 */
public abstract class AbstractValidationRule<I> {
    protected final IField<I> field;
    protected final ICondition<I> condition;
    protected String errorMsg;

    public AbstractValidationRule(IField<I> field, ICondition<I> condition) {
        this.field = field;
        this.condition = condition;
    }

    public abstract boolean validate(I input);

    public String getErrorMsg(){
        return this.errorMsg;
    }

    protected String getConditionMsg(){
        if (this.condition instanceof TrueCondition) return "";
        return String.format("when %s", this.condition.getMessage());
    }
}
