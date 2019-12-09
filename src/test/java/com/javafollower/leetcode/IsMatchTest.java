package com.javafollower.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsMatchTest {

    private IsMatch solution = new IsMatch();

    @Test
    public void testIsMatch_1() {
        String text = "aa";
        String pattern = "a";
        Assert.assertFalse(solution.isMatch(text, pattern));
    }

    @Test
    public void testIsMatch_2() {
        String text = "aa";
        String pattern = "a*";
        Assert.assertTrue(solution.isMatch(text, pattern));
    }

    @Test
    public void testIsMatch_3() {
        String text = "aa";
        String pattern = ".*";
        Assert.assertTrue(solution.isMatch(text, pattern));
    }

    @Test
    public void testIsMatch_4() {
        String text = "aab";
        String pattern = "c*a*b";
        Assert.assertTrue(solution.isMatch(text, pattern));
    }

    @Test
    public void testIsMatch_5() {
        String text = "mississippi";
        String pattern = "mis*is*p*.";
        Assert.assertFalse(solution.isMatch(text, pattern));
    }

    @Test
    public void testIsMatch_6() {
        String text = "";
        String pattern = "";
        Assert.assertTrue(solution.isMatch(text, pattern));
    }

    @Test
    public void testIsMatch_7() {
        String text = "a";
        String pattern = "";
        Assert.assertFalse(solution.isMatch(text, pattern));
    }
}