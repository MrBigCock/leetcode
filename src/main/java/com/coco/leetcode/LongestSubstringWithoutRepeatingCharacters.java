package com.coco.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a
 * substring, "pwke" is a subsequence and not a substring.
 * 
 * @see https://leetcode.com/problems/longest-substring-without-repeating-characters/#/description
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int index = 0, unUniqueIndex = 0; index < str.length(); index++) {
            char currentChar = str.charAt(index);
            if (map.containsKey(currentChar)) {
                unUniqueIndex = Math.max(map.get(currentChar) + 1, unUniqueIndex);
            }
            map.put(currentChar, index);
            max = Math.max(max, index - unUniqueIndex + 1);
        }
        return max;
    }

    /**
     * 错误的示范!
     * 
     * @param str
     * @return
     */
    public static int lengthOfLongestSubstring2(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int index = 0, unUniqueIndex = 0; index < str.length(); index++) {
            char currentChar = str.charAt(index);
            if (map.containsKey(currentChar)) {
                map.clear();
                unUniqueIndex = index;
            }
            map.put(currentChar, index);
            max = Math.max(max, index - unUniqueIndex + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        // 核心思想：选择一个没有重复字母的点开始计算。但是要注意"abba"这种存在双重复字母的情况
        System.out.println(lengthOfLongestSubstring("abba"));
        System.out.println(lengthOfLongestSubstring("dvdf"));

        System.out.println(lengthOfLongestSubstring2("abba"));
        System.out.println(lengthOfLongestSubstring2("dvdf"));
    }

}
