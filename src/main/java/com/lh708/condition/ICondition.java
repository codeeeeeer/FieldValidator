package com.lh708.condition;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/7 9:32
 */
public interface ICondition<I> {
    boolean check(I input);
    String getMessage();
    ICondition<I> setMessage(String errorMsg);
}
