package com.coco.leetcode;

/**
 * Given a sorted array consisting of only integers where every element appears twice except for one
 * element which appears once. Find this single element that appears only once.
 * 
 * @see https://leetcode.com/problems/single-element-in-a-sorted-array/#/description
 *
 */
public class SingleElementInASortedArray {

    public static int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;

        while (low < high) {
            mid = (low + high) / 2;
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                // 终止条件
                return nums[mid];
            } else if ((nums[mid] == nums[mid + 1] && mid % 2 == 0) || (nums[mid] == nums[mid - 1] && mid % 2 == 1)) {
                // 算法分支
                low = mid + 1;
            } else {
                // 算法分支
                high = mid - 1;
            }
        }
        // 终止条件
        return nums[low];
    }

    public static void main(String[] args) {
        // 验证边界
        System.out.println(singleNonDuplicate(new int[] { 1 }));
        System.out.println(singleNonDuplicate(new int[] { 1, 2, 2 }));
        System.out.println(singleNonDuplicate(new int[] { 1, 1, 2 }));
        System.out.println(singleNonDuplicate(new int[] { 1, 1, 2, 2, 3 }));
        System.out.println(singleNonDuplicate(new int[] { 1, 2, 2, 3, 4, 4 }));
    }

}
