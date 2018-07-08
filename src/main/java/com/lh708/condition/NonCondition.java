package com.lh708.condition;

/**
 * 〈opposite the condition〉
 *
 * @author LewJay
 * @create 2018/7/7 9:48
 */
public class NonCondition<I> extends AbstractCondition<I> {
    private final ICondition<I> condition;
    public NonCondition(ICondition<I> condition){
        this.condition = condition;
        this.message = String.format(" non %s ", condition.toString());
    }
    public boolean check(I input) {
        boolean check = condition.check(input);
        return !check;
    }
}
