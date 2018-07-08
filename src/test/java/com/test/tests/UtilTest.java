package com.test.tests;

import com.lh708.common.ValidationUtil;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/8 9:25
 */
public class UtilTest extends TestCase {
    public void testEquals(){
        //String Test
        assertTrue(ValidationUtil.equals(" test ", "test"));
        assertTrue(ValidationUtil.equals(" test ", "test "));
        assertTrue(ValidationUtil.equals(" test ", " test "));
        assertFalse(ValidationUtil.equals("test", "ttt"));
        assertFalse(ValidationUtil.equals(null, "ttt"));
        assertTrue(ValidationUtil.equals(null, null));

        //Comparable Test
        assertTrue(ValidationUtil.equals(123, 123));
        assertTrue(ValidationUtil.equals(123, Integer.valueOf(123)));
        assertFalse(ValidationUtil.equals(123, 123L));
        assertTrue(ValidationUtil.equals(123L, 123L));
    }

    public void testEmpty(){
        assertTrue(ValidationUtil.isEmpty(null));
        assertTrue(ValidationUtil.isEmpty(""));
        assertTrue(ValidationUtil.isEmpty("    "));
        assertTrue(ValidationUtil.isEmpty("\t"));
        assertFalse(ValidationUtil.isEmpty("h"));

        List<Object> objects = new ArrayList<Object>();
        assertTrue(ValidationUtil.isEmpty(objects));

        objects.add("sh");
        assertFalse(ValidationUtil.isEmpty(objects));
    }
}
