package com.javafollower.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtils {
    public static boolean isContainChinese(String str) {
        Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    public static void main(String[] args) {
        String str = "ww";
        System.out.println(isContainChinese(str));
    }
}
