/*
Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

Example 1:
Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.

Example 2:
Input: nums = [1,2,3], k = 0
Output: 0
*/

package Subarray;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int p = 1;
        int count = 0;
        while(r < nums.length){
            p *= nums[r];

            while(p >= k && l <= r){
                p /= nums[l];
                l++;
            }

            count += r - l +1;
            r++;
        }
        return count;
    }
}
