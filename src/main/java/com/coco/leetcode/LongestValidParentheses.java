package com.coco.leetcode;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid
 * (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has
 * length = 4.
 * 
 * @author mvpzhao
 *
 */
public class LongestValidParentheses {

    public static int longestValidParentheses(String str) {
        int n = str.length(), longest = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (c == '(') {
                st.push(i);
            } else {
                if (!st.empty()) {
                    if (str.charAt(st.peek()) == '(')
                        st.pop();
                    else
                        st.push(i);
                } else
                    st.push(i);
            }
        }
        if (st.empty()) {
            longest = n;
        } else {
            int a = n, b = 0;
            while (!st.empty()) {
                b = st.peek();
                st.pop();
                longest = Math.max(longest, a - b - 1);
                a = b;
            }
            longest = Math.max(longest, a);
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()())"));
    }

}
