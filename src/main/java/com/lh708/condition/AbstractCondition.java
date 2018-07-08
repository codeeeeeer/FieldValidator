package com.lh708.condition;

/**
 * 〈base condition, defining some default methods and fields〉
 *
 * @author LewJay
 * @create 2018/7/7 9:35
 */
public abstract class AbstractCondition<I> implements ICondition<I>{
    protected String message = "";
    public String getMessage() {
        return this.message;
    }

    public ICondition<I> setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
