package Arrays;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int s = 0;
        int e = 0;
        int sum = 0;
        int count = 0;
        for (e = 0; e < nums.length; e++) {
            sum += nums[e];
            while(sum > k){
                sum -= nums[s];
                s++;
            }
            if (sum == k)
                count++;
        }
        return count;
    }
}
