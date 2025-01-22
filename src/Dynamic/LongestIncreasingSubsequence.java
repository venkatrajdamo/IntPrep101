/*
Problem: Longest Increasing Subsequence
Given an integer array nums, return the length of the longest strictly increasing subsequence.

Example 1:
Input:
nums = [10, 9, 2, 5, 3, 7, 101, 18]
Output:4
Explanation:
The longest increasing subsequence is [2, 3, 7, 101], so the length is 4.

Example 2:
Input:
nums = [0, 1, 0, 3, 2, 3]
Output:4
 */
package Dynamic;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        int l = nums[0];
        for (int c : nums) {
            l = sub.get(sub.size() - 1);
            if (l < c) {
                sub.add(c);
            } else {
                int i = replaceMinNode(sub, c);
                sub.set(i, c);
            }
        }
        return sub.size();
    }

    public int replaceMinNode(List<Integer> sub, int c) {
        int s = 0;
        int e = sub.size() - 1;
        int i = (e + s) / 2;
        while (s < e) {
            if (sub.get(i) < c) {
                s = i + 1;
            } else if (sub.get(i) > c) {
                e = i;
            } else {
                return i;
            }
            i = (e + s) / 2;
        }
        return s;
    }
}

