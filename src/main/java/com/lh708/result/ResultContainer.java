package com.lh708.result;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/6/30 9:57
 */
public interface ResultContainer<T> {

    /**
     * add error messages to the target errorMsgs
     * @param result
     */
    public abstract void addResult(String result);

    /**
     * get the error messages
     * @return the error messages
     */
    public abstract T getResult();
}
