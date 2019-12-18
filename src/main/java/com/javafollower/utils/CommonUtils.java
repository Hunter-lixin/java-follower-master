package com.javafollower.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.javafollower.utils.CommonUtils.ToggleCase.TO_LOWER_CASE;
import static com.javafollower.utils.CommonUtils.ToggleCase.TO_UPPER_CASE;


public class CommonUtils {

    public enum ToggleCase {
        TO_LOWER_CASE,
        TO_UPPER_CASE,
    }

    public static boolean isContainChinese(String str) {
        Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    public static String toggleCaseFirstLetter(String input, ToggleCase toggleCase) {
        if (ToggleCase.TO_LOWER_CASE.equals(toggleCase)) {
            return lowerCaseFirstLetter(input);
        } else if (ToggleCase.TO_UPPER_CASE.equals(toggleCase)) {
            return upperCaseFirstLetter(input);
        }
        return input;
    }

    /**
     * 字符串首字母大写
     */
    private static String upperCaseFirstLetter(String input) {
        char[] charArray = input.toCharArray();
        if (charArray[0] >= 'a' && charArray[0] <= 'z') {
            charArray[0] = (char) (charArray[0] - 32);
        }
        return new String(charArray);
    }

    /**
     * 字符串首字母小写
     */
    private static String lowerCaseFirstLetter(String input) {
        char[] charArray = input.toCharArray();
        if (charArray[0] >= 'A' && charArray[0] <= 'Z') {
            charArray[0] = (char) (charArray[0] + 32);
        }
        return new String(charArray);
    }

    public static String humpString(String input, String regex) {
        if (input == null) {
            return "";
        }
        if (regex == null || regex.isEmpty()) {
            regex = "_";
        }
        StringBuilder result = new StringBuilder();
        String[] inputSplitArray = input.split(regex);
        for (String value : inputSplitArray) {
            result.append(toggleCaseFirstLetter(value, TO_UPPER_CASE));
        }
        return toggleCaseFirstLetter(result.toString(), TO_LOWER_CASE);
    }

}
