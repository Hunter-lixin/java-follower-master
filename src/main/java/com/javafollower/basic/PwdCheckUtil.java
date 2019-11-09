package com.javafollower.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PwdCheckUtil {

    private final static Logger LOG = LoggerFactory.getLogger(PwdCheckUtil.class);

    private static String[][] arr =
            {
                    {"`~", "1!`~"},
                    {"1!", "1!@2qQ"},
                    {"@2", "@21!3#wWqQ"},
                    {"3#", "3#@2wWeE4$￥"},
                    {"4$￥", "3#5%rReE￥"},
                    {"5%", "5%6^4$￥rRtT"},
                    {"6^", "6^5%7&tTyY"},
                    {"7&", "7&6^8*yYuU"},
                    {"8*", "8*7&9(uUiI"},
                    {"9(", "9(8*0)iIoO"},
                    {"0)", "0)9(-_oOpP"},
                    {"-_", "=+-_0)pP[{"},
                    {"=+", "-_=+[{}]"},
                    {"qQ", "qQ1!@2wWaAsS"},
                    {"wW", "wWqQ@23#eEdDaAsS"},
                    {"eE", "eEwW3#4$￥rRfFdDsS"},
                    {"rR", "rReE4$￥5%tTgGfFdD"},
                    {"tT", "tTrR5%6^yYhHgGfF"},
                    {"yY", "yYtT^67&uUjJhHgG"},
                    {"uU", "uUyY7&8*iIkKjJhH"},
                    {"iI", "iIuU8*9(oOlLkKjJ"},
                    {"oO", "iI9(0)pPoOlLkK"},
                    {"pP", "pPoO0)-_[{;:lL'\""},
                    {"[{", "[{pP-_=+]}'\";:"},
                    {"]}", "]}[{=+\\|'\""},
                    {"\\|", "】}]\\|、"},
                    {"aA", "aAqQwWsSzZ"},
                    {"sS", "sSaAqQwWeEdDzZxXcC"},
                    {"dD", "dDsSwWeErRfFvVcCxX"},
                    {"fF", "fFdDeErRtTgGvVcC"},
                    {"gG", "gGfFErRtTyYhHbBvV"},
                    {"hH", "hHgGtTyYuUjJnNbB"},
                    {"jJ", "jJhHyYuUiIkKmMnN"},
                    {"kK", "kKjJuUiIoOlL,<mM"},
                    {"lL", "lLkKiIoOpP;:.>,<"},
                    {";:", ";:lLoOpP[{'\"/?.>"},
                    {"'\"", "'\"/?;:[{]}"},
                    {"zZ", "zZaAsSXX"},
                    {"xX", "xXzZsSdDcC"},
                    {"cC", "cCxXdDfFvV"},
                    {"vV", "cCdDfFgGbB"},
                    {"bB", "bBvVgGhHnN"},
                    {"nN", "nNbBhHjJmM"},
                    {"mM", "mMnNjJkK,<"},
                    {",<", ",<mMkKlL.>"},
                    {".>", ".>,<lL;:/?"},
                    {"/?", "/?.>;:'\""},
            };

    /**
     * 返回true满足密码校验，反之false
     */
    public static boolean vaildPwd(String pwd) {
        boolean result = checkPwd(pwd);
        //满足第一个，再调用第二个
        if (result) {
            result = check(pwd);
        }
        return result;
    }


    /**
     * 判断密码中是否包含键盘相邻的字符，满足条件返回true，反之返回false
     */
    private static boolean check(String pwd) {
        boolean flag = true;

        String firstStr = "";
        String secStr = "";
        String checkStr = "";
        for (int i = 1; i <= pwd.length(); i++) {
            firstStr = pwd.substring(i - 1, i);
            for (String[] strings : arr) {
                if (strings[0].contains(firstStr)) {
                    checkStr = strings[1];
                }
            }
            if (i + 1 < pwd.length()) {
                secStr = pwd.substring(i, i + 1);
                if (checkStr.contains(secStr)) {
                    flag = false;
                    break;
                }
            }
        }

        if (!flag) {
            LOG.warn("弱密码校验：" + firstStr + "和" + secStr + "为键盘上相邻的数");
        } else {
            LOG.info("弱密码校验验通过");
        }

        return flag;
    }

    /**
     * 密码规则：包含特殊字符、大写字母、小写字母、数字中的三种。
     * 满足返回true,反之为false
     */
    private static boolean checkPwd(String pwd) {
        if (pwd.length() < 8) {
            return false;
        }
        // 特殊字符
        int count = 0;
        String regEx1 = "[+-/=<>$_?@#!,*]";
        Pattern p1 = Pattern.compile(regEx1);
        Matcher m1 = p1.matcher(pwd);
        if (m1.find()) {
            LOG.info("校验密码规则--密码包含特殊字符，{}", regEx1);
            count++;
        }
        // 大写字母
        String regEx2 = "[A-Z]";
        Pattern p2 = Pattern.compile(regEx2);
        Matcher m2 = p2.matcher(pwd);
        if (m2.find()) {
            LOG.info("校验密码规则--密码包含大写字母");
            count++;
        }

        // 小写字母
        String regEx3 = "[a-z]";
        Pattern p3 = Pattern.compile(regEx3);
        Matcher m3 = p3.matcher(pwd);
        if (m3.find()) {
            LOG.info("校验密码规则--密码包含小写字母");
            count++;
        }

        // 数字
        String regEx4 = "[0-9]";
        Pattern p4 = Pattern.compile(regEx4);
        Matcher m4 = p4.matcher(pwd);
        if (m4.find()) {
            LOG.info("校验密码规则--密码包含数字");
            count++;
        }

        return count >= 3;
    }

    public static void main(String[] args) {
        String pwd = "zHmh180@";
        vaildPwd(pwd);
    }
}
