package com.lh708.condition;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/7 9:32
 */
public interface ICondition<I> {

    /**
     * check the input base on the condition
     * @param input the target for checking
     * @return whether the condition is satisfied
     */
    boolean check(I input);

    /**
     * get the condition message
     * @return the condition message
     */
    String getMessage();

    /**
     * set the condition message
     * @param message the condition message
     * @return return itself for chain programming
     */
    ICondition<I> setMessage(String message);
}
