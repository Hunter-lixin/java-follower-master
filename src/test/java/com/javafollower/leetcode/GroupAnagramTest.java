package com.javafollower.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GroupAnagramTest {

    @Test
    public void testGroupAnagram(){
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = new ArrayList<>();
        List<String> withaet = new ArrayList<>();
        result.add(withaet);
        withaet.add("eat");
        withaet.add("tea");
        withaet.add("ate");

        List<String> withant = new ArrayList<>();
        result.add(withant);
        withant.add("tan");
        withant.add("nat");

        List<String> withbat = new ArrayList<>();
        result.add(withbat);
        withbat.add("bat");

        GroupAnagram groupAnagram = new GroupAnagram();
        Assert.assertEquals(groupAnagram.groupAnagrams(strs), result);

    }
}