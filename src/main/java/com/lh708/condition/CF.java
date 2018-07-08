package com.lh708.condition;

import com.lh708.field.IField;

/**
 * 〈condition factory〉
 *
 * @author LewJay
 * @create 2018/7/7 17:58
 */
public class CF {
    public static <I> ICondition<I> AND(ICondition<I>... conditions){
        return new AndCondition<I>(conditions);
    }

    public static <I> ICondition<I> OR(ICondition<I>... conditions){
        return new OrCondition<I>(conditions);
    }

    public static <I> ICondition<I> NON(ICondition<I> condition){
        return new NonCondition<I>(condition);
    }

    public static <I> ICondition<I> TRUE(){
        return new TrueCondition<I>();
    }

    public static <I> ICondition<I> Equals(IField<I> input, Object expected){
        return new EqualsCondition<I>(input, expected);
    }

    public static <I> ICondition<I> Empty(IField<I> input){
        return new EmptyCondition<I>(input);
    }
}
