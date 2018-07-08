package com.lh708.condition;

import org.apache.commons.lang3.StringUtils;

/**
 * 〈at least one of the conditions should be satisfied〉
 *
 * @author LewJay
 * @create 2018/7/7 9:42
 */
public class OrCondition<I> extends AbstractCondition<I> {
    private final ICondition<I>[] cs;
    public OrCondition(ICondition<I>... cs){
        this.cs = cs;
        this.message = String.format("[ %s ]",
                StringUtils.join(cs, " or "));
    }

    public boolean check(I input) {
        for (ICondition<I> condition:
                cs) {
            if (condition.check(input)) return true;
        }
        return false;
    }
}
