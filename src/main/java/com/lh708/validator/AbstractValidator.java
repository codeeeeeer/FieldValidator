package com.lh708.validator;

import com.lh708.condition.ICondition;
import com.lh708.condition.TrueCondition;
import com.lh708.field.IField;
import com.lh708.rule.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/2 20:21
 */
public abstract class AbstractValidator<I> implements IValidator<I>{
    protected final IField<I> field;
    protected final List<AbstractValidationRule<I>> rules;

    public AbstractValidator(IField<I> field) {
        this.field = field;
        this.rules = new ArrayList<AbstractValidationRule<I>>();
    }

    public IValidator<I> required() {
        this.rules.add(new RequiredRule<I>(this.field, new TrueCondition<I>()));
        return this;
    }

    public IValidator<I> required(ICondition<I> condition) {
        this.rules.add(new RequiredRule<I>(this.field, condition));
        return this;
    }

    public IValidator<I> checkEnums() {
        this.rules.add(new CheckEnumRule<I>(this.field, new TrueCondition<I>()));
        return this;
    }

    public IValidator<I> checkEnums(ICondition<I> condition) {
        this.rules.add(new CheckEnumRule<I>(this.field, condition));
        return this;
    }

    public IValidator<I> size(Integer min, Integer max) {
        this.rules.add(new SizeRule<I>(this.field, min, max, new TrueCondition<I>()));
        return this;
    }

    public IValidator<I> size(Integer min, Integer max, ICondition<I> condition) {
        this.rules.add(new SizeRule<I>(this.field, min, max, condition));
        return this;
    }

    public <V extends Comparable> IValidator<I> range(V min, V max) {
        this.rules.add(new RangeRule<I, V>(this.field, min, max, new TrueCondition<I>()));
        return this;
    }

    public <V extends Comparable> IValidator<I> range(V min, V max, ICondition<I> condition) {
        this.rules.add(new RangeRule<I, V>(this.field, min, max, condition));
        return this;
    }

    public IValidator<I> regex(String regex) {
        this.rules.add(new RegexRule<I>(this.field, regex, new TrueCondition<I>()));
        return this;
    }

    public IValidator<I> regex(String regex, ICondition<I> condition) {
        this.rules.add(new RegexRule<I>(this.field, regex, condition));
        return this;
    }

    public IValidator<I> mustEmpty(ICondition<I> condition) {
        this.rules.add(new EmptyRule<I>(this.field, condition));
        return this;
    }

    //    public IValidator<I> requiredIfEquals(IField<I> other, Object expected) {
//        this.rules.add(new RequiredIfEqualsRule<I>(this.field, other, expected));
//        return this;
//    }
//    public IValidator<I> mustEmptyIfEmpty(IField<I> other) {
//        this.rules.add(new MustEmptyIfEmptyRule<I>(this.field, other));
//        return this;
//    }
//    public IValidator<I> requiredIfEmpty(IField<I> other) {
//        this.rules.add(new RequiredIfEmptyRule<I>(this.field, other));
//        return this;
//    }
//    public IValidator<I> sizeIfEquals(Integer min, Integer max, IField<I> other, Object expected) {
//        this.rules.add(new SizeIfEqualsRule<I>(this.field, min, max, other, expected));
//        return this;
//    }
//    public IValidator<I> regexIfEquals(String regex, IField<I> other, Object expected) {
//        this.rules.add(new RegexIfEqualsRule<I>(this.field, regex, other, expected));
//        return this;
//    }
}
