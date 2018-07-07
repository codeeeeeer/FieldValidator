package com.lh708.result;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/2 19:45
 */
public class FieldResultContainer<T> implements ResultContainer<String> {
    private final T target;
    private final String fieldName;

    public FieldResultContainer(T target) {
        this.target = target;
        this.fieldName = "message";
    }

    public FieldResultContainer(T target, String fieldName) {
        this.target = target;
        this.fieldName = fieldName;
    }

    public void addResult(String result) {
        try {
            PropertyUtils.setProperty(target, fieldName, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getResult() {
        try {
            return (String) PropertyUtils.getProperty(target, fieldName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
