package com.neeson.algo.queuestack;

import java.util.Stack;

/**
 * Create on 2020-04-23
 *
 * @author Administrator
 */
public class MinStack {

    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> helper = new Stack<>();


    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        data.push(x);
        if (helper.empty() || helper.peek() > x) {
            helper.push(x);
        } else {
            helper.push(helper.peek());
        }
    }

    public void pop() {
        if (data.empty()) {
            return;
        }
        helper.pop();
        data.pop();

    }

    public int top() {
       return data.peek();
    }

    public int getMin() {
        return helper.peek();
    }

}
