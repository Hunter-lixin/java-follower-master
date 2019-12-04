package com.javafollower.leetcode.isValid;

import java.util.HashMap;
import java.util.Stack;

public class Solution {

    private HashMap<Character, Character> mappings = new HashMap<>();

    public Solution() {
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (mappings.containsKey(c)) {
                char element = stack.isEmpty() ? '#' : stack.pop();
                if (element != mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

}
