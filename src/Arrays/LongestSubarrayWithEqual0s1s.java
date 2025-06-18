/*Longest Subarray with Equal Number of 0s and 1s
Given a binary array nums, return the length of the longest contiguous subarray with an equal number of 0 and 1.
Example:
Input: nums = [0,1,0,1,1,1,0]
Output: 6
Explanation: The subarray [0,1,0,1,1,1] has 3 zeros and 3 ones.
*/

package Arrays;

import java.util.HashMap;

public class LongestSubarrayWithEqual0s1s {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<>();
        m.put(0, -1);
        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0) ? -1 : 1;
            if(m.containsKey(sum)){
                max = Math.max(max, i - m.get(sum));
            }
            else {
                m.put(sum, i);
            }
        }
        return max;
    }
}
