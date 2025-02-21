/* Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.



Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
*/

package String;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int len = 0;
        int maxLen = 0;
        for(int n: nums){
            set.add(n);
        }
        int i =0;
        while(i < nums.length){
            len++;
            if(!set.contains(nums[i] + 1 )){
                int c = nums[i] - 1;
                while(set.contains(c)){
                    len++;
                    c -= 1;
                }
                maxLen = Math.max(maxLen, len);
            }
            len = 0;
            i++;
        }
        return maxLen;
    }
}
