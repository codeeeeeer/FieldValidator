package com.lh708.result;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/2 19:59
 */
public class SingleResultContainer implements ResultContainer<String> {
    private String result;

    public void addResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
