package com.lh708.field;

import com.lh708.result.ResultContainer;

/**
 * 〈this provides some common methods of field 〉
 *
 * @author LewJay
 * @create 2018/6/30 8:47
 */
public interface IField<I> {
    /**
     * get the field value from the input
     * @param input value source
     * @return the value
     */
    Object getValue(I input);

    /**
     *  check the field value
     * @param input
     * @param resultContainer
     * @return
     */
    boolean validate(I input, ResultContainer resultContainer);
    String getName();
    IEnum[] getEnums();
    IField<?>[] getGroup();
}
