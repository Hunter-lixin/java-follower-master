package com.javafollower.leetcode;

import org.junit.Assert;
import org.junit.Test;


public class NumberOffGameTest {

    @Test
    public void testNumberOffGame() {
        NumberOffGame solution = new NumberOffGame();
        Assert.assertEquals("", solution.numberOffGame(100, 1));
        Assert.assertEquals("58,91", solution.numberOffGame(100, 3));
        Assert.assertEquals("34,45,97", solution.numberOffGame(100, 4));
    }
}