package com.js.utils;

public class CurrentHolder {
    private static final ThreadLocal<Integer> CURRENT_LOCAL = new ThreadLocal<>();
    //设置当前用户
    public static void setCurrentId(Integer current) {
        CURRENT_LOCAL.set(current);
    }
    //获取当前用户
    public static Integer getCurrentId() {
        return CURRENT_LOCAL.get();

    }

    public static void remove() {
        CURRENT_LOCAL.remove();
    }
}
