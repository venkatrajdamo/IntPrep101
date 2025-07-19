package Subarray;

public class CountNumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }
    public int atMost(int[] nums, int k){
        int l = 0;
        int r = 0;
        int count = 0;
        while (r < nums.length){
            if((nums[r] & 1) == 1){
                k--;
            }
            while(k < 0){
                if((nums[l] & 1) == 1){
                    k++;
                }
                l++;
            }
            count += r - l+1;
            r++;
        }
        return count;
    }
}
