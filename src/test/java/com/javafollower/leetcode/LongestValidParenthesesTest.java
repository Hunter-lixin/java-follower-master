package com.javafollower.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LongestValidParenthesesTest {

    @Test
    public void longestValidParentheses_1() {
        String s = "(()";
        LongestValidParentheses parentheses = new LongestValidParentheses();
        Assert.assertEquals(2, parentheses.longestValidParentheses(s));
    }

    @Test
    public void longestValidParentheses_2() {
        String s = ")()())";
        LongestValidParentheses parentheses = new LongestValidParentheses();
        assertThat(parentheses.longestValidParentheses(s),is(4));
    }
}