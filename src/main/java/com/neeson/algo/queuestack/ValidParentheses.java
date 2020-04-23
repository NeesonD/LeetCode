package com.neeson.algo.queuestack;

import java.util.Stack;

/**
 * Create on 2020-04-23
 *
 * @author Administrator
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (!stack.empty() && comp(stack.peek(),aChar)) {
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }
        return stack.empty();
    }

    boolean comp(char start, char end) {
        if (start == '(' && end == ')') {
            return true;
        }
        if (start == '[' && end == ']') {
            return true;
        }
        if (start == '{' && end == '}') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        new ValidParentheses().isValid("()");
    }

}
