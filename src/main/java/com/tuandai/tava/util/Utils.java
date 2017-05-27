package com.tuandai.tava.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by lzf on 2017/5/27.
 */
public class Utils {

    /**
     * <p>检查字符串是否为null或者空串（""）</p>
     * <pre>
     * CommonUtil.isBlank(null)      = true
     * CommonUtil.isBlank("")        = true
     * CommonUtil.isBlank(" ")       = true
     * CommonUtil.isBlank("bob")     = false
     * CommonUtil.isBlank("  bob  ") = false
     * </pre>
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    /**
     * 检查集合是否为null或者空（0个元素）
     * @param col
     * @return
     */
    public static boolean isBlank(Collection<?> col) {
        return col == null || col.isEmpty();
    }

    /**
     * 将数组转换为{@link List}，空数组返回空的{@link ArrayList}（非null）
     * @param ary
     * @param <T>
     * @return
     */
    public static <T> List<T> asList(T... ary) {
        return ary == null || ary.length == 0 ? new ArrayList<>() : new ArrayList<>(Arrays.asList(ary));
    }

    /**
     * 将集合{@link Collection}转换为{@link List}，空集合返回空的{@link ArrayList}（非null）
     * @param <T>
     * @param col
     * @return
     */
    public static <T> List<T> asList(Collection<T> col) {
        return isBlank(col) ? new ArrayList<>() : new ArrayList<>(col);
    }

}
