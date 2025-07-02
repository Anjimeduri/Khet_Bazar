package com.khet_bazar.utils;

import lombok.Data;

@Data
public class Context {
    private static final ThreadLocal<String> nameSpace = new ThreadLocal<>();
    private static final ThreadLocal<String> userID = new ThreadLocal<>();

    public static String getNameSpace() {
        return nameSpace.get();
    }

    public static void setNameSpace(String id) {
        nameSpace.set(id);
    }

    public static String getUserId() {
        return userID.get();
    }

    public static void setUserId(String id) {
        userID.set(id);
    }

    public static void clean() {
        nameSpace.remove();
        userID.remove();

    }
}
