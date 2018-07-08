package com.lh708.condition;

/**
 * 〈the condition is always satisfied〉
 *
 * @author LewJay
 * @create 2018/7/7 9:55
 */
public class TrueCondition<I> extends AbstractCondition<I> {
    public boolean check(I input) {
        return true;
    }
}
