package com.lh708.condition;

import com.lh708.common.ValidationUtil;
import com.lh708.field.IField;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/7 9:59
 */
public class EmptyCondition<I> extends AbstractCondition<I> {
    private final IField<I> field;
    public EmptyCondition(IField<I> field){
        this.field = field;
        this.message = String.format("[ %s is empty]", this.field.getName());
    }

    public boolean check(I input) {
        Object value = this.field.getValue(input);
        return ValidationUtil.isEmpty(value);
    }
}
