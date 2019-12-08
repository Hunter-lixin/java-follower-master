package com.javafollower.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class ConvertTest {

    Convert result = new Convert();

    @Test
    public void testConvert_first() {
        Assert.assertEquals("LCIRETOESIIGEDHN", result.convert("LEETCODEISHIRING", 3));
    }

    @Test
    public void testConvert_sencod() {
        Assert.assertEquals("LDREOEIIECIHNTSG", result.convert("LEETCODEISHIRING", 4));
    }

    @Test
    public void testConvert_third() {
        Assert.assertEquals("LEETCODEISHIRING", result.convert("LEETCODEISHIRING", 1));
    }
}
