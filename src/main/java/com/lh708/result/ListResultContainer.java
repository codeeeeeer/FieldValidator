package com.lh708.result;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/6/30 10:05
 */
public class ListResultContainer implements ResultContainer<List<String>> {
    private final List<String> errorMsgs;

    public ListResultContainer(){
        errorMsgs = new ArrayList<String>();
    }
    public void addResult(String result) {
        this.errorMsgs.add(result);
    }

    public List<String> getResult() {
        return this.errorMsgs;
    }
}
