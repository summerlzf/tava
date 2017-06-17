package com.tuandai.tava.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @author lzf
 */
public final class Utils {

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

    /**
     * 将对象集合按照拼接规则拼接成字符串，类似于JavaScript中的join方法 （空集合，返回emptyValue，可指定空串或null）
     * <p>e.g. : ["1", "2", "3"] -> "1,2,3" or "1;2;3", ...
     * @param col
     * @param split
     * @param emptyValue
     * @return
     */
    public static <T> String join(Collection<T> col, String split, String emptyValue) {
        if(isBlank(col)) return emptyValue;
        StringBuilder sb = new StringBuilder();
        for(T o : col) {
            sb.append(split).append(o);
        }
        return sb.substring(split.length());
    }

    /**
     * 将对象集合按照拼接规则拼接成字符串，类似于JavaScript中的join方法 （空集合，返回null）
     * <p>e.g. : ["1", "2", "3"] -> "1,2,3" or "1;2;3", ...
     * @param col
     * @param split
     * @return
     */
    public static <T> String join(Collection<T> col, String split) {
        return join(col, split, null);
    }

    /**
     * 将对象数组按照拼接规则拼接成字符串，类似于JavaScript中的join方法 （空数组，返回emptyValue，可指定空串或null）
     * <p>e.g. : ["1", "2", "3"] -> "1,2,3" or "1;2;3", ...
     * @param ary
     * @param split
     * @param emptyValue
     * @return
     */
    public static <T> String join(T[] ary, String split, String emptyValue) {
        return ary == null || ary.length == 0 ? emptyValue : join(asList(ary), split, emptyValue);
    }

    /**
     * 将对象数组按照拼接规则拼接成字符串，类似于JavaScript中的join方法 （空数组，返回null）
     * <p>e.g. : ["1", "2", "3"] -> "1,2,3" or "1;2;3", ...
     * @param ary
     * @param split
     * @return
     */
    public static <T> String join(T[] ary, String split) {
        return join(ary, split, null);
    }

    /**
     * 生成标准的32位MD5值
     * @param text
     * @return
     */
    public static String MD5(String text) {
        try {
            StringBuilder sb = new StringBuilder();
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(text.getBytes(StandardCharsets.UTF_8));
            for (byte b : md.digest()) {
                int n = b;
                if(n < 0) n += 256;
                if(n < 16) sb.append("0");
                sb.append(Integer.toHexString(n));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
        }
        return null;
    }

    /**
     * 生成SHA-1哈希
     * @param text
     * @return
     */
    public static String SHA1(String text) {
        try {
            Formatter ft = new Formatter();
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(text.getBytes(StandardCharsets.UTF_8));
            for (byte b : md.digest()) {
                ft.format("%02x", b);
            }
            String str = ft.toString();
            ft.close();
            return str;
        } catch (NoSuchAlgorithmException e) {
        }
        return null;
    }

    /**
     * 生成UUID
     * @return
     */
    public static String UUID() {
        return UUID.randomUUID().toString().toUpperCase();
    }

}
