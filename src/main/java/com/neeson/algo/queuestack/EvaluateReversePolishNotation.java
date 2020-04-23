package com.neeson.algo.queuestack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Create on 2020-04-23
 *
 * @author Administrator
 */
public class EvaluateReversePolishNotation {

    Set<String> strings;

    {
        strings = new HashSet<>();
        strings.add("+");
        strings.add("-");
        strings.add("*");
        strings.add("/");
    }


    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (help(token)) {
                String pop1 = stack.pop();
                String pop2 = stack.pop();
                if (token.equals("+")) {
                    stack.push(String.valueOf(Integer.valueOf(pop2) + Integer.valueOf(pop1)));
                } else if (token.equals("-")) {
                    stack.push(String.valueOf(Integer.valueOf(pop2) - Integer.valueOf(pop1)));
                } else if (token.equals("*")) {
                    stack.push(String.valueOf(Integer.valueOf(pop2) * Integer.valueOf(pop1)));
                } else if (token.equals("/")) {
                    stack.push(String.valueOf(Integer.valueOf(pop2) / Integer.valueOf(pop1)));
                }
            } else {
                stack.push(token);
            }
        }
        return Integer.valueOf(stack.pop());
    }

    boolean help(String s) {
        if (strings.contains(s)) {
            return true;
        }
        return false;
    }

}
