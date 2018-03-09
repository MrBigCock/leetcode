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

    /**
     * <p>
     * The workflow of the solution is as below.
     * 
     * <p>
     * 1.Scan the string from beginning to end.
     * 
     * <p>
     * 2.If current character is '(', push its index to the stack. If current character is ')' and
     * the character at the index of the top of stack is '(', we just find a matching pair so pop
     * from the stack. Otherwise, we push the index of ')' to the stack.
     * 
     * <p>
     * 3.After the scan is done, the stack will only contain the indices of characters which cannot
     * be matched. Then let's use the opposite side - substring between adjacent indices should be
     * valid parentheses.
     * 
     * <p>
     * 4.If the stack is empty, the whole input string is valid. Otherwise, we can scan the stack to
     * get longest valid substring as described in step 3.
     * 
     * @param str
     * @return
     */
    public static int longestValidParentheses(String str) {
        int n = str.length();
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
        
        int longest = 0;
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
