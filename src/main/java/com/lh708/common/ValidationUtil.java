package com.lh708.common;

import java.util.List;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/6/30 9:08
 */
public class ValidationUtil {
    public static boolean equals(Object o1, Object o2){
        if (o1 == null && o2 == null) return true;
        if (o1 == null || o2 == null) return false;

        if (o1 instanceof String && o2 instanceof String) {
            return ((String) o1).trim().equals(((String) o2).trim());
        }
        return false;
    }

    public static boolean notEquals(Object o1, Object o2){
        return !equals(o1, o2);
    }

    public static boolean isEmpty(Object o){
        if (o == null) return true;

        if (o instanceof String) return "".equals(((String) o).trim());
        if (o instanceof List) return ((List) o).isEmpty();

        return false;
    }

    public static boolean isNotEmpty(Object o){
        return ! isEmpty(o);
    }

    public static <V extends Comparable> boolean between(V test, V min, V max){
        if (min != null && max != null){
            return min.compareTo(test) <= 0 && max.compareTo(test) >= 0;
        }else if (min != null){
            return min.compareTo(test) <= 0;
        }else if (max != null){
            return max.compareTo(test) >= 0;
        }else return true;
    }
}
