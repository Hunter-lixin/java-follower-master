package com.javafollower.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsAnagramTest {

    @Test
    public void testIsAnagram_with_anagram_and_nagaram_true() {
        String s = "anagram", t = "nagaram";
        IsAnagram isAnagram = new IsAnagram();
        Assert.assertTrue(isAnagram.isAnagram(s, t));
    }

    @Test
    public void testShould_rat_and_car_be_false() {
        String s = "rat", t = "car";
        IsAnagram isAnagram = new IsAnagram();
        Assert.assertFalse(isAnagram.isAnagram(s, t));
    }

    @Test
    public void testShould_java_and_python_be_false() {
        String s = "java", t = "python";
        IsAnagram isAnagram = new IsAnagram();
        Assert.assertFalse(isAnagram.isAnagram(s, t));
    }
}