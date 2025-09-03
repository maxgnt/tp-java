package com.isitech.bibliotheque.utils;

public class StringUtils {


    public static boolean isNullOrEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }


    public static String capitalize(String s) {
        if (isNullOrEmpty(s)) return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }


    public static String tronquer(String s, int maxLength) {
        if (s == null) return null;
        if (s.length() <= maxLength) return s;
        return s.substring(0, maxLength - 3) + "...";
    }
}
