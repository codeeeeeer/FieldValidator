package com.test;

import com.test.cases.MultipleConditionTest;
import com.test.cases.OrderValidatorTest;
import com.test.cases.RuleTest;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/2 20:15
 */
public class ValidationTestSuite {
    public static void main(String[] args) {
        TestSuite suite = new TestSuite();

        suite.addTestSuite(OrderValidatorTest.class);
        suite.addTestSuite(RuleTest.class);
        suite.addTestSuite(MultipleConditionTest.class);

        TestRunner.run(suite);
    }
}
