package com.zigzag.proxy.satic.demo2;

/**
 * 数据源路由对象,
 * 使用ThreadLocal单例实现
 *
 * @author qlk
 */
public class DynamicDataSourceEntry {
    public final static String DEFAULT_SOURCE = null;
    private final static ThreadLocal<String> LOCAL = new ThreadLocal<>();

    private DynamicDataSourceEntry() {
    }

    public static void clear() {
        LOCAL.remove();
    }

    public static String get() {
        return LOCAL.get();
    }

    public static void restore() {
        LOCAL.set(DEFAULT_SOURCE);
    }

    public static void set(String source) {
        LOCAL.set(source);
    }

    public static void set(int year) {
        LOCAL.set("DB_" + year);
    }
}
