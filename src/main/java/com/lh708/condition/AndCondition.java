package com.lh708.condition;

import org.apache.commons.lang3.StringUtils;

/**
 * 〈all the conditions should be satisfied〉
 *
 * @author LewJay
 * @create 2018/7/7 9:35
 */
public class AndCondition<I> extends AbstractCondition<I> {
    private final ICondition<I>[] cs;
    public AndCondition(ICondition<I>... cs){
        this.cs = cs;
        this.message = String.format("[ %s ]",
                StringUtils.join(cs, " and "));
    }

    public boolean check(I input) {
        for (ICondition<I> condition:
                cs) {
            if ( ! condition.check(input))
                return false;
        }
        return true;
    }
}
