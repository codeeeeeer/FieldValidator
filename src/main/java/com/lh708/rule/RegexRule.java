package com.lh708.rule;

import com.lh708.common.ValidationUtil;
import com.lh708.condition.ICondition;
import com.lh708.field.IField;

import java.util.regex.Pattern;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/4 21:20
 */
public class RegexRule<I> extends AbstractValidationRule<I> {
    private final Pattern pattern;

    public RegexRule(IField<I> field, String regex, ICondition<I> condition) {
        super(field, condition);
        this.pattern = Pattern.compile(regex);
        this.errorMsg = String.format("%s is invalid %s",
                this.field.getName(), getConditionMsg());
    }

    @Override
    public boolean validate(I input) {
        if (! condition.check(input))
            return true;

        Object value = this.field.getValue(input);
        if (ValidationUtil.isEmpty(value)) return true;

        if (value instanceof String)
            return this.pattern.matcher((String) value).matches();
        return false;
    }
}
