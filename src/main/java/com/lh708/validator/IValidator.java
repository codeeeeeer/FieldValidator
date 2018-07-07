package com.lh708.validator;

import com.lh708.condition.ICondition;
import com.lh708.field.IField;
import com.lh708.result.ResultContainer;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/6/30 8:53
 */
public interface IValidator<I> {
    IValidator<I> required();
    IValidator<I> required(ICondition<I> condition);
    IValidator<I> checkEnums();
    IValidator<I> checkEnums(ICondition<I> condition);
    <V extends Comparable> IValidator<I> range(V min, V max);
    <V extends Comparable> IValidator<I> range(V min, V max, ICondition<I> condition);
    IValidator<I> size(Integer min, Integer max);
    IValidator<I> size(Integer min, Integer max, ICondition<I> condition);
    IValidator<I> mustEmpty(ICondition<I> condition);
    IValidator<I> regex(String regex);
    IValidator<I> regex(String regex, ICondition<I> condition);
    boolean validate(I input, ResultContainer output);

//
//    @Deprecated
//    IValidator<I> requiredIfEquals(IField<I> other, Object expected);
//    @Deprecated
//    IValidator<I> mustEmptyIfEmpty(IField<I> other);
//    @Deprecated
//    IValidator<I> requiredIfEmpty(IField<I> other);
//    @Deprecated
//    IValidator<I> sizeIfEquals(Integer min, Integer max, IField<I> other, Object expected);
//    @Deprecated
//    IValidator<I> regexIfEquals(String regex, IField<I> other, Object expected);
}
